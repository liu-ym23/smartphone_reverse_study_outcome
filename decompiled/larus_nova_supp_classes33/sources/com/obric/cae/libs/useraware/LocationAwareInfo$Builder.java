package com.obric.cae.libs.useraware;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class LocationAwareInfo$Builder {
    public long a;
    public String b;
    public double c;
    public double d;
    public float e;
    public double f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;

    public LocationAwareInfo$Builder() {
    }

    public LocationAwareInfo build() {
        return new LocationAwareInfo(this);
    }

    public static /* synthetic */ long a(LocationAwareInfo$Builder r2) {
        return r2.a;
    }

    public static /* synthetic */ String b(LocationAwareInfo$Builder r0) {
        return r0.b;
    }

    public static /* synthetic */ float c(LocationAwareInfo$Builder r0) {
        return r0.k;
    }

    public static /* synthetic */ double d(LocationAwareInfo$Builder r2) {
        return r2.c;
    }

    public static /* synthetic */ double e(LocationAwareInfo$Builder r2) {
        return r2.d;
    }

    public static /* synthetic */ float f(LocationAwareInfo$Builder r0) {
        return r0.e;
    }

    public static /* synthetic */ double g(LocationAwareInfo$Builder r2) {
        return r2.f;
    }

    public static /* synthetic */ float h(LocationAwareInfo$Builder r0) {
        return r0.g;
    }

    public static /* synthetic */ float i(LocationAwareInfo$Builder r0) {
        return r0.h;
    }

    public static /* synthetic */ float j(LocationAwareInfo$Builder r0) {
        return r0.i;
    }

    public static /* synthetic */ float k(LocationAwareInfo$Builder r0) {
        return r0.j;
    }

    public LocationAwareInfo$Builder setAltitudeAccuracyMeters(float r1) {
        this.g = r1;
        return this;
    }

    public LocationAwareInfo$Builder setAltitudeMeters(double r1) {
        this.f = r1;
        return this;
    }

    public LocationAwareInfo$Builder setBearingAccuracyDegrees(float r1) {
        this.k = r1;
        return this;
    }

    public LocationAwareInfo$Builder setBearingDegrees(float r1) {
        this.j = r1;
        return this;
    }

    public LocationAwareInfo$Builder setHorizontalAccuracyMeters(float r1) {
        this.e = r1;
        return this;
    }

    public LocationAwareInfo$Builder setLatitudeDegrees(double r1) {
        this.c = r1;
        return this;
    }

    public LocationAwareInfo$Builder setLongitudeDegrees(double r1) {
        this.d = r1;
        return this;
    }

    public LocationAwareInfo$Builder setProvider(String r1) {
        this.b = r1;
        return this;
    }

    public LocationAwareInfo$Builder setSpeedAccuracyMetersPerSecond(float r1) {
        this.i = r1;
        return this;
    }

    public LocationAwareInfo$Builder setSpeedMetersPerSecond(float r1) {
        this.h = r1;
        return this;
    }

    public LocationAwareInfo$Builder setTimestamp(long r1) {
        this.a = r1;
        return this;
    }
}
