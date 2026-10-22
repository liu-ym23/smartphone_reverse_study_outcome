package com.bytedance.android.live.liveinteract.revenue.game;

import com.bytedance.android.livesdk.chatroom.model.interact.k0;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ LinkMicGameWidget a;

    public f(LinkMicGameWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
        if (r4 == null) goto L13;
        k1 r5 = (k1) r4.data;
        if (r5 == null) goto L14;
        p2 r6 = r5.getLinkmicPlayModeInfo();
        if (r6 == null) goto L15;
        k0 r7 = r6.getLinkMicGameInfo();
        if (r7 == null) goto L16;
        LinkMicGameWidget r0 = this.a;
        int r1 = LinkMicGameWidget.w;
        r0.zq(r7, "getPlayModeInfo");
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }
}
