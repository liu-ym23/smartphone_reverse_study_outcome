package com.bytedance.android.live.revenue.platform.container.impl;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ p.a a;

    public n(p.a r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.b.onNext(r2);
    }
}
