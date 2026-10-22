package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableDebounceTimed$DebounceEmitter<T> extends AtomicReference<io.reactivex.disposables.b> implements Runnable, io.reactivex.disposables.b {
    private static final long serialVersionUID = 6812032969491025141L;
    final long idx;
    final AtomicBoolean once;
    final c<T> parent;
    final T value;

    ObservableDebounceTimed$DebounceEmitter(T r10, long r11, c<T> r12) {
        this.once = new AtomicBoolean();
        this.value = r10;
        this.idx = r11;
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

    @Override // java.lang.Runnable
    public void run() {
        if (this.once.compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        throw null;
    }

    public void setResource(io.reactivex.disposables.b r10) {
        DisposableHelper.replace(this, r10);
    }
}
