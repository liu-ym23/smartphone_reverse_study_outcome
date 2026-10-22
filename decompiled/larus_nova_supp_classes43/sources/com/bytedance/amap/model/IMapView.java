package com.bytedance.amap.model;

import android.os.Bundle;
import android.view.View;
import com.amap.api.maps.AMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IMapView {
    AMap getMap();

    View getRealMapView();

    void onCreate(Bundle r1);

    void onDestroy();

    void onLowMemory();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle r1);
}
