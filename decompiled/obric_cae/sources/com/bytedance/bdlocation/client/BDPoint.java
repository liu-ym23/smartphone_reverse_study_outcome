package com.bytedance.bdlocation.client;

import com.obric.cae.userAware.report.SubwayEvaluationEvent;

/* JADX INFO: loaded from: classes.dex */
public class BDPoint {
    private String coordinateSystem;
    private double latitude;
    private double longitude;
    private String provider;

    public BDPoint() {
        this(LocationInfoConst.SYSTEM);
    }

    public boolean equals(Object r8) {
        if ((r8 instanceof BDPoint) == true) goto L5;
        return false;
    L5:
        BDPoint r10 = (BDPoint) r8;
        if (this.latitude == r10.latitude) goto L9;
        return false;
    L9:
        if (this.longitude != r10.longitude) goto L12;
        return true;
    L12:
        return false;
    }

    public String getCoordinateSystem() {
        return this.coordinateSystem;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getProvider() {
        return this.provider;
    }

    public int hashCode() {
        return Double.valueOf((this.latitude + this.longitude) * 1000000.0d).intValue();
    }

    public void setCoordinateSystem(String r8) {
        this.coordinateSystem = r8;
    }

    public void setLatitude(double r8) {
        if (r8 <= 90.0d) goto L6;
        r8 = 90.0d;
    L6:
        if (r8 >= (-90.0d)) goto L8;
        r8 = -90.0d;
    L8:
        this.latitude = r8;
    }

    public void setLongitude(double r8) {
        if (r8 <= 180.0d) goto L6;
        r8 = 180.0d;
    L6:
        if (r8 >= (-180.0d)) goto L8;
        r8 = -180.0d;
    L8:
        this.longitude = r8;
    }

    public void setProvider(String r8) {
        this.provider = r8;
    }

    public String toString() {
        return "BDPoint{provider='" + this.provider + "', longitude=" + this.longitude + ", latitude=" + this.latitude + ", coordinateSystem=" + this.coordinateSystem + '}';
    }

    public BDPoint(double r8, double r10) {
        this(r8, r10, SubwayEvaluationEvent.VERIFY_METHOD_NONE);
    }

    public BDPoint(double r8, double r10, String r11) {
        this.longitude = 0.0d;
        this.latitude = 0.0d;
        if (r10 <= 180.0d) goto L6;
        r10 = 180.0d;
    L6:
        if (r10 >= (-180.0d)) goto L9;
        r10 = -180.0d;
    L9:
        if (r8 <= 90.0d) goto L12;
        r8 = 90.0d;
    L12:
        if (r8 >= (-90.0d)) goto L14;
        r8 = -90.0d;
    L14:
        this.longitude = r10;
        this.latitude = r8;
        this.provider = r11;
    }

    public BDPoint(double r8, double r10, String r11, String r12) {
        this(r8, r10, r11);
        this.coordinateSystem = r12;
    }

    public BDPoint(String r8) {
        this.longitude = 0.0d;
        this.latitude = 0.0d;
        this.provider = r8;
    }
}
