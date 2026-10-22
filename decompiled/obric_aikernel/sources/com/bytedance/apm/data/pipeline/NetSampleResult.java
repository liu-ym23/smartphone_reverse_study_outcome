package com.bytedance.apm.data.pipeline;

/* JADX INFO: loaded from: classes.dex */
public final enum NetSampleResult extends Enum<NetSampleResult> {
    private static final /* synthetic */ NetSampleResult[] $VALUES = null;
    public static final NetSampleResult HIT = null;
    public static final NetSampleResult NOT_HIT = null;
    public static final NetSampleResult UNKNOWN = null;

    static {
        NetSampleResult r10 = new NetSampleResult("UNKNOWN", 0);
        UNKNOWN = r10;
        NetSampleResult r11 = new NetSampleResult("HIT", 1);
        HIT = r11;
        NetSampleResult r12 = new NetSampleResult("NOT_HIT", 2);
        NOT_HIT = r12;
        $VALUES = new NetSampleResult[]{r10, r11, r12};
    }

    private NetSampleResult(String r10, int r11) {
        super(r10, r11);
    }

    public static NetSampleResult valueOf(String r10) {
        return (NetSampleResult) Enum.valueOf(NetSampleResult.class, r10);
    }

    public static NetSampleResult[] values() {
        return (NetSampleResult[]) $VALUES.clone();
    }
}
