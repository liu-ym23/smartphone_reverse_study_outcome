package com.bytedance.lynx.map.ng;

import ai.j0;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.room.f;
import b0.e;
import com.bytedance.amap.model.AliCircle;
import com.bytedance.amap.model.AliMarker;
import com.bytedance.amap.model.AliPolygon;
import com.bytedance.amap.model.AliPolyline;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.map.api.BDMapClient;
import com.bytedance.map.api.IMapService;
import com.bytedance.map.api.MapInitConfig;
import com.bytedance.map.api.animation.AnimationStyle;
import com.bytedance.map.api.animation.EaseCubicInterpolator;
import com.bytedance.map.api.collision.Boundary;
import com.bytedance.map.api.collision.CollisionTextModel;
import com.bytedance.map.api.edit.EditHandler;
import com.bytedance.map.api.image.ImageOptions;
import com.bytedance.map.api.image.MapImageLoader;
import com.bytedance.map.api.lifecycle.MapLifecycleObserver;
import com.bytedance.map.api.listener.MapActionListener;
import com.bytedance.map.api.listener.MarkerActionListener;
import com.bytedance.map.api.listener.PolygonEditListener;
import com.bytedance.map.api.model.BDCircleOptions;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.BDMarkerOptions;
import com.bytedance.map.api.model.BDPolygonOptions;
import com.bytedance.map.api.model.BDPolylineOptions;
import com.bytedance.map.api.model.ICircle;
import com.bytedance.map.api.model.IMarker;
import com.bytedance.map.api.model.IPolygon;
import com.bytedance.map.api.model.IPolyline;
import com.bytedance.map.api.monitor.MapMonitorUtil;
import com.bytedance.map.api.sensor.SensorEventHelper;
import com.bytedance.map.api.thread.ThreadManager;
import com.bytedance.map.api.view.StrokeTextView;
import com.lynx.animax.i;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.u0;
import com.obric.launcher.widget.R$id;
import com.obric.launcher.widget.R$layout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mf.a;
import mf.d;
import mf.g;
import on.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxMapView extends UISimpleView<LinearLayout> implements MapActionListener, MarkerActionListener, PolygonEditListener, a {
    private static final String EVENT_MAP_LOAD = "mapload";
    private static final String EVENT_MARKER_SELECT = "didselectannotation";
    private static final String EVENT_MARKER_UNSELECT = "diddeselectannotation";
    private static final String EVENT_MODULE_LOAD = "moduleload";
    private static final String EVENT_MOVE_BY_USER = "didmovebyuser";
    private static final String EVENT_ON_EDIT = "onedit";
    private static final String EVENT_ON_EDIT_END = "oneditend";
    private static final String EVENT_ON_EDIT_START = "oneditstart";
    private static final String EVENT_REGION_CHANGE = "regiondidchange";
    private static final String EVENT_SINGLE_TAP_AT_MAP = "didsingletapatmap";
    private static final String EVENT_VIEW_DRAW = "viewdraw";
    private static final String EVENT_ZOOM_BY_USER = "didzoombyuser";
    private static final String EVENT_ZOOM_CHANGE = "zoomchange";
    private static final int STATUS_2D_MAP = 1;
    private static final int STATUS_3D_MAP = 2;
    private static final int STATUS_GOOGLE_MAP = 3;
    private static final int STATUS_GOOGLE_STATIC_MAP = 4;
    private static final int STATUS_NO_MAP = 0;
    private static final String TAG = "LynxMapView";
    private Map<String, ICircle> mCircleMap;
    private Map<String, CollisionTextModel> mCollisionMarkerMap;
    private float mCollisionPercent;
    private List<CollisionTextModel> mCollisionTextModels;
    private boolean mEnableCollision;
    private boolean mEnableMapLoadEvent;
    private boolean mEnableMarkerSelectEvent;
    private boolean mEnableMarkerUnselectEvent;
    private boolean mEnableMoveByUserEvent;
    private boolean mEnableOnEdit;
    private boolean mEnableOnEditEnd;
    private boolean mEnableOnEditStart;
    private boolean mEnableRegionChangeEvent;
    private boolean mEnableSingleTapAtMap;
    private boolean mEnableViewDrawEvent;
    private boolean mEnableZoomByUserEvent;
    private boolean mEnableZoomChangeEvent;
    private boolean mFirstRender;
    private boolean mIsBindSelectAnnotation;
    private boolean mIsBindViewDraw;
    private boolean mIsBindZoomChange;
    private boolean mIsCameraLoad;
    private boolean mIsChangeByZoom;
    private boolean mIsTouchByUser;
    private String mLastClickedMarkerId;
    private double mLastLatitude;
    private double mLastLongitude;
    private float mLastZoom;
    private Map<String, BDLatLng> mLatLngMap;
    private g mLifecycleNotification;
    private BDMapClient mMapClient;
    private Map<String, IMarker> mMarkerMap;
    private int mModuleStatus;
    private boolean mNeedUserLocationHeading;
    private Map<String, IPolygon> mPolygonMap;
    private Map<String, IPolyline> mPolylineMap;
    private SensorEventHelper mSensorHelper;
    private Map<String, IMarker> mTextMarkerMap;
    private IMarker mUserLocationMarker;

    public LynxMapView(LynxContext r5) {
        this(r5, null);
    }

    public static /* synthetic */ void access$000(LynxMapView r5, int r10, String r11, List r12, float r13, int r14, int r15, float r16, boolean r17, Bitmap r18, ReadableMap r19, ReadableMap r110) {
        r5.updatePolyline(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110);
    }

    public static /* synthetic */ void access$100(LynxMapView r5) {
        r5.doEnterBackgroundTask();
    }

    public static /* synthetic */ void access$200(LynxMapView r5) {
        r5.doOuterBackgroundTask();
    }

    public static /* synthetic */ void access$300(LynxMapView r5, String r10, BDLatLng r11, Bitmap r12, float r13, float r14, ReadableMap r15) {
        r5.addMarker(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ void access$400(LynxMapView r5, String r10, BDLatLng r11, Bitmap r12, float r13, float r14, ReadableMap r15) {
        r5.updateMarker(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ IMarker access$500(LynxMapView r5) {
        return r5.mUserLocationMarker;
    }

    public static /* synthetic */ IMarker access$502(LynxMapView r5, IMarker r10) {
        r5.mUserLocationMarker = r10;
        return r10;
    }

    public static /* synthetic */ BDMapClient access$600(LynxMapView r5) {
        return r5.mMapClient;
    }

    public static /* synthetic */ Map access$700(LynxMapView r5) {
        return r5.mMarkerMap;
    }

    public static /* synthetic */ SensorEventHelper access$800(LynxMapView r5) {
        return r5.mSensorHelper;
    }

    private void addChangeResult(JavaOnlyArray r5, String r10, BDLatLng r11) {
        Point r12 = convertLatLngToPoint(r11.f6917a, r11.f6918b);
        if (r12 != null) goto L5;
        return;
    L5:
        JavaOnlyMap r13 = new JavaOnlyMap();
        r13.putInt("x", r12.x);
        r13.putInt("y", r12.y);
        r13.putString("id", r10);
        r5.pushMap(r13);
    }

    private void addCircle(String r5, BDLatLng r10, double r11, int r12, int r13, int r14, float r15) {
        BDCircleOptions r16 = new BDCircleOptions();
        r16.f6914a = r10;
        r16.f6915b = r11;
        r16.f6916c = r12;
        r16.d = r13;
        r16.e = r14;
        IMapService r17 = this.mMapClient.f6862a;
        if (r17 != null) goto L5;
        ICircle r18 = null;
    L6:
        this.mCircleMap.put(r5, r18);
        return;
    L5:
        r18 = r17.addCircle(r16);
        goto L6
    }

    private void addMarker(String r27, BDLatLng r28, Bitmap r29, float r30, float r31, ReadableMap r32) {
        ReadableMap r10 = r32.getMap("mtext");
        String r5 = r32.getString("content");
        ReadableMap r11 = r32.getMap("contentStyle");
        float r12 = (float) r32.getDouble("zIndex", 0.0d);
        boolean r22 = r32.getBoolean("clickable", true);
        IMarker r23 = null;
        if (r10 == null) goto L6;
        int r13 = r10.getInt("alignment", 0);
        float r24 = (float) r10.getDouble("content_padding", 0.0d);
        View r14 = getMarkerMtextView(r13, r10, r29);
        int r15 = r13;
    L12:
        float r16 = 0.5f;
        if (r15 != 0) goto L15;
        float r17 = 1.0f;
    L16:
        ReadableMap r18 = r32.getMap("offset");
        if (r18 == null) goto L26;
        float r19 = (float) r18.getDouble("offsetX", 0.0d);
        float r20 = (float) r18.getDouble("offsetY", 0.0d);
        if (r29 != null) goto L21;
    L25:
        float r21 = r20;
        float r110 = r17;
        float r25 = r19;
    L27:
        BDMapClient r111 = this.mMapClient;
        BDMarkerOptions r112 = new BDMarkerOptions(r28, r29, null, r30, r31, r16, r110, r12, r22, r27);
        IMapService r26 = r111.f6862a;
        if (r26 != null) goto L30;
    L29:
        IMarker r113 = r23;
        this.mMarkerMap.put(r27, r113);
        ReadableMap r114 = r32.getMap("animate");
        if (r114 == null) goto L34;
        startMarkerAnimationInternal(r113, r114);
    L34:
        LynxLog.b(2, TAG, "addMarker: " + r113 + "latLng : " + r28);
        if (r14 == null) goto L44;
        int r115 = r15;
        IMarker r33 = addTextMarker(r27, r28, r14, r12, r25, r21, r15, r24, r22);
        this.mTextMarkerMap.put(r27, r33);
        if (r115 != 1) goto L41;
        if (r10 == null) goto L41;
        if (r113 == null) goto L41;
        ((AliMarker) r113).a(false);
    L41:
        if (r114 == null) goto L45;
        startMarkerAnimationInternal(r33, r114);
        return;
    L45:
        return;
    L44:
        return;
    L30:
        r23 = r26.addMarker(r112);
        goto L29
    L21:
        if (r29.getWidth() <= 0) goto L25;
        if (r29.getHeight() <= 0) goto L25;
        r16 = 0.5f - (dp2px(r19) / r29.getWidth());
        r17 = r17 - (dp2px(r20) / r29.getHeight());
        goto L25
    L26:
        r110 = r17;
        r25 = 0.0f;
        r21 = 0.0f;
        goto L27
    L15:
        r17 = 0.5f;
        goto L16
    L6:
        if (TextUtils.isEmpty(r5) == true) goto L11;
        if (r11 == null) goto L9;
        int r116 = r11.getInt("alignment", 0);
        float r34 = (float) r11.getDouble("content_padding", 0.0d);
    L10:
        r14 = getMarkerTextView(r5, r11);
        r24 = r34;
        r15 = r116;
        goto L12
    L9:
        r116 = 0;
        r34 = 0.0f;
        goto L10
    L11:
        r15 = 1;
        r14 = null;
        r24 = 0.0f;
        goto L12
    }

    private void addPolygon(String r5, List<BDLatLng> r10, int r11, int r12, int r13, float r14) {
        BDPolygonOptions r15 = new BDPolygonOptions();
        r15.f6926a = r5;
        r15.f6927b = r10;
        r15.f6928c = r11;
        r15.d = r12;
        r15.e = r13;
        IMapService r16 = this.mMapClient.f6862a;
        if (r16 != null) goto L5;
        IPolygon r17 = null;
    L6:
        this.mPolygonMap.put(r5, r17);
        return;
    L5:
        r17 = r16.addPolygon(r15);
        goto L6
    }

    private void addSensorListener() {
        SensorEventHelper r5 = this.mSensorHelper;
        if (r5 == null) goto L6;
        r5.a();
        return;
    }

    private IMarker addTextMarker(String r18, BDLatLng r19, View r20, float r21, float r22, float r23, int r24, float r25, boolean r26) {
        int r5 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r20.measure(r5, r5);
        int r10 = r20.getMeasuredWidth();
        int r11 = r20.getMeasuredHeight();
        if (r24 != 1) goto L5;
        float r12 = 0.5f;
    L6:
        float r13 = 0.5f - (dp2px(r22) / r10);
        float r15 = r23 + r25;
        float r14 = r12 - (dp2px(r15) / r11);
        BDMapClient r16 = this.mMapClient;
        BDMarkerOptions r17 = new BDMarkerOptions(r19, null, r20, 0.0f, 1.0f, r13, r14, r21, r26, r18);
        IMapService r27 = r16.f6862a;
        if (r27 != null) goto L9;
        IMarker r28 = null;
    L11:
        if (this.mEnableCollision == false) goto L13;
        CollisionTextModel r29 = new CollisionTextModel(r28);
        r29.e = r19;
        r29.f6881b = r20.getMeasuredWidth();
        r29.f6882c = r20.getMeasuredHeight();
        r29.g = r24;
        r29.d = dp2px(r15);
        r29.f = (int) r21;
        r29.f6883h = r18;
        this.mCollisionMarkerMap.put(r18, r29);
    L13:
        return r28;
    L9:
        r28 = r27.addMarker(r17);
        goto L11
    L5:
        r12 = 0.0f;
        goto L6
    }

    private int argb2rgba(int r5) {
        return (r5 << 8) | (r5 >>> 24);
    }

    public static /* synthetic */ int b(CollisionTextModel r5, CollisionTextModel r10) {
        return lambda$buildTextModels$3(r5, r10);
    }

    private synchronized void buildTextModels() {
        monitor-enter(this);
        ArrayList r5 = new ArrayList(this.mCollisionMarkerMap.values());     // Catch: Throwable -> L6
        this.mCollisionTextModels = r5;     // Catch: Throwable -> L6
        Collections.sort(r5, new androidx.room.vo.a(4));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void c(LynxMapView r5, ReadableMap r10, Callback r11) {
        r5.lambda$updateAnnotations$2(r10, r11);
    }

    private void cameraChangeViewDraw() {
        JavaOnlyArray r5 = new JavaOnlyArray();
        Iterator<Map.Entry<String, BDLatLng>> r10 = this.mLatLngMap.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        Map.Entry<String, BDLatLng> r11 = r10.next();
        addChangeResult(r5, r11.getKey(), r11.getValue());
        goto L4
    L7:
        if (this.mIsBindViewDraw == true) goto L9;
        return;
    L9:
        if (r5.size() <= 0) goto L14;
        onViewDraw(r5);
        return;
    }

    private void clearAllMarkersAndMaps() {
        clearMarkerMap(this.mMarkerMap);
        clearMarkerMap(this.mTextMarkerMap);
        Map<String, CollisionTextModel> r5 = this.mCollisionMarkerMap;
        if (r5 != null) goto L5;
    L7:
        List<CollisionTextModel> r10 = this.mCollisionTextModels;
        if (r10 != null) goto L10;
    L12:
        Map<String, BDLatLng> r11 = this.mLatLngMap;
        if (r11 != null) goto L15;
        return;
    L15:
        if (r11.isEmpty() == true) goto L19;
        this.mLatLngMap.clear();
        return;
    L19:
        return;
    L10:
        if (r10.isEmpty() == true) goto L12;
        this.mCollisionTextModels.clear();
        goto L12
    L5:
        if (r5.isEmpty() == true) goto L7;
        this.mCollisionMarkerMap.clear();
        goto L7
    }

    private void clearAllPolylines() {
        Map<String, IPolyline> r5 = this.mPolylineMap;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.size() <= 0) goto L20;
        Iterator<IPolyline> r10 = this.mPolylineMap.values().iterator();
    L8:
        if (r10.hasNext() == false) goto L12;
        IPolyline r11 = r10.next();
        if (r11 == null) goto L8;
        ((AliPolyline) r11).a();
        goto L8
    L12:
        this.mPolylineMap.clear();
        return;
    }

    private void clearMarkerById(Map<String, IMarker> r5, String r10) {
        IMarker r11 = r5.get(r10);
        if (r11 == null) goto L5;
        ((AliMarker) r11).a();
    L5:
        r5.remove(r10);
    }

    private void clearMarkerMap(Map<String, IMarker> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == true) goto L19;
        Iterator<Map.Entry<String, IMarker>> r10 = r5.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        IMarker r11 = r10.next().getValue();
        if (r11 == null) goto L7;
        ((AliMarker) r11).a();
        goto L7
    L11:
        r5.clear();
        return;
    }

    private Point convertLatLngToPoint(double r5, double r10) {
        BDMapClient r11 = this.mMapClient;
        if (r11 != null) goto L5;
        return null;
    L5:
        BDLatLng r12 = new BDLatLng(r5, r10);
        IMapService r13 = r11.f6862a;
        if (r13 != null) goto L9;
        return null;
    L9:
        return r13.transLatLngToPoint(r12);
    }

    private BDLatLng convertPointToLatLng(Point r5) {
        BDMapClient r10 = this.mMapClient;
        if (r10 != null) goto L5;
        return null;
    L5:
        IMapService r11 = r10.f6862a;
        if (r11 != null) goto L9;
        return null;
    L9:
        return r11.transPointToLatLng(r5);
    }

    private void deleteCircle(String r5) {
        ICircle r10 = this.mCircleMap.get(r5);
        if (r10 == null) goto L5;
        ((AliCircle) r10).a();
    L5:
        this.mCircleMap.remove(r5);
    }

    private void deleteLine(String r5) {
        IPolyline r10 = this.mPolylineMap.get(r5);
        if (r10 == null) goto L5;
        ((AliPolyline) r10).a();
    L5:
        this.mPolylineMap.remove(r5);
    }

    private void deleteMarker(String r5) {
        clearMarkerById(this.mMarkerMap, r5);
        clearMarkerById(this.mTextMarkerMap, r5);
        this.mCollisionMarkerMap.remove(r5);
        this.mLatLngMap.remove(r5);
    }

    private void deletePolygon(String r5) {
        IPolygon r10 = this.mPolygonMap.get(r5);
        if (r10 == null) goto L5;
        ((AliPolygon) r10).b();
    L5:
        EditHandler r11 = this.mMapClient.f6863b;
        if (r11 == null) goto L9;
        r11.a(r10);
    L9:
        this.mPolygonMap.remove(r5);
    }

    private void destroySensorHelper() {
        SensorEventHelper r5 = this.mSensorHelper;
        if (r5 == null) goto L6;
        r5.b();
        this.mSensorHelper.f = null;
        this.mSensorHelper = null;
        return;
    }

    private synchronized void detectCollision() {
        monitor-enter(this);
        SystemClock.elapsedRealtime();     // Catch: Throwable -> L10
        Point r5 = new Point();     // Catch: Throwable -> L10
        Boundary r10 = new Boundary();     // Catch: Throwable -> L10
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L10
        Iterator<CollisionTextModel> r12 = this.mCollisionTextModels.iterator();     // Catch: Throwable -> L10
    L5:
        if (r12.hasNext() == false) goto L43;
        CollisionTextModel r13 = r12.next();     // Catch: Throwable -> L10
        BDLatLng r14 = r13.e;     // Catch: Throwable -> L10
        if (r14 == null) goto L12;
        Point r15 = convertLatLngToPoint(r14.f6917a, r14.f6918b);     // Catch: Throwable -> L10
    L14:
        if (r15 == null) goto L20;
        int r16 = r13.g;     // Catch: Throwable -> L10
        if (r16 != 0) goto L18;
        r5.set(r15.x, ((r13.f6882c / 2) + r15.y) + r13.d);     // Catch: Throwable -> L10
        goto L20
    L18:
        if (r16 != 1) goto L20;
        r5.set(r15.x, r15.y);     // Catch: Throwable -> L10
    L20:
        int r17 = r13.f6881b;     // Catch: Throwable -> L10
        int r18 = r13.f6882c;     // Catch: Throwable -> L10
        String r19 = r13.f6883h;     // Catch: Throwable -> L10
        int r110 = r5.x;     // Catch: Throwable -> L10
        int r20 = r17 / 2;     // Catch: Throwable -> L10
        r10.f6877a = r110 - r20;     // Catch: Throwable -> L10
        int r111 = r5.y;     // Catch: Throwable -> L10
        int r21 = r18 / 2;     // Catch: Throwable -> L10
        r10.f6878b = r111 - r21;     // Catch: Throwable -> L10
        r10.f6879c = r110 + r20;     // Catch: Throwable -> L10
        r10.d = r111 + r21;     // Catch: Throwable -> L10
        r10.e = r19;     // Catch: Throwable -> L10
        Iterator r22 = r11.iterator();     // Catch: Throwable -> L10
    L22:
        if (r22.hasNext() == false) goto L38;
        Boundary r23 = (Boundary) r22.next();     // Catch: Throwable -> L10
        float r24 = this.mCollisionPercent;     // Catch: Throwable -> L10
        int r112 = r23.f6879c;     // Catch: Throwable -> L10
        int r113 = r10.f6877a;     // Catch: Throwable -> L10
        if (r112 < r113) goto L22;
        int r114 = r23.f6877a;     // Catch: Throwable -> L10
        int r115 = r10.f6879c;     // Catch: Throwable -> L10
        if (r114 > r115) goto L22;
        int r116 = r23.f6878b;     // Catch: Throwable -> L10
        int r117 = r10.d;     // Catch: Throwable -> L10
        if (r116 > r117) goto L22;
        int r118 = r23.d;     // Catch: Throwable -> L10
        int r119 = r10.f6878b;     // Catch: Throwable -> L10
        if (r118 < r119) goto L22;
        int r120 = r115 - r113;     // Catch: Throwable -> L10
        int r121 = r117 - r119;     // Catch: Throwable -> L10
        Rect r122 = new Rect(r23.f6877a, r23.f6878b, r23.f6879c, r23.d);     // Catch: Throwable -> L10
        r122.intersect(new Rect(r10.f6877a, r10.f6878b, r10.f6879c, r10.d));     // Catch: Throwable -> L10
        if ((r122.width() * r122.height()) < ((r121 * r120) * r24)) goto L22;
        IMarker r25 = r13.f6880a;     // Catch: Throwable -> L10
        if (r25 == null) goto L5;
        ((AliMarker) r25).b(false);     // Catch: Throwable -> L10
        goto L5
    L38:
        IMarker r26 = r13.f6880a;     // Catch: Throwable -> L10
        if (r26 == null) goto L41;
        ((AliMarker) r26).b(true);     // Catch: Throwable -> L10
    L41:
        Boundary r27 = new Boundary();     // Catch: Throwable -> L10
        r27.d = r10.d;     // Catch: Throwable -> L10
        r27.f6879c = r10.f6879c;     // Catch: Throwable -> L10
        r27.f6878b = r10.f6878b;     // Catch: Throwable -> L10
        r27.f6877a = r10.f6877a;     // Catch: Throwable -> L10
        r27.e = r10.e;     // Catch: Throwable -> L10
        r11.add(r27);     // Catch: Throwable -> L10
        goto L5
    L12:
        r15 = null;
        goto L14
    L43:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void doEnterBackgroundTask() {
        removeSensorListener();
    }

    private void doOuterBackgroundTask() {
        if (this.mNeedUserLocationHeading == false) goto L6;
        addSensorListener();
        return;
    }

    private int dp2px(float r5) {
        return (int) ((r5 * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private AnimationStyle getAnimationStyle(int r10, ReadableMap r11) {
        float r5 = (float) r11.getDouble("from");
        float r12 = (float) r11.getDouble("to");
        long r13 = r11.getLong("duration", 250);
        int r14 = r11.getInt("interpolator");
        boolean r15 = r11.getBoolean("enableOvershoot", false);
        Interpolator r16 = getInterpolator(r14, r11.getMap("bezierParams"), r15);
        int r17 = r11.getInt("fillMode", 0);
        int r18 = r11.getInt("repeatCount", 0);
        int r19 = r11.getInt("repeatMode", 1);
        AnimationStyle r20 = new AnimationStyle();
        r20.f6870a = r10;
        r20.f6871b = r5;
        r20.f6872c = r12;
        r20.d = r13;
        r20.e = r16;
        r20.f = r17;
        r20.g = r18;
        r20.f6873h = r19;
        return r20;
    }

    private BDLatLng getCenterWithPadding(float r10, float r11, float r12, float r13) {
        BDMapClient r5 = this.mMapClient;
        if (r5 != null) goto L6;
        return null;
    L6:
        BDLatLng r14 = r5.a();
        Point r15 = new Point();
        if (r14 == null) goto L9;
        r15 = convertLatLngToPoint(r14.f6917a, r14.f6918b);
    L9:
        if (r15 == null) goto L12;
        int r16 = r15.x;
        r15.x = j0.c(dp2px(r11), dp2px(r13), 2, r16);
        int r17 = r15.y;
        r15.y = j0.c(dp2px(r10), dp2px(r12), 2, r17);
    L12:
        return convertPointToLatLng(r15);
    }

    @Nullable
    private ImageOptions getImageOptions(String r5, ReadableMap r10) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        ImageOptions r11 = new ImageOptions();
        r11.f6902a = r5;
        if (r10 == null) goto L9;
        r11.f6903b = dp2px((float) r10.getDouble("width"));
        r11.f6904c = dp2px((float) r10.getDouble("height"));
    L9:
        return r11;
    }

    @Nullable
    private List<ImageOptions> getImageOptionsList(ReadableArray r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        ArrayList r5 = new ArrayList();
        int r11 = 0;
    L7:
        if (r11 >= r10.size()) goto L9;
        ImageOptions r12 = new ImageOptions();
        ReadableMap r13 = r10.getMap(r11);
        r12.f6902a = r13.getString("url");
        r12.f6903b = dp2px((float) r13.getDouble("width"));
        r12.f6904c = dp2px((float) r13.getDouble("height"));
        r12.d = r13.getInt("index");
        r5.add(r12);
        r11 = r11 + 1;
        goto L7
    L9:
        return r5;
    }

    private Interpolator getInterpolator(int r10, ReadableMap r11, boolean r12) {
        LinearInterpolator r13 = new LinearInterpolator();
        if (r10 != 1) goto L7;
        if (r11 != null) goto L6;
        return r13;
    L6:
        return new EaseCubicInterpolator((float) r11.getDouble("x1"), (float) r11.getDouble("y1"), (float) r11.getDouble("x2"), (float) r11.getDouble("y2"), r12);
    L7:
        return r13;
    }

    private List<BDLatLng> getLatLngList(ReadableArray r10) {
        if (r10 == null) goto L17;
        if (r10.size() == 0) goto L17;
        ArrayList r11 = new ArrayList();
        int r5 = 0;
    L8:
        if (r5 >= r10.size()) goto L15;
        ReadableArray r12 = r10.getArray(r5);
        if (r12 == null) goto L14;
        if (r12.size() < 2) goto L14;
        r11.add(new BDLatLng(r12.getDouble(1), r12.getDouble(0)));
    L14:
        r5 = r5 + 1;
        goto L8
    L15:
        return r11;
    L17:
        return new ArrayList();
    }

    private BDLatLng getLatLngWithPadding(double r5, double r10, float r11, float r12) {
        Point r13 = convertLatLngToPoint(r5, r10);
        if (r13 == null) goto L6;
        r13.x += dp2px(r11);
        r13.y += dp2px(r12);
        return convertPointToLatLng(r13);
    L6:
        return null;
    }

    private View getMarkerMtextView(int r10, ReadableMap r11, Bitmap r12) {
        LinearLayout r5 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R$layout.map_marker_mtext_layout, null);
        LinearLayout r13 = (LinearLayout) r5.findViewById(R$id.marker_mtext_layout);
        r13.setOrientation(1);
        ReadableArray r14 = r11.getArray("textItems");
        if (r14 != null) goto L5;
    L10:
        if (r10 != 1) goto L15;
        if (r12 == null) goto L15;
        int r15 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r13.measure(r15, r15);
        int r16 = r13.getMeasuredWidth();
        int r17 = r13.getMeasuredHeight();
        int r18 = r12.getWidth();
        int r19 = r12.getHeight();
        LinearLayout.LayoutParams r20 = (LinearLayout.LayoutParams) r13.getLayoutParams();
        if (r20 == null) goto L15;
        r20.width = Math.max(r16, r18);
        r20.height = Math.max(r17, r19);
        r13.setLayoutParams(r20);
    L15:
        return r5;
    L5:
        if (r14.size() <= 0) goto L10;
        int r21 = 0;
    L8:
        if (r21 >= r14.size()) goto L10;
        ReadableMap r22 = r14.getMap(r21);
        String r23 = r22.getString("content");
        ReadableMap r24 = r22.getMap("style");
        StrokeTextView r25 = new StrokeTextView(this.mContext);
        r25.setLines(1);
        r25.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        renderTextView(r25, r23, r24);
        LinearLayout.LayoutParams r26 = new LinearLayout.LayoutParams(-2, -2);
        r26.gravity = 17;
        r13.addView(r25, r26);
        r21 = r21 + 1;
        goto L8
    }

    private View getMarkerTextView(String r5, ReadableMap r10) {
        View r11 = LayoutInflater.from(this.mContext).inflate(R$layout.map_marker_text_layout, null);
        renderTextView((StrokeTextView) r11.findViewById(R$id.marker_text), r5, r10);
        return r11;
    }

    private JavaOnlyArray getPointsData(List<BDLatLng> r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.size() == 0) goto L14;
        JavaOnlyArray r10 = new JavaOnlyArray();
        Iterator<BDLatLng> r11 = r5.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        BDLatLng r12 = r11.next();
        JavaOnlyArray r13 = new JavaOnlyArray();
        r13.pushDouble(r12.f6918b);
        r13.pushDouble(r12.f6917a);
        r10.pushArray(r13);
        goto L8
    L10:
        return r10;
    L14:
        return null;
    }

    private BDLatLng getTargetCenter(BDLatLng r10, float r11, float r12, float r13, float r14, float r15) {
        BDMapClient r5 = this.mMapClient;
        if (r5 == null) goto L5;
        BDLatLng r16 = r5.a();
        IMapService r17 = this.mMapClient.f6862a;
        if (r17 != null) goto L9;
        float r18 = 0.0f;
    L10:
        BDLatLng r19 = getCenterWithPadding(r12, r13, r14, r15);
        if (r16 == null) goto L17;
        if (r19 == null) goto L17;
        BDLatLng r20 = new BDLatLng(0.0d, 0.0d);
        double r21 = r11 / r18;
        r20.f6917a = ((r16.f6917a - r19.f6917a) / r21) + r10.f6917a;
        r20.f6918b = ((r16.f6918b - r19.f6918b) / r21) + r10.f6918b;
        return r20;
    L17:
        return new BDLatLng(0.0d, 0.0d);
    L9:
        r18 = r17.getZoom();
        goto L10
    L5:
        return new BDLatLng(0.0d, 0.0d);
    }

    public static /* synthetic */ void i(LynxMapView r5, ReadableArray r10) {
        r5.lambda$showAnnotation$0(r10);
    }

    public static /* synthetic */ void j(LynxMapView r5, ReadableMap r10, ReadableArray r11) {
        r5.lambda$setUserLocationAnnotation$1(r10, r11);
    }

    private static int lambda$buildTextModels$3(CollisionTextModel r5, CollisionTextModel r10) {
        return r10.f - r5.f;
    }

    private /* synthetic */ void lambda$setUserLocationAnnotation$1(ReadableMap r10, ReadableArray r11) {
        String r5 = r10.getString("id");
        e r12 = new e(this, new BDLatLng(r11.getArray(0).getDouble(1), r11.getArray(0).getDouble(0)), (float) r10.getDouble("zIndex", 0.0d), r5);
        ReadableMap r13 = r10.getMap("imageGroup");
        if (r13 == null) goto L6;
        MapImageLoader.a(getImageOptionsList(r13.getArray("loadParams")), r12);
        return;
    L6:
        MapImageLoader.a(getImageOptions(r10.getString("imageUrl"), r10.getMap("imageSize")), r12);
    }

    private /* synthetic */ void lambda$showAnnotation$0(ReadableArray r18) {
        monitor-enter(LynxMapView.class);
        clearAllMarkersAndMaps();     // Catch: Throwable -> L10
        JavaOnlyArray r5 = new JavaOnlyArray();     // Catch: Throwable -> L10
        CountDownLatch r11 = new CountDownLatch(r18.size());     // Catch: Throwable -> L10
        int r12 = 0;
        int r13 = 0;
    L6:
        if (r13 >= r18.size()) goto L32;
        ReadableMap r15 = r18.getMap(r13);     // Catch: Throwable -> L10
        if (r15 == null) goto L12;
        ReadableArray r10 = r15.getArray("points");     // Catch: Throwable -> L10
    L13:
        if (r15 == null) goto L21;
        if (r10 == null) goto L21;
        if (r10.size() == 0) goto L21;
        if (r10.getArray(r12) == null) goto L21;
        if (r10.getArray(r12).size() < 2) goto L21;
        BDLatLng r14 = new BDLatLng(r10.getArray(r12).getDouble(1), r10.getArray(r12).getDouble(r12));     // Catch: Throwable -> L10
        float r16 = (float) (360.0d - r15.getDouble("rotateAngle", 0.0d));     // Catch: Throwable -> L10
        float r17 = (float) r15.getDouble("alpha", 1.0d);     // Catch: Throwable -> L10
        String r19 = r15.getString("id");     // Catch: Throwable -> L10
        int r110 = r13;
        d r20 = new d(this, r19, r14, r16, r17, r15, r11);     // Catch: Throwable -> L10
        ReadableMap r21 = r15.getMap("imageGroup");     // Catch: Throwable -> L10
        if (r21 == null) goto L25;
        MapImageLoader.a(getImageOptionsList(r21.getArray("loadParams")), r20);     // Catch: Throwable -> L10
    L26:
        int r22 = 0;
        if (r15.getBoolean("customWigetView", false) == false) goto L30;
        addChangeResult(r5, r19, r14);     // Catch: Throwable -> L10
        this.mLatLngMap.put(r19, r14);     // Catch: Throwable -> L10
    L30:
        r13 = r110 + 1;     // Catch: Throwable -> L10
        r12 = r22;
        goto L6
    L25:
        MapImageLoader.a(getImageOptions(r15.getString("imageUrl"), r15.getMap("imageSize")), r20);     // Catch: Throwable -> L10
    L21:
        r22 = r12;
        r110 = r13;
        r11.countDown();     // Catch: Throwable -> L10
        goto L30
    L12:
        r10 = null;
        goto L13
    L32:
        if (this.mIsCameraLoad == true) goto L34;
    L47:
        r11.await(WsConstants.EXIT_DELAY_TIME, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10 InterruptedException -> L38
    L41:
        if (this.mEnableCollision == false) goto L43;
        buildTextModels();     // Catch: Throwable -> L10
        detectCollision();     // Catch: Throwable -> L10
    L43:
        monitor-exit(LynxMapView.class);     // Catch: Throwable -> L10
        return;
    L38:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        goto L41
    L34:
        if (r5.size() <= 0) goto L47;
        onViewDraw(r5);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$updateAnnotations$2(ReadableMap r20, Callback r21) {
        monitor-enter(LynxMapView.class);
        int r12 = r20.getInt("type");     // Catch: Throwable -> L16
        ReadableArray r5 = r20.getArray("annotations");     // Catch: Throwable -> L16
        if (r5 != null) goto L7;
    L55:
        if (r21 == null) goto L57;
        r21.invoke(new Object[]{4, "Invalid parameter 'annotations': expected array"});     // Catch: Throwable -> L16
    L57:
        monitor-exit(LynxMapView.class);     // Catch: Throwable -> L16
        return;
    L7:
        if (r5.size() == 0) goto L55;
        JavaOnlyArray r13 = new JavaOnlyArray();     // Catch: Throwable -> L16
        CountDownLatch r14 = new CountDownLatch(r5.size());     // Catch: Throwable -> L16
        int r15 = 0;
        int r10 = 0;
    L11:
        if (r10 >= r5.size()) goto L40;
        ReadableMap r11 = r5.getMap(r10);     // Catch: Throwable -> L16
        if (r11 != null) goto L18;
        r14.countDown();     // Catch: Throwable -> L16
    L15:
        ReadableArray r18 = r5;
        int r16 = r10;
        int r17 = r12;
        int r19 = r15;
    L38:
        r10 = r16 + 1;     // Catch: Throwable -> L16
        r15 = r19;
        r12 = r17;
        r5 = r18;
        goto L11
    L18:
        String r22 = r11.getString("id");     // Catch: Throwable -> L16
        if (r12 != 1) goto L21;
        deleteMarker(r22);     // Catch: Throwable -> L16
        r14.countDown();     // Catch: Throwable -> L16
        goto L15
    L21:
        ReadableArray r23 = r11.getArray("points");     // Catch: Throwable -> L16
        if (r23 != null) goto L24;
    L29:
        r18 = r5;
        r16 = r10;
        r17 = r12;
        r19 = r15;
        r14.countDown();     // Catch: Throwable -> L16
        goto L38
    L24:
        if (r23.size() == 0) goto L29;
        if (r23.getArray(r15) == null) goto L29;
        if (r23.getArray(r15).size() < 2) goto L29;
        BDLatLng r24 = new BDLatLng(r23.getArray(r15).getDouble(1), r23.getArray(r15).getDouble(r15));     // Catch: Throwable -> L16
        r18 = r5;
        r17 = r12;
        r16 = r10;
        mf.e r25 = new mf.e(this, r12, r22, r24, (float) (360.0d - r11.getDouble("rotateAngle", 0.0d)), (float) r11.getDouble("alpha", 1.0d), r11, r14);     // Catch: Throwable -> L16
        ReadableMap r26 = r11.getMap("imageGroup");     // Catch: Throwable -> L16
        if (r26 == null) goto L33;
        MapImageLoader.a(getImageOptionsList(r26.getArray("loadParams")), r25);     // Catch: Throwable -> L16
    L34:
        r19 = 0;
        if (r11.getBoolean("customWigetView", false) == false) goto L38;
        addChangeResult(r13, r22, r24);     // Catch: Throwable -> L16
        this.mLatLngMap.put(r22, r24);     // Catch: Throwable -> L16
        goto L38
    L33:
        MapImageLoader.a(getImageOptions(r11.getString("imageUrl"), r11.getMap("imageSize")), r25);     // Catch: Throwable -> L16
        goto L34
    L40:
        if (this.mIsCameraLoad == true) goto L42;
    L61:
        r14.await(WsConstants.EXIT_DELAY_TIME, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L16 InterruptedException -> L48
    L51:
        if (this.mEnableCollision == false) goto L53;
        buildTextModels();     // Catch: Throwable -> L16
        detectCollision();     // Catch: Throwable -> L16
    L53:
        monitor-exit(LynxMapView.class);     // Catch: Throwable -> L16
        return;
    L48:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        goto L51
    L42:
        if (this.mIsBindViewDraw == false) goto L61;
        if (r13.isEmpty() == true) goto L61;
        onViewDraw(r13);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    private void onLynxEdit(String r5, JavaOnlyArray r10) {
        if (this.mEnableOnEdit == true) goto L5;
        return;
    L5:
        if (getLynxContext() == null) goto L9;
        i r11 = new i(getSign(), EVENT_ON_EDIT);
        r11.a("id", r5);
        r11.a("points", r10);
        getLynxContext().g.b(r11);
        return;
    }

    private void onLynxEditEnd(String r5, JavaOnlyArray r10) {
        if (this.mEnableOnEditEnd == true) goto L5;
        return;
    L5:
        if (getLynxContext() == null) goto L9;
        i r11 = new i(getSign(), EVENT_ON_EDIT_END);
        r11.a("id", r5);
        r11.a("points", r10);
        getLynxContext().g.b(r11);
        return;
    }

    private void onLynxEditStart(String r5, JavaOnlyArray r10) {
        if (this.mEnableOnEditStart == true) goto L5;
        return;
    L5:
        if (getLynxContext() == null) goto L9;
        i r11 = new i(getSign(), EVENT_ON_EDIT_START);
        r11.a("id", r5);
        r11.a("points", r10);
        getLynxContext().g.b(r11);
        return;
    }

    private void onLynxMapClickByUser(BDLatLng r10) {
        if (this.mEnableSingleTapAtMap == true) goto L5;
        return;
    L5:
        if (getLynxContext() == null) goto L11;
        b r5 = new i(getSign(), EVENT_SINGLE_TAP_AT_MAP);
        Point r11 = convertLatLngToPoint(r10.f6917a, r10.f6918b);
        if (r11 == null) goto L12;
        JavaOnlyArray r12 = new JavaOnlyArray();
        r12.pushDouble(r10.f6918b);
        r12.pushDouble(r10.f6917a);
        JavaOnlyArray r13 = new JavaOnlyArray();
        r13.pushInt(r11.x);
        r13.pushInt(r11.y);
        r5.a("coordinate", r12);
        r5.a("point", r13);
        getLynxContext().g.b(r5);
        return;
    L12:
        return;
    }

    private void onLynxMapLoad() {
        if (this.mEnableMapLoadEvent == true) goto L5;
        return;
    L5:
        if (getLynxContext() == null) goto L9;
        getLynxContext().g.b(new i(getSign(), EVENT_MAP_LOAD));
        return;
    }

    private void onMarkerSelect(String r5) {
        if (this.mEnableMarkerSelectEvent == true) goto L5;
        return;
    L5:
        if (getLynxContext() == null) goto L9;
        i r10 = new i(getSign(), EVENT_MARKER_SELECT);
        r10.a("id", r5);
        getLynxContext().g.b(r10);
        return;
    }

    private void onMarkerUnselect(String r5) {
        if (this.mEnableMarkerUnselectEvent == true) goto L5;
        return;
    L5:
        if (getLynxContext() == null) goto L9;
        i r10 = new i(getSign(), EVENT_MARKER_UNSELECT);
        r10.a("id", r5);
        getLynxContext().g.b(r10);
        return;
    }

    private void onMoveByUser() {
        if (this.mEnableMoveByUserEvent == true) goto L5;
        return;
    L5:
        if (getLynxContext() == null) goto L9;
        getLynxContext().g.b(new i(getSign(), EVENT_MOVE_BY_USER));
        return;
    }

    private void onRegionChange() {
        if (this.mEnableRegionChangeEvent == true) goto L5;
        return;
    L5:
        if (getLynxContext() == null) goto L9;
        getLynxContext().g.b(new i(getSign(), EVENT_REGION_CHANGE));
        return;
    }

    private void onViewDraw(JavaOnlyArray r5) {
        if (this.mEnableViewDrawEvent == true) goto L5;
        return;
    L5:
        if (getLynxContext() == null) goto L9;
        i r10 = new i(getSign(), EVENT_VIEW_DRAW);
        r10.a("changes", r5);
        getLynxContext().g.b(r10);
        return;
    }

    private void onZoomByUser() {
        if (this.mEnableZoomByUserEvent == true) goto L5;
        return;
    L5:
        if (getLynxContext() == null) goto L9;
        getLynxContext().g.b(new i(getSign(), EVENT_ZOOM_BY_USER));
        return;
    }

    private void onZoomChange(float r5) {
        if (this.mEnableZoomChangeEvent == true) goto L5;
        return;
    L5:
        if (getLynxContext() == null) goto L9;
        i r10 = new i(getSign(), EVENT_ZOOM_CHANGE);
        r10.a("zoom", Float.valueOf(r5));
        getLynxContext().g.b(r10);
        return;
    }

    private int px2dp(float r5) {
        return (int) ((r5 / this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void removeSensorListener() {
        SensorEventHelper r5 = this.mSensorHelper;
        if (r5 == null) goto L6;
        r5.b();
        return;
    }

    private void renderTextView(StrokeTextView r10, String r11, ReadableMap r12) {
        r10.setText(r11);
        if (r12 == null) goto L16;
        r10.setTextSize(1, (float) r12.getDouble("font_size", 14.0d));
        if (r12.getBoolean("is_bold", false) == false) goto L7;
        r10.setTypeface(Typeface.DEFAULT_BOLD);
    L7:
        r10.setTextColor(rgba2argb((int) r12.getLong("font_color", argb2rgba(Color.argb(255, 0, 0, 0)))));
        ReadableMap r5 = r12.getMap("max_size");
        if (r5 == null) goto L10;
        r10.setMaxWidth(dp2px((float) r5.getDouble("width", 120.0d)));
    L10:
        long r13 = r12.getLong("shadow_color", 0);
        if (r13 != 0) goto L13;
        r10.setStrokeColor(0);
    L14:
        r10.setBackgroundColor(rgba2argb((int) r12.getLong("background_color", argb2rgba(Color.argb(0, 255, 255, 255)))));
        return;
    L13:
        int r14 = (int) r13;
        r10.setStrokeColor(rgba2argb(r14));
        r10.setShadowLayer(10.0f, 0.0f, 0.0f, rgba2argb(r14));
        goto L14
    }

    private int rgba2argb(int r5) {
        return (r5 >>> 8) | (r5 << 24);
    }

    private void sendModuleLoadEvent() {
        LynxLog.b(2, TAG, "sendModuleLoadEvent:" + this.mModuleStatus);
        JavaOnlyArray r5 = new JavaOnlyArray();
        r5.pushInt(this.mModuleStatus);
        this.mContext.e(EVENT_MODULE_LOAD, r5);
    }

    private void setMarkerSelect(String r5, boolean r10) {
        if (r10 == false) goto L4;
        onMarkerSelect(r5);
    L5:
        IMarker r11 = this.mMarkerMap.get(r5);
        if (r11 == null) goto L8;
        ((AliMarker) r11).f3095c = r10;
    L8:
        IMarker r12 = this.mTextMarkerMap.get(r5);
        if (r12 == null) goto L12;
        ((AliMarker) r12).f3095c = r10;
        return;
    L12:
        return;
    L4:
        onMarkerUnselect(r5);
        goto L5
    }

    private void startMarkerAnimationInternal(IMarker r5, ReadableMap r10) {
        if (r5 == null) goto L14;
        ArrayList r11 = new ArrayList();
        ReadableMap r12 = r10.getMap("scale");
        ReadableMap r13 = r10.getMap("alpha");
        if (r12 == null) goto L7;
        r11.add(getAnimationStyle(0, r12));
    L7:
        if (r13 == null) goto L9;
        r11.add(getAnimationStyle(1, r13));
    L9:
        IMapService r14 = this.mMapClient.f6862a;
        if (r14 != null) goto L12;
        return;
    L12:
        r14.startMarkerAnimation(r5, r11);
        return;
    }

    private void updateCircle(String r5, BDLatLng r10, double r11, int r12, int r13, int r14, float r15) {
        ICircle r16 = this.mCircleMap.get(r5);
        if (r16 == null) goto L6;
        AliCircle r17 = (AliCircle) r16;
        r17.a(r10);
        r17.a(r11);
        r17.a(r12);
        r17.b(r13);
        r17.a(r14);
        return;
    }

    private void updateMarker(String r5, BDLatLng r10, Bitmap r11, float r12, float r13, ReadableMap r14) {
        IMarker r15 = this.mMarkerMap.get(r5);
        boolean r16 = r14.getBoolean("clickable", true);
        if (r15 == null) goto L5;
        AliMarker r17 = (AliMarker) r15;
        r17.a(r10);
        r17.a(r11);
        r17.b(r12);
        r17.a(r13);
        r17.a(r16);
    L5:
        ReadableMap r18 = r14.getMap("mtext");
        String r19 = r14.getString("content");
        ReadableMap r20 = r14.getMap("contentStyle");
        IMarker r21 = this.mTextMarkerMap.get(r5);
        if (r21 == null) goto L14;
        AliMarker r22 = (AliMarker) r21;
        r22.a(r10);
        r22.a(r13);
        if (r18 == null) goto L11;
        r22.a(getMarkerMtextView(r18.getInt("alignment", 0), r18, r11));
        return;
    L11:
        if (r19 == null) goto L15;
        r22.a(getMarkerTextView(r19, r20));
        return;
    L15:
        return;
    }

    private void updateModuleStatus() {
        BDMapClient r5 = this.mMapClient;
        if (r5 == null) goto L37;
        IMapService r10 = r5.f6862a;
        int r11 = -1;
        if (r10 != null) goto L8;
        int r12 = -1;
    L10:
        if (r12 != 0) goto L13;
        this.mModuleStatus = 1;
        return;
    L13:
        IMapService r13 = this.mMapClient.f6862a;
        if (r13 != null) goto L16;
        int r14 = -1;
    L18:
        if (r14 != 1) goto L21;
        this.mModuleStatus = 2;
        return;
    L21:
        IMapService r15 = this.mMapClient.f6862a;
        if (r15 != null) goto L24;
        int r16 = -1;
    L26:
        if (r16 != 2) goto L29;
        this.mModuleStatus = 3;
        return;
    L29:
        IMapService r17 = this.mMapClient.f6862a;
        if (r17 == null) goto L33;
        r11 = r17.getMapType();
    L33:
        if (r11 != 3) goto L36;
        this.mModuleStatus = 4;
        return;
    L36:
        return;
    L24:
        r16 = r15.getMapType();
        goto L26
    L16:
        r14 = r13.getMapType();
        goto L18
    L8:
        r12 = r10.getMapType();
        goto L10
    }

    private void updatePolygon(String r5, List<BDLatLng> r10, int r11, int r12, int r13, float r14) {
        IPolygon r15 = this.mPolygonMap.get(r5);
        if (r15 == null) goto L6;
        AliPolygon r16 = (AliPolygon) r15;
        r16.a(r10);
        r16.a(r11);
        r16.b(r12);
        r16.a(r13);
        return;
    }

    private void updatePolyline(int r14, String r15, List<BDLatLng> r16, float r17, int r18, int r19, float r20, boolean r21, Bitmap r22, ReadableMap r23, ReadableMap r24) {
        if (r14 != 0) goto L11;
        BDMapClient r11 = this.mMapClient;
        BDPolylineOptions r12 = new BDPolylineOptions(r15, r16, r19, r18, r20, r21, r17, r22);
        IMapService r5 = r11.f6862a;
        if (r5 != null) goto L7;
        IPolyline r10 = null;
    L8:
        this.mPolylineMap.put(r15, r10);
        return;
    L7:
        r10 = r5.addPolyline(r12);
        goto L8
    L11:
        if (r14 != 2) goto L37;
        IPolyline r13 = this.mPolylineMap.get(r15);
        if (r13 != null) goto L15;
        return;
    L15:
        if (r23.hasKey("points") == false) goto L18;
        ((AliPolyline) r13).a(r16);
    L18:
        if (r23.hasKey("zIndex") == false) goto L21;
        ((AliPolyline) r13).c(r17);
    L21:
        if (r23.hasKey("texture") == false) goto L23;
        ((AliPolyline) r13).a(r22);
    L23:
        if (r24 != null) goto L25;
        return;
    L25:
        if (r24.hasKey("stroke_color") == false) goto L28;
        ((AliPolyline) r13).a(r18);
    L28:
        if (r24.hasKey("line_width") == false) goto L31;
        ((AliPolyline) r13).b(r19);
    L31:
        if (r24.hasKey("alpha") == false) goto L34;
        ((AliPolyline) r13).a(r20);
    L34:
        if (r24.hasKey("isDottedLine") == false) goto L40;
        ((AliPolyline) r13).a(r21);
        return;
    L40:
        return;
    }

    @c0(name = "collision_percent")
    public void collisionPercent(double r5) {
        this.mCollisionPercent = (float) r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r5) {
        return createView(r5);
    }

    @f0
    public void deselectAnnotation(ReadableMap r5, Callback r10) {
        if (r5 != null) goto L5;
    L16:
        if (r10 == null) goto L21;
        r10.invoke(new Object[]{4, "Missing required parameter: identifier"});
        return;
    L21:
        return;
    L5:
        if (r5.size() == 0) goto L16;
        String r11 = r5.getString("identifier");
        if (TextUtils.isEmpty(r11) == false) goto L12;
        if (r10 == null) goto L19;
        r10.invoke(new Object[]{4, "Missing required parameter: identifier"});
        return;
    L19:
        return;
    L12:
        setMarkerSelect(r11, false);
        this.mLastClickedMarkerId = r11;
        if (r10 == null) goto L20;
        r10.invoke(new Object[]{0});
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        BDMapClient r5 = this.mMapClient;
        if (r5 == null) goto L15;
        IMapService r10 = r5.f6862a;
        if (r10 == null) goto L15;
        r10.onDestroy();
        MapMonitorUtil.a("destroy", null, null);
        long r11 = SystemClock.elapsedRealtime() - r5.f6864c;
        JSONObject r12 = new JSONObject();
        if (TextUtils.isEmpty("duration") == false) goto L29;
    L14:
        MapMonitorUtil.a("display_total_time", null, r12);
        goto L15
    L29:
        r12.put("duration", r11);     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L15:
        destroySensorHelper();
        g r13 = this.mLifecycleNotification;
        monitor-enter(MapLifecycleObserver.class);
        if (r13 != null) goto L23;
        boolean r14 = MapLifecycleObserver.f6911a;     // Catch: Throwable -> L21
        monitor-exit(MapLifecycleObserver.class);
        return;
    L23:
        MapLifecycleObserver.d.remove(r13);     // Catch: Throwable -> L21
        monitor-exit(MapLifecycleObserver.class);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    @c0(name = "enable_collision")
    public void enableCollision(boolean r5) {
        this.mEnableCollision = r5;
    }

    @c0(name = "enable_all_gestures")
    public void enableInitAllGestures(boolean r5) {
        BDMapClient r10 = this.mMapClient;
        if (r10 == null) goto L10;
        IMapService r11 = r10.f6862a;
        if (r11 != null) goto L8;
        return;
    L8:
        r11.setAllGesturesEnabled(r5);
        return;
    }

    @c0(name = "enable_rotate_gestures")
    public void enableInitRotateGestures(boolean r5) {
        BDMapClient r10 = this.mMapClient;
        if (r10 == null) goto L10;
        IMapService r11 = r10.f6862a;
        if (r11 != null) goto L8;
        return;
    L8:
        r11.setRotateGesturesEnabled(r5);
        return;
    }

    @c0(name = "enable_scroll_gestures")
    public void enableInitScrollGestures(boolean r5) {
        BDMapClient r10 = this.mMapClient;
        if (r10 == null) goto L10;
        IMapService r11 = r10.f6862a;
        if (r11 != null) goto L8;
        return;
    L8:
        r11.setScrollGesturesEnabled(r5);
        return;
    }

    @c0(name = "enable_tilt_gestures")
    public void enableInitTiltGestures(boolean r5) {
        BDMapClient r10 = this.mMapClient;
        if (r10 == null) goto L10;
        IMapService r11 = r10.f6862a;
        if (r11 != null) goto L8;
        return;
    L8:
        r11.setTiltGesturesEnabled(r5);
        return;
    }

    @c0(name = "enable_zoom_gestures")
    public void enableInitZoomGestures(boolean r5) {
        BDMapClient r10 = this.mMapClient;
        if (r10 == null) goto L10;
        IMapService r11 = r10.f6862a;
        if (r11 != null) goto L8;
        return;
    L8:
        r11.setZoomGesturesEnabled(r5);
        return;
    }

    @f0
    public void endPolygonEdit(ReadableMap r5, Callback r10) {
        if (this.mMapClient != null) goto L8;
        if (r10 == null) goto L27;
        r10.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L27:
        return;
    L8:
        if (r5 != null) goto L10;
    L24:
        if (r10 == null) goto L30;
        r10.invoke(new Object[]{4, "Missing required parameter: id"});
        return;
    L30:
        return;
    L10:
        if (r5.size() == 0) goto L24;
        String r11 = r5.getString("id");
        if (TextUtils.isEmpty(r11) == false) goto L17;
        if (r10 == null) goto L28;
        r10.invoke(new Object[]{4, "Missing required parameter: id"});
        return;
    L28:
        return;
    L17:
        IPolygon r12 = this.mPolygonMap.get(r11);
        EditHandler r13 = this.mMapClient.f6863b;
        if (r13 == null) goto L21;
        r13.a(r12);
    L21:
        if (r10 == null) goto L29;
        r10.invoke(new Object[]{0});
        return;
    }

    @Override // mf.a
    public BDMarkerOptions genMarkerOptions(ReadableMap r20, float r21, float r22, boolean r23) {
        if (r20 == null) goto L5;
        ReadableArray r5 = r20.getArray("points");
    L7:
        if (r5 != null) goto L9;
    L16:
        BDLatLng r10 = new BDLatLng(0.0d, 0.0d);
    L15:
        BDLatLng r11 = r10;
        float r12 = (float) (360.0d - r20.getDouble("rotateAngle", 0.0d));
        float r13 = (float) r20.getDouble("alpha", 1.0d);
        String r18 = r20.getString("id");
        float r14 = (float) r20.getDouble("zIndex", 0.0d);
        boolean r17 = r20.getBoolean("clickable", true);
        ReadableMap r15 = r20.getMap("offset");
        if (r15 == null) goto L24;
        float r16 = (float) r15.getDouble("offsetX", 0.0d);
        float r19 = (float) r15.getDouble("offsetY", 0.0d);
        if (r21 == 0.0f) goto L24;
        if (r22 == 0.0f) goto L24;
        float r24 = 0.5f - (dp2px(r16) / r21);
        float r110 = 0.5f - (dp2px(r19) / r22);
        float r111 = r24;
    L26:
        return new BDMarkerOptions(r11, null, null, r12, r13, r111, r110, r14, r17, r18);
    L24:
        r111 = 0.5f;
        r110 = 0.5f;
        goto L26
    L9:
        if (r5.size() <= 0) goto L16;
        if (r5.getArray(0) == null) goto L16;
        if (r5.getArray(0).size() < 2) goto L16;
        r10 = new BDLatLng(r5.getArray(0).getDouble(1), r5.getArray(0).getDouble(0));
        goto L15
    L5:
        r5 = null;
        goto L7
    }

    @f0
    public void getBound(Callback r10) {
        BDMapClient r11 = this.mMapClient;
        if (r11 != null) goto L7;
        if (r10 == null) goto L14;
        r10.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L14:
        return;
    L7:
        if (r10 == null) goto L42;
        IMapService r12 = r11.f6862a;
        if (r12 != null) goto L12;
        Map r13 = null;
    L13:
        if (r13 == null) goto L41;
        JavaOnlyArray r5 = new JavaOnlyArray();
        JavaOnlyArray r14 = new JavaOnlyArray();
        JavaOnlyArray r15 = new JavaOnlyArray();
        JavaOnlyArray r16 = new JavaOnlyArray();
        JavaOnlyArray r17 = new JavaOnlyArray();
        if (r13.get("far_left_lng") == null) goto L19;
        r14.pushDouble(((Double) r13.get("far_left_lng")).doubleValue());
    L19:
        if (r13.get("far_left_lat") == null) goto L22;
        r14.pushDouble(((Double) r13.get("far_left_lat")).doubleValue());
    L22:
        if (r13.get("far_right_lng") == null) goto L25;
        r15.pushDouble(((Double) r13.get("far_right_lng")).doubleValue());
    L25:
        if (r13.get("far_right_lat") == null) goto L28;
        r15.pushDouble(((Double) r13.get("far_right_lat")).doubleValue());
    L28:
        if (r13.get("near_left_lng") == null) goto L31;
        r16.pushDouble(((Double) r13.get("near_left_lng")).doubleValue());
    L31:
        if (r13.get("near_left_lat") == null) goto L34;
        r16.pushDouble(((Double) r13.get("near_left_lat")).doubleValue());
    L34:
        if (r13.get("near_right_lng") == null) goto L37;
        r17.pushDouble(((Double) r13.get("near_right_lng")).doubleValue());
    L37:
        if (r13.get("near_right_lat") == null) goto L39;
        r17.pushDouble(((Double) r13.get("near_right_lat")).doubleValue());
    L39:
        r5.pushArray(r14);
        r5.pushArray(r15);
        r5.pushArray(r16);
        r5.pushArray(r17);
        r10.invoke(new Object[]{0, r5});
        return;
    L41:
        return;
    L12:
        r13 = r12.getVisibleRegion();
        goto L13
    }

    @f0
    public void getBoundWithPadding(ReadableMap r19, Callback r20) {
        if (this.mMapClient != null) goto L7;
        if (r20 == null) goto L60;
        r20.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L60:
        return;
    L7:
        if (r19 == null) goto L57;
        if (r19.size() == 0) goto L57;
        IMapService r5 = this.mMapClient.f6862a;
        if (r5 != null) goto L15;
        Map r10 = null;
    L14:
        Map r11 = r10;
        if (r11 != null) goto L20;
        if (r20 == null) goto L61;
        r20.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L61:
        return;
    L20:
        ReadableArray r12 = r19.getArray("padding");
        if (r12 != null) goto L23;
    L25:
        float r13 = 0.0f;
        float r14 = 0.0f;
        float r15 = 0.0f;
        float r16 = 0.0f;
    L26:
        JavaOnlyArray r17 = new JavaOnlyArray();
        JavaOnlyArray r18 = new JavaOnlyArray();
        JavaOnlyArray r21 = new JavaOnlyArray();
        JavaOnlyArray r22 = new JavaOnlyArray();
        JavaOnlyArray r23 = new JavaOnlyArray();
        if (r11.get("far_left_lng") != null) goto L29;
    L33:
        JavaOnlyArray r110 = r22;
        JavaOnlyArray r24 = r23;
        JavaOnlyArray r25 = r21;
        JavaOnlyArray r111 = r17;
        JavaOnlyArray r112 = r18;
    L35:
        if (r11.get("far_right_lng") == null) goto L42;
        if (r11.get("far_right_lat") == null) goto L42;
        BDLatLng r26 = getLatLngWithPadding(((Double) r11.get("far_right_lat")).doubleValue(), ((Double) r11.get("far_right_lng")).doubleValue(), -r13, r16);
        if (r26 == null) goto L42;
        r25.pushDouble(r26.f6918b);
        r25.pushDouble(r26.f6917a);
    L42:
        if (r11.get("near_left_lng") == null) goto L49;
        if (r11.get("near_left_lat") == null) goto L49;
        BDLatLng r27 = getLatLngWithPadding(((Double) r11.get("near_left_lat")).doubleValue(), ((Double) r11.get("near_left_lng")).doubleValue(), r15, -r14);
        if (r27 == null) goto L49;
        r110.pushDouble(r27.f6918b);
        r110.pushDouble(r27.f6917a);
    L49:
        if (r11.get("near_right_lng") != null) goto L51;
    L55:
        JavaOnlyArray r28 = r111;
        r28.pushArray(r112);
        r28.pushArray(r25);
        r28.pushArray(r110);
        r28.pushArray(r24);
        r20.invoke(new Object[]{0, r28});
        return;
    L51:
        if (r11.get("near_right_lat") == null) goto L55;
        BDLatLng r29 = getLatLngWithPadding(((Double) r11.get("near_right_lat")).doubleValue(), ((Double) r11.get("near_right_lng")).doubleValue(), -r13, -r14);
        if (r29 == null) goto L55;
        r24.pushDouble(r29.f6918b);
        r24.pushDouble(r29.f6917a);
        goto L55
    L29:
        if (r11.get("far_left_lat") == null) goto L33;
        r110 = r22;
        r24 = r23;
        r25 = r21;
        r111 = r17;
        r112 = r18;
        BDLatLng r30 = getLatLngWithPadding(((Double) r11.get("far_left_lat")).doubleValue(), ((Double) r11.get("far_left_lng")).doubleValue(), r15, r16);
        if (r30 == null) goto L35;
        r112.pushDouble(r30.f6918b);
        r112.pushDouble(r30.f6917a);
        goto L35
    L23:
        if (r12.size() <= 3) goto L25;
        float r31 = (float) r12.getDouble(0);
        float r32 = (float) r12.getDouble(1);
        float r33 = (float) r12.getDouble(2);
        r13 = (float) r12.getDouble(3);
        r16 = r31;
        r15 = r32;
        r14 = r33;
        goto L26
    L15:
        r10 = r5.getVisibleRegion();
    L57:
        if (r20 == null) goto L62;
        r20.invoke(new Object[]{4, "Missing required parameter: padding"});
        return;
    }

    @f0
    public void getCenter(Callback r5) {
        BDMapClient r10 = this.mMapClient;
        if (r10 != null) goto L7;
        if (r5 == null) goto L8;
        r5.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L8:
        return;
    L7:
        if (r5 == null) goto L14;
        BDLatLng r11 = r10.a();
        JavaOnlyArray r12 = new JavaOnlyArray();
        if (r11 == null) goto L12;
        r12.pushDouble(r11.f6918b);
        r12.pushDouble(r11.f6917a);
    L12:
        r5.invoke(new Object[]{0, r12});
        return;
    }

    @f0
    public void getPolygonPoints(ReadableMap r5, Callback r10) {
        if (r5 != null) goto L5;
    L19:
        if (r10 == null) goto L24;
        r10.invoke(new Object[]{4, "Missing required parameter: id"});
        return;
    L24:
        return;
    L5:
        if (r5.size() == 0) goto L19;
        String r11 = r5.getString("id");
        if (TextUtils.isEmpty(r11) == false) goto L12;
        if (r10 == null) goto L22;
        r10.invoke(new Object[]{4, "Missing required parameter: id"});
        return;
    L22:
        return;
    L12:
        IPolygon r12 = this.mPolygonMap.get(r11);
        if (r12 != null) goto L17;
        if (r10 == null) goto L23;
        r10.invoke(new Object[]{4, "Invalid parameter 'id': polygon not found"});
        return;
    L23:
        return;
    L17:
        r10.invoke(new Object[]{0, getPointsData(((AliPolygon) r12).a())});
    }

    @f0
    public void getRotationDegree(Callback r5) {
        if (this.mMapClient != null) goto L7;
        if (r5 == null) goto L15;
        r5.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L15:
        return;
    L7:
        JavaOnlyMap r10 = new JavaOnlyMap();
        IMapService r11 = this.mMapClient.f6862a;
        if (r11 != null) goto L10;
        Log.e("BDMapClient", "BDMapClient.getRotationDegree: mMapService == null, return -1.0f, init?");
        float r12 = -1.0f;
    L11:
        r10.putDouble("rotation", r12);
        if (r5 == null) goto L16;
        r5.invoke(new Object[]{0, r10});
        return;
    L16:
        return;
    L10:
        r12 = r11.getRotationDegree();
        goto L11
    }

    @f0
    public void getZoom(Callback r5) {
        BDMapClient r10 = this.mMapClient;
        if (r10 != null) goto L7;
        if (r5 == null) goto L8;
        r5.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L8:
        return;
    L7:
        if (r5 == null) goto L15;
        IMapService r11 = r10.f6862a;
        if (r11 != null) goto L12;
        float r12 = 0.0f;
    L13:
        r5.invoke(new Object[]{0, Float.valueOf(r12)});
        return;
    L12:
        r12 = r11.getZoom();
        goto L13
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public void insertView(LynxUI r5) {
    }

    @c0(name = "is_bind_selectannotation")
    public void isBindSelectAnnotation(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L7;
        this.mIsBindSelectAnnotation = true;
        return;
    L7:
        if (r5.equals("true") == false) goto L10;
        this.mIsBindSelectAnnotation = true;
    L10:
        if (r5.equals("false") == false) goto L13;
        this.mIsBindSelectAnnotation = false;
        return;
    }

    @f0
    public void latLngToPx(ReadableMap r10, Callback r11) {
        if (this.mMapClient != null) goto L8;
        if (r11 == null) goto L38;
        r11.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L38:
        return;
    L8:
        if (r10 != null) goto L10;
    L35:
        if (r11 == null) goto L42;
        r11.invoke(new Object[]{4, "Missing required parameter: lat/lng"});
        return;
    L42:
        return;
    L10:
        if (r10.size() == 0) goto L35;
        if (r10.hasKey("lat") == false) goto L32;
        ReadableType r5 = r10.getType("lat");
        ReadableType r12 = ReadableType.Number;
        if (r5 != r12) goto L32;
        if (r10.hasKey("lng") == true) goto L20;
    L29:
        if (r11 == null) goto L40;
        r11.invoke(new Object[]{4, "Missing required parameter: longitude"});
        return;
    L40:
        return;
    L20:
        if (r10.getType("lng") != r12) goto L29;
        Point r13 = convertLatLngToPoint(r10.getDouble("lat"), r10.getDouble("lng"));
        if (r13 != null) goto L27;
        if (r11 == null) goto L39;
        r11.invoke(new Object[]{4, "Invalid parameter 'lat/lng': cannot convert to point"});
        return;
    L39:
        return;
    L27:
        JavaOnlyMap r14 = new JavaOnlyMap();
        r14.put("x", Integer.valueOf(r13.x));
        r14.put("y", Integer.valueOf(r13.y));
        r11.invoke(new Object[]{0, r14});
        return;
    L32:
        if (r11 == null) goto L41;
        r11.invoke(new Object[]{4, "Missing required parameter: latitude"});
        return;
    }

    @f0
    public void lnglatToPoint(ReadableMap r10, Callback r11) {
        if (this.mMapClient != null) goto L8;
        if (r11 == null) goto L28;
        r11.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L28:
        return;
    L8:
        if (r10 != null) goto L10;
    L25:
        if (r11 == null) goto L30;
        r11.invoke(new Object[]{4, "Missing required parameter: lnglat"});
        return;
    L30:
        return;
    L10:
        if (r10.size() == 0) goto L25;
        ReadableArray r12 = r10.getArray("lnglat");
        if (r12 != null) goto L15;
    L22:
        if (r11 == null) goto L29;
        r11.invoke(new Object[]{4, "Invalid parameter 'lnglat': expected array [lng, lat]"});
        return;
    L29:
        return;
    L15:
        if (r12.size() < 2) goto L22;
        Point r5 = convertLatLngToPoint(r12.getDouble(1), r12.getDouble(0));
        JavaOnlyArray r13 = new JavaOnlyArray();
        if (r5 == null) goto L20;
        r13.pushDouble(r5.x);
        r13.pushDouble(r5.y);
    L20:
        r11.invoke(new Object[]{0, r13});
    }

    @Override // com.bytedance.map.api.listener.PolygonEditListener
    public void onEdit(IPolygon r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        AliPolygon r10 = (AliPolygon) r5;
        onLynxEdit(r10.f3097b, getPointsData(r10.a()));
    }

    @Override // com.bytedance.map.api.listener.PolygonEditListener
    public void onEditEnd(IPolygon r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        AliPolygon r10 = (AliPolygon) r5;
        onLynxEditEnd(r10.f3097b, getPointsData(r10.a()));
    }

    @Override // com.bytedance.map.api.listener.PolygonEditListener
    public void onEditStart(IPolygon r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        AliPolygon r10 = (AliPolygon) r5;
        onLynxEditStart(r10.f3097b, getPointsData(r10.a()));
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public void onInsertChild(LynxBaseUI r5, int r10) {
        super.onInsertChild(r5, r10);
        if ((r5 instanceof LynxMapMarker) == false) goto L6;
        ((LynxMapMarker) r5).mLynxMapView = this;
        return;
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public void onMapClick(BDLatLng r5) {
        LynxLog.b(2, TAG, "onMapClick: " + r5);
        onLynxMapClickByUser(r5);
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public void onMapLoad() {
        LynxLog.b(2, TAG, "onMapLoaded");
        if (this.mIsCameraLoad == true) goto L5;
        this.mIsCameraLoad = true;
    L5:
        onLynxMapLoad();
        cameraChangeViewDraw();
        float r5 = 0.0f;
        if (this.mIsBindZoomChange == false) goto L12;
        IMapService r10 = this.mMapClient.f6862a;
        if (r10 != null) goto L10;
        float r11 = 0.0f;
    L11:
        onZoomChange(r11);
        goto L12
    L10:
        r11 = r10.getZoom();
    L12:
        IMapService r12 = this.mMapClient.f6862a;
        if (r12 == null) goto L16;
        r5 = r12.getZoom();
    L16:
        this.mLastZoom = r5;
        BDLatLng r13 = this.mMapClient.a();
        if (r13 == null) goto L20;
        this.mLastLatitude = r13.f6917a;
        this.mLastLongitude = r13.f6918b;
        return;
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public void onMapMove(BDLatLng r5) {
        cameraChangeViewDraw();
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public void onMapMoveEnd(BDLatLng r10) {
        LynxLog.b(2, TAG, "onCameraChangeFinish" + this);
        cameraChangeViewDraw();
        BDLatLng r11 = this.mMapClient.a();
        if (r11 != null) goto L5;
    L15:
        this.mIsChangeByZoom = false;
        return;
    L5:
        if (r11.f6917a == this.mLastLatitude) goto L15;
        if (r11.f6918b == this.mLastLongitude) goto L15;
        if (this.mIsChangeByZoom == true) goto L12;
        LynxLog.b(2, TAG, "regionChange: move");
        onRegionChange();
    L12:
        if (this.mIsTouchByUser == false) goto L14;
        LynxLog.b(2, TAG, "onTouch: moveByUser");
        onMoveByUser();
        this.mIsTouchByUser = false;
    L14:
        this.mLastLatitude = r11.f6917a;
        this.mLastLongitude = r11.f6918b;
        goto L15
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public void onMapTouch(MotionEvent r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getAction() != 1) goto L8;
        this.mIsTouchByUser = true;
        return;
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public void onMapZoom(float r5) {
        LynxLog.b(2, TAG, "zoom: " + r5 + this);
        if (this.mIsBindZoomChange == false) goto L5;
        onZoomChange(r5);
    L5:
        cameraChangeViewDraw();
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public void onMapZoomEnd(float r10) {
        LynxLog.b(2, TAG, "onCameraChangeFinish" + this);
        if (this.mIsBindZoomChange == false) goto L5;
        onZoomChange(r10);
    L5:
        cameraChangeViewDraw();
        if (r10 == this.mLastZoom) goto L11;
        this.mIsChangeByZoom = true;
        LynxLog.b(2, TAG, "regionChange: zoom");
        onRegionChange();
        if (this.mIsTouchByUser == false) goto L10;
        LynxLog.b(2, TAG, "onTouch: zoomByUser");
        onZoomByUser();
        this.mIsTouchByUser = false;
    L10:
        this.mLastZoom = r10;
    L11:
        BDLatLng r11 = this.mMapClient.a();
        if (r11 == null) goto L19;
        if (r11.f6917a != this.mLastLatitude) goto L19;
        if (r11.f6918b != this.mLastLongitude) goto L19;
        this.mIsChangeByZoom = false;
    L19:
        if (this.mEnableCollision == false) goto L22;
        detectCollision();
        return;
    }

    @Override // com.bytedance.map.api.listener.MarkerActionListener
    public void onMarkerClick(IMarker r5) {
        LynxLog.b(2, TAG, "onMarkerClick");
        if (this.mIsBindSelectAnnotation == false) goto L13;
        AliMarker r10 = (AliMarker) r5;
        String r11 = r10.f3094b;
        if (r10.f3095c == false) goto L7;
        setMarkerSelect(r11, false);
    L12:
        this.mLastClickedMarkerId = r11;
        goto L13
    L7:
        setMarkerSelect(r11, true);
        String r12 = this.mLastClickedMarkerId;
        if (r12 == null) goto L12;
        if (r12.equals(r11) == true) goto L12;
        setMarkerSelect(this.mLastClickedMarkerId, false);
    L13:
        Iterator<LynxBaseUI> r13 = getChildren().iterator();
    L15:
        if (r13.hasNext() == false) goto L39;
        LynxMapMarker r14 = (LynxMapMarker) r13.next();
        if (r14 == null) goto L15;
        IMarker r15 = r14.mMarker;
        if (r15 == null) goto L15;
        if (r5 == null) goto L15;
        if (((AliMarker) r15).f3094b != ((AliMarker) r5).f3094b) goto L15;
        if (r14.mMotionEventAtLastTouchUp == null) goto L15;
        getLynxContext().f10140h.o(r14.mMotionEventAtLastTouchUp);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
        if (this.mFirstRender == true) goto L5;
    L8:
        this.mFirstRender = false;
        return;
    L5:
        if (this.mMapClient.f6862a == null) goto L7;
        updateModuleStatus();
    L7:
        sendModuleLoadEvent();
        goto L8
    }

    @Override // mf.a
    public List<AnimationStyle> parseAnimationStyle(ReadableMap r5) {
        ArrayList r10 = new ArrayList();
        ReadableMap r11 = r5.getMap("scale");
        ReadableMap r12 = r5.getMap("alpha");
        if (r11 == null) goto L5;
        r10.add(getAnimationStyle(0, r11));
    L5:
        if (r12 == null) goto L7;
        r10.add(getAnimationStyle(1, r12));
    L7:
        return r10;
    }

    @Override // mf.a
    public void removeMarker(IMarker r5, boolean r10) {
        IMapService r11 = this.mMapClient.f6862a;
        if (r11 == null) goto L6;
        r11.removeMarker(r5);
    L6:
        this.mMarkerMap.remove(((AliMarker) r5).f3094b);
        if (r10 == false) goto L12;
        SensorEventHelper r12 = this.mSensorHelper;
        if (r12 == null) goto L13;
        r12.f = null;
        return;
    L13:
        return;
    }

    @f0
    public void selectAnnotation(ReadableMap r5, Callback r10) {
        if (r5 != null) goto L5;
    L21:
        if (r10 == null) goto L26;
        r10.invoke(new Object[]{4, "Missing required parameter: identifier"});
        return;
    L26:
        return;
    L5:
        if (r5.size() == 0) goto L21;
        String r11 = r5.getString("identifier");
        if (TextUtils.isEmpty(r11) == false) goto L12;
        if (r10 == null) goto L24;
        r10.invoke(new Object[]{4, "Missing required parameter: identifier"});
        return;
    L24:
        return;
    L12:
        setMarkerSelect(r11, true);
        String r12 = this.mLastClickedMarkerId;
        if (r12 != null) goto L15;
    L17:
        this.mLastClickedMarkerId = r11;
        if (r10 == null) goto L25;
        r10.invoke(new Object[]{0});
        return;
    L25:
        return;
    L15:
        if (r12.equals(r11) == true) goto L17;
        setMarkerSelect(this.mLastClickedMarkerId, false);
        goto L17
    }

    @f0
    public void setAllGesturesEnable(ReadableMap r5, Callback r10) {
        if (this.mMapClient != null) goto L7;
        if (r10 == null) goto L21;
        r10.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L21:
        return;
    L7:
        if (r5 != null) goto L9;
    L18:
        if (r10 == null) goto L23;
        r10.invoke(new Object[]{4, "Missing required parameter: enable"});
        return;
    L23:
        return;
    L9:
        if (r5.size() == 0) goto L18;
        boolean r11 = r5.getBoolean("enable", true);
        IMapService r12 = this.mMapClient.f6862a;
        if (r12 == null) goto L15;
        r12.setAllGesturesEnabled(r11);
    L15:
        if (r10 == null) goto L22;
        r10.invoke(new Object[]{0});
        return;
    }

    @c0(name = "is_bind_viewdraw")
    public void setBindViewDraw(String r5) {
        if (r5 != null) goto L7;
        this.mIsBindViewDraw = true;
        return;
    L7:
        if (r5.equals("true") == false) goto L10;
        this.mIsBindViewDraw = true;
    L10:
        if (r5.equals("false") == false) goto L13;
        this.mIsBindViewDraw = false;
        return;
    }

    @c0(name = "is_bind_zoomchange")
    public void setBindZoomChange(String r5) {
        if (r5 != null) goto L7;
        this.mIsBindZoomChange = true;
        return;
    L7:
        if (r5.equals("true") == false) goto L10;
        this.mIsBindZoomChange = true;
    L10:
        if (r5.equals("false") == false) goto L13;
        this.mIsBindZoomChange = false;
        return;
    }

    @f0
    public void setBound(ReadableMap r13, Callback r14) {
        if (this.mMapClient != null) goto L8;
        if (r14 == null) goto L40;
        r14.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L40:
        return;
    L8:
        if (r13 != null) goto L10;
    L37:
        if (r14 == null) goto L44;
        r14.invoke(new Object[]{4, "Missing required parameter: bound"});
        return;
    L44:
        return;
    L10:
        if (r13.size() == 0) goto L37;
        ReadableMap r5 = r13.getMap("bound");
        if (r5 != null) goto L17;
        if (r14 == null) goto L41;
        r14.invoke(new Object[]{4, "Missing required parameter: bound"});
        return;
    L41:
        return;
    L17:
        ReadableArray r10 = r5.getArray("points");
        if (r10 != null) goto L22;
        if (r14 == null) goto L42;
        r14.invoke(new Object[]{4, "Invalid parameter 'bound.points': expected array"});
        return;
    L42:
        return;
    L22:
        List<BDLatLng> r11 = getLatLngList(r10);
        boolean r12 = r13.getBoolean("isanimate", true);
        double r15 = r13.getDouble("duration", 0.0d);
        ReadableArray r16 = r5.getArray("padding");
        if (r16 != null) goto L25;
    L30:
        int r17 = (int) r15;
        IMapService r18 = this.mMapClient.f6862a;
        if (r18 == null) goto L34;
        r18.setBound(r11, 100, 100, 100, 100, r12, r17);
    L34:
        if (r14 == null) goto L43;
        r14.invoke(new Object[]{0});
        return;
    L43:
        return;
    L25:
        if (r16.size() <= 3) goto L30;
        BDMapClient r19 = this.mMapClient;
        int r20 = dp2px((float) r16.getDouble(1));
        int r21 = dp2px((float) r16.getDouble(3));
        int r22 = dp2px((float) r16.getDouble(0));
        int r110 = dp2px((float) r16.getDouble(2));
        int r111 = (int) r15;
        IMapService r23 = r19.f6862a;
        if (r23 == null) goto L34;
        r23.setBound(r11, r20, r21, r22, r110, r12, r111);
        goto L34
    }

    @f0
    public void setCenter(ReadableMap r10, Callback r11) {
        if (this.mMapClient != null) goto L8;
        if (r11 == null) goto L30;
        r11.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L30:
        return;
    L8:
        if (r10 != null) goto L10;
    L27:
        if (r11 == null) goto L33;
        r11.invoke(new Object[]{4, "Missing required parameter: center"});
        return;
    L33:
        return;
    L10:
        if (r10.size() == 0) goto L27;
        ReadableArray r5 = r10.getArray("center");
        if (r5 != null) goto L15;
    L24:
        if (r11 == null) goto L32;
        r11.invoke(new Object[]{4, "Invalid parameter 'center': expected array [lng, lat]"});
        return;
    L32:
        return;
    L15:
        if (r5.size() == 0) goto L24;
        boolean r12 = r10.getBoolean("isanimate", true);
        double r13 = r10.getDouble("duration", 0.0d);
        BDMapClient r14 = this.mMapClient;
        BDLatLng r15 = new BDLatLng(r5.getDouble(1), r5.getDouble(0));
        int r16 = (int) r13;
        IMapService r17 = r14.f6862a;
        if (r17 == null) goto L21;
        r17.setCenter(r15, r12, r16);
    L21:
        if (r11 == null) goto L31;
        r11.invoke(new Object[]{0});
        return;
    }

    @c0(name = "centerAndZoom")
    public void setCenterAndZoom(ReadableMap r5) {
        setCenterAndZoom(r5, null);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setEvents(Map<String, on.a> r5) {
        super.setEvents(r5);
        if (r5 == null) goto L6;
        this.mEnableMapLoadEvent = r5.containsKey(EVENT_MAP_LOAD);
        this.mEnableViewDrawEvent = r5.containsKey(EVENT_VIEW_DRAW);
        this.mEnableZoomChangeEvent = r5.containsKey(EVENT_ZOOM_CHANGE);
        this.mEnableMarkerSelectEvent = r5.containsKey(EVENT_MARKER_SELECT);
        this.mEnableMarkerUnselectEvent = r5.containsKey(EVENT_MARKER_UNSELECT);
        this.mEnableRegionChangeEvent = r5.containsKey(EVENT_REGION_CHANGE);
        this.mEnableMoveByUserEvent = r5.containsKey(EVENT_MOVE_BY_USER);
        this.mEnableZoomByUserEvent = r5.containsKey(EVENT_ZOOM_BY_USER);
        this.mEnableSingleTapAtMap = r5.containsKey(EVENT_SINGLE_TAP_AT_MAP);
        this.mEnableOnEditStart = r5.containsKey(EVENT_ON_EDIT_START);
        this.mEnableOnEdit = r5.containsKey(EVENT_ON_EDIT);
        this.mEnableOnEditEnd = r5.containsKey(EVENT_ON_EDIT_END);
        return;
    }

    @c0(name = "enable_handle_gesture")
    public void setHandleGesture(boolean r5) {
        BDMapClient r10 = this.mMapClient;
        if (r10 == null) goto L10;
        IMapService r11 = r10.f6862a;
        if (r11 != null) goto L8;
        return;
    L8:
        r11.setHandleGesture(r5);
        return;
    }

    @c0(name = "bound")
    public void setInitBound(ReadableMap r10) {
        if (this.mMapClient == null) goto L24;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.size() == 0) goto L25;
        ReadableArray r5 = r10.getArray("points");
        List<BDLatLng> r11 = getLatLngList(r5);
        LynxLog.b(2, TAG, "onViewDraw initBound = " + r5);
        ReadableArray r12 = r10.getArray("padding");
        if (r12 != null) goto L12;
    L18:
        IMapService r13 = this.mMapClient.f6862a;
        if (r13 == null) goto L27;
        r13.setBound(r11, 100, 100, 100, 100, false);
        return;
    L27:
        return;
    L12:
        if (r12.size() <= 3) goto L18;
        BDMapClient r14 = this.mMapClient;
        int r15 = dp2px((float) r12.getDouble(1));
        int r16 = dp2px((float) r12.getDouble(3));
        int r17 = dp2px((float) r12.getDouble(0));
        int r18 = dp2px((float) r12.getDouble(2));
        IMapService r19 = r14.f6862a;
        if (r19 == null) goto L26;
        r19.setBound(r11, r15, r16, r17, r18, false);
        return;
    L26:
        return;
    L25:
        return;
    }

    @c0(name = "center")
    public void setInitCenter(ReadableArray r10) {
        if (this.mMapClient == null) goto L15;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.size() < 2) goto L16;
        BDMapClient r11 = this.mMapClient;
        BDLatLng r5 = new BDLatLng(r10.getDouble(1), r10.getDouble(0));
        IMapService r12 = r11.f6862a;
        if (r12 == null) goto L17;
        r12.setCenter(r5, false);
        return;
    L17:
        return;
    L16:
        return;
    }

    @c0(name = "zoom")
    public void setInitZoom(float r5) {
        BDMapClient r10 = this.mMapClient;
        if (r10 == null) goto L10;
        IMapService r11 = r10.f6862a;
        if (r11 != null) goto L8;
        return;
    L8:
        r11.setZoom(r5, false);
        return;
    }

    @c0(name = "mapstyle")
    public void setMapStyle(String r5) {
        if (this.mMapClient != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r5) == true) goto L14;
        IMapService r10 = this.mMapClient.f6862a;
        if (r10 != null) goto L11;
        return;
    L11:
        r10.setCustomMapStyle(true, r5);
        return;
    }

    @c0(name = "max-zoom-level")
    public void setMaxZoomLevel(float r5) {
        BDMapClient r10 = this.mMapClient;
        if (r10 == null) goto L10;
        IMapService r11 = r10.f6862a;
        if (r11 != null) goto L8;
        return;
    L8:
        r11.setMaxZoomLevel(r5);
        return;
    }

    @c0(name = "min-zoom-level")
    public void setMinZoomLevel(float r5) {
        BDMapClient r10 = this.mMapClient;
        if (r10 == null) goto L10;
        IMapService r11 = r10.f6862a;
        if (r11 != null) goto L8;
        return;
    L8:
        r11.setMinZoomLevel(r5);
        return;
    }

    @c0(name = "need_user_location_heading")
    public void setNeedUserLocationHeading(boolean r5) {
        this.mNeedUserLocationHeading = r5;
        if (r5 == false) goto L6;
        addSensorListener();
        return;
    L6:
        removeSensorListener();
    }

    @c0(name = "restricted-region")
    public void setRestrictedRegion(ReadableArray r10) {
        if (this.mMapClient != null) goto L6;
        return;
    L6:
        if (r10 != null) goto L8;
    L14:
        LynxError r11 = new LynxError(229800, "An illegal data format is set for the attribute of 'restricted-region' on <x-map-ng>", "Please set NorthEastLat, NorthEastLng, SouthWestLat, and SouthWestLng in sequence.", "error");
        r11.f9990a = true;
        getLynxContext().b(r11);
        return;
    L8:
        if (r10.size() < 4) goto L14;
        BDLatLng r5 = new BDLatLng(r10.getDouble(0), r10.getDouble(1));
        BDLatLng r12 = new BDLatLng(r10.getDouble(2), r10.getDouble(3));
        IMapService r13 = this.mMapClient.f6862a;
        if (r13 != null) goto L12;
        return;
    L12:
        r13.setLimitRegion(r5, r12);
    }

    @f0
    public void setRotateGesturesEnable(ReadableMap r5, Callback r10) {
        if (this.mMapClient != null) goto L7;
        if (r10 == null) goto L21;
        r10.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L21:
        return;
    L7:
        if (r5 != null) goto L9;
    L18:
        if (r10 == null) goto L23;
        r10.invoke(new Object[]{4, "Missing required parameter: enable"});
        return;
    L23:
        return;
    L9:
        if (r5.size() == 0) goto L18;
        boolean r11 = r5.getBoolean("enable", true);
        IMapService r12 = this.mMapClient.f6862a;
        if (r12 == null) goto L15;
        r12.setRotateGesturesEnabled(r11);
    L15:
        if (r10 == null) goto L22;
        r10.invoke(new Object[]{0});
        return;
    }

    @c0(name = "rotation")
    public void setRotation(float r5) {
        BDMapClient r10 = this.mMapClient;
        if (r10 != null) goto L5;
        return;
    L5:
        IMapService r11 = r10.f6862a;
        if (r11 != null) goto L9;
        Log.e("BDMapClient", "BDMapClient.setRotationDegree: mMapService == null, init?");
        return;
    L9:
        r11.setRotationDegree(r5, false, 0);
    }

    @f0
    public void setRotationDegree(ReadableMap r10, Callback r11) {
        if (this.mMapClient != null) goto L7;
        if (r11 == null) goto L21;
        r11.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L21:
        return;
    L7:
        if (r10 != null) goto L9;
    L18:
        if (r11 == null) goto L23;
        r11.invoke(new Object[]{4, "Missing required parameter: rotation"});
        return;
    L23:
        return;
    L9:
        if (r10.size() == 0) goto L18;
        float r5 = (float) r10.getDouble("rotation", 0.0d);
        boolean r12 = r10.getBoolean("animated", true);
        long r13 = r10.getLong("duration", 100);
        int r14 = (int) r13;
        IMapService r15 = this.mMapClient.f6862a;
        if (r15 != null) goto L14;
        Log.e("BDMapClient", "BDMapClient.setRotationDegree: mMapService == null, init?");
    L15:
        if (r11 == null) goto L22;
        r11.invoke(new Object[]{0});
        return;
    L22:
        return;
    L14:
        r15.setRotationDegree(r5, r12, r14);
        goto L15
    }

    @f0
    public void setScrollGesturesEnable(ReadableMap r5, Callback r10) {
        if (this.mMapClient != null) goto L7;
        if (r10 == null) goto L21;
        r10.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L21:
        return;
    L7:
        if (r5 != null) goto L9;
    L18:
        if (r10 == null) goto L23;
        r10.invoke(new Object[]{4, "Missing required parameter: enable"});
        return;
    L23:
        return;
    L9:
        if (r5.size() == 0) goto L18;
        boolean r11 = r5.getBoolean("enable", true);
        IMapService r12 = this.mMapClient.f6862a;
        if (r12 == null) goto L15;
        r12.setScrollGesturesEnabled(r11);
    L15:
        if (r10 == null) goto L22;
        r10.invoke(new Object[]{0});
        return;
    }

    @f0
    public void setTiltGesturesEnable(ReadableMap r5, Callback r10) {
        if (this.mMapClient != null) goto L7;
        if (r10 == null) goto L21;
        r10.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L21:
        return;
    L7:
        if (r5 != null) goto L9;
    L18:
        if (r10 == null) goto L23;
        r10.invoke(new Object[]{4, "Missing required parameter: enable"});
        return;
    L23:
        return;
    L9:
        if (r5.size() == 0) goto L18;
        boolean r11 = r5.getBoolean("enable", true);
        IMapService r12 = this.mMapClient.f6862a;
        if (r12 == null) goto L15;
        r12.setTiltGesturesEnabled(r11);
    L15:
        if (r10 == null) goto L22;
        r10.invoke(new Object[]{0});
        return;
    }

    @c0(name = "user_location_annotation")
    public void setUserLocationAnnotation(ReadableMap r5) {
        if (this.mMapClient == null) goto L24;
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.size() == 0) goto L25;
        ReadableArray r10 = r5.getArray("points");
        if (r10 != null) goto L12;
        return;
    L12:
        if (r10.size() != 0) goto L14;
        return;
    L14:
        if (r10.getArray(0) != null) goto L16;
        return;
    L16:
        if (r10.getArray(0).size() < 2) goto L26;
        ThreadManager.a().f6940a.execute(new f(this, 12, r5, r10));
        return;
    L26:
        return;
    L25:
        return;
    }

    @f0
    public void setZoom(ReadableMap r10, Callback r11) {
        if (this.mMapClient != null) goto L8;
        if (r11 == null) goto L30;
        r11.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L30:
        return;
    L8:
        if (r10 != null) goto L10;
    L27:
        if (r11 == null) goto L33;
        r11.invoke(new Object[]{4, "Missing required parameter: zoom"});
        return;
    L33:
        return;
    L10:
        if (r10.size() == 0) goto L27;
        if (r10.hasKey("zoom") == true) goto L15;
    L24:
        if (r11 == null) goto L32;
        r11.invoke(new Object[]{4, "Invalid parameter 'zoom is missing'"});
        return;
    L32:
        return;
    L15:
        if (r10.getType("zoom") != ReadableType.Number) goto L24;
        float r5 = (float) r10.getDouble("zoom");
        boolean r12 = r10.getBoolean("isanimate", true);
        double r13 = r10.getDouble("duration", 0.0d);
        int r14 = (int) r13;
        IMapService r15 = this.mMapClient.f6862a;
        if (r15 == null) goto L21;
        r15.setZoom(r5, r12, r14);
    L21:
        if (r11 == null) goto L31;
        r11.invoke(new Object[]{0});
        return;
    }

    @f0
    public void setZoomGesturesEnable(ReadableMap r5, Callback r10) {
        if (this.mMapClient != null) goto L7;
        if (r10 == null) goto L21;
        r10.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L21:
        return;
    L7:
        if (r5 != null) goto L9;
    L18:
        if (r10 == null) goto L23;
        r10.invoke(new Object[]{4, "Missing required parameter: enable"});
        return;
    L23:
        return;
    L9:
        if (r5.size() == 0) goto L18;
        boolean r11 = r5.getBoolean("enable", true);
        IMapService r12 = this.mMapClient.f6862a;
        if (r12 == null) goto L15;
        r12.setZoomGesturesEnabled(r11);
    L15:
        if (r10 == null) goto L22;
        r10.invoke(new Object[]{0});
        return;
    }

    @c0(name = "annotation")
    public void showAnnotation(ReadableArray r5) {
        if (this.mMapClient == null) goto L12;
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.size() == 0) goto L13;
        LynxLog.b(2, TAG, "showAnnotation");
        ThreadManager.a().f6940a.execute(new kh.b(2, this, r5));
        return;
    L13:
        return;
    }

    @c0(name = SVGRenderEngine.LINE)
    public synchronized void showLine(ReadableArray r15) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.mMapClient == null) goto L27;
        if (r15 == null) goto L27;
        if (r15.size() == 0) goto L27;
        clearAllPolylines();     // Catch: Throwable -> L16
        int r5 = 0;
    L11:
        if (r5 >= r15.size()) goto L27;
        ReadableMap r10 = r15.getMap(r5);     // Catch: Throwable -> L16
        String r11 = r10.getString("id", String.valueOf(r5));     // Catch: Throwable -> L16
        List<BDLatLng> r12 = getLatLngList(r10.getArray("points"));     // Catch: Throwable -> L16
        ReadableMap r13 = r10.getMap("extra");     // Catch: Throwable -> L16
        int r14 = Color.argb(255, 255, 0, 0);     // Catch: Throwable -> L16
        if (r13 == null) goto L18;
        int r16 = dp2px((float) r13.getDouble("line_width", px2dp(10.0f)));     // Catch: Throwable -> L16
        int r17 = rgba2argb((int) r13.getLong("stroke_color", argb2rgba(Color.argb(255, 255, 0, 0))));     // Catch: Throwable -> L16
        boolean r18 = r13.getBoolean("isDottedLine", false);     // Catch: Throwable -> L16
        float r19 = (float) r13.getDouble("alpha", 1.0d);     // Catch: Throwable -> L16
        int r20 = r17;
        int r21 = r16;
        boolean r110 = r18;
    L19:
        BDMapClient r22 = this.mMapClient;     // Catch: Throwable -> L16
        BDPolylineOptions r23 = new BDPolylineOptions(r11, r12, r21, r20, r19, r110, 0.0f, null);     // Catch: Throwable -> L16
        IMapService r24 = r22.f6862a;     // Catch: Throwable -> L16
        if (r24 != null) goto L22;
        IPolyline r25 = null;
    L23:
        if (r11 == null) goto L26;
        if (r25 == null) goto L26;
        this.mPolylineMap.put(r11, r25);     // Catch: Throwable -> L16
    L26:
        r5 = r5 + 1;
        goto L11
    L22:
        r25 = r24.addPolyline(r23);     // Catch: Throwable -> L16
        goto L23
    L18:
        r110 = false;
        r21 = 10;
        r19 = 1.0f;
        r20 = r14;
    L27:
        monitor-exit(this);
    }

    @f0
    public void startMarkerAnimation(ReadableMap r5, Callback r10) {
        if (this.mMapClient != null) goto L8;
        if (r10 == null) goto L24;
        r10.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L24:
        return;
    L8:
        if (r5 != null) goto L10;
    L21:
        if (r10 == null) goto L27;
        r10.invoke(new Object[]{4, "Missing required parameter: animation"});
        return;
    L27:
        return;
    L10:
        if (r5.size() == 0) goto L21;
        String r11 = r5.getString("id");
        if (TextUtils.isEmpty(r11) == false) goto L17;
        if (r10 == null) goto L25;
        r10.invoke(new Object[]{4, "Missing required parameter: id"});
        return;
    L25:
        return;
    L17:
        IMarker r12 = this.mMarkerMap.get(r11);
        IMarker r13 = this.mTextMarkerMap.get(r11);
        startMarkerAnimationInternal(r12, r5);
        startMarkerAnimationInternal(r13, r5);
        if (r10 == null) goto L26;
        r10.invoke(new Object[]{0});
        return;
    }

    @f0
    public void startPolygonEdit(ReadableMap r10, Callback r11) {
        if (this.mMapClient != null) goto L8;
        if (r11 == null) goto L51;
        r11.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L51:
        return;
    L8:
        if (r10 != null) goto L10;
    L47:
        if (r11 == null) goto L54;
        r11.invoke(new Object[]{4, "Missing required parameter: id"});
        return;
    L54:
        return;
    L10:
        if (r10.size() == 0) goto L47;
        String r12 = r10.getString("id");
        if (TextUtils.isEmpty(r12) == false) goto L17;
        if (r11 == null) goto L52;
        r11.invoke(new Object[]{4, "Missing required parameter: id"});
        return;
    L52:
        return;
    L17:
        IPolygon r13 = this.mPolygonMap.get(r12);
        EditHandler r14 = this.mMapClient.f6863b;
        if (r14 == null) goto L44;
        if (r13 == null) goto L44;
        if (r13.equals(r14.f6896p) == true) goto L44;
        r14.a(r14.f6896p);
        r14.f6896p = r13;
        ArrayList r15 = ((AliPolygon) r13).a();
        int r5 = r15.size();
        int r16 = 0;
    L25:
        if (r16 >= r5) goto L27;
        BDLatLng r17 = (BDLatLng) r15.get(r16);
        r16 = r16 + 1;
        BDLatLng r18 = r14.a(r17, (BDLatLng) r15.get(r16 % r5));
        r14.s.add(r14.a(r17, LayoutInflater.from(r14.f6885a).inflate(R$layout.map_big_point_marker_layout, null)));
        r14.s.add(r14.a(r18, LayoutInflater.from(r14.f6885a).inflate(R$layout.map_small_point_marker_layout, null)));
        r14.f6897q.add(new BDLatLng(r17, true));
        r14.f6897q.add(new BDLatLng(r18, false));
        goto L25
    L27:
        IMapService r19 = r14.f6886b.f6862a;
        if (r19 != null) goto L30;
        boolean r110 = false;
    L31:
        r14.d = r110;
        IMapService r111 = r14.f6886b.f6862a;
        if (r111 != null) goto L34;
        boolean r112 = false;
    L35:
        r14.e = r112;
        IMapService r113 = r14.f6886b.f6862a;
        if (r113 != null) goto L38;
        boolean r114 = false;
    L39:
        r14.f = r114;
        IMapService r115 = r14.f6886b.f6862a;
        if (r115 != null) goto L42;
        boolean r116 = false;
    L43:
        r14.g = r116;
        goto L44
    L42:
        r116 = r115.isTiltGesturesEnabled();
        goto L43
    L38:
        r114 = r113.isScrollGesturesEnabled();
        goto L39
    L34:
        r112 = r111.isZoomGesturesEnabled();
        goto L35
    L30:
        r110 = r19.isRotateGesturesEnabled();
    L44:
        if (r11 == null) goto L53;
        r11.invoke(new Object[]{0});
        return;
    }

    @f0
    public void updateAnnotations(ReadableMap r5, Callback r10) {
        if (this.mMapClient != null) goto L7;
        if (r10 == null) goto L18;
        r10.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L18:
        return;
    L7:
        if (r5 != null) goto L9;
    L15:
        if (r10 == null) goto L20;
        r10.invoke(new Object[]{4, "Missing required parameter: annotations"});
        return;
    L20:
        return;
    L9:
        if (r5.size() == 0) goto L15;
        LynxLog.b(2, TAG, "updateAnnotation" + this);
        ThreadManager.a().f6940a.execute(new f(this, 11, r5, r10));
        if (r10 == null) goto L19;
        r10.invoke(new Object[]{0});
        return;
    }

    @f0
    public void updateCircles(ReadableMap r18, Callback r19) {
        if (this.mMapClient != null) goto L9;
        if (r19 == null) goto L6;
        r19.invoke(new Object[]{7, "map is not loaded!"});
    L6:
        LynxLog.b(2, TAG, "updateCircles and mMapClient is null");
        return;
    L9:
        if (r18 != null) goto L11;
    L52:
        if (r19 == null) goto L54;
        r19.invoke(new Object[]{4, "Missing required parameter: circles"});
    L54:
        LynxLog.b(2, TAG, "updateCircles and mapDataItem is null");
        return;
    L11:
        if (r18.size() == 0) goto L52;
        LynxLog.b(2, TAG, "updateCircles" + this);
        int r12 = r18.getInt("type");
        ReadableArray r13 = r18.getArray("circles");
        if (r13 != null) goto L16;
    L49:
        if (r19 == null) goto L62;
        r19.invoke(new Object[]{4, "Invalid parameter 'circles': expected array"});
        return;
    L62:
        return;
    L16:
        if (r13.size() == 0) goto L49;
        int r14 = 0;
        int r15 = 0;
    L20:
        if (r15 >= r13.size()) goto L46;
        ReadableMap r5 = r13.getMap(r15);
        if (r5 != null) goto L24;
    L23:
        r15 = r15;
    L45:
        r15 = r15 + 1;
        r14 = 0;
        goto L20
    L24:
        String r10 = r5.getString("id");
        if (r12 != 1) goto L27;
        deleteCircle(r10);
        goto L23
    L27:
        ReadableArray r11 = r5.getArray("points");
        if (r11 == null) goto L23;
        if (r11.size() == 0) goto L23;
        if (r11.getArray(r14) == null) goto L23;
        if (r11.getArray(r14).size() < 2) goto L23;
        BDLatLng r16 = new BDLatLng(r11.getArray(r14).getDouble(1), r11.getArray(r14).getDouble(r14));
        double r17 = r5.getDouble("radius");
        ReadableMap r20 = r5.getMap("extra");
        int r21 = Color.argb(r14, 255, 255, 255);
        int r22 = Color.argb(255, r14, r14, r14);
        if (r20 == null) goto L40;
        r21 = rgba2argb((int) r20.getLong("fill_color", argb2rgba(Color.argb(r14, 255, 255, 255))));
        int r23 = rgba2argb((int) r20.getLong("stroke_color", argb2rgba(Color.argb(255, r14, r14, r14))));
        int r24 = (int) r20.getLong("line_width", 10);
        float r110 = (float) r20.getDouble("alpha", 1.0d);
        int r25 = r23;
        int r111 = r24;
    L39:
        int r26 = r21;
        if (r12 != 0) goto L43;
        addCircle(r10, r16, r17, r26, r25, r111, r110);
        goto L45
    L43:
        if (r12 != 2) goto L45;
        updateCircle(r10, r16, r17, r26, r25, r111, r110);
        goto L45
    L40:
        r111 = 10;
        r110 = 1.0f;
        r25 = r22;
        goto L39
    L46:
        if (r19 == null) goto L61;
        r19.invoke(new Object[]{0});
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.bytedance.lynx.map.ng.LynxMapView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1, types: [com.bytedance.lynx.map.ng.LynxMapView] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r14v3, types: [com.lynx.react.bridge.ReadableMap] */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.lynx.react.bridge.ReadableArray] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.bytedance.lynx.map.ng.LynxMapView] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.lynx.react.bridge.ReadableArray] */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v3, types: [boolean] */
    @f0
    public void updateLines(ReadableMap r23, Callback r24) {
        ?? r12 = this;
        Callback r13 = r24;
        int r14 = 2;
        if (r12.mMapClient != null) goto L9;
        if (r13 == null) goto L6;
        r13.invoke(new Object[]{7, "map is not loaded!"});
    L6:
        LynxLog.b(2, TAG, "updateLines and mMapClient is null");
        return;
    L9:
        if (r23 == null) goto L58;
        if (r23.size() == 0) goto L58;
        LynxLog.b(2, TAG, "updateLines" + r12);
        int r15 = r23.getInt("type");
        ReadableArray r11 = r23.getArray("lines");
        if (r11 == null) goto L55;
        if (r11.size() == 0) goto L55;
        ?? r10 = 0;
        int r16 = 0;
        ?? r17 = r12;
    L20:
        if (r16 >= r11.size()) goto L51;
        ReadableMap r18 = r11.getMap(r16);
        if (r18 != null) goto L24;
    L23:
        int r19 = r15;
    L50:
        r16 = r16 + 1;
        r17 = this;
        r13 = r24;
        r15 = r19;
        r10 = r10;
        r11 = r11;
        r14 = 2;
        goto L20
    L24:
        String r5 = r18.getString("id");
        int r20 = 1;
        if (r15 != 1) goto L27;
        r17.deleteLine(r5);
        goto L23
    L27:
        ReadableArray r21 = r18.getArray("points");
        if (r21 == null) goto L23;
        if (r21.size() == 0) goto L23;
        ArrayList r22 = new ArrayList();
        ?? r25 = r10;
        ?? r26 = r21;
    L34:
        if (r25 >= r26.size()) goto L42;
        ?? r27 = r26.getArray(r25);
        if (r27 == 0) goto L41;
        if (r27.size() < r14) goto L41;
        r22.add(new BDLatLng(r27.getDouble(r20), r27.getDouble(r10)));
    L41:
        r26 = r26;
        r15 = r15;
        r20 = 1;
        r14 = 2;
        r25 = r25 + 1;
        goto L34
    L42:
        r19 = r15;
        float r28 = (float) r18.getDouble("zIndex");
        ?? r110 = r18.getMap("extra");
        if (r110 == 0) goto L45;
        int r29 = r17.rgba2argb((int) r110.getLong("stroke_color", r17.argb2rgba(Color.argb(255, 255, r10, r10))));
        int r30 = r17.dp2px((float) r110.getDouble("line_width", r17.px2dp(10.0f)));
        int r31 = r30;
        float r111 = (float) r110.getDouble("alpha", 1.0d);
        ?? r112 = r110.getBoolean("isDottedLine", r10);
        int r32 = r29;
    L46:
        ReadableMap r33 = r18.getMap("texture");
        if (r33 == null) goto L49;
        MapImageLoader.a(r17.getImageOptions(r33.getString("imageUrl"), r33.getMap("imageSize")), new mf.f(this, r19, r5, r22, r28, r32, r31, r111, r112, r18, r110));
        goto L50
    L49:
        updatePolyline(r19, r5, r22, r28, r32, r31, r111, r112, null, r18, r110);
        goto L50
    L45:
        r32 = Color.argb(255, 255, r10, r10);
        r31 = 10;
        r111 = 1.0f;
        r112 = r10;
        goto L46
    L51:
        ?? r210 = r10;
        Callback r34 = r13;
        if (r34 == null) goto L69;
        r34.invoke(new Object[]{Integer.valueOf(r210 == true ? 1 : 0)});
        return;
    L69:
        return;
    L55:
        if (r13 == null) goto L70;
        r13.invoke(new Object[]{4, "Invalid parameter 'lines': expected array"});
        return;
    L70:
        return;
    L58:
        if (r13 == null) goto L60;
        r13.invoke(new Object[]{4, "Missing required parameter: lines"});
    L60:
        LynxLog.b(2, TAG, "updateLines and mapDataItem is null");
    }

    @f0
    public void updatePolygons(ReadableMap r14, Callback r15) {
        if (this.mMapClient != null) goto L8;
        if (r15 == null) goto L51;
        r15.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L51:
        return;
    L8:
        if (r14 != null) goto L10;
    L42:
        if (r15 == null) goto L54;
        r15.invoke(new Object[]{4, "Missing required parameter: polygons"});
        return;
    L54:
        return;
    L10:
        if (r14.size() == 0) goto L42;
        LynxLog.b(2, TAG, "updatePolygons" + this);
        int r5 = r14.getInt("type");
        ReadableArray r16 = r14.getArray("polygons");
        if (r16 != null) goto L15;
    L39:
        if (r15 == null) goto L53;
        r15.invoke(new Object[]{4, "Invalid parameter 'polygons': expected array"});
        return;
    L53:
        return;
    L15:
        if (r16.size() == 0) goto L39;
        int r10 = 0;
    L19:
        if (r10 >= r16.size()) goto L36;
        ReadableMap r11 = r16.getMap(r10);
        if (r11 == null) goto L35;
        String r12 = r11.getString("id");
        if (r5 != 1) goto L26;
        deletePolygon(r12);
        goto L35
    L26:
        List<BDLatLng> r13 = getLatLngList(r11.getArray("points"));
        ReadableMap r17 = r11.getMap("extra");
        int r18 = Color.argb(0, 255, 255, 255);
        int r19 = Color.argb(255, 0, 0, 0);
        if (r17 == null) goto L30;
        r18 = rgba2argb((int) r17.getLong("fill_color", argb2rgba(Color.argb(0, 255, 255, 255))));
        int r20 = rgba2argb((int) r17.getLong("stroke_color", argb2rgba(Color.argb(255, 0, 0, 0))));
        int r21 = (int) r17.getLong("line_width", 10);
        float r110 = (float) r17.getDouble("alpha", 1.0d);
        int r111 = r20;
        int r112 = r21;
    L29:
        int r22 = r18;
        if (r5 != 0) goto L33;
        addPolygon(r12, r13, r22, r111, r112, r110);
        goto L35
    L33:
        if (r5 != 2) goto L35;
        updatePolygon(r12, r13, r22, r111, r112, r110);
        goto L35
    L30:
        r112 = 10;
        r110 = 1.0f;
        r111 = r19;
    L35:
        r10 = r10 + 1;
        goto L19
    L36:
        if (r15 == null) goto L52;
        r15.invoke(new Object[]{0});
        return;
    }

    public LynxMapView(LynxContext r5, Object r10) {
        super(r5, r10);
        this.mModuleStatus = 0;
        this.mEnableMapLoadEvent = false;
        this.mEnableViewDrawEvent = false;
        this.mEnableZoomChangeEvent = false;
        this.mEnableMarkerSelectEvent = false;
        this.mEnableMarkerUnselectEvent = false;
        this.mEnableRegionChangeEvent = false;
        this.mEnableMoveByUserEvent = false;
        this.mEnableZoomByUserEvent = false;
        this.mEnableSingleTapAtMap = false;
        this.mEnableOnEditStart = false;
        this.mEnableOnEdit = false;
        this.mEnableOnEditEnd = false;
        this.mIsCameraLoad = false;
        this.mIsBindViewDraw = false;
        this.mIsBindZoomChange = false;
        this.mIsBindSelectAnnotation = false;
        this.mNeedUserLocationHeading = false;
        this.mEnableCollision = false;
        this.mCollisionPercent = 0.0f;
        this.mIsTouchByUser = false;
        this.mIsChangeByZoom = false;
        this.mLatLngMap = new ConcurrentHashMap();
        this.mMarkerMap = new ConcurrentHashMap();
        this.mTextMarkerMap = new ConcurrentHashMap();
        this.mPolylineMap = new ConcurrentHashMap();
        this.mCircleMap = new ConcurrentHashMap();
        this.mPolygonMap = new ConcurrentHashMap();
        this.mCollisionTextModels = new CopyOnWriteArrayList();
        this.mCollisionMarkerMap = new ConcurrentHashMap();
        this.mFirstRender = true;
        this.mSensorHelper = new SensorEventHelper(r5);
        g r11 = new g();
        this.mLifecycleNotification = r11;
        monitor-enter(MapLifecycleObserver.class);
        MapLifecycleObserver.d.add(r11);     // Catch: Throwable -> L8
        monitor-exit(MapLifecycleObserver.class);     // Catch: Throwable -> L8
        MapLifecycleObserver.b();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public LinearLayout createView(Context r10) {
        LynxLog.b(2, TAG, "createView");
        LinearLayout r5 = new LinearLayout(r10);
        if ((r10 instanceof LynxContext) == false) goto L7;
        u0 r11 = ((LynxContext) r10).K;
        if (r11 == null) goto L7;
        int r12 = r11.K;
    L8:
        MapInitConfig.Builder r13 = new MapInitConfig.Builder(r10);
        r13.f6869b = r12;
        if (r10 == null) goto L36;
        BDMapClient r14 = new BDMapClient(new MapInitConfig(r13));
        this.mMapClient = r14;
        IMapService r15 = r14.f6862a;
        if (r15 == null) goto L14;
        r15.onStart();
    L14:
        IMapService r16 = this.mMapClient.f6862a;
        if (r16 == null) goto L18;
        r16.attachToParentView(r5);
    L18:
        IMapService r17 = this.mMapClient.f6862a;
        if (r17 == null) goto L22;
        r17.setMyLocationButtonEnabled(false);
    L22:
        IMapService r18 = this.mMapClient.f6862a;
        if (r18 == null) goto L26;
        r18.addMapActionListener(this);
    L26:
        IMapService r19 = this.mMapClient.f6862a;
        if (r19 == null) goto L30;
        r19.addMarkerActionListener(this);
    L30:
        EditHandler r20 = this.mMapClient.f6863b;
        if (r20 != null) goto L33;
        return r5;
    L33:
        r20.f6887c = this;
        return r5;
    L36:
        throw new IllegalArgumentException("Context is empty!");
    L7:
        r12 = 0;
        goto L8
    }

    @f0
    public void setCenterAndZoom(ReadableMap r16, Callback r17) {
        if (this.mMapClient != null) goto L8;
        if (r17 == null) goto L42;
        r17.invoke(new Object[]{7, "map is not loaded!"});
        return;
    L42:
        return;
    L8:
        if (r16 != null) goto L10;
    L39:
        if (r17 == null) goto L45;
        r17.invoke(new Object[]{4, "Missing required parameter: center and zoom"});
        return;
    L45:
        return;
    L10:
        if (r16.size() == 0) goto L39;
        ReadableArray r5 = r16.getArray("center");
        if (r5 != null) goto L15;
    L36:
        if (r17 == null) goto L44;
        r17.invoke(new Object[]{4, "Invalid parameter 'center': expected array [lng, lat]"});
        return;
    L44:
        return;
    L15:
        if (r5.size() == 0) goto L36;
        BDLatLng r10 = new BDLatLng(r5.getDouble(1), r5.getDouble(0));
        IMapService r11 = this.mMapClient.f6862a;
        if (r11 != null) goto L20;
        float r12 = 0.0f;
    L21:
        float r13 = (float) r16.getDouble("zoom", r12);
        boolean r14 = r16.getBoolean("isanimate", true);
        double r15 = r16.getDouble("duration", 0.0d);
        ReadableArray r18 = r16.getArray("padding");
        if (r18 != null) goto L24;
    L30:
        int r19 = (int) r15;
        IMapService r20 = this.mMapClient.f6862a;
        if (r20 == null) goto L33;
        r20.setCenterAndZoom(r10, r13, r14, r19);
    L33:
        if (r17 == null) goto L43;
        r17.invoke(new Object[]{0});
        return;
    L43:
        return;
    L24:
        if (r18.size() <= 3) goto L30;
        float r21 = (float) r18.getDouble(0);
        float r22 = (float) r18.getDouble(1);
        float r23 = (float) r18.getDouble(2);
        float r110 = (float) r18.getDouble(3);
        BDMapClient r111 = this.mMapClient;
        BDLatLng r24 = getTargetCenter(r10, r13, r21, r22, r23, r110);
        int r25 = (int) r15;
        IMapService r26 = r111.f6862a;
        if (r26 == null) goto L33;
        if (r24 == null) goto L33;
        r26.setCenterAndZoom(r24, r13, r14, r25);
        goto L33
    L20:
        r12 = r11.getZoom();
        goto L21
    }

    @Override // mf.a
    public void startMarkerAnimation(IMarker r5, List<AnimationStyle> r10) {
        IMapService r11 = this.mMapClient.f6862a;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.startMarkerAnimation(r5, r10);
    }

    @Override // mf.a
    public IMarker addMarker(BDMarkerOptions r5, boolean r10) {
        IMapService r11 = this.mMapClient.f6862a;
        if (r11 != null) goto L5;
        IMarker r12 = null;
    L6:
        this.mMarkerMap.put(((AliMarker) r12).f3094b, r12);
        if (r10 == false) goto L11;
        SensorEventHelper r13 = this.mSensorHelper;
        if (r13 == null) goto L11;
        r13.f = r12;
    L11:
        return r12;
    L5:
        r12 = r11.addMarker(r5);
        goto L6
    }
}
