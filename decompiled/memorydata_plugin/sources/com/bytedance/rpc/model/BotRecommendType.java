package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum BotRecommendType extends Enum<BotRecommendType> {
    private static final /* synthetic */ BotRecommendType[] $VALUES = null;

    @SerializedName("2")
    public static final BotRecommendType Discoverable = null;

    @SerializedName("1")
    public static final BotRecommendType Featured = null;

    @SerializedName("0")
    public static final BotRecommendType None = null;
    private final int value;

    static {
        BotRecommendType r0 = new BotRecommendType("None", 0, 0);
        None = r0;
        BotRecommendType r1 = new BotRecommendType("Featured", 1, 1);
        Featured = r1;
        BotRecommendType r3 = new BotRecommendType("Discoverable", 2, 2);
        Discoverable = r3;
        $VALUES = new BotRecommendType[]{r0, r1, r3};
    }

    private BotRecommendType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static BotRecommendType findByValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return Discoverable;
    L12:
        return Featured;
    L14:
        return None;
    }

    public static BotRecommendType valueOf(String r2) {
        return (BotRecommendType) ZeusTransformUtils.preCheckCast(Enum.valueOf(BotRecommendType.class, r2), BotRecommendType.class, "com.obric.memorydata.plugin");
    }

    public static BotRecommendType[] values() {
        return (BotRecommendType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BotRecommendType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
