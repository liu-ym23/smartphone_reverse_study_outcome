package mt;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public interface j {
    void onComplete();

    void onError(Throwable r5);

    void onSubscribe(Disposable r5);

    void onSuccess(Object r5);
}
