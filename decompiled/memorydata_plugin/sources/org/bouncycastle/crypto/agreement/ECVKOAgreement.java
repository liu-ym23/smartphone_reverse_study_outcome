package org.bouncycastle.crypto.agreement;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithUKM;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes7.dex */
public class ECVKOAgreement {
    private final Digest digest;
    private ECPrivateKeyParameters key;
    private BigInteger ukm;

    private byte[] fromPoint(ECPoint r8) {
        BigInteger r0 = r8.getAffineXCoord().toBigInteger();
        BigInteger r9 = r8.getAffineYCoord().toBigInteger();
        if (r0.toByteArray().length <= 33) goto L5;
        int r1 = 64;
    L6:
        int r2 = r1 * 2;
        byte[] r3 = new byte[r2];
        byte[] r4 = BigIntegers.asUnsignedByteArray(r1, r0);
        byte[] r10 = BigIntegers.asUnsignedByteArray(r1, r9);
        int r5 = 0;
    L7:
        if (r5 == r1) goto L9;
        r3[r5] = r4[(r1 - r5) - 1];
        r5 = r5 + 1;
        goto L7
    L9:
        int r6 = 0;
    L10:
        if (r6 == r1) goto L12;
        r3[r1 + r6] = r10[(r1 - r6) - 1];
        r6 = r6 + 1;
        goto L10
    L12:
        this.digest.update(r3, 0, r2);
        byte[] r11 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(r11, 0);
        return r11;
    L5:
        r1 = 32;
        goto L6
    }

    private static BigInteger toInteger(byte[] r5) {
        int r0 = r5.length;
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L4:
        if (r2 == r0) goto L7;
        r1[r2] = r5[(r5.length - r2) - 1];
        r2 = r2 + 1;
        goto L4
    L7:
        return new BigInteger(1, r1);
    }

    public byte[] calculateAgreement(CipherParameters r4) {
        ECPublicKeyParameters r5 = (ECPublicKeyParameters) ZeusTransformUtils.preCheckCast((CipherParameters) ZeusTransformUtils.wrapperContextForParams(r4, CipherParameters.class, "com.obric.memorydata.plugin"), ECPublicKeyParameters.class, "com.obric.memorydata.plugin");
        ECDomainParameters r0 = this.key.getParameters();
        if (r0.equals(r5.getParameters()) == false) goto L15;
        BigInteger r1 = r0.getH().multiply(this.ukm).multiply(this.key.getD()).mod(r0.getN());
        ECPoint r6 = ECAlgorithms.cleanPoint(r0.getCurve(), r5.getQ());
        if (r6.isInfinity() == true) goto L13;
        ECPoint r7 = r6.multiply(r1).normalize();
        if (r7.isInfinity() == true) goto L11;
        return fromPoint(r7);
    L11:
        throw new IllegalStateException("Infinity is not a valid agreement value for ECVKO");
    L13:
        throw new IllegalStateException("Infinity is not a valid public key for ECDHC");
    L15:
        throw new IllegalStateException("ECVKO public key has wrong domain parameters");
    }

    public void init(CipherParameters r4) {
        ParametersWithUKM r5 = (ParametersWithUKM) ZeusTransformUtils.preCheckCast((CipherParameters) ZeusTransformUtils.wrapperContextForParams(r4, CipherParameters.class, "com.obric.memorydata.plugin"), ParametersWithUKM.class, "com.obric.memorydata.plugin");
        this.key = (ECPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r5.getParameters(), ECPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        this.ukm = toInteger(r5.getUKM());
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties("ECVKO", this.key));
    }
}
