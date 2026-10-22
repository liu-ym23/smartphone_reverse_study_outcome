package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.livesdk.message.model.ih;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k0 implements com.bytedance.android.live.broadcastgame.c0<j0>, vlc.l {
    public com.bytedance.android.live.broadcastgame.b0 a;
    public final vlc.d b;

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void release() {
        this.b.removeMessageListener(this);
    }

    public k0(vlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        this.b = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void a(com.bytedance.android.live.broadcastgame.b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "queue");
        this.a = r2;
        this.b.addMessageListener(MessageType.OPEN_GAME_PERFORMANCE_FINISH_MESSAGE.getIntType(), this);
    }

    public final void onMessage(tlc.d r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        if ((r4 instanceof ih) == false) goto L8;
        com.bytedance.android.live.broadcastgame.b0 r0 = this.a;
        if (r0 == null) goto L9;
        ih r5 = (ih) r4;
        String r2 = r5.taskId;
        r0.insert(new j0(r5.appId, r2));
        return;
    L9:
        return;
    }
}
