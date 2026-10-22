package com.mammon.audiosdk.enums;

import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum SAMICoreAudioFormat extends Enum<SAMICoreAudioFormat> {
    private static final /* synthetic */ SAMICoreAudioFormat[] $VALUES = null;
    public static final SAMICoreAudioFormat AAC = null;
    public static final SAMICoreAudioFormat OPUS = null;
    public static final SAMICoreAudioFormat PCM = null;
    public static final SAMICoreAudioFormat WAV = null;
    public static final HashMap<Integer, SAMICoreAudioFormat> intToEnumMap = null;
    private int value;

    static {
        int r2 = 0;
        SAMICoreAudioFormat r0 = new SAMICoreAudioFormat("PCM", 0, 0);
        PCM = r0;
        SAMICoreAudioFormat r1 = new SAMICoreAudioFormat("WAV", 1, 1);
        WAV = r1;
        SAMICoreAudioFormat r3 = new SAMICoreAudioFormat("AAC", 2, 2);
        AAC = r3;
        SAMICoreAudioFormat r5 = new SAMICoreAudioFormat("OPUS", 3, 3);
        OPUS = r5;
        $VALUES = new SAMICoreAudioFormat[]{r0, r1, r3, r5};
        intToEnumMap = new HashMap();
        SAMICoreAudioFormat[] r4 = values();
        int r6 = r4.length;
    L3:
        if (r2 >= r6) goto L5;
        SAMICoreAudioFormat r7 = r4[r2];
        intToEnumMap.put(Integer.valueOf(r7.getValue()), r7);
        r2 = r2 + 1;
        goto L3
    }

    public static SAMICoreAudioFormat[] values() {
        return (SAMICoreAudioFormat[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreAudioFormat fromInt(int r1) {
        return intToEnumMap.get(Integer.valueOf(r1));
    }

    public static SAMICoreAudioFormat valueOf(String r1) {
        return (SAMICoreAudioFormat) a.a(SAMICoreAudioFormat.class, r1);
    }

    private SAMICoreAudioFormat(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
