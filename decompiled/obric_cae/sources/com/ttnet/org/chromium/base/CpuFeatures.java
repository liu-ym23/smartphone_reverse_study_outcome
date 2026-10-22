package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public abstract class CpuFeatures {
    public CpuFeatures() {
    }

    public static int getCount() {
        return nativeGetCoreCount();
    }

    public static long getMask() {
        return nativeGetCpuFeatures();
    }

    private static native int nativeGetCoreCount();

    private static native long nativeGetCpuFeatures();
}
