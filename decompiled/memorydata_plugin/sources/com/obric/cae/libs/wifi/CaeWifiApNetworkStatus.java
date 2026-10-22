package com.obric.cae.libs.wifi;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class CaeWifiApNetworkStatus implements Parcelable {
    public static final Parcelable.Creator<CaeWifiApNetworkStatus> CREATOR = null;
    public static final int STATUS_NO_INTERNET = 1;
    public static final int STATUS_NO_RECORD = -1;
    public static final int STATUS_PORTAL = 2;
    public static final int STATUS_VALIDATED = 0;
    public String dbSsid;
    public String inputBssid;
    public String inputSsid;
    public long lastStatusTime;
    public int networkStatus;
    public long updateTime;

    public class a implements Parcelable.Creator<CaeWifiApNetworkStatus> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CaeWifiApNetworkStatus createFromParcel(Parcel r1) {
            return new CaeWifiApNetworkStatus(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final CaeWifiApNetworkStatus[] newArray(int r1) {
            return new CaeWifiApNetworkStatus[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CaeWifiApNetworkStatus() {
        this.networkStatus = -1;
    }

    public CaeWifiApNetworkStatus(Parcel r3) {
        this.networkStatus = -1;
        this.inputSsid = r3.readString();
        this.inputBssid = r3.readString();
        this.dbSsid = r3.readString();
        this.networkStatus = r3.readInt();
        this.lastStatusTime = r3.readLong();
        this.updateTime = r3.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.inputSsid);
        r3.writeString(this.inputBssid);
        r3.writeString(this.dbSsid);
        r3.writeInt(this.networkStatus);
        r3.writeLong(this.lastStatusTime);
        r3.writeLong(this.updateTime);
    }
}
