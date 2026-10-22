package org.bouncycastle.jcajce.provider.asymmetric.dh;

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
import org.bouncycastle.asn1.x9.DomainParameters;
import org.bouncycastle.asn1.x9.ValidationParams;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.DHValidationParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.spec.DHDomainParameterSpec;
import org.bouncycastle.jcajce.spec.DHExtendedPublicKeySpec;

/* JADX INFO: loaded from: classes7.dex */
public class BCDHPublicKey implements DHPublicKey {
    static final long serialVersionUID = -216691575254424324L;
    private transient DHPublicKeyParameters dhPublicKey;
    private transient DHParameterSpec dhSpec;
    private transient SubjectPublicKeyInfo info;
    private BigInteger y;

    BCDHPublicKey(BigInteger r4, DHParameterSpec r5) {
        this.y = r4;
        this.dhSpec = r5;
        if (ZeusTransformUtils.instanceOf(r5, DHDomainParameterSpec.class) == false) goto L5;
        DHPublicKeyParameters r0 = new DHPublicKeyParameters(r4, ((DHDomainParameterSpec) ZeusTransformUtils.preCheckCast(r5, DHDomainParameterSpec.class, "com.obric.memorydata.plugin")).getDomainParameters());
    L6:
        this.dhPublicKey = r0;
        return;
    L5:
        r0 = new DHPublicKeyParameters(r4, new DHParameters(r5.getP(), r5.getG()));
        goto L6
    }

    BCDHPublicKey(DHPublicKey r5) {
        DHPublicKey r6 = (DHPublicKey) ZeusTransformUtils.wrapperContextForParams(r5, DHPublicKey.class, "com.obric.memorydata.plugin");
        this.y = r6.getY();
        DHParameterSpec r7 = r6.getParams();
        this.dhSpec = r7;
        if (ZeusTransformUtils.instanceOf(r7, DHDomainParameterSpec.class) == false) goto L5;
        DHDomainParameterSpec r8 = (DHDomainParameterSpec) ZeusTransformUtils.preCheckCast(this.dhSpec, DHDomainParameterSpec.class, "com.obric.memorydata.plugin");
        this.dhPublicKey = new DHPublicKeyParameters(this.y, r8.getDomainParameters());
        return;
    L5:
        this.dhPublicKey = new DHPublicKeyParameters(this.y, new DHParameters(this.dhSpec.getP(), this.dhSpec.getG()));
    }

    BCDHPublicKey(DHPublicKeySpec r5) {
        this.y = r5.getY();
        if (ZeusTransformUtils.instanceOf(r5, DHExtendedPublicKeySpec.class) == false) goto L5;
        DHParameterSpec r0 = ((DHExtendedPublicKeySpec) ZeusTransformUtils.preCheckCast(r5, DHExtendedPublicKeySpec.class, "com.obric.memorydata.plugin")).getParams();
    L6:
        this.dhSpec = r0;
        if (ZeusTransformUtils.instanceOf(this.dhSpec, DHDomainParameterSpec.class) == false) goto L9;
        DHDomainParameterSpec r6 = (DHDomainParameterSpec) ZeusTransformUtils.preCheckCast(this.dhSpec, DHDomainParameterSpec.class, "com.obric.memorydata.plugin");
        DHPublicKeyParameters r1 = new DHPublicKeyParameters(this.y, r6.getDomainParameters());
    L10:
        this.dhPublicKey = r1;
        return;
    L9:
        r1 = new DHPublicKeyParameters(this.y, new DHParameters(r5.getP(), r5.getG()));
        goto L10
    L5:
        r0 = new DHParameterSpec(r5.getP(), r5.getG());
        goto L6
    }

    public BCDHPublicKey(SubjectPublicKeyInfo r11) {
        this.info = r11;
        this.y = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r11.parsePublicKey(), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
        ASN1Sequence r0 = ASN1Sequence.getInstance(r11.getAlgorithm().getParameters());
        ASN1ObjectIdentifier r12 = r11.getAlgorithm().getAlgorithm();
        if (r12.equals(PKCSObjectIdentifiers.dhKeyAgreement) == false) goto L7;
    L18:
        DHParameter r13 = DHParameter.getInstance(r0);
        if (r13.getL() == null) goto L21;
        this.dhSpec = new DHParameterSpec(r13.getP(), r13.getG(), r13.getL().intValue());
        DHPublicKeyParameters r14 = new DHPublicKeyParameters(this.y, new DHParameters(this.dhSpec.getP(), this.dhSpec.getG(), null, this.dhSpec.getL()));
    L22:
        this.dhPublicKey = r14;
        return;
    L21:
        this.dhSpec = new DHParameterSpec(r13.getP(), r13.getG());
        r14 = new DHPublicKeyParameters(this.y, new DHParameters(this.dhSpec.getP(), this.dhSpec.getG()));
        goto L22
    L7:
        if (isPKCSParam(r0) == true) goto L18;
        if (r12.equals(X9ObjectIdentifiers.dhpublicnumber) == false) goto L17;
        DomainParameters r15 = DomainParameters.getInstance(r0);
        ValidationParams r1 = r15.getValidationParams();
        if (r1 == null) goto L14;
        this.dhPublicKey = new DHPublicKeyParameters(this.y, new DHParameters(r15.getP(), r15.getG(), r15.getQ(), r15.getJ(), new DHValidationParameters(r1.getSeed(), r1.getPgenCounter().intValue())));
    L15:
        this.dhSpec = new DHDomainParameterSpec(this.dhPublicKey.getParameters());
        return;
    L14:
        this.dhPublicKey = new DHPublicKeyParameters(this.y, new DHParameters(r15.getP(), r15.getG(), r15.getQ(), r15.getJ(), null));
        goto L15
    L17:
        throw new IllegalArgumentException("unknown algorithm type: " + r12);
    L25:
        throw new IllegalArgumentException("invalid info structure in DH public key");
    }

    BCDHPublicKey(DHPublicKeyParameters r3) {
        this.y = r3.getY();
        this.dhSpec = new DHDomainParameterSpec(r3.getParameters());
        this.dhPublicKey = r3;
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
        r6.defaultReadObject();
        this.dhSpec = new DHParameterSpec((BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), (BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), r6.readInt());
        this.info = null;
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.defaultWriteObject();
        r2.writeObject(this.dhSpec.getP());
        r2.writeObject(this.dhSpec.getG());
        r2.writeInt(this.dhSpec.getL());
    }

    public DHPublicKeyParameters engineGetKeyParameters() {
        return this.dhPublicKey;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, DHPublicKey.class) == true) goto L5;
        return false;
    L5:
        DHPublicKey r5 = (DHPublicKey) ZeusTransformUtils.preCheckCast(r4, DHPublicKey.class, "com.obric.memorydata.plugin");
        if (getY().equals(r5.getY()) == true) goto L8;
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

    @Override // java.security.Key
    public byte[] getEncoded() {
        SubjectPublicKeyInfo r0 = this.info;
        if (r0 == null) goto L7;
        return KeyUtil.getEncodedSubjectPublicKeyInfo(r0);
    L7:
        if (ZeusTransformUtils.instanceOf(this.dhSpec, DHDomainParameterSpec.class) == false) goto L16;
        if (((DHDomainParameterSpec) ZeusTransformUtils.preCheckCast(this.dhSpec, DHDomainParameterSpec.class, "com.obric.memorydata.plugin")).getQ() == null) goto L16;
        DHParameters r1 = ((DHDomainParameterSpec) ZeusTransformUtils.preCheckCast(this.dhSpec, DHDomainParameterSpec.class, "com.obric.memorydata.plugin")).getDomainParameters();
        DHValidationParameters r2 = r1.getValidationParameters();
        ValidationParams r3 = null;
        if (r2 == null) goto L13;
        r3 = new ValidationParams(r2.getSeed(), r2.getCounter());
    L13:
        ValidationParams r9 = r3;
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.dhpublicnumber, new DomainParameters(r1.getP(), r1.getG(), r1.getQ(), r1.getJ(), r9).toASN1Primitive()), new ASN1Integer(this.y));
    L16:
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL()).toASN1Primitive()), new ASN1Integer(this.y));
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

    public int hashCode() {
        int r0 = (getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode();
        return getParams().getL() ^ r0;
    }

    public String toString() {
        return DHUtil.publicKeyToString("DH", this.y, new DHParameters(this.dhSpec.getP(), this.dhSpec.getG()));
    }
}
