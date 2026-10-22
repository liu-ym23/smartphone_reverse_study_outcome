package com.google.common.primitives;

import com.google.common.base.b0;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {
    public static final UnsignedInteger MAX_VALUE = null;
    public static final UnsignedInteger ONE = null;
    public static final UnsignedInteger ZERO = null;
    private final int value;

    static {
        ZERO = fromIntBits(0);
        ONE = fromIntBits(1);
        MAX_VALUE = fromIntBits(-1);
    }

    public UnsignedInteger(int r5) {
        this.value = r5;
    }

    public static UnsignedInteger fromIntBits(int r5) {
        return new UnsignedInteger(r5);
    }

    public static UnsignedInteger valueOf(long r5) {
        if ((4294967295L & r5) != r5) goto L5;
        boolean r10 = true;
    L6:
        b0.f("value (%s) is outside the range for an unsigned integer value", r5, r10);
        return fromIntBits((int) r5);
    L5:
        r10 = false;
        goto L6
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(longValue());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UnsignedInteger r5) {
        return compareTo2(r5);
    }

    public UnsignedInteger dividedBy(UnsignedInteger r5) {
        int r10 = this.value;
        r5.getClass();
        return fromIntBits((int) ((((long) r10) & 4294967295L) / (((long) r5.value) & 4294967295L)));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return longValue();
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof UnsignedInteger) == true) goto L5;
        return false;
    L5:
        if (this.value != ((UnsignedInteger) r5).value) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return longValue();
    }

    public int hashCode() {
        return this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return ((long) this.value) & 4294967295L;
    }

    public UnsignedInteger minus(UnsignedInteger r5) {
        int r10 = this.value;
        r5.getClass();
        return fromIntBits(r10 - r5.value);
    }

    public UnsignedInteger mod(UnsignedInteger r5) {
        int r10 = this.value;
        r5.getClass();
        return fromIntBits((int) ((((long) r10) & 4294967295L) % (((long) r5.value) & 4294967295L)));
    }

    public UnsignedInteger plus(UnsignedInteger r5) {
        int r10 = this.value;
        r5.getClass();
        return fromIntBits(r10 + r5.value);
    }

    public UnsignedInteger times(UnsignedInteger r5) {
        int r10 = this.value;
        r5.getClass();
        return fromIntBits(r10 * r5.value);
    }

    public String toString() {
        return toString(10);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UnsignedInteger r5) {
        r5.getClass();
        int r10 = this.value;
        int r11 = r10 ^ Integer.MIN_VALUE;
        int r12 = r5.value ^ Integer.MIN_VALUE;
        if (r11 >= r12) goto L5;
        return -1;
    L5:
        if (r11 <= r12) goto L7;
        return 1;
    L7:
        return 0;
    }

    public String toString(int r5) {
        return Long.toString(((long) this.value) & 4294967295L, r5);
    }

    public static UnsignedInteger valueOf(String r5) {
        return valueOf(r5, 10);
    }

    public static UnsignedInteger valueOf(String r5, int r10) {
        r5.getClass();
        long r11 = Long.parseLong(r5, r10);
        if ((4294967295L & r11) == r11) goto L5;
        StringBuilder r12 = new StringBuilder(r5.length() + 69);
        r12.append("Input ");
        r12.append(r5);
        r12.append(" in base ");
        r12.append(r10);
        r12.append(" is not in the range of an unsigned integer");
        throw new NumberFormatException(r12.toString());
    L5:
        return fromIntBits((int) r11);
    }

    public static UnsignedInteger valueOf(BigInteger r5) {
        r5.getClass();
        if (r5.signum() >= 0) goto L5;
    L7:
        boolean r10 = false;
    L8:
        b0.h("value (%s) is outside the range for an unsigned integer value", r10, r5);
        return fromIntBits(r5.intValue());
    L5:
        if (r5.bitLength() > 32) goto L7;
        r10 = true;
        goto L8
    }
}
