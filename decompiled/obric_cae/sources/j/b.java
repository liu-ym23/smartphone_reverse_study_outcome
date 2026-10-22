package j;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c<K, V> f8356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c<K, V> f8357b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final WeakHashMap<f<K, V>, Boolean> f8358m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f8359n;

    public static class a<K, V> extends e<K, V> {
        @Override // j.b.e
        public final c<K, V> b(c<K, V> r8) {
            return r8.f8363n;
        }

        @Override // j.b.e
        public final c<K, V> c(c<K, V> r8) {
            return r8.f8362m;
        }
    }

    /* JADX INFO: renamed from: j.b$b, reason: collision with other inner class name */
    public static class C0094b<K, V> extends e<K, V> {
        @Override // j.b.e
        public final c<K, V> b(c<K, V> r8) {
            return r8.f8362m;
        }

        @Override // j.b.e
        public final c<K, V> c(c<K, V> r8) {
            return r8.f8363n;
        }
    }

    public static class c<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f8360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f8361b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public c<K, V> f8362m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public c<K, V> f8363n;

        public c(K r8, V r10) {
            this.f8360a = r8;
            this.f8361b = r10;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r10 = (c) r8;
            K r11 = r10.f8360a;
            if (this.f8360a.equals(r11) == false) goto L14;
            if (this.f8361b.equals(r10.f8361b) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f8360a;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f8361b;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int r8 = this.f8360a.hashCode();
            return this.f8361b.hashCode() ^ r8;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V r8) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            return this.f8360a + "=" + this.f8361b;
        }
    }

    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c<K, V> f8364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f8365b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ b f8366m;

        public d(b r8) {
            this.f8366m = r8;
            this.f8365b = true;
        }

        @Override // j.b.f
        public final void a(c<K, V> r8) {
            c<K, V> r10 = this.f8364a;
            if (r8 != r10) goto L10;
            c<K, V> r11 = r10.f8363n;
            this.f8364a = r11;
            if (r11 != null) goto L7;
            boolean r12 = true;
        L8:
            this.f8365b = r12;
            return;
        L7:
            r12 = false;
            goto L8
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f8365b == true) goto L5;
            c<K, V> r8 = this.f8364a;
            if (r8 == null) goto L15;
            if (r8.f8362m == null) goto L15;
            return true;
        L15:
            return false;
        L5:
            if (this.f8366m.f8356a == null) goto L8;
            return true;
        L8:
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.f8365b == false) goto L5;
            this.f8365b = false;
            c<K, V> r8 = this.f8366m.f8356a;
        L9:
            this.f8364a = r8;
            return r8;
        L5:
            c<K, V> r10 = this.f8364a;
            if (r10 == null) goto L8;
            r8 = r10.f8362m;
            goto L9
        L8:
            r8 = null;
            goto L9
        }
    }

    public static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c<K, V> f8367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c<K, V> f8368b;

        public e(c<K, V> r8, c<K, V> r10) {
            this.f8367a = r10;
            this.f8368b = r8;
        }

        @Override // j.b.f
        public final void a(c<K, V> r8) {
            c<K, V> r10 = null;
            if (this.f8367a == r8) goto L5;
        L7:
            c<K, V> r11 = this.f8367a;
            if (r11 != r8) goto L10;
            this.f8367a = b(r11);
        L10:
            c<K, V> r12 = this.f8368b;
            if (r12 != r8) goto L19;
            c<K, V> r13 = this.f8367a;
            if (r12 == r13) goto L17;
            if (r13 == null) goto L17;
            r10 = c(r12);
        L17:
            this.f8368b = r10;
            return;
        L19:
            return;
        L5:
            if (r8 != this.f8368b) goto L7;
            this.f8368b = null;
            this.f8367a = null;
            goto L7
        }

        public abstract c<K, V> b(c<K, V> r8);

        public abstract c<K, V> c(c<K, V> r8);

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f8368b == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            c<K, V> r8 = this.f8368b;
            c<K, V> r10 = this.f8367a;
            if (r8 == r10) goto L7;
            if (r10 == null) goto L7;
            c<K, V> r11 = c(r8);
        L8:
            this.f8368b = r11;
            return r8;
        L7:
            r11 = null;
            goto L8
        }
    }

    public static abstract class f<K, V> {
        public f() {
        }

        public abstract void a(c<K, V> r8);
    }

    public b() {
        this.f8358m = new WeakHashMap();
        this.f8359n = 0;
    }

    public c<K, V> a(K r8) {
        c<K, V> r10 = this.f8356a;
    L3:
        if (r10 == null) goto L8;
        if (r10.f8360a.equals(r8) == true) goto L8;
        r10 = r10.f8362m;
    L8:
        return r10;
    }

    public V b(K r8, V r10) {
        c<K, V> r11 = a(r8);
        if (r11 != null) goto L5;
        c<K, V> r12 = new c(r8, r10);
        this.f8359n++;
        c<K, V> r13 = this.f8357b;
        if (r13 != null) goto L9;
        this.f8356a = r12;
    L10:
        this.f8357b = r12;
        return null;
    L9:
        r13.f8362m = r12;
        r12.f8363n = r13;
        goto L10
    L5:
        return r11.f8361b;
    }

    public V c(K r8) {
        c<K, V> r10 = a(r8);
        if (r10 != null) goto L5;
        return null;
    L5:
        this.f8359n--;
        WeakHashMap<f<K, V>, Boolean> r11 = this.f8358m;
        if (r11.isEmpty() == true) goto L11;
        Iterator<f<K, V>> r12 = r11.keySet().iterator();
    L9:
        if (r12.hasNext() == false) goto L11;
        r12.next().a(r10);
    L11:
        c<K, V> r13 = r10.f8363n;
        c<K, V> r14 = r10.f8362m;
        if (r13 == null) goto L14;
        r13.f8362m = r14;
    L15:
        c<K, V> r15 = r10.f8362m;
        if (r15 == null) goto L18;
        r15.f8363n = r13;
    L19:
        r10.f8362m = null;
        r10.f8363n = null;
        return r10.f8361b;
    L18:
        this.f8357b = r13;
        goto L19
    L14:
        this.f8356a = r14;
        goto L15
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r8;
        if (this.f8359n == r10.f8359n) goto L11;
        return false;
    L11:
        Iterator<Map.Entry<K, V>> r11 = iterator();
        Iterator<Map.Entry<K, V>> r12 = r10.iterator();
    L12:
        e r13 = (e) r11;
        if (r13.hasNext() == false) goto L24;
        e r14 = (e) r12;
        if (r14.hasNext() == false) goto L24;
        Map.Entry r15 = (Map.Entry) r13.next();
        Object r16 = r14.next();
        if (r15 != null) goto L19;
        if (r16 == null) goto L19;
    L22:
        return false;
    L19:
        if (r15 == null) goto L12;
        if (r15.equals(r16) == true) goto L12;
    L24:
        if (r13.hasNext() == true) goto L29;
        if (((e) r12).hasNext() == true) goto L29;
        return true;
    L29:
        return false;
    }

    public final int hashCode() {
        Iterator<Map.Entry<K, V>> r8 = iterator();
        int r10 = 0;
    L3:
        e r11 = (e) r8;
        if (r11.hasNext() == false) goto L6;
        r10 = r10 + ((Map.Entry) r11.next()).hashCode();
        goto L3
    L6:
        return r10;
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        a r8 = new a(this.f8356a, this.f8357b);
        this.f8358m.put(r8, Boolean.FALSE);
        return r8;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("[");
        Iterator<Map.Entry<K, V>> r10 = iterator();
    L3:
        e r11 = (e) r10;
        if (r11.hasNext() == false) goto L8;
        r8.append(((Map.Entry) r11.next()).toString());
        if (r11.hasNext() == false) goto L3;
        r8.append(", ");
        goto L3
    L8:
        r8.append("]");
        return r8.toString();
    }
}
