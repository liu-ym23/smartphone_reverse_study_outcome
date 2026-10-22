package com.bytedance.apm.data.pipeline;

/* JADX INFO: loaded from: classes2.dex */
public final enum NetSampleResult extends Enum<NetSampleResult> {
    public static final NetSampleResult HIT = null;
    public static final NetSampleResult NOT_HIT = null;
    public static final NetSampleResult UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetSampleResult[] f3864a = null;

    static {
        NetSampleResult r5 = new NetSampleResult("UNKNOWN", 0);
        UNKNOWN = r5;
        NetSampleResult r10 = new NetSampleResult("HIT", 1);
        HIT = r10;
        NetSampleResult r11 = new NetSampleResult("NOT_HIT", 2);
        NOT_HIT = r11;
        f3864a = new NetSampleResult[]{r5, r10, r11};
    }

    public static NetSampleResult valueOf(String r5) {
        return (NetSampleResult) Enum.valueOf(NetSampleResult.class, r5);
    }

    public static NetSampleResult[] values() {
        return (NetSampleResult[]) f3864a.clone();
    }
}
