package org.bouncycastle.jcajce.provider.asymmetric.gost;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.GOST3410Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.GOST3410Params;
import org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import org.bouncycastle.jce.spec.GOST3410PrivateKeySpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

/* JADX INFO: loaded from: classes7.dex */
public class BCGOST3410PrivateKey implements GOST3410PrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 8581661527592305464L;
    private transient PKCS12BagAttributeCarrier attrCarrier;
    private transient GOST3410Params gost3410Spec;
    private BigInteger x;

    public BCGOST3410PrivateKey() {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    BCGOST3410PrivateKey(PrivateKeyInfo r6) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        GOST3410PublicKeyAlgParameters r0 = GOST3410PublicKeyAlgParameters.getInstance(r6.getPrivateKeyAlgorithm().getParameters());
        ASN1Encodable r1 = r6.parsePrivateKey();
        if (ZeusTransformUtils.instanceOf(r1, ASN1Integer.class) == false) goto L6;
        BigInteger r7 = ASN1Integer.getInstance(r1).getPositiveValue();
    L5:
        this.x = r7;
        this.gost3410Spec = GOST3410ParameterSpec.fromPublicKeyAlg(r0);
        return;
    L6:
        byte[] r8 = ASN1OctetString.getInstance(r6.parsePrivateKey()).getOctets();
        byte[] r2 = new byte[r8.length];
        int r3 = 0;
    L8:
        if (r3 == r8.length) goto L10;
        r2[r3] = r8[(r8.length - 1) - r3];
        r3 = r3 + 1;
        goto L8
    L10:
        r7 = new BigInteger(1, r2);
        goto L5
    }

    BCGOST3410PrivateKey(GOST3410PrivateKeyParameters r2, GOST3410ParameterSpec r3) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r2.getX();
        this.gost3410Spec = r3;
        if (r3 == null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("spec is null");
    }

    BCGOST3410PrivateKey(GOST3410PrivateKey r3) {
        GOST3410PrivateKey r4 = (GOST3410PrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, GOST3410PrivateKey.class, "com.obric.memorydata.plugin");
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r4.getX();
        this.gost3410Spec = r4.getParameters();
    }

    BCGOST3410PrivateKey(GOST3410PrivateKeySpec r5) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r5.getX();
        this.gost3410Spec = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(r5.getP(), r5.getQ(), r5.getA()));
    }

    private boolean compareObj(Object r1, Object r2) {
        if (r1 != r2) goto L5;
        return true;
    L5:
        if (r1 != null) goto L9;
        return false;
    L9:
        return r1.equals(r2);
    }

    private void readObject(ObjectInputStream r8) {
        r8.defaultReadObject();
        String r0 = (String) ZeusTransformUtils.preCheckCast(r8.readObject(), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        this.gost3410Spec = new GOST3410ParameterSpec(r0, (String) ZeusTransformUtils.preCheckCast(r8.readObject(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r8.readObject(), String.class, "com.obric.memorydata.plugin"));
    L6:
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        return;
    L5:
        this.gost3410Spec = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec((BigInteger) ZeusTransformUtils.preCheckCast(r8.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), (BigInteger) ZeusTransformUtils.preCheckCast(r8.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), (BigInteger) ZeusTransformUtils.preCheckCast(r8.readObject(), BigInteger.class, "com.obric.memorydata.plugin")));
        r8.readObject();
        r8.readObject();
        goto L6
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
        if (ZeusTransformUtils.instanceOf(r4, GOST3410PrivateKey.class) == true) goto L5;
        return false;
    L5:
        GOST3410PrivateKey r5 = (GOST3410PrivateKey) ZeusTransformUtils.preCheckCast(r4, GOST3410PrivateKey.class, "com.obric.memorydata.plugin");
        if (getX().equals(r5.getX()) == true) goto L8;
        return false;
    L8:
        if (getParameters().getPublicKeyParameters().equals(r5.getParameters().getPublicKeyParameters()) == true) goto L10;
        return false;
    L10:
        if (getParameters().getDigestParamSetOID().equals(r5.getParameters().getDigestParamSetOID()) == true) goto L12;
        return false;
    L12:
        if (compareObj(getParameters().getEncryptionParamSetOID(), r5.getParameters().getEncryptionParamSetOID()) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "GOST3410";
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier r1) {
        return this.attrCarrier.getBagAttribute(r1);
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        byte[] r0 = getX().toByteArray();
        int r1 = 0;
        if (r0[0] != 0) goto L5;
        int r2 = r0.length - 1;
    L6:
        byte[] r3 = new byte[r2];
    L8:
        if (r1 == r3.length) goto L18;
        r3[r1] = r0[(r0.length - 1) - r1];
        r1 = r1 + 1;
        goto L8
    L18:
    L16:
        return null;
    L11:
        if (ZeusTransformUtils.instanceOf(this.gost3410Spec, GOST3410ParameterSpec.class) == false) goto L13;
        PrivateKeyInfo r4 = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94, new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(this.gost3410Spec.getPublicKeyParamSetOID()), new ASN1ObjectIdentifier(this.gost3410Spec.getDigestParamSetOID()))), new DEROctetString(r3));     // Catch: IOException -> L16
    L14:
        return r4.getEncoded("DER");
    L13:
        r4 = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94), new DEROctetString(r3));     // Catch: IOException -> L16
        goto L14
    L5:
        r2 = r0.length;
        goto L6
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410Key
    public GOST3410Params getParameters() {
        return this.gost3410Spec;
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410PrivateKey
    public BigInteger getX() {
        return this.x;
    }

    public int hashCode() {
        int r0 = getX().hashCode();
        return this.gost3410Spec.hashCode() ^ r0;
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier r3, ASN1Encodable r4) {
        ASN1Encodable r5 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin");
        this.attrCarrier.setBagAttribute(r3, r5);
    }

    public String toString() {
        return GOSTUtil.privateKeyToString("GOST3410", this.x, ((GOST3410PrivateKeyParameters) ZeusTransformUtils.preCheckCast(GOST3410Util.generatePrivateKeyParameter(this), GOST3410PrivateKeyParameters.class, "com.obric.memorydata.plugin")).getParameters());
    L4:
        e = move-exception;
        throw new IllegalStateException(e.getMessage());
    }
}
