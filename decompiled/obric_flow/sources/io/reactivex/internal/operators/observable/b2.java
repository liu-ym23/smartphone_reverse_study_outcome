package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public final class b2 implements pt.c, pt.g, pt.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f17729b;

    public /* synthetic */ b2(Object r5, int r10) {
        this.f17728a = r10;
        this.f17729b = r5;
    }

    @Override // pt.g
    public void accept(Object r5) {
        ObserverResourceWrapper r10 = (ObserverResourceWrapper) this.f17729b;
        r10.setResource((Disposable) r5);
    }

    @Override // pt.c
    public Object apply(Object r5, Object r10) {
        switch(this.f17728a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        pt.g r11 = (pt.g) this.f17729b;
        r11.accept((mt.d) r10);
        return r5;
    L6:
        pt.b r12 = (pt.b) this.f17729b;
        r12.accept(r5, (mt.d) r10);
        return r5;
    }

    @Override // pt.o
    public Object apply(Object r5) {
        Object r10 = ((r) this.f17729b).d.apply(new Object[]{r5});
        io.reactivex.internal.functions.e.d(r10, "The combiner returned a null value");
        return r10;
    }
}
