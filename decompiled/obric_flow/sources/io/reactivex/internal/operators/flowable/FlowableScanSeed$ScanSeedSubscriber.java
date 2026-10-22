package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableScanSeed$ScanSeedSubscriber<T, R> extends AtomicInteger implements mt.g, zu.d {
    private static final long serialVersionUID = -1776795561228106469L;
    final pt.c accumulator;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    final zu.c downstream;
    Throwable error;
    final int limit;
    final int prefetch;
    final rt.g queue;
    final AtomicLong requested;
    zu.d upstream;
    R value;

    public FlowableScanSeed$ScanSeedSubscriber(zu.c r5, pt.c r10, R r11, int r12) {
        this.downstream = r5;
        this.accumulator = r10;
        this.value = r11;
        this.prefetch = r12;
        this.limit = r12 - (r12 >> 2);
        SpscArrayQueue r13 = new SpscArrayQueue(r12);
        this.queue = r13;
        r13.offer(r11);
        this.requested = new AtomicLong();
    }

    @Override // zu.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() != 0) goto L6;
        this.queue.clear();
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        zu.c r5 = this.downstream;
        rt.g r10 = this.queue;
        int r11 = this.limit;
        int r12 = this.consumed;
        int r13 = 1;
    L6:
        long r14 = this.requested.get();
        long r15 = 0;
    L8:
        if (r15 == r14) goto L32;
        if (this.cancelled == true) goto L11;
        boolean r16 = this.done;
        if (r16 == false) goto L19;
        Throwable r17 = this.error;
        if (r17 == null) goto L19;
        r10.clear();
        r5.onError(r17);
        return;
    L19:
        Object r18 = r10.poll();
        if (r18 != null) goto L22;
        boolean r19 = true;
    L23:
        if (r16 == false) goto L27;
        if (r19 == false) goto L27;
        r5.onComplete();
        return;
    L27:
        if (r19 == true) goto L32;
        r5.onNext(r18);
        r15 = r15 + 1;
        r12 = r12 + 1;
        if (r12 != r11) goto L8;
        this.upstream.request(r11);
        r12 = 0;
        goto L8
    L22:
        r19 = false;
        goto L23
    L11:
        r10.clear();
        return;
    L32:
        if (r15 != r14) goto L44;
        if (this.done == false) goto L44;
        Throwable r20 = this.error;
        if (r20 != null) goto L37;
        if (r10.isEmpty() == false) goto L44;
        r5.onComplete();
        return;
    L37:
        r10.clear();
        r5.onError(r20);
        return;
    L44:
        if (r15 == 0) goto L46;
        v0.y(this.requested, r15);
    L46:
        this.consumed = r12;
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L6;
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.error = r5;
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
    @Override // zu.c
    public void onNext(T r5) {
        if (this.done == false) goto L5;
        return;
    L5:
        R r10 = this.value;
        R r11 = (R) this.accumulator.apply(r10, r5);
        io.reactivex.internal.functions.e.d(r11, "The accumulator returned a null value");     // Catch: Throwable -> L9
        this.value = r11;
        this.queue.offer(r11);
        drain();
        return;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        onError(th);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(this.prefetch - 1);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this.requested, r5);
        drain();
        return;
    }
}
