package com.obric.assistant.component.clicktalk;

import com.obric.assistant.ability.audio.ExitClickSpeakerType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class ChatClickTalkComponent$d {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ExitClickSpeakerType.values().length];
        r0[ExitClickSpeakerType.ASR_END.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
    L19:
        r0[ExitClickSpeakerType.SEND_MESSAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
    L27:
        r0[ExitClickSpeakerType.RESTART.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
    L21:
        r0[ExitClickSpeakerType.MANUAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
    L23:
        r0[ExitClickSpeakerType.TIMEOUT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
    L17:
        r0[ExitClickSpeakerType.DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
    L9:
        a = r0;
    }
}
