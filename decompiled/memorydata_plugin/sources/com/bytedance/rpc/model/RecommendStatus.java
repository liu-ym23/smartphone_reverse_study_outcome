package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum RecommendStatus extends Enum<RecommendStatus> {
    private static final /* synthetic */ RecommendStatus[] $VALUES = null;

    @SerializedName("1")
    public static final RecommendStatus Disable = null;

    @SerializedName("0")
    public static final RecommendStatus Enable = null;
    private final int value;

    static {
        RecommendStatus r0 = new RecommendStatus("Enable", 0, 0);
        Enable = r0;
        RecommendStatus r1 = new RecommendStatus("Disable", 1, 1);
        Disable = r1;
        $VALUES = new RecommendStatus[]{r0, r1};
    }

    private RecommendStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static RecommendStatus findByValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return Disable;
    L10:
        return Enable;
    }

    public static RecommendStatus valueOf(String r2) {
        return (RecommendStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(RecommendStatus.class, r2), RecommendStatus.class, "com.obric.memorydata.plugin");
    }

    public static RecommendStatus[] values() {
        return (RecommendStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RecommendStatus[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
