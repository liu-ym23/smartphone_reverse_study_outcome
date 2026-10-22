package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ResultType extends Enum<ResultType> {
    private static final /* synthetic */ ResultType[] $VALUES = null;

    @SerializedName("5")
    public static final ResultType ResultType_BotSchema = null;

    @SerializedName("0")
    public static final ResultType ResultType_Default = null;

    @SerializedName("4")
    public static final ResultType ResultType_None = null;

    @SerializedName("2")
    public static final ResultType ResultType_PluginIntent = null;

    @SerializedName("1")
    public static final ResultType ResultType_PluginResponse = null;

    @SerializedName("6")
    public static final ResultType ResultType_ReferenceVariable = null;

    @SerializedName("3")
    public static final ResultType ResultType_Variables = null;
    private final int value;

    static {
        ResultType r0 = new ResultType("ResultType_Default", 0, 0);
        ResultType_Default = r0;
        ResultType r1 = new ResultType("ResultType_PluginResponse", 1, 1);
        ResultType_PluginResponse = r1;
        ResultType r3 = new ResultType("ResultType_PluginIntent", 2, 2);
        ResultType_PluginIntent = r3;
        ResultType r5 = new ResultType("ResultType_Variables", 3, 3);
        ResultType_Variables = r5;
        ResultType r7 = new ResultType("ResultType_None", 4, 4);
        ResultType_None = r7;
        ResultType r9 = new ResultType("ResultType_BotSchema", 5, 5);
        ResultType_BotSchema = r9;
        ResultType r11 = new ResultType("ResultType_ReferenceVariable", 6, 6);
        ResultType_ReferenceVariable = r11;
        $VALUES = new ResultType[]{r0, r1, r3, r5, r7, r9, r11};
    }

    private ResultType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ResultType findByValue(int r0) {
        switch(r0) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return ResultType_ReferenceVariable;
    L8:
        return ResultType_BotSchema;
    L10:
        return ResultType_None;
    L12:
        return ResultType_Variables;
    L14:
        return ResultType_PluginIntent;
    L16:
        return ResultType_PluginResponse;
    L18:
        return ResultType_Default;
    }

    public static ResultType valueOf(String r2) {
        return (ResultType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ResultType.class, r2), ResultType.class, "com.obric.memorydata.plugin");
    }

    public static ResultType[] values() {
        return (ResultType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ResultType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
