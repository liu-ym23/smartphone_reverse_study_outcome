package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.observers.d f17873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pt.o f17874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f17875c;
    public final AtomicReference d;
    public volatile long e;
    public boolean f;

    public n0(io.reactivex.observers.d r5, pt.o r10) {
        this.d = new AtomicReference();
        this.f17873a = r5;
        this.f17874b = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f17875c.dispose();
        DisposableHelper.dispose(this.d);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f17875c.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
        AtomicReference r5 = this.d;
        Disposable r10 = (Disposable) r5.get();
        if (r10 == DisposableHelper.DISPOSED) goto L9;
        ((m0) r10).a();
        DisposableHelper.dispose(r5);
        this.f17873a.onComplete();
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        DisposableHelper.dispose(this.d);
        this.f17873a.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r10) {
        if (this.f == false) goto L5;
        return;
    L5:
        long r5 = this.e + 1;
        this.e = r5;
        Disposable r11 = (Disposable) this.d.get();
        if (r11 == null) goto L19;
        r11.dispose();
    L19:
        Object r12 = this.f17874b.apply(r10);     // Catch: Throwable -> L16
        io.reactivex.internal.functions.e.d(r12, "The ObservableSource supplied is null");     // Catch: Throwable -> L16
        mt.s r13 = (mt.s) r12;     // Catch: Throwable -> L16
        m0 r14 = new m0(this, r5, r10);
        AtomicReference r15 = this.d;
    L11:
        if (r15.compareAndSet(r11, r14) == true) goto L12;
        if (r15.get() == r11) goto L11;
        return;
    L12:
        r13.subscribe(r14);
        return;
    L16:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        dispose();
        this.f17873a.onError(th);
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.f17875c, r5) == false) goto L6;
        this.f17875c = r5;
        this.f17873a.onSubscribe(this);
        return;
    }
}
