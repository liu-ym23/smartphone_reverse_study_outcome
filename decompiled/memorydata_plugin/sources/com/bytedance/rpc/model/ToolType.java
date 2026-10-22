package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ToolType extends Enum<ToolType> {
    private static final /* synthetic */ ToolType[] $VALUES = null;

    @SerializedName("1")
    public static final ToolType Agent = null;

    @SerializedName("0")
    public static final ToolType Function = null;

    @SerializedName("2")
    public static final ToolType Other = null;
    private final int value;

    static {
        ToolType r0 = new ToolType("Function", 0, 0);
        Function = r0;
        ToolType r1 = new ToolType("Agent", 1, 1);
        Agent = r1;
        ToolType r3 = new ToolType("Other", 2, 2);
        Other = r3;
        $VALUES = new ToolType[]{r0, r1, r3};
    }

    private ToolType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ToolType findByValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return Other;
    L12:
        return Agent;
    L14:
        return Function;
    }

    public static ToolType valueOf(String r2) {
        return (ToolType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ToolType.class, r2), ToolType.class, "com.obric.memorydata.plugin");
    }

    public static ToolType[] values() {
        return (ToolType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ToolType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
