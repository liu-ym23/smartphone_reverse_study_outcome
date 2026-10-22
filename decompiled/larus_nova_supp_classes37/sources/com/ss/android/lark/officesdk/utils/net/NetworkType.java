package com.ss.android.lark.officesdk.utils.net;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum NetworkType extends Enum<NetworkType> {
    public static final NetworkType NETWORK_2G = null;
    public static final NetworkType NETWORK_3G = null;
    public static final NetworkType NETWORK_4G = null;
    public static final NetworkType NETWORK_5G = null;
    public static final NetworkType NETWORK_MOBILE = null;
    public static final NetworkType NETWORK_NO = null;
    public static final NetworkType NETWORK_UNKNOWN = null;
    public static final NetworkType NETWORK_WIFI = null;
    public static final /* synthetic */ NetworkType[] a = null;

    static {
        NetworkType r0 = new NetworkType("NETWORK_NO", 0);
        NETWORK_NO = r0;
        NetworkType r1 = new NetworkType("NETWORK_WIFI", 1);
        NETWORK_WIFI = r1;
        NetworkType r3 = new NetworkType("NETWORK_2G", 2);
        NETWORK_2G = r3;
        NetworkType r5 = new NetworkType("NETWORK_3G", 3);
        NETWORK_3G = r5;
        NetworkType r7 = new NetworkType("NETWORK_4G", 4);
        NETWORK_4G = r7;
        NetworkType r9 = new NetworkType("NETWORK_5G", 5);
        NETWORK_5G = r9;
        NetworkType r11 = new NetworkType("NETWORK_MOBILE", 6);
        NETWORK_MOBILE = r11;
        NetworkType r13 = new NetworkType("NETWORK_UNKNOWN", 7);
        NETWORK_UNKNOWN = r13;
        a = new NetworkType[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    public static NetworkType[] values() {
        return (NetworkType[]) a.clone();
    }

    public static NetworkType valueOf(String r1) {
        return (NetworkType) a.a(NetworkType.class, r1);
    }

    public NetworkType(String r1, int r2) {
        super(r1, r2);
    }
}
