package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net")
public final class GURLUtils {
    public GURLUtils() {
    }

    public static String getOrigin(String r8) {
        return nativeGetOrigin(r8);
    }

    public static String getScheme(String r8) {
        return nativeGetScheme(r8);
    }

    private static native String nativeGetOrigin(String r8);

    private static native String nativeGetScheme(String r8);
}
