package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class NaturalOrdering extends Ordering<Comparable<?>> implements Serializable {
    static final NaturalOrdering INSTANCE = null;
    private static final long serialVersionUID = 0;
    private transient Ordering<Comparable<?>> nullsFirst;
    private transient Ordering<Comparable<?>> nullsLast;

    static {
        INSTANCE = new NaturalOrdering();
    }

    private NaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public int compare(Comparable<?> r2, Comparable<?> r3) {
        Comparable r1 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r1);
        com.google.common.base.n.a(r4);
        return r1.compareTo(r4);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public /* synthetic */ int compare(Object r3, Object r4) {
        return compare((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable<?>> Ordering<S> nullsFirst() {
        Ordering<S> r0 = (Ordering<S>) this.nullsFirst;
        if (r0 != null) goto L6;
        Ordering<S> r1 = super.nullsFirst();
        this.nullsFirst = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable<?>> Ordering<S> nullsLast() {
        Ordering<S> r0 = (Ordering<S>) this.nullsLast;
        if (r0 != null) goto L6;
        Ordering<S> r1 = super.nullsLast();
        this.nullsLast = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable<?>> Ordering<S> reverse() {
        return ReverseNaturalOrdering.INSTANCE;
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
