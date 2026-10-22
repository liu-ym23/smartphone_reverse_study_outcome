package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q1<T> implements Consumer {
    public final /* synthetic */ PlayerShadowWidget a;

    public q1(PlayerShadowWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        com.bytedance.android.livesdk.chatroom.progress.context.a r3 = (com.bytedance.android.livesdk.chatroom.progress.context.a) r2;
        PlayerShadowWidget.wq(this.a, true);
    }
}
