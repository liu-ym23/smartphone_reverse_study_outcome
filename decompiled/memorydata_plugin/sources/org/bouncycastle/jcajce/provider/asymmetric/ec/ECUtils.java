package org.bouncycastle.jcajce.provider.asymmetric.ec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.spec.ECParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;

/* JADX INFO: loaded from: classes7.dex */
class ECUtils {
    static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey r2) {
        PublicKey r3 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r2, PublicKey.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, BCECPublicKey.class) == false) goto L6;
        return ((BCECPublicKey) ZeusTransformUtils.preCheckCast(r3, BCECPublicKey.class, "com.obric.memorydata.plugin")).engineGetKeyParameters();
    L6:
        return ECUtil.generatePublicKeyParameter(r3);
    }

    static X962Parameters getDomainParametersFromName(ECParameterSpec r7, boolean r8) {
        if (ZeusTransformUtils.instanceOf(r7, ECNamedCurveSpec.class) == false) goto L8;
        ASN1ObjectIdentifier r9 = ECUtil.getNamedCurveOid(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(r7, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName());
        if (r9 != null) goto L12;
        r9 = new ASN1ObjectIdentifier(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(r7, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName());
    L12:
        return new X962Parameters(r9);
    L8:
        if (r7 == null) goto L13;
        ECCurve r2 = EC5Util.convertCurve(r7.getCurve());
        return new X962Parameters(new X9ECParameters(r2, new X9ECPoint(EC5Util.convertPoint(r2, r7.getGenerator()), r8), r7.getOrder(), BigInteger.valueOf(r7.getCofactor()), r7.getCurve().getSeed()));
    L13:
        return new X962Parameters(DERNull.INSTANCE);
    }
}
