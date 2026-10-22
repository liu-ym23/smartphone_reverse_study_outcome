package j1;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f9734a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f9735b;

    /* JADX INFO: renamed from: j1.a$a, reason: collision with other inner class name */
    private static class C0205a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f9737b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f9738c;

        C0205a(int r10, boolean r11) {
            this.f9736a = r10;
            this.f9737b = r11;
        }

        boolean a() {
            if (this.f9738c >= this.f9736a) goto L5;
            return true;
        L5:
            return false;
        }

        int b() {
            if (this.f9737b == true) goto L6;
            int r10 = this.f9738c;
            this.f9738c = r10 + 1;
            return r10;
        L6:
            int r11 = this.f9736a - 1;
            int r12 = this.f9738c;
            this.f9738c = r12 + 1;
            return r11 - r12;
        }
    }

    static {
        f9734a = !"little".equals(System.getProperty("sun.cpu.endian"));
        f9735b = new a();
    }

    public a() {
    }

    private byte[] a(String r10) {
        return r10.getBytes("UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private int b(byte[] r10, int r11) {
        return n(r10, r11);
    }

    private long c(byte[] r10, int r11) {
        return o(r10, r11);
    }

    public static a d() {
        return f9735b;
    }

    private long e(b r10) {
        long r11 = (r10.b() ^ r10.a()) * (-7070675565921424023L);
        long r12 = ((r11 ^ (r11 >>> 47)) ^ r10.a()) * (-7070675565921424023L);
        return ((r12 >>> 47) ^ r12) * (-7070675565921424023L);
    }

    private long f(String r29) {
        byte[] r10 = a(r29);
        int r11 = r10.length;
        if (r11 > 32) goto L11;
        if (r11 > 16) goto L9;
        return i(r10);
    L9:
        return l(r10);
    L11:
        if (r11 <= 64) goto L13;
        long r12 = c(r10, r11 - 40);
        long r13 = c(r10, r11 - 16) + c(r10, r11 - 56);
        long r14 = r11;
        long r15 = j(c(r10, r11 - 48) + r14, c(r10, r11 - 24));
        b r17 = s(r10, r11 - 64, r14, r15);
        b r16 = s(r10, r11 - 32, r13 - 5435081209227447693L, r12);
        long r18 = (r12 * (-5435081209227447693L)) + c(r10, 0);
        int r19 = (r11 - 1) & (-64);
        b r20 = r16;
        int r110 = 0;
        int r111 = r19;
        long r21 = r18;
    L15:
        long r22 = p(((r21 + r13) + r17.b()) + c(r10, r110 + 8), 37) * (-5435081209227447693L);
        long r23 = p((r13 + r17.a()) + c(r10, r110 + 48), 42) * (-5435081209227447693L);
        long r112 = r22 ^ r20.a();
        long r24 = r23 + (r17.b() + c(r10, r110 + 40));
        long r113 = p(r20.b() + r15, 33) * (-5435081209227447693L);
        r17 = s(r10, r110, r17.a() * (-5435081209227447693L), r112 + r20.b());
        r20 = s(r10, r110 + 32, r113 + r20.a(), r24 + c(r10, r110 + 16));
        r110 = r110 + 64;
        r111 = r111 - 64;
        if (r111 == 0) goto L18;
        r21 = r113;
        r15 = r112;
        r13 = r24;
        goto L15
    L18:
        return j((j(r17.b(), r20.b()) + (q(r24) * (-5435081209227447693L))) + r112, j(r17.a(), r20.a()) + r113);
    L13:
        return m(r10);
    }

    public static BigInteger g(String r10) {
        if (r10 != null) goto L5;
        r10 = "NULL";
    L5:
        return d().h(r10);
    }

    private long i(byte[] r14) {
        int r10 = r14.length;
        if (r10 < 8) goto L7;
        long r11 = ((long) (r10 * 2)) - 7286425919675154353L;
        long r12 = c(r14, 0) - 7286425919675154353L;
        long r13 = c(r14, r10 - 8);
        return k((p(r13, 37) * r11) + r12, (p(r12, 25) + r13) * r11, r11);
    L7:
        if (r10 >= 4) goto L9;
        if (r10 <= 0) goto L13;
        int r15 = r14[0] & 255;
        int r16 = r14[r10 >>> 1] & 255;
        return q((((long) (r10 + ((r14[r10 - 1] & 255) << 2))) * (-4348849565147123417L)) ^ (((long) (r15 + (r16 << 8))) * (-7286425919675154353L))) * (-7286425919675154353L);
    L13:
        return -7286425919675154353L;
    L9:
        return k(((((long) b(r14, 0)) & 4294967295L) << 3) + ((long) r10), ((long) b(r14, r10 - 4)) & 4294967295L, (-7286425919675154353L) + ((long) (r10 * 2)));
    }

    private long j(long r10, long r11) {
        return e(new b(r10, r11));
    }

    private long k(long r10, long r11, long r12) {
        long r13 = (r10 ^ r11) * r12;
        long r14 = ((r13 ^ (r13 >>> 47)) ^ r11) * r12;
        return (r14 ^ (r14 >>> 47)) * r12;
    }

    private long l(byte[] r18) {
        int r10 = r18.length;
        long r11 = ((long) (r10 * 2)) - 7286425919675154353L;
        long r12 = c(r18, 0) * (-5435081209227447693L);
        long r13 = c(r18, 8);
        long r14 = c(r18, r10 - 8) * r11;
        return k((c(r18, r10 - 16) * (-7286425919675154353L)) + (p(r12 + r13, 43) + p(r14, 30)), (r12 + p(r13 - 7286425919675154353L, 18)) + r14, r11);
    }

    private long m(byte[] r27) {
        int r10 = r27.length;
        long r11 = ((long) (r10 * 2)) - 7286425919675154353L;
        long r12 = c(r27, 0) * (-7286425919675154353L);
        long r13 = c(r27, 8);
        long r14 = c(r27, r10 - 24);
        long r15 = c(r27, r10 - 32);
        long r16 = c(r27, 16) * (-7286425919675154353L);
        long r17 = c(r27, 24) * 9;
        long r18 = c(r27, r10 - 8);
        long r19 = c(r27, r10 - 16) * r11;
        long r20 = r12 + r18;
        long r22 = p(r20, 43) + ((p(r13, 30) + r14) * 9);
        long r21 = ((r20 ^ r15) + r17) + 1;
        long r110 = Long.reverseBytes((r22 + r21) * r11) + r19;
        long r23 = r16 + r17;
        long r111 = p(r23, 42) + r14;
        long r24 = r23 + r14;
        return (q((((r24 + (Long.reverseBytes(((r111 + r24) * r11) + ((Long.reverseBytes((r21 + r110) * r11) + r18) * r11)) + r13)) * r11) + r15) + r19) * r11) + r111;
    }

    private int n(byte[] r10, int r11) {
        C0205a r12 = new C0205a(4, f9734a);
        int r13 = 0;
    L4:
        if (r12.a() == false) goto L6;
        int r14 = r12.b();
        r13 = r13 | ((r10[r14 + r11] & 255) << (r14 * 8));
        goto L4
    L6:
        return r13;
    }

    private long o(byte[] r10, int r11) {
        C0205a r12 = new C0205a(8, f9734a);
        long r13 = 0;
    L4:
        if (r12.a() == false) goto L6;
        int r14 = r12.b();
        r13 = r13 | ((((long) r10[r14 + r11]) & 255) << (r14 * 8));
        goto L4
    L6:
        return r13;
    }

    private long p(long r10, int r11) {
        if (r11 != 0) goto L5;
        return r10;
    L5:
        return (r10 >>> r11) | (r10 << (64 - r11));
    }

    private long q(long r10) {
        return r10 ^ (r10 >>> 47);
    }

    private b r(long r10, long r11, long r12, long r13, long r14, long r15) {
        long r16 = r14 + r10;
        long r17 = (r11 + r16) + r12;
        long r18 = p((r15 + r16) + r13, 21) + p(r17, 44);
        return new b(r17 + r13, r18 + r16);
    }

    private b s(byte[] r14, int r15, long r16, long r18) {
        return r(c(r14, r15), c(r14, r15 + 8), c(r14, r15 + 16), c(r14, r15 + 24), r16, r18);
    }

    public BigInteger h(String r10) {
        long r11 = f(r10);
        if (r11 < 0) goto L7;
        return BigInteger.valueOf(r11);
    L7:
        return BigInteger.valueOf(r11 & Long.MAX_VALUE).add(BigInteger.valueOf(Long.MAX_VALUE)).add(BigInteger.valueOf(1));
    }
}
