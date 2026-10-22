package com.monitor.cloudmessage.utils;

/* JADX INFO: loaded from: classes2.dex */
final enum NetworkUtils$NetworkType extends Enum<NetworkUtils$NetworkType> {
    public static final NetworkUtils$NetworkType MOBILE = null;
    public static final NetworkUtils$NetworkType MOBILE_2G = null;
    public static final NetworkUtils$NetworkType MOBILE_3G = null;
    public static final NetworkUtils$NetworkType MOBILE_4G = null;
    public static final NetworkUtils$NetworkType NONE = null;
    public static final NetworkUtils$NetworkType WIFI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkUtils$NetworkType[] f11219a = null;
    final int nativeInt;

    static {
        NetworkUtils$NetworkType r5 = new NetworkUtils$NetworkType("NONE", 0, 0);
        NONE = r5;
        NetworkUtils$NetworkType r10 = new NetworkUtils$NetworkType("MOBILE", 1, 1);
        MOBILE = r10;
        NetworkUtils$NetworkType r11 = new NetworkUtils$NetworkType("MOBILE_2G", 2, 2);
        MOBILE_2G = r11;
        NetworkUtils$NetworkType r12 = new NetworkUtils$NetworkType("MOBILE_3G", 3, 3);
        MOBILE_3G = r12;
        NetworkUtils$NetworkType r13 = new NetworkUtils$NetworkType("WIFI", 4, 4);
        WIFI = r13;
        NetworkUtils$NetworkType r14 = new NetworkUtils$NetworkType("MOBILE_4G", 5, 5);
        MOBILE_4G = r14;
        f11219a = new NetworkUtils$NetworkType[]{r5, r10, r11, r12, r13, r14};
    }

    public NetworkUtils$NetworkType(String r5, int r10, int r11) {
        super(r5, r10);
        this.nativeInt = r11;
    }

    public static NetworkUtils$NetworkType valueOf(String r5) {
        return (NetworkUtils$NetworkType) Enum.valueOf(NetworkUtils$NetworkType.class, r5);
    }

    public static NetworkUtils$NetworkType[] values() {
        return (NetworkUtils$NetworkType[]) f11219a.clone();
    }

    public int getValue() {
        return this.nativeInt;
    }
}
