package n;

/* JADX INFO: loaded from: classes.dex */
public final class e<E> implements Cloneable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Object f9370o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f9372b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Object[] f9373m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f9374n;

    static {
        f9370o = new Object();
    }

    public e() {
        this.f9371a = false;
        int r8 = 4;
    L3:
        int r10 = 80;
        if (r8 >= 32) goto L9;
        int r11 = (1 << r8) - 12;
        if (80 <= r11) goto L7;
        r8 = r8 + 1;
        goto L3
    L7:
        r10 = r11;
    L9:
        int r12 = r10 / 8;
        this.f9372b = new long[r12];
        this.f9373m = new Object[r12];
    }

    public final void a() {
        int r8 = this.f9374n;
        Object[] r10 = this.f9373m;
        int r11 = 0;
    L3:
        if (r11 >= r8) goto L5;
        r10[r11] = null;
        r11 = r11 + 1;
        goto L3
    L5:
        this.f9374n = 0;
        this.f9371a = false;
    }

    public final e<E> b() {
        e<E> r8 = (e) super.clone();     // Catch: CloneNotSupportedException -> L4
        r8.f9372b = (long[]) this.f9372b.clone();     // Catch: CloneNotSupportedException -> L4
        r8.f9373m = (Object[]) this.f9373m.clone();     // Catch: CloneNotSupportedException -> L4
        return r8;
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public final void c() {
        int r8 = this.f9374n;
        long[] r10 = this.f9372b;
        Object[] r11 = this.f9373m;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r8) goto L10;
        Object r14 = r11[r12];
        if (r14 == f9370o) goto L9;
        if (r12 == r13) goto L8;
        r10[r13] = r10[r12];
        r11[r13] = r14;
        r11[r12] = null;
    L8:
        r13 = r13 + 1;
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        this.f9371a = false;
        this.f9374n = r13;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    public final E d(long r8) {
        return (E) e(r8, null);
    }

    public final Object e(long r8, Long r10) {
        int r11 = defpackage.c.t(this.f9372b, this.f9374n, r8);
        if (r11 < 0) goto L8;
        Object r12 = this.f9373m[r11];
        if (r12 == f9370o) goto L8;
        return r12;
    L8:
        return r10;
    }

    public final int f(long r8) {
        if (this.f9371a == false) goto L6;
        c();
    L6:
        return defpackage.c.t(this.f9372b, this.f9374n, r8);
    }

    public final void g(long r8, E r10) {
        int r11 = defpackage.c.t(this.f9372b, this.f9374n, r8);
        if (r11 < 0) goto L5;
        this.f9373m[r11] = r10;
        return;
    L5:
        int r12 = ~r11;
        int r13 = this.f9374n;
        if (r12 >= r13) goto L12;
        Object[] r14 = this.f9373m;
        if (r14[r12] != f9370o) goto L12;
        this.f9372b[r12] = r8;
        r14[r12] = r10;
        return;
    L12:
        if (this.f9371a == true) goto L14;
    L16:
        int r15 = this.f9374n;
        if (r15 < this.f9372b.length) goto L26;
        int r16 = (r15 + 1) * 8;
        int r17 = 4;
    L20:
        if (r17 >= 32) goto L25;
        int r18 = (1 << r17) - 12;
        if (r16 <= r18) goto L23;
        r17 = r17 + 1;
        goto L20
    L23:
        r16 = r18;
    L25:
        int r19 = r16 / 8;
        long[] r20 = new long[r19];
        Object[] r21 = new Object[r19];
        long[] r22 = this.f9372b;
        System.arraycopy(r22, 0, r20, 0, r22.length);
        Object[] r23 = this.f9373m;
        System.arraycopy(r23, 0, r21, 0, r23.length);
        this.f9372b = r20;
        this.f9373m = r21;
    L26:
        int r24 = this.f9374n - r12;
        if (r24 == 0) goto L29;
        long[] r25 = this.f9372b;
        int r26 = r12 + 1;
        System.arraycopy(r25, r12, r25, r26, r24);
        Object[] r27 = this.f9373m;
        System.arraycopy(r27, r12, r27, r26, this.f9374n - r12);
    L29:
        this.f9372b[r12] = r8;
        this.f9373m[r12] = r10;
        this.f9374n++;
        return;
    L14:
        if (r13 < this.f9372b.length) goto L16;
        c();
        r12 = ~defpackage.c.t(this.f9372b, this.f9374n, r8);
        goto L16
    }

    public final E h(int r8) {
        if (this.f9371a == false) goto L6;
        c();
    L6:
        return (E) this.f9373m[r8];
    }

    public final String toString() {
        if (this.f9371a == false) goto L6;
        c();
    L6:
        if (this.f9374n > 0) goto L9;
        return "{}";
    L9:
        StringBuilder r8 = new StringBuilder(this.f9374n * 28);
        r8.append('{');
        int r10 = 0;
    L11:
        if (r10 >= this.f9374n) goto L22;
        if (r10 <= 0) goto L15;
        r8.append(", ");
    L15:
        if (this.f9371a == false) goto L17;
        c();
    L17:
        r8.append(this.f9372b[r10]);
        r8.append('=');
        E r11 = h(r10);
        if (r11 == this) goto L20;
        r8.append(r11);
    L21:
        r10 = r10 + 1;
        goto L11
    L20:
        r8.append("(this Map)");
        goto L21
    L22:
        r8.append('}');
        return r8.toString();
    }
}
