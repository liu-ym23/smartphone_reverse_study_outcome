package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum OnboardingResultSource extends Enum<OnboardingResultSource> {
    private static final /* synthetic */ OnboardingResultSource[] $VALUES = null;

    @SerializedName("1")
    public static final OnboardingResultSource LLM_GEN = null;

    @SerializedName("2")
    public static final OnboardingResultSource LLM_GEN_THEN_TRANSLATE = null;

    @SerializedName("3")
    public static final OnboardingResultSource MANUAL = null;

    @SerializedName("4")
    public static final OnboardingResultSource MANUAL_THEN_TRANSLATE = null;
    private final int value;

    static {
        OnboardingResultSource r0 = new OnboardingResultSource("LLM_GEN", 0, 1);
        LLM_GEN = r0;
        OnboardingResultSource r1 = new OnboardingResultSource("LLM_GEN_THEN_TRANSLATE", 1, 2);
        LLM_GEN_THEN_TRANSLATE = r1;
        OnboardingResultSource r4 = new OnboardingResultSource("MANUAL", 2, 3);
        MANUAL = r4;
        OnboardingResultSource r6 = new OnboardingResultSource("MANUAL_THEN_TRANSLATE", 3, 4);
        MANUAL_THEN_TRANSLATE = r6;
        $VALUES = new OnboardingResultSource[]{r0, r1, r4, r6};
    }

    private OnboardingResultSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static OnboardingResultSource findByValue(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 4) goto L13;
        return null;
    L13:
        return MANUAL_THEN_TRANSLATE;
    L15:
        return MANUAL;
    L17:
        return LLM_GEN_THEN_TRANSLATE;
    L19:
        return LLM_GEN;
    }

    public static OnboardingResultSource valueOf(String r2) {
        return (OnboardingResultSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(OnboardingResultSource.class, r2), OnboardingResultSource.class, "com.obric.memorydata.plugin");
    }

    public static OnboardingResultSource[] values() {
        return (OnboardingResultSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OnboardingResultSource[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
