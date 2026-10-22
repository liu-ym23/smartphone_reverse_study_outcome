package com.obric.cae.location.geofence;

import android.content.Context;
import android.location.Location;
import android.os.Binder;
import android.os.PowerExemptionManager;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.location.geofence.a;
import com.obric.cae.libs.statemachine.e;
import com.obric.cae.location.city.f;
import com.obric.cae.location.database.c;
import com.obric.cae.location.report.b;
import com.obric.cae.location.report.d;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class StarGeoCallback {
    private static final int BREACH_CONFIDENCE_DOWNGRADE_DISTANCE_METER = 1000;
    private static final int EQUAL_CONFIDENCE_CONFIRM_COUNT = 2;
    private static final int LOWER_CONFIDENCE_FORCE_ACCEPT_COUNT = 2;
    private static final int LOWER_CONFIDENCE_REQUEST_LOCATION_COUNT = 1;
    private static final long PENDING_REVERSE_EVENT_LOCATION_REQUEST_TIMEOUT_MS = 70000;
    private static final int REVERSE_EVENT_ACCEPT = 0;
    private static final int REVERSE_EVENT_IGNORE = 1;
    private static final int REVERSE_EVENT_IGNORE_AND_REQUEST_LOCATION = 2;
    private static final String TAG = "StarLocation-geoCallback";
    private static final long UNKNOWN_STATE_CONFIRMATION_WINDOW_MS = 90000;
    private static final ConcurrentHashMap<Integer, StarGeoCallback> sInstances = null;
    private final c dbManager;
    private final ConcurrentHashMap<String, BreachLocation> mBreachLocationMap;
    private final Context mContext;
    private final Object mGeofenceCallbackLock;
    private final RemoteCallbackList<a> mGeofenceCallbacks;
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
            int[] r0 = new int[StarGeofence.GeoEvent.values().length];
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoEvent = r0;
            r0[StarGeofence.GeoEvent.ENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
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

        private BreachLocation(String r1, double r2, double r4, float r6, int r7, boolean r8, int r9) {
            this.provider = r1;
            this.latitude = r2;
            this.longitude = r4;
            this.accuracy = r6;
            this.source = r7;
            this.simCardReady = r8;
            this.confidence = r9;
        }

        public static /* synthetic */ int access$100(BreachLocation r0) {
            return r0.getConfidence();
        }

        public static /* synthetic */ double access$200(BreachLocation r2) {
            return r2.getLatitude();
        }

        public static /* synthetic */ double access$300(BreachLocation r2) {
            return r2.getLongitude();
        }

        public static /* synthetic */ BreachLocation access$400(BreachLocation r0, int r1) {
            return r0.withConfidence(r1);
        }

        public static /* synthetic */ BreachLocation access$500(Location r0, int r1, boolean r2, int r3) {
            return from(r0, r1, r2, r3);
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

    private StarGeoCallback(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mGeofenceCallbackLock = new Object();
        this.mGeofenceCallbacks = new AnonymousClass1(this);
        this.mPendingReverseEventMap = new ConcurrentHashMap();
        this.mPendingReverseRejectCountMap = new ConcurrentHashMap();
        this.mPendingReverseStageTimeMap = new ConcurrentHashMap();
        this.mBreachLocationMap = new ConcurrentHashMap();
        this.mPendingReverseTimeoutLock = new Object();
        this.mPendingReverseEventExecutor = Executors.newSingleThreadScheduledExecutor();
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.mUserId = r4;
        this.dbManager = c.a(r6, r4);
    }

    public static /* synthetic */ int access$000(StarGeoCallback r0) {
        return r0.mUserId;
    }

    private void appendGeofencesByState(List<StarGeofence> r3, List<StarGeofence> r4, StarGeofence.GeoState r5) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Iterator r7 = r2.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        StarGeofence r8 = (StarGeofence) ZeusTransformUtils.preCheckCast(r7.next(), StarGeofence.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L4;
        if (r8.getGeoState() != r5) goto L4;
        r6.add(r8);
        goto L4
    }

    private void applyAcceptedEvent(StarGeofence r25, long r26, StarGeofence.GeoEvent r28, Location r29, int r30, int r31, boolean r32, float r33) {
        int r2 = AnonymousClass2.$SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoEvent[r28.ordinal()];
        if (r2 != 1) goto L5;
        com.obric.cae.log.a.e(TAG, "set StarGeofence INSIDE from " + r30);
        StarGeofence.GeoState r3 = StarGeofence.GeoState.INSIDE;
    L10:
        r25.setGeoState(r3);
        r25.setEventTimestamp(r26);
        String r15 = r25.getGeofenceId();
        if (r15 != null) goto L14;
        com.obric.cae.log.a.i(TAG, "geofenceId is null");
        return;
    L14:
        StarGeofenceManager.getInstance(this.mContext, this.mUserId).removeUnknownStateGeofence(r15);
        clearPendingReverseEvent(r15);
        this.mBreachLocationMap.put(r15, BreachLocation.access$500(r29, r30, r32, com.obric.cae.location.a.a().c(r29)));
        if ((r25.getTransitionType().getValue() & r25.getGeoState().getValue()) != 0) goto L18;
        com.obric.cae.log.a.c(TAG, "No registered transition events for this geofence, skipping callback.");
        return;
    L18:
        int r11 = this.dbManager.e(r15);
        boolean r16 = this.dbManager.a(r25);
        this.dbManager.b(r25, r11);
        com.obric.cae.location.report.a r4 = b.a();
        if (r4 == null) goto L22;
        r4.a(r26, r29, r15, r30, r31, r28, r33, r16);
    L22:
        d.a(r26, r29, r15, r30, r31, r28, r33, r16);
        String r5 = r25.getPackageName();
        UserAwareManager.getInstance().notifyInnerCallbacks($$Lambda$StarGeoCallback$WJ4WNsli8sphZPYDjecbDyQSRWw.INSTANCE, r25, new Location(r29));
        com.obric.cae.log.a.c(TAG, "run geofence callback, event:" + r28.getValue() + ", responseRate=" + r33 + ", " + logBreachLocation(r29, r30, r32) + ", " + r25, StarGeofenceManager.getGeofenceLogFile(this.mUserId));
        PowerExemptionManager r18 = (PowerExemptionManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService(PowerExemptionManager.class), PowerExemptionManager.class, "com.obric.memorydata.plugin");
        com.obric.cae.log.a.c(TAG, "packageName = " + r5);
        r18.addToTemporaryAllowList(r5, 100, "need 30 seconds to execute restricted actions.", 30000);
        if (com.obric.cae.location.geosdk.poi.a.a(this.mContext, r11, r25) == true) goto L49;
        ArrayList r0 = new ArrayList();
        Object r6 = this.mGeofenceCallbackLock;
        monitor-enter(r6);
        int r7 = this.mGeofenceCallbacks.beginBroadcast();     // Catch: Throwable -> L46
        int r8 = 0;
    L28:
        if (r8 >= r7) goto L36;
    L33:
        th = move-exception;
        this.mGeofenceCallbacks.finishBroadcast();     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L30:
        if (r5.equals(this.mGeofenceCallbacks.getBroadcastCookie(r8)) == false) goto L32;
        r0.add((a) ZeusTransformUtils.preCheckCast(this.mGeofenceCallbacks.getBroadcastItem(r8), a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L33
    L32:
        r8 = r8 + 1;
        goto L28
    L36:
        this.mGeofenceCallbacks.finishBroadcast();     // Catch: Throwable -> L46
        monitor-exit(r6);     // Catch: Throwable -> L46
        Iterator r9 = r0.iterator();
    L40:
        if (r9.hasNext() == false) goto L62;
        ((a) ZeusTransformUtils.preCheckCast(r9.next(), a.class, "com.obric.memorydata.plugin")).a(r15, r29, r28.ordinal());     // Catch: RemoteException -> L44
    L44:
        e = move-exception;
        com.obric.cae.log.a.c(TAG, "onBreachReport failed, packageName=" + r5 + ", geofenceId=" + r15 + ", error=" + e.getMessage(), StarGeofenceManager.getGeofenceLogFile(this.mUserId));
        goto L40
    L62:
        return;
    L46:
        th = move-exception;
        throw th;
    L49:
        return;
    L5:
        if (r2 == 2) goto L8;
        com.obric.cae.log.a.e(TAG, "set StarGeofence UNKNOWN");
        r25.setGeoState(StarGeofence.GeoState.UNKNOWN);
        return;
    L8:
        com.obric.cae.log.a.e(TAG, "set StarGeofence OUTSIDE from " + r30);
        r3 = StarGeofence.GeoState.OUTSIDE;
        goto L10
    }

    private void clearGeofenceEventCache(String r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        clearPendingReverseEvent(r1);
        this.mBreachLocationMap.remove(r1);
    }

    private void clearPendingReverseEvent(String r3) {
        this.mPendingReverseEventMap.remove(r3);
        this.mPendingReverseRejectCountMap.remove(r3);
        this.mPendingReverseStageTimeMap.remove(r3);
        Object r4 = this.mPendingReverseTimeoutLock;
        monitor-enter(r4);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingReverseStageTimeMap.isEmpty() == false) goto L9;
        ScheduledFuture<?> r0 = this.mPendingReverseTimeoutFuture;     // Catch: Throwable -> L11
        if (r0 == null) goto L9;
        r0.cancel(false);     // Catch: Throwable -> L11
        this.mPendingReverseTimeoutFuture = null;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r4);     // Catch: Throwable -> L11
    }

    private BreachLocation getActiveBreachLocation(String r4, BreachLocation r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (com.obric.cae.location.util.d.a().n() == true) goto L8;
        return r5;
    L8:
        int r0 = com.obric.cae.location.a.a().b(BreachLocation.access$100(r5));
        if (r0 != BreachLocation.access$100(r5)) goto L11;
        return r5;
    L11:
        BreachLocation r1 = BreachLocation.access$400(r5, r0);
        this.mBreachLocationMap.put(r4, r1);
        com.obric.cae.log.a.f(TAG, "downgrade breach location confidence after large movement, geofenceId=" + r4 + ", previousConfidence=" + BreachLocation.access$100(r5) + ", downgradedConfidence=" + r0);
        return r1;
    }

    public static synchronized StarGeoCallback getInstance(Context r4, int r5) {
        monitor-enter(StarGeoCallback.class);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        ConcurrentHashMap<Integer, StarGeoCallback> r1 = sInstances;     // Catch: Throwable -> L9
        StarGeoCallback r2 = (StarGeoCallback) ZeusTransformUtils.preCheckCast(r1.get(Integer.valueOf(r5)), StarGeoCallback.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r2 != null) goto L7;
        r2 = new StarGeoCallback(r6, r5);     // Catch: Throwable -> L9
        r1.put(Integer.valueOf(r5), r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(StarGeoCallback.class);
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    private void handleSameStateEvent(StarGeofence r7, StarGeofence.GeoEvent r8, Location r9, int r10, boolean r11) {
        String r0 = r7.getGeofenceId();
        if (r0 != null) goto L6;
        com.obric.cae.log.a.i(TAG, "geofenceId is null");
        return;
    L6:
        StarGeofence.GeoEvent r2 = (StarGeofence.GeoEvent) ZeusTransformUtils.preCheckCast(this.mPendingReverseEventMap.get(r0), StarGeofence.GeoEvent.class, "com.obric.memorydata.plugin");
        int r3 = com.obric.cae.location.a.a().c(r9);
        if (r2 == null) goto L10;
        if (r2 == r8) goto L10;
        com.obric.cae.log.a.c(TAG, f.a("cancel staged reverse geofence event, geofenceId=", r0, ", currentState=").append(r7.getGeoState()).append(", supportEvent=").append(r8).toString(), StarGeofenceManager.getGeofenceLogFile(this.mUserId));
        clearPendingReverseEvent(r0);
    L10:
        BreachLocation r12 = getActiveBreachLocation(r0, (BreachLocation) ZeusTransformUtils.preCheckCast(this.mBreachLocationMap.get(r0), BreachLocation.class, "com.obric.memorydata.plugin"));
        if (r12 != null) goto L13;
    L16:
        this.mBreachLocationMap.put(r0, BreachLocation.access$500(r9, r10, r11, r3));
        return;
    L13:
        if (BreachLocation.access$100(r12) <= r3) goto L16;
        int r13 = com.obric.cae.location.a.a().a(BreachLocation.access$100(r12));
        this.mBreachLocationMap.put(r0, BreachLocation.access$400(r12, r13));
        com.obric.cae.log.a.d(TAG, e.a(new StringBuilder("downgrade breach location confidence, geofenceId=").append(r0).append(", currentConfidence=").append(r3).append(", previousConfidence="), BreachLocation.access$100(r12), ", downgradedConfidence=", r13, ", event=").append(r8).append(", source=").append(r10).toString());
    }

    public static boolean hasPendingReverseEvent(int r6) {
        if (r6 >= 0) goto L6;
        r6 = 0;
    L6:
        ConcurrentHashMap<Integer, StarGeoCallback> r2 = sInstances;
        StarGeoCallback r3 = (StarGeoCallback) ZeusTransformUtils.preCheckCast(r2.get(Integer.valueOf(r6)), StarGeoCallback.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L9;
    L11:
        if (r6 != 0) goto L13;
        return false;
    L13:
        StarGeoCallback r7 = (StarGeoCallback) ZeusTransformUtils.preCheckCast(r2.get(0), StarGeoCallback.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L16;
        return false;
    L16:
        if (r7.mPendingReverseEventMap.isEmpty() == false) goto L18;
        return false;
    L18:
        return true;
    L9:
        if (r3.mPendingReverseEventMap.isEmpty() == true) goto L11;
        return true;
    }

    public static /* synthetic */ void lambda$_KbxjVcJ3HK5grH4ZUJX3epqEfA(StarGeoCallback r0) {
        r0.onPendingReverseEventTimeout();
    }

    static /* synthetic */ void lambda$applyAcceptedEvent$0(InnerAwareInfoCallback r0, StarGeofence r1, Location r2) {
        r0.onGeofenceInfoChange(r1, r2);
    }

    private String logBreachLocation(Location r1, int r2, boolean r3) {
        return BreachLocation.access$500(r1, r2, r3, com.obric.cae.location.a.a().c(r1)).toString();
    }

    private void logStagedReverseEvent(StarGeofence.GeoEvent r2, int r3, String r4, int r5, int r6, int r7, String r8) {
        com.obric.cae.log.a.f(TAG, e.a(new StringBuilder("stage reverse geofence event=").append(r2).append(", reason=").append(r8).append(", source=").append(r3).append(", geofenceId=").append(r4).append(", currentConfidence="), r5, ", previousConfidence=", r6, ", rejectedCount=").append(r7).toString());
    }

    public static void notifyEngineStatusReportToAllUsers(Context r4, int r5, Location r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        UserManager r0 = (UserManager) ZeusTransformUtils.preCheckCast(r7.getSystemService("user"), UserManager.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        Iterator<UserHandle> r1 = r0.getUserProfiles().iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        getInstance(r7, ((UserHandle) ZeusTransformUtils.preCheckCast(r1.next(), UserHandle.class, "com.obric.memorydata.plugin")).getIdentifier()).engineStatusReport(r5, r6);
        goto L6
    L11:
        return;
    L8:
        getInstance(r7, 0).engineStatusReport(r5, r6);
    }

    private void onPendingReverseEventTimeout() {
        long r0 = SystemClock.elapsedRealtime();
        Object r2 = this.mPendingReverseTimeoutLock;
        monitor-enter(r2);
        this.mPendingReverseTimeoutFuture = null;     // Catch: Throwable -> L23
        Iterator<Map.Entry<String, Long>> r3 = this.mPendingReverseStageTimeMap.entrySet().iterator();     // Catch: Throwable -> L23
        boolean r5 = false;
    L7:
        if (r3.hasNext() == false) goto L17;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        Long r8 = (Long) ZeusTransformUtils.preCheckCast(r6.getValue(), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        StarGeofence.GeoEvent r9 = (StarGeofence.GeoEvent) ZeusTransformUtils.preCheckCast(this.mPendingReverseEventMap.get(r7), StarGeofence.GeoEvent.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r9 == null) goto L16;
        if (r8 == null) goto L16;
        if ((r0 - r8.longValue()) < PENDING_REVERSE_EVENT_LOCATION_REQUEST_TIMEOUT_MS) goto L7;
        this.mPendingReverseStageTimeMap.remove(r7, r8);     // Catch: Throwable -> L23
        com.obric.cae.log.a.f(TAG, "pending reverse geofence event timeout, geofenceId=" + r7 + ", event=" + r9 + ", timeoutMs=" + PENDING_REVERSE_EVENT_LOCATION_REQUEST_TIMEOUT_MS);     // Catch: Throwable -> L23
        r5 = true;
    L16:
        this.mPendingReverseStageTimeMap.remove(r7);     // Catch: Throwable -> L23
        goto L7
    L17:
        scheduleNextPendingReverseEventTimeoutLocked(r0);     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        if (r5 == true) goto L21;
        return;
    L21:
        com.obric.cae.log.a.f(TAG, "request fused location for pending reverse geofence event timeout");
        com.obric.cae.location.util.d r13 = com.obric.cae.location.util.d.a();
        r13.a(true);
        r13.b("fused", true, com.obric.cae.log.a.a());
        return;
    L23:
        th = move-exception;
        throw th;
    }

    private List<StarGeofence> orderGeofencesForEventCalculation(List<StarGeofence> r4) {
        List<StarGeofence> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList(r5.size());
        appendGeofencesByState(r5, r0, StarGeofence.GeoState.INSIDE);
        appendGeofencesByState(r5, r0, StarGeofence.GeoState.UNKNOWN);
        appendGeofencesByState(r5, r0, StarGeofence.GeoState.OUTSIDE);
        Iterator<StarGeofence> r3 = r5.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        StarGeofence r6 = (StarGeofence) ZeusTransformUtils.preCheckCast(r3.next(), StarGeofence.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L9;
        if (r6.getGeoState() != null) goto L4;
    L9:
        r0.add(r6);
        goto L4
    L10:
        return r0;
    }

    private StarGeofence.GeoEvent resolveAmbiguousReverseEvent(StarGeofence.GeoState r1, double r2, double r4) {
        if (r1 != StarGeofence.GeoState.INSIDE) goto L9;
        if (r2 <= r4) goto L9;
        return StarGeofence.GeoEvent.EXIT;
    L9:
        if (r1 != StarGeofence.GeoState.OUTSIDE) goto L15;
        if (r2 >= r4) goto L15;
        return StarGeofence.GeoEvent.ENTER;
    L15:
        return StarGeofence.GeoEvent.UNKNOWN;
    }

    private void scheduleNextPendingReverseEventTimeoutLocked(long r10) {
        Iterator<Long> r0 = this.mPendingReverseStageTimeMap.values().iterator();
        long r3 = Long.MAX_VALUE;
    L4:
        if (r0.hasNext() == false) goto L10;
        Long r5 = (Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L4;
        r3 = Math.min(r3, Math.max(0, PENDING_REVERSE_EVENT_LOCATION_REQUEST_TIMEOUT_MS - (r10 - r5.longValue())));
        goto L4
    L10:
        if (r3 == Long.MAX_VALUE) goto L18;
        this.mPendingReverseTimeoutFuture = this.mPendingReverseEventExecutor.schedule(new $$Lambda$StarGeoCallback$_KbxjVcJ3HK5grH4ZUJX3epqEfA(this), r3, TimeUnit.MILLISECONDS);
        return;
    }

    private void schedulePendingReverseEventTimeoutIfNeeded() {
        Object r0 = this.mPendingReverseTimeoutLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingReverseTimeoutFuture == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        scheduleNextPendingReverseEventTimeoutLocked(SystemClock.elapsedRealtime());     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    private boolean shouldConfirmRecentPersistedState(StarGeofence r3, BreachLocation r4, long r5) {
        if (r4 == null) goto L6;
        return false;
    L6:
        if (r3.getGeoState() != StarGeofence.GeoState.UNKNOWN) goto L8;
        return false;
    L8:
        long r6 = r3.getEventTimestamp();
        if (r6 > 0) goto L11;
        return false;
    L11:
        if (r5 >= r6) goto L13;
        return false;
    L13:
        if ((r5 - r6) > 90000) goto L18;
        return true;
    L18:
        return false;
    }

    private int shouldStageReverseEvent(StarGeofence r17, StarGeofence.GeoEvent r18, Location r19, long r20, int r22) {
        StarGeofence.GeoState r3 = r17.getGeoState();
        if (r3 != StarGeofence.GeoState.OUTSIDE) goto L7;
        if (r18 != StarGeofence.GeoEvent.ENTER) goto L7;
    L10:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L14;
        return 0;
    L14:
        String r5 = r17.getGeofenceId();
        if (r5 != null) goto L18;
        com.obric.cae.log.a.j(TAG, "geofenceId is null");
        return 0;
    L18:
        StarGeofence.GeoEvent r6 = (StarGeofence.GeoEvent) ZeusTransformUtils.preCheckCast(this.mPendingReverseEventMap.get(r5), StarGeofence.GeoEvent.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L22;
        if (r6 == r18) goto L22;
        clearPendingReverseEvent(r5);
    L22:
        BreachLocation r7 = getActiveBreachLocation(r5, (BreachLocation) ZeusTransformUtils.preCheckCast(this.mBreachLocationMap.get(r5), BreachLocation.class, "com.obric.memorydata.plugin"));
        if (r7 != null) goto L25;
        int r9 = 0;
    L26:
        int r10 = com.obric.cae.location.a.a().c(r19);
        if (r10 != 0) goto L30;
        logStagedReverseEvent(r18, r22, r5, r10, r9, stageReverseEvent(r5, r18), "zero confidence reverse");
        return 2;
    L30:
        if (r7 == null) goto L53;
        if (r10 <= r9) goto L36;
        clearPendingReverseEvent(r5);
        com.obric.cae.log.a.d(TAG, "accept reverse event=" + r18 + ", source=" + r22 + ", geofenceId=" + r5 + ", currentConfidence=" + r10 + ", previousConfidence=" + r9);
        return 0;
    L36:
        if (r10 != r9) goto L43;
        int r8 = stageReverseEvent(r5, r18);
        if (r8 < 2) goto L41;
        clearPendingReverseEvent(r5);
        com.obric.cae.log.a.d(TAG, "accept reverse event=" + r18 + ", source=" + r22 + ", geofenceId=" + r5 + ", confidence=" + r10 + ", rejectedCount=" + r8);
        return 0;
    L41:
        logStagedReverseEvent(r18, r22, r5, r10, r9, r8, "equal confidence");
        return 1;
    L43:
        int r11 = stageReverseEvent(r5, r18);
        if (r11 < 2) goto L47;
        clearPendingReverseEvent(r5);
        com.obric.cae.log.a.d(TAG, "accept reverse event=" + r18 + ", source=" + r22 + ", geofenceId=" + r5 + ", currentConfidence=" + r10 + ", previousConfidence=" + r9 + ", rejectedCount=" + r11);
        return 0;
    L47:
        logStagedReverseEvent(r18, r22, r5, r10, r9, r11, "lower confidence");
        if (r11 >= 1) goto L62;
        return 1;
    L62:
        return 2;
    L53:
        if (shouldConfirmRecentPersistedState(r17, null, r20) == false) goto L59;
        int r12 = stageReverseEvent(r5, r18);
        logStagedReverseEvent(r18, r22, r5, r10, r9, r12, "recent persisted state");
        if (r12 < 1) goto L58;
        return 2;
    L58:
        return 1;
    L59:
        if (r6 != r18) goto L61;
        clearPendingReverseEvent(r5);
    L61:
        return 0;
    L25:
        r9 = BreachLocation.access$100(r7);
    L7:
        if (r3 == StarGeofence.GeoState.INSIDE) goto L9;
    L11:
        r4 = false;
        goto L12
    L9:
        if (r18 != StarGeofence.GeoEvent.EXIT) goto L11;
        goto L10
    }

    private int stageReverseEvent(String r6, StarGeofence.GeoEvent r7) {
        StarGeofence.GeoEvent r0 = (StarGeofence.GeoEvent) ZeusTransformUtils.preCheckCast(this.mPendingReverseEventMap.get(r6), StarGeofence.GeoEvent.class, "com.obric.memorydata.plugin");
        int r1 = 1;
        if (r0 != r7) goto L9;
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(this.mPendingReverseRejectCountMap.get(r6), Integer.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        int r3 = 1;
    L8:
        r1 = 1 + r3;
        goto L9
    L7:
        r3 = r2.intValue();
    L9:
        if (r0 == r7) goto L11;
    L12:
        this.mPendingReverseStageTimeMap.put(r6, Long.valueOf(SystemClock.elapsedRealtime()));
    L13:
        this.mPendingReverseEventMap.put(r6, r7);
        this.mPendingReverseRejectCountMap.put(r6, Integer.valueOf(r1));
        schedulePendingReverseEventTimeoutIfNeeded();
        return r1;
    L11:
        if (this.mPendingReverseStageTimeMap.containsKey(r6) == true) goto L13;
        goto L12
    }

    private void updateBreachLocationConfidenceByCurrentLocation(Location r15) {
        com.obric.cae.location.util.d r9 = com.obric.cae.location.util.d.a();
        int r10 = com.obric.cae.location.a.a().c(r15);
        Iterator<Map.Entry<String, BreachLocation>> r11 = this.mBreachLocationMap.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L15;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");
        BreachLocation r13 = (BreachLocation) ZeusTransformUtils.preCheckCast(r0.getValue(), BreachLocation.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L4;
        if (r13 == null) goto L4;
        if (r10 <= BreachLocation.access$100(r13)) goto L4;
        double r1 = r9.a(r15.getLatitude(), r15.getLongitude(), BreachLocation.access$200(r13), BreachLocation.access$300(r13));
        if (r1 <= 1000.0d) goto L4;
        int r2 = com.obric.cae.location.a.a().a(BreachLocation.access$100(r13));
        this.mBreachLocationMap.put(r12, BreachLocation.access$400(r13, r2));
        com.obric.cae.log.a.d(TAG, "downgrade breach location confidence, geofenceId=" + r12 + ", distance=" + r1 + ", currentConfidence=" + r10 + ", previousConfidence=" + BreachLocation.access$100(r13) + ", downgradedConfidence=" + r2);
        goto L4
    }

    public synchronized void calculateGeofenceEvent(Location r25, int r26, int r27) {
        monitor-enter(this);
        com.obric.cae.log.a.d(TAG, "source=" + r27);     // Catch: Throwable -> L36
        if (r25 != null) goto L9;
        com.obric.cae.log.a.b(TAG, "location is null");     // Catch: Throwable -> L36
        monitor-exit(this);
        return;
    L9:
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L36
        Iterator<StarGeofence> r14 = orderGeofencesForEventCalculation(this.dbManager.a()).iterator();     // Catch: Throwable -> L36
    L11:
        if (r14.hasNext() == false) goto L34;
        StarGeofence r7 = (StarGeofence) ZeusTransformUtils.preCheckCast(r14.next(), StarGeofence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        if (r7 == null) goto L14;
        String r8 = r7.getGeofenceId();     // Catch: Throwable -> L36
        if (r8 == null) goto L17;
        int r1 = this.dbManager.e(r8);     // Catch: Throwable -> L36
        if (c.a(r1, r26) == false) goto L20;
        double r15 = com.obric.cae.location.util.d.a().a(r25.getLatitude(), r25.getLongitude(), r7.getLatitude(), r7.getLongitude());     // Catch: Throwable -> L36
        if (r15 >= (r25.getAccuracy() + r7.getRadius())) goto L23;
        if (r7.getRadius() >= r25.getAccuracy()) goto L28;
    L30:
        StarGeofence.GeoEvent r4 = resolveAmbiguousReverseEvent(r7.getGeoState(), r15, r7.getRadius());     // Catch: Throwable -> L36
        if (r4 == StarGeofence.GeoEvent.UNKNOWN) goto L11;
        com.obric.cae.log.a.b(TAG, "calculate ambiguous reverse geofence, source=" + r27 + ", event=" + r4 + ", geofenceId=" + r8);     // Catch: Throwable -> L36
    L24:
        eventNotify(r12, r4, r7, r25, r27, r15);     // Catch: Throwable -> L36
        goto L11
    L28:
        if (r15 > (r7.getRadius() - r25.getAccuracy())) goto L30;
        com.obric.cae.log.a.b(TAG, "calculate enter geofence, source=" + r27 + ", geofenceId=" + r8);     // Catch: Throwable -> L36
        r4 = StarGeofence.GeoEvent.ENTER;     // Catch: Throwable -> L36
        goto L24
    L23:
        com.obric.cae.log.a.b(TAG, "calculate exit geofence, source=" + r27 + ", geofenceId=" + r8);     // Catch: Throwable -> L36
        r4 = StarGeofence.GeoEvent.EXIT;     // Catch: Throwable -> L36
        goto L24
    L20:
        com.obric.cae.log.a.b(TAG, com.obric.cae.location.b.a("skip geofence by user mismatch, currentUserId=", r26, ", geofenceUserId=", r1, ", geofenceId=").append(r8).toString());     // Catch: Throwable -> L36
        goto L11
    L17:
        com.obric.cae.log.a.j(TAG, "geofenceId is null");     // Catch: Throwable -> L36
        goto L11
    L14:
        com.obric.cae.log.a.b(TAG, "starGeofence is null");     // Catch: Throwable -> L36
        goto L11
    L34:
        monitor-exit(this);
        return;
    L36:
        th = move-exception;
        throw th;
    }

    public void engineStatusReport(final int r3, final Location r4) {
        com.obric.cae.log.a.d(TAG, "status: " + r3 + ", location: " + r4);
        com.obric.cae.location.util.d.a().r().execute(new $$Lambda$StarGeoCallback$S4CmyLZFvUhX86yy79krz3mJt4(this, r3, r4));
    }

    public void eventNotify(long r18, StarGeofence.GeoEvent r20, StarGeofence r21, Location r22, int r23, double r24) {
        if (r21 == null) goto L47;
        if (r22 == null) goto L47;
        monitor-enter(this);
        com.obric.cae.location.util.d r10 = com.obric.cae.location.util.d.a();     // Catch: Throwable -> L44
        int r12 = r10.c(this.mContext);     // Catch: Throwable -> L44
        if (r12 != 5) goto L10;
        boolean r14 = true;
    L11:
        String r15 = r21.getGeofenceId();     // Catch: Throwable -> L44
        if (r15 != null) goto L16;
        com.obric.cae.log.a.i(TAG, "geofenceId is null");     // Catch: Throwable -> L44
        monitor-exit(this);     // Catch: Throwable -> L44
        return;
    L16:
        StarGeofence r1 = this.dbManager.d(r15);     // Catch: Throwable -> L44
        if (r1 != null) goto L19;
        StarGeofence r16 = r21;
    L20:
        StarGeofence.GeoEvent r2 = StarGeofence.GeoEvent.ENTER;     // Catch: Throwable -> L44
        if (r20 != r2) goto L23;
        double r3 = r24 / ((double) r16.getRadius());     // Catch: Throwable -> L44
    L24:
        float r4 = (float) r3;     // Catch: Throwable -> L44
        if (r16.getGeoState() != StarGeofence.GeoState.OUTSIDE) goto L29;
        if (StarGeofence.GeoEvent.EXIT != r20) goto L29;
    L31:
        handleSameStateEvent(r16, r20, r22, r23, r14);     // Catch: Throwable -> L44
        monitor-exit(this);     // Catch: Throwable -> L44
        return;
    L29:
        if (r16.getGeoState() != StarGeofence.GeoState.INSIDE) goto L34;
        if (r2 == r20) goto L31;
    L34:
        int r5 = shouldStageReverseEvent(r16, r20, r22, r18, r23);     // Catch: Throwable -> L44
        if (r5 == 0) goto L41;
        com.obric.cae.log.a.c(TAG, "shouldStageReverseEvent, event=" + r20 + ", geofenceId=" + r15 + ", state=" + r16.getGeoState() + ", responseRate=" + r4 + ", " + logBreachLocation(r22, r23, r14), StarGeofenceManager.getGeofenceLogFile(this.mUserId));     // Catch: Throwable -> L44
        if (r5 != 2) goto L39;
        r10.a(true);     // Catch: Throwable -> L44
        r10.b("fused", true, com.obric.cae.log.a.a());     // Catch: Throwable -> L44
    L39:
        monitor-exit(this);     // Catch: Throwable -> L44
        return;
    L41:
        updateBreachLocationConfidenceByCurrentLocation(r22);     // Catch: Throwable -> L44
        applyAcceptedEvent(r16, r18, r20, r22, r23, r12, r14, r4);     // Catch: Throwable -> L44
        monitor-exit(this);     // Catch: Throwable -> L44
        return;
    L23:
        r3 = ((double) r16.getRadius()) / r24;     // Catch: Throwable -> L44
        goto L24
    L19:
        r16 = r1;
        goto L20
    L10:
        r14 = false;
    L44:
        th = move-exception;
        throw th;
    L47:
        com.obric.cae.log.a.i(TAG, "originalStarGeofence or location is null...");
    }

    public /* synthetic */ void lambda$engineStatusReport$1$StarGeoCallback(int r8, Location r9) {
        ArrayList r0 = new ArrayList();
        Object r1 = this.mGeofenceCallbackLock;
        monitor-enter(r1);
        int r2 = this.mGeofenceCallbacks.beginBroadcast();     // Catch: Throwable -> L24
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        r0.add((a) ZeusTransformUtils.preCheckCast(this.mGeofenceCallbacks.getBroadcastItem(r3), a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9
        r3 = r3 + 1;
        goto L6
    L9:
        th = move-exception;
        this.mGeofenceCallbacks.finishBroadcast();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L12:
        this.mGeofenceCallbacks.finishBroadcast();     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        Iterator r4 = r0.iterator();
    L16:
        if (r4.hasNext() == false) goto L22;
        ((a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin")).a(r8, r9);     // Catch: RemoteException -> L20
    L20:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "onGeofenceStatusReport failed.", e);
        goto L16
    L22:
        UserAwareManager.getInstance().notifyInnerCallbacks($$Lambda$TYvBoiyPbE6uWXCeB3mXxNjRj5w.INSTANCE, Integer.valueOf(r8));
        com.obric.cae.log.a.c(TAG, "engineStatusReport, status: " + r8 + ", location: " + r9, StarGeofenceManager.getGeofenceLogFile(this.mUserId));
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public void registerGeofenceCallback(String r6, a r7) {
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin");
        com.obric.cae.log.a.c(TAG, f.a("registerGeofenceCallback called by packageName: ", r6, ", uid: ").append(Binder.getCallingUid()).append(", pid: ").append(Binder.getCallingPid()).append(", callback: ").append(r8.hashCode()).toString(), StarGeofenceManager.getGeofenceLogFile(this.mUserId));
        Object r2 = this.mGeofenceCallbackLock;
        monitor-enter(r2);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mGeofenceCallbacks.register(r8, r6) == true) goto L7;
        com.obric.cae.log.a.c(TAG, "registerGeofenceCallback failed, packageName=" + r6 + (", callback=" + r8.hashCode()), StarGeofenceManager.getGeofenceLogFile(this.mUserId));     // Catch: Throwable -> L9
    L7:
        monitor-exit(r2);     // Catch: Throwable -> L9
    }

    public void unregisterGeofenceCallback(String r3, a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        com.obric.cae.log.a.c(TAG, f.a("unregisterGeofenceCallback called by packageName: ", r3, ", uid: ").append(Binder.getCallingUid()).append(", pid: ").append(Binder.getCallingPid()).append(", callback: ").append(r5.hashCode()).toString(), StarGeofenceManager.getGeofenceLogFile(this.mUserId));
        Object r6 = this.mGeofenceCallbackLock;
        monitor-enter(r6);
        this.mGeofenceCallbacks.unregister(r5);     // Catch: Throwable -> L10
        monitor-exit(r6);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
