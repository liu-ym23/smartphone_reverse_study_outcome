package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableDebounceTimed$DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
    private static final long serialVersionUID = 6812032969491025141L;
    final long idx;
    final AtomicBoolean once;
    final o0 parent;
    final T value;

    public ObservableDebounceTimed$DebounceEmitter(T r5, long r10, o0 r11) {
        this.once = new AtomicBoolean();
        this.value = r5;
        this.idx = r10;
        this.parent = r11;
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

    @Override // java.lang.Runnable
    public void run() {
        if (this.once.compareAndSet(false, true) == false) goto L8;
        o0 r5 = this.parent;
        long r10 = this.idx;
        T r11 = this.value;
        if (r10 != r5.g) goto L9;
        r5.f17887a.onNext(r11);
        dispose();
        return;
    L9:
        return;
    }

    public void setResource(Disposable r5) {
        DisposableHelper.replace(this, r5);
    }
}
