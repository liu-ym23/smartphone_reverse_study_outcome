package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
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
        return "LocationAwareInfo[1," + this.mTimestamp + "," + this.mProvider + "," + this.mLatitudeDegrees + "," + this.mLongitudeDegrees + "," + this.mHorizontalAccuracyMeters + "," + this.mAltitudeMeters + "," + this.mAltitudeAccuracyMeters + "," + this.mSpeedMetersPerSecond + "," + this.mSpeedAccuracyMetersPerSecond + "," + this.mBearingDegrees + "," + this.mBearingAccuracyDegrees + ']';
    }

    public LocationAwareInfo() {
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

    public LocationAwareInfo(Parcel r3) {
        this.mTimestamp = r3.readLong();
        this.mProvider = r3.readString();
        this.mLatitudeDegrees = r3.readDouble();
        this.mLongitudeDegrees = r3.readDouble();
        this.mHorizontalAccuracyMeters = r3.readFloat();
        this.mAltitudeMeters = r3.readDouble();
        this.mAltitudeAccuracyMeters = r3.readFloat();
        this.mSpeedMetersPerSecond = r3.readFloat();
        this.mSpeedAccuracyMetersPerSecond = r3.readFloat();
        this.mBearingDegrees = r3.readFloat();
        this.mBearingAccuracyDegrees = r3.readFloat();
    }

    public void readFromParcel(Parcel r3) {
        this.mTimestamp = r3.readLong();
        this.mProvider = r3.readString();
        this.mLatitudeDegrees = r3.readDouble();
        this.mLongitudeDegrees = r3.readDouble();
        this.mHorizontalAccuracyMeters = r3.readFloat();
        this.mAltitudeMeters = r3.readDouble();
        this.mAltitudeAccuracyMeters = r3.readFloat();
        this.mSpeedMetersPerSecond = r3.readFloat();
        this.mSpeedAccuracyMetersPerSecond = r3.readFloat();
        this.mBearingDegrees = r3.readFloat();
        this.mBearingAccuracyDegrees = r3.readFloat();
    }

    public boolean sameLocation(LocationAwareInfo r6) {
        if (r6 != null) goto L4;
    L10:
        return false;
    L4:
        if (r6.mLatitudeDegrees != this.mLatitudeDegrees) goto L10;
        if (r6.mLongitudeDegrees != this.mLongitudeDegrees) goto L10;
        if (r6.mHorizontalAccuracyMeters != this.mHorizontalAccuracyMeters) goto L10;
        return true;
    }

    public LocationAwareInfo(Builder r3) {
        this.mTimestamp = Builder.a(r3);
        this.mProvider = Builder.b(r3);
        this.mLatitudeDegrees = Builder.d(r3);
        this.mLongitudeDegrees = Builder.e(r3);
        this.mHorizontalAccuracyMeters = Builder.f(r3);
        this.mAltitudeMeters = Builder.g(r3);
        this.mAltitudeAccuracyMeters = Builder.h(r3);
        this.mSpeedMetersPerSecond = Builder.i(r3);
        this.mSpeedAccuracyMetersPerSecond = Builder.j(r3);
        this.mBearingDegrees = Builder.k(r3);
        this.mBearingAccuracyDegrees = Builder.c(r3);
    }

    public LocationAwareInfo(LocationAwareInfo r3) {
        this.mTimestamp = r3.getTimestamp();
        this.mProvider = r3.getProvider();
        this.mLatitudeDegrees = r3.getLatitudeDegrees();
        this.mLongitudeDegrees = r3.getLongitudeDegrees();
        this.mHorizontalAccuracyMeters = r3.getHorizontalAccuracyMeters();
        this.mAltitudeMeters = r3.getAltitudeMeters();
        this.mAltitudeAccuracyMeters = r3.getAltitudeAccuracyMeters();
        this.mSpeedMetersPerSecond = r3.getSpeedMetersPerSecond();
        this.mSpeedAccuracyMetersPerSecond = r3.getSpeedAccuracyMetersPerSecond();
        this.mBearingDegrees = r3.getBearingDegrees();
        this.mBearingAccuracyDegrees = r3.getBearingAccuracyDegrees();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.mTimestamp);
        r3.writeString(this.mProvider);
        r3.writeDouble(this.mLatitudeDegrees);
        r3.writeDouble(this.mLongitudeDegrees);
        r3.writeFloat(this.mHorizontalAccuracyMeters);
        r3.writeDouble(this.mAltitudeMeters);
        r3.writeFloat(this.mAltitudeAccuracyMeters);
        r3.writeFloat(this.mSpeedMetersPerSecond);
        r3.writeFloat(this.mSpeedAccuracyMetersPerSecond);
        r3.writeFloat(this.mBearingDegrees);
        r3.writeFloat(this.mBearingAccuracyDegrees);
    }

    public LocationAwareInfo(long r1, String r3, double r4, double r6, float r8, double r9, float r11, float r12, float r13, float r14, float r15) {
        this.mTimestamp = r1;
        this.mProvider = r3;
        this.mLatitudeDegrees = r4;
        this.mLongitudeDegrees = r6;
        this.mHorizontalAccuracyMeters = r8;
        this.mAltitudeMeters = r9;
        this.mAltitudeAccuracyMeters = r11;
        this.mSpeedMetersPerSecond = r12;
        this.mSpeedAccuracyMetersPerSecond = r13;
        this.mBearingDegrees = r14;
        this.mBearingAccuracyDegrees = r15;
    }
}
