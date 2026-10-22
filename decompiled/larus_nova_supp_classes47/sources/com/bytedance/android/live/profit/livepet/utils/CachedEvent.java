package com.bytedance.android.live.profit.livepet.utils;

import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.o;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class CachedEvent<T> {
    public final ArrayDeque<T> a;
    public final PublishSubject<T> b;
    public final String c;
    public final int d;

    public CachedEvent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.d = 10;
        this.a = new ArrayDeque();
        int r0 = o.a;
        this.b = PublishSubject.create();
        this.c = "LivePet/CachedEvent/".concat(r2);
    }

    public final Observable<T> a(final boolean r2) {
        l r0 = l.a;
        final Function0<Observable<T>> r1 = new CachedEvent$observe$1(this, r2);
        return Observable.defer(new a(r1));
    }

    public final void b(T r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
    L4:
        if (this.a.size() < this.d) goto L6;
        this.a.removeFirst();
        goto L4
    L6:
        this.a.add(r3);
        this.b.onNext(r3);
    }
}
