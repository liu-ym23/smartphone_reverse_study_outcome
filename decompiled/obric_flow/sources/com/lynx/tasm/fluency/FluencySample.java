package com.lynx.tasm.fluency;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class FluencySample {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f10845a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f10846b;

    static {
        f10845a = new AtomicBoolean(true);
        f10846b = false;
    }

    public static void a() {
        f10845a.set(true);
        nativeNeedCheckFluencyEnable();
    }

    private static native void nativeNeedCheckFluencyEnable();

    private static native void nativeSetFluencySample(boolean r5);
}
