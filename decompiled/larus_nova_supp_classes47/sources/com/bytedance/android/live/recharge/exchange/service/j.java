package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;

    public final void onStart() {
        RxUtilKt.c(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).O3(hw0.c.a), this.a);
    }

    public final void onStop() {
        this.a.clear();
    }

    public j() {
        this.a = new CompositeDisposable();
    }
}
