package org.bouncycastle.jcajce.provider.asymmetric.dh;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import org.bouncycastle.asn1.x9.DomainParameters;
import org.bouncycastle.asn1.x9.ValidationParams;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHValidationParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jcajce.spec.DHDomainParameterSpec;
import org.bouncycastle.jcajce.spec.DHExtendedPrivateKeySpec;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;

/* JADX INFO: loaded from: classes7.dex */
public class BCDHPrivateKey implements DHPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 311058815616901812L;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier;
    private transient DHPrivateKeyParameters dhPrivateKey;
    private transient DHParameterSpec dhSpec;
    private transient PrivateKeyInfo info;
    private BigInteger x;

    public BCDHPrivateKey() {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    BCDHPrivateKey(DHPrivateKey r3) {
        DHPrivateKey r4 = (DHPrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, DHPrivateKey.class, "com.obric.memorydata.plugin");
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r4.getX();
        this.dhSpec = r4.getParams();
    }

    BCDHPrivateKey(DHPrivateKeySpec r3) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r3.getX();
        if (ZeusTransformUtils.instanceOf(r3, DHExtendedPrivateKeySpec.class) == false) goto L5;
        this.dhSpec = ((DHExtendedPrivateKeySpec) ZeusTransformUtils.preCheckCast(r3, DHExtendedPrivateKeySpec.class, "com.obric.memorydata.plugin")).getParams();
        return;
    L5:
        this.dhSpec = new DHParameterSpec(r3.getP(), r3.getG());
    }

    public BCDHPrivateKey(PrivateKeyInfo r10) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        ASN1Sequence r0 = ASN1Sequence.getInstance(r10.getPrivateKeyAlgorithm().getParameters());
        ASN1Integer r1 = (ASN1Integer) ZeusTransformUtils.preCheckCast(r10.parsePrivateKey(), ASN1Integer.class, "com.obric.memorydata.plugin");
        ASN1ObjectIdentifier r2 = r10.getPrivateKeyAlgorithm().getAlgorithm();
        this.info = r10;
        this.x = r1.getValue();
        if (r2.equals(PKCSObjectIdentifiers.dhKeyAgreement) == false) goto L9;
        DHParameter r11 = DHParameter.getInstance(r0);
        if (r11.getL() == null) goto L7;
        this.dhSpec = new DHParameterSpec(r11.getP(), r11.getG(), r11.getL().intValue());
        DHPrivateKeyParameters r3 = new DHPrivateKeyParameters(this.x, new DHParameters(r11.getP(), r11.getG(), null, r11.getL().intValue()));
    L11:
        this.dhPrivateKey = r3;
        return;
    L7:
        this.dhSpec = new DHParameterSpec(r11.getP(), r11.getG());
        r3 = new DHPrivateKeyParameters(this.x, new DHParameters(r11.getP(), r11.getG()));
        goto L11
    L9:
        if (r2.equals(X9ObjectIdentifiers.dhpublicnumber) == false) goto L14;
        DomainParameters r12 = DomainParameters.getInstance(r0);
        this.dhSpec = new DHDomainParameterSpec(r12.getP(), r12.getQ(), r12.getG(), r12.getJ(), 0);
        r3 = new DHPrivateKeyParameters(this.x, new DHParameters(r12.getP(), r12.getG(), r12.getQ(), r12.getJ(), null));
        goto L11
    L14:
        throw new IllegalArgumentException("unknown algorithm type: " + r2);
    }

    BCDHPrivateKey(DHPrivateKeyParameters r2) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r2.getX();
        this.dhSpec = new DHDomainParameterSpec(r2.getParameters());
    }

    private void readObject(ObjectInputStream r6) {
        r6.defaultReadObject();
        this.dhSpec = new DHParameterSpec((BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), (BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), r6.readInt());
        this.info = null;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.defaultWriteObject();
        r2.writeObject(this.dhSpec.getP());
        r2.writeObject(this.dhSpec.getG());
        r2.writeInt(this.dhSpec.getL());
    }

    DHPrivateKeyParameters engineGetKeyParameters() {
        DHPrivateKeyParameters r0 = this.dhPrivateKey;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (ZeusTransformUtils.instanceOf(this.dhSpec, DHDomainParameterSpec.class) == false) goto L10;
        return new DHPrivateKeyParameters(this.x, ((DHDomainParameterSpec) ZeusTransformUtils.preCheckCast(this.dhSpec, DHDomainParameterSpec.class, "com.obric.memorydata.plugin")).getDomainParameters());
    L10:
        return new DHPrivateKeyParameters(this.x, new DHParameters(this.dhSpec.getP(), this.dhSpec.getG(), null, this.dhSpec.getL()));
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, DHPrivateKey.class) == true) goto L5;
        return false;
    L5:
        DHPrivateKey r5 = (DHPrivateKey) ZeusTransformUtils.preCheckCast(r4, DHPrivateKey.class, "com.obric.memorydata.plugin");
        if (getX().equals(r5.getX()) == true) goto L8;
        return false;
    L8:
        if (getParams().getG().equals(r5.getParams().getG()) == true) goto L10;
        return false;
    L10:
        if (getParams().getP().equals(r5.getParams().getP()) == true) goto L12;
        return false;
    L12:
        if (getParams().getL() != r5.getParams().getL()) goto L18;
        return true;
    L18:
        return false;
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
        PrivateKeyInfo r2 = this.info;     // Catch: Exception -> L20
        if (r2 == null) goto L9;
        return r2.getEncoded("DER");
    L9:
        if (ZeusTransformUtils.instanceOf(this.dhSpec, DHDomainParameterSpec.class) == true) goto L11;
    L17:
        PrivateKeyInfo r3 = new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL()).toASN1Primitive()), new ASN1Integer(getX()));     // Catch: Exception -> L20
    L19:
        return r3.getEncoded("DER");
    L11:
        if (((DHDomainParameterSpec) ZeusTransformUtils.preCheckCast(this.dhSpec, DHDomainParameterSpec.class, "com.obric.memorydata.plugin")).getQ() == null) goto L17;
        DHParameters r0 = ((DHDomainParameterSpec) ZeusTransformUtils.preCheckCast(this.dhSpec, DHDomainParameterSpec.class, "com.obric.memorydata.plugin")).getDomainParameters();     // Catch: Exception -> L20
        DHValidationParameters r4 = r0.getValidationParameters();     // Catch: Exception -> L20
        if (r4 == null) goto L15;
        ValidationParams r11 = new ValidationParams(r4.getSeed(), r4.getCounter());     // Catch: Exception -> L20
    L16:
        r3 = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.dhpublicnumber, new DomainParameters(r0.getP(), r0.getG(), r0.getQ(), r0.getJ(), r11).toASN1Primitive()), new ASN1Integer(getX()));     // Catch: Exception -> L20
        goto L19
    L15:
        r11 = null;
    L20:
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

    public int hashCode() {
        int r0 = (getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode();
        return getParams().getL() ^ r0;
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier r3, ASN1Encodable r4) {
        ASN1Encodable r5 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin");
        this.attrCarrier.setBagAttribute(r3, r5);
    }

    public String toString() {
        return DHUtil.privateKeyToString("DH", this.x, new DHParameters(this.dhSpec.getP(), this.dhSpec.getG()));
    }
}
