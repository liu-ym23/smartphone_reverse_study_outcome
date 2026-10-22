package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final class CompoundOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<? super T>[] comparators;

    CompoundOrdering(Iterable<? extends Comparator<? super T>> r3) {
        this.comparators = (Comparator[]) ZeusTransformUtils.preCheckCast(aj.a((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"), new Comparator[0]), Comparator[].class, "com.obric.memorydata.plugin");
    }

    CompoundOrdering(Comparator<? super T> r3, Comparator<? super T> r4) {
        this.comparators = new Comparator[]{(Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin")};
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T r5, T r6) {
        int r1 = 0;
    L3:
        Comparator<? super T>[] r2 = this.comparators;
        if (r1 >= r2.length) goto L9;
        int r3 = r2[r1].compare(r5, r6);
        if (r3 != 0) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return r3;
    L9:
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, CompoundOrdering.class) == false) goto L10;
        CompoundOrdering r4 = (CompoundOrdering) ZeusTransformUtils.preCheckCast(r3, CompoundOrdering.class, "com.obric.memorydata.plugin");
        return Arrays.equals(this.comparators, r4.comparators);
    L10:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.comparators);
    }

    public String toString() {
        return "Ordering.compound(" + Arrays.toString(this.comparators) + ")";
    }
}
