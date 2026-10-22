package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class BCRSAPublicKey implements RSAPublicKey {
    static final AlgorithmIdentifier DEFAULT_ALGORITHM_IDENTIFIER = null;
    static final long serialVersionUID = 2675817738516720772L;
    private transient AlgorithmIdentifier algorithmIdentifier;
    private BigInteger modulus;
    private BigInteger publicExponent;
    private transient RSAKeyParameters rsaPublicKey;

    static {
        DEFAULT_ALGORITHM_IDENTIFIER = new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE);
    }

    BCRSAPublicKey(RSAPublicKey r4) {
        RSAPublicKey r5 = (RSAPublicKey) ZeusTransformUtils.wrapperContextForParams(r4, RSAPublicKey.class, "com.obric.memorydata.plugin");
        this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
        this.modulus = r5.getModulus();
        this.publicExponent = r5.getPublicExponent();
        this.rsaPublicKey = new RSAKeyParameters(false, this.modulus, this.publicExponent);
    }

    BCRSAPublicKey(RSAPublicKeySpec r4) {
        this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
        this.modulus = r4.getModulus();
        this.publicExponent = r4.getPublicExponent();
        this.rsaPublicKey = new RSAKeyParameters(false, this.modulus, this.publicExponent);
    }

    BCRSAPublicKey(AlgorithmIdentifier r1, RSAKeyParameters r2) {
        this.algorithmIdentifier = r1;
        this.modulus = r2.getModulus();
        this.publicExponent = r2.getExponent();
        this.rsaPublicKey = r2;
    }

    BCRSAPublicKey(SubjectPublicKeyInfo r1) {
        populateFromPublicKeyInfo(r1);
    }

    BCRSAPublicKey(RSAKeyParameters r2) {
        this(DEFAULT_ALGORITHM_IDENTIFIER, r2);
    }

    private void populateFromPublicKeyInfo(SubjectPublicKeyInfo r4) {
        org.bouncycastle.asn1.pkcs.RSAPublicKey r0 = org.bouncycastle.asn1.pkcs.RSAPublicKey.getInstance(r4.parsePublicKey());     // Catch: IOException -> L4
        this.algorithmIdentifier = r4.getAlgorithm();     // Catch: IOException -> L4
        this.modulus = r0.getModulus();     // Catch: IOException -> L4
        this.publicExponent = r0.getPublicExponent();     // Catch: IOException -> L4
        this.rsaPublicKey = new RSAKeyParameters(false, this.modulus, this.publicExponent);     // Catch: IOException -> L4
        return;
    L5:
        throw new IllegalArgumentException("invalid info structure in RSA public key");
    }

    private void readObject(ObjectInputStream r4) {
        r4.defaultReadObject();
        this.algorithmIdentifier = AlgorithmIdentifier.getInstance(r4.readObject());     // Catch: Exception -> L5
    L6:
        this.rsaPublicKey = new RSAKeyParameters(false, this.modulus, this.publicExponent);
        return;
    L5:
        this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
        goto L6
    }

    private void writeObject(ObjectOutputStream r3) {
        r3.defaultWriteObject();
        if (this.algorithmIdentifier.equals(DEFAULT_ALGORITHM_IDENTIFIER) == true) goto L6;
        r3.writeObject(this.algorithmIdentifier.getEncoded());
        return;
    }

    RSAKeyParameters engineGetKeyParameters() {
        return this.rsaPublicKey;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RSAPublicKey.class) == true) goto L8;
        return false;
    L8:
        RSAPublicKey r6 = (RSAPublicKey) ZeusTransformUtils.preCheckCast(r5, RSAPublicKey.class, "com.obric.memorydata.plugin");
        if (getModulus().equals(r6.getModulus()) == false) goto L14;
        if (getPublicExponent().equals(r6.getPublicExponent()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        if (this.algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS) == false) goto L6;
        return "RSASSA-PSS";
    L6:
        return "RSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return KeyUtil.getEncodedSubjectPublicKeyInfo(this.algorithmIdentifier, new org.bouncycastle.asn1.pkcs.RSAPublicKey(getModulus(), getPublicExponent()));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // java.security.interfaces.RSAKey
    public BigInteger getModulus() {
        return this.modulus;
    }

    @Override // java.security.interfaces.RSAPublicKey
    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public int hashCode() {
        int r0 = getModulus().hashCode();
        return getPublicExponent().hashCode() ^ r0;
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        r0.append("RSA Public Key [").append(RSAUtil.generateKeyFingerprint(getModulus())).append("]").append(",[").append(RSAUtil.generateExponentFingerprint(getPublicExponent())).append("]").append(r1);
        r0.append("        modulus: ").append(getModulus().toString(16)).append(r1);
        r0.append("public exponent: ").append(getPublicExponent().toString(16)).append(r1);
        return r0.toString();
    }
}
