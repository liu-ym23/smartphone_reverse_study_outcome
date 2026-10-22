package com.bytedance.android.live.recharge.platform.service;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q implements com.bytedance.android.scope.o {
    public Disposable a;

    public final void onStart() {
        this.a = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).O3(fx0.n.a);
    }

    public final void onStop() {
        this.a.dispose();
    }

    public q() {
        this.a = Disposables.disposed();
    }
}
