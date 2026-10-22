package com.bytedance.bdlocation;

import android.location.Address;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class BDAddress extends Address {
    private float accuracy;
    private double altitude;
    private float horizontalAccuracy;
    private float speed;
    private float verticalAccuracy;

    public BDAddress(Address r8) {
        super(r8.getLocale());
        setFeatureName(r8.getFeatureName());
        int r10 = 0;
    L4:
        if (r10 > r8.getMaxAddressLineIndex()) goto L6;
        setAddressLine(r10, r8.getAddressLine(r10));
        r10 = r10 + 1;
        goto L4
    L6:
        setAdminArea(r8.getAdminArea());
        setSubAdminArea(r8.getSubAdminArea());
        setLocality(r8.getLocality());
        setSubLocality(r8.getSubLocality());
        setThoroughfare(r8.getThoroughfare());
        setSubThoroughfare(r8.getSubThoroughfare());
        setPremises(r8.getPremises());
        setPostalCode(r8.getPostalCode());
        setCountryCode(r8.getCountryCode());
        setCountryName(r8.getCountryName());
        setLatitude(r8.getLatitude());
        setLongitude(r8.getLongitude());
        setUrl(r8.getUrl());
        setExtras(r8.getExtras());
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public float getHorizontalAccuracy() {
        return this.horizontalAccuracy;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getVerticalAccuracy() {
        return this.verticalAccuracy;
    }

    public void setAccuracy(float r8) {
        this.accuracy = r8;
    }

    public void setAltitude(double r8) {
        this.altitude = r8;
    }

    public void setHorizontalAccuracy(float r8) {
        this.horizontalAccuracy = r8;
    }

    public void setSpeed(float r8) {
        this.speed = r8;
    }

    public void setVerticalAccuracy(float r8) {
        this.verticalAccuracy = r8;
    }

    @Override // android.location.Address
    public String toString() {
        return "BDAddress{speed=" + this.speed + ", accuracy=" + this.accuracy + ", altitude=" + this.altitude + ", verticalAccuracy=" + this.verticalAccuracy + ", horizontalAccuracy=" + this.horizontalAccuracy + ", addr= " + super.toString() + '}';
    }

    public BDAddress(Locale r8) {
        super(r8);
    }
}
