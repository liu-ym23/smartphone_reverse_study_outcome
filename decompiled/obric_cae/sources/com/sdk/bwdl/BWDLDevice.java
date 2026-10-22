package com.sdk.bwdl;

import android.os.Parcel;
import android.os.Parcelable;
import com.sdk.bwdl.Utils.BWDLInnerConstant;

/* JADX INFO: loaded from: classes2.dex */
public class BWDLDevice implements Parcelable {
    public static final Parcelable.Creator<BWDLDevice> CREATOR = null;
    private int mDeviceId;
    private Object mDeviceInfo;
    private BWDLInnerConstant.ConnectivityType mType;

    static {
        CREATOR = new AnonymousClass1();
    }

    public BWDLDevice(Parcel r8) {
        this.mType = BWDLInnerConstant.ConnectivityType.values()[r8.readInt()];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BWDLInnerConstant.ConnectivityType getConnectivityType() {
        return this.mType;
    }

    public int getDeviceId() {
        return this.mDeviceId;
    }

    public Object getDeviceInfo() {
        return this.mDeviceInfo;
    }

    public void setDeviceId(int r8) {
        this.mDeviceId = r8;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mType.ordinal());
    }

    public BWDLDevice(BWDLInnerConstant.ConnectivityType r8, Object r10) {
        this.mType = r8;
        this.mDeviceInfo = r10;
    }

    public BWDLDevice(BWDLInnerConstant.ConnectivityType r8, Object r10, int r11) {
        this.mType = r8;
        this.mDeviceInfo = r10;
        this.mDeviceId = r11;
    }
}
