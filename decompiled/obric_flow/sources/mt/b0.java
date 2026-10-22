package mt;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public interface b0 {
    void onError(Throwable r5);

    void onSubscribe(Disposable r5);

    void onSuccess(Object r5);
}
