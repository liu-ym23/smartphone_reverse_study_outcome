package io.reactivex.internal.operators.flowable;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableFromIterable$IteratorSubscription<T> extends FlowableFromIterable$BaseRangeSubscription<T> {
    private static final long serialVersionUID = -6022804456014692607L;
    final tc.c<? super T> downstream;

    FlowableFromIterable$IteratorSubscription(tc.c<? super T> r10, Iterator<? extends T> r11) {
        super(r11);
        this.downstream = r10;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable$BaseRangeSubscription
    void fastPath() {
        Iterator<? extends T> r10 = this.it;
        tc.c<? super T> r11 = this.downstream;
    L4:
        if (this.cancelled == true) goto L5;
        T r12 = r10.next();     // Catch: Throwable -> L23
        if (this.cancelled == true) goto L9;
        if (r12 == null) goto L11;
        r11.onNext(r12);
        if (this.cancelled == true) goto L16;
        if (r10.hasNext() == true) goto L4;
        if (this.cancelled == true) goto L33;
        r11.onComplete();
        return;
    L33:
        return;
    L16:
        return;
    L11:
        th = new NullPointerException("Iterator.next() returned a null value");
    L12:
        r11.onError(th);
        return;
    L9:
        return;
    L23:
        th = th;
        io.reactivex.exceptions.a.a(th);
        goto L12
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable$BaseRangeSubscription
    void slowPath(long r10) {
        Iterator<? extends T> r11 = this.it;
        tc.c<? super T> r12 = this.downstream;
    L3:
        long r13 = 0;
    L5:
        if (r13 != r10) goto L7;
        r10 = get();
        if (r13 != r10) goto L5;
        r10 = addAndGet(-r13);
        if (r10 != 0) goto L3;
        return;
    L7:
        if (this.cancelled == true) goto L8;
        T r14 = r11.next();     // Catch: Throwable -> L27
        if (this.cancelled == true) goto L12;
        if (r14 == null) goto L14;
        r12.onNext(r14);
        if (this.cancelled == true) goto L19;
        if (r11.hasNext() == false) goto L23;
        r13 = r13 + 1;
        goto L5
    L23:
        if (this.cancelled == true) goto L49;
        r12.onComplete();
        return;
    L49:
        return;
    L19:
        return;
    L14:
        th = new NullPointerException("Iterator.next() returned a null value");
    L15:
        r12.onError(th);
        return;
    L12:
        return;
    L27:
        th = th;
        io.reactivex.exceptions.a.a(th);
        goto L15
    }
}
