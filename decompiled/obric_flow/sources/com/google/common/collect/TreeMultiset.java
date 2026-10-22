package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final class TreeMultiset<E> extends p0 implements Serializable {
    private static final long serialVersionUID = 1;
    public final transient z9 d;
    public final transient GeneralRange e;
    public final transient y9 f;

    public static abstract enum Aggregate extends Enum<Aggregate> {
        public static final Aggregate DISTINCT = null;
        public static final Aggregate SIZE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Aggregate[] f8873a = null;

        static {
            final String r5 = "SIZE";
            final int r10 = 0;
            Aggregate r11 = new AnonymousClass1(r5, r10);
            SIZE = r11;
            final String r12 = "DISTINCT";
            final int r13 = 1;
            Aggregate r14 = new AnonymousClass2(r12, r13);
            DISTINCT = r14;
            f8873a = new Aggregate[]{r11, r14};
        }

        public Aggregate(String r5, int r10, v9 r11) {
            super(r5, r10);
        }

        public static Aggregate valueOf(String r5) {
            return (Aggregate) Enum.valueOf(Aggregate.class, r5);
        }

        public static Aggregate[] values() {
            return (Aggregate[]) f8873a.clone();
        }

        public abstract int nodeAggregate(y9 r5);

        public abstract long treeAggregate(y9 r5);
    }

    public TreeMultiset(z9 r5, GeneralRange<E> r10, y9 r11) {
        super(r10.comparator());
        this.d = r5;
        this.e = r10;
        this.f = r11;
    }

    public static /* synthetic */ y9 access$1300(TreeMultiset r5) {
        return r5.e();
    }

    public static /* synthetic */ GeneralRange access$1400(TreeMultiset r5) {
        return r5.e;
    }

    public static y7 access$1500(TreeMultiset r5, y9 r10) {
        r5.getClass();
        return new v9(r5, r10);
    }

    public static /* synthetic */ y9 access$1600(TreeMultiset r5) {
        return r5.f;
    }

    public static y9 access$1700(TreeMultiset r10) {
        y9 r5 = r10.d.f9250a;
        if (r5 == null) goto L23;
        GeneralRange r11 = r10.e;
        boolean r12 = r11.hasUpperBound();
        y9 r13 = r10.f;
        if (r12 == false) goto L15;
        Object r14 = r11.getUpperEndpoint();
        y9 r15 = r5.g(r10.comparator(), r14);
        if (r15 != null) goto L11;
        return null;
    L11:
        if (r11.getUpperBoundType() == BoundType.OPEN) goto L13;
    L16:
        if (r15 != r13) goto L18;
        return null;
    L18:
        if (r11.contains(r15.f9233a) == true) goto L21;
        return null;
    L21:
        return r15;
    L13:
        if (r10.comparator().compare(r14, r15.f9233a) != 0) goto L16;
        r15 = r15.f9236h;
        Objects.requireNonNull(r15);
        goto L16
    L15:
        r15 = r13.f9236h;
        Objects.requireNonNull(r15);
        goto L16
    L23:
        return null;
    }

    public static void access$1800(y9 r5, y9 r10, y9 r11) {
        r5.f9237i = r10;
        r10.f9236h = r5;
        r10.f9237i = r11;
        r11.f9236h = r10;
    }

    public static void access$1900(y9 r5, y9 r10) {
        r5.f9237i = r10;
        r10.f9236h = r5;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset(g8.natural());
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        Comparator r10 = (Comparator) r5.readObject();
        p7.F(p0.class, "comparator").a(this, r10);
        p7.F(TreeMultiset.class, "range").a(this, GeneralRange.all(r10));
        p7.F(TreeMultiset.class, "rootReference").a(this, new z9());
        y9 r11 = new y9();
        p7.F(TreeMultiset.class, "header").a(this, r11);
        r11.f9237i = r11;
        r11.f9236h = r11;
        p7.f0(this, r5, r5.readInt());
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        r5.writeObject(elementSet().comparator());
        p7.A0(this, r5);
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public int add(E r5, int r10) {
        p7.q(r10, "occurrences");
        if (r10 == 0) goto L5;
        com.google.common.base.b0.i(this.e.contains(r5));
        z9 r11 = this.d;
        y9 r12 = r11.f9250a;
        if (r12 != null) goto L10;
        comparator().compare(r5, r5);
        y9 r13 = new y9(r5, r10);
        y9 r14 = this.f;
        r14.f9237i = r13;
        r13.f9236h = r14;
        r13.f9237i = r14;
        r14.f9236h = r13;
        r11.a(r12, r13);
        return 0;
    L10:
        int[] r15 = new int[1];
        r11.a(r12, r12.a(comparator(), r5, r10, r15));
        return r15[0];
    L5:
        return count(r5);
    }

    public final long b(Aggregate r5, y9 r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        Comparator r11 = comparator();
        GeneralRange r12 = this.e;
        int r13 = r11.compare(r12.getUpperEndpoint(), r10.f9233a);
        if (r13 > 0) goto L8;
        if (r13 != 0) goto L20;
        int r14 = x9.f9226a[r12.getUpperBoundType().ordinal()];
        if (r14 == 1) goto L19;
        if (r14 != 2) goto L17;
        return r5.treeAggregate(r10.g);
    L17:
        throw new AssertionError();
    L19:
        return ((long) r5.nodeAggregate(r10)) + r5.treeAggregate(r10.g);
    L20:
        long r15 = r5.treeAggregate(r10.g) + ((long) r5.nodeAggregate(r10));
        return b(r5, r10.f) + r15;
    L8:
        return b(r5, r10.g);
    }

    public final long c(Aggregate r5, y9 r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        Comparator r11 = comparator();
        GeneralRange r12 = this.e;
        int r13 = r11.compare(r12.getLowerEndpoint(), r10.f9233a);
        if (r13 < 0) goto L8;
        if (r13 != 0) goto L20;
        int r14 = x9.f9226a[r12.getLowerBoundType().ordinal()];
        if (r14 == 1) goto L19;
        if (r14 != 2) goto L17;
        return r5.treeAggregate(r10.f);
    L17:
        throw new AssertionError();
    L19:
        return ((long) r5.nodeAggregate(r10)) + r5.treeAggregate(r10.f);
    L20:
        long r15 = r5.treeAggregate(r10.f) + ((long) r5.nodeAggregate(r10));
        return c(r5, r10.g) + r15;
    L8:
        return c(r5, r10.f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        GeneralRange r5 = this.e;
        if (r5.hasLowerBound() == false) goto L5;
    L11:
        p7.u(entryIterator());
        return;
    L5:
        if (r5.hasUpperBound() == true) goto L11;
        y9 r10 = this.f;
        y9 r11 = r10.f9237i;
        Objects.requireNonNull(r11);
    L8:
        if (r11 == r10) goto L10;
        y9 r12 = r11.f9237i;
        Objects.requireNonNull(r12);
        r11.f9234b = 0;
        r11.f = null;
        r11.g = null;
        r11.f9236h = null;
        r11.f9237i = null;
        r11 = r12;
        goto L8
    L10:
        r10.f9237i = r10;
        r10.f9236h = r10;
        this.d.f9250a = null;
    }

    @Override // com.google.common.collect.v8, com.google.common.collect.t8
    public Comparator comparator() {
        return this.comparator;
    }

    @Override // com.google.common.collect.j0, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean contains(Object r5) {
        return super.contains(r5);
    }

    @Override // com.google.common.collect.z7
    public int count(Object r5) {
        y9 r10 = this.d.f9250a;     // Catch: Throwable -> L10
        if (this.e.contains(r5) == false) goto L9;
        if (r10 == null) goto L9;
        return r10.e(comparator(), r5);
    L9:
        return 0;
    }

    public final long d(Aggregate r10) {
        y9 r5 = this.d.f9250a;
        long r11 = r10.treeAggregate(r5);
        GeneralRange r12 = this.e;
        if (r12.hasLowerBound() == false) goto L6;
        r11 = r11 - c(r10, r5);
    L6:
        if (r12.hasUpperBound() == true) goto L8;
        return r11;
    L8:
        return r11 - b(r10, r5);
    }

    @Override // com.google.common.collect.p0
    public Iterator<y7> descendingEntryIterator() {
        return new w9(this, 1);
    }

    @Override // com.google.common.collect.v8
    public v8 descendingMultiset() {
        v8 r5 = this.f9113c;
        if (r5 != null) goto L6;
        v8 r10 = createDescendingMultiset();
        this.f9113c = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.j0
    public int distinctElements() {
        return dn.a.U(d(Aggregate.DISTINCT));
    }

    public final y9 e() {
        y9 r5 = this.d.f9250a;
        if (r5 != null) goto L5;
        return null;
    L5:
        GeneralRange r10 = this.e;
        boolean r11 = r10.hasLowerBound();
        y9 r12 = this.f;
        if (r11 == false) goto L15;
        Object r13 = r10.getLowerEndpoint();
        y9 r14 = r5.d(comparator(), r13);
        if (r14 != null) goto L11;
        return null;
    L11:
        if (r10.getLowerBoundType() == BoundType.OPEN) goto L13;
    L16:
        if (r14 != r12) goto L18;
        return null;
    L18:
        if (r10.contains(r14.f9233a) == true) goto L21;
        return null;
    L21:
        return r14;
    L13:
        if (comparator().compare(r13, r14.f9233a) != 0) goto L16;
        r14 = r14.f9237i;
        Objects.requireNonNull(r14);
        goto L16
    L15:
        r14 = r12.f9237i;
        Objects.requireNonNull(r14);
        goto L16
    }

    @Override // com.google.common.collect.j0
    public Iterator<E> elementIterator() {
        return new q0(entryIterator(), 3);
    }

    @Override // com.google.common.collect.p0, com.google.common.collect.j0, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.j0
    public Iterator<y7> entryIterator() {
        return new w9(this, 0);
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.v8
    public y7 firstEntry() {
        Iterator<y7> r5 = entryIterator();
        if (r5.hasNext() == true) goto L7;
        return null;
    L7:
        return r5.next();
    }

    @Override // java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEach(Consumer r5) {
        super.forEach(r5);
    }

    @Override // com.google.common.collect.z7
    public void forEachEntry(ObjIntConsumer<? super E> r5) {
        r5.getClass();
        y9 r10 = e();
    L4:
        if (r10 == this.f) goto L9;
        if (r10 == null) goto L13;
        GeneralRange r11 = this.e;
        a1.a r12 = (Object) r10.f9233a;
        if (r11.tooHigh(r12) == true) goto L14;
        r5.accept(r12, r10.f9234b);
        r10 = r10.f9237i;
        Objects.requireNonNull(r10);
        goto L4
    L14:
        return;
    L13:
        return;
    }

    @Override // com.google.common.collect.v8
    public v8 headMultiset(E r5, BoundType r10) {
        GeneralRange r11 = GeneralRange.upTo(comparator(), r5, r10);
        GeneralRange r12 = this.e.intersect(r11);
        y9 r13 = this.f;
        return new TreeMultiset(this.d, r12, r13);
    }

    @Override // com.google.common.collect.j0, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return p7.O(this);
    }

    @Override // com.google.common.collect.v8
    public y7 lastEntry() {
        Iterator<y7> r5 = descendingEntryIterator();
        if (r5.hasNext() == true) goto L7;
        return null;
    L7:
        return r5.next();
    }

    @Override // com.google.common.collect.v8
    public y7 pollFirstEntry() {
        Iterator<y7> r5 = entryIterator();
        if (r5.hasNext() == false) goto L5;
        y7 r10 = r5.next();
        Multisets$ImmutableEntry r11 = new Multisets$ImmutableEntry(r10.getElement(), r10.getCount());
        r5.remove();
        return r11;
    L5:
        return null;
    }

    @Override // com.google.common.collect.v8
    public y7 pollLastEntry() {
        Iterator<y7> r5 = descendingEntryIterator();
        if (r5.hasNext() == false) goto L5;
        y7 r10 = r5.next();
        Multisets$ImmutableEntry r11 = new Multisets$ImmutableEntry(r10.getElement(), r10.getCount());
        r5.remove();
        return r11;
    L5:
        return null;
    }

    @Override // com.google.common.collect.z7
    public int remove(Object r10, int r11) {
        p7.q(r11, "occurrences");
        if (r11 == 0) goto L5;
        z9 r5 = this.d;
        y9 r12 = r5.f9250a;
        int[] r13 = new int[1];
        if (this.e.contains(r10) == false) goto L14;
        if (r12 == null) goto L14;
        r5.a(r12, r12.k(comparator(), r10, r11, r13));
        return r13[0];
    L14:
        return 0;
    L5:
        return count(r10);
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public int setCount(E r5, int r10) {
        p7.q(r10, "count");
        boolean r11 = true;
        if (this.e.contains(r5) == true) goto L9;
        if (r10 == 0) goto L7;
        r11 = false;
    L7:
        com.google.common.base.b0.i(r11);
        return 0;
    L9:
        z9 r12 = this.d;
        y9 r13 = r12.f9250a;
        if (r13 != null) goto L14;
        if (r10 <= 0) goto L13;
        add(r5, r10);
    L13:
        return 0;
    L14:
        int[] r14 = new int[1];
        r12.a(r13, r13.q(comparator(), r5, r10, r14));
        return r14[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return dn.a.U(d(Aggregate.SIZE));
    }

    @Override // java.util.Collection, java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return super.spliterator();
    }

    @Override // com.google.common.collect.v8
    public v8 subMultiset(Object r5, BoundType r10, Object r11, BoundType r12) {
        r10.getClass();
        r12.getClass();
        return tailMultiset(r5, r10).headMultiset(r11, r12);
    }

    @Override // com.google.common.collect.v8
    public v8 tailMultiset(E r5, BoundType r10) {
        GeneralRange r11 = GeneralRange.downTo(comparator(), r5, r10);
        GeneralRange r12 = this.e.intersect(r11);
        y9 r13 = this.f;
        return new TreeMultiset(this.d, r12, r13);
    }

    public static <E> TreeMultiset<E> create(Comparator<? super E> r5) {
        if (r5 != null) goto L5;
        return new TreeMultiset(g8.natural());
    L5:
        return new TreeMultiset(r5);
    }

    public static int distinctElements(y9 r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        return r5.f9235c;
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> r5) {
        TreeMultiset<E> r10 = create();
        p7.i(r10, r5);
        return r10;
    }

    public TreeMultiset(Comparator<? super E> r5) {
        super(r5);
        this.e = GeneralRange.all(r5);
        y9 r10 = new y9();
        this.f = r10;
        r10.f9237i = r10;
        r10.f9236h = r10;
        this.d = new z9();
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public boolean setCount(E r12, int r13, int r14) {
        p7.q(r14, "newCount");
        p7.q(r13, "oldCount");
        com.google.common.base.b0.i(this.e.contains(r12));
        z9 r5 = this.d;
        y9 r10 = r5.f9250a;
        if (r10 != null) goto L9;
        if (r13 != 0) goto L8;
        if (r14 <= 0) goto L7;
        add(r12, r14);
    L7:
        return true;
    L8:
        return false;
    L9:
        int[] r11 = new int[1];
        r5.a(r10, r10.p(comparator(), r12, r13, r14, r11));
        if (r11[0] == r13) goto L12;
        return false;
    L12:
        return true;
    }
}
