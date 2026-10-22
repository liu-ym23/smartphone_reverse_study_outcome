package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableUsing$UsingObserver<T, D> extends AtomicBoolean implements mt.u, Disposable {
    private static final long serialVersionUID = 5904473792286235046L;
    final pt.g disposer;
    final mt.u downstream;
    final boolean eager;
    final D resource;
    Disposable upstream;

    public ObservableUsing$UsingObserver(mt.u r5, D r10, pt.g r11, boolean r12) {
        this.downstream = r5;
        this.resource = r10;
        this.disposer = r11;
        this.eager = r12;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        disposeAfter();
        this.upstream.dispose();
    }

    public void disposeAfter() {
        if (compareAndSet(false, true) == false) goto L11;
        this.disposer.accept(this.resource);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get();
    }

    @Override // mt.u
    public void onComplete() {
        if (this.eager == true) goto L5;
        this.downstream.onComplete();
        this.upstream.dispose();
        disposeAfter();
        return;
    L5:
        if (compareAndSet(false, true) == true) goto L14;
    L11:
        this.upstream.dispose();
        this.downstream.onComplete();
        return;
    L14:
        this.disposer.accept(this.resource);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (this.eager == true) goto L5;
        this.downstream.onError(r5);
        this.upstream.dispose();
        disposeAfter();
        return;
    L5:
        if (compareAndSet(false, true) == true) goto L13;
    L10:
        this.upstream.dispose();
        this.downstream.onError(r5);
        return;
    L13:
        this.disposer.accept(this.resource);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r5 = new CompositeException(new Throwable[]{r5, th});
        goto L10
    }

    @Override // mt.u
    public void onNext(T r5) {
        this.downstream.onNext(r5);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }
}
