package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class BdimPredictEvent implements Parcelable {
    public static final Parcelable.Creator<BdimPredictEvent> CREATOR = null;
    private final String mActualCodType;
    private final String mAddress;
    private final String mCod;
    private final BluetoothDevice mDevice;
    private final String mIoCapability;
    private final String mManuf;
    private final String mMethod;
    private final String mName;
    private final String mServiceInfo;

    public class a implements Parcelable.Creator<BdimPredictEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BdimPredictEvent createFromParcel(Parcel r8) {
            return new BdimPredictEvent(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final BdimPredictEvent[] newArray(int r8) {
            return new BdimPredictEvent[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public BdimPredictEvent(BluetoothDevice r8, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        this.mDevice = r8;
        this.mAddress = r10;
        this.mName = r11;
        this.mServiceInfo = r12;
        this.mMethod = r13;
        this.mIoCapability = r14;
        this.mCod = r15;
        this.mManuf = r16;
        this.mActualCodType = r17;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getActualCodType() {
        return this.mActualCodType;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public String getCod() {
        return this.mCod;
    }

    public BluetoothDevice getDevice() {
        return this.mDevice;
    }

    public String getIoCapability() {
        return this.mIoCapability;
    }

    public String getManuf() {
        return this.mManuf;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public String getName() {
        return this.mName;
    }

    public String getServiceInfo() {
        return this.mServiceInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeParcelable(this.mDevice, r10);
        r8.writeString(this.mAddress);
        r8.writeString(this.mName);
        r8.writeString(this.mServiceInfo);
        r8.writeString(this.mMethod);
        r8.writeString(this.mIoCapability);
        r8.writeString(this.mCod);
        r8.writeString(this.mManuf);
        r8.writeString(this.mActualCodType);
    }

    public BdimPredictEvent(Parcel r8) {
        this.mDevice = (BluetoothDevice) r8.readParcelable(BluetoothDevice.class.getClassLoader());
        this.mAddress = r8.readString();
        this.mName = r8.readString();
        this.mServiceInfo = r8.readString();
        this.mMethod = r8.readString();
        this.mIoCapability = r8.readString();
        this.mCod = r8.readString();
        this.mManuf = r8.readString();
        this.mActualCodType = r8.readString();
    }
}
