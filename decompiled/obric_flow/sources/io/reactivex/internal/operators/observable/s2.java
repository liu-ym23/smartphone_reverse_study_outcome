package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class s2 extends st.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.n f17955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f17956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r2 f17957c;

    public s2(r2 r5, mt.n r10, AtomicReference r11) {
        this.f17957c = r5;
        this.f17955a = r10;
        this.f17956b = r11;
    }

    @Override // st.a
    public final void d(pt.g r5) {
    L2:
        AtomicReference r10 = this.f17956b;
        q2 r11 = (q2) r10.get();
        if (r11 != null) goto L5;
    L6:
        q2 r12 = new q2(r10);
    L8:
        if (r10.compareAndSet(r11, r12) == true) goto L9;
        if (r10.get() == r11) goto L8;
    L9:
        r11 = r12;
    L10:
        AtomicBoolean r13 = r11.f17924c;
        boolean r14 = false;
        if (r13.get() == false) goto L13;
    L25:
        r5.accept(r11);     // Catch: Throwable -> L19
        if (r14 == false) goto L31;
        this.f17955a.subscribe(r11);
        return;
    L31:
        return;
    L19:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        throw io.reactivex.internal.util.d.d(th);
    L13:
        if (r13.compareAndSet(false, true) == false) goto L25;
        r14 = true;
        goto L25
    L5:
        if (r11.isDisposed() == false) goto L10;
        goto L6
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        this.f17957c.subscribe(r5);
    }
}
