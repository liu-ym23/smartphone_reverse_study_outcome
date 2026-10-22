package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 extends io.reactivex.internal.observers.a {
    public final pt.o f;
    public final pt.d g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f18012h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f18013i;

    public v0(mt.u r5, pt.o r10, pt.d r11) {
        super(r5);
        this.f = r10;
        this.g = r11;
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (this.d == false) goto L5;
        return;
    L5:
        int r10 = this.e;
        mt.u r11 = this.f17623a;
        if (r10 == 0) goto L21;
        r11.onNext(r5);
        return;
    L21:
        Object r12 = this.f.apply(r5);     // Catch: Throwable -> L14
        if (this.f18013i == false) goto L16;
        pt.d r13 = this.g;     // Catch: Throwable -> L14
        Object r14 = this.f18012h;     // Catch: Throwable -> L14
        ((com.lynx.tasm.utils.c) r13).getClass();     // Catch: Throwable -> L14
        boolean r15 = io.reactivex.internal.functions.e.b(r14, r12);     // Catch: Throwable -> L14
        this.f18012h = r12;     // Catch: Throwable -> L14
        if (r15 == false) goto L17;
        return;
    L17:
        r11.onNext(r5);
        return;
    L16:
        this.f18013i = true;     // Catch: Throwable -> L14
        this.f18012h = r12;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        a(th);
    }

    @Override // rt.h
    public final Object poll() {
    L2:
        Object r5 = this.f17625c.poll();
        if (r5 == null) goto L4;
        Object r10 = this.f.apply(r5);
        if (this.f18013i == false) goto L8;
        Object r11 = this.f18012h;
        ((com.lynx.tasm.utils.c) this.g).getClass();
        if (io.reactivex.internal.functions.e.b(r11, r10) == false) goto L12;
        this.f18012h = r10;
        goto L2
    L12:
        this.f18012h = r10;
        return r5;
    L8:
        this.f18013i = true;
        this.f18012h = r10;
        return r5;
    L4:
        return null;
    }
}
