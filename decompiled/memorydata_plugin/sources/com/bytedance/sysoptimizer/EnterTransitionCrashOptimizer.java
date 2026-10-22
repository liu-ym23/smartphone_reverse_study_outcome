package com.bytedance.sysoptimizer;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class EnterTransitionCrashOptimizer {
    private static Context sContext;

    public EnterTransitionCrashOptimizer() {
    }

    public static void fix(Context r2) {
        sContext = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
    }

    public static Context getContext() {
        return sContext;
    }
}
