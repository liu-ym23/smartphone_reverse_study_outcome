package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class m8 extends n0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Comparable f9078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RegularContiguousSet f9079c;

    public m8(RegularContiguousSet r5, Comparable r10) {
        this.f9079c = r5;
        super(r10);
        this.f9078b = r5.last();
    }

    @Override // com.google.common.collect.n0
    public final Object a(Object r5) {
        Comparable r10 = (Comparable) r5;
        if (RegularContiguousSet.access$000(r10, this.f9078b) == false) goto L6;
        return null;
    L6:
        return this.f9079c.domain.next(r10);
    }
}
