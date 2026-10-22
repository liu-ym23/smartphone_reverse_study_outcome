package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableDoFinally<T> extends a<T, T> {
    final io.reactivex.b.a c;

    static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements io.reactivex.internal.a.a<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final io.reactivex.internal.a.a<? super T> downstream;
        final io.reactivex.b.a onFinally;
        io.reactivex.internal.a.d<T> qs;
        boolean syncFused;
        org.a.d upstream;

        DoFinallyConditionalSubscriber(io.reactivex.internal.a.a<? super T> r3, io.reactivex.b.a r4) {
            io.reactivex.internal.a.a<? super T> r5 = (io.reactivex.internal.a.a) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.internal.a.a.class, "com.obric.memorydata.plugin");
            io.reactivex.b.a r6 = (io.reactivex.b.a) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.b.a.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.onFinally = r6;
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.cancel();
            runFinally();
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            this.qs.clear();
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // org.a.c
        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            this.downstream.onError(r2);
            runFinally();
        }

        @Override // org.a.c
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L9;
            this.upstream = r4;
            if (ZeusTransformUtils.instanceOf(r4, io.reactivex.internal.a.d.class) == false) goto L7;
            this.qs = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r4, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
        L7:
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.internal.a.f
        public T poll() {
            T r0 = this.qs.poll();
            if (r0 == null) goto L5;
        L7:
            return r0;
        L5:
            if (this.syncFused == false) goto L7;
            runFinally();
            goto L7
        }

        @Override // org.a.d
        public void request(long r1) {
            this.upstream.request(r1);
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r4) {
            io.reactivex.internal.a.d<T> r0 = this.qs;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L13:
            return 0;
        L5:
            if ((r4 & 4) != 0) goto L13;
            int r5 = r0.requestFusion(r4);
            if (r5 != 0) goto L9;
        L12:
            return r5;
        L9:
            if (r5 != 1) goto L11;
            r1 = true;
        L11:
            this.syncFused = r1;
            goto L12
        }

        void runFinally() {
            if (compareAndSet(0, 1) == false) goto L11;
            this.onFinally.a();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            io.reactivex.d.a.a(th);
            return;
        }

        @Override // io.reactivex.internal.a.a
        public boolean tryOnNext(T r1) {
            return this.downstream.tryOnNext(r1);
        }
    }

    static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements j<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final org.a.c<? super T> downstream;
        final io.reactivex.b.a onFinally;
        io.reactivex.internal.a.d<T> qs;
        boolean syncFused;
        org.a.d upstream;

        DoFinallySubscriber(org.a.c<? super T> r3, io.reactivex.b.a r4) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            io.reactivex.b.a r6 = (io.reactivex.b.a) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.b.a.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.onFinally = r6;
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.cancel();
            runFinally();
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            this.qs.clear();
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // org.a.c
        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            this.downstream.onError(r2);
            runFinally();
        }

        @Override // org.a.c
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L9;
            this.upstream = r4;
            if (ZeusTransformUtils.instanceOf(r4, io.reactivex.internal.a.d.class) == false) goto L7;
            this.qs = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r4, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
        L7:
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.internal.a.f
        public T poll() {
            T r0 = this.qs.poll();
            if (r0 == null) goto L5;
        L7:
            return r0;
        L5:
            if (this.syncFused == false) goto L7;
            runFinally();
            goto L7
        }

        @Override // org.a.d
        public void request(long r1) {
            this.upstream.request(r1);
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r4) {
            io.reactivex.internal.a.d<T> r0 = this.qs;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L13:
            return 0;
        L5:
            if ((r4 & 4) != 0) goto L13;
            int r5 = r0.requestFusion(r4);
            if (r5 != 0) goto L9;
        L12:
            return r5;
        L9:
            if (r5 != 1) goto L11;
            r1 = true;
        L11:
            this.syncFused = r1;
            goto L12
        }

        void runFinally() {
            if (compareAndSet(0, 1) == false) goto L11;
            this.onFinally.a();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            io.reactivex.d.a.a(th);
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, io.reactivex.internal.a.a.class) == false) goto L5;
        this.f16812b.a(new DoFinallyConditionalSubscriber((io.reactivex.internal.a.a) ZeusTransformUtils.preCheckCast(r6, io.reactivex.internal.a.a.class, "com.obric.memorydata.plugin"), this.c));
        return;
    L5:
        this.f16812b.a(new DoFinallySubscriber(r6, this.c));
    }
}
