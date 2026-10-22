package com.bytedance.obric.memory.model;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum OMemorySemanticOperation extends Enum<OMemorySemanticOperation> {
    private static final /* synthetic */ OMemorySemanticOperation[] $VALUES = null;

    @SerializedName("2")
    public static final OMemorySemanticOperation DELETE = null;

    @SerializedName("1")
    public static final OMemorySemanticOperation UPSERT = null;
    private final int value;

    static {
        OMemorySemanticOperation r0 = new OMemorySemanticOperation("UPSERT", 0, 1);
        UPSERT = r0;
        OMemorySemanticOperation r1 = new OMemorySemanticOperation(HttpMethodContrants.DELETE, 1, 2);
        DELETE = r1;
        $VALUES = new OMemorySemanticOperation[]{r0, r1};
    }

    private OMemorySemanticOperation(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static OMemorySemanticOperation findByValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return DELETE;
    L11:
        return UPSERT;
    }

    public static OMemorySemanticOperation valueOf(String r2) {
        return (OMemorySemanticOperation) ZeusTransformUtils.preCheckCast(Enum.valueOf(OMemorySemanticOperation.class, r2), OMemorySemanticOperation.class, "com.obric.memorydata.plugin");
    }

    public static OMemorySemanticOperation[] values() {
        return (OMemorySemanticOperation[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OMemorySemanticOperation[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
