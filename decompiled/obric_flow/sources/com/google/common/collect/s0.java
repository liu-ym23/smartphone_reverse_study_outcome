package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s0 implements l9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Set f9150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient Collection f9151b;

    public s0() {
    }

    public abstract Iterator cellIterator();

    public abstract Spliterator cellSpliterator();

    public Set<k9> createCellSet() {
        return new r0(this);
    }

    public Collection<Object> createValues() {
        return new q6(this, 2);
    }

    @Override // com.google.common.collect.l9
    public boolean equals(Object r5) {
        if (r5 != this) goto L5;
        return true;
    L5:
        if ((r5 instanceof l9) == true) goto L10;
        return false;
    L10:
        return cellSet().equals(((l9) r5).cellSet());
    }

    @Override // com.google.common.collect.l9
    public int hashCode() {
        return cellSet().hashCode();
    }

    @Override // com.google.common.collect.l9
    public void putAll(l9 r5) {
        Iterator r10 = r5.cellSet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        k9 r11 = (k9) r10.next();
        put(r11.getRowKey(), r11.getColumnKey(), r11.getValue());
        goto L4
    }

    public String toString() {
        return rowMap().toString();
    }

    public Iterator<Object> valuesIterator() {
        return new q0(cellSet().iterator(), 0);
    }

    public Spliterator<Object> valuesSpliterator() {
        return p7.R(cellSpliterator(), new h(2));
    }
}
