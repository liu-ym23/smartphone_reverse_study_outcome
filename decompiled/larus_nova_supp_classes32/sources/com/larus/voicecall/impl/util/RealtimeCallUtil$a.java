package com.larus.voicecall.impl.util;

import com.larus.im.service.audio.AudioSessionType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public /* synthetic */ class RealtimeCallUtil$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AudioSessionType.values().length];
        r0[AudioSessionType.MMT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r0[AudioSessionType.RTC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        a = r0;
    }
}
