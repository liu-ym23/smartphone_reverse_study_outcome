package com.bytedance.android.live.liveinteract.revenue.game;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ LinkMicGameWidget a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Runnable c;

    public m(LinkMicGameWidget r1, int r2, n r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        LinkMicGameWidget.wq(this.a, this.b, ((com.bytedance.android.livesdk.chatroom.viewmodel.k) r4).b, this.c);
    }
}
