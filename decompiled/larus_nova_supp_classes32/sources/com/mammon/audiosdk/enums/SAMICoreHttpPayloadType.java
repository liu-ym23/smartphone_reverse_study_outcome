package com.mammon.audiosdk.enums;

import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum SAMICoreHttpPayloadType extends Enum<SAMICoreHttpPayloadType> {
    private static final /* synthetic */ SAMICoreHttpPayloadType[] $VALUES = null;
    public static final SAMICoreHttpPayloadType JsonString = null;
    public static final SAMICoreHttpPayloadType None = null;
    public static final SAMICoreHttpPayloadType StyleConversion = null;
    public static final HashMap<Integer, SAMICoreHttpPayloadType> intToEnumMap = null;
    private int value;

    static {
        int r2 = 0;
        SAMICoreHttpPayloadType r0 = new SAMICoreHttpPayloadType("None", 0, 0);
        None = r0;
        SAMICoreHttpPayloadType r1 = new SAMICoreHttpPayloadType("JsonString", 1, 1);
        JsonString = r1;
        SAMICoreHttpPayloadType r3 = new SAMICoreHttpPayloadType("StyleConversion", 2, 2);
        StyleConversion = r3;
        $VALUES = new SAMICoreHttpPayloadType[]{r0, r1, r3};
        intToEnumMap = new HashMap();
        SAMICoreHttpPayloadType[] r4 = values();
        int r5 = r4.length;
    L3:
        if (r2 >= r5) goto L5;
        SAMICoreHttpPayloadType r6 = r4[r2];
        intToEnumMap.put(Integer.valueOf(r6.getValue()), r6);
        r2 = r2 + 1;
        goto L3
    }

    public static SAMICoreHttpPayloadType[] values() {
        return (SAMICoreHttpPayloadType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreHttpPayloadType fromInt(int r1) {
        return intToEnumMap.get(Integer.valueOf(r1));
    }

    public static SAMICoreHttpPayloadType valueOf(String r1) {
        return (SAMICoreHttpPayloadType) a.a(SAMICoreHttpPayloadType.class, r1);
    }

    private SAMICoreHttpPayloadType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
