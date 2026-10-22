package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableMap<K, V> implements Serializable, Map<K, V> {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = null;
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;
    private transient ImmutableSet<K> keySet;
    private transient ImmutableSetMultimap<K, V> multimapView;
    private transient ImmutableCollection<V> values;

    static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        IteratorBasedImmutableMap() {
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new C1EntrySetImpl(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableCollection<V> createValues() {
            return new ImmutableMapValues(this);
        }

        abstract bj<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        Spliterator<Map.Entry<K, V>> entrySpliterator() {
            return Spliterators.spliterator(entryIterator(), size(), 1297);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.k
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    private final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {
        final /* synthetic */ ImmutableMap this$0;

        private MapViewOfValuesAsSingletonSets(ImmutableMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ MapViewOfValuesAsSingletonSets(ImmutableMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(Object r1) {
            return this.this$0.containsKey(r1);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        ImmutableSet<K> createKeySet() {
            return this.this$0.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        bj<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            final bj<Map.Entry<K, V>> r0 = this.this$0.entrySet().iterator();
            return new AnonymousClass1(this, r0);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public ImmutableSet<V> get(Object r1) {
            Object r0 = this.this$0.get(r1);
            if (r0 != null) goto L6;
            return null;
        L6:
            return ImmutableSet.of(r0);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Object get(Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isHashCodeFast() {
            return this.this$0.isHashCodeFast();
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return this.this$0.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return this.this$0.size();
        }
    }

    static class SerializedForm<K, V> implements Serializable {
        private static final boolean USE_LEGACY_SERIALIZATION = true;
        private static final long serialVersionUID = 0;
        private final Object keys;
        private final Object values;

        SerializedForm(ImmutableMap<K, V> r7) {
            Object[] r0 = new Object[r7.size()];
            Object[] r1 = new Object[r7.size()];
            bj<Map.Entry<K, V>> r8 = r7.entrySet().iterator();
            int r2 = 0;
        L4:
            if (r8.hasNext() == false) goto L6;
            Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            r0[r2] = r3.getKey();
            r1[r2] = r3.getValue();
            r2 = r2 + 1;
            goto L4
        L6:
            this.keys = r0;
            this.values = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        final Object legacyReadResolve() {
            Object[] r0 = (Object[]) ZeusTransformUtils.preCheckCast(this.keys, Object[].class, "com.obric.memorydata.plugin");
            Object[] r1 = (Object[]) ZeusTransformUtils.preCheckCast(this.values, Object[].class, "com.obric.memorydata.plugin");
            a<K, V> r5 = makeBuilder(r0.length);
            int r2 = 0;
        L4:
            if (r2 >= r0.length) goto L7;
            r5.b(r0[r2], r1[r2]);
            r2 = r2 + 1;
            goto L4
        L7:
            return r5.e();
        }

        a<K, V> makeBuilder(int r1) {
            return new a(r1);
        }

        final Object readResolve() {
            if (ZeusTransformUtils.instanceOf(this.keys, ImmutableSet.class) == false) goto L5;
            ImmutableSet r0 = (ImmutableSet) ZeusTransformUtils.preCheckCast(this.keys, ImmutableSet.class, "com.obric.memorydata.plugin");
            ImmutableCollection r1 = (ImmutableCollection) ZeusTransformUtils.preCheckCast(this.values, ImmutableCollection.class, "com.obric.memorydata.plugin");
            a<K, V> r4 = makeBuilder(r0.size());
            bj r2 = r0.iterator();
            bj r3 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L11;
            r4.b(r2.next(), r3.next());
            goto L8
        L11:
            return r4.e();
        L5:
            return legacyReadResolve();
        }
    }

    public static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Comparator<? super V> f4449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map.Entry<K, V>[] f4450b;
        int c;
        boolean d;

        public a() {
            this(4);
        }

        a(int r1) {
            this.f4450b = new Map.Entry[r1];
            this.c = 0;
            this.d = false;
        }

        private ImmutableMap<K, V> a(boolean r8) {
            int r0 = this.c;
            if (r0 == 0) goto L21;
            if (r0 != 1) goto L7;
            Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.f4450b[0]), Map.Entry.class, "com.obric.memorydata.plugin");
            return ImmutableMap.of(r7.getKey(), r7.getValue());
        L7:
            if (this.f4449a != null) goto L10;
            Map.Entry<K, V>[] r1 = this.f4450b;
        L16:
            this.d = true;
            return RegularImmutableMap.fromEntryArray(r0, r1, r8);
        L10:
            if (this.d == false) goto L12;
            this.f4450b = (Map.Entry[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(this.f4450b, r0), Map.Entry[].class, "com.obric.memorydata.plugin");
        L12:
            r1 = this.f4450b;
            if (r8 == true) goto L15;
            Map.Entry<K, V>[] r2 = a(r1, this.c);
            r1 = r2;
            r0 = r2.length;
        L15:
            Arrays.sort(r1, 0, r0, Ordering.from(this.f4449a).onResultOf(Maps.b()));
            goto L16
        L21:
            return ImmutableMap.of();
        }

        private void a(int r3) {
            Map.Entry<K, V>[] r0 = this.f4450b;
            if (r3 <= r0.length) goto L6;
            this.f4450b = (Map.Entry[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r0, ImmutableCollection.a.a(r0.length, r3)), Map.Entry[].class, "com.obric.memorydata.plugin");
            this.d = false;
            return;
        }

        private static <K, V> Map.Entry<K, V>[] a(Map.Entry<K, V>[] r6, int r7) {
            HashSet r0 = new HashSet();
            BitSet r1 = new BitSet();
            int r2 = r7 - 1;
        L3:
            if (r2 < 0) goto L9;
            if (r0.add(r6[r2].getKey()) == true) goto L7;
            r1.set(r2);
        L7:
            r2 = r2 - 1;
            goto L3
        L9:
            if (r1.isEmpty() == false) goto L11;
            return r6;
        L11:
            Map.Entry<K, V>[] r3 = new Map.Entry[r7 - r1.cardinality()];
            int r4 = 0;
            int r5 = 0;
        L12:
            if (r4 >= r7) goto L17;
            if (r1.get(r4) == true) goto L16;
            r3[r5] = r6[r4];
            r5 = r5 + 1;
        L16:
            r4 = r4 + 1;
            goto L12
        L17:
            return r3;
        }

        a<K, V> b(a<K, V> r6) {
            com.google.common.base.n.a(r6);
            a(this.c + r6.c);
            System.arraycopy(r6.f4450b, 0, this.f4450b, this.c, r6.c);
            this.c += r6.c;
            return this;
        }

        public a<K, V> b(Iterable<? extends Map.Entry<? extends K, ? extends V>> r4) {
            Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r5, Collection.class) == false) goto L5;
            a(this.c + ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).size());
        L5:
            Iterator r6 = r5.iterator();
        L7:
            if (r6.hasNext() == false) goto L9;
            b((Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
            goto L7
        L9:
            return this;
        }

        public a<K, V> b(K r3, V r4) {
            a(this.c + 1);
            Map.Entry<K, V> r5 = ImmutableMap.entryOf(r3, r4);
            Map.Entry<K, V>[] r6 = this.f4450b;
            int r0 = this.c;
            this.c = r0 + 1;
            r6[r0] = r5;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a<K, V> b(Map.Entry<? extends K, ? extends V> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            return b(r4.getKey(), r4.getValue());
        }

        public a<K, V> b(Map<? extends K, ? extends V> r3) {
            return b(((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin")).entrySet());
        }

        public ImmutableMap<K, V> d() {
            return a(false);
        }

        public ImmutableMap<K, V> e() {
            return a(true);
        }

        public ImmutableMap<K, V> f() {
            return e();
        }
    }

    static {
        EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    }

    ImmutableMap() {
    }

    public static <K, V> a<K, V> builder() {
        return new a();
    }

    public static <K, V> a<K, V> builderWithExpectedSize(int r1) {
        o.a(r1, "expectedSize");
        return new a(r1);
    }

    static void checkNoConflict(boolean r0, String r1, Object r2, Object r3) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw conflictException(r1, r2, r3);
    }

    static IllegalArgumentException conflictException(String r3, Object r4, Object r5) {
        return new IllegalArgumentException("Multiple entries with same " + r3 + ": " + r4 + " and " + r5);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r3) {
        Map.Entry[] r4 = (Map.Entry[]) ZeusTransformUtils.preCheckCast(aj.a((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"), EMPTY_ENTRY_ARRAY), Map.Entry[].class, "com.obric.memorydata.plugin");
        int r0 = r4.length;
        if (r0 == 0) goto L11;
        if (r0 != 1) goto L7;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r4[0]), Map.Entry.class, "com.obric.memorydata.plugin");
        return of(r5.getKey(), r5.getValue());
    L7:
        return RegularImmutableMap.fromEntries(r4);
    L11:
        return of();
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ImmutableMap.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r4, SortedMap.class) == true) goto L10;
        ImmutableMap<K, V> r0 = (ImmutableMap) ZeusTransformUtils.preCheckCast(r4, ImmutableMap.class, "com.obric.memorydata.plugin");
        if (r0.isPartialView() == true) goto L14;
        return r0;
    L14:
        return copyOf(r4.entrySet());
    L10:
        if (ZeusTransformUtils.instanceOf(r4, EnumMap.class) == false) goto L14;
        return copyOfEnumMap((EnumMap) ZeusTransformUtils.preCheckCast(r4, EnumMap.class, "com.obric.memorydata.plugin"));
    }

    private static <K extends Enum<K>, V> ImmutableMap<K, ? extends V> copyOfEnumMap(EnumMap<?, ? extends V> r4) {
        EnumMap r0 = new EnumMap(r4);
        Iterator<Map.Entry<K, V>> r5 = r0.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        o.a(r1.getKey(), r1.getValue());
        goto L4
    L7:
        return ImmutableEnumMap.asImmutable(r0);
    }

    static <K, V> Map.Entry<K, V> entryOf(K r1, V r2) {
        return new ImmutableMapEntry(r1, r2);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    public static <K, V> ImmutableMap<K, V> of(K r0, V r1) {
        return ImmutableBiMap.of(r0, r1);
    }

    public static <K, V> ImmutableMap<K, V> of(K r1, V r2, K r3, V r4) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r1, r2), entryOf(r3, r4)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r1, r2), entryOf(r3, r4), entryOf(r5, r6)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r1, r2), entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r1, r2), entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r1, r2), entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12, K r13, V r14) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r1, r2), entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18, K r19, V r20) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18), entryOf(r19, r20)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18, K r19, V r20, K r21, V r22) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18), entryOf(r19, r20), entryOf(r21, r22)});
    }

    @SafeVarargs
    public static <K, V> ImmutableMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... r0) {
        return RegularImmutableMap.fromEntries(r0);
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3) {
        return n.a((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin"));
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3, BinaryOperator<V> r4) {
        return n.a((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin"), (BinaryOperator) ZeusTransformUtils.wrapperContextForParams(r4, BinaryOperator.class, "com.obric.memorydata.plugin"));
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty() == true) goto L5;
        ImmutableSetMultimap<K, V> r0 = this.multimapView;
        if (r0 != null) goto L10;
        ImmutableSetMultimap<K, V> r1 = new ImmutableSetMultimap(new MapViewOfValuesAsSingletonSets(this, null), size(), null);
        this.multimapView = r1;
        return r1;
    L10:
        return r0;
    L5:
        return ImmutableSetMultimap.of();
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V compute(K r1, BiFunction<? super K, ? super V, ? extends V> r2) {
        BiFunction r0 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V computeIfAbsent(K r1, Function<? super K, ? extends V> r2) {
        Function r0 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V computeIfPresent(K r1, BiFunction<? super K, ? super V, ? extends V> r2) {
        BiFunction r0 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(Object r1) {
        if (get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object r1) {
        return values().contains(r1);
    }

    abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    abstract ImmutableSet<K> createKeySet();

    abstract ImmutableCollection<V> createValues();

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> r0 = this.entrySet;
        if (r0 != null) goto L6;
        ImmutableSet<Map.Entry<K, V>> r1 = createEntrySet();
        this.entrySet = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    public boolean equals(Object r1) {
        return Maps.f(this, r1);
    }

    public abstract V get(Object r1);

    @Override // java.util.Map
    public final V getOrDefault(Object r1, V r2) {
        V r0 = get(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r2;
    }

    @Override // java.util.Map
    public int hashCode() {
        return Sets.a(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isHashCodeFast() {
        return false;
    }

    abstract boolean isPartialView();

    bj<K> keyIterator() {
        final bj<Map.Entry<K, V>> r0 = entrySet().iterator();
        return new AnonymousClass1(this, r0);
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> r0 = this.keySet;
        if (r0 != null) goto L6;
        ImmutableSet<K> r1 = createKeySet();
        this.keySet = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    Spliterator<K> keySpliterator() {
        return p.a(entrySet().spliterator(), $$Lambda$Xht_Ljvt5R8DKx7cj_m0kty8zw.INSTANCE);
    }

    @Override // java.util.Map
    @Deprecated
    public final V merge(K r1, V r2, BiFunction<? super V, ? super V, ? extends V> r3) {
        BiFunction r0 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r3, BiFunction.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V putIfAbsent(K r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean remove(Object r1, Object r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V replace(K r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean replace(K r1, V r2, V r3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void replaceAll(BiFunction<? super K, ? super V, ? extends V> r2) {
        BiFunction r1 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.a(this);
    }

    public ImmutableCollection<V> values() {
        ImmutableCollection<V> r0 = this.values;
        if (r0 != null) goto L6;
        ImmutableCollection<V> r1 = createValues();
        this.values = r1;
        return r1;
    L6:
        return r0;
    }

    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
