package com.bytedance.map.api.listener;

import android.view.MotionEvent;
import com.bytedance.map.api.model.BDLatLng;

/* JADX INFO: loaded from: classes2.dex */
public interface MapActionListener {
    void onMapClick(BDLatLng r5);

    void onMapLoad();

    void onMapMove(BDLatLng r5);

    void onMapMoveEnd(BDLatLng r5);

    void onMapTouch(MotionEvent r5);

    void onMapZoom(float r5);

    void onMapZoomEnd(float r5);
}
