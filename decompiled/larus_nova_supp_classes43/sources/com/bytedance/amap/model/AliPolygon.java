package com.bytedance.amap.model;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Polygon;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.IPolygon;
import com.bytedance.map.api.monitor.MapMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AliPolygon implements IPolygon {
    private static final String TAG = "AliPolygon";
    private String mId;
    private Polygon mPolygon;

    public boolean isClickable() {
        return false;
    }

    public void setClickable(boolean r1) {
    }

    public List<BDLatLng> getPoints() {
        ArrayList r0 = new ArrayList();
        Iterator r1 = this.mPolygon.getPoints().iterator();     // Catch: Exception -> L8
    L5:
        if (r1.hasNext() == false) goto L10;
        LatLng r10 = (LatLng) r1.next();     // Catch: Exception -> L8
        r0.add(new BDLatLng(r10.latitude, r10.longitude));     // Catch: Exception -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "getPoints error:" + e.getMessage());
        goto L10
    }

    public void remove() {
        this.mPolygon.remove();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "remove error:" + e.getMessage());
    }

    public String getId() {
        return this.mId;
    }

    public Polygon getPolygon() {
        return this.mPolygon;
    }

    public void setFillColor(int r10) {
        this.mPolygon.setFillColor(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setFillColor error:" + e.getMessage());
    }

    public void setLineWidth(float r10) {
        this.mPolygon.setStrokeWidth(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setLineWidth error:" + e.getMessage());
    }

    public void setStrokeColor(int r10) {
        this.mPolygon.setStrokeColor(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setStrokeColor error:" + e.getMessage());
    }

    public void updatePoints(List<BDLatLng> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.size() == 0) goto L19;
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L12
        Iterator<BDLatLng> r11 = r10.iterator();     // Catch: Exception -> L12
    L8:
        if (r11.hasNext() == false) goto L10;
        BDLatLng r1 = r11.next();     // Catch: Exception -> L12
        r0.add(new LatLng(r1.getLatitude(), r1.getLongitude()));     // Catch: Exception -> L12
        goto L8
    L10:
        this.mPolygon.setPoints(r0);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "updatePoints error:" + e.getMessage());
        return;
    }

    public AliPolygon(Polygon r1, String r10) {
        this.mPolygon = r1;
        this.mId = r10;
    }
}
