package com.google.common.hash;

import java.io.Serializable;
import java.nio.charset.Charset;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
final class Murmur3_32HashFunction extends b implements Serializable {
    static final k GOOD_FAST_HASH_32 = null;
    static final k MURMUR3_32 = null;
    static final k MURMUR3_32_FIXED = null;
    private static final long serialVersionUID = 0;
    private final int seed;
    private final boolean supplementaryPlaneFix;

    static {
        MURMUR3_32 = new Murmur3_32HashFunction(0, false);
        MURMUR3_32_FIXED = new Murmur3_32HashFunction(0, true);
        GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(n.f9292a, true);
    }

    public Murmur3_32HashFunction(int r5, boolean r10) {
        this.seed = r5;
        this.supplementaryPlaneFix = r10;
    }

    public static long a(char r5) {
        return ((((long) (r5 >>> '\f')) | 224) | ((long) ((((r5 >>> 6) & 63) | 128) << 8))) | ((long) (((r5 & '?') | 128) << 16));
    }

    public static /* synthetic */ int access$000(int r5) {
        return f(r5);
    }

    public static /* synthetic */ int access$100(int r5, int r10) {
        return e(r5, r10);
    }

    public static /* synthetic */ int access$200(byte[] r5, int r10) {
        return d(r10, r5);
    }

    public static long access$300(char r5) {
        return (((long) (r5 >>> 6)) | 192) | ((long) (((r5 & '?') | 128) << 8));
    }

    public static /* synthetic */ long access$400(char r5) {
        return a(r5);
    }

    public static /* synthetic */ long access$500(int r5) {
        return b(r5);
    }

    public static /* synthetic */ j access$600(int r5, int r10) {
        return c(r5, r10);
    }

    public static long b(int r10) {
        return (((((long) (r10 >>> 18)) | 240) | ((((long) ((r10 >>> 12) & 63)) | 128) << 8)) | ((((long) ((r10 >>> 6) & 63)) | 128) << 16)) | ((((long) (r10 & 63)) | 128) << 24);
    }

    public static j c(int r5, int r10) {
        int r11 = r5 ^ r10;
        int r12 = (r11 ^ (r11 >>> 16)) * (-2048144789);
        int r13 = (r12 ^ (r12 >>> 13)) * (-1028477387);
        return j.fromInt(r13 ^ (r13 >>> 16));
    }

    public static int d(int r5, byte[] r10) {
        byte r11 = r10[r5 + 3];
        byte r12 = r10[r5 + 2];
        byte r13 = r10[r5 + 1];
        byte r14 = r10[r5];
        int r15 = ((r11 << 24) | ((r12 & UByte.MAX_VALUE) << 16)) | ((r13 & UByte.MAX_VALUE) << 8);
        return (r14 & UByte.MAX_VALUE) | r15;
    }

    public static int e(int r5, int r10) {
        return (Integer.rotateLeft(r5 ^ r10, 13) * 5) - 430675100;
    }

    public static int f(int r5) {
        return Integer.rotateLeft(r5 * (-862048943), 15) * 461845907;
    }

    public int bits() {
        return 32;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof Murmur3_32HashFunction) == false) goto L10;
        Murmur3_32HashFunction r10 = (Murmur3_32HashFunction) r5;
        if (this.seed == r10.seed) goto L7;
        return false;
    L7:
        if (this.supplementaryPlaneFix != r10.supplementaryPlaneFix) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.google.common.hash.b
    public j hashBytes(byte[] r5, int r10, int r11) {
        com.google.common.base.b0.p(r10, r10 + r11, r5.length);
        int r12 = this.seed;
        int r13 = 0;
        int r14 = 0;
    L3:
        int r15 = r14 + 4;
        if (r15 > r11) goto L6;
        r12 = e(r12, f(d(r14 + r10, r5)));
        r14 = r15;
        goto L3
    L6:
        int r16 = r14;
        int r17 = 0;
    L7:
        if (r16 >= r11) goto L10;
        r13 = r13 ^ ((r5[r10 + r16] & UByte.MAX_VALUE) << r17);
        r16 = r16 + 1;
        r17 = r17 + 8;
        goto L7
    L10:
        return c(r12 ^ f(r13), r11);
    }

    public int hashCode() {
        int r5 = Murmur3_32HashFunction.class.hashCode();
        return this.seed ^ r5;
    }

    @Override // com.google.common.hash.b
    public j hashInt(int r5) {
        int r10 = f(r5);
        return c(e(this.seed, r10), 4);
    }

    @Override // com.google.common.hash.b
    public j hashLong(long r5) {
        int r10 = (int) r5;
        int r11 = f(r10);
        return c(e(e(this.seed, r11), f((int) (r5 >>> 32))), 8);
    }

    @Override // com.google.common.hash.b
    public j hashString(CharSequence r14, Charset r15) {
        if (com.google.common.base.h.f8658a.equals(r15) == false) goto L42;
        int r5 = r14.length();
        int r10 = this.seed;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L5:
        int r16 = r12 + 4;
        if (r16 > r5) goto L13;
        char r17 = r14.charAt(r12);
        char r18 = r14.charAt(r12 + 1);
        char r19 = r14.charAt(r12 + 2);
        char r110 = r14.charAt(r12 + 3);
        if (r17 >= 128) goto L13;
        if (r18 >= 128) goto L13;
        if (r19 >= 128) goto L13;
        if (r110 >= 128) goto L13;
        r10 = e(r10, f((((r18 << '\b') | r17) | (r19 << 16)) | (r110 << 24)));
        r13 = r13 + 4;
        r12 = r16;
    L13:
        long r20 = 0;
    L14:
        if (r12 >= r5) goto L40;
        char r21 = r14.charAt(r12);
        if (r21 >= 128) goto L19;
        r20 = r20 | (((long) r21) << r11);
        r11 = r11 + 8;
        r13 = r13 + 1;
    L36:
        if (r11 < 32) goto L38;
        r10 = e(r10, f((int) r20));
        r20 = r20 >>> 32;
        r11 = r11 - 32;
    L38:
        r12 = r12 + 1;
        goto L14
    L19:
        if (r21 >= 2048) goto L22;
        r20 = r20 | (((((long) (r21 >>> 6)) | 192) | ((long) (((r21 & '?') | 128) << 8))) << r11);
        r11 = r11 + 16;
        r13 = r13 + 2;
        goto L36
    L22:
        if (r21 >= 55296) goto L24;
    L34:
        r20 = r20 | (a(r21) << r11);
        r11 = r11 + 24;
        r13 = r13 + 3;
        goto L36
    L24:
        if (r21 > 57343) goto L34;
        int r22 = Character.codePointAt(r14, r12);
        if (r22 == r21) goto L29;
        r12 = r12 + 1;
        r20 = r20 | (b(r22) << r11);
        if (this.supplementaryPlaneFix == false) goto L33;
        r11 = r11 + 32;
    L33:
        r13 = r13 + 4;
        goto L36
    L29:
        return hashBytes(r14.toString().getBytes(r15));
    L40:
        return c(f((int) r20) ^ r10, r13);
    L42:
        return hashBytes(r14.toString().getBytes(r15));
    }

    @Override // com.google.common.hash.b
    public j hashUnencodedChars(CharSequence r5) {
        int r10 = this.seed;
        int r11 = 1;
    L4:
        if (r11 >= r5.length()) goto L7;
        r10 = e(r10, f(r5.charAt(r11 - 1) | (r5.charAt(r11) << 16)));
        r11 = r11 + 2;
        goto L4
    L7:
        if ((r5.length() & 1) != 1) goto L10;
        r10 = r10 ^ f(r5.charAt(r5.length() - 1));
    L10:
        return c(r10, r5.length() * 2);
    }

    @Override // com.google.common.hash.k
    public l newHasher() {
        int r5 = this.seed;
        y r10 = new y();
        r10.f9296a = r5;
        r10.d = 0;
        r10.e = false;
        return r10;
    }

    public String toString() {
        int r5 = this.seed;
        StringBuilder r10 = new StringBuilder(31);
        r10.append("Hashing.murmur3_32(");
        r10.append(r5);
        r10.append(")");
        return r10.toString();
    }
}
