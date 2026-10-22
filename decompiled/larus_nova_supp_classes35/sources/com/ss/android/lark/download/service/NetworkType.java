package com.ss.android.lark.download.service;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum NetworkType extends Enum<NetworkType> {
    public static final NetworkType CELLULAR_DATA_NETWORK = null;
    public static final NetworkType NO_INTERNET_CONNECTION = null;
    public static final NetworkType WIFI = null;
    public static final /* synthetic */ NetworkType[] a = null;
    private int value;

    static {
        NetworkType r0 = new NetworkType("NO_INTERNET_CONNECTION", 0, 1);
        NO_INTERNET_CONNECTION = r0;
        NetworkType r1 = new NetworkType("CELLULAR_DATA_NETWORK", 1, 2);
        CELLULAR_DATA_NETWORK = r1;
        NetworkType r4 = new NetworkType("WIFI", 2, 3);
        WIFI = r4;
        a = new NetworkType[]{r0, r1, r4};
    }

    public static NetworkType[] values() {
        return (NetworkType[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static NetworkType forNumber(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return WIFI;
    L13:
        return CELLULAR_DATA_NETWORK;
    L15:
        return NO_INTERNET_CONNECTION;
    }

    public static NetworkType valueOf(String r1) {
        return (NetworkType) a.a(NetworkType.class, r1);
    }

    public static NetworkType valueOf(int r0) {
        return forNumber(r0);
    }

    public NetworkType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
