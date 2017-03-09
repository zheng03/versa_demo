package com.hill.versa.utils;

import java.io.File;

/**
 * Created by hill on 17/3/9.
 */

public class VersaUtils {

    private final static int kSystemRootStateUnknow=-1;
    private final static int kSystemRootStateDisable=0;
    private final static int kSystemRootStateEnable=1;
    private static int systemRootState=kSystemRootStateUnknow;

    public static boolean isRootSystem()
    {
        if(systemRootState==kSystemRootStateEnable)
        {
            return true;
        }
        else if(systemRootState==kSystemRootStateDisable)
        {

            return false;
        }
        File f=null;
        final String kSuSearchPaths[]={"/system/bin/","/system/xbin/","/system/sbin/","/sbin/","/vendor/bin/"};
        try{
            for(int i=0;i<kSuSearchPaths.length;i++)
            {
                f=new File(kSuSearchPaths[i]+"su");
                if(f!=null&&f.exists())
                {
                    systemRootState=kSystemRootStateEnable;
                    return true;
                }
            }
        }catch(Exception e)
        {
        }
        systemRootState=kSystemRootStateDisable;
        return false;
    }
}