package com.bytedance.android.live.recharge;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b0<T> implements Consumer {
    public final /* synthetic */ a0 a;

    public b0(a0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        this.a.n.a(r3);
        this.a.F.onNext(r3);
    }
}
