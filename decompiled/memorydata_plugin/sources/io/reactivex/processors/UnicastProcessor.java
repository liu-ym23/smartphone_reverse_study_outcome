package io.reactivex.processors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class UnicastProcessor<T> extends a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.internal.queue.a<T> f17166b;
    final AtomicReference<Runnable> c;
    final boolean d;
    volatile boolean e;
    Throwable f;
    final AtomicReference<c<? super T>> g;
    volatile boolean h;
    final AtomicBoolean i;
    final BasicIntQueueSubscription<T> j;
    final AtomicLong k;
    boolean l;

    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;
        final /* synthetic */ UnicastProcessor this$0;

        UnicastQueueSubscription(UnicastProcessor r1) {
            this.this$0 = r1;
        }

        @Override // org.a.d
        public void cancel() {
            if (this.this$0.h == false) goto L5;
            return;
        L5:
            this.this$0.h = true;
            this.this$0.d();
            this.this$0.g.lazySet(null);
            if (this.this$0.j.getAndIncrement() != 0) goto L11;
            this.this$0.g.lazySet(null);
            if (this.this$0.l == true) goto L12;
            this.this$0.f17166b.clear();
            return;
        L12:
            return;
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            this.this$0.f17166b.clear();
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return this.this$0.f17166b.isEmpty();
        }

        @Override // io.reactivex.internal.a.f
        public T poll() {
            return this.this$0.f17166b.poll();
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.this$0.k, r2);
            this.this$0.e();
            return;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.this$0.l = true;
            return 2;
        L6:
            return 0;
        }
    }

    UnicastProcessor(int r3) {
        this(r3, null, true);
    }

    UnicastProcessor(int r3, Runnable r4) {
        this(r3, (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin"), true);
    }

    UnicastProcessor(int r3, Runnable r4, boolean r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        this.f17166b = new io.reactivex.internal.queue.a(io.reactivex.internal.functions.a.a(r3, "capacityHint"));
        this.c = new AtomicReference(r6);
        this.d = r5;
        this.g = new AtomicReference();
        this.i = new AtomicBoolean();
        this.j = new UnicastQueueSubscription(this);
        this.k = new AtomicLong();
    }

    public static <T> UnicastProcessor<T> a(int r1) {
        return new UnicastProcessor(r1);
    }

    public static <T> UnicastProcessor<T> a(int r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r4, "onTerminate");
        return new UnicastProcessor(r2, r4);
    }

    public static <T> UnicastProcessor<T> c() {
        return new UnicastProcessor(a());
    }

    @Override // io.reactivex.g
    public void a(c<? super T> r4) {
        c<? super T> r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        if (this.i.get() == false) goto L5;
    L10:
        EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), r5);
        return;
    L5:
        if (this.i.compareAndSet(false, true) == false) goto L10;
        r5.onSubscribe(this.j);
        this.g.set(r5);
        if (this.h == false) goto L9;
        this.g.lazySet(null);
        return;
    L9:
        e();
    }

    boolean a(boolean r4, boolean r5, boolean r6, c<? super T> r7, io.reactivex.internal.queue.a<T> r8) {
        c r9 = (c) ZeusTransformUtils.wrapperContextForParams(r7, c.class, "com.obric.memorydata.plugin");
        if (this.h == false) goto L6;
        r8.clear();
        this.g.lazySet(null);
        return true;
    L6:
        if (r5 == false) goto L18;
        if (r4 == true) goto L9;
    L12:
        if (r6 == false) goto L20;
        Throwable r10 = this.f;
        this.g.lazySet(null);
        if (r10 == null) goto L16;
        r9.onError(r10);
    L17:
        return true;
    L16:
        r9.onComplete();
        goto L17
    L20:
        return false;
    L9:
        if (this.f == null) goto L12;
        r8.clear();
        this.g.lazySet(null);
        r9.onError(this.f);
        return true;
    L18:
        return false;
    }

    void b(c<? super T> r19) {
        c<? super T> r7 = (c) ZeusTransformUtils.wrapperContextForParams(r19, c.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.queue.a<T> r8 = this.f17166b;
        boolean r9 = true;
        boolean r10 = !this.d;
        int r11 = 1;
    L3:
        long r12 = this.k.get();
        long r4 = 0;
    L5:
        if (r12 == r4) goto L16;
        boolean r2 = this.e;
        T r3 = r8.poll();
        if (r3 != null) goto L9;
        boolean r17 = r9;
    L10:
        long r14 = r4;
        if (a(r10, r2, r17, r7, r8) == true) goto L12;
        if (r17 == true) goto L17;
        r7.onNext(r3);
        r4 = r14 + 1;
        r9 = true;
    L17:
        if (r12 != r4) goto L22;
        if (a(r10, this.e, r8.isEmpty(), r7, r8) == false) goto L22;
        return;
    L22:
        if (r14 != 0) goto L24;
    L26:
        r11 = this.j.addAndGet(-r11);
        if (r11 == 0) goto L28;
        r9 = true;
        goto L3
    L28:
        return;
    L24:
        if (r12 == Long.MAX_VALUE) goto L26;
        this.k.addAndGet(-r14);
        goto L26
    L12:
        return;
    L9:
        r17 = false;
        goto L10
    L16:
        r14 = r4;
        goto L17
    }

    void c(c<? super T> r7) {
        c r8 = (c) ZeusTransformUtils.wrapperContextForParams(r7, c.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.queue.a<T> r0 = this.f17166b;
        int r2 = 1;
        boolean r1 = !this.d;
    L4:
        if (this.h == true) goto L5;
        boolean r3 = this.e;
        if (r1 == false) goto L14;
        if (r3 == false) goto L14;
        if (this.f == null) goto L14;
        r0.clear();
        this.g.lazySet(null);
        r8.onError(this.f);
        return;
    L14:
        r8.onNext(null);
        if (r3 == true) goto L16;
        r2 = this.j.addAndGet(-r2);
        if (r2 != 0) goto L4;
        return;
    L16:
        this.g.lazySet(null);
        Throwable r6 = this.f;
        if (r6 == null) goto L19;
        r8.onError(r6);
        return;
    L19:
        r8.onComplete();
        return;
    L5:
        this.g.lazySet(null);
    }

    void d() {
        Runnable r2 = (Runnable) ZeusTransformUtils.preCheckCast(this.c.getAndSet(null), Runnable.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r2.run();
        return;
    }

    void e() {
        if (this.j.getAndIncrement() == 0) goto L5;
        return;
    L5:
        int r0 = 1;
        c<? super T> r1 = this.g.get();
        Class<c> r2 = c.class;
    L6:
        c<? super T> r3 = (c) ZeusTransformUtils.preCheckCast(r1, r2, "com.obric.memorydata.plugin");
        if (r3 != null) goto L9;
        r0 = this.j.addAndGet(-r0);
        if (r0 == 0) goto L15;
        r1 = this.g.get();
        r2 = c.class;
        goto L6
    L15:
        return;
    L9:
        if (this.l == false) goto L11;
        c(r3);
        return;
    L11:
        b(r3);
    }

    @Override // org.a.c
    public void onComplete() {
        if (this.e == false) goto L5;
        return;
    L5:
        if (this.h == true) goto L10;
        this.e = true;
        d();
        e();
        return;
    }

    @Override // org.a.c
    public void onError(Throwable r2) {
        io.reactivex.internal.functions.a.a(r2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.e == false) goto L5;
    L9:
        io.reactivex.d.a.a(r2);
        return;
    L5:
        if (this.h == true) goto L9;
        this.f = r2;
        this.e = true;
        d();
        e();
    }

    @Override // org.a.c
    public void onNext(T r2) {
        io.reactivex.internal.functions.a.a(r2, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.e == false) goto L5;
        return;
    L5:
        if (this.h == true) goto L10;
        this.f17166b.offer(r2);
        e();
        return;
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (this.e == false) goto L5;
    L8:
        r4.cancel();
        return;
    L5:
        if (this.h == true) goto L8;
        r4.request(Long.MAX_VALUE);
    }
}
