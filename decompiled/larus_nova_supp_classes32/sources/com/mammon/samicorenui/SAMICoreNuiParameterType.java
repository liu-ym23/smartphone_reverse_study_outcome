package com.mammon.samicorenui;

import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum SAMICoreNuiParameterType extends Enum<SAMICoreNuiParameterType> {
    public static final SAMICoreNuiParameterType AEC_BIT_DEPTH = null;
    public static final SAMICoreNuiParameterType AEC_CHANNEL = null;
    public static final SAMICoreNuiParameterType AEC_DEBUG = null;
    public static final SAMICoreNuiParameterType AEC_ENABLE = null;
    public static final SAMICoreNuiParameterType AEC_MODEL = null;
    public static final SAMICoreNuiParameterType AEC_SAMPLE_RATE = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_BIT_DEPTH = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_CHANNEL = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_DEBUG = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_ENABLE = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_ENABLE_PUNCTUATION = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_EOS_SILENCE_TIMEOUT = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_LANG = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_SAMPLE_RATE = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_SOS_SILENCE_TIMEOUT = null;
    public static final SAMICoreNuiParameterType AUDIO_MIC_AUDIO_SOURCE = null;
    public static final SAMICoreNuiParameterType AUDIO_MIC_BIT_DEPTH = null;
    public static final SAMICoreNuiParameterType AUDIO_MIC_CHANNEL = null;
    public static final SAMICoreNuiParameterType AUDIO_MIC_DEBUG = null;
    public static final SAMICoreNuiParameterType AUDIO_MIC_ENABLE = null;
    public static final SAMICoreNuiParameterType AUDIO_MIC_SAMPLE_RATE = null;
    public static final SAMICoreNuiParameterType AUDIO_PLAYER_BIT_DEPTH = null;
    public static final SAMICoreNuiParameterType AUDIO_PLAYER_CHANNEL = null;
    public static final SAMICoreNuiParameterType AUDIO_PLAYER_DEBUG = null;
    public static final SAMICoreNuiParameterType AUDIO_PLAYER_ENABLE = null;
    public static final SAMICoreNuiParameterType AUDIO_PLAYER_SAMPLE_RATE = null;
    public static final SAMICoreNuiParameterType AUDIO_PLAYER_STREAM = null;
    public static final SAMICoreNuiParameterType COMMON_APPKEY = null;
    public static final SAMICoreNuiParameterType COMMON_DEBUG_PATH = null;
    public static final SAMICoreNuiParameterType COMMON_LOG_LEVEL = null;
    public static final SAMICoreNuiParameterType COMMON_TOKEN = null;
    public static final SAMICoreNuiParameterType COMMON_URL = null;
    public static final SAMICoreNuiParameterType DENOISE_DEBUG = null;
    public static final SAMICoreNuiParameterType DENOISE_ENABLE = null;
    public static final SAMICoreNuiParameterType DEVICE_TYPE = null;
    public static final SAMICoreNuiParameterType KWS_BIT_DEPTH = null;
    public static final SAMICoreNuiParameterType KWS_CHANNEL = null;
    public static final SAMICoreNuiParameterType KWS_DEBUG = null;
    public static final SAMICoreNuiParameterType KWS_ENABLE = null;
    public static final SAMICoreNuiParameterType KWS_KEY_WORDS = null;
    public static final SAMICoreNuiParameterType KWS_MODEL = null;
    public static final SAMICoreNuiParameterType KWS_MODEL_TYPE = null;
    public static final SAMICoreNuiParameterType KWS_SAMPLE_RATE = null;
    public static final SAMICoreNuiParameterType KWS_THRESHOLD = null;
    public static final SAMICoreNuiParameterType KWS_WAKEUP_MODE = null;
    public static final SAMICoreNuiParameterType NLU_DEBUG = null;
    public static final SAMICoreNuiParameterType NLU_ENABLE = null;
    public static final SAMICoreNuiParameterType TTS_ONLINE_DEBUG = null;
    public static final SAMICoreNuiParameterType TTS_ONLINE_ENABLE = null;
    public static final SAMICoreNuiParameterType TTS_ONLINE_FORMAT = null;
    public static final SAMICoreNuiParameterType TTS_ONLINE_PITCH_RATE = null;
    public static final SAMICoreNuiParameterType TTS_ONLINE_SAMPLE_RATE = null;
    public static final SAMICoreNuiParameterType TTS_ONLINE_SPEAKER = null;
    public static final SAMICoreNuiParameterType TTS_ONLINE_SPEECH_RATE = null;
    public static final SAMICoreNuiParameterType VAD_DEBUG = null;
    public static final SAMICoreNuiParameterType VAD_ENABLE = null;
    public static final /* synthetic */ SAMICoreNuiParameterType[] a = null;
    public static final HashMap<Integer, SAMICoreNuiParameterType> intToEnumMap = null;
    private int value;

    static {
        SAMICoreNuiParameterType r0 = new SAMICoreNuiParameterType("DEVICE_TYPE", 0, 0);
        DEVICE_TYPE = r0;
        SAMICoreNuiParameterType r1 = new SAMICoreNuiParameterType("COMMON_LOG_LEVEL", 1, 10000);
        COMMON_LOG_LEVEL = r1;
        SAMICoreNuiParameterType r3 = new SAMICoreNuiParameterType("COMMON_DEBUG_PATH", 2, 10001);
        COMMON_DEBUG_PATH = r3;
        SAMICoreNuiParameterType r4 = new SAMICoreNuiParameterType("COMMON_URL", 3, 10002);
        COMMON_URL = r4;
        SAMICoreNuiParameterType r6 = new SAMICoreNuiParameterType("COMMON_APPKEY", 4, 10003);
        COMMON_APPKEY = r6;
        SAMICoreNuiParameterType r8 = new SAMICoreNuiParameterType("COMMON_TOKEN", 5, 10004);
        COMMON_TOKEN = r8;
        SAMICoreNuiParameterType r10 = new SAMICoreNuiParameterType("AUDIO_MIC_ENABLE", 6, 10100);
        AUDIO_MIC_ENABLE = r10;
        SAMICoreNuiParameterType r12 = new SAMICoreNuiParameterType("AUDIO_MIC_AUDIO_SOURCE", 7, 10101);
        AUDIO_MIC_AUDIO_SOURCE = r12;
        SAMICoreNuiParameterType r14 = new SAMICoreNuiParameterType("AUDIO_MIC_SAMPLE_RATE", 8, 10102);
        AUDIO_MIC_SAMPLE_RATE = r14;
        SAMICoreNuiParameterType r13 = new SAMICoreNuiParameterType("AUDIO_MIC_CHANNEL", 9, 10103);
        AUDIO_MIC_CHANNEL = r13;
        SAMICoreNuiParameterType r11 = new SAMICoreNuiParameterType("AUDIO_MIC_BIT_DEPTH", 10, 10104);
        AUDIO_MIC_BIT_DEPTH = r11;
        SAMICoreNuiParameterType r9 = new SAMICoreNuiParameterType("AUDIO_MIC_DEBUG", 11, 10105);
        AUDIO_MIC_DEBUG = r9;
        SAMICoreNuiParameterType r7 = new SAMICoreNuiParameterType("AUDIO_PLAYER_ENABLE", 12, 10200);
        AUDIO_PLAYER_ENABLE = r7;
        SAMICoreNuiParameterType r5 = new SAMICoreNuiParameterType("AUDIO_PLAYER_STREAM", 13, 10201);
        AUDIO_PLAYER_STREAM = r5;
        SAMICoreNuiParameterType r2 = new SAMICoreNuiParameterType("AUDIO_PLAYER_SAMPLE_RATE", 14, 10202);
        AUDIO_PLAYER_SAMPLE_RATE = r2;
        SAMICoreNuiParameterType r15 = new SAMICoreNuiParameterType("AUDIO_PLAYER_CHANNEL", 15, 10203);
        AUDIO_PLAYER_CHANNEL = r15;
        SAMICoreNuiParameterType r16 = new SAMICoreNuiParameterType("AUDIO_PLAYER_BIT_DEPTH", 16, 10204);
        AUDIO_PLAYER_BIT_DEPTH = r16;
        SAMICoreNuiParameterType r17 = new SAMICoreNuiParameterType("AUDIO_PLAYER_DEBUG", 17, 10205);
        AUDIO_PLAYER_DEBUG = r17;
        SAMICoreNuiParameterType r18 = new SAMICoreNuiParameterType("DENOISE_ENABLE", 18, 10300);
        DENOISE_ENABLE = r18;
        SAMICoreNuiParameterType r19 = new SAMICoreNuiParameterType("DENOISE_DEBUG", 19, 10301);
        DENOISE_DEBUG = r19;
        SAMICoreNuiParameterType r20 = new SAMICoreNuiParameterType("VAD_ENABLE", 20, 10400);
        VAD_ENABLE = r20;
        SAMICoreNuiParameterType r21 = new SAMICoreNuiParameterType("VAD_DEBUG", 21, 10401);
        VAD_DEBUG = r21;
        SAMICoreNuiParameterType r22 = new SAMICoreNuiParameterType("AEC_ENABLE", 22, 10500);
        AEC_ENABLE = r22;
        SAMICoreNuiParameterType r23 = new SAMICoreNuiParameterType("AEC_MODEL", 23, 10501);
        AEC_MODEL = r23;
        SAMICoreNuiParameterType r24 = new SAMICoreNuiParameterType("AEC_SAMPLE_RATE", 24, 10502);
        AEC_SAMPLE_RATE = r24;
        SAMICoreNuiParameterType r25 = new SAMICoreNuiParameterType("AEC_CHANNEL", 25, 10503);
        AEC_CHANNEL = r25;
        SAMICoreNuiParameterType r26 = new SAMICoreNuiParameterType("AEC_BIT_DEPTH", 26, 10504);
        AEC_BIT_DEPTH = r26;
        SAMICoreNuiParameterType r27 = new SAMICoreNuiParameterType("AEC_DEBUG", 27, 10505);
        AEC_DEBUG = r27;
        SAMICoreNuiParameterType r28 = new SAMICoreNuiParameterType("KWS_ENABLE", 28, 10600);
        KWS_ENABLE = r28;
        SAMICoreNuiParameterType r29 = new SAMICoreNuiParameterType("KWS_WAKEUP_MODE", 29, 10601);
        KWS_WAKEUP_MODE = r29;
        SAMICoreNuiParameterType r30 = new SAMICoreNuiParameterType("KWS_MODEL", 30, 10602);
        KWS_MODEL = r30;
        SAMICoreNuiParameterType r31 = new SAMICoreNuiParameterType("KWS_MODEL_TYPE", 31, 10603);
        KWS_MODEL_TYPE = r31;
        SAMICoreNuiParameterType r32 = new SAMICoreNuiParameterType("KWS_KEY_WORDS", 32, 10604);
        KWS_KEY_WORDS = r32;
        SAMICoreNuiParameterType r33 = new SAMICoreNuiParameterType("KWS_SAMPLE_RATE", 33, 10605);
        KWS_SAMPLE_RATE = r33;
        SAMICoreNuiParameterType r34 = new SAMICoreNuiParameterType("KWS_CHANNEL", 34, 10606);
        KWS_CHANNEL = r34;
        SAMICoreNuiParameterType r35 = new SAMICoreNuiParameterType("KWS_BIT_DEPTH", 35, 10607);
        KWS_BIT_DEPTH = r35;
        SAMICoreNuiParameterType r36 = new SAMICoreNuiParameterType("KWS_THRESHOLD", 36, 10608);
        KWS_THRESHOLD = r36;
        SAMICoreNuiParameterType r37 = new SAMICoreNuiParameterType("KWS_DEBUG", 37, 10609);
        KWS_DEBUG = r37;
        SAMICoreNuiParameterType r38 = new SAMICoreNuiParameterType("ASR_ONLINE_ENABLE", 38, 10700);
        ASR_ONLINE_ENABLE = r38;
        SAMICoreNuiParameterType r39 = new SAMICoreNuiParameterType("ASR_ONLINE_SAMPLE_RATE", 39, 10701);
        ASR_ONLINE_SAMPLE_RATE = r39;
        SAMICoreNuiParameterType r40 = new SAMICoreNuiParameterType("ASR_ONLINE_CHANNEL", 40, 10702);
        ASR_ONLINE_CHANNEL = r40;
        SAMICoreNuiParameterType r41 = new SAMICoreNuiParameterType("ASR_ONLINE_BIT_DEPTH", 41, 10703);
        ASR_ONLINE_BIT_DEPTH = r41;
        SAMICoreNuiParameterType r42 = new SAMICoreNuiParameterType("ASR_ONLINE_SOS_SILENCE_TIMEOUT", 42, 10704);
        ASR_ONLINE_SOS_SILENCE_TIMEOUT = r42;
        SAMICoreNuiParameterType r43 = new SAMICoreNuiParameterType("ASR_ONLINE_EOS_SILENCE_TIMEOUT", 43, 10705);
        ASR_ONLINE_EOS_SILENCE_TIMEOUT = r43;
        SAMICoreNuiParameterType r44 = new SAMICoreNuiParameterType("ASR_ONLINE_ENABLE_PUNCTUATION", 44, 10706);
        ASR_ONLINE_ENABLE_PUNCTUATION = r44;
        SAMICoreNuiParameterType r45 = new SAMICoreNuiParameterType("ASR_ONLINE_LANG", 45, 10707);
        ASR_ONLINE_LANG = r45;
        SAMICoreNuiParameterType r46 = new SAMICoreNuiParameterType("ASR_ONLINE_DEBUG", 46, 10708);
        ASR_ONLINE_DEBUG = r46;
        SAMICoreNuiParameterType r47 = new SAMICoreNuiParameterType("TTS_ONLINE_ENABLE", 47, 10800);
        TTS_ONLINE_ENABLE = r47;
        SAMICoreNuiParameterType r48 = new SAMICoreNuiParameterType("TTS_ONLINE_SPEAKER", 48, 10801);
        TTS_ONLINE_SPEAKER = r48;
        SAMICoreNuiParameterType r49 = new SAMICoreNuiParameterType("TTS_ONLINE_SAMPLE_RATE", 49, 10802);
        TTS_ONLINE_SAMPLE_RATE = r49;
        SAMICoreNuiParameterType r50 = new SAMICoreNuiParameterType("TTS_ONLINE_FORMAT", 50, 10803);
        TTS_ONLINE_FORMAT = r50;
        SAMICoreNuiParameterType r51 = new SAMICoreNuiParameterType("TTS_ONLINE_SPEECH_RATE", 51, 10804);
        TTS_ONLINE_SPEECH_RATE = r51;
        SAMICoreNuiParameterType r52 = new SAMICoreNuiParameterType("TTS_ONLINE_PITCH_RATE", 52, 10805);
        TTS_ONLINE_PITCH_RATE = r52;
        SAMICoreNuiParameterType r53 = new SAMICoreNuiParameterType("TTS_ONLINE_DEBUG", 53, 10806);
        TTS_ONLINE_DEBUG = r53;
        SAMICoreNuiParameterType r54 = new SAMICoreNuiParameterType("NLU_ENABLE", 54, 10900);
        NLU_ENABLE = r54;
        SAMICoreNuiParameterType r55 = new SAMICoreNuiParameterType("NLU_DEBUG", 55, 10901);
        NLU_DEBUG = r55;
        a = new SAMICoreNuiParameterType[]{r0, r1, r3, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r2, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55};
        intToEnumMap = new HashMap();
        SAMICoreNuiParameterType[] r56 = values();
        int r57 = r56.length;
        int r58 = 0;
    L3:
        if (r58 >= r57) goto L5;
        SAMICoreNuiParameterType r59 = r56[r58];
        intToEnumMap.put(Integer.valueOf(r59.getValue()), r59);
        r58 = r58 + 1;
        goto L3
    }

    public static SAMICoreNuiParameterType[] values() {
        return (SAMICoreNuiParameterType[]) a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreNuiParameterType fromInt(int r1) {
        return intToEnumMap.get(Integer.valueOf(r1));
    }

    public static SAMICoreNuiParameterType valueOf(String r1) {
        return (SAMICoreNuiParameterType) a.a(SAMICoreNuiParameterType.class, r1);
    }

    public SAMICoreNuiParameterType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
