package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class NaturalOrdering extends g8 implements Serializable {
    static final NaturalOrdering INSTANCE = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient g8 f8853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient g8 f8854b;

    static {
        INSTANCE = new NaturalOrdering();
    }

    private NaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Object r5, Object r10) {
        return compare((Comparable) r5, (Comparable) r10);
    }

    @Override // com.google.common.collect.g8
    public <S extends Comparable<?>> g8 nullsFirst() {
        g8 r5 = this.f8853a;
        if (r5 != null) goto L6;
        g8 r10 = super.nullsFirst();
        this.f8853a = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.g8
    public <S extends Comparable<?>> g8 nullsLast() {
        g8 r5 = this.f8854b;
        if (r5 != null) goto L6;
        g8 r10 = super.nullsLast();
        this.f8854b = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.g8
    public <S extends Comparable<?>> g8 reverse() {
        return ReverseNaturalOrdering.INSTANCE;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    public int compare(Comparable<?> r5, Comparable<?> r10) {
        r5.getClass();
        r10.getClass();
        return r5.compareTo(r10);
    }
}
