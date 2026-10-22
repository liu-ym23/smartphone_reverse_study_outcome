package com.obric.cae.location.report;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import com.obric.cae.cloud.applog.ByteIOUtils;
import com.obric.cae.libs.cldReport.ICldReportManager;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.location.StarLocationManager;
import com.obric.cae.location.database.StarCellDbManager;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.location.geosdk.bytedance.BdLocationManager;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.location.zpp.StarZppManager;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class StarLocationTeaReporter {
    private static final int CLD_REPORT_REASON_DEFAULT = 0;
    private static final int CLD_REPORT_SERVICE_RETRY_COUNT = 10;
    private static final int CLD_REPORT_SERVICE_RETRY_INTERVAL_MS = 1000;
    private static final int CLD_REPORT_SUBREASON_DEFAULT = 0;
    private static final String EVENT_REPORT_AIRPORT_ENTER = "star_location_airport_enter";
    private static final String EVENT_REPORT_AOI_MISSING = "star_location_aoi_missing";
    public static final String EVENT_REPORT_DIRECTION_SEARCH = "star_location_direction_search";
    private static final String EVENT_REPORT_FLIGHT_MODE = "star_location_flight_mode";
    private static final String EVENT_REPORT_NLP_ERROR = "star_location_nlp_error";
    private static final String EVENT_REPORT_STAR_GEOFENCE_BREACH = "star_location_geofence_breach";
    private static final String EVENT_REPORT_STAR_GEOFENCE_INFO = "star_location_geofence_info";
    private static final String EVENT_REPORT_STAR_ZPP_EVAL = "star_location_zpp_eval";
    private static final String EXTRA_CELL_ID = "cellId";
    private static final String EXTRA_NLP_ID = "QID";
    private static final int FLIGHT_MODE_AIRPORT_ENTER_MIN_DISTANCE_METERS = 100000;
    private static final String INFO_LOCATION_AOI_BOARD_BREACH = "location_aoi_board_breach";
    private static final String INFO_SENSOR_FLIGHT_MODE_DISTANCE_LESS_THAN_100KM = "flight_mode_distance_less_than_100km";
    private static final int MAX_PENDING_AIRPORT_ENTER_REPORT_COUNT = 2;
    private static final String SERVICE_NAME_CLD_REPORT = "cae_cld_report";
    private static final String TAG = "StarLocation-TeaReporter";
    private static volatile boolean sAirportEnterReportAllowed = false;
    private static final Object sAirportEnterReportLock = null;
    private static volatile ICldReportManager sCldReportManager = null;
    private static int sConsecutiveAirportOutsideCount = 0;
    private static volatile boolean sInitialized = false;
    private static final List<PendingAirportEnterReport> sPendingAirportEnterReports = null;

    public static final class PendingAirportEnterReport {
        private final String aoiName;
        private final String aoiType;
        private final boolean inside;
        private final String poiId;

        public PendingAirportEnterReport(String r8, String r10, String r11, boolean r12) {
            this.poiId = r8;
            this.aoiName = r10;
            this.aoiType = r11;
            this.inside = r12;
        }

        public static /* synthetic */ String access$000(PendingAirportEnterReport r8) {
            return r8.poiId;
        }

        public static /* synthetic */ String access$100(PendingAirportEnterReport r8) {
            return r8.aoiName;
        }

        public static /* synthetic */ String access$200(PendingAirportEnterReport r8) {
            return r8.aoiType;
        }

        public static /* synthetic */ boolean access$300(PendingAirportEnterReport r8) {
            return r8.inside;
        }
    }

    static {
        sAirportEnterReportLock = new Object();
        sPendingAirportEnterReports = new ArrayList();
    }

    private StarLocationTeaReporter() {
    }

    private static void appendDirectionRequestInfo(JSONObject r8, BdLocationManager.BmapBaseDirectionRequest r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r8.put("requestCoordType", safeString(r10.coordType));
        r8.put("requestRetCoordType", safeString(r10.retCoordtype));
        r8.put("origin", safeString(r10.origin));
        r8.put("destination", safeString(r10.destination));
    }

    private static void appendDirectionResponseInfo(JSONObject r8, BdLocationManager.BmapDirectionBaseResponse r10, String r11) {
        if (r10 != null) goto L4;
        boolean r12 = false;
    L5:
        r8.put("success", r12);
        if (r12 == true) goto L9;
        r8.put("failureReason", resolveDirectionErrorMessage(r10, r11));
        return;
    L9:
        return;
    L4:
        r12 = r10.isSuccess();
        goto L5
    }

    public static JSONObject buildTeaAirportEnterPayload(String r8, String r10, String r11, boolean r12) {
        JSONObject r13 = new JSONObject();
        r13.put("device_id", safeString(MatrixDidUtils.getDid()));
        r13.put("version", 4);
        r13.put("poiId", safeString(r8));
        r13.put("aoiName", safeString(r10));
        r13.put("aoiType", safeString(r11));
        r13.put("inside", r12);
        return r13;
    }

    public static JSONObject buildTeaAoiMissingPayload(String r8, String r10) {
        JSONObject r11 = new JSONObject();
        r11.put("poiId", safeString(r8));
        r11.put(QesdkUtils.TAGS.JSON_TAG_NAME, safeString(r10));
        return r11;
    }

    public static JSONObject buildTeaBreachPayload(long r8, Location r10, String r11, int r12, int r13, StarGeofence.GeoEvent r14, float r15, boolean r16) {
        JSONObject r17 = new JSONObject();
        r17.put("timestamp", Long.toString(r8));
        r17.put("latitude", safeString(r10.getLatitude()));
        r17.put(StarCellDbManager.CellInfoEntry.LONGITUDE, safeString(r10.getLongitude()));
        r17.put("hAcc", r10.getAccuracy());
        r17.put("provider", safeString(r10.getProvider()));
        r17.put("source", r12);
        r17.put("simCardStatus", r13);
        r17.put(StarLocationDbManager.AoiBoardEntry.GEOFENCE_ID, safeString(r11));
        r17.put("breachEvent", r14.getValue());
        r17.put("responseRate", r15);
        r17.put(StarLocationDbManager.GeofenceEntry.FIRST_BREACH, r16);
        return r17;
    }

    public static JSONObject buildTeaDirectionSearchPayload(int r8, BdLocationManager.BmapBaseDirectionRequest r10, BdLocationManager.BmapDirectionBaseResponse r11, long r12, long r13, String r14) {
        JSONObject r15 = new JSONObject();
        r15.put("device_id", safeString(MatrixDidUtils.getDid()));
        r15.put("directionType", r8);
        r15.put("totalCostMs", Math.max(0, r13 - r12));
        if (r10 == null) goto L5;
        String r16 = safeString(r10.xTtLogId);
    L6:
        r15.put("Logid", r16);
        appendDirectionRequestInfo(r15, r10);
        appendDirectionResponseInfo(r15, r11, r14);
        return r15;
    L5:
        r16 = "";
        goto L6
    }

    public static JSONObject buildTeaFlightModePayload(long r8, StarLocationManager.LocationSource r10, long r11, StarLocationManager.LocationSource r12, int r13) {
        JSONObject r14 = new JSONObject();
        r14.put("device_id", safeString(MatrixDidUtils.getDid()));
        r14.put("version", 1);
        r14.put("fly_timestamp", Long.toString(r8));
        r14.put("fly_prev_location", safeLocationSource(r10));
        r14.put("ground_timestamp", Long.toString(r11));
        r14.put("ground_next_location", safeLocationSource(r12));
        r14.put("distance", r13);
        return r14;
    }

    private static JSONObject buildTeaGeofencePayload(long r8, StarGeofence r10, int r11) {
        JSONObject r12 = new JSONObject();
        r12.put(StarLocationDbManager.AoiBoardEntry.GEOFENCE_ID, safeString(r10.getGeofenceId()));
        r12.put("packageName", safeString(r10.getPackageName()));
        r12.put("latitude", safeString(r10.getLatitude()));
        r12.put(StarCellDbManager.CellInfoEntry.LONGITUDE, safeString(r10.getLongitude()));
        r12.put("radius", r10.getRadius());
        r12.put(StarLocationDbManager.GeofenceEntry.TRANSITION_TYPE, r10.getTransitionType().getValue());
        r12.put("confidence", r10.getConfidence().getValue());
        r12.put("geoState", r10.getGeoState().getValue());
        r12.put("geoType", r10.getGeoType().getValue());
        r12.put(StarLocationDbManager.GeofenceEntry.FIRST_BREACH, r10.isFirstBreach());
        r12.put("operation", r11);
        r12.put("timestamp", Long.toString(r8));
        r12.put(StarLocationDbManager.GeofenceEntry.EVENT_TIMESTAMP, Long.toString(r10.getEventTimestamp()));
        if (TextUtils.isEmpty(r10.getAddress()) == true) goto L6;
        r12.put(StarLocationDbManager.GeofenceEntry.ADDRESS, safeString(r10.getAddress()));
    L6:
        if (TextUtils.isEmpty(r10.getPoiId()) == true) goto L8;
        r12.put("poiId", safeString(r10.getPoiId()));
    L8:
        return r12;
    }

    public static JSONObject buildTeaNlpErrorPayload(StarLocationManager.LocationSource r8, StarLocationManager.LocationSource r10, int r11, double r12) {
        Bundle r13 = r8.getExtra();
        Bundle r14 = r10.getExtra();
        if (r10.getUpdateTs() <= 0) goto L5;
        long r15 = r10.getUpdateTs();
    L6:
        JSONObject r16 = new JSONObject();
        r16.put("device_id", safeString(MatrixDidUtils.getDid()));
        r16.put("version", 1);
        r16.put("product_name", safeString(LocationUtil.sProductDevice));
        r16.put("cell_id", safeString(r13.getString(EXTRA_CELL_ID, "")));
        r16.put("cell_location", formatLocationCircle(r8));
        r16.put("nlp_timestamp", Long.toString(r15));
        r16.put("nlp_id", safeString(r14.getString(EXTRA_NLP_ID, "")));
        r16.put("nlp_location", formatLocationCircle(r10));
        r16.put("drift_ratio", r12 / ((double) r8.getRadius()));
        r16.put("nlp_valid_code", r11);
        return r16;
    L5:
        r15 = r10.getLocationTime();
        goto L6
    }

    public static JSONObject buildTeaZppPayload(StarZppManager.InnerStarZppData r8, float r10, int r11) {
        JSONObject r12 = new JSONObject();
        r12.put("modelVersion", safeString(r8.getModelVersion()));
        r12.put("timestamps", Long.toString(r8.getTimestamp()));
        r12.put("confidence", r8.getConfidence());
        JSONArray r13 = new JSONArray();
        Iterator<Float> r14 = r8.getFeatureArray().iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13.put(r14.next());
        goto L4
    L6:
        r12.put("featureArrays", r13.toString());
        float r15 = r8.getDistance();
        r12.put("eval_distance", r15);
        r12.put("eval_last_hAcc", r10);
        if (r10 <= 0.0f) goto L9;
        double r16 = (float) (Math.exp(Math.pow(r15 / r10, 2.0d) * (-0.1d)) * ((double) (300.0f / (r10 + 300.0f))));
    L10:
        r12.put("eval_confidence_cal", r16);
        r12.put("zppStrategy", r11);
        return r12;
    L9:
        r16 = 0.0d;
        goto L10
    }

    private static String formatLocationCircle(StarLocationManager.LocationSource r8) {
        if (r8 != null) goto L6;
        return "";
    L6:
        return r8.getLatitude() + "," + r8.getLongitude() + "," + r8.getRadius();
    }

    private static ICldReportManager getCldReportManager() {
        ICldReportManager r8 = sCldReportManager;
        if (r8 == null) goto L6;
        CommSenseLog.iWithMethodName(TAG, "use cached cld report service");
        return r8;
    L6:
        CommSenseLog.iWithMethodName(TAG, "get cld report service start");
        IBinder r10 = ServiceManager.getService(SERVICE_NAME_CLD_REPORT);
        int r11 = 0;
    L8:
        if (r10 != null) goto L17;
        if (r11 >= 10) goto L17;
        r11 = r11 + 1;
        CommSenseLog.iWithMethodName(TAG, "cld report service is unavailable, retry=" + r11);
        Thread.sleep(1000);     // Catch: InterruptedException -> L14
        r10 = ServiceManager.getService(SERVICE_NAME_CLD_REPORT);
    L14:
        Thread.currentThread().interrupt();
        String r12 = "get cld report service interrupted";
    L15:
        CommSenseLog.wWithMethodName(TAG, r12);
        return null;
    L17:
        if (r10 != null) goto L19;
        r12 = "cld report service is unavailable after retry";
        goto L15
    L19:
        CommSenseLog.iWithMethodName(TAG, "get cld report service success, retryCount=" + r11);
        ICldReportManager r13 = ICldReportManager.Stub.asInterface(r10);
        sCldReportManager = r13;
        return r13;
    }

    public static void init(Context r8) {
        if (r8 != null) goto L8;
        String r10 = "skipped, context is null";
    L5:
        CommSenseLog.wWithMethodName(TAG, r10);
        return;
    L8:
        if (sInitialized == true) goto L10;
    L12:
        Context r11 = r8.getApplicationContext();
        if ((r11 instanceof Application) == true) goto L20;
        r10 = "skipped, application context is unavailable";
        goto L5
    L20:
        ByteIOUtils.init(r11, (Application) r11, false);     // Catch: Exception -> L17
        sInitialized = true;     // Catch: Exception -> L17
        CommSenseLog.dWithMethodName(TAG, "TEA reporter initialized");     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "Failed to initialize TEA reporter", e);
        return;
    L10:
        if (ByteIOUtils.isInitialized() == false) goto L12;
    }

    public static void reportAirportEnter(AoiBoard r8, boolean r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.getType() == AoiBoard.Type.AIRPORT) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r8.getPoiId()) == false) goto L10;
        CommSenseLog.wWithMethodName(TAG, "skipped, airport aoi is invalid");
        return;
    L10:
        PendingAirportEnterReport r11 = new PendingAirportEnterReport(r8.getPoiId(), r8.getPoiName(), r8.getType().name(), r10);
        Object r12 = sAirportEnterReportLock;
        monitor-enter(r12);
        boolean r13 = true;
        if (r10 == false) goto L15;
        sConsecutiveAirportOutsideCount = 0;     // Catch: Throwable -> L32
    L18:
        boolean r14 = false;
    L20:
        if (sAirportEnterReportAllowed == true) goto L25;
        List<PendingAirportEnterReport> r15 = sPendingAirportEnterReports;     // Catch: Throwable -> L32
        if (r15.size() >= 2) goto L24;
        r15.add(r11);     // Catch: Throwable -> L32
    L24:
        CommSenseLog.dWithMethodName(TAG, "pending, flight mode distance gate is not satisfied");     // Catch: Throwable -> L32
        r13 = false;
    L25:
        monitor-exit(r12);     // Catch: Throwable -> L32
        if (r14 == false) goto L28;
        CommSenseLog.iWithMethodName(TAG, "trigger CLD report, errCode=6, reason=airport outside twice");
        reportErrorEvent(3, 6, 0, 0, INFO_LOCATION_AOI_BOARD_BREACH);
    L28:
        if (r13 == true) goto L30;
        return;
    L30:
        trackAirportEnter(r11);
        return;
    L15:
        int r16 = sConsecutiveAirportOutsideCount + 1;     // Catch: Throwable -> L32
        sConsecutiveAirportOutsideCount = r16;     // Catch: Throwable -> L32
        if (r16 < 2) goto L18;
        sConsecutiveAirportOutsideCount = 0;     // Catch: Throwable -> L32
        r14 = true;
    L32:
        th = move-exception;
        throw th;
    }

    public static void reportAoiMissing(String r8, String r10) {
        trackEvent(EVENT_REPORT_AOI_MISSING, buildTeaAoiMissingPayload(r8, r10));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);
    }

    public static void reportBreachEvent(long r8, Location r10, String r11, int r12, int r13, StarGeofence.GeoEvent r14, float r15, boolean r16) {
        if (r10 == null) goto L11;
        if (r14 == null) goto L11;
        trackEvent(EVENT_REPORT_STAR_GEOFENCE_BREACH, buildTeaBreachPayload(r8, r10, r11, r12, r13, r14, r15, r16));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);
        return;
    L11:
        CommSenseLog.wWithMethodName(TAG, "skipped, location or event is null");
    }

    public static void reportDirectionSearch(int r8, BdLocationManager.BmapBaseDirectionRequest r10, BdLocationManager.BmapDirectionBaseResponse r11, long r12, long r13, String r14) {
        trackEvent(EVENT_REPORT_DIRECTION_SEARCH, buildTeaDirectionSearchPayload(r8, r10, r11, r12, r13, r14));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);
    }

    private static void reportErrorEvent(int r11, int r12, int r13, int r14, String r15) {
        StringBuilder r8 = defpackage.a.g("reportErrorEvent start, moduleType=", r11, ", errCode=", r12, ", reason=");
        defpackage.b.q(r8, r13, ", subReason=", r14, ", infoLength=");
        r8.append(r15.length());
        CommSenseLog.iWithMethodName(TAG, r8.toString());
        ICldReportManager r10 = getCldReportManager();
        if (r10 != null) goto L11;
        CommSenseLog.wWithMethodName(TAG, "reportErrorEvent skipped, cld report manager is null, moduleType=" + r11 + ", errCode=" + r12);
        return;
    L11:
        CommSenseLog.iWithMethodName(TAG, "call cld report service, moduleType=" + r11 + ", errCode=" + r12);     // Catch: RemoteException -> L8
        r10.reportErrorEvent(r11, r12, r13, r14, r15);     // Catch: RemoteException -> L8
        CommSenseLog.iWithMethodName(TAG, "reportErrorEvent success, moduleType=" + r11 + ", errCode=" + r12);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        sCldReportManager = null;
        CommSenseLog.eWithMethodName(TAG, "reportErrorEvent error", e);
    }

    public static void reportFlightMode(long r8, StarLocationManager.LocationSource r10, long r11, StarLocationManager.LocationSource r12, int r13) {
        trackEvent(EVENT_REPORT_FLIGHT_MODE, buildTeaFlightModePayload(r8, r10, r11, r12, r13));     // Catch: Exception -> L25
        boolean r14 = false;
        if (r13 >= FLIGHT_MODE_AIRPORT_ENTER_MIN_DISTANCE_METERS) goto L6;
        CommSenseLog.iWithMethodName(TAG, "trigger CLD report, errCode=5, distance=" + r13);     // Catch: Exception -> L25
        reportErrorEvent(3, 5, 0, 0, INFO_SENSOR_FLIGHT_MODE_DISTANCE_LESS_THAN_100KM);     // Catch: Exception -> L25
    L6:
        Object r15 = sAirportEnterReportLock;     // Catch: Exception -> L25
        monitor-enter(r15);     // Catch: Exception -> L25
        if (r13 <= FLIGHT_MODE_AIRPORT_ENTER_MIN_DISTANCE_METERS) goto L29;
        r14 = true;
    L29:
        sAirportEnterReportAllowed = r14;     // Catch: Throwable -> L22
        if (sAirportEnterReportAllowed == false) goto L13;
        ArrayList r16 = new ArrayList(sPendingAirportEnterReports);     // Catch: Throwable -> L22
    L14:
        sPendingAirportEnterReports.clear();     // Catch: Throwable -> L22
        monitor-exit(r15);     // Catch: Throwable -> L22
        if (r16 == null) goto L32;
        Iterator r17 = r16.iterator();     // Catch: Exception -> L25
    L19:
        if (r17.hasNext() == false) goto L33;
        trackAirportEnter((PendingAirportEnterReport) r17.next());     // Catch: Exception -> L25
        goto L19
    L33:
        return;
    L32:
        return;
    L13:
        r16 = null;
    L22:
        th = move-exception;
        throw th;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);
    }

    public static void reportGeofenceEvent(long r8, StarGeofence r10, int r11) {
        if (r10 != null) goto L11;
        CommSenseLog.wWithMethodName(TAG, "skipped, starGeofence is null");
        return;
    L11:
        trackEvent(EVENT_REPORT_STAR_GEOFENCE_INFO, buildTeaGeofencePayload(r8, r10, r11));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);
    }

    public static void reportNlpError(StarLocationManager.LocationSource r8, StarLocationManager.LocationSource r10, int r11, double r12) {
        if (r8 == null) goto L27;
        if (r10 == null) goto L27;
        float r13 = r8.getRadius();
        if (r13 > 0.0f) goto L9;
    L24:
        String r14 = "skipped, location radius or distance is invalid";
    L25:
        CommSenseLog.dWithMethodName(TAG, r14);
        return;
    L9:
        if (Float.isNaN(r13) == true) goto L24;
        if (Float.isInfinite(r13) == true) goto L24;
        if (r12 < 0.0d) goto L24;
        if (Double.isNaN(r12) == true) goto L24;
        if (Double.isInfinite(r12) == true) goto L24;
        trackEvent(EVENT_REPORT_NLP_ERROR, buildTeaNlpErrorPayload(r8, r10, r11, r12));     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);
        return;
    L27:
        r14 = "skipped, location source is null";
        goto L25
    }

    public static void reportZppEval(StarZppManager.InnerStarZppData r8, float r10, int r11) {
        if (r8 != null) goto L11;
        CommSenseLog.wWithMethodName(TAG, "skipped, data is null");
        return;
    L11:
        trackEvent(EVENT_REPORT_STAR_ZPP_EVAL, buildTeaZppPayload(r8, r10, r11));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);
    }

    public static void resetAirportEnterReportGate() {
        Object r8 = sAirportEnterReportLock;
        monitor-enter(r8);
        sAirportEnterReportAllowed = false;     // Catch: Throwable -> L8
        sPendingAirportEnterReports.clear();     // Catch: Throwable -> L8
        sConsecutiveAirportOutsideCount = 0;     // Catch: Throwable -> L8
        monitor-exit(r8);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static String resolveDirectionErrorMessage(BdLocationManager.BmapDirectionBaseResponse r8, String r10) {
        if (r8 == null) goto L8;
        if (TextUtils.isEmpty(r8.message) == true) goto L8;
        return safeString(r8.message);
    L8:
        return safeString(r10);
    }

    private static String safeLocationSource(StarLocationManager.LocationSource r8) {
        if (r8 != null) goto L8;
        return "";
    L8:
        return r8.toJsonString();
    L7:
        return "";
    }

    public static String safeString(double r8) {
        if (Double.isNaN(r8) == false) goto L7;
        return "";
    L7:
        return Double.toString(r8);
    }

    private static void trackAirportEnter(PendingAirportEnterReport r8) {
        boolean r10 = LocationUtil.getInstance().isForbidMockLocation();
        if (r10 == true) goto L11;
        CommSenseLog.dWithMethodName(TAG, "skipped, forbidMockLocation=" + r10);
        return;
    L11:
        trackEvent(EVENT_REPORT_AIRPORT_ENTER, buildTeaAirportEnterPayload(PendingAirportEnterReport.access$000(r8), PendingAirportEnterReport.access$100(r8), PendingAirportEnterReport.access$200(r8), PendingAirportEnterReport.access$300(r8)));     // Catch: Exception -> L8
        CommSenseLog.dWithMethodName(TAG, "reported airport enter, poiId=" + PendingAirportEnterReport.access$000(r8) + ", inside=" + PendingAirportEnterReport.access$300(r8));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed to report airport enter", e);
    }

    private static void trackEvent(String r8, JSONObject r10) {
        ByteIOUtils.trackEvent(r8, r10);     // Catch: Exception -> L5
        CommSenseLog.dWithMethodName(TAG, "Tracked TEA event: " + r8 + ", payloadLength=" + r10.toString().length());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "Failed to track TEA event: " + r8, e);
    }

    private static String safeString(String r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        return r8;
    }
}
