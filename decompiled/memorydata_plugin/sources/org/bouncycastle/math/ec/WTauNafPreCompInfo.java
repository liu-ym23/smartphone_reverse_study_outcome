package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes7.dex */
public class WTauNafPreCompInfo implements PreCompInfo {
    protected ECPoint.AbstractF2m[] preComp;

    public WTauNafPreCompInfo() {
        this.preComp = null;
    }

    public ECPoint.AbstractF2m[] getPreComp() {
        return this.preComp;
    }

    public void setPreComp(ECPoint.AbstractF2m[] r1) {
        this.preComp = r1;
    }
}
