package com.larus.audio.flow.client.kmp_com;

import com.bytedance.flow_audio.api.service.KmpTtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsLifeState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public /* synthetic */ class FlowTtsClientKmpManagerDelegate$b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[TtsLifeState.values().length];
        r0[TtsLifeState.TTS_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
    L59:
        r0[TtsLifeState.TTS_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
    L65:
        r0[TtsLifeState.TTS_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
    L45:
        r0[TtsLifeState.TTS_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
    L10:
        a = r0;
        int[] r1 = new int[KmpTtsEventEnum.values().length];
        r1[KmpTtsEventEnum.TTS_TASK_FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
    L61:
        r1[KmpTtsEventEnum.TTS_SESSION_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
    L39:
        r1[KmpTtsEventEnum.TTS_NETWORK_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
    L47:
        r1[KmpTtsEventEnum.TTS_END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
    L55:
        r1[KmpTtsEventEnum.TTS_FIRST_PACKAGE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
    L63:
        r1[KmpTtsEventEnum.TTS_START.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
    L43:
        r1[KmpTtsEventEnum.CHAT_RESPONSE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L34
    L57:
        r1[KmpTtsEventEnum.TTS_SENTENCE_START.ordinal()] = 8;     // Catch: NoSuchFieldError -> L35
    L67:
        r1[KmpTtsEventEnum.TTS_SENTENCE_END.ordinal()] = 9;     // Catch: NoSuchFieldError -> L36
    L41:
        r1[KmpTtsEventEnum.TTS_SESSION_STARTED.ordinal()] = 10;     // Catch: NoSuchFieldError -> L37
    L49:
        r1[KmpTtsEventEnum.TTS_UNKNOWN_EVENT.ordinal()] = 11;     // Catch: NoSuchFieldError -> L38
    L22:
        b = r1;
    }
}
