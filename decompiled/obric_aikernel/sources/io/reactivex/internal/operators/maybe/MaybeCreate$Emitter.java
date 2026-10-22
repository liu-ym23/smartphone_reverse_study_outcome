package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.i;
import xb.j;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeCreate$Emitter<T> extends AtomicReference<io.reactivex.disposables.b> implements i<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -2467358622224974244L;
    final j<? super T> downstream;

    MaybeCreate$Emitter(j<? super T> r10) {
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

    public void onComplete() {
        io.reactivex.disposables.b r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 == r11) goto L13;
        io.reactivex.disposables.b r12 = getAndSet(r11);
        if (r12 == r11) goto L16;
        this.downstream.onComplete();     // Catch: Throwable -> L9
        if (r12 == null) goto L17;
        r12.dispose();
        return;
    L17:
        return;
    L9:
        th = move-exception;
        if (r12 == null) goto L12;
        r12.dispose();
    L12:
        throw th;
    L16:
        return;
    }

    public void onError(Throwable r10) {
        if (tryOnError(r10) == true) goto L6;
        dc.a.n(r10);
        return;
    }

    @Override // xb.i
    public void onSuccess(T r10) {
        io.reactivex.disposables.b r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 == r12) goto L15;
        io.reactivex.disposables.b r13 = getAndSet(r12);
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

    public void setDisposable(io.reactivex.disposables.b r10) {
        DisposableHelper.set(this, r10);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return String.format("%s{%s}", new Object[]{MaybeCreate$Emitter.class.getSimpleName(), super.toString()});
    }

    public boolean tryOnError(Throwable r10) {
        if (r10 != null) goto L4;
        r10 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L4:
        io.reactivex.disposables.b r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 == r12) goto L17;
        io.reactivex.disposables.b r13 = getAndSet(r12);
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
