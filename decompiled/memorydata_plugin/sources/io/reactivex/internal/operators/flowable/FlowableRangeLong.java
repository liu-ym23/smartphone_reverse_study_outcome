package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableRangeLong extends g<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f16787b;
    final long c;

    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final long end;
        long index;

        BaseRangeSubscription(long r1, long r3) {
            this.index = r1;
            this.end = r3;
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
        public final Long poll() {
            long r0 = this.index;
            if (r0 != this.end) goto L6;
            return null;
        L6:
            this.index = 1 + r0;
            return Long.valueOf(r0);
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
        final io.reactivex.internal.a.a<? super Long> downstream;

        RangeConditionalSubscription(io.reactivex.internal.a.a<? super Long> r3, long r4, long r6) {
            io.reactivex.internal.a.a<? super Long> r5 = (io.reactivex.internal.a.a) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.internal.a.a.class, "com.obric.memorydata.plugin");
            super(r4, r6);
            this.downstream = r5;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void fastPath() {
            long r0 = this.end;
            io.reactivex.internal.a.a<? super Long> r2 = this.downstream;
            long r3 = this.index;
        L4:
            if (r3 == r0) goto L10;
            if (this.cancelled == true) goto L7;
            r2.tryOnNext(Long.valueOf(r3));
            r3 = r3 + 1;
            goto L4
        L7:
            return;
        L10:
            if (this.cancelled == false) goto L12;
            return;
        L12:
            r2.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void slowPath(long r13) {
            long r0 = this.end;
            long r2 = this.index;
            io.reactivex.internal.a.a<? super Long> r4 = this.downstream;
        L3:
            long r7 = 0;
        L5:
            if (r7 == r13) goto L16;
            if (r2 == r0) goto L16;
            if (this.cancelled == true) goto L10;
            if (r4.tryOnNext(Long.valueOf(r2)) == false) goto L14;
            r7 = r7 + 1;
        L14:
            r2 = r2 + 1;
            goto L5
        L10:
            return;
        L16:
            if (r2 == r0) goto L18;
            r13 = get();
            if (r7 != r13) goto L5;
            this.index = r2;
            r13 = addAndGet(-r7);
            if (r13 != 0) goto L3;
            return;
        L18:
            if (this.cancelled == true) goto L37;
            r4.onComplete();
            return;
        }
    }

    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final org.a.c<? super Long> downstream;

        RangeSubscription(org.a.c<? super Long> r3, long r4, long r6) {
            org.a.c<? super Long> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            super(r4, r6);
            this.downstream = r5;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void fastPath() {
            long r0 = this.end;
            org.a.c<? super Long> r2 = this.downstream;
            long r3 = this.index;
        L4:
            if (r3 == r0) goto L10;
            if (this.cancelled == true) goto L7;
            r2.onNext(Long.valueOf(r3));
            r3 = r3 + 1;
            goto L4
        L7:
            return;
        L10:
            if (this.cancelled == false) goto L12;
            return;
        L12:
            r2.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void slowPath(long r12) {
            long r0 = this.end;
            long r2 = this.index;
            org.a.c<? super Long> r4 = this.downstream;
        L3:
            long r7 = 0;
        L5:
            if (r7 == r12) goto L13;
            if (r2 == r0) goto L13;
            if (this.cancelled == true) goto L10;
            r4.onNext(Long.valueOf(r2));
            r7 = r7 + 1;
            r2 = r2 + 1;
            goto L5
        L10:
            return;
        L13:
            if (r2 == r0) goto L15;
            r12 = get();
            if (r7 != r12) goto L5;
            this.index = r2;
            r12 = addAndGet(-r7);
            if (r12 != 0) goto L3;
            return;
        L15:
            if (this.cancelled == true) goto L34;
            r4.onComplete();
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super Long> r9) {
        org.a.c r10 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r9, org.a.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, io.reactivex.internal.a.a.class) == false) goto L5;
        org.a.d r0 = new RangeConditionalSubscription((io.reactivex.internal.a.a) ZeusTransformUtils.preCheckCast(r10, io.reactivex.internal.a.a.class, "com.obric.memorydata.plugin"), this.f16787b, this.c);
    L6:
        r10.onSubscribe(r0);
        return;
    L5:
        r0 = new RangeSubscription(r10, this.f16787b, this.c);
        goto L6
    }
}
