package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final enum TTNetDnsCacheSource extends Enum<TTNetDnsCacheSource> {
    private static final /* synthetic */ TTNetDnsCacheSource[] $VALUES = null;
    public static final TTNetDnsCacheSource SOURCE_ASYNC_BATCH_HTTPDNS = null;
    public static final TTNetDnsCacheSource SOURCE_HTTPDNS = null;
    public static final TTNetDnsCacheSource SOURCE_PRELOAD_BATCH_HTTPDNS = null;
    public static final TTNetDnsCacheSource SOURCE_PROC = null;
    public static final TTNetDnsCacheSource UNKNOWN = null;
    final int mValue;

    static {
        TTNetDnsCacheSource r0 = new TTNetDnsCacheSource("UNKNOWN", 0, -1);
        UNKNOWN = r0;
        TTNetDnsCacheSource r1 = new TTNetDnsCacheSource("SOURCE_HTTPDNS", 1, 3);
        SOURCE_HTTPDNS = r1;
        TTNetDnsCacheSource r3 = new TTNetDnsCacheSource("SOURCE_PROC", 2, 6);
        SOURCE_PROC = r3;
        TTNetDnsCacheSource r6 = new TTNetDnsCacheSource("SOURCE_PRELOAD_BATCH_HTTPDNS", 3, 7);
        SOURCE_PRELOAD_BATCH_HTTPDNS = r6;
        TTNetDnsCacheSource r8 = new TTNetDnsCacheSource("SOURCE_ASYNC_BATCH_HTTPDNS", 4, 8);
        SOURCE_ASYNC_BATCH_HTTPDNS = r8;
        $VALUES = new TTNetDnsCacheSource[]{r0, r1, r3, r6, r8};
    }

    private TTNetDnsCacheSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.mValue = r3;
    }

    public static TTNetDnsCacheSource valueOf(String r2) {
        return (TTNetDnsCacheSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(TTNetDnsCacheSource.class, r2), TTNetDnsCacheSource.class, "com.obric.memorydata.plugin");
    }

    public static TTNetDnsCacheSource[] values() {
        return (TTNetDnsCacheSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TTNetDnsCacheSource[].class, "com.obric.memorydata.plugin");
    }
}
