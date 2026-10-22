package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.r;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
final class SingleCreate$Emitter<T> extends AtomicReference<b> implements b {
    private static final long serialVersionUID = -2467358622224974244L;
    final r<? super T> downstream;

    SingleCreate$Emitter(r<? super T> r10) {
        this.downstream = r10;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public void onError(Throwable r10) {
        if (tryOnError(r10) == true) goto L6;
        dc.a.n(r10);
        return;
    }

    public void onSuccess(T r10) {
        b r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 == r12) goto L15;
        b r13 = getAndSet(r12);
        if (r13 == r12) goto L18;
        if (r10 != null) goto L8;
        this.downstream.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));     // Catch: Throwable -> L11
    L9:
        if (r13 == null) goto L19;
        r13.dispose();
        return;
    L19:
        return;
    L8:
        this.downstream.onSuccess(r10);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (r13 == null) goto L14;
        r13.dispose();
    L14:
        throw th;
    L18:
        return;
    }

    public void setCancellable(f r10) {
        setDisposable(new CancellableDisposable(r10));
    }

    public void setDisposable(b r10) {
        DisposableHelper.set(this, r10);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return String.format("%s{%s}", new Object[]{SingleCreate$Emitter.class.getSimpleName(), super.toString()});
    }

    public boolean tryOnError(Throwable r10) {
        if (r10 != null) goto L4;
        r10 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L4:
        b r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 == r12) goto L17;
        b r13 = getAndSet(r12);
        if (r13 == r12) goto L22;
        this.downstream.onError(r10);     // Catch: Throwable -> L13
        if (r13 == null) goto L21;
        r13.dispose();
        return true;
    L21:
        return true;
    L13:
        th = move-exception;
        if (r13 == null) goto L16;
        r13.dispose();
    L16:
        throw th;
    L22:
        return false;
    L17:
        return false;
    }
}
