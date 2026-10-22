package com.bytedance.amap.model;

import android.os.Bundle;
import android.view.View;
import com.amap.api.maps.AMap;

/* JADX INFO: loaded from: classes2.dex */
public interface IMapView {
    void a();

    void a(Bundle r5);

    AMap b();

    void c();

    View d();

    void e();

    void onDestroy();

    void onLowMemory();
}
