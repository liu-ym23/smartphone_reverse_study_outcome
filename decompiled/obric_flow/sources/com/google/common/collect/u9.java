package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes2.dex */
public final class u9 extends g9 implements SortedMap {
    public final Object d;
    public final Object e;
    public transient SortedMap f;
    public final /* synthetic */ TreeBasedTable g;

    public u9(TreeBasedTable r5, Object r10, Object r11, Object r12) {
        this.g = r5;
        super(r5, r10);
        this.d = r11;
        this.e = r12;
        if (r11 == null) goto L9;
        if (r12 == null) goto L9;
        if (r5.columnComparator().compare(r11, r12) <= 0) goto L9;
        boolean r13 = false;
    L10:
        com.google.common.base.b0.i(r13);
        return;
    L9:
        r13 = true;
        goto L10
    }

    @Override // com.google.common.collect.g9
    public final Map a() {
        e();
        SortedMap r5 = this.f;
        if (r5 == null) goto L10;
        Object r10 = this.d;
        if (r10 == null) goto L7;
        r5 = r5.tailMap(r10);
    L7:
        Object r11 = this.e;
        if (r11 != null) goto L13;
        return r5;
    L13:
        return r5.headMap(r11);
    L10:
        return null;
    }

    @Override // com.google.common.collect.g9
    public final void b() {
        e();
        SortedMap r5 = this.f;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == false) goto L9;
        this.g.backingMap.remove(this.f8997a);
        this.f = null;
        this.f8998b = null;
        return;
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return this.g.columnComparator();
    }

    @Override // com.google.common.collect.g9, java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object r5) {
        if (d(r5) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.containsKey(r5) == false) goto L7;
        return true;
    }

    public final boolean d(Object r5) {
        if (r5 == null) goto L12;
        TreeBasedTable r10 = this.g;
        Object r11 = this.d;
        if (r11 != null) goto L6;
    L7:
        Object r12 = this.e;
        if (r12 != null) goto L10;
    L11:
        return true;
    L10:
        if (r10.columnComparator().compare(r12, r5) <= 0) goto L12;
    L6:
        if (r10.columnComparator().compare(r11, r5) <= 0) goto L7;
    L12:
        return false;
    }

    public final void e() {
        SortedMap r5 = this.f;
        Object r10 = this.f8997a;
        TreeBasedTable r11 = this.g;
        if (r5 != null) goto L5;
    L8:
        this.f = (SortedMap) r11.backingMap.get(r10);
        return;
    L5:
        if (r5.isEmpty() == true) goto L7;
        return;
    L7:
        if (r11.backingMap.containsKey(r10) == true) goto L8;
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        c();
        Map r5 = this.f8998b;
        if (r5 == null) goto L7;
        return ((SortedMap) r5).firstKey();
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedMap
    public final SortedMap headMap(Object r5) {
        r5.getClass();
        com.google.common.base.b0.i(d(r5));
        Object r10 = this.f8997a;
        Object r11 = this.d;
        return new u9(this.g, r10, r11, r5);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public final Set keySet() {
        return new j7(this);
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        c();
        Map r5 = this.f8998b;
        if (r5 == null) goto L7;
        return ((SortedMap) r5).lastKey();
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.g9, java.util.AbstractMap, java.util.Map
    public final Object put(Object r5, Object r10) {
        r5.getClass();
        com.google.common.base.b0.i(d(r5));
        return super.put(r5, r10);
    }

    @Override // java.util.SortedMap
    public final SortedMap subMap(Object r5, Object r10) {
        r5.getClass();
        if (d(r5) == false) goto L7;
        r10.getClass();
        if (d(r10) == false) goto L7;
        boolean r11 = true;
    L8:
        com.google.common.base.b0.i(r11);
        return new u9(this.g, this.f8997a, r5, r10);
    L7:
        r11 = false;
        goto L8
    }

    @Override // java.util.SortedMap
    public final SortedMap tailMap(Object r5) {
        r5.getClass();
        com.google.common.base.b0.i(d(r5));
        Object r10 = this.f8997a;
        Object r11 = this.e;
        return new u9(this.g, r10, r5, r11);
    }
}
