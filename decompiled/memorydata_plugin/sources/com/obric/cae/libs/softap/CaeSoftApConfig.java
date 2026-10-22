package com.obric.cae.libs.softap;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class CaeSoftApConfig implements Parcelable {
    public static final Parcelable.Creator<CaeSoftApConfig> CREATOR = null;
    public static final int SECURITY_OPEN = 0;
    public static final int SECURITY_WPA2_PSK = 1;
    public static final int SECURITY_WPA2_WPA3_TRANSITION = 3;
    public static final int SECURITY_WPA3_SAE = 2;
    public static final int WIFI_STANDARD_WIFI6 = 6;
    public static final int WIFI_STANDARD_WIFI7 = 7;
    public int channel;
    public boolean enable160Mhz;
    public boolean hidden;
    public boolean metered;
    public String passphrase;
    public int securityType;
    public String ssid;
    public int wifiStandard;

    public class a implements Parcelable.Creator<CaeSoftApConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CaeSoftApConfig createFromParcel(Parcel r1) {
            return new CaeSoftApConfig(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final CaeSoftApConfig[] newArray(int r1) {
            return new CaeSoftApConfig[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CaeSoftApConfig() {
        this.securityType = 3;
        this.wifiStandard = 7;
        this.hidden = false;
        this.metered = false;
        this.enable160Mhz = true;
        this.channel = 36;
    }

    public CaeSoftApConfig(Parcel r5) {
        this.securityType = 3;
        int r0 = 7;
        this.wifiStandard = 7;
        boolean r1 = false;
        this.hidden = false;
        this.metered = false;
        this.enable160Mhz = true;
        this.channel = 36;
        this.ssid = r5.readString();
        this.passphrase = r5.readString();
        this.securityType = r5.readInt();
        if (r5.readInt() == 0) goto L5;
        boolean r3 = true;
    L6:
        this.hidden = r3;
        if (r5.readInt() == 0) goto L9;
        boolean r4 = true;
    L10:
        this.metered = r4;
        if (r5.readInt() == 0) goto L13;
        r1 = true;
    L13:
        this.enable160Mhz = r1;
        this.channel = r5.readInt();
        if (r5.dataAvail() <= 0) goto L16;
        r0 = r5.readInt();
    L16:
        this.wifiStandard = r0;
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.ssid);
        r1.writeString(this.passphrase);
        r1.writeInt(this.securityType);
        r1.writeInt(this.hidden ? 1 : 0);
        r1.writeInt(this.metered ? 1 : 0);
        r1.writeInt(this.enable160Mhz ? 1 : 0);
        r1.writeInt(this.channel);
        r1.writeInt(this.wifiStandard);
    }
}
