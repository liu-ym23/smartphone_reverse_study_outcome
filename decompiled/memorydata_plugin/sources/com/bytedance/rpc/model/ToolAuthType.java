package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ToolAuthType extends Enum<ToolAuthType> {
    private static final /* synthetic */ ToolAuthType[] $VALUES = null;

    @SerializedName("2")
    public static final ToolAuthType Always = null;

    @SerializedName("0")
    public static final ToolAuthType Ask = null;

    @SerializedName("1")
    public static final ToolAuthType Once = null;
    private final int value;

    static {
        ToolAuthType r0 = new ToolAuthType("Ask", 0, 0);
        Ask = r0;
        ToolAuthType r1 = new ToolAuthType("Once", 1, 1);
        Once = r1;
        ToolAuthType r3 = new ToolAuthType("Always", 2, 2);
        Always = r3;
        $VALUES = new ToolAuthType[]{r0, r1, r3};
    }

    private ToolAuthType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ToolAuthType findByValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return Always;
    L12:
        return Once;
    L14:
        return Ask;
    }

    public static ToolAuthType valueOf(String r2) {
        return (ToolAuthType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ToolAuthType.class, r2), ToolAuthType.class, "com.obric.memorydata.plugin");
    }

    public static ToolAuthType[] values() {
        return (ToolAuthType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ToolAuthType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
