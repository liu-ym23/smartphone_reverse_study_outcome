package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ModelStatus extends Enum<ModelStatus> {
    private static final /* synthetic */ ModelStatus[] $VALUES = null;

    @SerializedName("10")
    public static final ModelStatus Deleted = null;

    @SerializedName("1")
    public static final ModelStatus InUse = null;

    @SerializedName("5")
    public static final ModelStatus Pending = null;
    private final int value;

    static {
        ModelStatus r0 = new ModelStatus("InUse", 0, 1);
        InUse = r0;
        ModelStatus r1 = new ModelStatus("Pending", 1, 5);
        Pending = r1;
        ModelStatus r4 = new ModelStatus("Deleted", 2, 10);
        Deleted = r4;
        $VALUES = new ModelStatus[]{r0, r1, r4};
    }

    private ModelStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ModelStatus findByValue(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 5) goto L13;
        if (r1 == 10) goto L11;
        return null;
    L11:
        return Deleted;
    L13:
        return Pending;
    L15:
        return InUse;
    }

    public static ModelStatus valueOf(String r2) {
        return (ModelStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(ModelStatus.class, r2), ModelStatus.class, "com.obric.memorydata.plugin");
    }

    public static ModelStatus[] values() {
        return (ModelStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ModelStatus[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
