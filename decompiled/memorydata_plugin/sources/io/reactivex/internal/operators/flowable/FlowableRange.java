package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableRange extends g<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f16786b;
    final int c;

    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final int end;
        int index;

        BaseRangeSubscription(int r1, int r2) {
            this.index = r1;
            this.end = r2;
        }

        @Override // org.a.d
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.internal.a.f
        public final void clear() {
            this.index = this.end;
        }

        abstract void fastPath();

        @Override // io.reactivex.internal.a.f
        public final boolean isEmpty() {
            if (this.index != this.end) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.internal.a.f
        public final Integer poll() {
            int r0 = this.index;
            if (r0 != this.end) goto L6;
            return null;
        L6:
            this.index = r0 + 1;
            return Integer.valueOf(r0);
        }

        @Override // io.reactivex.internal.a.f
        public /* bridge */ /* synthetic */ Object poll() {
            return poll();
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

    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final io.reactivex.internal.a.a<? super Integer> downstream;

        RangeConditionalSubscription(io.reactivex.internal.a.a<? super Integer> r3, int r4, int r5) {
            io.reactivex.internal.a.a<? super Integer> r6 = (io.reactivex.internal.a.a) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.internal.a.a.class, "com.obric.memorydata.plugin");
            super(r4, r5);
            this.downstream = r6;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void fastPath() {
            int r0 = this.end;
            io.reactivex.internal.a.a<? super Integer> r1 = this.downstream;
            int r2 = this.index;
        L3:
            if (r2 == r0) goto L9;
            if (this.cancelled == true) goto L6;
            r1.tryOnNext(Integer.valueOf(r2));
            r2 = r2 + 1;
            goto L3
        L6:
            return;
        L9:
            if (this.cancelled == false) goto L11;
            return;
        L11:
            r1.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void slowPath(long r10) {
            int r0 = this.end;
            int r1 = this.index;
            io.reactivex.internal.a.a<? super Integer> r2 = this.downstream;
        L3:
            long r5 = 0;
        L5:
            if (r5 == r10) goto L14;
            if (r1 == r0) goto L14;
            if (this.cancelled == true) goto L9;
            if (r2.tryOnNext(Integer.valueOf(r1)) == false) goto L13;
            r5 = r5 + 1;
        L13:
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        L14:
            if (r1 == r0) goto L16;
            r10 = get();
            if (r5 != r10) goto L5;
            this.index = r1;
            r10 = addAndGet(-r5);
            if (r10 != 0) goto L3;
            return;
        L16:
            if (this.cancelled == true) goto L35;
            r2.onComplete();
            return;
        }
    }

    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final org.a.c<? super Integer> downstream;

        RangeSubscription(org.a.c<? super Integer> r3, int r4, int r5) {
            org.a.c<? super Integer> r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            super(r4, r5);
            this.downstream = r6;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void fastPath() {
            int r0 = this.end;
            org.a.c<? super Integer> r1 = this.downstream;
            int r2 = this.index;
        L3:
            if (r2 == r0) goto L9;
            if (this.cancelled == true) goto L6;
            r1.onNext(Integer.valueOf(r2));
            r2 = r2 + 1;
            goto L3
        L6:
            return;
        L9:
            if (this.cancelled == false) goto L11;
            return;
        L11:
            r1.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void slowPath(long r10) {
            int r0 = this.end;
            int r1 = this.index;
            org.a.c<? super Integer> r2 = this.downstream;
        L3:
            long r5 = 0;
        L5:
            if (r5 == r10) goto L11;
            if (r1 == r0) goto L11;
            if (this.cancelled == true) goto L9;
            r2.onNext(Integer.valueOf(r1));
            r5 = r5 + 1;
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        L11:
            if (r1 == r0) goto L13;
            r10 = get();
            if (r5 != r10) goto L5;
            this.index = r1;
            r10 = addAndGet(-r5);
            if (r10 != 0) goto L3;
            return;
        L13:
            if (this.cancelled == true) goto L32;
            r2.onComplete();
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super Integer> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, io.reactivex.internal.a.a.class) == false) goto L5;
        org.a.d r0 = new RangeConditionalSubscription((io.reactivex.internal.a.a) ZeusTransformUtils.preCheckCast(r5, io.reactivex.internal.a.a.class, "com.obric.memorydata.plugin"), this.f16786b, this.c);
    L6:
        r5.onSubscribe(r0);
        return;
    L5:
        r0 = new RangeSubscription(r5, this.f16786b, this.c);
        goto L6
    }
}
