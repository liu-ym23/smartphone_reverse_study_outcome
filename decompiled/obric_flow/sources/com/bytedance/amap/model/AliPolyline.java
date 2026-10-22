package com.bytedance.amap.model;

import android.graphics.Bitmap;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Polyline;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.IPolyline;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l9.o;
import m.f0;

/* JADX INFO: loaded from: classes2.dex */
public class AliPolyline implements IPolyline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Polyline f3098a;

    public AliPolyline(Polyline r5) {
        this.f3098a = r5;
    }

    public final void a(List r10) {
        ArrayList r5 = new ArrayList();     // Catch: Exception -> L6
        Iterator r11 = r10.iterator();     // Catch: Exception -> L6
    L4:
        if (r11.hasNext() == false) goto L8;
        BDLatLng r12 = (BDLatLng) r11.next();     // Catch: Exception -> L6
        r5.add(new LatLng(r12.f6917a, r12.f6918b));     // Catch: Exception -> L6
        goto L4
    L8:
        this.f3098a.setPoints(r5);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        f0.i(e, o.d("setPoints error:", e), "AliPolyline");
    }

    public final void b(float r5) {
        this.f3098a.setWidth(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setWidth error:", e), "AliPolyline");
    }

    public final void c(float r5) {
        this.f3098a.setZIndex(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setZIndex error:", e), "AliPolyline");
    }

    public final void a(int r5) {
        this.f3098a.setColor(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setColor error:", e), "AliPolyline");
    }

    public final void a(float r5) {
        this.f3098a.setTransparency(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setAlpha error:", e), "AliPolyline");
    }

    public final void a(boolean r5) {
        this.f3098a.setDottedLine(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setDottedLine error:", e), "AliPolyline");
    }

    public final void a(Bitmap r5) {
        this.f3098a.setCustomTexture(BitmapDescriptorFactory.fromBitmap(r5));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setCustomTexture error:", e), "AliPolyline");
    }

    public final void a() {
        this.f3098a.remove();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("remove error:", e), "AliPolyline");
    }
}
