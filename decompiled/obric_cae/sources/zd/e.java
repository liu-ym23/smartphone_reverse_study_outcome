package zd;

import he.i;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class e<V> extends AbstractCollection<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<?, V> f14365a;

    public e(b<?, V> r8) {
        i.f(r8, "backing");
        this.f14365a = r8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(V r8) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection<? extends V> r8) {
        i.f(r8, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f14365a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object r8) {
        return this.f14365a.containsValue(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.f14365a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        b<?, V> r8 = this.f14365a;
        r8.getClass();
        return new b.f(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object r8) {
        b<?, V> r10 = this.f14365a;
        r10.c();
        int r11 = r10.f14351p;
    L3:
        int r12 = -1;
        r11 = r11 - 1;
        if (r11 < 0) goto L10;
        if (r10.f14348m[r11] < 0) goto L3;
        V[] r13 = r10.f14347b;
        i.c(r13);
        if (i.a(r13[r11], r8) == false) goto L3;
        r12 = r11;
    L10:
        if (r12 >= 0) goto L12;
        return false;
    L12:
        r10.j(r12);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r8) {
        i.f(r8, "elements");
        this.f14365a.c();
        return super.removeAll(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r8) {
        i.f(r8, "elements");
        this.f14365a.c();
        return super.retainAll(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f14365a.f14353r;
    }
}
