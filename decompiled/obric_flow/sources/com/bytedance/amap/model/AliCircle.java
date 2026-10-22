package com.bytedance.amap.model;

import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.ICircle;
import l9.o;
import m.f0;

/* JADX INFO: loaded from: classes2.dex */
public class AliCircle implements ICircle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Circle f3091a;

    public AliCircle(Circle r5) {
        this.f3091a = r5;
    }

    public final void a(BDLatLng r10) {
        this.f3091a.setCenter(new LatLng(r10.f6917a, r10.f6918b));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("updateCenter error:", e), "AliCircle");
    }

    public final void b(int r5) {
        this.f3091a.setStrokeColor(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setStrokeColor error:", e), "AliCircle");
    }

    public final void a(double r5) {
        this.f3091a.setRadius(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("updateRadius error:", e), "AliCircle");
    }

    public final void a(int r5) {
        this.f3091a.setFillColor(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setFillColor error:", e), "AliCircle");
    }

    public final void a(float r5) {
        this.f3091a.setStrokeWidth(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setLineWidth error:", e), "AliCircle");
    }

    public final void a() {
        this.f3091a.remove();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("remove error:", e), "AliCircle");
    }
}
