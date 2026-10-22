package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
interface i<T> {
    void complete();

    void error(Throwable r10);

    void next(T r10);

    void replay(FlowableReplay$InnerSubscription<T> r10);
}
