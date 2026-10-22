package com.larus.audio.tts.notification;

import com.larus.audio.audiov3.audio.player.AudioPlayerState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public /* synthetic */ class c$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AudioPlayerState.values().length];
        r0[AudioPlayerState.STARTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[AudioPlayerState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[AudioPlayerState.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}
