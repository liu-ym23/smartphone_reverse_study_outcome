package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class ReverseNaturalOrdering extends g8 implements Serializable {
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

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Object r5, Object r10) {
        return compare((Comparable) r5, (Comparable) r10);
    }

    @Override // com.google.common.collect.g8
    public /* bridge */ /* synthetic */ Object max(Iterable r5) {
        return max(r5);
    }

    @Override // com.google.common.collect.g8
    public /* bridge */ /* synthetic */ Object min(Iterable r5) {
        return min(r5);
    }

    @Override // com.google.common.collect.g8
    public <S extends Comparable<?>> g8 reverse() {
        return g8.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    public int compare(Comparable<?> r5, Comparable<?> r10) {
        r5.getClass();
        if (r5 != r10) goto L7;
        return 0;
    L7:
        return r10.compareTo(r5);
    }

    @Override // com.google.common.collect.g8
    public /* bridge */ /* synthetic */ Object max(Object r5, Object r10) {
        return max((Comparable) r5, (Comparable) r10);
    }

    @Override // com.google.common.collect.g8
    public /* bridge */ /* synthetic */ Object min(Object r5, Object r10) {
        return min((Comparable) r5, (Comparable) r10);
    }

    @Override // com.google.common.collect.g8
    public /* bridge */ /* synthetic */ Object max(Object r5, Object r10, Object r11, Object[] r12) {
        return max((Comparable) r5, (Comparable) r10, (Comparable) r11, (Comparable[]) r12);
    }

    @Override // com.google.common.collect.g8
    public /* bridge */ /* synthetic */ Object min(Object r5, Object r10, Object r11, Object[] r12) {
        return min((Comparable) r5, (Comparable) r10, (Comparable) r11, (Comparable[]) r12);
    }

    @Override // com.google.common.collect.g8
    public /* bridge */ /* synthetic */ Object max(Iterator r5) {
        return max(r5);
    }

    @Override // com.google.common.collect.g8
    public /* bridge */ /* synthetic */ Object min(Iterator r5) {
        return min(r5);
    }

    public <E extends Comparable<?>> E max(E r5, E r10) {
        return (E) NaturalOrdering.INSTANCE.min(r5, r10);
    }

    public <E extends Comparable<?>> E min(E r5, E r10) {
        return (E) NaturalOrdering.INSTANCE.max(r5, r10);
    }

    public <E extends Comparable<?>> E max(E r5, E r10, E r11, E... r12) {
        return (E) NaturalOrdering.INSTANCE.min(r5, r10, r11, r12);
    }

    public <E extends Comparable<?>> E min(E r5, E r10, E r11, E... r12) {
        return (E) NaturalOrdering.INSTANCE.max(r5, r10, r11, r12);
    }

    @Override // com.google.common.collect.g8
    public <E extends Comparable<?>> E max(Iterator<E> r5) {
        return (E) NaturalOrdering.INSTANCE.min(r5);
    }

    @Override // com.google.common.collect.g8
    public <E extends Comparable<?>> E min(Iterator<E> r5) {
        return (E) NaturalOrdering.INSTANCE.max(r5);
    }

    @Override // com.google.common.collect.g8
    public <E extends Comparable<?>> E max(Iterable<E> r5) {
        return (E) NaturalOrdering.INSTANCE.min(r5);
    }

    @Override // com.google.common.collect.g8
    public <E extends Comparable<?>> E min(Iterable<E> r5) {
        return (E) NaturalOrdering.INSTANCE.max(r5);
    }
}
