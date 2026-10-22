package com.lynx.animax.base.bridge;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum ReadableType extends Enum<ReadableType> {
    private static final /* synthetic */ ReadableType[] $VALUES = null;
    public static final ReadableType Array = null;
    public static final ReadableType Boolean = null;
    public static final ReadableType ByteArray = null;
    public static final ReadableType Int = null;
    public static final ReadableType Long = null;
    public static final ReadableType LynxObject = null;
    public static final ReadableType Map = null;
    public static final ReadableType Null = null;
    public static final ReadableType Number = null;
    public static final ReadableType PiperData = null;
    public static final ReadableType String = null;

    static {
        ReadableType r0 = new ReadableType("Null", 0);
        Null = r0;
        ReadableType r1 = new ReadableType("Boolean", 1);
        Boolean = r1;
        ReadableType r3 = new ReadableType("Int", 2);
        Int = r3;
        ReadableType r5 = new ReadableType("Number", 3);
        Number = r5;
        ReadableType r7 = new ReadableType("String", 4);
        String = r7;
        ReadableType r9 = new ReadableType("Map", 5);
        Map = r9;
        ReadableType r11 = new ReadableType("Array", 6);
        Array = r11;
        ReadableType r13 = new ReadableType("Long", 7);
        Long = r13;
        ReadableType r15 = new ReadableType("ByteArray", 8);
        ByteArray = r15;
        ReadableType r14 = new ReadableType("PiperData", 9);
        PiperData = r14;
        ReadableType r12 = new ReadableType("LynxObject", 10);
        LynxObject = r12;
        $VALUES = new ReadableType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
    }

    public static ReadableType[] values() {
        return (ReadableType[]) $VALUES.clone();
    }

    public static ReadableType valueOf(String r1) {
        return (ReadableType) a.a(ReadableType.class, r1);
    }

    private ReadableType(String r1, int r2) {
        super(r1, r2);
    }
}
