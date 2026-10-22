package com.lynx.tasm.featurecount;

import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxEnvKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxFeatureCounter {
    public static volatile boolean a;
    public static volatile boolean b;

    public LynxFeatureCounter() {
    }

    public static native void nativeFeatureCount(int r0, int r1);

    static {
        b = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_FEATURE_COUNTER, false);
    }

    public static void a(int r1, int r2) {
        if (b == true) goto L6;
        return;
    L6:
        if (a == true) goto L9;
        a = LynxEnv.inst().isNativeLibraryLoaded();
    L9:
        if (a == false) goto L12;
        nativeFeatureCount(r1, r2);
        return;
    }
}
