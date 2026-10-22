package io.reactivex.internal.operators.single;

import mt.a0;
import mt.b0;
import mt.c0;
import mt.n;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f18109a;

    public c(c0 r5) {
        this.f18109a = r5;
    }

    public static b0 d(u r5) {
        return new SingleToObservable$SingleToObservableObserver(r5);
    }

    @Override // mt.n
    public final void subscribeActual(u r5) {
        SingleToObservable$SingleToObservableObserver r10 = new SingleToObservable$SingleToObservableObserver(r5);
        ((a0) this.f18109a).b(r10);
    }
}
