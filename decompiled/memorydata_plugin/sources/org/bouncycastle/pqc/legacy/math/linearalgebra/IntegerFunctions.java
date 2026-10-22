package org.bouncycastle.pqc.legacy.math.linearalgebra;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes7.dex */
public final class IntegerFunctions {
    private static final BigInteger FOUR = null;
    private static final BigInteger ONE = null;
    private static final int[] SMALL_PRIMES = null;
    private static final BigInteger TWO = null;
    private static final BigInteger ZERO = null;
    private static final int[] jacobiTable = null;
    private static SecureRandom sr;

    static {
        ZERO = BigInteger.valueOf(0);
        ONE = BigInteger.valueOf(1);
        TWO = BigInteger.valueOf(2);
        FOUR = BigInteger.valueOf(4);
        SMALL_PRIMES = new int[]{3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};
        sr = null;
        jacobiTable = new int[]{0, 1, 0, -1, 0, -1, 0, 1};
    }

    public static int ceilLog256(int r1) {
        if (r1 != 0) goto L5;
        return 1;
    L5:
        if (r1 >= 0) goto L7;
        r1 = -r1;
    L7:
        int r0 = 0;
    L8:
        if (r1 <= 0) goto L10;
        r0 = r0 + 1;
        r1 = r1 >>> 8;
        goto L8
    L10:
        return r0;
    }
}
