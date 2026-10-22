package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("net")
public final class HttpUtil {

    interface Natives {
        boolean isAllowedHeader(String r1, String r2);
    }

    public HttpUtil() {
    }

    public static boolean isAllowedHeader(String r1, String r2) {
        return HttpUtilJni.get().isAllowedHeader(r1, r2);
    }
}
