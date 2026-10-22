package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public class i4 extends p7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0 f9023b;

    public i4(j0 r5) {
        this.f9023b = r5;
    }

    public i4 B0(Object r5) {
        r5.getClass();
        this.f9023b.add(r5);
        return this;
    }

    @Override // com.google.common.collect.p7
    public /* bridge */ /* synthetic */ p7 g(Object r5) {
        return B0(r5);
    }

    public i4() {
        this(LinkedHashMultiset.create());
    }
}
