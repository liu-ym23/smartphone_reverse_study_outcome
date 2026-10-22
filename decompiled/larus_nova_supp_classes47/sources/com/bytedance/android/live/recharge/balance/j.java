package com.bytedance.android.live.recharge.balance;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ f a;

    public j(f r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Disposable r4 = (Disposable) r3;
        Iterator<T> r5 = CollectionsKt.toList(g.a).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((g.a) r5.next()).d(this.a);
        goto L4
    }
}
