package com.larus.audio.ttsV2;

import com.larus.audio.audiov3.task.tts.TtsState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public /* synthetic */ class TtsClientManager$c {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[TtsState.values().length];
        r0[TtsState.TTS_STARTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r0[TtsState.TTS_STOPPED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        a = r0;
    }
}
