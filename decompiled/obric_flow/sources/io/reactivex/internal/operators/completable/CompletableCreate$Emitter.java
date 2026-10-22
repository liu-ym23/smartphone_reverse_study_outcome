package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.b;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableCreate$Emitter extends AtomicReference<Disposable> implements Disposable {
    private static final long serialVersionUID = -2467358622224974244L;
    final b downstream;

    public CompletableCreate$Emitter(b r5) {
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

    public void onComplete() {
        Disposable r5 = get();
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (r5 == r10) goto L13;
        Disposable r11 = getAndSet(r10);
        if (r11 == r10) goto L16;
        this.downstream.onComplete();     // Catch: Throwable -> L9
        if (r11 == null) goto L17;
        r11.dispose();
        return;
    L17:
        return;
    L9:
        th = move-exception;
        if (r11 == null) goto L12;
        r11.dispose();
    L12:
        throw th;
    L16:
        return;
    }

    public void onError(Throwable r5) {
        if (tryOnError(r5) == true) goto L6;
        f.k(r5);
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
        return androidx.room.jarjarred.org.antlr.runtime.a.q(CompletableCreate$Emitter.class.getSimpleName(), "{", super.toString(), "}");
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
