package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.broadcastgame.channel.receiver.helper.ImAlignHelper;
import com.bytedance.android.live.broadcastgame.opengame.message.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class BaseAnchorMessageReceiver<T extends k> implements com.bytedance.android.live.broadcastgame.c0<T>, vlc.l {
    public com.bytedance.android.live.broadcastgame.b0 a;
    public final Lazy b;
    public final vlc.d c;

    public abstract int b();

    public abstract Long c(tlc.d r1);

    public abstract boolean d(tlc.d r1);

    public abstract a e(tlc.d r1);

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void release() {
        this.c.removeMessageListener(this);
    }

    public BaseAnchorMessageReceiver(vlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        this.c = r2;
        this.b = LazyKt.lazy(new BaseAnchorMessageReceiver$imAlignHelper$2(this));
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void a(com.bytedance.android.live.broadcastgame.b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "queue");
        this.a = r2;
        this.c.addMessageListener(b(), this);
    }

    public final void onMessage(tlc.d r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        ImAlignHelper r0 = (ImAlignHelper) this.b.getValue();
        boolean r2 = d(r6);
        Long r3 = c(r6);
        if (r3 == null) goto L5;
        long r4 = r3.longValue();
    L6:
        r0.a(new b0(r2, r4, r6));
        return;
    L5:
        r4 = 0;
        goto L6
    }
}
