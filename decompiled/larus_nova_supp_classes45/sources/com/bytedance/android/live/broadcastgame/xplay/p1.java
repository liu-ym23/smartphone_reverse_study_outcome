package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class p1 {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[XplayScene.values().length];
        a = r0;
        r0[XplayScene.Video.ordinal()] = 1;
        r0[XplayScene.TalkRoom.ordinal()] = 2;
        r0[XplayScene.RevenueLink.ordinal()] = 3;
        int[] r1 = new int[ToolbarButton.values().length];
        b = r1;
        r1[ToolbarButton.PK.ordinal()] = 1;
        r1[ToolbarButton.INTERACTION.ordinal()] = 2;
    }
}
