package com.byted.mgl.merge.service.model;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface BdpMap {

    public interface GeocoderSearchedListener {
        void onGeocoderSearchedListener(boolean r1, BdpLatLng r10);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(BdpCameraPosition r1);

        void onCameraChangeFinish(BdpCameraPosition r1);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(BdpMarkerOptions r1);
    }

    public interface OnLocateChangeListener {
        void onLocationChanged(Location r1, String r10);
    }

    public interface OnMapClickListener {
        void onMapClick(BdpLatLng r1);
    }

    public interface OnMarkerClickListener {
        void onMarkerClick(BdpMarkerOptions r1);
    }

    public interface RegeocodeSearchedListener {
        void onRegeocodeSearchedListener(boolean r1, String r10, String r11);
    }

    public interface SearchRouteCompleteListener {
        void onSearchRouteComplete();
    }

    void addCircle(BdpCircleOptions r1);

    void addMarker(BdpMarkerOptions r1);

    void addPolyline(BdpPolylineOptions r1);

    void cleanCircles();

    void cleanMarkers();

    void cleanPolyLines();

    View createMapView(Activity r1);

    BdpLatLng getCenterLocation();

    BdpVisibleRegion getRegion();

    double getRotate();

    double getScale();

    double getSkew();

    void includePoints(List<BdpLatLng> r1);

    boolean isMyLocationShowing();

    boolean isRouteOverlayShowing();

    void moveCameraToLatLng(BdpLatLng r1);

    void onActivityCreated(Bundle r1);

    void onDestroy();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle r1);

    void queryAddressNameByLatLng(BdpLatLng r1, RegeocodeSearchedListener r10);

    void queryLatLngByAddressName(String r1, GeocoderSearchedListener r10);

    void removeRouteOverlay();

    void searchRouteAndShowOverlay(BdpLatLng r1, BdpLatLng r10, SearchRouteCompleteListener r11);

    void setHasGrantLocatingPermission(boolean r1);

    void setMyLocatePointStyle(BdpLocatePointStyle r1);

    void setOnCameraChangeListener(OnCameraChangeListener r1);

    void setOnInfoWindowClickListener(OnInfoWindowClickListener r1);

    void setOnLocationChangedListener(OnLocateChangeListener r1);

    void setOnMapClickListener(OnMapClickListener r1);

    void setOnMarkerClickListener(OnMarkerClickListener r1);

    void setScale(double r1);

    void showLocateBluePoint(Location r1);

    void startLocation();

    void stopLocation();
}
