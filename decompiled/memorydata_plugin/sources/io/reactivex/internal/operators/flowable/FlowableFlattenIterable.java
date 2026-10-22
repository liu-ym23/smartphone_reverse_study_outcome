package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.a.f;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableFlattenIterable<T, R> extends a<T, R> {
    final h<? super T, ? extends Iterable<? extends R>> c;
    final int d;

    static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements j<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        volatile boolean cancelled;
        int consumed;
        Iterator<? extends R> current;
        volatile boolean done;
        final org.a.c<? super R> downstream;
        final AtomicReference<Throwable> error;
        int fusionMode;
        final int limit;
        final h<? super T, ? extends Iterable<? extends R>> mapper;
        final int prefetch;
        f<T> queue;
        final AtomicLong requested;
        org.a.d upstream;

        FlattenIterableSubscriber(org.a.c<? super R> r3, h<? super T, ? extends Iterable<? extends R>> r4, int r5) {
            org.a.c<? super R> r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends Iterable<? extends R>> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r6;
            this.mapper = r7;
            this.prefetch = r5;
            this.limit = r5 - (r5 >> 2);
            this.error = new AtomicReference();
            this.requested = new AtomicLong();
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        boolean checkTerminated(boolean r5, boolean r6, org.a.c<?> r7, f<?> r8) {
            org.a.c r9 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r7, org.a.c.class, "com.obric.memorydata.plugin");
            f r10 = (f) ZeusTransformUtils.wrapperContextForParams(r8, f.class, "com.obric.memorydata.plugin");
            if (this.cancelled == false) goto L6;
            this.current = null;
            r10.clear();
            return true;
        L6:
            if (r5 == true) goto L8;
            return false;
        L8:
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L11;
            Throwable r11 = ExceptionHelper.a(this.error);
            this.current = null;
            r10.clear();
            r9.onError(r11);
            return true;
        L11:
            if (r6 == false) goto L16;
            r9.onComplete();
            return true;
        L16:
            return false;
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            this.current = null;
            this.queue.clear();
        }

        void consumedOne(boolean r3) {
            if (r3 == false) goto L8;
            int r4 = this.consumed + 1;
            if (r4 != this.limit) goto L6;
            this.consumed = 0;
            this.upstream.request(r4);
            return;
        L6:
            this.consumed = r4;
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            org.a.c<?> r2 = this.downstream;
            f<T> r3 = this.queue;
            boolean r5 = true;
            if (this.fusionMode == 1) goto L8;
            boolean r0 = true;
        L9:
            Iterator<? extends R> r6 = this.current;
            int r8 = 1;
        L10:
            if (r6 != null) goto L32;
            boolean r9 = this.done;
            T r10 = r3.poll();     // Catch: Throwable -> L30
            if (r10 != null) goto L15;
            boolean r11 = r5;
        L17:
            if (checkTerminated(r9, r11, r2, r3) == true) goto L18;
            if (r10 == null) goto L32;
            r6 = ((Iterable) ZeusTransformUtils.preCheckCast(this.mapper.apply(r10), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L24
            if (r6.hasNext() == false) goto L22;
            this.current = r6;
            goto L32
        L22:
            consumedOne(r0);
            r6 = null;
        L24:
            Throwable th = th;
            io.reactivex.exceptions.a.a(th);
        L26:
            this.upstream.cancel();
            ExceptionHelper.a(this.error, th);
        L27:
            Throwable r1 = ExceptionHelper.a(this.error);
        L28:
            r2.onError(r1);
            return;
        L18:
            return;
        L15:
            r11 = false;
        L30:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.cancel();
            ExceptionHelper.a(this.error, th);
            r1 = ExceptionHelper.a(this.error);
            this.current = null;
            r3.clear();
        L32:
            if (r6 == null) goto L69;
            long r12 = this.requested.get();
            long r13 = 0;
        L35:
            if (r13 == r12) goto L53;
            if (checkTerminated(this.done, false, r2, r3) == true) goto L38;
            r2.onNext((Object) io.reactivex.internal.functions.a.a(r6.next(), "The iterator returned a null value"));
            if (checkTerminated(this.done, false, r2, r3) == true) goto L42;
            r13 = r13 + 1;
            if (r6.hasNext() == true) goto L35;
            consumedOne(r0);
            this.current = null;
            r6 = null;
        L48:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.current = null;
            this.upstream.cancel();
            ExceptionHelper.a(this.error, th);
            goto L27
        L42:
            return;
        L50:
            th = th;
            io.reactivex.exceptions.a.a(th);
            this.current = null;
            goto L26
        L38:
            return;
        L53:
            if (r13 != r12) goto L63;
            boolean r7 = this.done;
            if (r3.isEmpty() == false) goto L58;
            if (r6 != null) goto L58;
            boolean r15 = true;
        L60:
            if (checkTerminated(r7, r15, r2, r3) == false) goto L63;
            return;
        L58:
            r15 = false;
        L63:
            if (r13 != 0) goto L65;
        L67:
            if (r6 != null) goto L69;
        L72:
            r5 = true;
            goto L10
        L65:
            if (r12 == Long.MAX_VALUE) goto L67;
            this.requested.addAndGet(-r13);
        L69:
            r8 = addAndGet(-r8);
            if (r8 != 0) goto L72;
            return;
        L8:
            r0 = false;
            goto L9
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            if (this.current == null) goto L5;
        L7:
            return false;
        L5:
            if (this.queue.isEmpty() == false) goto L7;
            return true;
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
            if (this.done == false) goto L5;
        L7:
            io.reactivex.d.a.a(r2);
            return;
        L5:
            if (ExceptionHelper.a(this.error, r2) == false) goto L7;
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onNext(T r2) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.fusionMode == 0) goto L8;
        L11:
            drain();
            return;
        L8:
            if (this.queue.offer(r2) == true) goto L11;
            onError(new MissingBackpressureException("Queue is full?!"));
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r4) {
            org.a.d r5 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r4, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L16;
            this.upstream = r5;
            if (ZeusTransformUtils.instanceOf(r5, io.reactivex.internal.a.d.class) == false) goto L14;
            io.reactivex.internal.a.d r0 = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r5, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
            int r1 = r0.requestFusion(3);
            if (r1 != 1) goto L11;
            this.fusionMode = r1;
            this.queue = r0;
            this.done = true;
            this.downstream.onSubscribe(this);
            return;
        L11:
            if (r1 != 2) goto L14;
            this.fusionMode = r1;
            this.queue = r0;
            this.downstream.onSubscribe(this);
            r5.request(this.prefetch);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.prefetch);
            this.downstream.onSubscribe(this);
            r5.request(this.prefetch);
            return;
        }

        @Override // io.reactivex.internal.a.f
        public R poll() {
            Iterator<? extends R> r0 = this.current;
        L3:
            if (r0 != null) goto L11;
            T r1 = this.queue.poll();
            if (r1 == null) goto L6;
            r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.mapper.apply(r1), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            if (r0.hasNext() == true) goto L10;
            r0 = null;
            goto L3
        L10:
            this.current = r0;
            goto L11
        L6:
            return null;
        L11:
            R r2 = (R) io.reactivex.internal.functions.a.a(r0.next(), "The iterator returned a null value");
            if (r0.hasNext() == true) goto L14;
            this.current = null;
        L14:
            return r2;
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
            if ((r2 & 1) != 0) goto L5;
            return 0;
        L5:
            if (this.fusionMode != 1) goto L9;
            return 1;
        L9:
            return 0;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super R> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(this.f16812b, Callable.class) == true) goto L19;
        this.f16812b.a(new FlattenIterableSubscriber(r5, this.c, this.d));
        return;
    L19:
        Object r0 = ((Callable) ZeusTransformUtils.preCheckCast(this.f16812b, Callable.class, "com.obric.memorydata.plugin")).call();     // Catch: Throwable -> L14
        if (r0 != null) goto L21;
        EmptySubscription.complete(r5);
        return;
    L21:
        FlowableFromIterable.a(r5, ((Iterable) ZeusTransformUtils.preCheckCast(this.c.apply(r0), Iterable.class, "com.obric.memorydata.plugin")).iterator());
        return;
    L11:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(th, r5);
        return;
    L14:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(th, r5);
    }
}
