package com.sdk.bwdl.ExternalAPI;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.util.SparseArray;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BWDLDiscoveryData {
    private byte advVersion;
    private byte battery;
    private BluetoothDevice bluetoothDevice;
    private short companyID;
    private boolean connected;
    private int deviceId;
    private String deviceName;
    private int deviceType;
    private BWDLAdvertisingData mAdvertisingData;
    private List<BWDLAdvertisingData> mBWDLAdvertisingData;
    private BWDLDevice mBWDLDevice;
    private BluetoothDevice mBluetoothDevice;
    private String macAddress;
    private SparseArray<byte[]> manufacturerData;
    private int periodMillis;
    private short productPriPID;
    private byte productSubPID;
    private int rssi;
    private short serviceCapabilities;
    private byte[] serviceData;
    long timestamp;
    private int txPower;
    private List<ParcelUuid> uuids;

    public static class Builder {
        private BWDLDiscoveryData mBwdlDiscoveryData;

        public Builder() {
            this.mBwdlDiscoveryData = new BWDLDiscoveryData();
        }

        public BWDLDiscoveryData build() {
            return this.mBwdlDiscoveryData;
        }

        public Builder setAdvVersion(byte r8) {
            BWDLDiscoveryData.access$102(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setBWDLAdvertisingData(short r8, byte r10, byte[] r11, byte[] r12) {
            BWDLDiscoveryData.access$1700(this.mBwdlDiscoveryData).add(new BWDLAdvertisingData(r8, r10, r11, r12));
            if (BWDLDiscoveryData.access$1700(this.mBwdlDiscoveryData).size() != 1) goto L5;
            BWDLDiscoveryData r13 = this.mBwdlDiscoveryData;
            BWDLDiscoveryData.access$1802(r13, (BWDLAdvertisingData) BWDLDiscoveryData.access$1700(r13).get(0));
        L5:
            return this;
        }

        public Builder setBWDLDevice(Object r8) {
            BWDLDiscoveryData.access$2002(this.mBwdlDiscoveryData, new BWDLDevice(BWDLInnerConstant.ConnectivityType.GATT, r8, this.mBwdlDiscoveryData.getDeviceId()));
            return this;
        }

        public Builder setBattery(byte r8) {
            BWDLDiscoveryData.access$502(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setBluetoothDevice(BluetoothDevice r8) {
            BWDLDiscoveryData.access$1902(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setCompanyID(short r8) {
            BWDLDiscoveryData.access$002(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setConnected(boolean r8) {
            BWDLDiscoveryData.access$802(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setDeviceId(int r8) {
            BWDLDiscoveryData.access$602(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setDeviceName(String r8) {
            BWDLDiscoveryData.access$1002(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setDeviceType(int r8) {
            BWDLDiscoveryData.access$702(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setMacAddress(String r8) {
            BWDLDiscoveryData.access$902(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setManufacturerData(SparseArray<byte[]> r8) {
            BWDLDiscoveryData.access$1502(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setPeriodMillis(int r8) {
            BWDLDiscoveryData.access$1202(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setProductPriPID(short r8) {
            BWDLDiscoveryData.access$302(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setProductSubPID(byte r8) {
            BWDLDiscoveryData.access$402(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setRssi(int r8) {
            BWDLDiscoveryData.access$1102(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setServiceCapabilities(short r8) {
            BWDLDiscoveryData.access$202(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setServiceData(byte[] r8) {
            BWDLDiscoveryData.access$1402(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setTimeStamp(long r8) {
            if (r8 != (-1)) goto L5;
            BWDLDiscoveryData r10 = this.mBwdlDiscoveryData;
            r10.timestamp = System.currentTimeMillis();
        L6:
            return this;
        L5:
            this.mBwdlDiscoveryData.timestamp = r8;
            goto L6
        }

        public Builder setTxPower(int r8) {
            BWDLDiscoveryData.access$1302(this.mBwdlDiscoveryData, r8);
            return this;
        }

        public Builder setUuids(List<ParcelUuid> r8) {
            BWDLDiscoveryData.access$1602(this.mBwdlDiscoveryData, r8);
            return this;
        }
    }

    public BWDLDiscoveryData() {
        this.mBWDLAdvertisingData = new ArrayList();
    }

    public static /* synthetic */ short access$002(BWDLDiscoveryData r8, short r10) {
        r8.companyID = r10;
        return r10;
    }

    public static /* synthetic */ String access$1002(BWDLDiscoveryData r8, String r10) {
        r8.deviceName = r10;
        return r10;
    }

    public static /* synthetic */ byte access$102(BWDLDiscoveryData r8, byte r10) {
        r8.advVersion = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(BWDLDiscoveryData r8, int r10) {
        r8.rssi = r10;
        return r10;
    }

    public static /* synthetic */ int access$1202(BWDLDiscoveryData r8, int r10) {
        r8.periodMillis = r10;
        return r10;
    }

    public static /* synthetic */ int access$1302(BWDLDiscoveryData r8, int r10) {
        r8.txPower = r10;
        return r10;
    }

    public static /* synthetic */ byte[] access$1402(BWDLDiscoveryData r8, byte[] r10) {
        r8.serviceData = r10;
        return r10;
    }

    public static /* synthetic */ SparseArray access$1502(BWDLDiscoveryData r8, SparseArray r10) {
        r8.manufacturerData = r10;
        return r10;
    }

    public static /* synthetic */ List access$1602(BWDLDiscoveryData r8, List r10) {
        r8.uuids = r10;
        return r10;
    }

    public static /* synthetic */ List access$1700(BWDLDiscoveryData r8) {
        return r8.mBWDLAdvertisingData;
    }

    public static /* synthetic */ BWDLAdvertisingData access$1802(BWDLDiscoveryData r8, BWDLAdvertisingData r10) {
        r8.mAdvertisingData = r10;
        return r10;
    }

    public static /* synthetic */ BluetoothDevice access$1902(BWDLDiscoveryData r8, BluetoothDevice r10) {
        r8.mBluetoothDevice = r10;
        return r10;
    }

    public static /* synthetic */ BWDLDevice access$2002(BWDLDiscoveryData r8, BWDLDevice r10) {
        r8.mBWDLDevice = r10;
        return r10;
    }

    public static /* synthetic */ short access$202(BWDLDiscoveryData r8, short r10) {
        r8.serviceCapabilities = r10;
        return r10;
    }

    public static /* synthetic */ short access$302(BWDLDiscoveryData r8, short r10) {
        r8.productPriPID = r10;
        return r10;
    }

    public static /* synthetic */ byte access$402(BWDLDiscoveryData r8, byte r10) {
        r8.productSubPID = r10;
        return r10;
    }

    public static /* synthetic */ byte access$502(BWDLDiscoveryData r8, byte r10) {
        r8.battery = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(BWDLDiscoveryData r8, int r10) {
        r8.deviceId = r10;
        return r10;
    }

    public static /* synthetic */ int access$702(BWDLDiscoveryData r8, int r10) {
        r8.deviceType = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$802(BWDLDiscoveryData r8, boolean r10) {
        r8.connected = r10;
        return r10;
    }

    public static /* synthetic */ String access$902(BWDLDiscoveryData r8, String r10) {
        r8.macAddress = r10;
        return r10;
    }

    public BWDLAdvertisingData getAdvertisingData() {
        return this.mAdvertisingData;
    }

    public List<BWDLAdvertisingData> getBWDLAdvertisingData() {
        return this.mBWDLAdvertisingData;
    }

    public BWDLDevice getBWDLDevice() {
        return this.mBWDLDevice;
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.mBluetoothDevice;
    }

    public int getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public SparseArray<byte[]> getManufacturerData() {
        return this.manufacturerData;
    }

    public int getPeriodMillis() {
        return this.periodMillis;
    }

    public int getRssi() {
        return this.rssi;
    }

    public byte[] getServiceData() {
        return this.serviceData;
    }

    public long getTimeStamp() {
        return this.timestamp;
    }

    public int getTxPower() {
        return this.txPower;
    }

    public List<ParcelUuid> getUuids() {
        return this.uuids;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public boolean isTimeout(long r8) {
        if ((System.currentTimeMillis() - this.timestamp) <= r8) goto L5;
        return true;
    L5:
        return false;
    }

    public void setConnected(boolean r8) {
        this.connected = r8;
    }

    public void setDeviceType(int r8) {
        this.deviceType = r8;
    }

    public void updateTimeStamp(long r8) {
        this.timestamp = r8;
    }
}
