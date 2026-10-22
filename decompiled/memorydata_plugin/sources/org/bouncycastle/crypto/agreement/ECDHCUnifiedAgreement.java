package org.bouncycastle.crypto.agreement;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.params.ECDHUPrivateParameters;
import org.bouncycastle.crypto.params.ECDHUPublicParameters;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes7.dex */
public class ECDHCUnifiedAgreement {
    private ECDHUPrivateParameters privParams;

    public ECDHCUnifiedAgreement() {
    }

    public byte[] calculateAgreement(CipherParameters r4) {
        ECDHUPublicParameters r5 = (ECDHUPublicParameters) ZeusTransformUtils.preCheckCast((CipherParameters) ZeusTransformUtils.wrapperContextForParams(r4, CipherParameters.class, "com.obric.memorydata.plugin"), ECDHUPublicParameters.class, "com.obric.memorydata.plugin");
        ECDHCBasicAgreement r0 = new ECDHCBasicAgreement();
        ECDHCBasicAgreement r1 = new ECDHCBasicAgreement();
        r0.init(this.privParams.getStaticPrivateKey());
        BigInteger r2 = r0.calculateAgreement(r5.getStaticPublicKey());
        r1.init(this.privParams.getEphemeralPrivateKey());
        BigInteger r6 = r1.calculateAgreement(r5.getEphemeralPublicKey());
        int r3 = getFieldSize();
        byte[] r7 = new byte[r3 * 2];
        BigIntegers.asUnsignedByteArray(r6, r7, 0, r3);
        BigIntegers.asUnsignedByteArray(r2, r7, r3, r3);
        return r7;
    }

    public int getFieldSize() {
        return (this.privParams.getStaticPrivateKey().getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    public void init(CipherParameters r3) {
        ECDHUPrivateParameters r4 = (ECDHUPrivateParameters) ZeusTransformUtils.preCheckCast((CipherParameters) ZeusTransformUtils.wrapperContextForParams(r3, CipherParameters.class, "com.obric.memorydata.plugin"), ECDHUPrivateParameters.class, "com.obric.memorydata.plugin");
        this.privParams = r4;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties("ECCDHU", r4.getStaticPrivateKey()));
    }
}
