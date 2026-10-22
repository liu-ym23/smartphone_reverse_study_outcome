package com.bytedance.amap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.Gradient;
import com.amap.api.maps.model.HeatmapTileProvider;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.VisibleRegion;
import com.amap.api.maps.model.WeightedLatLng;
import com.amap.api.maps.model.animation.AlphaAnimation;
import com.amap.api.maps.model.animation.AnimationSet;
import com.amap.api.maps.model.animation.ScaleAnimation;
import com.bytedance.amap.adapter.AMapStyleOptionsConverter;
import com.bytedance.amap.adapter.AMapUiSettingsAdapter;
import com.bytedance.amap.depend.MonitorDependImpl;
import com.bytedance.amap.model.AliArc;
import com.bytedance.amap.model.AliCircle;
import com.bytedance.amap.model.AliHeatMap;
import com.bytedance.amap.model.AliMapView;
import com.bytedance.amap.model.AliMarker;
import com.bytedance.amap.model.AliPolygon;
import com.bytedance.amap.model.AliPolyline;
import com.bytedance.amap.model.AliTextureMapView;
import com.bytedance.amap.model.IMapView;
import com.bytedance.amap.utils.FileUtil;
import com.bytedance.map.api.IMapService;
import com.bytedance.map.api.MapGlobalConfig;
import com.bytedance.map.api.MapInitConfig;
import com.bytedance.map.api.animation.AnimationStyle;
import com.bytedance.map.api.cache.ReusableMapService;
import com.bytedance.map.api.listener.CancelableCallback;
import com.bytedance.map.api.listener.FirstMapTileLoadedListener;
import com.bytedance.map.api.listener.LocationChangeListener;
import com.bytedance.map.api.listener.MapActionListener;
import com.bytedance.map.api.listener.MapActionReasonListener;
import com.bytedance.map.api.listener.MapScreenShotListener;
import com.bytedance.map.api.listener.MapShotStatusListener;
import com.bytedance.map.api.listener.MarkerActionListener;
import com.bytedance.map.api.listener.PoiClickListener;
import com.bytedance.map.api.listener.PolygonClickListener;
import com.bytedance.map.api.listener.PolylineClickListener;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.model.BDArcOptions;
import com.bytedance.map.api.model.BDCircleOptions;
import com.bytedance.map.api.model.BDHeatMapOptions;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.BDLocationOverlayConfig;
import com.bytedance.map.api.model.BDMapStyleOptions;
import com.bytedance.map.api.model.BDMapStyleType;
import com.bytedance.map.api.model.BDMapUiConfigs;
import com.bytedance.map.api.model.BDMarkerOptions;
import com.bytedance.map.api.model.BDPoi;
import com.bytedance.map.api.model.BDPolygonOptions;
import com.bytedance.map.api.model.BDPolylineOptions;
import com.bytedance.map.api.model.BDTextPathOptions;
import com.bytedance.map.api.model.BDWeightedLatLng;
import com.bytedance.map.api.model.IArc;
import com.bytedance.map.api.model.ICircle;
import com.bytedance.map.api.model.IHeatMap;
import com.bytedance.map.api.model.IInfoWindowProvider;
import com.bytedance.map.api.model.IMarker;
import com.bytedance.map.api.model.IPolygon;
import com.bytedance.map.api.model.IPolyline;
import com.bytedance.map.api.model.ITextPath;
import com.bytedance.map.api.monitor.MapMonitor;
import com.bytedance.map.api.monitor.MapMonitorUtil;
import com.bytedance.map.api.settings.MapSettingsUtil;
import com.bytedance.map.api.utils.BitmapFileUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AMapServiceImpl implements IMapService, ReusableMapService, AMap.OnMapLoadedListener, AMap.OnCameraChangeListener, AMap.OnMapClickListener, AMap.OnMapTouchListener, AMap.OnMarkerClickListener, AMap.OnPOIClickListener, AMap.OnPolylineClickListener {
    private static final Method AMAP_SET_POLYGON_STROKE_DOTTED_LINE_TYPE_METHOD = null;
    private static final LatLng DEFAULT_MAP_CENTER = null;
    private static final String TAG = "AMapServiceImpl";
    private AMap mAMap;
    private List<IArc> mAliArcs;
    private List<ICircle> mAliCircles;
    private List<IHeatMap> mAliHeatMaps;
    private List<IMarker> mAliMarkers;
    private List<IPolygon> mAliPolygons;
    private List<IPolyline> mAliPolylines;
    private List<ITextPath> mAliTextPaths;
    private Context mAppContext;
    private Bitmap mCachedScreenShot;
    private volatile boolean mHasSetBizName;
    private IInfoWindowProvider mInfoWindowProvider;
    private long mInitDuration;
    private volatile boolean mIsMapLoad;
    private double mLastEndLat;
    private double mLastEndLng;
    private float mLastEndZoom;
    private double mLastLat;
    private double mLastLng;
    private volatile MapActionReasonListener.MapActionReason mLastMapActionReason;
    private float mLastZoom;
    private int mLogoPosition;
    private List<MapActionListener> mMapActionListenerList;
    private List<MapActionReasonListener> mMapActionReasonListenerList;
    private long mMapCreateTime;
    private long mMapLoadDuration;
    private final Object mMapLoadStateLock;
    private volatile IMapView mMapView;
    private List<MarkerActionListener> mMarkerActionListenerList;
    private Integer mPendingCustomMapType;
    private List<PoiClickListener> mPoiClickListeners;
    private List<PolylineClickListener> mPolylineClickListenerList;
    private long mReuseStartTime;
    private long mShotGeneration;
    private final Object mShotLock;

    /* JADX INFO: renamed from: com.bytedance.amap.AMapServiceImpl$5, reason: invalid class name */
    public class AnonymousClass5 implements AMap.OnMapScreenShotListener {
        final /* synthetic */ AMapServiceImpl this$0;
        final /* synthetic */ Context val$appContext;
        final /* synthetic */ MapShotStatusListener val$listener;
        final /* synthetic */ long val$shotGeneration;
        final /* synthetic */ long val$tStart;

        public static /* synthetic */ void a(AnonymousClass5 r0, long r1, long r10, long r11, long r12, boolean r13) {
            r0.lambda$onMapScreenShot$0(r1, r10, r11, r12, r13);
        }

        public void onMapScreenShot(Bitmap r1, int r10) {
        }

        public void onMapScreenShot(Bitmap r27) {
            if (AMapServiceImpl.access$100(this.this$0, this.val$shotGeneration) == true) goto L7;
            MapLogger.i(AMapServiceImpl.TAG, "onMapScreenShot ignored, stale generation=" + this.val$shotGeneration);
            return;
        L7:
            if (r27 != null) goto L10;
            long r18 = SystemClock.elapsedRealtime() - this.val$tStart;
            MapMonitor.launchShotToCacheMonitor(this.this$0.getMapType(), "shot_fail", System.currentTimeMillis(), r18, r18, 0);
            this.val$listener.onStatus(0);
            return;
        L10:
            Object r10 = AMapServiceImpl.access$200(this.this$0);
            monitor-enter(r10);
        L34:
            th = move-exception;
            throw th;
        L13:
            if (AMapServiceImpl.access$300(this.this$0, this.val$shotGeneration) == true) goto L17;
            MapLogger.i(AMapServiceImpl.TAG, "onMapScreenShot copy skipped, stale generation=" + this.val$shotGeneration);     // Catch: Throwable -> L34
            monitor-exit(r10);     // Catch: Throwable -> L34
            return;
        L17:
            Bitmap r13 = r27.copy(Bitmap.Config.RGB_565, false);     // Catch: Throwable -> L34
            AMapServiceImpl.access$402(this.this$0, r13);     // Catch: Throwable -> L34
            if (r13 != null) goto L22;
            long r19 = SystemClock.elapsedRealtime() - this.val$tStart;     // Catch: Throwable -> L34
            MapMonitor.launchShotToCacheMonitor(this.this$0.getMapType(), "shot_fail", System.currentTimeMillis(), r19, r19, 0);     // Catch: Throwable -> L34
            this.val$listener.onStatus(0);     // Catch: Throwable -> L34
            monitor-exit(r10);     // Catch: Throwable -> L34
            return;
        L22:
            MapLogger.i(AMapServiceImpl.TAG, "onMapScreenShot received, dt = " + (SystemClock.elapsedRealtime() - this.val$tStart) + " ms, bmp = " + r13.getWidth() + "x" + r13.getHeight() + ", size = " + String.format("%.2f", new Object[]{Float.valueOf((r13.getByteCount() / 1024.0f) / 1024.0f)}) + " MB");     // Catch: Throwable -> L34
            monitor-exit(r10);     // Catch: Throwable -> L34
            final long r11 = SystemClock.elapsedRealtime();
            final long r22 = r11 - this.val$tStart;
            MapLogger.i(AMapServiceImpl.TAG, "onMapScreenShot write start");
            Context r12 = this.val$appContext;
            if (r12 != null) goto L28;
            MapMonitor.launchShotToCacheMonitor(this.this$0.getMapType(), "write_fail", System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.val$tStart, r22, 0);
            this.val$listener.onStatus(0);
            return;
        L28:
            Bitmap.CompressFormat r14 = Bitmap.CompressFormat.JPEG;
            final long r15 = this.val$shotGeneration;
            final long r16 = this.val$tStart;
            BitmapFileUtil.writeBitmapAsync(r12, r13, r14, 100, "lbs", "map_shot.jpg", new a(this, r15, r11, r16, r22));
            if (AMapServiceImpl.access$100(this.this$0, this.val$shotGeneration) == true) goto L32;
            MapLogger.i(AMapServiceImpl.TAG, "onMapScreenShot notify ignored, stale generation=" + this.val$shotGeneration);
            return;
        L32:
            MapLogger.i(AMapServiceImpl.TAG, "onMapScreenShot notify success, total_dt = " + (SystemClock.elapsedRealtime() - this.val$tStart) + " ms");
            this.val$listener.onStatus(1);
        }

        public AnonymousClass5(AMapServiceImpl r1, long r10, long r11, MapShotStatusListener r12, Context r13) {
            this.this$0 = r1;
            this.val$shotGeneration = r10;
            this.val$tStart = r11;
            this.val$listener = r12;
            this.val$appContext = r13;
        }

        private /* synthetic */ void lambda$onMapScreenShot$0(long r15, long r17, long r19, long r21, boolean r23) {
            if (AMapServiceImpl.access$100(this.this$0, r15) == true) goto L6;
            MapLogger.i(AMapServiceImpl.TAG, "onWriteResult ignored, stale generation=" + r15);
            return;
        L6:
            MapLogger.i(AMapServiceImpl.TAG, "onWriteResult write done, success = " + r23 + ", dt = " + (SystemClock.elapsedRealtime() - r17) + " ms");
            if (r23 == false) goto L18;
            Object r10 = AMapServiceImpl.access$200(this.this$0);
            monitor-enter(r10);
        L15:
            th = move-exception;
            throw th;
        L11:
            if (AMapServiceImpl.access$300(this.this$0, r15) == false) goto L13;
            AMapServiceImpl.access$402(this.this$0, null);     // Catch: Throwable -> L15
        L13:
            monitor-exit(r10);     // Catch: Throwable -> L15
        L18:
            long r12 = SystemClock.elapsedRealtime() - r17;
            long r11 = SystemClock.elapsedRealtime() - r19;
            int r13 = this.this$0.getMapType();
            if (r23 == false) goto L21;
            String r0 = "write_success";
        L22:
            MapMonitor.launchShotToCacheMonitor(r13, r0, System.currentTimeMillis(), r11, r21, r12);
            return;
        L21:
            r0 = "write_fail";
            goto L22
        }
    }

    /* JADX INFO: renamed from: com.bytedance.amap.AMapServiceImpl$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$map$api$model$BDMapStyleType = null;

        static {
            int[] r0 = new int[BDMapStyleType.values().length];
            $SwitchMap$com$bytedance$map$api$model$BDMapStyleType = r0;
            r0[BDMapStyleType.NORMAL_LIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$map$api$model$BDMapStyleType[BDMapStyleType.NORMAL_DARK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public class AMapInfoWindowAdapter implements AMap.InfoWindowAdapter {
        final /* synthetic */ AMapServiceImpl this$0;

        public View getInfoContents(Marker r1) {
            return null;
        }

        public AMapInfoWindowAdapter(AMapServiceImpl r1) {
            this.this$0 = r1;
        }

        public View getInfoWindow(Marker r10) {
        L11:
            e = move-exception;
            MapMonitor.amapExceptionMonitor(e);
            MapLogger.e(AMapServiceImpl.TAG, "getInfoWindow error:" + e.getMessage());
            return null;
        L3:
            if (AMapServiceImpl.access$500(this.this$0) == null) goto L20;
            Iterator r0 = AMapServiceImpl.access$600(this.this$0).iterator();     // Catch: Exception -> L11
        L6:
            if (r0.hasNext() == false) goto L21;
            IMarker r1 = (IMarker) r0.next();     // Catch: Exception -> L11
            if (((AliMarker) r1).getMarker().equals(r10) == false) goto L6;
            return AMapServiceImpl.access$500(this.this$0).getInfoWindowView(r1);
        L21:
            return null;
        L20:
            return null;
        }
    }

    private static float getLogoDensityScale(int r10) {
        if (r10 != 0) goto L6;
        return 1.0f;
    L6:
        if (r10 > 120) goto L10;
        return 0.5f;
    L10:
        if (r10 > 160) goto L14;
        return 0.8f;
    L14:
        if (r10 > 240) goto L18;
        return 0.87f;
    L18:
        if (r10 > 320) goto L21;
        return 1.0f;
    L21:
        if (r10 > 480) goto L25;
        return 1.5f;
    L25:
        if (r10 > 640) goto L28;
        return 1.8f;
    L28:
        return 0.9f;
    }

    private synchronized void tryUploadMapInit() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMapLoad == true) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.mHasSetBizName == false) goto L11;
        MapMonitor.mapInit(getMapType(), this.mInitDuration, this.mMapLoadDuration);     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public void addFirstMapTileLoadedListener(FirstMapTileLoadedListener r1) {
    }

    public void addPolygonClickListener(PolygonClickListener r1) {
    }

    public ITextPath addTextPath(BDTextPathOptions r1) {
        return null;
    }

    public int getMapType() {
        return 1;
    }

    public Point getScaleControlPosition() {
        return null;
    }

    public boolean isAvailable(Context r1) {
        return true;
    }

    public boolean isSupportSetRotation() {
        return true;
    }

    public synchronized void onDestroy() {
        monitor-enter(this);
        MapLogger.i(TAG, "onDestroy");     // Catch: Throwable -> L6
        destroyForReal();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setHandleGesture(boolean r1) {
    }

    public void setScaleControlPosition(Point r1) {
    }

    static {
        DEFAULT_MAP_CENTER = new LatLng(39.90403d, 116.407525d);
        AMAP_SET_POLYGON_STROKE_DOTTED_LINE_TYPE_METHOD = resolveSetPolygonStrokeDottedLineTypeMethod();
    }

    private void clearLocationOverlayForReuse() {
        AMap r0 = this.mAMap;     // Catch: Exception -> L7
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setOnMyLocationChangeListener(null);     // Catch: Exception -> L7
        this.mAMap.setMyLocationEnabled(false);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "clearLocationOverlayForReuse error:" + e.getMessage());
    }

    private long nextShotGeneration() {
        Object r0 = this.mShotLock;
        monitor-enter(r0);
        long r1 = this.mShotGeneration + 1;     // Catch: Throwable -> L7
        this.mShotGeneration = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void prepareMapLoadStateForReuse() {
        Object r0 = this.mMapLoadStateLock;
        monitor-enter(r0);
        boolean r1 = this.mIsMapLoad;     // Catch: Throwable -> L12
        this.mPendingCustomMapType = null;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        long r10 = 0;
        this.mInitDuration = 0;
        if (r1 == true) goto L10;
        r10 = -1;
    L10:
        this.mMapLoadDuration = r10;
        MapLogger.i(TAG, "prepareMapLoadStateForReuse, isMapLoaded=" + r1);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void removeRealMapViewFromParent() {
    L12:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "removeRealMapViewFromParent error:" + e.getMessage());
        return;
    L3:
        if (this.mMapView != null) goto L5;
        return;
    L5:
        if (this.mMapView.getRealMapView() == null) goto L17;
        View r0 = this.mMapView.getRealMapView();     // Catch: Exception -> L12
        if ((r0.getParent() instanceof ViewGroup) == false) goto L18;
        ((ViewGroup) r0.getParent()).removeView(r0);     // Catch: Exception -> L12
        return;
    L18:
        return;
    }

    private void resetShotStateForReuse() {
        Object r0 = this.mShotLock;
        monitor-enter(r0);
        this.mShotGeneration++;     // Catch: Throwable -> L7
        this.mCachedScreenShot = null;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static Method resolveSetPolygonStrokeDottedLineTypeMethod() {
        return PolygonOptions.class.getMethod("setStrokeDottedLineType", new Class[]{Integer.TYPE});
    L4:
        return null;
    }

    public void clear() {
        AMap r0 = this.mAMap;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.mAliMarkers.clear();
        this.mAliPolylines.clear();
        this.mAliCircles.clear();
        this.mAliPolygons.clear();
        this.mAliHeatMaps.clear();
        this.mAliArcs.clear();
        this.mAliTextPaths.clear();
    }

    public synchronized void destroyForReal() {
        monitor-enter(this);
        MapLogger.i(TAG, "destroyForReal");     // Catch: Throwable -> L14
        removeRealMapViewFromParent();     // Catch: Throwable -> L14
        resetShotStateForReuse();     // Catch: Throwable -> L14
        clearMapForDestroy();     // Catch: Throwable -> L14
        if (this.mMapView != null) goto L18;
        monitor-exit(this);
        return;
    L18:
        this.mMapView.onDestroy();     // Catch: Exception -> L10 Throwable -> L14
        this.mMapView = null;     // Catch: Exception -> L10 Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);     // Catch: Throwable -> L14
        MapLogger.e(TAG, "onDestroy error:" + e.getMessage());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public BDLatLng getCenter() {
        AMap r0 = this.mAMap;
        if (r0 == null) goto L5;
        return new BDLatLng(r0.getCameraPosition().target.latitude, this.mAMap.getCameraPosition().target.longitude);
    L8:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "getCenter error:" + e.getMessage());
        return new BDLatLng(0.0d, 0.0d);
    L5:
        return new BDLatLng(0.0d, 0.0d);
    }

    public Bitmap getMapScreenShotFromCache() {
    L31:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "getMapScreenShotFromCache error:" + e.getMessage());
        return null;
    L34:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "getMapScreenShotFromCache oom error:" + e.getMessage());
        return null;
    L4:
        if (this.mAppContext != null) goto L7;
        MapLogger.i(TAG, "getMapScreenShotFromCache mAppContext == null");     // Catch: Exception -> L31 OutOfMemoryError -> L34
        MapMonitor.getShotFromCacheMonitor(getMapType(), "context_null", System.currentTimeMillis(), 0, false);     // Catch: Exception -> L31 OutOfMemoryError -> L34
        return null;
    L7:
        long r10 = SystemClock.elapsedRealtime();     // Catch: Exception -> L31 OutOfMemoryError -> L34
        Object r11 = this.mShotLock;     // Catch: Exception -> L31 OutOfMemoryError -> L34
        monitor-enter(r11);     // Catch: Exception -> L31 OutOfMemoryError -> L34
        Bitmap r12 = this.mCachedScreenShot;     // Catch: Throwable -> L28
        if (r12 != null) goto L12;
    L17:
        Bitmap r13 = null;
    L18:
        monitor-exit(r11);     // Catch: Throwable -> L28
        if (r13 == null) goto L22;
        MapLogger.i(TAG, "getMapScreenShotFromCache return local copy, dt = " + (SystemClock.elapsedRealtime() - r10) + " ms, bmp = " + r13.getWidth() + "x" + r13.getHeight());     // Catch: Exception -> L31 OutOfMemoryError -> L34
        MapMonitor.getShotFromCacheMonitor(getMapType(), "success", System.currentTimeMillis(), SystemClock.elapsedRealtime() - r10, false);     // Catch: Exception -> L31 OutOfMemoryError -> L34
        return r13;
    L22:
        long r14 = SystemClock.elapsedRealtime();     // Catch: Exception -> L31 OutOfMemoryError -> L34
        Bitmap r15 = BitmapFileUtil.readBitmap(this.mAppContext, "lbs", "map_shot.jpg");     // Catch: Exception -> L31 OutOfMemoryError -> L34
        if (r15 != null) goto L26;
        MapLogger.i(TAG, "getMapScreenShotFromCache diskBmp == null");     // Catch: Exception -> L31 OutOfMemoryError -> L34
        MapMonitor.getShotFromCacheMonitor(getMapType(), " and read_fail", System.currentTimeMillis(), SystemClock.elapsedRealtime() - r10, true);     // Catch: Exception -> L31 OutOfMemoryError -> L34
        return null;
    L26:
        MapLogger.i(TAG, "getMapScreenShotFromCache read disk done, dt = " + (SystemClock.elapsedRealtime() - r14) + " ms, bmp = " + r15.getWidth() + "x" + r15.getHeight() + ", size = " + String.format("%.2f", new Object[]{Float.valueOf((r15.getByteCount() / 1024.0f) / 1024.0f)}) + " MB");     // Catch: Exception -> L31 OutOfMemoryError -> L34
        MapMonitor.getShotFromCacheMonitor(getMapType(), "success", System.currentTimeMillis(), SystemClock.elapsedRealtime() - r10, true);     // Catch: Exception -> L31 OutOfMemoryError -> L34
        return r15;
    L12:
        if (r12.isRecycled() == true) goto L17;
        Bitmap.Config r16 = this.mCachedScreenShot.getConfig();     // Catch: Throwable -> L28
        if (r16 != null) goto L16;
        r16 = Bitmap.Config.RGB_565;     // Catch: Throwable -> L28
    L16:
        r13 = this.mCachedScreenShot.copy(r16, false);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: Exception -> L31 OutOfMemoryError -> L34
    }

    public float getMaxZoomLevel() {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L7;
        return -1.0f;
    L7:
        return r0.getMaxZoomLevel();
    }

    public float getMinZoomLevel() {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L7;
        return -1.0f;
    L7:
        return r0.getMinZoomLevel();
    }

    public View getRealMapView() {
        if (this.mMapView != null) goto L7;
        return null;
    L7:
        return this.mMapView.getRealMapView();
    }

    public float getRotationDegree() {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L11;
        MapLogger.e(TAG, "getRotationDegree: error, mAMap == null");
        return -1.0f;
    L11:
        return r0.getCameraPosition().bearing;
    L8:
        th = move-exception;
        MapMonitor.amapExceptionMonitor(th);
        MapLogger.i(TAG, "3D AMap, getRotationDegree error:" + th.getMessage());
        return -1.0f;
    }

    public float getScalePerPixel() {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L7;
        return -1.0f;
    L7:
        return r0.getScalePerPixel();
    }

    public BDMapUiConfigs getUiSettings() {
        return AMapUiSettingsAdapter.getUiSettings(this.mAMap, this.mLogoPosition);
    }

    public Map<String, Double> getVisibleRegion() {
        if (this.mAMap == null) goto L5;
        HashMap r0 = new HashMap();     // Catch: Exception -> L10
        VisibleRegion r1 = this.mAMap.getProjection().getVisibleRegion();     // Catch: Exception -> L10
        if (r1 == null) goto L9;
        r0.put("far_left_lat", Double.valueOf(r1.farLeft.latitude));     // Catch: Exception -> L10
        r0.put("far_left_lng", Double.valueOf(r1.farLeft.longitude));     // Catch: Exception -> L10
        r0.put("far_right_lat", Double.valueOf(r1.farRight.latitude));     // Catch: Exception -> L10
        r0.put("far_right_lng", Double.valueOf(r1.farRight.longitude));     // Catch: Exception -> L10
        r0.put("near_left_lat", Double.valueOf(r1.nearLeft.latitude));     // Catch: Exception -> L10
        r0.put("near_left_lng", Double.valueOf(r1.nearLeft.longitude));     // Catch: Exception -> L10
        r0.put("near_right_lat", Double.valueOf(r1.nearRight.latitude));     // Catch: Exception -> L10
        r0.put("near_right_lng", Double.valueOf(r1.nearRight.longitude));     // Catch: Exception -> L10
    L9:
        return r0;
    L10:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "getVisibleRegion error:" + e.getMessage());
        return new HashMap();
    L5:
        return new HashMap();
    }

    public float getZoom() {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L10;
        return 0.0f;
    L10:
        return r0.getCameraPosition().zoom;
    L7:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "getZoom error:" + e.getMessage());
        return 0.0f;
    }

    public int getZoomPosition() {
        return AMapUiSettingsAdapter.getZoomPosition(this.mAMap);
    }

    public boolean isCompassEnabled() {
        return AMapUiSettingsAdapter.isCompassEnabled(this.mAMap);
    }

    public boolean isGestureScaleByMapCenter() {
        return AMapUiSettingsAdapter.isGestureScaleByMapCenter(this.mAMap);
    }

    public boolean isIndoorSwitchEnabled() {
        return AMapUiSettingsAdapter.isIndoorSwitchEnabled(this.mAMap);
    }

    public boolean isMyLocationButtonEnabled() {
        return AMapUiSettingsAdapter.isMyLocationButtonEnabled(this.mAMap);
    }

    public boolean isPoiClickEnabled() {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isTouchPoiEnable();
    }

    public boolean isReusableReady() {
        if (this.mMapView != null) goto L5;
    L9:
        return false;
    L5:
        if (this.mMapView.getRealMapView() == null) goto L9;
        if (this.mAMap == null) goto L9;
        return true;
    }

    public boolean isRotateGesturesEnabled() {
        return AMapUiSettingsAdapter.isRotateGesturesEnabled(this.mAMap);
    }

    public boolean isScaleControlsEnabled() {
        return AMapUiSettingsAdapter.isScaleControlsEnabled(this.mAMap);
    }

    public boolean isScrollGesturesEnabled() {
        return AMapUiSettingsAdapter.isScrollGesturesEnabled(this.mAMap);
    }

    public boolean isTiltGesturesEnabled() {
        return AMapUiSettingsAdapter.isTiltGesturesEnabled(this.mAMap);
    }

    public boolean isZoomControlsEnabled() {
        return AMapUiSettingsAdapter.isZoomControlsEnabled(this.mAMap);
    }

    public boolean isZoomGesturesEnabled() {
        return AMapUiSettingsAdapter.isZoomGesturesEnabled(this.mAMap);
    }

    public void onLowMemory() {
        MapLogger.i(TAG, "onLowMemory");
        if (this.mMapView != null) goto L10;
        return;
    L10:
        this.mMapView.onLowMemory();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "onLowMemory error:" + e.getMessage());
    }

    public void onPause() {
        MapLogger.i(TAG, "onPause");
        if (this.mMapView != null) goto L10;
        return;
    L10:
        this.mMapView.onPause();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "onPause error:" + e.getMessage());
    }

    public void onResume() {
        MapLogger.i(TAG, "onResume");
        if (this.mMapView != null) goto L10;
        return;
    L10:
        this.mMapView.onResume();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "onResume error:" + e.getMessage());
    }

    public void onStart() {
        MapLogger.i(TAG, "onStart");
    }

    public void onStop() {
        MapLogger.i(TAG, "onStop");
    }

    public void releaseForReuse() {
        MapLogger.i(TAG, "releaseForReuse");
        removeRealMapViewFromParent();
        onPause();
        clearLocationOverlayForReuse();
        clear();
        this.mInfoWindowProvider = null;
        this.mMapActionListenerList.clear();
        this.mMapActionReasonListenerList.clear();
        this.mMarkerActionListenerList.clear();
        this.mPolylineClickListenerList.clear();
        this.mPoiClickListeners.clear();
        this.mPendingCustomMapType = null;
        resetShotStateForReuse();
        this.mLastZoom = -1.0f;
        this.mLastEndZoom = -1.0f;
        this.mLastLat = -1.0d;
        this.mLastLng = -1.0d;
        this.mLastEndLat = -1.0d;
        this.mLastEndLng = -1.0d;
        this.mLastMapActionReason = MapActionReasonListener.MapActionReason.REASON_SDK;
        this.mReuseStartTime = -1;
        this.mHasSetBizName = false;
    }

    public void removeAllArcs() {
        Iterator<IArc> r0 = this.mAliArcs.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IArc r1 = r0.next();
        if (r1 == null) goto L4;
        r1.remove();
        goto L4
    L8:
        this.mAliArcs.clear();
    }

    public void removeAllCircles() {
        Iterator<ICircle> r0 = this.mAliCircles.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ICircle r1 = r0.next();
        if (r1 == null) goto L4;
        r1.remove();
        goto L4
    L8:
        this.mAliCircles.clear();
    }

    public void removeAllHeatMaps() {
        List<IHeatMap> r0 = this.mAliHeatMaps;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.mAliHeatMaps.isEmpty() == true) goto L13;
        removeHeatMap((IHeatMap) ListProtector.get(this.mAliHeatMaps, 0));
        goto L8
    }

    public void removeAllMarkers() {
        List<IMarker> r0 = this.mAliMarkers;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.mAliMarkers.isEmpty() == true) goto L13;
        removeMarker((IMarker) ListProtector.get(this.mAliMarkers, 0));
        goto L8
    }

    public void removeAllPolygons() {
        Iterator<IPolygon> r0 = this.mAliPolygons.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IPolygon r1 = r0.next();
        if (r1 == null) goto L4;
        r1.remove();
        goto L4
    L8:
        this.mAliPolygons.clear();
    }

    public void removeAllPolylines() {
        Iterator<IPolyline> r0 = this.mAliPolylines.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IPolyline r1 = r0.next();
        if (r1 == null) goto L4;
        r1.remove();
        goto L4
    L8:
        this.mAliPolylines.clear();
    }

    public void removeAllTextPaths() {
        Iterator<ITextPath> r0 = this.mAliTextPaths.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ITextPath r1 = r0.next();
        if (r1 == null) goto L4;
        r1.remove();
        goto L4
    L8:
        this.mAliTextPaths.clear();
    }

    public AMapServiceImpl() {
        this.mLogoPosition = 0;
        this.mMapActionListenerList = new ArrayList();
        this.mMapActionReasonListenerList = new CopyOnWriteArrayList();
        this.mMarkerActionListenerList = new ArrayList();
        this.mPolylineClickListenerList = new ArrayList();
        this.mPoiClickListeners = new CopyOnWriteArrayList();
        this.mAliMarkers = new ArrayList();
        this.mAliPolylines = new ArrayList();
        this.mAliCircles = new ArrayList();
        this.mAliPolygons = new ArrayList();
        this.mAliHeatMaps = new ArrayList();
        this.mAliArcs = new ArrayList();
        this.mAliTextPaths = new ArrayList();
        this.mIsMapLoad = false;
        this.mHasSetBizName = false;
        this.mMapLoadStateLock = new Object();
        this.mLastZoom = -1.0f;
        this.mLastEndZoom = -1.0f;
        this.mLastLat = -1.0d;
        this.mLastLng = -1.0d;
        this.mLastEndLat = -1.0d;
        this.mLastEndLng = -1.0d;
        this.mLastMapActionReason = MapActionReasonListener.MapActionReason.REASON_SDK;
        this.mInitDuration = -1;
        this.mMapLoadDuration = -1;
        this.mReuseStartTime = -1;
        this.mShotLock = new Object();
        this.mShotGeneration = 0;
    }

    private void clearMapForDestroy() {
        clear();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "clearMapForDestroy error:" + e.getMessage());
    }

    public void onMapLoaded() {
        this.mMapLoadDuration = SystemClock.elapsedRealtime() - this.mMapCreateTime;
        Object r0 = this.mMapLoadStateLock;
        monitor-enter(r0);
        this.mIsMapLoad = true;     // Catch: Throwable -> L15
        Integer r10 = this.mPendingCustomMapType;     // Catch: Throwable -> L15
        this.mPendingCustomMapType = null;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        if (r10 == null) goto L9;
        applyCustomMapType(r10);
    L9:
        Iterator<MapActionListener> r1 = this.mMapActionListenerList.iterator();
    L11:
        if (r1.hasNext() == false) goto L13;
        r1.next().onMapLoad();
        goto L11
    L13:
        MapMonitor.loadMap(getMapType(), true, this.mMapLoadDuration);
        tryUploadMapInit();
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public int getLogoPosition() {
        return this.mLogoPosition;
    }

    public List<IMarker> getMarkers() {
        return this.mAliMarkers;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_amap_AMapServiceImpl_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static /* synthetic */ AMap access$000(AMapServiceImpl r0) {
        return r0.mAMap;
    }

    public static /* synthetic */ Object access$200(AMapServiceImpl r0) {
        return r0.mShotLock;
    }

    public static /* synthetic */ IInfoWindowProvider access$500(AMapServiceImpl r0) {
        return r0.mInfoWindowProvider;
    }

    public static /* synthetic */ List access$600(AMapServiceImpl r0) {
        return r0.mAliMarkers;
    }

    private void applyCustomMapType(Integer r10) {
        AMap r0 = this.mAMap;
        if (r0 == null) goto L13;
        if (r10 == null) goto L14;
        r0.setMapType(r10.intValue());     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "applyCustomMapType error:" + e.getMessage());
        return;
    L14:
        return;
    }

    private static void applyTextureViewDestroyConfig(MapInitConfig r10) {
        if (r10 != null) goto L15;
        MapLogger.i(TAG, "applyTextureViewDestroyConfig skipped: config is null");
        return;
    L15:
        Map r11 = r10.getExtraParams();     // Catch: Throwable -> L12
        if (r11 != null) goto L9;
        return;
    L9:
        if (Boolean.TRUE.equals(r11.get("useAliMap")) == false) goto L18;
        MapsInitializer.setTextureViewDestorySync(false);     // Catch: Throwable -> L12
        MapLogger.i(TAG, "useAliMap=true, setTextureViewDestorySync=false");     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L12:
        th = move-exception;
        MapLogger.e(TAG, "applyTextureViewDestroyConfig failed: " + th);
    }

    private void applyTopLogoPosition(View r11) {
        AMap r0 = this.mAMap;
        if (r0 == null) goto L40;
        if (r11 == null) goto L40;
        if (r11.getWidth() > 0) goto L9;
    L38:
        MapLogger.i(TAG, "applyTopLogoPosition skipped: invalid size, position=" + this.mLogoPosition + ", width=" + r11.getWidth() + ", height=" + r11.getHeight());
        return;
    L9:
        if (r11.getHeight() <= 0) goto L38;
        Context r10 = r11.getContext();
        if (r10 != null) goto L15;
        MapLogger.i(TAG, "applyTopLogoPosition skipped: context is null");
        return;
    L15:
        Context r12 = r10.getApplicationContext();
        if (r12 == null) goto L18;
        r10 = r12;
    L18:
        Resources r13 = r10.getResources();
        if (r13 != null) goto L22;
        MapLogger.i(TAG, "applyTopLogoPosition skipped: resources are null");
        return;
    L22:
        DisplayMetrics r14 = INVOKEVIRTUAL_com_bytedance_amap_AMapServiceImpl_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r13);
        if (r14 != null) goto L26;
        MapLogger.i(TAG, "applyTopLogoPosition skipped: display metrics are null");
        return;
    L26:
        int r15 = Math.round(r14.density * 10.0f);
        int r16 = Math.round(r14.density * 10.0f);
        float r17 = getLogoDensityScale(r14.densityDpi);
        int r18 = Math.max(1, (int) (160.0f * r17));
        int r19 = Math.max(1, (int) (40.0f * r17));
        int r20 = this.mLogoPosition;
        if (r20 != 3) goto L29;
    L36:
        int r21 = Math.max(0, r15);
        int r110 = Math.max(0, (r11.getHeight() - r19) - r16);
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setLogoLeftMargin(r21).setLogoBottomMargin(r110).build());
        MapLogger.i(TAG, "applyTopLogoPosition: requested=" + this.mLogoPosition + ", densityDpi=" + r14.densityDpi + ", density=" + r14.density + ", densityScale=" + r17 + ", logoSizePx=" + r18 + "x" + r19 + ", leftMarginPx=" + r21 + ", bottomMarginPx=" + r110);
        return;
    L29:
        if (r20 != 4) goto L31;
        r15 = (r11.getWidth() - r18) / 2;
        goto L36
    L31:
        if (r20 == 5) goto L34;
        MapLogger.i(TAG, "applyTopLogoPosition skipped: unexpected position=" + this.mLogoPosition);
        return;
    L34:
        r15 = (r11.getWidth() - r18) - r15;
    L40:
        MapLogger.i(TAG, "applyTopLogoPosition skipped: map or map view is null, position=" + this.mLogoPosition);
    }

    private PolylineOptions.LineCapType convertLineCapType(int r10) {
        if (r10 == 0) goto L14;
        if (r10 == 1) goto L12;
        if (r10 == 2) goto L10;
        return PolylineOptions.LineCapType.LineCapRound;
    L10:
        return PolylineOptions.LineCapType.LineCapArrow;
    L12:
        return PolylineOptions.LineCapType.LineCapSquare;
    L14:
        return PolylineOptions.LineCapType.LineCapButt;
    }

    private PolylineOptions.LineJoinType convertLineJoinType(int r10) {
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L9;
        return PolylineOptions.LineJoinType.LineJoinBevel;
    L9:
        return PolylineOptions.LineJoinType.LineJoinRound;
    L11:
        return PolylineOptions.LineJoinType.LineJoinMiter;
    }

    private int convertPolygonStrokeDottedLineType(BDPolygonOptions r10) {
        if (r10.isDottedStroke() == true) goto L7;
        return -1;
    L7:
        if (r10.getDottedLineType() == 1) goto L10;
        return 0;
    L10:
        return 1;
    }

    private void dispatchMapLoadIfNeeded(MapActionListener r10) {
        if (this.mIsMapLoad == false) goto L12;
        if (r10 == null) goto L13;
        long r11 = -1;
        if (this.mReuseStartTime == (-1)) goto L10;
        r11 = SystemClock.elapsedRealtime() - this.mReuseStartTime;
    L10:
        MapLogger.i(TAG, "dispatchMapLoadIfNeeded after reuse: service=" + Integer.toHexString(System.identityHashCode(this)) + ", reuseToMapLoadDuration=" + r11);
        r10.onMapLoad();
        return;
    L13:
        return;
    }

    private Integer getAMapType(BDMapStyleType r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = AnonymousClass6.$SwitchMap$com$bytedance$map$api$model$BDMapStyleType[r10.ordinal()];
        if (r11 == 1) goto L13;
        if (r11 == 2) goto L11;
        return null;
    L11:
        return 3;
    L13:
        return 1;
    }

    private boolean isShotGenerationValid(long r10) {
        Object r0 = this.mShotLock;
        monitor-enter(r0);
        boolean r11 = isShotGenerationValidLocked(r10);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isShotGenerationValidLocked(long r10) {
        if (this.mShotGeneration != r10) goto L5;
        return true;
    L5:
        return false;
    }

    public IArc addArc(BDArcOptions r11) {
        if (this.mAMap == null) goto L15;
        if (r11 == null) goto L19;
        BDLatLng r0 = r11.getStartLatLng();
        BDLatLng r10 = r11.getMiddleLatLng();
        BDLatLng r12 = r11.getEndLatLng();
        if (r0 == null) goto L16;
        if (r10 == null) goto L17;
        if (r12 == null) goto L20;
        Arc r1 = this.mAMap.addArc(new ArcOptions().point(new LatLng(r0.getLatitude(), r0.getLongitude()), new LatLng(r10.getLatitude(), r10.getLongitude()), new LatLng(r12.getLatitude(), r12.getLongitude())).strokeColor(r11.getColor()).strokeWidth(r11.getWidth()).zIndex(r11.getZIndex()).visible(r11.isVisible()));
        if (r1 == null) goto L18;
        AliArc r13 = new AliArc(r1, r11.getId());
        this.mAliArcs.add(r13);
        return r13;
    L18:
        return null;
    L20:
        return null;
    L17:
        return null;
    L16:
        return null;
    L19:
        return null;
    L15:
        return null;
    }

    public ICircle addCircle(BDCircleOptions r10) {
        if (this.mAMap == null) goto L13;
        if (r10 == null) goto L13;
        BDLatLng r0 = r10.getCenter();
        if (r0 != null) goto L14;
        return null;
    L14:
        AliCircle r11 = new AliCircle(this.mAMap.addCircle(new CircleOptions().center(new LatLng(r0.getLatitude(), r0.getLongitude())).radius(r10.getRadius()).zIndex(r10.getzIndex()).fillColor(r10.getFillColor()).strokeColor(r10.getStrokeColor()).strokeWidth(r10.getStrokeWidth())), r10.getId());     // Catch: Exception -> L11
        this.mAliCircles.add(r11);     // Catch: Exception -> L11
        return r11;
    L11:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "addCircle error:" + e.getMessage());
    L13:
        return null;
    }

    public IHeatMap addHeatMap(BDHeatMapOptions r11) {
        if (this.mAMap == null) goto L30;
        if (r11 == null) goto L30;
        if (r11.getColorArray() == null) goto L30;
        if (r11.getStepArray() == null) goto L30;
        if (r11.getColorArray().length == r11.getStepArray().length) goto L14;
    L29:
        MapLogger.i(TAG, "ColorArray.length != StepArray.length || length == 0");
        goto L30
    L14:
        if (r11.getColorArray().length == 0) goto L29;
        ArrayList r0 = new ArrayList();
        if (r11.getData() == null) goto L27;
        Iterator r1 = r11.getData().iterator();
    L20:
        if (r1.hasNext() == false) goto L27;
        BDWeightedLatLng r10 = (BDWeightedLatLng) r1.next();
        if (r10 == null) goto L20;
        if (r10.getLatLng() == null) goto L20;
        BDLatLng r12 = r10.getLatLng();
        r0.add(new WeightedLatLng(new LatLng(r12.getLatitude(), r12.getLongitude()), r10.getWeight()));
    L27:
        Gradient r13 = new Gradient(r11.getColorArray(), r11.getStepArray());
        HeatmapTileProvider r14 = new HeatmapTileProvider.Builder().weightedData(r0).gradient(r13).radius(r11.getRadius()).build();
        TileOverlayOptions r15 = new TileOverlayOptions().tileProvider(r14).zIndex(r11.getZIndex());
        AliHeatMap r16 = new AliHeatMap(this.mAMap.addTileOverlay(r15), r11.getId());
        this.mAliHeatMaps.add(r16);
        return r16;
    L30:
        return null;
    }

    public void addMapActionListener(MapActionListener r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.mMapActionListenerList.add(r10);
        dispatchMapLoadIfNeeded(r10);
    }

    public void addMapActionReasonListener(MapActionReasonListener r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.mMapActionReasonListenerList.add(r10);
    }

    public IMarker addMarker(BDMarkerOptions r15) {
        if (this.mAMap == null) goto L56;
        if (r15 == null) goto L56;
        BDLatLng r10 = r15.getLatLng();
        if (r10 == null) goto L9;
    L12:
        Bitmap r11 = r15.getIcon();
        View r12 = r15.getView();
        long r13 = SystemClock.elapsedRealtime();     // Catch: Exception -> L54
        MarkerOptions r14 = new MarkerOptions().position(new LatLng(r10.getLatitude(), r10.getLongitude())).anchor(r15.getAnchorX(), r15.getAnchorY()).rotateAngle(r15.getRotateAngle()).alpha(r15.getAlpha()).draggable(r15.isDraggable()).zIndex(r15.getZIndex()).infoWindowEnable(r15.isInfoWindowEnable()).setInfoWindowOffset(r15.getOffsetX(), r15.getOffSetY());     // Catch: Exception -> L54
        if (r15.isEnableCustomView() == false) goto L31;
        if (r12 != null) goto L58;
    L21:
        boolean r1 = false;
    L22:
        if (r1 == true) goto L39;
        if (r12 == null) goto L25;
        BitmapDescriptor r16 = BitmapDescriptorFactory.fromView(r12);     // Catch: Exception -> L54
    L28:
        if (r16 != null) goto L30;
        return null;
    L30:
        r14.icon(r16);     // Catch: Exception -> L54
        goto L39
    L25:
        if (r11 == null) goto L27;
        r16 = BitmapDescriptorFactory.fromBitmap(r11);     // Catch: Exception -> L54
        goto L28
    L27:
        r16 = null;
    L39:
        Marker r17 = this.mAMap.addMarker(r14);     // Catch: Exception -> L54
        if (r17 != null) goto L43;
        MapMonitor.drawAnnotation(getMapType(), false, SystemClock.elapsedRealtime() - r13);     // Catch: Exception -> L54
        return null;
    L43:
        MapMonitor.drawAnnotation(getMapType(), true, SystemClock.elapsedRealtime() - r13);     // Catch: Exception -> L54
        if (r15.getScreenPoint() == null) goto L46;
        r17.setPositionByPixels(r15.getScreenPoint().x, r15.getScreenPoint().y);     // Catch: Exception -> L54
    L46:
        AliMarker r18 = new AliMarker(r17, r15.getId(), r15.getScreenPoint());     // Catch: Exception -> L54
        if (r15.isShowInfoWindow() == false) goto L50;
        r18.showInfoWindow();     // Catch: Exception -> L54
    L50:
        if (r15.isClickable() == true) goto L52;
        r18.setClickable(r15.isClickable());     // Catch: Exception -> L54
    L52:
        this.mAliMarkers.add(r18);     // Catch: Exception -> L54
        return r18;
    L58:
        MarkerOptions.class.getMethod("icon", new Class[]{View.class}).invoke(r14, new Object[]{r12});     // Catch: Exception -> L19
        r1 = true;
        goto L22
    L19:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);     // Catch: Exception -> L54
        MapLogger.e(TAG, "addMarker icon error:" + e.getMessage());     // Catch: Exception -> L54
        goto L21
    L31:
        if (r11 == null) goto L33;
        BitmapDescriptor r19 = BitmapDescriptorFactory.fromBitmap(r11);     // Catch: Exception -> L54
    L36:
        if (r19 != null) goto L38;
        return null;
    L38:
        r14.icon(r19);     // Catch: Exception -> L54
        goto L39
    L33:
        if (r12 == null) goto L35;
        r19 = BitmapDescriptorFactory.fromView(r12);     // Catch: Exception -> L54
        goto L36
    L35:
        r19 = null;
    L54:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "addMarker error:" + e.getMessage());
        goto L56
    L9:
        if (r15.getScreenPoint() != null) goto L11;
        return null;
    L11:
        LatLng r20 = DEFAULT_MAP_CENTER;
        r10 = new BDLatLng(r20.latitude, r20.longitude);
    L56:
        return null;
    }

    public void addMarkerActionListener(MarkerActionListener r10) {
        this.mMarkerActionListenerList.add(r10);
    }

    public List<IMarker> addMarkers(List<BDMarkerOptions> r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.size() == 0) goto L14;
        ArrayList r0 = new ArrayList();
        Iterator<BDMarkerOptions> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        r0.add(addMarker(r11.next()));
        goto L8
    L10:
        return r0;
    L14:
        return null;
    }

    public void addPoiClickListener(PoiClickListener r10) {
        this.mPoiClickListeners.add(r10);
    }

    public IPolygon addPolygon(BDPolygonOptions r10) {
        if (this.mAMap == null) goto L19;
        if (r10 == null) goto L19;
        List r0 = r10.getLatLngs();
        if (r0 == null) goto L19;
        if (r0.size() == 0) goto L19;
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L17
        Iterator r1 = r0.iterator();     // Catch: Exception -> L17
    L13:
        if (r1.hasNext() == false) goto L15;
        BDLatLng r12 = (BDLatLng) r1.next();     // Catch: Exception -> L17
        r11.add(new LatLng(r12.getLatitude(), r12.getLongitude()));     // Catch: Exception -> L17
        goto L13
    L15:
        PolygonOptions r13 = new PolygonOptions();     // Catch: Exception -> L17
        r13.addAll(r11);     // Catch: Exception -> L17
        r13.zIndex(r10.getZIndex());     // Catch: Exception -> L17
        r13.fillColor(r10.getFillColor());     // Catch: Exception -> L17
        r13.strokeColor(r10.getStrokeColor());     // Catch: Exception -> L17
        r13.strokeWidth(r10.getStrokeWidth());     // Catch: Exception -> L17
        applyPolygonDottedStroke(r13, convertPolygonStrokeDottedLineType(r10));     // Catch: Exception -> L17
        AliPolygon r14 = new AliPolygon(this.mAMap.addPolygon(r13), r10.getId());     // Catch: Exception -> L17
        this.mAliPolygons.add(r14);     // Catch: Exception -> L17
        return r14;
    L17:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "addPolygon error:" + e.getMessage());
    L19:
        return null;
    }

    public IPolyline addPolyline(BDPolylineOptions r10) {
        if (this.mAMap == null) goto L67;
        if (r10 == null) goto L67;
        List r0 = r10.getLatLngs();
        if (r0 == null) goto L67;
        if (r0.size() == 0) goto L67;
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L65
        Iterator r1 = r0.iterator();     // Catch: Exception -> L65
    L13:
        if (r1.hasNext() == false) goto L15;
        BDLatLng r12 = (BDLatLng) r1.next();     // Catch: Exception -> L65
        r11.add(new LatLng(r12.getLatitude(), r12.getLongitude()));     // Catch: Exception -> L65
        goto L13
    L15:
        int r13 = 0;
        if (r10.getDottedLineType() != 1) goto L18;
        int r14 = 1;
    L19:
        int r15 = r10.getColor();     // Catch: Exception -> L65
        if (r10.getColorList() != null) goto L22;
    L24:
        PolylineOptions r16 = new PolylineOptions().addAll(r11).color(r15).width(r10.getWidthFloat()).setDottedLine(r10.isDottedLine()).setDottedLineType(r14).transparency(r10.getAlpha()).zIndex(r10.getZIndex()).lineCapType(convertLineCapType(r10.getLineCapType())).lineJoinType(convertLineJoinType(r10.getLineJoinType()));     // Catch: Exception -> L65
        r16.setReducePoint(r10.getEnableReducePoint());     // Catch: Exception -> L65
        Bitmap r17 = r10.getCustomTexture();     // Catch: Exception -> L65
        if (r17 == null) goto L27;
        BitmapDescriptor r18 = BitmapDescriptorFactory.fromBitmap(r17);     // Catch: Exception -> L65
    L28:
        if (r18 == null) goto L31;
        r16.setCustomTexture(r18).setUseTexture(r10.isUseTexture());     // Catch: Exception -> L65
    L31:
        if (r10.getColorList() == null) goto L36;
        if (r10.getColorList().isEmpty() == true) goto L36;
        r16.colorValues(r10.getColorList());     // Catch: Exception -> L65
    L36:
        if (r10.isUseTexture() == true) goto L38;
    L63:
        Polyline r19 = this.mAMap.addPolyline(r16);     // Catch: Exception -> L65
        MapMonitor.drawLine();     // Catch: Exception -> L65
        AliPolyline r20 = new AliPolyline(r19, r10.getId());     // Catch: Exception -> L65
        this.mAliPolylines.add(r20);     // Catch: Exception -> L65
        return r20;
    L38:
        if (r10.getCustomTextureList() == null) goto L63;
        if (r10.getCustomTextureList().isEmpty() == true) goto L63;
        ArrayList r21 = new ArrayList();     // Catch: Exception -> L65
        Iterator r22 = r10.getCustomTextureList().iterator();     // Catch: Exception -> L65
    L43:
        if (r22.hasNext() == false) goto L51;
        Bitmap r23 = (Bitmap) r22.next();     // Catch: Exception -> L65
        if (r23 == null) goto L43;
        BitmapDescriptor r24 = BitmapDescriptorFactory.fromBitmap(r23);     // Catch: Exception -> L65
        if (r24 == null) goto L43;
        r21.add(r24);     // Catch: Exception -> L65
        goto L43
    L51:
        r16.setCustomTextureList(r21);     // Catch: Exception -> L65
        r16.setUseTexture(r10.isUseTexture());     // Catch: Exception -> L65
        if (r10.getTextureIndexList() != null) goto L54;
    L59:
        ArrayList r25 = new ArrayList();     // Catch: Exception -> L65
        int r26 = Math.min(r21.size(), r11.size() - 1);     // Catch: Exception -> L65
    L60:
        if (r13 >= r26) goto L62;
        r25.add(Integer.valueOf(r13));     // Catch: Exception -> L65
        r13 = r13 + 1;     // Catch: Exception -> L65
        goto L60
    L62:
        r16.setCustomTextureIndex(r25);     // Catch: Exception -> L65
        goto L63
    L54:
        if (r10.getTextureIndexList().isEmpty() == true) goto L59;
        if (r10.getTextureIndexList().size() < (r11.size() - 1)) goto L59;
        r16.setCustomTextureIndex(r10.getTextureIndexList());     // Catch: Exception -> L65
        goto L63
    L27:
        r18 = null;
        goto L28
    L22:
        if (r10.getColorList().isEmpty() == true) goto L24;
        r15 = ((Integer) ListProtector.get(r10.getColorList(), 0)).intValue();     // Catch: Exception -> L65
        goto L24
    L18:
        r14 = 0;
    L65:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "addPolyline error:" + e.getMessage());
    L67:
        return null;
    }

    public void addPolylineClickListener(PolylineClickListener r10) {
        this.mPolylineClickListenerList.add(r10);
    }

    public void attachToParentView(ViewGroup r10) {
        MapLogger.i(TAG, "attachToParentView");
        if (this.mMapView != null) goto L10;
        return;
    L10:
        r10.addView(this.mMapView.getRealMapView(), 0, new ViewGroup.LayoutParams(-1, -1));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "attachToParentView error:" + e.getMessage());
    }

    public void getMapScreenShot(final MapScreenShotListener r10) {
        AMap r0 = this.mAMap;
        if (r0 == null) goto L8;
        if (r10 == null) goto L9;
        r0.getMapScreenShot(new AnonymousClass4(this, r10));
        return;
    L9:
        return;
    }

    public void initMap(MapInitConfig r10) {
        MapLogger.i(TAG, "initMap");
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getContext() == null) goto L41;
        MapMonitorUtil.init(r10.getContext(), MonitorDependImpl.getInstance());
        MapMonitorUtil.setBizName(r10.getBizName());
        this.mAppContext = r10.getContext().getApplicationContext();
        this.mMapCreateTime = SystemClock.elapsedRealtime();
        applyTextureViewDestroyConfig(r10);     // Catch: Exception -> L33
        MapsInitializer.updatePrivacyShow(r10.getContext(), MapGlobalConfig.isContainsPrivacy(), MapGlobalConfig.isPrivacyConfirmed());     // Catch: Exception -> L33
        MapsInitializer.updatePrivacyAgree(r10.getContext(), MapGlobalConfig.isPrivacyConfirmed());     // Catch: Exception -> L33
        if (MapGlobalConfig.getProtocol() != 1) goto L11;
        int r0 = 1;
    L12:
        MapsInitializer.setProtocol(r0);     // Catch: Exception -> L33
        LatLng r1 = DEFAULT_MAP_CENTER;     // Catch: Exception -> L33
        BDLatLng r11 = r10.getCenter();     // Catch: Exception -> L33
        if (r11 == null) goto L15;
        r1 = new LatLng(r11.getLatitude(), r11.getLongitude());     // Catch: Exception -> L33
    L15:
        AMapOptions r12 = new AMapOptions();     // Catch: Exception -> L33
        r12.camera(CameraPosition.fromLatLngZoom(r1, r10.getZoom()));     // Catch: Exception -> L33
        r12.scaleControlsEnabled(r10.isScaleControlsEnabled());     // Catch: Exception -> L33
        r12.zoomControlsEnabled(r10.isZoomControlsEnabled());     // Catch: Exception -> L33
        r12.compassEnabled(r10.isCompassEnabled());     // Catch: Exception -> L33
        r12.zoomGesturesEnabled(r10.isZoomGesturesEnabled());     // Catch: Exception -> L33
        r12.scrollGesturesEnabled(r10.isScrollGesturesEnabled());     // Catch: Exception -> L33
        r12.rotateGesturesEnabled(r10.isRotateGesturesEnabled());     // Catch: Exception -> L33
        r12.tiltGesturesEnabled(r10.isTiltGesturesEnabled());     // Catch: Exception -> L33
        int r13 = r10.getMapContainer();     // Catch: Exception -> L33
        if (r13 == 0) goto L20;
        if (r13 != 1) goto L21;
        this.mMapView = new AliTextureMapView(r10.getContext(), r12);     // Catch: Exception -> L33
    L21:
        this.mMapView.onCreate(null);     // Catch: Exception -> L33
        AMap r14 = this.mMapView.getMap();     // Catch: Exception -> L33
        this.mAMap = r14;     // Catch: Exception -> L33
        if (r14 != null) goto L24;
        MapMonitor.loadMap(getMapType(), false, SystemClock.elapsedRealtime() - this.mMapCreateTime);     // Catch: Exception -> L33
    L31:
        this.mInitDuration = SystemClock.elapsedRealtime() - this.mMapCreateTime;     // Catch: Exception -> L33
        return;
    L24:
        if (r10.isLoadCustomMapStyleFromAssets() == true) goto L36;
    L29:
        this.mAMap.setOnMapLoadedListener(this);     // Catch: Exception -> L33
        this.mAMap.setOnMapTouchListener(this);     // Catch: Exception -> L33
        this.mAMap.setOnCameraChangeListener(this);     // Catch: Exception -> L33
        this.mAMap.setOnMapClickListener(this);     // Catch: Exception -> L33
        this.mAMap.setOnMarkerClickListener(this);     // Catch: Exception -> L33
        this.mAMap.setOnPOIClickListener(this);     // Catch: Exception -> L33
        this.mAMap.setOnPolylineClickListener(this);     // Catch: Exception -> L33
        goto L31
    L36:
        this.mAMap.setCustomMapStyle(new CustomMapStyleOptions().setStyleData(FileUtil.readFileFromAssets(r10.getContext(), "sdk_amap_style.data")).setStyleExtraData(FileUtil.readFileFromAssets(r10.getContext(), "sdk_amap_style_extra.data")));     // Catch: IOException -> L27 Exception -> L33
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L33
        goto L29
    L20:
        this.mMapView = new AliMapView(r10.getContext(), r12);     // Catch: Exception -> L33
        goto L21
    L11:
        r0 = 2;
    L33:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "initMap error:" + e.getMessage());
        return;
    }

    public void launchMapShotToCache(MapShotStatusListener r12) {
    L10:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "launchMapShotToCache error:" + e.getMessage());
        return;
    L12:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "launchMapShotToCache oom error:" + e.getMessage());
        return;
    L4:
        if (this.mAMap == null) goto L8;
        if (r12 == null) goto L8;
        Context r10 = this.mAppContext;     // Catch: Exception -> L10 OutOfMemoryError -> L12
        long r11 = SystemClock.elapsedRealtime();     // Catch: Exception -> L10 OutOfMemoryError -> L12
        long r13 = nextShotGeneration();     // Catch: Exception -> L10 OutOfMemoryError -> L12
        MapLogger.i(TAG, "launchMapShotToCache start");     // Catch: Exception -> L10 OutOfMemoryError -> L12
        this.mAMap.getMapScreenShot(new AnonymousClass5(this, r13, r11, r12, r10));     // Catch: Exception -> L10 OutOfMemoryError -> L12
        return;
    L8:
        MapMonitor.launchShotToCacheMonitor(getMapType(), "launch_fail", System.currentTimeMillis(), 0, 0, 0);     // Catch: Exception -> L10 OutOfMemoryError -> L12
    }

    public void onCameraChange(CameraPosition r11) {
        if (r11 == null) goto L55;
    L40:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "onCameraChange error:" + e.getMessage());
        return;
    L4:
        if (r11.target != null) goto L6;
        return;
    L6:
        if (this.mIsMapLoad == false) goto L57;
        LatLng r1 = r11.target;     // Catch: Exception -> L40
        BDLatLng r0 = new BDLatLng(r1.latitude, r1.longitude);     // Catch: Exception -> L40
        MapActionReasonListener.MapActionReason r10 = this.mLastMapActionReason;     // Catch: Exception -> L40
        LatLng r12 = r11.target;     // Catch: Exception -> L40
        boolean r13 = false;
        if (r12.latitude == this.mLastLat) goto L11;
    L14:
        boolean r14 = true;
    L16:
        if (r11.zoom == this.mLastZoom) goto L18;
        r13 = true;
    L18:
        if (r14 == false) goto L20;
        this.mLastEndLat = -1.0d;     // Catch: Exception -> L40
        this.mLastEndLng = -1.0d;     // Catch: Exception -> L40
    L20:
        if (r13 == false) goto L22;
        this.mLastEndZoom = -1.0f;     // Catch: Exception -> L40
    L22:
        Iterator<MapActionListener> r15 = this.mMapActionListenerList.iterator();     // Catch: Exception -> L40
    L24:
        if (r15.hasNext() == false) goto L30;
        MapActionListener r16 = r15.next();     // Catch: Exception -> L40
        if (r14 == false) goto L28;
        r16.onMapMove(r0);     // Catch: Exception -> L40
    L28:
        if (r13 == false) goto L24;
        r16.onMapZoom(r11.zoom);     // Catch: Exception -> L40
        goto L24
    L30:
        Iterator<MapActionReasonListener> r17 = this.mMapActionReasonListenerList.iterator();     // Catch: Exception -> L40
    L32:
        if (r17.hasNext() == false) goto L38;
        MapActionReasonListener r18 = r17.next();     // Catch: Exception -> L40
        if (r14 == false) goto L36;
        r18.onMapMove(r0, r10);     // Catch: Exception -> L40
    L36:
        if (r13 == false) goto L32;
        r18.onMapZoom(r11.zoom, r10);     // Catch: Exception -> L40
        goto L32
    L38:
        LatLng r19 = r11.target;     // Catch: Exception -> L40
        this.mLastLat = r19.latitude;     // Catch: Exception -> L40
        this.mLastLng = r19.longitude;     // Catch: Exception -> L40
        this.mLastZoom = r11.zoom;     // Catch: Exception -> L40
        return;
    L11:
        if (r12.longitude != this.mLastLng) goto L14;
        r14 = false;
        goto L16
    L57:
        return;
    }

    public void onCameraChangeFinish(CameraPosition r12) {
        if (r12 == null) goto L51;
    L36:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "onCameraChangeFinish error:" + e.getMessage());
        return;
    L4:
        if (r12.target != null) goto L6;
        return;
    L6:
        if (this.mIsMapLoad == false) goto L53;
        LatLng r1 = r12.target;     // Catch: Exception -> L36
        BDLatLng r0 = new BDLatLng(r1.latitude, r1.longitude);     // Catch: Exception -> L36
        MapActionReasonListener.MapActionReason r10 = this.mLastMapActionReason;     // Catch: Exception -> L36
        boolean r11 = true;
        if (r12.zoom == this.mLastEndZoom) goto L11;
        boolean r13 = true;
    L12:
        LatLng r14 = r12.target;     // Catch: Exception -> L36
        if (r14.latitude == this.mLastEndLat) goto L15;
    L18:
        Iterator<MapActionListener> r15 = this.mMapActionListenerList.iterator();     // Catch: Exception -> L36
    L20:
        if (r15.hasNext() == false) goto L26;
        MapActionListener r16 = r15.next();     // Catch: Exception -> L36
        if (r13 == false) goto L24;
        r16.onMapZoomEnd(r12.zoom);     // Catch: Exception -> L36
    L24:
        if (r11 == false) goto L20;
        r16.onMapMoveEnd(r0);     // Catch: Exception -> L36
        goto L20
    L26:
        Iterator<MapActionReasonListener> r17 = this.mMapActionReasonListenerList.iterator();     // Catch: Exception -> L36
    L28:
        if (r17.hasNext() == false) goto L34;
        MapActionReasonListener r18 = r17.next();     // Catch: Exception -> L36
        if (r13 == false) goto L32;
        r18.onMapZoomEnd(r12.zoom, r10);     // Catch: Exception -> L36
    L32:
        if (r11 == false) goto L28;
        r18.onMapMoveEnd(r0, r10);     // Catch: Exception -> L36
        goto L28
    L34:
        LatLng r19 = r12.target;     // Catch: Exception -> L36
        this.mLastEndLat = r19.latitude;     // Catch: Exception -> L36
        this.mLastEndLng = r19.longitude;     // Catch: Exception -> L36
        this.mLastEndZoom = r12.zoom;     // Catch: Exception -> L36
        this.mLastMapActionReason = MapActionReasonListener.MapActionReason.REASON_SDK;     // Catch: Exception -> L36
        return;
    L15:
        if (r14.longitude != this.mLastEndLng) goto L18;
        r11 = false;
        goto L18
    L11:
        r13 = false;
        goto L12
    L53:
        return;
    }

    public void onCreate(Bundle r10) {
        MapLogger.i(TAG, "onCreate");
        if (this.mMapView != null) goto L10;
        return;
    L10:
        this.mMapView.onCreate(r10);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "onCreate error:" + e.getMessage());
    }

    public void onMapClick(LatLng r10) {
        if (r10 != null) goto L12;
        return;
    L12:
        Iterator<MapActionListener> r0 = this.mMapActionListenerList.iterator();     // Catch: Exception -> L9
    L6:
        if (r0.hasNext() == false) goto L16;
        r0.next().onMapClick(new BDLatLng(r10.latitude, r10.longitude));     // Catch: Exception -> L9
        goto L6
    L16:
        return;
    L9:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "onMapClick error:" + e.getMessage());
    }

    public boolean onMarkerClick(Marker r10) {
        Iterator<IMarker> r1 = this.mAliMarkers.iterator();     // Catch: Exception -> L16
    L5:
        if (r1.hasNext() == false) goto L15;
        IMarker r11 = r1.next();     // Catch: Exception -> L16
        if (((AliMarker) r11).getMarker().equals(r10) == false) goto L5;
        Iterator<MarkerActionListener> r12 = this.mMarkerActionListenerList.iterator();     // Catch: Exception -> L16
    L10:
        if (r12.hasNext() == false) goto L13;
        r12.next().onMarkerClick(r11);     // Catch: Exception -> L16
        goto L10
    L13:
        return true;
    L15:
        return false;
    L16:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "onMarkerClick error:" + e.getMessage());
        return false;
    }

    public void onPOIClick(Poi r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r1 = r10.getName();
        if (r10.getCoordinate() != null) goto L7;
        BDLatLng r11 = null;
    L8:
        BDPoi r0 = new BDPoi(r1, r11, r10.getPoiId());
        Iterator<PoiClickListener> r12 = this.mPoiClickListeners.iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        r12.next().onPoiClick(r0);
        goto L10
    L12:
        return;
    L7:
        r11 = new BDLatLng(r10.getCoordinate().latitude, r10.getCoordinate().longitude);
        goto L8
    }

    public void onPolylineClick(Polyline r10) {
        Iterator<IPolyline> r0 = this.mAliPolylines.iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        IPolyline r1 = r0.next();
        if (r1 == null) goto L4;
        if ((r1 instanceof AliPolyline) == false) goto L4;
        if (((AliPolyline) r1).getPolyline().equals(r10) == false) goto L4;
        Iterator<PolylineClickListener> r11 = this.mPolylineClickListenerList.iterator();
    L14:
        if (r11.hasNext() == false) goto L26;
        r11.next().onPolylineClick(r1);
        goto L14
    L26:
        return;
    }

    public void onSaveInstanceState(Bundle r10) {
        MapLogger.i(TAG, "onSaveInstanceState");
        if (this.mMapView != null) goto L10;
        return;
    L10:
        this.mMapView.onSaveInstanceState(r10);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "onSaveInstanceState error:" + e.getMessage());
    }

    public void onTouch(MotionEvent r10) {
        if (r10 == null) goto L4;
        this.mLastMapActionReason = MapActionReasonListener.MapActionReason.REASON_GESTURE;
    L4:
        Iterator<MapActionListener> r0 = this.mMapActionListenerList.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r0.next().onMapTouch(r10);
        goto L6
    }

    public void prepareForReuse(MapInitConfig r10) {
        MapLogger.i(TAG, "prepareForReuse");
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getContext() != null) goto L7;
        return;
    L7:
        if (this.mAMap == null) goto L16;
        applyTextureViewDestroyConfig(r10);
        MapMonitorUtil.setBizName(r10.getBizName());
        this.mAppContext = r10.getContext().getApplicationContext();
        long r0 = SystemClock.elapsedRealtime();
        this.mMapCreateTime = r0;
        this.mReuseStartTime = r0;
        this.mHasSetBizName = false;
        BDLatLng r1 = r10.getCenter();
        if (r1 != null) goto L12;
        LatLng r11 = DEFAULT_MAP_CENTER;
        r1 = new BDLatLng(r11.latitude, r11.longitude);
    L12:
        setCenterAndZoom(r1, r10.getZoom(), false);
        setScaleControlsEnabled(r10.isScaleControlsEnabled());
        setZoomControlsEnabled(r10.isZoomControlsEnabled());
        setCompassEnabled(r10.isCompassEnabled());
        setTrafficEnabled(r10.isTrafficEnabled());
        setZoomGesturesEnabled(r10.isZoomGesturesEnabled());
        setScrollGesturesEnabled(r10.isScrollGesturesEnabled());
        setRotateGesturesEnabled(r10.isRotateGesturesEnabled());
        setTiltGesturesEnabled(r10.isTiltGesturesEnabled());
        prepareMapLoadStateForReuse();
        return;
    }

    public void removeArc(IArc r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.mAliArcs.remove(r10);
        r10.remove();
    }

    public void removeCircle(ICircle r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.mAliCircles.remove(r10);
        r10.remove();
    }

    public void removeHeatMap(IHeatMap r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.mAliHeatMaps.remove(r10);
        r10.clearTileCache();
        r10.remove();
    }

    public void removeMarker(IMarker r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.mAliMarkers.remove(r10);
        r10.destroy();
    }

    public void removePolygon(IPolygon r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.mAliPolygons.remove(r10);
        r10.remove();
    }

    public void removePolyline(IPolyline r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.mAliPolylines.remove(r10);
        r10.remove();
    }

    public void removeTextPath(ITextPath r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.mAliTextPaths.remove(r10);
        r10.remove();
    }

    public void setAllGesturesEnabled(boolean r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setAllGesturesEnabled(r10).build());
    }

    public void setCompassEnabled(boolean r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setCompassEnabled(r10).build());
    }

    public void setCustomMapStyle(BDMapStyleOptions r10) {
        AMap r0 = this.mAMap;
        if (r0 == null) goto L13;
        if (r10 == null) goto L14;
        r0.setCustomMapStyle(AMapStyleOptionsConverter.from(r10));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "setCustomMapStyle error:" + e.getMessage());
        return;
    L14:
        return;
    }

    public void setGestureScaleByMapCenter(boolean r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setGestureScaleByMapCenter(r10).build());
    }

    public void setIndoorSwitchEnabled(boolean r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setIndoorSwitchEnabled(r10).build());
    }

    public void setLocationOverlay(BDLocationOverlayConfig r10) {
        if (this.mAMap == null) goto L21;
        if (r10 == null) goto L22;
        MyLocationStyle r0 = new MyLocationStyle();
        if (r10.getMyLocationIcon() == null) goto L9;
        r0.myLocationIcon(BitmapDescriptorFactory.fromBitmap(r10.getMyLocationIcon()));
    L9:
        r0.anchor(r10.getAnchorU(), r10.getAnchorV());
        r0.radiusFillColor(r10.getRadiusFillColor());
        r0.strokeColor(r10.getStrokeColor());
        r0.strokeWidth(r10.getStrokeWidth());
        r0.myLocationType(r10.getLocationType());
        r0.interval(r10.getIntervalMs());
        MyLocationStyle.class.getMethod("setZIndex", new Class[]{Integer.TYPE}).invoke(r0, new Object[]{Integer.valueOf(r10.getZIndex())});     // Catch: Exception -> L12
    L13:
        r0.showMyLocation(r10.isMyLocationVisible());
        this.mAMap.setMyLocationStyle(r0);
        final LocationChangeListener r1 = r10.getLocationChangeListener();
        AMap r11 = this.mAMap;
        if (r1 != null) goto L16;
        AMap.OnMyLocationChangeListener r12 = null;
    L17:
        r11.setOnMyLocationChangeListener(r12);
        this.mAMap.setMyLocationEnabled(r10.isMyLocationOverlayEnabled());
        return;
    L16:
        r12 = new AnonymousClass3(this, r1);
        goto L17
    L22:
        return;
    }

    public void setLogoBottomMargin(int r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setLogoBottomMargin(r10).build());
    }

    public void setLogoLeftMargin(int r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setLogoLeftMargin(r10).build());
    }

    public void setLogoPosition(int r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L6;
        MapLogger.i(TAG, "setLogoPosition skipped: map is null, position=" + r10);
        return;
    L6:
        this.mLogoPosition = r10;
        if (r10 != 3) goto L9;
    L14:
        boolean r11 = true;
    L15:
        if (r11 == true) goto L19;
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setLogoPosition(r10).build());
        return;
    L19:
        if (this.mMapView != null) goto L21;
        View r1 = null;
    L22:
        if (r1 != null) goto L25;
        MapLogger.i(TAG, "setLogoPosition skipped: map view is null, position=" + r10);
        return;
    L25:
        applyTopLogoPosition(r1);
        return;
    L21:
        r1 = this.mMapView.getRealMapView();
        goto L22
    L9:
        if (r10 == 4) goto L14;
        if (r10 == 5) goto L14;
        r11 = false;
        goto L15
    }

    public void setMaxZoomLevel(float r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r10 <= 20.0f) goto L9;
        r10 = 20.0f;
    L9:
        if (r10 >= 3.0f) goto L11;
        r10 = 3.0f;
    L11:
        r0.setMaxZoomLevel(r10);
    }

    public void setMinZoomLevel(float r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r10 >= 3.0f) goto L9;
        r10 = 3.0f;
    L9:
        if (r10 <= 20.0f) goto L11;
        r10 = 20.0f;
    L11:
        r0.setMinZoomLevel(r10);
    }

    public void setMonitorBizName(String r10) {
        if (r10 != null) goto L4;
    L5:
        r10 = "lynx_default_bizname";
    L6:
        MapMonitorUtil.setBizName(r10);
        this.mHasSetBizName = true;
        tryUploadMapInit();
        return;
    L4:
        if (r10.trim().isEmpty() == false) goto L6;
        goto L5
    }

    public void setMyLocationButtonEnabled(boolean r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setMyLocationButtonEnabled(r10).build());
    }

    public void setPoiClickEnabled(boolean r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTouchPoiEnable(r10);
    }

    public void setRotateGesturesEnabled(boolean r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setRotateGesturesEnabled(r10).build());
    }

    public void setScaleControlsEnabled(boolean r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setScaleControlsEnabled(r10).build());
    }

    public void setScrollGesturesEnabled(boolean r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setScrollGesturesEnabled(r10).build());
    }

    public void setTiltGesturesEnabled(boolean r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setTiltGesturesEnabled(r10).build());
    }

    public void setTrafficEnabled(boolean r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L10;
        return;
    L10:
        r0.setTrafficEnabled(r10);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "setTrafficEnabled error:" + e.getMessage());
    }

    public void setUiSettings(BDMapUiConfigs r10) {
        AMap r0 = this.mAMap;
        if (r0 == null) goto L10;
        if (r10 == null) goto L12;
        AMapUiSettingsAdapter.apply(r0, r10);
        Integer r11 = r10.getLogoPosition();
        if (r11 == null) goto L11;
        setLogoPosition(r11.intValue());
        return;
    L11:
        return;
    L12:
        return;
    }

    public void setZoomControlsEnabled(boolean r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setZoomControlsEnabled(r10).build());
    }

    public void setZoomGesturesEnabled(boolean r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setZoomGesturesEnabled(r10).build());
    }

    public void setZoomInByScreenCenter(boolean r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setZoomInByScreenCenter(r10).build());
    }

    public void setZoomPosition(int r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        AMapUiSettingsAdapter.apply(r0, new BDMapUiConfigs.Builder().setZoomPosition(r10).build());
    }

    public void showMapPoi(boolean r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.showMapText(r10);
    }

    public Point transLatLngToPoint(BDLatLng r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L10;
        return null;
    L10:
        return r0.getProjection().toScreenLocation(new LatLng(r10.getLatitude(), r10.getLongitude()));
    L7:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "transLatLngToPoint error:" + e.getMessage());
        return null;
    }

    public BDLatLng transPointToLatLng(Point r10) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L13;
        return null;
    L13:
        LatLng r11 = r0.getProjection().fromScreenLocation(r10);     // Catch: Exception -> L10
        if (r11 != null) goto L8;
        return null;
    L8:
        return new BDLatLng(r11.latitude, r11.longitude);
    L10:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "transPointToLatLng error:" + e.getMessage());
        return null;
    }

    public void setCustomMapStyle(BDMapStyleType r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Integer r11 = getAMapType(r10);
        if (r11 != null) goto L7;
        return;
    L7:
        Object r0 = this.mMapLoadStateLock;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (this.mIsMapLoad == true) goto L14;
        this.mPendingCustomMapType = r11;     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L17
        applyCustomMapType(r11);
    }

    public static /* synthetic */ boolean access$100(AMapServiceImpl r0, long r1) {
        return r0.isShotGenerationValid(r1);
    }

    public static /* synthetic */ boolean access$300(AMapServiceImpl r0, long r1) {
        return r0.isShotGenerationValidLocked(r1);
    }

    public static /* synthetic */ Bitmap access$402(AMapServiceImpl r0, Bitmap r1) {
        r0.mCachedScreenShot = r1;
        return r1;
    }

    private static void applyPolygonDottedStroke(PolygonOptions r10, int r11) {
        Method r0 = AMAP_SET_POLYGON_STROKE_DOTTED_LINE_TYPE_METHOD;
        if (r0 != null) goto L11;
        return;
    L11:
        r0.invoke(r10, new Object[]{Integer.valueOf(r11)});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "applyPolygonDottedStroke error:" + e.getMessage());
    }

    public float calculateLineDistance(BDLatLng r10, BDLatLng r11) {
        if (r10 == null) goto L7;
        if (r11 != null) goto L6;
        return 0.0f;
    L6:
        return AMapUtils.calculateLineDistance(new LatLng(r10.getLatitude(), r10.getLongitude()), new LatLng(r11.getLatitude(), r11.getLongitude()));
    L7:
        return 0.0f;
    }

    public void setCenter(BDLatLng r10, boolean r11) {
        setCenter(r10, r11, 250);
    }

    public void setCustomMapStyle(final boolean r10, final String r11) {
        if (this.mAMap != null) goto L14;
        return;
    L14:
    L11:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "setCustomMapStyle error:" + e.getMessage());
        return;
    L6:
        if (MapSettingsUtil.isUseNewStyleApi() == true) goto L9;
        this.mAMap.setCustomMapStyle(new CustomMapStyleOptions().setEnable(r10).setStyleId(r11));     // Catch: Exception -> L11
        return;
    L9:
        MapMonitor.customMapStyleTotal(r11);     // Catch: Exception -> L11
        this.mAMap.setCustomMapStyle(new CustomMapStyleOptions().setEnable(r10).setStyleId(r11), new AnonymousClass1(this, r11, r10));     // Catch: Exception -> L11
    }

    public void setLimitRegion(BDLatLng r10, BDLatLng r11) {
        if (this.mAMap == null) goto L9;
        if (r10 == null) goto L10;
        if (r11 == null) goto L11;
        LatLngBounds.Builder r0 = LatLngBounds.builder();
        r0.include(new LatLng(r10.getLatitude(), r10.getLongitude()));
        r0.include(new LatLng(r11.getLatitude(), r11.getLongitude()));
        this.mAMap.setMapStatusLimits(r0.build());
        return;
    L11:
        return;
    L10:
        return;
    }

    public boolean setMarkerIcon(IMarker r10, Bitmap r11) {
        if (this.mMapView != null) goto L11;
        return false;
    L11:
        ((AliMarker) r10).getMarker().setIcon(BitmapDescriptorFactory.fromBitmap(r11));     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "setMarkerIcon error:" + e.getMessage());
        return false;
    }

    public void setPointToCenter(int r10, int r11) {
        AMap r0 = this.mAMap;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setPointToCenter(r10, r11);
    }

    public void setZoom(float r10, boolean r11) {
        setZoom(r10, r11, 250);
    }

    public void startMarkerAnimation(IMarker r10, List<AnimationStyle> r11) {
        if (r10 == null) goto L31;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isEmpty() == true) goto L33;
        AnimationSet r0 = new AnimationSet(false);     // Catch: Exception -> L21
        Iterator<AnimationStyle> r12 = r11.iterator();     // Catch: Exception -> L21
    L9:
        if (r12.hasNext() == false) goto L19;
        AnimationStyle r1 = r12.next();     // Catch: Exception -> L21
        if (r1.getType() != 0) goto L14;
        ScaleAnimation r13 = new ScaleAnimation(r1.getFrom(), r1.getTo(), r1.getFrom(), r1.getTo());     // Catch: Exception -> L21
    L17:
        if (r13 == null) goto L9;
        r13.setFillMode(r1.getFillMode());     // Catch: Exception -> L21
        r13.setInterpolator(r1.getInterpolator());     // Catch: Exception -> L21
        r13.setRepeatCount(r1.getRepeatCount());     // Catch: Exception -> L21
        r13.setRepeatMode(r1.getRepeatMode());     // Catch: Exception -> L21
        r13.setDuration(r1.getDuration());     // Catch: Exception -> L21
        r0.addAnimation(r13);     // Catch: Exception -> L21
        goto L9
    L14:
        if (r1.getType() != 1) goto L16;
        r13 = new AlphaAnimation(r1.getFrom(), r1.getTo());     // Catch: Exception -> L21
        goto L17
    L16:
        r13 = null;
        goto L17
    L19:
        r10.startAnimation(r0);     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "startMarkerAnimation error:" + e.getMessage());
        return;
    L33:
        return;
    }

    public void setBound(List<BDLatLng> r10, int r11, boolean r12) {
        setBound(r10, r11, r12, 250);
    }

    public void setCenter(BDLatLng r10, boolean r11, int r12) {
        setCenter(r10, r11, r12, null);
    }

    public void setCenterAndZoom(BDLatLng r10, float r11, boolean r12) {
        setCenterAndZoom(r10, r11, r12, 250);
    }

    public void setRotationDegree(float r10, boolean r11, int r12) {
        changeCamera(CameraUpdateFactory.changeBearing(r10), r11, r12, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        MapMonitor.amapExceptionMonitor(th);
        MapLogger.e(TAG, "setRotationDegree error:" + th);
    }

    public void setZoom(float r10, boolean r11, int r12) {
        if (this.mAMap != null) goto L10;
        return;
    L10:
        changeCamera(CameraUpdateFactory.zoomTo(r10), r11, r12, null);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "setZoom error:" + e.getMessage());
    }

    private void changeCamera(CameraUpdate r10, boolean r11, int r12, final CancelableCallback r13) {
        if (this.mAMap != null) goto L8;
        if (r11 == false) goto L26;
        if (r13 == null) goto L27;
        r13.onCancel();
        return;
    L27:
        return;
    L26:
        return;
    L8:
        if (r12 > 0) goto L25;
        r12 = 250;
    L25:
        this.mLastMapActionReason = MapActionReasonListener.MapActionReason.REASON_API;     // Catch: Exception -> L19
        if (r11 == false) goto L17;
        AMap r0 = this.mAMap;     // Catch: Exception -> L19
        long r1 = r12;
        if (r13 != null) goto L15;
        AMap.CancelableCallback r14 = null;
    L16:
        r0.animateCamera(r10, r1, r14);     // Catch: Exception -> L19
        return;
    L15:
        r14 = new AnonymousClass2(this, r13);     // Catch: Exception -> L19
        goto L16
    L17:
        this.mAMap.moveCamera(r10);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "changeCamera error:" + e.getMessage());
        if (r11 == false) goto L29;
        if (r13 == null) goto L30;
        r13.onCancel();
        return;
    L30:
        return;
    }

    public void setBound(List<BDLatLng> r10, int r11, boolean r12, int r13) {
        if (this.mAMap == null) goto L15;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.isEmpty() == true) goto L17;
        LatLngBounds.Builder r0 = LatLngBounds.builder();
        Iterator<BDLatLng> r14 = r10.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        BDLatLng r1 = r14.next();
        r0.include(new LatLng(r1.getLatitude(), r1.getLongitude()));
        goto L10
    L12:
        changeCamera(CameraUpdateFactory.newLatLngBounds(r0.build(), r11), r12, r13, null);
        return;
    L17:
        return;
    }

    public void setCenter(BDLatLng r10, boolean r11, int r12, CancelableCallback r13) {
        if (this.mAMap == null) goto L14;
        if (r10 == null) goto L14;
        changeCamera(CameraUpdateFactory.newLatLng(new LatLng(r10.getLatitude(), r10.getLongitude())), r11, r12, r13);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "setCenter error:" + e.getMessage());
        if (r11 == false) goto L20;
        if (r13 == null) goto L21;
        r13.onCancel();
        return;
    L21:
        return;
    L20:
        return;
    L14:
        if (r11 == false) goto L23;
        if (r13 == null) goto L24;
        r13.onCancel();
        return;
    L24:
        return;
    }

    public void setCenterAndZoom(BDLatLng r10, float r11, boolean r12, int r13) {
        if (this.mAMap != null) goto L10;
        return;
    L10:
        changeCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(r10.getLatitude(), r10.getLongitude()), r11), r12, r13, null);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "setCenterAndZoom error:" + e.getMessage());
    }

    public void setBound(List<BDLatLng> r10, int r11, int r12, int r13, boolean r14) {
        setBound(r10, r11, r12, r13, r14, 250);
    }

    public void setBound(List<BDLatLng> r10, int r11, int r12, int r13, boolean r14, int r15) {
        if (this.mAMap == null) goto L15;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.isEmpty() == true) goto L17;
        LatLngBounds.Builder r0 = LatLngBounds.builder();
        Iterator<BDLatLng> r16 = r10.iterator();
    L10:
        if (r16.hasNext() == false) goto L12;
        BDLatLng r1 = r16.next();
        r0.include(new LatLng(r1.getLatitude(), r1.getLongitude()));
        goto L10
    L12:
        changeCamera(CameraUpdateFactory.newLatLngBounds(r0.build(), r11, r12, r13), r14, r15, null);
        return;
    L17:
        return;
    }

    public void setBound(List<BDLatLng> r10, int r11, int r12, int r13, int r14, boolean r15) {
        setBound(r10, r11, r12, r13, r14, r15, 250);
    }

    public void setBound(List<BDLatLng> r10, int r11, int r12, int r13, int r14, boolean r15, int r16) {
        if (this.mAMap == null) goto L20;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.isEmpty() == true) goto L22;
        LatLngBounds.Builder r0 = LatLngBounds.builder();     // Catch: Exception -> L14
        Iterator<BDLatLng> r17 = r10.iterator();     // Catch: Exception -> L14
    L10:
        if (r17.hasNext() == false) goto L12;
        BDLatLng r1 = r17.next();     // Catch: Exception -> L14
        r0.include(new LatLng(r1.getLatitude(), r1.getLongitude()));     // Catch: Exception -> L14
        goto L10
    L12:
        changeCamera(CameraUpdateFactory.newLatLngBoundsRect(r0.build(), r11, r12, r13, r14), r15, r16, null);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.e(TAG, "setBound error:" + e.getMessage());
        return;
    L22:
        return;
    }
}
