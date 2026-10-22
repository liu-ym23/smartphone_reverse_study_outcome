package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class n8 extends n0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Comparable f9092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RegularContiguousSet f9093c;

    public n8(RegularContiguousSet r5, Comparable r10) {
        this.f9093c = r5;
        super(r10);
        this.f9092b = r5.first();
    }

    @Override // com.google.common.collect.n0
    public final Object a(Object r5) {
        Comparable r10 = (Comparable) r5;
        if (RegularContiguousSet.access$000(r10, this.f9092b) == false) goto L6;
        return null;
    L6:
        return this.f9093c.domain.previous(r10);
    }
}
