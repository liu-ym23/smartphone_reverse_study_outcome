package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes7.dex */
public class WNafPreCompInfo implements PreCompInfo {
    protected int confWidth;
    protected ECPoint[] preComp;
    protected ECPoint[] preCompNeg;
    volatile int promotionCountdown;
    protected ECPoint twice;
    protected int width;

    public WNafPreCompInfo() {
        this.promotionCountdown = 4;
        this.confWidth = -1;
        this.preComp = null;
        this.preCompNeg = null;
        this.twice = null;
        this.width = -1;
    }

    int decrementPromotionCountdown() {
        int r0 = this.promotionCountdown;
        if (r0 <= 0) goto L6;
        int r1 = r0 - 1;
        this.promotionCountdown = r1;
        return r1;
    L6:
        return r0;
    }

    public int getConfWidth() {
        return this.confWidth;
    }

    public ECPoint[] getPreComp() {
        return this.preComp;
    }

    public ECPoint[] getPreCompNeg() {
        return this.preCompNeg;
    }

    int getPromotionCountdown() {
        return this.promotionCountdown;
    }

    public ECPoint getTwice() {
        return this.twice;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isPromoted() {
        if (this.promotionCountdown > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setConfWidth(int r1) {
        this.confWidth = r1;
    }

    public void setPreComp(ECPoint[] r1) {
        this.preComp = r1;
    }

    public void setPreCompNeg(ECPoint[] r1) {
        this.preCompNeg = r1;
    }

    void setPromotionCountdown(int r1) {
        this.promotionCountdown = r1;
    }

    public void setTwice(ECPoint r1) {
        this.twice = r1;
    }

    public void setWidth(int r1) {
        this.width = r1;
    }
}
