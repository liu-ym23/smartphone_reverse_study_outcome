package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ModelVersion extends Enum<ModelVersion> {
    private static final /* synthetic */ ModelVersion[] $VALUES = null;

    @SerializedName("1")
    public static final ModelVersion GPT3D5 = null;

    @SerializedName("2")
    public static final ModelVersion GPT4 = null;

    @SerializedName("0")
    public static final ModelVersion UNK = null;
    private final int value;

    static {
        ModelVersion r0 = new ModelVersion("UNK", 0, 0);
        UNK = r0;
        ModelVersion r1 = new ModelVersion("GPT3D5", 1, 1);
        GPT3D5 = r1;
        ModelVersion r3 = new ModelVersion("GPT4", 2, 2);
        GPT4 = r3;
        $VALUES = new ModelVersion[]{r0, r1, r3};
    }

    private ModelVersion(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ModelVersion findByValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return GPT4;
    L12:
        return GPT3D5;
    L14:
        return UNK;
    }

    public static ModelVersion valueOf(String r2) {
        return (ModelVersion) ZeusTransformUtils.preCheckCast(Enum.valueOf(ModelVersion.class, r2), ModelVersion.class, "com.obric.memorydata.plugin");
    }

    public static ModelVersion[] values() {
        return (ModelVersion[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ModelVersion[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
