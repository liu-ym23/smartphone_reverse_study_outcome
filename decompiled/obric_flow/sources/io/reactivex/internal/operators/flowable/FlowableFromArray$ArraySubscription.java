package io.reactivex.internal.operators.flowable;

import ai.j0;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableFromArray$ArraySubscription<T> extends FlowableFromArray$BaseArraySubscription<T> {
    private static final long serialVersionUID = 2587302975077663557L;
    final zu.c downstream;

    public FlowableFromArray$ArraySubscription(zu.c r5, T[] r10) {
        super(r10);
        this.downstream = r5;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription
    public void fastPath() {
        T[] r5 = this.array;
        int r10 = r5.length;
        zu.c r11 = this.downstream;
        int r12 = this.index;
    L3:
        if (r12 == r10) goto L13;
        if (this.cancelled == true) goto L6;
        T r13 = r5[r12];
        if (r13 == null) goto L9;
        r11.onNext(r13);
        r12 = r12 + 1;
        goto L3
    L9:
        r11.onError(new NullPointerException(j0.h(r12, "The element at index ", " is null")));
        return;
    L6:
        return;
    L13:
        if (this.cancelled == false) goto L15;
        return;
    L15:
        r11.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription
    public void slowPath(long r11) {
        T[] r5 = this.array;
        int r10 = r5.length;
        int r12 = this.index;
        zu.c r13 = this.downstream;
    L3:
        long r14 = 0;
    L5:
        if (r14 == r11) goto L15;
        if (r12 == r10) goto L15;
        if (this.cancelled == true) goto L9;
        T r15 = r5[r12];
        if (r15 == null) goto L12;
        r13.onNext(r15);
        r14 = r14 + 1;
        r12 = r12 + 1;
        goto L5
    L12:
        r13.onError(new NullPointerException(j0.h(r12, "The element at index ", " is null")));
        return;
    L9:
        return;
    L15:
        if (r12 == r10) goto L17;
        r11 = get();
        if (r14 != r11) goto L5;
        this.index = r12;
        r11 = addAndGet(-r14);
        if (r11 != 0) goto L3;
        return;
    L17:
        if (this.cancelled == true) goto L37;
        r13.onComplete();
        return;
    }
}
