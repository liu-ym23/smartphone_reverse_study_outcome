package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net")
public final class HttpUtil {

    interface Natives {
        boolean isAllowedHeader(String r10, String r11);
    }

    public HttpUtil() {
    }

    public static boolean isAllowedHeader(String r10, String r11) {
        return HttpUtilJni.get().isAllowedHeader(r10, r11);
    }
}
