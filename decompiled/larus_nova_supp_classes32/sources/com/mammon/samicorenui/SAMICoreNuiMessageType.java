package com.mammon.samicorenui;

import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum SAMICoreNuiMessageType extends Enum<SAMICoreNuiMessageType> {
    public static final SAMICoreNuiMessageType MESSAGE_TYPE_ASR_BEGIN = null;
    public static final SAMICoreNuiMessageType MESSAGE_TYPE_ASR_FINAL_RESULT = null;
    public static final SAMICoreNuiMessageType MESSAGE_TYPE_ASR_PARTIAL_RESULT = null;
    public static final SAMICoreNuiMessageType MESSAGE_TYPE_NLP_RESULT = null;
    public static final SAMICoreNuiMessageType MESSAGE_TYPE_TTS_AUDIO_DATA = null;
    public static final SAMICoreNuiMessageType MESSAGE_TYPE_TTS_BEGIN = null;
    public static final SAMICoreNuiMessageType MESSAGE_TYPE_TTS_END = null;
    public static final SAMICoreNuiMessageType MESSAGE_TYPE_WAKEUP_RESULT = null;
    public static final /* synthetic */ SAMICoreNuiMessageType[] a = null;
    public static final HashMap<Integer, SAMICoreNuiMessageType> intToEnumMap = null;
    private int value;

    static {
        int r2 = 0;
        SAMICoreNuiMessageType r0 = new SAMICoreNuiMessageType("MESSAGE_TYPE_WAKEUP_RESULT", 0, 0);
        MESSAGE_TYPE_WAKEUP_RESULT = r0;
        SAMICoreNuiMessageType r1 = new SAMICoreNuiMessageType("MESSAGE_TYPE_ASR_BEGIN", 1, 1);
        MESSAGE_TYPE_ASR_BEGIN = r1;
        SAMICoreNuiMessageType r3 = new SAMICoreNuiMessageType("MESSAGE_TYPE_ASR_PARTIAL_RESULT", 2, 2);
        MESSAGE_TYPE_ASR_PARTIAL_RESULT = r3;
        SAMICoreNuiMessageType r5 = new SAMICoreNuiMessageType("MESSAGE_TYPE_ASR_FINAL_RESULT", 3, 3);
        MESSAGE_TYPE_ASR_FINAL_RESULT = r5;
        SAMICoreNuiMessageType r7 = new SAMICoreNuiMessageType("MESSAGE_TYPE_TTS_BEGIN", 4, 4);
        MESSAGE_TYPE_TTS_BEGIN = r7;
        SAMICoreNuiMessageType r9 = new SAMICoreNuiMessageType("MESSAGE_TYPE_TTS_AUDIO_DATA", 5, 5);
        MESSAGE_TYPE_TTS_AUDIO_DATA = r9;
        SAMICoreNuiMessageType r11 = new SAMICoreNuiMessageType("MESSAGE_TYPE_TTS_END", 6, 6);
        MESSAGE_TYPE_TTS_END = r11;
        SAMICoreNuiMessageType r13 = new SAMICoreNuiMessageType("MESSAGE_TYPE_NLP_RESULT", 7, 7);
        MESSAGE_TYPE_NLP_RESULT = r13;
        a = new SAMICoreNuiMessageType[]{r0, r1, r3, r5, r7, r9, r11, r13};
        intToEnumMap = new HashMap();
        SAMICoreNuiMessageType[] r4 = values();
        int r6 = r4.length;
    L3:
        if (r2 >= r6) goto L5;
        SAMICoreNuiMessageType r8 = r4[r2];
        intToEnumMap.put(Integer.valueOf(r8.getValue()), r8);
        r2 = r2 + 1;
        goto L3
    }

    public static SAMICoreNuiMessageType[] values() {
        return (SAMICoreNuiMessageType[]) a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreNuiMessageType fromInt(int r1) {
        return intToEnumMap.get(Integer.valueOf(r1));
    }

    public static SAMICoreNuiMessageType valueOf(String r1) {
        return (SAMICoreNuiMessageType) a.a(SAMICoreNuiMessageType.class, r1);
    }

    public SAMICoreNuiMessageType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
