package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17664c;
    public final boolean d;
    public final io.reactivex.internal.functions.b e;

    public l(i r5, int r10) {
        io.reactivex.internal.functions.b r11 = io.reactivex.internal.functions.e.f17619c;
        super(r5);
        this.f17664c = r10;
        this.d = true;
        this.e = r11;
    }

    @Override // mt.e
    public final void b(mt.g r10) {
        FlowableOnBackpressureBuffer$BackpressureBufferSubscriber r11 = new FlowableOnBackpressureBuffer$BackpressureBufferSubscriber(r10, this.f17664c, this.d, false, this.e);
        this.f17654b.a(r11);
    }
}
