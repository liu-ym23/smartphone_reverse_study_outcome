package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: loaded from: classes2.dex */
final enum TTNetDnsSource extends Enum<TTNetDnsSource> {
    public static final TTNetDnsSource NOT_SET = null;
    public static final TTNetDnsSource SERVE_FROM_ASYNC_BATCH_PRELOAD = null;
    public static final TTNetDnsSource SERVE_FROM_BATCH_PRELOAD = null;
    public static final TTNetDnsSource SERVE_FROM_CACHE = null;
    public static final TTNetDnsSource SERVE_FROM_HARDCODE_HOSTS = null;
    public static final TTNetDnsSource SERVE_FROM_HTTP_DNS_JOB = null;
    public static final TTNetDnsSource SERVE_FROM_PREFER_ADDR = null;
    public static final TTNetDnsSource SERVE_FROM_PROC_DNS_JOB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TTNetDnsSource[] f4681a = null;
    final int mValue;

    static {
        TTNetDnsSource r5 = new TTNetDnsSource("NOT_SET", 0, 0);
        NOT_SET = r5;
        TTNetDnsSource r10 = new TTNetDnsSource("SERVE_FROM_CACHE", 1, 2);
        SERVE_FROM_CACHE = r10;
        TTNetDnsSource r11 = new TTNetDnsSource("SERVE_FROM_PREFER_ADDR", 2, 5);
        SERVE_FROM_PREFER_ADDR = r11;
        TTNetDnsSource r12 = new TTNetDnsSource("SERVE_FROM_HTTP_DNS_JOB", 3, 6);
        SERVE_FROM_HTTP_DNS_JOB = r12;
        TTNetDnsSource r13 = new TTNetDnsSource("SERVE_FROM_PROC_DNS_JOB", 4, 8);
        SERVE_FROM_PROC_DNS_JOB = r13;
        TTNetDnsSource r14 = new TTNetDnsSource("SERVE_FROM_HARDCODE_HOSTS", 5, 9);
        SERVE_FROM_HARDCODE_HOSTS = r14;
        TTNetDnsSource r15 = new TTNetDnsSource("SERVE_FROM_BATCH_PRELOAD", 6, 19);
        SERVE_FROM_BATCH_PRELOAD = r15;
        TTNetDnsSource r16 = new TTNetDnsSource("SERVE_FROM_ASYNC_BATCH_PRELOAD", 7, 20);
        SERVE_FROM_ASYNC_BATCH_PRELOAD = r16;
        f4681a = new TTNetDnsSource[]{r5, r10, r11, r12, r13, r14, r15, r16};
    }

    public TTNetDnsSource(String r5, int r10, int r11) {
        super(r5, r10);
        this.mValue = r11;
    }

    public static TTNetDnsSource valueOf(String r5) {
        return (TTNetDnsSource) Enum.valueOf(TTNetDnsSource.class, r5);
    }

    public static TTNetDnsSource[] values() {
        return (TTNetDnsSource[]) f4681a.clone();
    }
}
