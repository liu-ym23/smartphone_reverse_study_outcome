package com.obric.assistant.state.impl.multitask.consumer;

import com.obric.assistant.state.api.v2.core.AssistantAliveReason;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class ObricTaskFlowPowerResolver$c {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AssistantAliveReason.values().length];
        r0[AssistantAliveReason.SELF_UPDATE_DOWNLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
    L31:
        r0[AssistantAliveReason.SEND_MSG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
    L47:
        r0[AssistantAliveReason.WAKEUP_IN_PROGRESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
    L35:
        r0[AssistantAliveReason.ALARM_TTS_IN_PROGRESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
    L39:
        r0[AssistantAliveReason.COMPLEX_TASK_IN_PROGRESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
    L27:
        r0[AssistantAliveReason.MSG_TTS_IN_PROGRESS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
    L41:
        r0[AssistantAliveReason.AIGC_GENERATION_IN_PROGRESS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
    L43:
        r0[AssistantAliveReason.REALTIME_CALL_IN_PROGRESS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
    L33:
        r0[AssistantAliveReason.CLICK_TALK_IN_PROGRESS.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
    L37:
        r0[AssistantAliveReason.GLOBAL_AUDIO_IN_PROGRESS.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
    L29:
        r0[AssistantAliveReason.AI_NOTE_IN_PROGRESS.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
    L14:
        a = r0;
    }
}
