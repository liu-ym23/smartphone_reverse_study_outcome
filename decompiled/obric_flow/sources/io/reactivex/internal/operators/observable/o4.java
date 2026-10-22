package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class o4 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17899c;
    public final Object d;

    public /* synthetic */ o4(mt.n r5, Object r10, int r11, int r12) {
        this.f17898b = r12;
        super(r5);
        this.d = r10;
        this.f17899c = r11;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        switch(this.f17898b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ObservableWindowBoundarySupplier$WindowBoundaryMainObserver r10 = new ObservableWindowBoundarySupplier$WindowBoundaryMainObserver(r5, this.f17899c, (Callable) this.d);
        this.f17702a.subscribe(r10);
        return;
    L6:
        ObservableWindowBoundary$WindowBoundaryMainObserver r11 = new ObservableWindowBoundary$WindowBoundaryMainObserver(r5, this.f17899c);
        r5.onSubscribe(r11);
        ((mt.s) this.d).subscribe(r11.boundaryObserver);
        this.f17702a.subscribe(r11);
    }
}
