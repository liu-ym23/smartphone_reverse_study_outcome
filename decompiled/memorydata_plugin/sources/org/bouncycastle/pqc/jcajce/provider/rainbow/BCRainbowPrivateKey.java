package org.bouncycastle.pqc.jcajce.provider.rainbow;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.PrivateKey;
import java.util.Arrays;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.RainbowPrivateKey;
import org.bouncycastle.pqc.jcajce.spec.RainbowPrivateKeySpec;
import org.bouncycastle.pqc.legacy.crypto.rainbow.Layer;
import org.bouncycastle.pqc.legacy.crypto.rainbow.RainbowPrivateKeyParameters;
import org.bouncycastle.pqc.legacy.crypto.rainbow.util.RainbowUtil;

/* JADX INFO: loaded from: classes7.dex */
public class BCRainbowPrivateKey implements PrivateKey {
    private static final long serialVersionUID = 1;
    private short[][] A1inv;
    private short[][] A2inv;
    private short[] b1;
    private short[] b2;
    private Layer[] layers;
    private int[] vi;

    public BCRainbowPrivateKey(RainbowPrivateKeySpec r8) {
        this(r8.getInvA1(), r8.getB1(), r8.getInvA2(), r8.getB2(), r8.getVi(), r8.getLayers());
    }

    public BCRainbowPrivateKey(RainbowPrivateKeyParameters r8) {
        this(r8.getInvA1(), r8.getB1(), r8.getInvA2(), r8.getB2(), r8.getVi(), r8.getLayers());
    }

    public BCRainbowPrivateKey(short[][] r1, short[] r2, short[][] r3, short[] r4, int[] r5, Layer[] r6) {
        this.A1inv = r1;
        this.b1 = r2;
        this.A2inv = r3;
        this.b2 = r4;
        this.vi = r5;
        this.layers = r6;
    }

    public boolean equals(Object r6) {
        if (r6 != null) goto L5;
    L38:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r6, BCRainbowPrivateKey.class) == false) goto L38;
        BCRainbowPrivateKey r7 = (BCRainbowPrivateKey) ZeusTransformUtils.preCheckCast(r6, BCRainbowPrivateKey.class, "com.obric.memorydata.plugin");
        if (RainbowUtil.equals(this.A1inv, r7.getInvA1()) == false) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == true) goto L13;
    L15:
        boolean r1 = false;
    L16:
        if (r1 == true) goto L18;
    L20:
        boolean r2 = false;
    L21:
        if (r2 == true) goto L23;
    L25:
        boolean r3 = false;
    L26:
        if (r3 == true) goto L28;
    L30:
        boolean r4 = false;
    L32:
        if (this.layers.length == r7.getLayers().length) goto L34;
        return false;
    L34:
        int r5 = this.layers.length - 1;
    L35:
        if (r5 < 0) goto L37;
        r4 = r4 & this.layers[r5].equals(r7.getLayers()[r5]);
        r5 = r5 - 1;
        goto L35
    L37:
        return r4;
    L28:
        if (Arrays.equals(this.vi, r7.getVi()) == false) goto L30;
        r4 = true;
        goto L32
    L23:
        if (RainbowUtil.equals(this.b2, r7.getB2()) == false) goto L25;
        r3 = true;
        goto L26
    L18:
        if (RainbowUtil.equals(this.b1, r7.getB1()) == false) goto L20;
        r2 = true;
        goto L21
    L13:
        if (RainbowUtil.equals(this.A2inv, r7.getInvA2()) == false) goto L15;
        r1 = true;
        goto L16
    L10:
        r0 = false;
        goto L11
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    public short[] getB1() {
        return this.b1;
    }

    public short[] getB2() {
        return this.b2;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        RainbowPrivateKey r7 = new RainbowPrivateKey(this.A1inv, this.b1, this.A2inv, this.b2, this.vi, this.layers);
        return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.rainbow, DERNull.INSTANCE), r7).getEncoded();
    L9:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public short[][] getInvA1() {
        return this.A1inv;
    }

    public short[][] getInvA2() {
        return this.A2inv;
    }

    public Layer[] getLayers() {
        return this.layers;
    }

    public int[] getVi() {
        return this.vi;
    }

    public int hashCode() {
        int r0 = (((((((((this.layers.length * 37) + org.bouncycastle.util.Arrays.hashCode(this.A1inv)) * 37) + org.bouncycastle.util.Arrays.hashCode(this.b1)) * 37) + org.bouncycastle.util.Arrays.hashCode(this.A2inv)) * 37) + org.bouncycastle.util.Arrays.hashCode(this.b2)) * 37) + org.bouncycastle.util.Arrays.hashCode(this.vi);
        int r1 = this.layers.length - 1;
    L3:
        if (r1 < 0) goto L5;
        r0 = (r0 * 37) + this.layers[r1].hashCode();
        r1 = r1 - 1;
        goto L3
    L5:
        return r0;
    }
}
