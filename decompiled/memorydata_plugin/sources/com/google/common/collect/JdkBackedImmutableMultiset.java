package com.google.common.collect;

import com.google.common.primitives.Ints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class JdkBackedImmutableMultiset<E> extends ImmutableMultiset<E> {
    private final Map<E, Integer> delegateMap;
    private transient ImmutableSet<E> elementSet;
    private final ImmutableList<an.a<E>> entries;
    private final long size;

    private JdkBackedImmutableMultiset(Map<E, Integer> r3, ImmutableList<an.a<E>> r4, long r5) {
        this.delegateMap = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this.entries = r4;
        this.size = r5;
    }

    static <E> ImmutableMultiset<E> create(Collection<? extends an.a<? extends E>> r8) {
        int r0 = 0;
        an.a[] r9 = (an.a[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.wrapperContextForParams(r8, Collection.class, "com.obric.memorydata.plugin")).toArray(new an.a[0]), an.a[].class, "com.obric.memorydata.plugin");
        HashMap r1 = Maps.a(r9.length);
        long r2 = 0;
    L4:
        if (r0 >= r9.length) goto L10;
        an.a r4 = r9[r0];
        int r5 = r4.getCount();
        r2 = r2 + ((long) r5);
        Object r6 = com.google.common.base.n.a(r4.getElement());
        r1.put(r6, Integer.valueOf(r5));
        if (ZeusTransformUtils.instanceOf(r4, Multisets.ImmutableEntry.class) == true) goto L8;
        r9[r0] = Multisets.a(r6, r5);
    L8:
        r0 = r0 + 1;
        goto L4
    L10:
        return new JdkBackedImmutableMultiset(r1, ImmutableList.asImmutableList(r9), r2);
    }

    @Override // com.google.common.collect.an
    public int count(Object r2) {
        return ((Integer) ZeusTransformUtils.preCheckCast(this.delegateMap.getOrDefault(r2, 0), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> r0 = this.elementSet;
        if (r0 != null) goto L6;
        ImmutableMultiset.ElementSet r1 = new ImmutableMultiset.ElementSet(this.entries, this);
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
    an.a<E> getEntry(int r2) {
        return (an.a) ZeusTransformUtils.preCheckCast(this.entries.get(r2), an.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
    public int size() {
        return Ints.b(this.size);
    }
}
