package com.bytedance.android.live.revlink.impl.multianchor.utils;

import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i {
    public final CompositeDisposable a;
    public final long b;
    public final ld.a c;
    public final com.bytedance.android.livesdk.revenue.service.room.c d;
    public final com.bytedance.android.live.revlink.impl.global.c e;

    public static final class a {
    }

    static {
    }

    public i(ld.a r1, com.bytedance.android.livesdk.revenue.service.room.c r2, com.bytedance.android.live.revlink.impl.global.c r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.a = new CompositeDisposable();
        i97.a r4 = i97.a.a;
        this.b = System.currentTimeMillis();
    }
}
