package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
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

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f7002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7003b;
        public double c;
        public double d;
        public float e;
        public double f;
        public float g;
        public float h;
        public float i;
        public float j;
        public float k;

        public a() {
        }

        public static /* synthetic */ long a(a r2) {
            return r2.f7002a;
        }

        public static /* synthetic */ String b(a r0) {
            return r0.f7003b;
        }

        public static /* synthetic */ double c(a r2) {
            return r2.c;
        }

        public static /* synthetic */ double d(a r2) {
            return r2.d;
        }

        public static /* synthetic */ float e(a r0) {
            return r0.e;
        }

        public static /* synthetic */ double f(a r2) {
            return r2.f;
        }

        public static /* synthetic */ float g(a r0) {
            return r0.g;
        }

        public static /* synthetic */ float h(a r0) {
            return r0.h;
        }

        public static /* synthetic */ float i(a r0) {
            return r0.i;
        }

        public static /* synthetic */ float j(a r0) {
            return r0.j;
        }

        public static /* synthetic */ float k(a r0) {
            return r0.k;
        }

        public a a(double r1) {
            this.c = r1;
            return this;
        }

        public a a(float r1) {
            this.e = r1;
            return this;
        }

        public a a(long r1) {
            this.f7002a = r1;
            return this;
        }

        public a a(String r1) {
            this.f7003b = r1;
            return this;
        }

        public LocationAwareInfo a() {
            return new LocationAwareInfo(this);
        }

        public a b(double r1) {
            this.d = r1;
            return this;
        }

        public a b(float r1) {
            this.g = r1;
            return this;
        }

        public a c(double r1) {
            this.f = r1;
            return this;
        }

        public a c(float r1) {
            this.h = r1;
            return this;
        }

        public a d(float r1) {
            this.i = r1;
            return this;
        }

        public a e(float r1) {
            this.j = r1;
            return this;
        }

        public a f(float r1) {
            this.k = r1;
            return this;
        }
    }

    public class b implements Parcelable.Creator<LocationAwareInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final LocationAwareInfo createFromParcel(Parcel r1) {
            return new LocationAwareInfo(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final LocationAwareInfo[] newArray(int r1) {
            return new LocationAwareInfo[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    public LocationAwareInfo() {
    }

    public LocationAwareInfo(long r1, String r3, double r4, double r6, float r8, double r9, float r11, float r12, float r13, float r14, float r15) {
        this.mTimestamp = r1;
        this.mProvider = r3;
        this.mLatitudeDegrees = a(r4);
        this.mLongitudeDegrees = a(r6);
        this.mHorizontalAccuracyMeters = a(r8);
        this.mAltitudeMeters = a(r9);
        this.mAltitudeAccuracyMeters = a(r11);
        this.mSpeedMetersPerSecond = a(r12);
        this.mSpeedAccuracyMetersPerSecond = a(r13);
        this.mBearingDegrees = a(r14);
        this.mBearingAccuracyDegrees = a(r15);
    }

    public LocationAwareInfo(Parcel r3) {
        this.mTimestamp = r3.readLong();
        this.mProvider = r3.readString();
        this.mLatitudeDegrees = a(r3.readDouble());
        this.mLongitudeDegrees = a(r3.readDouble());
        this.mHorizontalAccuracyMeters = a(r3.readFloat());
        this.mAltitudeMeters = a(r3.readDouble());
        this.mAltitudeAccuracyMeters = a(r3.readFloat());
        this.mSpeedMetersPerSecond = a(r3.readFloat());
        this.mSpeedAccuracyMetersPerSecond = a(r3.readFloat());
        this.mBearingDegrees = a(r3.readFloat());
        this.mBearingAccuracyDegrees = a(r3.readFloat());
    }

    public LocationAwareInfo(a r3) {
        this.mTimestamp = a.a(r3);
        this.mProvider = a.b(r3);
        this.mLatitudeDegrees = a(a.c(r3));
        this.mLongitudeDegrees = a(a.d(r3));
        this.mHorizontalAccuracyMeters = a(a.e(r3));
        this.mAltitudeMeters = a(a.f(r3));
        this.mAltitudeAccuracyMeters = a(a.g(r3));
        this.mSpeedMetersPerSecond = a(a.h(r3));
        this.mSpeedAccuracyMetersPerSecond = a(a.i(r3));
        this.mBearingDegrees = a(a.j(r3));
        this.mBearingAccuracyDegrees = a(a.k(r3));
    }

    public LocationAwareInfo(LocationAwareInfo r3) {
        this.mTimestamp = r3.getTimestamp();
        this.mProvider = r3.getProvider();
        this.mLatitudeDegrees = a(r3.getLatitudeDegrees());
        this.mLongitudeDegrees = a(r3.getLongitudeDegrees());
        this.mHorizontalAccuracyMeters = a(r3.getHorizontalAccuracyMeters());
        this.mAltitudeMeters = a(r3.getAltitudeMeters());
        this.mAltitudeAccuracyMeters = a(r3.getAltitudeAccuracyMeters());
        this.mSpeedMetersPerSecond = a(r3.getSpeedMetersPerSecond());
        this.mSpeedAccuracyMetersPerSecond = a(r3.getSpeedAccuracyMetersPerSecond());
        this.mBearingDegrees = a(r3.getBearingDegrees());
        this.mBearingAccuracyDegrees = a(r3.getBearingAccuracyDegrees());
    }

    public static double a(double r1) {
        if (Double.isFinite(r1) == true) goto L7;
        return 0.0d;
    L7:
        return r1;
    }

    public static float a(float r1) {
        if (Float.isFinite(r1) == true) goto L7;
        return 0.0f;
    L7:
        return r1;
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

    public void readFromParcel(Parcel r3) {
        this.mTimestamp = r3.readLong();
        this.mProvider = r3.readString();
        this.mLatitudeDegrees = a(r3.readDouble());
        this.mLongitudeDegrees = a(r3.readDouble());
        this.mHorizontalAccuracyMeters = a(r3.readFloat());
        this.mAltitudeMeters = a(r3.readDouble());
        this.mAltitudeAccuracyMeters = a(r3.readFloat());
        this.mSpeedMetersPerSecond = a(r3.readFloat());
        this.mSpeedAccuracyMetersPerSecond = a(r3.readFloat());
        this.mBearingDegrees = a(r3.readFloat());
        this.mBearingAccuracyDegrees = a(r3.readFloat());
    }

    public boolean sameLocation(LocationAwareInfo r5) {
        if (r5 != null) goto L4;
    L10:
        return false;
    L4:
        if (r5.mLatitudeDegrees != this.mLatitudeDegrees) goto L10;
        if (r5.mLongitudeDegrees != this.mLongitudeDegrees) goto L10;
        if (r5.mHorizontalAccuracyMeters != this.mHorizontalAccuracyMeters) goto L10;
        return true;
    }

    public String toString() {
        return "LocationAwareInfo[1," + this.mTimestamp + "," + this.mProvider + "," + this.mLatitudeDegrees + "," + this.mLongitudeDegrees + "," + this.mHorizontalAccuracyMeters + "," + this.mAltitudeMeters + "," + this.mAltitudeAccuracyMeters + "," + this.mSpeedMetersPerSecond + "," + this.mSpeedAccuracyMetersPerSecond + "," + this.mBearingDegrees + "," + this.mBearingAccuracyDegrees + ']';
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
}
