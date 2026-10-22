package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableGroupBy$GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<yb.a<K, V>> implements xb.g<T> {
    static final Object NULL_KEY = null;
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final AtomicBoolean cancelled;
    final boolean delayError;
    boolean done;
    final tc.c<? super yb.a<K, V>> downstream;
    Throwable error;
    final Queue<e<K, V>> evictedGroups;
    volatile boolean finished;
    final AtomicInteger groupCount;
    final Map<Object, e<K, V>> groups;
    final zb.h<? super T, ? extends K> keySelector;
    boolean outputFused;
    final io.reactivex.internal.queue.a<yb.a<K, V>> queue;
    final AtomicLong requested;
    tc.d upstream;
    final zb.h<? super T, ? extends V> valueSelector;

    static {
        NULL_KEY = new Object();
    }

    public FlowableGroupBy$GroupBySubscriber(tc.c<? super yb.a<K, V>> r10, zb.h<? super T, ? extends K> r11, zb.h<? super T, ? extends V> r12, int r13, boolean r14, Map<Object, e<K, V>> r15, Queue<e<K, V>> r16) {
        this.cancelled = new AtomicBoolean();
        this.requested = new AtomicLong();
        this.groupCount = new AtomicInteger(1);
        this.downstream = r10;
        this.keySelector = r11;
        this.valueSelector = r12;
        this.bufferSize = r13;
        this.delayError = r14;
        this.groups = r15;
        this.evictedGroups = r16;
        this.queue = new io.reactivex.internal.queue.a(r13);
    }

    private void completeEvictions() {
        if (this.evictedGroups == null) goto L12;
        int r10 = 0;
    L5:
        e<K, V> r11 = this.evictedGroups.poll();
        if (r11 == null) goto L8;
        r11.onComplete();
        r10 = r10 + 1;
        goto L5
    L8:
        if (r10 == 0) goto L13;
        this.groupCount.addAndGet(-r10);
        return;
    L13:
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void cancel() {
        if (this.cancelled.compareAndSet(false, true) == false) goto L8;
        completeEvictions();
        if (this.groupCount.decrementAndGet() != 0) goto L9;
        this.upstream.cancel();
        return;
    L9:
        return;
    }

    public void cancel(K r10) {
        if (r10 != null) goto L5;
        r10 = (K) NULL_KEY;
    L5:
        this.groups.remove(r10);
        if (this.groupCount.decrementAndGet() != 0) goto L11;
        this.upstream.cancel();
        if (getAndIncrement() != 0) goto L12;
        this.queue.clear();
        return;
    L12:
        return;
    }

    boolean checkTerminated(boolean r10, boolean r11, tc.c<?> r12, io.reactivex.internal.queue.a<?> r13) {
        if (this.cancelled.get() == false) goto L7;
        r13.clear();
        return true;
    L7:
        if (this.delayError == false) goto L15;
        if (r10 == false) goto L23;
        if (r11 == false) goto L25;
        Throwable r14 = this.error;
        if (r14 == null) goto L13;
        r12.onError(r14);
    L14:
        return true;
    L13:
        r12.onComplete();
        goto L14
    L25:
        return false;
    L23:
        return false;
    L15:
        if (r10 == false) goto L26;
        Throwable r15 = this.error;
        if (r15 == null) goto L20;
        r13.clear();
        r12.onError(r15);
        return true;
    L20:
        if (r11 == false) goto L27;
        r12.onComplete();
        return true;
    L27:
        return false;
    L26:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public void clear() {
        this.queue.clear();
    }

    void drain() {
        if (getAndIncrement() == 0) goto L6;
        return;
    L6:
        if (this.outputFused == false) goto L8;
        drainFused();
        return;
    L8:
        drainNormal();
    }

    void drainFused() {
        io.reactivex.internal.queue.a<yb.a<K, V>> r10 = this.queue;
        tc.c<? super yb.a<K, V>> r11 = this.downstream;
        int r12 = 1;
    L4:
        if (this.cancelled.get() == true) goto L5;
        boolean r13 = this.finished;
        if (r13 == true) goto L10;
    L15:
        r11.onNext(null);
        if (r13 == true) goto L17;
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L4;
        return;
    L17:
        Throwable r14 = this.error;
        if (r14 == null) goto L20;
        r11.onError(r14);
        return;
    L20:
        r11.onComplete();
        return;
    L10:
        if (this.delayError == true) goto L15;
        Throwable r15 = this.error;
        if (r15 == null) goto L15;
        r10.clear();
        r11.onError(r15);
        return;
    L5:
        r10.clear();
    }

    void drainNormal() {
        io.reactivex.internal.queue.a<yb.a<K, V>> r10 = this.queue;
        tc.c<? super yb.a<K, V>> r11 = this.downstream;
        int r12 = 1;
    L3:
        long r13 = this.requested.get();
        long r14 = 0;
    L5:
        if (r14 == r13) goto L16;
        boolean r15 = this.finished;
        yb.a<K, V> r16 = r10.poll();
        if (r16 != null) goto L9;
        boolean r17 = true;
    L11:
        if (checkTerminated(r15, r17, r11, r10) == true) goto L12;
        if (r17 == true) goto L16;
        r11.onNext(r16);
        r14 = r14 + 1;
        goto L5
    L12:
        return;
    L9:
        r17 = false;
    L16:
        if (r14 != r13) goto L21;
        if (checkTerminated(this.finished, r10.isEmpty(), r11, r10) == false) goto L21;
        return;
    L21:
        if (r14 != 0) goto L23;
    L26:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L3;
        return;
    L23:
        if (r13 == Long.MAX_VALUE) goto L25;
        this.requested.addAndGet(-r14);
    L25:
        this.upstream.request(r14);
        goto L26
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // tc.c
    public void onComplete() {
        if (this.done == true) goto L14;
        Iterator<e<K, V>> r10 = this.groups.values().iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        r10.next().onComplete();
        goto L6
    L8:
        this.groups.clear();
        Queue<e<K, V>> r11 = this.evictedGroups;
        if (r11 == null) goto L11;
        r11.clear();
    L11:
        this.done = true;
        this.finished = true;
        drain();
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.done = true;
        Iterator<e<K, V>> r11 = this.groups.values().iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        r11.next().onError(r10);
        goto L8
    L10:
        this.groups.clear();
        Queue<e<K, V>> r12 = this.evictedGroups;
        if (r12 == null) goto L13;
        r12.clear();
    L13:
        this.error = r10;
        this.finished = true;
        drain();
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // tc.c
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        io.reactivex.internal.queue.a<yb.a<K, V>> r11 = this.queue;
        K r12 = this.keySelector.apply(r10);     // Catch: Throwable -> L22
        boolean r13 = false;
        if (r12 == null) goto L10;
        Object r14 = r12;
    L11:
        e<K, V> r15 = this.groups.get(r14);
        e r16 = r15;
        if (r15 == null) goto L14;
    L17:
        r16.onNext(io.reactivex.internal.functions.a.d(this.valueSelector.apply(r10), "The valueSelector returned null"));
        completeEvictions();
        if (r13 == false) goto L27;
        r11.offer(r16);
        drain();
        return;
    L27:
        return;
    L14:
        if (this.cancelled.get() == false) goto L16;
        return;
    L16:
        e r17 = e.d(r12, this.bufferSize, this, this.delayError);
        this.groups.put(r14, r17);
        this.groupCount.getAndIncrement();
        r13 = true;
        r16 = r17;
        goto L17
    L10:
        r14 = NULL_KEY;
    L22:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        onError(th);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(this.bufferSize);
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public /* bridge */ /* synthetic */ Object poll() {
        return poll();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public yb.a<K, V> poll() {
        return this.queue.poll();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this.requested, r10);
        drain();
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.c
    public int requestFusion(int r10) {
        if ((r10 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }
}
