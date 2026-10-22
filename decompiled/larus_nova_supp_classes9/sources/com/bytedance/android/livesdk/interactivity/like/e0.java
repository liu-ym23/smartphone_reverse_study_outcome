package com.bytedance.android.livesdk.interactivity.like;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e0<T> implements Consumer {
    public final /* synthetic */ DiggWidget a;

    public e0(DiggWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        this.a.S.e(cc2.g.b.c, ((zg1.e0) r3).a);
    }
}
