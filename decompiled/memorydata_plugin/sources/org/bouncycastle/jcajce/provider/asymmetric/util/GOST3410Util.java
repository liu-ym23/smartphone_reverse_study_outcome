package org.bouncycastle.jcajce.provider.asymmetric.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.bouncycastle.crypto.params.GOST3410PublicKeyParameters;
import org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import org.bouncycastle.jce.interfaces.GOST3410PublicKey;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

/* JADX INFO: loaded from: classes7.dex */
public class GOST3410Util {
    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey r5) {
        PrivateKey r6 = (PrivateKey) ZeusTransformUtils.wrapperContextForParams(r5, PrivateKey.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, GOST3410PrivateKey.class) == false) goto L7;
        GOST3410PrivateKey r7 = (GOST3410PrivateKey) ZeusTransformUtils.preCheckCast(r6, GOST3410PrivateKey.class, "com.obric.memorydata.plugin");
        GOST3410PublicKeyParameterSetSpec r0 = r7.getParameters().getPublicKeyParameters();
        return new GOST3410PrivateKeyParameters(r7.getX(), new GOST3410Parameters(r0.getP(), r0.getQ(), r0.getA()));
    L7:
        throw new InvalidKeyException("can't identify GOST3410 private key.");
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey r5) {
        PublicKey r6 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r5, PublicKey.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, GOST3410PublicKey.class) == false) goto L7;
        GOST3410PublicKey r7 = (GOST3410PublicKey) ZeusTransformUtils.preCheckCast(r6, GOST3410PublicKey.class, "com.obric.memorydata.plugin");
        GOST3410PublicKeyParameterSetSpec r0 = r7.getParameters().getPublicKeyParameters();
        return new GOST3410PublicKeyParameters(r7.getY(), new GOST3410Parameters(r0.getP(), r0.getQ(), r0.getA()));
    L7:
        throw new InvalidKeyException("can't identify GOST3410 public key: " + r6.getClass().getName());
    }
}
