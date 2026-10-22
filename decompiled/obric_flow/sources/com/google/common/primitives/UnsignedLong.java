package com.google.common.primitives;

import com.google.common.base.b0;
import java.io.Serializable;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {
    public static final UnsignedLong MAX_VALUE = null;
    public static final UnsignedLong ONE = null;
    public static final UnsignedLong ZERO = null;
    private final long value;

    static {
        ZERO = new UnsignedLong(0);
        ONE = new UnsignedLong(1);
        MAX_VALUE = new UnsignedLong(-1);
    }

    public UnsignedLong(long r5) {
        this.value = r5;
    }

    public static UnsignedLong fromLongBits(long r5) {
        return new UnsignedLong(r5);
    }

    public static UnsignedLong valueOf(long r5) {
        if (r5 < 0) goto L5;
        boolean r10 = true;
    L6:
        b0.f("value (%s) is outside the range for an unsigned long value", r5, r10);
        return fromLongBits(r5);
    L5:
        r10 = false;
        goto L6
    }

    public BigInteger bigIntegerValue() {
        BigInteger r5 = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        if (this.value < 0) goto L5;
        return r5;
    L5:
        return r5.setBit(63);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UnsignedLong r5) {
        return compareTo2(r5);
    }

    public UnsignedLong dividedBy(UnsignedLong r5) {
        long r10 = this.value;
        r5.getClass();
        return fromLongBits(f8.b.m(r10, r5.value));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long r5 = this.value;
        if (r5 < 0) goto L7;
        return r5;
    L7:
        return ((r5 & 1) | (r5 >>> 1)) * 2.0d;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof UnsignedLong) == true) goto L5;
        return false;
    L5:
        if (this.value != ((UnsignedLong) r5).value) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long r5 = this.value;
        if (r5 < 0) goto L7;
        return r5;
    L7:
        return ((r5 & 1) | (r5 >>> 1)) * 2.0f;
    }

    public int hashCode() {
        long r5 = this.value;
        return (int) (r5 ^ (r5 >>> 32));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public UnsignedLong minus(UnsignedLong r5) {
        long r10 = this.value;
        r5.getClass();
        return fromLongBits(r10 - r5.value);
    }

    public UnsignedLong mod(UnsignedLong r5) {
        long r10 = this.value;
        r5.getClass();
        return fromLongBits(f8.b.o(r10, r5.value));
    }

    public UnsignedLong plus(UnsignedLong r5) {
        long r10 = this.value;
        r5.getClass();
        return fromLongBits(r10 + r5.value);
    }

    public UnsignedLong times(UnsignedLong r5) {
        long r10 = this.value;
        r5.getClass();
        return fromLongBits(r10 * r5.value);
    }

    public String toString() {
        return f8.b.p(this.value, 10);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UnsignedLong r5) {
        r5.getClass();
        return f8.b.l(this.value, r5.value);
    }

    public static UnsignedLong valueOf(String r5) {
        return valueOf(r5, 10);
    }

    public String toString(int r5) {
        return f8.b.p(this.value, r5);
    }

    public static UnsignedLong valueOf(String r10, int r11) {
        r10.getClass();
        if (r10.length() == 0) goto L37;
        if (r11 < 2) goto L35;
        if (r11 > 36) goto L35;
        int r5 = j.f9344c[r11] - 1;
        int r12 = 0;
        long r13 = 0;
    L10:
        if (r12 >= r10.length()) goto L33;
        int r14 = Character.digit(r10.charAt(r12), r11);
        if (r14 == (-1)) goto L31;
        if (r12 <= r5) goto L29;
        if (r13 < 0) goto L24;
        long r15 = j.f9342a[r11];
        if (r13 < r15) goto L29;
        if (r13 > r15) goto L24;
        if (r14 <= j.f9343b[r11]) goto L29;
    L24:
        if (r10.length() == 0) goto L26;
        String r16 = "Too large for unsigned long: ".concat(r10);
    L28:
        throw new NumberFormatException(r16);
    L26:
        r16 = new String("Too large for unsigned long: ");
    L29:
        r13 = (r13 * ((long) r11)) + ((long) r14);
        r12 = r12 + 1;
        goto L10
    L31:
        throw new NumberFormatException(r10);
    L33:
        return fromLongBits(r13);
    L35:
        throw new NumberFormatException(androidx.constraintlayout.motion.widget.a.i(26, "illegal radix: ", r11));
    L37:
        throw new NumberFormatException("empty string");
    }

    public static UnsignedLong valueOf(BigInteger r5) {
        r5.getClass();
        if (r5.signum() >= 0) goto L5;
    L7:
        boolean r10 = false;
    L8:
        b0.h("value (%s) is outside the range for an unsigned long value", r10, r5);
        return fromLongBits(r5.longValue());
    L5:
        if (r5.bitLength() > 64) goto L7;
        r10 = true;
        goto L8
    }
}
