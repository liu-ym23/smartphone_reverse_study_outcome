package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableDebounceTimed$DebounceEmitter<T> extends AtomicReference<io.reactivex.disposables.b> implements Runnable, io.reactivex.disposables.b {
    private static final long serialVersionUID = 6812032969491025141L;
    final long idx;
    final AtomicBoolean once;
    final FlowableDebounceTimed$DebounceTimedSubscriber<T> parent;
    final T value;

    FlowableDebounceTimed$DebounceEmitter(T r10, long r11, FlowableDebounceTimed$DebounceTimedSubscriber<T> r12) {
        this.once = new AtomicBoolean();
        this.value = r10;
        this.idx = r11;
        this.parent = r12;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    void emit() {
        if (this.once.compareAndSet(false, true) == false) goto L6;
        this.parent.emit(this.idx, this.value, this);
        return;
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
        emit();
    }

    public void setResource(io.reactivex.disposables.b r10) {
        DisposableHelper.replace(this, r10);
    }
}
