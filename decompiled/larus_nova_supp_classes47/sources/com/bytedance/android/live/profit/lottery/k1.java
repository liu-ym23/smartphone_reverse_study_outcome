package com.bytedance.android.live.profit.lottery;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k1<T> implements Consumer {
    public final /* synthetic */ Disposable a;
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g b;

    public k1(Disposable r1, com.bytedance.android.live.revenue.common.g r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        k3 r3 = (k3) r2;
        this.a.dispose();
        this.b.a("stopped due to state change");
    }
}
