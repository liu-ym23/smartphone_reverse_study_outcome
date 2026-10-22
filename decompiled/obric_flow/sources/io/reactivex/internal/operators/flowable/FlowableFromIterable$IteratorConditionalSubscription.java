package io.reactivex.internal.operators.flowable;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableFromIterable$IteratorConditionalSubscription<T> extends FlowableFromIterable$BaseRangeSubscription<T> {
    private static final long serialVersionUID = -6022804456014692607L;
    final rt.a downstream;

    public FlowableFromIterable$IteratorConditionalSubscription(rt.a r5, Iterator<? extends T> r10) {
        super(r10);
        this.downstream = r5;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable$BaseRangeSubscription
    public void fastPath() {
        Iterator<? extends T> r5 = this.it;
        rt.a r10 = this.downstream;
    L4:
        if (this.cancelled == true) goto L5;
        T r11 = r5.next();     // Catch: Throwable -> L25
        if (this.cancelled == true) goto L9;
        if (r11 == null) goto L11;
        r10.tryOnNext(r11);
        if (this.cancelled == true) goto L15;
        if (r5.hasNext() == true) goto L4;
        if (this.cancelled == true) goto L38;
        r10.onComplete();
        return;
    L38:
        return;
    L22:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r10.onError(th);
        return;
    L15:
        return;
    L11:
        r10.onError(new NullPointerException("Iterator.next() returned a null value"));
        return;
    L9:
        return;
    L25:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r10.onError(th);
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable$BaseRangeSubscription
    public void slowPath(long r10) {
        Iterator<? extends T> r5 = this.it;
        rt.a r11 = this.downstream;
    L3:
        long r12 = 0;
    L5:
        if (r12 != r10) goto L7;
        r10 = get();
        if (r12 != r10) goto L5;
        r10 = addAndGet(-r12);
        if (r10 != 0) goto L3;
        return;
    L7:
        if (this.cancelled == true) goto L8;
        T r13 = r5.next();     // Catch: Throwable -> L30
        if (this.cancelled == true) goto L12;
        if (r13 == null) goto L14;
        boolean r14 = r11.tryOnNext(r13);
        if (this.cancelled == true) goto L18;
        if (r5.hasNext() == false) goto L22;
        if (r14 == false) goto L5;
        r12 = r12 + 1;
        goto L5
    L22:
        if (this.cancelled == true) goto L57;
        r11.onComplete();
        return;
    L57:
        return;
    L27:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r11.onError(th);
        return;
    L18:
        return;
    L14:
        r11.onError(new NullPointerException("Iterator.next() returned a null value"));
        return;
    L12:
        return;
    L30:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r11.onError(th);
        return;
    }
}
