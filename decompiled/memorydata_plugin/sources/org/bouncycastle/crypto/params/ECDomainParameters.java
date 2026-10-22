package org.bouncycastle.crypto.params;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Objects;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class ECDomainParameters implements ECConstants {
    private final ECPoint G;
    private final ECCurve curve;
    private final BigInteger h;
    private BigInteger hInv;
    private final BigInteger n;
    private final byte[] seed;

    public ECDomainParameters(X9ECParameters r7) {
        this(r7.getCurve(), r7.getG(), r7.getN(), r7.getH(), r7.getSeed());
    }

    public ECDomainParameters(ECCurve r7, ECPoint r8, BigInteger r9, BigInteger r10) {
        this(r7, r8, r9, r10, null);
    }

    public ECDomainParameters(ECCurve r2, ECPoint r3, BigInteger r4, BigInteger r5, byte[] r6) {
        this.hInv = null;
        Objects.requireNonNull(r2, "curve");
        Objects.requireNonNull(r4, "n");
        this.curve = r2;
        this.G = validatePublicPoint(r2, r3);
        this.n = r4;
        this.h = r5;
        this.seed = Arrays.clone(r6);
    }

    static ECPoint validatePublicPoint(ECCurve r1, ECPoint r2) {
        Objects.requireNonNull(r2, "Point cannot be null");
        ECPoint r3 = ECAlgorithms.importPoint(r1, r2).normalize();
        if (r3.isInfinity() == true) goto L10;
        if (r3.isValid() == false) goto L8;
        return r3;
    L8:
        throw new IllegalArgumentException("Point not on curve");
    L10:
        throw new IllegalArgumentException("Point at infinity");
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ECDomainParameters.class) == true) goto L8;
        return false;
    L8:
        ECDomainParameters r6 = (ECDomainParameters) ZeusTransformUtils.preCheckCast(r5, ECDomainParameters.class, "com.obric.memorydata.plugin");
        if (this.curve.equals(r6.curve) == false) goto L16;
        if (this.G.equals(r6.G) == false) goto L16;
        if (this.n.equals(r6.n) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.G;
    }

    public BigInteger getH() {
        return this.h;
    }

    public BigInteger getN() {
        return this.n;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }

    public int hashCode() {
        int r0 = (((this.curve.hashCode() ^ 1028) * 257) ^ this.G.hashCode()) * 257;
        return this.n.hashCode() ^ r0;
    }

    public BigInteger validatePrivateScalar(BigInteger r2) {
        Objects.requireNonNull(r2, "Scalar cannot be null");
        if (r2.compareTo(ECConstants.ONE) < 0) goto L8;
        if (r2.compareTo(getN()) >= 0) goto L8;
        return r2;
    L8:
        throw new IllegalArgumentException("Scalar is not in the interval [1, n - 1]");
    }

    public ECPoint validatePublicPoint(ECPoint r1) {
        return validatePublicPoint(getCurve(), r1);
    }
}
