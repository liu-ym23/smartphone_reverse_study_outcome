package com.obric.cae.smartNetwork.qoe;

/* JADX INFO: loaded from: classes2.dex */
public class CellularLteQoEParam extends CellularQoEParam {
    private int mRsrp;
    private int mRsrq;

    public CellularLteQoEParam() {
    }

    public int getRsrp() {
        return this.mRsrp;
    }

    public int getRsrq() {
        return this.mRsrq;
    }

    public void setRsrp(int r8) {
        this.mRsrp = r8;
    }

    public void setRsrq(int r8) {
        this.mRsrq = r8;
    }
}
