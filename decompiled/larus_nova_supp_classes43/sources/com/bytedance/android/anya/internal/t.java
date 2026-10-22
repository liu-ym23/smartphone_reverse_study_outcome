package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.e0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t<T extends MVIState<?>> implements e0<T>, List<T>, KMutableList {
    public Function0<Unit> a;
    public final List<T> b;
    public final List<b> c;

    public class a<T extends MVIState<?>, ITR extends Iterator<? extends T>> implements Iterator<T>, KMutableIterator {
        public int a;
        public final ITR b;
        public int c;
        public final /* synthetic */ t d;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.b.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            int r0 = this.c;
            this.a = r0;
            this.c = r0 + 1;
            return (MVIState) this.b.next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.d.e(new b.d(this.a));
            this.c = this.a;
            this.a = -1;
            this.b.remove();
        }

        public a(t r1, ITR r10, int r11) {
            this.d = r1;
            this.b = r10;
            this.c = r11;
            this.a = -1;
        }
    }

    public static abstract class b {
        public final int a;
        public final int b;

        public static final class a extends b {
            public static final a c = null;

            public a() {
                super(-1, -1);
            }

            static {
                c = new a();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.anya.internal.t$b$b, reason: collision with other inner class name */
        public static final class C0102b extends b {
            public C0102b(int r10) {
                super(r10, 1);
            }
        }

        public static final class c extends b {
            public c(int r10) {
                super(r10, 1);
            }

            public c(int r1, int r10) {
                super(r1, r10);
            }
        }

        public static final class d extends b {
            public d(int r10) {
                super(r10, 1);
            }

            public d(int r1, int r10) {
                super(r1, r10);
            }
        }

        public static final class e extends b {
            public e(int r10) {
                super(r10, 1);
            }
        }

        public final String toString() {
            return "{ type: " + getClass() + ", index: " + this.a + ", count: " + this.b + " }";
        }

        public b(int r1, int r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public final class c<T extends MVIState<?>> extends t<T>.a<T, ListIterator<T>> implements ListIterator<T>, KMutableListIterator {
        public final /* synthetic */ t e;

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return ((ListIterator) this.b).hasPrevious();
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return ((ListIterator) this.b).nextIndex();
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            int r0 = this.c - 1;
            this.c = r0;
            this.a = r0;
            return (MVIState) ((ListIterator) this.b).previous();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return ((ListIterator) this.b).previousIndex();
        }

        @Override // java.util.ListIterator
        public final void add(Object r10) {
            MVIState r11 = (MVIState) r10;
            r11.notifyParentNodeChange = this.e.c();
            this.e.e(new b.c(this.c));
            this.c++;
            this.a = -1;
            ((ListIterator) this.b).add(r11);
        }

        @Override // java.util.ListIterator
        public final void set(Object r10) {
            MVIState r11 = (MVIState) r10;
            r11.notifyParentNodeChange = this.e.c();
            this.e.e(new b.e(this.a));
            ((ListIterator) this.b).set(r11);
        }

        public c(t r1, ListIterator<T> r10, int r11) {
            this.e = r1;
            super(r1, r10, r11);
        }
    }

    public final class d<T extends MVIState<?>> implements List<T>, KMutableList {
        public final List<T> a;
        public final int b;
        public final /* synthetic */ t c;

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection<? extends Object> r10) {
            return this.a.containsAll(r10);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.List
        public final ListIterator<T> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection<? extends Object> r10) {
            return this.a.retainAll(r10);
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
            this.c.e(new b.d(this.b, this.a.size()));
            this.a.clear();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator<T> iterator() {
            return new a(this.c, this.a.iterator(), this.b);
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            return this.a.size();
        }

        @Override // java.util.List, java.util.Collection
        public final boolean add(Object r10) {
            MVIState r11 = (MVIState) r10;
            r11.notifyParentNodeChange = this.c.c();
            this.c.e(new b.c(this.a.size() + this.b));
            return this.a.add((T) r11);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection<? extends T> r10) {
            Iterator<T> r0 = r10.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            MVIState r1 = (MVIState) r0.next();
            r1.notifyParentNodeChange = this.c.c();
            goto L4
        L6:
            this.c.e(new b.c(this.a.size() + this.b, r10.size()));
            return this.a.addAll(r10);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object r10) {
            if ((r10 instanceof MVIState) == false) goto L6;
            List<T> r0 = this.a;
            return r0.contains((MVIState) r10);
        L6:
            return false;
        }

        @Override // java.util.List
        public final Object get(int r10) {
            return (MVIState) ListProtector.get(this.a, r10);
        }

        @Override // java.util.List
        public final int indexOf(Object r10) {
            if ((r10 instanceof MVIState) == false) goto L6;
            List<T> r0 = this.a;
            return r0.indexOf((MVIState) r10);
        L6:
            return -1;
        }

        @Override // java.util.List
        public final int lastIndexOf(Object r10) {
            if ((r10 instanceof MVIState) == false) goto L6;
            List<T> r0 = this.a;
            return r0.lastIndexOf((MVIState) r10);
        L6:
            return -1;
        }

        @Override // java.util.List
        public final ListIterator<T> listIterator(int r10) {
            return new c(this.c, this.a.listIterator(r10), this.b);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object r10) {
            if ((r10 instanceof MVIState) == false) goto L8;
            int r11 = indexOf((MVIState) r10);
            if (r11 < 0) goto L8;
            this.c.e(new b.d(this.b + r11));
            ListProtector.remove(this.a, r11);
            return true;
        L8:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection<? extends Object> r10) {
            Iterator r0 = CollectionsKt.toSet(r10).iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            MVIState r1 = (MVIState) r0.next();
            int r11 = this.a.indexOf(r1);
            if (r11 < 0) goto L4;
            this.c.e(new b.d(r11 + this.b));
            goto L4
        L9:
            return this.a.removeAll(r10);
        }

        @Override // java.util.List
        public final Object remove(int r10) {
            this.c.e(new b.d(this.b + r10));
            return (MVIState) ListProtector.remove(this.a, r10);
        }

        @Override // java.util.List
        public final void add(int r10, Object r11) {
            MVIState r12 = (MVIState) r11;
            r12.notifyParentNodeChange = this.c.c();
            this.c.e(new b.c(this.b + r10));
            ListProtector.add(this.a, r10, r12);
        }

        @Override // java.util.List
        public final boolean addAll(int r10, Collection<? extends T> r11) {
            Iterator<T> r0 = r11.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            MVIState r1 = (MVIState) r0.next();
            r1.notifyParentNodeChange = this.c.c();
            goto L4
        L6:
            this.c.e(new b.c(this.b + r10, r11.size()));
            return this.a.addAll(r10, r11);
        }

        @Override // java.util.List
        public final Object set(int r10, Object r11) {
            MVIState r12 = (MVIState) r11;
            r12.notifyParentNodeChange = this.c.c();
            this.c.e(new b.e(this.b + r10));
            return (MVIState) ListProtector.set(this.a, r10, r12);
        }

        @Override // java.util.List
        public final List<T> subList(int r10, int r11) {
            return new d(this.c, this.a.subList(r10, r11), this.b + r10);
        }

        public d(t r1, List<T> r10, int r11) {
            this.c = r1;
            this.a = r10;
            this.b = r11;
        }
    }

    public t() {
        this(null);
    }

    public final T a(int r10) {
        return (T) ListProtector.get(this.b, r10);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r10) {
        return this.b.containsAll(r10);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r10) {
        return this.b.retainAll(r10);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] r1) {
        return (T[]) CollectionToArray.toArray(this, r1);
    }

    public final Function0<Unit> c() {
        Function0<Unit> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("onChange");
    L5:
        return r0;
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        e(b.a.c);
        this.b.clear();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        return new a(this, this.b.iterator(), 0);
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.b.size();
    }

    public t(Object r10) {
        ArrayList r11 = new ArrayList();
        ArrayList r0 = new ArrayList();
        this.b = r11;
        this.c = r0;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object r10) {
        MVIState r11 = (MVIState) r10;
        Function0<Unit> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("onChange");
    L5:
        r11.notifyParentNodeChange = r0;
        e(new b.c(this.b.size()));
        return this.b.add((T) r11);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends T> r10) {
        Iterator<T> r0 = r10.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        MVIState r1 = (MVIState) r0.next();
        Function0<Unit> r11 = this.a;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("onChange");
    L8:
        r1.notifyParentNodeChange = r11;
        goto L4
    L9:
        e(new b.c(this.b.size(), r10.size()));
        return this.b.addAll(r10);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object r10) {
        if ((r10 instanceof MVIState) == false) goto L6;
        List<T> r0 = this.b;
        return r0.contains((MVIState) r10);
    L6:
        return false;
    }

    public final void d(int r10) {
        e(new b.C0102b(r10));
    }

    public final void e(b r10) {
        Function0<Unit> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("onChange");
    L5:
        r0.invoke();
        b r1 = (b) CollectionsKt.firstOrNull(this.c);
        b.a r11 = b.a.c;
        if (Intrinsics.areEqual(r1, r11) == false) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r10, r11) == false) goto L12;
        this.c.clear();
        this.c.add(r11);
        return;
    L12:
        this.c.add(r10);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int r1) {
        return a(r1);
    }

    @Override // java.util.List
    public final int indexOf(Object r10) {
        if ((r10 instanceof MVIState) == false) goto L6;
        List<T> r0 = this.b;
        return r0.indexOf((MVIState) r10);
    L6:
        return -1;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r10) {
        if ((r10 instanceof MVIState) == false) goto L6;
        List<T> r0 = this.b;
        return r0.lastIndexOf((MVIState) r10);
    L6:
        return -1;
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator(int r10) {
        return new c(this, this.b.listIterator(r10), r10);
    }

    @Override // com.bytedance.android.anya.e0
    public final boolean q(List<? extends T> r10) {
        if (this.b.size() == r10.size()) goto L5;
        boolean r0 = true;
    L6:
        int r1 = Math.min(this.b.size(), r10.size());
        int r11 = 0;
    L7:
        if (r11 >= r1) goto L17;
        i.a((MVIState) ListProtector.get(this.b, r11), (MVIState) ListProtector.get(r10, r11));
        e(new b.C0102b(r11));
        if (r0 == false) goto L11;
    L14:
        r0 = true;
    L15:
        r11 = r11 + 1;
        goto L7
    L11:
        if ((!((MVIState) ListProtector.get(this.b, r11)).modifiedProperties.isEmpty()) == true) goto L14;
        r0 = false;
        goto L15
    L17:
        if (r10.size() <= this.b.size()) goto L20;
        addAll(r10.subList(this.b.size(), r10.size()));
    L22:
        return r0;
    L20:
        if (r10.size() >= this.b.size()) goto L22;
        ((d) subList(r10.size(), this.b.size())).clear();
        goto L22
    L5:
        r0 = false;
        goto L6
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object r10) {
        if ((r10 instanceof MVIState) == false) goto L8;
        int r11 = indexOf((MVIState) r10);
        if (r11 < 0) goto L8;
        e(new b.d(r11));
        ListProtector.remove(this.b, r11);
        return true;
    L8:
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r10) {
        Iterator r0 = CollectionsKt.toSet(r10).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        MVIState r1 = (MVIState) r0.next();
        int r11 = this.b.indexOf(r1);
        if (r11 < 0) goto L4;
        e(new b.d(r11));
        goto L4
    L9:
        return this.b.removeAll(r10);
    }

    @Override // java.util.List
    public final Object remove(int r10) {
        e(new b.d(r10));
        return (MVIState) ListProtector.remove(this.b, r10);
    }

    @Override // java.util.List
    public final void add(int r10, Object r11) {
        MVIState r12 = (MVIState) r11;
        Function0<Unit> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("onChange");
    L5:
        r12.notifyParentNodeChange = r0;
        e(new b.c(r10));
        ListProtector.add(this.b, r10, r12);
    }

    @Override // java.util.List
    public final boolean addAll(int r10, Collection<? extends T> r11) {
        Iterator<T> r0 = r11.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        MVIState r1 = (MVIState) r0.next();
        Function0<Unit> r12 = this.a;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("onChange");
    L8:
        r1.notifyParentNodeChange = r12;
        goto L4
    L9:
        e(new b.c(r10, r11.size()));
        return this.b.addAll(r10, r11);
    }

    @Override // java.util.List
    public final Object set(int r10, Object r11) {
        MVIState r12 = (MVIState) r11;
        Function0<Unit> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("onChange");
    L5:
        r12.notifyParentNodeChange = r0;
        e(new b.e(r10));
        return (MVIState) ListProtector.set(this.b, r10, r12);
    }

    @Override // java.util.List
    public final List<T> subList(int r10, int r11) {
        return new d(this, this.b.subList(r10, r11), r10);
    }
}
