package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class v4 extends io.reactivex.internal.observers.h implements Disposable, Runnable {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object f18021p = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f18022h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TimeUnit f18023i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final mt.z f18024j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f18025k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f18026l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public io.reactivex.subjects.i f18027m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicReference f18028n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f18029o;

    static {
        f18021p = new Object();
    }

    public v4(io.reactivex.observers.d r5, long r10, TimeUnit r11, mt.z r12, int r13) {
        super(r5, new io.reactivex.internal.queue.a());
        this.f18028n = new AtomicReference();
        this.f18022h = r10;
        this.f18023i = r11;
        this.f18024j = r12;
        this.f18025k = r13;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.d = true;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.d;
    }

    @Override // mt.u
    public final void onComplete() {
        this.e = true;
        if (i() == false) goto L5;
        t();
    L5:
        DisposableHelper.dispose(this.f18028n);
        this.f17639b.onComplete();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        this.f = r5;
        this.e = true;
        if (i() == false) goto L5;
        t();
    L5:
        DisposableHelper.dispose(this.f18028n);
        this.f17639b.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (this.f18029o == false) goto L6;
        return;
    L6:
        if (j() == false) goto L10;
        this.f18027m.onNext(r5);
        if (this.f17638a.addAndGet(-1) != 0) goto L13;
        return;
    L13:
        t();
        return;
    L10:
        this.f17640c.offer(NotificationLite.next(r5));
        if (i() == true) goto L13;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.f18026l, r10) == false) goto L8;
        this.f18026l = r10;
        this.f18027m = new io.reactivex.subjects.i(this.f18025k);
        io.reactivex.observers.d r11 = this.f17639b;
        r11.onSubscribe(this);
        r11.onNext(this.f18027m);
        if (this.d == true) goto L9;
        mt.z r5 = this.f18024j;
        long r12 = this.f18022h;
        Disposable r13 = r5.e(this, r12, r12, this.f18023i);
        DisposableHelper.replace(this.f18028n, r13);
        return;
    L9:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.d == false) goto L5;
        this.f18029o = true;
        DisposableHelper.dispose(this.f18028n);
    L5:
        this.f17640c.offer(f18021p);
        if (i() == false) goto L9;
        t();
        return;
    }

    public final void t() {
        io.reactivex.internal.queue.a r5 = this.f17640c;
        io.reactivex.observers.d r10 = this.f17639b;
        io.reactivex.subjects.i r11 = this.f18027m;
        int r12 = 1;
    L3:
        boolean r13 = this.f18029o;
        boolean r14 = this.e;
        Object r15 = r5.poll();
        Object r16 = f18021p;
        if (r14 == false) goto L12;
        if (r15 == null) goto L7;
        if (r15 != r16) goto L12;
    L7:
        this.f18027m = null;
        r5.clear();
        DisposableHelper.dispose(this.f18028n);
        Throwable r17 = this.f;
        if (r17 == null) goto L10;
        r11.onError(r17);
        return;
    L10:
        r11.onComplete();
        return;
    L12:
        if (r15 == null) goto L13;
        if (r15 == r16) goto L17;
        r11.onNext(NotificationLite.getValue(r15));
        goto L3
    L17:
        r11.onComplete();
        if (r13 == false) goto L19;
        this.f18026l.dispose();
        goto L3
    L19:
        io.reactivex.subjects.i r18 = new io.reactivex.subjects.i(this.f18025k);
        this.f18027m = r18;
        r10.onNext(r18);
        r11 = r18;
        goto L3
    L13:
        AtomicInteger r19 = this.f17638a;
        r12 = r19.addAndGet(-r12);
        if (r12 != 0) goto L3;
    }
}
