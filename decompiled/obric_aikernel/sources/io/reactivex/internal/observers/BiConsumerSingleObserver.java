package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.r;

/* JADX INFO: loaded from: classes2.dex */
public final class BiConsumerSingleObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements r<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 4943102778943297569L;
    final zb.b<? super T, ? super Throwable> onCallback;

    public BiConsumerSingleObserver(zb.b<? super T, ? super Throwable> r10) {
        this.onCallback = r10;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // xb.r
    public void onError(Throwable r10) {
        lazySet(DisposableHelper.DISPOSED);     // Catch: Throwable -> L4
        this.onCallback.accept(null, r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(new CompositeException(new Throwable[]{r10, th}));
    }

    @Override // xb.r
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // xb.r
    public void onSuccess(T r10) {
        lazySet(DisposableHelper.DISPOSED);     // Catch: Throwable -> L4
        this.onCallback.accept(r10, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
    }
}
