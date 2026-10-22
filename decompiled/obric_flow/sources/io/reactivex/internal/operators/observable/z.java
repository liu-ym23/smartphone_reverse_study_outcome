package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f18087c;
    public final TimeUnit d;
    public final mt.z e;
    public final Callable f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f18088h;

    public z(mt.n r5, long r10, long r11, TimeUnit r12, mt.z r13, Callable r14, int r15, boolean r16) {
        super(r5);
        this.f18086b = r10;
        this.f18087c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f18088h = r16;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r18) {
        long r5 = this.f18086b;
        long r10 = this.f18087c;
        mt.s r11 = this.f17702a;
        if (r5 == r10) goto L5;
    L8:
        mt.y r16 = this.e.a();
        long r12 = this.f18086b;
        long r13 = this.f18087c;
        if (r12 != r13) goto L12;
        r11.subscribe(new v(new io.reactivex.observers.d(r18), this.f, r12, this.d, this.g, this.f18088h, r16));
        return;
    L12:
        r11.subscribe(new y(new io.reactivex.observers.d(r18), this.f, r12, r13, this.d, r16));
        return;
    L5:
        if (this.g != Integer.MAX_VALUE) goto L8;
        io.reactivex.observers.d r14 = new io.reactivex.observers.d(r18);
        mt.z r15 = this.e;
        r11.subscribe(new w(r14, this.f, r5, this.d, r15));
    }
}
