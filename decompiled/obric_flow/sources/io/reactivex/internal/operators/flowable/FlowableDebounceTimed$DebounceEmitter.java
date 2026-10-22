package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableDebounceTimed$DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
    private static final long serialVersionUID = 6812032969491025141L;
    final long idx;
    final AtomicBoolean once;
    final FlowableDebounceTimed$DebounceTimedSubscriber<T> parent;
    final T value;

    public FlowableDebounceTimed$DebounceEmitter(T r5, long r10, FlowableDebounceTimed$DebounceTimedSubscriber<T> r11) {
        this.once = new AtomicBoolean();
        this.value = r5;
        this.idx = r10;
        this.parent = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void emit() {
        if (this.once.compareAndSet(false, true) == false) goto L6;
        this.parent.emit(this.idx, this.value, this);
        return;
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
        emit();
    }

    public void setResource(Disposable r5) {
        DisposableHelper.replace(this, r5);
    }
}
