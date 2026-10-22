package com.bytedance.android.live.recharge;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0<T> implements Consumer {
    public final /* synthetic */ a0 a;

    public d0(a0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        com.bytedance.android.live.recharge.platform.model.f r3 = (com.bytedance.android.live.recharge.platform.model.f) r2;
        this.a.P.a(r3);
        this.a.H.onNext(r3);
    }
}
