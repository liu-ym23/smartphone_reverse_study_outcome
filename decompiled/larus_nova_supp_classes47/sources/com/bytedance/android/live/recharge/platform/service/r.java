package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;

    public final void onStart() {
        RxUtilKt.c(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).O3(fx0.o.a), this.a);
        RxUtilKt.c(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).O3(cd1.a.a), this.a);
    }

    public final void onStop() {
        this.a.clear();
    }

    public r() {
        this.a = new CompositeDisposable();
    }
}
