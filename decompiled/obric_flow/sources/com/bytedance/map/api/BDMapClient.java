package com.bytedance.map.api;

import android.content.Context;
import android.graphics.Point;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.bytedance.amap.model.AliMarker;
import com.bytedance.amap.model.AliPolygon;
import com.bytedance.lynx.map.ng.LynxMapView;
import com.bytedance.map.api.edit.EditHandler;
import com.bytedance.map.api.listener.MapActionListener;
import com.bytedance.map.api.listener.MarkerActionListener;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.IMarker;
import com.bytedance.map.api.monitor.MapMonitorUtil;
import com.bytedance.map.api.plugin.MapPluginManager;
import com.bytedance.map.api.service.MapInstanceManager;
import com.bytedance.map.api.utils.CommonUtil;
import com.obric.launcher.widget.R$layout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class BDMapClient implements MapActionListener, MarkerActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IMapService f6862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EditHandler f6863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6864c;

    public BDMapClient(MapInitConfig r10) {
        Context r5 = r10.f6865a;
        new MapPluginManager(r5);
        int r11 = r10.f6866b;
        MapInstanceManager r12 = new MapInstanceManager(r5);
        if (r11 != 0) goto L5;
        r12.f6939b = MapInstanceManager.a("com.bytedance.amap2d.AMap2DServiceImpl");
    L10:
        if (r12.f6939b != null) goto L13;
        r12.f6939b = MapInstanceManager.a("com.bytedance.gmap.GMapServiceImpl");
    L13:
        if (r12.f6939b != null) goto L15;
        r12.f6939b = MapInstanceManager.a("com.bytedance.amap2d.AMap2DServiceImpl");
    L15:
        IMapService r13 = r12.f6939b;
        if (r13 != null) goto L18;
    L19:
        r12.f6939b = MapInstanceManager.a("com.bytedance.gmap_static.GMapStaticServiceImpl");
    L20:
        IMapService r14 = r12.f6939b;
        this.f6862a = r14;
        this.f6863b = new EditHandler(r5, this);
        if (r14 == null) goto L24;
        this.f6864c = SystemClock.elapsedRealtime();
        r14.initMap(r10);
        r14.addMapActionListener(this);
        r14.addMarkerActionListener(this);
        return;
    L24:
        return;
    L18:
        if (r13.isAvailable(r5) == true) goto L20;
    L5:
        if (r11 != 1) goto L10;
        r12.f6939b = MapInstanceManager.a("com.bytedance.amap.AMapServiceImpl");
        goto L10
    }

    public final BDLatLng a() {
        IMapService r5 = this.f6862a;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getCenter();
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public final void onMapClick(BDLatLng r5) {
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public final void onMapLoad() {
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public final void onMapMove(BDLatLng r5) {
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public final void onMapMoveEnd(BDLatLng r5) {
        MapMonitorUtil.a("user_move_map", null, null);
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public final void onMapTouch(MotionEvent r14) {
        EditHandler r13 = this.f6863b;
        if (r13 == null) goto L92;
        monitor-enter(r13);
    L25:
        th = move-exception;
        throw th;
    L6:
        if (r13.f6896p == null) goto L88;
        Log.i("EditHandler ", "action is " + r14.getAction() + " and hasmoved is " + r13.f6892l);     // Catch: Throwable -> L25
        int r5 = r14.getAction();     // Catch: Throwable -> L25
        if (r5 != 0) goto L11;
        r13.f6888h = (int) r14.getX();     // Catch: Throwable -> L25
        int r15 = (int) r14.getY();     // Catch: Throwable -> L25
        r13.f6889i = r15;     // Catch: Throwable -> L25
        int r10 = r13.f6888h;     // Catch: Throwable -> L25
        r13.f6898r.clear();     // Catch: Throwable -> L25
        int r11 = 0;
    L70:
        if (r11 >= r13.f6897q.size()) goto L79;
        BDMapClient r12 = r13.f6886b;     // Catch: Throwable -> L25
        BDLatLng r16 = (BDLatLng) r13.f6897q.get(r11);     // Catch: Throwable -> L25
        IMapService r17 = r12.f6862a;     // Catch: Throwable -> L25
        if (r17 != null) goto L74;
        Point r18 = null;
    L75:
        if (r18 == null) goto L78;
        float r19 = r18.x;     // Catch: Throwable -> L25
        float r20 = r18.y;     // Catch: Throwable -> L25
        r13.f6898r.put(Integer.valueOf(r11), Integer.valueOf((int) Math.sqrt(Math.pow(r15 - r20, 2.0d) + Math.pow(r10 - r19, 2.0d))));     // Catch: Throwable -> L25
    L78:
        r11 = r11 + 1;     // Catch: Throwable -> L25
        goto L70
    L74:
        r18 = r17.transLatLngToPoint(r16);     // Catch: Throwable -> L25
        goto L75
    L79:
        int[] r110 = CommonUtil.a(r13.f6898r);     // Catch: Throwable -> L25
        Log.i("EditHandler", String.valueOf(r110[1]));     // Catch: Throwable -> L25
        if (r110[1] >= EditHandler.f6884t) goto L88;
        r13.f6892l = true;     // Catch: Throwable -> L25
        IMapService r21 = r13.f6886b.f6862a;     // Catch: Throwable -> L25
        if (r21 == null) goto L85;
        r21.setAllGesturesEnabled(false);     // Catch: Throwable -> L25
    L85:
        int r111 = r110[0];     // Catch: Throwable -> L25
        r13.f6894n = r111;     // Catch: Throwable -> L25
        r13.f6895o = ((BDLatLng) r13.f6897q.get(r111)).f6919c;     // Catch: Throwable -> L25
    L86:
        monitor-exit(r13);     // Catch: Throwable -> L25
        return;
    L11:
        if (r5 == 1) goto L46;
        if (r5 != 2) goto L88;
        r13.f6890j = (int) r14.getX();     // Catch: Throwable -> L25
        int r112 = (int) r14.getY();     // Catch: Throwable -> L25
        r13.f6891k = r112;     // Catch: Throwable -> L25
        int r22 = r13.f6888h;     // Catch: Throwable -> L25
        int r23 = r13.f6889i;     // Catch: Throwable -> L25
        int r24 = r13.f6890j;     // Catch: Throwable -> L25
        if (r13.f6893m == false) goto L19;
    L28:
        if (r13.f6892l == false) goto L88;
        if (r13.f6893m == false) goto L88;
        Log.i("EditHandler ", "has moved and position is " + r13.f6894n);     // Catch: Throwable -> L25
        if (r13.f6894n == (-1)) goto L88;
        int r113 = r13.f6890j;     // Catch: Throwable -> L25
        int r25 = r13.f6891k;     // Catch: Throwable -> L25
        Log.i("EditHandler ", "handleMoveEvent");     // Catch: Throwable -> L25
        BDMapClient r26 = r13.f6886b;     // Catch: Throwable -> L25
        Point r27 = new Point(r113, r25);     // Catch: Throwable -> L25
        IMapService r114 = r26.f6862a;     // Catch: Throwable -> L25
        if (r114 != null) goto L37;
        BDLatLng r115 = null;
    L39:
        if (r13.f6895o == false) goto L41;
        r13.a(r115);     // Catch: Throwable -> L25
    L42:
        LynxMapView r116 = r13.f6887c;     // Catch: Throwable -> L25
        if (r116 == null) goto L88;
        r116.onEdit(r13.f6896p);     // Catch: Throwable -> L25
        goto L86
    L41:
        BDLatLng r28 = r13.a((BDLatLng) r13.f6897q.get(r13.f6894n - 1), r115);     // Catch: Throwable -> L25
        r13.s.add(r13.f6894n, r13.a(r28, LayoutInflater.from(r13.f6885a).inflate(R$layout.map_small_point_marker_layout, null)));     // Catch: Throwable -> L25
        r13.f6897q.add(r13.f6894n, new BDLatLng(r28, false));     // Catch: Throwable -> L25
        ((AliMarker) ((IMarker) r13.s.get(r13.f6894n + 1))).a();     // Catch: Throwable -> L25
        r13.s.remove(r13.f6894n + 1);     // Catch: Throwable -> L25
        r13.f6897q.remove(r13.f6894n + 1);     // Catch: Throwable -> L25
        r13.s.add(r13.f6894n + 1, r13.a(r115, LayoutInflater.from(r13.f6885a).inflate(R$layout.map_big_point_marker_layout, null)));     // Catch: Throwable -> L25
        r13.f6897q.add(r13.f6894n + 1, new BDLatLng(r115, true));     // Catch: Throwable -> L25
        BDLatLng r29 = r13.a((BDLatLng) r13.f6897q.get((r13.f6894n + 2) % r13.f6897q.size()), r115);     // Catch: Throwable -> L25
        r13.s.add(r13.f6894n + 2, r13.a(r29, LayoutInflater.from(r13.f6885a).inflate(R$layout.map_small_point_marker_layout, null)));     // Catch: Throwable -> L25
        r13.f6897q.add(r13.f6894n + 2, new BDLatLng(r29, false));     // Catch: Throwable -> L25
        r13.f6895o = true;     // Catch: Throwable -> L25
        r13.f6894n++;     // Catch: Throwable -> L25
        r13.a(r115);     // Catch: Throwable -> L25
        goto L42
    L37:
        r115 = r114.transPointToLatLng(r27);     // Catch: Throwable -> L25
        goto L39
    L19:
        if (((int) Math.sqrt(Math.pow(r23 - r112, 2.0d) + Math.pow(r22 - r24, 2.0d))) <= ((int) ((r13.f6885a.getResources().getDisplayMetrics().density * 5.0f) + 0.5f))) goto L28;
        r13.f6893m = true;     // Catch: Throwable -> L25
        if (r13.f6892l == false) goto L28;
        LynxMapView r117 = r13.f6887c;     // Catch: Throwable -> L25
        if (r117 == null) goto L28;
        r117.onEditStart(r13.f6896p);     // Catch: Throwable -> L25
        goto L28
    L46:
        if (r13.f6892l == true) goto L48;
    L52:
        r13.f6892l = false;     // Catch: Throwable -> L25
        r13.f6893m = false;     // Catch: Throwable -> L25
        r13.f6895o = false;     // Catch: Throwable -> L25
        r13.f6894n = -1;     // Catch: Throwable -> L25
        BDMapClient r118 = r13.f6886b;     // Catch: Throwable -> L25
        boolean r30 = r13.d;     // Catch: Throwable -> L25
        IMapService r119 = r118.f6862a;     // Catch: Throwable -> L25
        if (r119 == null) goto L56;
        r119.setRotateGesturesEnabled(r30);     // Catch: Throwable -> L25
    L56:
        BDMapClient r120 = r13.f6886b;     // Catch: Throwable -> L25
        boolean r31 = r13.f;     // Catch: Throwable -> L25
        IMapService r121 = r120.f6862a;     // Catch: Throwable -> L25
        if (r121 == null) goto L60;
        r121.setScrollGesturesEnabled(r31);     // Catch: Throwable -> L25
    L60:
        BDMapClient r122 = r13.f6886b;     // Catch: Throwable -> L25
        boolean r32 = r13.e;     // Catch: Throwable -> L25
        IMapService r123 = r122.f6862a;     // Catch: Throwable -> L25
        if (r123 == null) goto L64;
        r123.setZoomGesturesEnabled(r32);     // Catch: Throwable -> L25
    L64:
        BDMapClient r124 = r13.f6886b;     // Catch: Throwable -> L25
        boolean r33 = r13.g;     // Catch: Throwable -> L25
        IMapService r125 = r124.f6862a;     // Catch: Throwable -> L25
        if (r125 == null) goto L88;
        r125.setTiltGesturesEnabled(r33);     // Catch: Throwable -> L25
        goto L86
    L48:
        if (r13.f6893m == false) goto L52;
        LynxMapView r126 = r13.f6887c;     // Catch: Throwable -> L25
        if (r126 == null) goto L52;
        r126.onEditEnd(r13.f6896p);     // Catch: Throwable -> L25
    L88:
        monitor-exit(r13);
        return;
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public final void onMapZoom(float r5) {
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public final void onMapZoomEnd(float r5) {
        MapMonitorUtil.a("user_zoom_map", null, null);
    }

    @Override // com.bytedance.map.api.listener.MarkerActionListener
    public final void onMarkerClick(IMarker r10) {
        MapMonitorUtil.a("user_tap_annotation", null, null);
        EditHandler r11 = this.f6863b;
        if (r11 == null) goto L43;
        monitor-enter(r11);
        Log.i("EditHandler ", "onPointClick");     // Catch: Throwable -> L15
        if (r10 == null) goto L26;
        int r5 = 0;
        int r12 = 0;
    L10:
        if (r12 >= r11.s.size()) goto L17;
        if (r10.equals(r11.s.get(r12)) == true) goto L18;
        r12 = r12 + 1;     // Catch: Throwable -> L15
    L18:
        if (r12 == (-1)) goto L26;
        if (((BDLatLng) r11.f6897q.get(r12)).f6919c == false) goto L26;
        if (r11.f6897q.size() <= 6) goto L26;
        if (r12 != 0) goto L30;
        ArrayList r13 = r11.f6897q;     // Catch: Throwable -> L15
        BDLatLng r14 = r11.a((BDLatLng) r13.get(r13.size() - 2), (BDLatLng) r11.f6897q.get(2));     // Catch: Throwable -> L15
        ArrayList r15 = r11.s;     // Catch: Throwable -> L15
        ((AliMarker) ((IMarker) r15.get(r15.size() - 1))).a();     // Catch: Throwable -> L15
        ((AliMarker) ((IMarker) r11.s.get(1))).a();     // Catch: Throwable -> L15
        ((AliMarker) ((IMarker) r11.s.get(0))).a();     // Catch: Throwable -> L15
        ArrayList r16 = r11.s;     // Catch: Throwable -> L15
        r16.remove(r16.size() - 1);     // Catch: Throwable -> L15
        r11.s.remove(1);     // Catch: Throwable -> L15
        r11.s.remove(0);     // Catch: Throwable -> L15
        ArrayList r17 = r11.f6897q;     // Catch: Throwable -> L15
        r17.remove(r17.size() - 1);     // Catch: Throwable -> L15
        r11.f6897q.remove(1);     // Catch: Throwable -> L15
        r11.f6897q.remove(0);     // Catch: Throwable -> L15
        r11.s.add(r11.a(r14, LayoutInflater.from(r11.f6885a).inflate(R$layout.map_small_point_marker_layout, null)));     // Catch: Throwable -> L15
        r11.f6897q.add(new BDLatLng(r14, false));     // Catch: Throwable -> L15
    L32:
        if (r11.f6896p == null) goto L39;
        ArrayList r18 = new ArrayList();     // Catch: Throwable -> L15
    L36:
        if (r5 >= r11.f6897q.size()) goto L38;
        r18.add(r11.f6897q.get(r5));     // Catch: Throwable -> L15
        r5 = r5 + 2;     // Catch: Throwable -> L15
        goto L36
    L38:
        ((AliPolygon) r11.f6896p).a(r18);     // Catch: Throwable -> L15
    L39:
        monitor-exit(r11);     // Catch: Throwable -> L15
        return;
    L30:
        BDLatLng r19 = (BDLatLng) r11.f6897q.get(r12 - 2);     // Catch: Throwable -> L15
        ArrayList r20 = r11.f6897q;     // Catch: Throwable -> L15
        BDLatLng r21 = r11.a(r19, (BDLatLng) r20.get((r12 + 2) % r20.size()));     // Catch: Throwable -> L15
        int r22 = r12 + 1;     // Catch: Throwable -> L15
        ((AliMarker) ((IMarker) r11.s.get(r22))).a();     // Catch: Throwable -> L15
        ((AliMarker) ((IMarker) r11.s.get(r12))).a();     // Catch: Throwable -> L15
        int r23 = r12 - 1;     // Catch: Throwable -> L15
        ((AliMarker) ((IMarker) r11.s.get(r23))).a();     // Catch: Throwable -> L15
        r11.s.remove(r22);     // Catch: Throwable -> L15
        r11.s.remove(r12);     // Catch: Throwable -> L15
        r11.s.remove(r23);     // Catch: Throwable -> L15
        r11.f6897q.remove(r22);     // Catch: Throwable -> L15
        r11.f6897q.remove(r12);     // Catch: Throwable -> L15
        r11.f6897q.remove(r23);     // Catch: Throwable -> L15
        r11.s.add(r23, r11.a(r21, LayoutInflater.from(r11.f6885a).inflate(R$layout.map_small_point_marker_layout, null)));     // Catch: Throwable -> L15
        r11.f6897q.add(r23, new BDLatLng(r21, false));     // Catch: Throwable -> L15
        goto L32
    L17:
        r12 = -1;
    L26:
        monitor-exit(r11);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
