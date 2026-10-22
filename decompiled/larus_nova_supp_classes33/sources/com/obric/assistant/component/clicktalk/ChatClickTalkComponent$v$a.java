package com.obric.assistant.component.clicktalk;

import com.larus.audio.audiov3.task.asr.AsrLifeState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class ChatClickTalkComponent$v$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AsrLifeState.values().length];
        r0[AsrLifeState.ASR_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r0[AsrLifeState.ASR_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        a = r0;
    }
}
