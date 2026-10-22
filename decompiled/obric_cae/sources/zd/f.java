package zd;

import he.i;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class f<E> extends yd.b<E> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<E, ?> f14366a;

    public f() {
        this.f14366a = new b();
    }

    @Override // yd.b
    public final int a() {
        return this.f14366a.f14353r;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(E r8) {
        if (this.f14366a.b(r8) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends E> r8) {
        i.f(r8, "elements");
        this.f14366a.c();
        return super.addAll(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f14366a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object r8) {
        return this.f14366a.containsKey(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f14366a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<E> iterator() {
        b<E, ?> r8 = this.f14366a;
        r8.getClass();
        return new b.e(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object r8) {
        b<E, ?> r10 = this.f14366a;
        r10.c();
        int r11 = r10.g(r8);
        if (r11 >= 0) goto L5;
        r11 = -1;
    L6:
        if (r11 < 0) goto L8;
        return true;
    L8:
        return false;
    L5:
        r10.j(r11);
        goto L6
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<? extends Object> r8) {
        i.f(r8, "elements");
        this.f14366a.c();
        return super.removeAll(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<? extends Object> r8) {
        i.f(r8, "elements");
        this.f14366a.c();
        return super.retainAll(r8);
    }
}
