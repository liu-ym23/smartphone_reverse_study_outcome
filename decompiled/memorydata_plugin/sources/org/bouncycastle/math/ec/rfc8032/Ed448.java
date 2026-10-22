package org.bouncycastle.math.ec.rfc8032;

import java.util.Objects;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.math.ec.rfc7748.X448;
import org.bouncycastle.math.ec.rfc7748.X448Field;
import org.bouncycastle.math.raw.Nat;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Ed448 {
    private static final int[] B_x = null;
    private static final int[] B_y = null;
    private static final byte[] DOM4_PREFIX = null;
    private static final int[] L = null;
    private static final int[] P = null;
    private static int[] PRECOMP_BASE_COMB;
    private static PointAffine[] PRECOMP_BASE_WNAF;
    private static final Object PRECOMP_LOCK = null;

    /* JADX INFO: renamed from: org.bouncycastle.math.ec.rfc8032.Ed448$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class F extends X448Field {
    }

    private static class PointAffine {
        int[] x;
        int[] y;

        private PointAffine() {
            this.x = F.create();
            this.y = F.create();
        }

        /* synthetic */ PointAffine(AnonymousClass1 r1) {
            this();
        }
    }

    private static class PointProjective {
        int[] x;
        int[] y;
        int[] z;

        private PointProjective() {
            this.x = F.create();
            this.y = F.create();
            this.z = F.create();
        }

        /* synthetic */ PointProjective(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        DOM4_PREFIX = new byte[]{83, 105, 103, 69, 100, 52, 52, 56};
        P = new int[]{-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};
        L = new int[]{-1420278541, 595116690, -1916432555, 560775794, -1361693040, -1001465015, 2093622249, -1, -1, -1, -1, -1, -1, 1073741823};
        B_x = new int[]{118276190, 40534716, 9670182, 135141552, 85017403, 259173222, 68333082, 171784774, 174973732, 15824510, 73756743, 57518561, 94773951, 248652241, 107736333, 82941708};
        B_y = new int[]{36764180, 8885695, 130592152, 20104429, 163904957, 30304195, 121295871, 5901357, 125344798, 171541512, 175338348, 209069246, 3626697, 38307682, 24032956, 110359655};
        PRECOMP_LOCK = new Object();
        PRECOMP_BASE_WNAF = null;
        PRECOMP_BASE_COMB = null;
    }

    private static int checkPoint(int[] r3, int[] r4) {
        int[] r0 = F.create();
        int[] r1 = F.create();
        int[] r2 = F.create();
        F.sqr(r3, r1);
        F.sqr(r4, r2);
        F.mul(r1, r2, r0);
        F.add(r1, r2, r1);
        F.mul(r0, 39081, r0);
        F.subOne(r0);
        F.add(r0, r1, r0);
        F.normalize(r0);
        return F.isZero(r0);
    }

    private static int checkPoint(int[] r4, int[] r5, int[] r6) {
        int[] r0 = F.create();
        int[] r1 = F.create();
        int[] r2 = F.create();
        int[] r3 = F.create();
        F.sqr(r4, r1);
        F.sqr(r5, r2);
        F.sqr(r6, r3);
        F.mul(r1, r2, r0);
        F.add(r1, r2, r1);
        F.mul(r1, r3, r1);
        F.sqr(r3, r3);
        F.mul(r0, 39081, r0);
        F.sub(r0, r3, r0);
        F.add(r0, r1, r0);
        F.normalize(r0);
        return F.isZero(r0);
    }

    private static Xof createXof() {
        return new SHAKEDigest(256);
    }

    private static int decode32(byte[] r2, int r3) {
        int r0 = r2[r3] & 255;
        int r4 = r3 + 1;
        int r1 = r0 | ((r2[r4] & 255) << 8);
        int r5 = r4 + 1;
        int r6 = r1 | ((r2[r5] & 255) << 16);
        return (r2[r5 + 1] << 24) | r6;
    }

    private static void decode32(byte[] r3, int r4, int[] r5, int r6, int r7) {
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L5;
        r5[r6 + r0] = decode32(r3, (r0 * 4) + r4);
        r0 = r0 + 1;
        goto L3
    }

    private static void decodeScalar(byte[] r2, int r3, int[] r4) {
        decode32(r2, r3, r4, 0, 14);
    }

    private static int encodePoint(PointProjective r3, byte[] r4, int r5) {
        int[] r0 = F.create();
        int[] r1 = F.create();
        F.inv(r3.z, r1);
        F.mul(r3.x, r1, r0);
        F.mul(r3.y, r1, r1);
        F.normalize(r0);
        F.normalize(r1);
        int r6 = checkPoint(r0, r1);
        F.encode(r1, r4, r5);
        r4[(r5 + 57) - 1] = (byte) ((r0[0] & 1) << 7);
        return r6;
    }

    public static void generatePublicKey(byte[] r4, int r5, byte[] r6, int r7) {
        Xof r0 = createXof();
        byte[] r2 = new byte[114];
        r0.update(r4, r5, 57);
        r0.doFinal(r2, 0, 114);
        byte[] r8 = new byte[57];
        pruneScalar(r2, 0, r8);
        scalarMultBaseEncoded(r8, r6, r7);
    }

    private static void invertZs(PointProjective[] r7) {
        int r0 = r7.length;
        int[] r1 = F.createTable(r0);
        int[] r2 = F.create();
        F.copy(r7[0].z, 0, r2, 0);
        F.copy(r2, 0, r1, 0);
        int r4 = 0;
    L3:
        r4 = r4 + 1;
        if (r4 >= r0) goto L6;
        F.mul(r2, r7[r4].z, r2);
        F.copy(r2, 0, r1, r4 * 16);
        goto L3
    L6:
        F.invVar(r2, r2);
        int r5 = r4 - 1;
        int[] r3 = F.create();
    L7:
        if (r5 <= 0) goto L9;
        int r6 = r5 - 1;
        F.copy(r1, r6 * 16, r3, 0);
        F.mul(r3, r2, r3);
        F.mul(r2, r7[r5].z, r2);
        F.copy(r3, 0, r7[r5].z, 0);
        r5 = r6;
        goto L7
    L9:
        F.copy(r2, 0, r7[0].z, 0);
    }

    private static void pointAdd(PointAffine r9, PointProjective r10) {
        int[] r0 = F.create();
        int[] r1 = F.create();
        int[] r2 = F.create();
        int[] r3 = F.create();
        int[] r4 = F.create();
        int[] r5 = F.create();
        int[] r6 = F.create();
        F.sqr(r10.z, r0);
        F.mul(r9.x, r10.x, r1);
        F.mul(r9.y, r10.y, r2);
        F.mul(r1, r2, r3);
        F.mul(r3, 39081, r3);
        F.add(r0, r3, r4);
        F.sub(r0, r3, r5);
        F.add(r9.y, r9.x, r6);
        F.add(r10.y, r10.x, r3);
        F.mul(r6, r3, r6);
        F.add(r2, r1, r0);
        F.sub(r2, r1, r3);
        F.carry(r0);
        F.sub(r6, r0, r6);
        F.mul(r6, r10.z, r6);
        F.mul(r3, r10.z, r3);
        F.mul(r4, r6, r10.x);
        F.mul(r3, r5, r10.y);
        F.mul(r4, r5, r10.z);
    }

    private static void pointAdd(PointProjective r10, PointProjective r11) {
        int[] r0 = F.create();
        int[] r1 = F.create();
        int[] r2 = F.create();
        int[] r3 = F.create();
        int[] r4 = F.create();
        int[] r5 = F.create();
        int[] r6 = F.create();
        int[] r7 = F.create();
        F.mul(r10.z, r11.z, r0);
        F.sqr(r0, r1);
        F.mul(r10.x, r11.x, r2);
        F.mul(r10.y, r11.y, r3);
        F.mul(r2, r3, r4);
        F.mul(r4, 39081, r4);
        F.add(r1, r4, r5);
        F.sub(r1, r4, r6);
        F.add(r10.y, r10.x, r7);
        F.add(r11.y, r11.x, r4);
        F.mul(r7, r4, r7);
        F.add(r3, r2, r1);
        F.sub(r3, r2, r4);
        F.carry(r1);
        F.sub(r7, r1, r7);
        F.mul(r7, r0, r7);
        F.mul(r4, r0, r4);
        F.mul(r5, r7, r11.x);
        F.mul(r4, r6, r11.y);
        F.mul(r5, r6, r11.z);
    }

    private static void pointCopy(PointProjective r3, PointProjective r4) {
        F.copy(r3.x, 0, r4.x, 0);
        F.copy(r3.y, 0, r4.y, 0);
        F.copy(r3.z, 0, r4.z, 0);
    }

    private static void pointDouble(PointProjective r8) {
        int[] r0 = F.create();
        int[] r1 = F.create();
        int[] r2 = F.create();
        int[] r3 = F.create();
        int[] r4 = F.create();
        int[] r5 = F.create();
        F.add(r8.x, r8.y, r0);
        F.sqr(r0, r0);
        F.sqr(r8.x, r1);
        F.sqr(r8.y, r2);
        F.add(r1, r2, r3);
        F.carry(r3);
        F.sqr(r8.z, r4);
        F.add(r4, r4, r4);
        F.carry(r4);
        F.sub(r3, r4, r5);
        F.sub(r0, r3, r0);
        F.sub(r1, r2, r1);
        F.mul(r0, r5, r8.x);
        F.mul(r3, r1, r8.y);
        F.mul(r3, r5, r8.z);
    }

    private static void pointLookup(int r6, int r7, PointAffine r8) {
        int r9 = ((r6 * 16) * 2) * 16;
        int r2 = 0;
    L3:
        if (r2 >= 16) goto L5;
        int r3 = ((r2 ^ r7) - 1) >> 31;
        F.cmov(r3, PRECOMP_BASE_COMB, r9, r8.x, 0);
        int r10 = r9 + 16;
        F.cmov(r3, PRECOMP_BASE_COMB, r10, r8.y, 0);
        r9 = r10 + 16;
        r2 = r2 + 1;
        goto L3
    }

    private static void pointPrecomputeVar(PointProjective r4, PointProjective[] r5, int r6) {
        AnonymousClass1 r1 = null;
        PointProjective r0 = new PointProjective(r1);
        pointCopy(r4, r0);
        pointDouble(r0);
        r5[0] = new PointProjective(r1);
        pointCopy(r4, r5[0]);
        int r7 = 1;
    L3:
        if (r7 >= r6) goto L5;
        r5[r7] = new PointProjective(r1);
        pointCopy(r5[r7 - 1], r5[r7]);
        pointAdd(r0, r5[r7]);
        r7 = r7 + 1;
        goto L3
    }

    private static void pointSetNeutral(PointProjective r1) {
        F.zero(r1.x);
        F.one(r1.y);
        F.one(r1.z);
    }

    public static void precompute() {
        Object r1 = PRECOMP_LOCK;
        monitor-enter(r1);
    L43:
        th = move-exception;
        throw th;
    L5:
        if (PRECOMP_BASE_WNAF != null) goto L7;
    L10:
        int r0 = 32;
        PointProjective[] r3 = new PointProjective[112];     // Catch: Throwable -> L43
        AnonymousClass1 r5 = null;
        PointProjective r4 = new PointProjective(r5);     // Catch: Throwable -> L43
        F.copy(B_x, 0, r4.x, 0);     // Catch: Throwable -> L43
        F.copy(B_y, 0, r4.y, 0);     // Catch: Throwable -> L43
        F.one(r4.z);     // Catch: Throwable -> L43
        pointPrecomputeVar(r4, r3, 32);     // Catch: Throwable -> L43
        int r6 = 5;
        PointProjective[] r7 = new PointProjective[5];     // Catch: Throwable -> L43
        int r9 = 0;
    L11:
        if (r9 >= 5) goto L13;
        r7[r9] = new PointProjective(r5);     // Catch: Throwable -> L43
        r9 = r9 + 1;     // Catch: Throwable -> L43
        goto L11
    L13:
        int r10 = 32;
        int r11 = 0;
    L14:
        if (r11 >= r6) goto L35;
        int r12 = r10 + 1;     // Catch: Throwable -> L43
        PointProjective r13 = new PointProjective(r5);     // Catch: Throwable -> L43
        r3[r10] = r13;     // Catch: Throwable -> L43
        int r14 = 0;
    L16:
        int r15 = 1;
        if (r14 >= r6) goto L27;
        if (r14 != 0) goto L20;
        pointCopy(r4, r13);     // Catch: Throwable -> L43
    L21:
        pointDouble(r4);     // Catch: Throwable -> L43
        pointCopy(r4, r7[r14]);     // Catch: Throwable -> L43
        if ((r11 + r14) == 8) goto L26;
    L24:
        if (r15 >= 18) goto L26;
        pointDouble(r4);     // Catch: Throwable -> L43
        r15 = r15 + 1;     // Catch: Throwable -> L43
    L26:
        r14 = r14 + 1;     // Catch: Throwable -> L43
        goto L16
    L20:
        pointAdd(r4, r13);     // Catch: Throwable -> L43
        goto L21
    L27:
        F.negate(r13.x, r13.x);     // Catch: Throwable -> L43
        r10 = r12;
        int r16 = 0;
    L29:
        if (r16 >= 4) goto L34;
        int r17 = 1 << r16;     // Catch: Throwable -> L43
        int r18 = 0;
    L31:
        if (r18 >= r17) goto L33;
        r3[r10] = new PointProjective(r5);     // Catch: Throwable -> L43
        pointCopy(r3[r10 - r17], r3[r10]);     // Catch: Throwable -> L43
        pointAdd(r7[r16], r3[r10]);     // Catch: Throwable -> L43
        r18 = r18 + 1;     // Catch: Throwable -> L43
        r10 = r10 + 1;     // Catch: Throwable -> L43
        goto L31
    L33:
        r16 = r16 + 1;     // Catch: Throwable -> L43
        goto L29
    L34:
        r11 = r11 + 1;     // Catch: Throwable -> L43
        r6 = 5;
        goto L14
    L35:
        invertZs(r3);     // Catch: Throwable -> L43
        PRECOMP_BASE_WNAF = new PointAffine[32];     // Catch: Throwable -> L43
        int r8 = 0;
    L36:
        if (r8 >= 32) goto L38;
        PointProjective r19 = r3[r8];     // Catch: Throwable -> L43
        PointAffine[] r20 = PRECOMP_BASE_WNAF;     // Catch: Throwable -> L43
        PointAffine r21 = new PointAffine(r5);     // Catch: Throwable -> L43
        r20[r8] = r21;     // Catch: Throwable -> L43
        F.mul(r19.x, r19.z, r21.x);     // Catch: Throwable -> L43
        F.normalize(r21.x);     // Catch: Throwable -> L43
        F.mul(r19.y, r19.z, r21.y);     // Catch: Throwable -> L43
        F.normalize(r21.y);     // Catch: Throwable -> L43
        r8 = r8 + 1;     // Catch: Throwable -> L43
        goto L36
    L38:
        PRECOMP_BASE_COMB = F.createTable(160);     // Catch: Throwable -> L43
        int r22 = 0;
    L39:
        if (r0 >= 112) goto L41;
        PointProjective r23 = r3[r0];     // Catch: Throwable -> L43
        F.mul(r23.x, r23.z, r23.x);     // Catch: Throwable -> L43
        F.normalize(r23.x);     // Catch: Throwable -> L43
        F.mul(r23.y, r23.z, r23.y);     // Catch: Throwable -> L43
        F.normalize(r23.y);     // Catch: Throwable -> L43
        F.copy(r23.x, 0, PRECOMP_BASE_COMB, r22);     // Catch: Throwable -> L43
        int r24 = r22 + 16;     // Catch: Throwable -> L43
        F.copy(r23.y, 0, PRECOMP_BASE_COMB, r24);     // Catch: Throwable -> L43
        r22 = r24 + 16;     // Catch: Throwable -> L43
        r0 = r0 + 1;     // Catch: Throwable -> L43
        goto L39
    L41:
        monitor-exit(r1);     // Catch: Throwable -> L43
        return;
    L7:
        if (PRECOMP_BASE_COMB == null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L43
    }

    private static void pruneScalar(byte[] r2, int r3, byte[] r4) {
        System.arraycopy(r2, r3, r4, 0, 56);
        r4[0] = (byte) (r4[0] & 252);
        r4[55] = (byte) (r4[55] | 128);
        r4[56] = 0;
    }

    private static void scalarMultBase(byte[] r12, PointProjective r13) {
        precompute();
        int[] r1 = new int[15];
        decodeScalar(r12, 0, r1);
        r1[14] = Nat.cadd(14, (~r1[0]) & 1, r1, L, r1) + 4;
        Nat.shiftDownBit(15, r1, 0);
        PointAffine r14 = new PointAffine(null);
        pointSetNeutral(r13);
        int r4 = 17;
    L3:
        int r5 = 0;
        int r6 = r4;
    L5:
        if (r5 >= 5) goto L10;
        int r8 = 0;
        int r9 = 0;
    L7:
        if (r8 >= 5) goto L9;
        r9 = (r9 & (~(1 << r8))) ^ ((r1[r6 >>> 5] >>> (r6 & 31)) << r8);
        r6 = r6 + 18;
        r8 = r8 + 1;
        goto L7
    L9:
        int r7 = (r9 >>> 4) & 1;
        pointLookup(r5, ((-r7) ^ r9) & 15, r14);
        F.cnegate(r7, r14.x);
        pointAdd(r14, r13);
        r5 = r5 + 1;
        goto L5
    L10:
        r4 = r4 - 1;
        if (r4 < 0) goto L12;
        pointDouble(r13);
        goto L3
    }

    private static void scalarMultBaseEncoded(byte[] r2, byte[] r3, int r4) {
        PointProjective r0 = new PointProjective(null);
        scalarMultBase(r2, r0);
        if (encodePoint(r0, r3, r4) == 0) goto L6;
        return;
    L6:
        throw new IllegalStateException();
    }

    public static void scalarMultBaseXY(X448.Friend r1, byte[] r2, int r3, int[] r4, int[] r5) {
        Objects.requireNonNull(r1, "This method is only for use by X448");
        byte[] r6 = new byte[57];
        pruneScalar(r2, r3, r6);
        PointProjective r7 = new PointProjective(null);
        scalarMultBase(r6, r7);
        if (checkPoint(r7.x, r7.y, r7.z) == 0) goto L7;
        F.copy(r7.x, 0, r4, 0);
        F.copy(r7.y, 0, r5, 0);
        return;
    L7:
        throw new IllegalStateException();
    }
}
