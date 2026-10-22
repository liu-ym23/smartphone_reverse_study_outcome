package com.obric.cae.location.geosdk.poi;

import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.emoji2.text.g;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.libs.location.poi.IStarAoiBoardCallback;
import com.obric.cae.libs.location.poi.IStarAoiBoardManager;
import com.obric.cae.location.database.StarLocationAoiBoardStore;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.location.geofence.StarGeofenceManager;
import com.obric.cae.location.util.AoiBoardBindingUtil;
import com.obric.cae.location.util.AoiBoardUtil;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.userAware.report.SubwayEvaluationEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import o5.o;

/* JADX INFO: loaded from: classes.dex */
public final class StarAoiBoardManager {
    private static final long ACTIVE_LOCATION_TASK_TIMEOUT_MS = 20000;
    private static final int AOI_CONFIDENCE_RETRY_LIMIT = 2;
    private static final float AOI_GEOFENCE_ACTIVE_DISTANCE_METERS = 5000.0f;
    private static final int DEFAULT_AIRPORT_RADIUS_METERS = 3000;
    private static final int DEFAULT_CACHE_SIZE = 256;
    private static final long DEFAULT_CACHE_TTL_MS = 0;
    private static final int DEFAULT_SUBWAY_STATION_RADIUS_METERS = 500;
    private static final int DEFAULT_TRAIN_STATION_RADIUS_METERS = 700;
    private static final String GEOFENCE_PREFIX_AIRPORT = "airport_";
    private static final String GEOFENCE_PREFIX_AOI_BOARD = "aoi_board_";
    private static final String GEOFENCE_PREFIX_MALL = "mall_";
    private static final String GEOFENCE_PREFIX_SUBWAY_STATION = "subway_station_";
    private static final String GEOFENCE_PREFIX_TRAIN_STATION = "train_station_";
    private static final long HIGH_CONFIDENCE_LOCATION_REQUEST_INTERVAL_MS = 300000;
    private static final long LOW_CONFIDENCE_LOCATION_REQUEST_INTERVAL_MS = 1800000;
    private static final long MAX_CONFIDENCE_LOCATION_REQUEST_INTERVAL_MS = 180000;
    private static final long MEDIUM_CONFIDENCE_LOCATION_REQUEST_INTERVAL_MS = 900000;
    private static final int MIN_VALID_AOI_GEOFENCE_RADIUS_METERS = 1;
    private static final float NEAREST_AOI_LOG_DISTANCE_DELTA_METERS = 100.0f;
    private static final long NO_ACTIVE_LOCATION_REQUEST_INTERVAL_MS = Long.MAX_VALUE;
    private static final String STAR_DIR_NAME = "star";
    private static final String STR_POI_FILE_NAME = "star_poi.txt";
    private static final String TAG = "StarLocation-AoiManager";
    private static final int TRAFFIC_AOI_GEOFENCE_MIN_RADIUS_METERS = 300;
    private static final InnerAwareInfoCallback sAoiAwareCallback = null;
    private static final AtomicBoolean sInnerCallbackRegistered = null;
    private static final ConcurrentHashMap<Integer, StarAoiBoardManager> sInstances = null;
    private final LinkedHashMap<String, CacheEntry> mAoiBoardCache;
    private volatile boolean mAoiBoardsRecovered;
    private final ExecutorService mAoiCalculationExecutor;
    private final ConcurrentHashMap<String, AoiCalculationState> mAoiCalculationStateMap;
    private final ScheduledExecutorService mAoiLocationTaskExecutor;
    private final Context mAppContext;
    private final IStarAoiBoardManager.Stub mBinder;
    private final long mCacheTtlMs;
    private final ConcurrentHashMap<IBinder, IBinder.DeathRecipient> mCallbackDeathRecipientMap;
    private final ConcurrentHashMap<IBinder, IStarAoiBoardCallback> mCallbackMap;
    private final ConcurrentHashMap<IBinder, Integer> mCallbackUidMap;
    private volatile long mLastLocationRequestElapsedMs;
    private AoiBoard.Confidence mLastNearestAoiConfidence;
    private float mLastNearestAoiDistanceMeters;
    private String mLastNearestAoiPoiId;
    private volatile int mLatestHarStatus;
    private volatile int mLatestSteps;
    private boolean mLocationTaskInFlight;
    private final Object mLocationTaskLock;
    private String mLocationTaskPoiId;
    private ScheduledFuture<?> mLocationTaskTimeout;
    private long mLocationTaskToken;
    private final int mMaxCacheSize;
    private final File mPoiLogFile;
    private final AtomicBoolean mRecoveryFinished;
    private ScheduledFuture<?> mScheduledLocationTask;
    private long mScheduledLocationTaskAtElapsedMs;
    private final AoiBoardStore mStore;
    private final ConcurrentHashMap<Integer, Set<IBinder>> mUidCallbackBinderMap;
    private final int mUserId;

    /* JADX INFO: renamed from: com.obric.cae.location.geosdk.poi.StarAoiBoardManager$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$libs$location$poi$AoiBoard$Confidence = null;

        static {
            int[] r8 = new int[AoiBoard.Confidence.values().length];
            $SwitchMap$com$obric$cae$libs$location$poi$AoiBoard$Confidence = r8;
            r8[AoiBoard.Confidence.MAX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obric$cae$libs$location$poi$AoiBoard$Confidence[AoiBoard.Confidence.HIGH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obric$cae$libs$location$poi$AoiBoard$Confidence[AoiBoard.Confidence.MEDIUM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$obric$cae$libs$location$poi$AoiBoard$Confidence[AoiBoard.Confidence.LOW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$obric$cae$libs$location$poi$AoiBoard$Confidence[AoiBoard.Confidence.MIN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public interface AoiBoardStore {
        int deleteAllAoiBoards();

        int deleteAoiBoardsByTypes(Set<AoiBoard.Type> r8);

        List<AoiBoard> queryAllAoiBoards();

        AoiBoard queryAoiBoardByPoiId(String r8);

        boolean updateAoiBoardGeofenceId(String r8, String r10);

        boolean upsertAoiBoards(List<AoiBoard> r8);
    }

    public static final class AoiCalculationBatchResult {
        final List<AoiBoard> computedAoiBoards;
        final List<AoiDispatchRecord> dispatchRecords;
        final List<NearbyAoiBoardRecord> nearbyAoiBoardRecords;
        AoiBoard nearestAoiBoard;
        float shortestDistanceMeters;
        final List<AoiBoard> updatedAoiBoards;

        private AoiCalculationBatchResult() {
            this.computedAoiBoards = new ArrayList();
            this.updatedAoiBoards = new ArrayList();
            this.dispatchRecords = new ArrayList();
            this.nearbyAoiBoardRecords = new ArrayList();
            this.shortestDistanceMeters = Float.MAX_VALUE;
        }

        public /* synthetic */ AoiCalculationBatchResult(AnonymousClass1 r8) {
            this();
        }
    }

    public static final class AoiCalculationResult {
        private final float mDistanceMeters;
        private final boolean mHasStateChanged;
        private final boolean mShouldDispatchEvent;

        public AoiCalculationResult(boolean r8, boolean r10, float r11) {
            this.mHasStateChanged = r8;
            this.mShouldDispatchEvent = r10;
            this.mDistanceMeters = r11;
        }

        public float getDistanceMeters() {
            return this.mDistanceMeters;
        }

        public boolean hasStateChanged() {
            return this.mHasStateChanged;
        }

        public boolean shouldDispatchEvent() {
            return this.mShouldDispatchEvent;
        }
    }

    public static final class AoiCalculationState {
        AoiBoard.Confidence lastBaselineConfidence;
        long lastCalculatedElapsedMs;
        int lastCalculatedHarStatus;
        Location lastCalculatedLocation;
        int lastCalculatedSteps;
        float lastDistanceMeters;
        AoiBoard.Confidence lastEffectiveConfidence;
        AoiBoard.ConfidenceSource lastEffectiveConfidenceSource;
        AoiBoard.State lastResolvedState;
        int pendingActiveRequestCount;
        AoiBoard.Confidence retryLimitedConfidence;

        private AoiCalculationState() {
            this.lastCalculatedSteps = -1;
            this.lastCalculatedHarStatus = 4;
            this.lastDistanceMeters = Float.MAX_VALUE;
            this.lastResolvedState = AoiBoard.State.UNKNOWN;
        }

        public void record(Location r8, long r10, int r11, int r12, float r13, AoiBoard.State r14, AoiBoard.Confidence r15, AoiBoard.Confidence r16, AoiBoard.ConfidenceSource r17) {
            this.lastCalculatedElapsedMs = r10;
            this.lastCalculatedSteps = r11;
            this.lastCalculatedHarStatus = r12;
            this.lastDistanceMeters = r13;
            this.lastResolvedState = r14;
            this.lastBaselineConfidence = r15;
            this.lastEffectiveConfidence = r16;
            this.lastEffectiveConfidenceSource = r17;
            this.lastCalculatedLocation = new Location(r8);
        }

        public void resetRetryState(AoiBoard.State r8) {
            this.pendingActiveRequestCount = 0;
            this.retryLimitedConfidence = null;
            this.lastResolvedState = r8;
            this.lastEffectiveConfidenceSource = AoiBoard.ConfidenceSource.DISTANCE;
        }

        public /* synthetic */ AoiCalculationState(AnonymousClass1 r8) {
            this();
        }
    }

    public static final class AoiDispatchRecord {
        final AoiBoard aoiBoard;
        final Location location;

        public AoiDispatchRecord(AoiBoard r8, Location r10) {
            this.aoiBoard = r8;
            this.location = new Location(r10);
        }
    }

    public static final class AoiGeofenceCandidate {
        final AoiBoard aoiBoard;
        final float distanceMeters;
        private final LinkedHashMap<String, AoiBoard> mBoundAoiBoards;
        private boolean mCoveredByOther;
        final StarGeofence targetGeofence;

        public AoiGeofenceCandidate(AoiBoard r8, float r10, StarGeofence r11) {
            this.mBoundAoiBoards = new LinkedHashMap();
            this.aoiBoard = r8;
            this.distanceMeters = r10;
            this.targetGeofence = r11;
            addBoundAoiBoard(r8);
        }

        public void addBoundAoiBoard(AoiBoard r8) {
            if (r8.getPoiId().isEmpty() == true) goto L6;
            this.mBoundAoiBoards.put(r8.getPoiId(), r8);
            return;
        }

        public int getBoundAoiBoardCount() {
            return this.mBoundAoiBoards.size();
        }

        public List<AoiBoard> getBoundAoiBoards() {
            return new ArrayList(this.mBoundAoiBoards.values());
        }

        public void markCoveredByOther() {
            this.mCoveredByOther = true;
        }

        public boolean shouldCreateGeofence() {
            return !this.mCoveredByOther;
        }
    }

    public static final class AoiGeofenceDistanceResult {
        final List<AoiBoard> boundAoiBoards;
        boolean hasNearbyAoiBoard;
        float nearestDistanceMeters;

        public AoiGeofenceDistanceResult(List<AoiBoard> r8) {
            this.nearestDistanceMeters = Float.MAX_VALUE;
            this.boundAoiBoards = r8;
        }

        public void recordDistance(float r8) {
            if (r8 >= this.nearestDistanceMeters) goto L6;
            this.nearestDistanceMeters = r8;
            return;
        }
    }

    public static final class CacheEntry {
        final AoiBoard aoiBoard;
        final long updatedAtMs;

        public CacheEntry(AoiBoard r8, long r10) {
            this.aoiBoard = r8;
            this.updatedAtMs = r10;
        }
    }

    public static final class ConfidenceResult {
        final AoiBoard.Confidence confidence;
        final AoiBoard.ConfidenceSource source;

        public ConfidenceResult(AoiBoard.Confidence r8, AoiBoard.ConfidenceSource r10) {
            this.confidence = r8;
            this.source = r10;
        }
    }

    public static final class NearbyAoiBoardRecord {
        final AoiBoard aoiBoard;
        final float distanceMeters;

        public NearbyAoiBoardRecord(AoiBoard r8, float r10) {
            this.aoiBoard = r8;
            this.distanceMeters = r10;
        }
    }

    public static final class TrafficGeofenceShape {
        final double centerLatitude;
        final double centerLongitude;
        final boolean fromAoi;
        final int radiusMeters;

        public TrafficGeofenceShape(double r8, double r10, int r11, boolean r12) {
            this.centerLatitude = r8;
            this.centerLongitude = r10;
            this.radiusMeters = r11;
            this.fromAoi = r12;
        }
    }

    static {
        DEFAULT_CACHE_TTL_MS = TimeUnit.MINUTES.toMillis(10);
        sInstances = new ConcurrentHashMap();
        sInnerCallbackRegistered = new AtomicBoolean(false);
        sAoiAwareCallback = new AnonymousClass1();
    }

    private StarAoiBoardManager(Context r8, int r10) {
        this(r8, r10, new StarLocationAoiBoardStore(r8.getApplicationContext(), r10), DEFAULT_CACHE_TTL_MS, 256);
    }

    public static /* synthetic */ AoiCalculationState a(String r8) {
        return lambda$handleLocationTaskTimeoutRetry$11(r8);
    }

    public static /* synthetic */ List access$000() {
        return snapshotInstances();
    }

    public static /* synthetic */ void access$100(StarAoiBoardManager r8, int r10) {
        r8.handleStepsCounterChanged(r10);
    }

    public static /* synthetic */ void access$200(StarAoiBoardManager r8, int r10, long r11) {
        r8.handleHarStatusChanged(r10, r11);
    }

    public static /* synthetic */ void access$300(StarAoiBoardManager r8, Location r10) {
        r8.handleLocationChanged(r10);
    }

    public static /* synthetic */ void access$400(StarAoiBoardManager r8, StarGeofence r10, Location r11) {
        r8.handleGeofenceInfoChanged(r10, r11);
    }

    public static /* synthetic */ boolean access$500(StarAoiBoardManager r8) {
        return r8.mAoiBoardsRecovered;
    }

    public static /* synthetic */ List access$600(StarAoiBoardManager r8) {
        return r8.listVisibleAoiBoards();
    }

    public static /* synthetic */ List access$700(StarAoiBoardManager r8, int r10) {
        return r8.listVisibleAoiBoardsByType(r10);
    }

    public static /* synthetic */ AoiBoard access$800(StarAoiBoardManager r8, String r10) {
        return r8.findVisibleAoiBoardByPoiId(r10);
    }

    public static /* synthetic */ int access$900(StarAoiBoardManager r8) {
        return r8.mMaxCacheSize;
    }

    private boolean addTrafficGeofence(StarGeofence r8, float r10) {
        byte r11 = StarGeofenceManager.getInstance(this.mAppContext, 0).getBinder().addGeofence(r8);     // Catch: Throwable -> L12
        if (r11 != 0) goto L6;
    L9:
        boolean r12 = true;
    L10:
        CommSenseLog.dWithMethodName(TAG, "add nearby traffic geofence id=" + r8.getGeofenceId() + ", poiId=" + r8.getPoiId() + ", distanceMeters=" + r10 + ", radius=" + r8.getRadius() + ", result=" + r11);     // Catch: Throwable -> L12
        return r12;
    L6:
        if (r11 == 9) goto L9;
        r12 = false;
    L12:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "add traffic geofence failed id=" + r8.getGeofenceId(), th);
        return false;
    }

    private void applyAoiBoardState(AoiBoard r8, AoiBoard.State r10, AoiBoard.Event r11) {
        if (r11 != AoiBoard.Event.UNKNOWN) goto L5;
        r8.applyState(r10);
        return;
    L5:
        r8.applyEvent(r11);
    }

    public static /* synthetic */ void b(StarAoiBoardManager r8, long r10, String r11, AoiBoard r12) {
        r8.lambda$scheduleLocationTask$9(r10, r11, r12);
    }

    private void bindCoveredAoiBoardsToCoveringGeofences(List<AoiGeofenceCandidate> r8) {
        Iterator<AoiGeofenceCandidate> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        AoiGeofenceCandidate r11 = r10.next();
        AoiGeofenceCandidate r12 = findBestCoveringCandidate(r11, r8);
        if (r12 == null) goto L4;
        r12.addBoundAoiBoard(r11.aoiBoard);
        r11.markCoveredByOther();
        CommSenseLog.dWithMethodName(TAG, "bind covered aoi to larger geofence, poiId=" + r11.aoiBoard.getPoiId() + ", geofenceId=" + r12.targetGeofence.getGeofenceId() + ", ownerPoiId=" + r12.aoiBoard.getPoiId());
        goto L4
    }

    public static AoiBoard buildAoiBoard(String r8, String r10, String r11, StarGeofence r12) {
        AoiBoard r13 = buildAoiBoard(r8, r10, r11, resolveAoiBoardType(r12.getGeoType()));
        r13.setTransitionType(resolveAoiBoardTransitionType(r12.getTransitionType()));
        return r13;
    }

    private StarGeofence buildAoiBoardGeofence(AoiBoard r13) {
        AoiBoardUtil.AoiGeometry r8 = AoiBoardUtil.calculateGeometry(r13.getAoiBoard());
        if (r8 != null) goto L6;
        return null;
    L6:
        int r10 = Math.max(1, (int) Math.ceil(r8.getRadiusMeters()));
        StarGeofence r11 = new StarGeofence(this.mAppContext.getPackageName(), resolveAoiBoardGeofenceId(r13), r8.getCenterLatitude(), r8.getCenterLongitude(), r10, StarGeofence.GeoTransitionType.ENTERED_AND_EXITED);
        r11.setAddress(r13.getPoiName());
        r11.setConfidence(StarGeofence.GeoConfidence.HIGH);
        r11.setGeoType(resolveAoiBoardGeoType(r13.getType()));
        r11.setPoiId(r13.getPoiId());
        return r11;
    }

    private String buildAoiBoardGeofenceId(AoiBoard r8) {
        if (r8.getType() != AoiBoard.Type.MALL) goto L7;
        StringBuilder r10 = new StringBuilder(GEOFENCE_PREFIX_MALL);
    L5:
        r10.append(r8.getPoiId());
        return r10.toString();
    L7:
        r10 = new StringBuilder(GEOFENCE_PREFIX_AOI_BOARD);
        goto L5
    }

    private Map<String, AoiBoard> buildAoiBoardMapByPoiId(List<AoiBoard> r8) {
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<AoiBoard> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        AoiBoard r12 = r11.next();
        if (r12 == null) goto L4;
        if (r12.getPoiId().isEmpty() == true) goto L4;
        r10.put(r12.getPoiId(), r12);
        goto L4
    L11:
        return r10;
    }

    private Map<String, List<AoiBoard>> buildAoiBoardsMapByGeofenceId(List<AoiBoard> r8) {
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<AoiBoard> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        AoiBoard r12 = r11.next();
        if (r12 == null) goto L4;
        if (r12.getGeofenceId().isEmpty() == true) goto L4;
        ((List) r10.computeIfAbsent(r12.getGeofenceId(), new com.obric.cae.BWDL.BwdlDrop.a(5))).add(r12);
        goto L4
    L11:
        return r10;
    }

    private List<AoiGeofenceCandidate> buildAoiGeofenceCandidates(List<NearbyAoiBoardRecord> r8) {
        ArrayList r10 = new ArrayList();
        Iterator<NearbyAoiBoardRecord> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L14;
        NearbyAoiBoardRecord r12 = r11.next();
        if (r12 == null) goto L4;
        if (shouldCreateAoiGeofenceOwnerCandidate(r12.aoiBoard) == false) goto L4;
        StarGeofence r13 = buildAoiBoardGeofence(r12.aoiBoard);
        if (r13 == null) goto L4;
        r10.add(new AoiGeofenceCandidate(r12.aoiBoard, r12.distanceMeters, r13));
        goto L4
    L14:
        return r10;
    }

    private String buildLegacyAoiBoardGeofenceId(AoiBoard r8) {
        return GEOFENCE_PREFIX_AOI_BOARD + r8.getPoiId();
    }

    private Set<String> buildTargetGeofencePoiIds(AoiGeofenceCandidate r8, StarGeofence r10) {
        LinkedHashSet r11 = new LinkedHashSet();
        if (r10 == null) goto L5;
        r11.addAll(AoiBoardBindingUtil.parsePoiIds(r10.getPoiId()));
    L5:
        r11.addAll(AoiBoardBindingUtil.parsePoiIds(r8.targetGeofence.getPoiId()));
        Iterator<AoiBoard> r12 = r8.getBoundAoiBoards().iterator();
    L7:
        if (r12.hasNext() == false) goto L13;
        AoiBoard r13 = r12.next();
        if (r13 == null) goto L7;
        if (r13.getPoiId().isEmpty() == true) goto L7;
        r11.add(r13.getPoiId());
        goto L7
    L13:
        return r11;
    }

    private StarGeofence buildTrafficGeofence(AoiBoard r13) {
        return buildTrafficGeofence(buildTrafficGeofenceId(r13.getType(), r13.getPoiId()), r13.getPoiName(), r13.getPoiId(), r13.getAoiBoard(), 0.0d, 0.0d, r13.getType());
    }

    private String buildTrafficGeofenceId(AoiBoard.Type r8, String r10) {
        if (r8 != AoiBoard.Type.AIRPORT) goto L6;
        StringBuilder r11 = new StringBuilder(GEOFENCE_PREFIX_AIRPORT);
    L9:
        r11.append(r10);
        return r11.toString();
    L6:
        if (r8 != AoiBoard.Type.SUBWAY_STATION) goto L8;
        r11 = new StringBuilder(GEOFENCE_PREFIX_SUBWAY_STATION);
        goto L9
    L8:
        r11 = new StringBuilder(GEOFENCE_PREFIX_TRAIN_STATION);
        goto L9
    }

    private Map<String, StarGeofence> buildTrafficGeofenceMap(List<StarGeofence> r8) {
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<StarGeofence> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        StarGeofence r12 = r11.next();
        if (r12 == null) goto L4;
        if (r12.getPoiId() == null) goto L4;
        if (r12.getPoiId().isEmpty() == true) goto L4;
        r10.put(r12.getPoiId(), r12);
        goto L4
    L13:
        return r10;
    }

    private TrafficGeofenceShape buildTrafficGeofenceShape(String r15, double r16, double r18, int r20) {
        if (r15 == null) goto L16;
        if (r15.isEmpty() == true) goto L16;
        AoiBoardUtil.AoiGeometry r8 = AoiBoardUtil.calculateGeometry(r15);
        if (r8 == null) goto L14;
        if (r8.getRadiusMeters() <= 0.0d) goto L14;
        int r10 = Math.max(300, (int) Math.ceil(r8.getRadiusMeters()));
        return new TrafficGeofenceShape(r8.getCenterLatitude(), r8.getCenterLongitude(), r10, true);
    L14:
        return new TrafficGeofenceShape(r16, r18, r20, false);
    L16:
        return new TrafficGeofenceShape(r16, r18, r20, false);
    }

    public static /* synthetic */ String c(String r8, boolean r10) {
        return lambda$dump$7(r10, r8);
    }

    private void cacheAoiBoardLocked(AoiBoard r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.getPoiId().isEmpty() == true) goto L9;
        this.mAoiBoardCache.put(r8.getPoiId(), new CacheEntry(copyAoiBoard(r8), System.currentTimeMillis()));
        return;
    }

    private void cacheAoiBoardsLocked(List<AoiBoard> r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isEmpty() == true) goto L12;
        Iterator<AoiBoard> r10 = r8.iterator();
    L8:
        if (r10.hasNext() == false) goto L13;
        cacheAoiBoardLocked(r10.next());
        goto L8
    L13:
        return;
    }

    public static void calculateAllAoiBoardsByFreshLocation(Context r8, Location r10) {
        getInstance(r8, 0);
        List<StarAoiBoardManager> r11 = snapshotInstances();
        if (r11.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<StarAoiBoardManager> r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r12.next().handleLocationChanged(r10);
        goto L7
    L9:
        CommSenseLog.dWithMethodName(TAG, "fresh location dispatched to aoi managers, count=" + r11.size());
    }

    private AoiCalculationBatchResult calculateAoiBoardsByLocation(List<AoiBoard> r10, Location r11, boolean r12) {
        long r8 = SystemClock.elapsedRealtime();
        AoiCalculationBatchResult r13 = new AoiCalculationBatchResult(null);
        Iterator<AoiBoard> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L27;
        AoiBoard r15 = r14.next();
        if (r15 == null) goto L4;
        if (r15.getPoiId().isEmpty() == true) goto L4;
        if (r15.getAoiBoard().isEmpty() == true) goto L4;
        AoiCalculationResult r16 = maybeCalculateAoiBoardEvent(r15, r11, r8);     // Catch: Throwable -> L25
        r13.computedAoiBoards.add(r15);     // Catch: Throwable -> L25
        if (r16.getDistanceMeters() >= r13.shortestDistanceMeters) goto L15;
        r13.shortestDistanceMeters = r16.getDistanceMeters();     // Catch: Throwable -> L25
        r13.nearestAoiBoard = r15;     // Catch: Throwable -> L25
    L15:
        if (r12 == false) goto L20;
        if (r16.getDistanceMeters() > AOI_GEOFENCE_ACTIVE_DISTANCE_METERS) goto L20;
        r13.nearbyAoiBoardRecords.add(new NearbyAoiBoardRecord(r15, r16.getDistanceMeters()));     // Catch: Throwable -> L25
    L20:
        if (r16.hasStateChanged() == false) goto L4;
        r13.updatedAoiBoards.add(r15);     // Catch: Throwable -> L25
        if (r16.shouldDispatchEvent() == false) goto L4;
        r13.dispatchRecords.add(new AoiDispatchRecord(r15, r11));     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed, poiId=" + r15.getPoiId(), th);
        goto L4
    L27:
        return r13;
    }

    private boolean clearAoiGeofenceBindingIfMatch(AoiBoard r8, String r10, String r11) {
        String r12 = r8.getGeofenceId();
        if (r12.isEmpty() == false) goto L7;
        return true;
    L7:
        if (r10 != null) goto L9;
    L14:
        boolean r13 = localAoiBoardManager().updateAoiBoardGeofenceId(r8.getPoiId(), "");
        if (r13 == false) goto L17;
        r8.setGeofenceId("");
    L17:
        CommSenseLog.vWithMethodName(TAG, "clear aoi geofence binding poiId=" + r8.getPoiId() + ", geofenceId=" + r12 + ", reason=" + r11 + ", updated=" + r13);
        return r13;
    L9:
        if (r10.isEmpty() == true) goto L14;
        if (r10.equals(r12) == true) goto L14;
        CommSenseLog.vWithMethodName(TAG, "skip clear aoi geofence binding poiId=" + r8.getPoiId() + ", boundGeofenceId=" + r12 + ", expectedGeofenceId=" + r10 + ", reason=" + r11);
        return false;
    }

    private int clearAoiGeofenceBindingsIfMatch(List<AoiBoard> r8, String r10, String r11) {
        Iterator<AoiBoard> r12 = r8.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L13;
        AoiBoard r14 = r12.next();
        if (r14 == null) goto L4;
        if (r14.getPoiId().isEmpty() == true) goto L4;
        if (clearAoiGeofenceBindingIfMatch(r14, r10, r11) == false) goto L4;
        r13 = r13 + 1;
        goto L4
    L13:
        return r13;
    }

    private void clearTrafficGeofenceBindingsById(String r8, String r10, List<AoiBoard> r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isEmpty() == true) goto L12;
        Iterator<AoiBoard> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L13;
        clearAoiGeofenceBindingIfMatch(r12.next(), r8, r10);
        goto L8
    L13:
        return;
    }

    public static AoiBoard copyAoiBoard(AoiBoard r8) {
        AoiBoard r10 = new AoiBoard();
        r10.setPoiId(r8.getPoiId());
        r10.setPoiName(r8.getPoiName());
        r10.setAoiBoard(r8.getAoiBoard());
        r10.setCurState(r8.getCurState());
        r10.setTransitionType(r8.getTransitionType());
        r10.setConfidence(r8.getConfidence());
        r10.setConfidenceSource(r8.getConfidenceSource());
        r10.setEvent(r8.getEvent());
        r10.setType(r8.getType());
        r10.setGeofenceId(r8.getGeofenceId());
        r10.setEventTime(r8.getEventTime());
        return r10;
    }

    private static List<AoiBoard> copyAoiBoards(List<AoiBoard> r8) {
        if (r8 == null) goto L14;
        if (r8.isEmpty() == true) goto L14;
        ArrayList r10 = new ArrayList(r8.size());
        Iterator<AoiBoard> r11 = r8.iterator();
    L8:
        if (r11.hasNext() == false) goto L12;
        AoiBoard r12 = r11.next();
        if (r12 == null) goto L8;
        r10.add(copyAoiBoard(r12));
        goto L8
    L12:
        return r10;
    L14:
        return Collections.emptyList();
    }

    public static /* synthetic */ void d(StarAoiBoardManager r8, long r10, AoiBoard r11) {
        r8.lambda$executeLocationTask$10(r10, r11);
    }

    private StarLocationDbManager dbManager(int r8) {
        return StarLocationDbManager.getInstance(this.mAppContext, r8);
    }

    private boolean deleteGeofenceById(int r8, String r10, String r11) {
        if (r10 != null) goto L5;
    L13:
        return false;
    L5:
        if (r10.isEmpty() == true) goto L13;
        byte r12 = StarGeofenceManager.getInstance(this.mAppContext, r8).getBinder().deleteGeofenceById(this.mAppContext.getPackageName(), r10);     // Catch: Throwable -> L11
        CommSenseLog.dWithMethodName(TAG, "delete geofence id=" + r10 + ", reason=" + r11 + ", managerUserId=" + r8 + ", result=" + r12);     // Catch: Throwable -> L11
        if (r12 != 0) goto L16;
        return true;
    L16:
        return false;
    L11:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, defpackage.b.e("delete geofence failed id=", r10, ", reason=", r11), th);
        goto L13
    }

    private void deleteObsoleteAoiGeofenceIfNeeded(AoiBoard r8, String r10) {
        String r11 = r8.getGeofenceId();
        if (r11.isEmpty() == false) goto L5;
        return;
    L5:
        if (r11.equals(r10) == false) goto L7;
        return;
    L7:
        if (isManagedAoiGeofenceId(r11) == false) goto L18;
        CommSenseLog.dWithMethodName(TAG, "delete obsolete aoi geofence id=" + r11 + ", poiId=" + r8.getPoiId() + ", targetGeofenceId=" + r10 + ", result=" + StarGeofenceManager.getInstance(this.mAppContext, this.mUserId).getBinder().deleteGeofenceById(this.mAppContext.getPackageName(), r11));     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "delete obsolete aoi geofence failed id=".concat(r11), th);
        return;
    }

    private boolean deleteTrafficGeofence(StarGeofence r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        return deleteGeofenceById(0, r8.getGeofenceId(), "traffic");
    }

    private void dispatchAoiBoardEvent(AoiBoard r8, Location r10) {
        if (this.mUserId != 0) goto L5;
        notifyAoiBoardEventToAllUsers(this.mAppContext, r8, r10);
        return;
    L5:
        notifyAoiBoardEvent(r8, r10);
    }

    private AoiBoard.Confidence downgradeConfidence(AoiBoard.Confidence r8) {
        int r10 = AnonymousClass4.$SwitchMap$com$obric$cae$libs$location$poi$AoiBoard$Confidence[r8.ordinal()];
        if (r10 == 1) goto L19;
        if (r10 == 2) goto L17;
        if (r10 == 3) goto L15;
        if (r10 == 4) goto L13;
        return AoiBoard.Confidence.MIN;
    L13:
        return AoiBoard.Confidence.MIN;
    L15:
        return AoiBoard.Confidence.LOW;
    L17:
        return AoiBoard.Confidence.MEDIUM;
    L19:
        return AoiBoard.Confidence.HIGH;
    }

    public static /* synthetic */ void e(StarAoiBoardManager r8, StarGeofence r10, Location r11) {
        r8.lambda$handleGeofenceInfoChanged$4(r10, r11);
    }

    private static void ensureInnerAwareCallbackRegistered() {
        if (sInnerCallbackRegistered.compareAndSet(false, true) == false) goto L6;
        UserAwareManager.getInstance().registerInnerCallback(sAoiAwareCallback);
        CommSenseLog.dWithMethodName(TAG, "inner aware callback registered");
        return;
    }

    private void ensureNearbyAoiGeofenceCoverage(Location r8, List<NearbyAoiBoardRecord> r10) {
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        List<AoiGeofenceCandidate> r11 = buildAoiGeofenceCandidates(r10);
        if (r11.isEmpty() == false) goto L8;
        return;
    L8:
        bindCoveredAoiBoardsToCoveringGeofences(r11);
        LinkedHashMap r12 = new LinkedHashMap();
        int r13 = 0;
        Iterator<StarGeofence> r14 = dbManager(this.mUserId).queryAllGeofences().iterator();     // Catch: Throwable -> L24
    L11:
        if (r14.hasNext() == false) goto L16;
        StarGeofence r15 = r14.next();     // Catch: Throwable -> L24
        if (isAoiBoardGeofence(r15) == false) goto L11;
        r12.put(r15.getGeofenceId(), r15);     // Catch: Throwable -> L24
        goto L11
    L16:
        if (this.mUserId == 0) goto L26;
        Iterator<StarGeofence> r16 = dbManager(0).queryGeofencesByUserIdAndType(-1, null).iterator();     // Catch: Throwable -> L24
    L18:
        if (r16.hasNext() == false) goto L26;
        StarGeofence r17 = r16.next();     // Catch: Throwable -> L24
        if (isAoiBoardGeofence(r17) == false) goto L18;
        r12.putIfAbsent(r17.getGeofenceId(), r17);     // Catch: Throwable -> L24
    L26:
        Iterator<AoiGeofenceCandidate> r18 = r11.iterator();
    L28:
        if (r18.hasNext() == false) goto L35;
        AoiGeofenceCandidate r19 = r18.next();
        if (r19.shouldCreateGeofence() == false) goto L28;
        if (ensureSingleAoiGeofenceCoverage(r19, r12) == false) goto L28;
        r13 = r13 + r19.getBoundAoiBoardCount();
        goto L28
    L35:
        if (r13 <= 0) goto L57;
        StringBuilder r20 = new StringBuilder("[");
        defpackage.b.q(r20, this.mUserId, "] nearby aoi geofence coverage, count=", r13, ", activeDistanceMeters=5000.0, lat=");
        r20.append(r8.getLatitude());
        r20.append(", lon=");
        r20.append(r8.getLongitude());
        dumpPoiLog(r20.toString());
        return;
    L57:
        return;
    L24:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "query existing aoi geofences failed userId=" + this.mUserId, th);
        goto L26
    }

    private void ensureNearbyTrafficGeofence(AoiBoard r8, StarGeofence r10, float r11) {
        StarGeofence r12 = buildTrafficGeofence(r8);
        if (r12 != null) goto L5;
        return;
    L5:
        String r13 = r12.getGeofenceId();
        String r14 = r8.getGeofenceId();
        if (r14.isEmpty() == true) goto L13;
        if (r10 != null) goto L9;
    L12:
        clearAoiGeofenceBindingIfMatch(r8, null, "traffic_stale_binding");
        goto L13
    L9:
        if (r14.equals(r10.getGeofenceId()) == false) goto L12;
        CommSenseLog.vWithMethodName(TAG, "skip add bound traffic geofence poiId=" + r8.getPoiId() + ", geofenceId=" + r14 + ", distanceMeters=" + r11);
        return;
    L13:
        if (r10 == null) goto L23;
        if (r13.equals(r10.getGeofenceId()) == false) goto L19;
        persistTrafficGeofenceBinding(r8, r13, "recover_existing");
        CommSenseLog.dWithMethodName(TAG, "recover traffic geofence binding poiId=" + r8.getPoiId() + ", geofenceId=" + r13 + ", distanceMeters=" + r11);
        return;
    L19:
        if (deleteTrafficGeofence(r10) == true) goto L21;
        return;
    L21:
        clearAoiGeofenceBindingIfMatch(r8, r10.getGeofenceId(), "traffic_replace_existing");
    L23:
        if (r8.getGeofenceId().isEmpty() == true) goto L26;
        return;
    L26:
        if (addTrafficGeofence(r12, r11) == false) goto L29;
        persistTrafficGeofenceBinding(r8, r13, "nearby_add");
        return;
    }

    private boolean ensureSingleAoiGeofenceCoverage(AoiGeofenceCandidate r13, Map<String, StarGeofence> r14) {
        AoiBoard r8 = r13.aoiBoard;
        StarGeofence r10 = r13.targetGeofence;
        if (r10 != null) goto L5;
        return false;
    L5:
        String r11 = r10.getGeofenceId();
        StarGeofence r12 = r14.get(r11);
        Set<String> r15 = buildTargetGeofencePoiIds(r13, r12);
        r10.setPoiId(AoiBoardBindingUtil.joinPoiIds(r15));
        if (r12 == null) goto L36;
        Set<String> r16 = AoiBoardBindingUtil.parsePoiIds(r12.getPoiId());
        if (r16.isEmpty() == false) goto L10;
    L14:
        boolean r17 = updateExistingAoiGeofenceIfNeeded(r12, r10, r8, r13.distanceMeters);
        if (r17 == false) goto L17;
        r14.put(r11, r10);
    L17:
        int r18 = persistAoiGeofenceBindings(r13.getBoundAoiBoards(), r11, "recover_existing");
        if (r17 == true) goto L21;
        if (r18 > 0) goto L21;
        return false;
    L21:
        return true;
    L10:
        if (Collections.disjoint(r16, r15) == false) goto L14;
        StringBuilder r19 = defpackage.b.h("skip aoi geofence id conflict, geofenceId=", r11, ", poiId=");
        r19.append(r8.getPoiId());
        r19.append(", existingPoiIds=");
        r19.append(r16);
        CommSenseLog.wWithMethodName(TAG, r19.toString());
        return false;
    L36:
        byte r20 = StarGeofenceManager.getInstance(this.mAppContext, this.mUserId).getBinder().addGeofence(r10);     // Catch: Throwable -> L33
        if (r20 != 0) goto L26;
    L29:
        r14.put(r11, r10);     // Catch: Throwable -> L33
        int r110 = persistAoiGeofenceBindings(r13.getBoundAoiBoards(), r11, "nearby_add");     // Catch: Throwable -> L33
        CommSenseLog.dWithMethodName(TAG, "add nearby aoi geofence id=" + r11 + ", poiIds=" + r10.getPoiId() + ", type=" + r8.getType() + ", distanceMeters=" + r13.distanceMeters + ", radius=" + r10.getRadius() + ", result=" + r20 + ", bindingCount=" + r110);     // Catch: Throwable -> L33
        if (r110 > 0) goto L32;
        return false;
    L32:
        return true;
    L26:
        if (r20 == 9) goto L29;
        CommSenseLog.wWithMethodName(TAG, "add nearby aoi geofence failed id=" + r11 + ", poiId=" + r8.getPoiId() + ", result=" + r20);     // Catch: Throwable -> L33
    L35:
        return false;
    L33:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "add nearby aoi geofence failed id=" + r11, th);
        goto L35
    }

    private void executeLocationTask(long r11, String r13, AoiBoard r14) {
        Object r8 = this.mLocationTaskLock;
        monitor-enter(r8);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (r11 == this.mLocationTaskToken) goto L9;
        monitor-exit(r8);     // Catch: Throwable -> L19
        return;
    L9:
        if (this.mLocationTaskInFlight == false) goto L12;
        monitor-exit(r8);     // Catch: Throwable -> L19
        return;
    L12:
        this.mLocationTaskInFlight = true;     // Catch: Throwable -> L19
        this.mScheduledLocationTask = null;     // Catch: Throwable -> L19
        this.mScheduledLocationTaskAtElapsedMs = 0;     // Catch: Throwable -> L19
        ScheduledFuture<?> r10 = this.mLocationTaskTimeout;     // Catch: Throwable -> L19
        if (r10 == null) goto L15;
        r10.cancel(false);     // Catch: Throwable -> L19
    L15:
        this.mLocationTaskTimeout = this.mAoiLocationTaskExecutor.schedule(new com.bytedance.bdlocation.scan.bluetooth.c(this, r11, r14, 1), 20000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L19
        monitor-exit(r8);     // Catch: Throwable -> L19
        markActiveLocationRequested(Collections.singletonList(r14));
        this.mLastLocationRequestElapsedMs = SystemClock.elapsedRealtime();
        dumpPoiLog("[" + this.mUserId + "] run location task, reason= " + r13 + ", poiId=" + r14.getPoiId() + ", confidence=" + r14.getConfidence() + ", confidenceSource=" + formatConfidenceSource(r14));
        LocationUtil.getInstance().requestSingleLocationUpdates("fused", true, CommSenseLog.getMethodName());
    }

    public static /* synthetic */ List f(String r8) {
        return lambda$buildAoiBoardsMapByGeofenceId$6(r8);
    }

    private AoiGeofenceCandidate findBestCoveringCandidate(AoiGeofenceCandidate r11, List<AoiGeofenceCandidate> r12) {
        Iterator<AoiGeofenceCandidate> r10 = r12.iterator();
        AoiGeofenceCandidate r13 = null;
    L4:
        if (r10.hasNext() == false) goto L17;
        AoiGeofenceCandidate r8 = r10.next();
        if (r8 == r11) goto L4;
        if (r8.targetGeofence.getRadius() <= r11.targetGeofence.getRadius()) goto L4;
        StarGeofence r14 = r8.targetGeofence;
        if (AoiBoardUtil.isAoiBoardCoveredByCircle(r11.aoiBoard.getAoiBoard(), r14.getLatitude(), r14.getLongitude(), r14.getRadius()) == false) goto L4;
        if (r13 == null) goto L16;
        if (r8.targetGeofence.getRadius() >= r13.targetGeofence.getRadius()) goto L4;
    L16:
        r13 = r8;
        goto L4
    L17:
        return r13;
    }

    private AoiBoard findVisibleAoiBoardByPoiId(String r8) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.isEmpty() == true) goto L16;
        AoiBoard r10 = localAoiBoardManager().queryAoiBoardByPoiId(r8);
        if (r10 == null) goto L9;
    L13:
        return r10;
    L9:
        if (this.mUserId == 0) goto L13;
        return systemAoiBoardManager().queryAoiBoardByPoiId(r8);
    L16:
        return null;
    }

    private void finishLocationTaskIfNeeded(String r8) {
        Object r10 = this.mLocationTaskLock;
        monitor-enter(r10);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocationTaskInFlight == true) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L14
        return;
    L8:
        this.mLocationTaskInFlight = false;     // Catch: Throwable -> L14
        ScheduledFuture<?> r11 = this.mLocationTaskTimeout;     // Catch: Throwable -> L14
        if (r11 == null) goto L11;
        r11.cancel(false);     // Catch: Throwable -> L14
        this.mLocationTaskTimeout = null;     // Catch: Throwable -> L14
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L14
        CommSenseLog.vWithMethodName(TAG, "[" + this.mUserId + "] reason= " + r8);
    }

    private String formatCallback(IStarAoiBoardCallback r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        return " callback=" + r8.hashCode();
    }

    private static String formatConfidenceSource(AoiBoard.ConfidenceSource r8) {
        return r8.name();
    }

    public static /* synthetic */ void g(StarAoiBoardManager r8, Location r10) {
        r8.lambda$handleAoiGeofencePruneByLocation$3(r10);
    }

    public static ConcurrentHashMap<Integer, StarAoiBoardManager> getAllInstances() {
        return sInstances;
    }

    private int getDefaultTrafficRadiusMeters(AoiBoard.Type r8) {
        if (r8 != AoiBoard.Type.AIRPORT) goto L7;
        return 3000;
    L7:
        if (r8 != AoiBoard.Type.SUBWAY_STATION) goto L10;
        return 500;
    L10:
        return DEFAULT_TRAIN_STATION_RADIUS_METERS;
    }

    public static synchronized StarAoiBoardManager getInstance(Context r8) {
        monitor-enter(StarAoiBoardManager.class);
        StarAoiBoardManager r10 = getInstance(r8, 0);     // Catch: Throwable -> L8
        monitor-exit(StarAoiBoardManager.class);
        return r10;
    L8:
        th = move-exception;
        throw th;
    }

    private static synchronized StarAoiBoardManager getOrCreateInstanceLocked(Context r8, int r10) {
        monitor-enter(StarAoiBoardManager.class);
        ConcurrentHashMap<Integer, StarAoiBoardManager> r11 = sInstances;     // Catch: Throwable -> L9
        StarAoiBoardManager r12 = r11.get(Integer.valueOf(r10));     // Catch: Throwable -> L9
        if (r12 != null) goto L7;
        r12 = new StarAoiBoardManager(r8, r10);     // Catch: Throwable -> L9
        r11.put(Integer.valueOf(r10), r12);     // Catch: Throwable -> L9
    L7:
        monitor-exit(StarAoiBoardManager.class);
        return r12;
    L9:
        th = move-exception;
        throw th;
    }

    public static EnumSet<AoiBoard.Type> getTrafficAoiBoardTypes() {
        return EnumSet.of(AoiBoard.Type.AIRPORT, AoiBoard.Type.TRAIN_STATION, AoiBoard.Type.SUBWAY_STATION);
    }

    public static /* synthetic */ void h(StarAoiBoardManager r8, Location r10) {
        r8.lambda$handleLocationChanged$2(r10);
    }

    private void handleAoiGeofencePruneByLocation(Location r8) {
        Location r10 = new Location(r8);
        this.mAoiCalculationExecutor.execute(new c(this, r10, 0));
    }

    private void handleGeofenceInfoChanged(StarGeofence r8, Location r10) {
        String r11 = r8.getPoiId();
        if (r8.getGeoState() == StarGeofence.GeoState.UNKNOWN) goto L10;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.isEmpty() == true) goto L12;
        Location r12 = new Location(r10);
        this.mAoiCalculationExecutor.execute(new g(this, r8, r12, 2));
        return;
    L12:
        return;
    }

    private void handleHarStatusChanged(int r8, long r10) {
        if (this.mLatestHarStatus != r8) goto L5;
        return;
    L5:
        this.mLatestHarStatus = r8;
        maybeRequestFreshLocation(SubwayEvaluationEvent.VERIFY_EVENT_TYPE_HAR);
    }

    private void handleLocationChanged(Location r8) {
        Location r10 = new Location(r8);
        this.mAoiCalculationExecutor.execute(new c(this, r10, 1));
    }

    private void handleLocationTaskTimeoutRetry(String r12) {
        AoiBoard r8 = localAoiBoardManager().queryAoiBoardByPoiId(r12);
        if (r8 != null) goto L5;
    L23:
        CommSenseLog.dWithMethodName(TAG, "[" + this.mUserId + "] skip timeout retry, poiId=" + r12);
        return;
    L5:
        if (r8.getPoiId().isEmpty() == true) goto L23;
        if (r8.getAoiBoard().isEmpty() == true) goto L23;
        AoiCalculationState r10 = this.mAoiCalculationStateMap.computeIfAbsent(r12, new com.obric.cae.BWDL.BwdlDrop.a(2));
        AoiBoard.Confidence r11 = r10.lastBaselineConfidence;
        if (r11 != null) goto L12;
        r11 = r8.getConfidence();
    L12:
        AoiBoard.Confidence r13 = r11;
        maybeDegradeConfidenceForRetry(r8, r10, r13, r8.getCurState(), "timeout");
        AoiBoard.Confidence r14 = r10.retryLimitedConfidence;
        if (r14 != null) goto L15;
        AoiBoard.Confidence r15 = r13;
    L16:
        AoiBoard.ConfidenceSource r16 = resolveConfidenceSource(r13, r15, r10.retryLimitedConfidence);
        if (r8.getConfidence() == r15) goto L19;
    L20:
        r8.setConfidence(r15);
        r8.setConfidenceSource(r16);
        CommSenseLog.dWithMethodName(TAG, "[" + this.mUserId + "] timeout retry update, poiId=" + r12 + ", confidence=" + r15 + ", confidenceSource=" + formatConfidenceSource(r16) + ", saved=" + localAoiBoardManager().updateAoiBoard(r8));
    L21:
        scheduleLocationTask("timeout_retry", r8, resolveLocationRequestIntervalMs(r8.getConfidence()));
        return;
    L19:
        if (r8.getConfidenceSource() == r16) goto L21;
    L15:
        r15 = pickLessAggressiveConfidence(r13, r14);
        goto L16
    }

    private void handleStepsCounterChanged(int r8) {
        if (this.mLatestSteps != r8) goto L5;
        return;
    L5:
        this.mLatestSteps = r8;
        maybeRequestFreshLocation("steps");
    }

    public static boolean hasBoundAoiBoard(Context r8, int r10, StarGeofence r11) {
        if (r11 != null) goto L5;
        return false;
    L5:
        String r12 = r11.getPoiId();
        if (r12 != null) goto L8;
    L31:
        return false;
    L8:
        if (r12.isEmpty() == true) goto L31;
        if (r10 != (-1)) goto L13;
        r10 = 0;
    L13:
        Iterator<String> r13 = AoiBoardBindingUtil.parsePoiIds(r12).iterator();
    L15:
        if (r13.hasNext() == false) goto L31;
        String r14 = r13.next();
        AoiBoard r15 = getInstance(r8, r10).queryAoiBoardByPoiId(r14);
        if (r15 != null) goto L19;
    L23:
        if (r10 == 0) goto L15;
        AoiBoard r16 = getInstance(r8, 0).queryAoiBoardByPoiId(r14);
        if (r16 == null) goto L15;
        if (r16.isBoundTo(r11) == false) goto L15;
        if (r16.getAoiBoard().isEmpty() == true) goto L15;
        return true;
    L19:
        if (r15.isBoundTo(r11) == false) goto L23;
        if (r15.getAoiBoard().isEmpty() == true) goto L23;
        return true;
    }

    private boolean hasValidAoiBoardGeometry(AoiBoard r8) {
        if (r8 != null) goto L4;
    L8:
        return false;
    L4:
        if (r8.getPoiId().isEmpty() == true) goto L8;
        if (r8.getAoiBoard().isEmpty() == true) goto L8;
        return true;
    }

    public static /* synthetic */ void i(StarAoiBoardManager r8, IBinder r10) {
        r8.lambda$registerAoiBoardCallback$0(r10);
    }

    private File initPoiLogFile() {
        if (this.mUserId != 0) goto L5;
        String r8 = STR_POI_FILE_NAME;
    L6:
        File r10 = new File(LocationUtil.getInstance().getStarDir(this.mAppContext), r8);
        r10.delete();
        r10.createNewFile();     // Catch: IOException -> L9
    L11:
        CommSenseLog.d(TAG, "initPoiLogFile, file: " + r10);
        CommSenseLog.recordFileWithKey(CommSenseLog.KEY_FILE_POI, this.mUserId, r10);
        return r10;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "initPoiLogFile failed", e);
        goto L11
    L5:
        r8 = android.aimedia.a.h(new StringBuilder("star_poi_"), this.mUserId, ".txt");
        goto L6
    }

    private boolean isAoiBoardGeofence(StarGeofence r8) {
        if (r8 != null) goto L4;
        return false;
    L4:
        if (r8.getGeofenceId() != null) goto L7;
        return false;
    L7:
        return isManagedAoiGeofenceId(r8.getGeofenceId());
    }

    private boolean isCacheEntryValid(CacheEntry r8) {
        if (r8 != null) goto L4;
    L8:
        return false;
    L4:
        if (this.mCacheTtlMs > 0) goto L6;
    L7:
        return true;
    L6:
        if ((System.currentTimeMillis() - r8.updatedAtMs) > this.mCacheTtlMs) goto L8;
        goto L7
    }

    private boolean isManagedAoiGeofenceId(String r8) {
        if (r8 != null) goto L4;
    L8:
        return false;
    L4:
        if (r8.startsWith(GEOFENCE_PREFIX_AOI_BOARD) == false) goto L6;
    L7:
        return true;
    L6:
        if (r8.startsWith(GEOFENCE_PREFIX_MALL) == false) goto L8;
        goto L7
    }

    private static boolean isSameAoiBoardSnapshot(AoiBoard r8, AoiBoard r10) {
        if (r8.getPoiId().equals(r10.getPoiId()) == true) goto L5;
    L25:
        return false;
    L5:
        if (r8.getPoiName().equals(r10.getPoiName()) == false) goto L25;
        if (r8.getAoiBoard().equals(r10.getAoiBoard()) == false) goto L25;
        if (r8.getCurState() != r10.getCurState()) goto L25;
        if (r8.getTransitionType() != r10.getTransitionType()) goto L25;
        if (r8.getConfidence() != r10.getConfidence()) goto L25;
        if (r8.getConfidenceSource() != r10.getConfidenceSource()) goto L25;
        if (r8.getEvent() != r10.getEvent()) goto L25;
        if (r8.getEventTime() != r10.getEventTime()) goto L25;
        if (r8.getGeofenceId().equals(r10.getGeofenceId()) == false) goto L25;
        if (r8.getType() != r10.getType()) goto L25;
        return true;
    }

    public static boolean isSupportedTrafficAoiBoardType(AoiBoard.Type r8) {
        if (r8 != AoiBoard.Type.AIRPORT) goto L5;
    L10:
        return true;
    L5:
        if (r8 == AoiBoard.Type.TRAIN_STATION) goto L10;
        if (r8 == AoiBoard.Type.SUBWAY_STATION) goto L10;
        return false;
    }

    private boolean isTrafficPresetGeofence(StarGeofence r8) {
        if (resolveTrafficPresetAoiBoardType(r8) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ AoiCalculationState j(String r8) {
        return lambda$markActiveLocationRequested$8(r8);
    }

    public static /* synthetic */ AoiCalculationState k(String r8) {
        return lambda$maybeCalculateAoiBoardEvent$5(r8);
    }

    public static /* synthetic */ Set l(Integer r8) {
        return lambda$registerAoiBoardCallback$1(r8);
    }

    private static /* synthetic */ List lambda$buildAoiBoardsMapByGeofenceId$6(String r8) {
        return new ArrayList();
    }

    private static /* synthetic */ String lambda$dump$7(boolean r8, String r10) {
        if (r8 == true) goto L4;
        return r10;
    L4:
        return CommSenseLog.decryptCaeLog(r10);
    }

    private /* synthetic */ void lambda$executeLocationTask$10(long r8, AoiBoard r10) {
        onLocationTaskTimeout(r8, r10.getPoiId());
    }

    private /* synthetic */ void lambda$handleAoiGeofencePruneByLocation$3(Location r8) {
        pruneFarAwayAoiGeofencesByLocation(r8);
    }

    private /* synthetic */ void lambda$handleGeofenceInfoChanged$4(StarGeofence r8, Location r10) {
        processBoundAoiBoardsOnGeofenceChanged(r8, r10);
    }

    private /* synthetic */ void lambda$handleLocationChanged$2(Location r8) {
        processAoiBoardsOnLocationChanged(r8);
    }

    private static /* synthetic */ AoiCalculationState lambda$handleLocationTaskTimeoutRetry$11(String r8) {
        return new AoiCalculationState(null);
    }

    private static /* synthetic */ AoiCalculationState lambda$markActiveLocationRequested$8(String r8) {
        return new AoiCalculationState(null);
    }

    private static /* synthetic */ AoiCalculationState lambda$maybeCalculateAoiBoardEvent$5(String r8) {
        return new AoiCalculationState(null);
    }

    private /* synthetic */ void lambda$registerAoiBoardCallback$0(IBinder r8) {
        removeCallbackByBinder(r8);
    }

    private static /* synthetic */ Set lambda$registerAoiBoardCallback$1(Integer r8) {
        return ConcurrentHashMap.newKeySet();
    }

    private /* synthetic */ void lambda$scheduleLocationTask$9(long r8, String r10, AoiBoard r11) {
        executeLocationTask(r8, r10, copyAoiBoard(r11));
    }

    private List<StarGeofence> listAoiBoardGeofences() {
        List<StarGeofence> r8 = dbManager(this.mUserId).queryGeofencesByUserIdAndType(this.mUserId, null);     // Catch: Throwable -> L10
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L10
        Iterator<StarGeofence> r11 = r8.iterator();     // Catch: Throwable -> L10
    L4:
        if (r11.hasNext() == false) goto L9;
        StarGeofence r12 = r11.next();     // Catch: Throwable -> L10
        if (isAoiBoardGeofence(r12) == false) goto L4;
        r10.add(r12);     // Catch: Throwable -> L10
        goto L4
    L9:
        return r10;
    L10:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "list aoi geofences failed userId=" + this.mUserId, th);
        return Collections.emptyList();
    }

    private List<AoiBoard> listOwnedAoiBoardsBoundToGeofence(StarGeofence r8) {
        Set<String> r10 = AoiBoardBindingUtil.parsePoiIds(r8.getPoiId());
        if (r10.isEmpty() == true) goto L5;
        ArrayList r11 = new ArrayList(r10.size());
        Iterator<String> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L17;
        String r13 = r12.next();
        AoiBoard r14 = localAoiBoardManager().queryAoiBoardByPoiId(r13);
        if (r14 == null) goto L8;
        if (r14.getAoiBoard().isEmpty() == true) goto L8;
        if (r14.isBoundTo(r8) == false) goto L8;
        r11.add(r14);
        goto L8
    L17:
        return r11;
    L5:
        return Collections.emptyList();
    }

    private List<AoiBoard> listOwnedAoiBoardsForComputation() {
        return localAoiBoardManager().queryAllAoiBoards();
    }

    private List<AoiBoard> listTrafficAoiBoards() {
        return localAoiBoardManager().queryAoiBoardsByTypes(getTrafficAoiBoardTypes());
    }

    private List<AoiBoard> listVisibleAoiBoards() {
        if (this.mUserId == 0) goto L5;
        LinkedHashMap r8 = new LinkedHashMap();
        mergeAoiBoards(r8, systemAoiBoardManager().queryAllAoiBoards());
        mergeAoiBoards(r8, localAoiBoardManager().queryAllAoiBoards());
        return new ArrayList(r8.values());
    L5:
        return localAoiBoardManager().queryAllAoiBoards();
    }

    private List<AoiBoard> listVisibleAoiBoardsByType(int r8) {
        List<AoiBoard> r10 = listVisibleAoiBoards();
        ArrayList r11 = new ArrayList();
        Iterator<AoiBoard> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        AoiBoard r13 = r12.next();
        if (r13 == null) goto L4;
        if (r13.getType().ordinal() != r8) goto L4;
        r11.add(r13);
        goto L4
    L10:
        return r11;
    }

    private StarAoiBoardManager localAoiBoardManager() {
        return this;
    }

    private void markActiveLocationRequested(List<AoiBoard> r8) {
        Iterator<AoiBoard> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L16;
        AoiBoard r11 = r10.next();
        if (r11 == null) goto L4;
        if (r11.getPoiId().isEmpty() == true) goto L4;
        if (r11.getAoiBoard().isEmpty() == true) goto L4;
        if (r11.getConfidence() == AoiBoard.Confidence.MIN) goto L4;
        AoiCalculationState r12 = this.mAoiCalculationStateMap.computeIfAbsent(r11.getPoiId(), new com.obric.cae.BWDL.BwdlDrop.a(4));
        r12.pendingActiveRequestCount++;
        r12.lastResolvedState = r11.getCurState();
        goto L4
    }

    private AoiCalculationResult maybeCalculateAoiBoardEvent(AoiBoard r22, Location r23, long r24) {
        AoiCalculationState r8 = this.mAoiCalculationStateMap.computeIfAbsent(r22.getPoiId(), new com.obric.cae.BWDL.BwdlDrop.a(3));
        boolean r10 = AoiBoardUtil.isInAoiBoard(r22.getAoiBoard(), r23.getLatitude(), r23.getLongitude());
        float r15 = AoiBoardUtil.calculateShortestDistanceToAoiBoard(r22.getAoiBoard(), r23.getLatitude(), r23.getLongitude());
        if (r10 == false) goto L5;
        AoiBoard.State r11 = AoiBoard.State.INSIDE;
    L6:
        AoiBoard.State r14 = r11;
        AoiBoard.Event r13 = resolveAoiBoardEvent(r22, r14);
        AoiBoard.State r12 = r22.getCurState();
        AoiBoard.Event r16 = r22.getEvent();
        AoiBoard.Confidence r17 = r22.getConfidence();
        AoiBoard.ConfidenceSource r18 = r22.getConfidenceSource();
        AoiBoard.Confidence r19 = resolveConfidenceByDistance(r15);
        if (r12 == r14) goto L9;
        boolean r110 = true;
    L10:
        ConfidenceResult r20 = resolveEffectiveConfidence(r22, r8, r19, r14, r110);
        r22.setConfidence(r20.confidence);
        r22.setConfidenceSource(r20.source);
        applyAoiBoardState(r22, r14, r13);
        r8.record(r23, r24, this.mLatestSteps, this.mLatestHarStatus, r15, r14, r19, r20.confidence, r20.source);
        if (r12 == r22.getCurState()) goto L13;
    L20:
        CommSenseLog.encryptedD(TAG, CommSenseLog.LOG_TAG, "[" + this.mUserId + "] update aoiBoard=" + r22.getPoiId() + ", baselineConfidence=" + r19 + ", confidence=" + r20.confidence + ", confidenceSource=" + formatConfidenceSource(r20.source) + ", distanceMeters=" + r15 + ", lat=" + r23.getLatitude() + ", lon=" + r23.getLongitude(), CommSenseLog.LOG_TAG);
        if (r13 == AoiBoard.Event.UNKNOWN) goto L23;
        boolean r21 = true;
        boolean r25 = true;
    L25:
        return new AoiCalculationResult(r21, r25, r15);
    L23:
        r25 = false;
        r21 = true;
        goto L25
    L13:
        if (r16 != r22.getEvent()) goto L20;
        if (r17 != r22.getConfidence()) goto L20;
        if (r18 != r22.getConfidenceSource()) goto L20;
        return new AoiCalculationResult(false, false, r15);
    L9:
        r110 = false;
        goto L10
    L5:
        r11 = AoiBoard.State.OUTSIDE;
        goto L6
    }

    private void maybeDegradeConfidenceForRetry(AoiBoard r8, AoiCalculationState r10, AoiBoard.Confidence r11, AoiBoard.State r12, String r13) {
        if (r10.pendingActiveRequestCount >= 2) goto L5;
        return;
    L5:
        AoiBoard.Confidence r14 = r10.retryLimitedConfidence;
        if (r14 == null) goto L9;
        r11 = r14;
    L9:
        AoiBoard.Confidence r15 = downgradeConfidence(r11);
        r10.retryLimitedConfidence = r15;
        r10.pendingActiveRequestCount = 0;
        if (r11 == r15) goto L13;
        CommSenseLog.dWithMethodName(TAG, "[" + this.mUserId + "] downgrade confidence , source=" + r13 + ", poiId=" + r8.getPoiId() + ", from=" + r11 + ", to=" + r15 + ", confidenceSource=" + formatConfidenceSource(AoiBoard.ConfidenceSource.RETRY) + ", curState=" + r12 + ", retryLimit=2");
        return;
    }

    private void maybeLogNearestAoi(String r8, AoiBoard r10, float r11) {
        Object r12 = this.mLocationTaskLock;
        monitor-enter(r12);
        boolean r13 = r10.getPoiId().equals(this.mLastNearestAoiPoiId);     // Catch: Throwable -> L21
        boolean r14 = true;
        if (r10.getConfidence() != this.mLastNearestAoiConfidence) goto L7;
        boolean r15 = true;
    L9:
        if (Math.abs(r11 - this.mLastNearestAoiDistanceMeters) < NEAREST_AOI_LOG_DISTANCE_DELTA_METERS) goto L12;
        r14 = false;
    L12:
        if (r13 == false) goto L17;
        if (r15 == false) goto L17;
        if (r14 == false) goto L17;
        monitor-exit(r12);     // Catch: Throwable -> L21
        return;
    L17:
        this.mLastNearestAoiPoiId = r10.getPoiId();     // Catch: Throwable -> L21
        this.mLastNearestAoiConfidence = r10.getConfidence();     // Catch: Throwable -> L21
        this.mLastNearestAoiDistanceMeters = r11;     // Catch: Throwable -> L21
        monitor-exit(r12);     // Catch: Throwable -> L21
        CommSenseLog.vWithMethodName(TAG, "[" + this.mUserId + "] reason= " + r8 + ", poiId=" + r10.getPoiId() + ", confidence=" + r10.getConfidence() + ", confidenceSource=" + formatConfidenceSource(r10) + ", distanceMeters=" + r11);
        return;
    L7:
        r15 = false;
    L21:
        th = move-exception;
        throw th;
    }

    private void maybeRequestAoiGeofenceCoverage(List<AoiBoard> r8) {
        AoiBoard r10 = selectAoiBoardForGeofenceCoverage(r8);
        if (r10 != null) goto L5;
        return;
    L5:
        scheduleLocationTask("aoi_geofence_cover", r10, MAX_CONFIDENCE_LOCATION_REQUEST_INTERVAL_MS);
    }

    private void maybeRequestFreshLocation(String r8) {
        List<AoiBoard> r10 = listOwnedAoiBoardsForComputation();
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        AoiBoard r11 = selectControllingAoiBoard(r10);
        if (r11 != null) goto L9;
        CommSenseLog.dWithMethodName(TAG, "skip location request: reason=" + r8 + ", no controlling aoi");
        dumpPoiLog("skip location request userId=" + this.mUserId + ", reason=" + r8 + ", no controlling aoi");
        return;
    L9:
        scheduleLocationTask(r8, r11, resolveLocationRequestIntervalMs(r11.getConfidence()));
    }

    private void mergeAoiBoards(Map<String, AoiBoard> r8, List<AoiBoard> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L23;
        Iterator<AoiBoard> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L24;
        AoiBoard r12 = r11.next();
        if (r12 == null) goto L8;
        if (r12.getPoiId().isEmpty() == true) goto L8;
        r8.put(r12.getPoiId(), r12);
        goto L8
    L24:
        return;
    }

    private static List<AoiBoard> normalizeAoiBoards(List<AoiBoard> r8) {
        if (r8 == null) goto L18;
        if (r8.isEmpty() == true) goto L18;
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<AoiBoard> r11 = r8.iterator();
    L8:
        if (r11.hasNext() == false) goto L16;
        AoiBoard r12 = r11.next();
        if (r12 == null) goto L8;
        if (r12.getPoiId().isEmpty() == true) goto L8;
        r10.put(r12.getPoiId(), copyAoiBoard(r12));
        goto L8
    L16:
        return new ArrayList(r10.values());
    L18:
        return Collections.emptyList();
    }

    private List<AoiBoard> normalizeAoiBoardsPreservingRuntimeState(List<AoiBoard> r8) {
        List<AoiBoard> r10 = normalizeAoiBoards(r8);
        Iterator<AoiBoard> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        AoiBoard r12 = r11.next();
        AoiBoard r13 = this.mStore.queryAoiBoardByPoiId(r12.getPoiId());
        if (r13 == null) goto L4;
        preserveRuntimeState(r12, r13);
        goto L4
    L8:
        return r10;
    }

    public static void notifyAoiBoardEventToAllUsers(Context r8, AoiBoard r10, Location r11) {
        Iterator<StarAoiBoardManager> r12 = snapshotInstances().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().notifyAoiBoardEvent(r10, r11);
        goto L4
    }

    private void onLocationTaskTimeout(long r8, String r10) {
        Object r11 = this.mLocationTaskLock;
        monitor-enter(r11);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r8 == this.mLocationTaskToken) goto L7;
    L13:
        monitor-exit(r11);     // Catch: Throwable -> L15
        return;
    L7:
        if (this.mLocationTaskInFlight == false) goto L13;
        this.mLocationTaskInFlight = false;     // Catch: Throwable -> L15
        this.mLocationTaskTimeout = null;     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        CommSenseLog.dWithMethodName(TAG, "[" + this.mUserId + "] location task timeout, poiId=" + r10 + ", timeoutMs=20000");
        handleLocationTaskTimeoutRetry(r10);
    }

    private String parseManagedAoiGeofencePoiId(String r8) {
        if (r8.startsWith(GEOFENCE_PREFIX_AOI_BOARD) == false) goto L8;
        int r10 = 10;
    L6:
        return r8.substring(r10);
    L8:
        if (r8.startsWith(GEOFENCE_PREFIX_MALL) == false) goto L10;
        r10 = 5;
        goto L6
    L10:
        return null;
    }

    private boolean persistAoiGeofenceBinding(AoiBoard r8, String r10, String r11) {
        if (r10.equals(r8.getGeofenceId()) == false) goto L6;
        return true;
    L6:
        boolean r12 = localAoiBoardManager().updateAoiBoardGeofenceId(r8.getPoiId(), r10);
        if (r12 == false) goto L9;
        r8.setGeofenceId(r10);
    L9:
        CommSenseLog.dWithMethodName(TAG, "persist aoi geofence binding poiId=" + r8.getPoiId() + ", geofenceId=" + r10 + ", reason=" + r11 + ", updated=" + r12);
        return r12;
    }

    private int persistAoiGeofenceBindings(List<AoiBoard> r8, String r10, String r11) {
        Iterator<AoiBoard> r12 = r8.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L13;
        AoiBoard r14 = r12.next();
        if (r14 == null) goto L4;
        if (r14.getPoiId().isEmpty() == true) goto L4;
        deleteObsoleteAoiGeofenceIfNeeded(r14, r10);
        if (persistAoiGeofenceBinding(r14, r10, r11) == false) goto L4;
        r13 = r13 + 1;
        goto L4
    L13:
        return r13;
    }

    private boolean persistTrafficGeofenceBinding(AoiBoard r8, String r10, String r11) {
        if (r10.equals(r8.getGeofenceId()) == false) goto L6;
        return true;
    L6:
        boolean r12 = localAoiBoardManager().updateAoiBoardGeofenceId(r8.getPoiId(), r10);
        if (r12 == false) goto L9;
        r8.setGeofenceId(r10);
    L9:
        CommSenseLog.dWithMethodName(TAG, "persist traffic geofence binding poiId=" + r8.getPoiId() + ", geofenceId=" + r10 + ", reason=" + r11 + ", updated=" + r12);
        return r12;
    }

    private AoiBoard.Confidence pickLessAggressiveConfidence(AoiBoard.Confidence r8, AoiBoard.Confidence r10) {
        if (r8.ordinal() > r10.ordinal()) goto L6;
        return r8;
    L6:
        return r10;
    }

    private synchronized void preloadAoiBoardsFromDbOnInit() {
        monitor-enter(this);
        this.mRecoveryFinished.set(false);     // Catch: Throwable -> L27
        List<AoiBoard> r8 = this.mStore.queryAllAoiBoards();     // Catch: Throwable -> L17 RuntimeException -> L19
        rebuildCacheLocked(r8);     // Catch: Throwable -> L17 RuntimeException -> L19
        dumpPoiLog("init preload aoi boards userId=" + this.mUserId + ", count=" + r8.size() + ", cacheSize=" + this.mAoiBoardCache.size());     // Catch: Throwable -> L17 RuntimeException -> L19
        Iterator<AoiBoard> r10 = r8.iterator();     // Catch: Throwable -> L17 RuntimeException -> L19
    L8:
        if (r10.hasNext() == false) goto L13;
        AoiBoard r11 = r10.next();     // Catch: Throwable -> L17 RuntimeException -> L19
        if (r11 == null) goto L8;
        dumpPoiLog("[" + this.mUserId + "] recover " + r11);     // Catch: Throwable -> L17 RuntimeException -> L19
        goto L8
    L13:
        this.mAoiBoardsRecovered = true;     // Catch: Throwable -> L17 RuntimeException -> L19
        this.mRecoveryFinished.set(true);     // Catch: Throwable -> L27
        String r12 = "init preload aoi boards finished userId=" + this.mUserId + ", cacheSize=" + this.mAoiBoardCache.size();     // Catch: Throwable -> L27
    L15:
        dumpPoiLog(r12);     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L19:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);     // Catch: Throwable -> L17
        this.mRecoveryFinished.set(true);     // Catch: Throwable -> L27
        r12 = "init preload aoi boards finished userId=" + this.mUserId + ", cacheSize=" + this.mAoiBoardCache.size();     // Catch: Throwable -> L27
        goto L15
    L17:
        th = move-exception;
        this.mRecoveryFinished.set(true);     // Catch: Throwable -> L27
        dumpPoiLog("init preload aoi boards finished userId=" + this.mUserId + ", cacheSize=" + this.mAoiBoardCache.size());     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    private static void preserveRuntimeState(AoiBoard r8, AoiBoard r10) {
        r8.setCurState(r10.getCurState());
        r8.setConfidence(r10.getConfidence());
        r8.setConfidenceSource(r10.getConfidenceSource());
        r8.setEvent(r10.getEvent());
        r8.setEventTime(r10.getEventTime());
        r8.setGeofenceId(r10.getGeofenceId());
    }

    private static void preserveRuntimeStateFromMap(List<AoiBoard> r8, Map<String, AoiBoard> r10) {
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L19;
        Iterator<AoiBoard> r11 = r8.iterator();
    L9:
        if (r11.hasNext() == false) goto L20;
        AoiBoard r12 = r11.next();
        AoiBoard r13 = r10.get(r12.getPoiId());
        if (r13 == null) goto L9;
        preserveRuntimeState(r12, r13);
        goto L9
    L20:
        return;
    }

    private void processAoiBoardsOnLocationChanged(Location r8) {
        List<AoiBoard> r10 = listOwnedAoiBoardsForComputation();
        if (r10.isEmpty() == false) goto L6;
        this.mAoiCalculationStateMap.clear();
        finishLocationTaskIfNeeded("empty");
        return;
    L6:
        pruneMissingAoiStates(r10);
        AoiCalculationBatchResult r11 = calculateAoiBoardsByLocation(r10, r8, true);
        if (r11.computedAoiBoards.isEmpty() == false) goto L10;
        finishLocationTaskIfNeeded("no-computed");
        return;
    L10:
        boolean r12 = localAoiBoardManager().updateAoiBoards(r11.computedAoiBoards);
        if (r12 == true) goto L14;
        CommSenseLog.eWithMethodName(TAG, "update aoi boards failed userId=" + this.mUserId + ", count=" + r11.computedAoiBoards.size());
        finishLocationTaskIfNeeded("save-failed");
        return;
    L14:
        Iterator<AoiDispatchRecord> r13 = r11.dispatchRecords.iterator();
    L16:
        if (r13.hasNext() == false) goto L18;
        AoiDispatchRecord r14 = r13.next();
        dispatchAoiBoardEvent(r14.aoiBoard, r14.location);
        goto L16
    L18:
        ensureNearbyAoiGeofenceCoverage(r8, r11.nearbyAoiBoardRecords);
        if (r11.updatedAoiBoards.isEmpty() == true) goto L21;
        dumpPoiLog("[" + this.mUserId + "] location processed (" + r8.getLatitude() + ", " + r8.getLongitude() + "), computed=" + r11.computedAoiBoards.size() + ", changed=" + r11.updatedAoiBoards.size() + ", dispatch=" + r11.dispatchRecords.size() + ", saved=" + r12);
    L21:
        scheduleLocationTaskFromNearestAoi("aoi_update", r11.nearestAoiBoard, r11.shortestDistanceMeters);
    }

    private void processBoundAoiBoardsOnGeofenceChanged(StarGeofence r8, Location r10) {
        List<AoiBoard> r11 = listOwnedAoiBoardsBoundToGeofence(r8);
        if (r11.isEmpty() == false) goto L5;
        return;
    L5:
        AoiCalculationBatchResult r12 = calculateAoiBoardsByLocation(r11, r10, false);
        if (r12.computedAoiBoards.isEmpty() == false) goto L9;
        return;
    L9:
        if (saveCalculatedAoiBoards(r12.computedAoiBoards, "geofence_breach") == true) goto L12;
        CommSenseLog.eWithMethodName(TAG, "save geofence breach aoi boards failed userId=" + this.mUserId + ", geofenceId=" + r8.getGeofenceId() + ", count=" + r12.computedAoiBoards.size());
        return;
    L12:
        Iterator<AoiDispatchRecord> r13 = r12.dispatchRecords.iterator();
    L14:
        if (r13.hasNext() == false) goto L16;
        AoiDispatchRecord r14 = r13.next();
        dispatchAoiBoardEvent(r14.aoiBoard, r14.location);
        goto L14
    L16:
        dumpPoiLog("[" + this.mUserId + "] geofence breach calculate aoi boards, geofenceId=" + r8.getGeofenceId() + ", geoState=" + r8.getGeoState() + ", boundCount=" + r11.size() + ", computed=" + r12.computedAoiBoards.size() + ", changed=" + r12.updatedAoiBoards.size() + ", dispatch=" + r12.dispatchRecords.size() + ", lat=" + r10.getLatitude() + ", lon=" + r10.getLongitude());
    }

    private void pruneFarAwayAoiGeofencesByLocation(Location r10) {
        List<StarGeofence> r8 = listAoiBoardGeofences();
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        List<AoiBoard> r11 = localAoiBoardManager().queryAllAoiBoards();
        Map<String, AoiBoard> r12 = buildAoiBoardMapByPoiId(r11);
        Map<String, List<AoiBoard>> r13 = buildAoiBoardsMapByGeofenceId(r11);
        Iterator<StarGeofence> r14 = r8.iterator();
        int r15 = 0;
    L7:
        if (r14.hasNext() == false) goto L17;
        StarGeofence r16 = r14.next();
        if (isAoiBoardGeofence(r16) == false) goto L7;
        String r17 = r16.getGeofenceId();
        AoiGeofenceDistanceResult r18 = resolveAoiGeofenceDistance(r16, r10, r12, r13);
        if (r18.hasNearbyAoiBoard == true) goto L7;
        if (deleteGeofenceById(this.mUserId, r17, "far_aoi") == false) goto L7;
        r15 = r15 + 1;
        clearAoiGeofenceBindingsIfMatch(r18.boundAoiBoards, r17, "far_away");
        StringBuilder r19 = defpackage.b.h("remove far aoi geofence id=", r17, ", poiIds=");
        r19.append(r16.getPoiId());
        r19.append(", nearestDistanceMeters=");
        r19.append(r18.nearestDistanceMeters);
        r19.append(", activeDistanceMeters=5000.0, boundCount=");
        r19.append(r18.boundAoiBoards.size());
        CommSenseLog.dWithMethodName(TAG, r19.toString());
        goto L7
    L17:
        if (r15 <= 0) goto L29;
        dumpPoiLog("[" + this.mUserId + "] remove far aoi geofences, count=" + r15 + ", activeDistanceMeters=5000.0");
        return;
    }

    private void pruneMissingAoiStates(List<AoiBoard> r8) {
        HashSet r10 = new HashSet();
        Iterator<AoiBoard> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        AoiBoard r12 = r11.next();
        if (r12 == null) goto L4;
        if (r12.getPoiId().isEmpty() == true) goto L4;
        r10.add(r12.getPoiId());
        goto L4
    L10:
        Iterator r13 = new ArrayList(this.mAoiCalculationStateMap.keySet()).iterator();
    L12:
        if (r13.hasNext() == false) goto L16;
        String r14 = (String) r13.next();
        if (r10.contains(r14) == true) goto L12;
        this.mAoiCalculationStateMap.remove(r14);
        goto L12
    }

    public static String queryBoundAoiBoardString(Context r8, StarGeofence r10, boolean r11) {
        String r12 = r10.getPoiId();
        if (r12 != null) goto L5;
        return "null";
    L5:
        if (r12.isEmpty() == true) goto L35;
        int r13 = StarGeofenceManager.findUserIdByGeofence(r8, r10.getGeofenceId());
        if (r13 != (-1)) goto L10;
        r13 = 0;
    L10:
        StringBuilder r14 = new StringBuilder();
        Iterator<String> r15 = AoiBoardBindingUtil.parsePoiIds(r12).iterator();
    L12:
        if (r15.hasNext() == false) goto L25;
        String r16 = r15.next();
        AoiBoard r17 = getInstance(r8, r13).queryAoiBoardByPoiId(r16);
        if (r17 != null) goto L18;
        if (r11 == false) goto L18;
        if (r13 == 0) goto L18;
        r17 = getInstance(r8, 0).queryAoiBoardByPoiId(r16);
    L18:
        if (r17 == null) goto L12;
        if (r14.length() <= 0) goto L23;
        r14.append(";");
    L23:
        r14.append(r17);
        goto L12
    L25:
        if (r14.length() != 0) goto L28;
        return "null";
    L28:
        return r14.toString();
    L35:
        return "null";
    }

    private void rebuildCacheLocked(List<AoiBoard> r8) {
        this.mAoiBoardCache.clear();
        cacheAoiBoardsLocked(r8);
    }

    private void reconcileSingleTrafficAoiBoard(Location r8, AoiBoard r10, Map<String, StarGeofence> r11) {
        float r12 = AoiBoardUtil.calculateShortestDistanceToAoiBoard(r10.getAoiBoard(), r8.getLatitude(), r8.getLongitude());
        StarGeofence r13 = r11.remove(r10.getPoiId());
        if (r12 > AOI_GEOFENCE_ACTIVE_DISTANCE_METERS) goto L6;
        ensureNearbyTrafficGeofence(r10, r13, r12);
        return;
    L6:
        if (r13 != null) goto L8;
        return;
    L8:
        if (deleteTrafficGeofence(r13) == false) goto L12;
        clearAoiGeofenceBindingIfMatch(r10, r13.getGeofenceId(), "traffic_far_away");
        CommSenseLog.dWithMethodName(TAG, "remove far traffic geofence poiId=" + r10.getPoiId() + ", geofenceId=" + r13.getGeofenceId() + ", distanceMeters=" + r12);
        return;
    }

    private void removeCachedAoiBoardsByTypeLocked(AoiBoard.Type r8) {
        ArrayList r10 = new ArrayList();
        Iterator<Map.Entry<String, CacheEntry>> r11 = this.mAoiBoardCache.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Map.Entry<String, CacheEntry> r12 = r11.next();
        CacheEntry r13 = r12.getValue();
        if (r13 == null) goto L4;
        if (r13.aoiBoard.getType() != r8) goto L4;
        r10.add(r12.getKey());
        goto L4
    L10:
        Iterator r14 = r10.iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        String r15 = (String) r14.next();
        this.mAoiBoardCache.remove(r15);
        goto L12
    }

    private void removeCallback(IBinder r8, IStarAoiBoardCallback r10) {
        if (this.mCallbackMap.remove(r8, r10) == false) goto L6;
        removeCallbackByBinder(r8);
        return;
    }

    private boolean removeCallbackByBinder(IBinder r8) {
        IStarAoiBoardCallback r10 = this.mCallbackMap.remove(r8);
        Integer r11 = this.mCallbackUidMap.remove(r8);
        if (r11 == null) goto L9;
        Set<IBinder> r12 = this.mUidCallbackBinderMap.get(r11);
        if (r12 == null) goto L9;
        r12.remove(r8);
        if (r12.isEmpty() == false) goto L9;
        this.mUidCallbackBinderMap.remove(r11, r12);
    L9:
        unlinkCallbackDeathRecipient(r8);
        if (r10 == null) goto L12;
        return true;
    L12:
        return false;
    }

    public static void removeFarAwayAoiGeofencesByFreshLocation(Context r8, Location r10) {
        getInstance(r8, 0);
        List<StarAoiBoardManager> r11 = snapshotInstances();
        if (r11.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<StarAoiBoardManager> r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r12.next().handleAoiGeofencePruneByLocation(r10);
        goto L7
    L9:
        CommSenseLog.dWithMethodName(TAG, "fresh location dispatched to prune aoi geofences, count=" + r11.size());
    }

    private void removeStaleTrafficGeofences(Map<String, StarGeofence> r8, List<AoiBoard> r10) {
        Iterator<StarGeofence> r11 = r8.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        StarGeofence r12 = r11.next();
        if (deleteTrafficGeofence(r12) == false) goto L4;
        clearTrafficGeofenceBindingsById(r12.getGeofenceId(), "traffic_stale", r10);
        goto L4
    }

    private AoiBoard.Event resolveAoiBoardEvent(AoiBoard r8, AoiBoard.State r10) {
        if (r8.getCurState() != r10) goto L7;
        return AoiBoard.Event.UNKNOWN;
    L7:
        if (r10 != AoiBoard.State.INSIDE) goto L11;
        return AoiBoard.Event.ENTER;
    L11:
        if (r10 != AoiBoard.State.OUTSIDE) goto L15;
        return AoiBoard.Event.EXIT;
    L15:
        return AoiBoard.Event.UNKNOWN;
    }

    private StarGeofence.GeoType resolveAoiBoardGeoType(AoiBoard.Type r8) {
        if (r8 != AoiBoard.Type.MALL) goto L7;
        return StarGeofence.GeoType.MALL;
    L7:
        return StarGeofence.GeoType.UNKNOWN;
    }

    private String resolveAoiBoardGeofenceId(AoiBoard r8) {
        if (r8.getType() != AoiBoard.Type.MALL) goto L7;
        return buildAoiBoardGeofenceId(r8);
    L7:
        if (r8.getGeofenceId().isEmpty() == true) goto L11;
        return r8.getGeofenceId();
    L11:
        return buildAoiBoardGeofenceId(r8);
    }

    private static AoiBoard.TransitionType resolveAoiBoardTransitionType(StarGeofence.GeoTransitionType r8) {
        return AoiBoard.TransitionType.values()[r8.ordinal()];
    L5:
        return AoiBoard.TransitionType.UNKNOWN;
    }

    private static AoiBoard.Type resolveAoiBoardType(StarGeofence.GeoType r8) {
        return AoiBoard.Type.valueOf(r8.name());
    L5:
        return AoiBoard.Type.UNKNOWN;
    }

    private AoiGeofenceDistanceResult resolveAoiGeofenceDistance(StarGeofence r8, Location r10, Map<String, AoiBoard> r11, Map<String, List<AoiBoard>> r12) {
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator<String> r14 = AoiBoardBindingUtil.parsePoiIds(r8.getPoiId()).iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        AoiBoard r15 = r11.get(r14.next());
        if (r15 == null) goto L4;
        r13.put(r15.getPoiId(), r15);
        goto L4
    L8:
        String r16 = r8.getGeofenceId();
        if (r16 == null) goto L26;
        List<AoiBoard> r17 = r12.get(r16);
        if (r17 == null) goto L20;
        Iterator<AoiBoard> r18 = r17.iterator();
    L14:
        if (r18.hasNext() == false) goto L20;
        AoiBoard r19 = r18.next();
        if (r19 == null) goto L14;
        if (r19.getPoiId().isEmpty() == true) goto L14;
        r13.put(r19.getPoiId(), r19);
    L20:
        String r20 = parseManagedAoiGeofencePoiId(r16);
        if (r13.isEmpty() == false) goto L26;
        if (r20 == null) goto L26;
        AoiBoard r21 = r11.get(r20);
        if (r21 == null) goto L26;
        r13.put(r21.getPoiId(), r21);
    L26:
        AoiGeofenceDistanceResult r22 = new AoiGeofenceDistanceResult(new ArrayList(r13.values()));
        Iterator r23 = r13.values().iterator();
    L28:
        if (r23.hasNext() == false) goto L35;
        AoiBoard r24 = (AoiBoard) r23.next();
        if (hasValidAoiBoardGeometry(r24) == false) goto L28;
        float r25 = AoiBoardUtil.calculateShortestDistanceToAoiBoard(r24.getAoiBoard(), r10.getLatitude(), r10.getLongitude());
        r22.recordDistance(r25);
        if (r25 > AOI_GEOFENCE_ACTIVE_DISTANCE_METERS) goto L28;
        r22.hasNearbyAoiBoard = true;
        goto L28
    L35:
        return r22;
    }

    private AoiBoard.Confidence resolveConfidenceByDistance(float r8) {
        if (r8 > NEAREST_AOI_LOG_DISTANCE_DELTA_METERS) goto L7;
        return AoiBoard.Confidence.MAX;
    L7:
        if (r8 > 1000.0f) goto L11;
        return AoiBoard.Confidence.HIGH;
    L11:
        if (r8 > 2000.0f) goto L15;
        return AoiBoard.Confidence.MEDIUM;
    L15:
        if (r8 > 3000.0f) goto L19;
        return AoiBoard.Confidence.LOW;
    L19:
        return AoiBoard.Confidence.MIN;
    }

    private AoiBoard.ConfidenceSource resolveConfidenceSource(AoiBoard.Confidence r8, AoiBoard.Confidence r10, AoiBoard.Confidence r11) {
        if (r11 == null) goto L7;
        if (r10 == r8) goto L7;
        return AoiBoard.ConfidenceSource.RETRY;
    L7:
        return AoiBoard.ConfidenceSource.DISTANCE;
    }

    private ConfidenceResult resolveEffectiveConfidence(AoiBoard r8, AoiCalculationState r10, AoiBoard.Confidence r11, AoiBoard.State r12, boolean r13) {
        if (r13 == false) goto L5;
        r10.resetRetryState(r12);
        return new ConfidenceResult(r11, AoiBoard.ConfidenceSource.DISTANCE);
    L5:
        maybeDegradeConfidenceForRetry(r8, r10, r11, r12, LocationMonitorConst.LOCATION);
        AoiBoard.Confidence r14 = r10.retryLimitedConfidence;
        if (r14 != null) goto L8;
        AoiBoard.Confidence r15 = r11;
    L10:
        return new ConfidenceResult(r15, resolveConfidenceSource(r11, r15, r10.retryLimitedConfidence));
    L8:
        r15 = pickLessAggressiveConfidence(r11, r14);
        goto L10
    }

    private long resolveLocationRequestIntervalMs(AoiBoard.Confidence r8) {
        int r10 = AnonymousClass4.$SwitchMap$com$obric$cae$libs$location$poi$AoiBoard$Confidence[r8.ordinal()];
        if (r10 != 1) goto L5;
        return MAX_CONFIDENCE_LOCATION_REQUEST_INTERVAL_MS;
    L5:
        if (r10 != 2) goto L7;
        return 300000;
    L7:
        if (r10 != 3) goto L9;
        return MEDIUM_CONFIDENCE_LOCATION_REQUEST_INTERVAL_MS;
    L9:
        if (r10 == 4) goto L12;
        return NO_ACTIVE_LOCATION_REQUEST_INTERVAL_MS;
    L12:
        return LOW_CONFIDENCE_LOCATION_REQUEST_INTERVAL_MS;
    }

    private AoiBoard.Type resolveTrafficPresetAoiBoardType(StarGeofence r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        String r10 = r8.getGeofenceId();
        if (r8.getGeoType() != StarGeofence.GeoType.TRAFFIC) goto L21;
        if (r10 != null) goto L10;
        return null;
    L10:
        if (r10.startsWith(GEOFENCE_PREFIX_AIRPORT) == false) goto L14;
        return AoiBoard.Type.AIRPORT;
    L14:
        if (r10.startsWith(GEOFENCE_PREFIX_TRAIN_STATION) == false) goto L18;
        return AoiBoard.Type.TRAIN_STATION;
    L18:
        if (r10.startsWith(GEOFENCE_PREFIX_SUBWAY_STATION) == true) goto L20;
        return null;
    L20:
        return AoiBoard.Type.SUBWAY_STATION;
    L21:
        return null;
    }

    private synchronized boolean saveCalculatedAoiBoards(List<AoiBoard> r8, String r10) {
        monitor-enter(this);
        List<AoiBoard> r11 = normalizeAoiBoards(r8);     // Catch: Throwable -> L19
        if (r11.isEmpty() == false) goto L22;
        monitor-exit(this);
        return false;
    L22:
        boolean r12 = this.mStore.upsertAoiBoards(r11);     // Catch: RuntimeException -> L15 Throwable -> L19
        if (r12 == false) goto L12;
        cacheAoiBoardsLocked(r11);     // Catch: RuntimeException -> L15 Throwable -> L19
    L12:
        CommSenseLog.dWithMethodName(TAG, "save calculated aoi boards, reason=" + r10 + ", count=" + r11.size() + ", success=" + r12);     // Catch: RuntimeException -> L15 Throwable -> L19
        monitor-exit(this);
        return r12;
    L15:
        e = move-exception;
        CommSenseLog.e(TAG, "saveCalculatedAoiBoards failed, reason=" + r10, e);     // Catch: Throwable -> L19
        return false;
    L19:
        th = move-exception;
        throw th;
    }

    private void scheduleLocationTask(final String r17, final AoiBoard r18, long r19) {
        long r8 = NO_ACTIVE_LOCATION_REQUEST_INTERVAL_MS;
        if (r19 != NO_ACTIVE_LOCATION_REQUEST_INTERVAL_MS) goto L7;
        String r10 = TAG;
        String r11 = "[" + this.mUserId + "] skip location task, reason= " + r17 + ", poiId=" + r18.getPoiId() + ", confidence=" + r18.getConfidence() + ", confidenceSource=" + formatConfidenceSource(r18);
    L5:
        CommSenseLog.vWithMethodName(r10, r11);
        return;
    L7:
        long r12 = SystemClock.elapsedRealtime();
        if (this.mLastLocationRequestElapsedMs <= 0) goto L11;
        r8 = r12 - this.mLastLocationRequestElapsedMs;
    L11:
        if (r8 >= MAX_CONFIDENCE_LOCATION_REQUEST_INTERVAL_MS) goto L14;
        r10 = TAG;
        r11 = "[" + this.mUserId + "] skip location task, reason= " + r17 + ", poiId=" + r18.getPoiId() + ", elapsedSinceLastRequestMs=" + r8 + ", minIntervalMs=180000";
        goto L5
    L14:
        if (this.mLastLocationRequestElapsedMs <= 0) goto L16;
        long r13 = this.mLastLocationRequestElapsedMs + r19;
    L17:
        long r14 = Math.max(0, r13 - r12);
        Object r15 = this.mLocationTaskLock;
        monitor-enter(r15);
    L38:
        th = move-exception;
        throw th;
    L20:
        if (this.mLocationTaskInFlight == false) goto L24;
        CommSenseLog.vWithMethodName(TAG, "[" + this.mUserId + "] skip location task, reason= " + r17 + ", poiId=" + r18.getPoiId() + ", inFlight=true");     // Catch: Throwable -> L38
        monitor-exit(r15);     // Catch: Throwable -> L38
        return;
    L24:
        ScheduledFuture<?> r16 = this.mScheduledLocationTask;     // Catch: Throwable -> L38
        if (r16 != null) goto L27;
    L35:
        final long r110 = 1 + this.mLocationTaskToken;     // Catch: Throwable -> L38
        this.mLocationTaskToken = r110;     // Catch: Throwable -> L38
        this.mLocationTaskPoiId = r18.getPoiId();     // Catch: Throwable -> L38
        this.mScheduledLocationTaskAtElapsedMs = r12 + r14;     // Catch: Throwable -> L38
        this.mScheduledLocationTask = this.mAoiLocationTaskExecutor.schedule(new d(this, r110, r17, r18), r14, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L38
        CommSenseLog.dWithMethodName(TAG, "[" + this.mUserId + "] reason= " + r17 + ", poiId=" + r18.getPoiId() + ", confidence=" + r18.getConfidence() + ", confidenceSource=" + formatConfidenceSource(r18) + ", delayMs=" + r14 + ", intervalMs=" + r19);     // Catch: Throwable -> L38
        monitor-exit(r15);     // Catch: Throwable -> L38
        return;
    L27:
        if (r16.isDone() == true) goto L35;
        if (this.mScheduledLocationTaskAtElapsedMs <= r13) goto L31;
    L34:
        this.mScheduledLocationTask.cancel(false);     // Catch: Throwable -> L38
        goto L35
    L31:
        if (r18.getPoiId().equals(this.mLocationTaskPoiId) == false) goto L34;
        monitor-exit(r15);     // Catch: Throwable -> L38
        return;
    L16:
        r13 = r12;
        goto L17
    }

    private void scheduleLocationTaskFromNearestAoi(String r8, AoiBoard r10, float r11) {
        finishLocationTaskIfNeeded("location-updated");
        if (r10 != null) goto L6;
        dumpPoiLog("skip schedule userId=" + this.mUserId + ", reason=" + r8 + ", nearestAoiBoard=null");
        return;
    L6:
        maybeLogNearestAoi(r8, r10, r11);
        scheduleLocationTask(defpackage.a.e(r8, "-nearest"), r10, resolveLocationRequestIntervalMs(r10.getConfidence()));
    }

    private AoiBoard selectAoiBoardForGeofenceCoverage(List<AoiBoard> r8) {
        if (r8 != null) goto L5;
    L13:
        return null;
    L5:
        if (r8.isEmpty() == true) goto L13;
        Iterator<AoiBoard> r10 = r8.iterator();
    L9:
        if (r10.hasNext() == false) goto L13;
        AoiBoard r11 = r10.next();
        if (shouldUseGenericAoiGeofence(r11) == false) goto L9;
        return r11;
    }

    private AoiBoard selectControllingAoiBoard(List<AoiBoard> r8) {
        Iterator<AoiBoard> r10 = r8.iterator();
        AoiBoard r11 = null;
        float r12 = Float.MAX_VALUE;
        AoiBoard r13 = null;
    L4:
        if (r10.hasNext() == false) goto L18;
        AoiBoard r14 = r10.next();
        if (r14 == null) goto L4;
        if (r14.getPoiId().isEmpty() == true) goto L4;
        if (r14.getAoiBoard().isEmpty() == true) goto L4;
        AoiCalculationState r15 = this.mAoiCalculationStateMap.get(r14.getPoiId());
        if (r15 == null) goto L4;
        float r16 = r15.lastDistanceMeters;
        if (r16 >= r12) goto L4;
        r13 = r14;
        r12 = r16;
        goto L4
    L18:
        if (r13 == null) goto L20;
        return r13;
    L20:
        Iterator<AoiBoard> r17 = r8.iterator();
        long r18 = NO_ACTIVE_LOCATION_REQUEST_INTERVAL_MS;
    L22:
        if (r17.hasNext() == false) goto L33;
        AoiBoard r19 = r17.next();
        if (r19 == null) goto L22;
        if (r19.getPoiId().isEmpty() == true) goto L22;
        if (r19.getAoiBoard().isEmpty() == true) goto L22;
        long r20 = resolveLocationRequestIntervalMs(r19.getConfidence());
        if (r20 >= r18) goto L22;
        r11 = r19;
        r18 = r20;
        goto L22
    L33:
        return r11;
    }

    private boolean shouldCreateAoiGeofenceOwnerCandidate(AoiBoard r8) {
        if (shouldUseGenericAoiGeofence(r8) == true) goto L5;
        return false;
    L5:
        String r10 = r8.getGeofenceId();
        if (r10.isEmpty() == false) goto L8;
    L11:
        return true;
    L8:
        if (r10.equals(buildAoiBoardGeofenceId(r8)) == true) goto L11;
        if (r10.equals(buildLegacyAoiBoardGeofenceId(r8)) == true) goto L11;
        return false;
    }

    private boolean shouldUpdateAoiGeofence(StarGeofence r8, StarGeofence r10) {
        if (Math.abs(r8.getLatitude() - r10.getLatitude()) <= 1.0E-7d) goto L5;
    L14:
        return true;
    L5:
        if (Math.abs(r8.getLongitude() - r10.getLongitude()) > 1.0E-7d) goto L14;
        if (r8.getRadius() != r10.getRadius()) goto L14;
        if (r8.getGeoType() != r10.getGeoType()) goto L14;
        if (Objects.equals(r8.getPoiId(), r10.getPoiId()) == false) goto L14;
        return false;
    }

    private boolean shouldUseGenericAoiGeofence(AoiBoard r8) {
        if (hasValidAoiBoardGeometry(r8) == true) goto L5;
        return false;
    L5:
        AoiBoard.Type r10 = r8.getType();
        if (r10 != AoiBoard.Type.AIRPORT) goto L8;
        return false;
    L8:
        if (r10 != AoiBoard.Type.TRAIN_STATION) goto L10;
        return false;
    L10:
        if (r10 == AoiBoard.Type.SUBWAY_STATION) goto L15;
        return true;
    L15:
        return false;
    }

    private Map<String, AoiBoard> snapshotAoiBoardsByTypes(Set<AoiBoard.Type> r8) {
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<AoiBoard> r11 = this.mStore.queryAllAoiBoards().iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        AoiBoard r12 = r11.next();
        if (r12 == null) goto L4;
        if (r12.getPoiId().isEmpty() == true) goto L4;
        if (r8.contains(r12.getType()) == false) goto L4;
        r10.put(r12.getPoiId(), copyAoiBoard(r12));
        goto L4
    L13:
        return r10;
    }

    private static List<StarAoiBoardManager> snapshotInstances() {
        return new ArrayList(sInstances.values());
    }

    private StarAoiBoardManager systemAoiBoardManager() {
        if (this.mUserId != 0) goto L6;
        return localAoiBoardManager();
    L6:
        return getInstance(this.mAppContext, 0);
    }

    private void unlinkCallbackDeathRecipient(IBinder r8) {
        IBinder.DeathRecipient r10 = this.mCallbackDeathRecipientMap.remove(r8);
        if (r10 != null) goto L9;
        return;
    L9:
        r8.unlinkToDeath(r10, 0);     // Catch: Throwable -> L8
        return;
    }

    private boolean updateExistingAoiGeofenceIfNeeded(StarGeofence r8, StarGeofence r10, AoiBoard r11, float r12) {
        if (shouldUpdateAoiGeofence(r8, r10) == true) goto L14;
        return false;
    L14:
        byte r13 = StarGeofenceManager.getInstance(this.mAppContext, this.mUserId).getBinder().updateGeofence(r10);     // Catch: Throwable -> L11
        if (r13 != 0) goto L8;
        boolean r14 = true;
    L9:
        CommSenseLog.dWithMethodName(TAG, "update nearby aoi geofence id=" + r10.getGeofenceId() + ", poiId=" + r11.getPoiId() + ", type=" + r11.getType() + ", distanceMeters=" + r12 + ", oldRadius=" + r8.getRadius() + ", newRadius=" + r10.getRadius() + ", result=" + r13);     // Catch: Throwable -> L11
        return r14;
    L8:
        r14 = false;
    L11:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "update nearby aoi geofence failed id=" + r10.getGeofenceId(), th);
        return false;
    }

    public synchronized boolean addAoiBoards(List<AoiBoard> r8) {
        monitor-enter(this);
        List<AoiBoard> r10 = normalizeAoiBoardsPreservingRuntimeState(r8);     // Catch: Throwable -> L42 RuntimeException -> L44
    L6:
        if (r10.isEmpty() == false) goto L10;
        CommSenseLog.w(TAG, "addAoiBoards skipped, empty or invalid input");     // Catch: Throwable -> L42
        monitor-exit(this);
        return false;
    L10:
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L42
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L42
        Iterator<AoiBoard> r13 = r10.iterator();     // Catch: Throwable -> L42
    L12:
        if (r13.hasNext() == false) goto L50;
        AoiBoard r14 = r13.next();     // Catch: Throwable -> L42
        if (r14 == null) goto L12;
        if (r14.getPoiId().isEmpty() == true) goto L12;
        AoiBoard r15 = queryAoiBoardByPoiId(r14.getPoiId());     // Catch: Throwable -> L42
        if (r15 == null) goto L20;
        if (isSameAoiBoardSnapshot(r15, r14) == true) goto L12;
        r12.add(copyAoiBoard(r14));     // Catch: Throwable -> L42
        goto L12
    L20:
        r11.add(copyAoiBoard(r14));     // Catch: Throwable -> L42
        goto L12
    L50:
        boolean r16 = this.mStore.upsertAoiBoards(r10);     // Catch: RuntimeException -> L38 Throwable -> L42
        if (r16 == false) goto L36;
        cacheAoiBoardsLocked(r10);     // Catch: RuntimeException -> L38 Throwable -> L42
        Iterator r17 = r11.iterator();     // Catch: RuntimeException -> L38 Throwable -> L42
    L29:
        if (r17.hasNext() == false) goto L31;
        dumpPoiLog("[" + this.mUserId + "] add " + ((AoiBoard) r17.next()));     // Catch: RuntimeException -> L38 Throwable -> L42
        goto L29
    L31:
        Iterator r18 = r12.iterator();     // Catch: RuntimeException -> L38 Throwable -> L42
    L33:
        if (r18.hasNext() == false) goto L35;
        AoiBoard r19 = (AoiBoard) r18.next();     // Catch: RuntimeException -> L38 Throwable -> L42
        dumpPoiLog("[" + this.mUserId + "] update aoi_board: " + r19.getPoiId() + ", name=" + r19.getPoiName() + ", curState=" + r19.getCurState() + ", confidence=" + r19.getConfidence() + ", confidenceSource=" + formatConfidenceSource(r19));     // Catch: RuntimeException -> L38 Throwable -> L42
        goto L33
    L35:
        ArrayList r20 = new ArrayList(r11.size() + r12.size());     // Catch: RuntimeException -> L38 Throwable -> L42
        r20.addAll(r11);     // Catch: RuntimeException -> L38 Throwable -> L42
        r20.addAll(r12);     // Catch: RuntimeException -> L38 Throwable -> L42
        maybeRequestAoiGeofenceCoverage(r20);     // Catch: RuntimeException -> L38 Throwable -> L42
    L36:
        monitor-exit(this);
        return r16;
    L38:
        e = move-exception;
        CommSenseLog.e(TAG, "addAoiBoards failed", e);     // Catch: Throwable -> L42
        return false;
    L44:
        e = move-exception;
        CommSenseLog.e(TAG, "addAoiBoards failed to preserve runtime state", e);     // Catch: Throwable -> L42
        return false;
    L42:
        th = move-exception;
        throw th;
    }

    public synchronized int deleteAllAoiBoards() {
        monitor-enter(this);
        int r8 = this.mStore.deleteAllAoiBoards();     // Catch: Throwable -> L12 RuntimeException -> L14
        this.mAoiBoardCache.clear();     // Catch: Throwable -> L12 RuntimeException -> L14
        cacheAoiBoardsLocked(this.mStore.queryAllAoiBoards());     // Catch: Throwable -> L12 RuntimeException -> L14
        this.mAoiCalculationStateMap.clear();     // Catch: Throwable -> L12 RuntimeException -> L14
        Object r10 = this.mLocationTaskLock;     // Catch: Throwable -> L12 RuntimeException -> L14
        monitor-enter(r10);     // Catch: Throwable -> L12 RuntimeException -> L14
        this.mLocationTaskPoiId = "";     // Catch: Throwable -> L9
        this.mScheduledLocationTaskAtElapsedMs = 0;     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r8;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12 RuntimeException -> L14
    L14:
        e = move-exception;
        CommSenseLog.e(TAG, "deleteAllAoiBoards failed", e);     // Catch: Throwable -> L12
        return 0;
    L12:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter r8, String[] r10) {
        int r11 = 0;
        if (r10 != null) goto L5;
    L9:
        boolean r12 = false;
    L10:
        r8.println("Poi Log:");
        CommSenseLog.dumpFileContent(this.mPoiLogFile, r8, new b(r12, r11));
        return;
    L5:
        if (r10.length <= 0) goto L9;
        if ("--NeedDecrypt".equalsIgnoreCase(r10[0]) == false) goto L9;
        r12 = true;
        goto L10
    }

    public void dumpPoiLog(String r8) {
        File r10 = this.mPoiLogFile;
        if (r10 == null) goto L6;
        CommSenseLog.dumpD(TAG, r8, r10);
        return;
    }

    public IStarAoiBoardManager getBinder() {
        return this.mBinder;
    }

    public synchronized boolean hasUnknownStateAoiBoards() {
        monitor-enter(this);
        Iterator<AoiBoard> r8 = queryAllAoiBoards().iterator();     // Catch: Throwable -> L16
    L5:
        if (r8.hasNext() == false) goto L13;
        AoiBoard r10 = r8.next();     // Catch: Throwable -> L16
        if (r10 == null) goto L5;
        if (AoiBoard.State.UNKNOWN != r10.getCurState()) goto L5;
        monitor-exit(this);
        return true;
    L13:
        monitor-exit(this);
        return false;
    L16:
        th = move-exception;
        throw th;
    }

    public boolean isRecoveryFinished() {
        return this.mRecoveryFinished.get();
    }

    public List<StarGeofence> listTrafficGeofences() {
        List<StarGeofence> r8 = dbManager(0).queryGeofencesByUserIdAndType(-1, StarGeofence.GeoType.TRAFFIC);     // Catch: Throwable -> L11
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L11
        Iterator<StarGeofence> r11 = r8.iterator();     // Catch: Throwable -> L11
    L5:
        if (r11.hasNext() == false) goto L9;
        StarGeofence r12 = r11.next();     // Catch: Throwable -> L11
        if (isTrafficPresetGeofence(r12) == false) goto L5;
        r10.add(r12);     // Catch: Throwable -> L11
        goto L5
    L9:
        CommSenseLog.vWithMethodName(TAG, "traffic size=" + r10.size() + ", queriedUserId=-1");     // Catch: Throwable -> L11
        return r10;
    L11:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "list traffic geofences failed", th);
        return null;
    }

    public void notifyAoiBoardEvent(AoiBoard r10, Location r11) {
        CommSenseLog.dWithMethodName(TAG, "[" + this.mUserId + "] poiId=" + r10.getPoiId() + ", event=" + r10.getEvent());
        int r8 = r10.getEvent().ordinal();
        if (r8 != 0) goto L5;
        return;
    L5:
        UserAwareManager.getInstance().notifyInnerCallbacks(new o(2), r10);
        Iterator<Map.Entry<IBinder, IStarAoiBoardCallback>> r12 = this.mCallbackMap.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L15;
        Map.Entry<IBinder, IStarAoiBoardCallback> r13 = r12.next();
        IBinder r14 = r13.getKey();
        Integer r15 = this.mCallbackUidMap.get(r14);
        IStarAoiBoardCallback r16 = r13.getValue();
        if (r16 == null) goto L7;
        r16.onAoiBoardBreachReport(r10, r11, r8);     // Catch: Throwable -> L13
        dumpPoiLog(CommSenseLog.getMethodName() + " uid=" + r15 + formatCallback(r16) + ", poiId=" + r10.getPoiId() + ", event=" + r10.getEvent());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        removeCallback(r14, r16);
        dumpPoiLog(CommSenseLog.getMethodName() + " failed uid=" + r15 + formatCallback(r16) + ", poiId=" + r10.getPoiId() + ", event=" + r10.getEvent() + ", error=" + th.getMessage());
        goto L7
    }

    public synchronized List<AoiBoard> queryAllAoiBoards() {
        monitor-enter(this);
        List<AoiBoard> r8 = this.mStore.queryAllAoiBoards();     // Catch: Throwable -> L7 RuntimeException -> L9
        rebuildCacheLocked(r8);     // Catch: Throwable -> L7 RuntimeException -> L9
        List<AoiBoard> r10 = copyAoiBoards(r8);     // Catch: Throwable -> L7 RuntimeException -> L9
        monitor-exit(this);
        return r10;
    L7:
        th = move-exception;
        throw th;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "queryAllAoiBoards failed, userId=" + this.mUserId, e);     // Catch: Throwable -> L7
        return Collections.emptyList();
    }

    public synchronized AoiBoard queryAoiBoardByPoiId(String r8) {
        monitor-enter(this);
        if (r8 != null) goto L31;
    L29:
        monitor-exit(this);
        return null;
    L31:
    L26:
        th = move-exception;
        throw th;
    L7:
        if (r8.isEmpty() == true) goto L29;
        CacheEntry r10 = this.mAoiBoardCache.get(r8);     // Catch: Throwable -> L26
        if (isCacheEntryValid(r10) == false) goto L14;
        AoiBoard r11 = copyAoiBoard(r10.aoiBoard);     // Catch: Throwable -> L26
        monitor-exit(this);
        return r11;
    L14:
        this.mAoiBoardCache.remove(r8);     // Catch: Throwable -> L26
        AoiBoard r12 = this.mStore.queryAoiBoardByPoiId(r8);     // Catch: RuntimeException -> L22 Throwable -> L26
        if (r12 != null) goto L19;
        monitor-exit(this);
        return null;
    L19:
        cacheAoiBoardLocked(r12);     // Catch: RuntimeException -> L22 Throwable -> L26
        AoiBoard r13 = copyAoiBoard(r12);     // Catch: RuntimeException -> L22 Throwable -> L26
        monitor-exit(this);
        return r13;
    L22:
        e = move-exception;
        CommSenseLog.e(TAG, "queryAoiBoardByPoiId failed, poiId=".concat(r8), e);     // Catch: Throwable -> L26
        return null;
    }

    public synchronized List<AoiBoard> queryAoiBoardsByType(AoiBoard.Type r8) {
        monitor-enter(this);
        List<AoiBoard> r10 = queryAoiBoardsByTypes(Collections.singleton(r8));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized List<AoiBoard> queryAoiBoardsByTypes(Set<AoiBoard.Type> r8) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (r8.isEmpty() == false) goto L8;
        List<AoiBoard> r10 = Collections.emptyList();     // Catch: Throwable -> L19
        monitor-exit(this);
        return r10;
    L8:
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L19
        Iterator<AoiBoard> r12 = queryAllAoiBoards().iterator();     // Catch: Throwable -> L19
    L10:
        if (r12.hasNext() == false) goto L17;
        AoiBoard r13 = r12.next();     // Catch: Throwable -> L19
        if (hasValidAoiBoardGeometry(r13) == false) goto L10;
        if (r8.contains(r13.getType()) == false) goto L10;
        r11.add(r13);     // Catch: Throwable -> L19
        goto L10
    L17:
        monitor-exit(this);
        return r11;
    }

    public boolean reconcileTrafficGeofencesWithLocation(Location r8, List<StarGeofence> r10) {
        List<AoiBoard> r11 = listTrafficAoiBoards();
        if (r10 != null) goto L5;
        r10 = listTrafficGeofences();
    L5:
        if (r10 != null) goto L9;
        return false;
    L9:
        if (r11.isEmpty() == false) goto L12;
        removeOldTrafficGeofences(r10, getTrafficAoiBoardTypes(), r11);
        return true;
    L12:
        Map<String, StarGeofence> r12 = buildTrafficGeofenceMap(r10);
        Iterator<AoiBoard> r13 = r11.iterator();
    L14:
        if (r13.hasNext() == false) goto L16;
        reconcileSingleTrafficAoiBoard(r8, r13.next(), r12);
        goto L14
    L16:
        removeStaleTrafficGeofences(r12, r11);
        return true;
    }

    public void registerAoiBoardCallback(int r8, IStarAoiBoardCallback r10) {
        final IBinder r11 = r10.asBinder();
        removeCallbackByBinder(r11);
        IBinder.DeathRecipient r12 = new a(this, r11);
        r11.linkToDeath(r12, 0);     // Catch: RemoteException -> L5
        this.mCallbackMap.put(r11, r10);     // Catch: RemoteException -> L5
        this.mCallbackDeathRecipientMap.put(r11, r12);     // Catch: RemoteException -> L5
        this.mCallbackUidMap.put(r11, Integer.valueOf(r8));     // Catch: RemoteException -> L5
        this.mUidCallbackBinderMap.computeIfAbsent(Integer.valueOf(r8), new com.google.protobuf.d(5)).add(r11);     // Catch: RemoteException -> L5
        dumpPoiLog(CommSenseLog.getMethodName() + " uid=" + r8 + formatCallback(r10));     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        dumpPoiLog(CommSenseLog.getMethodName() + " failed uid=" + r8 + formatCallback(r10) + ", error=" + e.getMessage());
    }

    public synchronized void reloadAoiBoardsFromDbAfterCitySwitch() {
        monitor-enter(this);
        this.mRecoveryFinished.set(false);     // Catch: Throwable -> L33
        List<AoiBoard> r8 = this.mStore.queryAllAoiBoards();     // Catch: Throwable -> L23 RuntimeException -> L25
        rebuildCacheLocked(r8);     // Catch: Throwable -> L23 RuntimeException -> L25
        this.mAoiCalculationStateMap.clear();     // Catch: Throwable -> L23 RuntimeException -> L25
        Object r10 = this.mLocationTaskLock;     // Catch: Throwable -> L23 RuntimeException -> L25
        monitor-enter(r10);     // Catch: Throwable -> L23 RuntimeException -> L25
        ScheduledFuture<?> r11 = this.mScheduledLocationTask;     // Catch: Throwable -> L20
        if (r11 == null) goto L11;
        r11.cancel(false);     // Catch: Throwable -> L20
        this.mScheduledLocationTask = null;     // Catch: Throwable -> L20
    L11:
        ScheduledFuture<?> r12 = this.mLocationTaskTimeout;     // Catch: Throwable -> L20
        if (r12 == null) goto L14;
        r12.cancel(false);     // Catch: Throwable -> L20
        this.mLocationTaskTimeout = null;     // Catch: Throwable -> L20
    L14:
        this.mLocationTaskInFlight = false;     // Catch: Throwable -> L20
        this.mLocationTaskToken++;     // Catch: Throwable -> L20
        this.mLocationTaskPoiId = "";     // Catch: Throwable -> L20
        this.mScheduledLocationTaskAtElapsedMs = 0;     // Catch: Throwable -> L20
        this.mLastNearestAoiPoiId = "";     // Catch: Throwable -> L20
        this.mLastNearestAoiConfidence = null;     // Catch: Throwable -> L20
        this.mLastNearestAoiDistanceMeters = Float.MAX_VALUE;     // Catch: Throwable -> L20
        monitor-exit(r10);     // Catch: Throwable -> L20
        this.mAoiBoardsRecovered = true;     // Catch: Throwable -> L23 RuntimeException -> L25
        dumpPoiLog("reload aoi boards after city switch userId=" + this.mUserId + ", count=" + r8.size() + ", cacheSize=" + this.mAoiBoardCache.size());     // Catch: Throwable -> L23 RuntimeException -> L25
        AtomicBoolean r13 = this.mRecoveryFinished;     // Catch: Throwable -> L33
    L18:
        r13.set(true);     // Catch: Throwable -> L33
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23 RuntimeException -> L25
    L23:
        th = move-exception;
        this.mRecoveryFinished.set(true);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L25:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);     // Catch: Throwable -> L23
        this.mAoiBoardsRecovered = true;     // Catch: Throwable -> L23
        r13 = this.mRecoveryFinished;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }

    public int removeOldTrafficGeofences(List<StarGeofence> r8) {
        return removeOldTrafficGeofences(r8, getTrafficAoiBoardTypes());
    }

    public synchronized boolean replaceAoiBoardsByTypes(Set<AoiBoard.Type> r8, List<AoiBoard> r10) {
        monitor-enter(this);
    L34:
        th = move-exception;
        throw th;
    L5:
        if (r8.isEmpty() == false) goto L8;
        monitor-exit(this);
        return false;
    L8:
        List<AoiBoard> r11 = normalizeAoiBoards(r10);     // Catch: Throwable -> L34
        preserveRuntimeStateFromMap(r11, snapshotAoiBoardsByTypes(r8));     // Catch: RuntimeException -> L30 Throwable -> L34
        int r12 = this.mStore.deleteAoiBoardsByTypes(r8);     // Catch: RuntimeException -> L30 Throwable -> L34
        Iterator<AoiBoard.Type> r13 = r8.iterator();     // Catch: RuntimeException -> L30 Throwable -> L34
    L11:
        if (r13.hasNext() == false) goto L13;
        removeCachedAoiBoardsByTypeLocked(r13.next());     // Catch: RuntimeException -> L30 Throwable -> L34
        goto L11
    L13:
        this.mAoiCalculationStateMap.clear();     // Catch: RuntimeException -> L30 Throwable -> L34
        Object r14 = this.mLocationTaskLock;     // Catch: RuntimeException -> L30 Throwable -> L34
        monitor-enter(r14);     // Catch: RuntimeException -> L30 Throwable -> L34
        this.mLocationTaskPoiId = "";     // Catch: Throwable -> L27
        this.mScheduledLocationTaskAtElapsedMs = 0;     // Catch: Throwable -> L27
        monitor-exit(r14);     // Catch: Throwable -> L27
        if (r11.isEmpty() == false) goto L20;
    L23:
        boolean r15 = true;
    L24:
        CommSenseLog.d(TAG, "replaceAoiBoardsByTypes replaceTypes=" + r8 + ", replacementCount=" + r11.size() + ", deletedCount=" + r12 + ", success=" + r15);     // Catch: RuntimeException -> L30 Throwable -> L34
        monitor-exit(this);
        return r15;
    L20:
        if (addAoiBoards(r11) == true) goto L23;
        r15 = false;
    L27:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L30 Throwable -> L34
    L30:
        e = move-exception;
        CommSenseLog.e(TAG, "replaceAoiBoardsByTypes failed, replaceTypes=" + r8, e);     // Catch: Throwable -> L34
        return false;
    }

    public void unregisterAoiBoardCallback(int r8) {
        Set<IBinder> r10 = this.mUidCallbackBinderMap.remove(Integer.valueOf(r8));
        int r11 = 0;
        if (r10 == null) goto L10;
        Iterator<IBinder> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        if (removeCallbackByBinder(r12.next()) == false) goto L6;
        r11 = r11 + 1;
    L10:
        CommSenseLog.dWithMethodName(TAG, "unregister uid=" + r8 + ", removedCount=" + r11);
        dumpPoiLog("unregister callback uid=" + r8 + ", removedCount=" + r11);
    }

    public synchronized boolean updateAoiBoard(AoiBoard r8) {
        monitor-enter(this);
        if (r8 != null) goto L5;
        List<AoiBoard> r10 = Collections.emptyList();     // Catch: Throwable -> L9
    L6:
        boolean r11 = saveCalculatedAoiBoards(r10, "direct_update");     // Catch: Throwable -> L9
        monitor-exit(this);
        return r11;
    L5:
        r10 = Collections.singletonList(r8);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized boolean updateAoiBoardGeofenceId(String r8, String r10) {
        monitor-enter(this);
        if (r8 != null) goto L36;
    L34:
        monitor-exit(this);
        return false;
    L36:
    L31:
        th = move-exception;
        throw th;
    L7:
        if (r8.isEmpty() == true) goto L34;
        if (r10 != null) goto L11;
        r10 = "";
    L11:
        AoiBoard r11 = queryAoiBoardByPoiId(r8);     // Catch: Throwable -> L31
        if (r11 != null) goto L14;
    L37:
    L27:
        e = move-exception;
        CommSenseLog.e(TAG, "updateAoiBoardGeofenceId failed, poiId=".concat(r8), e);     // Catch: Throwable -> L31
        return false;
    L18:
        if (this.mStore.updateAoiBoardGeofenceId(r8, r10) == true) goto L21;
        monitor-exit(this);
        return false;
    L21:
        if (r11 != null) goto L23;
        r11 = this.mStore.queryAoiBoardByPoiId(r8);     // Catch: RuntimeException -> L27 Throwable -> L31
    L23:
        if (r11 == null) goto L25;
        r11.setGeofenceId(r10);     // Catch: RuntimeException -> L27 Throwable -> L31
        cacheAoiBoardLocked(r11);     // Catch: RuntimeException -> L27 Throwable -> L31
        dumpPoiLog("[" + this.mUserId + "] update aoi_board, poiId=" + r8 + ", geofenceId=" + r10);     // Catch: RuntimeException -> L27 Throwable -> L31
    L25:
        monitor-exit(this);
        return true;
    L14:
        if (r10.equals(r11.getGeofenceId()) == false) goto L37;
        monitor-exit(this);
        return true;
    }

    public synchronized boolean updateAoiBoards(List<AoiBoard> r8) {
        monitor-enter(this);
        boolean r10 = saveCalculatedAoiBoards(r8, "direct_update");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public StarAoiBoardManager(Context r8, int r10, AoiBoardStore r11, long r12, int r13) {
        this.mCallbackMap = new ConcurrentHashMap();
        this.mCallbackDeathRecipientMap = new ConcurrentHashMap();
        this.mCallbackUidMap = new ConcurrentHashMap();
        this.mUidCallbackBinderMap = new ConcurrentHashMap();
        this.mAoiCalculationStateMap = new ConcurrentHashMap();
        this.mAoiCalculationExecutor = Executors.newSingleThreadExecutor();
        this.mAoiLocationTaskExecutor = Executors.newSingleThreadScheduledExecutor();
        this.mRecoveryFinished = new AtomicBoolean(false);
        this.mLocationTaskLock = new Object();
        this.mLocationTaskInFlight = false;
        this.mScheduledLocationTaskAtElapsedMs = 0;
        this.mLocationTaskToken = 0;
        this.mLocationTaskPoiId = "";
        this.mLastNearestAoiPoiId = "";
        this.mLastNearestAoiDistanceMeters = Float.MAX_VALUE;
        this.mLatestSteps = -1;
        this.mLatestHarStatus = 4;
        this.mLastLocationRequestElapsedMs = 0;
        this.mAoiBoardsRecovered = false;
        this.mBinder = new AnonymousClass2(this);
        this.mAppContext = r8.getApplicationContext();
        this.mUserId = r10;
        this.mStore = r11;
        this.mCacheTtlMs = Math.max(0, r12);
        final boolean r14 = true;
        this.mMaxCacheSize = Math.max(1, r13);
        final int r15 = 16;
        final float r16 = 0.75f;
        this.mAoiBoardCache = new AnonymousClass3(this, r15, r16, r14);
        this.mPoiLogFile = initPoiLogFile();
        dumpPoiLog("init userId=" + r10);
        preloadAoiBoardsFromDbOnInit();
    }

    public static AoiBoard buildAoiBoard(String r8, String r10, String r11, AoiBoard.Type r12) {
        AoiBoard r13 = new AoiBoard();
        r13.setPoiId(r8);
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r13.setPoiName(r10);
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        r13.setAoiBoard(r11);
        r13.setCurState(AoiBoard.State.UNKNOWN);
        r13.setTransitionType(AoiBoard.TransitionType.ENTERED_AND_EXITED);
        r13.setConfidence(AoiBoard.Confidence.MIN);
        r13.setConfidenceSource(AoiBoard.ConfidenceSource.DEFAULT);
        r13.setEvent(AoiBoard.Event.UNKNOWN);
        r13.setType(r12);
        return r13;
    }

    private StarGeofence buildTrafficGeofence(String r19, String r20, String r21, String r22, double r23, double r25, AoiBoard.Type r27) {
        TrafficGeofenceShape r8 = buildTrafficGeofenceShape(r22, r23, r25, getDefaultTrafficRadiusMeters(r27));
        if (r22 != null) goto L5;
    L14:
        StarGeofence r10 = new StarGeofence(this.mAppContext.getPackageName(), r19, r8.centerLatitude, r8.centerLongitude, r8.radiusMeters, StarGeofence.GeoTransitionType.ENTERED_AND_EXITED);
        if (r20 != null) goto L17;
        String r11 = "";
    L18:
        r10.setAddress(r11);
        r10.setConfidence(StarGeofence.GeoConfidence.HIGH);
        r10.setGeoType(StarGeofence.GeoType.TRAFFIC);
        r10.setPoiId(r21);
        StringBuilder r12 = new StringBuilder("build traffic geofence id=");
        r12.append(r19);
        r12.append(", poiId=");
        r12.append(r21);
        r12.append(", radius=");
        r12.append(r8.radiusMeters);
        r12.append(", source=");
        if (r8.fromAoi == false) goto L21;
        String r13 = "aoi";
    L22:
        r12.append(r13);
        CommSenseLog.vWithMethodName(TAG, r12.toString());
        return r10;
    L21:
        r13 = "fallback";
        goto L22
    L17:
        r11 = r20;
        goto L18
    L5:
        if (r22.isEmpty() == true) goto L14;
        if (r8.fromAoi == true) goto L14;
        if (r23 != 0.0d) goto L14;
        if (r25 != 0.0d) goto L14;
        return null;
    }

    private static String formatConfidenceSource(AoiBoard r8) {
        return formatConfidenceSource(r8.getConfidenceSource());
    }

    public static synchronized StarAoiBoardManager getInstance(Context r8, int r10) {
        monitor-enter(StarAoiBoardManager.class);
        ensureInnerAwareCallbackRegistered();     // Catch: Throwable -> L10
        if (r10 == 0) goto L7;
        getOrCreateInstanceLocked(r8, 0);     // Catch: Throwable -> L10
    L7:
        StarAoiBoardManager r11 = getOrCreateInstanceLocked(r8, r10);     // Catch: Throwable -> L10
        monitor-exit(StarAoiBoardManager.class);
        return r11;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean isTrafficPresetGeofence(StarGeofence r8, Set<AoiBoard.Type> r10) {
        AoiBoard.Type r11 = resolveTrafficPresetAoiBoardType(r8);
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.contains(r11) == false) goto L7;
        return true;
    }

    private long resolveLocationRequestIntervalMs(List<AoiBoard> r8) {
        Iterator<AoiBoard> r10 = r8.iterator();
        long r11 = NO_ACTIVE_LOCATION_REQUEST_INTERVAL_MS;
    L4:
        if (r10.hasNext() == false) goto L9;
        AoiBoard r12 = r10.next();
        if (r12 == null) goto L4;
        r11 = Math.min(r11, resolveLocationRequestIntervalMs(r12.getConfidence()));
        goto L4
    L9:
        return r11;
    }

    public int removeOldTrafficGeofences(List<StarGeofence> r8, Set<AoiBoard.Type> r10) {
        return removeOldTrafficGeofences(r8, r10, null);
    }

    private int removeOldTrafficGeofences(List<StarGeofence> r8, Set<AoiBoard.Type> r10, List<AoiBoard> r11) {
        if (r8.isEmpty() == false) goto L5;
        return 0;
    L5:
        CommSenseLog.dWithMethodName(TAG, "traffic list size=" + r8.size() + ", aoiBoardTypes=" + r10);
        Iterator<StarGeofence> r12 = r8.iterator();
        int r13 = 0;
    L7:
        if (r12.hasNext() == false) goto L19;
        StarGeofence r14 = r12.next();
        if (r14 == null) goto L7;
        String r15 = r14.getGeofenceId();
        StringBuilder r16 = defpackage.b.h("inspect traffic geofence id=", r15, ", geoType=");
        r16.append(r14.getGeoType());
        r16.append(", address=");
        r16.append(r14.getAddress());
        CommSenseLog.dWithMethodName(TAG, r16.toString());
        if (isTrafficPresetGeofence(r14, r10) == false) goto L7;
        if (deleteGeofenceById(0, r15, "old_traffic") == false) goto L7;
        r13 = r13 + 1;
        if (r11 != null) goto L18;
        r11 = listTrafficAoiBoards();
    L18:
        clearTrafficGeofenceBindingsById(r15, "old_traffic", r11);
        goto L7
    L19:
        return r13;
    }
}
