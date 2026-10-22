package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableCache<T> extends io.reactivex.internal.operators.flowable.a<T, T> implements j<T> {
    static final CacheSubscription[] f = null;
    static final CacheSubscription[] g = null;
    final AtomicBoolean c;
    final int d;
    final AtomicReference<CacheSubscription<T>[]> e;
    volatile long h;
    final a<T> i;
    a<T> j;
    int k;
    Throwable l;
    volatile boolean m;

    static final class CacheSubscription<T> extends AtomicInteger implements org.a.d {
        private static final long serialVersionUID = 6770240836423125754L;
        final org.a.c<? super T> downstream;
        long index;
        a<T> node;
        int offset;
        final FlowableCache<T> parent;
        final AtomicLong requested;

        CacheSubscription(org.a.c<? super T> r3, FlowableCache<T> r4) {
            this.downstream = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.parent = r4;
            this.node = r4.i;
            this.requested = new AtomicLong();
        }

        @Override // org.a.d
        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
            this.parent.b(this);
            return;
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.b(this.requested, r2);
            this.parent.c(this);
            return;
        }
    }

    static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final T[] f16761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile a<T> f16762b;

        a(int r3) {
            this.f16761a = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(new Object[r3], Object[].class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f = new CacheSubscription[0];
        g = new CacheSubscription[0];
    }

    void a(CacheSubscription<T> r5) {
    L2:
        CacheSubscription<T>[] r0 = (CacheSubscription[]) ZeusTransformUtils.preCheckCast(this.e.get(), CacheSubscription[].class, "com.obric.memorydata.plugin");
        if (r0 == g) goto L4;
        int r1 = r0.length;
        CacheSubscription<T>[] r2 = new CacheSubscription[r1 + 1];
        System.arraycopy(r0, 0, r2, 0, r1);
        r2[r1] = r5;
        if (this.e.compareAndSet(r0, r2) == false) goto L2;
        return;
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        CacheSubscription<T> r0 = new CacheSubscription(r5, this);
        r5.onSubscribe(r0);
        a(r0);
        if (this.c.get() == false) goto L5;
    L7:
        c(r0);
        return;
    L5:
        if (this.c.compareAndSet(false, true) == false) goto L7;
        this.f16812b.a(this);
    }

    void b(CacheSubscription<T> r7) {
    L2:
        CacheSubscription<T>[] r0 = (CacheSubscription[]) ZeusTransformUtils.preCheckCast(this.e.get(), CacheSubscription[].class, "com.obric.memorydata.plugin");
        int r1 = r0.length;
        if (r1 == 0) goto L4;
        int r2 = -1;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L11;
        if (r0[r4] == r7) goto L9;
        r4 = r4 + 1;
        goto L6
    L9:
        r2 = r4;
    L11:
        if (r2 < 0) goto L12;
        if (r1 != 1) goto L16;
        CacheSubscription<T>[] r3 = f;
    L18:
        if (this.e.compareAndSet(r0, r3) == false) goto L2;
        return;
    L16:
        CacheSubscription<T>[] r5 = new CacheSubscription[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r2);
        System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
        r3 = r5;
        goto L18
    L12:
        return;
    }

    void c(CacheSubscription<T> r18) {
        if (r18.getAndIncrement() == 0) goto L5;
        return;
    L5:
        long r2 = r18.index;
        int r4 = r18.offset;
        a<T> r5 = r18.node;
        AtomicLong r6 = r18.requested;
        org.a.c<? super T> r7 = r18.downstream;
        int r8 = this.d;
        int r10 = 1;
    L6:
        boolean r11 = this.m;
        if (this.h != r2) goto L9;
        boolean r12 = true;
    L11:
        if (r11 == false) goto L18;
        if (r12 == false) goto L18;
        r18.node = null;
        Throwable r0 = this.l;
        if (r0 == null) goto L16;
        r7.onError(r0);
        return;
    L16:
        r7.onComplete();
        return;
    L18:
        if (r12 == true) goto L28;
        long r13 = r6.get();
        if (r13 == Long.MIN_VALUE) goto L21;
        if (r13 == r2) goto L28;
        if (r4 != r8) goto L27;
        r5 = r5.f16762b;
        r4 = 0;
    L27:
        r7.onNext(r5.f16761a[r4]);
        r4 = r4 + 1;
        r2 = r2 + 1;
        goto L6
    L21:
        r18.node = null;
        return;
    L28:
        r18.index = r2;
        r18.offset = r4;
        r18.node = r5;
        r10 = r18.addAndGet(-r10);
        if (r10 != 0) goto L6;
        return;
    L9:
        r12 = false;
        goto L11
    }

    @Override // org.a.c
    public void onComplete() {
        this.m = true;
        CacheSubscription<T>[] r0 = (CacheSubscription[]) ZeusTransformUtils.preCheckCast(this.e.getAndSet(g), CacheSubscription[].class, "com.obric.memorydata.plugin");
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        c(r0[r2]);
        r2 = r2 + 1;
        goto L3
    }

    @Override // org.a.c
    public void onError(Throwable r4) {
        if (this.m == false) goto L6;
        io.reactivex.d.a.a(r4);
        return;
    L6:
        this.l = r4;
        this.m = true;
        CacheSubscription<T>[] r5 = (CacheSubscription[]) ZeusTransformUtils.preCheckCast(this.e.getAndSet(g), CacheSubscription[].class, "com.obric.memorydata.plugin");
        int r0 = r5.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L9;
        c(r5[r1]);
        r1 = r1 + 1;
        goto L7
    }

    @Override // org.a.c
    public void onNext(T r6) {
        int r0 = this.k;
        int r2 = 0;
        if (r0 != this.d) goto L5;
        a<T> r1 = new a(r0);
        r1.f16761a[0] = r6;
        this.k = 1;
        this.j.f16762b = r1;
        this.j = r1;
    L6:
        this.h++;
        CacheSubscription<T>[] r7 = (CacheSubscription[]) ZeusTransformUtils.preCheckCast(this.e.get(), CacheSubscription[].class, "com.obric.memorydata.plugin");
        int r3 = r7.length;
    L7:
        if (r2 >= r3) goto L9;
        c(r7[r2]);
        r2 = r2 + 1;
        goto L7
    L9:
        return;
    L5:
        this.j.f16761a[r0] = r6;
        this.k = r0 + 1;
        goto L6
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(org.a.d r3) {
        ((org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin")).request(Long.MAX_VALUE);
    }
}
