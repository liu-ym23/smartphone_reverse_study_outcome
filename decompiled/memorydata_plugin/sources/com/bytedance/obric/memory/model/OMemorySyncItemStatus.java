package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum OMemorySyncItemStatus extends Enum<OMemorySyncItemStatus> {
    private static final /* synthetic */ OMemorySyncItemStatus[] $VALUES = null;

    @SerializedName("1")
    public static final OMemorySyncItemStatus IGNORED_OLD_VERSION = null;

    @SerializedName("4")
    public static final OMemorySyncItemStatus INVALID_ARGUMENT = null;

    @SerializedName("3")
    public static final OMemorySyncItemStatus RETRYABLE_ERROR = null;

    @SerializedName("0")
    public static final OMemorySyncItemStatus SUCCESS = null;
    private final int value;

    static {
        OMemorySyncItemStatus r0 = new OMemorySyncItemStatus("SUCCESS", 0, 0);
        SUCCESS = r0;
        OMemorySyncItemStatus r1 = new OMemorySyncItemStatus("IGNORED_OLD_VERSION", 1, 1);
        IGNORED_OLD_VERSION = r1;
        OMemorySyncItemStatus r3 = new OMemorySyncItemStatus("RETRYABLE_ERROR", 2, 3);
        RETRYABLE_ERROR = r3;
        OMemorySyncItemStatus r5 = new OMemorySyncItemStatus("INVALID_ARGUMENT", 3, 4);
        INVALID_ARGUMENT = r5;
        $VALUES = new OMemorySyncItemStatus[]{r0, r1, r3, r5};
    }

    private OMemorySyncItemStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static OMemorySyncItemStatus findByValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 3) goto L14;
        if (r1 == 4) goto L12;
        return null;
    L12:
        return INVALID_ARGUMENT;
    L14:
        return RETRYABLE_ERROR;
    L16:
        return IGNORED_OLD_VERSION;
    L18:
        return SUCCESS;
    }

    public static OMemorySyncItemStatus valueOf(String r2) {
        return (OMemorySyncItemStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(OMemorySyncItemStatus.class, r2), OMemorySyncItemStatus.class, "com.obric.memorydata.plugin");
    }

    public static OMemorySyncItemStatus[] values() {
        return (OMemorySyncItemStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OMemorySyncItemStatus[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
