package com.bytedance.android.live.profit.livepet.container;

import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ e a;

    public i(e r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Pair r4 = (Pair) r3;
        n r0 = this.a.c;
        r0.a = ((Number) r4.getFirst()).intValue();
        n r1 = this.a.c;
        r1.b = ((Number) r4.getSecond()).intValue();
        e r5 = this.a;
        e.a(r5, r5.c);
        e r6 = this.a;
        e.a(r6, r6.d);
    }
}
