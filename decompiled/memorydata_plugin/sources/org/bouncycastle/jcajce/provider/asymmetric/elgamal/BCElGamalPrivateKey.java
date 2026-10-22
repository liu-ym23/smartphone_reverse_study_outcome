package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

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
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;
import org.bouncycastle.jce.spec.ElGamalPrivateKeySpec;

/* JADX INFO: loaded from: classes7.dex */
public class BCElGamalPrivateKey implements DHPrivateKey, ElGamalPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 4819350091141529678L;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier;
    private transient ElGamalParameterSpec elSpec;
    private BigInteger x;

    public BCElGamalPrivateKey() {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    BCElGamalPrivateKey(DHPrivateKey r3) {
        DHPrivateKey r4 = (DHPrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, DHPrivateKey.class, "com.obric.memorydata.plugin");
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r4.getX();
        this.elSpec = new ElGamalParameterSpec(r4.getParams().getP(), r4.getParams().getG());
    }

    BCElGamalPrivateKey(DHPrivateKeySpec r3) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r3.getX();
        this.elSpec = new ElGamalParameterSpec(r3.getP(), r3.getG());
    }

    BCElGamalPrivateKey(PrivateKeyInfo r3) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        ElGamalParameter r0 = ElGamalParameter.getInstance(r3.getPrivateKeyAlgorithm().getParameters());
        this.x = ASN1Integer.getInstance(r3.parsePrivateKey()).getValue();
        this.elSpec = new ElGamalParameterSpec(r0.getP(), r0.getG());
    }

    BCElGamalPrivateKey(ElGamalPrivateKeyParameters r3) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r3.getX();
        this.elSpec = new ElGamalParameterSpec(r3.getParameters().getP(), r3.getParameters().getG());
    }

    BCElGamalPrivateKey(ElGamalPrivateKey r3) {
        ElGamalPrivateKey r4 = (ElGamalPrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, ElGamalPrivateKey.class, "com.obric.memorydata.plugin");
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r4.getX();
        this.elSpec = r4.getParameters();
    }

    BCElGamalPrivateKey(ElGamalPrivateKeySpec r3) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r3.getX();
        this.elSpec = new ElGamalParameterSpec(r3.getParams().getP(), r3.getParams().getG());
    }

    private void readObject(ObjectInputStream r5) {
        r5.defaultReadObject();
        this.elSpec = new ElGamalParameterSpec((BigInteger) ZeusTransformUtils.preCheckCast(r5.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), (BigInteger) ZeusTransformUtils.preCheckCast(r5.readObject(), BigInteger.class, "com.obric.memorydata.plugin"));
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.defaultWriteObject();
        r2.writeObject(this.elSpec.getP());
        r2.writeObject(this.elSpec.getG());
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
        return "ElGamal";
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
        return new PrivateKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalParameter(this.elSpec.getP(), this.elSpec.getG())), new ASN1Integer(getX())).getEncoded("DER");
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.jce.interfaces.ElGamalKey
    public ElGamalParameterSpec getParameters() {
        return this.elSpec;
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.elSpec.getP(), this.elSpec.getG());
    }

    @Override // javax.crypto.interfaces.DHPrivateKey, org.bouncycastle.jce.interfaces.ElGamalPrivateKey
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
}
