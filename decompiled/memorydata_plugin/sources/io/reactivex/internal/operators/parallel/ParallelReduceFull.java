package io.reactivex.internal.operators.parallel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.c;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.parallel.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class ParallelReduceFull<T> extends g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a<? extends T> f17045b;
    final c<T, T, T> c;

    static final class ParallelReduceFullInnerSubscriber<T> extends AtomicReference<d> implements j<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        boolean done;
        final ParallelReduceFullMainSubscriber<T> parent;
        final c<T, T, T> reducer;
        T value;

        ParallelReduceFullInnerSubscriber(ParallelReduceFullMainSubscriber<T> r3, c<T, T, T> r4) {
            c<T, T, T> r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
            this.parent = r3;
            this.reducer = r5;
        }

        void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            this.parent.innerComplete(this.value);
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.done = true;
            this.parent.innerError(r2);
        }

        @Override // org.a.c
        public void onNext(T r4) {
            if (this.done == true) goto L14;
            T r0 = this.value;
            if (r0 != null) goto L12;
        L6:
            this.value = r4;
            return;
        L12:
            r4 = (T) io.reactivex.internal.functions.a.a(this.reducer.apply(r0, r4), "The reducer returned a null value");
        L9:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            ((d) ZeusTransformUtils.preCheckCast(get(), d.class, "com.obric.memorydata.plugin")).cancel();
            onError(th);
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r3) {
            SubscriptionHelper.setOnce(this, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin"), Long.MAX_VALUE);
        }
    }

    static final class ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = -5370107872170712765L;
        final AtomicReference<SlotPair<T>> current;
        final AtomicReference<Throwable> error;
        final c<T, T, T> reducer;
        final AtomicInteger remaining;
        final ParallelReduceFullInnerSubscriber<T>[] subscribers;

        ParallelReduceFullMainSubscriber(org.a.c<? super T> r3, int r4, c<T, T, T> r5) {
            org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            c<T, T, T> r7 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
            super(r6);
            this.current = new AtomicReference();
            this.remaining = new AtomicInteger();
            this.error = new AtomicReference();
            ParallelReduceFullInnerSubscriber<T>[] r8 = new ParallelReduceFullInnerSubscriber[r4];
            int r0 = 0;
        L3:
            if (r0 >= r4) goto L5;
            r8[r0] = new ParallelReduceFullInnerSubscriber(this, r7);
            r0 = r0 + 1;
            goto L3
        L5:
            this.subscribers = r8;
            this.reducer = r7;
            this.remaining.lazySet(r4);
        }

        SlotPair<T> addValue(T r4) {
        L2:
            SlotPair<T> r0 = (SlotPair) ZeusTransformUtils.preCheckCast(this.current.get(), SlotPair.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L7;
            r0 = new SlotPair();
            if (this.current.compareAndSet(null, r0) == false) goto L2;
        L7:
            int r2 = r0.tryAcquireSlot();
            if (r2 >= 0) goto L10;
            this.current.compareAndSet(r0, null);
            goto L2
        L10:
            if (r2 != 0) goto L12;
            r0.first = r4;
        L14:
            if (r0.releaseSlot() == false) goto L17;
            this.current.compareAndSet(r0, null);
            return r0;
        L17:
            return null;
        L12:
            r0.second = r4;
            goto L14
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            ParallelReduceFullInnerSubscriber<T>[] r3 = this.subscribers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].cancel();
            r1 = r1 + 1;
            goto L3
        }

        void innerComplete(T r3) {
            if (r3 == null) goto L11;
        L3:
            SlotPair<T> r4 = addValue(r3);
            if (r4 == null) goto L11;
            r3 = (T) io.reactivex.internal.functions.a.a(this.reducer.apply(r4.first, r4.second), "The reducer returned a null value");
        L7:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            innerError(th);
            return;
        L11:
            if (this.remaining.decrementAndGet() != 0) goto L21;
            SlotPair r5 = (SlotPair) ZeusTransformUtils.preCheckCast(this.current.get(), SlotPair.class, "com.obric.memorydata.plugin");
            this.current.lazySet(null);
            if (r5 == null) goto L15;
            complete(r5.first);
            return;
        L15:
            this.downstream.onComplete();
            return;
        }

        void innerError(Throwable r3) {
            if (this.error.compareAndSet(null, r3) == false) goto L6;
            cancel();
            this.downstream.onError(r3);
            return;
        L6:
            if (r3 == this.error.get()) goto L10;
            io.reactivex.d.a.a(r3);
            return;
        }
    }

    static final class SlotPair<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
        T first;
        final AtomicInteger releaseIndex;
        T second;

        SlotPair() {
            this.releaseIndex = new AtomicInteger();
        }

        boolean releaseSlot() {
            if (this.releaseIndex.incrementAndGet() != 2) goto L5;
            return true;
        L5:
            return false;
        }

        int tryAcquireSlot() {
        L2:
            int r0 = get();
            if (r0 >= 2) goto L4;
            if (compareAndSet(r0, r0 + 1) == false) goto L2;
            return r0;
        L4:
            return -1;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        ParallelReduceFullMainSubscriber r0 = new ParallelReduceFullMainSubscriber(r5, this.f17045b.a(), this.c);
        r5.onSubscribe(r0);
        this.f17045b.a(r0.subscribers);
    }
}
