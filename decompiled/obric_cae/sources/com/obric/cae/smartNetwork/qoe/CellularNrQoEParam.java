package com.obric.cae.smartNetwork.qoe;

/* JADX INFO: loaded from: classes2.dex */
public class CellularNrQoEParam extends CellularQoEParam {
    private int mSsRsrp;
    private int mSsRsrq;

    public CellularNrQoEParam() {
    }

    public int getSsRsrp() {
        return this.mSsRsrp;
    }

    public int getSsRsrq() {
        return this.mSsRsrq;
    }

    public void setSsRsrp(int r8) {
        this.mSsRsrp = r8;
    }

    public void setSsRsrq(int r8) {
        this.mSsRsrq = r8;
    }
}
