package com.bytedance.android.live.core.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class NoNullRepeatList<T> extends CopyOnWriteArrayList<T> {
    public NoNullRepeatList() {
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public boolean add(T r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (contains(r3) == false) goto L9;
        return false;
    L9:
        return super.add(r3);
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> r2) {
        Iterator<? extends T> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        add(r3.next());
        goto L4
    L6:
        return true;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public boolean remove(Object r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return super.remove(r1);
    }
}
