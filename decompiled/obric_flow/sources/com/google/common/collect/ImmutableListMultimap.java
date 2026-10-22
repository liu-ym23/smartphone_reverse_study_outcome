package com.google.common.collect;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements x5 {
    private static final long serialVersionUID = 0;
    public transient ImmutableListMultimap f;

    public ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> r5, int r10) {
        super(r5, r10);
    }

    public static <K, V> v3 builder() {
        return new v3();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(q7 r5) {
        if (r5.isEmpty() == false) goto L7;
        return of();
    L7:
        if ((r5 instanceof ImmutableListMultimap) == false) goto L12;
        ImmutableListMultimap<K, V> r10 = (ImmutableListMultimap) r5;
        if (r10.isPartialView() == true) goto L12;
        return r10;
    L12:
        return fromMapEntries(r5.asMap().entrySet(), null);
    }

    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> flatteningToImmutableListMultimap(Function<? super T, ? extends K> r5, Function<? super T, ? extends Stream<? extends V>> r10) {
        Collector r11 = n1.f9084a;
        r5.getClass();
        r10.getClass();
        h1 r12 = new h1(r5, 0);
        h1 r13 = new h1(r10, 1);
        p7.q(8, "expectedKeys");
        r7 r14 = new r7();
        p7.q(2, "expectedValuesPerKey");
        s7 r15 = new s7(r14);
        return Collectors.collectingAndThen(Collector.of(new i1(r15, 0), new g1(r12, r13, 4), new e1(10), new Collector.Characteristics[0]), new h(7));
    }

    public static <K, V> ImmutableListMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> r10, Comparator<? super V> r11) {
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
        ImmutableList r18 = ImmutableList.copyOf(r17);
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
        r18 = ImmutableList.sortedCopyOf(r11, r17);
        goto L14
    L20:
        if (r14 != 0) goto L22;
        ImmutableMap r20 = ImmutableMap.of();
    L27:
        return new ImmutableListMultimap(r20, r13);
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

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    private void readObject(ObjectInputStream r11) throws IOException, ClassNotFoundException {
        r11.defaultReadObject();
        int r5 = r11.readInt();
        if (r5 < 0) goto L25;
        x3 r10 = ImmutableMap.builder();
        int r12 = 0;
        int r13 = 0;
    L5:
        if (r12 >= r5) goto L28;
        Object r14 = r11.readObject();
        int r15 = r11.readInt();
        if (r15 <= 0) goto L13;
        u3 r16 = ImmutableList.builder();
        int r17 = 0;
    L9:
        if (r17 >= r15) goto L11;
        r16.B0(r11.readObject());
        r17 = r17 + 1;
        goto L9
    L11:
        r10.g(r14, r16.D0());
        r13 = r13 + r15;
        r12 = r12 + 1;
        goto L5
    L13:
        throw new InvalidObjectException(androidx.constraintlayout.motion.widget.a.i(31, "Invalid value count ", r15));
    L28:
        f4.f8970a.a(this, r10.d());
        f7 r18 = f4.f8971b;
        r18.getClass();
        ((Field) r18.f8976a).set(this, Integer.valueOf(r13));     // Catch: IllegalAccessException -> L18
        return;
    L18:
        e = move-exception;
        throw new AssertionError(e);
    L21:
        e = move-exception;
        throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
    L25:
        throw new InvalidObjectException(androidx.constraintlayout.motion.widget.a.i(29, "Invalid key count ", r5));
    }

    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> toImmutableListMultimap(Function<? super T, ? extends K> r5, Function<? super T, ? extends V> r10) {
        int r11 = 8;
        Collector r12 = n1.f9084a;
        com.google.common.base.b0.n(r5, "keyFunction");
        com.google.common.base.b0.n(r10, "valueFunction");
        return Collector.of(new i1(r11), new g1(r5, r10, 2), new e1(r11), new h(14), new Collector.Characteristics[0]);
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        p7.z0(this, r5);
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

    public static <K, V> ImmutableListMultimap<K, V> of(K r5, V r10) {
        v3 r11 = builder();
        r11.f(r5, r10);
        return r11.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection get(Object r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> r5 = this.f;
        if (r5 != null) goto L11;
        v3 r10 = builder();
        ga r11 = entries().iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.f(r12.getValue(), r12.getKey());
        goto L6
    L8:
        ImmutableListMultimap<V, K> r13 = r10.e();
        r13.f = this;
        this.f = r13;
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ List get(Object r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    @Deprecated
    public /* bridge */ /* synthetic */ List removeAll(Object r5) {
        return removeAll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    @Deprecated
    public /* bridge */ /* synthetic */ List replaceValues(Object r5, Iterable r10) {
        return replaceValues(r5, r10);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    public ImmutableList<V> get(K r5) {
        ImmutableList<V> r10 = (ImmutableList) this.map.get(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return ImmutableList.of();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    @Deprecated
    public final ImmutableList<V> removeAll(Object r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q7
    @Deprecated
    public final ImmutableList<V> replaceValues(K r5, Iterable<? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r5, V r10, K r11, V r12) {
        v3 r13 = builder();
        r13.f(r5, r10);
        r13.f(r11, r12);
        return r13.e();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r5) {
        v3 r10 = new v3();
        Iterator<? extends Map.Entry<? extends K, ? extends V>> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        r10.d(r11.next());
        goto L4
    L7:
        return r10.e();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14) {
        v3 r15 = builder();
        r15.f(r5, r10);
        r15.f(r11, r12);
        r15.f(r13, r14);
        return r15.e();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14, K r15, V r16) {
        v3 r17 = builder();
        r17.f(r5, r10);
        r17.f(r11, r12);
        r17.f(r13, r14);
        r17.f(r15, r16);
        return r17.e();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18) {
        v3 r19 = builder();
        r19.f(r5, r10);
        r19.f(r11, r12);
        r19.f(r13, r14);
        r19.f(r15, r16);
        r19.f(r17, r18);
        return r19.e();
    }
}
