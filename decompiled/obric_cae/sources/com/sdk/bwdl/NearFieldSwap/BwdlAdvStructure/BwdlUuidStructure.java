package com.sdk.bwdl.NearFieldSwap.BwdlAdvStructure;

/* JADX INFO: loaded from: classes2.dex */
public class BwdlUuidStructure {
    private short mUuids;

    public BwdlUuidStructure() {
        this.mUuids = BwdlAdvConstants.BwdlDefaultUuids;
    }

    public byte[] getBytesData() {
        short r8 = this.mUuids;
        return new byte[]{(byte) ((r8 >> 8) & 255), (byte) (r8 & 255)};
    }

    public short getUuids() {
        return this.mUuids;
    }

    public void setUuids(short r8) {
        this.mUuids = r8;
    }
}
