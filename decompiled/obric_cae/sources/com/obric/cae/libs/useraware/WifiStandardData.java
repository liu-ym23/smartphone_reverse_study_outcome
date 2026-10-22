package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.cae.libs.utils.WifiUtils;

/* JADX INFO: loaded from: classes.dex */
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

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f5555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5556b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f5557c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5558d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f5559e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f5560f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f5561g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f5562h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f5563i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f5564j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f5565k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f5566l;

        public Builder() {
            this.f5556b = "";
            this.f5557c = "";
            this.f5558d = 0;
            this.f5559e = 0;
            this.f5560f = 0;
            this.f5561g = 0;
            this.f5562h = 0;
            this.f5563i = 0;
            this.f5564j = 0;
            this.f5565k = -1;
            this.f5566l = 0;
        }

        public static /* synthetic */ long a(Builder r8) {
            return r8.f5555a;
        }

        public static /* synthetic */ String b(Builder r8) {
            return r8.f5556b;
        }

        public static /* synthetic */ int c(Builder r8) {
            return r8.f5565k;
        }

        public static /* synthetic */ int d(Builder r8) {
            return r8.f5566l;
        }

        public static /* synthetic */ String e(Builder r8) {
            return r8.f5557c;
        }

        public static /* synthetic */ int f(Builder r8) {
            return r8.f5558d;
        }

        public static /* synthetic */ int g(Builder r8) {
            return r8.f5559e;
        }

        public static /* synthetic */ int h(Builder r8) {
            return r8.f5560f;
        }

        public static /* synthetic */ int i(Builder r8) {
            return r8.f5561g;
        }

        public static /* synthetic */ long j(Builder r8) {
            return r8.f5562h;
        }

        public static /* synthetic */ long k(Builder r8) {
            return r8.f5563i;
        }

        public static /* synthetic */ int l(Builder r8) {
            return r8.f5564j;
        }

        public WifiStandardData build() {
            return new WifiStandardData(this);
        }

        public Builder setApStandard(int r8) {
            this.f5566l = r8;
            return this;
        }

        public Builder setApType(int r8) {
            this.f5565k = r8;
            return this;
        }

        public Builder setAuthType(int r8) {
            this.f5564j = r8;
            return this;
        }

        public Builder setBand(int r8) {
            this.f5561g = r8;
            return this;
        }

        public Builder setBssid(String r8) {
            this.f5556b = r8;
            return this;
        }

        public Builder setDataflow(long r8) {
            this.f5562h = r8;
            return this;
        }

        public Builder setFrequency(int r8) {
            this.f5560f = r8;
            return this;
        }

        public Builder setRssi(int r8) {
            this.f5559e = r8;
            return this;
        }

        public Builder setSignalLevel(int r8) {
            this.f5558d = r8;
            return this;
        }

        public Builder setSsid(String r8) {
            this.f5557c = r8;
            return this;
        }

        public Builder setTimestamp(long r8) {
            this.f5555a = r8;
            return this;
        }

        public Builder setUseTime(long r8) {
            this.f5563i = r8;
            return this;
        }
    }

    public class a implements Parcelable.Creator<WifiStandardData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WifiStandardData createFromParcel(Parcel r8) {
            return new WifiStandardData(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final WifiStandardData[] newArray(int r8) {
            return new WifiStandardData[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public WifiStandardData(Parcel r8) {
        this.mAuthType = 0;
        this.mApType = -1;
        this.mApStandard = 0;
        this.mTimestamp = r8.readLong();
        this.mBssid = r8.readString();
        this.mSsid = r8.readString();
        this.mSignalLevel = r8.readInt();
        this.mRssi = r8.readInt();
        this.mFrequency = r8.readInt();
        this.mBand = r8.readInt();
        this.mDataflow = r8.readLong();
        this.mUseTime = r8.readLong();
        this.mAuthType = r8.readInt();
        this.mApType = r8.readInt();
        this.mApStandard = r8.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    public int getVersion() {
        return 1;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("WifiStandardData[1,");
        r8.append(this.mTimestamp);
        r8.append(",");
        r8.append(WifiUtils.maskMacAddress(this.mBssid));
        r8.append(",");
        r8.append(this.mSsid);
        r8.append(",");
        r8.append(this.mSignalLevel);
        r8.append(",");
        r8.append(this.mRssi);
        r8.append(",");
        r8.append(this.mFrequency);
        r8.append(",");
        r8.append(this.mBand);
        r8.append(",");
        r8.append(this.mDataflow);
        r8.append(",");
        r8.append(this.mUseTime);
        r8.append(",");
        r8.append(this.mAuthType);
        r8.append(",");
        r8.append(this.mApType);
        r8.append(",");
        return android.aimedia.a.f(r8, this.mApStandard, ']');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeLong(this.mTimestamp);
        r8.writeString(this.mBssid);
        r8.writeString(this.mSsid);
        r8.writeInt(this.mSignalLevel);
        r8.writeInt(this.mRssi);
        r8.writeInt(this.mFrequency);
        r8.writeInt(this.mBand);
        r8.writeLong(this.mDataflow);
        r8.writeLong(this.mUseTime);
        r8.writeInt(this.mAuthType);
        r8.writeInt(this.mApType);
        r8.writeInt(this.mApStandard);
    }

    public WifiStandardData(Builder r8) {
        this.mAuthType = 0;
        this.mApType = -1;
        this.mApStandard = 0;
        this.mTimestamp = Builder.a(r8);
        this.mBssid = Builder.b(r8);
        this.mSsid = Builder.e(r8);
        this.mSignalLevel = Builder.f(r8);
        this.mRssi = Builder.g(r8);
        this.mFrequency = Builder.h(r8);
        this.mBand = Builder.i(r8);
        this.mDataflow = Builder.j(r8);
        this.mUseTime = Builder.k(r8);
        this.mAuthType = Builder.l(r8);
        this.mApType = Builder.c(r8);
        this.mApStandard = Builder.d(r8);
    }
}
