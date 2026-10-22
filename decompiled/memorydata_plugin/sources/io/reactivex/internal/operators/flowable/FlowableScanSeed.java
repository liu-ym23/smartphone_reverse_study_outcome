package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.a.e;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableScanSeed<T, R> extends a<T, R> {
    final io.reactivex.b.c<R, ? super T, R> c;
    final Callable<R> d;

    static final class ScanSeedSubscriber<T, R> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = -1776795561228106469L;
        final io.reactivex.b.c<R, ? super T, R> accumulator;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final org.a.c<? super R> downstream;
        Throwable error;
        final int limit;
        final int prefetch;
        final e<R> queue;
        final AtomicLong requested;
        org.a.d upstream;
        R value;

        ScanSeedSubscriber(org.a.c<? super R> r3, io.reactivex.b.c<R, ? super T, R> r4, R r5, int r6) {
            org.a.c<? super R> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            io.reactivex.b.c<R, ? super T, R> r8 = (io.reactivex.b.c) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.b.c.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.accumulator = r8;
            this.value = r5;
            this.prefetch = r6;
            this.limit = r6 - (r6 >> 2);
            SpscArrayQueue r9 = new SpscArrayQueue(r6);
            this.queue = r9;
            r9.offer(r5);
            this.requested = new AtomicLong();
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() != 0) goto L6;
            this.queue.clear();
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            org.a.c<? super R> r1 = this.downstream;
            e<R> r2 = this.queue;
            int r3 = this.limit;
            int r4 = this.consumed;
            int r6 = 1;
        L6:
            long r7 = this.requested.get();
            long r11 = 0;
        L8:
            if (r11 == r7) goto L32;
            if (this.cancelled == true) goto L11;
            boolean r14 = this.done;
            if (r14 == false) goto L19;
            Throwable r15 = this.error;
            if (r15 == null) goto L19;
            r2.clear();
            r1.onError(r15);
            return;
        L19:
            R r16 = r2.poll();
            if (r16 != null) goto L22;
            boolean r17 = true;
        L23:
            if (r14 == false) goto L27;
            if (r17 == false) goto L27;
            r1.onComplete();
            return;
        L27:
            if (r17 == true) goto L32;
            r1.onNext(r16);
            r11 = r11 + 1;
            r4 = r4 + 1;
            if (r4 != r3) goto L8;
            this.upstream.request(r3);
            r4 = 0;
            goto L8
        L22:
            r17 = false;
            goto L23
        L11:
            r2.clear();
            return;
        L32:
            if (r11 != r7) goto L44;
            if (this.done == false) goto L44;
            Throwable r8 = this.error;
            if (r8 != null) goto L37;
            if (r2.isEmpty() == false) goto L44;
            r1.onComplete();
            return;
        L37:
            r2.clear();
            r1.onError(r8);
            return;
        L44:
            if (r11 == 0) goto L46;
            io.reactivex.internal.util.b.c(this.requested, r11);
        L46:
            this.consumed = r4;
            r6 = addAndGet(-r6);
            if (r6 != 0) goto L6;
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.error = r2;
            this.done = true;
            drain();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // org.a.c
        public void onNext(T r3) {
            if (this.done == false) goto L5;
            return;
        L5:
            R r0 = this.value;
            R r4 = (R) io.reactivex.internal.functions.a.a(this.accumulator.apply(r0, r3), "The accumulator returned a null value");
            this.value = r4;
            this.queue.offer(r4);
            drain();
            return;
        L9:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.cancel();
            onError(th);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            r4.request(this.prefetch - 1);
            return;
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.requested, r2);
            drain();
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super R> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        Object r0 = io.reactivex.internal.functions.a.a(this.d.call(), "The seed supplied is null");     // Catch: Throwable -> L6
        this.f16812b.a(new ScanSeedSubscriber(r6, this.c, r0, a()));
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(th, r6);
    }
}
