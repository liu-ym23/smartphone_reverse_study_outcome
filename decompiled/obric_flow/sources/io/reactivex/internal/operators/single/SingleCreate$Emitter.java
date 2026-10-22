package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.b0;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class SingleCreate$Emitter<T> extends AtomicReference<Disposable> implements Disposable {
    private static final long serialVersionUID = -2467358622224974244L;
    final b0 downstream;

    public SingleCreate$Emitter(b0 r5) {
        this.downstream = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public void onError(Throwable r5) {
        if (tryOnError(r5) == true) goto L6;
        f.k(r5);
        return;
    }

    public void onSuccess(T r5) {
        Disposable r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 == r11) goto L16;
        Disposable r12 = getAndSet(r11);
        if (r12 == r11) goto L19;
        if (r5 != null) goto L10;
        this.downstream.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));     // Catch: Throwable -> L8
    L11:
        if (r12 == null) goto L20;
        r12.dispose();
        return;
    L20:
        return;
    L10:
        this.downstream.onSuccess(r5);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (r12 == null) goto L15;
        r12.dispose();
    L15:
        throw th;
    L19:
        return;
    }

    public void setCancellable(pt.f r5) {
        setDisposable(new CancellableDisposable(r5));
    }

    public void setDisposable(Disposable r5) {
        DisposableHelper.set(this, r5);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return androidx.room.jarjarred.org.antlr.runtime.a.q(SingleCreate$Emitter.class.getSimpleName(), "{", super.toString(), "}");
    }

    public boolean tryOnError(Throwable r5) {
        if (r5 != null) goto L4;
        r5 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L4:
        Disposable r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 == r11) goto L17;
        Disposable r12 = getAndSet(r11);
        if (r12 == r11) goto L22;
        this.downstream.onError(r5);     // Catch: Throwable -> L13
        if (r12 == null) goto L21;
        r12.dispose();
        return true;
    L21:
        return true;
    L13:
        th = move-exception;
        if (r12 == null) goto L16;
        r12.dispose();
    L16:
        throw th;
    L22:
        return false;
    L17:
        return false;
    }
}
