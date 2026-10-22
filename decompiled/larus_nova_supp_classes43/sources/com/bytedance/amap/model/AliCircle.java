package com.bytedance.amap.model;

import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.ICircle;
import com.bytedance.map.api.monitor.MapMonitor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AliCircle implements ICircle {
    private static final String TAG = "AliCircle";
    private Circle mCircle;
    private String mId;

    public double getRadius() {
        return this.mCircle.getRadius();
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "getRadius error:" + e.getMessage());
        return 0.0d;
    }

    public void remove() {
        this.mCircle.remove();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "remove error:" + e.getMessage());
    }

    private AliCircle() {
    }

    public String getId() {
        return this.mId;
    }

    public boolean contains(BDLatLng r10) {
        return this.mCircle.contains(new LatLng(r10.getLatitude(), r10.getLongitude()));
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "contains error:" + e.getMessage());
        return false;
    }

    public void setFillColor(int r10) {
        this.mCircle.setFillColor(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setFillColor error:" + e.getMessage());
    }

    public void setLineWidth(float r10) {
        this.mCircle.setStrokeWidth(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setLineWidth error:" + e.getMessage());
    }

    public void setStrokeColor(int r10) {
        this.mCircle.setStrokeColor(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setStrokeColor error:" + e.getMessage());
    }

    public void updateCenter(BDLatLng r10) {
        this.mCircle.setCenter(new LatLng(r10.getLatitude(), r10.getLongitude()));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "updateCenter error:" + e.getMessage());
    }

    public void updateRadius(double r10) {
        this.mCircle.setRadius(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "updateRadius error:" + e.getMessage());
    }

    public AliCircle(Circle r1, String r10) {
        this.mId = r10;
        this.mCircle = r1;
    }
}
