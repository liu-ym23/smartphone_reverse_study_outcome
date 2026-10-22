package com.byted.mgl.merge.service.model;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BdpLocatePointStyle {
    public Bitmap locationIcon;
    public int radiusFillColor;
    public boolean showMyLocation;
    public int strokeColor;
    public float strokeWidth;

    public BdpLocatePointStyle() {
    }

    public int getRadiusFillColor() {
        return this.radiusFillColor;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public Bitmap getlocationIcon() {
        return this.locationIcon;
    }

    public boolean isShowMyLocation() {
        return this.showMyLocation;
    }

    public BdpLocatePointStyle locationIcon(Bitmap r1) {
        this.locationIcon = r1;
        return this;
    }

    public BdpLocatePointStyle radiusFillColor(int r1) {
        this.radiusFillColor = r1;
        return this;
    }

    public BdpLocatePointStyle showMyLocation(boolean r1) {
        this.showMyLocation = r1;
        return this;
    }

    public BdpLocatePointStyle strokeColor(int r1) {
        this.strokeColor = r1;
        return this;
    }

    public BdpLocatePointStyle strokeWidth(float r1) {
        this.strokeWidth = r1;
        return this;
    }

    public BdpLocatePointStyle(Bitmap r1, int r10, float r11, int r12, boolean r13) {
        this.locationIcon = r1;
        this.strokeColor = r10;
        this.strokeWidth = r11;
        this.radiusFillColor = r12;
        this.showMyLocation = r13;
    }
}
