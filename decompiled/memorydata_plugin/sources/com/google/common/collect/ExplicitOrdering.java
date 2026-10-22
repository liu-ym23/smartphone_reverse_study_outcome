package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<T, Integer> rankMap;

    ExplicitOrdering(ImmutableMap<T, Integer> r1) {
        this.rankMap = r1;
    }

    ExplicitOrdering(List<T> r3) {
        this(Maps.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")));
    }

    private int rank(T r3) {
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(this.rankMap.get(r3), Integer.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        return r2.intValue();
    L7:
        throw new Ordering.IncomparableValueException(r3);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T r1, T r2) {
        return rank(r1) - rank(r2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, ExplicitOrdering.class) == false) goto L6;
        ExplicitOrdering r4 = (ExplicitOrdering) ZeusTransformUtils.preCheckCast(r3, ExplicitOrdering.class, "com.obric.memorydata.plugin");
        return this.rankMap.equals(r4.rankMap);
    L6:
        return false;
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.rankMap.keySet() + ")";
    }
}
