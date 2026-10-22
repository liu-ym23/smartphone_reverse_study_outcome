package io.reactivex.internal.operators.observable;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.n f17750b;

    public /* synthetic */ d(mt.n r5, int r10) {
        this.f17749a = r10;
        this.f17750b = r5;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch(this.f17749a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        i r5 = new i();
        return new h(this.f17750b, r5);
    L6:
        c r10 = new c();
        mt.n.wrap(this.f17750b).materialize().subscribe(r10);
        return r10;
    }
}
