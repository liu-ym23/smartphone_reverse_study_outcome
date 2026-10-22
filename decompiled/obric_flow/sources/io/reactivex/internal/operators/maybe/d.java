package io.reactivex.internal.operators.maybe;

import mt.g;
import mt.h;
import mt.k;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends mt.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f17680b;

    public d(k r5) {
        this.f17680b = r5;
    }

    @Override // mt.e
    public final void b(g r5) {
        MaybeToFlowable$MaybeToFlowableSubscriber r10 = new MaybeToFlowable$MaybeToFlowableSubscriber(r5);
        ((h) this.f17680b).b(r10);
    }
}
