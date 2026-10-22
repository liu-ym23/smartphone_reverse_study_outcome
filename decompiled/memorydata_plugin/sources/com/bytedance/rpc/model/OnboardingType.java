package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum OnboardingType extends Enum<OnboardingType> {
    private static final /* synthetic */ OnboardingType[] $VALUES = null;

    @SerializedName("0")
    public static final OnboardingType None = null;

    @SerializedName("3")
    public static final OnboardingType OnboardingLLMGen = null;

    @SerializedName("1")
    public static final OnboardingType OnboardingNotDisplay = null;

    @SerializedName("2")
    public static final OnboardingType OnboardingPreset = null;
    private final int value;

    static {
        OnboardingType r0 = new OnboardingType("None", 0, 0);
        None = r0;
        OnboardingType r1 = new OnboardingType("OnboardingNotDisplay", 1, 1);
        OnboardingNotDisplay = r1;
        OnboardingType r3 = new OnboardingType("OnboardingPreset", 2, 2);
        OnboardingPreset = r3;
        OnboardingType r5 = new OnboardingType("OnboardingLLMGen", 3, 3);
        OnboardingLLMGen = r5;
        $VALUES = new OnboardingType[]{r0, r1, r3, r5};
    }

    private OnboardingType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static OnboardingType findByValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return OnboardingLLMGen;
    L14:
        return OnboardingPreset;
    L16:
        return OnboardingNotDisplay;
    L18:
        return None;
    }

    public static OnboardingType valueOf(String r2) {
        return (OnboardingType) ZeusTransformUtils.preCheckCast(Enum.valueOf(OnboardingType.class, r2), OnboardingType.class, "com.obric.memorydata.plugin");
    }

    public static OnboardingType[] values() {
        return (OnboardingType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OnboardingType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
