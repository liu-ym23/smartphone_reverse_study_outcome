package org.bouncycastle.crypto.agreement.jpake;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class JPAKEUtil {
    static final BigInteger ONE = null;
    static final BigInteger ZERO = null;

    static {
        ZERO = BigInteger.valueOf(0);
        ONE = BigInteger.valueOf(1);
    }

    public static BigInteger calculateA(BigInteger r0, BigInteger r1, BigInteger r2, BigInteger r3) {
        return r2.modPow(r3, r0);
    }

    public static BigInteger calculateGA(BigInteger r0, BigInteger r1, BigInteger r2, BigInteger r3) {
        return r1.multiply(r2).multiply(r3).mod(r0);
    }

    public static BigInteger calculateGx(BigInteger r0, BigInteger r1, BigInteger r2) {
        return r1.modPow(r2, r0);
    }

    private static BigInteger calculateHashForZeroKnowledgeProof(BigInteger r2, BigInteger r3, BigInteger r4, String r5, Digest r6) {
        Digest r7 = (Digest) ZeusTransformUtils.wrapperContextForParams(r6, Digest.class, "com.obric.memorydata.plugin");
        r7.reset();
        updateDigestIncludingSize(r7, r2);
        updateDigestIncludingSize(r7, r3);
        updateDigestIncludingSize(r7, r4);
        updateDigestIncludingSize(r7, r5);
        byte[] r8 = new byte[r7.getDigestSize()];
        r7.doFinal(r8, 0);
        return new BigInteger(r8);
    }

    public static BigInteger calculateKeyingMaterial(BigInteger r0, BigInteger r1, BigInteger r2, BigInteger r3, BigInteger r4, BigInteger r5) {
        return r2.modPow(r3.multiply(r4).negate().mod(r1), r0).multiply(r5).modPow(r3, r0);
    }

    public static BigInteger calculateS(char[] r1) {
        return new BigInteger(Strings.toUTF8ByteArray(r1));
    }

    public static BigInteger calculateX2s(BigInteger r0, BigInteger r1, BigInteger r2) {
        return r1.multiply(r2).mod(r0);
    }

    public static BigInteger[] calculateZeroKnowledgeProof(BigInteger r3, BigInteger r4, BigInteger r5, BigInteger r6, BigInteger r7, String r8, Digest r9, SecureRandom r10) {
        Digest r11 = (Digest) ZeusTransformUtils.wrapperContextForParams(r9, Digest.class, "com.obric.memorydata.plugin");
        BigInteger r12 = BigIntegers.createRandomInRange(ZERO, r4.subtract(ONE), r10);
        BigInteger r13 = r5.modPow(r12, r3);
        return new BigInteger[]{r13, r12.subtract(r7.multiply(calculateHashForZeroKnowledgeProof(r5, r13, r6, r8, r11))).mod(r4)};
    }

    public static BigInteger generateX1(BigInteger r2, SecureRandom r3) {
        return BigIntegers.createRandomInRange(ZERO, r2.subtract(ONE), r3);
    }

    public static BigInteger generateX2(BigInteger r1, SecureRandom r2) {
        BigInteger r0 = ONE;
        return BigIntegers.createRandomInRange(r0, r1.subtract(r0), r2);
    }

    private static byte[] intToByteArray(int r3) {
        return new byte[]{(byte) (r3 >>> 24), (byte) (r3 >>> 16), (byte) (r3 >>> 8), (byte) r3};
    }

    private static void updateDigestIncludingSize(Digest r3, String r4) {
        Digest r5 = (Digest) ZeusTransformUtils.wrapperContextForParams(r3, Digest.class, "com.obric.memorydata.plugin");
        byte[] r6 = Strings.toUTF8ByteArray(r4);
        r5.update(intToByteArray(r6.length), 0, 4);
        r5.update(r6, 0, r6.length);
        Arrays.fill(r6, (byte) 0);
    }

    private static void updateDigestIncludingSize(Digest r3, BigInteger r4) {
        Digest r5 = (Digest) ZeusTransformUtils.wrapperContextForParams(r3, Digest.class, "com.obric.memorydata.plugin");
        byte[] r6 = BigIntegers.asUnsignedByteArray(r4);
        r5.update(intToByteArray(r6.length), 0, 4);
        r5.update(r6, 0, r6.length);
        Arrays.fill(r6, (byte) 0);
    }

    public static void validateGa(BigInteger r1) {
        if (r1.equals(ONE) == true) goto L6;
        return;
    L6:
        throw new CryptoException("ga is equal to 1.  It should not be.  The chances of this happening are on the order of 2^160 for a 160-bit q.  Try again.");
    }

    public static void validateGx4(BigInteger r1) {
        if (r1.equals(ONE) == true) goto L6;
        return;
    L6:
        throw new CryptoException("g^x validation failed.  g^x should not be 1.");
    }

    public static void validateNotNull(Object r1, String r2) {
        if (r1 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r2 + " must not be null");
    }

    public static void validateParticipantIdsDiffer(String r2, String r3) {
        if (r2.equals(r3) == true) goto L6;
        return;
    L6:
        throw new CryptoException("Both participants are using the same participantId (" + r2 + "). This is not allowed. Each participant must use a unique participantId.");
    }

    public static void validateParticipantIdsEqual(String r3, String r4) {
        if (r3.equals(r4) == false) goto L6;
        return;
    L6:
        throw new CryptoException("Received payload from incorrect partner (" + r4 + "). Expected to receive payload from " + r3 + ".");
    }

    public static void validateZeroKnowledgeProof(BigInteger r2, BigInteger r3, BigInteger r4, BigInteger r5, BigInteger[] r6, String r7, Digest r8) {
        Digest r9 = (Digest) ZeusTransformUtils.wrapperContextForParams(r8, Digest.class, "com.obric.memorydata.plugin");
        BigInteger r0 = r6[0];
        BigInteger r10 = r6[1];
        BigInteger r11 = calculateHashForZeroKnowledgeProof(r4, r0, r5, r7, r9);
        if (r5.compareTo(ZERO) != 1) goto L12;
        if (r5.compareTo(r2) != (-1)) goto L12;
        if (r5.modPow(r3, r2).compareTo(ONE) != 0) goto L12;
        if (r4.modPow(r10, r2).multiply(r5.modPow(r11, r2)).mod(r2).compareTo(r0) != 0) goto L12;
        return;
    L12:
        throw new CryptoException("Zero-knowledge proof validation failed");
    }
}
