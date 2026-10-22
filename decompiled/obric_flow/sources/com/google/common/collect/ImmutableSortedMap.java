package com.google.common.collect;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g8 f8841h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ImmutableSortedMap f8842i = null;
    private static final long serialVersionUID = 0;
    public final transient RegularImmutableSortedSet e;
    public final transient ImmutableList f;
    public final transient ImmutableSortedMap g;

    public static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;
        private final Comparator<? super K> comparator;

        public SerializedForm(ImmutableSortedMap<K, V> r5) {
            super(r5);
            this.comparator = r5.comparator();
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public /* bridge */ /* synthetic */ x3 makeBuilder(int r5) {
            return makeBuilder(r5);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public v4 makeBuilder(int r5) {
            return new v4(this.comparator);
        }
    }

    static {
        f8841h = g8.natural();
        f8842i = new ImmutableSortedMap(ImmutableSortedSet.emptySet(g8.natural()), ImmutableList.of());
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> r5, ImmutableList<V> r10) {
        this(r5, r10, null);
    }

    public static ImmutableSortedMap a(Map r5, Comparator r10) {
        boolean r11 = false;
        if ((r5 instanceof SortedMap) == false) goto L10;
        Comparator<? super K> r12 = ((SortedMap) r5).comparator();
        if (r12 == null) goto L7;
        r11 = r10.equals(r12);
        goto L10
    L7:
        if (r10 != f8841h) goto L10;
        r11 = true;
    L10:
        if (r11 == true) goto L12;
    L16:
        Set<Map.Entry<K, V>> r13 = r5.entrySet();
        Map.Entry<?, ?>[] r14 = ImmutableMap.EMPTY_ENTRY_ARRAY;
        if ((r13 instanceof Collection) == false) goto L19;
        Set<Map.Entry<K, V>> r15 = r13;
    L20:
        Map.Entry[] r16 = (Map.Entry[]) r15.toArray(r14);
        return b(r10, r11, r16, r16.length);
    L19:
        r15 = p7.V(r13.iterator());
        goto L20
    L12:
        if ((r5 instanceof ImmutableSortedMap) == false) goto L16;
        ImmutableSortedMap r17 = (ImmutableSortedMap) r5;
        if (r17.isPartialView() == true) goto L16;
        return r17;
    }

    public static /* synthetic */ ImmutableSortedMap access$000(Comparator r5, Object r10, Object r11) {
        return e(r5, r10, r11);
    }

    public static /* synthetic */ ImmutableSortedMap access$100(Comparator r5, boolean r10, Map.Entry[] r11, int r12) {
        return b(r5, r10, r11, r12);
    }

    public static /* synthetic */ RegularImmutableSortedSet access$200(ImmutableSortedMap r5) {
        return r5.e;
    }

    public static /* synthetic */ ImmutableList access$300(ImmutableSortedMap r5) {
        return r5.f;
    }

    public static ImmutableSortedMap b(Comparator r10, boolean r11, Map.Entry[] r12, int r13) {
        if (r13 == 0) goto L21;
        int r5 = 0;
        if (r13 == 1) goto L18;
        Object[] r14 = new Object[r13];
        Object[] r15 = new Object[r13];
        if (r11 == false) goto L9;
    L7:
        if (r5 >= r13) goto L17;
        Map.Entry r16 = r12[r5];
        Objects.requireNonNull(r16);
        Map.Entry r17 = r16;
        Object r18 = r17.getKey();
        Object r19 = r17.getValue();
        p7.p(r18, r19);
        r14[r5] = r18;
        r15[r5] = r19;
        r5 = r5 + 1;
    L17:
        return new ImmutableSortedMap(new RegularImmutableSortedSet(new RegularImmutableList(r14), r10), new RegularImmutableList(r15));
    L9:
        Arrays.sort(r12, 0, r13, new u4(r10));
        Map.Entry r110 = r12[0];
        Objects.requireNonNull(r110);
        Map.Entry r111 = r110;
        Object r20 = r111.getKey();
        r14[0] = r20;
        Object r112 = r111.getValue();
        r15[0] = r112;
        p7.p(r14[0], r112);
        int r113 = 1;
    L10:
        if (r113 >= r13) goto L17;
        Map.Entry r21 = r12[r113 - 1];
        Objects.requireNonNull(r21);
        Map.Entry r22 = r21;
        Map.Entry r23 = r12[r113];
        Objects.requireNonNull(r23);
        Map.Entry r24 = r23;
        Object r25 = r24.getKey();
        Object r26 = r24.getValue();
        p7.p(r25, r26);
        r14[r113] = r25;
        r15[r113] = r26;
        if (r10.compare(r20, r25) == 0) goto L14;
        boolean r27 = true;
    L15:
        ImmutableMap.checkNoConflict(r27, STGroup.DICT_KEY, r22, r24);
        r113 = r113 + 1;
        r20 = r25;
        goto L10
    L14:
        r27 = false;
        goto L15
    L18:
        Map.Entry r114 = r12[0];
        Objects.requireNonNull(r114);
        Map.Entry r115 = r114;
        return e(r10, r115.getKey(), r115.getValue());
    L21:
        return emptyMap(r10);
    }

    public static ImmutableSortedMap c(Map.Entry... r5) {
        return b(g8.natural(), false, r5, r5.length);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> r5) {
        return a(r5, f8841h);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> r5) {
        Comparator<? super K> r10 = r5.comparator();
        if (r10 != null) goto L6;
        r10 = f8841h;
    L6:
        if ((r5 instanceof ImmutableSortedMap) == false) goto L10;
        ImmutableSortedMap<K, V> r11 = (ImmutableSortedMap) r5;
        if (r11.isPartialView() == true) goto L10;
        return r11;
    L10:
        Set<Map.Entry<K, ? extends V>> r12 = r5.entrySet();
        Map.Entry<?, ?>[] r13 = ImmutableMap.EMPTY_ENTRY_ARRAY;
        if ((r12 instanceof Collection) == false) goto L13;
        Set<Map.Entry<K, ? extends V>> r14 = r12;
    L14:
        Map.Entry[] r15 = (Map.Entry[]) r14.toArray(r13);
        return b(r10, true, r15, r15.length);
    L13:
        r14 = p7.V(r12.iterator());
        goto L14
    }

    public static ImmutableSortedMap e(Comparator r5, Object r10, Object r11) {
        ImmutableList r12 = ImmutableList.of(r10);
        r5.getClass();
        return new ImmutableSortedMap(new RegularImmutableSortedSet(r12, r5), ImmutableList.of(r11));
    }

    public static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> r5) {
        if (g8.natural().equals(r5) == false) goto L7;
        return of();
    L7:
        return new ImmutableSortedMap(ImmutableSortedSet.emptySet(r5), ImmutableList.of());
    }

    public static <K extends Comparable<?>, V> v4 naturalOrder() {
        return new v4(g8.natural());
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return f8842i;
    }

    public static <K, V> v4 orderedBy(Comparator<K> r5) {
        return new v4(r5);
    }

    public static <K extends Comparable<?>, V> v4 reverseOrder() {
        return new v4(g8.natural().reverse());
    }

    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(Comparator<? super K> r5, Function<? super T, ? extends K> r10, Function<? super T, ? extends V> r11) {
        Collector r12 = n1.f9084a;
        r5.getClass();
        r10.getClass();
        r11.getClass();
        return Collector.of(new k1(r5, 2), new g1(r10, r11, 5), new e1(11), new h(17), new Collector.Characteristics[]{Collector.Characteristics.UNORDERED});
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K r5) {
        return tailMap(r5, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K r5) {
        return (K) p7.P(ceilingEntry(r5));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new C1EntrySet(this);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        throw new AssertionError("should never be called");
    }

    public final ImmutableSortedMap d(int r5, int r10) {
        if (r5 == 0) goto L4;
    L6:
        if (r5 != r10) goto L10;
        return emptyMap(comparator());
    L10:
        return new ImmutableSortedMap(this.e.getSubSet(r5, r10), this.f.subList(r5, r10));
    L4:
        if (r10 != size()) goto L6;
        return this;
    }

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableSet descendingKeySet() {
        return descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap descendingMap() {
        return descendingMap();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return entrySet().asList().get(0);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K r5) {
        return headMap(r5, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K r5) {
        return (K) p7.P(floorEntry(r5));
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r5) {
        com.google.common.base.b0.m(r5);
        ImmutableList r10 = this.e.asList();
        int r11 = 0;
    L4:
        if (r11 >= size()) goto L6;
        r5.accept((Object) r10.get(r11), (Object) this.f.get(r11));
        r11 = r11 + 1;
        goto L4
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object r5) {
        int r10 = this.e.indexOf(r5);
        if (r10 != (-1)) goto L6;
        return null;
    L6:
        return (V) this.f.get(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap headMap(Object r5, boolean r10) {
        return headMap(r5, r10);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K r5) {
        return tailMap(r5, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K r5) {
        return (K) p7.P(higherEntry(r5));
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        if (this.e.isPartialView() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f.isPartialView() == true) goto L8;
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ ImmutableSet keySet() {
        return keySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return entrySet().asList().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K r5) {
        return headMap(r5, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K r5) {
        return (K) p7.P(lowerEntry(r5));
    }

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableSet navigableKeySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.f.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap subMap(Object r5, boolean r10, Object r11, boolean r12) {
        return subMap(r5, r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap tailMap(Object r5, boolean r10) {
        return tailMap(r5, r10);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> r5, ImmutableList<V> r10, ImmutableSortedMap<K, V> r11) {
        this.e = r5;
        this.f = r10;
        this.g = r11;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r5, Object r10) {
        return e(g8.natural(), r5, r10);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> descendingKeySet() {
        return (ImmutableSortedSet<K>) this.e.descendingSet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> r5 = this.g;
        if (r5 == null) goto L5;
        return r5;
    L5:
        if (isEmpty() == false) goto L9;
        return emptyMap(g8.from(comparator()).reverse());
    L9:
        return new ImmutableSortedMap((RegularImmutableSortedSet) this.e.descendingSet(), this.f.reverse(), this);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap headMap(Object r5) {
        return headMap(r5);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap subMap(Object r5, Object r10) {
        return subMap(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap tailMap(Object r5) {
        return tailMap(r5);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableCollection<V> values() {
        return this.f;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r5) {
        return copyOf(r5, f8841h);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r5, Object r10, Comparable r11, Object r12) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r5, r10), ImmutableMap.entryOf(r11, r12)});
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> headMap(K r5, boolean r10) {
        r5.getClass();
        return d(0, this.e.headIndex(r5, r10));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSortedSet<K> keySet() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> subMap(K r5, boolean r10, K r11, boolean r12) {
        r5.getClass();
        r11.getClass();
        if (comparator().compare(r5, r11) > 0) goto L5;
        boolean r13 = true;
    L6:
        com.google.common.base.b0.k(r13, "expected fromKey <= toKey but %s > %s", r5, r11);
        return headMap(r11, r12).tailMap(r5, r10);
    L5:
        r13 = false;
        goto L6
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> tailMap(K r5, boolean r10) {
        r5.getClass();
        return d(this.e.tailIndex(r5, r10), size());
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r5, Object r10, Comparable r11, Object r12, Comparable r13, Object r14) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r5, r10), ImmutableMap.entryOf(r11, r12), ImmutableMap.entryOf(r13, r14)});
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r5, Comparator<? super K> r10) {
        r10.getClass();
        Map.Entry<?, ?>[] r11 = ImmutableMap.EMPTY_ENTRY_ARRAY;
        if ((r5 instanceof Collection) == false) goto L5;
        Collection r12 = (Collection) r5;
    L6:
        Map.Entry[] r13 = (Map.Entry[]) r12.toArray(r11);
        return b(r10, false, r13, r13.length);
    L5:
        r12 = p7.V(r5.iterator());
        goto L6
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r5, Object r10, Comparable r11, Object r12, Comparable r13, Object r14, Comparable r15, Object r16) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r5, r10), ImmutableMap.entryOf(r11, r12), ImmutableMap.entryOf(r13, r14), ImmutableMap.entryOf(r15, r16)});
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> headMap(K r5) {
        return headMap(r5, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> tailMap(K r5) {
        return tailMap(r5, true);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r5, Object r10, Comparable r11, Object r12, Comparable r13, Object r14, Comparable r15, Object r16, Comparable r17, Object r18) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r5, r10), ImmutableMap.entryOf(r11, r12), ImmutableMap.entryOf(r13, r14), ImmutableMap.entryOf(r15, r16), ImmutableMap.entryOf(r17, r18)});
    }

    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(Comparator<? super K> r5, Function<? super T, ? extends K> r10, Function<? super T, ? extends V> r11, BinaryOperator<V> r12) {
        Collector r13 = n1.f9084a;
        r5.getClass();
        r10.getClass();
        r11.getClass();
        r12.getClass();
        return Collectors.collectingAndThen(Collectors.toMap(r10, r11, r12, new k1(r5, 0)), new h(10));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r5, Object r10, Comparable r11, Object r12, Comparable r13, Object r14, Comparable r15, Object r16, Comparable r17, Object r18, Comparable r19, Object r110) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r5, r10), ImmutableMap.entryOf(r11, r12), ImmutableMap.entryOf(r13, r14), ImmutableMap.entryOf(r15, r16), ImmutableMap.entryOf(r17, r18), ImmutableMap.entryOf(r19, r110)});
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> subMap(K r5, K r10) {
        return subMap(r5, true, r10, false);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> r5, Comparator<? super K> r10) {
        r10.getClass();
        return a(r5, r10);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r5, Object r10, Comparable r11, Object r12, Comparable r13, Object r14, Comparable r15, Object r16, Comparable r17, Object r18, Comparable r19, Object r110, Comparable r111, Object r112) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r5, r10), ImmutableMap.entryOf(r11, r12), ImmutableMap.entryOf(r13, r14), ImmutableMap.entryOf(r15, r16), ImmutableMap.entryOf(r17, r18), ImmutableMap.entryOf(r19, r110), ImmutableMap.entryOf(r111, r112)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r5, Object r10, Comparable r11, Object r12, Comparable r13, Object r14, Comparable r15, Object r16, Comparable r17, Object r18, Comparable r19, Object r110, Comparable r111, Object r112, Comparable r113, Object r114) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r5, r10), ImmutableMap.entryOf(r11, r12), ImmutableMap.entryOf(r13, r14), ImmutableMap.entryOf(r15, r16), ImmutableMap.entryOf(r17, r18), ImmutableMap.entryOf(r19, r110), ImmutableMap.entryOf(r111, r112), ImmutableMap.entryOf(r113, r114)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r11, Object r12, Comparable r13, Object r14, Comparable r15, Object r16, Comparable r17, Object r18, Comparable r19, Object r20, Comparable r21, Object r22, Comparable r23, Object r24, Comparable r25, Object r26, Comparable r27, Object r28) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r11, r12), ImmutableMap.entryOf(r13, r14), ImmutableMap.entryOf(r15, r16), ImmutableMap.entryOf(r17, r18), ImmutableMap.entryOf(r19, r20), ImmutableMap.entryOf(r21, r22), ImmutableMap.entryOf(r23, r24), ImmutableMap.entryOf(r25, r26), ImmutableMap.entryOf(r27, r28)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r12, Object r13, Comparable r14, Object r15, Comparable r16, Object r17, Comparable r18, Object r19, Comparable r20, Object r21, Comparable r22, Object r23, Comparable r24, Object r25, Comparable r26, Object r27, Comparable r28, Object r29, Comparable r30, Object r31) {
        return c(new Map.Entry[]{ImmutableMap.entryOf(r12, r13), ImmutableMap.entryOf(r14, r15), ImmutableMap.entryOf(r16, r17), ImmutableMap.entryOf(r18, r19), ImmutableMap.entryOf(r20, r21), ImmutableMap.entryOf(r22, r23), ImmutableMap.entryOf(r24, r25), ImmutableMap.entryOf(r26, r27), ImmutableMap.entryOf(r28, r29), ImmutableMap.entryOf(r30, r31)});
    }
}
