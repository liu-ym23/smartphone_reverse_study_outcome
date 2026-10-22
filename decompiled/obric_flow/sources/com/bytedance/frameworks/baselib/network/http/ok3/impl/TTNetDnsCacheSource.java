package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: loaded from: classes2.dex */
final enum TTNetDnsCacheSource extends Enum<TTNetDnsCacheSource> {
    public static final TTNetDnsCacheSource SOURCE_ASYNC_BATCH_HTTPDNS = null;
    public static final TTNetDnsCacheSource SOURCE_HTTPDNS = null;
    public static final TTNetDnsCacheSource SOURCE_PRELOAD_BATCH_HTTPDNS = null;
    public static final TTNetDnsCacheSource SOURCE_PROC = null;
    public static final TTNetDnsCacheSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TTNetDnsCacheSource[] f4680a = null;
    final int mValue;

    static {
        TTNetDnsCacheSource r5 = new TTNetDnsCacheSource("UNKNOWN", 0, -1);
        UNKNOWN = r5;
        TTNetDnsCacheSource r10 = new TTNetDnsCacheSource("SOURCE_HTTPDNS", 1, 3);
        SOURCE_HTTPDNS = r10;
        TTNetDnsCacheSource r11 = new TTNetDnsCacheSource("SOURCE_PROC", 2, 6);
        SOURCE_PROC = r11;
        TTNetDnsCacheSource r12 = new TTNetDnsCacheSource("SOURCE_PRELOAD_BATCH_HTTPDNS", 3, 7);
        SOURCE_PRELOAD_BATCH_HTTPDNS = r12;
        TTNetDnsCacheSource r13 = new TTNetDnsCacheSource("SOURCE_ASYNC_BATCH_HTTPDNS", 4, 8);
        SOURCE_ASYNC_BATCH_HTTPDNS = r13;
        f4680a = new TTNetDnsCacheSource[]{r5, r10, r11, r12, r13};
    }

    public TTNetDnsCacheSource(String r5, int r10, int r11) {
        super(r5, r10);
        this.mValue = r11;
    }

    public static TTNetDnsCacheSource valueOf(String r5) {
        return (TTNetDnsCacheSource) Enum.valueOf(TTNetDnsCacheSource.class, r5);
    }

    public static TTNetDnsCacheSource[] values() {
        return (TTNetDnsCacheSource[]) f4680a.clone();
    }
}
