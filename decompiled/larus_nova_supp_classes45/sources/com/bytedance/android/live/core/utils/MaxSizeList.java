package com.bytedance.android.live.core.utils;

import java.util.Collection;
import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class MaxSizeList<T> extends LinkedList<T> {
    private final int max;

    public MaxSizeList(int r1) {
        this.max = r1;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(T r3) {
        boolean r4 = super.add(r3);
    L4:
        if (size() <= this.max) goto L6;
        removeFirst();
        goto L4
    L6:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public boolean addAll(int r2, Collection<? extends T> r3) {
        boolean r4 = super.addAll(r2, r3);
    L4:
        if (size() <= this.max) goto L6;
        removeFirst();
        goto L4
    L6:
        return r4;
    }
}
