package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractMapBasedMultiset<E> extends j0 implements Serializable {
    public static final /* synthetic */ int e = 0;
    private static final long serialVersionUID = -2250766705698539974L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient Map f8788c;
    public transient long d;

    public AbstractMapBasedMultiset(Map<E, Count> r5) {
        com.google.common.base.b0.i(r5.isEmpty());
        this.f8788c = r5;
    }

    public static /* synthetic */ long access$010(AbstractMapBasedMultiset r5) {
        long r10 = r5.d;
        r5.d = r10 - 1;
        return r10;
    }

    public static /* synthetic */ long access$022(AbstractMapBasedMultiset r5, long r10) {
        long r11 = r5.d - r10;
        r5.d = r11;
        return r11;
    }

    public static /* synthetic */ Map access$100(AbstractMapBasedMultiset r5) {
        return r5.f8788c;
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public int add(E r10, int r11) {
        if (r11 == 0) goto L4;
        boolean r5 = true;
        int r12 = 0;
        if (r11 <= 0) goto L8;
        boolean r13 = true;
    L9:
        com.google.common.base.b0.d(r11, "occurrences cannot be negative: %s", r13);
        Count r14 = (Count) this.f8788c.get(r10);
        if (r14 != null) goto L12;
        this.f8788c.put(r10, new Count(r11));
    L17:
        this.d += (long) r11;
        return r12;
    L12:
        int r15 = r14.get();
        long r16 = ((long) r15) + ((long) r11);
        if (r16 <= 2147483647L) goto L16;
        r5 = false;
    L16:
        com.google.common.base.b0.f("too many occurrences: %s", r16, r5);
        r14.add(r11);
        r12 = r15;
        goto L17
    L8:
        r13 = false;
        goto L9
    L4:
        return count(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Iterator<E> r5 = this.f8788c.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((Count) r5.next()).set(0);
        goto L4
    L6:
        this.f8788c.clear();
        this.d = 0;
    }

    @Override // com.google.common.collect.z7
    public int count(Object r5) {
        Count r10 = (Count) p7.l0(this.f8788c, r5);
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.get();
    }

    @Override // com.google.common.collect.j0
    public int distinctElements() {
        return this.f8788c.size();
    }

    @Override // com.google.common.collect.j0
    public Iterator<E> elementIterator() {
        return new a0(this, this.f8788c.entrySet().iterator(), 0);
    }

    @Override // com.google.common.collect.j0
    public Iterator<y7> entryIterator() {
        return new a0(this, this.f8788c.entrySet().iterator(), 1);
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public Set<y7> entrySet() {
        return super.entrySet();
    }

    @Override // java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEach(Consumer r5) {
        super.forEach(r5);
    }

    @Override // com.google.common.collect.z7
    public void forEachEntry(ObjIntConsumer<? super E> r5) {
        r5.getClass();
        this.f8788c.forEach(new h3(r5, 4));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new c0(this);
    }

    @Override // com.google.common.collect.z7
    public int remove(Object r5, int r10) {
        if (r10 != 0) goto L6;
        return count(r5);
    L6:
        if (r10 <= 0) goto L8;
        boolean r11 = true;
    L9:
        com.google.common.base.b0.d(r10, "occurrences cannot be negative: %s", r11);
        Count r12 = (Count) this.f8788c.get(r5);
        if (r12 != null) goto L12;
        return 0;
    L12:
        int r13 = r12.get();
        if (r13 > r10) goto L16;
        this.f8788c.remove(r5);
        r10 = r13;
    L16:
        r12.add(-r10);
        this.d -= (long) r10;
        return r13;
    L8:
        r11 = false;
        goto L9
    }

    public void setBackingMap(Map<E, Count> r5) {
        this.f8788c = r5;
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public int setCount(E r5, int r10) {
        p7.q(r10, "count");
        int r11 = 0;
        if (r10 != 0) goto L8;
        Count r12 = (Count) this.f8788c.remove(r5);
        if (r12 == null) goto L14;
        r11 = r12.getAndSet(r10);
    L14:
        this.d += (long) (r10 - r11);
        return r11;
    L8:
        Count r13 = (Count) this.f8788c.get(r5);
        if (r13 == null) goto L12;
        r11 = r13.getAndSet(r10);
    L12:
        if (r13 != null) goto L14;
        this.f8788c.put(r5, new Count(r10));
        goto L14
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return dn.a.U(this.d);
    }

    @Override // java.util.Collection, java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return super.spliterator();
    }
}
