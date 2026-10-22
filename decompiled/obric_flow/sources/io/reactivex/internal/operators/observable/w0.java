package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 extends io.reactivex.internal.observers.a {
    public final /* synthetic */ int f;
    public final Object g;

    public /* synthetic */ w0(mt.u r5, Object r10, int r11) {
        this.f = r11;
        super(r5);
        this.g = r10;
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        switch(this.f) {
            case 0: goto L24;
            case 1: goto L15;
            default: goto L5;
        };
    L15:
        int r10 = this.e;
        mt.u r11 = this.f17623a;
        if (r10 == 0) goto L35;
        r11.onNext(null);
        return;
    L35:
        if (((pt.p) this.g).test(r5) == false) goto L40;
        r11.onNext(r5);
        return;
    L40:
        return;
    L20:
        th = move-exception;
        a(th);
        return;
    L24:
        this.f17623a.onNext(r5);
        if (this.e != 0) goto L43;
        ((pt.g) this.g).accept(r5);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        a(th);
        return;
    L43:
        return;
    L5:
        if (this.d == true) goto L39;
        int r12 = this.e;
        mt.u r13 = this.f17623a;
        if (r12 == 0) goto L31;
        r13.onNext(null);
        return;
    L31:
        Object r14 = ((pt.o) this.g).apply(r5);     // Catch: Throwable -> L12
        io.reactivex.internal.functions.e.d(r14, "The mapper function returned a null value.");     // Catch: Throwable -> L12
        r13.onNext(r14);
        return;
    L12:
        th = move-exception;
        a(th);
        return;
    }

    @Override // rt.h
    public final Object poll() {
        switch(this.f) {
            case 0: goto L14;
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        Object r5 = this.f17625c.poll();
        if (r5 == null) goto L7;
        Object r10 = ((pt.o) this.g).apply(r5);
        io.reactivex.internal.functions.e.d(r10, "The mapper function returned a null value.");
        return r10;
    L7:
        return null;
    L9:
        Object r11 = this.f17625c.poll();
        if (r11 == null) goto L13;
        if (((pt.p) this.g).test(r11) == false) goto L9;
    L13:
        return r11;
    L14:
        Object r12 = this.f17625c.poll();
        if (r12 == null) goto L17;
        ((pt.g) this.g).accept(r12);
    L17:
        return r12;
    }
}
