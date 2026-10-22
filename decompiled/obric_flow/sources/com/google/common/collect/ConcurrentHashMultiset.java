package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final class ConcurrentHashMultiset<E> extends j0 implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient ConcurrentMap f8800c;

    public ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> r5) {
        com.google.common.base.b0.h("the backing map (%s) must be empty", r5.isEmpty(), r5);
        this.f8800c = r5;
    }

    public static /* synthetic */ ConcurrentMap access$100(ConcurrentHashMultiset r5) {
        return r5.f8800c;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset(new ConcurrentHashMap());
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        ConcurrentMap r10 = (ConcurrentMap) r5.readObject();
        j2.f9035a.a(this, r10);
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        r5.writeObject(this.f8800c);
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public int add(E r10, int r11) {
        r10.getClass();
        if (r11 == 0) goto L5;
        p7.s(r11);
    L7:
        ConcurrentMap r5 = this.f8800c;
        AtomicInteger r12 = (AtomicInteger) p7.l0(r5, r10);
        if (r12 != null) goto L12;
        r12 = (AtomicInteger) r5.putIfAbsent(r10, new AtomicInteger(r11));
        if (r12 != null) goto L12;
        return 0;
    L12:
        int r13 = r12.get();
        if (r13 == 0) goto L23;
        long r14 = ((long) r13) + ((long) r11);
        int r15 = (int) r14;
        if (r14 != r15) goto L17;
        boolean r16 = true;
    L28:
        com.lynx.tasm.utils.j.l("checkedAdd", r13, r11, r16);     // Catch: ArithmeticException -> L21
        if (r12.compareAndSet(r13, r15) == false) goto L12;
        return r13;
    L21:
        StringBuilder r17 = new StringBuilder(65);
        r17.append("Overflow adding ");
        r17.append(r11);
        r17.append(" occurrences to a count of ");
        r17.append(r13);
        throw new IllegalArgumentException(r17.toString());
    L17:
        r16 = false;
        goto L28
    L23:
        AtomicInteger r18 = new AtomicInteger(r11);
        if (r5.putIfAbsent(r10, r18) == null) goto L27;
        if (r5.replace(r10, r12, r18) == false) goto L7;
    L27:
        return 0;
    L5:
        return count(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList b() {
        int r5 = size();
        p7.q(r5, "arraySize");
        ArrayList r10 = new ArrayList(dn.a.U((((long) r5) + 5) + ((long) (r5 / 10))));
        Iterator<E> r11 = entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        y7 r12 = (y7) r11.next();
        Object r13 = r12.getElement();
        int r14 = r12.getCount();
    L6:
        if (r14 <= 0) goto L4;
        r10.add(r13);
        r14 = r14 - 1;
        goto L6
    L8:
        return r10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f8800c.clear();
    }

    @Override // com.google.common.collect.j0, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean contains(Object r5) {
        return super.contains(r5);
    }

    @Override // com.google.common.collect.z7
    public int count(Object r5) {
        AtomicInteger r10 = (AtomicInteger) p7.l0(this.f8800c, r5);
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.get();
    }

    @Override // com.google.common.collect.j0
    public Set<E> createElementSet() {
        return new d(this.f8800c.keySet(), 1);
    }

    @Override // com.google.common.collect.j0
    @Deprecated
    public Set<y7> createEntrySet() {
        return new i2(this);
    }

    @Override // com.google.common.collect.j0
    public int distinctElements() {
        return this.f8800c.size();
    }

    @Override // com.google.common.collect.j0
    public Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.j0
    public Iterator<y7> entryIterator() {
        return new h2(this, new g2(this));
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEach(Consumer r5) {
        super.forEach(r5);
    }

    @Override // com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer r5) {
        super.forEachEntry(r5);
    }

    @Override // com.google.common.collect.j0, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f8800c.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return p7.O(this);
    }

    @Override // com.google.common.collect.z7
    public int remove(Object r10, int r11) {
        if (r11 == 0) goto L4;
        p7.s(r11);
        ConcurrentMap r5 = this.f8800c;
        AtomicInteger r12 = (AtomicInteger) p7.l0(r5, r10);
        if (r12 != null) goto L8;
        return 0;
    L8:
        int r13 = r12.get();
        if (r13 == 0) goto L15;
        int r14 = Math.max(0, r13 - r11);
        if (r12.compareAndSet(r13, r14) == false) goto L8;
        if (r14 != 0) goto L14;
        r5.remove(r10, r12);
    L14:
        return r13;
    L15:
        return 0;
    L4:
        return count(r10);
    }

    public boolean removeExactly(Object r10, int r11) {
        if (r11 != 0) goto L5;
        return true;
    L5:
        p7.s(r11);
        ConcurrentMap r5 = this.f8800c;
        AtomicInteger r12 = (AtomicInteger) p7.l0(r5, r10);
        if (r12 != null) goto L8;
        return false;
    L8:
        int r13 = r12.get();
        if (r13 < r11) goto L10;
        int r14 = r13 - r11;
        if (r12.compareAndSet(r13, r14) == false) goto L8;
        if (r14 != 0) goto L15;
        r5.remove(r10, r12);
    L15:
        return true;
    L10:
        return false;
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public int setCount(E r10, int r11) {
        r10.getClass();
        p7.q(r11, "count");
    L3:
        ConcurrentMap r5 = this.f8800c;
        AtomicInteger r12 = (AtomicInteger) p7.l0(r5, r10);
        if (r12 != null) goto L10;
        if (r11 == 0) goto L6;
        r12 = (AtomicInteger) r5.putIfAbsent(r10, new AtomicInteger(r11));
        if (r12 != null) goto L10;
        return 0;
    L6:
        return 0;
    L10:
        int r13 = r12.get();
        if (r13 == 0) goto L12;
        if (r12.compareAndSet(r13, r11) == false) goto L10;
        if (r11 != 0) goto L23;
        r5.remove(r10, r12);
    L23:
        return r13;
    L12:
        if (r11 == 0) goto L13;
        AtomicInteger r14 = new AtomicInteger(r11);
        if (r5.putIfAbsent(r10, r14) == null) goto L18;
        if (r5.replace(r10, r12, r14) == false) goto L3;
    L18:
        return 0;
    L13:
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        Iterator<E> r5 = this.f8800c.values().iterator();
        long r10 = 0;
    L4:
        if (r5.hasNext() == false) goto L7;
        r10 = r10 + ((long) ((AtomicInteger) r5.next()).get());
        goto L4
    L7:
        return dn.a.U(r10);
    }

    @Override // java.util.Collection, java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return super.spliterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return b().toArray();
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> r5) {
        ConcurrentHashMultiset<E> r10 = create();
        p7.i(r10, r5);
        return r10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] r5) {
        return (T[]) b().toArray(r5);
    }

    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> r5) {
        return new ConcurrentHashMultiset(r5);
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public boolean setCount(E r5, int r10, int r11) {
        r5.getClass();
        p7.q(r10, "oldCount");
        p7.q(r11, "newCount");
        ConcurrentMap r12 = this.f8800c;
        AtomicInteger r13 = (AtomicInteger) p7.l0(r12, r5);
        if (r13 != null) goto L12;
        if (r10 == 0) goto L6;
        return false;
    L6:
        if (r11 != 0) goto L9;
        return true;
    L9:
        if (r12.putIfAbsent(r5, new AtomicInteger(r11)) == null) goto L11;
        return false;
    L11:
        return true;
    L12:
        int r14 = r13.get();
        if (r14 != r10) goto L29;
        if (r14 != 0) goto L25;
        if (r11 != 0) goto L18;
        r12.remove(r5, r13);
        return true;
    L18:
        AtomicInteger r15 = new AtomicInteger(r11);
        if (r12.putIfAbsent(r5, r15) == null) goto L23;
        if (r12.replace(r5, r13, r15) == true) goto L23;
        return false;
    L23:
        return true;
    L25:
        if (r13.compareAndSet(r14, r11) == false) goto L29;
        if (r11 != 0) goto L28;
        r12.remove(r5, r13);
    L28:
        return true;
    L29:
        return false;
    }
}
