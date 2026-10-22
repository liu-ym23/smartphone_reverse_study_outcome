package io.reactivex.subjects;

import bc.f;
import io.reactivex.Observable;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import xb.o;

/* JADX INFO: loaded from: classes2.dex */
public final class UnicastSubject<T> extends a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.internal.queue.a<T> f9723c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final AtomicReference<o<? super T>> f9724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AtomicReference<Runnable> f9725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f9726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    volatile boolean f9727j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    volatile boolean f9728k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Throwable f9729l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final AtomicBoolean f9730m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final BasicIntQueueDisposable<T> f9731n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f9732o;

    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;
        final /* synthetic */ UnicastSubject this$0;

        UnicastQueueDisposable(UnicastSubject r10) {
            this.this$0 = r10;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
        public void clear() {
            this.this$0.f9723c.clear();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.disposables.b
        public void dispose() {
            if (this.this$0.f9727j == true) goto L8;
            this.this$0.f9727j = true;
            this.this$0.j();
            this.this$0.f9724g.lazySet(null);
            if (this.this$0.f9731n.getAndIncrement() != 0) goto L9;
            this.this$0.f9724g.lazySet(null);
            this.this$0.f9723c.clear();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.this$0.f9727j;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
        public boolean isEmpty() {
            return this.this$0.f9723c.isEmpty();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
        public T poll() {
            return this.this$0.f9723c.poll();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.c
        public int requestFusion(int r10) {
            if ((r10 & 2) == 0) goto L6;
            this.this$0.f9732o = true;
            return 2;
        L6:
            return 0;
        }
    }

    UnicastSubject(int r10, Runnable r11, boolean r12) {
        this.f9723c = new io.reactivex.internal.queue.a(io.reactivex.internal.functions.a.e(r10, "capacityHint"));
        this.f9725h = new AtomicReference(io.reactivex.internal.functions.a.d(r11, "onTerminate"));
        this.f9726i = r12;
        this.f9724g = new AtomicReference();
        this.f9730m = new AtomicBoolean();
        this.f9731n = new UnicastQueueDisposable(this);
    }

    UnicastSubject(int r10, boolean r11) {
        this.f9723c = new io.reactivex.internal.queue.a(io.reactivex.internal.functions.a.e(r10, "capacityHint"));
        this.f9725h = new AtomicReference();
        this.f9726i = r11;
        this.f9724g = new AtomicReference();
        this.f9730m = new AtomicBoolean();
        this.f9731n = new UnicastQueueDisposable(this);
    }

    public static <T> UnicastSubject<T> h() {
        return new UnicastSubject(Observable.a(), true);
    }

    public static <T> UnicastSubject<T> i(int r10, Runnable r11) {
        return new UnicastSubject(r10, r11, true);
    }

    @Override // io.reactivex.Observable
    protected void f(o<? super T> r10) {
        if (this.f9730m.get() == false) goto L5;
    L11:
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), r10);
        return;
    L5:
        if (this.f9730m.compareAndSet(false, true) == false) goto L11;
        r10.onSubscribe(this.f9731n);
        this.f9724g.lazySet(r10);
        if (this.f9727j == false) goto L10;
        this.f9724g.lazySet(null);
        return;
    L10:
        k();
    }

    void j() {
        Runnable r10 = this.f9725h.get();
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f9725h.compareAndSet(r10, null) == false) goto L9;
        r10.run();
        return;
    }

    void k() {
        if (this.f9731n.getAndIncrement() == 0) goto L5;
        return;
    L5:
        o<? super T> r10 = this.f9724g.get();
        int r11 = 1;
    L6:
        if (r10 != null) goto L8;
        r11 = this.f9731n.addAndGet(-r11);
        if (r11 == 0) goto L14;
        r10 = this.f9724g.get();
        goto L6
    L14:
        return;
    L8:
        if (this.f9732o == false) goto L10;
        l(r10);
        return;
    L10:
        m(r10);
    }

    void l(o<? super T> r10) {
        io.reactivex.internal.queue.a<T> r11 = this.f9723c;
        int r12 = 1;
        boolean r13 = !this.f9726i;
    L4:
        if (this.f9727j == true) goto L5;
        boolean r14 = this.f9728k;
        if (r13 == false) goto L13;
        if (r14 == false) goto L13;
        if (o(r11, r10) == false) goto L13;
        return;
    L13:
        r10.onNext(null);
        if (r14 == true) goto L15;
        r12 = this.f9731n.addAndGet(-r12);
        if (r12 != 0) goto L4;
        return;
    L15:
        n(r10);
        return;
    L5:
        this.f9724g.lazySet(null);
        r11.clear();
    }

    void m(o<? super T> r10) {
        io.reactivex.internal.queue.a<T> r11 = this.f9723c;
        boolean r12 = !this.f9726i;
        boolean r13 = true;
        int r14 = 1;
    L4:
        if (this.f9727j == true) goto L5;
        boolean r15 = this.f9728k;
        T r16 = this.f9723c.poll();
        if (r16 != null) goto L10;
        boolean r17 = true;
    L11:
        if (r15 == false) goto L21;
        if (r12 == false) goto L18;
        if (r13 == false) goto L18;
        if (o(r11, r10) == true) goto L16;
        r13 = false;
        goto L18
    L16:
        return;
    L18:
        if (r17 == false) goto L21;
        n(r10);
        return;
    L21:
        if (r17 == true) goto L22;
        r10.onNext(r16);
        goto L4
    L22:
        r14 = this.f9731n.addAndGet(-r14);
        if (r14 != 0) goto L4;
        return;
    L10:
        r17 = false;
        goto L11
    L5:
        this.f9724g.lazySet(null);
        r11.clear();
    }

    void n(o<? super T> r10) {
        this.f9724g.lazySet(null);
        Throwable r11 = this.f9729l;
        if (r11 == null) goto L5;
        r10.onError(r11);
        return;
    L5:
        r10.onComplete();
    }

    boolean o(f<T> r10, o<? super T> r11) {
        Throwable r12 = this.f9729l;
        if (r12 == null) goto L6;
        this.f9724g.lazySet(null);
        r10.clear();
        r11.onError(r12);
        return true;
    L6:
        return false;
    }

    @Override // xb.o
    public void onComplete() {
        if (this.f9728k == false) goto L5;
        return;
    L5:
        if (this.f9727j == true) goto L10;
        this.f9728k = true;
        j();
        k();
        return;
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        io.reactivex.internal.functions.a.d(r10, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f9728k == false) goto L5;
    L9:
        dc.a.n(r10);
        return;
    L5:
        if (this.f9727j == true) goto L9;
        this.f9729l = r10;
        this.f9728k = true;
        j();
        k();
    }

    @Override // xb.o
    public void onNext(T r10) {
        io.reactivex.internal.functions.a.d(r10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f9728k == false) goto L5;
        return;
    L5:
        if (this.f9727j == true) goto L10;
        this.f9723c.offer(r10);
        k();
        return;
    }

    @Override // xb.o
    public void onSubscribe(b r10) {
        if (this.f9728k == false) goto L5;
    L6:
        r10.dispose();
        return;
    L5:
        if (this.f9727j == true) goto L6;
    }
}
