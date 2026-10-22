package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum PromptTemplateFormat extends Enum<PromptTemplateFormat> {
    private static final /* synthetic */ PromptTemplateFormat[] $VALUES = null;

    @SerializedName("1")
    public static final PromptTemplateFormat FString = null;

    @SerializedName("2")
    public static final PromptTemplateFormat Jinja2 = null;
    private final int value;

    static {
        PromptTemplateFormat r0 = new PromptTemplateFormat("FString", 0, 1);
        FString = r0;
        PromptTemplateFormat r1 = new PromptTemplateFormat("Jinja2", 1, 2);
        Jinja2 = r1;
        $VALUES = new PromptTemplateFormat[]{r0, r1};
    }

    private PromptTemplateFormat(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static PromptTemplateFormat findByValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return Jinja2;
    L11:
        return FString;
    }

    public static PromptTemplateFormat valueOf(String r2) {
        return (PromptTemplateFormat) ZeusTransformUtils.preCheckCast(Enum.valueOf(PromptTemplateFormat.class, r2), PromptTemplateFormat.class, "com.obric.memorydata.plugin");
    }

    public static PromptTemplateFormat[] values() {
        return (PromptTemplateFormat[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PromptTemplateFormat[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
