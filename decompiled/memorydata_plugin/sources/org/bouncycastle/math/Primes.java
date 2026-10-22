package org.bouncycastle.math;

import com.obric.cae.userAware.WifiScanSceneType;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Primes {
    private static final BigInteger ONE = null;
    private static final BigInteger THREE = null;
    private static final BigInteger TWO = null;

    public static class MROutput {
        private BigInteger factor;
        private boolean provablyComposite;

        private MROutput(boolean r1, BigInteger r2) {
            this.provablyComposite = r1;
            this.factor = r2;
        }

        static /* synthetic */ MROutput access$000() {
            return probablyPrime();
        }

        static /* synthetic */ MROutput access$100(BigInteger r0) {
            return provablyCompositeWithFactor(r0);
        }

        static /* synthetic */ MROutput access$200() {
            return provablyCompositeNotPrimePower();
        }

        private static MROutput probablyPrime() {
            return new MROutput(false, null);
        }

        private static MROutput provablyCompositeNotPrimePower() {
            return new MROutput(true, null);
        }

        private static MROutput provablyCompositeWithFactor(BigInteger r2) {
            return new MROutput(true, r2);
        }

        public boolean isProvablyComposite() {
            return this.provablyComposite;
        }
    }

    static {
        ONE = BigInteger.valueOf(1);
        TWO = BigInteger.valueOf(2);
        THREE = BigInteger.valueOf(3);
    }

    private static void checkCandidate(BigInteger r2, String r3) {
        if (r2 == null) goto L9;
        if (r2.signum() < 1) goto L9;
        if (r2.bitLength() < 2) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("'" + r3 + "' must be non-null and >= 2");
    }

    public static MROutput enhancedMRProbablePrimeTest(BigInteger r11, SecureRandom r12, int r13) {
        checkCandidate(r11, "candidate");
        if (r12 == null) goto L54;
        if (r13 < 1) goto L52;
        if (r11.bitLength() != 2) goto L11;
        return MROutput.access$000();
    L11:
        if (r11.testBit(0) == false) goto L13;
        BigInteger r2 = r11.subtract(ONE);
        BigInteger r3 = r11.subtract(TWO);
        int r4 = r2.getLowestSetBit();
        BigInteger r5 = r2.shiftRight(r4);
        int r6 = 0;
    L15:
        if (r6 >= r13) goto L50;
        BigInteger r7 = BigIntegers.createRandomInRange(TWO, r3, r12);
        BigInteger r8 = r7.gcd(r11);
        BigInteger r9 = ONE;
        if (r8.compareTo(r9) > 0) goto L19;
        BigInteger r10 = r7.modPow(r5, r11);
        if (r10.equals(r9) == true) goto L48;
        if (r10.equals(r2) == true) goto L48;
        int r14 = 1;
    L26:
        if (r14 >= r4) goto L34;
        BigInteger r15 = r10.modPow(TWO, r11);
        if (r15.equals(r2) == true) goto L29;
        if (r15.equals(ONE) == true) goto L32;
        r14 = r14 + 1;
        r10 = r15;
        goto L26
    L32:
        boolean r16 = false;
    L35:
        if (r16 == true) goto L48;
        BigInteger r17 = ONE;
        if (r15.equals(r17) == true) goto L42;
        r10 = r15.modPow(TWO, r11);
        if (r10.equals(r17) == false) goto L42;
        r10 = r15;
    L42:
        BigInteger r18 = r10.subtract(r17).gcd(r11);
        if (r18.compareTo(r17) <= 0) goto L47;
        return MROutput.access$100(r18);
    L47:
        return MROutput.access$200();
    L29:
        r16 = true;
        goto L35
    L34:
        r16 = false;
        r15 = r10;
    L48:
        r6 = r6 + 1;
        goto L15
    L19:
        return MROutput.access$100(r8);
    L50:
        return MROutput.access$000();
    L13:
        return MROutput.access$100(TWO);
    L52:
        throw new IllegalArgumentException("'iterations' must be > 0");
    L54:
        throw new IllegalArgumentException("'random' cannot be null");
    }

    public static boolean hasAnySmallFactors(BigInteger r1) {
        checkCandidate(r1, "candidate");
        return implHasAnySmallFactors(r1);
    }

    private static boolean implHasAnySmallFactors(BigInteger r3) {
        int r0 = r3.mod(BigInteger.valueOf(223092870)).intValue();
        if ((r0 % 2) != 0) goto L5;
    L108:
        return true;
    L5:
        if ((r0 % 3) == 0) goto L108;
        if ((r0 % 5) == 0) goto L108;
        if ((r0 % 7) == 0) goto L108;
        if ((r0 % 11) == 0) goto L108;
        if ((r0 % 13) == 0) goto L108;
        if ((r0 % 17) == 0) goto L108;
        if ((r0 % 19) == 0) goto L108;
        if ((r0 % 23) == 0) goto L108;
        int r1 = r3.mod(BigInteger.valueOf(58642669)).intValue();
        if ((r1 % 29) == 0) goto L108;
        if ((r1 % 31) == 0) goto L108;
        if ((r1 % 37) == 0) goto L108;
        if ((r1 % 41) == 0) goto L108;
        if ((r1 % 43) == 0) goto L108;
        int r2 = r3.mod(BigInteger.valueOf(600662303)).intValue();
        if ((r2 % 47) == 0) goto L108;
        if ((r2 % 53) == 0) goto L108;
        if ((r2 % 59) == 0) goto L108;
        if ((r2 % 61) == 0) goto L108;
        if ((r2 % 67) == 0) goto L108;
        int r4 = r3.mod(BigInteger.valueOf(33984931)).intValue();
        if ((r4 % 71) == 0) goto L108;
        if ((r4 % 73) == 0) goto L108;
        if ((r4 % 79) == 0) goto L108;
        if ((r4 % 83) == 0) goto L108;
        int r5 = r3.mod(BigInteger.valueOf(89809099)).intValue();
        if ((r5 % 89) == 0) goto L108;
        if ((r5 % 97) == 0) goto L108;
        if ((r5 % 101) == 0) goto L108;
        if ((r5 % 103) == 0) goto L108;
        int r6 = r3.mod(BigInteger.valueOf(167375713)).intValue();
        if ((r6 % 107) == 0) goto L108;
        if ((r6 % 109) == 0) goto L108;
        if ((r6 % 113) == 0) goto L108;
        if ((r6 % 127) == 0) goto L108;
        int r7 = r3.mod(BigInteger.valueOf(371700317)).intValue();
        if ((r7 % 131) == 0) goto L108;
        if ((r7 % 137) == 0) goto L108;
        if ((r7 % 139) == 0) goto L108;
        if ((r7 % 149) == 0) goto L108;
        int r8 = r3.mod(BigInteger.valueOf(645328247)).intValue();
        if ((r8 % 151) == 0) goto L108;
        if ((r8 % 157) == 0) goto L108;
        if ((r8 % 163) == 0) goto L108;
        if ((r8 % 167) == 0) goto L108;
        int r9 = r3.mod(BigInteger.valueOf(1070560157)).intValue();
        if ((r9 % 173) == 0) goto L108;
        if ((r9 % 179) == 0) goto L108;
        if ((r9 % 181) == 0) goto L108;
        if ((r9 % 191) == 0) goto L108;
        int r10 = r3.mod(BigInteger.valueOf(1596463769)).intValue();
        if ((r10 % 193) == 0) goto L108;
        if ((r10 % 197) == 0) goto L108;
        if ((r10 % WifiScanSceneType.HAR_END) == 0) goto L108;
        if ((r10 % 211) == 0) goto L108;
        return false;
    }

    private static boolean implMRProbablePrimeToBase(BigInteger r3, BigInteger r4, BigInteger r5, int r6, BigInteger r7) {
        BigInteger r8 = r7.modPow(r5, r3);
        if (r8.equals(ONE) == false) goto L5;
        return true;
    L5:
        if (r8.equals(r4) == true) goto L23;
        int r9 = 1;
    L9:
        if (r9 >= r6) goto L18;
        r8 = r8.modPow(TWO, r3);
        if (r8.equals(r4) == true) goto L24;
        if (r8.equals(ONE) == true) goto L15;
        r9 = r9 + 1;
        goto L9
    L15:
        return false;
    L24:
        return true;
    L18:
        return false;
    L23:
        return true;
    }

    public static boolean isMRProbablePrime(BigInteger r8, SecureRandom r9, int r10) {
        checkCandidate(r8, "candidate");
        if (r9 == null) goto L22;
        if (r10 < 1) goto L20;
        if (r8.bitLength() != 2) goto L10;
        return true;
    L10:
        if (r8.testBit(0) == true) goto L12;
        return false;
    L12:
        BigInteger r2 = r8.subtract(ONE);
        BigInteger r3 = r8.subtract(TWO);
        int r4 = r2.getLowestSetBit();
        BigInteger r5 = r2.shiftRight(r4);
        int r6 = 0;
    L13:
        if (r6 >= r10) goto L18;
        if (implMRProbablePrimeToBase(r8, r2, r5, r4, BigIntegers.createRandomInRange(TWO, r3, r9)) == false) goto L16;
        r6 = r6 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    L20:
        throw new IllegalArgumentException("'iterations' must be > 0");
    L22:
        throw new IllegalArgumentException("'random' cannot be null");
    }
}
