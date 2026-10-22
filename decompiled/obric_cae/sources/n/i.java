package n;

/* JADX INFO: loaded from: classes.dex */
public final class i<E> implements Cloneable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Object f9402n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f9403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f9404b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9405m;

    static {
        f9402n = new Object();
    }

    public i() {
        int r8 = 4;
    L3:
        int r10 = 40;
        if (r8 >= 32) goto L9;
        int r11 = (1 << r8) - 12;
        if (40 <= r11) goto L7;
        r8 = r8 + 1;
        goto L3
    L7:
        r10 = r11;
    L9:
        int r12 = r10 / 4;
        this.f9403a = new int[r12];
        this.f9404b = new Object[r12];
    }

    public final void a(int r8, E r10) {
        int r11 = this.f9405m;
        if (r11 == 0) goto L9;
        if (r8 > this.f9403a[r11 - 1]) goto L9;
        d(r8, r10);
        return;
    L9:
        if (r11 < this.f9403a.length) goto L18;
        int r12 = (r11 + 1) * 4;
        int r13 = 4;
    L12:
        if (r13 >= 32) goto L17;
        int r14 = (1 << r13) - 12;
        if (r12 <= r14) goto L15;
        r13 = r13 + 1;
        goto L12
    L15:
        r12 = r14;
    L17:
        int r15 = r12 / 4;
        int[] r16 = new int[r15];
        Object[] r17 = new Object[r15];
        int[] r18 = this.f9403a;
        System.arraycopy(r18, 0, r16, 0, r18.length);
        Object[] r19 = this.f9404b;
        System.arraycopy(r19, 0, r17, 0, r19.length);
        this.f9403a = r16;
        this.f9404b = r17;
    L18:
        this.f9403a[r11] = r8;
        this.f9404b[r11] = r10;
        this.f9405m = r11 + 1;
    }

    public final i<E> b() {
        i<E> r8 = (i) super.clone();     // Catch: CloneNotSupportedException -> L4
        r8.f9403a = (int[]) this.f9403a.clone();     // Catch: CloneNotSupportedException -> L4
        r8.f9404b = (Object[]) this.f9404b.clone();     // Catch: CloneNotSupportedException -> L4
        return r8;
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public final Object c(int r8, Integer r10) {
        int[] r11 = this.f9403a;
        int r12 = defpackage.c.s(this.f9405m, r8, r11);
        if (r12 < 0) goto L8;
        Object r13 = this.f9404b[r12];
        if (r13 == f9402n) goto L8;
        return r13;
    L8:
        return r10;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    public final void d(int r8, E r10) {
        int r11 = defpackage.c.s(this.f9405m, r8, this.f9403a);
        if (r11 < 0) goto L5;
        this.f9404b[r11] = r10;
        return;
    L5:
        int r12 = ~r11;
        int r13 = this.f9405m;
        if (r12 >= r13) goto L12;
        Object[] r14 = this.f9404b;
        if (r14[r12] != f9402n) goto L12;
        this.f9403a[r12] = r8;
        r14[r12] = r10;
        return;
    L12:
        if (r13 < this.f9403a.length) goto L21;
        int r15 = (r13 + 1) * 4;
        int r16 = 4;
    L15:
        if (r16 >= 32) goto L20;
        int r17 = (1 << r16) - 12;
        if (r15 <= r17) goto L18;
        r16 = r16 + 1;
        goto L15
    L18:
        r15 = r17;
    L20:
        int r18 = r15 / 4;
        int[] r19 = new int[r18];
        Object[] r20 = new Object[r18];
        int[] r21 = this.f9403a;
        System.arraycopy(r21, 0, r19, 0, r21.length);
        Object[] r22 = this.f9404b;
        System.arraycopy(r22, 0, r20, 0, r22.length);
        this.f9403a = r19;
        this.f9404b = r20;
    L21:
        int r23 = this.f9405m - r12;
        if (r23 == 0) goto L24;
        int[] r24 = this.f9403a;
        int r25 = r12 + 1;
        System.arraycopy(r24, r12, r24, r25, r23);
        Object[] r26 = this.f9404b;
        System.arraycopy(r26, r12, r26, r25, this.f9405m - r12);
    L24:
        this.f9403a[r12] = r8;
        this.f9404b[r12] = r10;
        this.f9405m++;
    }

    public final String toString() {
        if (this.f9405m > 0) goto L6;
        return "{}";
    L6:
        StringBuilder r8 = new StringBuilder(this.f9405m * 28);
        r8.append('{');
        int r10 = 0;
    L8:
        if (r10 >= this.f9405m) goto L16;
        if (r10 <= 0) goto L11;
        r8.append(", ");
    L11:
        r8.append(this.f9403a[r10]);
        r8.append('=');
        Object r11 = this.f9404b[r10];
        if (r11 == this) goto L14;
        r8.append(r11);
    L15:
        r10 = r10 + 1;
        goto L8
    L14:
        r8.append("(this Map)");
        goto L15
    L16:
        r8.append('}');
        return r8.toString();
    }
}
