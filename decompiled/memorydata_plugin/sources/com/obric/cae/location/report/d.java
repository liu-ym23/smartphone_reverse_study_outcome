package com.obric.cae.location.report;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f7277a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f7278b = false;
    public static volatile boolean c = false;
    public static volatile com.obric.cae.libs.cldReport.b d;
    public static int e;
    public static final ArrayList f = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7280b;
        public final String c;
        public final boolean d;

        public a(String r1, String r2, String r3, boolean r4) {
            this.f7279a = r1;
            this.f7280b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
        f7277a = new Object();
        f = new ArrayList();
    }

    public static String a(double r1) {
        if (Double.isNaN(r1) == false) goto L7;
        return "";
    L7:
        return Double.toString(r1);
    }

    public static void a() {
        Object r0 = f7277a;
        monitor-enter(r0);
        c = false;     // Catch: Throwable -> L8
        f.clear();     // Catch: Throwable -> L8
        e = 0;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void a(int r1, com.obric.cae.location.geosdk.bytedance.a.AbstractC0355a r2, com.obric.cae.location.geosdk.bytedance.a.b r3, long r4, long r6, String r8) {
        a("star_location_direction_search", b(r1, r2, r3, r4, r6, r8));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-TeaReporter", "failed", e);
    }

    public static void a(int r11, String r12) {
        if (com.obric.cae.location.util.d.a().l() == true) goto L6;
        com.obric.cae.log.a.d("StarLocation-TeaReporter", "skipped CLD event while mock location is allowed, errCode=" + r11);
        return;
    L6:
        com.obric.cae.log.a.f("StarLocation-TeaReporter", com.obric.cae.libs.statemachine.d.a("reportErrorEvent start, moduleType=3, errCode=", r11, ", reason=0, subReason=0, infoLength=").append(r12.length()).toString());
        com.obric.cae.libs.cldReport.b r1 = d;
        if (r1 == null) goto L10;
        com.obric.cae.log.a.f("StarLocation-TeaReporter", "use cached cld report service");
    L9:
        com.obric.cae.libs.cldReport.b r4 = r1;
    L22:
        if (r4 != null) goto L32;
        com.obric.cae.log.a.h("StarLocation-TeaReporter", "reportErrorEvent skipped, cld report manager is null, moduleType=3, errCode=" + r11);
        return;
    L32:
        com.obric.cae.log.a.f("StarLocation-TeaReporter", "call cld report service, moduleType=3, errCode=" + r11);     // Catch: RemoteException -> L27
        r4.a(3, r11, 0, 0, r12);     // Catch: RemoteException -> L27
        com.obric.cae.log.a.f("StarLocation-TeaReporter", "reportErrorEvent success, moduleType=3, errCode=" + r11);     // Catch: RemoteException -> L27
        return;
    L27:
        e = move-exception;
        d = null;
        com.obric.cae.log.a.b("StarLocation-TeaReporter", "reportErrorEvent error", e);
        return;
    L10:
        com.obric.cae.log.a.f("StarLocation-TeaReporter", "get cld report service start");
        IBinder r5 = ServiceManager.getService("cae_cld_report");
        int r6 = 0;
    L11:
        if (r5 != null) goto L18;
        if (r6 >= 10) goto L18;
        r6 = r6 + 1;
        com.obric.cae.log.a.f("StarLocation-TeaReporter", "cld report service is unavailable, retry=" + r6);
        Thread.sleep(1000);     // Catch: InterruptedException -> L17
        r5 = ServiceManager.getService("cae_cld_report");
    L17:
        Thread.currentThread().interrupt();
        String r2 = "get cld report service interrupted";
    L20:
        com.obric.cae.log.a.h("StarLocation-TeaReporter", r2);
        r4 = null;
    L18:
        if (r5 != null) goto L21;
        r2 = "cld report service is unavailable after retry";
        goto L20
    L21:
        com.obric.cae.log.a.f("StarLocation-TeaReporter", "get cld report service success, retryCount=" + r6);
        r1 = com.obric.cae.libs.cldReport.b.a.a(r5);
        d = r1;
        goto L9
    }

    public static void a(long r2, Location r4, String r5, int r6, int r7, StarGeofence.GeoEvent r8, float r9, boolean r10) {
        if (r4 == null) goto L11;
        if (r8 == null) goto L11;
        a("star_location_geofence_breach", b(r2, r4, r5, r6, r7, r8, r9, r10));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-TeaReporter", "failed", e);
        return;
    L11:
        com.obric.cae.log.a.h("StarLocation-TeaReporter", "skipped, location or event is null");
    }

    public static void a(long r2, StarGeofence r4, int r5) {
        if (r4 != null) goto L11;
        com.obric.cae.log.a.h("StarLocation-TeaReporter", "skipped, starGeofence is null");
        return;
    L11:
        a("star_location_geofence_info", b(r2, r4, r5));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-TeaReporter", "failed", e);
    }

    public static void a(long r1, com.obric.cae.location.a.C0349a r3, long r4, com.obric.cae.location.a.C0349a r6, int r7) {
        a("star_location_flight_mode", b(r1, r3, r4, r6, r7));     // Catch: Exception -> L25
        if (r7 >= 100000) goto L6;
        com.obric.cae.log.a.f("StarLocation-TeaReporter", "trigger CLD report, errCode=5, distance=" + r7);     // Catch: Exception -> L25
        a(5, "flight_mode_distance_less_than_100km");     // Catch: Exception -> L25
    L6:
        ArrayList r2 = null;
        Object r5 = f7277a;     // Catch: Exception -> L25
        monitor-enter(r5);     // Catch: Exception -> L25
        if (r7 <= 100000) goto L10;
        boolean r8 = true;
    L28:
        c = r8;     // Catch: Throwable -> L22
        if (c == false) goto L14;
        r2 = new ArrayList(f);     // Catch: Throwable -> L22
    L14:
        f.clear();     // Catch: Throwable -> L22
        monitor-exit(r5);     // Catch: Throwable -> L22
        if (r2 == null) goto L32;
        Iterator r9 = r2.iterator();     // Catch: Exception -> L25
    L19:
        if (r9.hasNext() == false) goto L33;
        a((a) ZeusTransformUtils.preCheckCast(r9.next(), a.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L25
        goto L19
    L33:
        return;
    L32:
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: Exception -> L25
    L10:
        r8 = false;
    L25:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-TeaReporter", "failed", e);
    }

    public static void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        String r5 = "skipped, context is null";
    L5:
        com.obric.cae.log.a.h("StarLocation-TeaReporter", r5);
        return;
    L8:
        if (f7278b == true) goto L10;
    L12:
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Application.class) == true) goto L20;
        r5 = "skipped, application context is unavailable";
        goto L5
    L20:
        com.obric.cae.cloud.applog.b.a(r6, (Application) ZeusTransformUtils.preCheckCast(r6, Application.class, "com.obric.memorydata.plugin"), false);     // Catch: Exception -> L17
        f7278b = true;     // Catch: Exception -> L17
        com.obric.cae.log.a.d("StarLocation-TeaReporter", "TEA reporter initialized");     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-TeaReporter", "Failed to initialize TEA reporter", e);
        return;
    L10:
        if (com.obric.cae.cloud.applog.b.a() == false) goto L12;
    }

    public static void a(AoiBoard r5, boolean r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getType() == AoiBoard.Type.AIRPORT) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r5.getPoiId()) == false) goto L10;
        com.obric.cae.log.a.h("StarLocation-TeaReporter", "skipped, airport aoi is invalid");
        return;
    L10:
        a r0 = new a(r5.getPoiId(), r5.getPoiName(), r5.getType().name(), r6);
        Object r7 = f7277a;
        monitor-enter(r7);
        boolean r2 = true;
        if (r6 == false) goto L15;
        e = 0;     // Catch: Throwable -> L32
    L18:
        boolean r8 = false;
    L20:
        if (c == true) goto L25;
        ArrayList r3 = f;     // Catch: Throwable -> L32
        if (r3.size() >= 2) goto L24;
        r3.add(r0);     // Catch: Throwable -> L32
    L24:
        com.obric.cae.log.a.d("StarLocation-TeaReporter", "pending, flight mode distance gate is not satisfied");     // Catch: Throwable -> L32
        r2 = false;
    L25:
        monitor-exit(r7);     // Catch: Throwable -> L32
        if (r8 == false) goto L28;
        com.obric.cae.log.a.f("StarLocation-TeaReporter", "trigger CLD report, errCode=6, reason=airport outside twice");
        a(6, "location_aoi_board_breach");
    L28:
        if (r2 == true) goto L30;
        return;
    L30:
        a(r0);
        return;
    L15:
        int r9 = e + 1;     // Catch: Throwable -> L32
        e = r9;     // Catch: Throwable -> L32
        if (r9 < 2) goto L18;
        e = 0;     // Catch: Throwable -> L32
        r8 = true;
    L32:
        th = move-exception;
        throw th;
    }

    public static void a(com.obric.cae.location.a.C0349a r2) {
        if (r2 != null) goto L11;
        com.obric.cae.log.a.d("StarLocation-TeaReporter", "skipped, location source is null");
        return;
    L11:
        a("star_location_source", b(r2));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-TeaReporter", "failed", e);
    }

    public static void a(com.obric.cae.location.a.C0349a r3, com.obric.cae.location.a.C0349a r4, int r5, double r6) {
        if (r3 == null) goto L27;
        if (r4 == null) goto L27;
        float r1 = r3.g();
        if (r1 > 0.0f) goto L9;
    L24:
        String r7 = "skipped, location radius or distance is invalid";
    L25:
        com.obric.cae.log.a.d("StarLocation-TeaReporter", r7);
        return;
    L9:
        if (Float.isNaN(r1) == true) goto L24;
        if (Float.isInfinite(r1) == true) goto L24;
        if (r6 < 0.0d) goto L24;
        if (Double.isNaN(r6) == true) goto L24;
        if (Double.isInfinite(r6) == true) goto L24;
        a("star_location_nlp_error", b(r3, r4, r5, r6));     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-TeaReporter", "failed", e);
        return;
    L27:
        r7 = "skipped, location source is null";
        goto L25
    }

    public static void a(a r10) {
        boolean r1 = com.obric.cae.location.util.d.a().l();
        if (r1 == true) goto L21;
        com.obric.cae.log.a.d("StarLocation-TeaReporter", "skipped, forbidMockLocation=" + r1);
        return;
    L21:
        String r3 = r10.f7279a;     // Catch: Exception -> L18
        String r4 = r10.f7280b;     // Catch: Exception -> L18
        String r5 = r10.c;     // Catch: Exception -> L18
        boolean r6 = r10.d;     // Catch: Exception -> L18
        JSONObject r7 = b();     // Catch: Exception -> L18
        r7.put("version", 5);     // Catch: Exception -> L18
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        r7.put("poiId", r3);     // Catch: Exception -> L18
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        r7.put("aoiName", r4);     // Catch: Exception -> L18
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        r7.put("aoiType", r5);     // Catch: Exception -> L18
        r7.put("inside", r6);     // Catch: Exception -> L18
        a("star_location_airport_enter", r7);     // Catch: Exception -> L18
        com.obric.cae.log.a.d("StarLocation-TeaReporter", "reported airport enter, poiId=" + r10.f7279a + ", inside=" + r10.d);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-TeaReporter", "failed to report airport enter", e);
    }

    public static void a(String r4, String r5) {
        JSONObject r1 = b();     // Catch: Exception -> L11
        r1.put("version", 1);     // Catch: Exception -> L11
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        r1.put("poiId", r4);     // Catch: Exception -> L11
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        r1.put(ActivityLifecycle.NAME, r5);     // Catch: Exception -> L11
        a("star_location_aoi_missing", r1);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-TeaReporter", "failed", e);
    }

    public static void a(String r1, String r2, String r3, String r4, String r5, String r6, double r7) {
        a("star_location_indoor_check", b(r1, r2, r3, r4, r5, r6, r7));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-TeaReporter", "failed", e);
    }

    public static void a(String r3, JSONObject r4) {
        if (com.obric.cae.location.util.d.a().l() == true) goto L11;
        com.obric.cae.log.a.d("StarLocation-TeaReporter", "skipped TEA event while mock location is allowed: ".concat(r3));
        return;
    L11:
        com.obric.cae.cloud.applog.b.a(r3, r4);     // Catch: Exception -> L8
        com.obric.cae.log.a.d("StarLocation-TeaReporter", "Tracked TEA event: " + r3 + ", payloadLength=" + r4.toString().length());     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-TeaReporter", "Failed to track TEA event: ".concat(r3), e);
    }

    public static JSONObject b() {
        JSONObject r0 = new JSONObject();
        String r1 = MatrixDidUtils.getDid();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.put("device_id", r1);
        String r3 = com.obric.cae.location.util.d.f7299b;
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        r0.put("product_name", r2);
        return r0;
    }

    public static JSONObject b(int r3, com.obric.cae.location.geosdk.bytedance.a.AbstractC0355a r4, com.obric.cae.location.geosdk.bytedance.a.b r5, long r6, long r8, String r10) {
        JSONObject r0 = b();
        r0.put("version", 1);
        r0.put("directionType", r3);
        r0.put("totalCostMs", Math.max(0, r8 - r6));
        if (r4 == null) goto L6;
        String r7 = r4.k;
        if (r7 == null) goto L6;
    L7:
        r0.put("Logid", r7);
        if (r4 == null) goto L23;
        String r9 = r4.e;
        if (r9 != null) goto L13;
        r9 = "";
    L13:
        r0.put("requestCoordType", r9);
        String r11 = r4.f;
        if (r11 != null) goto L16;
        r11 = "";
    L16:
        r0.put("requestRetCoordType", r11);
        String r12 = r4.f7093a;
        if (r12 != null) goto L19;
        r12 = "";
    L19:
        r0.put("origin", r12);
        String r13 = r4.f7094b;
        if (r13 != null) goto L22;
        r13 = "";
    L22:
        r0.put("destination", r13);
    L23:
        if (r5 != null) goto L25;
        boolean r14 = false;
    L26:
        r0.put("success", r14);
        if (r14 == true) goto L37;
        if (r5 != null) goto L30;
    L34:
        if (r10 != null) goto L36;
    L35:
        r10 = "";
    L36:
        r0.put("failureReason", r10);
        goto L37
    L30:
        if (TextUtils.isEmpty(r5.f7124b) == true) goto L34;
        r10 = r5.f7124b;
        if (r10 != null) goto L36;
    L37:
        return r0;
    L25:
        r14 = r5.a();
    L6:
        r7 = "";
        goto L7
    }

    public static JSONObject b(long r3, Location r5, String r6, int r7, int r8, StarGeofence.GeoEvent r9, float r10, boolean r11) {
        JSONObject r0 = b();
        r0.put("version", 1);
        r0.put("timestamp", Long.toString(r3));
        r0.put("latitude", a(r5.getLatitude()));
        r0.put("longitude", a(r5.getLongitude()));
        r0.put("hAcc", r5.getAccuracy());
        String r4 = r5.getProvider();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.put("provider", r4);
        r0.put(AILabCheckPermissionTask.KEY_SOURCE, r7);
        r0.put("simCardStatus", r8);
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r0.put("geofenceId", r6);
        r0.put("breachEvent", r9.getValue());
        r0.put("responseRate", r10);
        r0.put("firstBreach", r11);
        return r0;
    }

    public static JSONObject b(long r5, StarGeofence r7, int r8) {
        JSONObject r0 = b();
        r0.put("version", 1);
        String r1 = r7.getGeofenceId();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.put("geofenceId", r1);
        String r3 = r7.getPackageName();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r3);
        r0.put("latitude", a(r7.getLatitude()));
        r0.put("longitude", a(r7.getLongitude()));
        r0.put("radius", r7.getRadius());
        r0.put("transitionType", r7.getTransitionType().getValue());
        r0.put("confidence", r7.getConfidence().getValue());
        r0.put("geoState", r7.getGeoState().getValue());
        r0.put("geoType", r7.getGeoType().getValue());
        r0.put("firstBreach", r7.isFirstBreach());
        r0.put("operation", r8);
        r0.put("timestamp", Long.toString(r5));
        r0.put("eventTimestamp", Long.toString(r7.getEventTimestamp()));
        if (TextUtils.isEmpty(r7.getAddress()) == true) goto L15;
        String r6 = r7.getAddress();
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        r0.put(MemoryKeyInfoEntity.KEY_ADDRESS, r6);
    L15:
        if (TextUtils.isEmpty(r7.getPoiId()) == true) goto L21;
        String r9 = r7.getPoiId();
        if (r9 == null) goto L20;
        r2 = r9;
    L20:
        r0.put("poiId", r2);
    L21:
        return r0;
    }

    public static JSONObject b(long r3, com.obric.cae.location.a.C0349a r5, long r6, com.obric.cae.location.a.C0349a r8, int r9) {
        JSONObject r0 = b();
        r0.put("version", 2);
        r0.put("fly_timestamp", Long.toString(r3));
        String r4 = "";
        if (r5 != null) goto L14;
    L4:
        String r7 = "";
    L6:
        r0.put("fly_prev_location", r7);
        r0.put("ground_timestamp", Long.toString(r6));
        if (r8 != null) goto L16;
    L10:
        r0.put("ground_next_location", r4);
        r0.put("distance", r9);
        return r0;
    L16:
        r4 = r8.r();     // Catch: Exception -> L13
        goto L10
    L14:
        r7 = r5.r();     // Catch: Exception -> L12
        goto L6
    }

    public static JSONObject b(com.obric.cae.location.a.C0349a r5) {
        JSONObject r0 = b();
        r0.put("version", 2);
        r0.put(AILabCheckPermissionTask.KEY_SOURCE, r5.b());
        String r1 = r5.c();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.put("provider", r1);
        r0.put("latitude", a(r5.e()));
        r0.put("longitude", a(r5.f()));
        float r3 = r5.g();
        if (Float.isNaN(r3) == true) goto L9;
        r2 = Float.toString(r3);
    L9:
        r0.put("radius", r2);
        r0.put("applied", r5.h());
        r0.put("coordSys", r5.i().name());
        r0.put("confidence", r5.j());
        r0.put("updateTs", Long.toString(r5.d()));
        r0.put("elapsedRealtimeNanos", Long.toString(r5.n()));
        r0.put("locationTime", Long.toString(r5.o()));
        r0.put("simReady", r5.k());
        r0.put("wifiConnected", r5.l());
        r0.put("mock", r5.p());
        return r0;
    }

    public static JSONObject b(com.obric.cae.location.a.C0349a r9, com.obric.cae.location.a.C0349a r10, int r11, double r12) {
        Bundle r0 = r9.m();
        Bundle r1 = r10.m();
        if (r10.d() <= 0) goto L5;
        long r2 = r10.d();
    L6:
        JSONObject r4 = b();
        r4.put("version", 1);
        String r6 = "";
        String r3 = r0.getString("cellId", "");
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r4.put("cell_id", r3);
        r4.put("cell_location", r9.e() + "," + r9.f() + "," + r9.g());
        r4.put("nlp_timestamp", Long.toString(r2));
        String r5 = r1.getString("QID", "");
        if (r5 == null) goto L13;
        r6 = r5;
    L13:
        r4.put("nlp_id", r6);
        r4.put("nlp_location", r10.e() + "," + r10.f() + "," + r10.g());
        r4.put("drift_ratio", r12 / ((double) r9.g()));
        r4.put("nlp_valid_code", r11);
        return r4;
    L5:
        r2 = r10.o();
        goto L6
    }

    public static JSONObject b(String r3, String r4, String r5, String r6, String r7, String r8, double r9) {
        JSONObject r0 = b();
        r0.put("version", 1);
        r0.put(ObricMemoryConstants.KEY_SESSION_ID, r3);
        r0.put("callingPackage", r4);
        r0.put(InfoRequestQPSOptTraceLogger.REASON, r5);
        r0.put("businessName", r6);
        r0.put("businessVersion", r7);
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        r0.put("finalLabel", r8);
        r0.put("finalProbIndoor", a(r9));
        return r0;
    }
}
