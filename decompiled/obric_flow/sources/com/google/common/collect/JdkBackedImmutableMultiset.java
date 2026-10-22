package com.google.common.collect;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
final class JdkBackedImmutableMultiset<E> extends ImmutableMultiset<E> {
    private final Map<E, Integer> delegateMap;
    public transient ImmutableSet e;
    private final ImmutableList<y7> entries;
    private final long size;

    public JdkBackedImmutableMultiset(HashMap r5, ImmutableList r10, long r11) {
        this.delegateMap = r5;
        this.entries = r10;
        this.size = r11;
    }

    public static <E> ImmutableMultiset<E> create(Collection<? extends y7> r10) {
        int r5 = 0;
        y7[] r11 = (y7[]) r10.toArray(new y7[0]);
        HashMap r12 = p7.X(r11.length);
        long r13 = 0;
    L4:
        if (r5 >= r11.length) goto L10;
        y7 r14 = r11[r5];
        int r15 = r14.getCount();
        r13 = r13 + ((long) r15);
        Object r16 = r14.getElement();
        r16.getClass();
        r12.put(r16, Integer.valueOf(r15));
        if ((r14 instanceof Multisets$ImmutableEntry) == true) goto L8;
        r11[r5] = new Multisets$ImmutableEntry(r16, r15);
    L8:
        r5 = r5 + 1;
        goto L4
    L10:
        return new JdkBackedImmutableMultiset(r12, ImmutableList.asImmutableList(r11), r13);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public int count(Object r5) {
        return this.delegateMap.getOrDefault(r5, 0).intValue();
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
        return this.entries.get(r5);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return dn.a.U(this.size);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> r5 = this.e;
        if (r5 != null) goto L6;
        ImmutableMultiset.ElementSet r10 = new ImmutableMultiset.ElementSet(this.entries, this);
        this.e = r10;
        return r10;
    L6:
        return r5;
    }
}
