package com.bytedance.android.live.liveinteract.revenue.common.vieweffect;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[MicSeatScene.values().length];
        a = r0;
        MicSeatScene r1 = MicSeatScene.AUDIO_LINK_ANCHOR;
        r0[r1.ordinal()] = 1;
        MicSeatScene r2 = MicSeatScene.AUDIO_LINK_C_POSITION;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[MicSeatScene.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[MicSeatScene.AUDIO_LINK_C_POSITION_V2.ordinal()] = 3;
        r3[MicSeatScene.VIDEO_LINK_EQUAL.ordinal()] = 4;
        r3[MicSeatScene.AUDIO_LINK_LARGE.ordinal()] = 5;
        r3[MicSeatScene.AUDIO_LINK.ordinal()] = 6;
        r3[MicSeatScene.VIDEO_LINK.ordinal()] = 7;
    }
}
