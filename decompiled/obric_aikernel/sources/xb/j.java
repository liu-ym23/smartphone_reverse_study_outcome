package xb;

/* JADX INFO: loaded from: classes2.dex */
public interface j<T> {
    void onComplete();

    void onError(Throwable r10);

    void onSubscribe(io.reactivex.disposables.b r10);

    void onSuccess(T r10);
}
