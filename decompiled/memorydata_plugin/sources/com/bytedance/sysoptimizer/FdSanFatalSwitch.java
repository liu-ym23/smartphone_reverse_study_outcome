package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class FdSanFatalSwitch {
    private static final String TAG = "FdSanFatalSwitch";
    private static volatile boolean mFdSanFatalSwitch = false;

    static {
    }

    public FdSanFatalSwitch() {
    }

    private static boolean loadOptimizerOnNeed(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return false;
    L5:
        return SysOptimizer.loadOptimizerLibrary(r3);
    }

    private static native void openAndroidQFdsan();

    public static synchronized void openAndroidQFdsan(Context r3) {
        monitor-enter(FdSanFatalSwitch.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (mFdSanFatalSwitch == false) goto L7;
    L9:
        monitor-exit(FdSanFatalSwitch.class);
        return;
    L7:
        if (loadOptimizerOnNeed(r4) == false) goto L9;
        openAndroidQFdsan();     // Catch: Throwable -> L11
        mFdSanFatalSwitch = true;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
