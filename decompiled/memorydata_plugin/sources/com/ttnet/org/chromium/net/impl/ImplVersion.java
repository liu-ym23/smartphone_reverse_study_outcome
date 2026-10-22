package com.ttnet.org.chromium.net.impl;

/* JADX INFO: loaded from: classes6.dex */
public class ImplVersion {
    private static final int API_LEVEL = 16;
    private static final String CRONET_VERSION = "107.0.5273.2";
    private static final String LAST_CHANGE = "c4385650a46a52d58f9aac68b87d40686cf2388b";

    private ImplVersion() {
    }

    public static int getApiLevel() {
        return 16;
    }

    public static String getCronetVersion() {
        return CRONET_VERSION;
    }

    public static String getCronetVersionWithLastChange() {
        return "107.0.5273.2@c4385650";
    }

    public static String getLastChange() {
        return LAST_CHANGE;
    }
}
