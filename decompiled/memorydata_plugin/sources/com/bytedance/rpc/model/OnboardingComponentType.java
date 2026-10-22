package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum OnboardingComponentType extends Enum<OnboardingComponentType> {
    private static final /* synthetic */ OnboardingComponentType[] $VALUES = null;

    @SerializedName("1")
    public static final OnboardingComponentType Prologue = null;

    @SerializedName("2")
    public static final OnboardingComponentType SuggestedQuestion = null;
    private final int value;

    static {
        OnboardingComponentType r0 = new OnboardingComponentType("Prologue", 0, 1);
        Prologue = r0;
        OnboardingComponentType r1 = new OnboardingComponentType("SuggestedQuestion", 1, 2);
        SuggestedQuestion = r1;
        $VALUES = new OnboardingComponentType[]{r0, r1};
    }

    private OnboardingComponentType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static OnboardingComponentType findByValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return SuggestedQuestion;
    L11:
        return Prologue;
    }

    public static OnboardingComponentType valueOf(String r2) {
        return (OnboardingComponentType) ZeusTransformUtils.preCheckCast(Enum.valueOf(OnboardingComponentType.class, r2), OnboardingComponentType.class, "com.obric.memorydata.plugin");
    }

    public static OnboardingComponentType[] values() {
        return (OnboardingComponentType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OnboardingComponentType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
