package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p0<T> implements Consumer {
    public final /* synthetic */ q0 a;

    public p0(q0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        LiveGiftMenuStickerServiceWidget r4 = this.a.a;
        r4.g = null;
        LiveGiftMenuStickerServiceWidget.wq(r4);
    }
}
