package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableFromIterable<T> extends g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable<? extends T> f16775b;

    static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        Iterator<? extends T> it;
        boolean once;

        BaseRangeSubscription(Iterator<? extends T> r3) {
            this.it = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        }

        @Override // org.a.d
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.internal.a.f
        public final void clear() {
            this.it = null;
        }

        abstract void fastPath();

        @Override // io.reactivex.internal.a.f
        public final boolean isEmpty() {
            Iterator<? extends T> r0 = this.it;
            if (r0 != null) goto L5;
        L8:
            return true;
        L5:
            if (r0.hasNext() == false) goto L8;
            return false;
        }

        @Override // io.reactivex.internal.a.f
        public final T poll() {
            Iterator<? extends T> r0 = this.it;
            if (r0 != null) goto L6;
            return null;
        L6:
            if (this.once == true) goto L9;
            this.once = true;
        L12:
            return (T) io.reactivex.internal.functions.a.a(this.it.next(), "Iterator.next() returned a null value");
        L9:
            if (r0.hasNext() == true) goto L12;
            return null;
        }

        @Override // org.a.d
        public final void request(long r5) {
            if (SubscriptionHelper.validate(r5) == true) goto L5;
            return;
        L5:
            if (io.reactivex.internal.util.b.a(this, r5) == 0) goto L7;
            return;
        L7:
            if (r5 != Long.MAX_VALUE) goto L9;
            fastPath();
            return;
        L9:
            slowPath(r5);
        }

        @Override // io.reactivex.internal.a.c
        public final int requestFusion(int r1) {
            return r1 & 1;
        }

        abstract void slowPath(long r1);
    }

    static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final io.reactivex.internal.a.a<? super T> downstream;

        IteratorConditionalSubscription(io.reactivex.internal.a.a<? super T> r3, Iterator<? extends T> r4) {
            io.reactivex.internal.a.a<? super T> r5 = (io.reactivex.internal.a.a) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.internal.a.a.class, "com.obric.memorydata.plugin");
            super((Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin"));
            this.downstream = r5;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void fastPath() {
            Iterator<? extends T> r0 = this.it;
            io.reactivex.internal.a.a<? super T> r1 = this.downstream;
        L4:
            if (this.cancelled == true) goto L5;
            T r2 = r0.next();     // Catch: Throwable -> L23
            if (this.cancelled == true) goto L9;
            if (r2 == null) goto L11;
            r1.tryOnNext(r2);
            if (this.cancelled == true) goto L16;
            if (r0.hasNext() == true) goto L4;
            if (this.cancelled == true) goto L33;
            r1.onComplete();
            return;
        L33:
            return;
        L16:
            return;
        L11:
            th = new NullPointerException("Iterator.next() returned a null value");
        L12:
            r1.onError(th);
            return;
        L9:
            return;
        L23:
            th = th;
            io.reactivex.exceptions.a.a(th);
            goto L12
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void slowPath(long r9) {
            Iterator<? extends T> r0 = this.it;
            io.reactivex.internal.a.a<? super T> r1 = this.downstream;
        L3:
            long r4 = 0;
        L5:
            if (r4 != r9) goto L7;
            r9 = get();
            if (r4 != r9) goto L5;
            r9 = addAndGet(-r4);
            if (r9 != 0) goto L3;
            return;
        L7:
            if (this.cancelled == true) goto L8;
            T r6 = r0.next();     // Catch: Throwable -> L28
            if (this.cancelled == true) goto L12;
            if (r6 == null) goto L14;
            boolean r7 = r1.tryOnNext(r6);
            if (this.cancelled == true) goto L19;
            if (r0.hasNext() == false) goto L23;
            if (r7 == false) goto L5;
            r4 = r4 + 1;
            goto L5
        L23:
            if (this.cancelled == true) goto L52;
            r1.onComplete();
            return;
        L52:
            return;
        L19:
            return;
        L14:
            th = new NullPointerException("Iterator.next() returned a null value");
        L15:
            r1.onError(th);
            return;
        L12:
            return;
        L28:
            th = th;
            io.reactivex.exceptions.a.a(th);
            goto L15
        }
    }

    static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final org.a.c<? super T> downstream;

        IteratorSubscription(org.a.c<? super T> r3, Iterator<? extends T> r4) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            super((Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin"));
            this.downstream = r5;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void fastPath() {
            Iterator<? extends T> r0 = this.it;
            org.a.c<? super T> r1 = this.downstream;
        L4:
            if (this.cancelled == true) goto L5;
            T r2 = r0.next();     // Catch: Throwable -> L23
            if (this.cancelled == true) goto L9;
            if (r2 == null) goto L11;
            r1.onNext(r2);
            if (this.cancelled == true) goto L16;
            if (r0.hasNext() == true) goto L4;
            if (this.cancelled == true) goto L33;
            r1.onComplete();
            return;
        L33:
            return;
        L16:
            return;
        L11:
            th = new NullPointerException("Iterator.next() returned a null value");
        L12:
            r1.onError(th);
            return;
        L9:
            return;
        L23:
            th = th;
            io.reactivex.exceptions.a.a(th);
            goto L12
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void slowPath(long r9) {
            Iterator<? extends T> r0 = this.it;
            org.a.c<? super T> r1 = this.downstream;
        L3:
            long r4 = 0;
        L5:
            if (r4 != r9) goto L7;
            r9 = get();
            if (r4 != r9) goto L5;
            r9 = addAndGet(-r4);
            if (r9 != 0) goto L3;
            return;
        L7:
            if (this.cancelled == true) goto L8;
            T r6 = r0.next();     // Catch: Throwable -> L27
            if (this.cancelled == true) goto L12;
            if (r6 == null) goto L14;
            r1.onNext(r6);
            if (this.cancelled == true) goto L19;
            if (r0.hasNext() == false) goto L23;
            r4 = r4 + 1;
            goto L5
        L23:
            if (this.cancelled == true) goto L49;
            r1.onComplete();
            return;
        L49:
            return;
        L19:
            return;
        L14:
            th = new NullPointerException("Iterator.next() returned a null value");
        L15:
            r1.onError(th);
            return;
        L12:
            return;
        L27:
            th = th;
            io.reactivex.exceptions.a.a(th);
            goto L15
        }
    }

    public static <T> void a(org.a.c<? super T> r3, Iterator<? extends T> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        Iterator r6 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin");
        if (r6.hasNext() == true) goto L8;
        EmptySubscription.complete(r5);
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r5, io.reactivex.internal.a.a.class) == false) goto L10;
        org.a.d r0 = new IteratorConditionalSubscription((io.reactivex.internal.a.a) ZeusTransformUtils.preCheckCast(r5, io.reactivex.internal.a.a.class, "com.obric.memorydata.plugin"), r6);
    L11:
        r5.onSubscribe(r0);
        return;
    L10:
        r0 = new IteratorSubscription(r5, r6);
    L13:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(th, r5);
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        a(r4, this.f16775b.iterator());
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(th, r4);
    }
}
