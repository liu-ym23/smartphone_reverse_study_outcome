package com.bytedance.amap.model;

import android.graphics.Bitmap;
import android.view.View;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.animation.AnimationSet;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.IMarker;
import l9.o;
import m.f0;

/* JADX INFO: loaded from: classes2.dex */
public class AliMarker implements IMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Marker f3093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3095c;

    public AliMarker(Marker r5, String r10) {
        this.f3095c = false;
        this.f3093a = r5;
        this.f3094b = r10;
    }

    public final void a(BDLatLng r10) {
        this.f3093a.setPosition(new LatLng(r10.f6917a, r10.f6918b));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("updatePosition error:", e), "AliMarker");
    }

    public final void b(float r5) {
        this.f3093a.setRotateAngle(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setRotateAngle error:", e), "AliMarker");
    }

    public final void c(float r5) {
        this.f3093a.setZIndex(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setZIndex error:", e), "AliMarker");
    }

    public final void b(boolean r5) {
        this.f3093a.setVisible(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setVisible error:", e), "AliMarker");
    }

    public final void a(Bitmap r5) {
        this.f3093a.setIcon(BitmapDescriptorFactory.fromBitmap(r5));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("updateMarkerIcon error:", e), "AliMarker");
    }

    public final void a(View r5) {
        this.f3093a.setIcon(BitmapDescriptorFactory.fromView(r5));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("updateMarkerIcon error:", e), "AliMarker");
    }

    public final void a(float r5) {
        this.f3093a.setAlpha(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setAlpha error:", e), "AliMarker");
    }

    public final void a(Object r5) {
    L6:
        e = move-exception;
        f0.i(e, o.d("startAnimation error:", e), "AliMarker");
        return;
    L3:
        if ((r5 instanceof AnimationSet) == false) goto L11;
        this.f3093a.setAnimation((Animation) r5);     // Catch: Exception -> L6
        this.f3093a.startAnimation();     // Catch: Exception -> L6
        return;
    }

    public final void a() {
        this.f3093a.destroy();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("destroy error:", e), "AliMarker");
    }

    public final void a(boolean r5) {
        this.f3093a.setClickable(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f0.i(e, o.d("setClickable error:", e), "AliMarker");
    }
}
