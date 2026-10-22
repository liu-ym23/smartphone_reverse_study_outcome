package com.bytedance.framwork.core.monitor;

/* JADX INFO: loaded from: classes2.dex */
public final enum MonitorNetUtil$NetworkType extends Enum<MonitorNetUtil$NetworkType> {
    public static final MonitorNetUtil$NetworkType MOBILE = null;
    public static final MonitorNetUtil$NetworkType MOBILE_2G = null;
    public static final MonitorNetUtil$NetworkType MOBILE_3G = null;
    public static final MonitorNetUtil$NetworkType MOBILE_4G = null;
    public static final MonitorNetUtil$NetworkType NONE = null;
    public static final MonitorNetUtil$NetworkType WIFI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MonitorNetUtil$NetworkType[] f4696a = null;
    final int nativeInt;

    static {
        MonitorNetUtil$NetworkType r5 = new MonitorNetUtil$NetworkType("NONE", 0, 0);
        NONE = r5;
        MonitorNetUtil$NetworkType r10 = new MonitorNetUtil$NetworkType("MOBILE", 1, 1);
        MOBILE = r10;
        MonitorNetUtil$NetworkType r11 = new MonitorNetUtil$NetworkType("MOBILE_2G", 2, 2);
        MOBILE_2G = r11;
        MonitorNetUtil$NetworkType r12 = new MonitorNetUtil$NetworkType("MOBILE_3G", 3, 3);
        MOBILE_3G = r12;
        MonitorNetUtil$NetworkType r13 = new MonitorNetUtil$NetworkType("WIFI", 4, 4);
        WIFI = r13;
        MonitorNetUtil$NetworkType r14 = new MonitorNetUtil$NetworkType("MOBILE_4G", 5, 5);
        MOBILE_4G = r14;
        f4696a = new MonitorNetUtil$NetworkType[]{r5, r10, r11, r12, r13, r14};
    }

    public MonitorNetUtil$NetworkType(String r5, int r10, int r11) {
        super(r5, r10);
        this.nativeInt = r11;
    }

    public static MonitorNetUtil$NetworkType valueOf(String r5) {
        return (MonitorNetUtil$NetworkType) Enum.valueOf(MonitorNetUtil$NetworkType.class, r5);
    }

    public static MonitorNetUtil$NetworkType[] values() {
        return (MonitorNetUtil$NetworkType[]) f4696a.clone();
    }

    public int getValue() {
        return this.nativeInt;
    }
}
