package xb;

/* JADX INFO: loaded from: classes2.dex */
public interface o<T> {
    void onComplete();

    void onError(Throwable r10);

    void onNext(T r10);

    void onSubscribe(io.reactivex.disposables.b r10);
}
