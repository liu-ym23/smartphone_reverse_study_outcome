package com.sdk.bwdl.NearFieldSwap;

/* JADX INFO: loaded from: classes2.dex */
public class AdvCustomizedStructure {
    private byte mDataLength;
    private byte[] mFeatureData;
    private short mFeatureType;

    public AdvCustomizedStructure() {
    }

    public AdvCustomizedStructure(short r8, byte r10, byte[] r11) {
        this.mFeatureType = r8;
        this.mDataLength = r10;
        byte[] r12 = new byte[r10];
        this.mFeatureData = r11;
    }

    public byte[] getAdData() {
        return this.mFeatureData;
    }

    public short getFeatureType() {
        return this.mFeatureType;
    }

    public byte getLength() {
        return this.mDataLength;
    }

    public void setFeatureData(byte[] r8) {
        this.mFeatureData = r8;
    }

    public void setFeatureType(short r8) {
        this.mFeatureType = r8;
    }

    public void setLength(byte r8) {
        this.mDataLength = r8;
    }
}
