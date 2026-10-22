package com.mammon.samicorenui;

import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum SAMICoreNuiDirectiveType extends Enum<SAMICoreNuiDirectiveType> {
    public static final SAMICoreNuiDirectiveType DIRECTIVE_CANCEL_CURRENT_DIALOG = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_FINISH_TALKING = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_PLAYING_DECISION = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_PLAY_SSML_TTS = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_PLAY_TTS = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_START_ENGINE = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_STOP_ENGINE = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_SYNC_STOP_ENGINE = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_BOE_ASR = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_LONG_ASR_START = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_LONG_ASR_STOP = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_ONLINE_ASR = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_SET_AEC_MODEL_PATH = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_SET_ENABLE_Punctuation = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_SET_WAKEUP_TEST_AUDIO_FILE = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_SET_WAKEUP_THRESHOLD = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_SET_WAKEUP_TTS_THRESHOLD = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_USE_LOCAL_AUDIO_FILE = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_WAKEUP = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TRIGGER_WAKEUP = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TRIGGER_WAKEUP_FOR_TTS = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_USE_KWS_MODE = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_USE_MODE1 = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_USE_MODE2 = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_USE_WAKEUP_MODE = null;
    public static final /* synthetic */ SAMICoreNuiDirectiveType[] a = null;
    public static final HashMap<Integer, SAMICoreNuiDirectiveType> intToEnumMap = null;
    private int value;

    static {
        SAMICoreNuiDirectiveType r0 = new SAMICoreNuiDirectiveType("DIRECTIVE_START_ENGINE", 0, 0);
        DIRECTIVE_START_ENGINE = r0;
        SAMICoreNuiDirectiveType r1 = new SAMICoreNuiDirectiveType("DIRECTIVE_STOP_ENGINE", 1, 1);
        DIRECTIVE_STOP_ENGINE = r1;
        SAMICoreNuiDirectiveType r3 = new SAMICoreNuiDirectiveType("DIRECTIVE_SYNC_STOP_ENGINE", 2, 2);
        DIRECTIVE_SYNC_STOP_ENGINE = r3;
        SAMICoreNuiDirectiveType r5 = new SAMICoreNuiDirectiveType("DIRECTIVE_PLAYING_DECISION", 3, 3);
        DIRECTIVE_PLAYING_DECISION = r5;
        SAMICoreNuiDirectiveType r7 = new SAMICoreNuiDirectiveType("DIRECTIVE_TRIGGER_WAKEUP", 4, 4);
        DIRECTIVE_TRIGGER_WAKEUP = r7;
        SAMICoreNuiDirectiveType r9 = new SAMICoreNuiDirectiveType("DIRECTIVE_CANCEL_CURRENT_DIALOG", 5, 5);
        DIRECTIVE_CANCEL_CURRENT_DIALOG = r9;
        SAMICoreNuiDirectiveType r11 = new SAMICoreNuiDirectiveType("DIRECTIVE_FINISH_TALKING", 6, 6);
        DIRECTIVE_FINISH_TALKING = r11;
        SAMICoreNuiDirectiveType r13 = new SAMICoreNuiDirectiveType("DIRECTIVE_TRIGGER_WAKEUP_FOR_TTS", 7, 7);
        DIRECTIVE_TRIGGER_WAKEUP_FOR_TTS = r13;
        SAMICoreNuiDirectiveType r15 = new SAMICoreNuiDirectiveType("DIRECTIVE_PLAY_TTS", 8, 8);
        DIRECTIVE_PLAY_TTS = r15;
        SAMICoreNuiDirectiveType r14 = new SAMICoreNuiDirectiveType("DIRECTIVE_PLAY_SSML_TTS", 9, 9);
        DIRECTIVE_PLAY_SSML_TTS = r14;
        SAMICoreNuiDirectiveType r12 = new SAMICoreNuiDirectiveType("DIRECTIVE_USE_MODE1", 10, 10);
        DIRECTIVE_USE_MODE1 = r12;
        SAMICoreNuiDirectiveType r10 = new SAMICoreNuiDirectiveType("DIRECTIVE_USE_MODE2", 11, 11);
        DIRECTIVE_USE_MODE2 = r10;
        SAMICoreNuiDirectiveType r8 = new SAMICoreNuiDirectiveType("DIRECTIVE_USE_WAKEUP_MODE", 12, 12);
        DIRECTIVE_USE_WAKEUP_MODE = r8;
        SAMICoreNuiDirectiveType r6 = new SAMICoreNuiDirectiveType("DIRECTIVE_USE_KWS_MODE", 13, 13);
        DIRECTIVE_USE_KWS_MODE = r6;
        SAMICoreNuiDirectiveType r4 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_WAKEUP", 14, 14);
        DIRECTIVE_TEST_WAKEUP = r4;
        SAMICoreNuiDirectiveType r2 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_USE_LOCAL_AUDIO_FILE", 15, 15);
        DIRECTIVE_TEST_USE_LOCAL_AUDIO_FILE = r2;
        SAMICoreNuiDirectiveType r16 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_LONG_ASR_START", 16, 16);
        DIRECTIVE_TEST_LONG_ASR_START = r16;
        SAMICoreNuiDirectiveType r17 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_LONG_ASR_STOP", 17, 17);
        DIRECTIVE_TEST_LONG_ASR_STOP = r17;
        SAMICoreNuiDirectiveType r18 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_BOE_ASR", 18, 18);
        DIRECTIVE_TEST_BOE_ASR = r18;
        SAMICoreNuiDirectiveType r19 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_ONLINE_ASR", 19, 19);
        DIRECTIVE_TEST_ONLINE_ASR = r19;
        SAMICoreNuiDirectiveType r20 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_SET_WAKEUP_THRESHOLD", 20, 20);
        DIRECTIVE_TEST_SET_WAKEUP_THRESHOLD = r20;
        SAMICoreNuiDirectiveType r21 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_SET_WAKEUP_TTS_THRESHOLD", 21, 21);
        DIRECTIVE_TEST_SET_WAKEUP_TTS_THRESHOLD = r21;
        SAMICoreNuiDirectiveType r22 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_SET_AEC_MODEL_PATH", 22, 22);
        DIRECTIVE_TEST_SET_AEC_MODEL_PATH = r22;
        SAMICoreNuiDirectiveType r23 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_SET_ENABLE_Punctuation", 23, 23);
        DIRECTIVE_TEST_SET_ENABLE_Punctuation = r23;
        SAMICoreNuiDirectiveType r24 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_SET_WAKEUP_TEST_AUDIO_FILE", 24, 24);
        DIRECTIVE_TEST_SET_WAKEUP_TEST_AUDIO_FILE = r24;
        a = new SAMICoreNuiDirectiveType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24};
        intToEnumMap = new HashMap();
        SAMICoreNuiDirectiveType[] r25 = values();
        int r26 = r25.length;
        int r27 = 0;
    L3:
        if (r27 >= r26) goto L5;
        SAMICoreNuiDirectiveType r28 = r25[r27];
        intToEnumMap.put(Integer.valueOf(r28.getValue()), r28);
        r27 = r27 + 1;
        goto L3
    }

    public static SAMICoreNuiDirectiveType[] values() {
        return (SAMICoreNuiDirectiveType[]) a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreNuiDirectiveType fromInt(int r1) {
        return intToEnumMap.get(Integer.valueOf(r1));
    }

    public static SAMICoreNuiDirectiveType valueOf(String r1) {
        return (SAMICoreNuiDirectiveType) a.a(SAMICoreNuiDirectiveType.class, r1);
    }

    public SAMICoreNuiDirectiveType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
