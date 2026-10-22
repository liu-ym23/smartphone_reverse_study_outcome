package org.bouncycastle.pqc.legacy.crypto.rainbow;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.pqc.legacy.crypto.rainbow.util.RainbowUtil;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class Layer {
    private short[][][] coeff_alpha;
    private short[][][] coeff_beta;
    private short[] coeff_eta;
    private short[][] coeff_gamma;
    private int oi;
    private int vi;
    private int viNext;

    public Layer(byte r1, byte r2, short[][][] r3, short[][][] r4, short[][] r5, short[] r6) {
        int r7 = r1 & 255;
        this.vi = r7;
        int r8 = r2 & 255;
        this.viNext = r8;
        this.oi = r8 - r7;
        this.coeff_alpha = r3;
        this.coeff_beta = r4;
        this.coeff_gamma = r5;
        this.coeff_eta = r6;
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, Layer.class) == false) goto L31;
        Layer r5 = (Layer) ZeusTransformUtils.preCheckCast(r4, Layer.class, "com.obric.memorydata.plugin");
        if (this.vi == r5.getVi()) goto L10;
        return false;
    L10:
        if (this.viNext == r5.getViNext()) goto L12;
        return false;
    L12:
        if (this.oi == r5.getOi()) goto L14;
        return false;
    L14:
        if (RainbowUtil.equals(this.coeff_alpha, r5.getCoeffAlpha()) == true) goto L16;
        return false;
    L16:
        if (RainbowUtil.equals(this.coeff_beta, r5.getCoeffBeta()) == true) goto L18;
        return false;
    L18:
        if (RainbowUtil.equals(this.coeff_gamma, r5.getCoeffGamma()) == true) goto L20;
        return false;
    L20:
        if (RainbowUtil.equals(this.coeff_eta, r5.getCoeffEta()) == false) goto L30;
        return true;
    L30:
        return false;
    L31:
        return false;
    }

    public short[][][] getCoeffAlpha() {
        return this.coeff_alpha;
    }

    public short[][][] getCoeffBeta() {
        return this.coeff_beta;
    }

    public short[] getCoeffEta() {
        return this.coeff_eta;
    }

    public short[][] getCoeffGamma() {
        return this.coeff_gamma;
    }

    public int getOi() {
        return this.oi;
    }

    public int getVi() {
        return this.vi;
    }

    public int getViNext() {
        return this.viNext;
    }

    public int hashCode() {
        return (((((((((((this.vi * 37) + this.viNext) * 37) + this.oi) * 37) + Arrays.hashCode(this.coeff_alpha)) * 37) + Arrays.hashCode(this.coeff_beta)) * 37) + Arrays.hashCode(this.coeff_gamma)) * 37) + Arrays.hashCode(this.coeff_eta);
    }
}
