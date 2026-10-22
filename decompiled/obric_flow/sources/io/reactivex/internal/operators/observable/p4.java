package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class p4 extends io.reactivex.observers.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q4 f17913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.reactivex.subjects.i f17914c;
    public boolean d;

    public p4(q4 r5, io.reactivex.subjects.i r10) {
        this.f17913b = r5;
        this.f17914c = r10;
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.d == false) goto L5;
        return;
    L5:
        this.d = true;
        q4 r5 = this.f17913b;
        r5.f17931k.c(this);
        r4 r10 = new r4(this.f17914c, null);
        r5.f17640c.offer(r10);
        if (r5.i() == false) goto L9;
        r5.t();
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        if (this.d == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.d = true;
        q4 r10 = this.f17913b;
        r10.f17932l.dispose();
        r10.f17931k.dispose();
        r10.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        dispose();
        onComplete();
    }
}
