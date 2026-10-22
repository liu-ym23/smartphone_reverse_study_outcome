package com.sdk.bwdl.NearFieldSwap.BwdlAdvStructure;

import com.sdk.bwdl.ExternalAPI.BWDLAdvertisingData;
import com.sdk.bwdl.NearFieldSwap.AdvCommonStructure;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class BwdlAdvStructure {
    private int AdvLen;
    private boolean BLEAdvFlagDataOption;
    private boolean BLEAdvNameDataOption;
    private boolean BLEAdvPowerDataOption;
    private boolean BLEAdvServiceDataOption;
    private boolean BLEAdvUUIDDataOption;
    private BwdlServiceDataStructure mBwdlServiceDataStructure;
    private AdvCommonStructure mFlags;
    private AdvCommonStructure mLocalName;
    private AdvCommonStructure mService;
    private AdvCommonStructure mTxPowerLevel;
    private AdvCommonStructure mUuid;

    public BwdlAdvStructure(int r8) {
        this.BLEAdvFlagDataOption = true;
        this.BLEAdvNameDataOption = false;
        this.BLEAdvPowerDataOption = false;
        this.BLEAdvUUIDDataOption = false;
        this.BLEAdvServiceDataOption = true;
        BwdlServiceDataStructure r10 = new BwdlServiceDataStructure();
        this.mBwdlServiceDataStructure = r10;
        r10.setDeviceId(r8);
        updateBwdlAdvData();
    }

    public static byte[] toByteArray(BwdlAdvStructure r8) {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();     // Catch: IOException -> L4
        ObjectOutputStream r11 = new ObjectOutputStream(r10);     // Catch: IOException -> L4
        r11.writeObject(r8);     // Catch: IOException -> L4
        r11.flush();     // Catch: IOException -> L4
        return r10.toByteArray();
    L4:
        e = move-exception;
        throw new RuntimeException("Failed to convert object to byte array", e);
    }

    public void get() {
    }

    public int getAdvStructureLen() {
        return this.AdvLen;
    }

    public byte[] getBytes() {
        ByteArrayOutputStream r8 = new ByteArrayOutputStream();
        if (isBLEAdvFlagDataOption() == false) goto L6;
        r8.write(this.mFlags.getBytes(), 0, this.mFlags.getBytes().length);
    L6:
        if (isBLEAdvNameDataOption() == false) goto L9;
        r8.write(this.mLocalName.getBytes(), 0, this.mLocalName.getBytes().length);
    L9:
        if (isBLEAdvPowerDataOption() == false) goto L12;
        r8.write(this.mTxPowerLevel.getBytes(), 0, this.mTxPowerLevel.getBytes().length);
    L12:
        if (isBLEAdvUUIDDataOption() == false) goto L15;
        r8.write(this.mUuid.getBytes(), 0, this.mUuid.getBytes().length);
    L15:
        if (isBLEAdvServiceDataOption() == false) goto L18;
        r8.write(this.mService.getBytes(), 0, this.mService.getBytes().length);
    L18:
        return r8.toByteArray();
    }

    public boolean isBLEAdvFlagDataOption() {
        return this.BLEAdvFlagDataOption;
    }

    public boolean isBLEAdvNameDataOption() {
        return this.BLEAdvNameDataOption;
    }

    public boolean isBLEAdvPowerDataOption() {
        return this.BLEAdvPowerDataOption;
    }

    public boolean isBLEAdvServiceDataOption() {
        return this.BLEAdvServiceDataOption;
    }

    public boolean isBLEAdvUUIDDataOption() {
        return this.BLEAdvUUIDDataOption;
    }

    public void removeBwdlAdvServiceData(BWDLAdvertisingData r8) {
        this.mBwdlServiceDataStructure.removeBwdlAdvServiceData(r8);
    }

    public void set() {
    }

    public void setBLEAdvFlagDataOption(boolean r8) {
        this.BLEAdvFlagDataOption = r8;
    }

    public void setBLEAdvNameDataOption(boolean r8) {
        this.BLEAdvNameDataOption = r8;
    }

    public void setBLEAdvPowerDataOption(boolean r8) {
        this.BLEAdvPowerDataOption = r8;
    }

    public void setBLEAdvServiceDataOption(boolean r8) {
        this.BLEAdvServiceDataOption = r8;
    }

    public void setBLEAdvUUIDDataOption(boolean r8) {
        this.BLEAdvUUIDDataOption = r8;
    }

    public void updateBwdlAdvData() {
        if (isBLEAdvFlagDataOption() == false) goto L6;
        byte[] r8 = new BwdlFlagDataStructure().getBytesData();
        this.mFlags = new AdvCommonStructure(BwdlAdvConstants.BwdlFlagsLengh, BwdlAdvConstants.BwdlFlagsType, r8);
    L6:
        if (isBLEAdvNameDataOption() == false) goto L9;
        byte[] r10 = new BwdlLocalNameStructure().getBytesData();
        this.mLocalName = new AdvCommonStructure(BwdlAdvConstants.BwdlAdvShortDevNameLengh, BwdlAdvConstants.BwdlAdvShortDevNameType, r10);
    L9:
        if (isBLEAdvPowerDataOption() == false) goto L12;
        byte[] r11 = new BwdlTxPowerStructure().getBytesData();
        this.mTxPowerLevel = new AdvCommonStructure(BwdlAdvConstants.BwdlAdvTxPowerLengh, BwdlAdvConstants.BwdlAdvTxPowerType, r11);
    L12:
        if (isBLEAdvUUIDDataOption() == false) goto L15;
        byte[] r12 = new BwdlUuidStructure().getBytesData();
        this.mUuid = new AdvCommonStructure(BwdlAdvConstants.BwdlAdvUUIDLengh, BwdlAdvConstants.BwdlAdvUUIDType, r12);
    L15:
        if (isBLEAdvServiceDataOption() == false) goto L18;
        byte[] r13 = this.mBwdlServiceDataStructure.getBytesData();
        this.mService = new AdvCommonStructure(r13.length + 1, BwdlAdvConstants.BwdlAdVServiceDataType, r13);
        return;
    }

    public void updateBwdlAdvServiceData(BWDLAdvertisingData r8) {
        this.mBwdlServiceDataStructure.updateBwdlAdvServiceData(r8);
    }
}
