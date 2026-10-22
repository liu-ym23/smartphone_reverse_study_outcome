package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private static final int ENDPOINT = -2;
    private final boolean accessOrder;
    private transient int firstEntry;
    private transient int lastEntry;
    transient long[] links;

    class a extends CompactHashMap<K, V>.a {
        a(CompactLinkedHashMap r1) {
            super(r1);
        }

        @Override // com.google.common.collect.CompactHashMap.a, java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<Map.Entry<K, V>> spliterator() {
            return Spliterators.spliterator(this, 17);
        }
    }

    class b extends CompactHashMap<K, V>.c {
        b(CompactLinkedHashMap r1) {
            super(r1);
        }

        @Override // com.google.common.collect.CompactHashMap.c, java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<K> spliterator() {
            return Spliterators.spliterator(this, 17);
        }

        @Override // com.google.common.collect.CompactHashMap.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return ap.a(this);
        }

        @Override // com.google.common.collect.CompactHashMap.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r1) {
            return (T[]) ap.a(this, r1);
        }
    }

    class c extends CompactHashMap<K, V>.e {
        c(CompactLinkedHashMap r1) {
            super(r1);
        }

        @Override // com.google.common.collect.CompactHashMap.e, java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            return Spliterators.spliterator(this, 16);
        }

        @Override // com.google.common.collect.CompactHashMap.e, java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return ap.a(this);
        }

        @Override // com.google.common.collect.CompactHashMap.e, java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] r1) {
            return (T[]) ap.a(this, r1);
        }
    }

    CompactLinkedHashMap() {
        this(3);
    }

    CompactLinkedHashMap(int r2) {
        this(r2, false);
    }

    CompactLinkedHashMap(int r1, boolean r2) {
        super(r1);
        this.accessOrder = r2;
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int r1) {
        return new CompactLinkedHashMap(r1);
    }

    private int getPredecessor(int r2) {
        return ((int) (link(r2) >>> 32)) - 1;
    }

    private long link(int r1) {
        return requireLinks()[r1];
    }

    private long[] requireLinks() {
        return (long[]) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.links), long[].class, "com.obric.memorydata.plugin");
    }

    private void setLink(int r1, long r2) {
        requireLinks()[r1] = r2;
    }

    private void setPredecessor(int r5, int r6) {
        setLink(r5, (link(r5) & 4294967295L) | (((long) (r6 + 1)) << 32));
    }

    private void setSucceeds(int r2, int r3) {
        if (r2 != (-2)) goto L5;
        this.firstEntry = r3;
    L6:
        if (r3 != (-2)) goto L8;
        this.lastEntry = r2;
        return;
    L8:
        setPredecessor(r3, r2);
        return;
    L5:
        setSuccessor(r2, r3);
        goto L6
    }

    private void setSuccessor(int r7, int r8) {
        setLink(r7, (link(r7) & (-4294967296L)) | (((long) (r8 + 1)) & 4294967295L));
    }

    @Override // com.google.common.collect.CompactHashMap
    void accessEntry(int r3) {
        if (this.accessOrder == false) goto L6;
        setSucceeds(getPredecessor(r3), getSuccessor(r3));
        setSucceeds(this.lastEntry, r3);
        setSucceeds(r3, -2);
        incrementModCount();
        return;
    }

    @Override // com.google.common.collect.CompactHashMap
    int adjustAfterRemove(int r1, int r2) {
        if (r1 >= size()) goto L5;
        return r1;
    L5:
        return r2;
    }

    @Override // com.google.common.collect.CompactHashMap
    int allocArrays() {
        int r0 = super.allocArrays();
        this.links = new long[r0];
        return r0;
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        this.firstEntry = -2;
        this.lastEntry = -2;
        long[] r0 = this.links;
        if (r0 == null) goto L8;
        Arrays.fill(r0, 0, size(), 0);
    L8:
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashMap
    Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> r0 = super.convertToHashFloodingResistantImplementation();
        this.links = null;
        return r0;
    }

    @Override // com.google.common.collect.CompactHashMap
    Set<Map.Entry<K, V>> createEntrySet() {
        return new a(this);
    }

    @Override // com.google.common.collect.CompactHashMap
    Map<K, V> createHashFloodingResistantDelegate(int r3) {
        return new LinkedHashMap(r3, 1.0f, this.accessOrder);
    }

    @Override // com.google.common.collect.CompactHashMap
    Set<K> createKeySet() {
        return new b(this);
    }

    @Override // com.google.common.collect.CompactHashMap
    Collection<V> createValues() {
        return new c(this);
    }

    @Override // com.google.common.collect.CompactHashMap
    int firstEntryIndex() {
        return this.firstEntry;
    }

    @Override // com.google.common.collect.CompactHashMap
    int getSuccessor(int r1) {
        return ((int) link(r1)) - 1;
    }

    @Override // com.google.common.collect.CompactHashMap
    void init(int r1) {
        super.init(r1);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    void insertEntry(int r1, K r2, V r3, int r4, int r5) {
        super.insertEntry(r1, r2, r3, r4, r5);
        setSucceeds(this.lastEntry, r1);
        setSucceeds(r1, -2);
    }

    @Override // com.google.common.collect.CompactHashMap
    void moveLastEntry(int r3, int r4) {
        int r0 = size() - 1;
        super.moveLastEntry(r3, r4);
        setSucceeds(getPredecessor(r3), getSuccessor(r3));
        if (r3 >= r0) goto L5;
        setSucceeds(getPredecessor(r0), r3);
        setSucceeds(r3, getSuccessor(r0));
    L5:
        setLink(r0, 0);
    }

    @Override // com.google.common.collect.CompactHashMap
    void resizeEntries(int r2) {
        super.resizeEntries(r2);
        this.links = Arrays.copyOf(requireLinks(), r2);
    }
}
