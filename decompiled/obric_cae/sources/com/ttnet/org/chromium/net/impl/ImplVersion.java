package com.ttnet.org.chromium.net.impl;

/* JADX INFO: loaded from: classes2.dex */
public class ImplVersion {
    private static final int API_LEVEL = 12;
    private static final String CRONET_VERSION = "77.0.3844.0";
    private static final String LAST_CHANGE = "75ce914eec9114172da89f1390e9ab437ede0a6a-refs/heads/master@{#674799}";

    private ImplVersion() {
    }

    public static int getApiLevel() {
        return 12;
    }

    public static String getCronetVersion() {
        return CRONET_VERSION;
    }

    public static String getCronetVersionWithLastChange() {
        return "77.0.3844.0@75ce914e";
    }

    public static String getLastChange() {
        return LAST_CHANGE;
    }
}
