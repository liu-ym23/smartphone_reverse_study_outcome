package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r1<T> implements Consumer {
    public final /* synthetic */ PlayerShadowWidget a;

    public r1(PlayerShadowWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        String r3 = (String) r2;
        PlayerShadowWidget.wq(this.a, false);
    }
}
