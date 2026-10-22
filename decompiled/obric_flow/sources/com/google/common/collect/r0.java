package com.google.common.collect;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0 f9139a;

    public r0(s0 r5) {
        this.f9139a = r5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f9139a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object r5) {
        if ((r5 instanceof k9) == false) goto L15;
        k9 r10 = (k9) r5;
        Map r11 = (Map) p7.l0(this.f9139a.rowMap(), r10.getRowKey());
        if (r11 == null) goto L16;
        Set r12 = r11.entrySet();
        ImmutableEntry r13 = new ImmutableEntry(r10.getColumnKey(), r10.getValue());
        r12.getClass();
        boolean r14 = r12.contains(r13);     // Catch: Throwable -> L9
    L10:
        if (r14 == false) goto L17;
        return true;
    L17:
        return false;
    L9:
        r14 = false;
        goto L10
    L16:
        return false;
    L15:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return this.f9139a.cellIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object r5) {
        if ((r5 instanceof k9) == false) goto L15;
        k9 r10 = (k9) r5;
        Map r11 = (Map) p7.l0(this.f9139a.rowMap(), r10.getRowKey());
        if (r11 == null) goto L16;
        Set r12 = r11.entrySet();
        ImmutableEntry r13 = new ImmutableEntry(r10.getColumnKey(), r10.getValue());
        r12.getClass();
        boolean r14 = r12.remove(r13);     // Catch: Throwable -> L9
    L10:
        if (r14 == false) goto L17;
        return true;
    L17:
        return false;
    L9:
        r14 = false;
        goto L10
    L16:
        return false;
    L15:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f9139a.size();
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Spliterator spliterator() {
        return this.f9139a.cellSpliterator();
    }
}
