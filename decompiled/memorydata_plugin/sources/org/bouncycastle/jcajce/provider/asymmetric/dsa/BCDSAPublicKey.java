package org.bouncycastle.jcajce.provider.asymmetric.dsa;

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
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class BCDSAPublicKey implements DSAPublicKey {
    private static BigInteger ZERO = null;
    private static final long serialVersionUID = 1752452449903495175L;
    private transient DSAParams dsaSpec;
    private transient DSAPublicKeyParameters lwKeyParams;
    private BigInteger y;

    static {
        ZERO = BigInteger.valueOf(0);
    }

    BCDSAPublicKey(DSAPublicKey r3) {
        DSAPublicKey r4 = (DSAPublicKey) ZeusTransformUtils.wrapperContextForParams(r3, DSAPublicKey.class, "com.obric.memorydata.plugin");
        this.y = r4.getY();
        this.dsaSpec = r4.getParams();
        this.lwKeyParams = new DSAPublicKeyParameters(this.y, DSAUtil.toDSAParameters(this.dsaSpec));
    }

    BCDSAPublicKey(DSAPublicKeySpec r4) {
        this.y = r4.getY();
        this.dsaSpec = new DSAParameterSpec(r4.getP(), r4.getQ(), r4.getG());
        this.lwKeyParams = new DSAPublicKeyParameters(this.y, DSAUtil.toDSAParameters(this.dsaSpec));
    }

    public BCDSAPublicKey(SubjectPublicKeyInfo r4) {
        this.y = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r4.parsePublicKey(), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
        if (isNotNull(r4.getAlgorithm().getParameters()) == false) goto L7;
        DSAParameter r5 = DSAParameter.getInstance(r4.getAlgorithm().getParameters());
        this.dsaSpec = new DSAParameterSpec(r5.getP(), r5.getQ(), r5.getG());
    L8:
        this.lwKeyParams = new DSAPublicKeyParameters(this.y, DSAUtil.toDSAParameters(this.dsaSpec));
        return;
    L7:
        this.dsaSpec = null;
    L11:
        throw new IllegalArgumentException("invalid info structure in DSA public key");
    }

    BCDSAPublicKey(DSAPublicKeyParameters r5) {
        this.y = r5.getY();
        if (r5.getParameters() == null) goto L5;
        DSAParameterSpec r0 = new DSAParameterSpec(r5.getParameters().getP(), r5.getParameters().getQ(), r5.getParameters().getG());
    L6:
        this.dsaSpec = r0;
        this.lwKeyParams = r5;
        return;
    L5:
        r0 = null;
        goto L6
    }

    private boolean isNotNull(ASN1Encodable r2) {
        ASN1Encodable r1 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r2, ASN1Encodable.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (DERNull.INSTANCE.equals(r1.toASN1Primitive()) == true) goto L7;
        return true;
    }

    private void readObject(ObjectInputStream r6) {
        r6.defaultReadObject();
        BigInteger r0 = (BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin");
        if (r0.equals(ZERO) == false) goto L5;
        this.dsaSpec = null;
    L6:
        this.lwKeyParams = new DSAPublicKeyParameters(this.y, DSAUtil.toDSAParameters(this.dsaSpec));
        return;
    L5:
        this.dsaSpec = new DSAParameterSpec(r0, (BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), (BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin"));
        goto L6
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.defaultWriteObject();
        DSAParams r0 = this.dsaSpec;
        if (r0 != null) goto L5;
        BigInteger r1 = ZERO;
    L6:
        r2.writeObject(r1);
        return;
    L5:
        r2.writeObject(r0.getP());
        r2.writeObject(this.dsaSpec.getQ());
        r1 = this.dsaSpec.getG();
        goto L6
    }

    DSAPublicKeyParameters engineGetKeyParameters() {
        return this.lwKeyParams;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, DSAPublicKey.class) == true) goto L5;
        return false;
    L5:
        DSAPublicKey r6 = (DSAPublicKey) ZeusTransformUtils.preCheckCast(r5, DSAPublicKey.class, "com.obric.memorydata.plugin");
        if (this.dsaSpec == null) goto L20;
        if (getY().equals(r6.getY()) == true) goto L10;
        return false;
    L10:
        if (r6.getParams() != null) goto L12;
        return false;
    L12:
        if (getParams().getG().equals(r6.getParams().getG()) == true) goto L14;
        return false;
    L14:
        if (getParams().getP().equals(r6.getParams().getP()) == true) goto L16;
        return false;
    L16:
        if (getParams().getQ().equals(r6.getParams().getQ()) == true) goto L18;
        return false;
    L18:
        return true;
    L20:
        if (getY().equals(r6.getY()) == true) goto L22;
        return false;
    L22:
        if (r6.getParams() == null) goto L24;
        return false;
    L24:
        return true;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        if (this.dsaSpec != null) goto L7;
        AlgorithmIdentifier r0 = new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa);
        ASN1Integer r1 = new ASN1Integer(this.y);
    L6:
        return KeyUtil.getEncodedSubjectPublicKeyInfo(r0, r1);
    L7:
        r0 = new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(this.dsaSpec.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG()).toASN1Primitive());
        r1 = new ASN1Integer(this.y);
        goto L6
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
        if (this.dsaSpec == null) goto L7;
        int r0 = (getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode();
        return getParams().getQ().hashCode() ^ r0;
    L7:
        return getY().hashCode();
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        r0.append("DSA Public Key [").append(DSAUtil.generateKeyFingerprint(this.y, getParams())).append("]").append(r1);
        r0.append("            Y: ").append(getY().toString(16)).append(r1);
        return r0.toString();
    }
}
