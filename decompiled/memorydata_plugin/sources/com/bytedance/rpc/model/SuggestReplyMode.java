package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum SuggestReplyMode extends Enum<SuggestReplyMode> {
    private static final /* synthetic */ SuggestReplyMode[] $VALUES = null;

    @SerializedName("2")
    public static final SuggestReplyMode Disable = null;

    @SerializedName("3")
    public static final SuggestReplyMode UseOriginBotMode = null;

    @SerializedName("1")
    public static final SuggestReplyMode WithCustomizedPrompt = null;

    @SerializedName("0")
    public static final SuggestReplyMode WithDefaultPrompt = null;
    private final int value;

    static {
        SuggestReplyMode r0 = new SuggestReplyMode("WithDefaultPrompt", 0, 0);
        WithDefaultPrompt = r0;
        SuggestReplyMode r1 = new SuggestReplyMode("WithCustomizedPrompt", 1, 1);
        WithCustomizedPrompt = r1;
        SuggestReplyMode r3 = new SuggestReplyMode("Disable", 2, 2);
        Disable = r3;
        SuggestReplyMode r5 = new SuggestReplyMode("UseOriginBotMode", 3, 3);
        UseOriginBotMode = r5;
        $VALUES = new SuggestReplyMode[]{r0, r1, r3, r5};
    }

    private SuggestReplyMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static SuggestReplyMode findByValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return UseOriginBotMode;
    L14:
        return Disable;
    L16:
        return WithCustomizedPrompt;
    L18:
        return WithDefaultPrompt;
    }

    public static SuggestReplyMode valueOf(String r2) {
        return (SuggestReplyMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(SuggestReplyMode.class, r2), SuggestReplyMode.class, "com.obric.memorydata.plugin");
    }

    public static SuggestReplyMode[] values() {
        return (SuggestReplyMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SuggestReplyMode[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
