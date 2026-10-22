package com.sdk.bwdl.NearFieldSwap.BwdlAdvStructure;

/* JADX INFO: loaded from: classes2.dex */
public class BwdlTxPowerStructure {
    private byte mTxPower;

    public BwdlTxPowerStructure() {
        this.mTxPower = BwdlAdvConstants.BwdlDefaultTxPower;
    }

    public byte[] getBytesData() {
        return new byte[]{this.mTxPower};
    }

    public byte getTxPower() {
        return this.mTxPower;
    }

    public void setTxPower(byte r8) {
        this.mTxPower = r8;
    }
}
