package n;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h<K, V> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Object[] f9395n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f9396o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Object[] f9397p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f9398q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f9399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f9400b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9401m;

    public h() {
        this.f9399a = defpackage.c.f3206k;
        this.f9400b = defpackage.c.f3207l;
        this.f9401m = 0;
    }

    private void b(int r8) {
        if (r8 != 8) goto L17;
        monitor-enter(h.class);
        Object[] r10 = f9397p;     // Catch: Throwable -> L13
        if (r10 == null) goto L11;
        this.f9400b = r10;     // Catch: Throwable -> L13
        f9397p = (Object[]) r10[0];     // Catch: Throwable -> L13
        this.f9399a = (int[]) r10[1];     // Catch: Throwable -> L13
        r10[1] = null;     // Catch: Throwable -> L13
        r10[0] = null;     // Catch: Throwable -> L13
        f9398q--;     // Catch: Throwable -> L13
        monitor-exit(h.class);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(h.class);     // Catch: Throwable -> L13
    L30:
        this.f9399a = new int[r8];
        this.f9400b = new Object[r8 << 1];
        return;
    L13:
        th = move-exception;
        throw th;
    L17:
        if (r8 != 4) goto L30;
        monitor-enter(h.class);
        Object[] r11 = f9395n;     // Catch: Throwable -> L27
        if (r11 == null) goto L25;
        this.f9400b = r11;     // Catch: Throwable -> L27
        f9395n = (Object[]) r11[0];     // Catch: Throwable -> L27
        this.f9399a = (int[]) r11[1];     // Catch: Throwable -> L27
        r11[1] = null;     // Catch: Throwable -> L27
        r11[0] = null;     // Catch: Throwable -> L27
        f9396o--;     // Catch: Throwable -> L27
        monitor-exit(h.class);     // Catch: Throwable -> L27
        return;
    L25:
        monitor-exit(h.class);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public static void d(int[] r8, Object[] r10, int r11) {
        if (r8.length != 8) goto L18;
        monitor-enter(h.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f9398q >= 10) goto L12;
        r10[0] = f9397p;     // Catch: Throwable -> L14
        r10[1] = r8;     // Catch: Throwable -> L14
        int r12 = (r11 << 1) - 1;     // Catch: Throwable -> L14
    L9:
        if (r12 < 2) goto L11;
        r10[r12] = null;     // Catch: Throwable -> L14
        r12 = r12 - 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        f9397p = r10;     // Catch: Throwable -> L14
        f9398q++;     // Catch: Throwable -> L14
    L12:
        monitor-exit(h.class);     // Catch: Throwable -> L14
        return;
    L18:
        if (r8.length == 4) goto L20;
        return;
    L20:
        monitor-enter(h.class);
    L29:
        th = move-exception;
        throw th;
    L22:
        if (f9396o >= 10) goto L27;
        r10[0] = f9395n;     // Catch: Throwable -> L29
        r10[1] = r8;     // Catch: Throwable -> L29
        int r13 = (r11 << 1) - 1;     // Catch: Throwable -> L29
    L24:
        if (r13 < 2) goto L26;
        r10[r13] = null;     // Catch: Throwable -> L29
        r13 = r13 - 1;     // Catch: Throwable -> L29
        goto L24
    L26:
        f9395n = r10;     // Catch: Throwable -> L29
        f9396o++;     // Catch: Throwable -> L29
    L27:
        monitor-exit(h.class);     // Catch: Throwable -> L29
    }

    public final void c(int r8) {
        int r10 = this.f9401m;
        int[] r11 = this.f9399a;
        if (r11.length >= r8) goto L9;
        Object[] r12 = this.f9400b;
        b(r8);
        if (this.f9401m <= 0) goto L7;
        System.arraycopy(r11, 0, this.f9399a, 0, r10);
        System.arraycopy(r12, 0, this.f9400b, 0, r10 << 1);
    L7:
        d(r11, r12, r10);
    L9:
        if (this.f9401m != r10) goto L12;
        return;
    L12:
        throw new ConcurrentModificationException();
    }

    public final void clear() {
        int r8 = this.f9401m;
        if (r8 <= 0) goto L6;
        int[] r10 = this.f9399a;
        Object[] r11 = this.f9400b;
        this.f9399a = defpackage.c.f3206k;
        this.f9400b = defpackage.c.f3207l;
        this.f9401m = 0;
        d(r10, r11, r8);
    L6:
        if (this.f9401m > 0) goto L9;
        return;
    L9:
        throw new ConcurrentModificationException();
    }

    public final boolean containsKey(Object r8) {
        if (f(r8) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean containsValue(Object r8) {
        if (h(r8) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int e(int r8, Object r10) {
        int r11 = this.f9401m;
        if (r11 != 0) goto L32;
        return -1;
    L32:
        int r12 = defpackage.c.s(r11, r8, this.f9399a);     // Catch: ArrayIndexOutOfBoundsException -> L30
        if (r12 >= 0) goto L10;
        return r12;
    L10:
        if (r10.equals(this.f9400b[r12 << 1]) == false) goto L12;
        return r12;
    L12:
        int r13 = r12 + 1;
    L13:
        if (r13 >= r11) goto L20;
        if (this.f9399a[r13] != r8) goto L20;
        if (r10.equals(this.f9400b[r13 << 1]) == true) goto L18;
        r13 = r13 + 1;
        goto L13
    L18:
        return r13;
    L20:
        int r14 = r12 - 1;
    L21:
        if (r14 < 0) goto L29;
        if (this.f9399a[r14] != r8) goto L29;
        if (r10.equals(this.f9400b[r14 << 1]) == true) goto L26;
        r14 = r14 - 1;
        goto L21
    L26:
        return r14;
    L29:
        return ~r13;
    L31:
        throw new ConcurrentModificationException();
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h) == false) goto L26;
        h r10 = (h) r8;
        if (this.f9401m == r10.f9401m) goto L10;
        return false;
    L10:
        int r11 = 0;
    L48:
        if (r11 >= this.f9401m) goto L23;
        K r12 = i(r11);     // Catch: Throwable -> L24
        V r13 = k(r11);     // Catch: Throwable -> L24
        Object r14 = r10.getOrDefault(r12, null);     // Catch: Throwable -> L24
        if (r13 != null) goto L20;
        if (r14 != null) goto L18;
        if (r10.containsKey(r12) == false) goto L18;
    L22:
        r11 = r11 + 1;
    L18:
        return false;
    L20:
        if (r13.equals(r14) == true) goto L22;
        return false;
    L23:
        return true;
    L24:
        return false;
    L26:
        if ((r8 instanceof Map) == false) goto L44;
        Map r15 = (Map) r8;
        if (this.f9401m == r15.size()) goto L30;
        return false;
    L30:
        int r16 = 0;
    L46:
        if (r16 >= this.f9401m) goto L43;
        K r17 = i(r16);     // Catch: Throwable -> L45
        V r18 = k(r16);     // Catch: Throwable -> L45
        Object r19 = r15.get(r17);     // Catch: Throwable -> L45
        if (r18 != null) goto L40;
        if (r19 != null) goto L38;
        if (r15.containsKey(r17) == false) goto L38;
    L42:
        r16 = r16 + 1;
    L38:
        return false;
    L40:
        if (r18.equals(r19) == true) goto L42;
        return false;
    L43:
        return true;
    L44:
        return false;
    }

    public final int f(Object r8) {
        if (r8 != null) goto L5;
        return g();
    L5:
        return e(r8.hashCode(), r8);
    }

    public final int g() {
        int r8 = this.f9401m;
        if (r8 != 0) goto L32;
        return -1;
    L32:
        int r10 = defpackage.c.s(r8, 0, this.f9399a);     // Catch: ArrayIndexOutOfBoundsException -> L30
        if (r10 >= 0) goto L10;
        return r10;
    L10:
        if (this.f9400b[r10 << 1] != null) goto L12;
        return r10;
    L12:
        int r11 = r10 + 1;
    L13:
        if (r11 >= r8) goto L20;
        if (this.f9399a[r11] != 0) goto L20;
        if (this.f9400b[r11 << 1] == null) goto L18;
        r11 = r11 + 1;
        goto L13
    L18:
        return r11;
    L20:
        int r12 = r10 - 1;
    L21:
        if (r12 < 0) goto L29;
        if (this.f9399a[r12] != 0) goto L29;
        if (this.f9400b[r12 << 1] == null) goto L26;
        r12 = r12 - 1;
        goto L21
    L26:
        return r12;
    L29:
        return ~r11;
    L31:
        throw new ConcurrentModificationException();
    }

    public final V get(Object r8) {
        return getOrDefault(r8, null);
    }

    public final V getOrDefault(Object r8, V r10) {
        int r11 = f(r8);
        if (r11 >= 0) goto L5;
        return r10;
    L5:
        return (V) this.f9400b[(r11 << 1) + 1];
    }

    final int h(Object r8) {
        int r10 = this.f9401m * 2;
        Object[] r11 = this.f9400b;
        if (r8 != null) goto L11;
        int r12 = 1;
    L5:
        if (r12 >= r10) goto L18;
        if (r11[r12] == null) goto L9;
        r12 = r12 + 2;
        goto L5
    L9:
        return r12 >> 1;
    L18:
        return -1;
    L11:
        int r13 = 1;
    L12:
        if (r13 >= r10) goto L24;
        if (r8.equals(r11[r13]) == true) goto L16;
        r13 = r13 + 2;
        goto L12
    L16:
        return r13 >> 1;
    L24:
        return -1;
    }

    public final int hashCode() {
        int[] r8 = this.f9399a;
        Object[] r10 = this.f9400b;
        int r11 = this.f9401m;
        int r12 = 1;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r11) goto L9;
        Object r15 = r10[r12];
        int r16 = r8[r13];
        if (r15 != null) goto L7;
        int r17 = 0;
    L8:
        r14 = r14 + (r17 ^ r16);
        r13 = r13 + 1;
        r12 = r12 + 2;
        goto L3
    L7:
        r17 = r15.hashCode();
        goto L8
    L9:
        return r14;
    }

    public final K i(int r8) {
        return (K) this.f9400b[r8 << 1];
    }

    public final boolean isEmpty() {
        if (this.f9401m > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final V j(int r11) {
        Object[] r8 = this.f9400b;
        int r10 = r11 << 1;
        V r12 = (V) r8[r10 + 1];
        int r13 = this.f9401m;
        int r14 = 0;
        if (r13 > 1) goto L5;
        d(this.f9399a, r8, r13);
        this.f9399a = defpackage.c.f3206k;
        this.f9400b = defpackage.c.f3207l;
    L24:
        if (r13 != this.f9401m) goto L28;
        this.f9401m = r14;
        return r12;
    L28:
        throw new ConcurrentModificationException();
    L5:
        int r15 = r13 - 1;
        int[] r16 = this.f9399a;
        int r17 = 8;
        if (r16.length > 8) goto L8;
    L19:
        if (r11 >= r15) goto L21;
        int r18 = r11 + 1;
        int r19 = r15 - r11;
        System.arraycopy(r16, r18, r16, r11, r19);
        Object[] r110 = this.f9400b;
        System.arraycopy(r110, r18 << 1, r110, r10, r19 << 1);
    L21:
        Object[] r111 = this.f9400b;
        int r20 = r15 << 1;
        r111[r20] = null;
        r111[r20 + 1] = null;
    L22:
        r14 = r15;
        goto L24
    L8:
        if (r13 >= (r16.length / 3)) goto L19;
        if (r13 <= 8) goto L11;
        r17 = r13 + (r13 >> 1);
    L11:
        b(r17);
        if (r13 != this.f9401m) goto L18;
        if (r11 <= 0) goto L15;
        System.arraycopy(r16, 0, this.f9399a, 0, r11);
        System.arraycopy(r8, 0, this.f9400b, 0, r10);
    L15:
        if (r11 >= r15) goto L22;
        int r21 = r11 + 1;
        int r22 = r15 - r11;
        System.arraycopy(r16, r21, this.f9399a, r11, r22);
        System.arraycopy(r8, r21 << 1, this.f9400b, r10, r22 << 1);
        goto L22
    L18:
        throw new ConcurrentModificationException();
    }

    public final V k(int r8) {
        return (V) this.f9400b[(r8 << 1) + 1];
    }

    public final V put(K r10, V r11) {
        int r8 = this.f9401m;
        if (r10 != null) goto L5;
        int r12 = g();
        int r13 = 0;
    L6:
        if (r12 < 0) goto L9;
        int r14 = (r12 << 1) + 1;
        Object[] r15 = this.f9400b;
        V r16 = (V) r15[r14];
        r15[r14] = r11;
        return r16;
    L9:
        int r17 = ~r12;
        int[] r18 = this.f9399a;
        if (r8 < r18.length) goto L26;
        int r19 = 8;
        if (r8 < 8) goto L15;
        r19 = (r8 >> 1) + r8;
    L18:
        Object[] r20 = this.f9400b;
        b(r19);
        if (r8 != this.f9401m) goto L25;
        int[] r21 = this.f9399a;
        if (r21.length <= 0) goto L23;
        System.arraycopy(r18, 0, r21, 0, r18.length);
        System.arraycopy(r20, 0, this.f9400b, 0, r20.length);
    L23:
        d(r18, r20, r8);
        goto L26
    L25:
        throw new ConcurrentModificationException();
    L15:
        if (r8 >= 4) goto L18;
        r19 = 4;
    L26:
        if (r17 >= r8) goto L28;
        int[] r22 = this.f9399a;
        int r23 = r17 + 1;
        System.arraycopy(r22, r17, r22, r23, r8 - r17);
        Object[] r24 = this.f9400b;
        System.arraycopy(r24, r17 << 1, r24, r23 << 1, (this.f9401m - r17) << 1);
    L28:
        int r25 = this.f9401m;
        if (r8 != r25) goto L35;
        int[] r26 = this.f9399a;
        if (r17 >= r26.length) goto L35;
        r26[r17] = r13;
        Object[] r27 = this.f9400b;
        int r28 = r17 << 1;
        r27[r28] = r10;
        r27[r28 + 1] = r11;
        this.f9401m = r25 + 1;
        return null;
    L35:
        throw new ConcurrentModificationException();
    L5:
        int r29 = r10.hashCode();
        r13 = r29;
        r12 = e(r29, r10);
        goto L6
    }

    public final V putIfAbsent(K r8, V r10) {
        V r11 = getOrDefault(r8, null);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return put(r8, r10);
    }

    public final V remove(Object r8) {
        int r10 = f(r8);
        if (r10 >= 0) goto L5;
        return null;
    L5:
        return j(r10);
    }

    public final V replace(K r8, V r10) {
        int r11 = f(r8);
        if (r11 < 0) goto L6;
        int r12 = (r11 << 1) + 1;
        Object[] r13 = this.f9400b;
        V r14 = (V) r13[r12];
        r13[r12] = r10;
        return r14;
    L6:
        return null;
    }

    public final int size() {
        return this.f9401m;
    }

    public final String toString() {
        if (isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r8 = new StringBuilder(this.f9401m * 28);
        r8.append('{');
        int r10 = 0;
    L8:
        if (r10 >= this.f9401m) goto L20;
        if (r10 <= 0) goto L11;
        r8.append(", ");
    L11:
        K r11 = i(r10);
        if (r11 == this) goto L14;
        r8.append(r11);
    L15:
        r8.append('=');
        V r12 = k(r10);
        if (r12 == this) goto L18;
        r8.append(r12);
    L19:
        r10 = r10 + 1;
        goto L8
    L18:
        r8.append("(this Map)");
        goto L19
    L14:
        r8.append("(this Map)");
        goto L15
    L20:
        r8.append('}');
        return r8.toString();
    }

    public h(int r8) {
        if (r8 != 0) goto L5;
        this.f9399a = defpackage.c.f3206k;
        this.f9400b = defpackage.c.f3207l;
    L6:
        this.f9401m = 0;
        return;
    L5:
        b(r8);
        goto L6
    }

    public final boolean remove(Object r8, Object r10) {
        int r11 = f(r8);
        if (r11 < 0) goto L11;
        V r12 = k(r11);
        if (r10 == r12) goto L9;
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r10.equals(r12) == true) goto L9;
        return false;
    L9:
        j(r11);
        return true;
    L11:
        return false;
    }

    public final boolean replace(K r8, V r10, V r11) {
        int r12 = f(r8);
        if (r12 < 0) goto L11;
        V r13 = k(r12);
        if (r13 == r10) goto L9;
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r10.equals(r13) == true) goto L9;
        return false;
    L9:
        int r14 = (r12 << 1) + 1;
        Object[] r15 = this.f9400b;
        Object r16 = r15[r14];
        r15[r14] = r11;
        return true;
    L11:
        return false;
    }
}
