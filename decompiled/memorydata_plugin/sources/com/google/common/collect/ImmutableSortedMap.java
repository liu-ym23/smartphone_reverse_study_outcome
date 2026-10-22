package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
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

/* JADX INFO: loaded from: classes2.dex */
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
    private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = null;
    private static final Comparator<Comparable> NATURAL_ORDER = null;
    private static final long serialVersionUID = 0;
    private transient ImmutableSortedMap<K, V> descendingMap;
    private final transient RegularImmutableSortedSet<K> keySet;
    private final transient ImmutableList<V> valueList;

    private static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;
        private final Comparator<? super K> comparator;

        SerializedForm(ImmutableSortedMap<K, V> r1) {
            super(r1);
            this.comparator = r1.comparator();
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        /* bridge */ /* synthetic */ ImmutableMap.a makeBuilder(int r1) {
            return makeBuilder(r1);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        a<K, V> makeBuilder(int r1) {
            return new a(this.comparator);
        }
    }

    public static class a<K, V> extends ImmutableMap.a<K, V> {
        private final Comparator<? super K> e;

        public a(Comparator<? super K> r3) {
            this.e = (Comparator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin");
        }

        a<K, V> a(ImmutableMap.a<K, V> r1) {
            super.b(r1);
            return this;
        }

        public a<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> r3) {
            super.b((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public a<K, V> a(K r1, V r2) {
            super.b(r1, r2);
            return this;
        }

        public a<K, V> a(Map.Entry<? extends K, ? extends V> r3) {
            super.b((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public a<K, V> a(Map<? extends K, ? extends V> r3) {
            super.b((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public ImmutableSortedMap<K, V> a() {
            return b();
        }

        @Override // com.google.common.collect.ImmutableMap.a
        /* synthetic */ ImmutableMap.a b(ImmutableMap.a r1) {
            return a(r1);
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public /* synthetic */ ImmutableMap.a b(Iterable r3) {
            return a((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.a
        public /* synthetic */ ImmutableMap.a b(Object r1, Object r2) {
            return a(r1, r2);
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public /* synthetic */ ImmutableMap.a b(Map.Entry r3) {
            return a((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public /* synthetic */ ImmutableMap.a b(Map r3) {
            return a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
        }

        public ImmutableSortedMap<K, V> b() {
            int r0 = this.c;
            if (r0 == 0) goto L11;
            if (r0 != 1) goto L7;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.f4450b[0]), Map.Entry.class, "com.obric.memorydata.plugin");
            return ImmutableSortedMap.access$000(this.e, r1.getKey(), r1.getValue());
        L7:
            return ImmutableSortedMap.access$100(this.e, false, this.f4450b, this.c);
        L11:
            return ImmutableSortedMap.emptyMap(this.e);
        }

        @Deprecated
        public final ImmutableSortedMap<K, V> c() {
            throw new UnsupportedOperationException("ImmutableSortedMap.Builder does not yet implement buildKeepingLast()");
        }

        @Override // com.google.common.collect.ImmutableMap.a
        @Deprecated
        public /* synthetic */ ImmutableMap d() {
            return c();
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public /* synthetic */ ImmutableMap e() {
            return b();
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public /* synthetic */ ImmutableMap f() {
            return a();
        }
    }

    static {
        NATURAL_ORDER = Ordering.natural();
        NATURAL_EMPTY_MAP = new ImmutableSortedMap(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());
    }

    ImmutableSortedMap(RegularImmutableSortedSet<K> r2, ImmutableList<V> r3) {
        this(r2, r3, null);
    }

    ImmutableSortedMap(RegularImmutableSortedSet<K> r1, ImmutableList<V> r2, ImmutableSortedMap<K, V> r3) {
        this.keySet = r1;
        this.valueList = r2;
        this.descendingMap = r3;
    }

    static /* synthetic */ ImmutableSortedMap access$000(Comparator r2, Object r3, Object r4) {
        return of((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    static /* synthetic */ ImmutableSortedMap access$100(Comparator r2, boolean r3, Map.Entry[] r4, int r5) {
        return fromEntries((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin"), r3, r4, r5);
    }

    static /* synthetic */ RegularImmutableSortedSet access$200(ImmutableSortedMap r0) {
        return r0.keySet;
    }

    static /* synthetic */ ImmutableList access$300(ImmutableSortedMap r0) {
        return r0.valueList;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r3) {
        return copyOf((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"), (Ordering) ZeusTransformUtils.preCheckCast(NATURAL_ORDER, Ordering.class, "com.obric.memorydata.plugin"));
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r2, Comparator<? super K> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        return fromEntries((Comparator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin"), false, r4);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> r3) {
        return copyOfInternal((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), (Ordering) ZeusTransformUtils.preCheckCast(NATURAL_ORDER, Ordering.class, "com.obric.memorydata.plugin"));
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> r2, Comparator<? super K> r3) {
        return copyOfInternal((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin"));
    }

    private static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> r4, Comparator<? super K> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Comparator<Comparable> r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r5, Comparator.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r6, SortedMap.class) == false) goto L11;
        Comparator<? super K> r1 = ((SortedMap) ZeusTransformUtils.preCheckCast(r6, SortedMap.class, "com.obric.memorydata.plugin")).comparator();
        if (r1 == null) goto L7;
        boolean r2 = r7.equals(r1);
    L10:
        r3 = r2;
        goto L11
    L7:
        if (r7 != NATURAL_ORDER) goto L11;
        r2 = true;
    L11:
        if (r3 == false) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, ImmutableSortedMap.class) == false) goto L18;
        ImmutableSortedMap<K, V> r0 = (ImmutableSortedMap) ZeusTransformUtils.preCheckCast(r6, ImmutableSortedMap.class, "com.obric.memorydata.plugin");
        if (r0.isPartialView() == true) goto L18;
        return r0;
    L18:
        return fromEntries(r7, r3, r6.entrySet());
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> r4) {
        SortedMap r5 = (SortedMap) ZeusTransformUtils.wrapperContextForParams(r4, SortedMap.class, "com.obric.memorydata.plugin");
        Comparator<Comparable> r1 = r5.comparator();
        if (r1 != null) goto L6;
        r1 = NATURAL_ORDER;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ImmutableSortedMap.class) == false) goto L11;
        ImmutableSortedMap<K, V> r0 = (ImmutableSortedMap) ZeusTransformUtils.preCheckCast(r5, ImmutableSortedMap.class, "com.obric.memorydata.plugin");
        if (r0.isPartialView() == true) goto L11;
        return r0;
    L11:
        return fromEntries(r1, true, r5.entrySet());
    }

    static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> r2) {
        Comparator r3 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        if (Ordering.natural().equals(r3) == false) goto L7;
        return of();
    L7:
        return new ImmutableSortedMap(ImmutableSortedSet.emptySet(r3), ImmutableList.of());
    }

    private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> r2, boolean r3, Iterable<? extends Map.Entry<? extends K, ? extends V>> r4) {
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        Map.Entry[] r6 = (Map.Entry[]) ZeusTransformUtils.preCheckCast(aj.a((Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"), EMPTY_ENTRY_ARRAY), Map.Entry[].class, "com.obric.memorydata.plugin");
        return fromEntries(r5, r3, r6, r6.length);
    }

    private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> r10, boolean r11, Map.Entry<K, V>[] r12, int r13) {
        final Comparator r14 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r10, Comparator.class, "com.obric.memorydata.plugin");
        if (r13 == 0) goto L22;
        int r2 = 0;
        if (r13 == 1) goto L19;
        Object[] r3 = new Object[r13];
        Object[] r4 = new Object[r13];
        if (r11 == false) goto L10;
    L8:
        if (r2 >= r13) goto L18;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r12[r2]), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r0 = r15.getKey();
        Object r16 = r15.getValue();
        o.a(r0, r16);
        r3[r2] = r0;
        r4[r2] = r16;
        r2 = r2 + 1;
    L18:
        return new ImmutableSortedMap(new RegularImmutableSortedSet(new RegularImmutableList(r3), r14), new RegularImmutableList(r4));
    L10:
        Arrays.sort(r12, 0, r13, new $$Lambda$ImmutableSortedMap$NfbNoNBlXgMMYtpSNqTqcrygOZQ(r14));
        Map.Entry r17 = (Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r12[0]), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r5 = r17.getKey();
        r3[0] = r5;
        r4[0] = r17.getValue();
        o.a(r3[0], r4[0]);
        int r18 = 1;
    L11:
        if (r18 >= r13) goto L18;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r12[r18 - 1]), Map.Entry.class, "com.obric.memorydata.plugin");
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r12[r18]), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r8 = r7.getKey();
        Object r9 = r7.getValue();
        o.a(r8, r9);
        r3[r18] = r8;
        r4[r18] = r9;
        if (r14.compare(r5, r8) == 0) goto L15;
        boolean r19 = true;
    L16:
        checkNoConflict(r19, "key", r6, r7);
        r18 = r18 + 1;
        r5 = r8;
        goto L11
    L15:
        r19 = false;
        goto L16
    L19:
        Map.Entry r110 = (Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r12[0]), Map.Entry.class, "com.obric.memorydata.plugin");
        return of(r14, r110.getKey(), r110.getValue());
    L22:
        return emptyMap(r14);
    }

    private static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> fromEntries(Map.Entry<K, V>... r3) {
        return fromEntries(Ordering.natural(), false, r3, r3.length);
    }

    private ImmutableSortedMap<K, V> getSubMap(int r3, int r4) {
        if (r3 == 0) goto L4;
    L6:
        if (r3 != r4) goto L10;
        return emptyMap(comparator());
    L10:
        return new ImmutableSortedMap(this.keySet.getSubSet(r3, r4), this.valueList.subList(r3, r4));
    L4:
        if (r4 != size()) goto L6;
        return this;
    }

    static /* synthetic */ int lambda$fromEntries$0(Comparator r2, Map.Entry r3, Map.Entry r4) {
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6);
        Objects.requireNonNull(r7);
        return r5.compare(r6.getKey(), r7.getKey());
    }

    public static <K extends Comparable<?>, V> a<K, V> naturalOrder() {
        return new a(Ordering.natural());
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return (ImmutableSortedMap<K, V>) NATURAL_EMPTY_MAP;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r2, Object r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        return of(Ordering.natural(), r4, r3);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r2, Object r3, Comparable r4, Object r5) {
        return fromEntries(new Map.Entry[]{entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin"), r3), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin"), r5)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r2, Object r3, Comparable r4, Object r5, Comparable r6, Object r7) {
        return fromEntries(new Map.Entry[]{entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin"), r3), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin"), r5), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r6, Comparable.class, "com.obric.memorydata.plugin"), r7)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r2, Object r3, Comparable r4, Object r5, Comparable r6, Object r7, Comparable r8, Object r9) {
        return fromEntries(new Map.Entry[]{entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin"), r3), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin"), r5), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r6, Comparable.class, "com.obric.memorydata.plugin"), r7), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r8, Comparable.class, "com.obric.memorydata.plugin"), r9)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r2, Object r3, Comparable r4, Object r5, Comparable r6, Object r7, Comparable r8, Object r9, Comparable r10, Object r11) {
        return fromEntries(new Map.Entry[]{entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin"), r3), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin"), r5), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r6, Comparable.class, "com.obric.memorydata.plugin"), r7), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r8, Comparable.class, "com.obric.memorydata.plugin"), r9), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r10, Comparable.class, "com.obric.memorydata.plugin"), r11)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r2, Object r3, Comparable r4, Object r5, Comparable r6, Object r7, Comparable r8, Object r9, Comparable r10, Object r11, Comparable r12, Object r13) {
        return fromEntries(new Map.Entry[]{entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin"), r3), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin"), r5), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r6, Comparable.class, "com.obric.memorydata.plugin"), r7), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r8, Comparable.class, "com.obric.memorydata.plugin"), r9), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r10, Comparable.class, "com.obric.memorydata.plugin"), r11), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r12, Comparable.class, "com.obric.memorydata.plugin"), r13)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r2, Object r3, Comparable r4, Object r5, Comparable r6, Object r7, Comparable r8, Object r9, Comparable r10, Object r11, Comparable r12, Object r13, Comparable r14, Object r15) {
        return fromEntries(new Map.Entry[]{entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin"), r3), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin"), r5), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r6, Comparable.class, "com.obric.memorydata.plugin"), r7), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r8, Comparable.class, "com.obric.memorydata.plugin"), r9), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r10, Comparable.class, "com.obric.memorydata.plugin"), r11), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r12, Comparable.class, "com.obric.memorydata.plugin"), r13), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r14, Comparable.class, "com.obric.memorydata.plugin"), r15)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r10, Object r11, Comparable r12, Object r13, Comparable r14, Object r15, Comparable r16, Object r17, Comparable r18, Object r19, Comparable r20, Object r21, Comparable r22, Object r23, Comparable r24, Object r25) {
        return fromEntries(new Map.Entry[]{entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r10, Comparable.class, "com.obric.memorydata.plugin"), r11), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r12, Comparable.class, "com.obric.memorydata.plugin"), r13), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r14, Comparable.class, "com.obric.memorydata.plugin"), r15), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r16, Comparable.class, "com.obric.memorydata.plugin"), r17), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r18, Comparable.class, "com.obric.memorydata.plugin"), r19), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r20, Comparable.class, "com.obric.memorydata.plugin"), r21), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r22, Comparable.class, "com.obric.memorydata.plugin"), r23), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r24, Comparable.class, "com.obric.memorydata.plugin"), r25)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r11, Object r12, Comparable r13, Object r14, Comparable r15, Object r16, Comparable r17, Object r18, Comparable r19, Object r20, Comparable r21, Object r22, Comparable r23, Object r24, Comparable r25, Object r26, Comparable r27, Object r28) {
        return fromEntries(new Map.Entry[]{entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r11, Comparable.class, "com.obric.memorydata.plugin"), r12), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r13, Comparable.class, "com.obric.memorydata.plugin"), r14), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r15, Comparable.class, "com.obric.memorydata.plugin"), r16), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r17, Comparable.class, "com.obric.memorydata.plugin"), r18), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r19, Comparable.class, "com.obric.memorydata.plugin"), r20), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r21, Comparable.class, "com.obric.memorydata.plugin"), r22), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r23, Comparable.class, "com.obric.memorydata.plugin"), r24), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r25, Comparable.class, "com.obric.memorydata.plugin"), r26), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r27, Comparable.class, "com.obric.memorydata.plugin"), r28)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r12, Object r13, Comparable r14, Object r15, Comparable r16, Object r17, Comparable r18, Object r19, Comparable r20, Object r21, Comparable r22, Object r23, Comparable r24, Object r25, Comparable r26, Object r27, Comparable r28, Object r29, Comparable r30, Object r31) {
        return fromEntries(new Map.Entry[]{entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r12, Comparable.class, "com.obric.memorydata.plugin"), r13), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r14, Comparable.class, "com.obric.memorydata.plugin"), r15), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r16, Comparable.class, "com.obric.memorydata.plugin"), r17), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r18, Comparable.class, "com.obric.memorydata.plugin"), r19), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r20, Comparable.class, "com.obric.memorydata.plugin"), r21), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r22, Comparable.class, "com.obric.memorydata.plugin"), r23), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r24, Comparable.class, "com.obric.memorydata.plugin"), r25), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r26, Comparable.class, "com.obric.memorydata.plugin"), r27), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r28, Comparable.class, "com.obric.memorydata.plugin"), r29), entryOf((Comparable) ZeusTransformUtils.wrapperContextForParams(r30, Comparable.class, "com.obric.memorydata.plugin"), r31)});
    }

    private static <K, V> ImmutableSortedMap<K, V> of(Comparator<? super K> r4, K r5, V r6) {
        Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.of(r5), (Comparator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r7), Comparator.class, "com.obric.memorydata.plugin")), ImmutableList.of(r6));
    }

    public static <K, V> a<K, V> orderedBy(Comparator<K> r2) {
        return new a((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <K extends Comparable<?>, V> a<K, V> reverseOrder() {
        return new a(Ordering.natural().reverse());
    }

    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(Comparator<? super K> r2, Function<? super T, ? extends K> r3, Function<? super T, ? extends V> r4) {
        return n.a((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin"));
    }

    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(Comparator<? super K> r2, Function<? super T, ? extends K> r3, Function<? super T, ? extends V> r4, BinaryOperator<V> r5) {
        return n.a((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin"), (BinaryOperator) ZeusTransformUtils.wrapperContextForParams(r5, BinaryOperator.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K r2) {
        return tailMap(r2, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K r1) {
        return (K) Maps.b(ceilingEntry(r1));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new C1EntrySet(this);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> descendingKeySet() {
        return this.keySet.descendingSet();
    }

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableSet descendingKeySet() {
        return descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> r0 = this.descendingMap;
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (isEmpty() == false) goto L9;
        return emptyMap(Ordering.from(comparator()).reverse());
    L9:
        return new ImmutableSortedMap((RegularImmutableSortedSet) ZeusTransformUtils.preCheckCast(this.keySet.descendingSet(), RegularImmutableSortedSet.class, "com.obric.memorydata.plugin"), this.valueList.reverse(), this);
    }

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap descendingMap() {
        return descendingMap();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
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
        return (Map.Entry) ZeusTransformUtils.preCheckCast(entrySet().asList().get(0), Map.Entry.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K r2) {
        return headMap(r2, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K r1) {
        return (K) Maps.b(floorEntry(r1));
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r5) {
        BiConsumer r6 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r5, BiConsumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r6);
        ImmutableList r0 = this.keySet.asList();
        int r1 = 0;
    L4:
        if (r1 >= size()) goto L6;
        r6.accept(r0.get(r1), this.valueList.get(r1));
        r1 = r1 + 1;
        goto L4
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object r2) {
        int r3 = this.keySet.indexOf(r2);
        if (r3 != (-1)) goto L6;
        return null;
    L6:
        return this.valueList.get(r3);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> headMap(K r2) {
        return headMap(r2, false);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> headMap(K r2, boolean r3) {
        return getSubMap(0, this.keySet.headIndex((K) com.google.common.base.n.a(r2), r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap headMap(Object r1, boolean r2) {
        return headMap(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap headMap(Object r1) {
        return headMap(r1);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K r2) {
        return tailMap(r2, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K r1) {
        return (K) Maps.b(higherEntry(r1));
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        if (this.keySet.isPartialView() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.valueList.isPartialView() == true) goto L8;
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ ImmutableSet keySet() {
        return keySet();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSortedSet<K> keySet() {
        return this.keySet;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return (Map.Entry) ZeusTransformUtils.preCheckCast(entrySet().asList().get(size() - 1), Map.Entry.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K r2) {
        return headMap(r2, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K r1) {
        return (K) Maps.b(lowerEntry(r1));
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.keySet;
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
        return this.valueList.size();
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> subMap(K r3, K r4) {
        return subMap(r3, true, r4, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> subMap(K r3, boolean r4, K r5, boolean r6) {
        com.google.common.base.n.a(r3);
        com.google.common.base.n.a(r5);
        if (comparator().compare(r3, r5) > 0) goto L5;
        boolean r0 = true;
    L6:
        com.google.common.base.n.a(r0, "expected fromKey <= toKey but %s > %s", r3, r5);
        return headMap(r5, r6).tailMap(r3, r4);
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap subMap(Object r1, boolean r2, Object r3, boolean r4) {
        return subMap(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap subMap(Object r1, Object r2) {
        return subMap(r1, r2);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> tailMap(K r2) {
        return tailMap(r2, true);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> tailMap(K r2, boolean r3) {
        return getSubMap(this.keySet.tailIndex((K) com.google.common.base.n.a(r2), r3), size());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap tailMap(Object r1, boolean r2) {
        return tailMap(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap tailMap(Object r1) {
        return tailMap(r1);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.k
    public ImmutableCollection<V> values() {
        return this.valueList;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.k
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new SerializedForm(this);
    }
}
