package com.ss.android.lark.passport.signinsdk_api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class DeviceId implements Serializable, Parcelable {
    public static final Parcelable.Creator<DeviceId> CREATOR = null;
    private String deviceId;

    public class a implements Parcelable.Creator<DeviceId> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DeviceId createFromParcel(Parcel r2) {
            return new DeviceId(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final DeviceId[] newArray(int r1) {
            return new DeviceId[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public DeviceId(Parcel r1) {
        this.deviceId = r1.readString();
    }

    public void setDeviceId(String r1) {
        this.deviceId = r1;
    }

    public DeviceId(String r1) {
        this.deviceId = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.deviceId);
    }
}
