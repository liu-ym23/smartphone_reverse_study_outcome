package io.reactivex;

/* JADX INFO: loaded from: classes6.dex */
public interface m<T> {
    void onComplete();

    void onError(Throwable r1);

    void onSubscribe(io.reactivex.disposables.b r1);

    void onSuccess(T r1);
}
