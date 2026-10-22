package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class LocationAwareInfo implements Parcelable {
    public static final Parcelable.Creator<LocationAwareInfo> CREATOR = null;
    private static final int VERSION = 1;
    private float mAltitudeAccuracyMeters;
    private double mAltitudeMeters;
    private float mBearingAccuracyDegrees;
    private float mBearingDegrees;
    private float mHorizontalAccuracyMeters;
    private double mLatitudeDegrees;
    private double mLongitudeDegrees;
    private String mProvider;
    private float mSpeedAccuracyMetersPerSecond;
    private float mSpeedMetersPerSecond;
    private long mTimestamp;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f5526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f5528c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f5529d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f5530e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public double f5531f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f5532g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f5533h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f5534i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f5535j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f5536k;

        public Builder() {
        }

        public static /* synthetic */ long a(Builder r8) {
            return r8.f5526a;
        }

        public static /* synthetic */ String b(Builder r8) {
            return r8.f5527b;
        }

        public static /* synthetic */ float c(Builder r8) {
            return r8.f5536k;
        }

        public static /* synthetic */ double d(Builder r8) {
            return r8.f5528c;
        }

        public static /* synthetic */ double e(Builder r8) {
            return r8.f5529d;
        }

        public static /* synthetic */ float f(Builder r8) {
            return r8.f5530e;
        }

        public static /* synthetic */ double g(Builder r8) {
            return r8.f5531f;
        }

        public static /* synthetic */ float h(Builder r8) {
            return r8.f5532g;
        }

        public static /* synthetic */ float i(Builder r8) {
            return r8.f5533h;
        }

        public static /* synthetic */ float j(Builder r8) {
            return r8.f5534i;
        }

        public static /* synthetic */ float k(Builder r8) {
            return r8.f5535j;
        }

        public LocationAwareInfo build() {
            return new LocationAwareInfo(this);
        }

        public Builder setAltitudeAccuracyMeters(float r8) {
            this.f5532g = r8;
            return this;
        }

        public Builder setAltitudeMeters(double r8) {
            this.f5531f = r8;
            return this;
        }

        public Builder setBearingAccuracyDegrees(float r8) {
            this.f5536k = r8;
            return this;
        }

        public Builder setBearingDegrees(float r8) {
            this.f5535j = r8;
            return this;
        }

        public Builder setHorizontalAccuracyMeters(float r8) {
            this.f5530e = r8;
            return this;
        }

        public Builder setLatitudeDegrees(double r8) {
            this.f5528c = r8;
            return this;
        }

        public Builder setLongitudeDegrees(double r8) {
            this.f5529d = r8;
            return this;
        }

        public Builder setProvider(String r8) {
            this.f5527b = r8;
            return this;
        }

        public Builder setSpeedAccuracyMetersPerSecond(float r8) {
            this.f5534i = r8;
            return this;
        }

        public Builder setSpeedMetersPerSecond(float r8) {
            this.f5533h = r8;
            return this;
        }

        public Builder setTimestamp(long r8) {
            this.f5526a = r8;
            return this;
        }
    }

    public class a implements Parcelable.Creator<LocationAwareInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LocationAwareInfo createFromParcel(Parcel r8) {
            return new LocationAwareInfo(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final LocationAwareInfo[] newArray(int r8) {
            return new LocationAwareInfo[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public LocationAwareInfo() {
    }

    public LocationAwareInfo(long r8, String r10, double r11, double r12, float r13, double r14, float r15, float r16, float r17, float r18, float r19) {
        this.mTimestamp = r8;
        this.mProvider = r10;
        this.mLatitudeDegrees = r11;
        this.mLongitudeDegrees = r12;
        this.mHorizontalAccuracyMeters = r13;
        this.mAltitudeMeters = r14;
        this.mAltitudeAccuracyMeters = r15;
        this.mSpeedMetersPerSecond = r16;
        this.mSpeedAccuracyMetersPerSecond = r17;
        this.mBearingDegrees = r18;
        this.mBearingAccuracyDegrees = r19;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getAltitudeAccuracyMeters() {
        return this.mAltitudeAccuracyMeters;
    }

    public double getAltitudeMeters() {
        return this.mAltitudeMeters;
    }

    public float getBearingAccuracyDegrees() {
        return this.mBearingAccuracyDegrees;
    }

    public float getBearingDegrees() {
        return this.mBearingDegrees;
    }

    public float getHorizontalAccuracyMeters() {
        return this.mHorizontalAccuracyMeters;
    }

    public double getLatitudeDegrees() {
        return this.mLatitudeDegrees;
    }

    public double getLongitudeDegrees() {
        return this.mLongitudeDegrees;
    }

    public String getProvider() {
        return this.mProvider;
    }

    public float getSpeedAccuracyMetersPerSecond() {
        return this.mSpeedAccuracyMetersPerSecond;
    }

    public float getSpeedMetersPerSecond() {
        return this.mSpeedMetersPerSecond;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getVersion() {
        return 1;
    }

    public void readFromParcel(Parcel r8) {
        this.mTimestamp = r8.readLong();
        this.mProvider = r8.readString();
        this.mLatitudeDegrees = r8.readDouble();
        this.mLongitudeDegrees = r8.readDouble();
        this.mHorizontalAccuracyMeters = r8.readFloat();
        this.mAltitudeMeters = r8.readDouble();
        this.mAltitudeAccuracyMeters = r8.readFloat();
        this.mSpeedMetersPerSecond = r8.readFloat();
        this.mSpeedAccuracyMetersPerSecond = r8.readFloat();
        this.mBearingDegrees = r8.readFloat();
        this.mBearingAccuracyDegrees = r8.readFloat();
    }

    public boolean sameLocation(LocationAwareInfo r8) {
        if (r8 != null) goto L4;
    L10:
        return false;
    L4:
        if (r8.mLatitudeDegrees != this.mLatitudeDegrees) goto L10;
        if (r8.mLongitudeDegrees != this.mLongitudeDegrees) goto L10;
        if (r8.mHorizontalAccuracyMeters != this.mHorizontalAccuracyMeters) goto L10;
        return true;
    }

    public String toString() {
        return "LocationAwareInfo[1," + this.mTimestamp + "," + this.mProvider + "," + this.mLatitudeDegrees + "," + this.mLongitudeDegrees + "," + this.mHorizontalAccuracyMeters + "," + this.mAltitudeMeters + "," + this.mAltitudeAccuracyMeters + "," + this.mSpeedMetersPerSecond + "," + this.mSpeedAccuracyMetersPerSecond + "," + this.mBearingDegrees + "," + this.mBearingAccuracyDegrees + ']';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeLong(this.mTimestamp);
        r8.writeString(this.mProvider);
        r8.writeDouble(this.mLatitudeDegrees);
        r8.writeDouble(this.mLongitudeDegrees);
        r8.writeFloat(this.mHorizontalAccuracyMeters);
        r8.writeDouble(this.mAltitudeMeters);
        r8.writeFloat(this.mAltitudeAccuracyMeters);
        r8.writeFloat(this.mSpeedMetersPerSecond);
        r8.writeFloat(this.mSpeedAccuracyMetersPerSecond);
        r8.writeFloat(this.mBearingDegrees);
        r8.writeFloat(this.mBearingAccuracyDegrees);
    }

    public LocationAwareInfo(Parcel r8) {
        this.mTimestamp = r8.readLong();
        this.mProvider = r8.readString();
        this.mLatitudeDegrees = r8.readDouble();
        this.mLongitudeDegrees = r8.readDouble();
        this.mHorizontalAccuracyMeters = r8.readFloat();
        this.mAltitudeMeters = r8.readDouble();
        this.mAltitudeAccuracyMeters = r8.readFloat();
        this.mSpeedMetersPerSecond = r8.readFloat();
        this.mSpeedAccuracyMetersPerSecond = r8.readFloat();
        this.mBearingDegrees = r8.readFloat();
        this.mBearingAccuracyDegrees = r8.readFloat();
    }

    public LocationAwareInfo(Builder r8) {
        this.mTimestamp = Builder.a(r8);
        this.mProvider = Builder.b(r8);
        this.mLatitudeDegrees = Builder.d(r8);
        this.mLongitudeDegrees = Builder.e(r8);
        this.mHorizontalAccuracyMeters = Builder.f(r8);
        this.mAltitudeMeters = Builder.g(r8);
        this.mAltitudeAccuracyMeters = Builder.h(r8);
        this.mSpeedMetersPerSecond = Builder.i(r8);
        this.mSpeedAccuracyMetersPerSecond = Builder.j(r8);
        this.mBearingDegrees = Builder.k(r8);
        this.mBearingAccuracyDegrees = Builder.c(r8);
    }

    public LocationAwareInfo(LocationAwareInfo r8) {
        this.mTimestamp = r8.getTimestamp();
        this.mProvider = r8.getProvider();
        this.mLatitudeDegrees = r8.getLatitudeDegrees();
        this.mLongitudeDegrees = r8.getLongitudeDegrees();
        this.mHorizontalAccuracyMeters = r8.getHorizontalAccuracyMeters();
        this.mAltitudeMeters = r8.getAltitudeMeters();
        this.mAltitudeAccuracyMeters = r8.getAltitudeAccuracyMeters();
        this.mSpeedMetersPerSecond = r8.getSpeedMetersPerSecond();
        this.mSpeedAccuracyMetersPerSecond = r8.getSpeedAccuracyMetersPerSecond();
        this.mBearingDegrees = r8.getBearingDegrees();
        this.mBearingAccuracyDegrees = r8.getBearingAccuracyDegrees();
    }
}
