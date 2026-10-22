package com.bytedance.framwork.core.monitor;

/* JADX INFO: loaded from: classes2.dex */
public final enum MonitorNetUtil$CompressType extends Enum<MonitorNetUtil$CompressType> {
    public static final MonitorNetUtil$CompressType DEFLATER = null;
    public static final MonitorNetUtil$CompressType GZIP = null;
    public static final MonitorNetUtil$CompressType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MonitorNetUtil$CompressType[] f4695a = null;
    final int nativeInt;

    static {
        MonitorNetUtil$CompressType r5 = new MonitorNetUtil$CompressType("NONE", 0, 0);
        NONE = r5;
        MonitorNetUtil$CompressType r10 = new MonitorNetUtil$CompressType("GZIP", 1, 1);
        GZIP = r10;
        MonitorNetUtil$CompressType r11 = new MonitorNetUtil$CompressType("DEFLATER", 2, 2);
        DEFLATER = r11;
        f4695a = new MonitorNetUtil$CompressType[]{r5, r10, r11};
    }

    public MonitorNetUtil$CompressType(String r5, int r10, int r11) {
        super(r5, r10);
        this.nativeInt = r11;
    }

    public static MonitorNetUtil$CompressType valueOf(String r5) {
        return (MonitorNetUtil$CompressType) Enum.valueOf(MonitorNetUtil$CompressType.class, r5);
    }

    public static MonitorNetUtil$CompressType[] values() {
        return (MonitorNetUtil$CompressType[]) f4695a.clone();
    }
}
