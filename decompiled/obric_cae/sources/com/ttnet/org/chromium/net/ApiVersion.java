package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes2.dex */
public class ApiVersion {
    private static final int API_LEVEL = 12;
    private static final String CRONET_VERSION = "77.0.3844.0";
    private static final String LAST_CHANGE = "75ce914eec9114172da89f1390e9ab437ede0a6a-refs/heads/master@{#674799}";
    private static final int MIN_COMPATIBLE_API_LEVEL = 3;

    private ApiVersion() {
    }

    public static int getApiLevel() {
        return 3;
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

    public static int getMaximumAvailableApiLevel() {
        return 12;
    }
}
