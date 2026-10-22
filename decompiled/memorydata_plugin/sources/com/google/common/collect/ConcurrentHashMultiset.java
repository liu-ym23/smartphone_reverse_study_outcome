package com.google.common.collect;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.google.common.primitives.Ints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class ConcurrentHashMultiset<E> extends d<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> countMap;

    private class a extends d<E>.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMultiset f4423b;

        private a(ConcurrentHashMultiset r1) {
            this.f4423b = r1;
            super(r1);
        }

        /* synthetic */ a(ConcurrentHashMultiset r1, AnonymousClass1 r2) {
            this(r1);
        }

        private List<an.a<E>> c() {
            ArrayList r0 = Lists.c(size());
            Iterators.a(r0, iterator());
            return r0;
        }

        @Override // com.google.common.collect.d.b, com.google.common.collect.Multisets.c
        /* synthetic */ an a() {
            return b();
        }

        ConcurrentHashMultiset<E> b() {
            return this.f4423b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return c().toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r1) {
            return (T[]) c().toArray(r1);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final av.a<ConcurrentHashMultiset> f4424a = null;

        static {
            f4424a = av.a(ConcurrentHashMultiset.class, "countMap");
        }
    }

    ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> r3) {
        ConcurrentMap<E, AtomicInteger> r4 = (ConcurrentMap) ZeusTransformUtils.wrapperContextForParams(r3, ConcurrentMap.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4.isEmpty(), "the backing map (%s) must be empty", r4);
        this.countMap = r4;
    }

    static /* synthetic */ ConcurrentMap access$100(ConcurrentHashMultiset r0) {
        return r0.countMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset(new ConcurrentHashMap());
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        ConcurrentHashMultiset<E> r0 = create();
        aj.a(r0, r3);
        return r0;
    }

    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> r2) {
        return new ConcurrentHashMultiset((ConcurrentMap) ZeusTransformUtils.wrapperContextForParams(r2, ConcurrentMap.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        ConcurrentMap r4 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(r3.readObject(), ConcurrentMap.class, "com.obric.memorydata.plugin");
        b.f4424a.a(this, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<E> snapshot() {
        ArrayList r0 = Lists.c(size());
        Iterator<E> r4 = entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        an.a r1 = (an.a) ZeusTransformUtils.preCheckCast(r4.next(), an.a.class, "com.obric.memorydata.plugin");
        Object r2 = r1.getElement();
        int r3 = r1.getCount();
    L6:
        if (r3 <= 0) goto L4;
        r0.add(r2);
        r3 = r3 - 1;
        goto L6
    L8:
        return r0;
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(this.countMap);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public int add(E r5, int r6) {
        com.google.common.base.n.a(r5);
        if (r6 == 0) goto L5;
        o.b(r6, "occurrences");
    L7:
        AtomicInteger r0 = (AtomicInteger) ZeusTransformUtils.preCheckCast(Maps.a(this.countMap, r5), AtomicInteger.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L12;
        r0 = (AtomicInteger) ZeusTransformUtils.preCheckCast(this.countMap.putIfAbsent(r5, new AtomicInteger(r6)), AtomicInteger.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L12;
        return 0;
    L12:
        int r2 = r0.get();
        if (r2 == 0) goto L19;
        if (r0.compareAndSet(r2, com.google.common.math.c.b(r2, r6)) == false) goto L12;
        return r2;
    L18:
        throw new IllegalArgumentException("Overflow adding " + r6 + " occurrences to a count of " + r2);
    L19:
        AtomicInteger r3 = new AtomicInteger(r6);
        if (this.countMap.putIfAbsent(r5, r3) == null) goto L23;
        if (this.countMap.replace(r5, r0, r3) == false) goto L7;
    L23:
        return 0;
    L5:
        return count(r5);
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.countMap.clear();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
    public /* bridge */ /* synthetic */ boolean contains(Object r1) {
        return super.contains(r1);
    }

    @Override // com.google.common.collect.an
    public int count(Object r2) {
        AtomicInteger r1 = (AtomicInteger) ZeusTransformUtils.preCheckCast(Maps.a(this.countMap, r2), AtomicInteger.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.get();
    }

    @Override // com.google.common.collect.d
    Set<E> createElementSet() {
        final Set<E> r0 = this.countMap.keySet();
        return new AnonymousClass1(this, r0);
    }

    @Override // com.google.common.collect.d
    @Deprecated
    public Set<an.a<E>> createEntrySet() {
        return new a(this, null);
    }

    @Override // com.google.common.collect.d
    int distinctElements() {
        return this.countMap.size();
    }

    @Override // com.google.common.collect.d
    Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.d
    Iterator<an.a<E>> entryIterator() {
        final AbstractIterator<an.a<E>> r0 = new AnonymousClass2(this);
        return new AnonymousClass3(this, r0);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.an
    public Iterator<E> iterator() {
        return Multisets.b(this);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public int remove(Object r6, int r7) {
        if (r7 == 0) goto L4;
        o.b(r7, "occurrences");
        AtomicInteger r0 = (AtomicInteger) ZeusTransformUtils.preCheckCast(Maps.a(this.countMap, r6), AtomicInteger.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        return 0;
    L8:
        int r2 = r0.get();
        if (r2 == 0) goto L15;
        int r3 = Math.max(0, r2 - r7);
        if (r0.compareAndSet(r2, r3) == false) goto L8;
        if (r3 != 0) goto L14;
        this.countMap.remove(r6, r0);
    L14:
        return r2;
    L15:
        return 0;
    L4:
        return count(r6);
    }

    public boolean removeExactly(Object r6, int r7) {
        if (r7 != 0) goto L5;
        return true;
    L5:
        o.b(r7, "occurrences");
        AtomicInteger r1 = (AtomicInteger) ZeusTransformUtils.preCheckCast(Maps.a(this.countMap, r6), AtomicInteger.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L8;
        return false;
    L8:
        int r3 = r1.get();
        if (r3 < r7) goto L10;
        int r4 = r3 - r7;
        if (r1.compareAndSet(r3, r4) == false) goto L8;
        if (r4 != 0) goto L15;
        this.countMap.remove(r6, r1);
    L15:
        return true;
    L10:
        return false;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public int setCount(E r5, int r6) {
        com.google.common.base.n.a(r5);
        o.a(r6, CommonConsts.COUNT_TYPE);
    L3:
        AtomicInteger r0 = (AtomicInteger) ZeusTransformUtils.preCheckCast(Maps.a(this.countMap, r5), AtomicInteger.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        if (r6 == 0) goto L6;
        r0 = (AtomicInteger) ZeusTransformUtils.preCheckCast(this.countMap.putIfAbsent(r5, new AtomicInteger(r6)), AtomicInteger.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        return 0;
    L6:
        return 0;
    L10:
        int r2 = r0.get();
        if (r2 == 0) goto L12;
        if (r0.compareAndSet(r2, r6) == false) goto L10;
        if (r6 != 0) goto L23;
        this.countMap.remove(r5, r0);
    L23:
        return r2;
    L12:
        if (r6 == 0) goto L13;
        AtomicInteger r3 = new AtomicInteger(r6);
        if (this.countMap.putIfAbsent(r5, r3) == null) goto L18;
        if (this.countMap.replace(r5, r0, r3) == false) goto L3;
    L18:
        return 0;
    L13:
        return 0;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public boolean setCount(E r5, int r6, int r7) {
        com.google.common.base.n.a(r5);
        o.a(r6, "oldCount");
        o.a(r7, "newCount");
        AtomicInteger r0 = (AtomicInteger) ZeusTransformUtils.preCheckCast(Maps.a(this.countMap, r5), AtomicInteger.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L12;
        if (r6 == 0) goto L6;
        return false;
    L6:
        if (r7 != 0) goto L9;
        return true;
    L9:
        if (this.countMap.putIfAbsent(r5, new AtomicInteger(r7)) == null) goto L11;
        return false;
    L11:
        return true;
    L12:
        int r3 = r0.get();
        if (r3 != r6) goto L29;
        if (r3 != 0) goto L25;
        if (r7 != 0) goto L18;
        this.countMap.remove(r5, r0);
        return true;
    L18:
        AtomicInteger r8 = new AtomicInteger(r7);
        if (this.countMap.putIfAbsent(r5, r8) == null) goto L23;
        if (this.countMap.replace(r5, r0, r8) == true) goto L23;
        return false;
    L23:
        return true;
    L25:
        if (r0.compareAndSet(r3, r7) == false) goto L29;
        if (r7 != 0) goto L28;
        this.countMap.remove(r5, r0);
    L28:
        return true;
    L29:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
    public int size() {
        Iterator<AtomicInteger> r5 = this.countMap.values().iterator();
        long r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L7;
        r0 = r0 + ((long) ((AtomicInteger) ZeusTransformUtils.preCheckCast(r5.next(), AtomicInteger.class, "com.obric.memorydata.plugin")).get());
        goto L4
    L7:
        return Ints.b(r0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return snapshot().toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] r1) {
        return (T[]) snapshot().toArray(r1);
    }
}
