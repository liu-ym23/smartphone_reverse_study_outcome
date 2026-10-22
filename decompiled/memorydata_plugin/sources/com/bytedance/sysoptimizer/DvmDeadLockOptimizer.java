package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class DvmDeadLockOptimizer {
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mOptimized = false;

    static {
    }

    private DvmDeadLockOptimizer() {
    }

    private static boolean loadOptimizerOnNeed(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT == 19) goto L7;
        return false;
    L7:
        return SysOptimizer.loadOptimizerLibrary(r3);
    }

    private static native boolean optimize();

    public static synchronized boolean optimize(Context r3) {
        monitor-enter(DvmDeadLockOptimizer.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (mOptimized == false) goto L10;
        boolean r5 = true;
    L7:
        monitor-exit(DvmDeadLockOptimizer.class);
        return r5;
    L10:
        if (loadOptimizerOnNeed(r4) == true) goto L20;
    L16:
        r5 = false;
        goto L7
    L20:
        boolean r6 = optimize();     // Catch: UnsatisfiedLinkError -> L14 Throwable -> L17
        mOptimized = r6;     // Catch: UnsatisfiedLinkError -> L14 Throwable -> L17
        monitor-exit(DvmDeadLockOptimizer.class);
        return r6;
    L14:
        e = move-exception;
        Log.e(TAG, "failed to optimize, UnsatisfiedLinkError", e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }
}
