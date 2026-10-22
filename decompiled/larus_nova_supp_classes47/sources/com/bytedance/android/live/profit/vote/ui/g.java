package com.bytedance.android.live.profit.vote.ui;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ VoteViewModel a;
    public final /* synthetic */ com.bytedance.android.live.profit.vote.model.b b;

    public g(VoteViewModel r1, com.bytedance.android.live.profit.vote.model.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        this.a.d.a(new com.bytedance.android.live.profit.vote.model.b.e(((com.bytedance.android.live.profit.vote.model.b.a) this.b).a));
    }
}
