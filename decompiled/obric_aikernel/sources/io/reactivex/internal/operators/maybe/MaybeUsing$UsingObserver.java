package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import zb.g;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeUsing$UsingObserver<T, D> extends AtomicReference<Object> implements j<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -674404550052917487L;
    final g<? super D> disposer;
    final j<? super T> downstream;
    final boolean eager;
    io.reactivex.disposables.b upstream;

    MaybeUsing$UsingObserver(j<? super T> r10, D r11, g<? super D> r12, boolean r13) {
        super(r11);
        this.downstream = r10;
        this.disposer = r12;
        this.eager = r13;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
        disposeResourceAfter();
    }

    void disposeResourceAfter() {
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

    @Override // xb.j
    public void onComplete() {
        this.upstream = DisposableHelper.DISPOSED;
        if (this.eager == false) goto L11;
        Object r10 = getAndSet(this);
        if (r10 == this) goto L17;
        this.disposer.accept(r10);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
        return;
    L17:
        return;
    L11:
        this.downstream.onComplete();
        if (this.eager == true) goto L18;
        disposeResourceAfter();
        return;
    }

    @Override // xb.j
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
        disposeResourceAfter();
        return;
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.j
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
        disposeResourceAfter();
        return;
    }
}
