package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class LexicographicalOrdering<T> extends Ordering<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<? super T> elementOrder;

    LexicographicalOrdering(Comparator<? super T> r3) {
        this.elementOrder = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
    }

    public int compare(Iterable<T> r4, Iterable<T> r5) {
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin");
        Iterator<T> r8 = r6.iterator();
        Iterator<T> r9 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L13;
        if (r9.hasNext() == false) goto L7;
        int r0 = this.elementOrder.compare(r8.next(), r9.next());
        if (r0 == 0) goto L4;
        return r0;
    L7:
        return 1;
    L13:
        if (r9.hasNext() == false) goto L16;
        return -1;
    L16:
        return 0;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public /* synthetic */ int compare(Object r3, Object r4) {
        return compare((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.Comparator
    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, LexicographicalOrdering.class) == false) goto L10;
        LexicographicalOrdering r4 = (LexicographicalOrdering) ZeusTransformUtils.preCheckCast(r3, LexicographicalOrdering.class, "com.obric.memorydata.plugin");
        return this.elementOrder.equals(r4.elementOrder);
    L10:
        return false;
    }

    public int hashCode() {
        return this.elementOrder.hashCode() ^ 2075626741;
    }

    public String toString() {
        return this.elementOrder + ".lexicographical()";
    }
}
