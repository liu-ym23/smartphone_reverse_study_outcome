package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableRangeLong$RangeSubscription extends FlowableRangeLong$BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    final zu.c downstream;

    public FlowableRangeLong$RangeSubscription(zu.c r5, long r10, long r11) {
        super(r10, r11);
        this.downstream = r5;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
    public void fastPath() {
        long r5 = this.end;
        zu.c r10 = this.downstream;
        long r11 = this.index;
    L4:
        if (r11 == r5) goto L10;
        if (this.cancelled == true) goto L7;
        r10.onNext(Long.valueOf(r11));
        r11 = r11 + 1;
        goto L4
    L7:
        return;
    L10:
        if (this.cancelled == false) goto L12;
        return;
    L12:
        r10.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
    public void slowPath(long r12) {
        long r5 = this.end;
        long r10 = this.index;
        zu.c r11 = this.downstream;
    L3:
        long r13 = 0;
    L5:
        if (r13 == r12) goto L13;
        if (r10 == r5) goto L13;
        if (this.cancelled == true) goto L10;
        r11.onNext(Long.valueOf(r10));
        r13 = r13 + 1;
        r10 = r10 + 1;
        goto L5
    L10:
        return;
    L13:
        if (r10 == r5) goto L15;
        r12 = get();
        if (r13 != r12) goto L5;
        this.index = r10;
        r12 = addAndGet(-r13);
        if (r12 != 0) goto L3;
        return;
    L15:
        if (this.cancelled == true) goto L34;
        r11.onComplete();
        return;
    }
}
