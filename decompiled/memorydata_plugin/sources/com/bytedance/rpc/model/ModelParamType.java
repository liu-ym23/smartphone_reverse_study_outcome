package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ModelParamType extends Enum<ModelParamType> {
    private static final /* synthetic */ ModelParamType[] $VALUES = null;

    @SerializedName("3")
    public static final ModelParamType Boolean = null;

    @SerializedName("1")
    public static final ModelParamType Float = null;

    @SerializedName("2")
    public static final ModelParamType Int = null;

    @SerializedName("4")
    public static final ModelParamType String = null;
    private final int value;

    static {
        ModelParamType r0 = new ModelParamType("Float", 0, 1);
        Float = r0;
        ModelParamType r1 = new ModelParamType("Int", 1, 2);
        Int = r1;
        ModelParamType r4 = new ModelParamType("Boolean", 2, 3);
        Boolean = r4;
        ModelParamType r6 = new ModelParamType("String", 3, 4);
        String = r6;
        $VALUES = new ModelParamType[]{r0, r1, r4, r6};
    }

    private ModelParamType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ModelParamType findByValue(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 4) goto L13;
        return null;
    L13:
        return String;
    L15:
        return Boolean;
    L17:
        return Int;
    L19:
        return Float;
    }

    public static ModelParamType valueOf(String r2) {
        return (ModelParamType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ModelParamType.class, r2), ModelParamType.class, "com.obric.memorydata.plugin");
    }

    public static ModelParamType[] values() {
        return (ModelParamType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ModelParamType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
