package org.bouncycastle.operator.jcajce;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.operator.AsymmetricKeyUnwrapper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;

/* JADX INFO: loaded from: classes7.dex */
public class JceAsymmetricKeyUnwrapper extends AsymmetricKeyUnwrapper {
    private Map extraMappings;
    private OperatorHelper helper;
    private PrivateKey privKey;
    private boolean unwrappedKeyMustBeEncodable;

    public JceAsymmetricKeyUnwrapper(AlgorithmIdentifier r3, PrivateKey r4) {
        PrivateKey r5 = (PrivateKey) ZeusTransformUtils.wrapperContextForParams(r4, PrivateKey.class, "com.obric.memorydata.plugin");
        super(r3);
        this.helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.extraMappings = new HashMap();
        this.privKey = r5;
    }

    public GenericKey generateUnwrappedKey(AlgorithmIdentifier r6, byte[] r7) {
        Cipher r0 = this.helper.createAsymmetricWrapper(getAlgorithmIdentifier().getAlgorithm(), this.extraMappings);     // Catch: InvalidAlgorithmParameterException -> L24 BadPaddingException -> L27 IllegalBlockSizeException -> L30 InvalidKeyException -> L33
        AlgorithmParameters r1 = this.helper.createAlgorithmParameters(getAlgorithmIdentifier());     // Catch: InvalidAlgorithmParameterException -> L24 BadPaddingException -> L27 IllegalBlockSizeException -> L30 InvalidKeyException -> L33
        Key r3 = null;
        if (r1 == null) goto L6;
        r0.init(4, this.privKey, r1);     // Catch: Throwable -> L37 InvalidAlgorithmParameterException -> L24 BadPaddingException -> L27 IllegalBlockSizeException -> L30 InvalidKeyException -> L33
    L7:
        Key r2 = r0.unwrap(r7, this.helper.getKeyAlgorithmName(r6.getAlgorithm()), 3);     // Catch: Throwable -> L37 InvalidAlgorithmParameterException -> L24 BadPaddingException -> L27 IllegalBlockSizeException -> L30 InvalidKeyException -> L33
        if (this.unwrappedKeyMustBeEncodable == false) goto L15;
        byte[] r4 = r2.getEncoded();     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 InvalidAlgorithmParameterException -> L24 BadPaddingException -> L27 IllegalBlockSizeException -> L30 InvalidKeyException -> L33
        if (r4 == null) goto L16;
        if (r4.length == 0) goto L16;
    L15:
        r3 = r2;
        goto L16
    L6:
        r0.init(4, this.privKey);     // Catch: Throwable -> L37 InvalidAlgorithmParameterException -> L24 BadPaddingException -> L27 IllegalBlockSizeException -> L30 InvalidKeyException -> L33
    L16:
        if (r3 == null) goto L18;
    L22:
        return new JceGenericKey(r6, r3);
    L18:
        if (r1 == null) goto L20;
        r0.init(2, this.privKey, r1);     // Catch: InvalidAlgorithmParameterException -> L24 BadPaddingException -> L27 IllegalBlockSizeException -> L30 InvalidKeyException -> L33
    L21:
        r3 = new SecretKeySpec(r0.doFinal(r7), r6.getAlgorithm().getId());     // Catch: InvalidAlgorithmParameterException -> L24 BadPaddingException -> L27 IllegalBlockSizeException -> L30 InvalidKeyException -> L33
        goto L22
    L20:
        r0.init(2, this.privKey);     // Catch: InvalidAlgorithmParameterException -> L24 BadPaddingException -> L27 IllegalBlockSizeException -> L30 InvalidKeyException -> L33
    L24:
        e = move-exception;
        throw new OperatorException("invalid algorithm parameters: " + e.getMessage(), e);
    L33:
        e = move-exception;
        throw new OperatorException("key invalid: " + e.getMessage(), e);
    L27:
        e = move-exception;
        throw new OperatorException("bad padding: " + e.getMessage(), e);
    L30:
        e = move-exception;
        throw new OperatorException("illegal blocksize: " + e.getMessage(), e);
    }

    public JceAsymmetricKeyUnwrapper setAlgorithmMapping(ASN1ObjectIdentifier r2, String r3) {
        this.extraMappings.put(r2, r3);
        return this;
    }

    public JceAsymmetricKeyUnwrapper setMustProduceEncodableUnwrappedKey(boolean r1) {
        this.unwrappedKeyMustBeEncodable = r1;
        return this;
    }
}
