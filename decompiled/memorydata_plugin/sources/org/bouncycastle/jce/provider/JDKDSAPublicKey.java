package org.bouncycastle.jce.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class JDKDSAPublicKey implements DSAPublicKey {
    private static final long serialVersionUID = 1752452449903495175L;
    private DSAParams dsaSpec;
    private BigInteger y;

    JDKDSAPublicKey(BigInteger r1, DSAParameterSpec r2) {
        this.y = r1;
        this.dsaSpec = r2;
    }

    JDKDSAPublicKey(DSAPublicKey r3) {
        DSAPublicKey r4 = (DSAPublicKey) ZeusTransformUtils.wrapperContextForParams(r3, DSAPublicKey.class, "com.obric.memorydata.plugin");
        this.y = r4.getY();
        this.dsaSpec = r4.getParams();
    }

    JDKDSAPublicKey(DSAPublicKeySpec r4) {
        this.y = r4.getY();
        this.dsaSpec = new DSAParameterSpec(r4.getP(), r4.getQ(), r4.getG());
    }

    JDKDSAPublicKey(SubjectPublicKeyInfo r4) {
        this.y = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r4.parsePublicKey(), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
        if (isNotNull(r4.getAlgorithm().getParameters()) == false) goto L12;
        DSAParameter r5 = DSAParameter.getInstance(r4.getAlgorithm().getParameters());
        this.dsaSpec = new DSAParameterSpec(r5.getP(), r5.getQ(), r5.getG());
        return;
    L12:
        return;
    L9:
        throw new IllegalArgumentException("invalid info structure in DSA public key");
    }

    JDKDSAPublicKey(DSAPublicKeyParameters r4) {
        this.y = r4.getY();
        this.dsaSpec = new DSAParameterSpec(r4.getParameters().getP(), r4.getParameters().getQ(), r4.getParameters().getG());
    }

    private boolean isNotNull(ASN1Encodable r2) {
        ASN1Encodable r1 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r2, ASN1Encodable.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (DERNull.INSTANCE.equals(r1) == true) goto L7;
        return true;
    }

    private void readObject(ObjectInputStream r6) {
        this.y = (BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin");
        this.dsaSpec = new DSAParameterSpec((BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), (BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), (BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin"));
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.writeObject(this.y);
        r2.writeObject(this.dsaSpec.getP());
        r2.writeObject(this.dsaSpec.getQ());
        r2.writeObject(this.dsaSpec.getG());
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, DSAPublicKey.class) == true) goto L5;
        return false;
    L5:
        DSAPublicKey r5 = (DSAPublicKey) ZeusTransformUtils.preCheckCast(r4, DSAPublicKey.class, "com.obric.memorydata.plugin");
        if (getY().equals(r5.getY()) == true) goto L8;
        return false;
    L8:
        if (getParams().getG().equals(r5.getParams().getG()) == true) goto L10;
        return false;
    L10:
        if (getParams().getP().equals(r5.getParams().getP()) == true) goto L12;
        return false;
    L12:
        if (getParams().getQ().equals(r5.getParams().getQ()) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
    L9:
        return null;
    L4:
        if (this.dsaSpec != null) goto L8;
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa), new ASN1Integer(this.y)).getEncoded("DER");
    L8:
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(this.dsaSpec.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG())), new ASN1Integer(this.y)).getEncoded("DER");
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // java.security.interfaces.DSAKey
    public DSAParams getParams() {
        return this.dsaSpec;
    }

    @Override // java.security.interfaces.DSAPublicKey
    public BigInteger getY() {
        return this.y;
    }

    public int hashCode() {
        int r0 = (getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode();
        return getParams().getQ().hashCode() ^ r0;
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        r0.append("DSA Public Key").append(r1);
        r0.append("            y: ").append(getY().toString(16)).append(r1);
        return r0.toString();
    }
}
