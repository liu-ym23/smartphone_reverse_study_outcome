package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final ImmutableMultiset<Object> EMPTY = null;
    static final double HASH_FLOODING_FPP = 0.001d;
    static final int MAX_HASH_BUCKET_LENGTH = 9;
    static final double MAX_LOAD_FACTOR = 1.0d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Multisets$ImmutableEntry[] f8858j = null;
    public final transient Multisets$ImmutableEntry[] e;
    public final transient Multisets$ImmutableEntry[] f;
    public final transient int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final transient int f8859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient ImmutableSet f8860i;

    public static final class NonTerminalEntry<E> extends Multisets$ImmutableEntry<E> {
        private final Multisets$ImmutableEntry<E> nextInBucket;

        public NonTerminalEntry(E r5, int r10, Multisets$ImmutableEntry<E> r11) {
            super(r5, r10);
            this.nextInBucket = r11;
        }

        @Override // com.google.common.collect.Multisets$ImmutableEntry
        public Multisets$ImmutableEntry<E> nextInBucket() {
            return this.nextInBucket;
        }
    }

    static {
        f8858j = new Multisets$ImmutableEntry[0];
        EMPTY = create(ImmutableList.of());
    }

    public RegularImmutableMultiset(Multisets$ImmutableEntry[] r5, Multisets$ImmutableEntry[] r10, int r11, int r12, ImmutableSet r13) {
        this.e = r5;
        this.f = r10;
        this.g = r11;
        this.f8859h = r12;
        this.f8860i = r13;
    }

    public static <E> ImmutableMultiset<E> create(Collection<? extends y7> r15) {
        int r5 = r15.size();
        Multisets$ImmutableEntry[] r10 = new Multisets$ImmutableEntry[r5];
        if (r5 == 0) goto L5;
        int r11 = p7.v(1.0d, r5);
        int r12 = r11 - 1;
        Multisets$ImmutableEntry[] r13 = new Multisets$ImmutableEntry[r11];
        Iterator<? extends y7> r16 = r15.iterator();
        long r14 = 0;
        int r17 = 0;
        int r18 = 0;
    L8:
        if (r16.hasNext() == false) goto L19;
        y7 r19 = r16.next();
        Object r110 = r19.getElement();
        r110.getClass();
        int r111 = r19.getCount();
        int r112 = r110.hashCode();
        int r113 = p7.n0(r112) & r12;
        Multisets$ImmutableEntry r114 = r13[r113];
        if (r114 == null) goto L12;
        Multisets$ImmutableEntry r20 = new NonTerminalEntry(r110, r111, r114);
    L18:
        r17 = r17 + (r112 ^ r111);
        r10[r18] = r20;
        r13[r113] = r20;
        r14 = r14 + ((long) r111);
        r18 = r18 + 1;
        goto L8
    L12:
        if ((r19 instanceof Multisets$ImmutableEntry) == true) goto L14;
    L16:
        r20 = new Multisets$ImmutableEntry(r110, r111);
        goto L18
    L14:
        if ((r19 instanceof NonTerminalEntry) == true) goto L16;
        r20 = (Multisets$ImmutableEntry) r19;
        goto L18
    L19:
        int r115 = 0;
    L20:
        if (r115 >= r11) goto L29;
        Multisets$ImmutableEntry r21 = r13[r115];
        int r22 = 0;
    L22:
        if (r21 == null) goto L27;
        r22 = r22 + 1;
        if (r22 > 9) goto L37;
        r21 = r21.nextInBucket();
        goto L22
    L37:
        return JdkBackedImmutableMultiset.create(ImmutableList.asImmutableList(r10));
    L27:
        r115 = r115 + 1;
        goto L20
    L29:
        return new RegularImmutableMultiset(r10, r13, dn.a.U(r14), r17, null);
    L5:
        return new RegularImmutableMultiset(r10, f8858j, 0, 0, ImmutableSet.of());
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public int count(Object r5) {
        if (r5 == null) goto L14;
        Multisets$ImmutableEntry[] r10 = this.f;
        if (r10.length == 0) goto L14;
        Multisets$ImmutableEntry r11 = r10[p7.o0(r5) & (r10.length - 1)];
    L8:
        if (r11 == null) goto L14;
        if (com.google.common.base.b0.w(r5, r11.getElement()) == true) goto L12;
        r11 = r11.nextInBucket();
        goto L8
    L12:
        return r11.getCount();
    L14:
        return 0;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableMultiset, java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEach(Consumer r5) {
        super.forEach(r5);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer r5) {
        super.forEachEntry(r5);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public y7 getEntry(int r5) {
        return this.e[r5];
    }

    @Override // com.google.common.collect.ImmutableMultiset, java.util.Collection, com.google.common.collect.z7
    public int hashCode() {
        return this.f8859h;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.g;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> r5 = this.f8860i;
        if (r5 != null) goto L6;
        ImmutableMultiset.ElementSet r10 = new ImmutableMultiset.ElementSet(Arrays.asList(this.e), this);
        this.f8860i = r10;
        return r10;
    L6:
        return r5;
    }
}
