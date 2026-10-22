package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableRange$RangeConditionalSubscription extends FlowableRange$BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    final bc.a<? super Integer> downstream;

    FlowableRange$RangeConditionalSubscription(bc.a<? super Integer> r10, int r11, int r12) {
        super(r11, r12);
        this.downstream = r10;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
    void fastPath() {
        int r10 = this.end;
        bc.a<? super Integer> r11 = this.downstream;
        int r12 = this.index;
    L3:
        if (r12 == r10) goto L9;
        if (this.cancelled == true) goto L6;
        r11.tryOnNext(Integer.valueOf(r12));
        r12 = r12 + 1;
        goto L3
    L6:
        return;
    L9:
        if (this.cancelled == false) goto L11;
        return;
    L11:
        r11.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
    void slowPath(long r10) {
        int r11 = this.end;
        int r12 = this.index;
        bc.a<? super Integer> r13 = this.downstream;
    L3:
        long r14 = 0;
    L5:
        if (r14 == r10) goto L14;
        if (r12 == r11) goto L14;
        if (this.cancelled == true) goto L9;
        if (r13.tryOnNext(Integer.valueOf(r12)) == false) goto L13;
        r14 = r14 + 1;
    L13:
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    L14:
        if (r12 == r11) goto L16;
        r10 = get();
        if (r14 != r10) goto L5;
        this.index = r12;
        r10 = addAndGet(-r14);
        if (r10 != 0) goto L3;
        return;
    L16:
        if (this.cancelled == true) goto L35;
        r13.onComplete();
        return;
    }
}
