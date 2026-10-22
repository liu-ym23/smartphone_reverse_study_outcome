package com.obric.cae.location.city;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.libs.location.poi.IStarPoiCallback;
import com.obric.cae.location.cell.CellPoiService;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.location.geosdk.bytedance.BdLocationManager;
import com.obric.cae.location.geosdk.poi.StarAoiBoardManager;
import com.obric.cae.location.geosdk.poi.StarPoiManager;
import com.obric.cae.location.report.StarLocationTeaReporter;
import com.obric.cae.location.util.AoiBoardUtil;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.location.util.PoiDslBuilder;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class TrafficGeoManager {
    private static final long[] AIRPORT_GROUND_CHECK_DELAY_MS = null;
    private static final long AIRPORT_GROUND_LOCATION_TIMEOUT_MS = 0;
    private static final String AIRPORT_NEW_TYPE_CODE = "131002";
    private static final String AIRPORT_NEW_TYPE_NAME = "飞机场";
    private static final String AIRPORT_SEARCH_KEYWORD = "国际机场";
    private static final String KEY_AIRPORT_AOI_BOARD = "airport_aoi_board";
    private static final String KEY_SUBWAY_STATION_AOI_BOARD = "subway_station_aoi_board";
    private static final String KEY_TRAFFIC_SEARCH_CITY = "traffic_aoi_board_city";
    private static final String KEY_TRAFFIC_VERSION = "traffic_version";
    private static final String KEY_TRAIN_STATION_AOI_BOARD = "train_station_aoi_board";
    private static final String POI_SEARCH_INDEX = "o_project_bamp_search";
    private static final String SUBWAY_NEW_TYPE_CODE = "131401";
    private static final String SUBWAY_NEW_TYPE_CODE_L1 = "130000";
    private static final String SUBWAY_NEW_TYPE_CODE_L2 = "131400";
    private static final String SUBWAY_NEW_TYPE_NAME = "地铁站";
    private static final String SUBWAY_NEW_TYPE_NAME_L1 = "地名地址";
    private static final String SUBWAY_NEW_TYPE_NAME_L2 = "地铁站";
    private static final String[] SUBWAY_SEARCH_KEYWORDS = null;
    private static final String TAG = "StarLocation-trafficGeo";
    private static final int TRAFFIC_AOI_BOARD_STATE_NO_RESULT = -1;
    private static final int TRAFFIC_AOI_BOARD_STATE_PENDING = 0;
    private static final int TRAFFIC_AOI_BOARD_STATE_SUCCESS = 2;
    private static final String TRAFFIC_PREF_NAME = "star_location_sp";
    private static final long TRAFFIC_RETRY_DELAY_MS = 5000;
    private static final int TRAFFIC_VERSION_BASELINE = 2;
    private static final String TRAIN_NEW_TYPE_CODE = "131301";
    private static final String TRAIN_NEW_TYPE_NAME = "火车站";
    private static final String TRAIN_STATION_SEARCH_KEYWORD = "火车站";
    private static volatile TrafficGeoManager sInstance;
    private final AtomicReference<String> mActiveTrafficCity;
    private final AtomicInteger mAirportFlightModeToken;
    private final Object mAirportGroundCheckHandlerToken;
    private int mAirportGroundOutsideCheckCount;
    private boolean mAirportGroundReportFinished;
    private final Context mAppContext;
    private final AtomicBoolean mHighConfidenceCellPoiCallbackRegistered;
    private final CellPoiService.HighConfidenceCellPoiListener mHighConfidenceCellPoiListener;
    private int mLastHandledFlightModeState;
    private final AtomicReference<String> mLastHighConfidenceStationName;
    private final AtomicReference<AoiBoard> mLastInsideAoiBoard;
    private final Handler mMainHandler;
    private int mPendingAirportGroundLocationCheckIndex;
    private int mPendingAirportGroundLocationCheckToken;
    private int mPendingFlightModeState;
    private final AtomicReference<Location> mPendingTrafficLocation;
    private final ContentObserver mProactiveAgentObserver;
    private final InnerAwareInfoCallback mTrafficAwareCallback;
    private final AtomicBoolean mTrafficAwareCallbackRegistered;
    private ExecutorService mTrafficExecutor;
    private final AtomicBoolean mTrafficLocationRefreshScheduled;
    private final CityAoiSyncRunner mTrafficSyncRunner;

    /* JADX INFO: renamed from: com.obric.cae.location.city.TrafficGeoManager$2, reason: invalid class name */
    public class AnonymousClass2 extends InnerAwareInfoCallback {
        final /* synthetic */ TrafficGeoManager this$0;

        public AnonymousClass2(TrafficGeoManager r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(AnonymousClass2 r8, int r10) {
            r8.lambda$onflightModeChanged$1(r10);
        }

        public static /* synthetic */ void b(TrafficGeoManager r8) {
            lambda$onLocationChanged$0(r8);
        }

        public static /* synthetic */ void c(AnonymousClass2 r8, AoiBoard r10) {
            r8.lambda$onAoiBoardEvent$2(r10);
        }

        private /* synthetic */ void lambda$onAoiBoardEvent$2(AoiBoard r8) {
            TrafficGeoManager.access$300(this.this$0, r8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            CommSenseLog.eWithMethodName(TrafficGeoManager.TAG, "recordLastInsideAoiBoard error", th);
        }

        private static /* synthetic */ void lambda$onLocationChanged$0(TrafficGeoManager r8) {
            TrafficGeoManager.access$500(r8);
        }

        private /* synthetic */ void lambda$onflightModeChanged$1(int r8) {
            TrafficGeoManager.access$400(this.this$0, r8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            CommSenseLog.eWithMethodName(TrafficGeoManager.TAG, "handleFlightModeChanged error, state=" + r8, th);
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onAoiBoardEvent(final AoiBoard r8) {
            if (r8 != null) goto L4;
            return;
        L4:
            TrafficGeoManager.access$200(this.this$0).execute(new l(this, r8));
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onLocationChanged(Location r8) {
            if (r8 != null) goto L4;
            return;
        L4:
            TrafficGeoManager.access$000(this.this$0).set(new Location(r8));
            int r10 = 0;
            if (TrafficGeoManager.access$100(this.this$0).compareAndSet(false, true) == true) goto L7;
            return;
        L7:
            TrafficGeoManager.access$200(this.this$0).execute(new k(this.this$0, r10));
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onflightModeChanged(final int r8) {
            TrafficGeoManager.access$200(this.this$0).execute(new j(this, r8));
        }
    }

    public static final class TrafficAoiQueryResult {
        final List<AoiBoard> aoiBoards;
        final Map<String, String> newTypeCodeL3ByPoiId;
        final Map<String, Integer> stateUpdates;
        final boolean success;

        public TrafficAoiQueryResult(boolean r8, List<AoiBoard> r10, Map<String, String> r11, Map<String, Integer> r12) {
            this.success = r8;
            this.aoiBoards = r10;
            this.newTypeCodeL3ByPoiId = r11;
            this.stateUpdates = r12;
        }
    }

    public static final class TrafficSyncContext {
        final String city;
        List<StarGeofence> existingTrafficGeofences;
        final boolean needReloadTrafficData;

        public TrafficSyncContext(String r8, List<StarGeofence> r10, boolean r11) {
            this.city = r8;
            this.existingTrafficGeofences = r10;
            this.needReloadTrafficData = r11;
        }
    }

    static {
        SUBWAY_SEARCH_KEYWORDS = new String[]{"地铁站", "地铁线路"};
        TimeUnit r8 = TimeUnit.MINUTES;
        AIRPORT_GROUND_CHECK_DELAY_MS = new long[]{r8.toMillis(10), r8.toMillis(20), r8.toMillis(30)};
        AIRPORT_GROUND_LOCATION_TIMEOUT_MS = TimeUnit.SECONDS.toMillis(20);
    }

    private TrafficGeoManager(Context r11) {
        this.mActiveTrafficCity = new AtomicReference(null);
        final Handler r8 = new Handler(Looper.getMainLooper());
        this.mMainHandler = r8;
        this.mTrafficLocationRefreshScheduled = new AtomicBoolean(false);
        this.mPendingTrafficLocation = new AtomicReference(null);
        this.mLastInsideAoiBoard = new AtomicReference(null);
        this.mAirportGroundCheckHandlerToken = new Object();
        this.mAirportFlightModeToken = new AtomicInteger(0);
        this.mLastHandledFlightModeState = -1;
        this.mPendingFlightModeState = -1;
        this.mPendingAirportGroundLocationCheckToken = 0;
        this.mPendingAirportGroundLocationCheckIndex = 0;
        this.mAirportGroundOutsideCheckCount = 0;
        this.mAirportGroundReportFinished = true;
        this.mProactiveAgentObserver = new AnonymousClass1(this, r8);
        this.mTrafficAwareCallbackRegistered = new AtomicBoolean(false);
        this.mTrafficAwareCallback = new AnonymousClass2(this);
        this.mLastHighConfidenceStationName = new AtomicReference(null);
        this.mHighConfidenceCellPoiCallbackRegistered = new AtomicBoolean(false);
        this.mHighConfidenceCellPoiListener = new e(this);
        this.mAppContext = r11.getApplicationContext();
        this.mTrafficSyncRunner = new CityAoiSyncRunner(TAG, "traffic", r8, 5000, new c(this), new f(this));
    }

    public static /* synthetic */ String a(BdLocationManager.CommonPOIInfo r8) {
        return getTrafficCandidateKey(r8);
    }

    public static /* synthetic */ AtomicReference access$000(TrafficGeoManager r8) {
        return r8.mPendingTrafficLocation;
    }

    public static /* synthetic */ AtomicBoolean access$100(TrafficGeoManager r8) {
        return r8.mTrafficLocationRefreshScheduled;
    }

    public static /* synthetic */ ExecutorService access$200(TrafficGeoManager r8) {
        return r8.trafficExecutor();
    }

    public static /* synthetic */ void access$300(TrafficGeoManager r8, AoiBoard r10) {
        r8.recordLastInsideAoiBoard(r10);
    }

    public static /* synthetic */ void access$400(TrafficGeoManager r8, int r10) {
        r8.handleFlightModeChanged(r10);
    }

    public static /* synthetic */ void access$500(TrafficGeoManager r8) {
        r8.drainTrafficLocationUpdates();
    }

    private StarAoiBoardManager aoiBoardManager() {
        return StarAoiBoardManager.getInstance(this.mAppContext, 0);
    }

    private void applyTrafficAoiBoardSearchStates(String r8, Map<String, Integer> r10) {
        SharedPreferences.Editor r11 = trafficPrefs().edit();
        r11.putString(KEY_TRAFFIC_SEARCH_CITY, r8);
        Iterator<Map.Entry<String, Integer>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<String, Integer> r13 = r12.next();
        r11.putInt(r13.getKey(), r13.getValue().intValue());
        goto L4
    L6:
        r11.apply();
    }

    public static /* synthetic */ void b(TrafficGeoManager r8, String r10) {
        r8.tryAddPresetTrafficGeofencesIfNeeded(r10);
    }

    private AoiBoard buildTrafficAoiBoard(BdLocationManager.CommonPOIInfo r8, String r10, AoiBoard.Type r11) {
        if (r8 != null) goto L5;
    L13:
        return null;
    L5:
        if (r10.isEmpty() == true) goto L13;
        String r12 = r8.name;
        String r13 = extractTrafficAoiBoard(r8);
        if (r13.isEmpty() == false) goto L12;
        StringBuilder r14 = defpackage.b.i("traffic candidate missing aoi data, name=", r12, ", poiId=", r10, ", type=");
        r14.append(r11);
        CommSenseLog.vWithMethodName(TAG, r14.toString());
        StarLocationTeaReporter.reportAoiMissing(r10, r12);
        return null;
    L12:
        return StarAoiBoardManager.buildAoiBoard(r10, r12, r13, r11);
    }

    public static String buildTrafficSearchDsl(String r8, String r10, String r11) {
        PoiDslBuilder r12 = new PoiDslBuilder().addTerm("new_type_name", r10);
        if (r11.isEmpty() == true) goto L6;
        r12.addTerm("new_type_code", r11);
    L6:
        return r12.addTerm("lbs_city", r8).setOp("and").build();
    }

    public static /* synthetic */ void c(TrafficGeoManager r8, int r10, int r11) {
        r8.lambda$scheduleAirportGroundChecks$1(r10, r11);
    }

    private void cancelAirportGroundChecks() {
        this.mMainHandler.removeCallbacksAndMessages(this.mAirportGroundCheckHandlerToken);
        clearPendingAirportGroundLocationCheck();
        this.mAirportGroundReportFinished = true;
    }

    private void clearPendingAirportGroundLocationCheck() {
        this.mPendingAirportGroundLocationCheckToken = 0;
        this.mPendingAirportGroundLocationCheckIndex = 0;
    }

    private void collectTrafficAoiBoards(Map<String, AoiBoard> r8, Map<String, String> r10, List<BdLocationManager.CommonPOIInfo> r11, AoiBoard.Type r12) {
        Iterator<BdLocationManager.CommonPOIInfo> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L18;
        BdLocationManager.CommonPOIInfo r14 = r13.next();
        if (r14 != null) goto L8;
        String r15 = "";
    L10:
        if (r15.isEmpty() == true) goto L4;
        String r16 = extractTrafficNewTypeCode(r14.extraInfos);
        if (r16.isEmpty() == true) goto L15;
        r10.put(r15, r16);
    L15:
        AoiBoard r17 = buildTrafficAoiBoard(r14, r15, r12);
        if (r17 == null) goto L4;
        r8.put(r17.getPoiId(), r17);
        goto L4
    L8:
        r15 = extractPoiId(r14.extraInfos);
        goto L10
    }

    private boolean collectTrafficAoiBoardsForType(Map<String, AoiBoard> r14, Map<String, String> r15, Map<String, Integer> r16, String r17, String r18, String r19, String r20, String r21, int r22, String r23, AoiBoard.Type r24) {
        return collectTrafficAoiBoardsForType(r14, r15, r16, r17, Arrays.asList(new String[]{r18}), r19, r20, r21, r22, r23, r24);
    }

    public static /* synthetic */ void d(TrafficGeoManager r8, int r10, int r11) {
        r8.lambda$handleAirportGroundCheck$4(r10, r11);
    }

    private StarLocationDbManager dbManager() {
        return StarLocationDbManager.getInstance(this.mAppContext, 0);
    }

    private void drainTrafficLocationUpdates() {
    L2:
        int r8 = 1;
        Location r10 = this.mPendingTrafficLocation.getAndSet(null);     // Catch: Throwable -> L23
        if (r10 == null) goto L5;
        reconcileTrafficGeofencesWithLocation(r10, null);     // Catch: Throwable -> L13
        handlePendingAirportGroundLocationCheck(r10);     // Catch: Throwable -> L13
    L16:
        if (this.mPendingTrafficLocation.get() != null) goto L2;
        this.mTrafficLocationRefreshScheduled.set(false);
        if (this.mPendingTrafficLocation.get() != null) goto L20;
        return;
    L20:
        if (this.mTrafficLocationRefreshScheduled.compareAndSet(false, true) == false) goto L40;
        trafficExecutor().execute(new k(this, r8));
        return;
    L40:
        return;
    L13:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, WsConstants.KEY_CONNECTION_ERROR, th);     // Catch: Throwable -> L23
        goto L16
    L5:
        this.mTrafficLocationRefreshScheduled.set(false);
        if (this.mPendingTrafficLocation.get() != null) goto L8;
        return;
    L8:
        if (this.mTrafficLocationRefreshScheduled.compareAndSet(false, true) == false) goto L38;
        trafficExecutor().execute(new a(this, r8));
        return;
    L38:
        return;
    L23:
        th = move-exception;
        this.mTrafficLocationRefreshScheduled.set(false);
        if (this.mPendingTrafficLocation.get() != null) goto L27;
    L29:
        throw th;
    L27:
        if (this.mTrafficLocationRefreshScheduled.compareAndSet(false, true) == false) goto L29;
        trafficExecutor().execute(new a(this, r8));
        goto L29
    }

    public static /* synthetic */ void e(TrafficGeoManager r8, int r10, int r11) {
        r8.lambda$handleAirportGroundCheck$3(r10, r11);
    }

    private boolean ensureTrafficDataPrepared(TrafficSyncContext r8) {
        if (r8.needReloadTrafficData == true) goto L5;
        this.mActiveTrafficCity.set(r8.city);
        return true;
    L5:
        if (reloadTrafficDataForCity(r8.city, r8.existingTrafficGeofences) == true) goto L7;
        return false;
    L7:
        CommSenseLog.dWithMethodName(TAG, "ensureTrafficDataPrepared start query refreshed traffic geofences");
        List<StarGeofence> r10 = listTrafficGeofences();
        StringBuilder r11 = new StringBuilder("ensureTrafficDataPrepared queried refreshed traffic geofences, isNull=");
        if (r10 != null) goto L10;
        boolean r12 = true;
    L11:
        r11.append(r12);
        r11.append(", size=");
        if (r10 != null) goto L14;
        int r13 = -1;
    L15:
        r11.append(r13);
        CommSenseLog.dWithMethodName(TAG, r11.toString());
        if (r10 != null) goto L19;
        scheduleRetryAddTrafficGeofences();
        return false;
    L19:
        r8.existingTrafficGeofences = r10;
        return true;
    L14:
        r13 = r10.size();
        goto L15
    L10:
        r12 = false;
        goto L11
    }

    private void ensureTrafficSearchStateForCity(String r8) {
        String r10 = trafficPrefs().getString(KEY_TRAFFIC_SEARCH_CITY, "");
        if (r8.equals(r10) == false) goto L5;
        return;
    L5:
        trafficPrefs().edit().putString(KEY_TRAFFIC_SEARCH_CITY, r8).putInt(KEY_AIRPORT_AOI_BOARD, 0).putInt(KEY_TRAIN_STATION_AOI_BOARD, 0).putInt(KEY_SUBWAY_STATION_AOI_BOARD, 0).apply();
        CommSenseLog.iWithMethodName(TAG, "reset traffic aoi search state, previousCity=" + r10 + ", currentCity=" + r8);
    }

    private boolean ensureTrafficVersionMigrated(List<StarGeofence> r8) {
        int r10 = getTrafficVersion();
        if (r10 != 0) goto L6;
        int r11 = removeOldTrafficGeofences(r8);
        int r12 = aoiBoardManager().deleteAllAoiBoards();
        this.mActiveTrafficCity.set(null);
        trafficPrefs().edit().remove(KEY_TRAFFIC_SEARCH_CITY).remove(KEY_AIRPORT_AOI_BOARD).remove(KEY_TRAIN_STATION_AOI_BOARD).remove(KEY_SUBWAY_STATION_AOI_BOARD).putInt(KEY_TRAFFIC_VERSION, 2).apply();
        CommSenseLog.iWithMethodName(TAG, "finish traffic version migration, removedTrafficCount=" + r11 + ", deletedAoiBoardCount=" + r12);
        return true;
    L6:
        if (r10 < 2) goto L8;
        return true;
    L8:
        return migrateTrafficAoiBoardsToLatestVersion(r8, r10);
    }

    public static String extractPoiId(Map<String, String> r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        String r10 = r8.get("awe_poi_id");
        if (r10 != null) goto L9;
        return "";
    L9:
        return r10;
    }

    private String extractTrafficAoiBoard(BdLocationManager.CommonPOIInfo r8) {
        String r10 = r8.aoiBorder;
        if (TextUtils.isEmpty(r10) == false) goto L7;
        Map<String, String> r11 = r8.extraInfos;
        if (r11 == null) goto L7;
        r10 = r11.get("aoi_border");
    L7:
        if (r10 != null) goto L10;
        return "";
    L10:
        String r12 = r10.trim();
        if (r12.startsWith("{") == true) goto L17;
        if (r12.startsWith("[") == true) goto L17;
        return r12;
    L17:
        return AoiBoardUtil.parseAndConvertGeoJsonAoiBoard(r12);
    }

    private String extractTrafficNewTypeCode(Map<String, String> r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        if (r8.isEmpty() == true) goto L21;
        String r10 = r8.get("new_type_code");
        if (r10 != null) goto L10;
    L11:
        r10 = r8.get("NewTypeCode");
    L12:
        if (r10 != null) goto L14;
    L15:
        r10 = r8.get("newTypeCode");
    L16:
        if (r10 != null) goto L19;
        return "";
    L19:
        return r10;
    L14:
        if (r10.isEmpty() == false) goto L16;
    L10:
        if (r10.isEmpty() == false) goto L12;
    L21:
        return "";
    }

    public static /* synthetic */ void f(TrafficGeoManager r8, int r10, String r11) {
        r8.lambda$new$0(r10, r11);
    }

    private AoiBoard findAoiBoardByPoiId(List<AoiBoard> r8, String r10) {
        if (r10.isEmpty() == false) goto L5;
        return null;
    L5:
        Iterator<AoiBoard> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        AoiBoard r12 = r11.next();
        if (r12 == null) goto L7;
        if (r10.equals(r12.getPoiId()) == false) goto L7;
        return r12;
    L13:
        return null;
    }

    private AoiBoard findInsideAirportAoiBoardByLocation(List<AoiBoard> r8, Location r10) {
        Iterator<AoiBoard> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        AoiBoard r12 = r11.next();
        if (r12 == null) goto L4;
        if (r12.getAoiBoard().isEmpty() == true) goto L4;
        boolean r13 = AoiBoardUtil.isInAoiBoard(r12.getAoiBoard(), r10.getLatitude(), r10.getLongitude());
        CommSenseLog.dWithMethodName(TAG, "airport location check poiId=" + r12.getPoiId() + ", inside=" + r13);
        if (r13 == false) goto L4;
        return r12;
    L13:
        return null;
    }

    private AoiBoard findInsideAirportAoiBoardByState(List<AoiBoard> r8) {
        Iterator<AoiBoard> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        AoiBoard r11 = r10.next();
        if (r11 == null) goto L4;
        if (r11.getCurState() != AoiBoard.State.INSIDE) goto L4;
        return r11;
    L10:
        return null;
    }

    private AoiBoard findPreviousInsideAirportAoiBoard(List<AoiBoard> r11) {
        AoiBoard r8 = this.mLastInsideAoiBoard.get();
        if (isValidAoiBoard(r8) == false) goto L9;
        CommSenseLog.dWithMethodName(TAG, "last inside aoi poiId=" + r8.getPoiId() + ", type=" + r8.getType() + ", eventTime=" + r8.getEventTime());
        if (r8.getType() == AoiBoard.Type.AIRPORT) goto L8;
        return null;
    L8:
        return findAoiBoardByPoiId(r11, r8.getPoiId());
    L9:
        Iterator<AoiBoard> r12 = aoiBoardManager().queryAllAoiBoards().iterator();
        AoiBoard r10 = null;
    L11:
        if (r12.hasNext() == false) goto L24;
        AoiBoard r13 = r12.next();
        if (isValidAoiBoard(r13) == false) goto L11;
        if (r13.getEventTime() <= 0) goto L11;
        if (r13.getCurState() != AoiBoard.State.INSIDE) goto L11;
        if (r10 == null) goto L23;
        if (r13.getEventTime() <= r10.getEventTime()) goto L11;
    L23:
        r10 = r13;
        goto L11
    L24:
        if (r10 != null) goto L27;
        CommSenseLog.dWithMethodName(TAG, "previous inside source not found");
        return null;
    L27:
        CommSenseLog.dWithMethodName(TAG, "previous inside source poiId=" + r10.getPoiId() + ", type=" + r10.getType() + ", state=" + r10.getCurState() + ", event=" + r10.getEvent() + ", eventTime=" + r10.getEventTime());
        if (r10.getType() == AoiBoard.Type.AIRPORT) goto L30;
        return null;
    L30:
        return r10;
    }

    public static /* synthetic */ void g(TrafficGeoManager r8) {
        r8.drainTrafficLocationUpdates();
    }

    public static TrafficGeoManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(TrafficGeoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TrafficGeoManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(TrafficGeoManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static List<String> getSubwaySearchKeywords() {
        return Arrays.asList(SUBWAY_SEARCH_KEYWORDS);
    }

    private int getTrafficAoiBoardSearchState(String r8) {
        return trafficPrefs().getInt(r8, 0);
    }

    public static EnumSet<AoiBoard.Type> getTrafficAoiBoardTypes() {
        return StarAoiBoardManager.getTrafficAoiBoardTypes();
    }

    private static String getTrafficCandidateKey(BdLocationManager.CommonPOIInfo r8) {
        String r10 = extractPoiId(r8.extraInfos);
        if (r10.isEmpty() == false) goto L9;
        StringBuilder r11 = new StringBuilder();
        String r12 = r8.name;
        if (r12 != null) goto L7;
        r12 = "";
    L7:
        r11.append(r12);
        r11.append("_");
        r11.append(r8.latitude);
        r11.append("_");
        r11.append(r8.longitude);
        return r11.toString();
    L9:
        return r10;
    }

    private int getTrafficVersion() {
        return trafficPrefs().getInt(KEY_TRAFFIC_VERSION, 0);
    }

    private static EnumSet<AoiBoard.Type> getVersionedTrafficAoiBoardTypes() {
        return EnumSet.of(AoiBoard.Type.AIRPORT, AoiBoard.Type.TRAIN_STATION);
    }

    public static /* synthetic */ void h(TrafficGeoManager r8, int r10, int r11) {
        r8.lambda$scheduleAirportGroundChecks$2(r10, r11);
    }

    private boolean handleAirportFlying(int r8) {
        if (isAirportFlightModeTokenValid(r8, 1) == true) goto L5;
        return true;
    L5:
        List<AoiBoard> r10 = listTrafficAoiBoardsByType(AoiBoard.Type.AIRPORT);
        if (r10.isEmpty() == false) goto L9;
        CommSenseLog.wWithMethodName(TAG, "skip flying airport report: no airport aoi board, searchState=" + getTrafficAoiBoardSearchState(KEY_AIRPORT_AOI_BOARD));
        return isAirportAoiBoardSearchFinished();
    L9:
        AoiBoard r11 = findInsideAirportAoiBoardByState(r10);
        if (r11 == null) goto L13;
        reportAirportEnter(r11, true, "flying_inside");
        return true;
    L13:
        AoiBoard r12 = findPreviousInsideAirportAoiBoard(r10);
        if (r12 == null) goto L17;
        reportAirportEnter(r12, true, "flying_previous_inside_airport");
        return true;
    L17:
        AoiBoard r13 = selectAirportAoiBoardForReport(r10);
        if (r13 != null) goto L21;
        CommSenseLog.wWithMethodName(TAG, "skip flying airport report: no report aoi board");
        return true;
    L21:
        CommSenseLog.dWithMethodName(TAG, "skip flying airport report: no inside airport evidence, poiId=" + r13.getPoiId());
        return true;
    }

    private void handleAirportGroundCheck(int r8, int r10) {
        int r11 = 0;
        if (isAirportFlightModeTokenValid(r8, 0) == true) goto L5;
    L14:
        StringBuilder r12 = defpackage.a.g("skip ground check index=", r10, ", token=", r8, ", currentToken=");
        r12.append(this.mAirportFlightModeToken.get());
        r12.append(", reportFinished=");
        r12.append(this.mAirportGroundReportFinished);
        String r13 = r12.toString();
    L15:
        CommSenseLog.dWithMethodName(TAG, r13);
        return;
    L5:
        if (this.mAirportGroundReportFinished == true) goto L14;
        if (listTrafficAoiBoardsByType(AoiBoard.Type.AIRPORT).isEmpty() == false) goto L13;
        CommSenseLog.wWithMethodName(TAG, "skip ground check: no airport aoi board, index=" + r10);
        if (r10 < AIRPORT_GROUND_CHECK_DELAY_MS.length) goto L17;
        cancelAirportGroundChecks();
        return;
    L17:
        return;
    L13:
        this.mPendingAirportGroundLocationCheckToken = r8;
        this.mPendingAirportGroundLocationCheckIndex = r10;
        LocationUtil.getInstance().requestSingleLocationUpdates("network", true, CommSenseLog.getMethodName());
        this.mMainHandler.postDelayed(new g(this, r8, r10, r11), this.mAirportGroundCheckHandlerToken, AIRPORT_GROUND_LOCATION_TIMEOUT_MS);
        r13 = "request airport ground location check, index=" + r10 + ", token=" + r8;
        goto L15
    }

    private void handleAirportGroundLocationCheckResult(int r8, int r10, Location r11, String r12) {
        if (r8 <= 0) goto L48;
        if (r10 > 0) goto L5;
        return;
    L5:
        if (this.mPendingAirportGroundLocationCheckToken == r8) goto L7;
        return;
    L7:
        if (this.mPendingAirportGroundLocationCheckIndex != r10) goto L51;
        clearPendingAirportGroundLocationCheck();
        if (isAirportFlightModeTokenValid(r8, 0) == true) goto L12;
    L43:
        StringBuilder r13 = defpackage.a.g("skip ground location check result index=", r10, ", token=", r8, ", currentToken=");
        r13.append(this.mAirportFlightModeToken.get());
        r13.append(", reportFinished=");
        r13.append(this.mAirportGroundReportFinished);
        r13.append(", source=");
        r13.append(r12);
        CommSenseLog.dWithMethodName(TAG, r13.toString());
        return;
    L12:
        if (this.mAirportGroundReportFinished == true) goto L43;
        List<AoiBoard> r14 = listTrafficAoiBoardsByType(AoiBoard.Type.AIRPORT);
        if (r14.isEmpty() == false) goto L20;
        CommSenseLog.wWithMethodName(TAG, "skip ground location check result: no airport aoi board, index=" + r10 + ", source=" + r12);
        if (r10 < AIRPORT_GROUND_CHECK_DELAY_MS.length) goto L45;
        cancelAirportGroundChecks();
        return;
    L45:
        return;
    L20:
        if (r11 != null) goto L25;
        CommSenseLog.dWithMethodName(TAG, "airport ground check unknown, index=" + r10 + ", source=" + r12);
        if (r10 < AIRPORT_GROUND_CHECK_DELAY_MS.length) goto L46;
        cancelAirportGroundChecks();
        return;
    L46:
        return;
    L25:
        AoiBoard r15 = findInsideAirportAoiBoardByLocation(r14, r11);
        if (r15 == null) goto L29;
        cancelAirportGroundChecks();
        reportAirportEnter(r15, true, defpackage.a.d("ground_check_inside_", r10));
        return;
    L29:
        this.mAirportGroundOutsideCheckCount++;
        StringBuilder r16 = defpackage.b.f("airport ground check outside, index=", r10, ", outsideCount=");
        r16.append(this.mAirportGroundOutsideCheckCount);
        r16.append(", source=");
        r16.append(r12);
        r16.append(", hasLocation=");
        r16.append(true);
        CommSenseLog.dWithMethodName(TAG, r16.toString());
        int r17 = this.mAirportGroundOutsideCheckCount;
        long[] r18 = AIRPORT_GROUND_CHECK_DELAY_MS;
        if (r17 < r18.length) goto L32;
        AoiBoard r19 = selectNearestAirportAoiBoard(r14, r11);
        if (r19 != null) goto L38;
        r19 = selectAirportAoiBoardForReport(r14);
    L38:
        if (r19 != null) goto L41;
        CommSenseLog.wWithMethodName(TAG, "skip ground outside report: no report aoi board");
        cancelAirportGroundChecks();
        return;
    L41:
        cancelAirportGroundChecks();
        reportAirportEnter(r19, false, "ground_check_all_outside");
        return;
    L32:
        if (r10 < r18.length) goto L47;
        cancelAirportGroundChecks();
        return;
    L47:
        return;
    L51:
        return;
    }

    private void handleFlightModeChanged(int r8) {
        if (r8 == 1) goto L8;
        if (r8 == 2) goto L8;
        if (r8 == 0) goto L8;
        CommSenseLog.dWithMethodName(TAG, "skip invalid flight mode state=" + r8);
        return;
    L8:
        int r10 = this.mLastHandledFlightModeState;
        if (r10 != r8) goto L13;
        CommSenseLog.dWithMethodName(TAG, "skip duplicate flight mode state=" + r8);
        return;
    L13:
        if (r8 != 2) goto L19;
        if (r10 == 1) goto L17;
        CommSenseLog.dWithMethodName(TAG, "skip invalid pre-landing transition, previousState=" + this.mLastHandledFlightModeState);
        return;
    L17:
        this.mLastHandledFlightModeState = r8;
        this.mPendingFlightModeState = -1;
        CommSenseLog.iWithMethodName(TAG, "record flight mode pre-landing, token=" + this.mAirportFlightModeToken.get());
        return;
    L19:
        this.mPendingFlightModeState = r8;
        int r11 = this.mAirportFlightModeToken.incrementAndGet();
        cancelAirportGroundChecks();
        this.mAirportGroundOutsideCheckCount = 0;
        CommSenseLog.iWithMethodName(TAG, "handle flight mode state=" + r8 + ", token=" + r11);
        if (r8 != 1) goto L22;
        boolean r12 = handleAirportFlying(r11);
    L23:
        if (r12 == false) goto L25;
        this.mLastHandledFlightModeState = r8;
        this.mPendingFlightModeState = -1;
        return;
    L25:
        CommSenseLog.dWithMethodName(TAG, "flight mode handling pending, state=" + r8);
        checkAndRunTrafficGeofences();
        return;
    L22:
        r12 = scheduleAirportGroundChecks(r11);
        goto L23
    }

    private void handlePendingAirportGroundLocationCheck(Location r8) {
        handleAirportGroundLocationCheckResult(this.mPendingAirportGroundLocationCheckToken, this.mPendingAirportGroundLocationCheckIndex, r8, QesdkUtils.TAGS.JSON_TAG_CALLBACK);
    }

    private boolean hasAoiBoardOfType(List<AoiBoard> r8, AoiBoard.Type r10) {
        if (r8 != null) goto L5;
        return false;
    L5:
        if (r8.isEmpty() == true) goto L23;
        Iterator<AoiBoard> r11 = r8.iterator();
    L9:
        if (r11.hasNext() == false) goto L24;
        AoiBoard r12 = r11.next();
        if (r12 == null) goto L9;
        if (r12.getType() != r10) goto L9;
        return true;
    L24:
        return false;
    L23:
        return false;
    }

    private boolean hasPreparedTrafficAoiBoards(String r8) {
        if (r8.equals(trafficPrefs().getString(KEY_TRAFFIC_SEARCH_CITY, "")) == true) goto L5;
        return false;
    L5:
        int r10 = getTrafficAoiBoardSearchState(KEY_AIRPORT_AOI_BOARD);
        int r11 = getTrafficAoiBoardSearchState(KEY_TRAIN_STATION_AOI_BOARD);
        int r12 = getTrafficAoiBoardSearchState(KEY_SUBWAY_STATION_AOI_BOARD);
        if (isTrafficAoiBoardSearchStateFinished(r10) == true) goto L8;
        return false;
    L8:
        if (isTrafficAoiBoardSearchStateFinished(r11) == true) goto L10;
        return false;
    L10:
        if (isTrafficAoiBoardSearchStateFinished(r12) == true) goto L13;
        return false;
    L13:
        if (r10 == 2) goto L18;
        if (r11 == 2) goto L18;
        if (r12 == 2) goto L18;
        List<AoiBoard> r13 = null;
    L19:
        if (r10 == 2) goto L21;
    L22:
        if (r11 == 2) goto L24;
    L25:
        if (r12 == 2) goto L27;
    L28:
        return true;
    L27:
        if (hasAoiBoardOfType(r13, AoiBoard.Type.SUBWAY_STATION) == true) goto L28;
        return false;
    L24:
        if (hasAoiBoardOfType(r13, AoiBoard.Type.TRAIN_STATION) == true) goto L25;
        return false;
    L21:
        if (hasAoiBoardOfType(r13, AoiBoard.Type.AIRPORT) == true) goto L22;
        return false;
    L18:
        r13 = listTrafficAoiBoards();
        goto L19
    }

    public static /* synthetic */ ExecutorService i(TrafficGeoManager r8) {
        return r8.trafficExecutor();
    }

    private void init() {
        LabFeatureChecker.registerProactiveAgentObserver(this.mAppContext, this.mProactiveAgentObserver);     // Catch: Throwable -> L4
        registerTrafficAwareCallbackIfNeeded();     // Catch: Throwable -> L4
        registerHighConfidenceCellPoiCallbackIfNeeded();     // Catch: Throwable -> L4
        checkAndRunTrafficGeofences();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "init register observer failed", th);
    }

    private boolean isAirportAoiBoardSearchFinished() {
        return isTrafficAoiBoardSearchStateFinished(getTrafficAoiBoardSearchState(KEY_AIRPORT_AOI_BOARD));
    }

    private boolean isAirportFlightModeTokenValid(int r8, int r10) {
        if (this.mAirportFlightModeToken.get() == r8) goto L5;
    L9:
        return false;
    L5:
        if (this.mLastHandledFlightModeState != r10) goto L7;
    L8:
        return true;
    L7:
        if (this.mPendingFlightModeState != r10) goto L9;
        goto L8
    }

    private boolean isTrafficAoiBoardSearchStateFinished(int r8) {
        if (r8 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r8 == (-1)) goto L8;
        return false;
    }

    private boolean isValidAoiBoard(AoiBoard r8) {
        if (r8 != null) goto L4;
    L8:
        return false;
    L4:
        if (r8.getPoiId().isEmpty() == true) goto L8;
        if (r8.getAoiBoard().isEmpty() == true) goto L8;
        return true;
    }

    private /* synthetic */ void lambda$handleAirportGroundCheck$3(int r8, int r10) {
        handleAirportGroundLocationCheckResult(r8, r10, null, "timeout");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "handleAirportGroundLocationCheckResult timeout error, index=" + r10, th);
    }

    private /* synthetic */ void lambda$handleAirportGroundCheck$4(final int r8, final int r10) {
        trafficExecutor().execute(new h(this, r8, r10));
    }

    private /* synthetic */ void lambda$new$0(int r8, String r10) {
        this.mLastHighConfidenceStationName.set(r10);
        CommSenseLog.i(TAG, "onHighConfidenceCellPoiStatusChange: cellPoiType=" + r8 + " stationName=" + r10);
        notifySubwayStationArrival(r10);
    }

    private /* synthetic */ void lambda$scheduleAirportGroundChecks$1(int r8, int r10) {
        handleAirportGroundCheck(r8, r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "handleAirportGroundCheck error, index=" + r10, th);
    }

    private /* synthetic */ void lambda$scheduleAirportGroundChecks$2(int r8, int r10) {
        if (this.mAirportFlightModeToken.get() == r8) goto L5;
        return;
    L5:
        trafficExecutor().execute(new com.obric.cae.location.c(r8, r10, 1, this));
    }

    private List<AoiBoard> listTrafficAoiBoards() {
        return aoiBoardManager().queryAoiBoardsByTypes(getTrafficAoiBoardTypes());
    }

    private List<AoiBoard> listTrafficAoiBoardsByType(AoiBoard.Type r8) {
        return aoiBoardManager().queryAoiBoardsByType(r8);
    }

    private List<StarGeofence> listTrafficGeofences() {
        return aoiBoardManager().listTrafficGeofences();
    }

    private boolean migrateTrafficAoiBoardsToLatestVersion(List<StarGeofence> r10, int r11) {
        if (getTrafficAoiBoardSearchState(KEY_AIRPORT_AOI_BOARD) == 2) goto L5;
    L8:
        boolean r8 = true;
    L10:
        if (r8 == true) goto L14;
        setTrafficVersion(2);
        StringBuilder r12 = new StringBuilder("traffic aoi board already latest, previousVersion=");
        r12.append(r11);
        r12.append(", currentVersion=2");
    L12:
        CommSenseLog.iWithMethodName(TAG, r12.toString());
        return true;
    L14:
        EnumSet<AoiBoard.Type> r13 = getVersionedTrafficAoiBoardTypes();
        int r14 = removeOldTrafficGeofences(r10, r13);
        boolean r15 = aoiBoardManager().replaceAoiBoardsByTypes(r13, null);
        boolean r16 = dbManager().deleteCityArchiveRootDir();
        if (r15 == false) goto L19;
        if (r16 == false) goto L19;
        this.mActiveTrafficCity.set(null);
        trafficPrefs().edit().putInt(KEY_AIRPORT_AOI_BOARD, 0).putInt(KEY_TRAIN_STATION_AOI_BOARD, 0).putInt(KEY_TRAFFIC_VERSION, 2).apply();
        r12 = new StringBuilder("finish traffic aoi board migration, previousVersion=");
        r12.append(r11);
        r12.append(", currentVersion=2, removedTrafficCount=");
        r12.append(r14);
    L19:
        CommSenseLog.wWithMethodName(TAG, "traffic aoi board migration failed, previousVersion=" + r11 + ", deletedAoiBoards=" + r15 + ", deletedArchiveRoot=" + r16);
        return false;
    L5:
        if (getTrafficAoiBoardSearchState(KEY_TRAIN_STATION_AOI_BOARD) != 2) goto L8;
        r8 = false;
        goto L10
    }

    private void notifySubwayStationArrival(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        Bundle r10 = new Bundle();
        r10.putLong("timestamp", System.currentTimeMillis());
        r10.putString(IStarPoiCallback.NEAR_THE_POI, "true");
        r10.putString(IStarPoiCallback.NEAR_THE_AOI, "false");
        r10.putString("poi_name", r8);
        r10.putString("new_type_name_l1", SUBWAY_NEW_TYPE_NAME_L1);
        r10.putString("new_type_name_l2", "地铁站");
        r10.putString("new_type_name_l3", "地铁站");
        r10.putString("new_type_code_l1", SUBWAY_NEW_TYPE_CODE_L1);
        r10.putString("new_type_code_l2", SUBWAY_NEW_TYPE_CODE_L2);
        r10.putString("new_type_code_l3", SUBWAY_NEW_TYPE_CODE);
        StarPoiManager.getInstance().notifyNearPoiReport(r10);
    }

    private TrafficSyncContext prepareTrafficSync(String r8) {
        List<StarGeofence> r10 = listTrafficGeofences();
        if (r10 != null) goto L7;
        CommSenseLog.wWithMethodName(TAG, "skip: traffic geofence list unavailable");
        scheduleRetryAddTrafficGeofences();
        return null;
    L7:
        if (ensureTrafficVersionMigrated(r10) == true) goto L10;
        scheduleRetryAddTrafficGeofences();
        return null;
    L10:
        String r11 = resolveTargetCity(r8);
        if (r11 != null) goto L13;
    L17:
        CommSenseLog.dWithMethodName(TAG, "skip: target city empty");
        return null;
    L13:
        if (r11.isEmpty() == true) goto L17;
        ensureTrafficSearchStateForCity(r11);
        boolean r12 = shouldReloadTrafficData(r11, dbManager().getCityInfoBySubAdminArea(r11));
        CommSenseLog.dWithMethodName(TAG, "traffic sync city=" + r11 + ", needReloadTrafficData=" + r12 + ", activeCity=" + this.mActiveTrafficCity.get() + ", existingTrafficCount=" + r10.size());
        return new TrafficSyncContext(r11, r10, r12);
    }

    private TrafficAoiQueryResult queryTrafficAoiBoards(String r17) {
        LinkedHashMap r12 = new LinkedHashMap();
        Map<String, String> r13 = new LinkedHashMap();
        Map<String, Integer> r14 = new LinkedHashMap();
        if (collectTrafficAoiBoardsForType(r12, r13, r14, r17, AIRPORT_SEARCH_KEYWORD, AIRPORT_NEW_TYPE_NAME, AIRPORT_NEW_TYPE_CODE, "airport", 1, KEY_AIRPORT_AOI_BOARD, AoiBoard.Type.AIRPORT) == true) goto L7;
        return new TrafficAoiQueryResult(false, new ArrayList(), new LinkedHashMap(), new LinkedHashMap());
    L7:
        if (collectTrafficAoiBoardsForType(r12, r13, r14, r17, "火车站", "火车站", TRAIN_NEW_TYPE_CODE, "train", 10, KEY_TRAIN_STATION_AOI_BOARD, AoiBoard.Type.TRAIN_STATION) == false) goto L9;
        r14.put(KEY_SUBWAY_STATION_AOI_BOARD, -1);
        return new TrafficAoiQueryResult(true, new ArrayList(r12.values()), r13, r14);
    L9:
        return new TrafficAoiQueryResult(false, new ArrayList(), new LinkedHashMap(), new LinkedHashMap());
    }

    private void reconcileTrafficGeofencesWithLocation(Location r8, List<StarGeofence> r10) {
        if (aoiBoardManager().reconcileTrafficGeofencesWithLocation(r8, r10) == true) goto L6;
        scheduleRetryAddTrafficGeofences();
        return;
    }

    private void recordLastInsideAoiBoard(AoiBoard r8) {
        if (r8.getEvent() == AoiBoard.Event.ENTER) goto L5;
        return;
    L5:
        if (r8.getPoiId().isEmpty() == true) goto L16;
        this.mLastInsideAoiBoard.set(StarAoiBoardManager.copyAoiBoard(r8));
        CommSenseLog.dWithMethodName(TAG, "record last inside aoi poiId=" + r8.getPoiId() + ", type=" + r8.getType() + ", eventTime=" + r8.getEventTime());
        if (r8.getType() == AoiBoard.Type.AIRPORT) goto L10;
        return;
    L10:
        if (this.mAirportGroundReportFinished == true) goto L15;
        cancelAirportGroundChecks();
        reportAirportEnter(r8, true, "ground_aoi_enter");
        return;
    L15:
        return;
    }

    private void refreshTrafficGeofencesByLocation(TrafficSyncContext r8) {
        Location r10 = LocationUtil.getInstance().getCurLocation("network", false, CommSenseLog.getMethodName());
        if (r10 == null) goto L6;
        reconcileTrafficGeofencesWithLocation(r10, r8.existingTrafficGeofences);
        return;
    }

    private void registerHighConfidenceCellPoiCallbackIfNeeded() {
        if (this.mHighConfidenceCellPoiCallbackRegistered.compareAndSet(false, true) == false) goto L6;
        CellPoiService.getInstance().addHighConfidenceCellPoiListener(this.mHighConfidenceCellPoiListener);
        return;
    }

    private void registerTrafficAwareCallbackIfNeeded() {
        if (this.mTrafficAwareCallbackRegistered.compareAndSet(false, true) == false) goto L6;
        UserAwareManager.getInstance().registerInnerCallback(this.mTrafficAwareCallback);
        return;
    }

    private boolean reloadTrafficDataForCity(String r8, List<StarGeofence> r10) {
        if (LocationUtil.getInstance().isNetworkValid() == true) goto L6;
        CommSenseLog.wWithMethodName(TAG, "skip reloadTrafficDataForCity: network invalid, city=" + r8);
        return false;
    L6:
        ensureTrafficSearchStateForCity(r8);
        TrafficAoiQueryResult r11 = queryTrafficAoiBoards(r8);
        if (r11.success == true) goto L10;
        scheduleRetryAddTrafficGeofences();
        return false;
    L10:
        int r12 = removeOldTrafficGeofences(r10);
        boolean r13 = aoiBoardManager().replaceAoiBoardsByTypes(getTrafficAoiBoardTypes(), r11.aoiBoards);
        CommSenseLog.dWithMethodName(TAG, "reloadTrafficDataForCity city=" + r8 + ", removedTrafficCount=" + r12 + ", trafficAoiBoardCount=" + r11.aoiBoards.size() + ", saved=" + r13);
        if (r13 == false) goto L13;
        StringBuilder r14 = defpackage.b.f("traffic new_type_code_l3 saved count=", StarLocationDbManager.getInstance(this.mAppContext, 0).updateAoiBoardNewTypeCodeL3s(r11.newTypeCodeL3ByPoiId), ", parsed count=");
        r14.append(r11.newTypeCodeL3ByPoiId.size());
        CommSenseLog.iWithMethodName(TAG, r14.toString());
        applyTrafficAoiBoardSearchStates(r8, r11.stateUpdates);
        this.mActiveTrafficCity.set(r8);
    L13:
        return r13;
    }

    private int removeOldTrafficGeofences(List<StarGeofence> r8) {
        return aoiBoardManager().removeOldTrafficGeofences(r8);
    }

    private void reportAirportEnter(AoiBoard r8, boolean r10, String r11) {
        StringBuilder r12 = defpackage.b.h("report airport enter reason=", r11, ", poiId=");
        r12.append(r8.getPoiId());
        r12.append(", inside=");
        r12.append(r10);
        CommSenseLog.iWithMethodName(TAG, r12.toString());
        StarLocationTeaReporter.reportAirportEnter(r8, r10);
    }

    private int resolveRestoredTrafficState(AoiBoard.Type r8, List<AoiBoard> r10) {
        if (hasAoiBoardOfType(r10, r8) == false) goto L5;
        return 2;
    L5:
        return 0;
    }

    private String resolveTargetCity(String r8) {
        if (r8 != null) goto L4;
    L6:
        StarLocationDbManager.CityInfo r10 = dbManager().getCityInfo();
        if (r10 != null) goto L10;
        return null;
    L10:
        return r10.subAdminArea;
    L4:
        if (r8.isEmpty() == true) goto L6;
        return r8;
    }

    private void retryPendingFlightModeIfNeeded() {
        int r8 = this.mPendingFlightModeState;
        if (r8 == 1) goto L7;
        if (r8 == 0) goto L7;
        return;
    L7:
        if (this.mLastHandledFlightModeState != r8) goto L10;
        this.mPendingFlightModeState = -1;
        return;
    L10:
        CommSenseLog.dWithMethodName(TAG, "retry pending flight mode state=" + r8);
        handleFlightModeChanged(r8);
    }

    private boolean scheduleAirportGroundChecks(int r10) {
        if (listTrafficAoiBoardsByType(AoiBoard.Type.AIRPORT).isEmpty() == false) goto L6;
        CommSenseLog.wWithMethodName(TAG, "skip ground airport checks: no airport aoi board, searchState=" + getTrafficAoiBoardSearchState(KEY_AIRPORT_AOI_BOARD));
        return isAirportAoiBoardSearchFinished();
    L6:
        int r8 = 0;
    L7:
        long[] r11 = AIRPORT_GROUND_CHECK_DELAY_MS;
        int r12 = 1;
        if (r8 >= r11.length) goto L10;
        int r13 = r8 + 1;
        long r14 = r11[r8];
        this.mMainHandler.postDelayed(new g(this, r10, r13, r12), this.mAirportGroundCheckHandlerToken, r14);
        CommSenseLog.dWithMethodName(TAG, "schedule airport ground check index=" + r13 + ", delayMs=" + r14 + ", token=" + r10);
        r8 = r13;
        goto L7
    L10:
        this.mAirportGroundReportFinished = false;
        return true;
    }

    private void scheduleRetryAddTrafficGeofences() {
        this.mTrafficSyncRunner.scheduleRetry();
    }

    private PoiSearchCollector.Result searchTrafficPoiCandidates(String r8, String r10, String r11, String r12, String r13, int r14) {
        return searchTrafficPoiCandidates(r8, Arrays.asList(new String[]{r10}), r11, r12, r13, r14);
    }

    private AoiBoard selectAirportAoiBoardForReport(List<AoiBoard> r8) {
        Iterator<AoiBoard> r10 = r8.iterator();
        AoiBoard r11 = null;
    L4:
        if (r10.hasNext() == false) goto L14;
        AoiBoard r12 = r10.next();
        if (r12 == null) goto L4;
        if (r12.getType() != AoiBoard.Type.AIRPORT) goto L4;
        if (r11 == null) goto L13;
        if (r12.getEventTime() <= r11.getEventTime()) goto L4;
    L13:
        r11 = r12;
        goto L4
    L14:
        return r11;
    }

    private AoiBoard selectNearestAirportAoiBoard(List<AoiBoard> r8, Location r10) {
        AoiBoard r11 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        Iterator<AoiBoard> r12 = r8.iterator();
        float r13 = Float.MAX_VALUE;
    L7:
        if (r12.hasNext() == false) goto L20;
        AoiBoard r14 = r12.next();
        if (r14 == null) goto L7;
        if (r14.getType() != AoiBoard.Type.AIRPORT) goto L7;
        if (r14.getAoiBoard().isEmpty() == true) goto L7;
        float r15 = AoiBoardUtil.calculateShortestDistanceToAoiBoard(r14.getAoiBoard(), r10.getLatitude(), r10.getLongitude());
        if (r11 == null) goto L19;
        if (r15 >= r13) goto L7;
    L19:
        r11 = r14;
        r13 = r15;
        goto L7
    L20:
        if (r11 == null) goto L22;
        CommSenseLog.dWithMethodName(TAG, "select nearest airport aoi poiId=" + r11.getPoiId() + ", distanceMeters=" + r13);
    L22:
        return r11;
    }

    private void setTrafficVersion(int r8) {
        trafficPrefs().edit().putInt(KEY_TRAFFIC_VERSION, r8).apply();
    }

    private boolean shouldReloadTrafficData(String r8, StarLocationDbManager.CityInfo r10) {
        String r11 = this.mActiveTrafficCity.get();
        if (r10 == null) goto L13;
        if (r11 == null) goto L10;
        if (r11.isEmpty() == true) goto L10;
        if (r8.equals(r11) == false) goto L13;
    L10:
        if (hasPreparedTrafficAoiBoards(r8) == false) goto L13;
        return false;
    L13:
        return true;
    }

    private synchronized ExecutorService trafficExecutor() {
        monitor-enter(this);
        ExecutorService r8 = this.mTrafficExecutor;     // Catch: Throwable -> L13
        if (r8 != null) goto L6;
    L9:
        this.mTrafficExecutor = Executors.newSingleThreadExecutor();     // Catch: Throwable -> L13
    L10:
        ExecutorService r10 = this.mTrafficExecutor;     // Catch: Throwable -> L13
        monitor-exit(this);
        return r10;
    L6:
        if (r8.isShutdown() == true) goto L9;
        if (this.mTrafficExecutor.isTerminated() == false) goto L10;
    L13:
        th = move-exception;
        throw th;
    }

    private SharedPreferences trafficPrefs() {
        return this.mAppContext.getSharedPreferences(TRAFFIC_PREF_NAME, 0);
    }

    private void tryAddPresetTrafficGeofencesIfNeeded(String r8) {
    L25:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, WsConstants.KEY_CONNECTION_ERROR, th);     // Catch: Throwable -> L30
        if (0 == 0) goto L41;
    L28:
        this.mTrafficSyncRunner.finishWork();
        return;
    L41:
        return;
    L30:
        th = move-exception;
        if (0 == 0) goto L33;
        this.mTrafficSyncRunner.finishWork();
    L33:
        throw th;
    L4:
        if (aoiBoardManager().isRecoveryFinished() == true) goto L7;
        CommSenseLog.dWithMethodName(TAG, "skip: aoi board recovery not finished");     // Catch: Throwable -> L25
        scheduleRetryAddTrafficGeofences();     // Catch: Throwable -> L25
        return;
    L7:
        boolean r10 = this.mTrafficSyncRunner.beginWork();     // Catch: Throwable -> L25
        if (r10 == true) goto L12;
        if (r10 == false) goto L37;
        this.mTrafficSyncRunner.finishWork();
        return;
    L37:
        return;
    L12:
        TrafficSyncContext r11 = prepareTrafficSync(r8);     // Catch: Throwable -> L25
        if (r11 != null) goto L18;
        if (r10 == false) goto L38;
        this.mTrafficSyncRunner.finishWork();
        return;
    L38:
        return;
    L18:
        if (ensureTrafficDataPrepared(r11) == true) goto L22;
        if (r10 == false) goto L39;
        this.mTrafficSyncRunner.finishWork();
        return;
    L39:
        return;
    L22:
        refreshTrafficGeofencesByLocation(r11);     // Catch: Throwable -> L25
        retryPendingFlightModeIfNeeded();     // Catch: Throwable -> L25
        if (r10 == true) goto L28;
    }

    private void unregisterHighConfidenceCellPoiCallbackIfNeeded() {
        if (this.mHighConfidenceCellPoiCallbackRegistered.compareAndSet(true, false) == false) goto L6;
        CellPoiService.getInstance().removeHighConfidenceCellPoiListener(this.mHighConfidenceCellPoiListener);
        return;
    }

    private void unregisterTrafficAwareCallbackIfNeeded() {
        if (this.mTrafficAwareCallbackRegistered.compareAndSet(true, false) == false) goto L6;
        UserAwareManager.getInstance().unregisterInnerCallback(this.mTrafficAwareCallback);
        return;
    }

    public void checkAndRunTrafficGeofences() {
        checkAndRunTrafficGeofences(null);
    }

    public void destroy() {
        LabFeatureChecker.unregisterProactiveAgentObserver(this.mAppContext, this.mProactiveAgentObserver);     // Catch: Throwable -> L4
    L6:
        this.mTrafficSyncRunner.destroy();
        this.mAirportFlightModeToken.incrementAndGet();
        cancelAirportGroundChecks();
        unregisterTrafficAwareCallbackIfNeeded();
        unregisterHighConfidenceCellPoiCallbackIfNeeded();
        monitor-enter(this);
        ExecutorService r8 = this.mTrafficExecutor;     // Catch: Throwable -> L15
        if (r8 != null) goto L23;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L23:
        r8.shutdownNow();     // Catch: Throwable -> L18
    L12:
        this.mTrafficExecutor = null;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L4:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "destroy unregister observer failed", th);
        goto L6
    }

    public String getLastHighConfidenceStationName() {
        return this.mLastHighConfidenceStationName.get();
    }

    public void onAddressResolved(Address r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        String r10 = r8.getSubAdminArea();
        if (r10 != null) goto L7;
    L11:
        CommSenseLog.dWithMethodName(TAG, "skip: subAdminArea is empty");
        return;
    L7:
        if (r10.isEmpty() == true) goto L11;
        checkAndRunTrafficGeofences(r10);
    }

    public void onCityStorageChanged(String r8, boolean r10) {
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        LinkedHashMap r11 = new LinkedHashMap();
        if (r10 == false) goto L8;
        List<AoiBoard> r12 = listTrafficAoiBoards();
        r11.put(KEY_AIRPORT_AOI_BOARD, Integer.valueOf(resolveRestoredTrafficState(AoiBoard.Type.AIRPORT, r12)));
        r11.put(KEY_TRAIN_STATION_AOI_BOARD, Integer.valueOf(resolveRestoredTrafficState(AoiBoard.Type.TRAIN_STATION, r12)));
        int r13 = Integer.valueOf(resolveRestoredTrafficState(AoiBoard.Type.SUBWAY_STATION, r12));
    L9:
        r11.put(KEY_SUBWAY_STATION_AOI_BOARD, r13);
        applyTrafficAoiBoardSearchStates(r8, r11);
        if (hasPreparedTrafficAoiBoards(r8) == false) goto L12;
        this.mActiveTrafficCity.set(r8);
    L13:
        CommSenseLog.dWithMethodName(TAG, "city=" + r8 + ", restoredFromArchive=" + r10 + ", stateUpdates=" + r11 + ", activeCity=" + this.mActiveTrafficCity.get());
        return;
    L12:
        this.mActiveTrafficCity.set(null);
        goto L13
    L8:
        r11.put(KEY_AIRPORT_AOI_BOARD, 0);
        r11.put(KEY_TRAIN_STATION_AOI_BOARD, 0);
        r13 = 0;
        goto L9
    }

    public void onServiceStarted() {
        init();
    }

    private void checkAndRunTrafficGeofences(String r8) {
        this.mTrafficSyncRunner.request(r8);
    }

    private boolean collectTrafficAoiBoardsForType(Map<String, AoiBoard> r19, Map<String, String> r20, Map<String, Integer> r21, String r22, List<String> r23, String r24, String r25, String r26, int r27, String r28, AoiBoard.Type r29) {
        int r8 = getTrafficAoiBoardSearchState(r28);
        if (r8 != 2) goto L13;
        List<AoiBoard> r10 = listTrafficAoiBoardsByType(r29);
        if (r10.isEmpty() == true) goto L12;
        ArrayList r11 = new ArrayList();
        Iterator<AoiBoard> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        AoiBoard r13 = r12.next();
        r19.put(r13.getPoiId(), r13);
        r11.add(r13.getPoiId());
        goto L8
    L10:
        r20.putAll(StarLocationDbManager.getInstance(this.mAppContext, 0).queryAoiBoardNewTypeCodeL3s(r11));
        CommSenseLog.dWithMethodName(TAG, r26 + " skip search for city=" + r22 + ", state=success, persistedCount=" + r10.size() + ", persistedNewTypeCodeL3Count=" + r20.size());
        return true;
    L12:
        CommSenseLog.wWithMethodName(TAG, r26 + " state=success but persisted boards missing, retry search");
    L16:
        PoiSearchCollector.Result r14 = searchTrafficPoiCandidates(r22, r23, r24, r25, r26, r27);
        if (r14.success == true) goto L21;
        CommSenseLog.wWithMethodName(TAG, r26 + " search failed, mark no_result, city=" + r22);
        r21.put(r28, -1);
        return true;
    L21:
        if (r14.candidates.isEmpty() == false) goto L24;
        r21.put(r28, -1);
        return true;
    L24:
        LinkedHashMap r15 = new LinkedHashMap();
        collectTrafficAoiBoards(r15, r20, r14.candidates, r29);
        if (r15.isEmpty() == false) goto L28;
        CommSenseLog.wWithMethodName(TAG, r26 + " search returned candidates but no valid aoi boards, city=" + r22);
        r21.put(r28, -1);
        return true;
    L28:
        r19.putAll(r15);
        r21.put(r28, 2);
        return true;
    L13:
        if (r8 != (-1)) goto L16;
        CommSenseLog.dWithMethodName(TAG, r26 + " skip search for city=" + r22 + ", state=no_result");
        return true;
    }

    private int removeOldTrafficGeofences(List<StarGeofence> r8, Set<AoiBoard.Type> r10) {
        return aoiBoardManager().removeOldTrafficGeofences(r8, r10);
    }

    private PoiSearchCollector.Result searchTrafficPoiCandidates(String r10, List<String> r11, String r12, String r13, String r14, int r15) {
        return PoiSearchCollector.collect(TAG, r10, r11, Arrays.asList(new String[]{buildTrafficSearchDsl(r10, r12, r13)}), POI_SEARCH_INDEX, r14, r15, true, new i());
    }
}
