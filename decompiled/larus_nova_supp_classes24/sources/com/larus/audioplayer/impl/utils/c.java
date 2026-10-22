package com.larus.audioplayer.impl.utils;

import com.larus.audioplayer.api.stream.StreamPlayerStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[StreamPlayerStatus.values().length];
        r0[StreamPlayerStatus.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[StreamPlayerStatus.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[StreamPlayerStatus.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}
