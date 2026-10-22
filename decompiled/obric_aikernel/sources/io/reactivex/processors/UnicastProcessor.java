package io.reactivex.processors;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import tc.c;
import tc.d;
import xb.e;

/* JADX INFO: loaded from: classes2.dex */
public final class UnicastProcessor<T> extends a<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final io.reactivex.internal.queue.a<T> f9695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AtomicReference<Runnable> f9696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f9697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    volatile boolean f9698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Throwable f9699k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final AtomicReference<c<? super T>> f9700l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    volatile boolean f9701m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final AtomicBoolean f9702n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final BasicIntQueueSubscription<T> f9703o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final AtomicLong f9704p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f9705q;

    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;
        final /* synthetic */ UnicastProcessor this$0;

        UnicastQueueSubscription(UnicastProcessor r10) {
            this.this$0 = r10;
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
        public void cancel() {
            if (this.this$0.f9701m == false) goto L5;
            return;
        L5:
            this.this$0.f9701m = true;
            this.this$0.g();
            UnicastProcessor r10 = this.this$0;
            if (r10.f9705q == false) goto L8;
            return;
        L8:
            if (r10.f9703o.getAndIncrement() != 0) goto L12;
            this.this$0.f9695g.clear();
            this.this$0.f9700l.lazySet(null);
            return;
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
        public void clear() {
            this.this$0.f9695g.clear();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
        public boolean isEmpty() {
            return this.this$0.f9695g.isEmpty();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
        public T poll() {
            return this.this$0.f9695g.poll();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
        public void request(long r10) {
            if (SubscriptionHelper.validate(r10) == false) goto L6;
            b.a(this.this$0.f9704p, r10);
            this.this$0.h();
            return;
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.c
        public int requestFusion(int r10) {
            if ((r10 & 2) == 0) goto L6;
            this.this$0.f9705q = true;
            return 2;
        L6:
            return 0;
        }
    }

    UnicastProcessor(int r10) {
        this(r10, null, true);
    }

    UnicastProcessor(int r10, Runnable r11) {
        this(r10, r11, true);
    }

    UnicastProcessor(int r10, Runnable r11, boolean r12) {
        this.f9695g = new io.reactivex.internal.queue.a(io.reactivex.internal.functions.a.e(r10, "capacityHint"));
        this.f9696h = new AtomicReference(r11);
        this.f9697i = r12;
        this.f9700l = new AtomicReference();
        this.f9702n = new AtomicBoolean();
        this.f9703o = new UnicastQueueSubscription(this);
        this.f9704p = new AtomicLong();
    }

    public static <T> UnicastProcessor<T> e() {
        return new UnicastProcessor(e.a());
    }

    public static <T> UnicastProcessor<T> f(int r10, Runnable r11) {
        io.reactivex.internal.functions.a.d(r11, "onTerminate");
        return new UnicastProcessor(r10, r11);
    }

    @Override // xb.e
    protected void c(c<? super T> r10) {
        if (this.f9702n.get() == false) goto L5;
    L10:
        EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), r10);
        return;
    L5:
        if (this.f9702n.compareAndSet(false, true) == false) goto L10;
        r10.onSubscribe(this.f9703o);
        this.f9700l.set(r10);
        if (this.f9701m == false) goto L9;
        this.f9700l.lazySet(null);
        return;
    L9:
        h();
    }

    boolean d(boolean r10, boolean r11, boolean r12, c<? super T> r13, io.reactivex.internal.queue.a<T> r14) {
        if (this.f9701m == false) goto L6;
        r14.clear();
        this.f9700l.lazySet(null);
        return true;
    L6:
        if (r11 == false) goto L18;
        if (r10 == true) goto L9;
    L12:
        if (r12 == false) goto L20;
        Throwable r15 = this.f9699k;
        this.f9700l.lazySet(null);
        if (r15 == null) goto L16;
        r13.onError(r15);
    L17:
        return true;
    L16:
        r13.onComplete();
        goto L17
    L20:
        return false;
    L9:
        if (this.f9699k == null) goto L12;
        r14.clear();
        this.f9700l.lazySet(null);
        r13.onError(this.f9699k);
        return true;
    L18:
        return false;
    }

    void g() {
        Runnable r10 = this.f9696h.getAndSet(null);
        if (r10 == null) goto L6;
        r10.run();
        return;
    }

    void h() {
        if (this.f9703o.getAndIncrement() == 0) goto L5;
        return;
    L5:
        int r10 = 1;
    L6:
        c<? super T> r11 = this.f9700l.get();
        if (r11 != null) goto L9;
        r10 = this.f9703o.addAndGet(-r10);
        if (r10 != 0) goto L6;
        return;
    L9:
        if (this.f9705q == false) goto L11;
        i(r11);
        return;
    L11:
        j(r11);
    }

    void i(c<? super T> r10) {
        io.reactivex.internal.queue.a<T> r11 = this.f9695g;
        int r12 = 1;
        boolean r13 = !this.f9697i;
    L4:
        if (this.f9701m == true) goto L5;
        boolean r14 = this.f9698j;
        if (r13 == false) goto L14;
        if (r14 == false) goto L14;
        if (this.f9699k == null) goto L14;
        r11.clear();
        this.f9700l.lazySet(null);
        r10.onError(this.f9699k);
        return;
    L14:
        r10.onNext(null);
        if (r14 == true) goto L16;
        r12 = this.f9703o.addAndGet(-r12);
        if (r12 != 0) goto L4;
        return;
    L16:
        this.f9700l.lazySet(null);
        Throwable r15 = this.f9699k;
        if (r15 == null) goto L19;
        r10.onError(r15);
        return;
    L19:
        r10.onComplete();
        return;
    L5:
        r11.clear();
        this.f9700l.lazySet(null);
    }

    void j(c<? super T> r18) {
        io.reactivex.internal.queue.a<T> r10 = this.f9695g;
        boolean r11 = true;
        boolean r12 = !this.f9697i;
        int r13 = 1;
    L3:
        long r14 = this.f9704p.get();
        long r15 = 0;
    L5:
        if (r14 == r15) goto L17;
        boolean r16 = this.f9698j;
        T r17 = r10.poll();
        if (r17 != null) goto L9;
        boolean r19 = r11;
    L10:
        long r110 = r15;
        if (d(r12, r16, r19, r18, r10) == true) goto L12;
        if (r19 == true) goto L18;
        r18.onNext(r17);
        r15 = 1 + r110;
        r11 = true;
    L18:
        if (r14 != r15) goto L23;
        if (d(r12, this.f9698j, r10.isEmpty(), r18, r10) == false) goto L23;
        return;
    L23:
        if (r110 != 0) goto L25;
    L27:
        r13 = this.f9703o.addAndGet(-r13);
        if (r13 == 0) goto L29;
        r11 = true;
        goto L3
    L29:
        return;
    L25:
        if (r14 == Long.MAX_VALUE) goto L27;
        this.f9704p.addAndGet(-r110);
        goto L27
    L12:
        return;
    L9:
        r19 = false;
        goto L10
    L17:
        r110 = r15;
        goto L18
    }

    @Override // tc.c
    public void onComplete() {
        if (this.f9698j == false) goto L5;
        return;
    L5:
        if (this.f9701m == true) goto L10;
        this.f9698j = true;
        g();
        h();
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        io.reactivex.internal.functions.a.d(r10, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f9698j == false) goto L5;
    L9:
        dc.a.n(r10);
        return;
    L5:
        if (this.f9701m == true) goto L9;
        this.f9699k = r10;
        this.f9698j = true;
        g();
        h();
    }

    @Override // tc.c
    public void onNext(T r10) {
        io.reactivex.internal.functions.a.d(r10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f9698j == false) goto L5;
        return;
    L5:
        if (this.f9701m == true) goto L10;
        this.f9695g.offer(r10);
        h();
        return;
    }

    @Override // tc.c
    public void onSubscribe(d r10) {
        if (this.f9698j == false) goto L5;
    L8:
        r10.cancel();
        return;
    L5:
        if (this.f9701m == true) goto L8;
        r10.request(Long.MAX_VALUE);
    }
}
