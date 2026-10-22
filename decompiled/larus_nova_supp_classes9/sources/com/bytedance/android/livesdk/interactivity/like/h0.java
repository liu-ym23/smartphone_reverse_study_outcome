package com.bytedance.android.livesdk.interactivity.like;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h0<T> implements Consumer {
    public final /* synthetic */ DiggWidget a;

    public h0(DiggWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        DiggWidget.zq(this.a);
    }
}
