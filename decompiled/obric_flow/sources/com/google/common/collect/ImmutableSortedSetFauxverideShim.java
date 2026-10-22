package com.google.common.collect;

import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
abstract class ImmutableSortedSetFauxverideShim<E> extends ImmutableSet.CachingAsList<E> {
    public ImmutableSortedSetFauxverideShim() {
    }

    @Deprecated
    public static <E> y4 builder() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> y4 builderWithExpectedSize(int r5) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> copyOf(E[] r5) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E r5) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> Collector<E, ?, ImmutableSet<E>> toImmutableSet() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E r5, E r10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E r5, E r10, E r11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E r5, E r10, E r11, E r12) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E r5, E r10, E r11, E r12, E r13) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E r5, E r10, E r11, E r12, E r13, E r14, E... r15) {
        throw new UnsupportedOperationException();
    }
}
