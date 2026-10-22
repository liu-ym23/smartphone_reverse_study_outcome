package com.obric.memory.datacollect;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final enum DataType extends Enum<DataType> {
    private static final /* synthetic */ DataType[] $VALUES = null;

    @SerializedName("1")
    public static final DataType Common = null;

    @SerializedName("0")
    public static final DataType WechatChat = null;
    private final int value;

    static {
        DataType r0 = new DataType("WechatChat", 0, 0);
        WechatChat = r0;
        DataType r1 = new DataType("Common", 1, 1);
        Common = r1;
        $VALUES = new DataType[]{r0, r1};
    }

    private DataType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static DataType findByValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return Common;
    L10:
        return WechatChat;
    }

    public static DataType valueOf(String r2) {
        return (DataType) ZeusTransformUtils.preCheckCast(Enum.valueOf(DataType.class, r2), DataType.class, "com.obric.memorydata.plugin");
    }

    public static DataType[] values() {
        return (DataType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DataType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
