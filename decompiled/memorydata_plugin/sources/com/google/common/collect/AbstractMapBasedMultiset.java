package com.google.common.collect;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.google.common.primitives.Ints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractMapBasedMultiset<E> extends d<E> implements Serializable {
    private static final long serialVersionUID = -2250766705698539974L;
    private transient Map<E, Count> backingMap;
    private transient long size;

    private class a implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator<Map.Entry<E, Count>> f4391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map.Entry<E, Count> f4392b;
        int c;
        boolean d;
        final /* synthetic */ AbstractMapBasedMultiset e;

        a(AbstractMapBasedMultiset r1) {
            this.e = r1;
            this.f4391a = AbstractMapBasedMultiset.access$100(r1).entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.c <= 0) goto L5;
        L8:
            return true;
        L5:
            if (this.f4391a.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.c != 0) goto L5;
            Map.Entry<E, Count> r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.f4391a.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            this.f4392b = r0;
            this.c = ((Count) ZeusTransformUtils.preCheckCast(r0.getValue(), Count.class, "com.obric.memorydata.plugin")).get();
        L5:
            this.c--;
            this.d = true;
            return (E) ((Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.f4392b), Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            o.a(this.d);
            if (((Count) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.f4392b), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Count.class, "com.obric.memorydata.plugin")).get() <= 0) goto L10;
            if (((Count) ZeusTransformUtils.preCheckCast(this.f4392b.getValue(), Count.class, "com.obric.memorydata.plugin")).addAndGet(-1) != 0) goto L7;
            this.f4391a.remove();
        L7:
            AbstractMapBasedMultiset.access$010(this.e);
            this.d = false;
            return;
        L10:
            throw new ConcurrentModificationException();
        }
    }

    public AbstractMapBasedMultiset(Map<E, Count> r3) {
        Map<E, Count> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4.isEmpty());
        this.backingMap = r4;
    }

    static /* synthetic */ long access$010(AbstractMapBasedMultiset r4) {
        long r0 = r4.size;
        r4.size = r0 - 1;
        return r0;
    }

    static /* synthetic */ long access$022(AbstractMapBasedMultiset r2, long r3) {
        long r0 = r2.size - r3;
        r2.size = r0;
        return r0;
    }

    static /* synthetic */ Map access$100(AbstractMapBasedMultiset r0) {
        return r0.backingMap;
    }

    private static int getAndSet(Count r0, int r1) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getAndSet(r1);
    }

    static /* synthetic */ void lambda$forEachEntry$0(ObjIntConsumer r2, Object r3, Count r4) {
        ((ObjIntConsumer) ZeusTransformUtils.wrapperContextForParams(r2, ObjIntConsumer.class, "com.obric.memorydata.plugin")).accept(r3, r4.get());
    }

    private void readObjectNoData() {
        throw new InvalidObjectException("Stream data required");
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public int add(E r8, int r9) {
        if (r9 == 0) goto L4;
        boolean r0 = true;
        int r1 = 0;
        if (r9 <= 0) goto L8;
        boolean r2 = true;
    L9:
        com.google.common.base.n.a(r2, "occurrences cannot be negative: %s", r9);
        Count r3 = (Count) ZeusTransformUtils.preCheckCast(this.backingMap.get(r8), Count.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L12;
        this.backingMap.put(r8, new Count(r9));
    L17:
        this.size += (long) r9;
        return r1;
    L12:
        int r10 = r3.get();
        long r4 = ((long) r10) + ((long) r9);
        if (r4 <= 2147483647L) goto L16;
        r0 = false;
    L16:
        com.google.common.base.n.a(r0, "too many occurrences: %s", r4);
        r3.add(r9);
        r1 = r10;
        goto L17
    L8:
        r2 = false;
        goto L9
    L4:
        return count(r8);
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Iterator<Count> r0 = this.backingMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Count) ZeusTransformUtils.preCheckCast(r0.next(), Count.class, "com.obric.memorydata.plugin")).set(0);
        goto L4
    L6:
        this.backingMap.clear();
        this.size = 0;
    }

    @Override // com.google.common.collect.an
    public int count(Object r2) {
        Count r1 = (Count) ZeusTransformUtils.preCheckCast(Maps.a(this.backingMap, r2), Count.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.get();
    }

    @Override // com.google.common.collect.d
    int distinctElements() {
        return this.backingMap.size();
    }

    @Override // com.google.common.collect.d
    Iterator<E> elementIterator() {
        final Iterator<Map.Entry<E, Count>> r0 = this.backingMap.entrySet().iterator();
        return new AnonymousClass1(this, r0);
    }

    @Override // com.google.common.collect.d
    Iterator<an.a<E>> entryIterator() {
        final Iterator<Map.Entry<E, Count>> r0 = this.backingMap.entrySet().iterator();
        return new AnonymousClass2(this, r0);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public Set<an.a<E>> entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.an
    public void forEachEntry(ObjIntConsumer<? super E> r3) {
        final ObjIntConsumer r4 = (ObjIntConsumer) ZeusTransformUtils.wrapperContextForParams(r3, ObjIntConsumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        this.backingMap.forEach(new $$Lambda$AbstractMapBasedMultiset$MYpJnkR8AkttYiKJt9tjmnhWf2c(r4));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.an
    public Iterator<E> iterator() {
        return new a(this);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public int remove(Object r5, int r6) {
        if (r6 != 0) goto L6;
        return count(r5);
    L6:
        if (r6 <= 0) goto L8;
        boolean r1 = true;
    L9:
        com.google.common.base.n.a(r1, "occurrences cannot be negative: %s", r6);
        Count r2 = (Count) ZeusTransformUtils.preCheckCast(this.backingMap.get(r5), Count.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L12;
        return 0;
    L12:
        int r0 = r2.get();
        if (r0 > r6) goto L16;
        this.backingMap.remove(r5);
        r6 = r0;
    L16:
        r2.add(-r6);
        this.size -= (long) r6;
        return r0;
    L8:
        r1 = false;
        goto L9
    }

    void setBackingMap(Map<E, Count> r3) {
        this.backingMap = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public int setCount(E r5, int r6) {
        o.a(r6, CommonConsts.COUNT_TYPE);
        Map<E, Count> r1 = this.backingMap;
        if (r6 != 0) goto L5;
        int r7 = getAndSet((Count) ZeusTransformUtils.preCheckCast(r1.remove(r5), Count.class, "com.obric.memorydata.plugin"), r6);
    L9:
        this.size += (long) (r6 - r7);
        return r7;
    L5:
        Count r0 = (Count) ZeusTransformUtils.preCheckCast(r1.get(r5), Count.class, "com.obric.memorydata.plugin");
        int r2 = getAndSet(r0, r6);
        if (r0 != null) goto L8;
        this.backingMap.put(r5, new Count(r6));
    L8:
        r7 = r2;
        goto L9
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
    public int size() {
        return Ints.b(this.size);
    }
}
