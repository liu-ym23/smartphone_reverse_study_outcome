package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c3 extends v2 implements SortedMap {
    public c3() {
    }

    public static int unsafeCompare(Comparator<?> r5, Object r10, Object r11) {
        if (r5 != null) goto L6;
        return ((Comparable) r10).compareTo(r11);
    L6:
        return r5.compare(r10, r11);
    }

    @Override // java.util.SortedMap
    public Comparator<Object> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.v2, com.google.common.collect.z2
    public abstract SortedMap delegate();

    @Override // java.util.SortedMap
    public Object firstKey() {
        return delegate().firstKey();
    }

    @Override // java.util.SortedMap
    public Object lastKey() {
        return delegate().lastKey();
    }

    @Override // com.google.common.collect.v2
    public boolean standardContainsKey(Object r5) {
        Object r10 = tailMap(r5).firstKey();     // Catch: Throwable -> L7
        if (unsafeCompare(comparator(), r10, r5) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public SortedMap<Object, Object> standardSubMap(Object r5, Object r10) {
        if (unsafeCompare(comparator(), r5, r10) > 0) goto L5;
        boolean r11 = true;
    L6:
        com.google.common.base.b0.g("fromKey must be <= toKey", r11);
        return tailMap(r5).headMap(r10);
    L5:
        r11 = false;
        goto L6
    }
}
