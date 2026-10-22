package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableFromArray$ArrayConditionalSubscription<T> extends FlowableFromArray$BaseArraySubscription<T> {
    private static final long serialVersionUID = 2587302975077663557L;
    final bc.a<? super T> downstream;

    FlowableFromArray$ArrayConditionalSubscription(bc.a<? super T> r10, T[] r11) {
        super(r11);
        this.downstream = r10;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription
    void fastPath() {
        T[] r10 = this.array;
        int r11 = r10.length;
        bc.a<? super T> r12 = this.downstream;
        int r13 = this.index;
    L3:
        if (r13 == r11) goto L13;
        if (this.cancelled == true) goto L6;
        T r14 = r10[r13];
        if (r14 == null) goto L9;
        r12.tryOnNext(r14);
        r13 = r13 + 1;
        goto L3
    L9:
        r12.onError(new NullPointerException("array element is null"));
        return;
    L6:
        return;
    L13:
        if (this.cancelled == false) goto L15;
        return;
    L15:
        r12.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription
    void slowPath(long r11) {
        T[] r10 = this.array;
        int r12 = r10.length;
        int r13 = this.index;
        bc.a<? super T> r14 = this.downstream;
    L3:
        long r15 = 0;
    L5:
        if (r15 == r11) goto L18;
        if (r13 == r12) goto L18;
        if (this.cancelled == true) goto L9;
        T r16 = r10[r13];
        if (r16 == null) goto L12;
        if (r14.tryOnNext(r16) == false) goto L17;
        r15 = r15 + 1;
    L17:
        r13 = r13 + 1;
        goto L5
    L12:
        r14.onError(new NullPointerException("array element is null"));
        return;
    L9:
        return;
    L18:
        if (r13 == r12) goto L20;
        r11 = get();
        if (r15 != r11) goto L5;
        this.index = r13;
        r11 = addAndGet(-r15);
        if (r11 != 0) goto L3;
        return;
    L20:
        if (this.cancelled == true) goto L40;
        r14.onComplete();
        return;
    }
}
