package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.preonline;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[MicSeatScene.values().length];
        a = r0;
        MicSeatScene r1 = MicSeatScene.AUDIO_LINK;
        r0[r1.ordinal()] = 1;
        MicSeatScene r2 = MicSeatScene.AUDIO_LINK_LARGE;
        r0[r2.ordinal()] = 2;
        r0[MicSeatScene.AUDIO_LINK_STAGE_ENLARGE.ordinal()] = 3;
        int[] r3 = new int[MicSeatScene.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
    }
}
