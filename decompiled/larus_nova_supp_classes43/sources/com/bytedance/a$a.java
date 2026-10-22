package com.bytedance;

import com.bytedance.flow_audio.api.foundation.player.AudioPlayerStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public /* synthetic */ class a$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AudioPlayerStatus.values().length];
        r0[AudioPlayerStatus.Stopped.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r0[AudioPlayerStatus.Paused.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        a = r0;
    }
}
