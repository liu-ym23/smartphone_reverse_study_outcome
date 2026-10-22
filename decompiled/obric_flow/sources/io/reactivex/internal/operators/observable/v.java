package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends io.reactivex.internal.observers.h implements Runnable, Disposable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Callable f18001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f18002i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TimeUnit f18003j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f18004k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f18005l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final mt.y f18006m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Collection f18007n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Disposable f18008o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Disposable f18009p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f18010q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f18011r;

    public v(io.reactivex.observers.d r5, Callable r10, long r11, TimeUnit r12, int r13, boolean r14, mt.y r15) {
        super(r5, new io.reactivex.internal.queue.a());
        this.f18001h = r10;
        this.f18002i = r11;
        this.f18003j = r12;
        this.f18004k = r13;
        this.f18005l = r14;
        this.f18006m = r15;
    }

    @Override // io.reactivex.internal.observers.h
    public final void d(io.reactivex.observers.d r5, Object r10) {
        r5.onNext((Collection) r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.d == true) goto L13;
        this.d = true;
        this.f18009p.dispose();
        this.f18006m.dispose();
        monitor-enter(this);
        this.f18007n = null;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.d;
    }

    @Override // mt.u
    public final void onComplete() {
        this.f18006m.dispose();
        monitor-enter(this);
        Collection r5 = this.f18007n;     // Catch: Throwable -> L11
        this.f18007n = null;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r5 == null) goto L16;
        this.f17640c.offer(r5);
        this.e = true;
        if (i() == false) goto L17;
        com.lynx.tasm.behavior.utils.d.k(this.f17640c, this.f17639b, this, this);
        return;
    L17:
        return;
    L16:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        monitor-enter(this);
        this.f18007n = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        this.f17639b.onError(r5);
        this.f18006m.dispose();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public final void onNext(Object r10) {
        monitor-enter(this);
        Collection r5 = this.f18007n;     // Catch: Throwable -> L7
        if (r5 != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        r5.add(r10);     // Catch: Throwable -> L7
        if (r5.size() >= this.f18004k) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L13:
        this.f18007n = null;     // Catch: Throwable -> L7
        this.f18010q++;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        if (this.f18005l == false) goto L18;
        this.f18008o.dispose();
    L18:
        l(r5, this);
        Object r11 = this.f18001h.call();     // Catch: Throwable -> L30
        io.reactivex.internal.functions.e.d(r11, "The buffer supplied is null");     // Catch: Throwable -> L30
        Collection r12 = (Collection) r11;     // Catch: Throwable -> L30
        monitor-enter(this);
        this.f18007n = r12;     // Catch: Throwable -> L27
        this.f18011r++;     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L27
        if (this.f18005l == false) goto L40;
        mt.y r13 = this.f18006m;
        long r14 = this.f18002i;
        this.f18008o = r13.c(this, r14, r14, this.f18003j);
        return;
    L40:
        return;
    L27:
        th = move-exception;
        throw th;
    L30:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.f17639b.onError(th);
        dispose();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r10) {
        io.reactivex.observers.d r5 = this.f17639b;
        if (DisposableHelper.validate(this.f18009p, r10) == false) goto L12;
        this.f18009p = r10;
        Object r11 = this.f18001h.call();     // Catch: Throwable -> L7
        io.reactivex.internal.functions.e.d(r11, "The buffer supplied is null");     // Catch: Throwable -> L7
        this.f18007n = (Collection) r11;
        r5.onSubscribe(this);
        TimeUnit r12 = this.f18003j;
        mt.y r13 = this.f18006m;
        long r14 = this.f18002i;
        this.f18008o = r13.c(this, r14, r14, r12);
        return;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r10.dispose();
        EmptyDisposable.error(th, r5);
        this.f18006m.dispose();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r5 = this.f18001h.call();     // Catch: Throwable -> L19
        io.reactivex.internal.functions.e.d(r5, "The bufferSupplier returned a null buffer");     // Catch: Throwable -> L19
        Collection r10 = (Collection) r5;     // Catch: Throwable -> L19
        monitor-enter(this);
        Collection r11 = this.f18007n;     // Catch: Throwable -> L13
        if (r11 != null) goto L7;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L7:
        if (this.f18010q != this.f18011r) goto L15;
        this.f18007n = r10;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        l(r11, this);
        return;
    L13:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        dispose();
        this.f17639b.onError(th);
    }
}
