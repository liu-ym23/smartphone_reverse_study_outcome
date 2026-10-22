package com.bytedance.android.live.recharge;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.ReplaySubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g0<T> implements Consumer {
    public final /* synthetic */ a0 a;

    public g0(a0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ReplaySubject r0 = this.a.I;
        r0.onError((Throwable) r2);
    }
}
