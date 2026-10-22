package com.bytedance.amap.model;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.MapView;

/* JADX INFO: loaded from: classes2.dex */
public class AliMapView implements IMapView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MapView f3092a;

    public AliMapView(Context r5, AMapOptions r10) {
        this.f3092a = new MapView(r5, r10);
    }

    @Override // com.bytedance.amap.model.IMapView
    public final void a() {
        this.f3092a.onResume();
    }

    @Override // com.bytedance.amap.model.IMapView
    public final AMap b() {
        return this.f3092a.getMap();
    }

    @Override // com.bytedance.amap.model.IMapView
    public final void c() {
        this.f3092a.onCreate(null);
    }

    @Override // com.bytedance.amap.model.IMapView
    public final View d() {
        return this.f3092a;
    }

    @Override // com.bytedance.amap.model.IMapView
    public final void e() {
        this.f3092a.onPause();
    }

    @Override // com.bytedance.amap.model.IMapView
    public final void onDestroy() {
        this.f3092a.onDestroy();
    }

    @Override // com.bytedance.amap.model.IMapView
    public final void onLowMemory() {
        this.f3092a.onLowMemory();
    }

    @Override // com.bytedance.amap.model.IMapView
    public final void a(Bundle r5) {
        this.f3092a.onSaveInstanceState(r5);
    }
}
