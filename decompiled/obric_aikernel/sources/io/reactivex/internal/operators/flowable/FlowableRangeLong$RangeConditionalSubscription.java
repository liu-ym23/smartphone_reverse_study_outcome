package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableRangeLong$RangeConditionalSubscription extends FlowableRangeLong$BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    final bc.a<? super Long> downstream;

    FlowableRangeLong$RangeConditionalSubscription(bc.a<? super Long> r10, long r11, long r12) {
        super(r11, r12);
        this.downstream = r10;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
    void fastPath() {
        long r10 = this.end;
        bc.a<? super Long> r11 = this.downstream;
        long r12 = this.index;
    L4:
        if (r12 == r10) goto L10;
        if (this.cancelled == true) goto L7;
        r11.tryOnNext(Long.valueOf(r12));
        r12 = r12 + 1;
        goto L4
    L7:
        return;
    L10:
        if (this.cancelled == false) goto L12;
        return;
    L12:
        r11.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
    void slowPath(long r13) {
        long r10 = this.end;
        long r11 = this.index;
        bc.a<? super Long> r12 = this.downstream;
    L3:
        long r14 = 0;
    L5:
        if (r14 == r13) goto L16;
        if (r11 == r10) goto L16;
        if (this.cancelled == true) goto L10;
        if (r12.tryOnNext(Long.valueOf(r11)) == false) goto L14;
        r14 = r14 + 1;
    L14:
        r11 = r11 + 1;
        goto L5
    L10:
        return;
    L16:
        if (r11 == r10) goto L18;
        r13 = get();
        if (r14 != r13) goto L5;
        this.index = r11;
        r13 = addAndGet(-r14);
        if (r13 != 0) goto L3;
        return;
    L18:
        if (this.cancelled == true) goto L37;
        r12.onComplete();
        return;
    }
}
