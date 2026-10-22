package io.reactivex;

/* JADX INFO: loaded from: classes6.dex */
public interface t<T> {
    void onComplete();

    void onError(Throwable r1);

    void onNext(T r1);

    void onSubscribe(io.reactivex.disposables.b r1);
}
