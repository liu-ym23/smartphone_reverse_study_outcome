package com.google.common.primitives;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class UnsignedLongs {

    static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<long[]> {
        private static final /* synthetic */ LexicographicalComparator[] $VALUES = null;
        public static final LexicographicalComparator INSTANCE = null;

        private static /* synthetic */ LexicographicalComparator[] $values() {
            return new LexicographicalComparator[]{INSTANCE};
        }

        static {
            INSTANCE = new LexicographicalComparator("INSTANCE", 0);
            $VALUES = $values();
        }

        private LexicographicalComparator(String r1, int r2) {
            super(r1, r2);
        }

        public static LexicographicalComparator valueOf(String r2) {
            return (LexicographicalComparator) ZeusTransformUtils.preCheckCast(Enum.valueOf(LexicographicalComparator.class, r2), LexicographicalComparator.class, "com.obric.memorydata.plugin");
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LexicographicalComparator[].class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(long[] r3, long[] r4) {
            return compare2((long[]) ZeusTransformUtils.preCheckCast(r3, long[].class, "com.obric.memorydata.plugin"), (long[]) ZeusTransformUtils.preCheckCast(r4, long[].class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(long[] r6, long[] r7) {
            int r5 = Math.min(r6.length, r7.length);
            int r0 = 0;
        L3:
            if (r0 >= r5) goto L10;
            if (r6[r0] != r7[r0]) goto L7;
            r0 = r0 + 1;
            goto L3
        L7:
            return UnsignedLongs.a(r6[r0], r7[r0]);
        L10:
            return r6.length - r7.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final long[] f4765a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int[] f4766b = null;
        static final int[] c = null;

        static {
            f4765a = new long[37];
            f4766b = new int[37];
            c = new int[37];
            BigInteger r0 = new BigInteger("10000000000000000", 16);
            int r1 = 2;
        L4:
            if (r1 > 36) goto L6;
            long r3 = r1;
            f4765a[r1] = UnsignedLongs.b(-1, r3);
            f4766b[r1] = (int) UnsignedLongs.c(-1, r3);
            c[r1] = r0.toString(r1).length() - 1;
            r1 = r1 + 1;
            goto L4
        }

        static boolean a(long r6, int r8, int r9) {
            if (r6 < 0) goto L15;
            long[] r0 = f4765a;
            if (r6 >= r0[r9]) goto L8;
            return false;
        L8:
            if (r6 <= r0[r9]) goto L11;
            return true;
        L11:
            if (r8 <= f4766b[r9]) goto L14;
            return true;
        L14:
            return false;
        L15:
            return true;
        }
    }

    public static int a(long r0, long r2) {
        return Longs.a(b(r0), b(r2));
    }

    public static long a(String r7, int r8) {
        n.a(r7);
        if (r7.length() == 0) goto L26;
        if (r8 < 2) goto L24;
        if (r8 > 36) goto L24;
        int r0 = a.c[r8] - 1;
        long r1 = 0;
        int r3 = 0;
    L10:
        if (r3 >= r7.length()) goto L22;
        int r4 = Character.digit(r7.charAt(r3), r8);
        if (r4 == (-1)) goto L21;
        if (r3 <= r0) goto L19;
        if (a.a(r1, r4, r8) == false) goto L19;
        throw new NumberFormatException("Too large for unsigned long: " + r7);
    L19:
        r1 = (r1 * ((long) r8)) + ((long) r4);
        r3 = r3 + 1;
        goto L10
    L21:
        throw new NumberFormatException(r7);
    L22:
        return r1;
    L24:
        throw new NumberFormatException("illegal radix: " + r8);
    L26:
        throw new NumberFormatException("empty string");
    }

    public static String a(long r1) {
        return a(r1, 10);
    }

    public static String a(long r11, int r13) {
        if (r13 >= 2) goto L5;
    L7:
        boolean r1 = false;
    L8:
        n.a(r1, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", r13);
        if (r11 != 0) goto L12;
        return "0";
    L12:
        if (r11 > 0) goto L14;
        int r3 = 64;
        char[] r4 = new char[64];
        int r5 = r13 - 1;
        if ((r13 & r5) != 0) goto L22;
        int r6 = Integer.numberOfTrailingZeros(r13);
    L18:
        r3 = r3 - 1;
        r4[r3] = Character.forDigit(((int) r11) & r5, r13);
        r11 = r11 >>> r6;
        if (r11 != 0) goto L18;
    L30:
        return new String(r4, r3, 64 - r3);
    L22:
        if ((r13 & 1) != 0) goto L24;
        long r7 = (r11 >>> 1) / ((long) (r13 >>> 1));
    L25:
        long r8 = r13;
        r4[63] = Character.forDigit((int) (r11 - (r7 * r8)), r13);
        r3 = 63;
    L27:
        if (r7 <= 0) goto L30;
        r3 = r3 - 1;
        r4[r3] = Character.forDigit((int) (r7 % r8), r13);
        r7 = r7 / r8;
        goto L27
    L24:
        r7 = b(r11, r13);
        goto L25
    L14:
        return Long.toString(r11, r13);
    L5:
        if (r13 > 36) goto L7;
        r1 = true;
        goto L8
    }

    private static long b(long r2) {
        return r2 ^ Long.MIN_VALUE;
    }

    public static long b(long r5, long r7) {
        if (r7 >= 0) goto L10;
        if (a(r5, r7) >= 0) goto L7;
        return 0;
    L7:
        return 1;
    L10:
        if (r5 >= 0) goto L12;
        int r0 = 1;
        long r1 = ((r5 >>> 1) / r7) << 1;
        if (a(r5 - (r1 * r7), r7) >= 0) goto L18;
        r0 = 0;
    L18:
        return r1 + ((long) r0);
    L12:
        return r5 / r7;
    }

    public static long c(long r5, long r7) {
        if (r7 >= 0) goto L10;
        if (a(r5, r7) >= 0) goto L8;
        return r5;
    L8:
        return r5 - r7;
    L10:
        if (r5 >= 0) goto L12;
        long r6 = r5 - ((((r5 >>> 1) / r7) << 1) * r7);
        if (a(r6, r7) >= 0) goto L18;
        r7 = 0;
    L18:
        return r6 - r7;
    L12:
        return r5 % r7;
    }
}
