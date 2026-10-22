package com.bytedance.apm.data.pipeline;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum NetSampleResult extends Enum<NetSampleResult> {
    private static final /* synthetic */ NetSampleResult[] $VALUES = null;
    public static final NetSampleResult HIT = null;
    public static final NetSampleResult NOT_HIT = null;
    public static final NetSampleResult UNKNOWN = null;

    static {
        NetSampleResult r0 = new NetSampleResult("UNKNOWN", 0);
        UNKNOWN = r0;
        NetSampleResult r1 = new NetSampleResult("HIT", 1);
        HIT = r1;
        NetSampleResult r3 = new NetSampleResult("NOT_HIT", 2);
        NOT_HIT = r3;
        $VALUES = new NetSampleResult[]{r0, r1, r3};
    }

    private NetSampleResult(String r1, int r2) {
        super(r1, r2);
    }

    public static NetSampleResult valueOf(String r2) {
        return (NetSampleResult) ZeusTransformUtils.preCheckCast(Enum.valueOf(NetSampleResult.class, r2), NetSampleResult.class, "com.obric.memorydata.plugin");
    }

    public static NetSampleResult[] values() {
        return (NetSampleResult[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NetSampleResult[].class, "com.obric.memorydata.plugin");
    }
}
