package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final enum TTNetDnsSource extends Enum<TTNetDnsSource> {
    private static final /* synthetic */ TTNetDnsSource[] $VALUES = null;
    public static final TTNetDnsSource NOT_SET = null;
    public static final TTNetDnsSource SERVE_FROM_ASYNC_BATCH_PRELOAD = null;
    public static final TTNetDnsSource SERVE_FROM_BATCH_PRELOAD = null;
    public static final TTNetDnsSource SERVE_FROM_CACHE = null;
    public static final TTNetDnsSource SERVE_FROM_HARDCODE_HOSTS = null;
    public static final TTNetDnsSource SERVE_FROM_HTTP_DNS_JOB = null;
    public static final TTNetDnsSource SERVE_FROM_PREFER_ADDR = null;
    public static final TTNetDnsSource SERVE_FROM_PROC_DNS_JOB = null;
    final int mValue;

    static {
        TTNetDnsSource r0 = new TTNetDnsSource("NOT_SET", 0, 0);
        NOT_SET = r0;
        TTNetDnsSource r1 = new TTNetDnsSource("SERVE_FROM_CACHE", 1, 2);
        SERVE_FROM_CACHE = r1;
        TTNetDnsSource r3 = new TTNetDnsSource("SERVE_FROM_PREFER_ADDR", 2, 5);
        SERVE_FROM_PREFER_ADDR = r3;
        TTNetDnsSource r6 = new TTNetDnsSource("SERVE_FROM_HTTP_DNS_JOB", 3, 6);
        SERVE_FROM_HTTP_DNS_JOB = r6;
        TTNetDnsSource r8 = new TTNetDnsSource("SERVE_FROM_PROC_DNS_JOB", 4, 8);
        SERVE_FROM_PROC_DNS_JOB = r8;
        TTNetDnsSource r11 = new TTNetDnsSource("SERVE_FROM_HARDCODE_HOSTS", 5, 9);
        SERVE_FROM_HARDCODE_HOSTS = r11;
        TTNetDnsSource r14 = new TTNetDnsSource("SERVE_FROM_BATCH_PRELOAD", 6, 19);
        SERVE_FROM_BATCH_PRELOAD = r14;
        TTNetDnsSource r7 = new TTNetDnsSource("SERVE_FROM_ASYNC_BATCH_PRELOAD", 7, 20);
        SERVE_FROM_ASYNC_BATCH_PRELOAD = r7;
        $VALUES = new TTNetDnsSource[]{r0, r1, r3, r6, r8, r11, r14, r7};
    }

    private TTNetDnsSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.mValue = r3;
    }

    public static TTNetDnsSource valueOf(String r2) {
        return (TTNetDnsSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(TTNetDnsSource.class, r2), TTNetDnsSource.class, "com.obric.memorydata.plugin");
    }

    public static TTNetDnsSource[] values() {
        return (TTNetDnsSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TTNetDnsSource[].class, "com.obric.memorydata.plugin");
    }
}
