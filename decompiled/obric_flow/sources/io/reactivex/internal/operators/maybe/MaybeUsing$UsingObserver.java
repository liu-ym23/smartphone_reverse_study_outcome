package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.j;
import pt.g;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeUsing$UsingObserver<T, D> extends AtomicReference<Object> implements j, Disposable {
    private static final long serialVersionUID = -674404550052917487L;
    final g disposer;
    final j downstream;
    final boolean eager;
    Disposable upstream;

    public MaybeUsing$UsingObserver(j r5, D r10, g r11, boolean r12) {
        super(r10);
        this.downstream = r5;
        this.disposer = r11;
        this.eager = r12;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
        disposeResourceAfter();
    }

    public void disposeResourceAfter() {
        Object r5 = getAndSet(this);
        if (r5 == this) goto L11;
        this.disposer.accept(r5);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(th);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // mt.j
    public void onComplete() {
        this.upstream = DisposableHelper.DISPOSED;
        if (this.eager == false) goto L11;
        Object r5 = getAndSet(this);
        if (r5 == this) goto L17;
        this.disposer.accept(r5);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
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

    @Override // mt.j
    public void onError(Throwable r5) {
        this.upstream = DisposableHelper.DISPOSED;
        if (this.eager == false) goto L11;
        Object r10 = getAndSet(this);
        if (r10 != this) goto L15;
        return;
    L15:
        this.disposer.accept(r10);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r5 = new CompositeException(new Throwable[]{r5, th});
    L11:
        this.downstream.onError(r5);
        if (this.eager == true) goto L17;
        disposeResourceAfter();
        return;
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        this.upstream = DisposableHelper.DISPOSED;
        if (this.eager == false) goto L11;
        Object r10 = getAndSet(this);
        if (r10 == this) goto L17;
        this.disposer.accept(r10);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
        return;
    L17:
        return;
    L11:
        this.downstream.onSuccess(r5);
        if (this.eager == true) goto L18;
        disposeResourceAfter();
        return;
    }
}
