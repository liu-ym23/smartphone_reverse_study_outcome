package com.bytedance.amap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.VisibleRegion;
import com.amap.api.maps.model.animation.AlphaAnimation;
import com.amap.api.maps.model.animation.AnimationSet;
import com.amap.api.maps.model.animation.ScaleAnimation;
import com.bytedance.amap.depend.MonitorDependImpl;
import com.bytedance.amap.model.AliCircle;
import com.bytedance.amap.model.AliMapView;
import com.bytedance.amap.model.AliMarker;
import com.bytedance.amap.model.AliPolygon;
import com.bytedance.amap.model.AliPolyline;
import com.bytedance.amap.model.AliTextureMapView;
import com.bytedance.amap.model.IMapView;
import com.bytedance.amap.utils.FileUtil;
import com.bytedance.map.api.IMapService;
import com.bytedance.map.api.MapInitConfig;
import com.bytedance.map.api.animation.AnimationStyle;
import com.bytedance.map.api.listener.CancelableCallback;
import com.bytedance.map.api.listener.MapActionListener;
import com.bytedance.map.api.listener.MapScreenShotListener;
import com.bytedance.map.api.listener.MarkerActionListener;
import com.bytedance.map.api.listener.PoiClickListener;
import com.bytedance.map.api.model.BDCircleOptions;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.BDMarkerOptions;
import com.bytedance.map.api.model.BDPolygonOptions;
import com.bytedance.map.api.model.BDPolylineOptions;
import com.bytedance.map.api.model.ICircle;
import com.bytedance.map.api.model.IInfoWindowProvider;
import com.bytedance.map.api.model.IMarker;
import com.bytedance.map.api.model.IPolygon;
import com.bytedance.map.api.model.IPolyline;
import com.bytedance.map.api.monitor.MapMonitor;
import com.bytedance.map.api.monitor.MapMonitorUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import l9.o;
import m.f0;
import mn.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class AMapServiceImpl implements IMapService, AMap.OnMapLoadedListener, AMap.OnCameraChangeListener, AMap.OnMapClickListener, AMap.OnMapTouchListener, AMap.OnMarkerClickListener, AMap.OnPOIClickListener {
    private static final LatLng DEFAULT_MAP_CENTER = null;
    private static final String TAG = "AMapServiceImpl";
    private AMap mAMap;
    private List<ICircle> mAliCircles;
    private List<IMarker> mAliMarkers;
    private List<IPolygon> mAliPolygons;
    private List<IPolyline> mAliPolylines;
    private IInfoWindowProvider mInfoWindowProvider;
    private boolean mIsMapLoad;
    private double mLastEndLat;
    private double mLastEndLng;
    private float mLastEndZoom;
    private double mLastLat;
    private double mLastLng;
    private float mLastZoom;
    private List<MapActionListener> mMapActionListenerList;
    private long mMapCreateTime;
    private volatile IMapView mMapView;
    private List<MarkerActionListener> mMarkerActionListenerList;
    private CopyOnWriteArrayList<PoiClickListener> mPoiClickListeners;

    static {
        DEFAULT_MAP_CENTER = new LatLng(39.90403d, 116.407525d);
    }

    public AMapServiceImpl() {
        this.mMapActionListenerList = new ArrayList();
        this.mMarkerActionListenerList = new ArrayList();
        this.mPoiClickListeners = new CopyOnWriteArrayList();
        this.mAliMarkers = new ArrayList();
        this.mAliPolylines = new ArrayList();
        this.mAliCircles = new ArrayList();
        this.mAliPolygons = new ArrayList();
        this.mIsMapLoad = false;
        this.mLastZoom = -1.0f;
        this.mLastEndZoom = -1.0f;
        this.mLastLat = -1.0d;
        this.mLastLng = -1.0d;
        this.mLastEndLat = -1.0d;
        this.mLastEndLng = -1.0d;
    }

    public static /* synthetic */ IInfoWindowProvider access$000(AMapServiceImpl r5) {
        r5.getClass();
        return null;
    }

    public static /* synthetic */ List access$100(AMapServiceImpl r5) {
        return r5.mAliMarkers;
    }

    private void changeCamera(CameraUpdate r5, boolean r10, int r11, @Nullable CancelableCallback r12) {
        AMap r13 = this.mAMap;
        if (r13 != null) goto L8;
        if (r10 == false) goto L27;
        if (r12 == null) goto L28;
        r12.a();
        return;
    L28:
        return;
    L27:
        return;
    L8:
        if (r11 > 0) goto L26;
        r11 = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    L26:
        if (r10 == false) goto L19;
        long r14 = r11;
        if (r12 != null) goto L14;
        AMap.CancelableCallback r15 = null;
    L15:
        r13.animateCamera(r5, r14, r15);     // Catch: Exception -> L17
        return;
    L14:
        r15 = new AnonymousClass1();     // Catch: Exception -> L17
        goto L15
    L19:
        r13.moveCamera(r5);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        f0.i(e, o.d("changeCamera error:", e), TAG);
        if (r10 == false) goto L29;
        if (r12 == null) goto L30;
        r12.a();
        return;
    L30:
        return;
    }

    @Override // com.bytedance.map.api.IMapService
    public ICircle addCircle(BDCircleOptions r10) {
        if (this.mAMap == null) goto L13;
        if (r10 == null) goto L13;
        BDLatLng r5 = r10.f6914a;
        if (r5 != null) goto L14;
        return null;
    L14:
        CircleOptions r11 = new CircleOptions().center(new LatLng(r5.f6917a, r5.f6918b)).radius(r10.f6915b).zIndex(0.0f).fillColor(r10.f6916c).strokeColor(r10.d).strokeWidth(r10.e);     // Catch: Exception -> L11
        AliCircle r12 = new AliCircle(this.mAMap.addCircle(r11));     // Catch: Exception -> L11
        this.mAliCircles.add(r12);     // Catch: Exception -> L11
        return r12;
    L11:
        e = move-exception;
        f0.i(e, o.d("addCircle error:", e), TAG);
    L13:
        return null;
    }

    @Override // com.bytedance.map.api.IMapService
    public void addMapActionListener(MapActionListener r5) {
        this.mMapActionListenerList.add(r5);
    }

    @Override // com.bytedance.map.api.IMapService
    public IMarker addMarker(BDMarkerOptions r13) {
        if (this.mAMap == null) goto L74;
        if (r13 == null) goto L74;
        BDLatLng r5 = r13.f6921b;
        if (r5 != null) goto L9;
        return null;
    L9:
        Bitmap r10 = r13.f6922c;
        View r11 = r13.d;
        long r12 = SystemClock.elapsedRealtime();     // Catch: Exception -> L13
        MarkerOptions r14 = new MarkerOptions().position(new LatLng(r5.f6917a, r5.f6918b)).anchor(r13.e, r13.f).rotateAngle(r13.g).alpha(r13.f6923h).draggable(false).zIndex(r13.f6924i).infoWindowEnable(false).setInfoWindowOffset(0, 0);     // Catch: Exception -> L13
        if (r10 == null) goto L15;
        BitmapDescriptor r15 = BitmapDescriptorFactory.fromBitmap(r10);     // Catch: Exception -> L13
    L18:
        if (r15 != null) goto L20;
        return null;
    L20:
        r14.icon(r15);     // Catch: Exception -> L13
        Marker r16 = this.mAMap.addMarker(r14);     // Catch: Exception -> L13
        if (r16 != null) goto L46;
        int r17 = getMapType();     // Catch: Exception -> L13
        long r18 = SystemClock.elapsedRealtime() - r12;     // Catch: Exception -> L13
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L13
        if (TextUtils.isEmpty("type") == true) goto L31;
        r19.put("type", r17);     // Catch: Exception -> L13 JSONException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
    L31:
        if (TextUtils.isEmpty("is_success") == false) goto L86;
    L37:
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L13
        if (TextUtils.isEmpty("duration") == false) goto L77;
    L44:
        MapMonitorUtil.a("bd_map_sdk_draw_annotation", r19, r110);     // Catch: Exception -> L13
        return null;
    L77:
        r110.put("duration", r18);     // Catch: Exception -> L13 JSONException -> L42
    L42:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
        goto L44
    L86:
        r19.put("is_success", false);     // Catch: Exception -> L13 JSONException -> L35
    L35:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
        goto L37
    L46:
        int r20 = getMapType();     // Catch: Exception -> L13
        long r21 = SystemClock.elapsedRealtime() - r12;     // Catch: Exception -> L13
        JSONObject r22 = new JSONObject();     // Catch: Exception -> L13
        if (TextUtils.isEmpty("type") == true) goto L54;
        r22.put("type", r20);     // Catch: Exception -> L13 JSONException -> L51
    L51:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
    L54:
        if (TextUtils.isEmpty("is_success") == false) goto L79;
    L61:
        JSONObject r23 = new JSONObject();     // Catch: Exception -> L13
        if (TextUtils.isEmpty("duration") == false) goto L83;
    L68:
        MapMonitorUtil.a("bd_map_sdk_draw_annotation", r22, r23);     // Catch: Exception -> L13
        AliMarker r24 = new AliMarker(r16, r13.f6920a);     // Catch: Exception -> L13
        boolean r111 = r13.f6925j;     // Catch: Exception -> L13
        if (r111 == true) goto L71;
        r24.a(r111);     // Catch: Exception -> L13
    L71:
        this.mAliMarkers.add(r24);     // Catch: Exception -> L13
        return r24;
    L83:
        r23.put("duration", r21);     // Catch: Exception -> L13 JSONException -> L66
    L66:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
        goto L68
    L79:
        r22.put("is_success", true);     // Catch: Exception -> L13 JSONException -> L59
    L59:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
        goto L61
    L15:
        if (r11 == null) goto L17;
        r15 = BitmapDescriptorFactory.fromView(r11);     // Catch: Exception -> L13
        goto L18
    L17:
        r15 = null;
    L13:
        e = move-exception;
        f0.i(e, o.d("addMarker error:", e), TAG);
    L74:
        return null;
    }

    @Override // com.bytedance.map.api.IMapService
    public void addMarkerActionListener(MarkerActionListener r5) {
        this.mMarkerActionListenerList.add(r5);
    }

    public List<IMarker> addMarkers(List<BDMarkerOptions> r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.size() == 0) goto L14;
        ArrayList r10 = new ArrayList();
        Iterator<BDMarkerOptions> r11 = r5.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        r10.add(addMarker(r11.next()));
        goto L8
    L10:
        return r10;
    L14:
        return null;
    }

    public void addPoiClickListener(PoiClickListener r5) {
        this.mPoiClickListeners.add(r5);
    }

    @Override // com.bytedance.map.api.IMapService
    public IPolygon addPolygon(BDPolygonOptions r10) {
        if (this.mAMap == null) goto L20;
        if (r10 == null) goto L20;
        List r5 = r10.f6927b;
        if (r5 == null) goto L20;
        if (r5.size() == 0) goto L20;
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L15
        Iterator r12 = r5.iterator();     // Catch: Exception -> L15
    L13:
        if (r12.hasNext() == false) goto L17;
        BDLatLng r13 = (BDLatLng) r12.next();     // Catch: Exception -> L15
        r11.add(new LatLng(r13.f6917a, r13.f6918b));     // Catch: Exception -> L15
        goto L13
    L17:
        PolygonOptions r14 = new PolygonOptions();     // Catch: Exception -> L15
        r14.addAll(r11);     // Catch: Exception -> L15
        r14.zIndex(0.0f);     // Catch: Exception -> L15
        r14.fillColor(r10.f6928c);     // Catch: Exception -> L15
        r14.strokeColor(r10.d);     // Catch: Exception -> L15
        r14.strokeWidth(r10.e);     // Catch: Exception -> L15
        AliPolygon r15 = new AliPolygon(this.mAMap.addPolygon(r14), r10.f6926a);     // Catch: Exception -> L15
        this.mAliPolygons.add(r15);     // Catch: Exception -> L15
        return r15;
    L15:
        e = move-exception;
        f0.i(e, o.d("addPolygon error:", e), TAG);
    L20:
        return null;
    }

    @Override // com.bytedance.map.api.IMapService
    public IPolyline addPolyline(BDPolylineOptions r10) {
        if (this.mAMap == null) goto L26;
        if (r10 == null) goto L26;
        List r5 = r10.f6929a;
        if (r5 == null) goto L26;
        if (r5.size() == 0) goto L26;
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L15
        Iterator r12 = r5.iterator();     // Catch: Exception -> L15
    L13:
        if (r12.hasNext() == false) goto L17;
        BDLatLng r13 = (BDLatLng) r12.next();     // Catch: Exception -> L15
        r11.add(new LatLng(r13.f6917a, r13.f6918b));     // Catch: Exception -> L15
        goto L13
    L17:
        PolylineOptions r14 = new PolylineOptions().addAll(r11).color(r10.f6930b).width(r10.f6931c).setDottedLine(r10.d).transparency(r10.e).zIndex(r10.f);     // Catch: Exception -> L15
        Bitmap r15 = r10.g;     // Catch: Exception -> L15
        if (r15 == null) goto L20;
        BitmapDescriptor r16 = BitmapDescriptorFactory.fromBitmap(r15);     // Catch: Exception -> L15
    L21:
        if (r16 == null) goto L23;
        r14.setCustomTexture(r16).setUseTexture(r10.f6932h);     // Catch: Exception -> L15
    L23:
        Polyline r17 = this.mAMap.addPolyline(r14);     // Catch: Exception -> L15
        MapMonitorUtil.a("draw_line", null, new JSONObject());     // Catch: Exception -> L15
        AliPolyline r18 = new AliPolyline(r17);     // Catch: Exception -> L15
        this.mAliPolylines.add(r18);     // Catch: Exception -> L15
        return r18;
    L20:
        r16 = null;
    L15:
        e = move-exception;
        f0.i(e, o.d("addPolyline error:", e), TAG);
    L26:
        return null;
    }

    @Override // com.bytedance.map.api.IMapService
    public void attachToParentView(ViewGroup r5) {
        if (this.mMapView == null) goto L12;
        r5.addView(this.mMapView.d(), 0, new ViewGroup.LayoutParams(-1, -1));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("attachToParentView error:", e), TAG);
        return;
    }

    @Override // com.bytedance.map.api.IMapService
    public BDLatLng getCenter() {
        AMap r5 = this.mAMap;
        if (r5 == null) goto L5;
        return new BDLatLng(r5.getCameraPosition().target.latitude, this.mAMap.getCameraPosition().target.longitude);
    L8:
        e = move-exception;
        StringBuilder r10 = o.d("getCenter error:", e);
        r10.append(e.getMessage());
        Log.i(TAG, r10.toString());
        return new BDLatLng(0.0d, 0.0d);
    L5:
        return new BDLatLng(0.0d, 0.0d);
    }

    public void getMapScreenShot(MapScreenShotListener r5) {
        AMap r10 = this.mAMap;
        if (r10 == null) goto L8;
        if (r5 == null) goto L9;
        r10.getMapScreenShot(new AnonymousClass2());
        return;
    L9:
        return;
    }

    @Override // com.bytedance.map.api.IMapService
    public int getMapType() {
        return 1;
    }

    public List<IMarker> getMarkers() {
        return this.mAliMarkers;
    }

    @Override // com.bytedance.map.api.IMapService
    public float getRotationDegree() {
        AMap r5 = this.mAMap;
        if (r5 != null) goto L11;
        Log.e(TAG, "getRotationDegree: error, mAMap == null");
        return -1.0f;
    L11:
        return r5.getCameraPosition().bearing;
    L8:
        th = move-exception;
        MapMonitor.a(th);
        Log.i(TAG, "3D AMap, getRotationDegree error:" + th.getMessage());
        return -1.0f;
    }

    @Override // com.bytedance.map.api.IMapService
    public Map<String, Double> getVisibleRegion() {
        if (this.mAMap == null) goto L5;
        HashMap r5 = new HashMap();     // Catch: Exception -> L10
        VisibleRegion r10 = this.mAMap.getProjection().getVisibleRegion();     // Catch: Exception -> L10
        if (r10 == null) goto L12;
        r5.put("far_left_lat", Double.valueOf(r10.farLeft.latitude));     // Catch: Exception -> L10
        r5.put("far_left_lng", Double.valueOf(r10.farLeft.longitude));     // Catch: Exception -> L10
        r5.put("far_right_lat", Double.valueOf(r10.farRight.latitude));     // Catch: Exception -> L10
        r5.put("far_right_lng", Double.valueOf(r10.farRight.longitude));     // Catch: Exception -> L10
        r5.put("near_left_lat", Double.valueOf(r10.nearLeft.latitude));     // Catch: Exception -> L10
        r5.put("near_left_lng", Double.valueOf(r10.nearLeft.longitude));     // Catch: Exception -> L10
        r5.put("near_right_lat", Double.valueOf(r10.nearRight.latitude));     // Catch: Exception -> L10
        r5.put("near_right_lng", Double.valueOf(r10.nearRight.longitude));     // Catch: Exception -> L10
        return r5;
    L12:
        return r5;
    L10:
        e = move-exception;
        StringBuilder r11 = o.d("getVisibleRegion error:", e);
        r11.append(e.getMessage());
        Log.i(TAG, r11.toString());
        return new HashMap();
    L5:
        return new HashMap();
    }

    @Override // com.bytedance.map.api.IMapService
    public float getZoom() {
        AMap r5 = this.mAMap;
        if (r5 != null) goto L10;
        return 0.0f;
    L10:
        return r5.getCameraPosition().zoom;
    L7:
        e = move-exception;
        f0.i(e, o.d("getZoom error:", e), TAG);
        return 0.0f;
    }

    @Override // com.bytedance.map.api.IMapService
    public void initMap(MapInitConfig r10) {
        if (r10 == null) goto L71;
        Context r5 = r10.f6865a;
        if (r5 != null) goto L7;
        return;
    L7:
        if (MonitorDependImpl.f3090a == null) goto L9;
    L19:
        MapMonitorUtil.a(r5, MonitorDependImpl.f3090a);
        this.mMapCreateTime = SystemClock.elapsedRealtime();
        MapsInitializer.updatePrivacyShow(r10.f6865a, true, true);     // Catch: Exception -> L25
        MapsInitializer.updatePrivacyAgree(r10.f6865a, true);     // Catch: Exception -> L25
        LatLng r11 = DEFAULT_MAP_CENTER;     // Catch: Exception -> L25
        AMapOptions r12 = new AMapOptions();     // Catch: Exception -> L25
        r12.camera(CameraPosition.fromLatLngZoom(r11, r10.d));     // Catch: Exception -> L25
        r12.scaleControlsEnabled(false);     // Catch: Exception -> L25
        r12.zoomControlsEnabled(false);     // Catch: Exception -> L25
        r12.compassEnabled(false);     // Catch: Exception -> L25
        r12.zoomGesturesEnabled(r10.e);     // Catch: Exception -> L25
        r12.scrollGesturesEnabled(r10.f);     // Catch: Exception -> L25
        r12.rotateGesturesEnabled(false);     // Catch: Exception -> L25
        r12.tiltGesturesEnabled(false);     // Catch: Exception -> L25
        int r13 = r10.f6867c;     // Catch: Exception -> L25
        if (r13 == 0) goto L27;
        if (r13 != 1) goto L28;
        this.mMapView = new AliTextureMapView(r10.f6865a, r12);     // Catch: Exception -> L25
    L28:
        this.mMapView.c();     // Catch: Exception -> L25
        AMap r14 = this.mMapView.b();     // Catch: Exception -> L25
        this.mAMap = r14;     // Catch: Exception -> L25
        if (r14 != null) goto L66;
        int r15 = getMapType();     // Catch: Exception -> L25
        long r16 = SystemClock.elapsedRealtime() - this.mMapCreateTime;     // Catch: Exception -> L25
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L25
        if (TextUtils.isEmpty("type") == true) goto L43;
        r17.put("type", r15);     // Catch: Exception -> L25 JSONException -> L40
    L40:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L25
    L43:
        if (TextUtils.isEmpty("is_success") == false) goto L62;
    L49:
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L25
        if (TextUtils.isEmpty("duration") == false) goto L64;
    L56:
        MapMonitorUtil.a("bd_map_sdk_load", r17, r18);     // Catch: Exception -> L25
        return;
    L64:
        r18.put("duration", r16);     // Catch: Exception -> L25 JSONException -> L54
    L54:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L25
        goto L56
    L62:
        r17.put("is_success", false);     // Catch: Exception -> L25 JSONException -> L47
    L47:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L25
        goto L49
    L66:
        r14.setCustomMapStyle(new CustomMapStyleOptions().setStyleData(FileUtil.a(r10.f6865a, "sdk_amap_style.data")).setStyleExtraData(FileUtil.a(r10.f6865a, "sdk_amap_style_extra.data")));     // Catch: Exception -> L25 IOException -> L32
    L34:
        this.mAMap.setOnMapLoadedListener(this);     // Catch: Exception -> L25
        this.mAMap.setOnMapTouchListener(this);     // Catch: Exception -> L25
        this.mAMap.setOnCameraChangeListener(this);     // Catch: Exception -> L25
        this.mAMap.setOnMapClickListener(this);     // Catch: Exception -> L25
        this.mAMap.setOnMarkerClickListener(this);     // Catch: Exception -> L25
        this.mAMap.setOnPOIClickListener(this);     // Catch: Exception -> L25
        return;
    L32:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L25
        goto L34
    L27:
        this.mMapView = new AliMapView(r10.f6865a, r12);     // Catch: Exception -> L25
    L25:
        e = move-exception;
        f0.i(e, o.d("initMap error:", e), TAG);
        return;
    L9:
        monitor-enter(MonitorDependImpl.class);
    L13:
        th = move-exception;
        throw th;
    L11:
        if (MonitorDependImpl.f3090a != null) goto L15;
        MonitorDependImpl.f3090a = new MonitorDependImpl();     // Catch: Throwable -> L13
    L15:
        monitor-exit(MonitorDependImpl.class);     // Catch: Throwable -> L13
        goto L19
    }

    @Override // com.bytedance.map.api.IMapService
    public boolean isAvailable(Context r5) {
        return true;
    }

    public boolean isPoiClickEnabled() {
        AMap r5 = this.mAMap;
        if (r5 != null) goto L7;
        return false;
    L7:
        return r5.isTouchPoiEnable();
    }

    @Override // com.bytedance.map.api.IMapService
    public boolean isRotateGesturesEnabled() {
        AMap r5 = this.mAMap;
        if (r5 != null) goto L10;
        return false;
    L10:
        return r5.getUiSettings().isRotateGesturesEnabled();
    L7:
        e = move-exception;
        f0.i(e, o.d("isRotateGesturesEnabled error:", e), TAG);
        return false;
    }

    @Override // com.bytedance.map.api.IMapService
    public boolean isScrollGesturesEnabled() {
        AMap r5 = this.mAMap;
        if (r5 != null) goto L10;
        return false;
    L10:
        return r5.getUiSettings().isScrollGesturesEnabled();
    L7:
        e = move-exception;
        f0.i(e, o.d("isScrollGesturesEnabled error:", e), TAG);
        return false;
    }

    public boolean isSupportSetRotation() {
        return true;
    }

    @Override // com.bytedance.map.api.IMapService
    public boolean isTiltGesturesEnabled() {
        AMap r5 = this.mAMap;
        if (r5 != null) goto L10;
        return false;
    L10:
        return r5.getUiSettings().isTiltGesturesEnabled();
    L7:
        e = move-exception;
        f0.i(e, o.d("isTiltGesturesEnabled error:", e), TAG);
        return false;
    }

    @Override // com.bytedance.map.api.IMapService
    public boolean isZoomGesturesEnabled() {
        AMap r5 = this.mAMap;
        if (r5 != null) goto L10;
        return false;
    L10:
        return r5.getUiSettings().isZoomGesturesEnabled();
    L7:
        e = move-exception;
        f0.i(e, o.d("isZoomGesturesEnabled error:", e), TAG);
        return false;
    }

    public void onCameraChange(CameraPosition r10) {
        if (r10 == null) goto L33;
    L16:
        e = move-exception;
        f0.i(e, o.d("onCameraChange error:", e), TAG);
        return;
    L4:
        if (r10.target != null) goto L6;
        return;
    L6:
        if (this.mIsMapLoad == false) goto L35;
        Iterator<MapActionListener> r5 = this.mMapActionListenerList.iterator();     // Catch: Exception -> L16
    L10:
        if (r5.hasNext() == false) goto L22;
        MapActionListener r11 = r5.next();     // Catch: Exception -> L16
        if (r10.target.latitude == this.mLastLat) goto L14;
    L18:
        r11.onMapMove(new BDLatLng(r10.target.latitude, r10.target.longitude));     // Catch: Exception -> L16
        this.mLastEndLat = -1.0d;     // Catch: Exception -> L16
        this.mLastEndLng = -1.0d;     // Catch: Exception -> L16
    L20:
        if (r10.zoom == this.mLastZoom) goto L10;
        r11.onMapZoom(r10.zoom);     // Catch: Exception -> L16
        this.mLastEndZoom = -1.0f;     // Catch: Exception -> L16
        goto L10
    L14:
        if (r10.target.longitude == this.mLastLng) goto L20;
    L22:
        this.mLastLat = r10.target.latitude;     // Catch: Exception -> L16
        this.mLastLng = r10.target.longitude;     // Catch: Exception -> L16
        this.mLastZoom = r10.zoom;     // Catch: Exception -> L16
        return;
    L35:
        return;
    }

    public void onCameraChangeFinish(CameraPosition r10) {
        if (r10 == null) goto L33;
    L14:
        e = move-exception;
        f0.i(e, o.d("onCameraChangeFinish error:", e), TAG);
        return;
    L4:
        if (r10.target != null) goto L6;
        return;
    L6:
        if (this.mIsMapLoad == false) goto L35;
        Iterator<MapActionListener> r5 = this.mMapActionListenerList.iterator();     // Catch: Exception -> L14
    L10:
        if (r5.hasNext() == false) goto L21;
        MapActionListener r11 = r5.next();     // Catch: Exception -> L14
        if (r10.zoom == this.mLastEndZoom) goto L17;
        r11.onMapZoomEnd(r10.zoom);     // Catch: Exception -> L14
    L17:
        if (r10.target.latitude != this.mLastEndLat) goto L20;
        if (r10.target.longitude == this.mLastEndLng) goto L10;
    L20:
        r11.onMapMoveEnd(new BDLatLng(r10.target.latitude, r10.target.longitude));     // Catch: Exception -> L14
        goto L10
    L21:
        this.mLastEndLat = r10.target.latitude;     // Catch: Exception -> L14
        this.mLastEndLng = r10.target.longitude;     // Catch: Exception -> L14
        this.mLastEndZoom = r10.zoom;     // Catch: Exception -> L14
        return;
    L35:
        return;
    }

    public void onCreate(Bundle r5) {
    }

    @Override // com.bytedance.map.api.IMapService
    public synchronized void onDestroy() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mMapView != null) goto L18;
    L13:
        monitor-exit(this);
        return;
    L18:
        this.mMapView.onDestroy();     // Catch: Throwable -> L9 Exception -> L11
        this.mMapView = null;     // Catch: Throwable -> L9 Exception -> L11
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        f0.i(e, o.d("onDestroy error:", e), TAG);     // Catch: Throwable -> L9
        goto L13
    }

    public void onLowMemory() {
        if (this.mMapView == null) goto L12;
        this.mMapView.onLowMemory();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("onLowMemory error:", e), TAG);
        return;
    }

    public void onMapClick(LatLng r10) {
        if (r10 == null) goto L16;
        Iterator<MapActionListener> r11 = this.mMapActionListenerList.iterator();     // Catch: Exception -> L9
    L6:
        if (r11.hasNext() == false) goto L17;
        r11.next().onMapClick(new BDLatLng(r10.latitude, r10.longitude));     // Catch: Exception -> L9
        goto L6
    L17:
        return;
    L9:
        e = move-exception;
        f0.i(e, o.d("onMapClick error:", e), TAG);
        return;
    }

    public void onMapLoaded() {
        this.mIsMapLoad = true;
        Iterator<MapActionListener> r5 = this.mMapActionListenerList.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().onMapLoad();
        goto L4
    L6:
        int r10 = getMapType();
        long r11 = SystemClock.elapsedRealtime() - this.mMapCreateTime;
        JSONObject r12 = new JSONObject();
        if (TextUtils.isEmpty("type") == true) goto L14;
        r12.put("type", r10);     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L14:
        if (TextUtils.isEmpty("is_success") == false) goto L31;
    L20:
        JSONObject r13 = new JSONObject();
        if (TextUtils.isEmpty("duration") == false) goto L33;
    L27:
        MapMonitorUtil.a("bd_map_sdk_load", r12, r13);
        return;
    L33:
        r13.put("duration", r11);     // Catch: JSONException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L27
    L31:
        r12.put("is_success", true);     // Catch: JSONException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    public boolean onMarkerClick(Marker r5) {
        Iterator<IMarker> r10 = this.mAliMarkers.iterator();     // Catch: Exception -> L13
    L5:
        if (r10.hasNext() == false) goto L17;
        IMarker r11 = r10.next();     // Catch: Exception -> L13
        if (((AliMarker) r11).f3093a.equals(r5) == false) goto L5;
        Iterator<MarkerActionListener> r12 = this.mMarkerActionListenerList.iterator();     // Catch: Exception -> L13
    L10:
        if (r12.hasNext() == false) goto L15;
        r12.next().onMarkerClick(r11);     // Catch: Exception -> L13
        goto L10
    L15:
        return true;
    L17:
        return false;
    L13:
        e = move-exception;
        f0.i(e, o.d("onMarkerClick error:", e), TAG);
        return false;
    }

    public void onPOIClick(Poi r5) {
        if (r5 == null) goto L13;
        r5.getName();
        if (r5.getCoordinate() == null) goto L8;
        double r10 = r5.getCoordinate().latitude;
        double r11 = r5.getCoordinate().longitude;
    L8:
        r5.getPoiId();
        Iterator<PoiClickListener> r12 = this.mPoiClickListeners.iterator();
        if (r12.hasNext() == true) goto L12;
        return;
    L12:
        throw h.c(r12);
    }

    public void onPause() {
        if (this.mMapView == null) goto L12;
        this.mMapView.e();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("onPause error:", e), TAG);
        return;
    }

    public void onResume() {
        if (this.mMapView == null) goto L12;
        this.mMapView.a();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("onResume error:", e), TAG);
        return;
    }

    public void onSaveInstanceState(Bundle r5) {
        if (this.mMapView == null) goto L12;
        this.mMapView.a(r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("onSaveInstanceState error:", e), TAG);
        return;
    }

    @Override // com.bytedance.map.api.IMapService
    public void onStart() {
    }

    public void onStop() {
    }

    public void onTouch(MotionEvent r5) {
        Iterator<MapActionListener> r10 = this.mMapActionListenerList.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onMapTouch(r5);
        goto L4
    }

    public void removeAllCircles() {
        Iterator<ICircle> r5 = this.mAliCircles.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        ICircle r10 = r5.next();
        if (r10 == null) goto L4;
        ((AliCircle) r10).a();
        goto L4
    L8:
        this.mAliCircles.clear();
    }

    public void removeAllMarkers() {
        List<IMarker> r5 = this.mAliMarkers;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.mAliMarkers.isEmpty() == true) goto L13;
        removeMarker(this.mAliMarkers.get(0));
        goto L8
    }

    public void removeAllPolylines() {
        Iterator<IPolyline> r5 = this.mAliPolylines.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        IPolyline r10 = r5.next();
        if (r10 == null) goto L4;
        ((AliPolyline) r10).a();
        goto L4
    L8:
        this.mAliPolylines.clear();
    }

    public void removeCircle(ICircle r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.mAliCircles.remove(r5);
        ((AliCircle) r5).a();
    }

    @Override // com.bytedance.map.api.IMapService
    public void removeMarker(IMarker r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.mAliMarkers.remove(r5);
        ((AliMarker) r5).a();
    }

    public void removePolygon(IPolygon r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.mAliPolygons.remove(r5);
        ((AliPolygon) r5).b();
    }

    public void removePolyline(IPolyline r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.mAliPolylines.remove(r5);
        ((AliPolyline) r5).a();
    }

    @Override // com.bytedance.map.api.IMapService
    public void setAllGesturesEnabled(boolean r5) {
        AMap r10 = this.mAMap;
        if (r10 == null) goto L12;
        r10.getUiSettings().setAllGesturesEnabled(r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("setAllGesturesEnabled error:", e), TAG);
        return;
    }

    @Override // com.bytedance.map.api.IMapService
    public void setBound(List<BDLatLng> r10, int r11, int r12, int r13, int r14, boolean r15, int r16) {
        if (this.mAMap == null) goto L21;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.size() == 0) goto L23;
        LatLngBounds.Builder r5 = LatLngBounds.builder();     // Catch: Exception -> L12
        Iterator<BDLatLng> r17 = r10.iterator();     // Catch: Exception -> L12
    L10:
        if (r17.hasNext() == false) goto L14;
        BDLatLng r18 = r17.next();     // Catch: Exception -> L12
        r5.include(new LatLng(r18.f6917a, r18.f6918b));     // Catch: Exception -> L12
        goto L10
    L14:
        changeCamera(CameraUpdateFactory.newLatLngBoundsRect(r5.build(), r11, r12, r13, r14), r15, r16, null);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        f0.i(e, o.d("setBound error:", e), TAG);
        return;
    L23:
        return;
    }

    @Override // com.bytedance.map.api.IMapService
    public void setCenter(BDLatLng r5, boolean r10, int r11) {
        setCenter(r5, r10, r11, null);
    }

    @Override // com.bytedance.map.api.IMapService
    public void setCenterAndZoom(BDLatLng r10, float r11, boolean r12, int r13) {
        if (this.mAMap == null) goto L12;
        changeCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(r10.f6917a, r10.f6918b), r11), r12, r13, null);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("setCenterAndZoom error:", e), TAG);
        return;
    }

    public void setCompassEnabled(boolean r5) {
        AMap r10 = this.mAMap;
        if (r10 == null) goto L12;
        r10.getUiSettings().setCompassEnabled(r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("setCompassEnabled error:", e), TAG);
        return;
    }

    @Override // com.bytedance.map.api.IMapService
    public void setCustomMapStyle(boolean r5, String r10) {
        AMap r11 = this.mAMap;
        if (r11 == null) goto L12;
        r11.setCustomMapStyle(new CustomMapStyleOptions().setEnable(r5).setStyleId(r10));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("setCustomMapStyle error:", e), TAG);
        return;
    }

    @Override // com.bytedance.map.api.IMapService
    public void setHandleGesture(boolean r5) {
    }

    @Override // com.bytedance.map.api.IMapService
    public void setLimitRegion(BDLatLng r10, BDLatLng r11) {
        if (this.mAMap == null) goto L9;
        if (r10 == null) goto L10;
        if (r11 == null) goto L11;
        LatLngBounds.Builder r5 = LatLngBounds.builder();
        r5.include(new LatLng(r10.f6917a, r10.f6918b));
        r5.include(new LatLng(r11.f6917a, r11.f6918b));
        this.mAMap.setMapStatusLimits(r5.build());
        return;
    L11:
        return;
    L10:
        return;
    }

    public boolean setMarkerIcon(IMarker r5, Bitmap r10) {
        if (this.mMapView != null) goto L11;
        return false;
    L11:
        BitmapDescriptor r11 = BitmapDescriptorFactory.fromBitmap(r10);     // Catch: Exception -> L8
        ((AliMarker) r5).f3093a.setIcon(r11);     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        f0.i(e, o.d("setMarkerIcon error:", e), TAG);
        return false;
    }

    @Override // com.bytedance.map.api.IMapService
    public void setMaxZoomLevel(float r5) {
        AMap r10 = this.mAMap;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r5 <= 20.0f) goto L9;
        r5 = 20.0f;
    L9:
        if (r5 >= 3.0f) goto L11;
        r5 = 3.0f;
    L11:
        r10.setMaxZoomLevel(r5);
    }

    @Override // com.bytedance.map.api.IMapService
    public void setMinZoomLevel(float r5) {
        AMap r10 = this.mAMap;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r5 >= 3.0f) goto L9;
        r5 = 3.0f;
    L9:
        if (r5 <= 20.0f) goto L11;
        r5 = 20.0f;
    L11:
        r10.setMinZoomLevel(r5);
    }

    @Override // com.bytedance.map.api.IMapService
    public void setMyLocationButtonEnabled(boolean r5) {
        AMap r10 = this.mAMap;
        if (r10 == null) goto L12;
        r10.getUiSettings().setMyLocationButtonEnabled(r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("setMyLocationButtonEnabled error:", e), TAG);
        return;
    }

    public void setPoiClickEnabled(boolean r5) {
        AMap r10 = this.mAMap;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setTouchPoiEnable(r5);
    }

    @Override // com.bytedance.map.api.IMapService
    public void setRotateGesturesEnabled(boolean r5) {
        AMap r10 = this.mAMap;
        if (r10 == null) goto L12;
        r10.getUiSettings().setRotateGesturesEnabled(r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("setRotateGesturesEnabled error:", e), TAG);
        return;
    }

    @Override // com.bytedance.map.api.IMapService
    public void setRotationDegree(float r5, boolean r10, int r11) {
        changeCamera(CameraUpdateFactory.changeBearing(r5), r10, r11, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        MapMonitor.a(th);
        Log.e(TAG, "setRotationDegree error:" + th);
    }

    public void setScaleControlsEnabled(boolean r5) {
        AMap r10 = this.mAMap;
        if (r10 == null) goto L12;
        r10.getUiSettings().setScaleControlsEnabled(r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("setScaleControlsEnabled error:", e), TAG);
        return;
    }

    @Override // com.bytedance.map.api.IMapService
    public void setScrollGesturesEnabled(boolean r5) {
        AMap r10 = this.mAMap;
        if (r10 == null) goto L12;
        r10.getUiSettings().setScrollGesturesEnabled(r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("setScrollGesturesEnabled error:", e), TAG);
        return;
    }

    @Override // com.bytedance.map.api.IMapService
    public void setTiltGesturesEnabled(boolean r5) {
        AMap r10 = this.mAMap;
        if (r10 == null) goto L12;
        r10.getUiSettings().setTiltGesturesEnabled(r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("setTiltGesturesEnabled error:", e), TAG);
        return;
    }

    public void setTrafficEnabled(boolean r5) {
        AMap r10 = this.mAMap;
        if (r10 == null) goto L12;
        r10.setTrafficEnabled(r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("setTrafficEnabled error:", e), TAG);
        return;
    }

    @Override // com.bytedance.map.api.IMapService
    public void setZoom(float r5, boolean r10, int r11) {
        if (this.mAMap == null) goto L12;
        changeCamera(CameraUpdateFactory.zoomTo(r5), r10, r11, null);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("setZoom error:", e), TAG);
        return;
    }

    public void setZoomControlsEnabled(boolean r5) {
        AMap r10 = this.mAMap;
        if (r10 == null) goto L12;
        r10.getUiSettings().setZoomControlsEnabled(r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("setZoomControlsEnabled error:", e), TAG);
        return;
    }

    @Override // com.bytedance.map.api.IMapService
    public void setZoomGesturesEnabled(boolean r5) {
        AMap r10 = this.mAMap;
        if (r10 == null) goto L12;
        r10.getUiSettings().setZoomGesturesEnabled(r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f0.i(e, o.d("setZoomGesturesEnabled error:", e), TAG);
        return;
    }

    @Override // com.bytedance.map.api.IMapService
    public void startMarkerAnimation(IMarker r5, List<AnimationStyle> r10) {
        AnimationSet r11 = new AnimationSet(false);     // Catch: Exception -> L8
        Iterator<AnimationStyle> r12 = r10.iterator();     // Catch: Exception -> L8
    L4:
        if (r12.hasNext() == false) goto L16;
        AnimationStyle r13 = r12.next();     // Catch: Exception -> L8
        int r14 = r13.f6870a;     // Catch: Exception -> L8
        if (r14 != 0) goto L11;
        float r15 = r13.f6871b;     // Catch: Exception -> L8
        float r16 = r13.f6872c;     // Catch: Exception -> L8
        ScaleAnimation r17 = new ScaleAnimation(r15, r16, r15, r16);     // Catch: Exception -> L8
    L14:
        if (r17 == null) goto L4;
        r17.setFillMode(r13.f);     // Catch: Exception -> L8
        r17.setInterpolator(r13.e);     // Catch: Exception -> L8
        r17.setRepeatCount(r13.g);     // Catch: Exception -> L8
        r17.setRepeatMode(r13.f6873h);     // Catch: Exception -> L8
        r17.setDuration(r13.d);     // Catch: Exception -> L8
        r11.addAnimation(r17);     // Catch: Exception -> L8
        goto L4
    L11:
        if (r14 != 1) goto L13;
        r17 = new AlphaAnimation(r13.f6871b, r13.f6872c);     // Catch: Exception -> L8
        goto L14
    L13:
        r17 = null;
        goto L14
    L16:
        ((AliMarker) r5).a(r11);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        f0.i(e, o.d("startMarkerAnimation error:", e), TAG);
    }

    @Override // com.bytedance.map.api.IMapService
    public Point transLatLngToPoint(BDLatLng r10) {
        AMap r11 = this.mAMap;
        if (r11 != null) goto L10;
        return null;
    L10:
        return r11.getProjection().toScreenLocation(new LatLng(r10.f6917a, r10.f6918b));
    L7:
        e = move-exception;
        f0.i(e, o.d("transLatLngToPoint error:", e), TAG);
        return null;
    }

    @Override // com.bytedance.map.api.IMapService
    public BDLatLng transPointToLatLng(Point r10) {
        AMap r5 = this.mAMap;
        if (r5 != null) goto L13;
        return null;
    L13:
        LatLng r11 = r5.getProjection().fromScreenLocation(r10);     // Catch: Exception -> L10
        if (r11 != null) goto L8;
        return null;
    L8:
        return new BDLatLng(r11.latitude, r11.longitude);
    L10:
        e = move-exception;
        f0.i(e, o.d("transPointToLatLng error:", e), TAG);
        return null;
    }

    public void setCenter(BDLatLng r10, boolean r11, int r12, @Nullable CancelableCallback r13) {
        if (this.mAMap == null) goto L13;
        if (r10 == null) goto L13;
        changeCamera(CameraUpdateFactory.newLatLng(new LatLng(r10.f6917a, r10.f6918b)), r11, r12, r13);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        f0.i(e, o.d("setCenter error:", e), TAG);
        if (r11 == false) goto L19;
        if (r13 == null) goto L20;
        r13.a();
        return;
    L20:
        return;
    L19:
        return;
    L13:
        if (r11 == false) goto L22;
        if (r13 == null) goto L23;
        r13.a();
        return;
    L23:
        return;
    }

    @Override // com.bytedance.map.api.IMapService
    public void setZoom(float r5, boolean r10) {
        setZoom(r5, r10, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    public void setCenterAndZoom(BDLatLng r5, float r10, boolean r11) {
        setCenterAndZoom(r5, r10, r11, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    @Override // com.bytedance.map.api.IMapService
    public void setBound(List<BDLatLng> r10, int r11, int r12, int r13, int r14, boolean r15) {
        setBound(r10, r11, r12, r13, r14, r15, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    @Override // com.bytedance.map.api.IMapService
    public void setCenter(BDLatLng r5, boolean r10) {
        setCenter(r5, r10, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }
}
