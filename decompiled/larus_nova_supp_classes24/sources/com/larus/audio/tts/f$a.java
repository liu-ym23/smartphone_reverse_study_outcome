package com.larus.audio.tts;

import com.larus.audio.audiov3.tts.PlayStateEnum;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public /* synthetic */ class f$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[PlayStateEnum.values().length];
        r0[PlayStateEnum.PLAY_STATE_PREPARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[PlayStateEnum.PLAY_STATE_STOPPED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[PlayStateEnum.PLAY_STATE_FAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}
