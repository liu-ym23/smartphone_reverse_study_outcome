package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class e6 extends g6 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8955i;

    public /* synthetic */ e6(MapMakerInternalMap r5, int r10) {
        this.f8955i = r10;
        super(r5);
    }

    @Override // com.google.common.collect.g6, java.util.Iterator
    public Object next() {
        switch(this.f8955i) {
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return super.next();
    L7:
        return c().f8894b;
    L9:
        return c().f8893a;
    }
}
