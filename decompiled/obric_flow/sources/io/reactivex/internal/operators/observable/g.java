package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.n f17784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f17785b;

    public g(mt.n r5, Object r10) {
        this.f17784a = r5;
        this.f17785b = r10;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Object r5 = this.f17785b;
        f r10 = new f();
        r10.f17775b = NotificationLite.next(r5);
        this.f17784a.subscribe(r10);
        return new e(r10);
    }
}
