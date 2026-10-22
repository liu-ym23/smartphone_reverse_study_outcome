package com.bytedance.security.trust;

import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes2.dex */
public class TrustManager {
    private TrustManager() {
    }

    public static TrustManager getInstance() {
        throw new RuntimeException("Stub!!");
    }

    public void checkClientTrusted(X509Certificate[] r1, String r2) {
        throw new RuntimeException("Stub!!");
    }

    public void checkServerTrusted(X509Certificate[] r1, String r2) {
        throw new RuntimeException("Stub!!");
    }
}
