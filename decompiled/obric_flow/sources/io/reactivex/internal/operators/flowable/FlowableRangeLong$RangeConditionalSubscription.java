package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableRangeLong$RangeConditionalSubscription extends FlowableRangeLong$BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    final rt.a downstream;

    public FlowableRangeLong$RangeConditionalSubscription(rt.a r5, long r10, long r11) {
        super(r10, r11);
        this.downstream = r5;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
    public void fastPath() {
        long r5 = this.end;
        rt.a r10 = this.downstream;
        long r11 = this.index;
    L4:
        if (r11 == r5) goto L10;
        if (this.cancelled == true) goto L7;
        r10.tryOnNext(Long.valueOf(r11));
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
    public void slowPath(long r13) {
        long r5 = this.end;
        long r10 = this.index;
        rt.a r11 = this.downstream;
    L3:
        long r12 = 0;
    L5:
        if (r12 == r13) goto L16;
        if (r10 == r5) goto L16;
        if (this.cancelled == true) goto L10;
        if (r11.tryOnNext(Long.valueOf(r10)) == false) goto L14;
        r12 = r12 + 1;
    L14:
        r10 = r10 + 1;
        goto L5
    L10:
        return;
    L16:
        if (r10 == r5) goto L18;
        r13 = get();
        if (r12 != r13) goto L5;
        this.index = r10;
        r13 = addAndGet(-r12);
        if (r13 != 0) goto L3;
        return;
    L18:
        if (this.cancelled == true) goto L37;
        r11.onComplete();
        return;
    }
}
