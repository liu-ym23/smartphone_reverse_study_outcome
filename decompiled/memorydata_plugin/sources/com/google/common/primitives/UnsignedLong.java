package com.google.common.primitives;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class UnsignedLong extends Number implements Serializable, Comparable<UnsignedLong> {
    public static final UnsignedLong MAX_VALUE = null;
    public static final UnsignedLong ONE = null;
    private static final long UNSIGNED_MASK = Long.MAX_VALUE;
    public static final UnsignedLong ZERO = null;
    private final long value;

    static {
        ZERO = new UnsignedLong(0);
        ONE = new UnsignedLong(1);
        MAX_VALUE = new UnsignedLong(-1);
    }

    private UnsignedLong(long r1) {
        this.value = r1;
    }

    public static UnsignedLong fromLongBits(long r1) {
        return new UnsignedLong(r1);
    }

    public static UnsignedLong valueOf(long r2) {
        if (r2 < 0) goto L5;
        boolean r0 = true;
    L6:
        n.a(r0, "value (%s) is outside the range for an unsigned long value", r2);
        return fromLongBits(r2);
    L5:
        r0 = false;
        goto L6
    }

    public static UnsignedLong valueOf(String r1) {
        return valueOf(r1, 10);
    }

    public static UnsignedLong valueOf(String r0, int r1) {
        return fromLongBits(UnsignedLongs.a(r0, r1));
    }

    public static UnsignedLong valueOf(BigInteger r2) {
        n.a(r2);
        if (r2.signum() >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        n.a(r0, "value (%s) is outside the range for an unsigned long value", r2);
        return fromLongBits(r2.longValue());
    L5:
        if (r2.bitLength() > 64) goto L7;
        r0 = true;
        goto L8
    }

    public BigInteger bigIntegerValue() {
        BigInteger r0 = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        if (this.value < 0) goto L5;
        return r0;
    L5:
        return r0.setBit(63);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UnsignedLong r3) {
        n.a(r3);
        return UnsignedLongs.a(this.value, r3.value);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(UnsignedLong r3) {
        return compareTo2((UnsignedLong) ZeusTransformUtils.preCheckCast(r3, UnsignedLong.class, "com.obric.memorydata.plugin"));
    }

    public UnsignedLong dividedBy(UnsignedLong r4) {
        return fromLongBits(UnsignedLongs.b(this.value, ((UnsignedLong) ZeusTransformUtils.preCheckCast(n.a(r4), UnsignedLong.class, "com.obric.memorydata.plugin")).value));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long r0 = this.value;
        if (r0 < 0) goto L7;
        return r0;
    L7:
        return ((r0 & 1) | (r0 >>> 1)) * 2.0d;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, UnsignedLong.class) == false) goto L8;
        UnsignedLong r5 = (UnsignedLong) ZeusTransformUtils.preCheckCast(r4, UnsignedLong.class, "com.obric.memorydata.plugin");
        if (this.value != r5.value) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long r0 = this.value;
        if (r0 < 0) goto L7;
        return r0;
    L7:
        return ((r0 & 1) | (r0 >>> 1)) * 2.0f;
    }

    public int hashCode() {
        return Longs.a(this.value);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public UnsignedLong minus(UnsignedLong r4) {
        return fromLongBits(this.value - ((UnsignedLong) ZeusTransformUtils.preCheckCast(n.a(r4), UnsignedLong.class, "com.obric.memorydata.plugin")).value);
    }

    public UnsignedLong mod(UnsignedLong r4) {
        return fromLongBits(UnsignedLongs.c(this.value, ((UnsignedLong) ZeusTransformUtils.preCheckCast(n.a(r4), UnsignedLong.class, "com.obric.memorydata.plugin")).value));
    }

    public UnsignedLong plus(UnsignedLong r4) {
        return fromLongBits(this.value + ((UnsignedLong) ZeusTransformUtils.preCheckCast(n.a(r4), UnsignedLong.class, "com.obric.memorydata.plugin")).value);
    }

    public UnsignedLong times(UnsignedLong r4) {
        return fromLongBits(this.value * ((UnsignedLong) ZeusTransformUtils.preCheckCast(n.a(r4), UnsignedLong.class, "com.obric.memorydata.plugin")).value);
    }

    public String toString() {
        return UnsignedLongs.a(this.value);
    }

    public String toString(int r3) {
        return UnsignedLongs.a(this.value, r3);
    }
}
