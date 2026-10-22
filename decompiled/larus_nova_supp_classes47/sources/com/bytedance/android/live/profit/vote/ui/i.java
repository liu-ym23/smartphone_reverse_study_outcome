package com.bytedance.android.live.profit.vote.ui;

import com.bytedance.android.live.profit.vote.VoteState;
import com.bytedance.revenue.platform.api.core.rx.n;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ com.bytedance.android.live.profit.vote.model.c a;
    public final /* synthetic */ VoteViewModel.b b;

    public i(com.bytedance.android.live.profit.vote.model.c r1, VoteViewModel.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        VoteViewModel r0 = this.b.a;
        com.bytedance.android.live.profit.vote.model.c r1 = this.a;
        int r2 = VoteViewModel.i;
        r0.getClass();
        int r5 = f.a[((VoteState) r4).ordinal()];
        if (r5 != 1) goto L5;
    L10:
        n<com.bytedance.android.live.profit.vote.model.b> r6 = r0.d;
        com.bytedance.android.live.profit.vote.model.b r3 = (com.bytedance.android.live.profit.vote.model.b) r6.d;
        if ((r3 instanceof com.bytedance.android.live.profit.vote.model.b.d) == false) goto L13;
        r6.a(new com.bytedance.android.live.profit.vote.model.b.d(r1, ((com.bytedance.android.live.profit.vote.model.b.d) r3).b));
        return;
    L13:
        int r7 = com.bytedance.revenue.platform.api.core.rx.c.a;
        r6.a(new com.bytedance.android.live.profit.vote.model.b.d(r1, BehaviorSubject.create()));
        return;
    L5:
        if (r5 == 2) goto L10;
        if (r5 != 3) goto L17;
        r0.d.a(new com.bytedance.android.live.profit.vote.model.b.C0056b(r1));
        return;
    }
}
