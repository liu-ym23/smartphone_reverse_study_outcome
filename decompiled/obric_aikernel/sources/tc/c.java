package tc;

/* JADX INFO: loaded from: classes3.dex */
public interface c<T> {
    void onComplete();

    void onError(Throwable r10);

    void onNext(T r10);

    void onSubscribe(d r10);
}
