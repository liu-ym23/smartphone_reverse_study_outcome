package com.bytedance.sysoptimizer.fake.name;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.sysoptimizer.SysOptimizer;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class SmFakeNameHandler {
    private static String TAG = "SYSOPTIMIZER";
    private static volatile boolean inited = false;

    static {
    }

    public SmFakeNameHandler() {
    }

    private static boolean inAndroid5x() {
        if (Build.VERSION.SDK_INT != 22) goto L5;
    L8:
        return true;
    L5:
        if (Build.VERSION.SDK_INT == 21) goto L8;
        return false;
    }

    private static native void replace(int r0);

    private static boolean shouldFix() {
        if (inAndroid5x() == true) goto L5;
    L7:
        return false;
    L5:
        if (Build.MODEL.startsWith("SM-") == false) goto L7;
        return true;
    }

    public static synchronized void start(Context r3) {
        monitor-enter(SmFakeNameHandler.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (shouldFix() == true) goto L9;
        monitor-exit(SmFakeNameHandler.class);
        return;
    L9:
        if (inited == false) goto L13;
        monitor-exit(SmFakeNameHandler.class);
        return;
    L13:
        inited = true;     // Catch: Throwable -> L25
        if (SysOptimizer.loadOptimizerLibrary(r4) == true) goto L29;
    L23:
        monitor-exit(SmFakeNameHandler.class);
        return;
    L29:
        replace(Build.VERSION.SDK_INT);     // Catch: NoSuchMethodError -> L17 UnsatisfiedLinkError -> L20 Throwable -> L25
    L17:
        e = e;
        String r1 = TAG;     // Catch: Throwable -> L25
        String r2 = "NoSuchMethodError";
    L19:
        Log.e(r1, r2, e);     // Catch: Throwable -> L25
    L20:
        e = e;
        r1 = TAG;     // Catch: Throwable -> L25
        r2 = "UnsatisfiedLinkError";
    L25:
        th = move-exception;
        throw th;
    }
}
