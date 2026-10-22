package io.reactivex.internal.operators.observable;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.n f17717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17718b;

    public b(mt.n r5, int r10) {
        this.f17717a = r5;
        this.f17718b = r10;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        BlockingObservableIterable$BlockingObservableIterator r5 = new BlockingObservableIterable$BlockingObservableIterator(this.f17718b);
        this.f17717a.subscribe(r5);
        return r5;
    }
}
