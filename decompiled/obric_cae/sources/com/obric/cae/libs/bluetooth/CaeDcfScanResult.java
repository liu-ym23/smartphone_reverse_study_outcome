package com.obric.cae.libs.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class CaeDcfScanResult implements Parcelable {
    public static final Parcelable.Creator<CaeDcfScanResult> CREATOR = null;
    private final String mDeviceId;
    private final byte[] mRawData;
    private final long mTimestamp;

    public class a implements Parcelable.Creator<CaeDcfScanResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CaeDcfScanResult createFromParcel(Parcel r8) {
            return new CaeDcfScanResult(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final CaeDcfScanResult[] newArray(int r8) {
            return new CaeDcfScanResult[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public CaeDcfScanResult(Parcel r8) {
        this.mDeviceId = r8.readString();
        this.mRawData = r8.createByteArray();
        this.mTimestamp = r8.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public byte[] getRawData() {
        return this.mRawData;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.mDeviceId);
        r8.writeByteArray(this.mRawData);
        r8.writeLong(this.mTimestamp);
    }

    public CaeDcfScanResult(String r8, byte[] r10, long r11) {
        this.mDeviceId = r8;
        this.mRawData = r10;
        this.mTimestamp = r11;
    }
}
