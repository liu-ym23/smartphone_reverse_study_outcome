package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class r2 extends s2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f9144c;

    public r2(Iterable r5, Iterable r10) {
        this.f9143b = 0;
        this.f9144c = r10;
        super(r5);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch(this.f9143b) {
            case 0: goto L7;
            default: goto L4;
        };
    L4:
        x0 r5 = new x0(((Iterable[]) this.f9144c).length, 1, this);
        h5 r10 = new h5();
        r10.f9013b = g5.d;
        r10.f9014c = r5;
        return r10;
    L7:
        return ((Iterable) this.f9144c).iterator();
    }

    public r2(Iterable[] r5) {
        this.f9143b = 1;
        this.f9144c = r5;
    }
}
