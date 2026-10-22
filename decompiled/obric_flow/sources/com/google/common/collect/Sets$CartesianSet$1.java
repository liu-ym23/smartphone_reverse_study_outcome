package com.google.common.collect;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class Sets$CartesianSet$1 extends ImmutableList<List<Object>> {
    final /* synthetic */ ImmutableList val$axes;

    public Sets$CartesianSet$1(ImmutableList r5) {
        this.val$axes = r5;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object get(int r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.val$axes.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    public List<Object> get(int r5) {
        return ((ImmutableSet) this.val$axes.get(r5)).asList();
    }
}
