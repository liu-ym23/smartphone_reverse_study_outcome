package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum OMemoryType extends Enum<OMemoryType> {
    private static final /* synthetic */ OMemoryType[] $VALUES = null;

    @SerializedName("2")
    public static final OMemoryType COLLECTION = null;

    @SerializedName("1")
    public static final OMemoryType SEMANTIC = null;
    private final int value;

    static {
        OMemoryType r0 = new OMemoryType("SEMANTIC", 0, 1);
        SEMANTIC = r0;
        OMemoryType r1 = new OMemoryType("COLLECTION", 1, 2);
        COLLECTION = r1;
        $VALUES = new OMemoryType[]{r0, r1};
    }

    private OMemoryType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static OMemoryType findByValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return COLLECTION;
    L11:
        return SEMANTIC;
    }

    public static OMemoryType valueOf(String r2) {
        return (OMemoryType) ZeusTransformUtils.preCheckCast(Enum.valueOf(OMemoryType.class, r2), OMemoryType.class, "com.obric.memorydata.plugin");
    }

    public static OMemoryType[] values() {
        return (OMemoryType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OMemoryType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
