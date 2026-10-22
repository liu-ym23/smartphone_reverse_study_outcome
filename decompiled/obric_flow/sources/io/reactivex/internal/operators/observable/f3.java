package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public interface f3 {
    void complete();

    void error(Throwable r5);

    void next(Object r5);

    void replay(ObservableReplay$InnerDisposable r5);
}
