package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.livesdk.message.model.fh;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s implements com.bytedance.android.live.broadcastgame.c0<r>, vlc.l {
    public com.bytedance.android.live.broadcastgame.b0 a;
    public final vlc.d b;

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void release() {
        this.b.removeMessageListener(this);
    }

    public s(vlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        this.b = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void a(com.bytedance.android.live.broadcastgame.b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "queue");
        this.a = r2;
        this.b.addMessageListener(MessageType.OPEN_GAME_DIAMOND_PAY_MESSAGE.getIntType(), this);
    }

    public final void onMessage(tlc.d r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        if ((r6 instanceof fh) == false) goto L8;
        com.bytedance.android.live.broadcastgame.b0 r0 = this.a;
        if (r0 == null) goto L9;
        fh r7 = (fh) r6;
        r0.insert(new r(r7.appId, r7.startId, r7.diamonds));
        return;
    L9:
        return;
    }
}
