package com.larus.bmhome.clarification;

import com.larus.audio.audiov3.task.asr.AsrLifeState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public /* synthetic */ class ClarificationComponent$c$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AsrLifeState.values().length];
        r0[AsrLifeState.ASR_RESULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r0[AsrLifeState.ASR_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        a = r0;
    }
}
