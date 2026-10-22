package com.ctc.wstx.util;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f3703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String[] f3704b;
    protected a[] c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected boolean h;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f3705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f3706b;

        public a(String r1, a r2) {
            this.f3705a = r1;
            this.f3706b = r2;
        }

        public String a() {
            return this.f3705a;
        }

        public String a(String r3) {
            String r0 = this.f3705a;
            a r2 = this.f3706b;
        L4:
            if (r0.equals(r3) == true) goto L5;
            if (r2 == null) goto L7;
            r0 = r2.a();
            r2 = r2.b();
            goto L4
        L7:
            return null;
        L5:
            return r0;
        }

        public String a(char[] r5, int r6, int r7) {
            String r0 = this.f3705a;
            a r4 = this.f3706b;
        L4:
            if (r0.length() != r7) goto L13;
            int r1 = 0;
        L7:
            if (r0.charAt(r1) != r5[r6 + r1]) goto L11;
            r1 = r1 + 1;
            if (r1 < r7) goto L7;
        L11:
            if (r1 != r7) goto L13;
            return r0;
        L13:
            if (r4 == null) goto L14;
            r0 = r4.a();
            r4 = r4.b();
            goto L4
        L14:
            return null;
        }

        public a b() {
            return this.f3706b;
        }
    }

    public k() {
        this(true);
    }

    public k(boolean r2) {
        this(r2, 128);
    }

    public k(boolean r2, int r3) {
        this(r2, r3, 0.75f);
    }

    public k(boolean r3, int r4, float r5) {
        this.f3703a = r3;
        this.g = 1;
        this.h = true;
        if (r4 < 1) goto L18;
        int r6 = 4;
    L5:
        if (r6 >= r4) goto L7;
        r6 = r6 + r6;
        goto L5
    L7:
        this.f3704b = new String[r6];
        this.c = new a[r6 >> 1];
        this.f = r6 - 1;
        this.d = 0;
        if (r5 < 0.01f) goto L16;
        if (r5 > 10.0f) goto L14;
        this.e = (int) (((double) (r6 * r5)) + 0.5d);
        return;
    L14:
        throw new IllegalArgumentException("Fill factor can not be higher than 10.0.");
    L16:
        throw new IllegalArgumentException("Fill factor can not be lower than 0.01.");
    L18:
        throw new IllegalArgumentException("Can not use negative/zero initial size: " + r4);
    }

    private k(boolean r1, String[] r2, a[] r3, int r4, int r5, int r6, int r7) {
        this.f3703a = r1;
        this.f3704b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = false;
    }

    public static int a(char[] r3, int r4, int r5) {
        int r1 = 1;
        int r0 = r3[r4];
    L3:
        if (r1 >= r5) goto L5;
        int r2 = (r0 * 31) + r3[r4 + r1];
        r1 = r1 + 1;
        r0 = r2;
        goto L3
    L5:
        return r0;
    }

    public static int b(String r4) {
        int r0 = r4.charAt(0);
        int r1 = r4.length();
        int r2 = 1;
    L3:
        if (r2 >= r1) goto L5;
        r0 = (r0 * 31) + r4.charAt(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private void e() {
        String[] r0 = this.f3704b;
        int r1 = r0.length;
        String[] r2 = new String[r1];
        this.f3704b = r2;
        System.arraycopy(r0, 0, r2, 0, r1);
        a[] r3 = this.c;
        int r4 = r3.length;
        a[] r5 = new a[r4];
        this.c = r5;
        System.arraycopy(r3, 0, r5, 0, r4);
    }

    private void f() {
        String[] r0 = this.f3704b;
        int r1 = r0.length;
        int r2 = r1 + r1;
        a[] r3 = this.c;
        this.f3704b = new String[r2];
        this.c = new a[r2 >> 1];
        this.f = r2 - 1;
        int r4 = this.e;
        this.e = r4 + r4;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L3:
        if (r6 >= r1) goto L11;
        String r8 = r0[r6];
        if (r8 == null) goto L10;
        r7 = r7 + 1;
        int r9 = b(r8) & this.f;
        String[] r10 = this.f3704b;
        if (r10[r9] != null) goto L9;
        r10[r9] = r8;
        goto L10
    L9:
        int r11 = r9 >> 1;
        this.c[r11] = new a(r8, this.c[r11]);
    L10:
        r6 = r6 + 1;
        goto L3
    L11:
        int r12 = r1 >> 1;
    L12:
        if (r5 >= r12) goto L22;
        a r13 = r3[r5];
    L14:
        if (r13 == null) goto L20;
        r7 = r7 + 1;
        String r14 = r13.a();
        int r15 = b(r14) & this.f;
        String[] r16 = this.f3704b;
        if (r16[r15] != null) goto L18;
        r16[r15] = r14;
    L19:
        r13 = r13.b();
        goto L14
    L18:
        int r17 = r15 >> 1;
        this.c[r17] = new a(r14, this.c[r17]);
        goto L19
    L20:
        r5 = r5 + 1;
        goto L12
    L22:
        if (r7 != this.d) goto L25;
        return;
    L25:
        throw new IllegalStateException("Internal error on SymbolTable.rehash(): had " + this.d + " entries; now have " + r7 + ".");
    }

    public k a() {
        monitor-enter(this);
        boolean r1 = this.f3703a;     // Catch: Throwable -> L7
        String[] r2 = this.f3704b;     // Catch: Throwable -> L7
        a[] r3 = this.c;     // Catch: Throwable -> L7
        int r4 = this.d;     // Catch: Throwable -> L7
        int r5 = this.e;     // Catch: Throwable -> L7
        int r6 = this.f;     // Catch: Throwable -> L7
        int r7 = this.g + 1;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return new k(r1, r2, r3, r4, r5, r6, r7);
    L7:
        th = move-exception;
        throw th;
    }

    public String a(String r8) {
        int r0 = r8.length();
        if (r0 >= 1) goto L6;
        return "";
    L6:
        int r2 = b(r8) & this.f;
        String r3 = this.f3704b[r2];
        if (r3 == null) goto L24;
        if (r3.length() != r0) goto L18;
        int r4 = 0;
    L11:
        if (r4 >= r0) goto L16;
        if (r3.charAt(r4) != r8.charAt(r4)) goto L16;
        r4 = r4 + 1;
    L16:
        if (r4 != r0) goto L18;
        return r3;
    L18:
        a r1 = this.c[r2 >> 1];
        if (r1 == null) goto L24;
        String r5 = r1.a(r8);
        if (r5 == null) goto L24;
        return r5;
    L24:
        if (this.d < this.e) goto L27;
        f();
        r2 = this.f & b(r8);
    L29:
        this.d++;
        if (this.f3703a == false) goto L32;
        r8 = r8.intern();
    L32:
        String[] r6 = this.f3704b;
        if (r6[r2] != null) goto L35;
        r6[r2] = r8;
    L36:
        return r8;
    L35:
        int r7 = r2 >> 1;
        this.c[r7] = new a(r8, this.c[r7]);
        goto L36
    L27:
        if (this.h == true) goto L29;
        e();
        this.h = true;
        goto L29
    }

    public String a(char[] r6, int r7, int r8, int r9) {
        if (r8 >= 1) goto L6;
        return "";
    L6:
        int r10 = r9 & this.f;
        String r1 = this.f3704b[r10];
        if (r1 == null) goto L24;
        if (r1.length() != r8) goto L18;
        int r2 = 0;
    L12:
        if (r1.charAt(r2) != r6[r7 + r2]) goto L16;
        r2 = r2 + 1;
        if (r2 < r8) goto L12;
    L16:
        if (r2 != r8) goto L18;
        return r1;
    L18:
        a r3 = this.c[r10 >> 1];
        if (r3 == null) goto L24;
        String r4 = r3.a(r6, r7, r8);
        if (r4 == null) goto L24;
        return r4;
    L24:
        if (this.d < this.e) goto L27;
        f();
        r10 = a(r6, r7, r8) & this.f;
    L29:
        this.d++;
        String r5 = new String(r6, r7, r8);
        if (this.f3703a == false) goto L32;
        r5 = r5.intern();
    L32:
        String[] r11 = this.f3704b;
        if (r11[r10] != null) goto L35;
        r11[r10] = r5;
    L36:
        return r5;
    L35:
        int r12 = r10 >> 1;
        this.c[r12] = new a(r5, this.c[r12]);
        goto L36
    L27:
        if (this.h == true) goto L29;
        e();
        this.h = true;
        goto L29
    }

    public synchronized void a(k r3) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (r3.b() > b()) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f3704b = r3.f3704b;     // Catch: Throwable -> L10
        this.c = r3.c;     // Catch: Throwable -> L10
        this.d = r3.d;     // Catch: Throwable -> L10
        this.e = r3.e;     // Catch: Throwable -> L10
        this.f = r3.f;     // Catch: Throwable -> L10
        this.g++;     // Catch: Throwable -> L10
        this.h = false;     // Catch: Throwable -> L10
        r3.h = false;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public void a(boolean r1) {
        this.f3703a = r1;
    }

    public int b() {
        return this.d;
    }

    public boolean b(k r2) {
        if (this.g != (r2.g + 1)) goto L5;
        return true;
    L5:
        return false;
    }

    public int c() {
        return this.g;
    }

    public boolean d() {
        return this.h;
    }
}
