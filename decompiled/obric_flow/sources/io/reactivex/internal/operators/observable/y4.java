package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class y4 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f18084c;
    public final TimeUnit d;
    public final mt.z e;
    public final long f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f18085h;

    public y4(mt.n r5, long r10, long r11, TimeUnit r12, mt.z r13, long r14, int r15, boolean r16) {
        super(r5);
        this.f18083b = r10;
        this.f18084c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f18085h = r16;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r12) {
        io.reactivex.observers.d r5 = new io.reactivex.observers.d(r12);
        long r10 = this.f18083b;
        long r11 = this.f18084c;
        mt.s r13 = this.f17702a;
        if (r10 != r11) goto L10;
        long r14 = this.f;
        if (r14 != Long.MAX_VALUE) goto L8;
        int r15 = this.g;
        r13.subscribe(new v4(r5, r10, this.d, this.e, r15));
        return;
    L8:
        r13.subscribe(new u4(r5, r10, this.d, this.e, this.g, r14, this.f18085h));
        return;
    L10:
        mt.y r16 = this.e.a();
        int r17 = this.g;
        r13.subscribe(new x4(r5, r10, r11, this.d, r16, r17));
    }
}
