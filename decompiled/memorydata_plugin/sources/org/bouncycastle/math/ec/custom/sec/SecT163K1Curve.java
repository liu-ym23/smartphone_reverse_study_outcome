package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.WTauNafMultiplier;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class SecT163K1Curve extends ECCurve.AbstractF2m {
    private static final ECFieldElement[] SECT163K1_AFFINE_ZS = null;
    protected SecT163K1Point infinity;

    static {
        SECT163K1_AFFINE_ZS = new ECFieldElement[]{new SecT163FieldElement(ECConstants.ONE)};
    }

    public SecT163K1Curve() {
        super(163, 3, 6, 7);
        this.infinity = new SecT163K1Point(this, null, null);
        this.f17979a = fromBigInteger(BigInteger.valueOf(1));
        this.f17980b = this.f17979a;
        this.order = new BigInteger(1, Hex.decodeStrict("04000000000000000000020108A2E0CC0D99F8A5EF"));
        this.cofactor = BigInteger.valueOf(2);
        this.coord = 6;
    }

    static /* synthetic */ ECFieldElement[] access$000() {
        return SECT163K1_AFFINE_ZS;
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECCurve cloneCurve() {
        return new SecT163K1Curve();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECLookupTable createCacheSafeLookupTable(ECPoint[] r9, int r10, final int r11) {
        final long[] r0 = new long[(r11 * 3) * 2];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r11) goto L6;
        ECPoint r4 = r9[r10 + r2];
        Nat192.copy64(((SecT163FieldElement) ZeusTransformUtils.preCheckCast(r4.getRawXCoord(), SecT163FieldElement.class, "com.obric.memorydata.plugin")).x, 0, r0, r3);
        int r5 = r3 + 3;
        Nat192.copy64(((SecT163FieldElement) ZeusTransformUtils.preCheckCast(r4.getRawYCoord(), SecT163FieldElement.class, "com.obric.memorydata.plugin")).x, 0, r0, r5);
        r3 = r5 + 3;
        r2 = r2 + 1;
        goto L3
    L6:
        return new AnonymousClass1(this, r11, r0);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECMultiplier createDefaultMultiplier() {
        return new WTauNafMultiplier();
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r2, ECFieldElement r3) {
        return new SecT163K1Point(this, r2, r3);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
        return new SecT163K1Point(this, r2, r3, r4);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECFieldElement fromBigInteger(BigInteger r1) {
        return new SecT163FieldElement(r1);
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public int getFieldSize() {
        return 163;
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public ECPoint getInfinity() {
        return this.infinity;
    }

    @Override // org.bouncycastle.math.ec.ECCurve.AbstractF2m
    public boolean isKoblitz() {
        return true;
    }

    @Override // org.bouncycastle.math.ec.ECCurve
    public boolean supportsCoordinateSystem(int r1) {
        if (r1 == 6) goto L6;
        return false;
    L6:
        return true;
    }
}
