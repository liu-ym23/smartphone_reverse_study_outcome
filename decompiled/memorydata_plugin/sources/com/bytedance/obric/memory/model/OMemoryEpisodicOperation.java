package com.bytedance.obric.memory.model;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum OMemoryEpisodicOperation extends Enum<OMemoryEpisodicOperation> {
    private static final /* synthetic */ OMemoryEpisodicOperation[] $VALUES = null;

    @SerializedName("3")
    public static final OMemoryEpisodicOperation DELETE = null;

    @SerializedName("1")
    public static final OMemoryEpisodicOperation INSERT = null;

    @SerializedName("2")
    public static final OMemoryEpisodicOperation UPDATE = null;
    private final int value;

    static {
        OMemoryEpisodicOperation r0 = new OMemoryEpisodicOperation("INSERT", 0, 1);
        INSERT = r0;
        OMemoryEpisodicOperation r1 = new OMemoryEpisodicOperation("UPDATE", 1, 2);
        UPDATE = r1;
        OMemoryEpisodicOperation r4 = new OMemoryEpisodicOperation(HttpMethodContrants.DELETE, 2, 3);
        DELETE = r4;
        $VALUES = new OMemoryEpisodicOperation[]{r0, r1, r4};
    }

    private OMemoryEpisodicOperation(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static OMemoryEpisodicOperation findByValue(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return DELETE;
    L13:
        return UPDATE;
    L15:
        return INSERT;
    }

    public static OMemoryEpisodicOperation valueOf(String r2) {
        return (OMemoryEpisodicOperation) ZeusTransformUtils.preCheckCast(Enum.valueOf(OMemoryEpisodicOperation.class, r2), OMemoryEpisodicOperation.class, "com.obric.memorydata.plugin");
    }

    public static OMemoryEpisodicOperation[] values() {
        return (OMemoryEpisodicOperation[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OMemoryEpisodicOperation[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
