package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: loaded from: classes.dex */
final enum TTNetDnsCacheSource extends Enum<TTNetDnsCacheSource> {
    private static final /* synthetic */ TTNetDnsCacheSource[] $VALUES = null;
    public static final TTNetDnsCacheSource SOURCE_ASYNC_BATCH_HTTPDNS = null;
    public static final TTNetDnsCacheSource SOURCE_HTTPDNS = null;
    public static final TTNetDnsCacheSource SOURCE_PRELOAD_BATCH_HTTPDNS = null;
    public static final TTNetDnsCacheSource SOURCE_PROC = null;
    public static final TTNetDnsCacheSource UNKNOWN = null;
    final int mValue;

    static {
        TTNetDnsCacheSource r10 = new TTNetDnsCacheSource("UNKNOWN", 0, -1);
        UNKNOWN = r10;
        TTNetDnsCacheSource r11 = new TTNetDnsCacheSource("SOURCE_HTTPDNS", 1, 3);
        SOURCE_HTTPDNS = r11;
        TTNetDnsCacheSource r12 = new TTNetDnsCacheSource("SOURCE_PROC", 2, 6);
        SOURCE_PROC = r12;
        TTNetDnsCacheSource r13 = new TTNetDnsCacheSource("SOURCE_PRELOAD_BATCH_HTTPDNS", 3, 7);
        SOURCE_PRELOAD_BATCH_HTTPDNS = r13;
        TTNetDnsCacheSource r14 = new TTNetDnsCacheSource("SOURCE_ASYNC_BATCH_HTTPDNS", 4, 8);
        SOURCE_ASYNC_BATCH_HTTPDNS = r14;
        $VALUES = new TTNetDnsCacheSource[]{r10, r11, r12, r13, r14};
    }

    private TTNetDnsCacheSource(String r10, int r11, int r12) {
        super(r10, r11);
        this.mValue = r12;
    }

    public static TTNetDnsCacheSource valueOf(String r10) {
        return (TTNetDnsCacheSource) Enum.valueOf(TTNetDnsCacheSource.class, r10);
    }

    public static TTNetDnsCacheSource[] values() {
        return (TTNetDnsCacheSource[]) $VALUES.clone();
    }
}
