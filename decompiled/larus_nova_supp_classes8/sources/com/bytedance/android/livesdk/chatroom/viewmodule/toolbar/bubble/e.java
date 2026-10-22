package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ BubbleController a;

    public e(BubbleController r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        g.b r3 = (g.b) r2;
        r3.i();
        this.a.e.a().f(r3);
    }
}
