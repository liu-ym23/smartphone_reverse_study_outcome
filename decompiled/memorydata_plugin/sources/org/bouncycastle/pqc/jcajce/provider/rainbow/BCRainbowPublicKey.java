package org.bouncycastle.pqc.jcajce.provider.rainbow;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.PublicKey;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.RainbowPublicKey;
import org.bouncycastle.pqc.jcajce.provider.util.KeyUtil;
import org.bouncycastle.pqc.jcajce.spec.RainbowPublicKeySpec;
import org.bouncycastle.pqc.legacy.crypto.rainbow.RainbowParameters;
import org.bouncycastle.pqc.legacy.crypto.rainbow.RainbowPublicKeyParameters;
import org.bouncycastle.pqc.legacy.crypto.rainbow.util.RainbowUtil;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BCRainbowPublicKey implements PublicKey {
    private static final long serialVersionUID = 1;
    private short[][] coeffquadratic;
    private short[] coeffscalar;
    private short[][] coeffsingular;
    private int docLength;
    private RainbowParameters rainbowParams;

    public BCRainbowPublicKey(int r1, short[][] r2, short[][] r3, short[] r4) {
        this.docLength = r1;
        this.coeffquadratic = r2;
        this.coeffsingular = r3;
        this.coeffscalar = r4;
    }

    public BCRainbowPublicKey(RainbowPublicKeySpec r4) {
        this(r4.getDocLength(), r4.getCoeffQuadratic(), r4.getCoeffSingular(), r4.getCoeffScalar());
    }

    public BCRainbowPublicKey(RainbowPublicKeyParameters r4) {
        this(r4.getDocLength(), r4.getCoeffQuadratic(), r4.getCoeffSingular(), r4.getCoeffScalar());
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, BCRainbowPublicKey.class) == false) goto L22;
        BCRainbowPublicKey r5 = (BCRainbowPublicKey) ZeusTransformUtils.preCheckCast(r4, BCRainbowPublicKey.class, "com.obric.memorydata.plugin");
        if (this.docLength == r5.getDocLength()) goto L10;
        return false;
    L10:
        if (RainbowUtil.equals(this.coeffquadratic, r5.getCoeffQuadratic()) == true) goto L12;
        return false;
    L12:
        if (RainbowUtil.equals(this.coeffsingular, r5.getCoeffSingular()) == true) goto L14;
        return false;
    L14:
        if (RainbowUtil.equals(this.coeffscalar, r5.getCoeffScalar()) == false) goto L21;
        return true;
    L21:
        return false;
    L22:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    public short[][] getCoeffQuadratic() {
        return this.coeffquadratic;
    }

    public short[] getCoeffScalar() {
        return Arrays.clone(this.coeffscalar);
    }

    public short[][] getCoeffSingular() {
        short[][] r0 = new short[this.coeffsingular.length][];
        int r1 = 0;
    L3:
        short[][] r2 = this.coeffsingular;
        if (r1 == r2.length) goto L6;
        r0[r1] = Arrays.clone(r2[r1]);
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    public int getDocLength() {
        return this.docLength;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        RainbowPublicKey r0 = new RainbowPublicKey(this.docLength, this.coeffquadratic, this.coeffsingular, this.coeffscalar);
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.rainbow, DERNull.INSTANCE), r0);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return (((((this.docLength * 37) + Arrays.hashCode(this.coeffquadratic)) * 37) + Arrays.hashCode(this.coeffsingular)) * 37) + Arrays.hashCode(this.coeffscalar);
    }
}
