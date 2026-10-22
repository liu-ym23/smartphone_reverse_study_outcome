package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableRange$RangeConditionalSubscription extends FlowableRange$BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    final rt.a downstream;

    public FlowableRange$RangeConditionalSubscription(rt.a r5, int r10, int r11) {
        super(r10, r11);
        this.downstream = r5;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
    public void fastPath() {
        int r5 = this.end;
        rt.a r10 = this.downstream;
        int r11 = this.index;
    L3:
        if (r11 == r5) goto L9;
        if (this.cancelled == true) goto L6;
        r10.tryOnNext(Integer.valueOf(r11));
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
        rt.a r12 = this.downstream;
    L3:
        long r13 = 0;
    L5:
        if (r13 == r10) goto L14;
        if (r11 == r5) goto L14;
        if (this.cancelled == true) goto L9;
        if (r12.tryOnNext(Integer.valueOf(r11)) == false) goto L13;
        r13 = r13 + 1;
    L13:
        r11 = r11 + 1;
        goto L5
    L9:
        return;
    L14:
        if (r11 == r5) goto L16;
        r10 = get();
        if (r13 != r10) goto L5;
        this.index = r11;
        r10 = addAndGet(-r13);
        if (r10 != 0) goto L3;
        return;
    L16:
        if (this.cancelled == true) goto L35;
        r12.onComplete();
        return;
    }
}
