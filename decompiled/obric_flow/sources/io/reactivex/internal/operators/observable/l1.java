package io.reactivex.internal.operators.observable;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class l1 extends io.reactivex.internal.observers.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.u f17850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterator f17851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f17852c;
    public boolean d;
    public boolean e;
    public boolean f;

    public l1(mt.u r5, Iterator r10) {
        this.f17850a = r5;
        this.f17851b = r10;
    }

    @Override // rt.h
    public final void clear() {
        this.e = true;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f17852c = true;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f17852c;
    }

    @Override // rt.h
    public final boolean isEmpty() {
        return this.e;
    }

    @Override // rt.h
    public final Object poll() {
        if (this.e == false) goto L5;
        return null;
    L5:
        boolean r5 = this.f;
        Iterator r10 = this.f17851b;
        if (r5 == true) goto L8;
        this.f = true;
    L12:
        Object r11 = r10.next();
        io.reactivex.internal.functions.e.d(r11, "The iterator returned a null value");
        return r11;
    L8:
        if (r10.hasNext() == true) goto L12;
        this.e = true;
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
