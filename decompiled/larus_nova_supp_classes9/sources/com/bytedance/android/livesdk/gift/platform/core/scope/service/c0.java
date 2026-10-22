package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ String b;

    public c0(d0 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        String r5 = this.b;
        if (r5 == null) goto L5;
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(com.bytedance.android.live.core.utils.s1.getContext(), r5);
    L5:
        this.a.c();
    }
}
