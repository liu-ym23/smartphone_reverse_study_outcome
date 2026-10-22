package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import com.bytedance.android.live.profit.miniplay.SupportLiveScene;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static GameCastStrategy a(boolean r1, DataCenter r2) {
        GameCastStrategy r0 = GameCastStrategy.NONE;
        if (r1 == false) goto L18;
        if (r2 == null) goto L21;
        int r3 = com.bytedance.android.live.broadcastgame.api.interactgame.j.a();
        if (r3 == SupportLiveScene.VIDEO_SINGLE_BROADCAST.getValue()) goto L17;
        if (r3 == SupportLiveScene.VIDEO_EQUAL_CHAT_ROOM.getValue()) goto L17;
        if (r3 == SupportLiveScene.VIDEO_LINK_ROOM.getValue()) goto L17;
        if (r3 == SupportLiveScene.VIDEO_CHAT_ROOM.getValue()) goto L20;
        return r0;
    L20:
        return GameCastStrategy.VIDEO_CHATROOM;
    L17:
        return GameCastStrategy.VIDEO_SINGLE;
    L21:
        return r0;
    L18:
        return r0;
    }
}
