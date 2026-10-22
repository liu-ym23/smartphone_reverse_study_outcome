package com.google.common.collect;

import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class w1 implements IntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9204b;

    public /* synthetic */ w1(Object r5, int r10) {
        this.f9203a = r10;
        this.f9204b = r5;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int r5) {
        switch(this.f9203a) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L6;
            default: goto L5;
        };
    L6:
        y0 r10 = (y0) this.f9204b;
        com.google.common.base.b0.l(r5, r10.f9227a.size());
        return new w0(r10, r5);
    L5:
        return ((ImmutableList) this.f9204b).get(r5);
    L9:
        return ((IndexedImmutableSet) this.f9204b).get(r5);
    L11:
        return ((ImmutableSortedMap.C1EntrySet.AnonymousClass1) this.f9204b).get(r5);
    L13:
        return ((ImmutableSet.Indexed) this.f9204b).get(r5);
    L15:
        return new x1((CompactHashMap) ((l) this.f9204b).d, r5);
    }
}
