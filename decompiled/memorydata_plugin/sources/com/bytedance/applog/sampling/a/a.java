package com.bytedance.applog.sampling.a;

import com.bytedance.rpc.internal.RpcUtils;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f1866a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f1867b;
    private static long c;

    /* JADX INFO: renamed from: com.bytedance.applog.sampling.a.a$a, reason: collision with other inner class name */
    private static class C0105a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f1868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f1869b;
        private int c;

        C0105a(int r1, boolean r2) {
            this.f1868a = r1;
            this.f1869b = r2;
        }

        boolean a() {
            if (this.c >= this.f1868a) goto L5;
            return true;
        L5:
            return false;
        }

        int b() {
            if (this.f1869b == true) goto L6;
            int r0 = this.c;
            this.c = r0 + 1;
            return r0;
        L6:
            int r1 = this.f1868a - 1;
            int r2 = this.c;
            this.c = r2 + 1;
            return r1 - r2;
        }
    }

    static {
        f1866a = !"little".equals(System.getProperty("sun.cpu.endian"));
        f1867b = new a();
        c = 4611686018427387904L;
    }

    public a() {
    }

    private long a(long r3) {
        return r3 ^ (r3 >>> 47);
    }

    private long a(long r3, int r5) {
        if (r5 != 0) goto L5;
        return r3;
    L5:
        return (r3 >>> r5) | (r3 << (64 - r5));
    }

    private long a(long r2, long r4) {
        return a(new b(r2, r4));
    }

    private long a(long r3, long r5, long r7) {
        long r2 = (r3 ^ r5) * r7;
        long r4 = ((r2 ^ (r2 >>> 47)) ^ r5) * r7;
        return (r4 ^ (r4 >>> 47)) * r7;
    }

    private long a(b r7) {
        long r0 = (r7.a() ^ r7.b()) * (-7070675565921424023L);
        long r1 = ((r0 ^ (r0 >>> 47)) ^ r7.b()) * (-7070675565921424023L);
        return ((r1 >>> 47) ^ r1) * (-7070675565921424023L);
    }

    private long a(byte[] r14) {
        int r2 = r14.length;
        if (r2 < 8) goto L7;
        long r7 = ((long) (r2 * 2)) - 7286425919675154353L;
        long r9 = c(r14, 0) - 7286425919675154353L;
        long r1 = c(r14, r2 - 8);
        return a((a(r1, 37) * r7) + r9, (a(r9, 25) + r1) * r7, r7);
    L7:
        if (r2 >= 4) goto L9;
        if (r2 <= 0) goto L13;
        int r3 = r14[0] & 255;
        int r8 = r14[r2 >>> 1] & 255;
        return a((((long) (r2 + ((r14[r2 - 1] & 255) << 2))) * (-4348849565147123417L)) ^ (((long) (r3 + (r8 << 8))) * (-7286425919675154353L))) * (-7286425919675154353L);
    L13:
        return -7286425919675154353L;
    L9:
        return a(((((long) d(r14, 0)) & 4294967295L) << 3) + ((long) r2), ((long) d(r14, r2 - 4)) & 4294967295L, (-7286425919675154353L) + ((long) (r2 * 2)));
    }

    private long a(byte[] r9, int r10) {
        C0105a r8 = new C0105a(8, f1866a);
        long r2 = 0;
    L4:
        if (r8.a() == false) goto L6;
        int r0 = r8.b();
        r2 = r2 | ((((long) r9[r0 + r10]) & 255) << (r0 * 8));
        goto L4
    L6:
        return r2;
    }

    public static a a() {
        return f1867b;
    }

    private b a(long r1, long r3, long r5, long r7, long r9, long r11) {
        long r10 = r9 + r1;
        long r4 = (r3 + r10) + r5;
        long r2 = a((r11 + r10) + r7, 21) + a(r4, 44);
        return new b(r4 + r7, r2 + r10);
    }

    private b a(byte[] r14, int r15, long r16, long r18) {
        return a(c(r14, r15), c(r14, r15 + 8), c(r14, r15 + 16), c(r14, r15 + 24), r16, r18);
    }

    public static BigInteger a(String r1) {
        if (r1 != null) goto L5;
        r1 = "NULL";
    L5:
        return a().b(r1);
    }

    private int b(byte[] r4, int r5) {
        C0105a r3 = new C0105a(4, f1866a);
        int r0 = 0;
    L4:
        if (r3.a() == false) goto L6;
        int r1 = r3.b();
        r0 = r0 | ((r4[r1 + r5] & 255) << (r1 * 8));
        goto L4
    L6:
        return r0;
    }

    private long b(byte[] r18) {
        int r2 = r18.length;
        long r7 = ((long) (r2 * 2)) - 7286425919675154353L;
        long r3 = c(r18, 0) * (-5435081209227447693L);
        long r9 = c(r18, 8);
        long r11 = c(r18, r2 - 8) * r7;
        return a((c(r18, r2 - 16) * (-7286425919675154353L)) + (a(r3 + r9, 43) + a(r11, 30)), (r3 + a(r9 - 7286425919675154353L, 18)) + r11, r7);
    }

    private long c(String r29) {
        byte[] r8 = d(r29);
        int r9 = r8.length;
        if (r9 > 32) goto L11;
        if (r9 > 16) goto L9;
        return a(r8);
    L9:
        return b(r8);
    L11:
        if (r9 <= 64) goto L13;
        long r11 = c(r8, r9 - 40);
        long r13 = c(r8, r9 - 16) + c(r8, r9 - 56);
        long r3 = r9;
        long r15 = a(c(r8, r9 - 48) + r3, c(r8, r9 - 24));
        b r17 = a(r8, r9 - 64, r3, r15);
        b r0 = a(r8, r9 - 32, r13 - 5435081209227447693L, r11);
        long r12 = (r11 * (-5435081209227447693L)) + c(r8, 0);
        int r2 = (r9 - 1) & (-64);
        b r10 = r0;
        int r14 = 0;
        int r16 = r2;
        long r1 = r12;
    L15:
        long r4 = a(((r1 + r13) + r17.a()) + c(r8, r14 + 8), 37) * (-5435081209227447693L);
        long r5 = a((r13 + r17.b()) + c(r8, r14 + 48), 42) * (-5435081209227447693L);
        long r18 = r4 ^ r10.b();
        long r6 = r5 + (r17.a() + c(r8, r14 + 40));
        long r19 = a(r10.a() + r15, 33) * (-5435081209227447693L);
        r17 = a(r8, r14, r17.b() * (-5435081209227447693L), r18 + r10.a());
        r10 = a(r8, r14 + 32, r19 + r10.b(), r6 + c(r8, r14 + 16));
        r14 = r14 + 64;
        r16 = r16 - 64;
        if (r16 == 0) goto L18;
        r1 = r19;
        r15 = r18;
        r13 = r6;
        goto L15
    L18:
        return a((a(r17.a(), r10.a()) + (a(r6) * (-5435081209227447693L))) + r18, a(r17.b(), r10.b()) + r19);
    L13:
        return c(r8);
    }

    private long c(byte[] r27) {
        int r2 = r27.length;
        long r3 = ((long) (r2 * 2)) - 7286425919675154353L;
        long r7 = c(r27, 0) * (-7286425919675154353L);
        long r9 = c(r27, 8);
        long r11 = c(r27, r2 - 24);
        long r13 = c(r27, r2 - 32);
        long r16 = c(r27, 16) * (-7286425919675154353L);
        long r5 = c(r27, 24) * 9;
        long r6 = c(r27, r2 - 8);
        long r1 = c(r27, r2 - 16) * r3;
        long r8 = r7 + r6;
        long r22 = a(r8, 43) + ((a(r9, 30) + r11) * 9);
        long r10 = ((r8 ^ r13) + r5) + 1;
        long r18 = Long.reverseBytes((r22 + r10) * r3) + r1;
        long r4 = r16 + r5;
        long r15 = a(r4, 42) + r11;
        long r12 = r4 + r11;
        return (a((((r12 + (Long.reverseBytes(((r15 + r12) * r3) + ((Long.reverseBytes((r10 + r18) * r3) + r6) * r3)) + r9)) * r3) + r13) + r1) * r3) + r15;
    }

    private long c(byte[] r1, int r2) {
        return a(r1, r2);
    }

    private int d(byte[] r1, int r2) {
        return b(r1, r2);
    }

    private byte[] d(String r1) {
        return r1.getBytes(RpcUtils.CHARSET_UTF8);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public BigInteger b(String r3) {
        long r2 = c(r3);
        if (r2 < 0) goto L7;
        return BigInteger.valueOf(r2);
    L7:
        return BigInteger.valueOf(r2 & Long.MAX_VALUE).add(BigInteger.valueOf(Long.MAX_VALUE)).add(BigInteger.valueOf(1));
    }
}
