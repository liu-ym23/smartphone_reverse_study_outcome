package org.apache.commons.compress.archivers.zip;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class ZipEightByteInteger implements Serializable {
    private static final int BYTE_1 = 1;
    private static final int BYTE_1_MASK = 65280;
    private static final int BYTE_1_SHIFT = 8;
    private static final int BYTE_2 = 2;
    private static final int BYTE_2_MASK = 16711680;
    private static final int BYTE_2_SHIFT = 16;
    private static final int BYTE_3 = 3;
    private static final long BYTE_3_MASK = 4278190080L;
    private static final int BYTE_3_SHIFT = 24;
    private static final int BYTE_4 = 4;
    private static final long BYTE_4_MASK = 1095216660480L;
    private static final int BYTE_4_SHIFT = 32;
    private static final int BYTE_5 = 5;
    private static final long BYTE_5_MASK = 280375465082880L;
    private static final int BYTE_5_SHIFT = 40;
    private static final int BYTE_6 = 6;
    private static final long BYTE_6_MASK = 71776119061217280L;
    private static final int BYTE_6_SHIFT = 48;
    private static final int BYTE_7 = 7;
    private static final long BYTE_7_MASK = 9151314442816847872L;
    private static final int BYTE_7_SHIFT = 56;
    private static final byte LEFTMOST_BIT = -128;
    private static final int LEFTMOST_BIT_SHIFT = 63;
    public static final ZipEightByteInteger ZERO = null;
    private static final long serialVersionUID = 1;
    private final BigInteger value;

    static {
        ZERO = new ZipEightByteInteger(0);
    }

    public ZipEightByteInteger(long r1) {
        this(BigInteger.valueOf(r1));
    }

    public ZipEightByteInteger(BigInteger r1) {
        this.value = r1;
    }

    public ZipEightByteInteger(byte[] r2) {
        this(r2, 0);
    }

    public ZipEightByteInteger(byte[] r1, int r2) {
        this.value = getValue(r1, r2);
    }

    public static byte[] getBytes(long r0) {
        return getBytes(BigInteger.valueOf(r0));
    }

    public static byte[] getBytes(BigInteger r6) {
        long r2 = r6.longValue();
        byte[] r1 = {(byte) (255 & r2), (byte) ((65280 & r2) >> 8), (byte) ((16711680 & r2) >> 16), (byte) ((BYTE_3_MASK & r2) >> 24), (byte) ((BYTE_4_MASK & r2) >> 32), (byte) ((BYTE_5_MASK & r2) >> 40), (byte) ((BYTE_6_MASK & r2) >> 48), (byte) ((r2 & BYTE_7_MASK) >> 56)};
        if (r6.testBit(63) == false) goto L5;
        r1[7] = (byte) (r1[7] | (-128));
    L5:
        return r1;
    }

    public static long getLongValue(byte[] r2) {
        return getLongValue(r2, 0);
    }

    public static long getLongValue(byte[] r0, int r1) {
        return getValue(r0, r1).longValue();
    }

    public static BigInteger getValue(byte[] r1) {
        return getValue(r1, 0);
    }

    public static BigInteger getValue(byte[] r7, int r8) {
        int r0 = r8 + 7;
        BigInteger r9 = BigInteger.valueOf(((((((((((long) r7[r0]) << 56) & BYTE_7_MASK) + ((((long) r7[r8 + 6]) << 48) & BYTE_6_MASK)) + ((((long) r7[r8 + 5]) << 40) & BYTE_5_MASK)) + ((((long) r7[r8 + 4]) << 32) & BYTE_4_MASK)) + ((((long) r7[r8 + 3]) << 24) & BYTE_3_MASK)) + ((((long) r7[r8 + 2]) << 16) & 16711680)) + ((((long) r7[r8 + 1]) << 8) & 65280)) + (((long) r7[r8]) & 255));
        if ((r7[r0] & (-128)) == (-128)) goto L5;
        return r9;
    L5:
        return r9.setBit(63);
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, ZipEightByteInteger.class) == true) goto L7;
        return false;
    L7:
        return this.value.equals(((ZipEightByteInteger) ZeusTransformUtils.preCheckCast(r3, ZipEightByteInteger.class, "com.obric.memorydata.plugin")).getValue());
    }

    public byte[] getBytes() {
        return getBytes(this.value);
    }

    public long getLongValue() {
        return this.value.longValue();
    }

    public BigInteger getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "ZipEightByteInteger value: " + this.value;
    }
}
