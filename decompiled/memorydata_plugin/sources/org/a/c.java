package org.a;

/* JADX INFO: loaded from: classes6.dex */
public interface c<T> {
    void onComplete();

    void onError(Throwable r1);

    void onNext(T r1);

    void onSubscribe(d r1);
}
