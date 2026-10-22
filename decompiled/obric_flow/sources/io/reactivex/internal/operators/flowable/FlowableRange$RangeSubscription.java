package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableRange$RangeSubscription extends FlowableRange$BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    final zu.c downstream;

    public FlowableRange$RangeSubscription(zu.c r5, int r10, int r11) {
        super(r10, r11);
        this.downstream = r5;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
    public void fastPath() {
        int r5 = this.end;
        zu.c r10 = this.downstream;
        int r11 = this.index;
    L3:
        if (r11 == r5) goto L9;
        if (this.cancelled == true) goto L6;
        r10.onNext(Integer.valueOf(r11));
        r11 = r11 + 1;
        goto L3
    L6:
        return;
    L9:
        if (this.cancelled == false) goto L11;
        return;
    L11:
        r10.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
    public void slowPath(long r10) {
        int r5 = this.end;
        int r11 = this.index;
        zu.c r12 = this.downstream;
    L3:
        long r13 = 0;
    L5:
        if (r13 == r10) goto L11;
        if (r11 == r5) goto L11;
        if (this.cancelled == true) goto L9;
        r12.onNext(Integer.valueOf(r11));
        r13 = r13 + 1;
        r11 = r11 + 1;
        goto L5
    L9:
        return;
    L11:
        if (r11 == r5) goto L13;
        r10 = get();
        if (r13 != r10) goto L5;
        this.index = r11;
        r10 = addAndGet(-r13);
        if (r10 != 0) goto L3;
        return;
    L13:
        if (this.cancelled == true) goto L32;
        r12.onComplete();
        return;
    }
}
