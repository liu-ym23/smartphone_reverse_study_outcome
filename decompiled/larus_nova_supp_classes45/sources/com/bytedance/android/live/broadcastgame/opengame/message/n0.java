package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.livesdk.message.model.hh;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n0 implements com.bytedance.android.live.broadcastgame.c0<m0>, vlc.l {
    public com.bytedance.android.live.broadcastgame.b0 a;
    public final vlc.d b;

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void release() {
        this.b.removeMessageListener(this);
    }

    public n0(vlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        this.b = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void a(com.bytedance.android.live.broadcastgame.b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "queue");
        this.a = r2;
        this.b.addMessageListener(MessageType.OPEN_GAME_OPEN_REWARD_MESSAGE.getIntType(), this);
    }

    public final void onMessage(tlc.d r11) {
        Intrinsics.checkNotNullParameter(r11, "message");
        if ((r11 instanceof hh) == false) goto L8;
        com.bytedance.android.live.broadcastgame.b0 r0 = this.a;
        if (r0 == null) goto L9;
        hh r12 = (hh) r11;
        r0.insert(new m0(r12.appId, r12.startId, r12.rewardId, r12.rewardCount, r12.rewardDiamonds, r12.rewardName));
        return;
    L9:
        return;
    }
}
