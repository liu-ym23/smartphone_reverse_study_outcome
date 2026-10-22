package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.g;
import io.reactivex.b.h;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;
import io.reactivex.j;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableGroupBy<T, K, V> extends io.reactivex.internal.operators.flowable.a<T, io.reactivex.a.b<K, V>> {
    final h<? super T, ? extends K> c;
    final h<? super T, ? extends V> d;
    final int e;
    final boolean f;
    final h<? super g<Object>, ? extends Map<K, Object>> g;

    public static final class GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<io.reactivex.a.b<K, V>> implements j<T> {
        static final Object NULL_KEY = null;
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final AtomicBoolean cancelled;
        final boolean delayError;
        boolean done;
        final org.a.c<? super io.reactivex.a.b<K, V>> downstream;
        Throwable error;
        final Queue<b<K, V>> evictedGroups;
        volatile boolean finished;
        final AtomicInteger groupCount;
        final Map<Object, b<K, V>> groups;
        final h<? super T, ? extends K> keySelector;
        boolean outputFused;
        final io.reactivex.internal.queue.a<io.reactivex.a.b<K, V>> queue;
        final AtomicLong requested;
        org.a.d upstream;
        final h<? super T, ? extends V> valueSelector;

        static {
            NULL_KEY = new Object();
        }

        public GroupBySubscriber(org.a.c<? super io.reactivex.a.b<K, V>> r3, h<? super T, ? extends K> r4, h<? super T, ? extends V> r5, int r6, boolean r7, Map<Object, b<K, V>> r8, Queue<b<K, V>> r9) {
            org.a.c<? super io.reactivex.a.b<K, V>> r10 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends K> r11 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends V> r12 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
            Map<Object, b<K, V>> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
            Queue<b<K, V>> r14 = (Queue) ZeusTransformUtils.wrapperContextForParams(r9, Queue.class, "com.obric.memorydata.plugin");
            this.cancelled = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.groupCount = new AtomicInteger(1);
            this.downstream = r10;
            this.keySelector = r11;
            this.valueSelector = r12;
            this.bufferSize = r6;
            this.delayError = r7;
            this.groups = r13;
            this.evictedGroups = r14;
            this.queue = new io.reactivex.internal.queue.a(r6);
        }

        private void completeEvictions() {
            if (this.evictedGroups == null) goto L12;
            int r0 = 0;
        L5:
            b r1 = (b) ZeusTransformUtils.preCheckCast(this.evictedGroups.poll(), b.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L8;
            r1.b();
            r0 = r0 + 1;
            goto L5
        L8:
            if (r0 == 0) goto L13;
            this.groupCount.addAndGet(-r0);
            return;
        L13:
            return;
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true) == false) goto L8;
            completeEvictions();
            if (this.groupCount.decrementAndGet() != 0) goto L9;
            this.upstream.cancel();
            return;
        L9:
            return;
        }

        public void cancel(K r2) {
            if (r2 != null) goto L5;
            r2 = (K) NULL_KEY;
        L5:
            this.groups.remove(r2);
            if (this.groupCount.decrementAndGet() != 0) goto L13;
            this.upstream.cancel();
            if (this.outputFused == false) goto L10;
            return;
        L10:
            if (getAndIncrement() != 0) goto L15;
            this.queue.clear();
            return;
        L15:
            return;
        }

        boolean checkTerminated(boolean r3, boolean r4, org.a.c<?> r5, io.reactivex.internal.queue.a<?> r6) {
            org.a.c r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
            if (this.cancelled.get() == false) goto L7;
            r6.clear();
            return true;
        L7:
            if (this.delayError == false) goto L15;
            if (r3 == false) goto L23;
            if (r4 == false) goto L25;
            Throwable r2 = this.error;
            if (r2 == null) goto L13;
            r7.onError(r2);
        L14:
            return true;
        L13:
            r7.onComplete();
            goto L14
        L25:
            return false;
        L23:
            return false;
        L15:
            if (r3 == false) goto L26;
            Throwable r8 = this.error;
            if (r8 == null) goto L20;
            r6.clear();
            r7.onError(r8);
            return true;
        L20:
            if (r4 == false) goto L27;
            r7.onComplete();
            return true;
        L27:
            return false;
        L26:
            return false;
        }

        @Override // io.reactivex.internal.a.f
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
            io.reactivex.internal.queue.a<io.reactivex.a.b<K, V>> r0 = this.queue;
            org.a.c<? super io.reactivex.a.b<K, V>> r1 = this.downstream;
            int r2 = 1;
        L4:
            if (this.cancelled.get() == true) goto L5;
            boolean r3 = this.finished;
            if (r3 == true) goto L9;
        L14:
            r1.onNext(null);
            if (r3 == true) goto L16;
            r2 = addAndGet(-r2);
            if (r2 != 0) goto L4;
            return;
        L16:
            Throwable r5 = this.error;
            if (r5 == null) goto L19;
            r1.onError(r5);
            return;
        L19:
            r1.onComplete();
            return;
        L9:
            if (this.delayError == true) goto L14;
            Throwable r4 = this.error;
            if (r4 == null) goto L14;
            r0.clear();
            r1.onError(r4);
            return;
        }

        void drainNormal() {
            io.reactivex.internal.queue.a<io.reactivex.a.b<K, V>> r0 = this.queue;
            org.a.c<? super io.reactivex.a.b<K, V>> r1 = this.downstream;
            int r3 = 1;
        L3:
            long r4 = this.requested.get();
            long r8 = 0;
        L5:
            if (r8 == r4) goto L16;
            boolean r11 = this.finished;
            io.reactivex.a.b r12 = (io.reactivex.a.b) ZeusTransformUtils.preCheckCast(r0.poll(), io.reactivex.a.b.class, "com.obric.memorydata.plugin");
            if (r12 != null) goto L9;
            boolean r13 = true;
        L11:
            if (checkTerminated(r11, r13, r1, r0) == true) goto L12;
            if (r13 == true) goto L16;
            r1.onNext(r12);
            r8 = r8 + 1;
            goto L5
        L12:
            return;
        L9:
            r13 = false;
        L16:
            if (r8 != r4) goto L21;
            if (checkTerminated(this.finished, r0.isEmpty(), r1, r0) == false) goto L21;
            return;
        L21:
            if (r8 != 0) goto L23;
        L26:
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L3;
            return;
        L23:
            if (r4 == Long.MAX_VALUE) goto L25;
            this.requested.addAndGet(-r8);
        L25:
            this.upstream.request(r8);
            goto L26
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == true) goto L14;
            Iterator<b<K, V>> r0 = this.groups.values().iterator();
        L6:
            if (r0.hasNext() == false) goto L8;
            ((b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin")).b();
            goto L6
        L8:
            this.groups.clear();
            Queue<b<K, V>> r1 = this.evictedGroups;
            if (r1 == null) goto L11;
            r1.clear();
        L11:
            this.done = true;
            this.finished = true;
            drain();
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r6) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r6);
            return;
        L6:
            this.done = true;
            Iterator<b<K, V>> r1 = this.groups.values().iterator();
        L8:
            if (r1.hasNext() == false) goto L10;
            ((b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.memorydata.plugin")).a(r6);
            goto L8
        L10:
            this.groups.clear();
            Queue<b<K, V>> r2 = this.evictedGroups;
            if (r2 == null) goto L13;
            r2.clear();
        L13:
            this.error = r6;
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
        @Override // org.a.c
        public void onNext(T r8) {
            if (this.done == false) goto L5;
            return;
        L5:
            io.reactivex.internal.queue.a<io.reactivex.a.b<K, V>> r0 = this.queue;
            K r1 = this.keySelector.apply(r8);     // Catch: Throwable -> L22
            boolean r2 = false;
            if (r1 == null) goto L10;
            Object r3 = r1;
        L11:
            b r4 = (b) ZeusTransformUtils.preCheckCast(this.groups.get(r3), b.class, "com.obric.memorydata.plugin");
            b r5 = r4;
            if (r4 == null) goto L14;
        L17:
            r5.a(io.reactivex.internal.functions.a.a(this.valueSelector.apply(r8), "The valueSelector returned null"));
            completeEvictions();
            if (r2 == false) goto L27;
            r0.offer(r5);
            drain();
            return;
        L27:
            return;
        L14:
            if (this.cancelled.get() == false) goto L16;
            return;
        L16:
            b r6 = b.a(r1, this.bufferSize, this, this.delayError);
            this.groups.put(r3, r6);
            this.groupCount.getAndIncrement();
            r2 = true;
            r5 = r6;
            goto L17
        L10:
            r3 = NULL_KEY;
        L22:
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
            r4.request(this.bufferSize);
            return;
        }

        @Override // io.reactivex.internal.a.f
        public io.reactivex.a.b<K, V> poll() {
            return (io.reactivex.a.b) ZeusTransformUtils.preCheckCast(this.queue.poll(), io.reactivex.a.b.class, "com.obric.memorydata.plugin");
        }

        @Override // io.reactivex.internal.a.f
        public /* bridge */ /* synthetic */ Object poll() {
            return poll();
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.requested, r2);
            drain();
            return;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.outputFused = true;
            return 2;
        L6:
            return 0;
        }
    }

    static final class State<T, K> extends BasicIntQueueSubscription<T> implements org.a.b<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final AtomicReference<org.a.c<? super T>> actual;
        final AtomicBoolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final AtomicBoolean once;
        boolean outputFused;
        final GroupBySubscriber<?, K, T> parent;
        int produced;
        final io.reactivex.internal.queue.a<T> queue;
        final AtomicLong requested;

        State(int r2, GroupBySubscriber<?, K, T> r3, K r4, boolean r5) {
            this.requested = new AtomicLong();
            this.cancelled = new AtomicBoolean();
            this.actual = new AtomicReference();
            this.once = new AtomicBoolean();
            this.queue = new io.reactivex.internal.queue.a(r2);
            this.parent = r3;
            this.key = r4;
            this.delayError = r5;
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true) == false) goto L6;
            this.parent.cancel(this.key);
            drain();
            return;
        }

        boolean checkTerminated(boolean r3, boolean r4, org.a.c<? super T> r5, boolean r6, long r7) {
            org.a.c r8 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
            if (this.cancelled.get() == true) goto L5;
            if (r3 == false) goto L26;
            if (r6 == false) goto L19;
            if (r4 == false) goto L29;
            Throwable r2 = this.error;
            if (r2 == null) goto L17;
            r8.onError(r2);
        L18:
            return true;
        L17:
            r8.onComplete();
            goto L18
        L29:
            return false;
        L19:
            Throwable r9 = this.error;
            if (r9 == null) goto L23;
            this.queue.clear();
            r8.onError(r9);
            return true;
        L23:
            if (r4 == false) goto L30;
            r8.onComplete();
            return true;
        L30:
            return false;
        L26:
            return false;
        L5:
            if (this.queue.poll() == null) goto L8;
            r7 = r7 + 1;
            goto L5
        L8:
            if (r7 == 0) goto L10;
            this.parent.upstream.request(r7);
        L10:
            return true;
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            io.reactivex.internal.queue.a<T> r0 = this.queue;
        L4:
            if (r0.poll() == null) goto L6;
            this.produced++;
            goto L4
        L6:
            tryReplenish();
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
            io.reactivex.internal.queue.a<T> r0 = this.queue;
            org.a.c r1 = (org.a.c) ZeusTransformUtils.preCheckCast(this.actual.get(), org.a.c.class, "com.obric.memorydata.plugin");
            int r2 = 1;
        L3:
            if (r1 != null) goto L5;
        L22:
            r2 = addAndGet(-r2);
            if (r2 == 0) goto L24;
            if (r1 != null) goto L3;
            r1 = (org.a.c) ZeusTransformUtils.preCheckCast(this.actual.get(), org.a.c.class, "com.obric.memorydata.plugin");
            goto L3
        L24:
            return;
        L5:
            if (this.cancelled.get() == true) goto L6;
            boolean r4 = this.done;
            if (r4 == true) goto L10;
        L15:
            r1.onNext(null);
            if (r4 == false) goto L22;
            Throwable r6 = this.error;
            if (r6 == null) goto L20;
            r1.onError(r6);
            return;
        L20:
            r1.onComplete();
            return;
        L10:
            if (this.delayError == true) goto L15;
            Throwable r5 = this.error;
            if (r5 == null) goto L15;
            r0.clear();
            r1.onError(r5);
            return;
        }

        void drainNormal() {
            io.reactivex.internal.queue.a<T> r8 = this.queue;
            boolean r9 = this.delayError;
            org.a.c<? super T> r12 = (org.a.c) ZeusTransformUtils.preCheckCast(this.actual.get(), org.a.c.class, "com.obric.memorydata.plugin");
            int r13 = 1;
        L3:
            if (r12 == null) goto L28;
            long r14 = this.requested.get();
            long r5 = 0;
        L6:
            if (r5 == r14) goto L17;
            boolean r1 = this.done;
            T r4 = r8.poll();
            if (r4 != null) goto L10;
            boolean r19 = true;
        L11:
            long r20 = r5;
            if (checkTerminated(r1, r19, r12, r9, r5) == true) goto L13;
            if (r19 == true) goto L15;
            r12.onNext(r4);
            r5 = r20 + 1;
            goto L6
        L15:
            r5 = r20;
            goto L17
        L13:
            return;
        L10:
            r19 = false;
        L17:
            if (r5 != r14) goto L23;
            long r21 = r5;
            if (checkTerminated(this.done, r8.isEmpty(), r12, r9, r5) == true) goto L20;
            r5 = r21;
            goto L23
        L20:
            return;
        L23:
            if (r5 == 0) goto L28;
            if (r14 == Long.MAX_VALUE) goto L27;
            this.requested.addAndGet(-r5);
        L27:
            this.parent.upstream.request(r5);
        L28:
            r13 = addAndGet(-r13);
            if (r13 == 0) goto L30;
            if (r12 != null) goto L3;
            r12 = (org.a.c) ZeusTransformUtils.preCheckCast(this.actual.get(), org.a.c.class, "com.obric.memorydata.plugin");
            goto L3
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            if (this.queue.isEmpty() == false) goto L6;
            tryReplenish();
            return true;
        L6:
            return false;
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            drain();
        }

        public void onNext(T r2) {
            this.queue.offer(r2);
            drain();
        }

        @Override // io.reactivex.internal.a.f
        public T poll() {
            T r0 = this.queue.poll();
            if (r0 == null) goto L6;
            this.produced++;
            return r0;
        L6:
            tryReplenish();
            return null;
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.requested, r2);
            drain();
            return;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.outputFused = true;
            return 2;
        L6:
            return 0;
        }

        @Override // org.a.b
        public void subscribe(org.a.c<? super T> r4) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
            if (this.once.compareAndSet(false, true) == false) goto L5;
            r5.onSubscribe(this);
            this.actual.lazySet(r5);
            drain();
            return;
        L5:
            EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), r5);
        }

        void tryReplenish() {
            int r0 = this.produced;
            if (r0 == 0) goto L6;
            this.produced = 0;
            this.parent.upstream.request(r0);
            return;
        }
    }

    static final class a<K, V> implements g<b<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Queue<b<K, V>> f16777a;

        a(Queue<b<K, V>> r3) {
            this.f16777a = (Queue) ZeusTransformUtils.wrapperContextForParams(r3, Queue.class, "com.obric.memorydata.plugin");
        }

        public void a(b<K, V> r1) {
            this.f16777a.offer(r1);
        }

        @Override // io.reactivex.b.g
        public /* synthetic */ void accept(Object r3) {
            a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class b<K, T> extends io.reactivex.a.b<K, T> {
        final State<T, K> c;

        public b(K r1, State<T, K> r2) {
            super(r1);
            this.c = r2;
        }

        public static <T, K> b<K, T> a(K r1, int r2, GroupBySubscriber<?, K, T> r3, boolean r4) {
            return new b(r1, new State(r2, r3, r1, r4));
        }

        public void a(T r1) {
            this.c.onNext(r1);
        }

        public void a(Throwable r1) {
            this.c.onError(r1);
        }

        @Override // io.reactivex.g
        public void a(org.a.c<? super T> r3) {
            org.a.c<? super T> r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.c.subscribe(r4);
        }

        public void b() {
            this.c.onComplete();
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super io.reactivex.a.b<K, V>> r11) {
        org.a.c r3 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r11, org.a.c.class, "com.obric.memorydata.plugin");
    L11:
        e = move-exception;
        io.reactivex.exceptions.a.a(e);
        r3.onSubscribe(EmptyComponent.INSTANCE);
        r3.onError(e);
        return;
    L4:
        if (this.g != null) goto L7;
        ConcurrentLinkedQueue r12 = null;
        Map r0 = new ConcurrentHashMap();     // Catch: Exception -> L11
    L6:
        ConcurrentLinkedQueue r9 = r12;
        Map r8 = r0;
        GroupBySubscriber r13 = new GroupBySubscriber(r3, this.c, this.d, this.e, this.f, r8, r9);
        this.f16812b.a(r13);
        return;
    L7:
        r12 = new ConcurrentLinkedQueue();     // Catch: Exception -> L11
        a r1 = new a(r12);     // Catch: Exception -> L11
        r0 = (Map) ZeusTransformUtils.preCheckCast(this.g.apply(r1), Map.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L11
        goto L6
    }
}
