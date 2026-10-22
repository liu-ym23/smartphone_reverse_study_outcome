package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes2.dex */
interface g<T> {
    void complete();

    void error(Throwable r10);

    void next(T r10);

    void replay(ObservableReplay$InnerDisposable<T> r10);
}
