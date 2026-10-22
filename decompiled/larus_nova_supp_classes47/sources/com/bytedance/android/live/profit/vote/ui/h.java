package com.bytedance.android.live.profit.vote.ui;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ VoteViewModel a;

    public h(VoteViewModel r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        this.a.d.a(com.bytedance.android.live.profit.vote.model.b.c.a);
    }
}
