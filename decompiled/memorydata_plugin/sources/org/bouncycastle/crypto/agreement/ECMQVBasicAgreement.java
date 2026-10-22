package org.bouncycastle.crypto.agreement;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.MQVPrivateParameters;
import org.bouncycastle.crypto.params.MQVPublicParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes7.dex */
public class ECMQVBasicAgreement implements BasicAgreement {
    MQVPrivateParameters privParams;

    public ECMQVBasicAgreement() {
    }

    private ECPoint calculateMqvAgreement(ECDomainParameters r4, ECPrivateKeyParameters r5, ECPrivateKeyParameters r6, ECPublicKeyParameters r7, ECPublicKeyParameters r8, ECPublicKeyParameters r9) {
        BigInteger r3 = r4.getN();
        int r0 = (r3.bitLength() + 1) / 2;
        BigInteger r1 = ECConstants.ONE.shiftLeft(r0);
        ECCurve r2 = r4.getCurve();
        ECPoint r10 = ECAlgorithms.cleanPoint(r2, r7.getQ());
        ECPoint r11 = ECAlgorithms.cleanPoint(r2, r8.getQ());
        ECPoint r12 = ECAlgorithms.cleanPoint(r2, r9.getQ());
        BigInteger r13 = r10.getAffineXCoord().toBigInteger().mod(r1).setBit(r0);
        BigInteger r14 = r5.getD().multiply(r13).add(r6.getD()).mod(r3);
        BigInteger r15 = r12.getAffineXCoord().toBigInteger().mod(r1).setBit(r0);
        BigInteger r16 = r4.getH().multiply(r14).mod(r3);
        return ECAlgorithms.sumOfTwoMultiplies(r11, r15.multiply(r16).mod(r3), r12, r16);
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters r9) {
        CipherParameters r10 = (CipherParameters) ZeusTransformUtils.wrapperContextForParams(r9, CipherParameters.class, "com.obric.memorydata.plugin");
        if (Properties.isOverrideSet("org.bouncycastle.ec.disable_mqv") == true) goto L15;
        MQVPublicParameters r11 = (MQVPublicParameters) ZeusTransformUtils.preCheckCast(r10, MQVPublicParameters.class, "com.obric.memorydata.plugin");
        ECPrivateKeyParameters r3 = this.privParams.getStaticPrivateKey();
        ECDomainParameters r2 = r3.getParameters();
        if (r2.equals(r11.getStaticPublicKey().getParameters()) == false) goto L13;
        ECPoint r8 = calculateMqvAgreement(r2, r3, this.privParams.getEphemeralPrivateKey(), this.privParams.getEphemeralPublicKey(), r11.getStaticPublicKey(), r11.getEphemeralPublicKey()).normalize();
        if (r8.isInfinity() == true) goto L11;
        return r8.getAffineXCoord().toBigInteger();
    L11:
        throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
    L13:
        throw new IllegalStateException("ECMQV public key components have wrong domain parameters");
    L15:
        throw new IllegalStateException("ECMQV explicitly disabled");
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public void init(CipherParameters r3) {
        MQVPrivateParameters r4 = (MQVPrivateParameters) ZeusTransformUtils.preCheckCast((CipherParameters) ZeusTransformUtils.wrapperContextForParams(r3, CipherParameters.class, "com.obric.memorydata.plugin"), MQVPrivateParameters.class, "com.obric.memorydata.plugin");
        this.privParams = r4;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties("ECMQV", r4.getStaticPrivateKey()));
    }
}
