package com.google.common.collect;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements s8 {
    private static final long serialVersionUID = 0;
    public final transient ImmutableSet f;
    public transient ImmutableSetMultimap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient ImmutableSet f8839h;

    public static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final transient ImmutableSetMultimap f8840b;

        public EntrySet(ImmutableSetMultimap<K, V> r5) {
            this.f8840b = r5;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r5) {
            if ((r5 instanceof Map.Entry) == false) goto L6;
            Map.Entry r10 = (Map.Entry) r5;
            Object r11 = r10.getKey();
            Object r12 = r10.getValue();
            return this.f8840b.containsEntry(r11, r12);
        L6:
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f8840b.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public ga iterator() {
            return this.f8840b.entryIterator();
        }
    }

    public ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> r5, int r10, Comparator<? super V> r11) {
        super(r5, r10);
        if (r11 != null) goto L5;
        ImmutableSet r12 = ImmutableSet.of();
    L6:
        this.f = r12;
        return;
    L5:
        r12 = ImmutableSortedSet.emptySet(r11);
        goto L6
    }

    public static <K, V> s4 builder() {
        return new s4();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r5) {
        s4 r10 = new s4();
        Iterator<? extends Map.Entry<? extends K, ? extends V>> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        r10.d(r11.next());
        goto L4
    L7:
        return r10.e();
    }

    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> flatteningToImmutableSetMultimap(Function<? super T, ? extends K> r5, Function<? super T, ? extends Stream<? extends V>> r10) {
        Collector r11 = n1.f9084a;
        r5.getClass();
        r10.getClass();
        h1 r12 = new h1(r5, 2);
        h1 r13 = new h1(r10, 3);
        p7.q(8, "expectedKeys");
        r7 r14 = new r7();
        p7.q(2, "expectedValuesPerKey");
        return Collectors.collectingAndThen(Collector.of(new i1(new s7(r14), 1), new g1(r12, r13, 4), new e1(10), new Collector.Characteristics[0]), new h(9));
    }

    public static <K, V> ImmutableSetMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> r10, Comparator<? super V> r11) {
        if (r10.isEmpty() == true) goto L5;
        Map.Entry[] r5 = new Map.Entry[r10.size()];
        Iterator<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> r12 = r10.iterator();
        int r13 = 0;
        int r14 = 0;
    L8:
        if (r12.hasNext() == false) goto L20;
        Map.Entry<? extends K, ? extends Collection<? extends V>> r15 = r12.next();
        K r16 = r15.getKey();
        Collection<? extends V> r17 = r15.getValue();
        if (r11 != null) goto L12;
        AbstractCollection r18 = ImmutableSet.copyOf(r17);
    L14:
        if (r18.isEmpty() == true) goto L8;
        int r19 = r14 + 1;
        if (r19 <= r5.length) goto L18;
        r5 = (Map.Entry[]) Arrays.copyOf(r5, p7.B(r5.length, r19));
    L18:
        r5[r14] = ImmutableMap.entryOf(r16, r18);
        r13 = r13 + r18.size();
        r14 = r14 + 1;
        goto L8
    L12:
        r18 = ImmutableSortedSet.copyOf(r11, r17);
        goto L14
    L20:
        if (r14 != 0) goto L22;
        ImmutableMap r20 = ImmutableMap.of();
    L27:
        return new ImmutableSetMultimap(r20, r13, r11);
    L22:
        if (r14 == 1) goto L24;
        r20 = RegularImmutableMap.fromEntryArray(r14, r5, true);
        goto L27
    L24:
        Map.Entry r21 = r5[0];
        Objects.requireNonNull(r21);
        r20 = ImmutableMap.of(r21.getKey(), r21.getValue());
        goto L27
    L5:
        return of();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    private void readObject(ObjectInputStream r12) throws IOException, ClassNotFoundException {
        r12.defaultReadObject();
        Comparator r5 = (Comparator) r12.readObject();
        int r10 = r12.readInt();
        if (r10 < 0) goto L37;
        x3 r11 = ImmutableMap.builder();
        int r13 = 0;
        int r14 = 0;
    L5:
        if (r13 >= r10) goto L38;
        Object r15 = r12.readObject();
        int r16 = r12.readInt();
        if (r16 <= 0) goto L20;
        if (r5 != null) goto L10;
        n4 r17 = new n4(0);
    L11:
        int r18 = 0;
    L12:
        if (r18 >= r16) goto L14;
        r17.B0(r12.readObject());
        r18 = r18 + 1;
        goto L12
    L14:
        ImmutableSet r19 = r17.C0();
        if (r19.size() != r16) goto L17;
        r11.g(r15, r19);
        r14 = r14 + r16;
        r13 = r13 + 1;
        goto L5
    L17:
        String r110 = String.valueOf(r15);
        throw new InvalidObjectException(androidx.room.jarjarred.org.antlr.runtime.a.l(r110.length() + 40, "Duplicate key-value pairs exist for key ", r110));
    L10:
        r17 = new y4(r5);
        goto L11
    L20:
        throw new InvalidObjectException(androidx.constraintlayout.motion.widget.a.i(31, "Invalid value count ", r16));
    L38:
        f4.f8970a.a(this, r11.d());
        f7 r111 = f4.f8971b;
        r111.getClass();
        ((Field) r111.f8976a).set(this, Integer.valueOf(r14));     // Catch: IllegalAccessException -> L30
        f7 r112 = t4.f9165a;
        if (r5 != null) goto L27;
        Object r20 = ImmutableSet.of();
    L28:
        r112.a(this, r20);
        return;
    L27:
        r20 = ImmutableSortedSet.emptySet(r5);
    L30:
        e = move-exception;
        throw new AssertionError(e);
    L33:
        e = move-exception;
        throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
    L37:
        throw new InvalidObjectException(androidx.constraintlayout.motion.widget.a.i(29, "Invalid key count ", r10));
    }

    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> toImmutableSetMultimap(Function<? super T, ? extends K> r5, Function<? super T, ? extends V> r10) {
        int r11 = 9;
        Collector r12 = n1.f9084a;
        com.google.common.base.b0.n(r5, "keyFunction");
        com.google.common.base.b0.n(r10, "valueFunction");
        return Collector.of(new i1(r11), new g1(r5, r10, 3), new e1(r11), new h(15), new Collector.Characteristics[0]);
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        r5.writeObject(valueComparator());
        p7.z0(this, r5);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ ImmutableCollection entries() {
        return entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ ImmutableCollection get(Object r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public /* bridge */ /* synthetic */ ImmutableMultimap inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection removeAll(Object r5) {
        return removeAll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object r5, Iterable r10) {
        return replaceValues(r5, r10);
    }

    public Comparator<? super V> valueComparator() {
        ImmutableSet r5 = this.f;
        if ((r5 instanceof ImmutableSortedSet) == true) goto L7;
        return null;
    L7:
        return ((ImmutableSortedSet) r5).comparator();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r5, V r10) {
        s4 r11 = builder();
        r11.f(r5, r10);
        return r11.e();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection get(Object r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> r5 = this.g;
        if (r5 != null) goto L11;
        s4 r10 = builder();
        ga r11 = entries().iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.f(r12.getValue(), r12.getKey());
        goto L6
    L8:
        ImmutableSetMultimap<V, K> r13 = r10.e();
        r13.g = this;
        this.g = r13;
        return r13;
    L11:
        return r5;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    @Deprecated
    public /* bridge */ /* synthetic */ Collection removeAll(Object r5) {
        return removeAll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r5, Iterable r10) {
        return replaceValues(r5, r10);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Set entries() {
        return entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Set get(Object r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    @Deprecated
    public /* bridge */ /* synthetic */ Set removeAll(Object r5) {
        return removeAll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    @Deprecated
    public /* bridge */ /* synthetic */ Set replaceValues(Object r5, Iterable r10) {
        return replaceValues(r5, r10);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> r5 = this.f8839h;
        if (r5 != null) goto L6;
        EntrySet r10 = new EntrySet(this);
        this.f8839h = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    public ImmutableSet<V> get(K r5) {
        return (ImmutableSet) com.google.common.base.b0.y((ImmutableSet) this.map.get(r5), this.f);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    @Deprecated
    public final ImmutableSet<V> removeAll(Object r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    @Deprecated
    public final ImmutableSet<V> replaceValues(K r5, Iterable<? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r5, V r10, K r11, V r12) {
        s4 r13 = builder();
        r13.f(r5, r10);
        r13.f(r11, r12);
        return r13.e();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(q7 r5) {
        r5.getClass();
        if (r5.isEmpty() == false) goto L6;
        return of();
    L6:
        if ((r5 instanceof ImmutableSetMultimap) == false) goto L11;
        ImmutableSetMultimap<K, V> r10 = (ImmutableSetMultimap) r5;
        if (r10.isPartialView() == true) goto L11;
        return r10;
    L11:
        return fromMapEntries(r5.asMap().entrySet(), null);
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14) {
        s4 r15 = builder();
        r15.f(r5, r10);
        r15.f(r11, r12);
        r15.f(r13, r14);
        return r15.e();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14, K r15, V r16) {
        s4 r17 = builder();
        r17.f(r5, r10);
        r17.f(r11, r12);
        r17.f(r13, r14);
        r17.f(r15, r16);
        return r17.e();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18) {
        s4 r19 = builder();
        r19.f(r5, r10);
        r19.f(r11, r12);
        r19.f(r13, r14);
        r19.f(r15, r16);
        r19.f(r17, r18);
        return r19.e();
    }
}
