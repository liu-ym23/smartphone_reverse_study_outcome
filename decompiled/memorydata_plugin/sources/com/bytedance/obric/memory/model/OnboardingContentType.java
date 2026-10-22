package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum OnboardingContentType extends Enum<OnboardingContentType> {
    private static final /* synthetic */ OnboardingContentType[] $VALUES = null;

    @SerializedName("1")
    public static final OnboardingContentType Prologue = null;

    @SerializedName("2")
    public static final OnboardingContentType SuggestedQuestions = null;
    private final int value;

    static {
        OnboardingContentType r0 = new OnboardingContentType("Prologue", 0, 1);
        Prologue = r0;
        OnboardingContentType r1 = new OnboardingContentType("SuggestedQuestions", 1, 2);
        SuggestedQuestions = r1;
        $VALUES = new OnboardingContentType[]{r0, r1};
    }

    private OnboardingContentType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static OnboardingContentType findByValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return SuggestedQuestions;
    L11:
        return Prologue;
    }

    public static OnboardingContentType valueOf(String r2) {
        return (OnboardingContentType) ZeusTransformUtils.preCheckCast(Enum.valueOf(OnboardingContentType.class, r2), OnboardingContentType.class, "com.obric.memorydata.plugin");
    }

    public static OnboardingContentType[] values() {
        return (OnboardingContentType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OnboardingContentType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
