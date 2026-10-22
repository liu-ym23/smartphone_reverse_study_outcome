package org.bouncycastle.util;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Map;
import java.util.WeakHashMap;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;

/* JADX INFO: loaded from: classes7.dex */
public final class BigIntegers {
    private static final int MAX_SMALL = 0;
    public static final BigInteger ONE = null;
    private static final BigInteger SMALL_PRIMES_PRODUCT = null;
    private static final BigInteger THREE = null;
    public static final BigInteger TWO = null;
    public static final BigInteger ZERO = null;

    public static class Cache {
        private final BigInteger[] preserve;
        private int preserveCounter;
        private final Map<BigInteger, Boolean> values;

        public Cache() {
            this.values = new WeakHashMap();
            this.preserve = new BigInteger[8];
            this.preserveCounter = 0;
        }

        public synchronized void add(BigInteger r3) {
            monitor-enter(this);
            this.values.put(r3, Boolean.TRUE);     // Catch: Throwable -> L6
            BigInteger[] r0 = this.preserve;     // Catch: Throwable -> L6
            int r1 = this.preserveCounter;     // Catch: Throwable -> L6
            r0[r1] = r3;     // Catch: Throwable -> L6
            this.preserveCounter = (r1 + 1) % r0.length;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized boolean contains(BigInteger r2) {
            monitor-enter(this);
            boolean r3 = this.values.containsKey(r2);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r3;
        L6:
            th = move-exception;
            throw th;
        }
    }

    static {
        ZERO = BigInteger.valueOf(0);
        ONE = BigInteger.valueOf(1);
        TWO = BigInteger.valueOf(2);
        THREE = BigInteger.valueOf(3);
        SMALL_PRIMES_PRODUCT = new BigInteger("8138e8a0fcf3a4e84a771d40fd305d7f4aa59306d7251de54d98af8fe95729a1f73d893fa424cd2edc8636a6c3285e022b0e3866a565ae8108eed8591cd4fe8d2ce86165a978d719ebf647f362d33fca29cd179fb42401cbaf3df0c614056f9c8f3cfd51e474afb6bc6974f78db8aba8e9e517fded658591ab7502bd41849462f", 16);
        MAX_SMALL = BigInteger.valueOf(743).bitLength();
    }

    public static void asUnsignedByteArray(BigInteger r3, byte[] r4, int r5, int r6) {
        byte[] r7 = r3.toByteArray();
        if (r7.length != r6) goto L6;
        System.arraycopy(r7, 0, r4, r5, r6);
        return;
    L6:
        int r2 = 1;
        if (r7[0] == 0) goto L9;
    L11:
        r2 = 0;
    L12:
        int r0 = r7.length - r2;
        if (r0 > r6) goto L17;
        int r8 = (r6 - r0) + r5;
        Arrays.fill(r4, r5, r8, (byte) 0);
        System.arraycopy(r7, r2, r4, r8, r0);
        return;
    L17:
        throw new IllegalArgumentException("standard length exceeded for value");
    L9:
        if (r7.length == 1) goto L11;
        goto L11
    }

    public static byte[] asUnsignedByteArray(int r3, BigInteger r4) {
        byte[] r5 = r4.toByteArray();
        if (r5.length != r3) goto L5;
        return r5;
    L5:
        int r0 = 0;
        if (r5[0] == 0) goto L8;
    L10:
        int r1 = r5.length - r0;
        if (r1 > r3) goto L15;
        byte[] r2 = new byte[r3];
        System.arraycopy(r5, r0, r2, r3 - r1, r1);
        return r2;
    L15:
        throw new IllegalArgumentException("standard length exceeded for value");
    L8:
        if (r5.length == 1) goto L10;
        r0 = 1;
        goto L10
    }

    public static byte[] asUnsignedByteArray(BigInteger r4) {
        byte[] r5 = r4.toByteArray();
        if (r5[0] == 0) goto L5;
    L8:
        return r5;
    L5:
        if (r5.length == 1) goto L8;
        int r1 = r5.length - 1;
        byte[] r3 = new byte[r1];
        System.arraycopy(r5, 1, r3, 0, r1);
        return r3;
    }

    private static byte[] createRandom(int r3, SecureRandom r4) {
        if (r3 < 1) goto L7;
        int r0 = (r3 + 7) / 8;
        byte[] r1 = new byte[r0];
        r4.nextBytes(r1);
        r1[0] = (byte) (r1[0] & ((byte) (255 >>> ((r0 * 8) - r3))));
        return r1;
    L7:
        throw new IllegalArgumentException("bitLength must be at least 1");
    }

    public static BigInteger createRandomBigInteger(int r1, SecureRandom r2) {
        return new BigInteger(1, createRandom(r1, r2));
    }

    public static BigInteger createRandomInRange(BigInteger r3, BigInteger r4, SecureRandom r5) {
        int r0 = r3.compareTo(r4);
        if (r0 < 0) goto L9;
        if (r0 > 0) goto L7;
        return r3;
    L7:
        throw new IllegalArgumentException("'min' may not be greater than 'max'");
    L9:
        if (r3.bitLength() <= (r4.bitLength() / 2)) goto L13;
        BigInteger r6 = createRandomInRange(ZERO, r4.subtract(r3), r5);
    L12:
        return r6.add(r3);
    L13:
        int r1 = 0;
    L15:
        if (r1 >= 1000) goto L22;
        BigInteger r2 = createRandomBigInteger(r4.bitLength(), r5);
        if (r2.compareTo(r3) < 0) goto L21;
        if (r2.compareTo(r4) > 0) goto L21;
        return r2;
    L21:
        r1 = r1 + 1;
        goto L15
    L22:
        r6 = createRandomBigInteger(r4.subtract(r3).bitLength() - 1, r5);
        goto L12
    }

    public static BigInteger fromUnsignedByteArray(byte[] r2, int r3, int r4) {
        if (r3 == 0) goto L4;
    L5:
        byte[] r0 = new byte[r4];
        System.arraycopy(r2, r3, r0, 0, r4);
        r2 = r0;
    L7:
        return new BigInteger(1, r2);
    L4:
        if (r4 == r2.length) goto L7;
        goto L5
    }

    public static int intValueExact(BigInteger r2) {
        if (r2.bitLength() > 31) goto L7;
        return r2.intValue();
    L7:
        throw new ArithmeticException("BigInteger out of int range");
    }

    public static BigInteger modOddInverse(BigInteger r2, BigInteger r3) {
        if (r2.testBit(0) == false) goto L20;
        if (r2.signum() != 1) goto L18;
        if (r3.signum() >= 0) goto L9;
    L10:
        r3 = r3.mod(r2);
    L11:
        int r0 = r2.bitLength();
        int[] r4 = Nat.fromBigInteger(r0, r2);
        int[] r5 = Nat.fromBigInteger(r0, r3);
        int r1 = r4.length;
        int[] r6 = Nat.create(r1);
        if (Mod.modOddInverse(r4, r5, r6) == 0) goto L16;
        return Nat.toBigInteger(r1, r6);
    L16:
        throw new ArithmeticException("BigInteger not invertible.");
    L9:
        if (r3.compareTo(r2) < 0) goto L11;
    L18:
        throw new ArithmeticException("BigInteger: modulus not positive");
    L20:
        throw new IllegalArgumentException("'M' must be odd");
    }
}
