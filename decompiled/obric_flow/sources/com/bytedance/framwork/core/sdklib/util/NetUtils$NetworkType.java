package com.bytedance.framwork.core.sdklib.util;

/* JADX INFO: loaded from: classes2.dex */
public final enum NetUtils$NetworkType extends Enum<NetUtils$NetworkType> {
    public static final NetUtils$NetworkType MOBILE = null;
    public static final NetUtils$NetworkType MOBILE_2G = null;
    public static final NetUtils$NetworkType MOBILE_3G = null;
    public static final NetUtils$NetworkType MOBILE_4G = null;
    public static final NetUtils$NetworkType NONE = null;
    public static final NetUtils$NetworkType UNKNOWN = null;
    public static final NetUtils$NetworkType WIFI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetUtils$NetworkType[] f4698a = null;
    final int nativeInt;

    static {
        NetUtils$NetworkType r5 = new NetUtils$NetworkType("UNKNOWN", 0, -1);
        UNKNOWN = r5;
        NetUtils$NetworkType r10 = new NetUtils$NetworkType("NONE", 1, 0);
        NONE = r10;
        NetUtils$NetworkType r11 = new NetUtils$NetworkType("MOBILE", 2, 1);
        MOBILE = r11;
        NetUtils$NetworkType r12 = new NetUtils$NetworkType("MOBILE_2G", 3, 2);
        MOBILE_2G = r12;
        NetUtils$NetworkType r13 = new NetUtils$NetworkType("MOBILE_3G", 4, 3);
        MOBILE_3G = r13;
        NetUtils$NetworkType r14 = new NetUtils$NetworkType("WIFI", 5, 4);
        WIFI = r14;
        NetUtils$NetworkType r15 = new NetUtils$NetworkType("MOBILE_4G", 6, 5);
        MOBILE_4G = r15;
        f4698a = new NetUtils$NetworkType[]{r5, r10, r11, r12, r13, r14, r15};
    }

    public NetUtils$NetworkType(String r5, int r10, int r11) {
        super(r5, r10);
        this.nativeInt = r11;
    }

    public static NetUtils$NetworkType valueOf(String r5) {
        return (NetUtils$NetworkType) Enum.valueOf(NetUtils$NetworkType.class, r5);
    }

    public static NetUtils$NetworkType[] values() {
        return (NetUtils$NetworkType[]) f4698a.clone();
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
