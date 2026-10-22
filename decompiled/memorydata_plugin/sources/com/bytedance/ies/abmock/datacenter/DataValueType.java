package com.bytedance.ies.abmock.datacenter;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum DataValueType extends Enum<DataValueType> {
    private static final /* synthetic */ DataValueType[] $VALUES = null;
    public static final DataValueType BOOLEAN = null;
    public static final DataValueType DOUBLE = null;
    public static final DataValueType FLOAT = null;
    public static final DataValueType INT = null;
    public static final DataValueType LONG = null;
    public static final DataValueType OBJECT = null;
    public static final DataValueType STRING = null;
    public static final DataValueType STRING_ARRAY = null;

    static {
        DataValueType r0 = new DataValueType("INT", 0);
        INT = r0;
        DataValueType r1 = new DataValueType("BOOLEAN", 1);
        BOOLEAN = r1;
        DataValueType r3 = new DataValueType("LONG", 2);
        LONG = r3;
        DataValueType r5 = new DataValueType("FLOAT", 3);
        FLOAT = r5;
        DataValueType r7 = new DataValueType("DOUBLE", 4);
        DOUBLE = r7;
        DataValueType r9 = new DataValueType("STRING", 5);
        STRING = r9;
        DataValueType r11 = new DataValueType("STRING_ARRAY", 6);
        STRING_ARRAY = r11;
        DataValueType r13 = new DataValueType("OBJECT", 7);
        OBJECT = r13;
        $VALUES = new DataValueType[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    private DataValueType(String r1, int r2) {
        super(r1, r2);
    }

    public static DataValueType valueOf(String r2) {
        return (DataValueType) ZeusTransformUtils.preCheckCast(Enum.valueOf(DataValueType.class, r2), DataValueType.class, "com.obric.memorydata.plugin");
    }

    public static DataValueType[] values() {
        return (DataValueType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DataValueType[].class, "com.obric.memorydata.plugin");
    }
}
