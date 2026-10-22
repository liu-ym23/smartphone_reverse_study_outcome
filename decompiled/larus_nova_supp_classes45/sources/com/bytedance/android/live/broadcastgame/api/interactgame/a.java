package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveMode.values().length];
        a = r0;
        r0[LiveMode.VIDEO.ordinal()] = 1;
        r0[LiveMode.AUDIO.ordinal()] = 2;
        r0[LiveMode.SCREEN_RECORD.ordinal()] = 3;
        r0[LiveMode.THIRD_PARTY.ordinal()] = 4;
    }
}
