package com.bytedance.android.live.recharge.order;

import io.reactivex.functions.Consumer;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ f a;
    public final /* synthetic */ f.b b;

    public h(f r1, f.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Order.State r3 = (Order.State) r2;
        Set<f.b> r4 = this.a.b;
        HashSet r5 = (HashSet) r4;
        r5.remove(this.b);
    }
}
