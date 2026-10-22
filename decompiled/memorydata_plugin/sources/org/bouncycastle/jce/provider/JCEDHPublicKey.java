package org.bouncycastle.jce.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.DHParameter;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.DHDomainParameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;

/* JADX INFO: loaded from: classes7.dex */
public class JCEDHPublicKey implements DHPublicKey {
    static final long serialVersionUID = -216691575254424324L;
    private DHParameterSpec dhSpec;
    private SubjectPublicKeyInfo info;
    private BigInteger y;

    JCEDHPublicKey(BigInteger r1, DHParameterSpec r2) {
        this.y = r1;
        this.dhSpec = r2;
    }

    JCEDHPublicKey(DHPublicKey r3) {
        DHPublicKey r4 = (DHPublicKey) ZeusTransformUtils.wrapperContextForParams(r3, DHPublicKey.class, "com.obric.memorydata.plugin");
        this.y = r4.getY();
        this.dhSpec = r4.getParams();
    }

    JCEDHPublicKey(DHPublicKeySpec r3) {
        this.y = r3.getY();
        this.dhSpec = new DHParameterSpec(r3.getP(), r3.getG());
    }

    JCEDHPublicKey(SubjectPublicKeyInfo r4) {
        this.info = r4;
        this.y = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r4.parsePublicKey(), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
        ASN1Sequence r0 = ASN1Sequence.getInstance(r4.getAlgorithmId().getParameters());
        ASN1ObjectIdentifier r5 = r4.getAlgorithmId().getAlgorithm();
        if (r5.equals(PKCSObjectIdentifiers.dhKeyAgreement) == false) goto L7;
    L15:
        DHParameter r6 = DHParameter.getInstance(r0);
        if (r6.getL() == null) goto L18;
        DHParameterSpec r1 = new DHParameterSpec(r6.getP(), r6.getG(), r6.getL().intValue());
    L12:
        this.dhSpec = r1;
        return;
    L18:
        r1 = new DHParameterSpec(r6.getP(), r6.getG());
        goto L12
    L7:
        if (isPKCSParam(r0) == true) goto L15;
        if (r5.equals(X9ObjectIdentifiers.dhpublicnumber) == false) goto L14;
        DHDomainParameters r7 = DHDomainParameters.getInstance(r0);
        r1 = new DHParameterSpec(r7.getP().getValue(), r7.getG().getValue());
        goto L12
    L14:
        throw new IllegalArgumentException("unknown algorithm type: " + r5);
    L21:
        throw new IllegalArgumentException("invalid info structure in DH public key");
    }

    JCEDHPublicKey(DHPublicKeyParameters r4) {
        this.y = r4.getY();
        this.dhSpec = new DHParameterSpec(r4.getParameters().getP(), r4.getParameters().getG(), r4.getParameters().getL());
    }

    private boolean isPKCSParam(ASN1Sequence r5) {
        if (r5.size() != 2) goto L6;
        return true;
    L6:
        if (r5.size() <= 3) goto L9;
        return false;
    L9:
        if (ASN1Integer.getInstance(r5.getObjectAt(2)).getValue().compareTo(BigInteger.valueOf(ASN1Integer.getInstance(r5.getObjectAt(0)).getValue().bitLength())) <= 0) goto L11;
        return false;
    L11:
        return true;
    }

    private void readObject(ObjectInputStream r6) {
        this.y = (BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin");
        this.dhSpec = new DHParameterSpec((BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), (BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), r6.readInt());
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.writeObject(getY());
        r2.writeObject(this.dhSpec.getP());
        r2.writeObject(this.dhSpec.getG());
        r2.writeInt(this.dhSpec.getL());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        SubjectPublicKeyInfo r0 = this.info;
        if (r0 == null) goto L7;
        return KeyUtil.getEncodedSubjectPublicKeyInfo(r0);
    L7:
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL())), new ASN1Integer(this.y));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return this.dhSpec;
    }

    @Override // javax.crypto.interfaces.DHPublicKey
    public BigInteger getY() {
        return this.y;
    }
}
