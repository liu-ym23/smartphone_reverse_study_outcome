package com.bytedance.android.live.profit.privilege.service;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements o {
    public final CompositeDisposable a;

    public final void onStart() {
        RxUtilKt.c(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).O3(wu0.b.a), this.a);
    }

    public final void onStop() {
        this.a.clear();
    }

    public a() {
        this.a = new CompositeDisposable();
    }
}
