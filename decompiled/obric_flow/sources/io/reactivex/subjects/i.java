package io.reactivex.subjects;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.internal.queue.b f18200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f18201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f18202c;
    public final boolean d;
    public volatile boolean e;
    public volatile boolean f;
    public Throwable g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f18203h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BasicIntQueueDisposable f18204i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f18205j;

    public i(int r5) {
        io.reactivex.internal.functions.e.e(r5, "capacityHint");
        this.f18200a = new io.reactivex.internal.queue.b(r5);
        this.f18202c = new AtomicReference();
        this.d = true;
        this.f18201b = new AtomicReference();
        this.f18203h = new AtomicBoolean();
        this.f18204i = new UnicastSubject$UnicastQueueDisposable(this);
    }

    public final void d() {
        AtomicReference r5 = this.f18202c;
        Runnable r10 = (Runnable) r5.get();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r5.compareAndSet(r10, null) == true) goto L6;
        if (r5.get() == r10) goto L5;
        return;
    L6:
        r10.run();
    }

    public final void e() {
        if (this.f18204i.getAndIncrement() == 0) goto L5;
        return;
    L5:
        u r5 = (u) this.f18201b.get();
        int r10 = 1;
        int r11 = 1;
    L6:
        if (r5 != null) goto L8;
        r11 = this.f18204i.addAndGet(-r11);
        if (r11 == 0) goto L55;
        r5 = (u) this.f18201b.get();
        goto L6
    L55:
        return;
    L8:
        if (this.f18205j == false) goto L28;
        io.reactivex.internal.queue.b r12 = this.f18200a;
        boolean r13 = this.d;
    L11:
        if (this.e == true) goto L12;
        boolean r14 = this.f;
        if (r13 == true) goto L19;
        if (r14 == false) goto L19;
        Throwable r15 = this.g;
        if (r15 == null) goto L19;
        this.f18201b.lazySet(null);
        r12.clear();
        r5.onError(r15);
        return;
    L19:
        r5.onNext(null);
        if (r14 == true) goto L21;
        r10 = this.f18204i.addAndGet(-r10);
        if (r10 != 0) goto L11;
        return;
    L21:
        this.f18201b.lazySet(null);
        Throwable r16 = this.g;
        if (r16 == null) goto L24;
        r5.onError(r16);
        return;
    L24:
        r5.onComplete();
        return;
    L12:
        this.f18201b.lazySet(null);
        r12.clear();
        return;
    L28:
        io.reactivex.internal.queue.b r17 = this.f18200a;
        boolean r18 = this.d;
        boolean r19 = true;
        int r20 = 1;
    L30:
        if (this.e == true) goto L31;
        boolean r21 = this.f;
        Object r22 = this.f18200a.poll();
        if (r22 != null) goto L35;
        boolean r110 = true;
    L36:
        if (r21 == false) goto L48;
        if (r18 == true) goto L43;
        if (r19 == false) goto L43;
        Throwable r23 = this.g;
        if (r23 != null) goto L41;
        r19 = false;
        goto L43
    L41:
        this.f18201b.lazySet(null);
        r17.clear();
        r5.onError(r23);
        return;
    L43:
        if (r110 == false) goto L48;
        this.f18201b.lazySet(null);
        Throwable r111 = this.g;
        if (r111 == null) goto L47;
        r5.onError(r111);
        return;
    L47:
        r5.onComplete();
        return;
    L48:
        if (r110 == true) goto L49;
        r5.onNext(r22);
        goto L30
    L49:
        r20 = this.f18204i.addAndGet(-r20);
        if (r20 != 0) goto L30;
        return;
    L35:
        r110 = false;
        goto L36
    L31:
        this.f18201b.lazySet(null);
        r17.clear();
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.f == false) goto L5;
        return;
    L5:
        if (this.e == true) goto L10;
        this.f = true;
        d();
        e();
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        io.reactivex.internal.functions.e.d(r5, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f == false) goto L5;
    L9:
        wn.f.k(r5);
        return;
    L5:
        if (this.e == true) goto L9;
        this.g = r5;
        this.f = true;
        d();
        e();
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        io.reactivex.internal.functions.e.d(r5, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f == false) goto L5;
        return;
    L5:
        if (this.e == true) goto L10;
        this.f18200a.offer(r5);
        e();
        return;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (this.f == false) goto L5;
    L6:
        r5.dispose();
        return;
    L5:
        if (this.e == true) goto L6;
    }

    @Override // mt.n
    public final void subscribeActual(u r5) {
        if (this.f18203h.get() == false) goto L5;
    L11:
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), r5);
        return;
    L5:
        if (this.f18203h.compareAndSet(false, true) == false) goto L11;
        r5.onSubscribe(this.f18204i);
        this.f18201b.lazySet(r5);
        if (this.e == false) goto L10;
        this.f18201b.lazySet(null);
        return;
    L10:
        e();
    }

    public i(Runnable r5, int r10) {
        io.reactivex.internal.functions.e.e(r10, "capacityHint");
        this.f18200a = new io.reactivex.internal.queue.b(r10);
        this.f18202c = new AtomicReference(r5);
        this.d = true;
        this.f18201b = new AtomicReference();
        this.f18203h = new AtomicBoolean();
        this.f18204i = new UnicastSubject$UnicastQueueDisposable(this);
    }
}
