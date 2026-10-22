package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
abstract class h<E> extends d<E> implements az<E> {
    final Comparator<? super E> comparator;
    private transient az<E> descendingMultiset;

    class a extends t<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f4680a;

        a(h r1) {
            this.f4680a = r1;
        }

        @Override // com.google.common.collect.t
        az<E> a() {
            return this.f4680a;
        }

        @Override // com.google.common.collect.t
        Iterator<an.a<E>> b() {
            return this.f4680a.descendingEntryIterator();
        }

        @Override // com.google.common.collect.t, com.google.common.collect.v, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return this.f4680a.descendingIterator();
        }
    }

    h() {
        this(Ordering.natural());
    }

    h(Comparator<? super E> r3) {
        this.comparator = (Comparator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin");
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    az<E> createDescendingMultiset() {
        return new a(this);
    }

    @Override // com.google.common.collect.d
    NavigableSet<E> createElementSet() {
        return new bb.b(this);
    }

    @Override // com.google.common.collect.d
    /* bridge */ /* synthetic */ Set createElementSet() {
        return createElementSet();
    }

    abstract Iterator<an.a<E>> descendingEntryIterator();

    Iterator<E> descendingIterator() {
        return Multisets.b(descendingMultiset());
    }

    public az<E> descendingMultiset() {
        az<E> r0 = this.descendingMultiset;
        if (r0 != null) goto L6;
        az<E> r1 = createDescendingMultiset();
        this.descendingMultiset = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public NavigableSet<E> elementSet() {
        return (NavigableSet) ZeusTransformUtils.preCheckCast(super.elementSet(), NavigableSet.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    public an.a<E> firstEntry() {
        Iterator<an.a<E>> r2 = entryIterator();
        if (r2.hasNext() == true) goto L7;
        return null;
    L7:
        return (an.a) ZeusTransformUtils.preCheckCast(r2.next(), an.a.class, "com.obric.memorydata.plugin");
    }

    public an.a<E> lastEntry() {
        Iterator<an.a<E>> r2 = descendingEntryIterator();
        if (r2.hasNext() == true) goto L7;
        return null;
    L7:
        return (an.a) ZeusTransformUtils.preCheckCast(r2.next(), an.a.class, "com.obric.memorydata.plugin");
    }

    public an.a<E> pollFirstEntry() {
        Iterator<an.a<E>> r3 = entryIterator();
        if (r3.hasNext() == false) goto L6;
        an.a r0 = (an.a) ZeusTransformUtils.preCheckCast(r3.next(), an.a.class, "com.obric.memorydata.plugin");
        an.a<E> r1 = Multisets.a(r0.getElement(), r0.getCount());
        r3.remove();
        return r1;
    L6:
        return null;
    }

    public an.a<E> pollLastEntry() {
        Iterator<an.a<E>> r3 = descendingEntryIterator();
        if (r3.hasNext() == false) goto L6;
        an.a r0 = (an.a) ZeusTransformUtils.preCheckCast(r3.next(), an.a.class, "com.obric.memorydata.plugin");
        an.a<E> r1 = Multisets.a(r0.getElement(), r0.getCount());
        r3.remove();
        return r1;
    L6:
        return null;
    }

    public az<E> subMultiset(E r1, BoundType r2, E r3, BoundType r4) {
        com.google.common.base.n.a(r2);
        com.google.common.base.n.a(r4);
        return tailMultiset(r1, r2).headMultiset(r3, r4);
    }
}
