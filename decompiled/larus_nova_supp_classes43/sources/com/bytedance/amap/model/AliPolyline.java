package com.bytedance.amap.model;

import android.graphics.Bitmap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Polyline;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.IPolyline;
import com.bytedance.map.api.monitor.MapMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AliPolyline implements IPolyline {
    private static final String TAG = "AliPolyline";
    private String mId;
    private Polyline mPolyline;

    public boolean isCollideWithPoi() {
        return false;
    }

    public void setCollideWithPoi(boolean r1) {
    }

    public void remove() {
        this.mPolyline.remove();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "remove error:" + e.getMessage());
    }

    private AliPolyline() {
    }

    public String getId() {
        return this.mId;
    }

    public Polyline getPolyline() {
        return this.mPolyline;
    }

    public void setAlpha(float r10) {
        this.mPolyline.setTransparency(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setAlpha error:" + e.getMessage());
    }

    public void setColor(int r10) {
        this.mPolyline.setColor(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setColor error:" + e.getMessage());
    }

    public void setColorList(List<Integer> r10) {
    L29:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setColorList error:" + e.getMessage());
        return;
    L3:
        if (this.mPolyline == null) goto L28;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.isEmpty() == false) goto L9;
        return;
    L9:
        if (r10.size() != 1) goto L15;
        if (ListProtector.get(r10, 0) == null) goto L15;
        setColor(((Integer) ListProtector.get(r10, 0)).intValue());     // Catch: Exception -> L29
        return;
    L15:
        if (this.mPolyline.getOptions() != null) goto L17;
        return;
    L17:
        if (r10.isEmpty() == true) goto L39;
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L29
        Iterator<Integer> r11 = r10.iterator();     // Catch: Exception -> L29
    L20:
        if (r11.hasNext() == false) goto L26;
        Integer r1 = r11.next();     // Catch: Exception -> L29
        if (r1 == null) goto L24;
        int r12 = r1.intValue();     // Catch: Exception -> L29
    L25:
        r0.add(Integer.valueOf(r12));     // Catch: Exception -> L29
        goto L20
    L24:
        r12 = 0;
        goto L25
    L26:
        this.mPolyline.setOptions(this.mPolyline.getOptions().colorValues(r0));     // Catch: Exception -> L29
        return;
    L39:
        return;
    }

    public void setCustomTexture(Bitmap r10) {
        this.mPolyline.setCustomTexture(BitmapDescriptorFactory.fromBitmap(r10));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setCustomTexture error:" + e.getMessage());
    }

    public void setCustomTextureList(List<Bitmap> r10) {
    L19:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setCustomTextureList error:" + e.getMessage());
        return;
    L3:
        if (this.mPolyline == null) goto L33;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.isEmpty() == true) goto L35;
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L19
        Iterator<Bitmap> r11 = r10.iterator();     // Catch: Exception -> L19
    L9:
        if (r11.hasNext() == false) goto L17;
        Bitmap r1 = r11.next();     // Catch: Exception -> L19
        if (r1 == null) goto L9;
        BitmapDescriptor r12 = BitmapDescriptorFactory.fromBitmap(r1);     // Catch: Exception -> L19
        if (r12 == null) goto L9;
        r0.add(r12);     // Catch: Exception -> L19
        goto L9
    L17:
        this.mPolyline.setCustomTextureList(r0);     // Catch: Exception -> L19
        return;
    L35:
        return;
    }

    public void setDottedLine(boolean r10) {
        this.mPolyline.setDottedLine(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setDottedLine error:" + e.getMessage());
    }

    public void setPoints(List<BDLatLng> r10) {
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L8
        Iterator<BDLatLng> r11 = r10.iterator();     // Catch: Exception -> L8
    L4:
        if (r11.hasNext() == false) goto L6;
        BDLatLng r1 = r11.next();     // Catch: Exception -> L8
        r0.add(new LatLng(r1.getLatitude(), r1.getLongitude()));     // Catch: Exception -> L8
        goto L4
    L6:
        this.mPolyline.setPoints(r0);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setPoints error:" + e.getMessage());
    }

    public void setTextureIndexList(List<Integer> r10) {
    L9:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setTextureIndexList error:" + e.getMessage());
        return;
    L3:
        if (this.mPolyline == null) goto L14;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.isEmpty() == true) goto L16;
        this.mPolyline.setCustomTextureIndex(r10);     // Catch: Exception -> L9
        return;
    L16:
        return;
    }

    public void setWidth(float r10) {
        this.mPolyline.setWidth(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setWidth error:" + e.getMessage());
    }

    public void setZIndex(float r10) {
        this.mPolyline.setZIndex(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setZIndex error:" + e.getMessage());
    }

    public AliPolyline(Polyline r1, String r10) {
        this.mPolyline = r1;
        this.mId = r10;
    }
}
