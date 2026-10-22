package org.bouncycastle.asn1.ua;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes7.dex */
public abstract class DSTU4145PointEncoder {
    public static ECPoint decodePoint(ECCurve r4, byte[] r5) {
        ECFieldElement r0 = r4.fromBigInteger(BigInteger.valueOf(r5[r5.length - 1] & 1));
        ECFieldElement r6 = r4.fromBigInteger(new BigInteger(1, r5));
        if (trace(r6).equals(r4.getA()) == true) goto L5;
        r6 = r6.addOne();
    L5:
        ECFieldElement r1 = null;
        if (r6.isZero() == false) goto L8;
        r1 = r4.getB().sqrt();
    L14:
        if (r1 == null) goto L18;
        return r4.validatePoint(r6.toBigInteger(), r1.toBigInteger());
    L18:
        throw new IllegalArgumentException("Invalid point compression");
    L8:
        ECFieldElement r2 = solveQuadraticEquation(r4, r6.square().invert().multiply(r4.getB()).add(r4.getA()).add(r6));
        if (r2 == null) goto L14;
        if (trace(r2).equals(r0) == true) goto L13;
        r2 = r2.addOne();
    L13:
        r1 = r6.multiply(r2);
        goto L14
    }

    public static byte[] encodePoint(ECPoint r3) {
        ECPoint r4 = r3.normalize();
        ECFieldElement r0 = r4.getAffineXCoord();
        byte[] r1 = r0.getEncoded();
        if (r0.isZero() == false) goto L5;
    L8:
        return r1;
    L5:
        if (trace(r4.getAffineYCoord().divide(r0)).isOne() == false) goto L7;
        int r5 = r1.length - 1;
        r1[r5] = (byte) (r1[r5] | 1);
        goto L8
    L7:
        int r6 = r1.length - 1;
        r1[r6] = (byte) (r1[r6] & 254);
        goto L8
    }

    private static ECFieldElement solveQuadraticEquation(ECCurve r8, ECFieldElement r9) {
        if (r9.isZero() == false) goto L5;
        return r9;
    L5:
        ECFieldElement r0 = r8.fromBigInteger(ECConstants.ZERO);
        Random r1 = new Random();
        int r2 = r9.getFieldSize();
    L6:
        ECFieldElement r3 = r8.fromBigInteger(new BigInteger(r2, r1));
        int r4 = 1;
        ECFieldElement r5 = r9;
        ECFieldElement r6 = r0;
    L8:
        if (r4 > (r2 - 1)) goto L11;
        ECFieldElement r7 = r5.square();
        r6 = r6.square().add(r7.multiply(r3));
        r5 = r7.add(r9);
        r4 = r4 + 1;
        goto L8
    L11:
        if (r5.isZero() == false) goto L12;
        if (r6.square().add(r6).isZero() == true) goto L6;
        return r6;
    L12:
        return null;
    }

    private static ECFieldElement trace(ECFieldElement r3) {
        int r0 = 1;
        ECFieldElement r1 = r3;
    L4:
        if (r0 >= r3.getFieldSize()) goto L6;
        r1 = r1.square().add(r3);
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }
}
