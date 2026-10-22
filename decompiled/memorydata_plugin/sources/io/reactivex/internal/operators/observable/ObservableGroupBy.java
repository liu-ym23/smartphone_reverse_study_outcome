package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.s;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableGroupBy<T, K, V> extends io.reactivex.internal.operators.observable.a<T, io.reactivex.c.b<K, V>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends K> f16949b;
    final h<? super T, ? extends V> c;
    final int d;
    final boolean e;

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements io.reactivex.disposables.b, t<T> {
        static final Object NULL_KEY = null;
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final AtomicBoolean cancelled;
        final boolean delayError;
        final t<? super io.reactivex.c.b<K, V>> downstream;
        final Map<Object, a<K, V>> groups;
        final h<? super T, ? extends K> keySelector;
        io.reactivex.disposables.b upstream;
        final h<? super T, ? extends V> valueSelector;

        static {
            NULL_KEY = new Object();
        }

        public GroupByObserver(t<? super io.reactivex.c.b<K, V>> r3, h<? super T, ? extends K> r4, h<? super T, ? extends V> r5, int r6, boolean r7) {
            t<? super io.reactivex.c.b<K, V>> r8 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends K> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends V> r10 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
            this.cancelled = new AtomicBoolean();
            this.downstream = r8;
            this.keySelector = r9;
            this.valueSelector = r10;
            this.bufferSize = r6;
            this.delayError = r7;
            this.groups = new ConcurrentHashMap();
            lazySet(1);
        }

        public void cancel(K r2) {
            if (r2 != null) goto L5;
            r2 = (K) NULL_KEY;
        L5:
            this.groups.remove(r2);
            if (decrementAndGet() != 0) goto L9;
            this.upstream.dispose();
            return;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (decrementAndGet() != 0) goto L9;
            this.upstream.dispose();
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // io.reactivex.t
        public void onComplete() {
            ArrayList r0 = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.memorydata.plugin")).b();
            goto L4
        L6:
            this.downstream.onComplete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r5) {
            ArrayList r0 = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.memorydata.plugin")).a(r5);
            goto L4
        L6:
            this.downstream.onError(r5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.t
        public void onNext(T r6) {
            K r0 = this.keySelector.apply(r6);     // Catch: Throwable -> L15
            if (r0 == null) goto L5;
            Object r1 = r0;
        L6:
            a r2 = (a) ZeusTransformUtils.preCheckCast(this.groups.get(r1), a.class, "com.obric.memorydata.plugin");
            a r3 = r2;
            if (r2 == false) goto L9;
        L12:
            r3.a(io.reactivex.internal.functions.a.a(this.valueSelector.apply(r6), "The value supplied is null"));
            return;
        L9:
            if (this.cancelled.get() == false) goto L11;
            return;
        L11:
            a<K, V> r4 = a.a(r0, this.bufferSize, this, this.delayError);
            this.groups.put(r1, r4);
            getAndIncrement();
            this.downstream.onNext(r4);
            r3 = r4;
            goto L12
        L5:
            r1 = NULL_KEY;
        L15:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.dispose();
            onError(th);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    static final class State<T, K> extends AtomicInteger implements io.reactivex.disposables.b, s<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final AtomicReference<t<? super T>> actual;
        final AtomicBoolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final AtomicBoolean once;
        final GroupByObserver<?, K, T> parent;
        final io.reactivex.internal.queue.a<T> queue;

        State(int r2, GroupByObserver<?, K, T> r3, K r4, boolean r5) {
            this.cancelled = new AtomicBoolean();
            this.once = new AtomicBoolean();
            this.actual = new AtomicReference();
            this.queue = new io.reactivex.internal.queue.a(r2);
            this.parent = r3;
            this.key = r4;
            this.delayError = r5;
        }

        boolean checkTerminated(boolean r4, boolean r5, t<? super T> r6, boolean r7) {
            t r8 = (t) ZeusTransformUtils.wrapperContextForParams(r6, t.class, "com.obric.memorydata.plugin");
            if (this.cancelled.get() == false) goto L6;
            this.queue.clear();
            this.parent.cancel(this.key);
            this.actual.lazySet(null);
            return true;
        L6:
            if (r4 == false) goto L21;
            if (r7 == false) goto L14;
            if (r5 == false) goto L23;
            Throwable r9 = this.error;
            this.actual.lazySet(null);
            if (r9 == null) goto L12;
            r8.onError(r9);
        L13:
            return true;
        L12:
            r8.onComplete();
            goto L13
        L23:
            return false;
        L14:
            Throwable r10 = this.error;
            if (r10 == null) goto L18;
            this.queue.clear();
            this.actual.lazySet(null);
            r8.onError(r10);
            return true;
        L18:
            if (r5 == false) goto L24;
            this.actual.lazySet(null);
            r8.onComplete();
            return true;
        L24:
            return false;
        L21:
            return false;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (getAndIncrement() != 0) goto L9;
            this.actual.lazySet(null);
            this.parent.cancel(this.key);
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            io.reactivex.internal.queue.a<T> r0 = this.queue;
            boolean r1 = this.delayError;
            t<? super T> r2 = (t) ZeusTransformUtils.preCheckCast(this.actual.get(), t.class, "com.obric.memorydata.plugin");
            int r5 = 1;
        L6:
            if (r2 == null) goto L17;
        L7:
            boolean r6 = this.done;
            T r7 = r0.poll();
            if (r7 != null) goto L10;
            boolean r8 = true;
        L12:
            if (checkTerminated(r6, r8, r2, r1) == true) goto L13;
            if (r8 == true) goto L17;
            r2.onNext(r7);
            goto L7
        L13:
            return;
        L10:
            r8 = false;
        L17:
            r5 = addAndGet(-r5);
            if (r5 == 0) goto L19;
            if (r2 != null) goto L6;
            r2 = (t) ZeusTransformUtils.preCheckCast(this.actual.get(), t.class, "com.obric.memorydata.plugin");
            goto L6
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled.get();
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

        @Override // io.reactivex.s
        public void subscribe(t<? super T> r4) {
            t<? super T> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
            if (this.once.compareAndSet(false, true) == false) goto L8;
            r5.onSubscribe(this);
            this.actual.lazySet(r5);
            if (this.cancelled.get() == false) goto L7;
            this.actual.lazySet(null);
            return;
        L7:
            drain();
            return;
        L8:
            EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), r5);
        }
    }

    static final class a<K, T> extends io.reactivex.c.b<K, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final State<T, K> f16950a;

        public a(K r1, State<T, K> r2) {
            super(r1);
            this.f16950a = r2;
        }

        public static <T, K> a<K, T> a(K r1, int r2, GroupByObserver<?, K, T> r3, boolean r4) {
            return new a(r1, new State(r2, r3, r1, r4));
        }

        @Override // io.reactivex.Observable
        public void a(t<? super T> r3) {
            t<? super T> r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.f16950a.subscribe(r4);
        }

        public void a(T r1) {
            this.f16950a.onNext(r1);
        }

        public void a(Throwable r1) {
            this.f16950a.onError(r1);
        }

        public void b() {
            this.f16950a.onComplete();
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super io.reactivex.c.b<K, V>> r8) {
        t r1 = (t) ZeusTransformUtils.wrapperContextForParams(r8, t.class, "com.obric.memorydata.plugin");
        this.f17034a.subscribe(new GroupByObserver(r1, this.f16949b, this.c, this.d, this.e));
    }
}
