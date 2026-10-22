package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum RecommendType extends Enum<RecommendType> {
    private static final /* synthetic */ RecommendType[] $VALUES = null;

    @SerializedName("0")
    public static final RecommendType Recommend = null;

    @SerializedName("1")
    public static final RecommendType TopRecommend = null;
    private final int value;

    static {
        RecommendType r0 = new RecommendType("Recommend", 0, 0);
        Recommend = r0;
        RecommendType r1 = new RecommendType("TopRecommend", 1, 1);
        TopRecommend = r1;
        $VALUES = new RecommendType[]{r0, r1};
    }

    private RecommendType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static RecommendType findByValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return TopRecommend;
    L10:
        return Recommend;
    }

    public static RecommendType valueOf(String r2) {
        return (RecommendType) ZeusTransformUtils.preCheckCast(Enum.valueOf(RecommendType.class, r2), RecommendType.class, "com.obric.memorydata.plugin");
    }

    public static RecommendType[] values() {
        return (RecommendType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RecommendType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
