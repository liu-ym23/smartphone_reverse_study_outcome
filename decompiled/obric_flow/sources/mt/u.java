package mt;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public interface u {
    void onComplete();

    void onError(Throwable r5);

    void onNext(Object r5);

    void onSubscribe(Disposable r5);
}
