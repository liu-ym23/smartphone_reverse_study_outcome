package n;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class g<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g<K, V>.b f9380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g<K, V>.c f9381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g<K, V>.e f9382c;

    public final class a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9384b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f9385m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f9386n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ g f9387o;

        public a(g r8, int r10) {
            this.f9387o = r8;
            this.f9386n = false;
            this.f9383a = r10;
            this.f9384b = r8.d();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f9385m >= this.f9384b) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (hasNext() == false) goto L7;
            T r8 = (T) this.f9387o.b(this.f9385m, this.f9383a);
            this.f9385m++;
            this.f9386n = true;
            return r8;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.f9386n == false) goto L7;
            int r8 = this.f9385m - 1;
            this.f9385m = r8;
            this.f9384b--;
            this.f9386n = false;
            this.f9387o.h(r8);
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    public final class b implements Set<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f9388a;

        public b(g r8) {
            this.f9388a = r8;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(Object r8) {
            Map.Entry r10 = (Map.Entry) r8;
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection<? extends Map.Entry<K, V>> r8) {
            g r10 = this.f9388a;
            int r11 = r10.d();
            Iterator<? extends Map.Entry<K, V>> r12 = r8.iterator();
        L4:
            if (r12.hasNext() == false) goto L7;
            Map.Entry<K, V> r13 = r12.next();
            r10.g(r13.getKey(), r13.getValue());
            goto L4
        L7:
            if (r11 == r10.d()) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            this.f9388a.a();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object r8) {
            if ((r8 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r10 = (Map.Entry) r8;
            Object r11 = r10.getKey();
            g r12 = this.f9388a;
            int r13 = r12.e(r11);
            if (r13 >= 0) goto L8;
            return false;
        L8:
            Object r14 = r12.b(r13, 1);
            Object r15 = r10.getValue();
            if (r14 == r15) goto L14;
            if (r14 != null) goto L12;
            return false;
        L12:
            if (r14.equals(r15) == true) goto L14;
            return false;
        L14:
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection<?> r8) {
            Iterator<?> r10 = r8.iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            if (contains(r10.next()) == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object r8) {
            return g.j(this, r8);
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            g r8 = this.f9388a;
            int r10 = r8.d() - 1;
            int r11 = 0;
        L3:
            if (r10 < 0) goto L12;
            Object r12 = r8.b(r10, 0);
            Object r13 = r8.b(r10, 1);
            if (r12 != null) goto L7;
            int r14 = 0;
        L8:
            if (r13 != null) goto L10;
            int r15 = 0;
        L11:
            r11 = r11 + (r14 ^ r15);
            r10 = r10 - 1;
            goto L3
        L10:
            r15 = r13.hashCode();
            goto L11
        L7:
            r14 = r12.hashCode();
            goto L8
        L12:
            return r11;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            if (this.f9388a.d() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new d(this.f9388a);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object r8) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection<?> r8) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection<?> r8) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return this.f9388a.d();
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final <T> T[] toArray(T[] r8) {
            throw new UnsupportedOperationException();
        }
    }

    public final class c implements Set<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f9389a;

        public c(g r8) {
            this.f9389a = r8;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(K r8) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection<? extends K> r8) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            this.f9389a.a();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object r8) {
            if (this.f9389a.e(r8) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection<?> r8) {
            Map<K, V> r10 = this.f9389a.c();
            Iterator<?> r11 = r8.iterator();
        L4:
            if (r11.hasNext() == false) goto L8;
            if (r10.containsKey(r11.next()) == true) goto L4;
            return false;
        L8:
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object r8) {
            return g.j(this, r8);
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            g r8 = this.f9389a;
            int r10 = r8.d() - 1;
            int r11 = 0;
        L3:
            if (r10 < 0) goto L9;
            Object r12 = r8.b(r10, 0);
            if (r12 != null) goto L7;
            int r13 = 0;
        L8:
            r11 = r11 + r13;
            r10 = r10 - 1;
            goto L3
        L7:
            r13 = r12.hashCode();
            goto L8
        L9:
            return r11;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            if (this.f9389a.d() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator<K> iterator() {
            return new a(this.f9389a, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object r8) {
            g r10 = this.f9389a;
            int r11 = r10.e(r8);
            if (r11 < 0) goto L6;
            r10.h(r11);
            return true;
        L6:
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection<?> r8) {
            Map<K, V> r10 = this.f9389a.c();
            int r11 = r10.size();
            Iterator<?> r12 = r8.iterator();
        L4:
            if (r12.hasNext() == false) goto L7;
            r10.remove(r12.next());
            goto L4
        L7:
            if (r11 == r10.size()) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection<?> r8) {
            return g.k(this.f9389a.c(), r8);
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return this.f9389a.d();
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            g r8 = this.f9389a;
            int r10 = r8.d();
            Object[] r11 = new Object[r10];
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L5;
            r11[r12] = r8.b(r12, 0);
            r12 = r12 + 1;
            goto L3
        L5:
            return r11;
        }

        @Override // java.util.Set, java.util.Collection
        public final <T> T[] toArray(T[] r8) {
            return (T[]) this.f9389a.l(r8, 0);
        }
    }

    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9391b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f9392m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ g f9393n;

        public d(g r8) {
            this.f9393n = r8;
            this.f9392m = false;
            this.f9390a = r8.d() - 1;
            this.f9391b = -1;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object r8) {
            if (this.f9392m == false) goto L28;
            if ((r8 instanceof Map.Entry) == true) goto L7;
            return false;
        L7:
            Map.Entry r10 = (Map.Entry) r8;
            Object r11 = r10.getKey();
            int r12 = this.f9391b;
            g r13 = this.f9393n;
            Object r14 = r13.b(r12, 0);
            if (r11 == r14) goto L14;
            if (r11 != null) goto L11;
        L13:
            boolean r15 = false;
        L15:
            if (r15 == false) goto L29;
            Object r16 = r10.getValue();
            Object r17 = r13.b(this.f9391b, 1);
            if (r16 == r17) goto L23;
            if (r16 != null) goto L20;
        L22:
            boolean r18 = false;
        L24:
            if (r18 == true) goto L26;
            return false;
        L26:
            return true;
        L20:
            if (r16.equals(r17) == false) goto L22;
        L23:
            r18 = true;
            goto L24
        L29:
            return false;
        L11:
            if (r11.equals(r14) == false) goto L13;
        L14:
            r15 = true;
            goto L15
        L28:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            if (this.f9392m == false) goto L7;
            int r8 = this.f9391b;
            return (K) this.f9393n.b(r8, 0);
        L7:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            if (this.f9392m == false) goto L7;
            int r8 = this.f9391b;
            return (V) this.f9393n.b(r8, 1);
        L7:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f9391b >= this.f9390a) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            if (this.f9392m == false) goto L14;
            int r8 = this.f9391b;
            g r10 = this.f9393n;
            int r11 = 0;
            Object r12 = r10.b(r8, 0);
            Object r13 = r10.b(this.f9391b, 1);
            if (r12 != null) goto L7;
            int r14 = 0;
        L8:
            if (r13 == null) goto L12;
            r11 = r13.hashCode();
        L12:
            return r14 ^ r11;
        L7:
            r14 = r12.hashCode();
            goto L8
        L14:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (hasNext() == false) goto L7;
            this.f9391b++;
            this.f9392m = true;
            return this;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.f9392m == false) goto L7;
            this.f9393n.h(this.f9391b);
            this.f9391b--;
            this.f9390a--;
            this.f9392m = false;
            return;
        L7:
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public final V setValue(V r8) {
            if (this.f9392m == false) goto L7;
            return (V) this.f9393n.i(this.f9391b, r8);
        L7:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    public final class e implements Collection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f9394a;

        public e(g r8) {
            this.f9394a = r8;
        }

        @Override // java.util.Collection
        public final boolean add(V r8) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends V> r8) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final void clear() {
            this.f9394a.a();
        }

        @Override // java.util.Collection
        public final boolean contains(Object r8) {
            if (this.f9394a.f(r8) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection<?> r8) {
            Iterator<?> r10 = r8.iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            if (contains(r10.next()) == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            if (this.f9394a.d() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return new a(this.f9394a, 1);
        }

        @Override // java.util.Collection
        public final boolean remove(Object r8) {
            g r10 = this.f9394a;
            int r11 = r10.f(r8);
            if (r11 < 0) goto L6;
            r10.h(r11);
            return true;
        L6:
            return false;
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection<?> r8) {
            g r10 = this.f9394a;
            int r11 = r10.d();
            int r12 = 0;
            boolean r13 = false;
        L3:
            if (r12 >= r11) goto L8;
            if (r8.contains(r10.b(r12, 1)) == false) goto L7;
            r10.h(r12);
            r12 = r12 - 1;
            r11 = r11 - 1;
            r13 = true;
        L7:
            r12 = r12 + 1;
            goto L3
        L8:
            return r13;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<?> r8) {
            g r10 = this.f9394a;
            int r11 = r10.d();
            int r12 = 0;
            boolean r13 = false;
        L3:
            if (r12 >= r11) goto L8;
            if (r8.contains(r10.b(r12, 1)) == true) goto L7;
            r10.h(r12);
            r12 = r12 - 1;
            r11 = r11 - 1;
            r13 = true;
        L7:
            r12 = r12 + 1;
            goto L3
        L8:
            return r13;
        }

        @Override // java.util.Collection
        public final int size() {
            return this.f9394a.d();
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            g r8 = this.f9394a;
            int r10 = r8.d();
            Object[] r11 = new Object[r10];
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L5;
            r11[r12] = r8.b(r12, 1);
            r12 = r12 + 1;
            goto L3
        L5:
            return r11;
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] r8) {
            return (T[]) this.f9394a.l(r8, 1);
        }
    }

    public static <T> boolean j(Set<T> r8, Object r10) {
        if (r8 != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Set) == false) goto L15;
        Set r11 = (Set) r10;
        if (r8.size() != r11.size()) goto L14;
        if (r8.containsAll(r11) == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public static <K, V> boolean k(Map<K, V> r8, Collection<?> r10) {
        int r11 = r8.size();
        Iterator<K> r12 = r8.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        if (r10.contains(r12.next()) == true) goto L4;
        r12.remove();
        goto L4
    L9:
        if (r11 == r8.size()) goto L11;
        return true;
    L11:
        return false;
    }

    public abstract void a();

    public abstract Object b(int r8, int r10);

    public abstract Map<K, V> c();

    public abstract int d();

    public abstract int e(Object r8);

    public abstract int f(Object r8);

    public abstract void g(K r8, V r10);

    public abstract void h(int r8);

    public abstract V i(int r8, V r10);

    public final <T> T[] l(T[] r8, int r10) {
        int r11 = d();
        if (r8.length >= r11) goto L5;
        r8 = (T[]) ((Object[]) Array.newInstance(r8.getClass().getComponentType(), r11));
    L5:
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L9;
        T[] r13 = r8;
        r13[r12] = b(r12, r10);
        r12 = r12 + 1;
        goto L6
    L9:
        if (r8.length <= r11) goto L11;
        r8[r11] = null;
    L11:
        return r8;
    }
}
