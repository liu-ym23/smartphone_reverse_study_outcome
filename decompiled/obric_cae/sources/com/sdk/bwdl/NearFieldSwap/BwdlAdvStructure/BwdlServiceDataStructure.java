package com.sdk.bwdl.NearFieldSwap.BwdlAdvStructure;

import com.sdk.bwdl.ExternalAPI.BWDLAdvertisingData;
import com.sdk.bwdl.Utils.BWDLLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class BwdlServiceDataStructure {
    private final byte SERVICE_CAPABILITIES_FASTPAIR;
    private final byte SERVICE_CAPABILITIES_FINDMY;
    private final byte SERVICE_CAPABILITIES_HDRECORDING;
    private final byte SERVICE_CAPABILITIES_HST;
    private final String TAG;
    private byte advVersion;
    private byte battery;
    private short companyID;
    private int deviceId;
    private List<BWDLAdvertisingData> mServiceStructure;
    private short productPriPID;
    private byte productSubPID;
    private short serviceCapabilities;

    public BwdlServiceDataStructure() {
        this.TAG = "BwdlServiceDataStructure";
        this.SERVICE_CAPABILITIES_FASTPAIR = 0;
        this.SERVICE_CAPABILITIES_HST = 1;
        this.SERVICE_CAPABILITIES_HDRECORDING = 2;
        this.SERVICE_CAPABILITIES_FINDMY = 3;
        this.mServiceStructure = new CopyOnWriteArrayList();
    }

    public byte[] getBytesData() {
        if (this.mServiceStructure.isEmpty() == true) goto L8;
        Iterator<BWDLAdvertisingData> r8 = this.mServiceStructure.iterator();
        int r10 = 0;
    L6:
        if (r8.hasNext() == false) goto L9;
        r10 = r10 + r8.next().getAllBytes().length;
    L9:
        byte[] r11 = new byte[BwdlAdvConstants.BwdlServiceCommonDataLen + r10];
        short r12 = this.companyID;
        r11[0] = (byte) (r12 & 255);
        r11[1] = (byte) ((r12 >> 8) & 255);
        r11[2] = this.advVersion;
        short r13 = this.serviceCapabilities;
        r11[3] = (byte) (r13 & 255);
        r11[4] = (byte) ((r13 >> 8) & 255);
        if (r12 == 0) goto L12;
        short r14 = this.productPriPID;
        r11[5] = (byte) (r14 & 255);
        r11[6] = (byte) ((r14 >> 8) & 255);
        r11[7] = this.productSubPID;
        r11[8] = this.battery;
    L14:
        if (this.mServiceStructure.isEmpty() == true) goto L19;
        Iterator<BWDLAdvertisingData> r15 = this.mServiceStructure.iterator();
    L17:
        if (r15.hasNext() == false) goto L19;
        BWDLAdvertisingData r16 = r15.next();
        System.arraycopy(r16.getAllBytes(), 0, r11, BwdlAdvConstants.BwdlServiceCommonDataLen, r16.getAllBytes().length);
    L19:
        BWDLLog.d("BwdlServiceDataStructure", "getBytesData mData=" + Arrays.toString(r11));
        return r11;
    L12:
        int r17 = this.deviceId;
        r11[5] = (byte) (r17 & 255);
        r11[6] = (byte) ((r17 >> 8) & 255);
        r11[7] = (byte) ((r17 >> 16) & 255);
        r11[8] = (byte) ((r17 >> 24) & 255);
        goto L14
    L8:
        r10 = 0;
        goto L9
    }

    public void removeBwdlAdvServiceData(BWDLAdvertisingData r8) {
        this.mServiceStructure.remove(r8);
    }

    public void setAdvVersion(byte r8) {
        this.advVersion = r8;
    }

    public void setBattery(byte r8) {
        this.battery = r8;
    }

    public void setCompanyID(short r8) {
        this.companyID = r8;
    }

    public void setDeviceId(int r8) {
        this.deviceId = r8;
    }

    public void setProductPriPID(short r8) {
        this.productPriPID = r8;
    }

    public void setProductSubPID(byte r8) {
        this.productSubPID = r8;
    }

    public void setServiceCapabilities(byte r8) {
        this.serviceCapabilities = r8;
    }

    public void updateBwdlAdvServiceData(BWDLAdvertisingData r8) {
        this.mServiceStructure.add(r8);
    }
}
