package com.google.common.collect;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Object f8794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int[] f8795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f8796c;
    public transient int d;
    transient Object[] elements;

    public CompactHashSet() {
        init(3);
    }

    public static /* synthetic */ int access$000(CompactHashSet r5) {
        return r5.f8796c;
    }

    public static Object access$100(CompactHashSet r5, int r10) {
        return r5.c()[r10];
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet();
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int r5) {
        return new CompactHashSet(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        int r10 = r5.readInt();
        if (r10 < 0) goto L9;
        init(r10);
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L7;
        add(r5.readObject());
        r11 = r11 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new InvalidObjectException(androidx.constraintlayout.motion.widget.a.i(25, "Invalid size: ", r10));
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        r5.writeInt(size());
        Iterator<E> r10 = iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r5.writeObject(r10.next());
        goto L4
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E r15) {
        if (needsAllocArrays() == false) goto L5;
        allocArrays();
    L5:
        Set<E> r5 = delegateOrNull();
        if (r5 != null) goto L8;
        int[] r10 = d();
        Object[] r11 = c();
        int r12 = this.d;
        int r13 = r12 + 1;
        int r14 = p7.o0(r15);
        int r16 = b();
        int r17 = r14 & r16;
        Object r18 = this.f8794a;
        Objects.requireNonNull(r18);
        int r19 = p7.p0(r17, r18);
        if (r19 != 0) goto L14;
        if (r13 <= r16) goto L13;
        r16 = e(r16, p7.W(r16), r14, r12);
    L29:
        int r20 = d().length;
        if (r13 <= r20) goto L34;
        int r21 = Math.min(1073741823, (Math.max(1, r20 >>> 1) + r20) | 1);
        if (r21 == r20) goto L34;
        resizeEntries(r21);
    L34:
        insertEntry(r12, r15, r14, r16);
        this.d = r13;
        incrementModCount();
        return true;
    L13:
        Object r22 = this.f8794a;
        Objects.requireNonNull(r22);
        p7.q0(r17, r13, r22);
        goto L29
    L14:
        int r23 = ~r16;
        int r24 = r14 & r23;
        int r110 = 0;
    L15:
        int r25 = r19 - 1;
        int r111 = r10[r25];
        if ((r111 & r23) == r24) goto L18;
    L20:
        int r112 = r111 & r16;
        r110 = r110 + 1;
        if (r112 == 0) goto L23;
        r19 = r112;
        goto L15
    L23:
        if (r110 >= 9) goto L25;
        if (r13 <= r16) goto L28;
        r16 = e(r16, p7.W(r16), r14, r12);
        goto L29
    L28:
        r10[r25] = p7.S(r111, r13, r16);
        goto L29
    L25:
        return convertToHashFloodingResistantImplementation().add(r15);
    L18:
        if (com.google.common.base.b0.w(r15, r11[r25]) == false) goto L20;
        return false;
    L8:
        return r5.add(r15);
    }

    public int adjustAfterRemove(int r5, int r10) {
        return r5 - 1;
    }

    public int allocArrays() {
        com.google.common.base.b0.u(needsAllocArrays(), "Arrays already allocated");
        int r5 = this.f8796c;
        int r10 = p7.r0(r5);
        this.f8794a = p7.y(r10);
        this.f8796c = p7.S(this.f8796c, 32 - Integer.numberOfLeadingZeros(r10 - 1), 31);
        this.f8795b = new int[r5];
        this.elements = new Object[r5];
        return r5;
    }

    public final int b() {
        return (1 << (this.f8796c & 31)) - 1;
    }

    public final Object[] c() {
        Object[] r5 = this.elements;
        Objects.requireNonNull(r5);
        return r5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        incrementModCount();
        Set<E> r5 = delegateOrNull();
        if (r5 == null) goto L8;
        this.f8796c = dn.a.P(size(), 3);
        r5.clear();
        this.f8794a = null;
        this.d = 0;
        return;
    L8:
        Arrays.fill(c(), 0, this.d, null);
        Object r10 = this.f8794a;
        Objects.requireNonNull(r10);
        if ((r10 instanceof byte[]) == false) goto L12;
        Arrays.fill((byte[]) r10, (byte) 0);
    L15:
        Arrays.fill(d(), 0, this.d, 0);
        this.d = 0;
        return;
    L12:
        if ((r10 instanceof short[]) == false) goto L14;
        Arrays.fill((short[]) r10, 0);
        goto L15
    L14:
        Arrays.fill((int[]) r10, 0);
        goto L15
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r10) {
        if (needsAllocArrays() == false) goto L5;
        return false;
    L5:
        Set<E> r5 = delegateOrNull();
        if (r5 != null) goto L8;
        int r11 = p7.o0(r10);
        int r12 = b();
        Object r13 = this.f8794a;
        Objects.requireNonNull(r13);
        int r14 = p7.p0(r11 & r12, r13);
        if (r14 != 0) goto L12;
        return false;
    L12:
        int r15 = ~r12;
        int r16 = r11 & r15;
    L13:
        int r17 = r14 - 1;
        int r18 = d()[r17];
        if ((r18 & r15) == r16) goto L16;
    L18:
        r14 = r18 & r12;
        if (r14 != 0) goto L13;
        return false;
    L16:
        if (com.google.common.base.b0.w(r10, c()[r17]) == false) goto L18;
        return true;
    L8:
        return r5.contains(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Set<E> convertToHashFloodingResistantImplementation() {
        LinkedHashSet r5 = new LinkedHashSet(b() + 1, 1.0f);
        int r10 = firstEntryIndex();
    L3:
        if (r10 < 0) goto L5;
        r5.add(c()[r10]);
        r10 = getSuccessor(r10);
        goto L3
    L5:
        this.f8794a = r5;
        this.f8795b = null;
        this.elements = null;
        incrementModCount();
        return r5;
    }

    public final int[] d() {
        int[] r5 = this.f8795b;
        Objects.requireNonNull(r5);
        return r5;
    }

    public Set<E> delegateOrNull() {
        Object r5 = this.f8794a;
        if ((r5 instanceof Set) == true) goto L5;
        return null;
    L5:
        return (Set) r5;
    }

    public final int e(int r10, int r11, int r12, int r13) {
        Object r5 = p7.y(r11);
        int r14 = r11 - 1;
        if (r13 == 0) goto L5;
        p7.q0(r12 & r14, r13 + 1, r5);
    L5:
        Object r15 = this.f8794a;
        Objects.requireNonNull(r15);
        int[] r16 = d();
        int r17 = 0;
    L6:
        if (r17 > r10) goto L11;
        int r18 = p7.p0(r17, r15);
    L8:
        if (r18 == 0) goto L10;
        int r19 = r18 - 1;
        int r20 = r16[r19];
        int r21 = ((~r10) & r20) | r17;
        int r22 = r21 & r14;
        int r23 = p7.p0(r22, r5);
        p7.q0(r22, r18, r5);
        r16[r19] = p7.S(r21, r23, r14);
        r18 = r20 & r10;
        goto L8
    L10:
        r17 = r17 + 1;
        goto L6
    L11:
        this.f8794a = r5;
        this.f8796c = p7.S(this.f8796c, 32 - Integer.numberOfLeadingZeros(r14), 31);
        return r14;
    }

    public int firstEntryIndex() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> r5) {
        r5.getClass();
        Set<E> r10 = delegateOrNull();
        if (r10 == null) goto L5;
        r10.forEach(r5);
        return;
    L5:
        int r11 = firstEntryIndex();
    L6:
        if (r11 < 0) goto L10;
        r5.accept(c()[r11]);
        r11 = getSuccessor(r11);
        goto L6
    }

    public int getSuccessor(int r5) {
        int r10 = r5 + 1;
        if (r10 < this.d) goto L7;
        return -1;
    L7:
        return r10;
    }

    public void incrementModCount() {
        this.f8796c += 32;
    }

    public void init(int r5) {
        if (r5 < 0) goto L5;
        boolean r10 = true;
    L6:
        com.google.common.base.b0.g("Expected size must be >= 0", r10);
        this.f8796c = dn.a.P(r5, 1);
        return;
    L5:
        r10 = false;
        goto L6
    }

    public void insertEntry(int r5, E r10, int r11, int r12) {
        int r13 = p7.S(r11, 0, r12);
        d()[r5] = r13;
        c()[r5] = r10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isUsingHashFloodingResistance() {
        if (delegateOrNull() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        Set<E> r5 = delegateOrNull();
        if (r5 == null) goto L7;
        return r5.iterator();
    L7:
        return new z1(this);
    }

    public void moveLastEntry(int r10, int r11) {
        Object r5 = this.f8794a;
        Objects.requireNonNull(r5);
        int[] r12 = d();
        Object[] r13 = c();
        int r14 = size();
        int r15 = r14 - 1;
        if (r10 >= r15) goto L11;
        Object r16 = r13[r15];
        r13[r10] = r16;
        r13[r15] = null;
        r12[r10] = r12[r15];
        r12[r15] = 0;
        int r17 = p7.o0(r16) & r11;
        int r18 = p7.p0(r17, r5);
        if (r18 != r14) goto L7;
        p7.q0(r17, r10 + 1, r5);
        return;
    L7:
        int r19 = r18 - 1;
        int r20 = r12[r19];
        int r21 = r20 & r11;
        if (r21 == r14) goto L9;
        r18 = r21;
        goto L7
    L9:
        r12[r19] = p7.S(r20, r10 + 1, r11);
        return;
    L11:
        r13[r10] = null;
        r12[r10] = 0;
    }

    public boolean needsAllocArrays() {
        if (this.f8794a != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object r10) {
        if (needsAllocArrays() == false) goto L5;
        return false;
    L5:
        Set<E> r5 = delegateOrNull();
        if (r5 != null) goto L8;
        int r11 = b();
        Object r12 = this.f8794a;
        Objects.requireNonNull(r12);
        int r13 = p7.g0(r10, null, r11, r12, d(), c(), null);
        if (r13 != (-1)) goto L12;
        return false;
    L12:
        moveLastEntry(r13, r11);
        this.d--;
        incrementModCount();
        return true;
    L8:
        return r5.remove(r10);
    }

    public void resizeEntries(int r5) {
        this.f8795b = Arrays.copyOf(d(), r5);
        this.elements = Arrays.copyOf(c(), r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set<E> r5 = delegateOrNull();
        if (r5 == null) goto L6;
        return r5.size();
    L6:
        return this.d;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<E> spliterator() {
        if (needsAllocArrays() == true) goto L5;
        Set<E> r5 = delegateOrNull();
        if (r5 == null) goto L10;
        return r5.spliterator();
    L10:
        return Spliterators.spliterator(c(), 0, this.d, 17);
    L5:
        return Spliterators.spliterator(new Object[0], 17);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (needsAllocArrays() == true) goto L5;
        Set<E> r5 = delegateOrNull();
        if (r5 == null) goto L10;
        return r5.toArray();
    L10:
        return Arrays.copyOf(c(), this.d);
    L5:
        return new Object[0];
    }

    public void trimToSize() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        Set<E> r5 = delegateOrNull();
        if (r5 == null) goto L9;
        LinkedHashSet r10 = new LinkedHashSet(size(), 1.0f);
        r10.addAll(r5);
        this.f8794a = r10;
        return;
    L9:
        int r11 = this.d;
        if (r11 >= d().length) goto L12;
        resizeEntries(r11);
    L12:
        int r12 = p7.r0(r11);
        int r13 = b();
        if (r12 >= r13) goto L16;
        e(r13, r12, 0, 0);
        return;
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> r5) {
        CompactHashSet<E> r10 = createWithExpectedSize(r5.size());
        r10.addAll(r5);
        return r10;
    }

    public CompactHashSet(int r5) {
        init(r5);
    }

    @SafeVarargs
    public static <E> CompactHashSet<E> create(E... r5) {
        CompactHashSet<E> r10 = createWithExpectedSize(r5.length);
        Collections.addAll(r10, r5);
        return r10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] r5) {
        if (needsAllocArrays() == true) goto L5;
        Set<E> r10 = delegateOrNull();
        if (r10 == null) goto L12;
        return (T[]) r10.toArray(r5);
    L12:
        return (T[]) p7.t0(c(), this.d, r5);
    L5:
        if (r5.length <= 0) goto L7;
        r5[0] = null;
    L7:
        return r5;
    }
}
