package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat128;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class SecP128R1Curve extends ECCurve.AbstractFp {
    private static final ECFieldElement[] SECP128R1_AFFINE_ZS = null;
    public static final BigInteger q = null;
    protected SecP128R1Point infinity;

    static {
        q = SecP128R1FieldElement.Q;
        SECP128R1_AFFINE_ZS = new ECFieldElement[]{new SecP128R1FieldElement(ECConstants.ONE)};
    }

    public SecP128R1Curve() {
        super(q);
        this.infinity = new SecP128R1Point(this, null, null);
        this.f17979a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f17980b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("E87579C11079F43DD824993C2CEE5ED3")));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFE0000000075A30D1B9038A115"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = 2;
    }

    static /* synthetic */ ECFieldElement[] access$000() {
        return SECP128R1_AFFINE_ZS;
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECCurve cloneCurve() {
        return new SecP128R1Curve();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECLookupTable createCacheSafeLookupTable(ECPoint[] r9, int r10, final int r11) {
        final int[] r0 = new int[(r11 * 4) * 2];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r11) goto L6;
        ECPoint r4 = r9[r10 + r2];
        Nat128.copy(((SecP128R1FieldElement) ZeusTransformUtils.preCheckCast(r4.getRawXCoord(), SecP128R1FieldElement.class, "com.obric.memorydata.plugin")).x, 0, r0, r3);
        int r5 = r3 + 4;
        Nat128.copy(((SecP128R1FieldElement) ZeusTransformUtils.preCheckCast(r4.getRawYCoord(), SecP128R1FieldElement.class, "com.obric.memorydata.plugin")).x, 0, r0, r5);
        r3 = r5 + 4;
        r2 = r2 + 1;
        goto L3
    L6:
        return new AnonymousClass1(this, r11, r0);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r2, ECFieldElement r3) {
        return new SecP128R1Point(this, r2, r3);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
        return new SecP128R1Point(this, r2, r3, r4);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECFieldElement fromBigInteger(BigInteger r1) {
        return new SecP128R1FieldElement(r1);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public int getFieldSize() {
        return q.bitLength();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint getInfinity() {
        return this.infinity;
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractFp, org.bouncycastle.math.ec.ECCurve
    public ECFieldElement randomFieldElementMult(SecureRandom r1) {
        int[] r0 = Nat128.create();
        SecP128R1Field.randomMult(r1, r0);
        return new SecP128R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public boolean supportsCoordinateSystem(int r1) {
        if (r1 == 2) goto L6;
        return false;
    L6:
        return true;
    }
}
