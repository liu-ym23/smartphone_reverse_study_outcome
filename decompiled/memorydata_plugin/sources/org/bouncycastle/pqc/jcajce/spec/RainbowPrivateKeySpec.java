package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.bouncycastle.pqc.legacy.crypto.rainbow.Layer;

/* JADX INFO: loaded from: classes7.dex */
public class RainbowPrivateKeySpec implements KeySpec {
    private short[][] A1inv;
    private short[][] A2inv;
    private short[] b1;
    private short[] b2;
    private Layer[] layers;
    private int[] vi;

    public RainbowPrivateKeySpec(short[][] r1, short[] r2, short[][] r3, short[] r4, int[] r5, Layer[] r6) {
        this.A1inv = r1;
        this.b1 = r2;
        this.A2inv = r3;
        this.b2 = r4;
        this.vi = r5;
        this.layers = r6;
    }

    public short[] getB1() {
        return this.b1;
    }

    public short[] getB2() {
        return this.b2;
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
}
