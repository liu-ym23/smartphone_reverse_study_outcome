package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends ot.a {
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FlowableGroupBy$State f17663c;

    public j(Object r5, FlowableGroupBy$State r10) {
        super(r5);
        this.f17663c = r10;
    }

    @Override // mt.e
    public final void b(mt.g r5) {
        this.f17663c.subscribe(r5);
    }
}
