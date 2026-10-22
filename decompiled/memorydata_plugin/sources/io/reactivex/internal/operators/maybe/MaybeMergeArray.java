package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.g;
import io.reactivex.internal.a.f;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.a.c;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeMergeArray<T> extends g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<? extends T>[] f16853b;

    static final class ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements a<T> {
        private static final long serialVersionUID = -4025173261791142821L;
        int consumerIndex;
        final AtomicInteger producerIndex;

        ClqSimpleQueue() {
            this.producerIndex = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public void drop() {
            poll();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.a.f
        public boolean offer(T r2) {
            this.producerIndex.getAndIncrement();
            return super.offer(r2);
        }

        public boolean offer(T r1, T r2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.a, io.reactivex.internal.a.f
        public T poll() {
            T r0 = (T) super.poll();
            if (r0 == null) goto L5;
            this.consumerIndex++;
        L5:
            return r0;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public int producerIndex() {
            return this.producerIndex.get();
        }
    }

    static final class MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements m<T> {
        private static final long serialVersionUID = -660395290758764731L;
        volatile boolean cancelled;
        long consumed;
        final c<? super T> downstream;
        final AtomicThrowable error;
        boolean outputFused;
        final a<Object> queue;
        final AtomicLong requested;
        final io.reactivex.disposables.a set;
        final int sourceCount;

        MergeMaybeObserver(c<? super T> r3, int r4, a<Object> r5) {
            c<? super T> r6 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            a<Object> r7 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
            this.downstream = r6;
            this.sourceCount = r4;
            this.set = new io.reactivex.disposables.a();
            this.requested = new AtomicLong();
            this.error = new AtomicThrowable();
            this.queue = r7;
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.set.dispose();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
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
            c<? super T> r0 = this.downstream;
            a<Object> r1 = this.queue;
            int r3 = 1;
        L4:
            if (this.cancelled == true) goto L5;
            Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L9;
            if (r1.producerIndex() != this.sourceCount) goto L14;
            boolean r5 = true;
        L16:
            if (r1.isEmpty() == true) goto L18;
            r0.onNext(null);
        L18:
            if (r5 == true) goto L19;
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L4;
            return;
        L19:
            r0.onComplete();
            return;
        L14:
            r5 = false;
            goto L16
        L9:
            r1.clear();
            r0.onError(r4);
            return;
        L5:
            r1.clear();
        }

        void drainNormal() {
            c<? super T> r0 = this.downstream;
            a<Object> r1 = this.queue;
            long r2 = this.consumed;
            int r4 = 1;
        L3:
            long r5 = this.requested.get();
        L5:
            if (r2 == r5) goto L24;
            if (this.cancelled == true) goto L8;
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L12;
            if (r1.consumerIndex() == this.sourceCount) goto L16;
            Object r9 = r1.poll();
            if (r9 == null) goto L24;
            if (r9 == NotificationLite.COMPLETE) goto L5;
            r0.onNext(r9);
            r2 = r2 + 1;
            goto L5
        L16:
            r0.onComplete();
            return;
        L12:
            r1.clear();
            r0.onError(this.error.terminate());
            return;
        L8:
            r1.clear();
            return;
        L24:
            if (r2 == r5) goto L26;
        L35:
            this.consumed = r2;
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L3;
            return;
        L26:
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L12;
        L29:
            if (r1.peek() != NotificationLite.COMPLETE) goto L32;
            r1.drop();
            goto L29
        L32:
            if (r1.consumerIndex() != this.sourceCount) goto L35;
            r0.onComplete();
        }

        boolean isCancelled() {
            return this.cancelled;
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.queue.offer(NotificationLite.COMPLETE);
            drain();
        }

        @Override // io.reactivex.m
        public void onError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            this.set.dispose();
            this.queue.offer(NotificationLite.COMPLETE);
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            this.set.a(r4);
        }

        @Override // io.reactivex.m
        public void onSuccess(T r2) {
            this.queue.offer(r2);
            drain();
        }

        @Override // io.reactivex.internal.a.f
        public T poll() {
        L2:
            T r0 = (T) this.queue.poll();
            if (r0 == NotificationLite.COMPLETE) goto L2;
            return r0;
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

    static final class MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements a<T> {
        private static final long serialVersionUID = -7969063454040569579L;
        int consumerIndex;
        final AtomicInteger producerIndex;

        MpscFillOnceSimpleQueue(int r1) {
            super(r1);
            this.producerIndex = new AtomicInteger();
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
        L3:
            if (poll() == null) goto L7;
            if (isEmpty() == false) goto L3;
            return;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public void drop() {
            int r0 = this.consumerIndex;
            lazySet(r0, null);
            this.consumerIndex = r0 + 1;
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            if (this.consumerIndex != producerIndex()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.internal.a.f
        public boolean offer(T r3) {
            io.reactivex.internal.functions.a.a(r3, "value is null");
            int r0 = this.producerIndex.getAndIncrement();
            if (r0 >= length()) goto L6;
            lazySet(r0, r3);
            return true;
        L6:
            return false;
        }

        public boolean offer(T r1, T r2) {
            throw new UnsupportedOperationException();
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public T peek() {
            int r0 = this.consumerIndex;
            if (r0 != length()) goto L7;
            return null;
        L7:
            return get(r0);
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a, java.util.Queue, io.reactivex.internal.a.f
        public T poll() {
            int r0 = this.consumerIndex;
            if (r0 != length()) goto L5;
            return null;
        L5:
            AtomicInteger r1 = this.producerIndex;
        L6:
            T r3 = get(r0);
            if (r3 != null) goto L8;
            if (r1.get() != r0) goto L6;
            return null;
        L8:
            this.consumerIndex = r0 + 1;
            lazySet(r0, null);
            return r3;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public int producerIndex() {
            return this.producerIndex.get();
        }
    }

    interface a<T> extends f<T> {
        int consumerIndex();

        void drop();

        T peek();

        @Override // java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.a, io.reactivex.internal.a.f
        T poll();

        int producerIndex();
    }

    @Override // io.reactivex.g
    public void a(c<? super T> r6) {
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.memorydata.plugin");
        o[] r5 = this.f16853b;
        int r0 = r5.length;
        if (r0 > a()) goto L5;
        a r1 = new MpscFillOnceSimpleQueue(r0);
    L6:
        MergeMaybeObserver r2 = new MergeMaybeObserver(r7, r0, r1);
        r7.onSubscribe(r2);
        AtomicThrowable r8 = r2.error;
        int r3 = r5.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L14;
        o r9 = r5[r4];
        if (r2.isCancelled() == true) goto L18;
        if (r8.get() != null) goto L19;
        r9.a(r2);
        r4 = r4 + 1;
        goto L7
    L19:
        return;
    L18:
        return;
    L14:
        return;
    L5:
        r1 = new ClqSimpleQueue();
        goto L6
    }
}
