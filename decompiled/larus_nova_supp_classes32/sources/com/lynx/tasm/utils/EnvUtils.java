package com.lynx.tasm.utils;

import android.content.Context;
import com.lynx.tasm.LynxEnv;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class EnvUtils {
    public EnvUtils() {
    }

    public static String getCacheDir() {
        Context r0 = LynxEnv.inst().getAppContext();
        if (r0 != null) goto L5;
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        return r0.getCacheDir().getAbsolutePath();
    }
}
