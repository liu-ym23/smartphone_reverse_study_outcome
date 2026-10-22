package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private final boolean accessOrder;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient int f8797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient int f8798i;
    transient long[] links;

    public CompactLinkedHashMap() {
        this(3);
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int r5) {
        return new CompactLinkedHashMap(r5);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void accessEntry(int r5) {
        if (this.accessOrder == false) goto L6;
        i(((int) (h()[r5] >>> 32)) - 1, getSuccessor(r5));
        i(this.f8798i, r5);
        i(r5, -2);
        incrementModCount();
        return;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int adjustAfterRemove(int r5, int r10) {
        if (r5 >= size()) goto L5;
        return r5;
    L5:
        return r10;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int allocArrays() {
        int r5 = super.allocArrays();
        this.links = new long[r5];
        return r5;
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        this.f8797h = -2;
        this.f8798i = -2;
        long[] r5 = this.links;
        if (r5 == null) goto L8;
        Arrays.fill(r5, 0, size(), 0);
    L8:
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashMap
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> r5 = super.convertToHashFloodingResistantImplementation();
        this.links = null;
        return r5;
    }

    @Override // com.google.common.collect.CompactHashMap
    public Set<Map.Entry<K, V>> createEntrySet() {
        return new a2(1, this);
    }

    @Override // com.google.common.collect.CompactHashMap
    public Map<K, V> createHashFloodingResistantDelegate(int r5) {
        return new LinkedHashMap(r5, 1.0f, this.accessOrder);
    }

    @Override // com.google.common.collect.CompactHashMap
    public Set<K> createKeySet() {
        return new b2(this, 1);
    }

    @Override // com.google.common.collect.CompactHashMap
    public Collection<V> createValues() {
        return new c2(this, 0);
    }

    @Override // com.google.common.collect.CompactHashMap
    public int firstEntryIndex() {
        return this.f8797h;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int getSuccessor(int r5) {
        return ((int) h()[r5]) - 1;
    }

    public final long[] h() {
        long[] r5 = this.links;
        Objects.requireNonNull(r5);
        return r5;
    }

    public final void i(int r10, int r11) {
        if (r10 != (-2)) goto L5;
        this.f8797h = r11;
    L6:
        if (r11 != (-2)) goto L8;
        this.f8798i = r10;
        return;
    L8:
        long r5 = (4294967295L & h()[r11]) | (((long) (r10 + 1)) << 32);
        h()[r11] = r5;
        return;
    L5:
        long r12 = (h()[r10] & (-4294967296L)) | (((long) (r11 + 1)) & 4294967295L);
        h()[r10] = r12;
        goto L6
    }

    @Override // com.google.common.collect.CompactHashMap
    public void init(int r5) {
        super.init(r5);
        this.f8797h = -2;
        this.f8798i = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void insertEntry(int r5, K r10, V r11, int r12, int r13) {
        super.insertEntry(r5, r10, r11, r12, r13);
        i(this.f8798i, r5);
        i(r5, -2);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void moveLastEntry(int r5, int r10) {
        int r11 = size() - 1;
        super.moveLastEntry(r5, r10);
        i(((int) (h()[r5] >>> 32)) - 1, getSuccessor(r5));
        if (r5 >= r11) goto L5;
        i(((int) (h()[r11] >>> 32)) - 1, r5);
        i(r5, getSuccessor(r11));
    L5:
        h()[r11] = 0;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void resizeEntries(int r5) {
        super.resizeEntries(r5);
        this.links = Arrays.copyOf(h(), r5);
    }

    public CompactLinkedHashMap(int r5) {
        this(r5, false);
    }

    public CompactLinkedHashMap(int r5, boolean r10) {
        super(r5);
        this.accessOrder = r10;
    }
}
