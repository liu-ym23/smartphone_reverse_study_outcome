package com.ttnet.org.chromium.net.impl;

/* JADX INFO: loaded from: classes2.dex */
public class ImplVersion {
    private static final int API_LEVEL = 16;
    private static final String CRONET_VERSION = "107.0.5273.2";
    private static final String LAST_CHANGE = "c3e3705b8d778d9120610019d6f88f888fcae7f0";

    private ImplVersion() {
    }

    public static int getApiLevel() {
        return 16;
    }

    public static String getCronetVersion() {
        return CRONET_VERSION;
    }

    public static String getCronetVersionWithLastChange() {
        return "107.0.5273.2@c3e3705b";
    }

    public static String getLastChange() {
        return LAST_CHANGE;
    }
}
