package io.reactivex.internal.operators.observable;

import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public final class u0 extends io.reactivex.internal.observers.a {
    public final Collection f;
    public final pt.o g;

    public u0(mt.u r5, pt.o r10, Collection r11) {
        super(r5);
        this.g = r10;
        this.f = r11;
    }

    @Override // io.reactivex.internal.observers.a, rt.h
    public final void clear() {
        this.f.clear();
        super.clear();
    }

    @Override // io.reactivex.internal.observers.a, mt.u
    public final void onComplete() {
        if (this.d == true) goto L6;
        this.d = true;
        this.f.clear();
        this.f17623a.onComplete();
        return;
    }

    @Override // io.reactivex.internal.observers.a, mt.u
    public final void onError(Throwable r5) {
        if (this.d == false) goto L5;
        wn.f.k(r5);
        return;
    L5:
        this.d = true;
        this.f.clear();
        this.f17623a.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (this.d == false) goto L5;
        return;
    L5:
        int r10 = this.e;
        mt.u r11 = this.f17623a;
        if (r10 == 0) goto L15;
        r11.onNext(null);
        return;
    L15:
        Object r12 = this.g.apply(r5);     // Catch: Throwable -> L10
        io.reactivex.internal.functions.e.d(r12, "The keySelector returned a null key");     // Catch: Throwable -> L10
        if (this.f.add(r12) == false) goto L17;
        r11.onNext(r5);
        return;
    L17:
        return;
    L10:
        th = move-exception;
        a(th);
    }

    @Override // rt.h
    public final Object poll() {
    L2:
        Object r5 = this.f17625c.poll();
        if (r5 == null) goto L6;
        Object r10 = this.g.apply(r5);
        io.reactivex.internal.functions.e.d(r10, "The keySelector returned a null key");
        if (this.f.add(r10) == false) goto L2;
    L6:
        return r5;
    }
}
