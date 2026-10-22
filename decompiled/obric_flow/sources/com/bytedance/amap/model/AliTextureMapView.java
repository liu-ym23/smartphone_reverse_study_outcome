package com.bytedance.amap.model;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.TextureMapView;

/* JADX INFO: loaded from: classes2.dex */
public class AliTextureMapView implements IMapView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextureMapView f3099a;

    public AliTextureMapView(Context r5, AMapOptions r10) {
        this.f3099a = new TextureMapView(r5, r10);
    }

    @Override // com.bytedance.amap.model.IMapView
    public final void a() {
        this.f3099a.onResume();
    }

    @Override // com.bytedance.amap.model.IMapView
    public final AMap b() {
        return this.f3099a.getMap();
    }

    @Override // com.bytedance.amap.model.IMapView
    public final void c() {
        this.f3099a.onCreate(null);
    }

    @Override // com.bytedance.amap.model.IMapView
    public final View d() {
        return this.f3099a;
    }

    @Override // com.bytedance.amap.model.IMapView
    public final void e() {
        this.f3099a.onPause();
    }

    @Override // com.bytedance.amap.model.IMapView
    public final void onDestroy() {
        this.f3099a.onDestroy();
    }

    @Override // com.bytedance.amap.model.IMapView
    public final void onLowMemory() {
        this.f3099a.onLowMemory();
    }

    @Override // com.bytedance.amap.model.IMapView
    public final void a(Bundle r5) {
        this.f3099a.onSaveInstanceState(r5);
    }
}
