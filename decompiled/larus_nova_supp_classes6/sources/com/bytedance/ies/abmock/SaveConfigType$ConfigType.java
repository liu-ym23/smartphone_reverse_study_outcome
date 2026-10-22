package com.bytedance.ies.abmock;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum SaveConfigType$ConfigType extends Enum<SaveConfigType$ConfigType> {
    private static final /* synthetic */ SaveConfigType$ConfigType[] $VALUES = null;
    public static final SaveConfigType$ConfigType BOOLEAN = null;
    public static final SaveConfigType$ConfigType DOUBLE = null;
    public static final SaveConfigType$ConfigType FLOAT = null;
    public static final SaveConfigType$ConfigType INT = null;
    public static final SaveConfigType$ConfigType LONG = null;
    public static final SaveConfigType$ConfigType OBJECT = null;
    public static final SaveConfigType$ConfigType STRING = null;
    public static final SaveConfigType$ConfigType STRING_ARRAY = null;

    static {
        SaveConfigType$ConfigType r0 = new SaveConfigType$ConfigType("BOOLEAN", 0);
        BOOLEAN = r0;
        SaveConfigType$ConfigType r1 = new SaveConfigType$ConfigType("INT", 1);
        INT = r1;
        SaveConfigType$ConfigType r3 = new SaveConfigType$ConfigType("LONG", 2);
        LONG = r3;
        SaveConfigType$ConfigType r5 = new SaveConfigType$ConfigType("DOUBLE", 3);
        DOUBLE = r5;
        SaveConfigType$ConfigType r7 = new SaveConfigType$ConfigType("FLOAT", 4);
        FLOAT = r7;
        SaveConfigType$ConfigType r9 = new SaveConfigType$ConfigType("STRING", 5);
        STRING = r9;
        SaveConfigType$ConfigType r11 = new SaveConfigType$ConfigType("STRING_ARRAY", 6);
        STRING_ARRAY = r11;
        SaveConfigType$ConfigType r13 = new SaveConfigType$ConfigType("OBJECT", 7);
        OBJECT = r13;
        $VALUES = new SaveConfigType$ConfigType[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    public static SaveConfigType$ConfigType[] values() {
        return (SaveConfigType$ConfigType[]) $VALUES.clone();
    }

    public static SaveConfigType$ConfigType valueOf(String r1) {
        return (SaveConfigType$ConfigType) a.a(SaveConfigType$ConfigType.class, r1);
    }

    private SaveConfigType$ConfigType(String r1, int r2) {
        super(r1, r2);
    }
}
