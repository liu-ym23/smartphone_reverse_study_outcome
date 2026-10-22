package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends a implements pt.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f17666c;

    public n(i r5) {
        super(r5);
        this.f17666c = this;
    }

    @Override // pt.g
    public final void accept(Object r5) {
    }

    @Override // mt.e
    public final void b(mt.g r5) {
        FlowableOnBackpressureDrop$BackpressureDropSubscriber r10 = new FlowableOnBackpressureDrop$BackpressureDropSubscriber(r5, this.f17666c);
        this.f17654b.a(r10);
    }
}
