package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends io.reactivex.internal.observers.h implements Runnable, Disposable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Callable f18068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f18069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f18070j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TimeUnit f18071k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final mt.y f18072l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedList f18073m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Disposable f18074n;

    public y(io.reactivex.observers.d r5, Callable r10, long r11, long r12, TimeUnit r13, mt.y r14) {
        super(r5, new io.reactivex.internal.queue.a());
        this.f18068h = r10;
        this.f18069i = r11;
        this.f18070j = r12;
        this.f18071k = r13;
        this.f18072l = r14;
        this.f18073m = new LinkedList();
    }

    @Override // io.reactivex.internal.observers.h
    public final void d(io.reactivex.observers.d r5, Object r10) {
        r5.onNext((Collection) r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.d == true) goto L12;
        this.d = true;
        monitor-enter(this);
        this.f18073m.clear();     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        this.f18074n.dispose();
        this.f18072l.dispose();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.d;
    }

    @Override // mt.u
    public final void onComplete() {
        monitor-enter(this);
        ArrayList r5 = new ArrayList(this.f18073m);     // Catch: Throwable -> L13
        this.f18073m.clear();     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        Iterator r10 = r5.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        Collection r11 = (Collection) r10.next();
        this.f17640c.offer(r11);
        goto L7
    L9:
        this.e = true;
        if (i() == false) goto L19;
        com.lynx.tasm.behavior.utils.d.k(this.f17640c, this.f17639b, this.f18072l, this);
        return;
    L19:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        this.e = true;
        monitor-enter(this);
        this.f18073m.clear();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        this.f17639b.onError(r5);
        this.f18072l.dispose();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        monitor-enter(this);
        Iterator r10 = this.f18073m.iterator();     // Catch: Throwable -> L7
    L5:
        if (r10.hasNext() == false) goto L9;
        ((Collection) r10.next()).add(r5);     // Catch: Throwable -> L7
        goto L5
    L9:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r11) {
        mt.y r5 = this.f18072l;
        io.reactivex.observers.d r10 = this.f17639b;
        if (DisposableHelper.validate(this.f18074n, r11) == false) goto L12;
        this.f18074n = r11;
        Object r12 = this.f18068h.call();     // Catch: Throwable -> L7
        io.reactivex.internal.functions.e.d(r12, "The buffer supplied is null");     // Catch: Throwable -> L7
        Collection r13 = (Collection) r12;     // Catch: Throwable -> L7
        this.f18073m.add(r13);
        r10.onSubscribe(this);
        TimeUnit r14 = this.f18071k;
        mt.y r15 = this.f18072l;
        long r16 = this.f18070j;
        r15.c(this, r16, r16, r14);
        r5.b(new x(this, r13, 1), this.f18069i, this.f18071k);
        return;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r11.dispose();
        EmptyDisposable.error(th, r10);
        r5.dispose();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.d == false) goto L22;
        return;
    L22:
        Object r5 = this.f18068h.call();     // Catch: Throwable -> L19
        io.reactivex.internal.functions.e.d(r5, "The bufferSupplier returned a null buffer");     // Catch: Throwable -> L19
        Collection r10 = (Collection) r5;     // Catch: Throwable -> L19
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (this.d == false) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L13:
        this.f18073m.add(r10);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        this.f18072l.b(new x(this, r10, 0), this.f18069i, this.f18071k);
        return;
    L19:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.f17639b.onError(th);
        dispose();
    }
}
