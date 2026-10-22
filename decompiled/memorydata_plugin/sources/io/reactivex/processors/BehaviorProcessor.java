package io.reactivex.processors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class BehaviorProcessor<T> extends a<T> {
    static final Object[] c = null;
    static final BehaviorSubscription[] d = null;
    static final BehaviorSubscription[] e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<BehaviorSubscription<T>[]> f17162b;
    final Lock f;
    final Lock g;
    final AtomicReference<Object> h;
    final AtomicReference<Throwable> i;
    long j;

    static final class BehaviorSubscription<T> extends AtomicLong implements io.reactivex.internal.util.a.InterfaceC0877a<Object>, d {
        private static final long serialVersionUID = 3293175281126227086L;
        volatile boolean cancelled;
        final c<? super T> downstream;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        io.reactivex.internal.util.a<Object> queue;
        final BehaviorProcessor<T> state;

        BehaviorSubscription(c<? super T> r3, BehaviorProcessor<T> r4) {
            this.downstream = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            this.state = r4;
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.state.b(this);
            return;
        }

        void emitFirst() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            monitor-enter(this);
        L26:
            th = move-exception;
            throw th;
        L7:
            if (this.cancelled == false) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L26
            return;
        L11:
            if (this.next == false) goto L14;
            monitor-exit(this);     // Catch: Throwable -> L26
            return;
        L14:
            BehaviorProcessor<T> r0 = this.state;     // Catch: Throwable -> L26
            Lock r1 = r0.f;     // Catch: Throwable -> L26
            r1.lock();     // Catch: Throwable -> L26
            this.index = r0.j;     // Catch: Throwable -> L26
            Object r2 = r0.h.get();     // Catch: Throwable -> L26
            r1.unlock();     // Catch: Throwable -> L26
            if (r2 == null) goto L17;
            boolean r3 = true;
        L18:
            this.emitting = r3;     // Catch: Throwable -> L26
            this.next = true;     // Catch: Throwable -> L26
            monitor-exit(this);     // Catch: Throwable -> L26
            if (r2 != null) goto L22;
            return;
        L22:
            if (test(r2) == false) goto L24;
            return;
        L24:
            emitLoop();
            return;
        L17:
            r3 = false;
            goto L18
        }

        void emitLoop() {
        L3:
            if (this.cancelled == true) goto L4;
            monitor-enter(this);
            io.reactivex.internal.util.a<Object> r0 = this.queue;     // Catch: Throwable -> L14
            if (r0 == null) goto L8;
            this.queue = null;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            r0.a(this);
            goto L3
        L8:
            this.emitting = false;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        void emitNext(Object r3, long r4) {
            if (this.cancelled == false) goto L6;
            return;
        L6:
            if (this.fastPath == true) goto L30;
            monitor-enter(this);
        L27:
            th = move-exception;
            throw th;
        L9:
            if (this.cancelled == false) goto L13;
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L13:
            if (this.index != r4) goto L17;
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L17:
            if (this.emitting == false) goto L24;
            io.reactivex.internal.util.a<Object> r5 = this.queue;     // Catch: Throwable -> L27
            if (r5 != null) goto L21;
            r5 = new io.reactivex.internal.util.a(4);     // Catch: Throwable -> L27
            this.queue = r5;     // Catch: Throwable -> L27
        L21:
            r5.a(r3);     // Catch: Throwable -> L27
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L24:
            this.next = true;     // Catch: Throwable -> L27
            monitor-exit(this);     // Catch: Throwable -> L27
            this.fastPath = true;
        L30:
            test(r3);
        }

        public boolean isFull() {
            if (get() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this, r2);
            return;
        }

        @Override // io.reactivex.internal.util.a.InterfaceC0877a, io.reactivex.b.j
        public boolean test(Object r7) {
            if (this.cancelled == false) goto L6;
            return true;
        L6:
            if (NotificationLite.isComplete(r7) == false) goto L10;
            this.downstream.onComplete();
            return true;
        L10:
            if (NotificationLite.isError(r7) == false) goto L13;
            this.downstream.onError(NotificationLite.getError(r7));
            return true;
        L13:
            long r2 = get();
            if (r2 == 0) goto L20;
            this.downstream.onNext((Object) NotificationLite.getValue(r7));
            if (r2 == Long.MAX_VALUE) goto L22;
            decrementAndGet();
            return false;
        L22:
            return false;
        L20:
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            return true;
        }
    }

    static {
        c = new Object[0];
        d = new BehaviorSubscription[0];
        e = new BehaviorSubscription[0];
    }

    @Override // io.reactivex.g
    public void a(c<? super T> r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        BehaviorSubscription<T> r0 = new BehaviorSubscription(r5, this);
        r5.onSubscribe(r0);
        if (a(r0) == true) goto L5;
        Throwable r3 = (Throwable) ZeusTransformUtils.preCheckCast(this.i.get(), Throwable.class, "com.obric.memorydata.plugin");
        if (r3 != ExceptionHelper.f17150a) goto L11;
        r5.onComplete();
        return;
    L11:
        r5.onError(r3);
        return;
    L5:
        if (r0.cancelled == false) goto L7;
        b(r0);
        return;
    L7:
        r0.emitFirst();
    }

    boolean a(BehaviorSubscription<T> r5) {
    L2:
        BehaviorSubscription<T>[] r0 = (BehaviorSubscription[]) ZeusTransformUtils.preCheckCast(this.f17162b.get(), BehaviorSubscription[].class, "com.obric.memorydata.plugin");
        if (r0 == e) goto L4;
        int r1 = r0.length;
        BehaviorSubscription<T>[] r3 = new BehaviorSubscription[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.f17162b.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    BehaviorSubscription<T>[] a(Object r5) {
        BehaviorSubscription<T>[] r0 = (BehaviorSubscription[]) ZeusTransformUtils.preCheckCast(this.f17162b.get(), BehaviorSubscription[].class, "com.obric.memorydata.plugin");
        BehaviorSubscription<T>[] r1 = e;
        if (r0 == r1) goto L7;
        r0 = (BehaviorSubscription[]) ZeusTransformUtils.preCheckCast(this.f17162b.getAndSet(r1), BehaviorSubscription[].class, "com.obric.memorydata.plugin");
        if (r0 == r1) goto L7;
        b(r5);
    L7:
        return r0;
    }

    void b(BehaviorSubscription<T> r7) {
    L2:
        BehaviorSubscription<T>[] r0 = (BehaviorSubscription[]) ZeusTransformUtils.preCheckCast(this.f17162b.get(), BehaviorSubscription[].class, "com.obric.memorydata.plugin");
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
        BehaviorSubscription<T>[] r3 = d;
    L18:
        if (this.f17162b.compareAndSet(r0, r3) == false) goto L2;
        return;
    L16:
        BehaviorSubscription<T>[] r5 = new BehaviorSubscription[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r2);
        System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
        r3 = r5;
        goto L18
    L12:
        return;
    }

    void b(Object r6) {
        Lock r0 = this.g;
        r0.lock();
        this.j++;
        this.h.lazySet(r6);
        r0.unlock();
    }

    @Override // org.a.c
    public void onComplete() {
        if (this.i.compareAndSet(null, ExceptionHelper.f17150a) == true) goto L5;
        return;
    L5:
        Object r0 = NotificationLite.complete();
        BehaviorSubscription<T>[] r1 = a(r0);
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        r1[r3].emitNext(r0, this.j);
        r3 = r3 + 1;
        goto L6
    }

    @Override // org.a.c
    public void onError(Throwable r7) {
        io.reactivex.internal.functions.a.a(r7, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.i.compareAndSet(null, r7) == true) goto L6;
        io.reactivex.d.a.a(r7);
        return;
    L6:
        Object r8 = NotificationLite.error(r7);
        BehaviorSubscription<T>[] r0 = a(r8);
        int r1 = r0.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        r0[r2].emitNext(r8, this.j);
        r2 = r2 + 1;
        goto L7
    }

    @Override // org.a.c
    public void onNext(T r7) {
        io.reactivex.internal.functions.a.a(r7, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.i.get() == null) goto L5;
        return;
    L5:
        Object r8 = NotificationLite.next(r7);
        b(r8);
        BehaviorSubscription[] r0 = (BehaviorSubscription[]) ZeusTransformUtils.preCheckCast(this.f17162b.get(), BehaviorSubscription[].class, "com.obric.memorydata.plugin");
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        r0[r2].emitNext(r8, this.j);
        r2 = r2 + 1;
        goto L6
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (this.i.get() == null) goto L6;
        r4.cancel();
        return;
    L6:
        r4.request(Long.MAX_VALUE);
    }
}
