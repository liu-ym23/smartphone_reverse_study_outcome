package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class a4 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mt.z f17713c;

    public /* synthetic */ a4(mt.n r5, mt.z r10, int r11) {
        this.f17712b = r11;
        super(r5);
        this.f17713c = r10;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        switch(this.f17712b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ObservableUnsubscribeOn$UnsubscribeObserver r10 = new ObservableUnsubscribeOn$UnsubscribeObserver(r5, this.f17713c);
        this.f17702a.subscribe(r10);
        return;
    L6:
        ObservableSubscribeOn$SubscribeOnObserver r11 = new ObservableSubscribeOn$SubscribeOnObserver(r5);
        r5.onSubscribe(r11);
        z3 r12 = new z3(0, this, r11);
        r11.setDisposable(this.f17713c.c(r12));
    }
}
