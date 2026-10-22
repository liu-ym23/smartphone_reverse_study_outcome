package com.bytedance.android.live.recharge;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e0<T> implements Consumer {
    public final /* synthetic */ a0 a;

    public e0(a0 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        this.a.H.onNext(new com.bytedance.android.live.recharge.platform.model.f(0));
        this.a.P.a(new com.bytedance.android.live.recharge.platform.model.f(0));
    }
}
