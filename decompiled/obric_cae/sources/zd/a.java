package zd;

import he.i;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class a<E> extends yd.a<E> implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public E[] f14337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14338b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14339m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14340n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a<E> f14341o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a<E> f14342p;

    /* JADX INFO: renamed from: zd.a$a, reason: collision with other inner class name */
    public static final class C0207a<E> implements ListIterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a<E> f14343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14344b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f14345m;

        public C0207a(a<E> r8, int r10) {
            i.f(r8, "list");
            this.f14343a = r8;
            this.f14344b = r10;
            this.f14345m = -1;
        }

        @Override // java.util.ListIterator
        public final void add(E r8) {
            int r10 = this.f14344b;
            this.f14344b = r10 + 1;
            this.f14343a.add(r10, r8);
            this.f14345m = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            if (this.f14344b >= this.f14343a.f14339m) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            if (this.f14344b <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final E next() {
            int r8 = this.f14344b;
            a<E> r10 = this.f14343a;
            if (r8 >= r10.f14339m) goto L7;
            this.f14344b = r8 + 1;
            this.f14345m = r8;
            return r10.f14337a[r10.f14338b + r8];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f14344b;
        }

        @Override // java.util.ListIterator
        public final E previous() {
            int r8 = this.f14344b;
            if (r8 <= 0) goto L7;
            int r10 = r8 - 1;
            this.f14344b = r10;
            this.f14345m = r10;
            a<E> r11 = this.f14343a;
            return r11.f14337a[r11.f14338b + r10];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f14344b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            int r8 = this.f14345m;
            if (r8 == (-1)) goto L5;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L10;
            this.f14343a.b(r8);
            this.f14344b = this.f14345m;
            this.f14345m = -1;
            return;
        L10:
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        L5:
            r10 = false;
            goto L6
        }

        @Override // java.util.ListIterator
        public final void set(E r8) {
            int r10 = this.f14345m;
            if (r10 == (-1)) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L10;
            this.f14343a.set(r10, r8);
            return;
        L10:
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        L5:
            r11 = false;
            goto L6
        }
    }

    public a() {
        this(l6.a.m(10), 0, 0, false, null, null);
    }

    @Override // yd.a
    public final int a() {
        return this.f14339m;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r8, E r10) {
        e();
        y0.d.c(r8, this.f14339m);
        d(this.f14338b + r8, r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int r8, Collection<? extends E> r10) {
        i.f(r10, "elements");
        e();
        y0.d.c(r8, this.f14339m);
        int r11 = r10.size();
        c(this.f14338b + r8, r10, r11);
        if (r11 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // yd.a
    public final E b(int r8) {
        e();
        y0.d.b(r8, this.f14339m);
        return g(this.f14338b + r8);
    }

    public final void c(int r8, Collection<? extends E> r10, int r11) {
        a<E> r12 = this.f14341o;
        if (r12 == null) goto L5;
        r12.c(r8, r10, r11);
        this.f14337a = r12.f14337a;
        this.f14339m += r11;
        return;
    L5:
        f(r8, r11);
        Iterator<? extends E> r13 = r10.iterator();
        int r14 = 0;
    L6:
        if (r14 >= r11) goto L10;
        this.f14337a[r8 + r14] = r13.next();
        r14 = r14 + 1;
        goto L6
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        e();
        h(this.f14338b, this.f14339m);
    }

    public final void d(int r8, E r10) {
        a<E> r11 = this.f14341o;
        if (r11 == null) goto L5;
        r11.d(r8, r10);
        this.f14337a = r11.f14337a;
        this.f14339m++;
        return;
    L5:
        f(r8, 1);
        this.f14337a[r8] = r10;
    }

    public final void e() {
        if (this.f14340n == true) goto L10;
        a<E> r8 = this.f14342p;
        if (r8 != null) goto L7;
    L9:
        boolean r10 = false;
    L11:
        if (r10 == true) goto L14;
        return;
    L14:
        throw new UnsupportedOperationException();
    L7:
        if (r8.f14340n == false) goto L9;
    L10:
        r10 = true;
        goto L11
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object r8) {
        if (r8 != this) goto L5;
        return true;
    L5:
        if ((r8 instanceof List) == false) goto L19;
        List r10 = (List) r8;
        E[] r11 = this.f14337a;
        int r12 = this.f14339m;
        if (r12 != r10.size()) goto L13;
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L15;
        if (i.a(r11[this.f14338b + r13], r10.get(r13)) == false) goto L13;
        r13 = r13 + 1;
        goto L10
    L15:
        boolean r14 = true;
    L16:
        if (r14 == false) goto L19;
        return true;
    L13:
        r14 = false;
    L19:
        return false;
    }

    public final void f(int r8, int r10) {
        int r11 = this.f14339m + r10;
        if (this.f14341o != null) goto L21;
        if (r11 < 0) goto L19;
        E[] r12 = this.f14337a;
        if (r11 <= r12.length) goto L16;
        int r13 = r12.length;
        int r14 = r13 + (r13 >> 1);
        if ((r14 - r11) >= 0) goto L11;
        r14 = r11;
    L11:
        if ((r14 - 2147483639) <= 0) goto L15;
        if (r11 <= 2147483639) goto L14;
        r14 = Integer.MAX_VALUE;
        goto L15
    L14:
        r14 = 2147483639;
    L15:
        i.f(r12, "<this>");
        E[] r15 = (E[]) Arrays.copyOf(r12, r14);
        i.e(r15, "copyOf(this, newSize)");
        this.f14337a = r15;
    L16:
        E[] r16 = this.f14337a;
        yd.e.s0(r16, r16, r8 + r10, r8, this.f14338b + this.f14339m);
        this.f14339m += r10;
        return;
    L19:
        throw new OutOfMemoryError();
    L21:
        throw new IllegalStateException();
    }

    public final E g(int r8) {
        a<E> r10 = this.f14341o;
        if (r10 == null) goto L6;
        E r11 = r10.g(r8);
        this.f14339m--;
        return r11;
    L6:
        E[] r12 = this.f14337a;
        E r13 = r12[r8];
        int r14 = this.f14339m;
        int r15 = this.f14338b;
        yd.e.s0(r12, r12, r8, r8 + 1, r14 + r15);
        E[] r16 = this.f14337a;
        int r17 = (r15 + this.f14339m) - 1;
        i.f(r16, "<this>");
        r16[r17] = null;
        this.f14339m--;
        return r13;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int r8) {
        y0.d.b(r8, this.f14339m);
        return this.f14337a[this.f14338b + r8];
    }

    public final void h(int r8, int r10) {
        a<E> r11 = this.f14341o;
        if (r11 == null) goto L5;
        r11.h(r8, r10);
    L6:
        this.f14339m -= r10;
        return;
    L5:
        E[] r12 = this.f14337a;
        yd.e.s0(r12, r12, r8, r8 + r10, this.f14339m);
        E[] r13 = this.f14337a;
        int r14 = this.f14339m;
        l6.a.H0(r14 - r10, r14, r13);
        goto L6
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        E[] r8 = this.f14337a;
        int r10 = this.f14339m;
        int r11 = 1;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L9;
        E r13 = r8[this.f14338b + r12];
        int r14 = r11 * 31;
        if (r13 == null) goto L7;
        int r15 = r13.hashCode();
    L8:
        r11 = r14 + r15;
        r12 = r12 + 1;
        goto L3
    L7:
        r15 = 0;
        goto L8
    L9:
        return r11;
    }

    public final int i(int r8, int r10, Collection<? extends E> r11, boolean r12) {
        a<E> r13 = this.f14341o;
        if (r13 == null) goto L6;
        int r14 = r13.i(r8, r10, r11, r12);
        this.f14339m -= r14;
        return r14;
    L6:
        int r15 = 0;
        int r16 = 0;
    L7:
        if (r15 >= r10) goto L12;
        int r17 = r8 + r15;
        if (r11.contains(this.f14337a[r17]) == r12) goto L10;
        r15 = r15 + 1;
        goto L7
    L10:
        E[] r18 = this.f14337a;
        r15 = r15 + 1;
        r18[r16 + r8] = r18[r17];
        r16 = r16 + 1;
        goto L7
    L12:
        int r19 = r10 - r16;
        E[] r20 = this.f14337a;
        yd.e.s0(r20, r20, r8 + r16, r10 + r8, this.f14339m);
        E[] r21 = this.f14337a;
        int r22 = this.f14339m;
        l6.a.H0(r22 - r19, r22, r21);
        this.f14339m -= r19;
        return r19;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object r8) {
        int r10 = 0;
    L4:
        if (r10 >= this.f14339m) goto L9;
        if (i.a(this.f14337a[this.f14338b + r10], r8) == true) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return r10;
    L9:
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        if (this.f14339m != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<E> iterator() {
        return new C0207a(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object r8) {
        int r10 = this.f14339m - 1;
    L3:
        if (r10 < 0) goto L8;
        if (i.a(this.f14337a[this.f14338b + r10], r8) == true) goto L6;
        r10 = r10 - 1;
        goto L3
    L6:
        return r10;
    L8:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<E> listIterator() {
        return new C0207a(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object r8) {
        e();
        int r10 = indexOf(r8);
        if (r10 < 0) goto L5;
        b(r10);
    L5:
        if (r10 < 0) goto L7;
        return true;
    L7:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection<? extends Object> r8) {
        i.f(r8, "elements");
        e();
        int r10 = this.f14339m;
        if (i(this.f14338b, r10, r8, false) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection<? extends Object> r8) {
        i.f(r8, "elements");
        e();
        int r10 = this.f14339m;
        if (i(this.f14338b, r10, r8, true) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int r8, E r10) {
        e();
        y0.d.b(r8, this.f14339m);
        E[] r11 = this.f14337a;
        int r12 = this.f14338b + r8;
        E r13 = r11[r12];
        r11[r12] = r10;
        return r13;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List<E> subList(int r10, int r11) {
        int r8 = this.f14339m;
        if (r10 < 0) goto L14;
        if (r11 > r8) goto L14;
        if (r10 > r11) goto L13;
        E[] r12 = this.f14337a;
        int r13 = this.f14338b + r10;
        int r14 = r11 - r10;
        boolean r15 = this.f14340n;
        a<E> r16 = this.f14342p;
        if (r16 != null) goto L9;
        a<E> r17 = this;
    L11:
        return new a(r12, r13, r14, r15, this, r17);
    L9:
        r17 = r16;
        goto L11
    L13:
        throw new IllegalArgumentException("fromIndex: " + r10 + " > toIndex: " + r11);
    L14:
        StringBuilder r18 = defpackage.a.g("fromIndex: ", r10, ", toIndex: ", r11, ", size: ");
        r18.append(r8);
        throw new IndexOutOfBoundsException(r18.toString());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        E[] r8 = this.f14337a;
        int r10 = this.f14339m;
        int r11 = this.f14338b;
        int r12 = r10 + r11;
        i.f(r8, "<this>");
        int r13 = r8.length;
        if (r12 > r13) goto L7;
        Object[] r14 = Arrays.copyOfRange(r8, r11, r12);
        i.e(r14, "copyOfRange(this, fromIndex, toIndex)");
        return r14;
    L7:
        throw new IndexOutOfBoundsException("toIndex (" + r12 + ") is greater than size (" + r13 + ").");
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        E[] r8 = this.f14337a;
        int r10 = this.f14339m;
        StringBuilder r11 = new StringBuilder((r10 * 3) + 2);
        r11.append("[");
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L7;
        if (r12 <= 0) goto L6;
        r11.append(", ");
    L6:
        r11.append(r8[this.f14338b + r12]);
        r12 = r12 + 1;
        goto L3
    L7:
        r11.append("]");
        String r13 = r11.toString();
        i.e(r13, "sb.toString()");
        return r13;
    }

    public a(E[] r8, int r10, int r11, boolean r12, a<E> r13, a<E> r14) {
        this.f14337a = r8;
        this.f14338b = r10;
        this.f14339m = r11;
        this.f14340n = r12;
        this.f14341o = r13;
        this.f14342p = r14;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E r8) {
        e();
        d(this.f14338b + this.f14339m, r8);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends E> r8) {
        i.f(r8, "elements");
        e();
        int r10 = r8.size();
        c(this.f14338b + this.f14339m, r8, r10);
        if (r10 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<E> listIterator(int r8) {
        y0.d.c(r8, this.f14339m);
        return new C0207a(this, r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final <T> T[] toArray(T[] r8) {
        i.f(r8, "destination");
        int r10 = r8.length;
        int r11 = this.f14339m;
        int r12 = this.f14338b;
        if (r10 >= r11) goto L6;
        T[] r13 = (T[]) Arrays.copyOfRange(this.f14337a, r12, r11 + r12, r8.getClass());
        i.e(r13, "copyOfRange(array, offse…h, destination.javaClass)");
        return r13;
    L6:
        yd.e.s0(this.f14337a, r8, 0, r12, r11 + r12);
        int r14 = r8.length;
        int r15 = this.f14339m;
        if (r14 <= r15) goto L9;
        r8[r15] = null;
    L9:
        return r8;
    }
}
