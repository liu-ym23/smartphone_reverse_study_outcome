package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableBufferBoundary$BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<Disposable> implements mt.u, Disposable {
    private static final long serialVersionUID = -8498650778633225126L;
    final long index;
    final ObservableBufferBoundary$BufferBoundaryObserver<T, C, ?, ?> parent;

    public ObservableBufferBoundary$BufferCloseObserver(ObservableBufferBoundary$BufferBoundaryObserver<T, C, ?, ?> r5, long r10) {
        this.parent = r5;
        this.index = r10;
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

    @Override // mt.u
    public void onComplete() {
        Disposable r5 = get();
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (r5 == r10) goto L6;
        lazySet(r10);
        this.parent.close(this, this.index);
        return;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        Disposable r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 == r11) goto L5;
        lazySet(r11);
        this.parent.boundaryError(this, r5);
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // mt.u
    public void onNext(Object r5) {
        Disposable r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 == r11) goto L6;
        lazySet(r11);
        r10.dispose();
        this.parent.close(this, this.index);
        return;
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }
}
