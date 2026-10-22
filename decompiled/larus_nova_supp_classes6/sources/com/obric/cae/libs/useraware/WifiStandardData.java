package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class WifiStandardData implements Parcelable {
    public static final int AP_TYPE_NORMAL = 0;
    public static final int AP_TYPE_SOFTAP = 1;
    public static final int AP_TYPE_UNKNOWN = -1;
    public static final int AUTH_ENTERPRISE = 1;
    public static final int AUTH_OPEN = 3;
    public static final int AUTH_PERSONAL = 2;
    public static final int AUTH_UNKNOWN = 0;
    public static final Parcelable.Creator<WifiStandardData> CREATOR = null;
    private static final String TAG = "WifiStandardData";
    private static final int VERSION = 1;
    public static final int WIFI_BAND_24_GHZ = 1;
    public static final int WIFI_BAND_5_GHZ = 2;
    public static final int WIFI_BAND_UNKNOWN = 0;
    public static final int WIFI_STANDARD_11AC = 5;
    public static final int WIFI_STANDARD_11AD = 7;
    public static final int WIFI_STANDARD_11AX = 6;
    public static final int WIFI_STANDARD_11BE = 8;
    public static final int WIFI_STANDARD_11N = 4;
    public static final int WIFI_STANDARD_LEGACY = 1;
    public static final int WIFI_STANDARD_UNKNOWN = 0;
    private int mApStandard;
    private int mApType;
    private int mAuthType;
    private int mBand;
    private String mBssid;
    private long mDataflow;
    private int mFrequency;
    private int mRssi;
    private int mSignalLevel;
    private String mSsid;
    private long mTimestamp;
    private long mUseTime;

    public class a implements Parcelable.Creator<WifiStandardData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WifiStandardData createFromParcel(Parcel r2) {
            return new WifiStandardData(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final WifiStandardData[] newArray(int r1) {
            return new WifiStandardData[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersion() {
        return 1;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "WifiStandardData[1," + this.mTimestamp + "," + this.mBssid + "," + this.mSsid + "," + this.mSignalLevel + "," + this.mRssi + "," + this.mFrequency + "," + this.mBand + "," + this.mDataflow + "," + this.mUseTime + "," + this.mAuthType + "," + this.mApType + "," + this.mApStandard + ']';
    }

    public int getApStandard() {
        return this.mApStandard;
    }

    public int getApType() {
        return this.mApType;
    }

    public int getAuthType() {
        return this.mAuthType;
    }

    public int getBand() {
        return this.mBand;
    }

    public String getBssid() {
        return this.mBssid;
    }

    public long getDataflow() {
        return this.mDataflow;
    }

    public int getFrequency() {
        return this.mFrequency;
    }

    public int getRssi() {
        return this.mRssi;
    }

    public int getSignalLevel() {
        return this.mSignalLevel;
    }

    public String getSsid() {
        return this.mSsid;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public long getUseTime() {
        return this.mUseTime;
    }

    public WifiStandardData(Parcel r3) {
        this.mAuthType = 0;
        this.mApType = -1;
        this.mApStandard = 0;
        this.mTimestamp = r3.readLong();
        this.mBssid = r3.readString();
        this.mSsid = r3.readString();
        this.mSignalLevel = r3.readInt();
        this.mRssi = r3.readInt();
        this.mFrequency = r3.readInt();
        this.mBand = r3.readInt();
        this.mDataflow = r3.readLong();
        this.mUseTime = r3.readLong();
        this.mAuthType = r3.readInt();
        this.mApType = r3.readInt();
        this.mApStandard = r3.readInt();
    }

    public WifiStandardData(Builder r3) {
        this.mAuthType = 0;
        this.mApType = -1;
        this.mApStandard = 0;
        this.mTimestamp = Builder.a(r3);
        this.mBssid = Builder.b(r3);
        this.mSsid = Builder.e(r3);
        this.mSignalLevel = Builder.f(r3);
        this.mRssi = Builder.g(r3);
        this.mFrequency = Builder.h(r3);
        this.mBand = Builder.i(r3);
        this.mDataflow = Builder.j(r3);
        this.mUseTime = Builder.k(r3);
        this.mAuthType = Builder.l(r3);
        this.mApType = Builder.c(r3);
        this.mApStandard = Builder.d(r3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.mTimestamp);
        r3.writeString(this.mBssid);
        r3.writeString(this.mSsid);
        r3.writeInt(this.mSignalLevel);
        r3.writeInt(this.mRssi);
        r3.writeInt(this.mFrequency);
        r3.writeInt(this.mBand);
        r3.writeLong(this.mDataflow);
        r3.writeLong(this.mUseTime);
        r3.writeInt(this.mAuthType);
        r3.writeInt(this.mApType);
        r3.writeInt(this.mApStandard);
    }
}
