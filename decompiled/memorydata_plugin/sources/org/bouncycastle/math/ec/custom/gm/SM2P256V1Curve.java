package org.bouncycastle.math.ec.custom.gm;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class SM2P256V1Curve extends ECCurve.AbstractFp {
    private static final ECFieldElement[] SM2P256V1_AFFINE_ZS = null;
    public static final BigInteger q = null;
    protected SM2P256V1Point infinity;

    static {
        q = SM2P256V1FieldElement.Q;
        SM2P256V1_AFFINE_ZS = new ECFieldElement[]{new SM2P256V1FieldElement(ECConstants.ONE)};
    }

    public SM2P256V1Curve() {
        super(q);
        this.infinity = new SM2P256V1Point(this, null, null);
        this.f17979a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC")));
        this.f17980b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93")));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = 2;
    }

    static /* synthetic */ ECFieldElement[] access$000() {
        return SM2P256V1_AFFINE_ZS;
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECCurve cloneCurve() {
        return new SM2P256V1Curve();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECLookupTable createCacheSafeLookupTable(ECPoint[] r9, int r10, final int r11) {
        final int[] r0 = new int[(r11 * 8) * 2];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r11) goto L6;
        ECPoint r4 = r9[r10 + r2];
        Nat256.copy(((SM2P256V1FieldElement) ZeusTransformUtils.preCheckCast(r4.getRawXCoord(), SM2P256V1FieldElement.class, "com.obric.memorydata.plugin")).x, 0, r0, r3);
        int r5 = r3 + 8;
        Nat256.copy(((SM2P256V1FieldElement) ZeusTransformUtils.preCheckCast(r4.getRawYCoord(), SM2P256V1FieldElement.class, "com.obric.memorydata.plugin")).x, 0, r0, r5);
        r3 = r5 + 8;
        r2 = r2 + 1;
        goto L3
    L6:
        return new AnonymousClass1(this, r11, r0);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r2, ECFieldElement r3) {
        return new SM2P256V1Point(this, r2, r3);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
        return new SM2P256V1Point(this, r2, r3, r4);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECFieldElement fromBigInteger(BigInteger r1) {
        return new SM2P256V1FieldElement(r1);
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
        int[] r0 = Nat256.create();
        SM2P256V1Field.randomMult(r1, r0);
        return new SM2P256V1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public boolean supportsCoordinateSystem(int r1) {
        if (r1 == 2) goto L6;
        return false;
    L6:
        return true;
    }
}
