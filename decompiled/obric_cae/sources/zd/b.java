package zd;

import he.i;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class b<K, V> implements Map<K, V>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public K[] f14346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public V[] f14347b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f14348m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f14349n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14350o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14351p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14352q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f14353r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public zd.d<K> f14354s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public zd.e<V> f14355t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public zd.c<K, V> f14356u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f14357v;

    public static final class a {
    }

    /* JADX INFO: renamed from: zd.b$b, reason: collision with other inner class name */
    public static final class C0208b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>> {
        public C0208b(b<K, V> r8) {
            i.f(r8, "map");
            super(r8);
        }

        @Override // java.util.Iterator
        public final Object next() {
            int r8 = this.f14361b;
            b<K, V> r10 = this.f14360a;
            if (r8 >= r10.f14351p) goto L7;
            this.f14361b = r8 + 1;
            this.f14362m = r8;
            c r11 = new c(r10, r8);
            a();
            return r11;
        L7:
            throw new NoSuchElementException();
        }
    }

    public static final class c<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b<K, V> f14358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14359b;

        public c(b<K, V> r8, int r10) {
            i.f(r8, "map");
            this.f14358a = r8;
            this.f14359b = r10;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object r8) {
            if ((r8 instanceof Map.Entry) == false) goto L9;
            Map.Entry r10 = (Map.Entry) r8;
            if (i.a(r10.getKey(), getKey()) == false) goto L9;
            if (i.a(r10.getValue(), getValue()) == false) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f14358a.f14346a[this.f14359b];
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            V[] r8 = this.f14358a.f14347b;
            i.c(r8);
            return r8[this.f14359b];
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K r8 = getKey();
            int r10 = 0;
            if (r8 == null) goto L5;
            int r11 = r8.hashCode();
        L6:
            V r12 = getValue();
            if (r12 == null) goto L10;
            r10 = r12.hashCode();
        L10:
            return r11 ^ r10;
        L5:
            r11 = 0;
            goto L6
        }

        @Override // java.util.Map.Entry
        public final V setValue(V r8) {
            b<K, V> r10 = this.f14358a;
            r10.c();
            V[] r11 = r10.f14347b;
            if (r11 != null) goto L6;
            r11 = (V[]) l6.a.m(r10.f14346a.length);
            r10.f14347b = r11;
        L6:
            int r12 = this.f14359b;
            V r13 = r11[r12];
            r11[r12] = r8;
            return r13;
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder();
            r8.append(getKey());
            r8.append('=');
            r8.append(getValue());
            return r8.toString();
        }
    }

    public static class d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b<K, V> f14360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14361b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f14362m;

        public d(b<K, V> r8) {
            i.f(r8, "map");
            this.f14360a = r8;
            this.f14362m = -1;
            a();
        }

        public final void a() {
        L2:
            int r8 = this.f14361b;
            b<K, V> r10 = this.f14360a;
            if (r8 >= r10.f14351p) goto L7;
            if (r10.f14348m[r8] >= 0) goto L10;
            this.f14361b = r8 + 1;
            goto L2
        L10:
            return;
        }

        public final boolean hasNext() {
            if (this.f14361b >= this.f14360a.f14351p) goto L5;
            return true;
        L5:
            return false;
        }

        public final void remove() {
            if (this.f14362m == (-1)) goto L5;
            boolean r8 = true;
        L6:
            if (r8 == false) goto L10;
            b<K, V> r10 = this.f14360a;
            r10.c();
            r10.j(this.f14362m);
            this.f14362m = -1;
            return;
        L10:
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        L5:
            r8 = false;
            goto L6
        }
    }

    public static final class e<K, V> extends d<K, V> implements Iterator<K> {
        @Override // java.util.Iterator
        public final K next() {
            int r8 = this.f14361b;
            b<K, V> r10 = this.f14360a;
            if (r8 >= r10.f14351p) goto L7;
            this.f14361b = r8 + 1;
            this.f14362m = r8;
            K r11 = r10.f14346a[r8];
            a();
            return r11;
        L7:
            throw new NoSuchElementException();
        }
    }

    public static final class f<K, V> extends d<K, V> implements Iterator<V> {
        @Override // java.util.Iterator
        public final V next() {
            int r8 = this.f14361b;
            b<K, V> r10 = this.f14360a;
            if (r8 >= r10.f14351p) goto L7;
            this.f14361b = r8 + 1;
            this.f14362m = r8;
            V[] r11 = r10.f14347b;
            i.c(r11);
            V r12 = r11[this.f14362m];
            a();
            return r12;
        L7:
            throw new NoSuchElementException();
        }
    }

    static {
        new a();
    }

    public b() {
        K[] r8 = (K[]) l6.a.m(8);
        int r10 = Integer.highestOneBit(24);
        this.f14346a = r8;
        this.f14347b = null;
        this.f14348m = new int[8];
        this.f14349n = new int[r10];
        this.f14350o = 2;
        this.f14351p = 0;
        this.f14352q = Integer.numberOfLeadingZeros(r10) + 1;
    }

    public final int b(K r8) {
        c();
    L3:
        int r10 = h(r8);
        int r11 = this.f14350o * 2;
        int r12 = this.f14349n.length / 2;
        if (r11 <= r12) goto L6;
        r11 = r12;
    L6:
        int r13 = 0;
    L7:
        int[] r14 = this.f14349n;
        int r15 = r14[r10];
        if (r15 <= 0) goto L9;
        if (i.a(this.f14346a[r15 - 1], r8) == true) goto L19;
        r13 = r13 + 1;
        if (r13 > r11) goto L22;
        int r16 = r10 - 1;
        if (r10 == 0) goto L25;
        r10 = r16;
        goto L7
    L25:
        r10 = this.f14349n.length - 1;
        goto L7
    L22:
        i(this.f14349n.length * 2);
        goto L3
    L19:
        return -r15;
    L9:
        int r17 = this.f14351p;
        K[] r18 = this.f14346a;
        if (r17 < r18.length) goto L12;
        f(1);
        goto L3
    L12:
        int r19 = r17 + 1;
        this.f14351p = r19;
        r18[r17] = r8;
        this.f14348m[r17] = r10;
        r14[r10] = r19;
        this.f14353r++;
        if (r13 <= this.f14350o) goto L15;
        this.f14350o = r13;
    L15:
        return r17;
    }

    public final void c() {
        if (this.f14357v == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void clear() {
        c();
        ke.b r8 = new ke.c(0, this.f14351p - 1).a();
    L4:
        if (r8.hasNext() == false) goto L8;
        int r10 = r8.nextInt();
        int[] r11 = this.f14348m;
        int r12 = r11[r10];
        if (r12 < 0) goto L4;
        this.f14349n[r12] = 0;
        r11[r10] = -1;
        goto L4
    L8:
        l6.a.H0(0, this.f14351p, this.f14346a);
        V[] r13 = this.f14347b;
        if (r13 == null) goto L11;
        l6.a.H0(0, this.f14351p, r13);
    L11:
        this.f14353r = 0;
        this.f14351p = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final boolean containsKey(Object r8) {
        if (g(r8) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r8) {
        int r10 = this.f14351p;
    L3:
        int r11 = -1;
        r10 = r10 - 1;
        if (r10 < 0) goto L10;
        if (this.f14348m[r10] < 0) goto L3;
        V[] r12 = this.f14347b;
        i.c(r12);
        if (i.a(r12[r10], r8) == false) goto L3;
        r11 = r10;
    L10:
        if (r11 < 0) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean d(Collection<?> r8) {
        i.f(r8, "m");
        Iterator<?> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Object r11 = r10.next();
        if (r11 == null) goto L9;
        if (e((Map.Entry) r11) == true) goto L4;
    L9:
        return false;
    L10:
        return true;
    }

    public final boolean e(Map.Entry<? extends K, ? extends V> r8) {
        i.f(r8, "entry");
        int r10 = g(r8.getKey());
        if (r10 >= 0) goto L6;
        return false;
    L6:
        V[] r11 = this.f14347b;
        i.c(r11);
        return i.a(r11[r10], r8.getValue());
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        zd.c<K, V> r8 = this.f14356u;
        if (r8 != null) goto L6;
        zd.c<K, V> r10 = new zd.c(this);
        this.f14356u = r10;
        return r10;
    L6:
        return r8;
    }

    @Override // java.util.Map
    public final boolean equals(Object r8) {
        if (r8 != this) goto L5;
        return true;
    L5:
        if ((r8 instanceof Map) == false) goto L15;
        Map r10 = (Map) r8;
        if (this.f14353r == r10.size()) goto L9;
    L11:
        boolean r11 = false;
    L12:
        if (r11 == false) goto L15;
        return true;
    L9:
        if (d(r10.entrySet()) == false) goto L11;
        r11 = true;
    L15:
        return false;
    }

    public final void f(int r8) {
        K[] r10 = this.f14346a;
        int r11 = r10.length;
        int r12 = this.f14351p;
        int r13 = r11 - r12;
        int r14 = r12 - this.f14353r;
        int r15 = 1;
        if (r13 < r8) goto L5;
    L9:
        boolean r16 = false;
    L10:
        if (r16 == false) goto L12;
        i(this.f14349n.length);
        return;
    L12:
        int r17 = r12 + r8;
        if (r17 < 0) goto L33;
        if (r17 <= r10.length) goto L35;
        int r18 = (r10.length * 3) / 2;
        if (r17 > r18) goto L20;
        r17 = r18;
    L20:
        K[] r19 = (K[]) Arrays.copyOf(r10, r17);
        i.e(r19, "copyOf(this, newSize)");
        this.f14346a = r19;
        V[] r20 = this.f14347b;
        if (r20 == null) goto L23;
        V[] r21 = (V[]) Arrays.copyOf(r20, r17);
        i.e(r21, "copyOf(this, newSize)");
    L24:
        this.f14347b = r21;
        int[] r22 = Arrays.copyOf(this.f14348m, r17);
        i.e(r22, "copyOf(this, newSize)");
        this.f14348m = r22;
        if (r17 < 1) goto L28;
        r15 = r17;
    L28:
        int r23 = Integer.highestOneBit(r15 * 3);
        if (r23 <= this.f14349n.length) goto L36;
        i(r23);
        return;
    L36:
        return;
    L23:
        r21 = null;
        goto L24
    L35:
        return;
    L33:
        throw new OutOfMemoryError();
    L5:
        if ((r13 + r14) < r8) goto L9;
        if (r14 < (r10.length / 4)) goto L9;
        r16 = true;
        goto L10
    }

    public final int g(K r8) {
        int r10 = h(r8);
        int r11 = this.f14350o;
    L3:
        int r12 = this.f14349n[r10];
        if (r12 == 0) goto L5;
        if (r12 <= 0) goto L10;
        int r13 = r12 - 1;
        if (i.a(this.f14346a[r13], r8) == false) goto L10;
        return r13;
    L10:
        r11 = r11 - 1;
        if (r11 < 0) goto L12;
        int r14 = r10 - 1;
        if (r10 == 0) goto L15;
        r10 = r14;
        goto L3
    L15:
        r10 = this.f14349n.length - 1;
        goto L3
    L12:
        return -1;
    L5:
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final V get(Object r8) {
        int r10 = g(r8);
        if (r10 >= 0) goto L6;
        return null;
    L6:
        V[] r11 = this.f14347b;
        i.c(r11);
        return r11[r10];
    }

    public final int h(K r8) {
        if (r8 == null) goto L4;
        int r10 = r8.hashCode();
    L6:
        return (r10 * (-1640531527)) >>> this.f14352q;
    L4:
        r10 = 0;
        goto L6
    }

    @Override // java.util.Map
    public final int hashCode() {
        C0208b r8 = new C0208b(this);
        int r10 = 0;
    L4:
        if (r8.hasNext() == false) goto L18;
        int r11 = r8.f14361b;
        b<K, V> r12 = r8.f14360a;
        if (r11 >= r12.f14351p) goto L17;
        r8.f14361b = r11 + 1;
        r8.f14362m = r11;
        K r13 = r12.f14346a[r11];
        if (r13 == null) goto L10;
        int r14 = r13.hashCode();
    L11:
        V[] r15 = r12.f14347b;
        i.c(r15);
        V r16 = r15[r8.f14362m];
        if (r16 == null) goto L14;
        int r17 = r16.hashCode();
    L15:
        r8.a();
        r10 = r10 + (r14 ^ r17);
        goto L4
    L14:
        r17 = 0;
        goto L15
    L10:
        r14 = 0;
        goto L11
    L17:
        throw new NoSuchElementException();
    L18:
        return r10;
    }

    public final void i(int r8) {
        if (this.f14351p <= this.f14353r) goto L18;
        V[] r10 = this.f14347b;
        int r11 = 0;
        int r12 = 0;
    L5:
        int r13 = this.f14351p;
        if (r11 >= r13) goto L14;
        if (this.f14348m[r11] < 0) goto L13;
        K[] r14 = this.f14346a;
        r14[r12] = r14[r11];
        if (r10 == null) goto L12;
        r10[r12] = r10[r11];
    L12:
        r12 = r12 + 1;
    L13:
        r11 = r11 + 1;
        goto L5
    L14:
        l6.a.H0(r12, r13, this.f14346a);
        if (r10 == null) goto L17;
        l6.a.H0(r12, this.f14351p, r10);
    L17:
        this.f14351p = r12;
    L18:
        int[] r15 = this.f14349n;
        if (r8 == r15.length) goto L21;
        this.f14349n = new int[r8];
        this.f14352q = Integer.numberOfLeadingZeros(r8) + 1;
    L22:
        int r16 = 0;
    L24:
        if (r16 >= this.f14351p) goto L40;
        int r17 = r16 + 1;
        int r18 = h(this.f14346a[r16]);
        int r19 = this.f14350o;
    L26:
        int[] r20 = this.f14349n;
        if (r20[r18] == 0) goto L28;
        r19 = r19 - 1;
        if (r19 < 0) goto L31;
        int r21 = r18 - 1;
        if (r18 == 0) goto L38;
        r18 = r21;
        goto L26
    L38:
        r18 = r20.length - 1;
        goto L26
    L31:
        boolean r22 = false;
    L32:
        if (r22 == false) goto L35;
        r16 = r17;
        goto L24
    L35:
        throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
    L28:
        r20[r18] = r17;
        this.f14348m[r16] = r18;
        r22 = true;
        goto L32
    L40:
        return;
    L21:
        int r23 = r15.length;
        i.f(r15, "<this>");
        Arrays.fill(r15, 0, r23, 0);
        goto L22
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        if (this.f14353r != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void j(int r12) {
        K[] r8 = this.f14346a;
        i.f(r8, "<this>");
        r8[r12] = null;
        int r10 = this.f14348m[r12];
        int r11 = this.f14350o * 2;
        int r13 = this.f14349n.length / 2;
        if (r11 <= r13) goto L5;
        r11 = r13;
    L5:
        int r14 = r11;
        int r15 = 0;
        int r16 = r10;
    L6:
        int r17 = r10 - 1;
        if (r10 != 0) goto L9;
        r10 = this.f14349n.length - 1;
    L10:
        r15 = r15 + 1;
        if (r15 > this.f14350o) goto L12;
        int[] r18 = this.f14349n;
        int r19 = r18[r10];
        if (r19 == 0) goto L15;
        if (r19 >= 0) goto L18;
        r18[r16] = -1;
    L21:
        r16 = r10;
        r15 = 0;
    L22:
        r14 = r14 - 1;
        if (r14 >= 0) goto L6;
        this.f14349n[r16] = -1;
    L25:
        this.f14348m[r12] = -1;
        this.f14353r--;
        return;
    L18:
        int r20 = r19 - 1;
        int r21 = h(this.f14346a[r20]) - r10;
        int[] r22 = this.f14349n;
        if ((r21 & (r22.length - 1)) < r15) goto L22;
        r22[r16] = r19;
        this.f14348m[r20] = r16;
        goto L21
    L15:
        r18[r16] = 0;
        goto L25
    L12:
        this.f14349n[r16] = 0;
        goto L25
    L9:
        r10 = r17;
        goto L10
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        zd.d<K> r8 = this.f14354s;
        if (r8 != null) goto L6;
        zd.d<K> r10 = new zd.d(this);
        this.f14354s = r10;
        return r10;
    L6:
        return r8;
    }

    @Override // java.util.Map
    public final V put(K r8, V r10) {
        c();
        int r11 = b(r8);
        V[] r12 = this.f14347b;
        if (r12 != null) goto L6;
        r12 = (V[]) l6.a.m(this.f14346a.length);
        this.f14347b = r12;
    L6:
        if (r11 >= 0) goto L9;
        int r13 = (-r11) - 1;
        V r14 = r12[r13];
        r12[r13] = r10;
        return r14;
    L9:
        r12[r11] = r10;
        return null;
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> r8) {
        i.f(r8, "from");
        c();
        Set<Map.Entry<? extends K, ? extends V>> r10 = r8.entrySet();
        if (r10.isEmpty() == true) goto L17;
        f(r10.size());
        Iterator<Map.Entry<? extends K, ? extends V>> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L26;
        Map.Entry<? extends K, ? extends V> r12 = r11.next();
        int r13 = b(r12.getKey());
        V[] r14 = this.f14347b;
        if (r14 != null) goto L12;
        r14 = (V[]) l6.a.m(this.f14346a.length);
        this.f14347b = r14;
    L12:
        if (r13 >= 0) goto L13;
        int r15 = (-r13) - 1;
        if (i.a(r12.getValue(), r14[r15]) == true) goto L7;
        r14[r15] = r12.getValue();
        goto L7
    L13:
        r14[r13] = r12.getValue();
        goto L7
    L26:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final V remove(Object r8) {
        c();
        int r10 = g(r8);
        if (r10 >= 0) goto L5;
        r10 = -1;
    L7:
        if (r10 >= 0) goto L9;
        return null;
    L9:
        V[] r11 = this.f14347b;
        i.c(r11);
        V r12 = r11[r10];
        r11[r10] = null;
        return r12;
    L5:
        j(r10);
        goto L7
    }

    @Override // java.util.Map
    public final int size() {
        return this.f14353r;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder((this.f14353r * 3) + 2);
        r8.append("{");
        C0208b r10 = new C0208b(this);
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L20;
        if (r11 <= 0) goto L7;
        r8.append(", ");
    L7:
        int r12 = r10.f14361b;
        b<K, V> r13 = r10.f14360a;
        if (r12 >= r13.f14351p) goto L19;
        r10.f14361b = r12 + 1;
        r10.f14362m = r12;
        K r14 = r13.f14346a[r12];
        if (i.a(r14, r13) == false) goto L12;
        r8.append("(this Map)");
    L13:
        r8.append('=');
        V[] r15 = r13.f14347b;
        i.c(r15);
        V r16 = r15[r10.f14362m];
        if (i.a(r16, r13) == false) goto L16;
        r8.append("(this Map)");
    L17:
        r10.a();
        r11 = r11 + 1;
        goto L4
    L16:
        r8.append(r16);
        goto L17
    L12:
        r8.append(r14);
        goto L13
    L19:
        throw new NoSuchElementException();
    L20:
        r8.append("}");
        String r17 = r8.toString();
        i.e(r17, "sb.toString()");
        return r17;
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        zd.e<V> r8 = this.f14355t;
        if (r8 != null) goto L6;
        zd.e<V> r10 = new zd.e(this);
        this.f14355t = r10;
        return r10;
    L6:
        return r8;
    }
}
