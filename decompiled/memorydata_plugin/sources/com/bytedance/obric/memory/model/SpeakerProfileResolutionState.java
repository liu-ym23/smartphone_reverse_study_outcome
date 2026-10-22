package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum SpeakerProfileResolutionState extends Enum<SpeakerProfileResolutionState> {
    private static final /* synthetic */ SpeakerProfileResolutionState[] $VALUES = null;

    @SerializedName("1")
    public static final SpeakerProfileResolutionState PENDING = null;

    @SerializedName("2")
    public static final SpeakerProfileResolutionState READY = null;

    @SerializedName("3")
    public static final SpeakerProfileResolutionState REJECTED = null;
    private final int value;

    static {
        SpeakerProfileResolutionState r0 = new SpeakerProfileResolutionState("PENDING", 0, 1);
        PENDING = r0;
        SpeakerProfileResolutionState r1 = new SpeakerProfileResolutionState("READY", 1, 2);
        READY = r1;
        SpeakerProfileResolutionState r4 = new SpeakerProfileResolutionState("REJECTED", 2, 3);
        REJECTED = r4;
        $VALUES = new SpeakerProfileResolutionState[]{r0, r1, r4};
    }

    private SpeakerProfileResolutionState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static SpeakerProfileResolutionState findByValue(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return REJECTED;
    L13:
        return READY;
    L15:
        return PENDING;
    }

    public static SpeakerProfileResolutionState valueOf(String r2) {
        return (SpeakerProfileResolutionState) ZeusTransformUtils.preCheckCast(Enum.valueOf(SpeakerProfileResolutionState.class, r2), SpeakerProfileResolutionState.class, "com.obric.memorydata.plugin");
    }

    public static SpeakerProfileResolutionState[] values() {
        return (SpeakerProfileResolutionState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SpeakerProfileResolutionState[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
