package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum PreGenType extends Enum<PreGenType> {
    private static final /* synthetic */ PreGenType[] $VALUES = null;

    @SerializedName("3")
    public static final PreGenType PreGen_Continue = null;

    @SerializedName("4")
    public static final PreGenType PreGen_End = null;

    @SerializedName("2")
    public static final PreGenType PreGen_PreQuery = null;

    @SerializedName("1")
    public static final PreGenType PreGen_Query = null;
    private final int value;

    static {
        PreGenType r0 = new PreGenType("PreGen_Query", 0, 1);
        PreGen_Query = r0;
        PreGenType r1 = new PreGenType("PreGen_PreQuery", 1, 2);
        PreGen_PreQuery = r1;
        PreGenType r4 = new PreGenType("PreGen_Continue", 2, 3);
        PreGen_Continue = r4;
        PreGenType r6 = new PreGenType("PreGen_End", 3, 4);
        PreGen_End = r6;
        $VALUES = new PreGenType[]{r0, r1, r4, r6};
    }

    private PreGenType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static PreGenType findByValue(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 4) goto L13;
        return null;
    L13:
        return PreGen_End;
    L15:
        return PreGen_Continue;
    L17:
        return PreGen_PreQuery;
    L19:
        return PreGen_Query;
    }

    public static PreGenType valueOf(String r2) {
        return (PreGenType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PreGenType.class, r2), PreGenType.class, "com.obric.memorydata.plugin");
    }

    public static PreGenType[] values() {
        return (PreGenType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PreGenType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
