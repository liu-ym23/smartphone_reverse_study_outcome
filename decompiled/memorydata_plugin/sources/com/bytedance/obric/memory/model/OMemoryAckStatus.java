package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum OMemoryAckStatus extends Enum<OMemoryAckStatus> {
    private static final /* synthetic */ OMemoryAckStatus[] $VALUES = null;

    @SerializedName("1")
    public static final OMemoryAckStatus ALREADY_ACKED = null;

    @SerializedName("3")
    public static final OMemoryAckStatus INVALID_ARGUMENT = null;

    @SerializedName("0")
    public static final OMemoryAckStatus SUCCESS = null;

    @SerializedName("2")
    public static final OMemoryAckStatus VERSION_CONFLICT = null;
    private final int value;

    static {
        OMemoryAckStatus r0 = new OMemoryAckStatus("SUCCESS", 0, 0);
        SUCCESS = r0;
        OMemoryAckStatus r1 = new OMemoryAckStatus("ALREADY_ACKED", 1, 1);
        ALREADY_ACKED = r1;
        OMemoryAckStatus r3 = new OMemoryAckStatus("VERSION_CONFLICT", 2, 2);
        VERSION_CONFLICT = r3;
        OMemoryAckStatus r5 = new OMemoryAckStatus("INVALID_ARGUMENT", 3, 3);
        INVALID_ARGUMENT = r5;
        $VALUES = new OMemoryAckStatus[]{r0, r1, r3, r5};
    }

    private OMemoryAckStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static OMemoryAckStatus findByValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return INVALID_ARGUMENT;
    L14:
        return VERSION_CONFLICT;
    L16:
        return ALREADY_ACKED;
    L18:
        return SUCCESS;
    }

    public static OMemoryAckStatus valueOf(String r2) {
        return (OMemoryAckStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(OMemoryAckStatus.class, r2), OMemoryAckStatus.class, "com.obric.memorydata.plugin");
    }

    public static OMemoryAckStatus[] values() {
        return (OMemoryAckStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OMemoryAckStatus[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
