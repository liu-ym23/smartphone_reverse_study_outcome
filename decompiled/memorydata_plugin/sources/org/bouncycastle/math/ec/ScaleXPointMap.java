package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes7.dex */
public class ScaleXPointMap implements ECPointMap {
    protected final ECFieldElement scale;

    public ScaleXPointMap(ECFieldElement r1) {
        this.scale = r1;
    }

    @Override // org.bouncycastle.math.ec.ECPointMap
    public ECPoint map(ECPoint r1) {
        return r1.scaleX(this.scale);
    }
}
