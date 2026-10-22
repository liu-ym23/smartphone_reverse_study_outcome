package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum PromptTemplateType extends Enum<PromptTemplateType> {
    private static final /* synthetic */ PromptTemplateType[] $VALUES = null;

    @SerializedName("2")
    public static final PromptTemplateType GPT_DATASET = null;

    @SerializedName("3")
    public static final PromptTemplateType GPT_NOTHING = null;

    @SerializedName("0")
    public static final PromptTemplateType GPT_TOOLS = null;

    @SerializedName("1")
    public static final PromptTemplateType GPT_TOOLS_DATASET = null;

    @SerializedName("4")
    public static final PromptTemplateType SEED_MUSIC = null;
    private final int value;

    static {
        PromptTemplateType r0 = new PromptTemplateType("GPT_TOOLS", 0, 0);
        GPT_TOOLS = r0;
        PromptTemplateType r1 = new PromptTemplateType("GPT_TOOLS_DATASET", 1, 1);
        GPT_TOOLS_DATASET = r1;
        PromptTemplateType r3 = new PromptTemplateType("GPT_DATASET", 2, 2);
        GPT_DATASET = r3;
        PromptTemplateType r5 = new PromptTemplateType("GPT_NOTHING", 3, 3);
        GPT_NOTHING = r5;
        PromptTemplateType r7 = new PromptTemplateType("SEED_MUSIC", 4, 4);
        SEED_MUSIC = r7;
        $VALUES = new PromptTemplateType[]{r0, r1, r3, r5, r7};
    }

    private PromptTemplateType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static PromptTemplateType findByValue(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L14;
        return null;
    L14:
        return SEED_MUSIC;
    L16:
        return GPT_NOTHING;
    L18:
        return GPT_DATASET;
    L20:
        return GPT_TOOLS_DATASET;
    L22:
        return GPT_TOOLS;
    }

    public static PromptTemplateType valueOf(String r2) {
        return (PromptTemplateType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PromptTemplateType.class, r2), PromptTemplateType.class, "com.obric.memorydata.plugin");
    }

    public static PromptTemplateType[] values() {
        return (PromptTemplateType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PromptTemplateType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
