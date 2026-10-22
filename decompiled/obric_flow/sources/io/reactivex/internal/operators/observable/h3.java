package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class h3 implements mt.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f17804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d3 f17805b;

    public h3(AtomicReference r5, d3 r10) {
        this.f17804a = r5;
        this.f17805b = r10;
    }

    @Override // mt.s
    public final void subscribe(mt.u r5) {
    L2:
        AtomicReference r10 = this.f17804a;
        ObservableReplay$ReplayObserver r11 = (ObservableReplay$ReplayObserver) r10.get();
        if (r11 != null) goto L11;
        ObservableReplay$ReplayObserver r12 = new ObservableReplay$ReplayObserver(this.f17805b.call());
    L6:
        if (r10.compareAndSet(null, r12) == true) goto L7;
        if (r10.get() == null) goto L6;
    L7:
        r11 = r12;
    L11:
        ObservableReplay$InnerDisposable r13 = new ObservableReplay$InnerDisposable(r11, r5);
        r5.onSubscribe(r13);
        r11.add(r13);
        if (r13.isDisposed() == false) goto L15;
        r11.remove(r13);
        return;
    L15:
        r11.buffer.replay(r13);
    }
}
