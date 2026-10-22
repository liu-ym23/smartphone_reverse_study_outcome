package com.obric.cae.smartNetwork.qoe;

/* JADX INFO: loaded from: classes2.dex */
public class WiFiQoEParam {
    private int mBand;
    private int mJitter;
    private int mRxThroughput;
    private int mTxThroughput;

    public WiFiQoEParam() {
    }

    public int getBand() {
        return this.mBand;
    }

    public int getRxThroughput() {
        return this.mRxThroughput;
    }

    public int getTxThroughput() {
        return this.mTxThroughput;
    }

    public void setBand(int r8) {
        this.mBand = r8;
    }

    public void setRxThroughput(int r8) {
        this.mRxThroughput = r8;
    }

    public void setTxThroughput(int r8) {
        this.mTxThroughput = r8;
    }
}
