package com.google.common.collect;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Comparator f9053b;

    public /* synthetic */ k1(Comparator r5, int r10) {
        this.f9052a = r10;
        this.f9053b = r5;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        Comparator r5 = this.f9053b;
        switch(this.f9052a) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            default: goto L4;
        };
    L4:
        int r10 = ImmutableSortedMultiset.e;
        return TreeMultiset.create(r5);
    L7:
        return new v4(r5);
    L9:
        return new y4(r5);
    L11:
        return new TreeMap(r5);
    }
}
