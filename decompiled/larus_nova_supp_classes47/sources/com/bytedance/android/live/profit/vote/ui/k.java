package com.bytedance.android.live.profit.vote.ui;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ VoteViewModel a;
    public final /* synthetic */ com.bytedance.android.live.profit.vote.model.b.d b;
    public final /* synthetic */ com.bytedance.android.live.profit.vote.b c;

    public k(VoteViewModel r1, com.bytedance.android.live.profit.vote.model.b.d r2, com.bytedance.android.live.profit.vote.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        this.b.b.onNext(r7);
        long r0 = VoteViewModel.h;
        if (r7 == null) goto L9;
        if (r7.longValue() != r0) goto L9;
        this.a.d.a(new com.bytedance.android.live.profit.vote.model.b.a(this.c));
        return;
    L9:
        if (r7.longValue() > 0) goto L13;
        this.a.d.a(new com.bytedance.android.live.profit.vote.model.b.e(this.c));
        return;
    }
}
