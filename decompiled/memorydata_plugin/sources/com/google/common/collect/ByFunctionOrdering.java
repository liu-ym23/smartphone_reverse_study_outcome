package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final com.google.common.base.g<F, ? extends T> function;
    final Ordering<T> ordering;

    ByFunctionOrdering(com.google.common.base.g<F, ? extends T> r3, Ordering<T> r4) {
        this.function = (com.google.common.base.g) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.g.class, "com.obric.memorydata.plugin")), com.google.common.base.g.class, "com.obric.memorydata.plugin");
        this.ordering = (Ordering) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r4), Ordering.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(F r3, F r4) {
        return this.ordering.compare(this.function.apply(r3), this.function.apply(r4));
    }

    @Override // java.util.Comparator
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ByFunctionOrdering.class) == false) goto L14;
        ByFunctionOrdering r6 = (ByFunctionOrdering) ZeusTransformUtils.preCheckCast(r5, ByFunctionOrdering.class, "com.obric.memorydata.plugin");
        if (this.function.equals(r6.function) == false) goto L13;
        if (this.ordering.equals(r6.ordering) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return com.google.common.base.k.a(new Object[]{this.function, this.ordering});
    }

    public String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }
}
