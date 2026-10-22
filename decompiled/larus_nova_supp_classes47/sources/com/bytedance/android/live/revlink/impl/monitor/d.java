package com.bytedance.android.live.revlink.impl.monitor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ RevLinkStallReporter a;
    public final /* synthetic */ String b;

    public d(RevLinkStallReporter r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        this.a.f(this.b, 0);
        this.a.e();
    }
}
