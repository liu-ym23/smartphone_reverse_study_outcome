package com.byted.mgl.merge.service.model;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BdpLatLng implements Serializable {
    public double latitude;
    public double longitude;

    public BdpLatLng() {
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLatitude(double r1) {
        this.latitude = r1;
    }

    public void setLongitude(double r1) {
        this.longitude = r1;
    }

    public BdpLatLng(double r1, double r10) {
        this.latitude = r1;
        this.longitude = r10;
    }
}
