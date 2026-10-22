package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.g;
import io.reactivex.internal.a.f;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableZip<T, R> extends g<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final org.a.b<? extends T>[] f16811b;
    final Iterable<? extends org.a.b<? extends T>> c;
    final h<? super Object[], ? extends R> d;
    final int e;
    final boolean f;

    static final class ZipCoordinator<T, R> extends AtomicInteger implements org.a.d {
        private static final long serialVersionUID = -2434867452883857743L;
        volatile boolean cancelled;
        final Object[] current;
        final boolean delayErrors;
        final org.a.c<? super R> downstream;
        final AtomicThrowable errors;
        final AtomicLong requested;
        final ZipSubscriber<T, R>[] subscribers;
        final h<? super Object[], ? extends R> zipper;

        ZipCoordinator(org.a.c<? super R> r3, h<? super Object[], ? extends R> r4, int r5, int r6, boolean r7) {
            org.a.c<? super R> r8 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super Object[], ? extends R> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r8;
            this.zipper = r9;
            this.delayErrors = r7;
            ZipSubscriber<T, R>[] r10 = new ZipSubscriber[r5];
            int r11 = 0;
        L3:
            if (r11 >= r5) goto L5;
            r10[r11] = new ZipSubscriber(this, r6);
            r11 = r11 + 1;
            goto L3
        L5:
            this.current = new Object[r5];
            this.subscribers = r10;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            cancelAll();
            return;
        }

        void cancelAll() {
            ZipSubscriber<T, R>[] r3 = this.subscribers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].cancel();
            r1 = r1 + 1;
            goto L3
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            org.a.c<? super R> r2 = this.downstream;
            ZipSubscriber<T, R>[] r3 = this.subscribers;
            int r4 = r3.length;
            Object[] r5 = this.current;
            int r7 = 1;
        L6:
            long r8 = this.requested.get();
            long r12 = 0;
        L8:
            if (r8 == r12) goto L53;
            if (this.cancelled == true) goto L11;
            if (this.delayErrors == false) goto L15;
        L19:
            boolean r0 = false;
            int r10 = 0;
        L20:
            if (r10 >= r4) goto L46;
            ZipSubscriber<T, R> r11 = r3[r10];
            if (r5[r10] != null) goto L45;
            boolean r6 = r11.done;     // Catch: Throwable -> L40
            f<T> r13 = r11.queue;     // Catch: Throwable -> L40
            if (r13 == null) goto L26;
            T r14 = r13.poll();     // Catch: Throwable -> L40
        L27:
            if (r14 != null) goto L29;
            boolean r18 = true;
        L30:
            if (r6 == false) goto L37;
            if (r18 == false) goto L37;
            cancelAll();     // Catch: Throwable -> L40
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L35;
            r2.onError(this.errors.terminate());     // Catch: Throwable -> L40
            return;
        L35:
            r2.onComplete();     // Catch: Throwable -> L40
            return;
        L37:
            if (r18 == true) goto L44;
            r5[r10] = r14;     // Catch: Throwable -> L40
        L44:
            r0 = true;
            goto L45
        L29:
            r18 = false;
            goto L30
        L26:
            r14 = null;
        L40:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.errors.addThrowable(th);
            if (this.delayErrors == true) goto L44;
        L16:
            cancelAll();
        L17:
            r2.onError(this.errors.terminate());
            return;
        L45:
            r10 = r10 + 1;
            goto L20
        L46:
            if (r0 == true) goto L53;
            r2.onNext((Object) io.reactivex.internal.functions.a.a(this.zipper.apply(r5.clone()), "The zipper returned a null value"));
            r12 = r12 + 1;
            Arrays.fill(r5, null);
        L50:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancelAll();
            this.errors.addThrowable(th);
            goto L17
        L15:
            if (this.errors.get() == null) goto L19;
        L11:
            return;
        L53:
            if (r8 != r12) goto L89;
            if (this.cancelled == true) goto L56;
            if (this.delayErrors == false) goto L60;
        L62:
            int r15 = 0;
        L63:
            if (r15 >= r4) goto L89;
            ZipSubscriber<T, R> r1 = r3[r15];
            if (r5[r15] != null) goto L87;
            boolean r16 = r1.done;     // Catch: Throwable -> L83
            f<T> r9 = r1.queue;     // Catch: Throwable -> L83
            if (r9 == null) goto L69;
            T r17 = r9.poll();     // Catch: Throwable -> L83
        L70:
            if (r17 != null) goto L72;
            boolean r19 = true;
        L73:
            if (r16 == false) goto L80;
            if (r19 == false) goto L80;
            cancelAll();     // Catch: Throwable -> L83
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L78;
            r2.onError(this.errors.terminate());     // Catch: Throwable -> L83
            return;
        L78:
            r2.onComplete();     // Catch: Throwable -> L83
            return;
        L80:
            if (r19 == true) goto L87;
            r5[r15] = r17;     // Catch: Throwable -> L83
            goto L87
        L72:
            r19 = false;
            goto L73
        L69:
            r17 = null;
        L83:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.errors.addThrowable(th);
            if (this.delayErrors == false) goto L16;
        L87:
            r15 = r15 + 1;
            goto L63
        L60:
            if (this.errors.get() == null) goto L62;
        L56:
            return;
        L89:
            if (r12 == 0) goto L96;
            int r20 = r3.length;
            int r21 = 0;
        L91:
            if (r21 >= r20) goto L94;
            r3[r21].request(r12);
            r21 = r21 + 1;
            goto L91
        L94:
            if (r8 == Long.MAX_VALUE) goto L96;
            this.requested.addAndGet(-r12);
        L96:
            r7 = addAndGet(-r7);
            if (r7 != 0) goto L6;
        }

        void error(ZipSubscriber<T, R> r2, Throwable r3) {
            if (this.errors.addThrowable(r3) == false) goto L5;
            r2.done = true;
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r3);
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.requested, r2);
            drain();
            return;
        }

        void subscribe(org.a.b<? extends T>[] r5, int r6) {
            ZipSubscriber<T, R>[] r0 = this.subscribers;
            int r1 = 0;
        L3:
            if (r1 >= r6) goto L12;
            if (this.cancelled == true) goto L18;
            if (this.delayErrors == true) goto L11;
            if (this.errors.get() == null) goto L11;
            return;
        L11:
            r5[r1].subscribe(r0[r1]);
            r1 = r1 + 1;
            goto L3
        L18:
            return;
        }
    }

    static final class ZipSubscriber<T, R> extends AtomicReference<org.a.d> implements j<T>, org.a.d {
        private static final long serialVersionUID = -4627193790118206028L;
        volatile boolean done;
        final int limit;
        final ZipCoordinator<T, R> parent;
        final int prefetch;
        long produced;
        f<T> queue;
        int sourceMode;

        ZipSubscriber(ZipCoordinator<T, R> r1, int r2) {
            this.parent = r1;
            this.prefetch = r2;
            this.limit = r2 - (r2 >> 2);
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            this.parent.error(this, r2);
        }

        @Override // org.a.c
        public void onNext(T r3) {
            if (this.sourceMode == 2) goto L5;
            this.queue.offer(r3);
        L5:
            this.parent.drain();
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r4) {
            org.a.d r5 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r4, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.setOnce(this, r5) == true) goto L5;
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r5, io.reactivex.internal.a.d.class) == false) goto L14;
            io.reactivex.internal.a.d r0 = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r5, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
            int r1 = r0.requestFusion(7);
            if (r1 != 1) goto L11;
            this.sourceMode = r1;
            this.queue = r0;
            this.done = true;
            this.parent.drain();
            return;
        L11:
            if (r1 != 2) goto L14;
            this.sourceMode = r1;
            this.queue = r0;
            r5.request(this.prefetch);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.prefetch);
            r5.request(this.prefetch);
        }

        @Override // org.a.d
        public void request(long r3) {
            if (this.sourceMode == 1) goto L9;
            long r0 = this.produced + r3;
            if (r0 < this.limit) goto L7;
            this.produced = 0;
            ((org.a.d) ZeusTransformUtils.preCheckCast(get(), org.a.d.class, "com.obric.memorydata.plugin")).request(r0);
            return;
        L7:
            this.produced = r0;
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super R> r10) {
        org.a.c r11 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r10, org.a.c.class, "com.obric.memorydata.plugin");
        org.a.b<? extends T>[] r0 = this.f16811b;
        if (r0 != null) goto L11;
        r0 = new org.a.b[8];
        Iterator<? extends org.a.b<? extends T>> r2 = this.c.iterator();
        int r4 = 0;
    L6:
        if (r2.hasNext() == false) goto L12;
        org.a.b<? extends T> r5 = (org.a.b) ZeusTransformUtils.preCheckCast(r2.next(), org.a.b.class, "com.obric.memorydata.plugin");
        if (r4 != r0.length) goto L10;
        org.a.b<? extends T>[] r6 = new org.a.b[(r4 >> 2) + r4];
        System.arraycopy(r0, 0, r6, 0, r4);
        r0 = r6;
    L10:
        r0[r4] = r5;
        r4 = r4 + 1;
    L12:
        int r1 = r4;
        if (r1 != 0) goto L16;
        EmptySubscription.complete(r11);
        return;
    L16:
        ZipCoordinator r8 = new ZipCoordinator(r11, this.d, r1, this.e, this.f);
        r11.onSubscribe(r8);
        r8.subscribe(r0, r1);
        return;
    L11:
        r4 = r0.length;
        goto L12
    }
}
