package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.base.LayerBackgroundStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[LayerBackgroundStatus.values().length];
        a = r0;
        r0[LayerBackgroundStatus.Audio.ordinal()] = 1;
        r0[LayerBackgroundStatus.Leave.ordinal()] = 2;
        int[] r1 = new int[MicSeatScene.values().length];
        b = r1;
        MicSeatScene r2 = MicSeatScene.AUDIO_LINK_LARGE;
        r1[r2.ordinal()] = 1;
        MicSeatScene r4 = MicSeatScene.AUDIO_LINK_C_POSITION;
        r1[r4.ordinal()] = 2;
        MicSeatScene r5 = MicSeatScene.AUDIO_LINK_HAMLET_AVATAR;
        r1[r5.ordinal()] = 3;
        MicSeatScene r6 = MicSeatScene.AUDIO_LINK_STAGE_ENLARGE;
        r1[r6.ordinal()] = 4;
        int[] r3 = new int[MicSeatScene.values().length];
        c = r3;
        r3[r2.ordinal()] = 1;
        r3[r4.ordinal()] = 2;
        r3[r5.ordinal()] = 3;
        r3[r6.ordinal()] = 4;
    }
}
