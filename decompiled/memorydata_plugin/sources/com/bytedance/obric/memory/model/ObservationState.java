package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ObservationState extends Enum<ObservationState> {
    private static final /* synthetic */ ObservationState[] $VALUES = null;

    @SerializedName("3")
    public static final ObservationState DONE = null;

    @SerializedName("4")
    public static final ObservationState FAILED = null;

    @SerializedName("1")
    public static final ObservationState PENDING = null;

    @SerializedName("2")
    public static final ObservationState PROCESSING = null;
    private final int value;

    static {
        ObservationState r0 = new ObservationState("PENDING", 0, 1);
        PENDING = r0;
        ObservationState r1 = new ObservationState("PROCESSING", 1, 2);
        PROCESSING = r1;
        ObservationState r4 = new ObservationState("DONE", 2, 3);
        DONE = r4;
        ObservationState r6 = new ObservationState(RawObservationEntity.STATE_FAILED, 3, 4);
        FAILED = r6;
        $VALUES = new ObservationState[]{r0, r1, r4, r6};
    }

    private ObservationState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ObservationState findByValue(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 4) goto L13;
        return null;
    L13:
        return FAILED;
    L15:
        return DONE;
    L17:
        return PROCESSING;
    L19:
        return PENDING;
    }

    public static ObservationState valueOf(String r2) {
        return (ObservationState) ZeusTransformUtils.preCheckCast(Enum.valueOf(ObservationState.class, r2), ObservationState.class, "com.obric.memorydata.plugin");
    }

    public static ObservationState[] values() {
        return (ObservationState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ObservationState[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
