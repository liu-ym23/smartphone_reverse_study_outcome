package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum OnboardingSceneType extends Enum<OnboardingSceneType> {
    private static final /* synthetic */ OnboardingSceneType[] $VALUES = null;

    @SerializedName("1")
    public static final OnboardingSceneType FIRST_MET = null;

    @SerializedName("2")
    public static final OnboardingSceneType WELCOME_BACK = null;
    private final int value;

    static {
        OnboardingSceneType r0 = new OnboardingSceneType("FIRST_MET", 0, 1);
        FIRST_MET = r0;
        OnboardingSceneType r1 = new OnboardingSceneType("WELCOME_BACK", 1, 2);
        WELCOME_BACK = r1;
        $VALUES = new OnboardingSceneType[]{r0, r1};
    }

    private OnboardingSceneType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static OnboardingSceneType findByValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return WELCOME_BACK;
    L11:
        return FIRST_MET;
    }

    public static OnboardingSceneType valueOf(String r2) {
        return (OnboardingSceneType) ZeusTransformUtils.preCheckCast(Enum.valueOf(OnboardingSceneType.class, r2), OnboardingSceneType.class, "com.obric.memorydata.plugin");
    }

    public static OnboardingSceneType[] values() {
        return (OnboardingSceneType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OnboardingSceneType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
