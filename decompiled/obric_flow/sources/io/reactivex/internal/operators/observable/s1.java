package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class s1 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f17954c;
    public final Object d;
    public final Object e;
    public final Object f;

    public /* synthetic */ s1(mt.n r5, Object r10, Object r11, Object r12, Object r13, int r14) {
        this.f17953b = r14;
        super(r5);
        this.f17954c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        switch(this.f17953b) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        pt.a r5 = (pt.a) this.e;
        pt.a r11 = (pt.a) this.f;
        x0 r12 = new x0(r10, (pt.g) this.f17954c, (pt.g) this.d, r5, r11);
        this.f17702a.subscribe(r12);
        return;
    L6:
        pt.o r13 = (pt.o) this.e;
        pt.c r14 = (pt.c) this.f;
        ObservableJoin$JoinDisposable r15 = new ObservableJoin$JoinDisposable(r10, (pt.o) this.d, r13, r14);
        r10.onSubscribe(r15);
        ObservableGroupJoin$LeftRightObserver r16 = new ObservableGroupJoin$LeftRightObserver(r15, true);
        r15.disposables.b(r16);
        ObservableGroupJoin$LeftRightObserver r17 = new ObservableGroupJoin$LeftRightObserver(r15, false);
        r15.disposables.b(r17);
        this.f17702a.subscribe(r16);
        ((mt.s) this.f17954c).subscribe(r17);
        return;
    L8:
        pt.o r18 = (pt.o) this.e;
        pt.c r19 = (pt.c) this.f;
        ObservableGroupJoin$GroupJoinDisposable r20 = new ObservableGroupJoin$GroupJoinDisposable(r10, (pt.o) this.d, r18, r19);
        r10.onSubscribe(r20);
        ObservableGroupJoin$LeftRightObserver r21 = new ObservableGroupJoin$LeftRightObserver(r20, true);
        r20.disposables.b(r21);
        ObservableGroupJoin$LeftRightObserver r22 = new ObservableGroupJoin$LeftRightObserver(r20, false);
        r20.disposables.b(r22);
        this.f17702a.subscribe(r21);
        ((mt.s) this.f17954c).subscribe(r22);
    }
}
