package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableReplay$SizeAndTimeBoundReplayBuffer<T> extends FlowableReplay$BoundedReplayBuffer<T> {
    private static final long serialVersionUID = 3457957419649567404L;
    final int limit;
    final long maxAge;
    final mt.z scheduler;
    final TimeUnit unit;

    public FlowableReplay$SizeAndTimeBoundReplayBuffer(int r5, long r10, TimeUnit r11, mt.z r12) {
        this.scheduler = r12;
        this.limit = r5;
        this.maxAge = r10;
        this.unit = r11;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public Object enterTransform(Object r5) {
        return new ut.f(r5, this.scheduler.b(this.unit), this.unit);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public FlowableReplay$Node getHead() {
        long r5 = this.scheduler.b(this.unit) - this.maxAge;
        FlowableReplay$Node r10 = get();
        FlowableReplay$Node r11 = r10.get();
    L3:
        FlowableReplay$Node r12 = r11;
        FlowableReplay$Node r13 = r10;
        r10 = r12;
        if (r10 == null) goto L14;
        ut.f r14 = (ut.f) r10.value;
        if (NotificationLite.isComplete(r14.f22464a) == true) goto L14;
        if (NotificationLite.isError(r14.f22464a) == true) goto L14;
        if (r14.f22465b > r5) goto L14;
        r11 = r10.get();
    L14:
        return r13;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public Object leaveTransform(Object r5) {
        return ((ut.f) r5).f22464a;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public void truncate() {
        long r5 = this.scheduler.b(this.unit) - this.maxAge;
        FlowableReplay$Node r10 = get();
        FlowableReplay$Node r11 = r10.get();
        int r12 = 0;
    L3:
        FlowableReplay$Node r13 = r11;
        FlowableReplay$Node r14 = r10;
        r10 = r13;
        if (r10 == null) goto L11;
        int r15 = this.size;
        if (r15 > this.limit) goto L7;
        if (((ut.f) r10.value).f22465b > r5) goto L11;
        r12 = r12 + 1;
        this.size = r15 - 1;
        r11 = r10.get();
        goto L3
    L7:
        r12 = r12 + 1;
        this.size = r15 - 1;
        r11 = r10.get();
    L11:
        if (r12 == 0) goto L21;
        setFirst(r14);
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public void truncateFinal() {
        long r5 = this.scheduler.b(this.unit) - this.maxAge;
        FlowableReplay$Node r10 = get();
        FlowableReplay$Node r11 = r10.get();
        int r12 = 0;
    L3:
        FlowableReplay$Node r13 = r11;
        FlowableReplay$Node r14 = r10;
        r10 = r13;
        if (r10 == null) goto L10;
        int r15 = this.size;
        if (r15 <= 1) goto L10;
        if (((ut.f) r10.value).f22465b > r5) goto L10;
        r12 = r12 + 1;
        this.size = r15 - 1;
        r11 = r10.get();
    L10:
        if (r12 == 0) goto L16;
        setFirst(r14);
        return;
    }
}
