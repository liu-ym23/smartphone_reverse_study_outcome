package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface l8 {
    void add(Range r5);

    default void addAll(Iterable r5) {
        Iterator r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        add((Range) r10.next());
        goto L4
    }

    Set asRanges();

    l8 complement();

    boolean encloses(Range r5);

    default boolean enclosesAll(Iterable r5) {
        Iterator r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (encloses((Range) r10.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    boolean isEmpty();

    void remove(Range r5);

    void removeAll(l8 r5);

    default void removeAll(Iterable r5) {
        Iterator r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        remove((Range) r10.next());
        goto L4
    }
}
