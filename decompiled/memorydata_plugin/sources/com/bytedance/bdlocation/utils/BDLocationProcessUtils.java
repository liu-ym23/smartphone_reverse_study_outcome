package com.bytedance.bdlocation.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.bdlocation.log.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationProcessUtils {
    private static volatile String sCurrentProcessName;

    static {
    }

    public BDLocationProcessUtils() {
    }

    public static String getCurrentProcessName(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Application.getProcessName();
    L7:
        if (sCurrentProcessName == null) goto L11;
        return sCurrentProcessName;
    L11:
        monitor-enter(BDLocationProcessUtils.class);
    L34:
        th = move-exception;
        throw th;
    L13:
        if (sCurrentProcessName == null) goto L38;
        String r7 = sCurrentProcessName;     // Catch: Throwable -> L34
        monitor-exit(BDLocationProcessUtils.class);     // Catch: Throwable -> L34
        return r7;
    L38:
        Iterator<ActivityManager.RunningAppProcessInfo> r8 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r6.getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin")).getRunningAppProcesses().iterator();     // Catch: Throwable -> L30
    L20:
        if (r8.hasNext() == false) goto L28;
        ActivityManager.RunningAppProcessInfo r2 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r8.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        if (r2.uid != Process.myUid()) goto L20;
        if (r2.pid != Process.myPid()) goto L20;
        sCurrentProcessName = r2.processName;     // Catch: Throwable -> L30
        String r9 = sCurrentProcessName;     // Catch: Throwable -> L30
        monitor-exit(BDLocationProcessUtils.class);     // Catch: Throwable -> L34
        return r9;
    L28:
        monitor-exit(BDLocationProcessUtils.class);     // Catch: Throwable -> L34
        return null;
    L30:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L34
        Logger.e("getCurrentProcessName failed, " + th, th);     // Catch: Throwable -> L34
        return null;
    }
}
