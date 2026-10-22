package com.google.common.collect;

import com.google.common.primitives.Ints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final ImmutableMultiset<Object> EMPTY = null;
    private static final Multisets.ImmutableEntry<?>[] EMPTY_ARRAY = null;
    static final double HASH_FLOODING_FPP = 0.001d;
    static final int MAX_HASH_BUCKET_LENGTH = 9;
    static final double MAX_LOAD_FACTOR = 1.0d;
    private transient ImmutableSet<E> elementSet;
    private final transient Multisets.ImmutableEntry<E>[] entries;
    private final transient int hashCode;
    private final transient Multisets.ImmutableEntry<?>[] hashTable;
    private final transient int size;

    private static final class NonTerminalEntry<E> extends Multisets.ImmutableEntry<E> {
        private final Multisets.ImmutableEntry<E> nextInBucket;

        NonTerminalEntry(E r1, int r2, Multisets.ImmutableEntry<E> r3) {
            super(r1, r2);
            this.nextInBucket = r3;
        }

        @Override // com.google.common.collect.Multisets.ImmutableEntry
        public Multisets.ImmutableEntry<E> nextInBucket() {
            return this.nextInBucket;
        }
    }

    static {
        EMPTY_ARRAY = new Multisets.ImmutableEntry[0];
        EMPTY = create(ImmutableList.of());
    }

    private RegularImmutableMultiset(Multisets.ImmutableEntry<E>[] r1, Multisets.ImmutableEntry<?>[] r2, int r3, int r4, ImmutableSet<E> r5) {
        this.entries = r1;
        this.hashTable = r2;
        this.size = r3;
        this.hashCode = r4;
        this.elementSet = r5;
    }

    static <E> ImmutableMultiset<E> create(Collection<? extends an.a<? extends E>> r15) {
        Collection r16 = (Collection) ZeusTransformUtils.wrapperContextForParams(r15, Collection.class, "com.obric.memorydata.plugin");
        int r0 = r16.size();
        Multisets.ImmutableEntry[] r3 = new Multisets.ImmutableEntry[r0];
        if (r0 == 0) goto L5;
        int r1 = ai.a(r0, MAX_LOAD_FACTOR);
        int r2 = r1 - 1;
        Multisets.ImmutableEntry[] r4 = new Multisets.ImmutableEntry[r1];
        long r5 = 0;
        Iterator<E> r17 = r16.iterator();
        int r7 = 0;
        int r8 = 0;
    L8:
        if (r17.hasNext() == false) goto L23;
        an.a r9 = (an.a) ZeusTransformUtils.preCheckCast(r17.next(), an.a.class, "com.obric.memorydata.plugin");
        Object r10 = com.google.common.base.n.a(r9.getElement());
        int r11 = r9.getCount();
        int r12 = r10.hashCode();
        int r13 = ai.a(r12) & r2;
        Multisets.ImmutableEntry r14 = r4[r13];
        if (r14 == null) goto L12;
        Multisets.ImmutableEntry r18 = new NonTerminalEntry(r10, r11, r14);
    L21:
        r7 = r7 + (r12 ^ r11);
        r3[r8] = r18;
        r4[r13] = r18;
        r5 = r5 + ((long) r11);
        r8 = r8 + 1;
        goto L8
    L12:
        if (ZeusTransformUtils.instanceOf(r9, Multisets.ImmutableEntry.class) == true) goto L14;
    L16:
        boolean r19 = false;
    L17:
        if (r19 == false) goto L19;
        r18 = (Multisets.ImmutableEntry) ZeusTransformUtils.preCheckCast(r9, Multisets.ImmutableEntry.class, "com.obric.memorydata.plugin");
        goto L21
    L19:
        r18 = new Multisets.ImmutableEntry(r10, r11);
        goto L21
    L14:
        if (ZeusTransformUtils.instanceOf(r9, NonTerminalEntry.class) == true) goto L16;
        r19 = true;
        goto L17
    L23:
        if (hashFloodingDetected(r4) == false) goto L26;
        return JdkBackedImmutableMultiset.create(ImmutableList.asImmutableList(r3));
    L26:
        return new RegularImmutableMultiset(r3, r4, Ints.b(r5), r7, null);
    L5:
        return new RegularImmutableMultiset(r3, EMPTY_ARRAY, 0, 0, ImmutableSet.of());
    }

    private static boolean hashFloodingDetected(Multisets.ImmutableEntry<?>[] r6) {
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L12;
        Multisets.ImmutableEntry<?> r2 = r6[r1];
        int r3 = 0;
    L6:
        if (r2 == null) goto L11;
        r3 = r3 + 1;
        if (r3 > 9) goto L9;
        r2 = r2.nextInBucket();
        goto L6
    L9:
        return true;
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        return false;
    }

    @Override // com.google.common.collect.an
    public int count(Object r4) {
        Multisets.ImmutableEntry<?>[] r3 = this.hashTable;
        if (r4 != null) goto L5;
    L14:
        return 0;
    L5:
        if (r3.length == 0) goto L14;
        Multisets.ImmutableEntry<?> r5 = r3[ai.a(r4) & (r3.length - 1)];
    L8:
        if (r5 == null) goto L14;
        if (com.google.common.base.k.a(r4, r5.getElement()) == true) goto L12;
        r5 = r5.nextInBucket();
        goto L8
    L12:
        return r5.getCount();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> r0 = this.elementSet;
        if (r0 != null) goto L6;
        ImmutableMultiset.ElementSet r1 = new ImmutableMultiset.ElementSet(Arrays.asList(this.entries), this);
        this.elementSet = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    an.a<E> getEntry(int r1) {
        return this.entries[r1];
    }

    @Override // com.google.common.collect.ImmutableMultiset, java.util.Collection, com.google.common.collect.an
    public int hashCode() {
        return this.hashCode;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
    public int size() {
        return this.size;
    }
}
