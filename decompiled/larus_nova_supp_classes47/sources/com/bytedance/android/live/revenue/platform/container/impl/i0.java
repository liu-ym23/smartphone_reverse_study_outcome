package com.bytedance.android.live.revenue.platform.container.impl;

import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i0 implements com.bytedance.platform.aio.channel.b.a {
    public final /* synthetic */ CompositeDisposable a;

    public final void b(boolean r1) {
    }

    public final void a() {
        this.a.dispose();
    }

    public i0(CompositeDisposable r1) {
        this.a = r1;
    }
}
