package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class g1 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f17789c;
    public final boolean d;

    public /* synthetic */ g1(mt.n r5, Object r10, boolean r11, int r12) {
        this.f17788b = r12;
        super(r5);
        this.f17789c = r10;
        this.d = r11;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        switch(this.f17788b) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            default: goto L4;
        };
    L4:
        final io.reactivex.observers.d r10 = new io.reactivex.observers.d(r5);
        boolean r11 = this.d;
        final mt.s r12 = (mt.s) this.f17789c;
        mt.s r13 = this.f17702a;
        if (r11 == false) goto L7;
        r13.subscribe(new ObservableSampleWithObservable$SampleMainEmitLast(r10, r12));
        return;
    L7:
        r13.subscribe(new ObservableSampleWithObservable$SampleMainNoLast(r10, r12));
        return;
    L9:
        p2 r14 = new p2(r5, (pt.o) this.f17789c, this.d);
        r5.onSubscribe(r14.d);
        this.f17702a.subscribe(r14);
        return;
    L11:
        ObservableFlatMapSingle$FlatMapSingleObserver r15 = new ObservableFlatMapSingle$FlatMapSingleObserver(r5, (pt.o) this.f17789c, this.d);
        this.f17702a.subscribe(r15);
        return;
    L13:
        ObservableFlatMapMaybe$FlatMapMaybeObserver r16 = new ObservableFlatMapMaybe$FlatMapMaybeObserver(r5, (pt.o) this.f17789c, this.d);
        this.f17702a.subscribe(r16);
        return;
    L15:
        ObservableFlatMapCompletable$FlatMapCompletableMainObserver r17 = new ObservableFlatMapCompletable$FlatMapCompletableMainObserver(r5, (pt.o) this.f17789c, this.d);
        this.f17702a.subscribe(r17);
    }
}
