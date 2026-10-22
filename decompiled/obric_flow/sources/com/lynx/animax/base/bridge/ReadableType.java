package com.lynx.animax.base.bridge;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
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
        ReadableType r5 = new ReadableType("Null", 0);
        Null = r5;
        ReadableType r10 = new ReadableType("Boolean", 1);
        Boolean = r10;
        ReadableType r11 = new ReadableType("Int", 2);
        Int = r11;
        ReadableType r12 = new ReadableType("Number", 3);
        Number = r12;
        ReadableType r13 = new ReadableType("String", 4);
        String = r13;
        ReadableType r14 = new ReadableType("Map", 5);
        Map = r14;
        ReadableType r15 = new ReadableType("Array", 6);
        Array = r15;
        ReadableType r16 = new ReadableType("Long", 7);
        Long = r16;
        ReadableType r17 = new ReadableType("ByteArray", 8);
        ByteArray = r17;
        ReadableType r18 = new ReadableType("PiperData", 9);
        PiperData = r18;
        ReadableType r19 = new ReadableType("LynxObject", 10);
        LynxObject = r19;
        $VALUES = new ReadableType[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
    }

    private ReadableType(String r5, int r10) {
        super(r5, r10);
    }

    public static ReadableType valueOf(String r5) {
        return (ReadableType) Enum.valueOf(ReadableType.class, r5);
    }

    public static ReadableType[] values() {
        return (ReadableType[]) $VALUES.clone();
    }
}
