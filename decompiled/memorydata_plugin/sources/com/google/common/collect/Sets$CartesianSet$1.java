package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes2.dex */
class Sets$CartesianSet$1<E> extends ImmutableList<List<E>> {
    final /* synthetic */ ImmutableList val$axes;

    Sets$CartesianSet$1(ImmutableList r1) {
        this.val$axes = r1;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    @Override // java.util.List
    public List<E> get(int r2) {
        return ((ImmutableSet) ZeusTransformUtils.preCheckCast(this.val$axes.get(r2), ImmutableSet.class, "com.obric.memorydata.plugin")).asList();
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.val$axes.size();
    }
}
