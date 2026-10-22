package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
class CompactLinkedHashSet<E> extends CompactHashSet<E> {
    public transient int[] e;
    public transient int[] f;
    public transient int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient int f8799h;

    public CompactLinkedHashSet() {
    }

    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet();
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int r5) {
        return new CompactLinkedHashSet(r5);
    }

    @Override // com.google.common.collect.CompactHashSet
    public int adjustAfterRemove(int r5, int r10) {
        if (r5 >= size()) goto L5;
        return r5;
    L5:
        return r10;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int allocArrays() {
        int r5 = super.allocArrays();
        this.e = new int[r5];
        this.f = new int[r5];
        return r5;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        this.g = -2;
        this.f8799h = -2;
        int[] r5 = this.e;
        if (r5 != null) goto L8;
    L10:
        super.clear();
        return;
    L8:
        if (this.f == null) goto L10;
        Arrays.fill(r5, 0, size(), 0);
        Arrays.fill(this.f, 0, size(), 0);
        goto L10
    }

    @Override // com.google.common.collect.CompactHashSet
    public Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> r5 = super.convertToHashFloodingResistantImplementation();
        this.e = null;
        this.f = null;
        return r5;
    }

    public final void f(int r5, int r10) {
        if (r5 != (-2)) goto L5;
        this.g = r10;
    L6:
        if (r10 != (-2)) goto L8;
        this.f8799h = r5;
        return;
    L8:
        int[] r11 = this.e;
        Objects.requireNonNull(r11);
        r11[r10] = r5 + 1;
        return;
    L5:
        int[] r12 = this.f;
        Objects.requireNonNull(r12);
        r12[r5] = r10 + 1;
        goto L6
    }

    @Override // com.google.common.collect.CompactHashSet
    public int firstEntryIndex() {
        return this.g;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int getSuccessor(int r5) {
        int[] r10 = this.f;
        Objects.requireNonNull(r10);
        return r10[r5] - 1;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void init(int r5) {
        super.init(r5);
        this.g = -2;
        this.f8799h = -2;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void insertEntry(int r5, E r10, int r11, int r12) {
        super.insertEntry(r5, r10, r11, r12);
        f(this.f8799h, r5);
        f(r5, -2);
    }

    @Override // com.google.common.collect.CompactHashSet
    public void moveLastEntry(int r5, int r10) {
        int r11 = size() - 1;
        super.moveLastEntry(r5, r10);
        int[] r12 = this.e;
        Objects.requireNonNull(r12);
        f(r12[r5] - 1, getSuccessor(r5));
        if (r5 >= r11) goto L5;
        int[] r13 = this.e;
        Objects.requireNonNull(r13);
        f(r13[r11] - 1, r5);
        f(r5, getSuccessor(r11));
    L5:
        int[] r14 = this.e;
        Objects.requireNonNull(r14);
        r14[r11] = 0;
        int[] r15 = this.f;
        Objects.requireNonNull(r15);
        r15[r11] = 0;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void resizeEntries(int r5) {
        super.resizeEntries(r5);
        int[] r10 = this.e;
        Objects.requireNonNull(r10);
        this.e = Arrays.copyOf(r10, r5);
        int[] r11 = this.f;
        Objects.requireNonNull(r11);
        this.f = Arrays.copyOf(r11, r5);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, 17);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] r5 = new Object[size()];
        p7.C(this, r5);
        return r5;
    }

    public CompactLinkedHashSet(int r5) {
        super(r5);
    }

    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> r5) {
        CompactLinkedHashSet<E> r10 = createWithExpectedSize(r5.size());
        r10.addAll(r5);
        return r10;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] r5) {
        return (T[]) p7.s0(this, r5);
    }

    @SafeVarargs
    public static <E> CompactLinkedHashSet<E> create(E... r5) {
        CompactLinkedHashSet<E> r10 = createWithExpectedSize(r5.length);
        Collections.addAll(r10, r5);
        return r10;
    }
}
