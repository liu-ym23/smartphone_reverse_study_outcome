package com.bytedance.android.live.profit.livepet.container;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ e a;

    public j(e r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        k r0 = this.a.d;
        r0.d = ((Integer) r2).intValue();
        e r3 = this.a;
        e.a(r3, r3.d);
    }
}
