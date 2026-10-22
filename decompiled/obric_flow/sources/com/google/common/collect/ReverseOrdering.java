package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class ReverseOrdering<T> extends g8 implements Serializable {
    private static final long serialVersionUID = 0;
    final g8 forwardOrder;

    public ReverseOrdering(g8 r5) {
        r5.getClass();
        this.forwardOrder = r5;
    }

    @Override // java.util.Comparator
    public int compare(T r5, T r10) {
        return this.forwardOrder.compare(r10, r5);
    }

    @Override // java.util.Comparator
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ReverseOrdering) == true) goto L8;
        return false;
    L8:
        return this.forwardOrder.equals(((ReverseOrdering) r5).forwardOrder);
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // com.google.common.collect.g8
    public <E extends T> E max(E r5, E r10) {
        return (E) this.forwardOrder.min(r5, r10);
    }

    @Override // com.google.common.collect.g8
    public <E extends T> E min(E r5, E r10) {
        return (E) this.forwardOrder.max(r5, r10);
    }

    @Override // com.google.common.collect.g8
    public <S extends T> g8 reverse() {
        return this.forwardOrder;
    }

    public String toString() {
        String r5 = String.valueOf(this.forwardOrder);
        return androidx.room.jarjarred.org.antlr.runtime.a.l(r5.length() + 10, r5, ".reverse()");
    }

    @Override // com.google.common.collect.g8
    public <E extends T> E max(E r5, E r10, E r11, E... r12) {
        return (E) this.forwardOrder.min(r5, r10, r11, r12);
    }

    @Override // com.google.common.collect.g8
    public <E extends T> E min(E r5, E r10, E r11, E... r12) {
        return (E) this.forwardOrder.max(r5, r10, r11, r12);
    }

    @Override // com.google.common.collect.g8
    public <E extends T> E max(Iterator<E> r5) {
        return (E) this.forwardOrder.min(r5);
    }

    @Override // com.google.common.collect.g8
    public <E extends T> E min(Iterator<E> r5) {
        return (E) this.forwardOrder.max(r5);
    }

    @Override // com.google.common.collect.g8
    public <E extends T> E max(Iterable<E> r5) {
        return (E) this.forwardOrder.min(r5);
    }

    @Override // com.google.common.collect.g8
    public <E extends T> E min(Iterable<E> r5) {
        return (E) this.forwardOrder.max(r5);
    }
}
