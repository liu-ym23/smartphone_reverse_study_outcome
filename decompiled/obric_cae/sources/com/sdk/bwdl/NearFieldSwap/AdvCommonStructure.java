package com.sdk.bwdl.NearFieldSwap;

/* JADX INFO: loaded from: classes2.dex */
public class AdvCommonStructure {
    private byte[] mAdData;
    private byte mDataType;
    private int mLength;

    public AdvCommonStructure(int r8, byte r10, byte[] r11) {
        this.mLength = r8;
        this.mDataType = r10;
        byte[] r12 = new byte[r8 - 1];
        this.mAdData = r11;
    }

    public byte[] getAdData() {
        return this.mAdData;
    }

    public byte[] getBytes() {
        int r8 = this.mLength;
        byte[] r10 = new byte[r8 + 1];
        r10[0] = (byte) r8;
        r10[1] = this.mDataType;
        byte[] r11 = this.mAdData;
        System.arraycopy(r11, 0, r10, 2, r11.length);
        return r10;
    }

    public byte getDataType() {
        return this.mDataType;
    }

    public int getLength() {
        return this.mLength;
    }

    public void setAdData(byte[] r8) {
        this.mAdData = r8;
    }

    public void setDataType(byte r8) {
        this.mDataType = r8;
    }

    public void setLength(int r8) {
        this.mLength = r8;
    }
}
