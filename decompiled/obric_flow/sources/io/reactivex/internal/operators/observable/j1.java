package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class j1 extends io.reactivex.internal.observers.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.u f17826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f17827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17828c;
    public boolean d;
    public volatile boolean e;

    public j1(mt.u r5, Object[] r10) {
        this.f17826a = r5;
        this.f17827b = r10;
    }

    @Override // rt.h
    public final void clear() {
        this.f17828c = this.f17827b.length;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.e = true;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.e;
    }

    @Override // rt.h
    public final boolean isEmpty() {
        if (this.f17828c != this.f17827b.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // rt.h
    public final Object poll() {
        int r5 = this.f17828c;
        Object[] r10 = this.f17827b;
        if (r5 == r10.length) goto L6;
        this.f17828c = r5 + 1;
        Object r11 = r10[r5];
        io.reactivex.internal.functions.e.d(r11, "The array element is null");
        return r11;
    L6:
        return null;
    }

    @Override // rt.d
    public final int requestFusion(int r5) {
        if ((r5 & 1) == 0) goto L6;
        this.d = true;
        return 1;
    L6:
        return 0;
    }
}
