package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum OnboardingSourceMode extends Enum<OnboardingSourceMode> {
    private static final /* synthetic */ OnboardingSourceMode[] $VALUES = null;

    @SerializedName("1")
    public static final OnboardingSourceMode NO_NEED = null;

    @SerializedName("3")
    public static final OnboardingSourceMode USE_LLM = null;

    @SerializedName("2")
    public static final OnboardingSourceMode USE_MANUAL = null;
    private final int value;

    static {
        OnboardingSourceMode r0 = new OnboardingSourceMode("NO_NEED", 0, 1);
        NO_NEED = r0;
        OnboardingSourceMode r1 = new OnboardingSourceMode("USE_MANUAL", 1, 2);
        USE_MANUAL = r1;
        OnboardingSourceMode r4 = new OnboardingSourceMode("USE_LLM", 2, 3);
        USE_LLM = r4;
        $VALUES = new OnboardingSourceMode[]{r0, r1, r4};
    }

    private OnboardingSourceMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static OnboardingSourceMode findByValue(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return USE_LLM;
    L13:
        return USE_MANUAL;
    L15:
        return NO_NEED;
    }

    public static OnboardingSourceMode valueOf(String r2) {
        return (OnboardingSourceMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(OnboardingSourceMode.class, r2), OnboardingSourceMode.class, "com.obric.memorydata.plugin");
    }

    public static OnboardingSourceMode[] values() {
        return (OnboardingSourceMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OnboardingSourceMode[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
