package org.bouncycastle.crypto.agreement;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes7.dex */
public class ECDHCBasicAgreement implements BasicAgreement {
    ECPrivateKeyParameters key;

    public ECDHCBasicAgreement() {
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters r3) {
        ECPublicKeyParameters r4 = (ECPublicKeyParameters) ZeusTransformUtils.preCheckCast((CipherParameters) ZeusTransformUtils.wrapperContextForParams(r3, CipherParameters.class, "com.obric.memorydata.plugin"), ECPublicKeyParameters.class, "com.obric.memorydata.plugin");
        ECDomainParameters r0 = this.key.getParameters();
        if (r0.equals(r4.getParameters()) == false) goto L15;
        BigInteger r2 = r0.getH().multiply(this.key.getD()).mod(r0.getN());
        ECPoint r5 = ECAlgorithms.cleanPoint(r0.getCurve(), r4.getQ());
        if (r5.isInfinity() == true) goto L13;
        ECPoint r6 = r5.multiply(r2).normalize();
        if (r6.isInfinity() == true) goto L11;
        return r6.getAffineXCoord().toBigInteger();
    L11:
        throw new IllegalStateException("Infinity is not a valid agreement value for ECDHC");
    L13:
        throw new IllegalStateException("Infinity is not a valid public key for ECDHC");
    L15:
        throw new IllegalStateException("ECDHC public key has wrong domain parameters");
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public void init(CipherParameters r3) {
        ECPrivateKeyParameters r4 = (ECPrivateKeyParameters) ZeusTransformUtils.preCheckCast((CipherParameters) ZeusTransformUtils.wrapperContextForParams(r3, CipherParameters.class, "com.obric.memorydata.plugin"), ECPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        this.key = r4;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties("ECCDH", r4));
    }
}
