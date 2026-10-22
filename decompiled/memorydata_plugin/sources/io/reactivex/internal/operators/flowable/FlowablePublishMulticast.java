package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.a.f;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowablePublishMulticast<T, R> extends io.reactivex.internal.operators.flowable.a<T, R> {
    final h<? super g<T>, ? extends org.a.b<? extends R>> c;
    final int d;
    final boolean e;

    static final class MulticastSubscription<T> extends AtomicLong implements org.a.d {
        private static final long serialVersionUID = 8664815189257569791L;
        final org.a.c<? super T> downstream;
        long emitted;
        final a<T> parent;

        MulticastSubscription(org.a.c<? super T> r3, a<T> r4) {
            this.downstream = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.parent = r4;
        }

        @Override // org.a.d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
            this.parent.b(this);
            this.parent.b();
            return;
        }

        public boolean isCancelled() {
            if (get() != Long.MIN_VALUE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.b(this, r2);
            this.parent.b();
            return;
        }
    }

    static final class a<T> extends g<T> implements io.reactivex.disposables.b, j<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final MulticastSubscription[] f16783b = null;
        static final MulticastSubscription[] c = null;
        final AtomicInteger d;
        final AtomicReference<MulticastSubscription<T>[]> e;
        final int f;
        final int g;
        final boolean h;
        final AtomicReference<org.a.d> i;
        volatile f<T> j;
        int k;
        volatile boolean l;
        Throwable m;
        int n;

        static {
            f16783b = new MulticastSubscription[0];
            c = new MulticastSubscription[0];
        }

        a(int r2, boolean r3) {
            this.f = r2;
            this.g = r2 - (r2 >> 2);
            this.h = r3;
            this.d = new AtomicInteger();
            this.i = new AtomicReference();
            this.e = new AtomicReference(f16783b);
        }

        void a(Throwable r8) {
            MulticastSubscription[] r7 = (MulticastSubscription[]) ZeusTransformUtils.preCheckCast(this.e.getAndSet(c), MulticastSubscription[].class, "com.obric.memorydata.plugin");
            int r0 = r7.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            MulticastSubscription r2 = r7[r1];
            if (r2.get() == Long.MIN_VALUE) goto L7;
            r2.downstream.onError(r8);
        L7:
            r1 = r1 + 1;
            goto L3
        }

        @Override // io.reactivex.g
        public void a(org.a.c<? super T> r3) {
            org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            MulticastSubscription<T> r0 = new MulticastSubscription(r4, this);
            r4.onSubscribe(r0);
            if (a(r0) == true) goto L5;
            Throwable r2 = this.m;
            if (r2 == null) goto L12;
            r4.onError(r2);
            return;
        L12:
            r4.onComplete();
            return;
        L5:
            if (r0.isCancelled() == false) goto L8;
            b(r0);
            return;
        L8:
            b();
        }

        boolean a(MulticastSubscription<T> r5) {
        L2:
            MulticastSubscription<T>[] r0 = (MulticastSubscription[]) ZeusTransformUtils.preCheckCast(this.e.get(), MulticastSubscription[].class, "com.obric.memorydata.plugin");
            if (r0 == c) goto L4;
            int r1 = r0.length;
            MulticastSubscription<T>[] r3 = new MulticastSubscription[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (this.e.compareAndSet(r0, r3) == false) goto L2;
            return true;
        L4:
            return false;
        }

        void b() {
            if (this.d.getAndIncrement() == 0) goto L5;
            return;
        L5:
            f<T> r0 = this.j;
            int r2 = this.n;
            int r3 = this.g;
            if (this.k == 1) goto L8;
            boolean r4 = true;
        L9:
            AtomicReference<MulticastSubscription<T>[]> r7 = this.e;
            MulticastSubscription[] r8 = (MulticastSubscription[]) ZeusTransformUtils.preCheckCast(r7.get(), MulticastSubscription[].class, "com.obric.memorydata.plugin");
            int r9 = 1;
        L10:
            int r11 = r8.length;
            if (r0 == null) goto L99;
            if (r11 == 0) goto L99;
            int r12 = r8.length;
            long r13 = Long.MAX_VALUE;
            long r16 = Long.MAX_VALUE;
            int r15 = 0;
        L15:
            if (r15 >= r12) goto L23;
            MulticastSubscription r5 = r8[r15];
            AtomicReference<MulticastSubscription<T>[]> r22 = r7;
            long r20 = r5.get() - r5.emitted;
            if (r20 != Long.MIN_VALUE) goto L19;
            r11 = r11 - 1;
        L22:
            r15 = r15 + 1;
            r7 = r22;
            goto L15
        L19:
            if (r16 <= r20) goto L22;
            r16 = r20;
            goto L22
        L23:
            AtomicReference<MulticastSubscription<T>[]> r23 = r7;
            long r6 = 0;
            if (r11 != 0) goto L27;
            r16 = 0;
        L27:
            if (r16 == r6) goto L78;
            if (isDisposed() == true) goto L30;
            boolean r14 = this.l;
            if (r14 == true) goto L35;
        L107:
            T r17 = r0.poll();     // Catch: Throwable -> L75
            if (r17 != null) goto L43;
            boolean r18 = true;
        L44:
            if (r14 == false) goto L51;
            if (r18 == false) goto L51;
            Throwable r1 = this.m;
            if (r1 == null) goto L49;
            a(r1);
            return;
        L49:
            c();
            return;
        L51:
            if (r18 == true) goto L78;
            int r10 = r8.length;
            int r19 = 0;
            boolean r110 = false;
        L55:
            if (r19 >= r10) goto L64;
            MulticastSubscription r21 = r8[r19];
            long r24 = r21.get();
            if (r24 != Long.MIN_VALUE) goto L59;
            r110 = true;
        L63:
            r19 = r19 + 1;
            r13 = Long.MAX_VALUE;
            goto L55
        L59:
            if (r24 == r13) goto L61;
            r21.emitted++;
        L61:
            r21.downstream.onNext(r17);
            goto L63
        L64:
            r16 = r16 - 1;
            if (r4 == false) goto L69;
            r2 = r2 + 1;
            if (r2 != r3) goto L69;
            ((org.a.d) ZeusTransformUtils.preCheckCast(this.i.get(), org.a.d.class, "com.obric.memorydata.plugin")).request(r3);
            r2 = 0;
        L69:
            MulticastSubscription[] r25 = (MulticastSubscription[]) ZeusTransformUtils.preCheckCast(r23.get(), MulticastSubscription[].class, "com.obric.memorydata.plugin");
            if (r110 == true) goto L74;
            if (r25 != r8) goto L74;
            r6 = 0;
            r13 = Long.MAX_VALUE;
        L74:
            r8 = r25;
        L106:
            r7 = r23;
            goto L10
        L43:
            r18 = false;
        L75:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            SubscriptionHelper.cancel(this.i);
            a(th);
            return;
        L35:
            if (this.h == true) goto L107;
            Throwable r111 = this.m;
            if (r111 == null) goto L107;
            a(r111);
            return;
        L30:
            r0.clear();
            return;
        L78:
            if (r16 == r6) goto L80;
        L100:
            this.n = r2;
            r9 = this.d.addAndGet(-r9);
            if (r9 == 0) goto L102;
            if (r0 != null) goto L105;
            r0 = this.j;
        L105:
            r8 = (MulticastSubscription[]) ZeusTransformUtils.preCheckCast(r23.get(), MulticastSubscription[].class, "com.obric.memorydata.plugin");
            goto L106
        L102:
            return;
        L80:
            if (isDisposed() == true) goto L81;
            boolean r26 = this.l;
            if (r26 == true) goto L86;
        L91:
            if (r26 == false) goto L100;
            if (r0.isEmpty() == false) goto L100;
            Throwable r27 = this.m;
            if (r27 == null) goto L97;
            a(r27);
            return;
        L97:
            c();
            return;
        L86:
            if (this.h == true) goto L91;
            Throwable r28 = this.m;
            if (r28 == null) goto L91;
            a(r28);
            return;
        L81:
            r0.clear();
            return;
        L99:
            r23 = r7;
            goto L100
        L8:
            r4 = false;
            goto L9
        }

        void b(MulticastSubscription<T> r7) {
        L2:
            MulticastSubscription<T>[] r0 = (MulticastSubscription[]) ZeusTransformUtils.preCheckCast(this.e.get(), MulticastSubscription[].class, "com.obric.memorydata.plugin");
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
            MulticastSubscription<T>[] r3 = f16783b;
        L18:
            if (this.e.compareAndSet(r0, r3) == false) goto L2;
            return;
        L16:
            MulticastSubscription<T>[] r5 = new MulticastSubscription[r1 - 1];
            System.arraycopy(r0, 0, r5, 0, r2);
            System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
            r3 = r5;
            goto L18
        L12:
            return;
        }

        void c() {
            MulticastSubscription[] r7 = (MulticastSubscription[]) ZeusTransformUtils.preCheckCast(this.e.getAndSet(c), MulticastSubscription[].class, "com.obric.memorydata.plugin");
            int r0 = r7.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            MulticastSubscription r2 = r7[r1];
            if (r2.get() == Long.MIN_VALUE) goto L7;
            r2.downstream.onComplete();
        L7:
            r1 = r1 + 1;
            goto L3
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SubscriptionHelper.cancel(this.i);
            if (this.d.getAndIncrement() != 0) goto L8;
            f<T> r1 = this.j;
            if (r1 == null) goto L9;
            r1.clear();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (this.i.get() != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.l == true) goto L6;
            this.l = true;
            b();
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.l == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.m = r2;
            this.l = true;
            b();
        }

        @Override // org.a.c
        public void onNext(T r3) {
            if (this.l == false) goto L6;
            return;
        L6:
            if (this.k == 0) goto L8;
        L11:
            b();
            return;
        L8:
            if (this.j.offer(r3) == true) goto L11;
            ((org.a.d) ZeusTransformUtils.preCheckCast(this.i.get(), org.a.d.class, "com.obric.memorydata.plugin")).cancel();
            onError(new MissingBackpressureException());
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r4) {
            org.a.d r5 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r4, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.setOnce(this.i, r5) == true) goto L5;
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r5, io.reactivex.internal.a.d.class) == false) goto L14;
            io.reactivex.internal.a.d r0 = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r5, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
            int r1 = r0.requestFusion(3);
            if (r1 != 1) goto L11;
            this.k = r1;
            this.j = r0;
            this.l = true;
            b();
            return;
        L11:
            if (r1 != 2) goto L14;
            this.k = r1;
            this.j = r0;
            io.reactivex.internal.util.h.a(r5, this.f);
            return;
        L14:
            this.j = io.reactivex.internal.util.h.a(this.f);
            io.reactivex.internal.util.h.a(r5, this.f);
        }
    }

    static final class b<R> implements j<R>, org.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final org.a.c<? super R> f16784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final a<?> f16785b;
        org.a.d c;

        b(org.a.c<? super R> r3, a<?> r4) {
            this.f16784a = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.f16785b = r4;
        }

        @Override // org.a.d
        public void cancel() {
            this.c.cancel();
            this.f16785b.dispose();
        }

        @Override // org.a.c
        public void onComplete() {
            this.f16784a.onComplete();
            this.f16785b.dispose();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            this.f16784a.onError(r2);
            this.f16785b.dispose();
        }

        @Override // org.a.c
        public void onNext(R r1) {
            this.f16784a.onNext(r1);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.c, r4) == false) goto L6;
            this.c = r4;
            this.f16784a.onSubscribe(this);
            return;
        }

        @Override // org.a.d
        public void request(long r1) {
            this.c.request(r1);
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super R> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        a r0 = new a(this.d, this.e);
        org.a.b r1 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.c.apply(r0), "selector returned a null Publisher"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        r1.subscribe(new b(r6, r0));
        this.f16812b.a(r0);
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(th, r6);
    }
}
