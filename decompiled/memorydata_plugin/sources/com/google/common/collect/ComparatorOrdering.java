package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final class ComparatorOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<T> comparator;

    ComparatorOrdering(Comparator<T> r3) {
        this.comparator = (Comparator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T r1, T r2) {
        return this.comparator.compare(r1, r2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ComparatorOrdering.class) == false) goto L10;
        ComparatorOrdering r4 = (ComparatorOrdering) ZeusTransformUtils.preCheckCast(r3, ComparatorOrdering.class, "com.obric.memorydata.plugin");
        return this.comparator.equals(r4.comparator);
    L10:
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }
}
