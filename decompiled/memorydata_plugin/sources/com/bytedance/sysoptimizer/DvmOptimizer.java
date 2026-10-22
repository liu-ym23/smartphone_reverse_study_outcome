package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class DvmOptimizer {
    private DvmOptimizer() {
    }

    public static void hookDvmLinearAllocFunc(Context r2) {
        if (loadOptimizerOnNeed((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")) == false) goto L6;
        startHookDvmFunc();
        return;
    }

    private static boolean loadOptimizerOnNeed(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT <= 19) goto L5;
        return false;
    L5:
        return SysOptimizer.loadOptimizerLibrary(r3);
    }

    public static void optDvmLinearAllocBuffer(Context r2) {
        if (loadOptimizerOnNeed((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")) == false) goto L6;
        optLinearAllocBuffer();
        return;
    }

    private static native void optLinearAllocBuffer();

    private static native void startHookDvmFunc();
}
