package org.bouncycastle.pqc.jcajce.provider.mceliece;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.PrivateKey;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.asn1.McEliecePrivateKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.legacy.crypto.mceliece.McEliecePrivateKeyParameters;
import org.bouncycastle.pqc.legacy.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.legacy.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.legacy.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.legacy.math.linearalgebra.PolynomialGF2mSmallM;

/* JADX INFO: loaded from: classes7.dex */
public class BCMcEliecePrivateKey implements PrivateKey, CipherParameters {
    private static final long serialVersionUID = 1;
    private McEliecePrivateKeyParameters params;

    public BCMcEliecePrivateKey(McEliecePrivateKeyParameters r1) {
        this.params = r1;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, BCMcEliecePrivateKey.class) == true) goto L5;
        return false;
    L5:
        BCMcEliecePrivateKey r5 = (BCMcEliecePrivateKey) ZeusTransformUtils.preCheckCast(r4, BCMcEliecePrivateKey.class, "com.obric.memorydata.plugin");
        if (getN() == r5.getN()) goto L8;
        return false;
    L8:
        if (getK() == r5.getK()) goto L10;
        return false;
    L10:
        if (getField().equals(r5.getField()) == true) goto L12;
        return false;
    L12:
        if (getGoppaPoly().equals(r5.getGoppaPoly()) == true) goto L14;
        return false;
    L14:
        if (getSInv().equals(r5.getSInv()) == true) goto L16;
        return false;
    L16:
        if (getP1().equals(r5.getP1()) == true) goto L18;
        return false;
    L18:
        if (getP2().equals(r5.getP2()) == false) goto L27;
        return true;
    L27:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        McEliecePrivateKey r8 = new McEliecePrivateKey(this.params.getN(), this.params.getK(), this.params.getField(), this.params.getGoppaPoly(), this.params.getP1(), this.params.getP2(), this.params.getSInv());
        return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.mcEliece), r8).getEncoded();
    L9:
        return null;
    }

    public GF2mField getField() {
        return this.params.getField();
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return this.params.getGoppaPoly();
    }

    public GF2Matrix getH() {
        return this.params.getH();
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

    public Permutation getP1() {
        return this.params.getP1();
    }

    public Permutation getP2() {
        return this.params.getP2();
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.params.getQInv();
    }

    public GF2Matrix getSInv() {
        return this.params.getSInv();
    }

    public int hashCode() {
        return (((((((((((this.params.getK() * 37) + this.params.getN()) * 37) + this.params.getField().hashCode()) * 37) + this.params.getGoppaPoly().hashCode()) * 37) + this.params.getP1().hashCode()) * 37) + this.params.getP2().hashCode()) * 37) + this.params.getSInv().hashCode();
    }
}
