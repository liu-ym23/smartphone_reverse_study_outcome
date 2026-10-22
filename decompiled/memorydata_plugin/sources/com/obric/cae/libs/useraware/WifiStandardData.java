package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
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

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f7006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7007b;
        public String c;
        public int d;
        public int e;
        public int f;
        public int g;
        public long h;
        public long i;
        public int j;
        public int k;
        public int l;

        public a() {
            this.f7007b = "";
            this.c = "";
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = -1;
            this.l = 0;
        }

        public static /* synthetic */ long a(a r2) {
            return r2.f7006a;
        }

        public static /* synthetic */ String b(a r0) {
            return r0.f7007b;
        }

        public static /* synthetic */ String c(a r0) {
            return r0.c;
        }

        public static /* synthetic */ int d(a r0) {
            return r0.d;
        }

        public static /* synthetic */ int e(a r0) {
            return r0.e;
        }

        public static /* synthetic */ int f(a r0) {
            return r0.f;
        }

        public static /* synthetic */ int g(a r0) {
            return r0.g;
        }

        public static /* synthetic */ long h(a r2) {
            return r2.h;
        }

        public static /* synthetic */ long i(a r2) {
            return r2.i;
        }

        public static /* synthetic */ int j(a r0) {
            return r0.j;
        }

        public static /* synthetic */ int k(a r0) {
            return r0.k;
        }

        public static /* synthetic */ int l(a r0) {
            return r0.l;
        }

        public a a(int r1) {
            this.d = r1;
            return this;
        }

        public a a(long r1) {
            this.f7006a = r1;
            return this;
        }

        public a a(String r1) {
            this.f7007b = r1;
            return this;
        }

        public WifiStandardData a() {
            return new WifiStandardData(this);
        }

        public a b(int r1) {
            this.e = r1;
            return this;
        }

        public a b(long r1) {
            this.h = r1;
            return this;
        }

        public a b(String r1) {
            this.c = r1;
            return this;
        }

        public a c(int r1) {
            this.f = r1;
            return this;
        }

        public a c(long r1) {
            this.i = r1;
            return this;
        }

        public a d(int r1) {
            this.g = r1;
            return this;
        }

        public a e(int r1) {
            this.j = r1;
            return this;
        }

        public a f(int r1) {
            this.k = r1;
            return this;
        }

        public a g(int r1) {
            this.l = r1;
            return this;
        }
    }

    public class b implements Parcelable.Creator<WifiStandardData> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final WifiStandardData createFromParcel(Parcel r1) {
            return new WifiStandardData(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final WifiStandardData[] newArray(int r1) {
            return new WifiStandardData[r1];
        }
    }

    static {
        CREATOR = new b();
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

    public WifiStandardData(a r3) {
        this.mAuthType = 0;
        this.mApType = -1;
        this.mApStandard = 0;
        this.mTimestamp = a.a(r3);
        this.mBssid = a.b(r3);
        this.mSsid = a.c(r3);
        this.mSignalLevel = a.d(r3);
        this.mRssi = a.e(r3);
        this.mFrequency = a.f(r3);
        this.mBand = a.g(r3);
        this.mDataflow = a.h(r3);
        this.mUseTime = a.i(r3);
        this.mAuthType = a.j(r3);
        this.mApType = a.k(r3);
        this.mApStandard = a.l(r3);
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
        return "WifiStandardData[1," + this.mTimestamp + "," + com.obric.cae.libs.utils.f.a(this.mBssid) + "," + this.mSsid + "," + this.mSignalLevel + "," + this.mRssi + "," + this.mFrequency + "," + this.mBand + "," + this.mDataflow + "," + this.mUseTime + "," + this.mAuthType + "," + this.mApType + "," + this.mApStandard + ']';
    }

    public String toUnmaskedString() {
        return "WifiStandardData[1," + this.mTimestamp + "," + this.mBssid + "," + this.mSsid + "," + this.mSignalLevel + "," + this.mRssi + "," + this.mFrequency + "," + this.mBand + "," + this.mDataflow + "," + this.mUseTime + "," + this.mAuthType + "," + this.mApType + "," + this.mApStandard + ']';
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
