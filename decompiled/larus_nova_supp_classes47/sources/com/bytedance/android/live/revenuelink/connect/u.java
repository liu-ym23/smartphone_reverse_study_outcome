package com.bytedance.android.live.revenuelink.connect;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ LinkOutManager.e a;

    public u(LinkOutManager.e r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        LinkOutManager.e r4 = this.a;
        j r0 = r4.a.f;
        if (r0 == null) goto L6;
        r0.Q4(r4.d);
        return;
    }
}
