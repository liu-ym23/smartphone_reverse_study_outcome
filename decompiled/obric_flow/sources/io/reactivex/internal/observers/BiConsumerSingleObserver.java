package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.b0;

/* JADX INFO: loaded from: classes3.dex */
public final class BiConsumerSingleObserver<T> extends AtomicReference<Disposable> implements b0, Disposable {
    private static final long serialVersionUID = 4943102778943297569L;
    final pt.b onCallback;

    public BiConsumerSingleObserver(pt.b r5) {
        this.onCallback = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        lazySet(DisposableHelper.DISPOSED);     // Catch: Throwable -> L4
        this.onCallback.accept(null, r5);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(new CompositeException(new Throwable[]{r5, th}));
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }

    @Override // mt.b0, mt.j
    public void onSuccess(T r5) {
        lazySet(DisposableHelper.DISPOSED);     // Catch: Throwable -> L4
        this.onCallback.accept(r5, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
    }
}
