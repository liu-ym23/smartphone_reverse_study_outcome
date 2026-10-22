package p4;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f9938a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9939b = null;

    /* JADX INFO: renamed from: p4.a$a, reason: collision with other inner class name */
    public static class C0134a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f9941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9942c;

        public C0134a(int r8, boolean r10) {
            this.f9940a = r8;
            this.f9941b = r10;
        }
    }

    static {
        f9938a = !"little".equals(System.getProperty("sun.cpu.endian"));
        f9939b = new a();
    }

    public static int a(int r8, byte[] r10) {
        C0134a r11 = new C0134a(4, f9938a);
        int r12 = 0;
    L3:
        int r13 = r11.f9942c;
        int r14 = r11.f9940a;
        if (r13 >= r14) goto L6;
        boolean r15 = true;
    L7:
        if (r15 == false) goto L13;
        if (r11.f9941b == true) goto L11;
        r11.f9942c = r13 + 1;
    L12:
        r12 = r12 | ((r10[r13 + r8] & 255) << (r13 * 8));
        goto L3
    L11:
        r11.f9942c = r13 + 1;
        r13 = (r14 - 1) - r13;
        goto L12
    L13:
        return r12;
    L6:
        r15 = false;
        goto L7
    }

    public static long b(int r10, byte[] r11) {
        C0134a r8 = new C0134a(8, f9938a);
        long r12 = 0;
    L3:
        int r13 = r8.f9942c;
        int r14 = r8.f9940a;
        if (r13 >= r14) goto L6;
        boolean r15 = true;
    L7:
        if (r15 == false) goto L13;
        if (r8.f9941b == true) goto L11;
        r8.f9942c = r13 + 1;
    L12:
        r12 = r12 | ((((long) r11[r13 + r10]) & 255) << (r13 * 8));
        goto L3
    L11:
        r8.f9942c = r13 + 1;
        r13 = (r14 - 1) - r13;
        goto L12
    L13:
        return r12;
    L6:
        r15 = false;
        goto L7
    }

    public static long c(long r8, long r10) {
        b r11 = new b(r8, r10);
        long r12 = r11.f9943a;
        long r13 = r11.f9944b;
        long r14 = (r12 ^ r13) * (-7070675565921424023L);
        long r15 = ((r14 ^ (r14 >>> 47)) ^ r13) * (-7070675565921424023L);
        return (r15 ^ (r15 >>> 47)) * (-7070675565921424023L);
    }

    public static long d(int r8, long r10) {
        if (r8 != 0) goto L5;
        return r10;
    L5:
        return (r10 >>> r8) | (r10 << (64 - r8));
    }

    public static b e(byte[] r8, int r10, long r11, long r12) {
        long r13 = b(r10, r8);
        long r14 = b(r10 + 8, r8);
        long r15 = b(r10 + 16, r8);
        long r16 = b(r10 + 24, r8);
        long r17 = r11 + r13;
        long r18 = d(21, (r12 + r17) + r16);
        long r19 = (r14 + r17) + r15;
        long r20 = d(44, r19) + r18;
        return new b(r19 + r16, r20 + r17);
    }
}
