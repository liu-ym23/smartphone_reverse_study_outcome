package n;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class d<E> implements Collection<E>, Set<E> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f9360o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object[] f9361p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static Object[] f9362q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f9363r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static Object[] f9364s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f9365t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f9366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f9367b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9368m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c f9369n;

    static {
        f9360o = new int[0];
        f9361p = new Object[0];
    }

    public d() {
        this(0);
    }

    public static void b(int[] r8, Object[] r10, int r11) {
        if (r8.length != 8) goto L18;
        monitor-enter(d.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f9365t >= 10) goto L12;
        r10[0] = f9364s;     // Catch: Throwable -> L14
        r10[1] = r8;     // Catch: Throwable -> L14
        int r12 = r11 - 1;     // Catch: Throwable -> L14
    L9:
        if (r12 < 2) goto L11;
        r10[r12] = null;     // Catch: Throwable -> L14
        r12 = r12 - 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        f9364s = r10;     // Catch: Throwable -> L14
        f9365t++;     // Catch: Throwable -> L14
    L12:
        monitor-exit(d.class);     // Catch: Throwable -> L14
        return;
    L18:
        if (r8.length == 4) goto L20;
        return;
    L20:
        monitor-enter(d.class);
    L29:
        th = move-exception;
        throw th;
    L22:
        if (f9363r >= 10) goto L27;
        r10[0] = f9362q;     // Catch: Throwable -> L29
        r10[1] = r8;     // Catch: Throwable -> L29
        int r13 = r11 - 1;     // Catch: Throwable -> L29
    L24:
        if (r13 < 2) goto L26;
        r10[r13] = null;     // Catch: Throwable -> L29
        r13 = r13 - 1;     // Catch: Throwable -> L29
        goto L24
    L26:
        f9362q = r10;     // Catch: Throwable -> L29
        f9363r++;     // Catch: Throwable -> L29
    L27:
        monitor-exit(d.class);     // Catch: Throwable -> L29
    }

    public final void a(int r8) {
        if (r8 != 8) goto L17;
        monitor-enter(d.class);
        Object[] r10 = f9364s;     // Catch: Throwable -> L13
        if (r10 == null) goto L11;
        this.f9367b = r10;     // Catch: Throwable -> L13
        f9364s = (Object[]) r10[0];     // Catch: Throwable -> L13
        this.f9366a = (int[]) r10[1];     // Catch: Throwable -> L13
        r10[1] = null;     // Catch: Throwable -> L13
        r10[0] = null;     // Catch: Throwable -> L13
        f9365t--;     // Catch: Throwable -> L13
        monitor-exit(d.class);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(d.class);     // Catch: Throwable -> L13
    L30:
        this.f9366a = new int[r8];
        this.f9367b = new Object[r8];
        return;
    L13:
        th = move-exception;
        throw th;
    L17:
        if (r8 != 4) goto L30;
        monitor-enter(d.class);
        Object[] r11 = f9362q;     // Catch: Throwable -> L27
        if (r11 == null) goto L25;
        this.f9367b = r11;     // Catch: Throwable -> L27
        f9362q = (Object[]) r11[0];     // Catch: Throwable -> L27
        this.f9366a = (int[]) r11[1];     // Catch: Throwable -> L27
        r11[1] = null;     // Catch: Throwable -> L27
        r11[0] = null;     // Catch: Throwable -> L27
        f9363r--;     // Catch: Throwable -> L27
        monitor-exit(d.class);     // Catch: Throwable -> L27
        return;
    L25:
        monitor-exit(d.class);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(E r10) {
        if (r10 != null) goto L5;
        int r8 = d();
        int r11 = 0;
    L6:
        if (r8 < 0) goto L8;
        return false;
    L8:
        int r12 = ~r8;
        int r13 = this.f9368m;
        int[] r14 = this.f9366a;
        if (r13 < r14.length) goto L21;
        int r15 = 8;
        if (r13 < 8) goto L14;
        r15 = (r13 >> 1) + r13;
    L17:
        Object[] r16 = this.f9367b;
        a(r15);
        int[] r17 = this.f9366a;
        if (r17.length <= 0) goto L20;
        System.arraycopy(r14, 0, r17, 0, r14.length);
        System.arraycopy(r16, 0, this.f9367b, 0, r16.length);
    L20:
        b(r14, r16, this.f9368m);
        goto L21
    L14:
        if (r13 >= 4) goto L17;
        r15 = 4;
    L21:
        int r18 = this.f9368m;
        if (r12 >= r18) goto L24;
        int[] r19 = this.f9366a;
        int r20 = r12 + 1;
        System.arraycopy(r19, r12, r19, r20, r18 - r12);
        Object[] r21 = this.f9367b;
        System.arraycopy(r21, r12, r21, r20, this.f9368m - r12);
    L24:
        this.f9366a[r12] = r11;
        this.f9367b[r12] = r10;
        this.f9368m++;
        return true;
    L5:
        int r22 = r10.hashCode();
        r11 = r22;
        r8 = c(r22, r10);
        goto L6
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends E> r8) {
        int r10 = this.f9368m;
        int r11 = r8.size() + r10;
        int[] r12 = this.f9366a;
        boolean r13 = false;
        if (r12.length >= r11) goto L8;
        Object[] r14 = this.f9367b;
        a(r11);
        int r15 = this.f9368m;
        if (r15 <= 0) goto L7;
        System.arraycopy(r12, 0, this.f9366a, 0, r15);
        System.arraycopy(r14, 0, this.f9367b, 0, this.f9368m);
    L7:
        b(r12, r14, this.f9368m);
    L8:
        Iterator<? extends E> r16 = r8.iterator();
    L10:
        if (r16.hasNext() == false) goto L12;
        r13 = r13 | add(r16.next());
        goto L10
    L12:
        return r13;
    }

    public final int c(int r8, Object r10) {
        int r11 = this.f9368m;
        if (r11 != 0) goto L6;
        return -1;
    L6:
        int r12 = defpackage.c.s(r11, r8, this.f9366a);
        if (r12 >= 0) goto L10;
        return r12;
    L10:
        if (r10.equals(this.f9367b[r12]) == false) goto L12;
        return r12;
    L12:
        int r13 = r12 + 1;
    L13:
        if (r13 >= r11) goto L20;
        if (this.f9366a[r13] != r8) goto L20;
        if (r10.equals(this.f9367b[r13]) == true) goto L18;
        r13 = r13 + 1;
        goto L13
    L18:
        return r13;
    L20:
        int r14 = r12 - 1;
    L21:
        if (r14 < 0) goto L29;
        if (this.f9366a[r14] != r8) goto L29;
        if (r10.equals(this.f9367b[r14]) == true) goto L26;
        r14 = r14 - 1;
        goto L21
    L26:
        return r14;
    L29:
        return ~r13;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int r8 = this.f9368m;
        if (r8 == 0) goto L6;
        b(this.f9366a, this.f9367b, r8);
        this.f9366a = f9360o;
        this.f9367b = f9361p;
        this.f9368m = 0;
        return;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object r8) {
        if (indexOf(r8) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<?> r8) {
        Iterator<?> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (contains(r10.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public final int d() {
        int r8 = this.f9368m;
        if (r8 != 0) goto L6;
        return -1;
    L6:
        int r10 = defpackage.c.s(r8, 0, this.f9366a);
        if (r10 >= 0) goto L10;
        return r10;
    L10:
        if (this.f9367b[r10] != null) goto L12;
        return r10;
    L12:
        int r11 = r10 + 1;
    L13:
        if (r11 >= r8) goto L20;
        if (this.f9366a[r11] != 0) goto L20;
        if (this.f9367b[r11] == null) goto L18;
        r11 = r11 + 1;
        goto L13
    L18:
        return r11;
    L20:
        int r12 = r10 - 1;
    L21:
        if (r12 < 0) goto L29;
        if (this.f9366a[r12] != 0) goto L29;
        if (this.f9367b[r12] == null) goto L26;
        r12 = r12 - 1;
        goto L21
    L26:
        return r12;
    L29:
        return ~r11;
    }

    public final void e(int r8) {
        Object[] r10 = this.f9367b;
        Object r11 = r10[r8];
        int r12 = this.f9368m;
        if (r12 > 1) goto L5;
        b(this.f9366a, r10, r12);
        this.f9366a = f9360o;
        this.f9367b = f9361p;
        this.f9368m = 0;
        return;
    L5:
        int[] r13 = this.f9366a;
        int r14 = 8;
        if (r13.length > 8) goto L8;
    L17:
        int r15 = r12 - 1;
        this.f9368m = r15;
        if (r8 >= r15) goto L20;
        int r16 = r8 + 1;
        System.arraycopy(r13, r16, r13, r8, r15 - r8);
        Object[] r17 = this.f9367b;
        System.arraycopy(r17, r16, r17, r8, this.f9368m - r8);
    L20:
        this.f9367b[this.f9368m] = null;
        return;
    L8:
        if (r12 >= (r13.length / 3)) goto L17;
        if (r12 <= 8) goto L11;
        r14 = r12 + (r12 >> 1);
    L11:
        a(r14);
        this.f9368m--;
        if (r8 <= 0) goto L14;
        System.arraycopy(r13, 0, this.f9366a, 0, r8);
        System.arraycopy(r10, 0, this.f9367b, 0, r8);
    L14:
        int r18 = this.f9368m;
        if (r8 >= r18) goto L23;
        int r19 = r8 + 1;
        System.arraycopy(r13, r19, this.f9366a, r8, r18 - r8);
        System.arraycopy(r10, r19, this.f9367b, r8, this.f9368m - r8);
        return;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof Set) == false) goto L18;
        Set r10 = (Set) r8;
        if (this.f9368m == r10.size()) goto L10;
        return false;
    L10:
        int r11 = 0;
    L20:
        if (r11 >= this.f9368m) goto L17;
        if (r10.contains(this.f9367b[r11]) == false) goto L15;
        r11 = r11 + 1;
        goto L20
    L15:
        return false;
    L17:
        return true;
    L18:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] r8 = this.f9366a;
        int r10 = this.f9368m;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r12 = r12 + r8[r11];
        r11 = r11 + 1;
        goto L3
    L5:
        return r12;
    }

    public final int indexOf(Object r8) {
        if (r8 != null) goto L5;
        return d();
    L5:
        return c(r8.hashCode(), r8);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        if (this.f9368m > 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<E> iterator() {
        if (this.f9369n != null) goto L5;
        this.f9369n = new c(this);
    L5:
        c r8 = this.f9369n;
        if (r8.f9381b != null) goto L9;
        r8.f9381b = new g.c(r8);
    L9:
        return (Iterator<E>) r8.f9381b.iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object r8) {
        int r10 = indexOf(r8);
        if (r10 < 0) goto L6;
        e(r10);
        return true;
    L6:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<?> r8) {
        Iterator<?> r10 = r8.iterator();
        boolean r11 = false;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = r11 | remove(r10.next());
        goto L4
    L6:
        return r11;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<?> r8) {
        int r10 = this.f9368m - 1;
        boolean r11 = false;
    L3:
        if (r10 < 0) goto L8;
        if (r8.contains(this.f9367b[r10]) == true) goto L7;
        e(r10);
        r11 = true;
    L7:
        r10 = r10 - 1;
        goto L3
    L8:
        return r11;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f9368m;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int r8 = this.f9368m;
        Object[] r10 = new Object[r8];
        System.arraycopy(this.f9367b, 0, r10, 0, r8);
        return r10;
    }

    public final String toString() {
        if (isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r8 = new StringBuilder(this.f9368m * 14);
        r8.append('{');
        int r10 = 0;
    L8:
        if (r10 >= this.f9368m) goto L16;
        if (r10 <= 0) goto L11;
        r8.append(", ");
    L11:
        Object r11 = this.f9367b[r10];
        if (r11 == this) goto L14;
        r8.append(r11);
    L15:
        r10 = r10 + 1;
        goto L8
    L14:
        r8.append("(this Set)");
        goto L15
    L16:
        r8.append('}');
        return r8.toString();
    }

    public d(int r8) {
        if (r8 != 0) goto L5;
        this.f9366a = f9360o;
        this.f9367b = f9361p;
    L6:
        this.f9368m = 0;
        return;
    L5:
        a(r8);
        goto L6
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] r8) {
        if (r8.length >= this.f9368m) goto L5;
        r8 = (T[]) ((Object[]) Array.newInstance(r8.getClass().getComponentType(), this.f9368m));
    L5:
        T[] r10 = r8;
        System.arraycopy(this.f9367b, 0, r10, 0, this.f9368m);
        int r11 = r8.length;
        int r12 = this.f9368m;
        if (r11 <= r12) goto L8;
        r8[r12] = null;
    L8:
        return r8;
    }
}
