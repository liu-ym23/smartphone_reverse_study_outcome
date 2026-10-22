package com.obric.assistant.component;

import com.larus.audio.audiov3.task.asr.AsrLifeState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class ObricIntercomComponent$c0$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AsrLifeState.values().length];
        r0[AsrLifeState.ASR_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r0[AsrLifeState.ASR_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r0[AsrLifeState.ASR_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r0[AsrLifeState.ASR_RESULT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        a = r0;
    }
}
