package com.google.common.collect;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class z4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f9244a;

    public z4() {
        this.f9244a = new ArrayList();
    }

    public final ImmutableTable a() {
        ArrayList r5 = this.f9244a;
        int r10 = r5.size();
        if (r10 == 0) goto L9;
        if (r10 == 1) goto L11;
        return RegularImmutableTable.forCells(r5, null, null);
    L11:
        return new SingletonImmutableTable((k9) p7.H(r5));
    L9:
        return ImmutableTable.of();
    }
}
