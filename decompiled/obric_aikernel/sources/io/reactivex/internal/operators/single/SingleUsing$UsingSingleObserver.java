package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.r;
import zb.g;

/* JADX INFO: loaded from: classes2.dex */
final class SingleUsing$UsingSingleObserver<T, U> extends AtomicReference<Object> implements r<T>, b {
    private static final long serialVersionUID = -5331524057054083935L;
    final g<? super U> disposer;
    final r<? super T> downstream;
    final boolean eager;
    b upstream;

    SingleUsing$UsingSingleObserver(r<? super T> r10, U r11, boolean r12, g<? super U> r13) {
        super(r11);
        this.downstream = r10;
        this.eager = r12;
        this.disposer = r13;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
        disposeAfter();
    }

    void disposeAfter() {
        Object r10 = getAndSet(this);
        if (r10 == this) goto L11;
        this.disposer.accept(r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // xb.r
    public void onError(Throwable r10) {
        this.upstream = DisposableHelper.DISPOSED;
        if (this.eager == false) goto L11;
        Object r11 = getAndSet(this);
        if (r11 != this) goto L15;
        return;
    L15:
        this.disposer.accept(r11);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r10 = new CompositeException(new Throwable[]{r10, th});
    L11:
        this.downstream.onError(r10);
        if (this.eager == true) goto L17;
        disposeAfter();
        return;
    }

    @Override // xb.r
    public void onSubscribe(b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.r
    public void onSuccess(T r10) {
        this.upstream = DisposableHelper.DISPOSED;
        if (this.eager == false) goto L11;
        Object r11 = getAndSet(this);
        if (r11 == this) goto L17;
        this.disposer.accept(r11);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
        return;
    L17:
        return;
    L11:
        this.downstream.onSuccess(r10);
        if (this.eager == true) goto L18;
        disposeAfter();
        return;
    }
}
