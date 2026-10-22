package com.obric.cae.libs.wifi;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class CaeWifiApInfo implements Parcelable {
    public static final Parcelable.Creator<CaeWifiApInfo> CREATOR = null;
    public String bssid;
    public int frequencyMhz;
    public int rssi;
    public String ssid;

    public class a implements Parcelable.Creator<CaeWifiApInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CaeWifiApInfo createFromParcel(Parcel r1) {
            return new CaeWifiApInfo(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final CaeWifiApInfo[] newArray(int r1) {
            return new CaeWifiApInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CaeWifiApInfo() {
    }

    public CaeWifiApInfo(Parcel r2) {
        this.ssid = r2.readString();
        this.bssid = r2.readString();
        this.frequencyMhz = r2.readInt();
        this.rssi = r2.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.ssid);
        r1.writeString(this.bssid);
        r1.writeInt(this.frequencyMhz);
        r1.writeInt(this.rssi);
    }
}
