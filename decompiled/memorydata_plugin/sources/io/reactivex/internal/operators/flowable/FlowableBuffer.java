package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.e;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.h;
import io.reactivex.j;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableBuffer<T, C extends Collection<? super T>> extends io.reactivex.internal.operators.flowable.a<T, C> {
    final int c;
    final int d;
    final Callable<C> e;

    static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements e, j<T>, org.a.d {
        private static final long serialVersionUID = -7370244972039324525L;
        final Callable<C> bufferSupplier;
        final ArrayDeque<C> buffers;
        volatile boolean cancelled;
        boolean done;
        final org.a.c<? super C> downstream;
        int index;
        final AtomicBoolean once;
        long produced;
        final int size;
        final int skip;
        org.a.d upstream;

        PublisherBufferOverlappingSubscriber(org.a.c<? super C> r3, int r4, int r5, Callable<C> r6) {
            org.a.c<? super C> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            Callable<C> r8 = (Callable) ZeusTransformUtils.wrapperContextForParams(r6, Callable.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.size = r4;
            this.skip = r5;
            this.bufferSupplier = r8;
            this.once = new AtomicBoolean();
            this.buffers = new ArrayDeque();
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
        }

        @Override // io.reactivex.b.e
        public boolean getAsBoolean() {
            return this.cancelled;
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            long r0 = this.produced;
            if (r0 == 0) goto L8;
            io.reactivex.internal.util.b.c(this, r0);
        L8:
            h.a(this.downstream, this.buffers, this, this);
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.done = true;
            this.buffers.clear();
            this.downstream.onError(r2);
        }

        @Override // org.a.c
        public void onNext(T r9) {
            if (this.done == false) goto L5;
            return;
        L5:
            ArrayDeque<C> r0 = this.buffers;
            int r1 = this.index;
            int r2 = r1 + 1;
            if (r1 == 0) goto L26;
        L12:
            Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r0.peek(), Collection.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L15;
        L17:
            Iterator<C> r4 = r0.iterator();
        L19:
            if (r4.hasNext() == false) goto L22;
            ((Collection) ZeusTransformUtils.preCheckCast(r4.next(), Collection.class, "com.obric.memorydata.plugin")).add(r9);
            goto L19
        L22:
            if (r2 != this.skip) goto L24;
            r2 = 0;
        L24:
            this.index = r2;
            return;
        L15:
            if ((r3.size() + 1) != this.size) goto L17;
            r0.poll();
            r3.add(r9);
            this.produced++;
            this.downstream.onNext(r3);
            goto L17
        L26:
            r0.offer((C) ((Collection) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer"), Collection.class, "com.obric.memorydata.plugin")));
        L9:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancel();
            onError(th);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.a.d
        public void request(long r8) {
            if (SubscriptionHelper.validate(r8) == true) goto L5;
            return;
        L5:
            if (h.a(r8, this.downstream, this.buffers, this, this) == false) goto L8;
            return;
        L8:
            if (this.once.get() == false) goto L10;
        L12:
            long r9 = io.reactivex.internal.util.b.b(this.skip, r8);
        L13:
            this.upstream.request(r9);
            return;
        L10:
            if (this.once.compareAndSet(false, true) == false) goto L12;
            r9 = io.reactivex.internal.util.b.a(this.size, io.reactivex.internal.util.b.b(this.skip, r8 - 1));
            goto L13
        }
    }

    static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = -5616169793639412593L;
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        final org.a.c<? super C> downstream;
        int index;
        final int size;
        final int skip;
        org.a.d upstream;

        PublisherBufferSkipSubscriber(org.a.c<? super C> r3, int r4, int r5, Callable<C> r6) {
            org.a.c<? super C> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            Callable<C> r8 = (Callable) ZeusTransformUtils.wrapperContextForParams(r6, Callable.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.size = r4;
            this.skip = r5;
            this.bufferSupplier = r8;
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            C r0 = this.buffer;
            this.buffer = null;
            if (r0 == null) goto L8;
            this.downstream.onNext(r0);
        L8:
            this.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.done = true;
            this.buffer = null;
            this.downstream.onError(r2);
        }

        @Override // org.a.c
        public void onNext(T r5) {
            if (this.done == false) goto L5;
            return;
        L5:
            C r0 = this.buffer;
            int r1 = this.index;
            int r2 = r1 + 1;
            if (r1 == 0) goto L21;
        L12:
            if (r0 == null) goto L17;
            r0.add(r5);
            if (r0.size() != this.size) goto L17;
            this.buffer = null;
            this.downstream.onNext(r0);
        L17:
            if (r2 != this.skip) goto L19;
            r2 = 0;
        L19:
            this.index = r2;
            return;
        L21:
            r0 = (C) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer"), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            this.buffer = r0;
        L9:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancel();
            onError(th);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.a.d
        public void request(long r7) {
            if (SubscriptionHelper.validate(r7) == true) goto L5;
            return;
        L5:
            if (get() == 0) goto L7;
        L9:
            this.upstream.request(io.reactivex.internal.util.b.b(this.skip, r7));
            return;
        L7:
            if (compareAndSet(0, 1) == false) goto L9;
            this.upstream.request(io.reactivex.internal.util.b.a(io.reactivex.internal.util.b.b(r7, this.size), io.reactivex.internal.util.b.b(this.skip - this.size, r7 - 1)));
        }
    }

    static final class a<T, C extends Collection<? super T>> implements j<T>, org.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final org.a.c<? super C> f16759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Callable<C> f16760b;
        final int c;
        C d;
        org.a.d e;
        boolean f;
        int g;

        a(org.a.c<? super C> r3, int r4, Callable<C> r5) {
            org.a.c<? super C> r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            Callable<C> r7 = (Callable) ZeusTransformUtils.wrapperContextForParams(r5, Callable.class, "com.obric.memorydata.plugin");
            this.f16759a = r6;
            this.c = r4;
            this.f16760b = r7;
        }

        @Override // org.a.d
        public void cancel() {
            this.e.cancel();
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.f == false) goto L5;
            return;
        L5:
            this.f = true;
            C r0 = this.d;
            if (r0 != null) goto L8;
        L10:
            this.f16759a.onComplete();
            return;
        L8:
            if (r0.isEmpty() == true) goto L10;
            this.f16759a.onNext(r0);
            goto L10
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.f == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.f = true;
            this.f16759a.onError(r2);
        }

        @Override // org.a.c
        public void onNext(T r4) {
            if (this.f == false) goto L5;
            return;
        L5:
            C r0 = this.d;
            if (r0 == null) goto L17;
        L12:
            r0.add(r4);
            int r5 = this.g + 1;
            if (r5 != this.c) goto L15;
            this.g = 0;
            this.d = null;
            this.f16759a.onNext(r0);
            return;
        L15:
            this.g = r5;
            return;
        L17:
            r0 = (C) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.f16760b.call(), "The bufferSupplier returned a null buffer"), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            this.d = r0;
        L9:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancel();
            onError(th);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.e, r4) == false) goto L6;
            this.e = r4;
            this.f16759a.onSubscribe(this);
            return;
        }

        @Override // org.a.d
        public void request(long r4) {
            if (SubscriptionHelper.validate(r4) == false) goto L6;
            this.e.request(io.reactivex.internal.util.b.b(r4, this.c));
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super C> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        int r0 = this.c;
        int r1 = this.d;
        if (r0 != r1) goto L6;
        g<T> r2 = this.f16812b;
        j<? super T> r3 = new a(r6, this.c, this.e);
    L5:
        r2.a(r3);
        return;
    L6:
        if (r1 <= r0) goto L8;
        r2 = this.f16812b;
        r3 = new PublisherBufferSkipSubscriber(r6, this.c, this.d, this.e);
        goto L5
    L8:
        r2 = this.f16812b;
        r3 = new PublisherBufferOverlappingSubscriber(r6, this.c, this.d, this.e);
        goto L5
    }
}
