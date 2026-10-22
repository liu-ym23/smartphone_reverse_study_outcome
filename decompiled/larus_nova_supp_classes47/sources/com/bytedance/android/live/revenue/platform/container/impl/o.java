package com.bytedance.android.live.revenue.platform.container.impl;

import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ p.a a;

    public o(p.a r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ObservableEmitter r0 = this.a.b;
        r0.onError((Throwable) r2);
    }
}
