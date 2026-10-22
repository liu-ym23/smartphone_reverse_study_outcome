package ja;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class s<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f8784s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator<? super K> f8785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8786b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e<K, V> f8787m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f8788n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f8789o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e<K, V> f8790p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public s<K, V>.b f8791q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public s<K, V>.c f8792r;

    public class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        public final int compare(Comparable r8, Comparable r10) {
            return r8.compareTo(r10);
        }
    }

    public class b extends AbstractSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f8793a;

        public class a extends s<K, V>.d<Map.Entry<K, V>> {
            public a(b r8) {
                super(r8.f8793a);
            }

            @Override // java.util.Iterator
            public final Object next() {
                return a();
            }
        }

        public b(s r8) {
            this.f8793a = r8;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            this.f8793a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object r8) {
            if ((r8 instanceof Map.Entry) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f8793a.c((Map.Entry) r8) == null) goto L7;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object r8) {
            if ((r8 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            s r10 = this.f8793a;
            e<K, V> r11 = r10.c((Map.Entry) r8);
            if (r11 != null) goto L8;
            return false;
        L8:
            r10.e(r11, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f8793a.f8788n;
        }
    }

    public final class c extends AbstractSet<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f8794a;

        public class a extends s<K, V>.d<K> {
            public a(c r8) {
                super(r8.f8794a);
            }

            @Override // java.util.Iterator
            public final K next() {
                return a().f8804p;
            }
        }

        public c(s r8) {
            this.f8794a = r8;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            this.f8794a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object r8) {
            return this.f8794a.containsKey(r8);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object r8) {
            s r10 = this.f8794a;
            r10.getClass();
            if (r8 != null) goto L14;
        L6:
            e<K, V> r11 = null;
        L8:
            if (r11 == null) goto L10;
            r10.e(r11, true);
        L10:
            if (r11 != null) goto L12;
            return false;
        L12:
            return true;
        L14:
            r11 = r10.b(r8, false);     // Catch: ClassCastException -> L13
            goto L8
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f8794a.f8788n;
        }
    }

    public abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<K, V> f8795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e<K, V> f8796b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f8797m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ s f8798n;

        public d(s r8) {
            this.f8798n = r8;
            this.f8795a = r8.f8790p.f8802n;
            this.f8796b = null;
            this.f8797m = r8.f8789o;
        }

        public final e<K, V> a() {
            e<K, V> r8 = this.f8795a;
            s r10 = this.f8798n;
            if (r8 == r10.f8790p) goto L11;
            if (r10.f8789o != this.f8797m) goto L9;
            this.f8795a = r8.f8802n;
            this.f8796b = r8;
            return r8;
        L9:
            throw new ConcurrentModificationException();
        L11:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f8795a == this.f8798n.f8790p) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> r8 = this.f8796b;
            if (r8 == null) goto L7;
            s r10 = this.f8798n;
            r10.e(r8, true);
            this.f8796b = null;
            this.f8797m = r10.f8789o;
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    public static final class e<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<K, V> f8799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e<K, V> f8800b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public e<K, V> f8801m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public e<K, V> f8802n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public e<K, V> f8803o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final K f8804p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final boolean f8805q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public V f8806r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f8807s;

        public e(boolean r8) {
            this.f8804p = null;
            this.f8805q = r8;
            this.f8803o = this;
            this.f8802n = this;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object r8) {
            if ((r8 instanceof Map.Entry) == false) goto L20;
            Map.Entry r10 = (Map.Entry) r8;
            K r11 = this.f8804p;
            if (r11 != null) goto L10;
            if (r10.getKey() != null) goto L21;
        L11:
            V r12 = this.f8806r;
            if (r12 != null) goto L17;
            if (r10.getValue() != null) goto L23;
        L18:
            return true;
        L23:
            return false;
        L17:
            if (r12.equals(r10.getValue()) == true) goto L18;
            return false;
        L21:
            return false;
        L10:
            if (r11.equals(r10.getKey()) == true) goto L11;
            return false;
        L20:
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f8804p;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f8806r;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int r8 = 0;
            K r10 = this.f8804p;
            if (r10 != null) goto L5;
            int r11 = 0;
        L6:
            V r12 = this.f8806r;
            if (r12 == null) goto L11;
            r8 = r12.hashCode();
        L11:
            return r11 ^ r8;
        L5:
            r11 = r10.hashCode();
            goto L6
        }

        @Override // java.util.Map.Entry
        public final V setValue(V r8) {
            if (r8 == null) goto L4;
        L8:
            V r10 = this.f8806r;
            this.f8806r = r8;
            return r10;
        L4:
            if (this.f8805q == true) goto L8;
            throw new NullPointerException("value == null");
        }

        public final String toString() {
            return this.f8804p + "=" + this.f8806r;
        }

        public e(boolean r8, e<K, V> r10, K r11, e<K, V> r12, e<K, V> r13) {
            this.f8799a = r10;
            this.f8804p = r11;
            this.f8805q = r8;
            this.f8807s = 1;
            this.f8802n = r12;
            this.f8803o = r13;
            r13.f8802n = this;
            r12.f8803o = this;
        }
    }

    static {
        f8784s = new a();
    }

    public s() {
        this(true);
    }

    public final e<K, V> b(K r13, boolean r14) {
        e<K, V> r8 = this.f8787m;
        a r10 = f8784s;
        Comparator<? super K> r11 = this.f8785a;
        if (r8 == null) goto L19;
        if (r11 != r10) goto L6;
        Comparable r12 = (Comparable) r13;
    L7:
        K r15 = r8.f8804p;
        if (r12 == null) goto L10;
        int r16 = r12.compareTo(r15);
    L11:
        if (r16 == 0) goto L12;
        if (r16 >= 0) goto L15;
        e<K, V> r17 = r8.f8800b;
    L16:
        if (r17 == null) goto L20;
        r8 = r17;
    L20:
        if (r14 == true) goto L22;
        return null;
    L22:
        e<K, V> r18 = this.f8790p;
        if (r8 != null) goto L31;
        if (r11 == r10) goto L26;
    L30:
        e<K, V> r19 = new e(this.f8786b, r8, r13, r18, r18.f8803o);
        this.f8787m = r19;
    L36:
        this.f8788n++;
        this.f8789o++;
        return r19;
    L26:
        if ((r13 instanceof Comparable) == true) goto L30;
        throw new ClassCastException(r13.getClass().getName().concat(" is not Comparable"));
    L31:
        r19 = new e(this.f8786b, r8, r13, r18, r18.f8803o);
        if (r16 >= 0) goto L34;
        r8.f8800b = r19;
    L35:
        d(r8, true);
        goto L36
    L34:
        r8.f8801m = r19;
        goto L35
    L15:
        r17 = r8.f8801m;
        goto L16
    L12:
        return r8;
    L10:
        r16 = r11.compare(r13, r15);
        goto L11
    L6:
        r12 = null;
        goto L7
    L19:
        r16 = 0;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e<K, V> c(Map.Entry<?, ?> r8) {
        Object r10 = r8.getKey();
        boolean r11 = false;
        if (r10 != null) goto L15;
    L6:
        e<K, V> r12 = null;
    L7:
        if (r12 != null) goto L9;
    L11:
        if (r11 == true) goto L13;
        return null;
    L13:
        return r12;
    L9:
        if (Objects.equals(r12.f8806r, r8.getValue()) == false) goto L11;
        r11 = true;
        goto L11
    L15:
        r12 = b(r10, false);     // Catch: ClassCastException -> L14
        goto L7
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f8787m = null;
        this.f8788n = 0;
        this.f8789o++;
        e<K, V> r8 = this.f8790p;
        r8.f8803o = r8;
        r8.f8802n = r8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object r8) {
        if (r8 != 0) goto L11;
    L6:
        e<K, V> r10 = null;
    L7:
        if (r10 == null) goto L13;
        return true;
    L13:
        return false;
    L11:
        r10 = b(r8, false);     // Catch: ClassCastException -> L10
        goto L7
    }

    public final void d(e<K, V> r8, boolean r10) {
    L2:
        if (r8 == null) goto L52;
        e<K, V> r11 = r8.f8800b;
        e<K, V> r12 = r8.f8801m;
        int r13 = 0;
        if (r11 == null) goto L6;
        int r14 = r11.f8807s;
    L7:
        if (r12 == null) goto L9;
        int r15 = r12.f8807s;
    L10:
        int r16 = r14 - r15;
        if (r16 != (-2)) goto L28;
        e<K, V> r17 = r12.f8800b;
        e<K, V> r18 = r12.f8801m;
        if (r18 == null) goto L15;
        int r19 = r18.f8807s;
    L16:
        if (r17 == null) goto L18;
        r13 = r17.f8807s;
    L18:
        int r20 = r13 - r19;
        if (r20 == (-1)) goto L24;
        if (r20 != 0) goto L23;
        if (r10 == false) goto L24;
    L23:
        h(r12);
    L24:
        g(r8);
        if (r10 == false) goto L51;
        return;
    L51:
        r8 = r8.f8799a;
        goto L2
    L15:
        r19 = 0;
        goto L16
    L28:
        if (r16 != 2) goto L44;
        e<K, V> r21 = r11.f8800b;
        e<K, V> r22 = r11.f8801m;
        if (r22 == null) goto L32;
        int r23 = r22.f8807s;
    L33:
        if (r21 == null) goto L35;
        r13 = r21.f8807s;
    L35:
        int r24 = r13 - r23;
        if (r24 == 1) goto L41;
        if (r24 != 0) goto L40;
        if (r10 == false) goto L41;
    L40:
        g(r11);
    L41:
        h(r8);
        if (r10 == false) goto L51;
        return;
    L32:
        r23 = 0;
        goto L33
    L44:
        if (r16 != 0) goto L48;
        r8.f8807s = r14 + 1;
        if (r10 == false) goto L51;
        return;
    L48:
        r8.f8807s = Math.max(r14, r15) + 1;
        if (r10 == true) goto L51;
        return;
    L9:
        r15 = 0;
        goto L10
    L6:
        r14 = 0;
        goto L7
    }

    public final void e(e<K, V> r8, boolean r10) {
        if (r10 == false) goto L4;
        e<K, V> r11 = r8.f8803o;
        r11.f8802n = r8.f8802n;
        r8.f8802n.f8803o = r11;
    L4:
        e<K, V> r12 = r8.f8800b;
        e<K, V> r13 = r8.f8801m;
        e<K, V> r14 = r8.f8799a;
        int r15 = 0;
        if (r12 == null) goto L25;
        if (r13 == null) goto L25;
        if (r12.f8807s <= r13.f8807s) goto L12;
    L9:
        e<K, V> r16 = r12.f8801m;
        if (r16 == null) goto L16;
        r12 = r16;
    L16:
        e(r12, false);
        e<K, V> r17 = r8.f8800b;
        if (r17 == null) goto L19;
        int r18 = r17.f8807s;
        r12.f8800b = r17;
        r17.f8799a = r12;
        r8.f8800b = null;
    L20:
        e<K, V> r19 = r8.f8801m;
        if (r19 == null) goto L23;
        r15 = r19.f8807s;
        r12.f8801m = r19;
        r19.f8799a = r12;
        r8.f8801m = null;
    L23:
        r12.f8807s = Math.max(r18, r15) + 1;
        f(r8, r12);
        return;
    L19:
        r18 = 0;
    L12:
        e<K, V> r20 = r13.f8800b;
        if (r20 == null) goto L15;
        r13 = r20;
        goto L12
    L15:
        r12 = r13;
    L25:
        if (r12 == null) goto L27;
        f(r8, r12);
        r8.f8800b = null;
    L30:
        d(r14, false);
        this.f8788n--;
        this.f8789o++;
        return;
    L27:
        if (r13 == null) goto L29;
        f(r8, r13);
        r8.f8801m = null;
        goto L30
    L29:
        f(r8, null);
        goto L30
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        s<K, V>.b r8 = this.f8791q;
        if (r8 != null) goto L7;
        s<K, V>.b r10 = new b(this);
        this.f8791q = r10;
        return r10;
    L7:
        return r8;
    }

    public final void f(e<K, V> r8, e<K, V> r10) {
        e<K, V> r11 = r8.f8799a;
        r8.f8799a = null;
        if (r10 == null) goto L5;
        r10.f8799a = r11;
    L5:
        if (r11 != null) goto L7;
        this.f8787m = r10;
        return;
    L7:
        if (r11.f8800b != r8) goto L9;
        r11.f8800b = r10;
        return;
    L9:
        r11.f8801m = r10;
    }

    public final void g(e<K, V> r8) {
        e<K, V> r10 = r8.f8800b;
        e<K, V> r11 = r8.f8801m;
        e<K, V> r12 = r11.f8800b;
        e<K, V> r13 = r11.f8801m;
        r8.f8801m = r12;
        if (r12 == null) goto L5;
        r12.f8799a = r8;
    L5:
        f(r8, r11);
        r11.f8800b = r8;
        r8.f8799a = r11;
        int r14 = 0;
        if (r10 == null) goto L8;
        int r15 = r10.f8807s;
    L9:
        if (r12 == null) goto L11;
        int r16 = r12.f8807s;
    L12:
        int r17 = Math.max(r15, r16) + 1;
        r8.f8807s = r17;
        if (r13 == null) goto L15;
        r14 = r13.f8807s;
    L15:
        r11.f8807s = Math.max(r17, r14) + 1;
        return;
    L11:
        r16 = 0;
        goto L12
    L8:
        r15 = 0;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object r8) {
        if (r8 != 0) goto L12;
    L7:
        e<K, V> r10 = null;
    L8:
        if (r10 != null) goto L10;
        return null;
    L10:
        return r10.f8806r;
    L12:
        r10 = b(r8, false);     // Catch: ClassCastException -> L11
        goto L8
    }

    public final void h(e<K, V> r8) {
        e<K, V> r10 = r8.f8800b;
        e<K, V> r11 = r8.f8801m;
        e<K, V> r12 = r10.f8800b;
        e<K, V> r13 = r10.f8801m;
        r8.f8800b = r13;
        if (r13 == null) goto L5;
        r13.f8799a = r8;
    L5:
        f(r8, r10);
        r10.f8801m = r8;
        r8.f8799a = r10;
        int r14 = 0;
        if (r11 == null) goto L8;
        int r15 = r11.f8807s;
    L9:
        if (r13 == null) goto L11;
        int r16 = r13.f8807s;
    L12:
        int r17 = Math.max(r15, r16) + 1;
        r8.f8807s = r17;
        if (r12 == null) goto L15;
        r14 = r12.f8807s;
    L15:
        r10.f8807s = Math.max(r17, r14) + 1;
        return;
    L11:
        r16 = 0;
        goto L12
    L8:
        r15 = 0;
        goto L9
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        s<K, V>.c r8 = this.f8792r;
        if (r8 != null) goto L7;
        s<K, V>.c r10 = new c(this);
        this.f8792r = r10;
        return r10;
    L7:
        return r8;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K r8, V r10) {
        if (r8 == null) goto L12;
        if (r10 == null) goto L5;
    L9:
        e<K, V> r11 = b(r8, true);
        V r12 = r11.f8806r;
        r11.f8806r = r10;
        return r12;
    L5:
        if (this.f8786b == true) goto L9;
        throw new NullPointerException("value == null");
    L12:
        throw new NullPointerException("key == null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object r8) {
        if (r8 != 0) goto L14;
    L7:
        e<K, V> r10 = null;
    L8:
        if (r10 == null) goto L10;
        e(r10, true);
    L10:
        if (r10 != null) goto L12;
        return null;
    L12:
        return r10.f8806r;
    L14:
        r10 = b(r8, false);     // Catch: ClassCastException -> L13
        goto L8
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f8788n;
    }

    public s(boolean r8) {
        a r10 = f8784s;
        this.f8788n = 0;
        this.f8789o = 0;
        this.f8785a = r10;
        this.f8786b = r8;
        this.f8790p = new e(r8);
    }
}
