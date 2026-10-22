package com.mammon.audiosdk.enums;

import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum SAMICoreAbConfigType extends Enum<SAMICoreAbConfigType> {
    private static final /* synthetic */ SAMICoreAbConfigType[] $VALUES = null;
    public static final SAMICoreAbConfigType BoolType = null;
    public static final SAMICoreAbConfigType FloatType = null;
    public static final SAMICoreAbConfigType IntType = null;
    public static final SAMICoreAbConfigType StringType = null;
    public static final SAMICoreAbConfigType UnknownType = null;
    public static final HashMap<Integer, SAMICoreAbConfigType> intToEnumMap = null;
    private int value;

    static {
        int r2 = 0;
        SAMICoreAbConfigType r0 = new SAMICoreAbConfigType("UnknownType", 0, 0);
        UnknownType = r0;
        SAMICoreAbConfigType r1 = new SAMICoreAbConfigType("IntType", 1, 1);
        IntType = r1;
        SAMICoreAbConfigType r3 = new SAMICoreAbConfigType("FloatType", 2, 2);
        FloatType = r3;
        SAMICoreAbConfigType r5 = new SAMICoreAbConfigType("StringType", 3, 3);
        StringType = r5;
        SAMICoreAbConfigType r7 = new SAMICoreAbConfigType("BoolType", 4, 4);
        BoolType = r7;
        $VALUES = new SAMICoreAbConfigType[]{r0, r1, r3, r5, r7};
        intToEnumMap = new HashMap();
        SAMICoreAbConfigType[] r4 = values();
        int r6 = r4.length;
    L3:
        if (r2 >= r6) goto L5;
        SAMICoreAbConfigType r8 = r4[r2];
        intToEnumMap.put(Integer.valueOf(r8.getValue()), r8);
        r2 = r2 + 1;
        goto L3
    }

    public static SAMICoreAbConfigType[] values() {
        return (SAMICoreAbConfigType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreAbConfigType fromInt(int r1) {
        return intToEnumMap.get(Integer.valueOf(r1));
    }

    public static SAMICoreAbConfigType valueOf(String r1) {
        return (SAMICoreAbConfigType) a.a(SAMICoreAbConfigType.class, r1);
    }

    private SAMICoreAbConfigType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
