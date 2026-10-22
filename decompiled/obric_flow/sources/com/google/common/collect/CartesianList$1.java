package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
class CartesianList$1 extends ImmutableList<Object> {
    final /* synthetic */ d1 this$0;
    final /* synthetic */ int val$index;

    public CartesianList$1(d1 r5, int r10) {
        this.val$index = r10;
    }

    @Override // java.util.List
    public Object get(int r5) {
        com.google.common.base.b0.l(r5, size());
        d1.b();
        throw null;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        int r5 = d1.f8933a;
        throw null;
    }
}
