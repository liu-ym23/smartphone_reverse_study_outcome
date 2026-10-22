package com.lynx.tasm.utils;

import android.content.Context;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public class EnvUtils {
    @CalledByNative
    public static String getCacheDir() {
        Context r5 = LynxEnv.inst().getAppContext();
        if (r5 != null) goto L5;
        return "";
    L5:
        return r5.getCacheDir().getAbsolutePath();
    }
}
