package com.bytedance.android.live.liveinteract.revenue.paid.profilecard;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ PaidProfileCardControlWidget a;

    public a(PaidProfileCardControlWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        this.a.n7();
    }
}
