package io.reactivex.internal.operators.single;

import mt.a0;
import mt.c0;
import mt.e;
import mt.g;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f18108b;

    public b(c0 r5) {
        this.f18108b = r5;
    }

    @Override // mt.e
    public final void b(g r5) {
        SingleToFlowable$SingleToFlowableObserver r10 = new SingleToFlowable$SingleToFlowableObserver(r5);
        ((a0) this.f18108b).b(r10);
    }
}
