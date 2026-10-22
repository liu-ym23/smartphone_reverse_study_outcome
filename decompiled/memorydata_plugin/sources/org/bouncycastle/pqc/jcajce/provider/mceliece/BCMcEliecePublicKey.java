package org.bouncycastle.pqc.jcajce.provider.mceliece;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.PublicKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.asn1.McEliecePublicKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.legacy.crypto.mceliece.McEliecePublicKeyParameters;
import org.bouncycastle.pqc.legacy.math.linearalgebra.GF2Matrix;

/* JADX INFO: loaded from: classes7.dex */
public class BCMcEliecePublicKey implements PublicKey {
    private static final long serialVersionUID = 1;
    private McEliecePublicKeyParameters params;

    public BCMcEliecePublicKey(McEliecePublicKeyParameters r1) {
        this.params = r1;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, BCMcEliecePublicKey.class) == false) goto L12;
        BCMcEliecePublicKey r5 = (BCMcEliecePublicKey) ZeusTransformUtils.preCheckCast(r4, BCMcEliecePublicKey.class, "com.obric.memorydata.plugin");
        if (this.params.getN() == r5.getN()) goto L7;
        return false;
    L7:
        if (this.params.getT() == r5.getT()) goto L9;
        return false;
    L9:
        if (this.params.getG().equals(r5.getG()) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        McEliecePublicKey r0 = new McEliecePublicKey(this.params.getN(), this.params.getT(), this.params.getG());
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.mcEliece), r0).getEncoded();
    L5:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public GF2Matrix getG() {
        return this.params.getG();
    }

    public int getK() {
        return this.params.getK();
    }

    AsymmetricKeyParameter getKeyParams() {
        return this.params;
    }

    public int getN() {
        return this.params.getN();
    }

    public int getT() {
        return this.params.getT();
    }

    public int hashCode() {
        return ((this.params.getN() + (this.params.getT() * 37)) * 37) + this.params.getG().hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n length of the code         : " + this.params.getN() + "\n") + " error correction capability: " + this.params.getT() + "\n") + " generator matrix           : " + this.params.getG();
    }
}
