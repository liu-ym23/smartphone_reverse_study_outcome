package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableUsing$UsingObserver<T, D> extends AtomicBoolean implements xb.o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 5904473792286235046L;
    final zb.g<? super D> disposer;
    final xb.o<? super T> downstream;
    final boolean eager;
    final D resource;
    io.reactivex.disposables.b upstream;

    ObservableUsing$UsingObserver(xb.o<? super T> r10, D r11, zb.g<? super D> r12, boolean r13) {
        this.downstream = r10;
        this.resource = r11;
        this.disposer = r12;
        this.eager = r13;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        disposeAfter();
        this.upstream.dispose();
    }

    void disposeAfter() {
        if (compareAndSet(false, true) == false) goto L11;
        this.disposer.accept(this.resource);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get();
    }

    @Override // xb.o
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
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (this.eager == true) goto L5;
        this.downstream.onError(r10);
        this.upstream.dispose();
        disposeAfter();
        return;
    L5:
        if (compareAndSet(false, true) == true) goto L13;
    L10:
        this.upstream.dispose();
        this.downstream.onError(r10);
        return;
    L13:
        this.disposer.accept(this.resource);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r10 = new CompositeException(new Throwable[]{r10, th});
        goto L10
    }

    @Override // xb.o
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
