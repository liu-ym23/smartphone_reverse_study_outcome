package io.reactivex.processors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.a.f;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class MulticastProcessor<T> extends a<T> {
    static final MulticastSubscription[] n = null;
    static final MulticastSubscription[] o = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicInteger f17163b;
    final AtomicReference<d> c;
    final AtomicReference<MulticastSubscription<T>[]> d;
    final AtomicBoolean e;
    final int f;
    final int g;
    final boolean h;
    volatile f<T> i;
    volatile boolean j;
    volatile Throwable k;
    int l;
    int m;

    static final class MulticastSubscription<T> extends AtomicLong implements d {
        private static final long serialVersionUID = -363282618957264509L;
        final c<? super T> downstream;
        long emitted;
        final MulticastProcessor<T> parent;

        MulticastSubscription(c<? super T> r3, MulticastProcessor<T> r4) {
            this.downstream = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            this.parent = r4;
        }

        @Override // org.a.d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
            this.parent.b(this);
            return;
        }

        void onComplete() {
            if (get() == Long.MIN_VALUE) goto L6;
            this.downstream.onComplete();
            return;
        }

        void onError(Throwable r5) {
            if (get() == Long.MIN_VALUE) goto L6;
            this.downstream.onError(r5);
            return;
        }

        void onNext(T r5) {
            if (get() == Long.MIN_VALUE) goto L6;
            this.emitted++;
            this.downstream.onNext(r5);
            return;
        }

        @Override // org.a.d
        public void request(long r9) {
            if (SubscriptionHelper.validate(r9) == false) goto L21;
        L4:
            long r0 = get();
            if (r0 == Long.MIN_VALUE) goto L22;
            long r2 = Long.MAX_VALUE;
            if (r0 == Long.MAX_VALUE) goto L23;
            long r4 = r0 + r9;
            if (r4 < 0) goto L14;
            r2 = r4;
        L14:
            if (compareAndSet(r0, r2) == false) goto L4;
            this.parent.c();
            return;
        L23:
            return;
        L22:
            return;
        }
    }

    static {
        n = new MulticastSubscription[0];
        o = new MulticastSubscription[0];
    }

    @Override // io.reactivex.g
    public void a(c<? super T> r6) {
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.memorydata.plugin");
        MulticastSubscription<T> r0 = new MulticastSubscription(r7, this);
        r7.onSubscribe(r0);
        if (a(r0) == false) goto L9;
        if (r0.get() != Long.MIN_VALUE) goto L7;
        b(r0);
        return;
    L7:
        c();
        return;
    L9:
        if (this.e.get() == false) goto L11;
    L12:
        Throwable r5 = this.k;
        if (r5 == null) goto L16;
        r7.onError(r5);
        return;
    L16:
        r7.onComplete();
        return;
    L11:
        if (this.h == true) goto L16;
        goto L12
    }

    boolean a(MulticastSubscription<T> r5) {
    L2:
        MulticastSubscription<T>[] r0 = (MulticastSubscription[]) ZeusTransformUtils.preCheckCast(this.d.get(), MulticastSubscription[].class, "com.obric.memorydata.plugin");
        if (r0 == o) goto L4;
        int r1 = r0.length;
        MulticastSubscription<T>[] r3 = new MulticastSubscription[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.d.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void b(MulticastSubscription<T> r7) {
    L2:
        MulticastSubscription<T>[] r0 = (MulticastSubscription[]) ZeusTransformUtils.preCheckCast(this.d.get(), MulticastSubscription[].class, "com.obric.memorydata.plugin");
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
        if (r2 < 0) goto L41;
        if (r1 == 1) goto L16;
        MulticastSubscription<T>[] r5 = new MulticastSubscription[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r2);
        System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
        if (this.d.compareAndSet(r0, r5) == false) goto L2;
        return;
    L16:
        if (this.h == true) goto L18;
        if (this.d.compareAndSet(r0, n) == false) goto L2;
        return;
    L18:
        if (this.d.compareAndSet(r0, o) == false) goto L2;
        SubscriptionHelper.cancel(this.c);
        this.e.set(true);
        return;
    L41:
        return;
    }

    void c() {
        if (this.f17163b.getAndIncrement() == 0) goto L5;
        return;
    L5:
        AtomicReference<MulticastSubscription<T>[]> r2 = this.d;
        int r0 = this.l;
        int r3 = this.g;
        int r4 = this.m;
        int r6 = 1;
    L6:
        f<T> r7 = this.i;
        if (r7 == null) goto L80;
        MulticastSubscription[] r8 = (MulticastSubscription[]) ZeusTransformUtils.preCheckCast(r2.get(), MulticastSubscription[].class, "com.obric.memorydata.plugin");
        if (r8.length == 0) goto L80;
        int r9 = r8.length;
        long r11 = -1;
        int r15 = r6;
        long r5 = -1;
        int r14 = 0;
    L12:
        if (r14 >= r9) goto L20;
        MulticastSubscription r13 = r8[r14];
        long r18 = r13.get();
        if (r18 < 0) goto L19;
        if (r5 != r11) goto L18;
        r5 = r18 - r13.emitted;
        goto L19
    L18:
        r5 = Math.min(r5, r18 - r13.emitted);
    L19:
        r14 = r14 + 1;
        r11 = -1;
        goto L12
    L20:
        long r12 = r5;
        int r10 = r0;
    L22:
        if (r12 <= 0) goto L59;
        MulticastSubscription[] r1 = (MulticastSubscription[]) ZeusTransformUtils.preCheckCast(r2.get(), MulticastSubscription[].class, "com.obric.memorydata.plugin");
        if (r1 == o) goto L25;
        if (r8 != r1) goto L65;
        boolean r16 = this.j;
        T r17 = r7.poll();     // Catch: Throwable -> L32
    L34:
        if (r17 != null) goto L36;
        boolean r19 = true;
    L37:
        if (r16 == false) goto L48;
        if (r19 == false) goto L48;
        Throwable r20 = this.k;
        if (r20 == null) goto L44;
        MulticastSubscription[] r21 = (MulticastSubscription[]) ZeusTransformUtils.preCheckCast(r2.getAndSet(o), MulticastSubscription[].class, "com.obric.memorydata.plugin");
        int r22 = r21.length;
        int r110 = 0;
    L42:
        if (r110 >= r22) goto L47;
        r21[r110].onError(r20);
        r110 = r110 + 1;
        goto L42
    L47:
        return;
    L44:
        MulticastSubscription[] r23 = (MulticastSubscription[]) ZeusTransformUtils.preCheckCast(r2.getAndSet(o), MulticastSubscription[].class, "com.obric.memorydata.plugin");
        int r24 = r23.length;
        int r111 = 0;
    L45:
        if (r111 >= r24) goto L117;
        r23[r111].onComplete();
        r111 = r111 + 1;
        goto L45
    L117:
        return;
    L48:
        if (r19 == true) goto L59;
        int r25 = r8.length;
        int r26 = 0;
    L51:
        if (r26 >= r25) goto L53;
        r8[r26].onNext(r17);
        r26 = r26 + 1;
        goto L51
    L53:
        r12 = r12 - 1;
        if (r4 == 1) goto L22;
        r10 = r10 + 1;
        if (r10 != r3) goto L22;
        ((d) ZeusTransformUtils.preCheckCast(this.c.get(), d.class, "com.obric.memorydata.plugin")).request(r3);
        r10 = 0;
        goto L22
    L36:
        r19 = false;
    L32:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        SubscriptionHelper.cancel(this.c);
        this.k = th;
        this.j = true;
        r17 = null;
        r16 = true;
    L65:
        r0 = r10;
        r6 = r15;
        goto L6
    L25:
        r7.clear();
        return;
    L59:
        if (r12 != 0) goto L79;
        MulticastSubscription<T>[] r27 = (MulticastSubscription[]) ZeusTransformUtils.preCheckCast(r2.get(), MulticastSubscription[].class, "com.obric.memorydata.plugin");
        MulticastSubscription<T>[] r28 = o;
        if (r27 == r28) goto L62;
        if (r8 != r27) goto L65;
        if (this.j == false) goto L79;
        if (r7.isEmpty() == false) goto L79;
        Throwable r29 = this.k;
        if (r29 == null) goto L75;
        MulticastSubscription[] r30 = (MulticastSubscription[]) ZeusTransformUtils.preCheckCast(r2.getAndSet(r28), MulticastSubscription[].class, "com.obric.memorydata.plugin");
        int r31 = r30.length;
        int r112 = 0;
    L73:
        if (r112 >= r31) goto L78;
        r30[r112].onError(r29);
        r112 = r112 + 1;
        goto L73
    L78:
        return;
    L75:
        MulticastSubscription[] r32 = (MulticastSubscription[]) ZeusTransformUtils.preCheckCast(r2.getAndSet(r28), MulticastSubscription[].class, "com.obric.memorydata.plugin");
        int r33 = r32.length;
        int r113 = 0;
    L76:
        if (r113 >= r33) goto L118;
        r32[r113].onComplete();
        r113 = r113 + 1;
        goto L76
    L118:
        return;
    L62:
        r7.clear();
        return;
    L79:
        r0 = r10;
    L81:
        this.l = r0;
        r6 = this.f17163b.addAndGet(-r15);
        if (r6 != 0) goto L6;
        return;
    L80:
        r15 = r6;
        goto L81
    }

    @Override // org.a.c
    public void onComplete() {
        if (this.e.compareAndSet(false, true) == false) goto L6;
        this.j = true;
        c();
        return;
    }

    @Override // org.a.c
    public void onError(Throwable r4) {
        io.reactivex.internal.functions.a.a(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.e.compareAndSet(false, true) == false) goto L5;
        this.k = r4;
        this.j = true;
        c();
        return;
    L5:
        io.reactivex.d.a.a(r4);
    }

    @Override // org.a.c
    public void onNext(T r2) {
        if (this.e.get() == false) goto L6;
        return;
    L6:
        if (this.m != 0) goto L11;
        io.reactivex.internal.functions.a.a(r2, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.i.offer(r2) == true) goto L11;
        SubscriptionHelper.cancel(this.c);
        onError(new MissingBackpressureException());
        return;
    L11:
        c();
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        if (SubscriptionHelper.setOnce(this.c, r5) == true) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, io.reactivex.internal.a.d.class) == false) goto L14;
        io.reactivex.internal.a.d r0 = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r5, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
        int r1 = r0.requestFusion(3);
        if (r1 != 1) goto L11;
        this.m = r1;
        this.i = r0;
        this.j = true;
        c();
        return;
    L11:
        if (r1 != 2) goto L14;
        this.m = r1;
        this.i = r0;
        r5.request(this.f);
        return;
    L14:
        this.i = new SpscArrayQueue(this.f);
        r5.request(this.f);
    }
}
