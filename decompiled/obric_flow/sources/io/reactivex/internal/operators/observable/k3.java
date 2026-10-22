package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class k3 extends st.a implements qt.c {
    public static final j3 e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.n f17840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f17841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d3 f17842c;
    public final h3 d;

    static {
        e = new j3();
    }

    public k3(h3 r5, mt.n r10, AtomicReference r11, d3 r12) {
        this.d = r5;
        this.f17840a = r10;
        this.f17841b = r11;
        this.f17842c = r12;
    }

    public static k3 e(mt.n r5, d3 r10) {
        AtomicReference r11 = new AtomicReference();
        return new k3(new h3(r11, r10), r5, r11, r10);
    }

    @Override // qt.c
    public final void a(Disposable r5) {
        ObservableReplay$ReplayObserver r10 = (ObservableReplay$ReplayObserver) r5;
    L3:
        AtomicReference r11 = this.f17841b;
        if (r11.compareAndSet(r10, null) == true) goto L8;
        if (r11.get() == r10) goto L3;
        return;
    }

    @Override // st.a
    public final void d(pt.g r5) {
    L2:
        AtomicReference r10 = this.f17841b;
        ObservableReplay$ReplayObserver r11 = (ObservableReplay$ReplayObserver) r10.get();
        if (r11 != null) goto L5;
    L6:
        ObservableReplay$ReplayObserver r12 = new ObservableReplay$ReplayObserver(this.f17842c.call());
    L8:
        if (r10.compareAndSet(r11, r12) == true) goto L9;
        if (r10.get() == r11) goto L8;
    L9:
        r11 = r12;
    L11:
        if (r11.shouldConnect.get() == false) goto L13;
    L15:
        boolean r13 = false;
    L28:
        r5.accept(r11);     // Catch: Throwable -> L20
        if (r13 == false) goto L34;
        this.f17840a.subscribe(r11);
        return;
    L34:
        return;
    L20:
        th = move-exception;
        if (r13 == false) goto L23;
        r11.shouldConnect.compareAndSet(true, false);
    L23:
        com.lynx.jsbridge.a.t(th);
        throw io.reactivex.internal.util.d.d(th);
    L13:
        if (r11.shouldConnect.compareAndSet(false, true) == false) goto L15;
        r13 = true;
        goto L28
    L5:
        if (r11.isDisposed() == false) goto L11;
        goto L6
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        this.d.subscribe(r5);
    }
}
