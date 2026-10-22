package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
class CompactLinkedHashSet<E> extends CompactHashSet<E> {
    private static final int ENDPOINT = -2;
    private transient int firstEntry;
    private transient int lastEntry;
    private transient int[] predecessor;
    private transient int[] successor;

    CompactLinkedHashSet() {
    }

    CompactLinkedHashSet(int r1) {
        super(r1);
    }

    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet();
    }

    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        CompactLinkedHashSet<E> r0 = createWithExpectedSize(r3.size());
        r0.addAll(r3);
        return r0;
    }

    @SafeVarargs
    public static <E> CompactLinkedHashSet<E> create(E... r1) {
        CompactLinkedHashSet<E> r0 = createWithExpectedSize(r1.length);
        Collections.addAll(r0, r1);
        return r0;
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int r1) {
        return new CompactLinkedHashSet(r1);
    }

    private int getPredecessor(int r1) {
        return requirePredecessors()[r1] - 1;
    }

    private int[] requirePredecessors() {
        return (int[]) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.predecessor), int[].class, "com.obric.memorydata.plugin");
    }

    private int[] requireSuccessors() {
        return (int[]) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.successor), int[].class, "com.obric.memorydata.plugin");
    }

    private void setPredecessor(int r1, int r2) {
        requirePredecessors()[r1] = r2 + 1;
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

    private void setSuccessor(int r1, int r2) {
        requireSuccessors()[r1] = r2 + 1;
    }

    @Override // com.google.common.collect.CompactHashSet
    int adjustAfterRemove(int r1, int r2) {
        if (r1 >= size()) goto L5;
        return r1;
    L5:
        return r2;
    }

    @Override // com.google.common.collect.CompactHashSet
    int allocArrays() {
        int r0 = super.allocArrays();
        this.predecessor = new int[r0];
        this.successor = new int[r0];
        return r0;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        this.firstEntry = -2;
        this.lastEntry = -2;
        int[] r0 = this.predecessor;
        if (r0 != null) goto L8;
    L10:
        super.clear();
        return;
    L8:
        if (this.successor == null) goto L10;
        Arrays.fill(r0, 0, size(), 0);
        Arrays.fill(this.successor, 0, size(), 0);
        goto L10
    }

    @Override // com.google.common.collect.CompactHashSet
    Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> r0 = super.convertToHashFloodingResistantImplementation();
        this.predecessor = null;
        this.successor = null;
        return r0;
    }

    @Override // com.google.common.collect.CompactHashSet
    int firstEntryIndex() {
        return this.firstEntry;
    }

    @Override // com.google.common.collect.CompactHashSet
    int getSuccessor(int r1) {
        return requireSuccessors()[r1] - 1;
    }

    @Override // com.google.common.collect.CompactHashSet
    void init(int r1) {
        super.init(r1);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.CompactHashSet
    void insertEntry(int r1, E r2, int r3, int r4) {
        super.insertEntry(r1, r2, r3, r4);
        setSucceeds(this.lastEntry, r1);
        setSucceeds(r1, -2);
    }

    @Override // com.google.common.collect.CompactHashSet
    void moveLastEntry(int r3, int r4) {
        int r0 = size() - 1;
        super.moveLastEntry(r3, r4);
        setSucceeds(getPredecessor(r3), getSuccessor(r3));
        if (r3 >= r0) goto L5;
        setSucceeds(getPredecessor(r0), r3);
        setSucceeds(r3, getSuccessor(r0));
    L5:
        requirePredecessors()[r0] = 0;
        requireSuccessors()[r0] = 0;
    }

    @Override // com.google.common.collect.CompactHashSet
    void resizeEntries(int r2) {
        super.resizeEntries(r2);
        this.predecessor = Arrays.copyOf(requirePredecessors(), r2);
        this.successor = Arrays.copyOf(requireSuccessors(), r2);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, 17);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return ap.a(this);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] r1) {
        return (T[]) ap.a(this, r1);
    }
}
