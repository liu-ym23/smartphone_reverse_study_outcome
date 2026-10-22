package com.bytedance.common.utility;

/* JADX INFO: loaded from: classes2.dex */
public final enum NetworkUtils$NetworkType extends Enum<NetworkUtils$NetworkType> {
    public static final NetworkUtils$NetworkType MOBILE = null;
    public static final NetworkUtils$NetworkType MOBILE_2G = null;
    public static final NetworkUtils$NetworkType MOBILE_3G = null;
    public static final NetworkUtils$NetworkType MOBILE_3G_H = null;
    public static final NetworkUtils$NetworkType MOBILE_3G_HP = null;
    public static final NetworkUtils$NetworkType MOBILE_4G = null;
    public static final NetworkUtils$NetworkType MOBILE_5G = null;
    public static final NetworkUtils$NetworkType NONE = null;
    public static final NetworkUtils$NetworkType UNKNOWN = null;
    public static final NetworkUtils$NetworkType WIFI = null;
    public static final NetworkUtils$NetworkType WIFI_24GHZ = null;
    public static final NetworkUtils$NetworkType WIFI_5GHZ = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkUtils$NetworkType[] f3951a = null;
    final int nativeInt;

    static {
        NetworkUtils$NetworkType r5 = new NetworkUtils$NetworkType("UNKNOWN", 0, -1);
        UNKNOWN = r5;
        NetworkUtils$NetworkType r10 = new NetworkUtils$NetworkType("NONE", 1, 0);
        NONE = r10;
        NetworkUtils$NetworkType r11 = new NetworkUtils$NetworkType("MOBILE", 2, 1);
        MOBILE = r11;
        NetworkUtils$NetworkType r12 = new NetworkUtils$NetworkType("MOBILE_2G", 3, 2);
        MOBILE_2G = r12;
        NetworkUtils$NetworkType r13 = new NetworkUtils$NetworkType("MOBILE_3G", 4, 3);
        MOBILE_3G = r13;
        NetworkUtils$NetworkType r14 = new NetworkUtils$NetworkType("WIFI", 5, 4);
        WIFI = r14;
        NetworkUtils$NetworkType r15 = new NetworkUtils$NetworkType("MOBILE_4G", 6, 5);
        MOBILE_4G = r15;
        NetworkUtils$NetworkType r16 = new NetworkUtils$NetworkType("MOBILE_5G", 7, 6);
        MOBILE_5G = r16;
        NetworkUtils$NetworkType r17 = new NetworkUtils$NetworkType("WIFI_24GHZ", 8, 7);
        WIFI_24GHZ = r17;
        NetworkUtils$NetworkType r18 = new NetworkUtils$NetworkType("WIFI_5GHZ", 9, 8);
        WIFI_5GHZ = r18;
        NetworkUtils$NetworkType r19 = new NetworkUtils$NetworkType("MOBILE_3G_H", 10, 9);
        MOBILE_3G_H = r19;
        NetworkUtils$NetworkType r110 = new NetworkUtils$NetworkType("MOBILE_3G_HP", 11, 10);
        MOBILE_3G_HP = r110;
        f3951a = new NetworkUtils$NetworkType[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110};
    }

    public NetworkUtils$NetworkType(String r5, int r10, int r11) {
        super(r5, r10);
        this.nativeInt = r11;
    }

    public static NetworkUtils$NetworkType valueOf(String r5) {
        return (NetworkUtils$NetworkType) Enum.valueOf(NetworkUtils$NetworkType.class, r5);
    }

    public static NetworkUtils$NetworkType[] values() {
        return (NetworkUtils$NetworkType[]) f3951a.clone();
    }

    public int getValue() {
        return this.nativeInt;
    }

    public boolean is2G() {
        if (this != MOBILE) goto L5;
    L8:
        return true;
    L5:
        if (this == MOBILE_2G) goto L8;
        return false;
    }

    public boolean is3GOrHigher() {
        if (this != MOBILE_3G) goto L5;
    L14:
        return true;
    L5:
        if (this == MOBILE_3G_H) goto L14;
        if (this == MOBILE_3G_HP) goto L14;
        if (this == MOBILE_4G) goto L14;
        if (this == MOBILE_5G) goto L14;
        return false;
    }

    public boolean is4GOrHigher() {
        if (this != MOBILE_4G) goto L5;
    L8:
        return true;
    L5:
        if (this == MOBILE_5G) goto L8;
        return false;
    }

    public boolean isAvailable() {
        if (this != UNKNOWN) goto L5;
    L7:
        return false;
    L5:
        if (this == NONE) goto L7;
        return true;
    }

    public boolean isWifi() {
        if (this != WIFI) goto L5;
        return true;
    L5:
        return false;
    }
}
