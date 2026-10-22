package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17825b;

    public /* synthetic */ j0(mt.s r5, int r10) {
        this.f17825b = r10;
        super(r5);
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        switch(this.f17825b) {
            case 0: goto L23;
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L25;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        g2 r10 = new g2(r5, 1);
        this.f17702a.subscribe(r10);
        return;
    L6:
        io.reactivex.observers.d r11 = new io.reactivex.observers.d(r5);
        this.f17702a.subscribe(r11);
        return;
    L8:
        t0 r12 = new t0(r5, 3);
        this.f17702a.subscribe(r12);
        return;
    L17:
        t0 r13 = new t0(r5, 2);
        this.f17702a.subscribe(r13);
        return;
    L19:
        t0 r14 = new t0(r5, 1);
        this.f17702a.subscribe(r14);
        return;
    L21:
        t0 r15 = new t0();
        r15.f17970b = r5;
        this.f17702a.subscribe(r15);
        return;
    L23:
        i0 r16 = new i0(r5, 0);
        this.f17702a.subscribe(r16);
        return;
    L25:
        throw null;     // Catch: Throwable -> L12 NullPointerException -> L15
    L15:
        e = move-exception;
        throw e;
    L12:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
        NullPointerException r17 = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
        r17.initCause(th);
        throw r17;
    }
}
