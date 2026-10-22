package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class v9 extends b8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y9 f9199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TreeMultiset f9200b;

    public v9(TreeMultiset r5, y9 r10) {
        this.f9200b = r5;
        this.f9199a = r10;
    }

    @Override // com.google.common.collect.y7
    public final int getCount() {
        y9 r5 = this.f9199a;
        int r10 = r5.f9234b;
        if (r10 != 0) goto L6;
        Object r11 = r5.f9233a;
        return this.f9200b.count(r11);
    L6:
        return r10;
    }

    @Override // com.google.common.collect.y7
    public final Object getElement() {
        return this.f9199a.f9233a;
    }
}
