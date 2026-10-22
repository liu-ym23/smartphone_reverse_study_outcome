package io.reactivex.internal.operators.observable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends io.reactivex.observers.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayBlockingQueue f17806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f17807c;

    public i() {
        this.f17806b = new ArrayBlockingQueue(1);
        this.f17807c = new AtomicInteger();
    }

    @Override // mt.u
    public final void onComplete() {
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        wn.f.k(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        mt.l r10 = (mt.l) r5;
        if (this.f17807c.getAndSet(0) == 1) goto L6;
        if (r10.c() == false) goto L6;
        return;
    L6:
        ArrayBlockingQueue r11 = this.f17806b;
        if (r11.offer(r10) == true) goto L22;
        mt.l r12 = (mt.l) r11.poll();
        if (r12 == null) goto L6;
        if (r12.c() == true) goto L6;
        r10 = r12;
        goto L6
    }
}
