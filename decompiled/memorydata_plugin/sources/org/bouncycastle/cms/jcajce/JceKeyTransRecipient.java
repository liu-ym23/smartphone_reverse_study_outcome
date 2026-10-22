package org.bouncycastle.cms.jcajce;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.Gost2814789EncryptedKey;
import org.bouncycastle.asn1.cryptopro.GostR3410KeyTransport;
import org.bouncycastle.asn1.cryptopro.GostR3410TransportParameters;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.KeyTransRecipient;
import org.bouncycastle.jcajce.spec.GOST28147WrapParameterSpec;
import org.bouncycastle.jcajce.spec.UserKeyingMaterialSpec;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.jcajce.JceAsymmetricKeyUnwrapper;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JceKeyTransRecipient implements KeyTransRecipient {
    protected EnvelopedDataHelper contentHelper;
    protected Map extraMappings;
    protected EnvelopedDataHelper helper;
    private PrivateKey recipientKey;
    protected boolean unwrappedKeyMustBeEncodable;
    protected boolean validateKeySize;

    public JceKeyTransRecipient(PrivateKey r3) {
        PrivateKey r4 = (PrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, PrivateKey.class, "com.obric.memorydata.plugin");
        EnvelopedDataHelper r0 = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
        this.helper = r0;
        this.contentHelper = r0;
        this.extraMappings = new HashMap();
        this.validateKeySize = false;
        this.recipientKey = CMSUtils.cleanPrivateKey(r4);
    }

    public Key extractSecretKey(AlgorithmIdentifier r7, AlgorithmIdentifier r8, byte[] r9) {
        if (CMSUtils.isGOST(r7.getAlgorithm()) == true) goto L22;
        JceAsymmetricKeyUnwrapper r10 = this.helper.createAsymmetricUnwrapper(r7, this.recipientKey).setMustProduceEncodableUnwrappedKey(this.unwrappedKeyMustBeEncodable);
        if (this.extraMappings.isEmpty() == true) goto L24;
        Iterator r0 = this.extraMappings.keySet().iterator();
    L13:
        if (r0.hasNext() == false) goto L24;
        ASN1ObjectIdentifier r2 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r0.next(), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        r10.setAlgorithmMapping(r2, (String) ZeusTransformUtils.preCheckCast(this.extraMappings.get(r2), String.class, "com.obric.memorydata.plugin"));
    L24:
        Key r11 = this.helper.getJceKey(r8.getAlgorithm(), r10.generateUnwrappedKey(r8, r9));     // Catch: OperatorException -> L19
        if (this.validateKeySize == false) goto L18;
        this.helper.keySizeCheck(r8, r11);     // Catch: OperatorException -> L19
    L18:
        return r11;
    L19:
        e = move-exception;
        throw new CMSException("exception unwrapping key: " + e.getMessage(), e);
    L22:
        GostR3410KeyTransport r12 = GostR3410KeyTransport.getInstance(r9);     // Catch: Exception -> L6
        GostR3410TransportParameters r1 = r12.getTransportParameters();     // Catch: Exception -> L6
        PublicKey r3 = this.helper.createKeyFactory(r7.getAlgorithm()).generatePublic(new X509EncodedKeySpec(r1.getEphemeralPublicKey().getEncoded()));     // Catch: Exception -> L6
        KeyAgreement r13 = this.helper.createKeyAgreement(r7.getAlgorithm());     // Catch: Exception -> L6
        r13.init(this.recipientKey, new UserKeyingMaterialSpec(r1.getUkm()));     // Catch: Exception -> L6
        r13.doPhase(r3, true);     // Catch: Exception -> L6
        SecretKey r14 = r13.generateSecret(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_KeyWrap.getId());     // Catch: Exception -> L6
        Cipher r4 = this.helper.createCipher(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_KeyWrap);     // Catch: Exception -> L6
        r4.init(4, r14, new GOST28147WrapParameterSpec(r1.getEncryptionParamSet(), r1.getUkm()));     // Catch: Exception -> L6
        Gost2814789EncryptedKey r15 = r12.getSessionEncryptedKey();     // Catch: Exception -> L6
        return r4.unwrap(Arrays.concatenate(r15.getEncryptedKey(), r15.getMacKey()), this.helper.getBaseCipherName(r8.getAlgorithm()), 3);
    L6:
        e = move-exception;
        throw new CMSException("exception unwrapping key: " + e.getMessage(), e);
    }
}
