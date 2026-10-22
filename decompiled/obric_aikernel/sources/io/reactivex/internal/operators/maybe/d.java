package io.reactivex.internal.operators.maybe;

import bc.f;

/* JADX INFO: loaded from: classes2.dex */
interface d<T> extends f<T> {
    int consumerIndex();

    void drop();

    T peek();

    @Override // java.util.Queue, io.reactivex.internal.operators.maybe.d, bc.f
    T poll();

    int producerIndex();
}
