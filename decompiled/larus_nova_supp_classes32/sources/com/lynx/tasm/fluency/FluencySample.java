package com.lynx.tasm.fluency;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FluencySample {
    public static final AtomicBoolean a = null;
    public static boolean b;

    public FluencySample() {
    }

    private static native void nativeNeedCheckFluencyEnable();

    private static native void nativeSetFluencySample(boolean r0);

    static {
        a = new AtomicBoolean(true);
        b = false;
    }

    public static void a() {
        a.set(true);
        nativeNeedCheckFluencyEnable();
    }
}
