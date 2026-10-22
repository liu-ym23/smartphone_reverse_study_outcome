package com.obric.cae.location.geofence;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Binder;
import android.os.PowerExemptionManager;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import androidx.activity.d;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.libs.location.geofence.IStarGeofenceCallback;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.location.StarLocationManager;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.location.geosdk.poi.StarAoiBoardManager;
import com.obric.cae.location.report.StarLocationReportBase;
import com.obric.cae.location.report.StarLocationReportFactory;
import com.obric.cae.location.report.StarLocationTeaReporter;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import r1.s;

/* JADX INFO: loaded from: classes.dex */
public class StarGeoCallback {
    private static final int BREACH_CONFIDENCE_DOWNGRADE_DISTANCE_METER = 1000;
    public static final String DYNAMIC_GEOFENCE_ID_PREFIX = "dynamic_geofence_id_";
    private static final int DYNAMIC_GEOFENCE_RADIUS_METER = 150;
    private static final int EQUAL_CONFIDENCE_CONFIRM_COUNT = 2;
    private static final int LOWER_CONFIDENCE_FORCE_ACCEPT_COUNT = 2;
    private static final int LOWER_CONFIDENCE_REQUEST_LOCATION_COUNT = 1;
    private static final long PENDING_REVERSE_EVENT_LOCATION_REQUEST_TIMEOUT_MS = 60000;
    private static final int REVERSE_EVENT_ACCEPT = 0;
    private static final int REVERSE_EVENT_IGNORE = 1;
    private static final int REVERSE_EVENT_IGNORE_AND_REQUEST_LOCATION = 2;
    private static final String TAG = "StarLocation-geoCallback";
    private static final long UNKNOWN_STATE_CONFIRMATION_WINDOW_MS = 90000;
    private static final ConcurrentHashMap<Integer, StarGeoCallback> sInstances = null;
    private final StarLocationDbManager dbManager;
    private final ConcurrentHashMap<String, BreachLocation> mBreachLocationMap;
    private final Context mContext;
    private final Object mGeofenceCallbackLock;
    private final RemoteCallbackList<IStarGeofenceCallback> mGeofenceCallbacks;
    private final ScheduledExecutorService mPendingReverseEventExecutor;
    private final ConcurrentHashMap<String, StarGeofence.GeoEvent> mPendingReverseEventMap;
    private final ConcurrentHashMap<String, Integer> mPendingReverseRejectCountMap;
    private final ConcurrentHashMap<String, Long> mPendingReverseStageTimeMap;
    private ScheduledFuture<?> mPendingReverseTimeoutFuture;
    private final Object mPendingReverseTimeoutLock;
    private final int mUserId;

    /* JADX INFO: renamed from: com.obric.cae.location.geofence.StarGeoCallback$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoEvent = null;

        static {
            int[] r8 = new int[StarGeofence.GeoEvent.values().length];
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoEvent = r8;
            r8[StarGeofence.GeoEvent.ENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoEvent[StarGeofence.GeoEvent.EXIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final class BreachLocation {
        private final float accuracy;
        private final int confidence;
        private final double latitude;
        private final double longitude;
        private final String provider;
        private final boolean simCardReady;
        private final int source;

        private BreachLocation(String r8, double r10, double r11, float r12, int r13, boolean r14, int r15) {
            this.provider = r8;
            this.latitude = r10;
            this.longitude = r11;
            this.accuracy = r12;
            this.source = r13;
            this.simCardReady = r14;
            this.confidence = r15;
        }

        public static /* synthetic */ int access$100(BreachLocation r8) {
            return r8.getConfidence();
        }

        public static /* synthetic */ double access$200(BreachLocation r8) {
            return r8.getLatitude();
        }

        public static /* synthetic */ double access$300(BreachLocation r8) {
            return r8.getLongitude();
        }

        public static /* synthetic */ BreachLocation access$400(BreachLocation r8, int r10) {
            return r8.withConfidence(r10);
        }

        public static /* synthetic */ BreachLocation access$500(Location r8, int r10, boolean r11, int r12) {
            return from(r8, r10, r11, r12);
        }

        private static BreachLocation from(Location r11, int r12, boolean r13, int r14) {
            return new BreachLocation(r11.getProvider(), r11.getLatitude(), r11.getLongitude(), r11.getAccuracy(), r12, r13, r14);
        }

        private int getConfidence() {
            return this.confidence;
        }

        private double getLatitude() {
            return this.latitude;
        }

        private double getLongitude() {
            return this.longitude;
        }

        private BreachLocation withConfidence(int r12) {
            return new BreachLocation(this.provider, this.latitude, this.longitude, this.accuracy, this.source, this.simCardReady, r12);
        }

        public String toString() {
            return "Breach Location:(" + this.provider + ", " + this.latitude + "," + this.longitude + ", " + this.accuracy + "), source=" + this.source + ", simCardReady=" + this.simCardReady + ", confidence=" + this.confidence;
        }
    }

    static {
        sInstances = new ConcurrentHashMap();
    }

    private StarGeoCallback(Context r8, int r10) {
        this.mGeofenceCallbackLock = new Object();
        this.mGeofenceCallbacks = new AnonymousClass1(this);
        this.mPendingReverseEventMap = new ConcurrentHashMap();
        this.mPendingReverseRejectCountMap = new ConcurrentHashMap();
        this.mPendingReverseStageTimeMap = new ConcurrentHashMap();
        this.mBreachLocationMap = new ConcurrentHashMap();
        this.mPendingReverseTimeoutLock = new Object();
        this.mPendingReverseEventExecutor = Executors.newSingleThreadScheduledExecutor();
        Context r11 = r8.getApplicationContext();
        this.mContext = r11;
        this.mUserId = r10;
        this.dbManager = StarLocationDbManager.getInstance(r11, r10);
    }

    public static /* synthetic */ void a(InnerAwareInfoCallback r8, StarGeofence r10, Location r11) {
        lambda$applyAcceptedEvent$0(r8, r10, r11);
    }

    public static /* synthetic */ int access$000(StarGeoCallback r8) {
        return r8.mUserId;
    }

    @SuppressLint({"NewApi"})
    private void addDynamicIndoorGeofence(Location r12) {
        StarGeofence r10 = new StarGeofence(this.mContext.getPackageName(), DYNAMIC_GEOFENCE_ID_PREFIX + r12.getElapsedRealtimeMillis(), r12.getLatitude(), r12.getLongitude(), 150, StarGeofence.GeoTransitionType.EXITED_ONLY);
        r10.setGeoType(StarGeofence.GeoType.INDOOR);
        CommSenseLog.dWithMethodName(TAG, r10.toString());     // Catch: RemoteException -> L5
        StarGeofenceManager.getInstance(this.mContext, this.mUserId).getBinder().addGeofence(r10);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "addDynamicIndoorGeofence failed.", e);
    }

    private void appendGeofencesByState(List<StarGeofence> r8, List<StarGeofence> r10, StarGeofence.GeoState r11) {
        Iterator<StarGeofence> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        StarGeofence r13 = r12.next();
        if (r13 == null) goto L4;
        if (r13.getGeoState() != r11) goto L4;
        r10.add(r13);
        goto L4
    }

    private boolean applyAcceptedEvent(StarGeofence r26, long r27, StarGeofence.GeoEvent r29, Location r30, int r31, int r32, boolean r33, float r34) {
        int r8 = AnonymousClass2.$SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoEvent[r29.ordinal()];
        int r15 = 0;
        if (r8 != 1) goto L5;
        CommSenseLog.i(TAG, "set StarGeofence INSIDE from " + r31);
        StarGeofence.GeoState r10 = StarGeofence.GeoState.INSIDE;
    L10:
        r26.setGeoState(r10);
        r26.setEventTimestamp(r27);
        String r11 = r26.getGeofenceId();
        if (r11 != null) goto L14;
        CommSenseLog.e(TAG, "geofenceId is null");
        return false;
    L14:
        StarGeofenceManager.getInstance(this.mContext, this.mUserId).removeUnknownStateGeofence(r11);
        clearPendingReverseEvent(r11);
        this.mBreachLocationMap.put(r11, BreachLocation.access$500(r30, r31, r33, StarLocationManager.getInstance().getLocationConfidence(r30)));
        if ((r26.getTransitionType().getValue() & r26.getGeoState().getValue()) != 0) goto L18;
        CommSenseLog.d(TAG, "No registered transition events for this geofence, skipping callback.");
        return false;
    L18:
        int r12 = this.dbManager.queryGeofenceUserIdById(r11);
        boolean r16 = this.dbManager.advanceGeofenceFirstBreachForNotification(r26);
        this.dbManager.updateGeofence(r26, r12);
        StarLocationReportBase r13 = StarLocationReportFactory.getReportInstance();
        if (r13 == null) goto L22;
        r13.recordBreachEvent(r27, r30, r11, r31, r32, r29, r34, r16);
    L22:
        StarLocationTeaReporter.reportBreachEvent(r27, r30, r11, r31, r32, r29, r34, r16);
        String r14 = r26.getPackageName();
        boolean r17 = isDynamicIndoorGeofence(r26, r11);
        UserAwareManager.getInstance().notifyInnerCallbacks(new a(r15), r26, new Location(r30));
        CommSenseLog.dumpI(TAG, "run geofence callback, event:" + r29.getValue() + ", responseRate=" + r34 + ", " + logBreachLocation(r30, r31, r33) + ", " + r26, StarGeofenceManager.getGeofenceLogFile(this.mUserId));
        PowerExemptionManager r19 = (PowerExemptionManager) this.mContext.getSystemService(PowerExemptionManager.class);
        StringBuilder r18 = new StringBuilder("packageName = ");
        r18.append(r14);
        CommSenseLog.d(TAG, r18.toString());
        r19.addToTemporaryAllowList(r14, 100, "need 30 seconds to execute restricted actions.", 30000);
        if (StarAoiBoardManager.hasBoundAoiBoard(this.mContext, r12, r26) == true) goto L48;
        ArrayList r20 = new ArrayList();
        Object r21 = this.mGeofenceCallbackLock;
        monitor-enter(r21);
        int r22 = this.mGeofenceCallbacks.beginBroadcast();     // Catch: Throwable -> L45
    L27:
        if (r15 >= r22) goto L35;
    L32:
        th = move-exception;
        this.mGeofenceCallbacks.finishBroadcast();     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L29:
        if (r14.equals(this.mGeofenceCallbacks.getBroadcastCookie(r15)) == false) goto L31;
        r20.add((IStarGeofenceCallback) this.mGeofenceCallbacks.getBroadcastItem(r15));     // Catch: Throwable -> L32
    L31:
        r15 = r15 + 1;
        goto L27
    L35:
        this.mGeofenceCallbacks.finishBroadcast();     // Catch: Throwable -> L45
        monitor-exit(r21);     // Catch: Throwable -> L45
        Iterator r23 = r20.iterator();
    L39:
        if (r23.hasNext() == false) goto L48;
        ((IStarGeofenceCallback) r23.next()).onBreachReport(r11, r30, r29.ordinal());     // Catch: RemoteException -> L43
    L43:
        e = move-exception;
        StringBuilder r24 = defpackage.b.i("onBreachReport failed, packageName=", r14, ", geofenceId=", r11, ", error=");
        r24.append(e.getMessage());
        CommSenseLog.dumpI(TAG, r24.toString(), StarGeofenceManager.getGeofenceLogFile(this.mUserId));
    L45:
        th = move-exception;
        throw th;
    L48:
        return r17;
    L5:
        if (r8 == 2) goto L8;
        CommSenseLog.i(TAG, "set StarGeofence UNKNOWN");
        r26.setGeoState(StarGeofence.GeoState.UNKNOWN);
        return false;
    L8:
        CommSenseLog.i(TAG, "set StarGeofence OUTSIDE from " + r31);
        r10 = StarGeofence.GeoState.OUTSIDE;
        goto L10
    }

    public static /* synthetic */ void b(StarGeoCallback r8) {
        r8.onPendingReverseEventTimeout();
    }

    public static /* synthetic */ void c(StarGeoCallback r8, Location r10, int r11) {
        r8.lambda$engineStatusReport$1(r10, r11);
    }

    private void clearGeofenceEventCache(String r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        clearPendingReverseEvent(r8);
        this.mBreachLocationMap.remove(r8);
    }

    private void clearPendingReverseEvent(String r8) {
        this.mPendingReverseEventMap.remove(r8);
        this.mPendingReverseRejectCountMap.remove(r8);
        this.mPendingReverseStageTimeMap.remove(r8);
        Object r10 = this.mPendingReverseTimeoutLock;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingReverseStageTimeMap.isEmpty() == false) goto L9;
        ScheduledFuture<?> r11 = this.mPendingReverseTimeoutFuture;     // Catch: Throwable -> L11
        if (r11 == null) goto L9;
        r11.cancel(false);     // Catch: Throwable -> L11
        this.mPendingReverseTimeoutFuture = null;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L11
    }

    private void deleteDynamicGeofence(StarGeofence r8) {
        String r10 = r8.getGeofenceId();
        if (r10 != null) goto L6;
        CommSenseLog.e(TAG, "geofenceId is null");
        return;
    L6:
        clearGeofenceEventCache(r10);
        CommSenseLog.d(TAG, "deleteDynamicGeofence: ".concat(r10));     // Catch: RemoteException -> L9
        StarGeofenceManager.getInstance(this.mContext, this.mUserId).getBinder().deleteGeofence(r8);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "deleteDynamicGeofence failed.", e);
    }

    private BreachLocation getActiveBreachLocation(String r8, BreachLocation r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (LocationUtil.getInstance().hasLargeMovement() == true) goto L8;
        return r10;
    L8:
        int r11 = StarLocationManager.getInstance().downgradeConfidenceAfterLargeMovement(BreachLocation.access$100(r10));
        if (r11 != BreachLocation.access$100(r10)) goto L11;
        return r10;
    L11:
        BreachLocation r12 = BreachLocation.access$400(r10, r11);
        this.mBreachLocationMap.put(r8, r12);
        CommSenseLog.iWithMethodName(TAG, "downgrade breach location confidence after large movement, geofenceId=" + r8 + ", previousConfidence=" + BreachLocation.access$100(r10) + ", downgradedConfidence=" + r11);
        return r12;
    }

    public static synchronized StarGeoCallback getInstance(Context r8, int r10) {
        monitor-enter(StarGeoCallback.class);
        ConcurrentHashMap<Integer, StarGeoCallback> r11 = sInstances;     // Catch: Throwable -> L9
        StarGeoCallback r12 = r11.get(Integer.valueOf(r10));     // Catch: Throwable -> L9
        if (r12 != null) goto L7;
        r12 = new StarGeoCallback(r8, r10);     // Catch: Throwable -> L9
        r11.put(Integer.valueOf(r10), r12);     // Catch: Throwable -> L9
    L7:
        monitor-exit(StarGeoCallback.class);
        return r12;
    L9:
        th = move-exception;
        throw th;
    }

    private void handleSameStateEvent(StarGeofence r8, StarGeofence.GeoEvent r10, Location r11, int r12, boolean r13) {
        String r14 = r8.getGeofenceId();
        if (r14 != null) goto L6;
        CommSenseLog.e(TAG, "geofenceId is null");
        return;
    L6:
        StarGeofence.GeoEvent r15 = this.mPendingReverseEventMap.get(r14);
        int r16 = StarLocationManager.getInstance().getLocationConfidence(r11);
        if (r15 == null) goto L10;
        if (r15 == r10) goto L10;
        StringBuilder r17 = defpackage.b.h("cancel staged reverse geofence event, geofenceId=", r14, ", currentState=");
        r17.append(r8.getGeoState());
        r17.append(", supportEvent=");
        r17.append(r10);
        CommSenseLog.dumpI(TAG, r17.toString(), StarGeofenceManager.getGeofenceLogFile(this.mUserId));
        clearPendingReverseEvent(r14);
    L10:
        BreachLocation r18 = getActiveBreachLocation(r14, this.mBreachLocationMap.get(r14));
        if (r18 != null) goto L13;
    L16:
        this.mBreachLocationMap.put(r14, BreachLocation.access$500(r11, r12, r13, r16));
        return;
    L13:
        if (BreachLocation.access$100(r18) <= r16) goto L16;
        CommSenseLog.dWithMethodName(TAG, "ignore breach location with lower confidence, geofenceId=" + r14 + ", currentConfidence=" + r16 + ", previousConfidence=" + BreachLocation.access$100(r18) + ", event=" + r10 + ", source=" + r12);
    }

    private boolean isDynamicIndoorGeofence(StarGeofence r8, String r10) {
        if (r8.getGeoType() == StarGeofence.GeoType.INDOOR) goto L5;
    L9:
        return false;
    L5:
        if (this.mContext.getPackageName().equalsIgnoreCase(r8.getPackageName()) == false) goto L9;
        if (r10.startsWith(DYNAMIC_GEOFENCE_ID_PREFIX) == false) goto L9;
        return true;
    }

    private static /* synthetic */ void lambda$applyAcceptedEvent$0(InnerAwareInfoCallback r8, StarGeofence r10, Location r11) {
        r8.onGeofenceInfoChange(r10, r11);
    }

    private /* synthetic */ void lambda$engineStatusReport$1(Location r8, int r10) {
        int r11 = 0;
        if (r8 == null) goto L5;
    L7:
        ArrayList r12 = new ArrayList();
        Object r13 = this.mGeofenceCallbackLock;
        monitor-enter(r13);
        int r14 = this.mGeofenceCallbacks.beginBroadcast();     // Catch: Throwable -> L30
    L10:
        if (r11 >= r14) goto L16;
        r12.add((IStarGeofenceCallback) this.mGeofenceCallbacks.getBroadcastItem(r11));     // Catch: Throwable -> L13
        r11 = r11 + 1;
        goto L10
    L13:
        th = move-exception;
        this.mGeofenceCallbacks.finishBroadcast();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L16:
        this.mGeofenceCallbacks.finishBroadcast();     // Catch: Throwable -> L30
        monitor-exit(r13);     // Catch: Throwable -> L30
        Iterator r15 = r12.iterator();
    L20:
        if (r15.hasNext() == false) goto L26;
        ((IStarGeofenceCallback) r15.next()).onGeofenceStatusReport(r10, r8);     // Catch: RemoteException -> L24
    L24:
        e = move-exception;
        CommSenseLog.e(TAG, "onEngineStatusReport failed.", e);
        goto L20
    L26:
        UserAwareManager.getInstance().notifyInnerCallbacks(new s(3), Integer.valueOf(r10));
        CommSenseLog.dumpI(TAG, "engineStatusReport, status: " + r10 + ", location: " + r8, StarGeofenceManager.getGeofenceLogFile(this.mUserId));
        if (r8 == null) goto L43;
        processIndoorEvent(r10, r8);
        return;
    L43:
        return;
    L30:
        th = move-exception;
        throw th;
    L5:
        if (r10 != 1) goto L7;
        CommSenseLog.d(TAG, "indoor engineStatusReport: location is null, try to get");
        r8 = LocationUtil.getInstance().requestSingleLocationUpdates("network", false, "engineStatusReport");
        goto L7
    }

    private String logBreachLocation(Location r8, int r10, boolean r11) {
        return BreachLocation.access$500(r8, r10, r11, StarLocationManager.getInstance().getLocationConfidence(r8)).toString();
    }

    private void logStagedReverseEvent(StarGeofence.GeoEvent r8, int r10, String r11, int r12, int r13, int r14, String r15) {
        StringBuilder r16 = new StringBuilder("stage reverse geofence event=");
        r16.append(r8);
        r16.append(", reason=");
        r16.append(r15);
        r16.append(", source=");
        r16.append(r10);
        r16.append(", geofenceId=");
        r16.append(r11);
        r16.append(", currentConfidence=");
        defpackage.b.q(r16, r12, ", previousConfidence=", r13, ", rejectedCount=");
        r16.append(r14);
        CommSenseLog.iWithMethodName(TAG, r16.toString());
    }

    public static void notifyEngineStatusReportToAllUsers(Context r8, int r10, Location r11) {
        UserManager r12 = (UserManager) r8.getSystemService("user");
        if (r12 == null) goto L8;
        Iterator<UserHandle> r13 = r12.getUserProfiles().iterator();
    L6:
        if (r13.hasNext() == false) goto L11;
        getInstance(r8, r13.next().getIdentifier()).engineStatusReport(r10, r11);
        goto L6
    L11:
        return;
    L8:
        getInstance(r8, 0).engineStatusReport(r10, r11);
    }

    private void onPendingReverseEventTimeout() {
        long r8 = SystemClock.elapsedRealtime();
        Object r10 = this.mPendingReverseTimeoutLock;
        monitor-enter(r10);
        this.mPendingReverseTimeoutFuture = null;     // Catch: Throwable -> L23
        Iterator<Map.Entry<String, Long>> r11 = this.mPendingReverseStageTimeMap.entrySet().iterator();     // Catch: Throwable -> L23
        boolean r12 = false;
    L7:
        if (r11.hasNext() == false) goto L17;
        Map.Entry<String, Long> r13 = r11.next();     // Catch: Throwable -> L23
        String r14 = r13.getKey();     // Catch: Throwable -> L23
        Long r15 = r13.getValue();     // Catch: Throwable -> L23
        StarGeofence.GeoEvent r16 = this.mPendingReverseEventMap.get(r14);     // Catch: Throwable -> L23
        if (r16 == null) goto L16;
        if (r15 == null) goto L16;
        if ((r8 - r15.longValue()) < 60000) goto L7;
        this.mPendingReverseStageTimeMap.remove(r14, r15);     // Catch: Throwable -> L23
        CommSenseLog.iWithMethodName(TAG, "pending reverse geofence event timeout, geofenceId=" + r14 + ", event=" + r16 + ", timeoutMs=60000");     // Catch: Throwable -> L23
        r12 = true;
    L16:
        this.mPendingReverseStageTimeMap.remove(r14);     // Catch: Throwable -> L23
        goto L7
    L17:
        scheduleNextPendingReverseEventTimeoutLocked(r8);     // Catch: Throwable -> L23
        monitor-exit(r10);     // Catch: Throwable -> L23
        if (r12 == true) goto L21;
        return;
    L21:
        CommSenseLog.iWithMethodName(TAG, "request fused location for pending reverse geofence event timeout");
        LocationUtil r17 = LocationUtil.getInstance();
        r17.setDisableNlpWifiCache(true);
        r17.getCurLocation("fused", true, CommSenseLog.getMethodName());
        return;
    L23:
        th = move-exception;
        throw th;
    }

    private List<StarGeofence> orderGeofencesForEventCalculation(List<StarGeofence> r8) {
        ArrayList r10 = new ArrayList(r8.size());
        appendGeofencesByState(r8, r10, StarGeofence.GeoState.INSIDE);
        appendGeofencesByState(r8, r10, StarGeofence.GeoState.UNKNOWN);
        appendGeofencesByState(r8, r10, StarGeofence.GeoState.OUTSIDE);
        Iterator<StarGeofence> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        StarGeofence r12 = r11.next();
        if (r12 == null) goto L9;
        if (r12.getGeoState() != null) goto L4;
    L9:
        r10.add(r12);
        goto L4
    L10:
        return r10;
    }

    private void processIndoorEvent(int r14, Location r15) {
        if (r14 == 1) goto L28;
        return;
    L28:
        List<StarGeofence> r16 = StarGeofenceManager.getInstance(this.mContext, this.mUserId).getBinder().listGeofences(this.mContext.getPackageName());     // Catch: RemoteException -> L25
        if (r16 != null) goto L8;
    L23:
        CommSenseLog.d(TAG, "no geofence found.");     // Catch: RemoteException -> L25
        return;
    L8:
        if (r16.isEmpty() == true) goto L23;
        Iterator<StarGeofence> r17 = r16.iterator();
    L12:
        if (r17.hasNext() == false) goto L21;
        StarGeofence r8 = r17.next();
        if (r8.getGeoType() == StarGeofence.GeoType.HOME) goto L18;
        if (r8.getGeoType() != StarGeofence.GeoType.COMPANY) goto L12;
    L18:
        if (LocationUtil.getInstance().calculateDistance(r8.getLatitude(), r8.getLongitude(), r15.getLatitude(), r15.getLongitude()) > 150.0d) goto L12;
        CommSenseLog.i(TAG, "no need to create dynamic geofence.");
        return;
    L21:
        addDynamicIndoorGeofence(r15);
        return;
    L25:
        e = move-exception;
        CommSenseLog.e(TAG, "listGeofences failed.", e);
    }

    private StarGeofence.GeoEvent resolveAmbiguousReverseEvent(StarGeofence.GeoState r8, double r10, double r11) {
        if (r8 != StarGeofence.GeoState.INSIDE) goto L9;
        if (r10 <= r11) goto L9;
        return StarGeofence.GeoEvent.EXIT;
    L9:
        if (r8 != StarGeofence.GeoState.OUTSIDE) goto L15;
        if (r10 >= r11) goto L15;
        return StarGeofence.GeoEvent.ENTER;
    L15:
        return StarGeofence.GeoEvent.UNKNOWN;
    }

    private void scheduleNextPendingReverseEventTimeoutLocked(long r10) {
        Iterator<Long> r8 = this.mPendingReverseStageTimeMap.values().iterator();
        long r11 = Long.MAX_VALUE;
    L4:
        if (r8.hasNext() == false) goto L10;
        Long r12 = r8.next();
        if (r12 == null) goto L4;
        r11 = Math.min(r11, Math.max(0, 60000 - (r10 - r12.longValue())));
        goto L4
    L10:
        if (r11 == Long.MAX_VALUE) goto L18;
        this.mPendingReverseTimeoutFuture = this.mPendingReverseEventExecutor.schedule(new d(this, 19), r11, TimeUnit.MILLISECONDS);
        return;
    }

    private void schedulePendingReverseEventTimeoutIfNeeded() {
        Object r8 = this.mPendingReverseTimeoutLock;
        monitor-enter(r8);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingReverseTimeoutFuture == null) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L8:
        scheduleNextPendingReverseEventTimeoutLocked(SystemClock.elapsedRealtime());     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
    }

    private boolean shouldConfirmRecentPersistedState(StarGeofence r8, BreachLocation r10, long r11) {
        if (r10 == null) goto L6;
        return false;
    L6:
        if (r8.getGeoState() != StarGeofence.GeoState.UNKNOWN) goto L8;
        return false;
    L8:
        long r12 = r8.getEventTimestamp();
        if (r12 > 0) goto L11;
        return false;
    L11:
        if (r11 >= r12) goto L13;
        return false;
    L13:
        if ((r11 - r12) > 90000) goto L18;
        return true;
    L18:
        return false;
    }

    private boolean shouldDeleteExitedDynamicGeofence(StarGeofence r8, String r10) {
        if (r8.getGeoState() == StarGeofence.GeoState.OUTSIDE) goto L5;
    L7:
        return false;
    L5:
        if (isDynamicIndoorGeofence(r8, r10) == false) goto L7;
        return true;
    }

    private int shouldStageReverseEvent(StarGeofence r17, StarGeofence.GeoEvent r18, Location r19, long r20, int r22) {
        StarGeofence.GeoState r8 = r17.getGeoState();
        if (r8 != StarGeofence.GeoState.OUTSIDE) goto L7;
        if (r18 != StarGeofence.GeoEvent.ENTER) goto L7;
    L10:
        boolean r10 = true;
    L12:
        if (r10 == true) goto L14;
        return 0;
    L14:
        String r11 = r17.getGeofenceId();
        if (r11 != null) goto L18;
        CommSenseLog.eWithMethodName(TAG, "geofenceId is null");
        return 0;
    L18:
        StarGeofence.GeoEvent r12 = this.mPendingReverseEventMap.get(r11);
        if (r12 == null) goto L22;
        if (r12 == r18) goto L22;
        clearPendingReverseEvent(r11);
    L22:
        BreachLocation r13 = getActiveBreachLocation(r11, this.mBreachLocationMap.get(r11));
        if (r13 != null) goto L25;
        int r14 = 0;
    L26:
        int r15 = StarLocationManager.getInstance().getLocationConfidence(r19);
        if (r15 != 0) goto L30;
        logStagedReverseEvent(r18, r22, r11, r15, r14, stageReverseEvent(r11, r18), "zero confidence reverse");
        return 2;
    L30:
        if (r13 == null) goto L53;
        if (r15 <= r14) goto L36;
        clearPendingReverseEvent(r11);
        CommSenseLog.dWithMethodName(TAG, "accept reverse event=" + r18 + ", source=" + r22 + ", geofenceId=" + r11 + ", currentConfidence=" + r15 + ", previousConfidence=" + r14);
        return 0;
    L36:
        if (r15 != r14) goto L43;
        int r16 = stageReverseEvent(r11, r18);
        if (r16 < 2) goto L41;
        clearPendingReverseEvent(r11);
        CommSenseLog.dWithMethodName(TAG, "accept reverse event=" + r18 + ", source=" + r22 + ", geofenceId=" + r11 + ", confidence=" + r15 + ", rejectedCount=" + r16);
        return 0;
    L41:
        logStagedReverseEvent(r18, r22, r11, r15, r14, r16, "equal confidence");
        return 1;
    L43:
        int r21 = stageReverseEvent(r11, r18);
        if (r21 < 2) goto L47;
        clearPendingReverseEvent(r11);
        CommSenseLog.dWithMethodName(TAG, "accept reverse event=" + r18 + ", source=" + r22 + ", geofenceId=" + r11 + ", currentConfidence=" + r15 + ", previousConfidence=" + r14 + ", rejectedCount=" + r21);
        return 0;
    L47:
        logStagedReverseEvent(r18, r22, r11, r15, r14, r21, "lower confidence");
        if (r21 >= 1) goto L62;
        return 1;
    L62:
        return 2;
    L53:
        if (shouldConfirmRecentPersistedState(r17, null, r20) == false) goto L59;
        int r23 = stageReverseEvent(r11, r18);
        logStagedReverseEvent(r18, r22, r11, r15, r14, r23, "recent persisted state");
        if (r23 < 1) goto L58;
        return 2;
    L58:
        return 1;
    L59:
        if (r12 != r18) goto L61;
        clearPendingReverseEvent(r11);
    L61:
        return 0;
    L25:
        r14 = BreachLocation.access$100(r13);
    L7:
        if (r8 == StarGeofence.GeoState.INSIDE) goto L9;
    L11:
        r10 = false;
        goto L12
    L9:
        if (r18 != StarGeofence.GeoEvent.EXIT) goto L11;
        goto L10
    }

    private int stageReverseEvent(String r8, StarGeofence.GeoEvent r10) {
        StarGeofence.GeoEvent r11 = this.mPendingReverseEventMap.get(r8);
        int r12 = 1;
        if (r11 != r10) goto L9;
        Integer r13 = this.mPendingReverseRejectCountMap.get(r8);
        if (r13 != null) goto L7;
        int r14 = 1;
    L8:
        r12 = 1 + r14;
        goto L9
    L7:
        r14 = r13.intValue();
    L9:
        if (r11 == r10) goto L11;
    L12:
        this.mPendingReverseStageTimeMap.put(r8, Long.valueOf(SystemClock.elapsedRealtime()));
    L13:
        this.mPendingReverseEventMap.put(r8, r10);
        this.mPendingReverseRejectCountMap.put(r8, Integer.valueOf(r12));
        schedulePendingReverseEventTimeoutIfNeeded();
        return r12;
    L11:
        if (this.mPendingReverseStageTimeMap.containsKey(r8) == true) goto L13;
        goto L12
    }

    private void updateBreachLocationConfidenceByCurrentLocation(Location r15) {
        LocationUtil r10 = LocationUtil.getInstance();
        int r11 = StarLocationManager.getInstance().getLocationConfidence(r15);
        Iterator<Map.Entry<String, BreachLocation>> r12 = this.mBreachLocationMap.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L15;
        Map.Entry<String, BreachLocation> r8 = r12.next();
        String r13 = r8.getKey();
        BreachLocation r14 = r8.getValue();
        if (r13 == null) goto L4;
        if (r14 == null) goto L4;
        if (r11 <= BreachLocation.access$100(r14)) goto L4;
        double r16 = r10.calculateDistance(r15.getLatitude(), r15.getLongitude(), BreachLocation.access$200(r14), BreachLocation.access$300(r14));
        if (r16 <= 1000.0d) goto L4;
        int r17 = StarLocationManager.getInstance().downgradeConfidence(BreachLocation.access$100(r14));
        this.mBreachLocationMap.put(r13, BreachLocation.access$400(r14, r17));
        CommSenseLog.dWithMethodName(TAG, "downgrade breach location confidence, geofenceId=" + r13 + ", distance=" + r16 + ", currentConfidence=" + r11 + ", previousConfidence=" + BreachLocation.access$100(r14) + ", downgradedConfidence=" + r17);
        goto L4
    }

    public synchronized void calculateGeofenceEvent(Location r25, int r26, int r27) {
        monitor-enter(this);
        CommSenseLog.dWithMethodName(TAG, "source=" + r27);     // Catch: Throwable -> L36
        if (r25 != null) goto L9;
        CommSenseLog.vWithMethodName(TAG, "location is null");     // Catch: Throwable -> L36
        monitor-exit(this);
        return;
    L9:
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L36
        Iterator<StarGeofence> r14 = orderGeofencesForEventCalculation(this.dbManager.queryAllGeofences()).iterator();     // Catch: Throwable -> L36
    L11:
        if (r14.hasNext() == false) goto L34;
        StarGeofence r8 = r14.next();     // Catch: Throwable -> L36
        if (r8 == null) goto L14;
        String r10 = r8.getGeofenceId();     // Catch: Throwable -> L36
        if (r10 == null) goto L17;
        int r11 = this.dbManager.queryGeofenceUserIdById(r10);     // Catch: Throwable -> L36
        if (StarLocationDbManager.matchesUserId(r11, r26) == false) goto L20;
        double r15 = LocationUtil.getInstance().calculateDistance(r25.getLatitude(), r25.getLongitude(), r8.getLatitude(), r8.getLongitude());     // Catch: Throwable -> L36
        if (r15 >= (r25.getAccuracy() + r8.getRadius())) goto L23;
        if (r8.getRadius() >= r25.getAccuracy()) goto L28;
    L30:
        StarGeofence.GeoEvent r13 = resolveAmbiguousReverseEvent(r8.getGeoState(), r15, r8.getRadius());     // Catch: Throwable -> L36
        if (r13 == StarGeofence.GeoEvent.UNKNOWN) goto L11;
        CommSenseLog.vWithMethodName(TAG, "calculate ambiguous reverse geofence, source=" + r27 + ", event=" + r13 + ", geofenceId=" + r10);     // Catch: Throwable -> L36
    L24:
        eventNotify(r12, r13, r8, r25, r27, r15);     // Catch: Throwable -> L36
        goto L11
    L28:
        if (r15 > (r8.getRadius() - r25.getAccuracy())) goto L30;
        CommSenseLog.vWithMethodName(TAG, "calculate enter geofence, source=" + r27 + ", geofenceId=" + r10);     // Catch: Throwable -> L36
        r13 = StarGeofence.GeoEvent.ENTER;     // Catch: Throwable -> L36
        goto L24
    L23:
        CommSenseLog.vWithMethodName(TAG, "calculate exit geofence, source=" + r27 + ", geofenceId=" + r10);     // Catch: Throwable -> L36
        r13 = StarGeofence.GeoEvent.EXIT;     // Catch: Throwable -> L36
        goto L24
    L20:
        CommSenseLog.vWithMethodName(TAG, "skip geofence by user mismatch, currentUserId=" + r26 + ", geofenceUserId=" + r11 + ", geofenceId=" + r10);     // Catch: Throwable -> L36
        goto L11
    L17:
        CommSenseLog.eWithMethodName(TAG, "geofenceId is null");     // Catch: Throwable -> L36
        goto L11
    L14:
        CommSenseLog.vWithMethodName(TAG, "starGeofence is null");     // Catch: Throwable -> L36
        goto L11
    L34:
        monitor-exit(this);
        return;
    L36:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"InlinedApi"})
    public void engineStatusReport(int r8, Location r10) {
        CommSenseLog.d(TAG, "engineStatusReport, status: " + r8 + ", location: " + r10);
        LocationUtil.getInstance().getExecutor().execute(new n4.d(this, r10, r8));
    }

    public void eventNotify(long r18, StarGeofence.GeoEvent r20, StarGeofence r21, Location r22, int r23, double r24) {
        if (r21 == null) goto L53;
        if (r22 == null) goto L53;
        monitor-enter(this);
        LocationUtil r10 = LocationUtil.getInstance();     // Catch: Throwable -> L50
        int r13 = r10.getSimCardState(this.mContext);     // Catch: Throwable -> L50
        if (r13 != 5) goto L10;
        boolean r15 = true;
    L11:
        String r8 = r21.getGeofenceId();     // Catch: Throwable -> L50
        if (r8 != null) goto L16;
        CommSenseLog.e(TAG, "geofenceId is null");     // Catch: Throwable -> L50
        monitor-exit(this);     // Catch: Throwable -> L50
        return;
    L16:
        StarGeofence r11 = this.dbManager.queryGeofenceById(r8);     // Catch: Throwable -> L50
        if (r11 != null) goto L19;
        StarGeofence r12 = r21;
    L21:
        if (shouldDeleteExitedDynamicGeofence(r12, r8) == false) goto L23;
        boolean r14 = true;
    L46:
        monitor-exit(this);     // Catch: Throwable -> L50
        if (r14 == false) goto L56;
        deleteDynamicGeofence(r21);
        return;
    L56:
        return;
    L23:
        StarGeofence.GeoEvent r16 = StarGeofence.GeoEvent.ENTER;     // Catch: Throwable -> L50
        if (r20 != r16) goto L27;
        double r17 = r24 / ((double) r12.getRadius());     // Catch: Throwable -> L50
    L26:
        float r19 = (float) r17;     // Catch: Throwable -> L50
        if (r12.getGeoState() != StarGeofence.GeoState.OUTSIDE) goto L33;
        if (StarGeofence.GeoEvent.EXIT != r20) goto L33;
    L35:
        handleSameStateEvent(r12, r20, r22, r23, r15);     // Catch: Throwable -> L50
        monitor-exit(this);     // Catch: Throwable -> L50
        return;
    L33:
        if (r12.getGeoState() != StarGeofence.GeoState.INSIDE) goto L38;
        if (r16 == r20) goto L35;
    L38:
        StarGeofence r110 = r12;
        int r25 = shouldStageReverseEvent(r12, r20, r22, r18, r23);     // Catch: Throwable -> L50
        if (r25 == 0) goto L45;
        CommSenseLog.dumpI(TAG, "shouldStageReverseEvent, event=" + r20 + ", geofenceId=" + r8 + ", state=" + r110.getGeoState() + ", responseRate=" + r19 + ", " + logBreachLocation(r22, r23, r15), StarGeofenceManager.getGeofenceLogFile(this.mUserId));     // Catch: Throwable -> L50
        if (r25 != 2) goto L43;
        r10.setDisableNlpWifiCache(true);     // Catch: Throwable -> L50
        r10.getCurLocation("network", true, CommSenseLog.getMethodName());     // Catch: Throwable -> L50
        r10.getCurLocation(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, true, CommSenseLog.getMethodName());     // Catch: Throwable -> L50
    L43:
        monitor-exit(this);     // Catch: Throwable -> L50
        return;
    L45:
        updateBreachLocationConfidenceByCurrentLocation(r22);     // Catch: Throwable -> L50
        r14 = applyAcceptedEvent(r110, r18, r20, r22, r23, r13, r15, r19);     // Catch: Throwable -> L50
        goto L46
    L27:
        r17 = ((double) r12.getRadius()) / r24;     // Catch: Throwable -> L50
        goto L26
    L19:
        r12 = r11;
        goto L21
    L10:
        r15 = false;
    L50:
        th = move-exception;
        throw th;
    L53:
        CommSenseLog.e(TAG, "originalStarGeofence or location is null...");
    }

    public void registerGeofenceCallback(String r8, IStarGeofenceCallback r10) {
        StringBuilder r11 = defpackage.b.h("registerGeofenceCallback called by packageName: ", r8, ", uid: ");
        r11.append(Binder.getCallingUid());
        r11.append(", pid: ");
        r11.append(Binder.getCallingPid());
        r11.append(", callback: ");
        r11.append(r10.hashCode());
        CommSenseLog.dumpI(TAG, r11.toString(), StarGeofenceManager.getGeofenceLogFile(this.mUserId));
        Object r12 = this.mGeofenceCallbackLock;
        monitor-enter(r12);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mGeofenceCallbacks.register(r10, r8) == true) goto L7;
        StringBuilder r13 = new StringBuilder("registerGeofenceCallback failed, packageName=");     // Catch: Throwable -> L9
        r13.append(r8);     // Catch: Throwable -> L9
        r13.append(", callback=" + r10.hashCode());     // Catch: Throwable -> L9
        CommSenseLog.dumpI(TAG, r13.toString(), StarGeofenceManager.getGeofenceLogFile(this.mUserId));     // Catch: Throwable -> L9
    L7:
        monitor-exit(r12);     // Catch: Throwable -> L9
    }

    public void unregisterGeofenceCallback(String r8, IStarGeofenceCallback r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        StringBuilder r11 = defpackage.b.h("unregisterGeofenceCallback called by packageName: ", r8, ", uid: ");
        r11.append(Binder.getCallingUid());
        r11.append(", pid: ");
        r11.append(Binder.getCallingPid());
        r11.append(", callback: ");
        r11.append(r10.hashCode());
        CommSenseLog.dumpI(TAG, r11.toString(), StarGeofenceManager.getGeofenceLogFile(this.mUserId));
        Object r12 = this.mGeofenceCallbackLock;
        monitor-enter(r12);
        this.mGeofenceCallbacks.unregister(r10);     // Catch: Throwable -> L9
        monitor-exit(r12);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
