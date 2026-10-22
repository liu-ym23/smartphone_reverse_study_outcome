package com.google.common.collect;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
abstract class ImmutableSortedMultisetFauxverideShim<E> extends ImmutableMultiset<E> {
    public ImmutableSortedMultisetFauxverideShim() {
    }

    @Deprecated
    public static <E> w4 builder() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> copyOf(E[] r5) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E r5) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> Collector<E, ?, ImmutableMultiset<E>> toImmutableMultiset() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public abstract /* synthetic */ int count(Object r5);

    @Override // com.google.common.collect.ImmutableMultiset, java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEach(Consumer r5) {
        super.forEach(r5);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer r5) {
        super.forEachEntry(r5);
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E r5, E r10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <T, E> Collector<T, ?, ImmutableMultiset<E>> toImmutableMultiset(Function<? super T, ? extends E> r5, ToIntFunction<? super T> r10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E r5, E r10, E r11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E r5, E r10, E r11, E r12) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E r5, E r10, E r11, E r12, E r13) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E r5, E r10, E r11, E r12, E r13, E r14, E... r15) {
        throw new UnsupportedOperationException();
    }
}
