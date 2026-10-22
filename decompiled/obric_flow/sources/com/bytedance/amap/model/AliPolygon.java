package com.bytedance.amap.model;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Polygon;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.IPolygon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l9.o;
import m.f0;

/* JADX INFO: loaded from: classes2.dex */
public class AliPolygon implements IPolygon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Polygon f3096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3097b;

    public AliPolygon(Polygon r5, String r10) {
        this.f3096a = r5;
        this.f3097b = r10;
    }

    public final void a(List r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.size() == 0) goto L20;
        ArrayList r5 = new ArrayList();     // Catch: Exception -> L10
        Iterator r11 = r10.iterator();     // Catch: Exception -> L10
    L8:
        if (r11.hasNext() == false) goto L12;
        BDLatLng r12 = (BDLatLng) r11.next();     // Catch: Exception -> L10
        r5.add(new LatLng(r12.f6917a, r12.f6918b));     // Catch: Exception -> L10
        goto L8
    L12:
        this.f3096a.setPoints(r5);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        f0.i(e, o.d("updatePoints error:", e), "AliPolygon");
        return;
    }

    public final void b(int r5) {
        this.f3096a.setStrokeColor(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setStrokeColor error:", e), "AliPolygon");
    }

    public final void b() {
        this.f3096a.remove();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("remove error:", e), "AliPolygon");
    }

    public final ArrayList a() {
        ArrayList r5 = new ArrayList();
        Iterator r10 = this.f3096a.getPoints().iterator();     // Catch: Exception -> L8
    L5:
        if (r10.hasNext() == false) goto L10;
        LatLng r11 = (LatLng) r10.next();     // Catch: Exception -> L8
        r5.add(new BDLatLng(r11.latitude, r11.longitude));     // Catch: Exception -> L8
    L10:
        return r5;
    L8:
        e = move-exception;
        f0.i(e, o.d("getPoints error:", e), "AliPolygon");
        goto L10
    }

    public final void a(int r5) {
        this.f3096a.setFillColor(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setFillColor error:", e), "AliPolygon");
    }

    public final void a(float r5) {
        this.f3096a.setStrokeWidth(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setLineWidth error:", e), "AliPolygon");
    }
}
