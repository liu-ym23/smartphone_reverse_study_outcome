package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class m2 extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9068c;
    public final int d;
    public final /* synthetic */ DenseImmutableTable.ImmutableArrayMap e;

    public m2(DenseImmutableTable.ImmutableArrayMap r5) {
        this.e = r5;
        this.f9068c = -1;
        this.d = r5.keyToIndex().size();
    }

    @Override // com.google.common.collect.g
    public final Object a() {
        int r5 = this.f9068c;
    L3:
        this.f9068c = r5 + 1;
        int r10 = this.f9068c;
        if (r10 >= this.d) goto L9;
        DenseImmutableTable.ImmutableArrayMap r11 = this.e;
        Object r12 = r11.getValue(r10);
        if (r12 != null) goto L13;
        r5 = this.f9068c;
        goto L3
    L13:
        return new ImmutableEntry(r11.getKey(this.f9068c), r12);
    L9:
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    }
}
