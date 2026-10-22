package com.sdk.bwdl.ExternalAPI;

/* JADX INFO: loaded from: classes2.dex */
public class BWDLAdvertisingData {
    private static final int DATA_LENGTH_SIZE = 1;
    private static final int DATA_TYPE_SIZE = 1;
    private static final int SERVICE_LENGTH_SIZE = 1;
    private static final int SERVICE_UUID_SIZE = 2;
    private byte[] mFeatureData;
    private byte mFeatureType;
    private byte mLength;
    public byte[] mPrivData;
    private byte mServiceLength;
    private short mServiceUuid;

    public BWDLAdvertisingData(short r8, byte r10, byte[] r11, byte[] r12) {
        this.mServiceUuid = r8;
        this.mServiceLength = 0;
        this.mLength = 0;
        this.mFeatureType = r10;
        if (r11 != null) goto L5;
    L7:
        this.mLength = 2;
        this.mFeatureData = new byte[2 - 1];
    L8:
        if (r12 != null) goto L10;
    L12:
        int r13 = this.mLength;
    L13:
        this.mServiceLength = (byte) (r13 + 1);
        return;
    L10:
        if (r12.length <= 0) goto L12;
        this.mPrivData = r12;
        r13 = r12.length + this.mLength;
        goto L13
    L5:
        if (r11.length <= 0) goto L7;
        this.mLength = (byte) (r11.length + 1);
        this.mFeatureData = r11;
        goto L8
    }

    public byte[] getAllBytes() {
        byte r8 = this.mServiceLength;
        byte[] r10 = new byte[r8 + 3];
        short r11 = this.mServiceUuid;
        r10[0] = (byte) (r11 & 255);
        r10[1] = (byte) ((r11 >> 8) & 255);
        r10[2] = r8;
        r10[3] = this.mLength;
        r10[4] = this.mFeatureType;
        byte[] r12 = this.mFeatureData;
        System.arraycopy(r12, 0, r10, 5, r12.length);
        byte[] r13 = this.mPrivData;
        if (r13 == null) goto L5;
        System.arraycopy(r13, 0, r10, this.mFeatureData.length + 5, r13.length);
    L5:
        return r10;
    }

    public byte[] getBytes() {
        byte r8 = this.mServiceLength;
        byte[] r10 = new byte[r8 + 3];
        short r11 = this.mServiceUuid;
        r10[0] = (byte) (r11 & 255);
        r10[1] = (byte) ((r11 >> 8) & 255);
        r10[2] = r8;
        byte[] r12 = this.mFeatureData;
        System.arraycopy(r12, 0, r10, 3, r12.length);
        return r10;
    }

    public byte[] getFeatureData() {
        return this.mFeatureData;
    }

    public byte getFeatureType() {
        return this.mFeatureType;
    }

    public byte[] getPrivData() {
        return this.mPrivData;
    }

    public short getServiceUuid() {
        return this.mServiceUuid;
    }

    public BWDLAdvertisingData(short r8, byte[] r10) {
        this.mServiceUuid = r8;
        this.mServiceLength = 0;
        this.mLength = 0;
        if (r10 != null) goto L5;
    L7:
        this.mFeatureData = new byte[0];
        return;
    L5:
        if (r10.length <= 0) goto L7;
        this.mServiceLength = (byte) r10.length;
        this.mFeatureData = r10;
    }
}
