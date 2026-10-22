package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f17667c;

    public /* synthetic */ o(i r5, int r10) {
        this.f17667c = r10;
        super(r5);
    }

    @Override // mt.e
    public final void b(mt.g r5) {
        switch(this.f17667c) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        FlowableOnBackpressureLatest$BackpressureLatestSubscriber r10 = new FlowableOnBackpressureLatest$BackpressureLatestSubscriber(r5);
        this.f17654b.a(r10);
        return;
    L6:
        FlowableOnBackpressureError$BackpressureErrorSubscriber r11 = new FlowableOnBackpressureError$BackpressureErrorSubscriber(r5);
        this.f17654b.a(r11);
    }
}
