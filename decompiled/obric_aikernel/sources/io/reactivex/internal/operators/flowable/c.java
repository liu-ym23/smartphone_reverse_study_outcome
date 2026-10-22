package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
interface c<T> {
    void innerComplete();

    void innerError(Throwable r10);

    void innerNext(T r10);
}
