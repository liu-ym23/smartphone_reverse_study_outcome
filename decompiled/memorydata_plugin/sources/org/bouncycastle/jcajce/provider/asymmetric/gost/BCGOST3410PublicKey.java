package org.bouncycastle.jcajce.provider.asymmetric.gost;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.GOST3410PublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.GOST3410Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jce.interfaces.GOST3410Params;
import org.bouncycastle.jce.interfaces.GOST3410PublicKey;
import org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeySpec;

/* JADX INFO: loaded from: classes7.dex */
public class BCGOST3410PublicKey implements GOST3410PublicKey {
    static final long serialVersionUID = -6251023343619275990L;
    private transient GOST3410Params gost3410Spec;
    private BigInteger y;

    BCGOST3410PublicKey(BigInteger r1, GOST3410ParameterSpec r2) {
        this.y = r1;
        this.gost3410Spec = r2;
    }

    BCGOST3410PublicKey(SubjectPublicKeyInfo r6) {
        GOST3410PublicKeyAlgParameters r0 = GOST3410PublicKeyAlgParameters.getInstance(r6.getAlgorithm().getParameters());
        byte[] r7 = ((DEROctetString) ZeusTransformUtils.preCheckCast(r6.parsePublicKey(), DEROctetString.class, "com.obric.memorydata.plugin")).getOctets();     // Catch: IOException -> L10
        byte[] r1 = new byte[r7.length];     // Catch: IOException -> L10
        int r2 = 0;
    L5:
        if (r2 == r7.length) goto L7;
        r1[r2] = r7[(r7.length - 1) - r2];     // Catch: IOException -> L10
        r2 = r2 + 1;     // Catch: IOException -> L10
        goto L5
    L7:
        this.y = new BigInteger(1, r1);     // Catch: IOException -> L10
        this.gost3410Spec = GOST3410ParameterSpec.fromPublicKeyAlg(r0);
        return;
    L11:
        throw new IllegalArgumentException("invalid info structure in GOST3410 public key");
    }

    BCGOST3410PublicKey(GOST3410PublicKeyParameters r1, GOST3410ParameterSpec r2) {
        this.y = r1.getY();
        this.gost3410Spec = r2;
    }

    BCGOST3410PublicKey(GOST3410PublicKey r3) {
        GOST3410PublicKey r4 = (GOST3410PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, GOST3410PublicKey.class, "com.obric.memorydata.plugin");
        this.y = r4.getY();
        this.gost3410Spec = r4.getParameters();
    }

    BCGOST3410PublicKey(GOST3410PublicKeySpec r5) {
        this.y = r5.getY();
        this.gost3410Spec = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(r5.getP(), r5.getQ(), r5.getA()));
    }

    private void readObject(ObjectInputStream r8) {
        r8.defaultReadObject();
        String r0 = (String) ZeusTransformUtils.preCheckCast(r8.readObject(), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        this.gost3410Spec = new GOST3410ParameterSpec(r0, (String) ZeusTransformUtils.preCheckCast(r8.readObject(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r8.readObject(), String.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        this.gost3410Spec = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec((BigInteger) ZeusTransformUtils.preCheckCast(r8.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), (BigInteger) ZeusTransformUtils.preCheckCast(r8.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), (BigInteger) ZeusTransformUtils.preCheckCast(r8.readObject(), BigInteger.class, "com.obric.memorydata.plugin")));
        r8.readObject();
        r8.readObject();
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.defaultWriteObject();
        if (this.gost3410Spec.getPublicKeyParamSetOID() == null) goto L5;
        Object r0 = this.gost3410Spec.getPublicKeyParamSetOID();
    L6:
        r2.writeObject(r0);
        r2.writeObject(this.gost3410Spec.getDigestParamSetOID());
        r2.writeObject(this.gost3410Spec.getEncryptionParamSetOID());
        return;
    L5:
        r2.writeObject(null);
        r2.writeObject(this.gost3410Spec.getPublicKeyParameters().getP());
        r2.writeObject(this.gost3410Spec.getPublicKeyParameters().getQ());
        r0 = this.gost3410Spec.getPublicKeyParameters().getA();
        goto L6
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, BCGOST3410PublicKey.class) == false) goto L10;
        BCGOST3410PublicKey r5 = (BCGOST3410PublicKey) ZeusTransformUtils.preCheckCast(r4, BCGOST3410PublicKey.class, "com.obric.memorydata.plugin");
        if (this.y.equals(r5.y) == true) goto L7;
        return false;
    L7:
        if (this.gost3410Spec.equals(r5.gost3410Spec) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "GOST3410";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        byte[] r0 = getY().toByteArray();
        int r1 = 0;
        if (r0[0] != 0) goto L5;
        int r2 = r0.length - 1;
    L6:
        byte[] r3 = new byte[r2];
    L8:
        if (r1 == r3.length) goto L21;
        r3[r1] = r0[(r0.length - 1) - r1];
        r1 = r1 + 1;
        goto L8
    L21:
    L19:
        return null;
    L11:
        if (ZeusTransformUtils.instanceOf(this.gost3410Spec, GOST3410ParameterSpec.class) == true) goto L13;
        SubjectPublicKeyInfo r4 = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94), new DEROctetString(r3));     // Catch: IOException -> L19
    L17:
        return KeyUtil.getEncodedSubjectPublicKeyInfo(r4);
    L13:
        if (this.gost3410Spec.getEncryptionParamSetOID() == null) goto L15;
        r4 = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94, new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(this.gost3410Spec.getPublicKeyParamSetOID()), new ASN1ObjectIdentifier(this.gost3410Spec.getDigestParamSetOID()), new ASN1ObjectIdentifier(this.gost3410Spec.getEncryptionParamSetOID()))), new DEROctetString(r3));     // Catch: IOException -> L19
        goto L17
    L15:
        r4 = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94, new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(this.gost3410Spec.getPublicKeyParamSetOID()), new ASN1ObjectIdentifier(this.gost3410Spec.getDigestParamSetOID()))), new DEROctetString(r3));     // Catch: IOException -> L19
        goto L17
    L5:
        r2 = r0.length;
        goto L6
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410Key
    public GOST3410Params getParameters() {
        return this.gost3410Spec;
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410PublicKey
    public BigInteger getY() {
        return this.y;
    }

    public int hashCode() {
        int r0 = this.y.hashCode();
        return this.gost3410Spec.hashCode() ^ r0;
    }

    public String toString() {
        return GOSTUtil.publicKeyToString("GOST3410", this.y, ((GOST3410PublicKeyParameters) ZeusTransformUtils.preCheckCast(GOST3410Util.generatePublicKeyParameter(this), GOST3410PublicKeyParameters.class, "com.obric.memorydata.plugin")).getParameters());
    L4:
        e = move-exception;
        throw new IllegalStateException(e.getMessage());
    }
}
