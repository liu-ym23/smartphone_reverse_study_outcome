package com.bytedance.android.live.recharge.balance;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ f a;

    public l(f r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        Iterator<T> r0 = CollectionsKt.toList(g.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g.a) r0.next()).e(this.a, r5);
        goto L4
    }
}
