package org.bouncycastle.math.ec.rfc8032;

import java.util.Objects;
import kotlin.jvm.internal.ByteCompanionObject;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.math.ec.rfc7748.X25519;
import org.bouncycastle.math.ec.rfc7748.X25519Field;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Ed25519 {
    private static final int[] B_x = null;
    private static final int[] B_y = null;
    private static final int[] C_d = null;
    private static final int[] C_d2 = null;
    private static final int[] C_d4 = null;
    private static final byte[] DOM2_PREFIX = null;
    private static final int[] L = null;
    private static final int[] P = null;
    private static int[] PRECOMP_BASE_COMB;
    private static PointPrecomp[] PRECOMP_BASE_WNAF;
    private static final Object PRECOMP_LOCK = null;

    /* JADX INFO: renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class F extends X25519Field {
    }

    private static class PointAccum {
        int[] u;
        int[] v;
        int[] x;
        int[] y;
        int[] z;

        private PointAccum() {
            this.x = F.create();
            this.y = F.create();
            this.z = F.create();
            this.u = F.create();
            this.v = F.create();
        }

        /* synthetic */ PointAccum(AnonymousClass1 r1) {
            this();
        }
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

    private static class PointExtended {
        int[] t;
        int[] x;
        int[] y;
        int[] z;

        private PointExtended() {
            this.x = F.create();
            this.y = F.create();
            this.z = F.create();
            this.t = F.create();
        }

        /* synthetic */ PointExtended(AnonymousClass1 r1) {
            this();
        }
    }

    private static class PointPrecomp {
        int[] xyd;
        int[] ymx_h;
        int[] ypx_h;

        private PointPrecomp() {
            this.ymx_h = F.create();
            this.ypx_h = F.create();
            this.xyd = F.create();
        }

        /* synthetic */ PointPrecomp(AnonymousClass1 r1) {
            this();
        }
    }

    private static class PointTemp {
        int[] r0;
        int[] r1;

        private PointTemp() {
            this.r0 = F.create();
            this.r1 = F.create();
        }

        /* synthetic */ PointTemp(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        DOM2_PREFIX = new byte[]{83, 105, 103, 69, 100, 50, 53, 53, 49, 57, 32, 110, 111, 32, 69, 100, 50, 53, 53, 49, 57, 32, 99, 111, 108, 108, 105, 115, 105, 111, 110, 115};
        P = new int[]{-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};
        L = new int[]{1559614445, 1477600026, -1560830762, 350157278, 0, 0, 0, SQLiteDatabase.CREATE_IF_NECESSARY};
        B_x = new int[]{52811034, 25909283, 8072341, 50637101, 13785486, 30858332, 20483199, 20966410, 43936626, 4379245};
        B_y = new int[]{40265304, 26843545, 6710886, 53687091, 13421772, 40265318, 26843545, 6710886, 53687091, 13421772};
        C_d = new int[]{56195235, 47411844, 25868126, 40503822, 57364, 58321048, 30416477, 31930572, 57760639, 10749657};
        C_d2 = new int[]{45281625, 27714825, 18181821, 13898781, 114729, 49533232, 60832955, 30306712, 48412415, 4722099};
        C_d4 = new int[]{23454386, 55429651, 2809210, 27797563, 229458, 31957600, 54557047, 27058993, 29715967, 9444199};
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
        F.sub(r2, r1, r2);
        F.mul(r0, C_d, r0);
        F.addOne(r0);
        F.sub(r0, r2, r0);
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
        F.sub(r2, r1, r2);
        F.mul(r2, r3, r2);
        F.sqr(r3, r3);
        F.mul(r0, C_d, r0);
        F.add(r0, r3, r0);
        F.sub(r0, r2, r0);
        F.normalize(r0);
        return F.isZero(r0);
    }

    private static Digest createDigest() {
        return new SHA512Digest();
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
        decode32(r2, r3, r4, 0, 8);
    }

    private static int encodePoint(PointAccum r3, byte[] r4, int r5) {
        int[] r0 = F.create();
        int[] r1 = F.create();
        F.inv(r3.z, r1);
        F.mul(r3.x, r1, r0);
        F.mul(r3.y, r1, r1);
        F.normalize(r0);
        F.normalize(r1);
        int r6 = checkPoint(r0, r1);
        F.encode(r1, r4, r5);
        int r7 = (r5 + 32) - 1;
        r4[r7] = (byte) (((r0[0] & 1) << 7) | r4[r7]);
        return r6;
    }

    public static void generatePublicKey(byte[] r3, int r4, byte[] r5, int r6) {
        Digest r0 = createDigest();
        byte[] r1 = new byte[r0.getDigestSize()];
        r0.update(r3, r4, 32);
        r0.doFinal(r1, 0);
        byte[] r7 = new byte[32];
        pruneScalar(r1, 0, r7);
        scalarMultBaseEncoded(r7, r5, r6);
    }

    private static void invertDoubleZs(PointExtended[] r7) {
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
        F.copy(r2, 0, r1, r4 * 10);
        goto L3
    L6:
        F.add(r2, r2, r2);
        F.invVar(r2, r2);
        int r5 = r4 - 1;
        int[] r3 = F.create();
    L7:
        if (r5 <= 0) goto L9;
        int r6 = r5 - 1;
        F.copy(r1, r6 * 10, r3, 0);
        F.mul(r3, r2, r3);
        F.mul(r2, r7[r5].z, r2);
        F.copy(r3, 0, r7[r5].z, 0);
        r5 = r6;
        goto L7
    L9:
        F.copy(r2, 0, r7[0].z, 0);
    }

    private static void pointAdd(PointExtended r5, PointExtended r6, PointExtended r7, PointTemp r8) {
        int[] r0 = r7.x;
        int[] r1 = r7.y;
        int[] r2 = r8.r0;
        int[] r9 = r8.r1;
        F.apm(r5.y, r5.x, r1, r0);
        F.apm(r6.y, r6.x, r9, r2);
        F.mul(r0, r2, r0);
        F.mul(r1, r9, r1);
        F.mul(r5.t, r6.t, r2);
        F.mul(r2, C_d2, r2);
        F.add(r5.z, r5.z, r9);
        F.mul(r9, r6.z, r9);
        F.apm(r1, r0, r1, r0);
        F.apm(r9, r2, r9, r2);
        F.mul(r0, r1, r7.t);
        F.mul(r2, r9, r7.z);
        F.mul(r0, r2, r7.x);
        F.mul(r1, r9, r7.y);
    }

    private static void pointAdd(PointPrecomp r6, PointAccum r7, PointTemp r8) {
        int[] r0 = r7.x;
        int[] r1 = r7.y;
        int[] r9 = r8.r0;
        int[] r2 = r7.u;
        int[] r3 = r7.v;
        F.apm(r7.y, r7.x, r1, r0);
        F.mul(r0, r6.ymx_h, r0);
        F.mul(r1, r6.ypx_h, r1);
        F.mul(r7.u, r7.v, r9);
        F.mul(r9, r6.xyd, r9);
        F.apm(r1, r0, r3, r2);
        F.apm(r7.z, r9, r1, r0);
        F.mul(r0, r1, r7.z);
        F.mul(r0, r2, r7.x);
        F.mul(r1, r3, r7.y);
    }

    private static void pointCopy(PointAccum r3, PointExtended r4) {
        F.copy(r3.x, 0, r4.x, 0);
        F.copy(r3.y, 0, r4.y, 0);
        F.copy(r3.z, 0, r4.z, 0);
        F.mul(r3.u, r3.v, r4.t);
    }

    private static void pointCopy(PointAffine r3, PointExtended r4) {
        F.copy(r3.x, 0, r4.x, 0);
        F.copy(r3.y, 0, r4.y, 0);
        F.one(r4.z);
        F.mul(r3.x, r3.y, r4.t);
    }

    private static void pointDouble(PointAccum r7) {
        int[] r0 = r7.x;
        int[] r1 = r7.y;
        int[] r2 = r7.z;
        int[] r3 = r7.u;
        int[] r4 = r7.v;
        F.add(r7.x, r7.y, r3);
        F.sqr(r7.x, r0);
        F.sqr(r7.y, r1);
        F.sqr(r7.z, r2);
        F.add(r2, r2, r2);
        F.apm(r0, r1, r4, r1);
        F.sqr(r3, r3);
        F.sub(r4, r3, r3);
        F.add(r2, r1, r0);
        F.carry(r0);
        F.mul(r0, r1, r7.z);
        F.mul(r0, r3, r7.x);
        F.mul(r1, r4, r7.y);
    }

    private static void pointLookup(int r6, int r7, PointPrecomp r8) {
        int r9 = ((r6 * 8) * 3) * 10;
        int r2 = 0;
    L3:
        if (r2 >= 8) goto L5;
        int r3 = ((r2 ^ r7) - 1) >> 31;
        F.cmov(r3, PRECOMP_BASE_COMB, r9, r8.ymx_h, 0);
        int r10 = r9 + 10;
        F.cmov(r3, PRECOMP_BASE_COMB, r10, r8.ypx_h, 0);
        int r11 = r10 + 10;
        F.cmov(r3, PRECOMP_BASE_COMB, r11, r8.xyd, 0);
        r9 = r11 + 10;
        r2 = r2 + 1;
        goto L3
    }

    private static void pointPrecompute(PointAffine r4, PointExtended[] r5, int r6, PointTemp r7) {
        AnonymousClass1 r1 = null;
        PointExtended r0 = new PointExtended(r1);
        r5[0] = r0;
        pointCopy(r4, r0);
        PointExtended r8 = new PointExtended(r1);
        pointAdd(r5[0], r5[0], r8, r7);
        int r2 = 1;
    L3:
        if (r2 >= r6) goto L5;
        PointExtended r3 = r5[r2 - 1];
        PointExtended r9 = new PointExtended(r1);
        r5[r2] = r9;
        pointAdd(r3, r8, r9, r7);
        r2 = r2 + 1;
        goto L3
    }

    private static void pointSetNeutral(PointAccum r1) {
        F.zero(r1.x);
        F.one(r1.y);
        F.one(r1.z);
        F.zero(r1.u);
        F.one(r1.v);
    }

    public static void precompute() {
        Object r1 = PRECOMP_LOCK;
        monitor-enter(r1);
    L44:
        th = move-exception;
        throw th;
    L5:
        if (PRECOMP_BASE_WNAF != null) goto L7;
    L10:
        int r0 = 32;
        PointExtended[] r3 = new PointExtended[96];     // Catch: Throwable -> L44
        AnonymousClass1 r5 = null;
        PointTemp r4 = new PointTemp(r5);     // Catch: Throwable -> L44
        PointAffine r6 = new PointAffine(r5);     // Catch: Throwable -> L44
        int[] r7 = B_x;     // Catch: Throwable -> L44
        int r9 = 0;
        F.copy(r7, 0, r6.x, 0);     // Catch: Throwable -> L44
        int[] r8 = B_y;     // Catch: Throwable -> L44
        F.copy(r8, 0, r6.y, 0);     // Catch: Throwable -> L44
        pointPrecompute(r6, r3, 32, r4);     // Catch: Throwable -> L44
        PointAccum r10 = new PointAccum(r5);     // Catch: Throwable -> L44
        F.copy(r7, 0, r10.x, 0);     // Catch: Throwable -> L44
        F.copy(r8, 0, r10.y, 0);     // Catch: Throwable -> L44
        F.one(r10.z);     // Catch: Throwable -> L44
        F.copy(r10.x, 0, r10.u, 0);     // Catch: Throwable -> L44
        F.copy(r10.y, 0, r10.v, 0);     // Catch: Throwable -> L44
        int r11 = 4;
        PointExtended[] r12 = new PointExtended[4];     // Catch: Throwable -> L44
        int r13 = 0;
    L11:
        if (r13 >= 4) goto L13;
        r12[r13] = new PointExtended(r5);     // Catch: Throwable -> L44
        r13 = r13 + 1;     // Catch: Throwable -> L44
        goto L11
    L13:
        PointExtended r14 = new PointExtended(r5);     // Catch: Throwable -> L44
        int r15 = 32;
        int r16 = 0;
    L15:
        if (r16 >= 8) goto L36;
        int r17 = r15 + 1;     // Catch: Throwable -> L44
        PointExtended r18 = new PointExtended(r5);     // Catch: Throwable -> L44
        r3[r15] = r18;     // Catch: Throwable -> L44
        int r19 = r9;
    L18:
        if (r19 >= r11) goto L28;
        if (r19 != 0) goto L21;
        pointCopy(r10, r18);     // Catch: Throwable -> L44
    L22:
        pointDouble(r10);     // Catch: Throwable -> L44
        pointCopy(r10, r12[r19]);     // Catch: Throwable -> L44
        if ((r16 + r19) == 10) goto L27;
        int r20 = 1;
    L25:
        if (r20 >= 8) goto L27;
        pointDouble(r10);     // Catch: Throwable -> L44
        r20 = r20 + 1;     // Catch: Throwable -> L44
    L27:
        r19 = r19 + 1;     // Catch: Throwable -> L44
        r11 = 4;
        goto L18
    L21:
        pointCopy(r10, r14);     // Catch: Throwable -> L44
        pointAdd(r18, r14, r18, r4);     // Catch: Throwable -> L44
        goto L22
    L28:
        F.negate(r18.x, r18.x);     // Catch: Throwable -> L44
        F.negate(r18.t, r18.t);     // Catch: Throwable -> L44
        r15 = r17;
        int r21 = 0;
    L30:
        if (r21 >= 3) goto L35;
        int r22 = 1 << r21;     // Catch: Throwable -> L44
        int r110 = 0;
    L32:
        if (r110 >= r22) goto L34;
        r3[r15] = new PointExtended(r5);     // Catch: Throwable -> L44
        pointAdd(r3[r15 - r22], r12[r21], r3[r15], r4);     // Catch: Throwable -> L44
        r110 = r110 + 1;     // Catch: Throwable -> L44
        r15 = r15 + 1;     // Catch: Throwable -> L44
        goto L32
    L34:
        r21 = r21 + 1;     // Catch: Throwable -> L44
        goto L30
    L35:
        r16 = r16 + 1;     // Catch: Throwable -> L44
        r11 = 4;
        r9 = 0;
        goto L15
    L36:
        invertDoubleZs(r3);     // Catch: Throwable -> L44
        PRECOMP_BASE_WNAF = new PointPrecomp[32];     // Catch: Throwable -> L44
        int r2 = 0;
    L37:
        if (r2 >= 32) goto L39;
        PointExtended r23 = r3[r2];     // Catch: Throwable -> L44
        PointPrecomp[] r24 = PRECOMP_BASE_WNAF;     // Catch: Throwable -> L44
        PointPrecomp r25 = new PointPrecomp(r5);     // Catch: Throwable -> L44
        r24[r2] = r25;     // Catch: Throwable -> L44
        F.mul(r23.x, r23.z, r23.x);     // Catch: Throwable -> L44
        F.mul(r23.y, r23.z, r23.y);     // Catch: Throwable -> L44
        F.apm(r23.y, r23.x, r25.ypx_h, r25.ymx_h);     // Catch: Throwable -> L44
        F.mul(r23.x, r23.y, r25.xyd);     // Catch: Throwable -> L44
        F.mul(r25.xyd, C_d4, r25.xyd);     // Catch: Throwable -> L44
        F.normalize(r25.ymx_h);     // Catch: Throwable -> L44
        F.normalize(r25.ypx_h);     // Catch: Throwable -> L44
        F.normalize(r25.xyd);     // Catch: Throwable -> L44
        r2 = r2 + 1;     // Catch: Throwable -> L44
        goto L37
    L39:
        PRECOMP_BASE_COMB = F.createTable(192);     // Catch: Throwable -> L44
        PointPrecomp r26 = new PointPrecomp(r5);     // Catch: Throwable -> L44
        int r27 = 0;
    L40:
        if (r0 >= 96) goto L42;
        PointExtended r28 = r3[r0];     // Catch: Throwable -> L44
        F.mul(r28.x, r28.z, r28.x);     // Catch: Throwable -> L44
        F.mul(r28.y, r28.z, r28.y);     // Catch: Throwable -> L44
        F.apm(r28.y, r28.x, r26.ypx_h, r26.ymx_h);     // Catch: Throwable -> L44
        F.mul(r28.x, r28.y, r26.xyd);     // Catch: Throwable -> L44
        F.mul(r26.xyd, C_d4, r26.xyd);     // Catch: Throwable -> L44
        F.normalize(r26.ymx_h);     // Catch: Throwable -> L44
        F.normalize(r26.ypx_h);     // Catch: Throwable -> L44
        F.normalize(r26.xyd);     // Catch: Throwable -> L44
        F.copy(r26.ymx_h, 0, PRECOMP_BASE_COMB, r27);     // Catch: Throwable -> L44
        int r29 = r27 + 10;     // Catch: Throwable -> L44
        F.copy(r26.ypx_h, 0, PRECOMP_BASE_COMB, r29);     // Catch: Throwable -> L44
        int r30 = r29 + 10;     // Catch: Throwable -> L44
        F.copy(r26.xyd, 0, PRECOMP_BASE_COMB, r30);     // Catch: Throwable -> L44
        r27 = r30 + 10;     // Catch: Throwable -> L44
        r0 = r0 + 1;     // Catch: Throwable -> L44
        goto L40
    L42:
        monitor-exit(r1);     // Catch: Throwable -> L44
        return;
    L7:
        if (PRECOMP_BASE_COMB == null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L44
    }

    private static void pruneScalar(byte[] r2, int r3, byte[] r4) {
        System.arraycopy(r2, r3, r4, 0, 32);
        r4[0] = (byte) (r4[0] & 248);
        r4[31] = (byte) (r4[31] & ByteCompanionObject.MAX_VALUE);
        r4[31] = (byte) (r4[31] | 64);
    }

    private static void scalarMultBase(byte[] r11, PointAccum r12) {
        precompute();
        int[] r1 = new int[8];
        decodeScalar(r11, 0, r1);
        Nat.cadd(8, (~r1[0]) & 1, r1, L, r1);
        Nat.shiftDownBit(8, r1, 1);
        int r13 = 0;
    L3:
        if (r13 >= 8) goto L5;
        r1[r13] = Interleave.shuffle2(r1[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        AnonymousClass1 r4 = null;
        PointPrecomp r14 = new PointPrecomp(r4);
        PointTemp r5 = new PointTemp(r4);
        pointSetNeutral(r12);
        int r6 = 28;
        int r7 = 0;
    L6:
        int r8 = 0;
    L7:
        if (r8 >= 8) goto L9;
        int r9 = r1[r8] >>> r6;
        int r10 = (r9 >>> 3) & 1;
        pointLookup(r8, (r9 ^ (-r10)) & 7, r14);
        int r15 = r7 ^ r10;
        F.cnegate(r15, r12.x);
        F.cnegate(r15, r12.u);
        pointAdd(r14, r12, r5);
        r8 = r8 + 1;
        r7 = r10;
        goto L7
    L9:
        r6 = r6 - 4;
        if (r6 < 0) goto L11;
        pointDouble(r12);
        goto L6
    L11:
        F.cnegate(r7, r12.x);
        F.cnegate(r7, r12.u);
    }

    private static void scalarMultBaseEncoded(byte[] r2, byte[] r3, int r4) {
        PointAccum r0 = new PointAccum(null);
        scalarMultBase(r2, r0);
        if (encodePoint(r0, r3, r4) == 0) goto L6;
        return;
    L6:
        throw new IllegalStateException();
    }

    public static void scalarMultBaseYZ(X25519.Friend r1, byte[] r2, int r3, int[] r4, int[] r5) {
        Objects.requireNonNull(r1, "This method is only for use by X25519");
        byte[] r6 = new byte[32];
        pruneScalar(r2, r3, r6);
        PointAccum r7 = new PointAccum(null);
        scalarMultBase(r6, r7);
        if (checkPoint(r7.x, r7.y, r7.z) == 0) goto L7;
        F.copy(r7.y, 0, r4, 0);
        F.copy(r7.z, 0, r5, 0);
        return;
    L7:
        throw new IllegalStateException();
    }
}
