package com.bytedance.map.api;

import android.content.Context;
import android.graphics.Point;
import android.view.ViewGroup;
import com.bytedance.map.api.listener.MapActionListener;
import com.bytedance.map.api.listener.MarkerActionListener;
import com.bytedance.map.api.model.BDCircleOptions;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.BDMarkerOptions;
import com.bytedance.map.api.model.BDPolygonOptions;
import com.bytedance.map.api.model.BDPolylineOptions;
import com.bytedance.map.api.model.ICircle;
import com.bytedance.map.api.model.IMarker;
import com.bytedance.map.api.model.IPolygon;
import com.bytedance.map.api.model.IPolyline;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IMapService {
    ICircle addCircle(BDCircleOptions r5);

    void addMapActionListener(MapActionListener r5);

    IMarker addMarker(BDMarkerOptions r5);

    void addMarkerActionListener(MarkerActionListener r5);

    IPolygon addPolygon(BDPolygonOptions r5);

    IPolyline addPolyline(BDPolylineOptions r5);

    void attachToParentView(ViewGroup r5);

    BDLatLng getCenter();

    int getMapType();

    float getRotationDegree();

    Map getVisibleRegion();

    float getZoom();

    void initMap(MapInitConfig r5);

    boolean isAvailable(Context r5);

    boolean isRotateGesturesEnabled();

    boolean isScrollGesturesEnabled();

    boolean isTiltGesturesEnabled();

    boolean isZoomGesturesEnabled();

    void onDestroy();

    void onStart();

    void removeMarker(IMarker r5);

    void setAllGesturesEnabled(boolean r5);

    void setBound(List r5, int r10, int r11, int r12, int r13, boolean r14);

    void setBound(List r5, int r10, int r11, int r12, int r13, boolean r14, int r15);

    void setCenter(BDLatLng r5, boolean r10);

    void setCenter(BDLatLng r5, boolean r10, int r11);

    void setCenterAndZoom(BDLatLng r5, float r10, boolean r11, int r12);

    void setCustomMapStyle(boolean r5, String r10);

    void setHandleGesture(boolean r5);

    void setLimitRegion(BDLatLng r5, BDLatLng r10);

    void setMaxZoomLevel(float r5);

    void setMinZoomLevel(float r5);

    void setMyLocationButtonEnabled(boolean r5);

    void setRotateGesturesEnabled(boolean r5);

    void setRotationDegree(float r5, boolean r10, int r11);

    void setScrollGesturesEnabled(boolean r5);

    void setTiltGesturesEnabled(boolean r5);

    void setZoom(float r5, boolean r10);

    void setZoom(float r5, boolean r10, int r11);

    void setZoomGesturesEnabled(boolean r5);

    void startMarkerAnimation(IMarker r5, List r10);

    Point transLatLngToPoint(BDLatLng r5);

    BDLatLng transPointToLatLng(Point r5);
}
