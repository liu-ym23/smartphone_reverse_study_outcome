package com.ss.ugc.live.barrage.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import com.ss.ugc.live.barrage.controller.AbsBarrageController;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements List<AbsBarrage>, KMutableList {
    public final b a;
    public final List<AbsBarrage> b;

    /* JADX INFO: renamed from: com.ss.ugc.live.barrage.util.a$a, reason: collision with other inner class name */
    public static final class C0201a implements ListIterator<AbsBarrage>, KMutableListIterator {
        public AbsBarrage a;
        public final ListIterator<AbsBarrage> b;
        public final b c;

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.b.hasNext();
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.b.hasPrevious();
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.b.nextIndex();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.b.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            AbsBarrage r0 = this.b.next();
            this.a = r0;
            return r0;
        }

        @Override // java.util.ListIterator
        public final AbsBarrage previous() {
            AbsBarrage r0 = this.b.previous();
            this.a = r0;
            return r0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            this.b.remove();
            AbsBarrage r0 = this.a;
            if (r0 == null) goto L6;
            r0.p(AbsBarrage.State.HIDDEN);
            this.c.a(r0);
            return;
        }

        @Override // java.util.ListIterator
        public final void add(AbsBarrage r3) {
            AbsBarrage r4 = r3;
            ListIterator<AbsBarrage> r0 = this.b;
            r4.p(AbsBarrage.State.VISIBLE);
            this.c.b();
            r0.add(r4);
        }

        @Override // java.util.ListIterator
        public final void set(AbsBarrage r3) {
            AbsBarrage r4 = r3;
            ListIterator<AbsBarrage> r0 = this.b;
            r4.p(AbsBarrage.State.VISIBLE);
            this.c.b();
            r0.set(r4);
            AbsBarrage r5 = this.a;
            if (r5 == null) goto L6;
            r5.p(AbsBarrage.State.HIDDEN);
            this.c.a(r5);
            return;
        }

        public C0201a(ListIterator<AbsBarrage> r1, b r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    public interface b {
        void a(AbsBarrage r1);

        void b();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r2) {
        return this.b.containsAll(r2);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] r1) {
        return (T[]) CollectionToArray.toArray(this, r1);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        List<AbsBarrage> r0 = this.b;
        Iterator<T> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        AbsBarrage r2 = (AbsBarrage) r1.next();
        r2.p(AbsBarrage.State.HIDDEN);
        this.a.a(r2);
        goto L4
    L6:
        r0.clear();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<AbsBarrage> iterator() {
        return new C0201a(this.b.listIterator(), this.a);
    }

    @Override // java.util.List
    public final ListIterator<AbsBarrage> listIterator() {
        return new C0201a(this.b.listIterator(), this.a);
    }

    @Override // java.util.Collection
    public final Stream<AbsBarrage> parallelStream() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.b.size();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Spliterator<AbsBarrage> spliterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final Stream<AbsBarrage> stream() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object r3) {
        AbsBarrage r4 = (AbsBarrage) r3;
        UtilsKt.a();
        boolean r0 = this.b.add(r4);
        r4.p(AbsBarrage.State.VISIBLE);
        this.a.b();
        return r0;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends AbsBarrage> r4) {
        UtilsKt.a();
        boolean r0 = this.b.addAll(r4);
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((AbsBarrage) r5.next()).p(AbsBarrage.State.VISIBLE);
        this.a.b();
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object r2) {
        if ((r2 instanceof AbsBarrage) == false) goto L6;
        List<AbsBarrage> r0 = this.b;
        return r0.contains((AbsBarrage) r2);
    L6:
        return false;
    }

    @Override // java.util.List
    public final AbsBarrage get(int r2) {
        return (AbsBarrage) ListProtector.get(this.b, r2);
    }

    @Override // java.util.List
    public final int indexOf(Object r2) {
        if ((r2 instanceof AbsBarrage) == false) goto L6;
        List<AbsBarrage> r0 = this.b;
        return r0.indexOf((AbsBarrage) r2);
    L6:
        return -1;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r2) {
        if ((r2 instanceof AbsBarrage) == false) goto L6;
        List<AbsBarrage> r0 = this.b;
        return r0.lastIndexOf((AbsBarrage) r2);
    L6:
        return -1;
    }

    @Override // java.util.List
    public final ListIterator<AbsBarrage> listIterator(int r3) {
        return new C0201a(this.b.listIterator(r3), this.a);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object r3) {
        if ((r3 instanceof AbsBarrage) == false) goto L6;
        AbsBarrage r4 = (AbsBarrage) r3;
        UtilsKt.a();
        boolean r0 = this.b.remove(r4);
        r4.p(AbsBarrage.State.HIDDEN);
        this.a.a(r4);
        return r0;
    L6:
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r4) {
        UtilsKt.a();
        boolean r0 = this.b.removeAll(r4);
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        AbsBarrage r1 = (AbsBarrage) r5.next();
        r1.p(AbsBarrage.State.HIDDEN);
        this.a.a(r1);
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.Collection
    public final boolean removeIf(Predicate<? super AbsBarrage> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<AbsBarrage> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final AbsBarrage remove(int r2) {
        UtilsKt.a();
        AbsBarrage r3 = (AbsBarrage) ListProtector.remove(this.b, r2);
        r3.p(AbsBarrage.State.HIDDEN);
        this.a.a(r3);
        return r3;
    }

    public a(AbsBarrageController.c r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.util.List
    public final void add(int r2, AbsBarrage r3) {
        AbsBarrage r4 = r3;
        UtilsKt.a();
        ListProtector.add(this.b, r2, r4);
        r4.p(AbsBarrage.State.VISIBLE);
        this.a.b();
    }

    @Override // java.util.List
    public final boolean addAll(int r3, Collection<? extends AbsBarrage> r4) {
        UtilsKt.a();
        boolean r5 = this.b.addAll(r3, r4);
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ((AbsBarrage) r6.next()).p(AbsBarrage.State.VISIBLE);
        this.a.b();
        goto L4
    L6:
        return r5;
    }

    @Override // java.util.List
    public final AbsBarrage set(int r3, AbsBarrage r4) {
        AbsBarrage r5 = r4;
        List<AbsBarrage> r0 = this.b;
        r5.p(AbsBarrage.State.VISIBLE);
        this.a.a(r5);
        AbsBarrage r6 = (AbsBarrage) ListProtector.set(r0, r3, r5);
        r6.p(AbsBarrage.State.HIDDEN);
        this.a.a(r6);
        return r6;
    }

    @Override // java.util.List
    public final List<AbsBarrage> subList(int r1, int r2) {
        throw new UnsupportedOperationException();
    }
}
