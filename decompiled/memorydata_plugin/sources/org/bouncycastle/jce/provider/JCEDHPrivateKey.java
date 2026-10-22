package org.bouncycastle.jce.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.DHParameter;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.DHDomainParameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;

/* JADX INFO: loaded from: classes7.dex */
public class JCEDHPrivateKey implements DHPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 311058815616901812L;
    private PKCS12BagAttributeCarrier attrCarrier;
    private DHParameterSpec dhSpec;
    private PrivateKeyInfo info;
    BigInteger x;

    public JCEDHPrivateKey() {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    JCEDHPrivateKey(DHPrivateKey r3) {
        DHPrivateKey r4 = (DHPrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, DHPrivateKey.class, "com.obric.memorydata.plugin");
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r4.getX();
        this.dhSpec = r4.getParams();
    }

    JCEDHPrivateKey(DHPrivateKeySpec r3) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r3.getX();
        this.dhSpec = new DHParameterSpec(r3.getP(), r3.getG());
    }

    JCEDHPrivateKey(PrivateKeyInfo r4) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        ASN1Sequence r0 = ASN1Sequence.getInstance(r4.getPrivateKeyAlgorithm().getParameters());
        ASN1Integer r1 = ASN1Integer.getInstance(r4.parsePrivateKey());
        ASN1ObjectIdentifier r2 = r4.getPrivateKeyAlgorithm().getAlgorithm();
        this.info = r4;
        this.x = r1.getValue();
        if (r2.equals(PKCSObjectIdentifiers.dhKeyAgreement) == false) goto L9;
        DHParameter r5 = DHParameter.getInstance(r0);
        if (r5.getL() == null) goto L7;
        DHParameterSpec r3 = new DHParameterSpec(r5.getP(), r5.getG(), r5.getL().intValue());
    L11:
        this.dhSpec = r3;
        return;
    L7:
        r3 = new DHParameterSpec(r5.getP(), r5.getG());
        goto L11
    L9:
        if (r2.equals(X9ObjectIdentifiers.dhpublicnumber) == false) goto L14;
        DHDomainParameters r6 = DHDomainParameters.getInstance(r0);
        r3 = new DHParameterSpec(r6.getP().getValue(), r6.getG().getValue());
        goto L11
    L14:
        throw new IllegalArgumentException("unknown algorithm type: " + r2);
    }

    JCEDHPrivateKey(DHPrivateKeyParameters r4) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r4.getX();
        this.dhSpec = new DHParameterSpec(r4.getParameters().getP(), r4.getParameters().getG(), r4.getParameters().getL());
    }

    private void readObject(ObjectInputStream r6) {
        this.x = (BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin");
        this.dhSpec = new DHParameterSpec((BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), (BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), r6.readInt());
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.writeObject(getX());
        r2.writeObject(this.dhSpec.getP());
        r2.writeObject(this.dhSpec.getG());
        r2.writeInt(this.dhSpec.getL());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DH";
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
        PrivateKeyInfo r0 = this.info;     // Catch: IOException -> L9
        if (r0 == null) goto L8;
        return r0.getEncoded("DER");
    L8:
        return new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL())), new ASN1Integer(getX())).getEncoded("DER");
    L9:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return this.dhSpec;
    }

    @Override // javax.crypto.interfaces.DHPrivateKey
    public BigInteger getX() {
        return this.x;
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier r3, ASN1Encodable r4) {
        ASN1Encodable r5 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin");
        this.attrCarrier.setBagAttribute(r3, r5);
    }
}
