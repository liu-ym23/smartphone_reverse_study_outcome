package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k extends Completable {
    public final Completable a;
    public final CompletableSource b;

    public final void subscribeActual(io.reactivex.b r4) {
        this.a.subscribe(new r(this.b, r4));
    }

    public k(Completable r1, CompletableSource r2) {
        this.a = r1;
        this.b = r2;
    }
}
