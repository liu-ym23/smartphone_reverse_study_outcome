package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class u3 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17988c;

    public /* synthetic */ u3(mt.n r5, int r10, int r11) {
        this.f17987b = r11;
        super(r5);
        this.f17988c = r10;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        switch(this.f17987b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ObservableTakeLast$TakeLastObserver r10 = new ObservableTakeLast$TakeLastObserver(r5, this.f17988c);
        this.f17702a.subscribe(r10);
        return;
    L6:
        ObservableSkipLast$SkipLastObserver r11 = new ObservableSkipLast$SkipLastObserver(r5, this.f17988c);
        this.f17702a.subscribe(r11);
    }
}
