package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableFromArray<T> extends g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final T[] f16774b;

    static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final io.reactivex.internal.a.a<? super T> downstream;

        ArrayConditionalSubscription(io.reactivex.internal.a.a<? super T> r3, T[] r4) {
            io.reactivex.internal.a.a<? super T> r5 = (io.reactivex.internal.a.a) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.internal.a.a.class, "com.obric.memorydata.plugin");
            super(r4);
            this.downstream = r5;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void fastPath() {
            T[] r0 = this.array;
            int r1 = r0.length;
            io.reactivex.internal.a.a<? super T> r2 = this.downstream;
            int r3 = this.index;
        L3:
            if (r3 == r1) goto L13;
            if (this.cancelled == true) goto L6;
            T r4 = r0[r3];
            if (r4 == null) goto L9;
            r2.tryOnNext(r4);
            r3 = r3 + 1;
            goto L3
        L9:
            r2.onError(new NullPointerException("The element at index " + r3 + " is null"));
            return;
        L6:
            return;
        L13:
            if (this.cancelled == false) goto L15;
            return;
        L15:
            r2.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void slowPath(long r11) {
            T[] r0 = this.array;
            int r1 = r0.length;
            int r2 = this.index;
            io.reactivex.internal.a.a<? super T> r3 = this.downstream;
        L3:
            long r6 = 0;
        L5:
            if (r6 == r11) goto L18;
            if (r2 == r1) goto L18;
            if (this.cancelled == true) goto L9;
            T r8 = r0[r2];
            if (r8 == null) goto L12;
            if (r3.tryOnNext(r8) == false) goto L17;
            r6 = r6 + 1;
        L17:
            r2 = r2 + 1;
            goto L5
        L12:
            r3.onError(new NullPointerException("The element at index " + r2 + " is null"));
            return;
        L9:
            return;
        L18:
            if (r2 == r1) goto L20;
            r11 = get();
            if (r6 != r11) goto L5;
            this.index = r2;
            r11 = addAndGet(-r6);
            if (r11 != 0) goto L3;
            return;
        L20:
            if (this.cancelled == true) goto L40;
            r3.onComplete();
            return;
        }
    }

    static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final org.a.c<? super T> downstream;

        ArraySubscription(org.a.c<? super T> r3, T[] r4) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            super(r4);
            this.downstream = r5;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void fastPath() {
            T[] r0 = this.array;
            int r1 = r0.length;
            org.a.c<? super T> r2 = this.downstream;
            int r3 = this.index;
        L3:
            if (r3 == r1) goto L13;
            if (this.cancelled == true) goto L6;
            T r4 = r0[r3];
            if (r4 == null) goto L9;
            r2.onNext(r4);
            r3 = r3 + 1;
            goto L3
        L9:
            r2.onError(new NullPointerException("The element at index " + r3 + " is null"));
            return;
        L6:
            return;
        L13:
            if (this.cancelled == false) goto L15;
            return;
        L15:
            r2.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void slowPath(long r11) {
            T[] r0 = this.array;
            int r1 = r0.length;
            int r2 = this.index;
            org.a.c<? super T> r3 = this.downstream;
        L3:
            long r6 = 0;
        L5:
            if (r6 == r11) goto L15;
            if (r2 == r1) goto L15;
            if (this.cancelled == true) goto L9;
            T r8 = r0[r2];
            if (r8 == null) goto L12;
            r3.onNext(r8);
            r6 = r6 + 1;
            r2 = r2 + 1;
            goto L5
        L12:
            r3.onError(new NullPointerException("The element at index " + r2 + " is null"));
            return;
        L9:
            return;
        L15:
            if (r2 == r1) goto L17;
            r11 = get();
            if (r6 != r11) goto L5;
            this.index = r2;
            r11 = addAndGet(-r6);
            if (r11 != 0) goto L3;
            return;
        L17:
            if (this.cancelled == true) goto L37;
            r3.onComplete();
            return;
        }
    }

    static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;

        BaseArraySubscription(T[] r1) {
            this.array = r1;
        }

        @Override // org.a.d
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.internal.a.f
        public final void clear() {
            this.index = this.array.length;
        }

        abstract void fastPath();

        @Override // io.reactivex.internal.a.f
        public final boolean isEmpty() {
            if (this.index != this.array.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.internal.a.f
        public final T poll() {
            int r0 = this.index;
            T[] r1 = this.array;
            if (r0 != r1.length) goto L6;
            return null;
        L6:
            this.index = r0 + 1;
            return (T) io.reactivex.internal.functions.a.a(r1[r0], "array element is null");
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

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, io.reactivex.internal.a.a.class) == false) goto L5;
        org.a.d r0 = new ArrayConditionalSubscription((io.reactivex.internal.a.a) ZeusTransformUtils.preCheckCast(r5, io.reactivex.internal.a.a.class, "com.obric.memorydata.plugin"), this.f16774b);
    L6:
        r5.onSubscribe(r0);
        return;
    L5:
        r0 = new ArraySubscription(r5, this.f16774b);
        goto L6
    }
}
