package yd;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class c<T> implements Collection<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T[] f14112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14113b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Object[] r8) {
        he.i.f(r8, "values");
        this.f14112a = r8;
        this.f14113b = false;
    }

    @Override // java.util.Collection
    public final boolean add(T r8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends T> r8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object r8) {
        T[] r10 = this.f14112a;
        he.i.f(r10, "<this>");
        if (r8 != null) goto L10;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L16;
        if (r10[r12] == null) goto L17;
        r12 = r12 + 1;
    L17:
        if (r12 < 0) goto L24;
        return true;
    L24:
        return false;
    L16:
        r12 = -1;
        goto L17
    L10:
        int r13 = r10.length;
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L16;
        if (he.i.a(r8, r10[r14]) == true) goto L14;
        r14 = r14 + 1;
        goto L11
    L14:
        r12 = r14;
        goto L17
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r8) {
        he.i.f(r8, "elements");
        if (r8.isEmpty() == true) goto L15;
        Iterator<T> r10 = r8.iterator();
    L7:
        if (r10.hasNext() == false) goto L16;
        if (contains(r10.next()) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        if (this.f14112a.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        T[] r8 = this.f14112a;
        he.i.f(r8, "array");
        return new he.a(r8);
    }

    @Override // java.util.Collection
    public final boolean remove(Object r8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f14112a.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        T[] r8 = this.f14112a;
        he.i.f(r8, "<this>");
        if (this.f14113b == true) goto L5;
    L7:
        Object[] r10 = Arrays.copyOf(r8, r8.length, Object[].class);
        he.i.e(r10, "copyOf(this, this.size, Array<Any?>::class.java)");
        return r10;
    L5:
        if (he.i.a(r8.getClass(), Object[].class) == false) goto L7;
        return r8;
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] r8) {
        he.i.f(r8, "array");
        return (T[]) l6.a.V0(this, r8);
    }
}
