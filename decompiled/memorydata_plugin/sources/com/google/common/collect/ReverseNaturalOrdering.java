package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class ReverseNaturalOrdering extends Ordering<Comparable<?>> implements Serializable {
    static final ReverseNaturalOrdering INSTANCE = null;
    private static final long serialVersionUID = 0;

    static {
        INSTANCE = new ReverseNaturalOrdering();
    }

    private ReverseNaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public int compare(Comparable<?> r2, Comparable<?> r3) {
        Comparable r1 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r1);
        if (r1 != r4) goto L7;
        return 0;
    L7:
        return r4.compareTo(r1);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public /* synthetic */ int compare(Object r3, Object r4) {
        return compare((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public <E extends Comparable<?>> E max(E r2, E r3) {
        Comparable r1 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        return (E) ZeusTransformUtils.preCheckCast(NaturalOrdering.INSTANCE.min(r1, r4), Comparable.class, "com.obric.memorydata.plugin");
    }

    public <E extends Comparable<?>> E max(E r2, E r3, E r4, E... r5) {
        Comparable r1 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        return (E) ZeusTransformUtils.preCheckCast(NaturalOrdering.INSTANCE.min(r1, r6, r7, r5), Comparable.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable<?>> E max(Iterable<E> r2) {
        Iterable r1 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        return (E) ZeusTransformUtils.preCheckCast(NaturalOrdering.INSTANCE.min(r1), Comparable.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable<?>> E max(Iterator<E> r2) {
        Iterator r1 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        return (E) ZeusTransformUtils.preCheckCast(NaturalOrdering.INSTANCE.min(r1), Comparable.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.Ordering
    public /* synthetic */ Object max(Iterable r3) {
        return max((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.Ordering
    public /* synthetic */ Object max(Object r3, Object r4) {
        return max((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.Ordering
    public /* synthetic */ Object max(Object r3, Object r4, Object r5, Object[] r6) {
        return max((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"), (Comparable[]) ZeusTransformUtils.preCheckCast(r6, Comparable[].class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.Ordering
    public /* synthetic */ Object max(Iterator r3) {
        return max((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
    }

    public <E extends Comparable<?>> E min(E r2, E r3) {
        Comparable r1 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        return (E) ZeusTransformUtils.preCheckCast(NaturalOrdering.INSTANCE.max(r1, r4), Comparable.class, "com.obric.memorydata.plugin");
    }

    public <E extends Comparable<?>> E min(E r2, E r3, E r4, E... r5) {
        Comparable r1 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        return (E) ZeusTransformUtils.preCheckCast(NaturalOrdering.INSTANCE.max(r1, r6, r7, r5), Comparable.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable<?>> E min(Iterable<E> r2) {
        Iterable r1 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        return (E) ZeusTransformUtils.preCheckCast(NaturalOrdering.INSTANCE.max(r1), Comparable.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable<?>> E min(Iterator<E> r2) {
        Iterator r1 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        return (E) ZeusTransformUtils.preCheckCast(NaturalOrdering.INSTANCE.max(r1), Comparable.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.Ordering
    public /* synthetic */ Object min(Iterable r3) {
        return min((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.Ordering
    public /* synthetic */ Object min(Object r3, Object r4) {
        return min((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.Ordering
    public /* synthetic */ Object min(Object r3, Object r4, Object r5, Object[] r6) {
        return min((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"), (Comparable[]) ZeusTransformUtils.preCheckCast(r6, Comparable[].class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.Ordering
    public /* synthetic */ Object min(Iterator r3) {
        return min((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable<?>> Ordering<S> reverse() {
        return Ordering.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
