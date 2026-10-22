package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net")
public final class HttpUtil {
    public HttpUtil() {
    }

    public static boolean isAllowedHeader(String r8, String r10) {
        return nativeIsAllowedHeader(r8, r10);
    }

    private static native boolean nativeIsAllowedHeader(String r8, String r10);
}
