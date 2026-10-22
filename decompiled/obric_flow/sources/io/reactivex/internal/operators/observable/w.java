package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends io.reactivex.internal.observers.h implements Runnable, Disposable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Callable f18030h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f18031i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TimeUnit f18032j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final mt.z f18033k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f18034l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Collection f18035m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicReference f18036n;

    public w(io.reactivex.observers.d r5, Callable r10, long r11, TimeUnit r12, mt.z r13) {
        super(r5, new io.reactivex.internal.queue.a());
        this.f18036n = new AtomicReference();
        this.f18030h = r10;
        this.f18031i = r11;
        this.f18032j = r12;
        this.f18033k = r13;
    }

    @Override // io.reactivex.internal.observers.h
    public final void d(io.reactivex.observers.d r5, Object r10) {
        io.reactivex.observers.d r11 = this.f17639b;
        r11.onNext((Collection) r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f18036n);
        this.f18034l.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f18036n.get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mt.u
    public final void onComplete() {
        monitor-enter(this);
        Collection r5 = this.f18035m;     // Catch: Throwable -> L11
        this.f18035m = null;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r5 == null) goto L9;
        this.f17640c.offer(r5);
        this.e = true;
        if (i() == false) goto L9;
        com.lynx.tasm.behavior.utils.d.k(this.f17640c, this.f17639b, null, this);
    L9:
        DisposableHelper.dispose(this.f18036n);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        monitor-enter(this);
        this.f18035m = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        this.f17639b.onError(r5);
        DisposableHelper.dispose(this.f18036n);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        monitor-enter(this);
        Collection r10 = this.f18035m;     // Catch: Throwable -> L7
        if (r10 != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        r10.add(r5);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.f18034l, r10) == false) goto L23;
        this.f18034l = r10;
        Object r11 = this.f18030h.call();     // Catch: Throwable -> L15
        io.reactivex.internal.functions.e.d(r11, "The buffer supplied is null");     // Catch: Throwable -> L15
        this.f18035m = (Collection) r11;
        this.f17639b.onSubscribe(this);
        if (this.d == true) goto L24;
        mt.z r5 = this.f18033k;
        long r12 = this.f18031i;
        Disposable r13 = r5.e(this, r12, r12, this.f18032j);
        AtomicReference r14 = this.f18036n;
    L10:
        if (r14.compareAndSet(null, r13) == true) goto L26;
        if (r14.get() == null) goto L10;
        r13.dispose();
        return;
    L26:
        return;
    L24:
        return;
    L15:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        dispose();
        EmptyDisposable.error(th, this.f17639b);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r5 = this.f18030h.call();     // Catch: Throwable -> L17
        io.reactivex.internal.functions.e.d(r5, "The bufferSupplier returned a null buffer");     // Catch: Throwable -> L17
        Collection r10 = (Collection) r5;     // Catch: Throwable -> L17
        monitor-enter(this);
        Collection r11 = this.f18035m;     // Catch: Throwable -> L7
        if (r11 == null) goto L9;
        this.f18035m = r10;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r11 != null) goto L13;
        DisposableHelper.dispose(this.f18036n);
        return;
    L13:
        k(r11, this);
        return;
    L7:
        th = move-exception;
        throw th;
    L17:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.f17639b.onError(th);
        dispose();
    }
}
