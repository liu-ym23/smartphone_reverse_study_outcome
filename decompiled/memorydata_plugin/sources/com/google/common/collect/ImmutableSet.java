package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;
    static final int SPLITERATOR_CHARACTERISTICS = 1297;

    static abstract class CachingAsList<E> extends ImmutableSet<E> {
        private transient ImmutableList<E> asList;

        CachingAsList() {
        }

        @Override // com.google.common.collect.ImmutableCollection
        public ImmutableList<E> asList() {
            ImmutableList<E> r0 = this.asList;
            if (r0 != null) goto L6;
            ImmutableList<E> r1 = createAsList();
            this.asList = r1;
            return r1;
        L6:
            return r0;
        }

        ImmutableList<E> createAsList() {
            return new RegularImmutableAsList(this, toArray());
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }
    }

    static abstract class Indexed<E> extends CachingAsList<E> {
        Indexed() {
        }

        @Override // com.google.common.collect.ImmutableCollection
        int copyIntoArray(Object[] r1, int r2) {
            return asList().copyIntoArray(r1, r2);
        }

        @Override // com.google.common.collect.ImmutableSet.CachingAsList
        ImmutableList<E> createAsList() {
            return new AnonymousClass1(this);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> r4) {
            Consumer r5 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r4, Consumer.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r5);
            int r0 = size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r5.accept(get(r1));
            r1 = r1 + 1;
            goto L3
        }

        abstract E get(int r1);

        @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public bj<E> iterator() {
            return asList().iterator();
        }

        @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return p.a(size(), ImmutableSet.SPLITERATOR_CHARACTERISTICS, new $$Lambda$HFLqm51g1K0rplRsHCpQqK9Q_iw(this));
        }
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] r1) {
            this.elements = r1;
        }

        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    public static class a<E> extends ImmutableCollection.a<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f4470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private e<E> f4471b;

        public a() {
            this(0);
        }

        a(int r2) {
            if (r2 <= 0) goto L5;
            this.f4471b = new d(r2);
            return;
        L5:
            this.f4471b = b.a();
        }

        a(boolean r1) {
            this.f4471b = null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.a
        public /* synthetic */ ImmutableCollection.a a(Object r1) {
            return b(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection.a
        public /* synthetic */ ImmutableCollection.a a(Iterator r3) {
            return b((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.a
        public /* synthetic */ ImmutableCollection.a a(Object[] r1) {
            return b(r1);
        }

        a<E> a(a<E> r2) {
            Objects.requireNonNull(this.f4471b);
            Objects.requireNonNull(r2.f4471b);
            a();
            this.f4471b = this.f4471b.a(r2.f4471b);
            return this;
        }

        final void a() {
            if (this.f4470a == false) goto L6;
            b();
            this.f4470a = false;
            return;
        }

        public a<E> b(E r2) {
            Objects.requireNonNull(this.f4471b);
            com.google.common.base.n.a(r2);
            a();
            this.f4471b = this.f4471b.a(r2);
            return this;
        }

        public a<E> b(Iterator<? extends E> r3) {
            super.a((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public a<E> b(E... r1) {
            super.a(r1);
            return this;
        }

        void b() {
            Objects.requireNonNull(this.f4471b);
            this.f4471b = this.f4471b.b();
        }

        public ImmutableSet<E> c() {
            Objects.requireNonNull(this.f4471b);
            this.f4470a = true;
            e<E> r0 = this.f4471b.f_();
            this.f4471b = r0;
            return r0.c();
        }
    }

    private static final class b<E> extends e<E> {
        private static final b<Object> c = null;

        static {
            c = new b();
        }

        private b() {
            super(0);
        }

        static <E> e<E> a() {
            return c;
        }

        @Override // com.google.common.collect.ImmutableSet.e
        e<E> a(E r2) {
            return new d(4).a(r2);
        }

        @Override // com.google.common.collect.ImmutableSet.e
        e<E> b() {
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.e
        ImmutableSet<E> c() {
            return ImmutableSet.of();
        }
    }

    private static final class c<E> extends e<E> {
        private final Set<Object> c;

        c(e<E> r3) {
            super(r3);
            this.c = Sets.a(this.f4473b);
            int r4 = 0;
        L4:
            if (r4 >= this.f4473b) goto L6;
            this.c.add(Objects.requireNonNull(this.f4472a[r4]));
            r4 = r4 + 1;
            goto L4
        }

        @Override // com.google.common.collect.ImmutableSet.e
        e<E> a(E r2) {
            com.google.common.base.n.a(r2);
            if (this.c.add(r2) == false) goto L5;
            b(r2);
        L5:
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.e
        e<E> b() {
            return new c(this);
        }

        @Override // com.google.common.collect.ImmutableSet.e
        ImmutableSet<E> c() {
            int r0 = this.f4473b;
            if (r0 == 0) goto L11;
            if (r0 == 1) goto L9;
            return new JdkBackedImmutableSet(this.c, ImmutableList.asImmutableList(this.f4472a, this.f4473b));
        L9:
            return ImmutableSet.of(Objects.requireNonNull(this.f4472a[0]));
        L11:
            return ImmutableSet.of();
        }
    }

    private static final class d<E> extends e<E> {
        private Object[] c;
        private int d;
        private int e;
        private int f;

        d(int r1) {
            super(r1);
            this.c = null;
            this.d = 0;
            this.e = 0;
        }

        d(d<E> r4) {
            super(r4);
            Object[] r0 = r4.c;
            if (r0 != null) goto L5;
            Object[] r1 = null;
        L6:
            this.c = r1;
            this.d = r4.d;
            this.e = r4.e;
            this.f = r4.f;
            return;
        L5:
            r1 = (Object[]) ZeusTransformUtils.preCheckCast(r0.clone(), Object[].class, "com.obric.memorydata.plugin");
            goto L6
        }

        static boolean a(Object[] r9) {
            int r0 = b(r9.length);
            int r1 = r9.length - 1;
            int r4 = 0;
            int r5 = 0;
        L4:
            if (r4 >= r9.length) goto L20;
            if (r4 != r5) goto L13;
            if (r9[r4] != null) goto L13;
            r5 = r4 + r0;
            if (r9[(r5 - 1) & r1] == null) goto L12;
            r5 = r4 + 1;
        L12:
            r4 = r5;
        L13:
            int r6 = r4 + r0;
            int r7 = r6 - 1;
        L14:
            if (r7 < r5) goto L19;
            if (r9[r7 & r1] == null) goto L17;
            r7 = r7 - 1;
            goto L14
        L17:
            r5 = r6;
            r4 = r7 + 1;
            goto L4
        L19:
            return true;
        L20:
            return false;
        }

        static Object[] a(int r6, Object[] r7, int r8) {
            Object[] r0 = new Object[r6];
            int r9 = r6 - 1;
            int r1 = 0;
        L3:
            if (r1 >= r8) goto L9;
            Object r2 = Objects.requireNonNull(r7[r1]);
            int r3 = ai.a(r2.hashCode());
        L5:
            int r4 = r3 & r9;
            if (r0[r4] == null) goto L7;
            r3 = r3 + 1;
            goto L5
        L7:
            r0[r4] = r2;
            r1 = r1 + 1;
            goto L3
        L9:
            return r0;
        }

        static int b(int r1) {
            return com.google.common.math.c.a(r1, RoundingMode.UNNECESSARY) * 13;
        }

        private e<E> c(E r7) {
            Objects.requireNonNull(this.c);
            int r0 = r7.hashCode();
            int r1 = ai.a(r0);
            int r2 = this.c.length - 1;
            int r3 = r1;
        L4:
            if ((r3 - r1) >= this.d) goto L14;
            int r4 = r3 & r2;
            Object r5 = this.c[r4];
            if (r5 == null) goto L7;
            if (r5.equals(r7) == true) goto L11;
            r3 = r3 + 1;
            goto L4
        L11:
            return this;
        L7:
            b(r7);
            this.c[r4] = r7;
            this.f += r0;
            a(this.f4473b);
            return this;
        L14:
            return new c(this).a(r7);
        }

        @Override // com.google.common.collect.ImmutableSet.e
        e<E> a(E r3) {
            com.google.common.base.n.a(r3);
            if (this.c != null) goto L11;
            if (this.f4473b != 0) goto L8;
            b(r3);
            return this;
        L8:
            a(this.f4472a.length);
            E r0 = this.f4472a[0];
            this.f4473b--;
            return c(r0).a(r3);
        L11:
            return c(r3);
        }

        void a(int r5) {
            Object[] r0 = this.c;
            if (r0 != null) goto L6;
            int r6 = ImmutableSet.chooseTableSize(r5);
            this.c = new Object[r6];
        L10:
            this.d = b(r6);
            this.e = (int) (((double) r6) * ImmutableSet.DESIRED_LOAD_FACTOR);
            return;
        L6:
            if (r5 > this.e) goto L8;
            return;
        L8:
            if (r0.length >= 1073741824) goto L13;
            r6 = r0.length * 2;
            this.c = a(r6, this.f4472a, this.f4473b);
            goto L10
        }

        @Override // com.google.common.collect.ImmutableSet.e
        e<E> b() {
            return new d(this);
        }

        @Override // com.google.common.collect.ImmutableSet.e
        ImmutableSet<E> c() {
            int r0 = this.f4473b;
            if (r0 == 0) goto L15;
            if (r0 == 1) goto L13;
            if (this.f4473b != this.f4472a.length) goto L9;
            Object[] r1 = this.f4472a;
        L11:
            return new RegularImmutableSet(r1, this.f, (Object[]) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.c), Object[].class, "com.obric.memorydata.plugin"), this.c.length - 1);
        L9:
            r1 = Arrays.copyOf(this.f4472a, this.f4473b);
            goto L11
        L13:
            return ImmutableSet.of(Objects.requireNonNull(this.f4472a[0]));
        L15:
            return ImmutableSet.of();
        }

        @Override // com.google.common.collect.ImmutableSet.e
        e<E> f_() {
            if (this.c != null) goto L5;
            return this;
        L5:
            int r0 = ImmutableSet.chooseTableSize(this.f4473b);
            if ((r0 * 2) >= this.c.length) goto L9;
            this.c = a(r0, this.f4472a, this.f4473b);
            this.d = b(r0);
            this.e = (int) (((double) r0) * ImmutableSet.DESIRED_LOAD_FACTOR);
        L9:
            if (a(this.c) == true) goto L11;
            return this;
        L11:
            return new c(this);
        }
    }

    private static abstract class e<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        E[] f4472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f4473b;

        e(int r1) {
            this.f4472a = (E[]) new Object[r1];
            this.f4473b = 0;
        }

        e(e<E> r3) {
            E[] r0 = r3.f4472a;
            this.f4472a = (E[]) Arrays.copyOf(r0, r0.length);
            this.f4473b = r3.f4473b;
        }

        private void a(int r3) {
            E[] r0 = this.f4472a;
            if (r3 <= r0.length) goto L6;
            int r4 = ImmutableCollection.a.a(r0.length, r3);
            this.f4472a = (E[]) Arrays.copyOf(this.f4472a, r4);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [com.google.common.collect.ImmutableSet$e, com.google.common.collect.ImmutableSet$e<E>] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7 */
        final e<E> a(e<E> r3) {
            int r0 = 0;
            ?? r2 = this;
        L4:
            if (r0 >= r3.f4473b) goto L6;
            d r4 = (e) r2;
            boolean r5 = (e<E>) r4.a(Objects.requireNonNull(r3.f4472a[r0]));
            r0 = r0 + 1;
            r2 = r5;
            goto L4
        L6:
            return (e<E>) r2;
        }

        abstract e<E> a(E r1);

        abstract e<E> b();

        final void b(E r4) {
            a(this.f4473b + 1);
            E[] r0 = this.f4472a;
            int r1 = this.f4473b;
            this.f4473b = r1 + 1;
            r0[r1] = r4;
        }

        abstract ImmutableSet<E> c();

        e<E> f_() {
            return this;
        }
    }

    ImmutableSet() {
    }

    public static <E> a<E> builder() {
        return new a();
    }

    public static <E> a<E> builderWithExpectedSize(int r1) {
        o.a(r1, "expectedSize");
        return new a(r1);
    }

    static int chooseTableSize(int r5) {
        int r6 = Math.max(r5, 2);
        boolean r0 = true;
        if (r6 >= CUTOFF) goto L10;
        int r1 = Integer.highestOneBit(r6 - 1) << 1;
    L6:
        if ((((double) r1) * DESIRED_LOAD_FACTOR) >= r6) goto L8;
        r1 = r1 << 1;
        goto L6
    L8:
        return r1;
    L10:
        if (r6 < 1073741824) goto L13;
        r0 = false;
    L13:
        com.google.common.base.n.a(r0, "collection too large");
        return 1073741824;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.common.collect.ImmutableSet$e] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    private static <E> ImmutableSet<E> construct(int r2, int r3, Object... r4) {
        if (r2 == 0) goto L13;
        int r0 = 0;
        if (r2 == 1) goto L11;
        ?? r1 = new d(r3);
    L6:
        if (r0 >= r2) goto L9;
        Object r5 = r1.a(com.google.common.base.n.a(r4[r0]));
        r0 = r0 + 1;
        r1 = r5;
        goto L6
    L9:
        return r1.f_().c();
    L11:
        return of(r4[0]);
    L13:
        return of();
    }

    private static <E> ImmutableSet<E> constructUnknownDuplication(int r2, Object... r3) {
        return construct(r2, Math.max(4, com.google.common.math.c.b(r2, RoundingMode.CEILING)), r3);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == false) goto L6;
        return copyOf((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin"));
    L6:
        return copyOf(r3.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ImmutableSet.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r4, SortedSet.class) == true) goto L10;
        ImmutableSet<E> r0 = (ImmutableSet) ZeusTransformUtils.preCheckCast(r4, ImmutableSet.class, "com.obric.memorydata.plugin");
        if (r0.isPartialView() == true) goto L13;
        return r0;
    L13:
        Object[] r1 = r4.toArray();
        if (ZeusTransformUtils.instanceOf(r4, Set.class) == false) goto L18;
        return construct(r1.length, r1.length, r1);
    L18:
        return constructUnknownDuplication(r1.length, r1);
    L10:
        if (ZeusTransformUtils.instanceOf(r4, EnumSet.class) == false) goto L13;
        return copyOfEnumSet((EnumSet) ZeusTransformUtils.preCheckCast(r4, EnumSet.class, "com.obric.memorydata.plugin"));
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> r2) {
        Iterator<? extends E> r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        if (r3.hasNext() == false) goto L5;
        E r0 = r3.next();
        if (r3.hasNext() == true) goto L11;
        return of(r0);
    L11:
        return new a().b(r0).b(r3).c();
    L5:
        return of();
    }

    public static <E> ImmutableSet<E> copyOf(E[] r3) {
        int r0 = r3.length;
        if (r0 == 0) goto L11;
        if (r0 == 1) goto L9;
        return constructUnknownDuplication(r3.length, (Object[]) ZeusTransformUtils.preCheckCast(r3.clone(), Object[].class, "com.obric.memorydata.plugin"));
    L9:
        return of(r3[0]);
    L11:
        return of();
    }

    private static ImmutableSet copyOfEnumSet(EnumSet r0) {
        return ImmutableEnumSet.asImmutable(EnumSet.copyOf(r0));
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    public static <E> ImmutableSet<E> of(E r1) {
        return new SingletonImmutableSet(r1);
    }

    public static <E> ImmutableSet<E> of(E r3, E r4) {
        return construct(2, 2, new Object[]{r3, r4});
    }

    public static <E> ImmutableSet<E> of(E r3, E r4, E r5) {
        return construct(3, 3, new Object[]{r3, r4, r5});
    }

    public static <E> ImmutableSet<E> of(E r3, E r4, E r5, E r6) {
        return construct(4, 4, new Object[]{r3, r4, r5, r6});
    }

    public static <E> ImmutableSet<E> of(E r3, E r4, E r5, E r6, E r7) {
        return construct(5, 5, new Object[]{r3, r4, r5, r6, r7});
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E r5, E r6, E r7, E r8, E r9, E r10, E... r11) {
        if (r11.length > 2147483641) goto L5;
        boolean r0 = true;
    L6:
        com.google.common.base.n.a(r0, "the total number of elements must fit in an int");
        int r1 = r11.length + 6;
        Object[] r4 = new Object[r1];
        r4[0] = r5;
        r4[1] = r6;
        r4[2] = r7;
        r4[3] = r8;
        r4[4] = r9;
        r4[5] = r10;
        System.arraycopy(r11, 0, r4, 6, r11.length);
        return construct(r1, r1, r4);
    L5:
        r0 = false;
        goto L6
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E> Collector<E, ?, ImmutableSet<E>> toImmutableSet() {
        return n.b();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ImmutableSet.class) == false) goto L17;
        if (isHashCodeFast() == false) goto L17;
        if (((ImmutableSet) ZeusTransformUtils.preCheckCast(r3, ImmutableSet.class, "com.obric.memorydata.plugin")).isHashCodeFast() == false) goto L17;
        if (hashCode() == r3.hashCode()) goto L17;
        return false;
    L17:
        return Sets.a(this, r3);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.a(this);
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract bj<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }
}
