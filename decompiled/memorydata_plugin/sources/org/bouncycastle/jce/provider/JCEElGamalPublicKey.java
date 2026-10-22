package org.bouncycastle.jce.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;
import org.bouncycastle.jce.spec.ElGamalPublicKeySpec;

/* JADX INFO: loaded from: classes7.dex */
public class JCEElGamalPublicKey implements DHPublicKey, ElGamalPublicKey {
    static final long serialVersionUID = 8712728417091216948L;
    private ElGamalParameterSpec elSpec;
    private BigInteger y;

    JCEElGamalPublicKey(BigInteger r1, ElGamalParameterSpec r2) {
        this.y = r1;
        this.elSpec = r2;
    }

    JCEElGamalPublicKey(DHPublicKey r3) {
        DHPublicKey r4 = (DHPublicKey) ZeusTransformUtils.wrapperContextForParams(r3, DHPublicKey.class, "com.obric.memorydata.plugin");
        this.y = r4.getY();
        this.elSpec = new ElGamalParameterSpec(r4.getParams().getP(), r4.getParams().getG());
    }

    JCEElGamalPublicKey(DHPublicKeySpec r3) {
        this.y = r3.getY();
        this.elSpec = new ElGamalParameterSpec(r3.getP(), r3.getG());
    }

    JCEElGamalPublicKey(SubjectPublicKeyInfo r4) {
        ElGamalParameter r0 = ElGamalParameter.getInstance(r4.getAlgorithm().getParameters());
        this.y = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r4.parsePublicKey(), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
        this.elSpec = new ElGamalParameterSpec(r0.getP(), r0.getG());
        return;
    L7:
        throw new IllegalArgumentException("invalid info structure in DSA public key");
    }

    JCEElGamalPublicKey(ElGamalPublicKeyParameters r3) {
        this.y = r3.getY();
        this.elSpec = new ElGamalParameterSpec(r3.getParameters().getP(), r3.getParameters().getG());
    }

    JCEElGamalPublicKey(ElGamalPublicKey r3) {
        ElGamalPublicKey r4 = (ElGamalPublicKey) ZeusTransformUtils.wrapperContextForParams(r3, ElGamalPublicKey.class, "com.obric.memorydata.plugin");
        this.y = r4.getY();
        this.elSpec = r4.getParameters();
    }

    JCEElGamalPublicKey(ElGamalPublicKeySpec r3) {
        this.y = r3.getY();
        this.elSpec = new ElGamalParameterSpec(r3.getParams().getP(), r3.getParams().getG());
    }

    private void readObject(ObjectInputStream r5) {
        this.y = (BigInteger) ZeusTransformUtils.preCheckCast(r5.readObject(), BigInteger.class, "com.obric.memorydata.plugin");
        this.elSpec = new ElGamalParameterSpec((BigInteger) ZeusTransformUtils.preCheckCast(r5.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), (BigInteger) ZeusTransformUtils.preCheckCast(r5.readObject(), BigInteger.class, "com.obric.memorydata.plugin"));
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.writeObject(getY());
        r2.writeObject(this.elSpec.getP());
        r2.writeObject(this.elSpec.getG());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "ElGamal";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalParameter(this.elSpec.getP(), this.elSpec.getG())), new ASN1Integer(this.y));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.jce.interfaces.ElGamalKey
    public ElGamalParameterSpec getParameters() {
        return this.elSpec;
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.elSpec.getP(), this.elSpec.getG());
    }

    @Override // javax.crypto.interfaces.DHPublicKey, org.bouncycastle.jce.interfaces.ElGamalPublicKey
    public BigInteger getY() {
        return this.y;
    }
}
