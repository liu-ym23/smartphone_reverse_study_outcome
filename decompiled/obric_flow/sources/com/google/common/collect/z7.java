package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public interface z7 extends Collection {
    int add(Object r5, int r10);

    int count(Object r5);

    Set elementSet();

    Set entrySet();

    @Override // com.google.common.collect.z7
    boolean equals(Object r5);

    default void forEach(Consumer r5) {
        r5.getClass();
        entrySet().forEach(new t7(r5, 1));
    }

    default void forEachEntry(ObjIntConsumer r5) {
        r5.getClass();
        entrySet().forEach(new m1(r5, 2));
    }

    @Override // com.google.common.collect.z7
    int hashCode();

    int remove(Object r5, int r10);

    int setCount(Object r5, int r10);

    boolean setCount(Object r5, int r10, int r11);

    @Override // java.lang.Iterable, com.google.common.collect.z7
    default Spliterator spliterator() {
        Spliterator r5 = entrySet().spliterator();
        return p7.D(r5, new h(22), (r5.characteristics() & 1296) | 64, size());
    }
}
