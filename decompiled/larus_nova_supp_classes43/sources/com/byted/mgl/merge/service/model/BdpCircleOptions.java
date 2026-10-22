package com.byted.mgl.merge.service.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BdpCircleOptions {
    public BdpLatLng center;
    public int fillColor;
    public double radius;
    public int strokeColor;
    public double strokeWidth;

    public BdpCircleOptions() {
    }

    public BdpLatLng getCenter() {
        return this.center;
    }

    public BdpCircleOptions center(BdpLatLng r1) {
        this.center = r1;
        return this;
    }

    public BdpCircleOptions fillColor(int r1) {
        this.fillColor = r1;
        return this;
    }

    public BdpCircleOptions radius(double r1) {
        this.radius = r1;
        return this;
    }

    public BdpCircleOptions strokeColor(int r1) {
        this.strokeColor = r1;
        return this;
    }

    public BdpCircleOptions strokeWidth(double r1) {
        this.strokeWidth = r1;
        return this;
    }
}
