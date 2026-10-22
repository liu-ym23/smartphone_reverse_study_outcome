package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class r2 implements mt.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f17942a;

    public r2(AtomicReference r5) {
        this.f17942a = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mt.s
    public final void subscribe(mt.u r10) {
        ObservablePublish$InnerDisposable r5 = new ObservablePublish$InnerDisposable(r10);
        r10.onSubscribe(r5);
    L3:
        AtomicReference r11 = this.f17942a;
        q2 r12 = (q2) r11.get();
        if (r12 != null) goto L6;
    L9:
        q2 r13 = new q2(r11);
    L11:
        if (r11.compareAndSet(r12, r13) == true) goto L12;
        if (r11.get() == r12) goto L11;
    L12:
        q2 r14 = r13;
    L13:
        AtomicReference r15 = r14.f17923b;
        ObservablePublish$InnerDisposable[] r16 = (ObservablePublish$InnerDisposable[]) r15.get();
        if (r16 == q2.f) goto L3;
        int r17 = r16.length;
        ObservablePublish$InnerDisposable[] r18 = new ObservablePublish$InnerDisposable[r17 + 1];
        System.arraycopy(r16, 0, r18, 0, r17);
        r18[r17] = r5;
    L18:
        if (r15.compareAndSet(r16, r18) == true) goto L19;
        if (r15.get() == r16) goto L18;
    L19:
        r5.setParent(r14);
        return;
    L6:
        if (r12.isDisposed() == true) goto L9;
        r14 = r12;
        goto L13
    }
}
