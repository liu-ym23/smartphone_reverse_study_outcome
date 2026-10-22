package com.obric.cae.libs.softap;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
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
        public final CaeSoftApConfig createFromParcel(Parcel r8) {
            return new CaeSoftApConfig(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final CaeSoftApConfig[] newArray(int r8) {
            return new CaeSoftApConfig[r8];
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.ssid);
        r8.writeString(this.passphrase);
        r8.writeInt(this.securityType);
        r8.writeInt(this.hidden ? 1 : 0);
        r8.writeInt(this.metered ? 1 : 0);
        r8.writeInt(this.enable160Mhz ? 1 : 0);
        r8.writeInt(this.channel);
        r8.writeInt(this.wifiStandard);
    }

    public CaeSoftApConfig(Parcel r8) {
        this.securityType = 3;
        int r10 = 7;
        this.wifiStandard = 7;
        boolean r11 = false;
        this.hidden = false;
        this.metered = false;
        this.enable160Mhz = true;
        this.channel = 36;
        this.ssid = r8.readString();
        this.passphrase = r8.readString();
        this.securityType = r8.readInt();
        if (r8.readInt() == 0) goto L5;
        boolean r12 = true;
    L6:
        this.hidden = r12;
        if (r8.readInt() == 0) goto L9;
        boolean r13 = true;
    L10:
        this.metered = r13;
        if (r8.readInt() == 0) goto L13;
        r11 = true;
    L13:
        this.enable160Mhz = r11;
        this.channel = r8.readInt();
        if (r8.dataAvail() <= 0) goto L16;
        r10 = r8.readInt();
    L16:
        this.wifiStandard = r10;
        return;
    L9:
        r13 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }
}
