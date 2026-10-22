package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,697:1\n1#2:698\n*E\n"})
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {
    public static final Companion Companion = null;
    private static final MapBuilder Empty = null;
    private static final int INITIAL_CAPACITY = 8;
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    private static final int MAGIC = -1640531527;
    private static final int TOMBSTONE = -1;
    private MapBuilderEntries<K, V> entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    private K[] keysArray;
    private MapBuilderKeys<K> keysView;
    private int length;
    private int maxProbeDistance;
    private int[] presenceArray;
    private int size;
    private V[] valuesArray;
    private MapBuilderValues<V> valuesView;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ int access$computeHashSize(Companion r10, int r11) {
            return r10.computeHashSize(r11);
        }

        public static final /* synthetic */ int access$computeShift(Companion r10, int r11) {
            return r10.computeShift(r11);
        }

        private final int computeHashSize(int r10) {
            return Integer.highestOneBit(RangesKt.coerceAtLeast(r10, 1) * 3);
        }

        private final int computeShift(int r10) {
            return Integer.numberOfLeadingZeros(r10) + 1;
        }

        public final MapBuilder getEmpty$kotlin_stdlib() {
            return MapBuilder.access$getEmpty$cp();
        }
    }

    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        public EntriesItr(MapBuilder<K, V> r10) {
            Intrinsics.checkNotNullParameter(r10, "map");
            super(r10);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public EntryRef<K, V> next() {
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L7;
            int r10 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r10 + 1);
            setLastIndex$kotlin_stdlib(r10);
            EntryRef<K, V> r11 = new EntryRef(getMap$kotlin_stdlib(), getLastIndex$kotlin_stdlib());
            initNext$kotlin_stdlib();
            return r11;
        L7:
            throw new NoSuchElementException();
        }

        public final void nextAppendString(StringBuilder r10) {
            Intrinsics.checkNotNullParameter(r10, "sb");
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L15;
            int r11 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r11 + 1);
            setLastIndex$kotlin_stdlib(r11);
            Object r12 = MapBuilder.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
            if (Intrinsics.areEqual(r12, getMap$kotlin_stdlib()) == false) goto L7;
            r10.append("(this Map)");
        L8:
            r10.append('=');
            Object[] r13 = MapBuilder.access$getValuesArray$p(getMap$kotlin_stdlib());
            Intrinsics.checkNotNull(r13);
            Object r14 = r13[getLastIndex$kotlin_stdlib()];
            if (Intrinsics.areEqual(r14, getMap$kotlin_stdlib()) == false) goto L11;
            r10.append("(this Map)");
        L12:
            initNext$kotlin_stdlib();
            return;
        L11:
            r10.append(r14);
            goto L12
        L7:
            r10.append(r12);
            goto L8
        L15:
            throw new NoSuchElementException();
        }

        public final int nextHashCode$kotlin_stdlib() {
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L14;
            int r10 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r10 + 1);
            setLastIndex$kotlin_stdlib(r10);
            Object r11 = MapBuilder.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
            int r12 = 0;
            if (r11 == null) goto L7;
            int r13 = r11.hashCode();
        L8:
            Object[] r14 = MapBuilder.access$getValuesArray$p(getMap$kotlin_stdlib());
            Intrinsics.checkNotNull(r14);
            Object r15 = r14[getLastIndex$kotlin_stdlib()];
            if (r15 == null) goto L11;
            r12 = r15.hashCode();
        L11:
            int r16 = r13 ^ r12;
            initNext$kotlin_stdlib();
            return r16;
        L7:
            r13 = 0;
            goto L8
        L14:
            throw new NoSuchElementException();
        }
    }

    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final int index;
        private final MapBuilder<K, V> map;

        public EntryRef(MapBuilder<K, V> r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "map");
            this.map = r10;
            this.index = r11;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L9;
            Map.Entry r11 = (Map.Entry) r10;
            if (Intrinsics.areEqual(r11.getKey(), getKey()) == false) goto L9;
            if (Intrinsics.areEqual(r11.getValue(), getValue()) == false) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) MapBuilder.access$getKeysArray$p(this.map)[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] r10 = MapBuilder.access$getValuesArray$p(this.map);
            Intrinsics.checkNotNull(r10);
            return (V) r10[this.index];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K r10 = getKey();
            int r11 = 0;
            if (r10 == null) goto L5;
            int r12 = r10.hashCode();
        L6:
            V r13 = getValue();
            if (r13 == null) goto L10;
            r11 = r13.hashCode();
        L10:
            return r12 ^ r11;
        L5:
            r12 = 0;
            goto L6
        }

        @Override // java.util.Map.Entry
        public V setValue(V r10) {
            this.map.checkIsMutable$kotlin_stdlib();
            Object[] r11 = MapBuilder.access$allocateValuesArray(this.map);
            int r12 = this.index;
            V r13 = (V) r11[r12];
            r11[r12] = r10;
            return r13;
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append(getKey());
            r10.append('=');
            r10.append(getValue());
            return r10.toString();
        }
    }

    @SourceDebugExtension({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,697:1\n1#2:698\n*E\n"})
    public static class Itr<K, V> {
        private int index;
        private int lastIndex;
        private final MapBuilder<K, V> map;

        public Itr(MapBuilder<K, V> r10) {
            Intrinsics.checkNotNullParameter(r10, "map");
            this.map = r10;
            this.lastIndex = -1;
            initNext$kotlin_stdlib();
        }

        public final int getIndex$kotlin_stdlib() {
            return this.index;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.lastIndex;
        }

        public final MapBuilder<K, V> getMap$kotlin_stdlib() {
            return this.map;
        }

        public final boolean hasNext() {
            if (this.index >= MapBuilder.access$getLength$p(this.map)) goto L5;
            return true;
        L5:
            return false;
        }

        public final void initNext$kotlin_stdlib() {
        L3:
            if (this.index >= MapBuilder.access$getLength$p(this.map)) goto L7;
            int[] r10 = MapBuilder.access$getPresenceArray$p(this.map);
            int r11 = this.index;
            if (r10[r11] >= 0) goto L10;
            this.index = r11 + 1;
            goto L3
        L10:
            return;
        }

        public final void remove() {
            if (this.lastIndex == (-1)) goto L5;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L10;
            this.map.checkIsMutable$kotlin_stdlib();
            MapBuilder.access$removeKeyAt(this.map, this.lastIndex);
            this.lastIndex = -1;
            return;
        L10:
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        L5:
            r10 = false;
            goto L6
        }

        public final void setIndex$kotlin_stdlib(int r10) {
            this.index = r10;
        }

        public final void setLastIndex$kotlin_stdlib(int r10) {
            this.lastIndex = r10;
        }
    }

    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator {
        public KeysItr(MapBuilder<K, V> r10) {
            Intrinsics.checkNotNullParameter(r10, "map");
            super(r10);
        }

        @Override // java.util.Iterator
        public K next() {
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L7;
            int r10 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r10 + 1);
            setLastIndex$kotlin_stdlib(r10);
            K r11 = (K) MapBuilder.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return r11;
        L7:
            throw new NoSuchElementException();
        }
    }

    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMutableIterator {
        public ValuesItr(MapBuilder<K, V> r10) {
            Intrinsics.checkNotNullParameter(r10, "map");
            super(r10);
        }

        @Override // java.util.Iterator
        public V next() {
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L7;
            int r10 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r10 + 1);
            setLastIndex$kotlin_stdlib(r10);
            Object[] r11 = MapBuilder.access$getValuesArray$p(getMap$kotlin_stdlib());
            Intrinsics.checkNotNull(r11);
            V r12 = (V) r11[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return r12;
        L7:
            throw new NoSuchElementException();
        }
    }

    static {
        Companion = new Companion(null);
        MapBuilder r10 = new MapBuilder(0);
        r10.isReadOnly = true;
        Empty = r10;
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int r10) {
        this(ListBuilderKt.arrayOfUninitializedElements(r10), null, new int[r10], new int[Companion.access$computeHashSize(Companion, r10)], 2, 0);
    }

    private MapBuilder(K[] r10, V[] r11, int[] r12, int[] r13, int r14, int r15) {
        this.keysArray = r10;
        this.valuesArray = r11;
        this.presenceArray = r12;
        this.hashArray = r13;
        this.maxProbeDistance = r14;
        this.length = r15;
        this.hashShift = Companion.access$computeShift(Companion, getHashSize());
    }

    public static final /* synthetic */ Object[] access$allocateValuesArray(MapBuilder r10) {
        return r10.allocateValuesArray();
    }

    public static final /* synthetic */ MapBuilder access$getEmpty$cp() {
        return Empty;
    }

    public static final /* synthetic */ Object[] access$getKeysArray$p(MapBuilder r10) {
        return r10.keysArray;
    }

    public static final /* synthetic */ int access$getLength$p(MapBuilder r10) {
        return r10.length;
    }

    public static final /* synthetic */ int[] access$getPresenceArray$p(MapBuilder r10) {
        return r10.presenceArray;
    }

    public static final /* synthetic */ Object[] access$getValuesArray$p(MapBuilder r10) {
        return r10.valuesArray;
    }

    public static final /* synthetic */ void access$removeKeyAt(MapBuilder r10, int r11) {
        r10.removeKeyAt(r11);
    }

    private final V[] allocateValuesArray() {
        V[] r10 = this.valuesArray;
        if (r10 == null) goto L5;
        return r10;
    L5:
        V[] r11 = (V[]) ListBuilderKt.arrayOfUninitializedElements(getCapacity$kotlin_stdlib());
        this.valuesArray = r11;
        return r11;
    }

    private final void compact() {
        V[] r10 = this.valuesArray;
        int r11 = 0;
        int r12 = 0;
    L3:
        int r13 = this.length;
        if (r11 >= r13) goto L12;
        if (this.presenceArray[r11] < 0) goto L11;
        K[] r14 = this.keysArray;
        r14[r12] = r14[r11];
        if (r10 == null) goto L10;
        r10[r12] = r10[r11];
    L10:
        r12 = r12 + 1;
    L11:
        r11 = r11 + 1;
        goto L3
    L12:
        ListBuilderKt.resetRange(this.keysArray, r12, r13);
        if (r10 == null) goto L15;
        ListBuilderKt.resetRange(r10, r12, this.length);
    L15:
        this.length = r12;
    }

    private final boolean contentEquals(Map<?, ?> r10) {
        if (size() == r10.size()) goto L5;
    L7:
        return false;
    L5:
        if (containsAllEntries$kotlin_stdlib(r10.entrySet()) == false) goto L7;
        return true;
    }

    private final void ensureCapacity(int r10) {
        if (r10 < 0) goto L18;
        if (r10 <= getCapacity$kotlin_stdlib()) goto L19;
        int r11 = (getCapacity$kotlin_stdlib() * 3) / 2;
        if (r10 > r11) goto L9;
        r10 = r11;
    L9:
        this.keysArray = (K[]) ListBuilderKt.copyOfUninitializedElements(this.keysArray, r10);
        V[] r12 = this.valuesArray;
        if (r12 == null) goto L12;
        V[] r13 = (V[]) ListBuilderKt.copyOfUninitializedElements(r12, r10);
    L13:
        this.valuesArray = r13;
        int[] r14 = Arrays.copyOf(this.presenceArray, r10);
        Intrinsics.checkNotNullExpressionValue(r14, "copyOf(this, newSize)");
        this.presenceArray = r14;
        int r15 = Companion.access$computeHashSize(Companion, r10);
        if (r15 <= getHashSize()) goto L20;
        rehash(r15);
        return;
    L20:
        return;
    L12:
        r13 = null;
        goto L13
    L19:
        return;
    L18:
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int r10) {
        if (shouldCompact(r10) == false) goto L5;
        rehash(getHashSize());
        return;
    L5:
        ensureCapacity(this.length + r10);
    }

    private final int findKey(K r10) {
        int r11 = hash(r10);
        int r12 = this.maxProbeDistance;
    L3:
        int r13 = this.hashArray[r11];
        if (r13 == 0) goto L5;
        if (r13 <= 0) goto L10;
        int r14 = r13 - 1;
        if (Intrinsics.areEqual(this.keysArray[r14], r10) == false) goto L10;
        return r14;
    L10:
        r12 = r12 - 1;
        if (r12 < 0) goto L12;
        int r15 = r11 - 1;
        if (r11 == 0) goto L15;
        r11 = r15;
        goto L3
    L15:
        r11 = getHashSize() - 1;
        goto L3
    L12:
        return -1;
    L5:
        return -1;
    }

    private final int findValue(V r10) {
        int r11 = this.length;
    L3:
        r11 = r11 - 1;
        if (r11 < 0) goto L10;
        if (this.presenceArray[r11] < 0) goto L3;
        V[] r12 = this.valuesArray;
        Intrinsics.checkNotNull(r12);
        if (Intrinsics.areEqual(r12[r11], r10) == false) goto L3;
        return r11;
    L10:
        return -1;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K r10) {
        if (r10 == null) goto L4;
        int r11 = r10.hashCode();
    L6:
        return (r11 * MAGIC) >>> this.hashShift;
    L4:
        r11 = 0;
        goto L6
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> r10) {
        boolean r11 = false;
        if (r10.isEmpty() == false) goto L5;
        return false;
    L5:
        ensureExtraCapacity(r10.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        if (putEntry(r12.next()) == false) goto L7;
        r11 = true;
        goto L7
    L11:
        return r11;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> r10) {
        int r11 = addKey$kotlin_stdlib(r10.getKey());
        V[] r12 = allocateValuesArray();
        if (r11 < 0) goto L6;
        r12[r11] = r10.getValue();
        return true;
    L6:
        int r13 = (-r11) - 1;
        V r14 = r12[r13];
        if (Intrinsics.areEqual(r10.getValue(), r14) == true) goto L10;
        r12[r13] = r10.getValue();
        return true;
    L10:
        return false;
    }

    private final boolean putRehash(int r10) {
        int r11 = hash(this.keysArray[r10]);
        int r12 = this.maxProbeDistance;
    L3:
        int[] r13 = this.hashArray;
        if (r13[r11] == 0) goto L5;
        r12 = r12 - 1;
        if (r12 < 0) goto L9;
        int r14 = r11 - 1;
        if (r11 == 0) goto L13;
        r11 = r14;
        goto L3
    L13:
        r11 = getHashSize() - 1;
        goto L3
    L9:
        return false;
    L5:
        r13[r11] = r10 + 1;
        this.presenceArray[r10] = r11;
        return true;
    }

    private final void rehash(int r10) {
        if (this.length <= size()) goto L5;
        compact();
    L5:
        int r11 = 0;
        if (r10 == getHashSize()) goto L8;
        this.hashArray = new int[r10];
        this.hashShift = Companion.access$computeShift(Companion, r10);
    L10:
        if (r11 >= this.length) goto L16;
        int r12 = r11 + 1;
        if (putRehash(r11) == false) goto L15;
        r11 = r12;
        goto L10
    L15:
        throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
    L16:
        return;
    L8:
        ArraysKt.fill(this.hashArray, 0, 0, getHashSize());
        goto L10
    }

    private final void removeHashAt(int r10) {
        int r11 = RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
        int r12 = 0;
        int r13 = r10;
    L3:
        int r14 = r10 - 1;
        if (r10 != 0) goto L6;
        r10 = getHashSize() - 1;
    L7:
        r12 = r12 + 1;
        if (r12 > this.maxProbeDistance) goto L9;
        int[] r15 = this.hashArray;
        int r16 = r15[r10];
        if (r16 == 0) goto L13;
        if (r16 >= 0) goto L19;
        r15[r13] = -1;
    L18:
        r13 = r10;
        r12 = 0;
    L22:
        r11 = r11 - 1;
        if (r11 >= 0) goto L3;
        this.hashArray[r13] = -1;
        return;
    L19:
        int r17 = r16 - 1;
        if (((hash(this.keysArray[r17]) - r10) & (getHashSize() - 1)) < r12) goto L22;
        this.hashArray[r13] = r16;
        this.presenceArray[r17] = r13;
        goto L18
    L13:
        r15[r13] = 0;
        return;
    L9:
        this.hashArray[r13] = 0;
        return;
    L6:
        r10 = r14;
        goto L7
    }

    private final void removeKeyAt(int r10) {
        ListBuilderKt.resetAt(this.keysArray, r10);
        removeHashAt(this.presenceArray[r10]);
        this.presenceArray[r10] = -1;
        this.size = size() - 1;
    }

    private final boolean shouldCompact(int r10) {
        int r11 = getCapacity$kotlin_stdlib();
        int r12 = this.length;
        int r13 = r11 - r12;
        int r14 = r12 - size();
        if (r13 < r10) goto L5;
    L9:
        return false;
    L5:
        if ((r13 + r14) < r10) goto L9;
        if (r14 < (getCapacity$kotlin_stdlib() / 4)) goto L9;
        return true;
    }

    private final Object writeReplace() {
        if (this.isReadOnly == false) goto L7;
        return new SerializedMap(this);
    L7:
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final int addKey$kotlin_stdlib(K r10) {
        checkIsMutable$kotlin_stdlib();
    L3:
        int r11 = hash(r10);
        int r12 = RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
        int r13 = 0;
    L4:
        int r14 = this.hashArray[r11];
        if (r14 <= 0) goto L7;
        if (Intrinsics.areEqual(this.keysArray[r14 - 1], r10) == true) goto L16;
        r13 = r13 + 1;
        if (r13 > r12) goto L19;
        int r15 = r11 - 1;
        if (r11 == 0) goto L22;
        r11 = r15;
        goto L4
    L22:
        r11 = getHashSize() - 1;
        goto L4
    L19:
        rehash(getHashSize() * 2);
        goto L3
    L16:
        return -r14;
    L7:
        if (this.length < getCapacity$kotlin_stdlib()) goto L9;
        ensureExtraCapacity(1);
        goto L3
    L9:
        int r16 = this.length;
        int r17 = r16 + 1;
        this.length = r17;
        this.keysArray[r16] = r10;
        this.presenceArray[r16] = r11;
        this.hashArray[r11] = r17;
        this.size = size() + 1;
        if (r13 <= this.maxProbeDistance) goto L12;
        this.maxProbeDistance = r13;
    L12:
        return r16;
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if (size() > 0) goto L7;
        MapBuilder r10 = Empty;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return r10;
    L7:
        return this;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        ?? r10 = new IntRange(0, this.length - 1).iterator2();
    L4:
        if (r10.hasNext() == false) goto L8;
        int r11 = r10.nextInt();
        int[] r12 = this.presenceArray;
        int r13 = r12[r11];
        if (r13 < 0) goto L4;
        this.hashArray[r13] = 0;
        r12[r11] = -1;
        goto L4
    L8:
        ListBuilderKt.resetRange(this.keysArray, 0, this.length);
        V[] r14 = this.valuesArray;
        if (r14 == null) goto L11;
        ListBuilderKt.resetRange(r14, 0, this.length);
    L11:
        this.size = 0;
        this.length = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "m");
        Iterator<?> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r12 = r11.next();
        if (r12 == null) goto L9;
        if (containsEntry$kotlin_stdlib((Map.Entry) r12) == true) goto L4;
    L9:
        return false;
    L10:
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "entry");
        int r11 = findKey(r10.getKey());
        if (r11 >= 0) goto L6;
        return false;
    L6:
        V[] r12 = this.valuesArray;
        Intrinsics.checkNotNull(r12);
        return Intrinsics.areEqual(r12[r11], r10.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object r10) {
        if (findKey(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object r10) {
        if (findValue(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object r10) {
        if (r10 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r10 instanceof Map) == true) goto L6;
    L8:
        return false;
    L6:
        if (contentEquals((Map) r10) == false) goto L8;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object r10) {
        int r11 = findKey(r10);
        if (r11 >= 0) goto L6;
        return null;
    L6:
        V[] r12 = this.valuesArray;
        Intrinsics.checkNotNull(r12);
        return r12[r11];
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries<K, V> r10 = this.entriesView;
        if (r10 != null) goto L6;
        MapBuilderEntries<K, V> r11 = new MapBuilderEntries(this);
        this.entriesView = r11;
        return r11;
    L6:
        return r10;
    }

    public Set<K> getKeys() {
        MapBuilderKeys<K> r10 = this.keysView;
        if (r10 != null) goto L6;
        MapBuilderKeys<K> r11 = new MapBuilderKeys(this);
        this.keysView = r11;
        return r11;
    L6:
        return r10;
    }

    public int getSize() {
        return this.size;
    }

    public Collection<V> getValues() {
        MapBuilderValues<V> r10 = this.valuesView;
        if (r10 != null) goto L6;
        MapBuilderValues<V> r11 = new MapBuilderValues(this);
        this.valuesView = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // java.util.Map
    public int hashCode() {
        EntriesItr<K, V> r10 = entriesIterator$kotlin_stdlib();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = r11 + r10.nextHashCode$kotlin_stdlib();
        goto L4
    L6:
        return r11;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr(this);
    }

    @Override // java.util.Map
    public V put(K r10, V r11) {
        checkIsMutable$kotlin_stdlib();
        int r12 = addKey$kotlin_stdlib(r10);
        V[] r13 = allocateValuesArray();
        if (r12 >= 0) goto L6;
        int r14 = (-r12) - 1;
        V r15 = r13[r14];
        r13[r14] = r11;
        return r15;
    L6:
        r13[r12] = r11;
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(r10.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object r10) {
        int r11 = removeKey$kotlin_stdlib(r10);
        if (r11 >= 0) goto L6;
        return null;
    L6:
        V[] r12 = this.valuesArray;
        Intrinsics.checkNotNull(r12);
        V r13 = r12[r11];
        ListBuilderKt.resetAt(r12, r11);
        return r13;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "entry");
        checkIsMutable$kotlin_stdlib();
        int r11 = findKey(r10.getKey());
        if (r11 >= 0) goto L5;
        return false;
    L5:
        V[] r12 = this.valuesArray;
        Intrinsics.checkNotNull(r12);
        if (Intrinsics.areEqual(r12[r11], r10.getValue()) == true) goto L8;
        return false;
    L8:
        removeKeyAt(r11);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K r10) {
        checkIsMutable$kotlin_stdlib();
        int r11 = findKey(r10);
        if (r11 >= 0) goto L6;
        return -1;
    L6:
        removeKeyAt(r11);
        return r11;
    }

    public final boolean removeValue$kotlin_stdlib(V r10) {
        checkIsMutable$kotlin_stdlib();
        int r11 = findValue(r10);
        if (r11 >= 0) goto L6;
        return false;
    L6:
        removeKeyAt(r11);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder((size() * 3) + 2);
        r10.append("{");
        EntriesItr<K, V> r11 = entriesIterator$kotlin_stdlib();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        if (r12 <= 0) goto L7;
        r10.append(", ");
    L7:
        r11.nextAppendString(r10);
        r12 = r12 + 1;
        goto L4
    L8:
        r10.append("}");
        String r13 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "sb.toString()");
        return r13;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr(this);
    }
}
