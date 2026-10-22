package com.google.common.primitives;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    private UnsignedInteger(int r1) {
        this.value = r1 & (-1);
    }

    public static UnsignedInteger fromIntBits(int r1) {
        return new UnsignedInteger(r1);
    }

    public static UnsignedInteger valueOf(long r2) {
        if ((4294967295L & r2) != r2) goto L5;
        boolean r0 = true;
    L6:
        n.a(r0, "value (%s) is outside the range for an unsigned integer value", r2);
        return fromIntBits((int) r2);
    L5:
        r0 = false;
        goto L6
    }

    public static UnsignedInteger valueOf(String r1) {
        return valueOf(r1, 10);
    }

    public static UnsignedInteger valueOf(String r0, int r1) {
        return fromIntBits(UnsignedInts.a(r0, r1));
    }

    public static UnsignedInteger valueOf(BigInteger r2) {
        n.a(r2);
        if (r2.signum() >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        n.a(r0, "value (%s) is outside the range for an unsigned integer value", r2);
        return fromIntBits(r2.intValue());
    L5:
        if (r2.bitLength() > 32) goto L7;
        r0 = true;
        goto L8
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(longValue());
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UnsignedInteger r1) {
        n.a(r1);
        return UnsignedInts.a(this.value, r1.value);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(UnsignedInteger r3) {
        return compareTo2((UnsignedInteger) ZeusTransformUtils.preCheckCast(r3, UnsignedInteger.class, "com.obric.memorydata.plugin"));
    }

    public UnsignedInteger dividedBy(UnsignedInteger r3) {
        return fromIntBits(UnsignedInts.b(this.value, ((UnsignedInteger) ZeusTransformUtils.preCheckCast(n.a(r3), UnsignedInteger.class, "com.obric.memorydata.plugin")).value));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return longValue();
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, UnsignedInteger.class) == false) goto L8;
        UnsignedInteger r5 = (UnsignedInteger) ZeusTransformUtils.preCheckCast(r4, UnsignedInteger.class, "com.obric.memorydata.plugin");
        if (this.value != r5.value) goto L9;
        return true;
    L9:
        return false;
    L8:
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
        return UnsignedInts.b(this.value);
    }

    public UnsignedInteger minus(UnsignedInteger r3) {
        return fromIntBits(this.value - ((UnsignedInteger) ZeusTransformUtils.preCheckCast(n.a(r3), UnsignedInteger.class, "com.obric.memorydata.plugin")).value);
    }

    public UnsignedInteger mod(UnsignedInteger r3) {
        return fromIntBits(UnsignedInts.c(this.value, ((UnsignedInteger) ZeusTransformUtils.preCheckCast(n.a(r3), UnsignedInteger.class, "com.obric.memorydata.plugin")).value));
    }

    public UnsignedInteger plus(UnsignedInteger r3) {
        return fromIntBits(this.value + ((UnsignedInteger) ZeusTransformUtils.preCheckCast(n.a(r3), UnsignedInteger.class, "com.obric.memorydata.plugin")).value);
    }

    public UnsignedInteger times(UnsignedInteger r3) {
        return fromIntBits(this.value * ((UnsignedInteger) ZeusTransformUtils.preCheckCast(n.a(r3), UnsignedInteger.class, "com.obric.memorydata.plugin")).value);
    }

    public String toString() {
        return toString(10);
    }

    public String toString(int r1) {
        return UnsignedInts.d(this.value, r1);
    }
}
