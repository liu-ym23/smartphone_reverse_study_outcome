package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class q2 extends b8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p2 f9130b;

    public q2(p2 r5, int r10) {
        this.f9130b = r5;
        this.f9129a = r10;
    }

    @Override // com.google.common.collect.y7
    public final int getCount() {
        return EnumMultiset.access$100(this.f9130b.e)[this.f9129a];
    }

    @Override // com.google.common.collect.y7
    public final Object getElement() {
        return EnumMultiset.access$000(this.f9130b.e)[this.f9129a];
    }
}
