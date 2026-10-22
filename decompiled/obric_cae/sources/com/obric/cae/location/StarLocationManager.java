package com.obric.cae.location;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.activity.k;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.libs.location.CoordinateTransformUtils;
import com.obric.cae.location.geofence.StarGeoCallback;
import com.obric.cae.location.geofence.StarGeofenceManager;
import com.obric.cae.location.geosdk.poi.StarAoiBoardManager;
import com.obric.cae.location.report.StarLocationTeaReporter;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class StarLocationManager {
    private static final double CELL_COVERAGE_OUTSIDE_MULTIPLIER = 1.68d;
    private static final float DEFAULT_LOCATION_RADIUS_METERS = 50.0f;
    private static final int DEFAULT_LOCATION_UPDATE_QUEUE_MAX_SIZE = 300;
    public static final String EXTRA_ALTITUDE = "ALTITUDE";
    public static final String EXTRA_BEARING = "BEARING";
    public static final String EXTRA_BEARING_ACCURACY_DEGREES = "BEARING_ACCURACY_DEGREES";
    public static final String EXTRA_HAS_ALTITUDE = "HAS_ALTITUDE";
    public static final String EXTRA_LOCATION_CONFIDENCE = "location_confidence";
    public static final String EXTRA_SPEED = "SPEED";
    public static final String EXTRA_SPEED_ACCURACY_METERS_PER_SECOND = "SPEED_ACCURACY_METERS_PER_SECOND";
    public static final String EXTRA_VERTICAL_ACCURACY_METERS = "VERTICAL_ACCURACY_METERS";
    private static final float HIGH_CONFIDENCE_GPS_ACCURACY_THRESHOLD = 50.0f;
    private static final float HIGH_CONFIDENCE_NETWORK_ACCURACY_THRESHOLD = 30.0f;
    private static final String JSON_KEY_APPLIED = "applied";
    private static final String JSON_KEY_CONFIDENCE = "confidence";
    private static final String JSON_KEY_COORD_SYS = "coordSys";
    private static final String JSON_KEY_ELAPSED_REALTIME_NANOS = "elapsedRealtimeNanos";
    private static final String JSON_KEY_EXTRA = "extra";
    private static final String JSON_KEY_EXTRA_KEY = "key";
    private static final String JSON_KEY_EXTRA_TYPE = "type";
    private static final String JSON_KEY_EXTRA_VALUE = "value";
    private static final String JSON_KEY_LATITUDE = "latitude";
    private static final String JSON_KEY_LOCATION_TIME = "locationTime";
    private static final String JSON_KEY_LONGITUDE = "longitude";
    private static final String JSON_KEY_MOCK = "mock";
    private static final String JSON_KEY_PROVIDER = "provider";
    private static final String JSON_KEY_RADIUS = "radius";
    private static final String JSON_KEY_SIM_READY = "simReady";
    private static final String JSON_KEY_SOURCE = "source";
    private static final String JSON_KEY_UPDATE_TS = "updateTs";
    private static final String JSON_KEY_USER_ID = "userId";
    private static final String JSON_KEY_VERSION = "version";
    private static final String JSON_KEY_WIFI_CONNECTED = "wifiConnected";
    private static final String JSON_TYPE_BOOLEAN = "boolean";
    private static final String JSON_TYPE_DOUBLE = "double";
    private static final String JSON_TYPE_FLOAT = "float";
    private static final String JSON_TYPE_INT = "int";
    private static final String JSON_TYPE_LONG = "long";
    private static final String JSON_TYPE_NULL = "null";
    private static final String JSON_TYPE_STRING = "string";
    public static final int LOCATION_CONFIDENCE_HIGH = 4;
    public static final int LOCATION_CONFIDENCE_LOW = 1;
    public static final int LOCATION_CONFIDENCE_MAX = 5;
    public static final int LOCATION_CONFIDENCE_MEDIUM = 3;
    public static final int LOCATION_CONFIDENCE_ZERO = 0;
    private static final int LOCATION_SOURCE_JSON_VERSION = 2;
    private static final float LOW_CONFIDENCE_NETWORK_ACCURACY_THRESHOLD = 200.0f;
    private static final float MAX_CONFIDENCE_GPS_ACCURACY_THRESHOLD = 20.0f;
    private static final int MAX_HISTORY_SIZE = 100;
    private static final float MEDIUM_CONFIDENCE_GPS_ACCURACY_THRESHOLD = 70.0f;
    private static final float MEDIUM_CONFIDENCE_NETWORK_ACCURACY_THRESHOLD = 100.0f;
    private static final long NETWORK_LOCATION_CACHE_DELAY_MS = 3000;
    private static final int NLP_VALID_CODE_CENTER_OUTSIDE_CELL = 2;
    private static final int NLP_VALID_CODE_CENTER_WEAK_OUTSIDE_CELL = 1;
    private static final int NLP_VALID_CODE_OK = 0;
    private static final int NLP_VALID_CODE_RADIUS_LARGER_THAN_CELL = 3;
    public static final String PROVIDER_CELL = "cell";
    public static final int SOURCE_ACTIVE_BD = 5;
    public static final int SOURCE_ACTIVE_LPM_CURRENT = 3;
    public static final int SOURCE_ACTIVE_LPM_SINGLE = 4;
    public static final int SOURCE_BD_CELL = 6;
    public static final int SOURCE_PASSIVE = 1;
    public static final int SOURCE_UNKNOWN = 0;
    public static final int SOURCE_VENDOR_GEOFENCE = 2;
    private static final String STR_LOCATION_FILE_NAME = "star_location.txt";
    private static final String TAG = "StarLocation-manager";
    private static volatile StarLocationManager sInstance;
    private final AtomicReference<Location> mCacheNlpLocation;
    private volatile Context mContext;
    private final AtomicLong mDroppedLocationUpdateTaskCount;
    private final AtomicBoolean mGnssEngineOn;
    private final Object mHistoryLock;
    private final ArrayDeque<LocationSource> mHistorySources;
    private final AtomicReference<Location> mLastVendorGeofenceLocation;
    private final ConcurrentMap<String, LocationSource> mLatestSourceProvider;
    private volatile File mLocationFile;
    private final ArrayDeque<LocationUpdateTask> mLocationUpdateQueue;
    private boolean mLocationUpdateQueueDraining;
    private final ExecutorService mLocationUpdateQueueExecutor;
    private final Object mLocationUpdateQueueLock;
    private final AtomicBoolean mReceivedGnssLocation;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocationConfidenceValue {
    }

    public static class LocationSource {
        private boolean applied;
        private int confidence;
        private CoordinateTransformUtils.CoordinateSystem coordSys;
        private long elapsedRealtimeNanos;
        private Bundle extra;
        private double latitude;
        private long locationTime;
        private double longitude;
        private boolean mock;
        private String provider;
        private float radius;
        private boolean simReady;
        private int source;
        private long updateTs;
        private int userId;
        private boolean wifiConnected;

        public LocationSource() {
            this.source = 0;
            this.provider = "";
            this.updateTs = 0;
            this.latitude = 0.0d;
            this.longitude = 0.0d;
            this.radius = 0.0f;
            this.applied = true;
            this.coordSys = CoordinateTransformUtils.CoordinateSystem.WGS84;
            this.confidence = 0;
            this.simReady = false;
            this.wifiConnected = false;
            this.extra = new Bundle();
            this.elapsedRealtimeNanos = 0;
            this.locationTime = 0;
            this.mock = false;
            this.userId = 0;
        }

        private static Bundle bundleFromJsonArray(JSONArray r8) {
            Bundle r10 = new Bundle();
            if (r8 != null) goto L5;
            return r10;
        L5:
            int r11 = 0;
        L7:
            if (r11 >= r8.length()) goto L16;
            JSONObject r12 = r8.optJSONObject(r11);
            if (r12 == null) goto L15;
            String r13 = r12.optString(StarLocationManager.JSON_KEY_EXTRA_KEY, "");
            if (r13.isEmpty() == true) goto L15;
            putBundleValue(r10, r13, r12);
        L15:
            r11 = r11 + 1;
            goto L7
        L16:
            return r10;
        }

        private static JSONArray bundleToJsonArray(Bundle r8) {
            JSONArray r10 = new JSONArray();
            Iterator<String> r11 = r8.keySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            String r12 = r11.next();
            JSONObject r13 = new JSONObject();
            Object r14 = r8.get(r12);
            r13.put(StarLocationManager.JSON_KEY_EXTRA_KEY, r12);
            putTypedJsonValue(r13, r14);
            r10.put(r13);
            goto L4
        L6:
            return r10;
        }

        public static LocationSource fromJsonString(String r10) {
            JSONObject r8 = new JSONObject(r10);
            if (r8.has(StarLocationManager.JSON_KEY_SOURCE) == false) goto L11;
            if (r8.has("latitude") == false) goto L11;
            if (r8.has("longitude") == false) goto L11;
            return new LocationSource().setSource(r8.optInt(StarLocationManager.JSON_KEY_SOURCE, 0)).setProvider(r8.optString(StarLocationManager.JSON_KEY_PROVIDER, "")).setLatitude(r8.optDouble("latitude", 0.0d)).setLongitude(r8.optDouble("longitude", 0.0d)).setRadius((float) r8.optDouble("radius", 0.0d)).setApplied(r8.optBoolean(StarLocationManager.JSON_KEY_APPLIED, true)).setCoordSys(parseCoordinateSystem(r8.optString(StarLocationManager.JSON_KEY_COORD_SYS, null))).setConfidence(r8.optInt("confidence", 0)).setUpdateTs(r8.optLong(StarLocationManager.JSON_KEY_UPDATE_TS, 0)).setElapsedRealtimeNanos(r8.optLong(StarLocationManager.JSON_KEY_ELAPSED_REALTIME_NANOS, 0)).setLocationTime(r8.optLong(StarLocationManager.JSON_KEY_LOCATION_TIME, 0)).setSimReady(r8.optBoolean(StarLocationManager.JSON_KEY_SIM_READY, false)).setWifiConnected(r8.optBoolean(StarLocationManager.JSON_KEY_WIFI_CONNECTED, false)).setMock(r8.optBoolean(StarLocationManager.JSON_KEY_MOCK, false)).setUserId(r8.optInt("userId", 0)).setExtra(bundleFromJsonArray(r8.optJSONArray("extra")));
        L11:
            throw new JSONException("missing LocationSource json fields");
        }

        private static CoordinateTransformUtils.CoordinateSystem parseCoordinateSystem(String r8) {
            if (r8 == null) goto L11;
            if (r8.isEmpty() == true) goto L11;
            return CoordinateTransformUtils.CoordinateSystem.valueOf(r8);
        L9:
            return CoordinateTransformUtils.CoordinateSystem.WGS84;
        L11:
            return CoordinateTransformUtils.CoordinateSystem.WGS84;
        }

        private static void putBundleValue(Bundle r10, String r11, JSONObject r12) {
            String r8 = r12.optString("type", "string");
            switch(r8.hashCode()) {
                case -1325958191: goto L24;
                case -891985903: goto L21;
                case 104431: goto L18;
                case 3327612: goto L15;
                case 3392903: goto L12;
                case 64711720: goto L9;
                case 97526364: goto L6;
                default: goto L26;
            };
        L26:
            byte r13 = -1;
        L27:
            if (r13 != 0) goto L29;
            String r14 = null;
        L42:
            r10.putString(r11, r14);
            return;
        L29:
            if (r13 == 1) goto L40;
            if (r13 != 2) goto L32;
            r10.putLong(r11, r12.optLong("value", 0));
            return;
        L32:
            if (r13 == 3) goto L38;
            if (r13 == 4) goto L37;
            if (r13 == 5) goto L36;
            r14 = r12.optString("value", "");
            goto L42
        L36:
            r10.putBoolean(r11, r12.optBoolean("value", false));
            return;
        L37:
            r10.putDouble(r11, r12.optDouble("value", 0.0d));
            return;
        L38:
            r10.putFloat(r11, (float) r12.optDouble("value", 0.0d));
            return;
        L40:
            r10.putInt(r11, r12.optInt("value", 0));
            return;
        L6:
            if (r8.equals("float") == false) goto L26;
            r13 = 3;
            goto L27
        L9:
            if (r8.equals("boolean") == false) goto L26;
            r13 = 5;
            goto L27
        L12:
            if (r8.equals(StarLocationManager.JSON_TYPE_NULL) == false) goto L26;
            r13 = 0;
            goto L27
        L15:
            if (r8.equals("long") == false) goto L26;
            r13 = 2;
            goto L27
        L18:
            if (r8.equals("int") == false) goto L26;
            r13 = 1;
            goto L27
        L21:
            if (r8.equals("string") == false) goto L26;
            r13 = 6;
            goto L27
        L24:
            if (r8.equals("double") == false) goto L26;
            r13 = 4;
            goto L27
        }

        private static void putTypedJsonValue(JSONObject r8, Object r10) {
            if (r10 != null) goto L7;
            r8.put("type", StarLocationManager.JSON_TYPE_NULL);
            r10 = JSONObject.NULL;
        L5:
            r8.put("value", r10);
            return;
        L7:
            if ((r10 instanceof Integer) == false) goto L11;
            String r11 = "int";
        L9:
            r8.put("type", r11);
            goto L5
        L11:
            if ((r10 instanceof Long) == false) goto L14;
            r11 = "long";
            goto L9
        L14:
            if ((r10 instanceof Float) == false) goto L17;
            r8.put("type", "float");
            r8.put("value", ((Float) r10).doubleValue());
            return;
        L17:
            if ((r10 instanceof Double) == false) goto L20;
            r11 = "double";
            goto L9
        L20:
            if ((r10 instanceof Boolean) == false) goto L22;
            r11 = "boolean";
            goto L9
        L22:
            boolean r12 = r10 instanceof String;
            r8.put("type", "string");
            if (r12 == true) goto L5;
            r10 = String.valueOf(r10);
            goto L5
        }

        private JSONObject toJson() {
            JSONObject r8 = new JSONObject();
            r8.put("version", 2);
            r8.put(StarLocationManager.JSON_KEY_SOURCE, this.source);
            r8.put(StarLocationManager.JSON_KEY_PROVIDER, this.provider);
            r8.put("latitude", this.latitude);
            r8.put("longitude", this.longitude);
            r8.put("radius", this.radius);
            r8.put(StarLocationManager.JSON_KEY_APPLIED, this.applied);
            r8.put(StarLocationManager.JSON_KEY_COORD_SYS, this.coordSys.name());
            r8.put("confidence", this.confidence);
            r8.put(StarLocationManager.JSON_KEY_UPDATE_TS, this.updateTs);
            r8.put(StarLocationManager.JSON_KEY_ELAPSED_REALTIME_NANOS, this.elapsedRealtimeNanos);
            r8.put(StarLocationManager.JSON_KEY_LOCATION_TIME, this.locationTime);
            r8.put(StarLocationManager.JSON_KEY_SIM_READY, this.simReady);
            r8.put(StarLocationManager.JSON_KEY_WIFI_CONNECTED, this.wifiConnected);
            r8.put(StarLocationManager.JSON_KEY_MOCK, this.mock);
            r8.put("userId", this.userId);
            r8.put("extra", bundleToJsonArray(this.extra));
            return r8;
        }

        public LocationSource copy() {
            return new LocationSource(this);
        }

        public boolean equals(Object r8) {
            if ((r8 instanceof LocationSource) == false) goto L13;
            LocationSource r10 = (LocationSource) r8;
            if (getProvider().equals(r10.getProvider()) == false) goto L13;
            if (Double.compare(r10.getLatitude(), getLatitude()) != 0) goto L13;
            if (Double.compare(r10.getLongitude(), getLongitude()) != 0) goto L13;
            if (Float.compare(r10.getRadius(), getRadius()) != 0) goto L13;
            return true;
        L13:
            return false;
        }

        public int getConfidence() {
            return this.confidence;
        }

        public CoordinateTransformUtils.CoordinateSystem getCoordSys() {
            return this.coordSys;
        }

        public long getElapsedRealtimeNanos() {
            return this.elapsedRealtimeNanos;
        }

        public Bundle getExtra() {
            return new Bundle(this.extra);
        }

        public double getLatitude() {
            return this.latitude;
        }

        public long getLocationTime() {
            return this.locationTime;
        }

        public double getLongitude() {
            return this.longitude;
        }

        public String getProvider() {
            return this.provider;
        }

        public float getRadius() {
            return this.radius;
        }

        public int getSource() {
            return this.source;
        }

        public long getUpdateTs() {
            return this.updateTs;
        }

        public int getUserId() {
            return this.userId;
        }

        public boolean isApplied() {
            return this.applied;
        }

        public boolean isMock() {
            return this.mock;
        }

        public boolean isSimReady() {
            return this.simReady;
        }

        public boolean isWifiConnected() {
            return this.wifiConnected;
        }

        public LocationSource setApplied(boolean r8) {
            this.applied = r8;
            return this;
        }

        public LocationSource setConfidence(int r8) {
            this.confidence = r8;
            return this;
        }

        public LocationSource setCoordSys(CoordinateTransformUtils.CoordinateSystem r8) {
            if (r8 != null) goto L4;
            r8 = CoordinateTransformUtils.CoordinateSystem.WGS84;
        L4:
            this.coordSys = r8;
            return this;
        }

        public LocationSource setElapsedRealtimeNanos(long r8) {
            this.elapsedRealtimeNanos = r8;
            return this;
        }

        public LocationSource setExtra(Bundle r8) {
            if (r8 != null) goto L4;
            Bundle r10 = new Bundle();
        L5:
            this.extra = r10;
            return this;
        L4:
            r10 = new Bundle(r8);
            goto L5
        }

        public LocationSource setLatitude(double r8) {
            this.latitude = r8;
            return this;
        }

        public LocationSource setLocationTime(long r8) {
            this.locationTime = r8;
            return this;
        }

        public LocationSource setLongitude(double r8) {
            this.longitude = r8;
            return this;
        }

        public LocationSource setMock(boolean r8) {
            this.mock = r8;
            return this;
        }

        public LocationSource setProvider(String r8) {
            if (r8 != null) goto L4;
            r8 = "";
        L4:
            this.provider = r8;
            return this;
        }

        public LocationSource setRadius(float r8) {
            this.radius = r8;
            return this;
        }

        public LocationSource setSimReady(boolean r8) {
            this.simReady = r8;
            return this;
        }

        public LocationSource setSource(int r8) {
            this.source = r8;
            return this;
        }

        public LocationSource setUpdateTs(long r8) {
            this.updateTs = r8;
            return this;
        }

        public LocationSource setUserId(int r8) {
            this.userId = r8;
            return this;
        }

        public LocationSource setWifiConnected(boolean r8) {
            this.wifiConnected = r8;
            return this;
        }

        public String toJsonString() {
            return toJson().toString();
        }

        public String toString() {
            return "LocationSource[source=" + this.source + ", provider=" + this.provider + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", radius=" + this.radius + ", applied=" + this.applied + ", coordSys=" + this.coordSys + ", confidence=" + this.confidence + ", updateTs=" + this.updateTs + ", elapsedRealtimeNanos=" + this.elapsedRealtimeNanos + ", locationTime=" + this.locationTime + ", simReady=" + this.simReady + ", wifiConnected=" + this.wifiConnected + ", mock=" + this.mock + ", userId=" + this.userId + ", extra=" + this.extra + ']';
        }

        public LocationSource(LocationSource r8) {
            this.source = 0;
            this.provider = "";
            this.updateTs = 0;
            this.latitude = 0.0d;
            this.longitude = 0.0d;
            this.radius = 0.0f;
            this.applied = true;
            this.coordSys = CoordinateTransformUtils.CoordinateSystem.WGS84;
            this.confidence = 0;
            this.simReady = false;
            this.wifiConnected = false;
            this.extra = new Bundle();
            this.elapsedRealtimeNanos = 0;
            this.locationTime = 0;
            this.mock = false;
            this.userId = 0;
            this.source = r8.source;
            this.provider = r8.provider;
            this.updateTs = r8.updateTs;
            this.latitude = r8.latitude;
            this.longitude = r8.longitude;
            this.radius = r8.radius;
            this.applied = r8.applied;
            this.coordSys = r8.coordSys;
            this.confidence = r8.confidence;
            this.simReady = r8.simReady;
            this.wifiConnected = r8.wifiConnected;
            this.extra = new Bundle(r8.extra);
            this.elapsedRealtimeNanos = r8.elapsedRealtimeNanos;
            this.locationTime = r8.locationTime;
            this.mock = r8.mock;
            this.userId = r8.userId;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocationSourceValue {
    }

    public static class LocationUpdateTask {
        private final LocationSource locationSource;

        private LocationUpdateTask(LocationSource r8) {
            this.locationSource = r8;
        }

        public static /* synthetic */ LocationUpdateTask access$000(LocationSource r8) {
            return fromLocationSource(r8);
        }

        public static /* synthetic */ LocationSource access$100(LocationUpdateTask r8) {
            return r8.locationSource;
        }

        private static LocationUpdateTask fromLocationSource(LocationSource r8) {
            return new LocationUpdateTask(r8);
        }
    }

    private StarLocationManager() {
        this.mLatestSourceProvider = new ConcurrentHashMap();
        this.mHistorySources = new ArrayDeque();
        this.mHistoryLock = new Object();
        this.mLocationUpdateQueueLock = new Object();
        this.mLocationUpdateQueue = new ArrayDeque();
        this.mLocationUpdateQueueExecutor = Executors.newSingleThreadExecutor(new a(0));
        this.mCacheNlpLocation = new AtomicReference(null);
        this.mLastVendorGeofenceLocation = new AtomicReference(null);
        this.mGnssEngineOn = new AtomicBoolean(false);
        this.mReceivedGnssLocation = new AtomicBoolean(false);
        this.mDroppedLocationUpdateTaskCount = new AtomicLong(0);
        this.mLocationUpdateQueueDraining = false;
    }

    public static /* synthetic */ void a(StarLocationManager r8, int r10, int r11) {
        r8.lambda$cacheNetworkLocation$1(r10, r11);
    }

    public static /* synthetic */ Thread b(Runnable r8) {
        return lambda$new$0(r8);
    }

    public static /* synthetic */ void c(LocationUpdateTask r8, InnerAwareInfoCallback r10) {
        lambda$executeLocationUpdateTask$2(r8, r10);
    }

    private boolean cacheNetworkLocation(int r8, Location r10, int r11) {
        int r12 = 0;
        if (r10.equals(this.mCacheNlpLocation.get()) == false) goto L6;
        CommSenseLog.dWithMethodName(TAG, "skip same nlp location");
        return false;
    L6:
        Location r13 = new Location(r10);
        this.mCacheNlpLocation.set(r13);
        LocationUtil.getInstance().getExecutor().submit(new c(r11, r8, r12, this));
        return true;
    }

    private void calculateAoiBoardEvent(Location r8, int r10) {
        Context r11 = this.mContext;
        if (r11 != null) goto L11;
        CommSenseLog.dWithMethodName(TAG, "skipped, context is null");
        return;
    L11:
        StarAoiBoardManager.removeFarAwayAoiGeofencesByFreshLocation(r11, r8);     // Catch: Throwable -> L8
        StarAoiBoardManager.calculateAllAoiBoardsByFreshLocation(r11, r8);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", th);
    }

    public static /* synthetic */ void d(StarLocationManager r8) {
        r8.drainLocationUpdateQueue();
    }

    private void dispatchGeofenceEventToManagers(Location r8, int r10, int r11) {
        Context r12 = this.mContext;
        if (r12 != null) goto L6;
        CommSenseLog.d(TAG, "dispatchGeofenceEventToManagers skipped, context is null");
        return;
    L6:
        int r13 = getSafeUserId(r10);
        StarGeoCallback.getInstance(r12, r13).calculateGeofenceEvent(r8, r13, r11);
        if (r13 == 0) goto L10;
        CommSenseLog.dWithMethodName(TAG, "include system geofences, currentUserId=" + r13);
        StarGeoCallback.getInstance(r12, 0).calculateGeofenceEvent(r8, r13, r11);
        return;
    }

    private void drainLocationUpdateQueue() {
    L2:
        Object r8 = this.mLocationUpdateQueueLock;
        monitor-enter(r8);
        LocationUpdateTask r10 = this.mLocationUpdateQueue.pollFirst();     // Catch: Throwable -> L14
        if (r10 == null) goto L6;
        monitor-exit(r8);     // Catch: Throwable -> L14
        executeLocationUpdateTask(r10);     // Catch: RuntimeException -> L12
    L12:
        e = move-exception;
        CommSenseLog.e(TAG, "process location update task failed", e);
        goto L2
    L6:
        this.mLocationUpdateQueueDraining = false;     // Catch: Throwable -> L14
        this.mLocationUpdateQueueLock.notifyAll();     // Catch: Throwable -> L14
        monitor-exit(r8);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void dumpLocationSource(LocationSource r8) {
        File r10 = this.mLocationFile;
        if (r10 != null) goto L11;
        CommSenseLog.dWithMethodName(TAG, "skipped, log file not initialized");
        return;
    L11:
        CommSenseLog.dumpI(TAG, r8.toJsonString(), r10);     // Catch: Throwable -> L8
        return;
    L8:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);
    }

    private void enqueueLocationUpdateTask(LocationUpdateTask r8) {
        Object r10 = this.mLocationUpdateQueueLock;
        monitor-enter(r10);
        LocationUpdateTask r11 = null;
    L18:
    L15:
        th = move-exception;
        throw th;
    L6:
        if (this.mLocationUpdateQueue.size() < 300) goto L8;
        r11 = this.mLocationUpdateQueue.removeFirst();     // Catch: Throwable -> L15
        this.mDroppedLocationUpdateTaskCount.incrementAndGet();     // Catch: Throwable -> L15
        goto L18
    L8:
        this.mLocationUpdateQueue.addLast(r8);     // Catch: Throwable -> L15
        if (this.mLocationUpdateQueueDraining == true) goto L11;
        this.mLocationUpdateQueueDraining = true;     // Catch: Throwable -> L15
        this.mLocationUpdateQueueExecutor.execute(new k(this, 15));     // Catch: Throwable -> L15
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L15
        if (r11 == null) goto L21;
        CommSenseLog.w(TAG, "location update queue overflow, drop oldest task");
        return;
    }

    private void executeLocationUpdateTask(final LocationUpdateTask r8) {
        maybeReportNlpError(LocationUpdateTask.access$100(r8));
        if (isLocationSourceValidByCellCoverage(LocationUpdateTask.access$100(r8)) == true) goto L5;
        LocationUpdateTask.access$100(r8).setApplied(false);
    L5:
        dumpLocationSource(LocationUpdateTask.access$100(r8));
        if (LocationUpdateTask.access$100(r8).isApplied() == true) goto L8;
        return;
    L8:
        UserAwareManager.getInstance().notifyInnerCallbacks(new b(r8));
        Location r10 = toLocation(LocationUpdateTask.access$100(r8));
        int r11 = LocationUpdateTask.access$100(r8).getSource();
        dispatchGeofenceEventToManagers(r10, LocationUpdateTask.access$100(r8).getUserId(), r11);
        calculateAoiBoardEvent(r10, r11);
    }

    private LocationSource findLatestPreviousBdCellSource(LocationSource r8) {
        Object r10 = this.mHistoryLock;
        monitor-enter(r10);
        Iterator<LocationSource> r11 = this.mHistorySources.iterator();     // Catch: Throwable -> L21
        LocationSource r12 = null;
    L6:
        if (r11.hasNext() == false) goto L16;
        LocationSource r13 = r11.next();     // Catch: Throwable -> L21
        if (r13.getSource() != 6) goto L6;
        if (isBeforeOrSameByTime(r13, r8) == false) goto L6;
        if (r12 == null) goto L15;
        if (isAfterByTime(r13, r12) == false) goto L6;
    L15:
        r12 = r13;
        goto L6
    L16:
        monitor-exit(r10);     // Catch: Throwable -> L21
        if (r12 != null) goto L20;
        return null;
    L20:
        return new LocationSource(r12);
    L21:
        th = move-exception;
        throw th;
    }

    private LocationSource fromLocation(int r8, Location r10, int r11) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.getExtras() != null) goto L8;
        Bundle r12 = new Bundle();
    L10:
        if (r10.hasAltitude() == false) goto L13;
        r12.putDouble(EXTRA_ALTITUDE, r10.getAltitude());
        r12.putBoolean(EXTRA_HAS_ALTITUDE, true);
    L13:
        if (r10.hasVerticalAccuracy() == false) goto L16;
        r12.putFloat(EXTRA_VERTICAL_ACCURACY_METERS, r10.getVerticalAccuracyMeters());
    L16:
        if (r10.hasSpeed() == false) goto L19;
        r12.putFloat(EXTRA_SPEED, r10.getSpeed());
    L19:
        if (r10.hasBearing() == false) goto L22;
        r12.putFloat(EXTRA_BEARING, r10.getBearing());
    L22:
        if (r10.hasSpeedAccuracy() == false) goto L25;
        r12.putFloat(EXTRA_SPEED_ACCURACY_METERS_PER_SECOND, r10.getSpeedAccuracyMetersPerSecond());
    L25:
        if (r10.hasBearingAccuracy() == false) goto L27;
        r12.putFloat(EXTRA_BEARING_ACCURACY_DEGREES, r10.getBearingAccuracyDegrees());
    L27:
        LocationSource r13 = new LocationSource().setSource(r8).setProvider(r10.getProvider()).setUpdateTs(System.currentTimeMillis()).setElapsedRealtimeNanos(r10.getElapsedRealtimeNanos()).setLocationTime(r10.getTime()).setLatitude(r10.getLatitude()).setLongitude(r10.getLongitude()).setCoordSys(CoordinateTransformUtils.CoordinateSystem.WGS84).setConfidence(getLocationConfidence(r10)).setUserId(r11).setExtra(r12);
        if (r10.hasAccuracy() == false) goto L30;
        r13.setRadius(r10.getAccuracy());
    L30:
        return r13;
    L8:
        r12 = new Bundle(r10.getExtras());
        goto L10
    }

    public static synchronized StarLocationManager getInstance() {
        monitor-enter(StarLocationManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new StarLocationManager();     // Catch: Throwable -> L10
    L7:
        StarLocationManager r8 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(StarLocationManager.class);
        return r8;
    }

    private int getSafeUserId(int r8) {
        if (r8 >= 0) goto L6;
        return 0;
    L6:
        return r8;
    }

    private boolean isAfterByTime(LocationSource r10, LocationSource r11) {
        long r8 = r10.getElapsedRealtimeNanos();
        long r12 = r11.getElapsedRealtimeNanos();
        if (r8 <= 0) goto L12;
        if (r12 <= 0) goto L12;
        if (r8 <= r12) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (r10.getUpdateTs() <= r11.getUpdateTs()) goto L15;
        return true;
    L15:
        return false;
    }

    private boolean isBeforeOrSameByTime(LocationSource r10, LocationSource r11) {
        long r8 = r10.getElapsedRealtimeNanos();
        long r12 = r11.getElapsedRealtimeNanos();
        if (r8 > 0) goto L5;
    L11:
        long r13 = r10.getUpdateTs();
        long r14 = r11.getUpdateTs();
        if (r13 <= 0) goto L19;
        if (r14 <= 0) goto L19;
        if (r13 > r14) goto L19;
        return true;
    L19:
        return false;
    L5:
        if (r12 <= 0) goto L11;
        if (r8 > r12) goto L10;
        return true;
    L10:
        return false;
    }

    private boolean isLocationSourceValidByCellCoverage(LocationSource r15) {
        if (r15.getSource() != 6) goto L6;
        return true;
    L6:
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r15.getProvider()) == false) goto L8;
        return true;
    L8:
        LocationSource r8 = findLatestPreviousBdCellSource(r15);
        if (r8 != null) goto L12;
        return true;
    L12:
        if (isValidRadius(r8.getRadius()) == true) goto L16;
        String r14 = "skipped, invalid cell location radius";
    L14:
        CommSenseLog.dWithMethodName(TAG, r14);
        return true;
    L16:
        CoordinateTransformUtils.CoordinateSystem r10 = r8.getCoordSys();
        CoordinateTransformUtils.CoordinateSystem r11 = CoordinateTransformUtils.CoordinateSystem.WGS84;
        if (r10 == r11) goto L19;
    L38:
        r14 = "skipped, inconsistent coordinate system";
        goto L14
    L19:
        if (r15.getCoordSys() != r11) goto L38;
        double r12 = LocationUtil.getInstance().calculateDistance(r8.getLatitude(), r8.getLongitude(), r15.getLatitude(), r15.getLongitude());
        if (Double.isNaN(r12) == false) goto L24;
    L37:
        r14 = "skipped, invalid location distance";
        goto L14
    L24:
        if (Double.isInfinite(r12) == true) goto L37;
        float r13 = r15.getRadius();
        if (Float.compare(r13, 0.0f) != 0) goto L29;
        r13 = 50.0f;
    L29:
        double r16 = ((double) r8.getRadius()) * CELL_COVERAGE_OUTSIDE_MULTIPLIER;
        if (isValidRadius(r13) == false) goto L33;
        r16 = Math.max(r16, r8.getRadius() + r13);
    L33:
        if (r12 > r16) goto L35;
        return true;
    L35:
        CommSenseLog.dumpI(TAG, "drop location source outside cell coverage, source=" + r15.getSource() + ", provider=" + r15.getProvider() + ", distance=" + r12 + ", cellRadius=" + r8.getRadius() + ", radius=" + r13, this.mLocationFile);
        return false;
    }

    private boolean isPassiveNetworkSource(LocationSource r8) {
        if (r8.getSource() == 1) goto L5;
    L7:
        return false;
    L5:
        if ("network".equals(r8.getProvider()) == false) goto L7;
        return true;
    }

    private boolean isSameAsLatestPreviousNetworkLocation(LocationSource r8) {
        Object r10 = this.mHistoryLock;
        monitor-enter(r10);
        Iterator<LocationSource> r11 = this.mHistorySources.descendingIterator();     // Catch: Throwable -> L20
    L6:
        if (r11.hasNext() == false) goto L17;
        LocationSource r12 = r11.next();     // Catch: Throwable -> L20
        if (r12 == r8) goto L6;
        if ("network".equals(r12.getProvider()) == false) goto L6;
        if (r12.getSource() == 6) goto L6;
        boolean r13 = r12.equals(r8);     // Catch: Throwable -> L20
        monitor-exit(r10);     // Catch: Throwable -> L20
        return r13;
    L17:
        monitor-exit(r10);     // Catch: Throwable -> L20
        return false;
    L20:
        th = move-exception;
        throw th;
    }

    private boolean isValidRadius(float r8) {
        if (r8 > 0.0f) goto L5;
    L7:
        return false;
    L5:
        if (Float.isInfinite(r8) == true) goto L7;
        return true;
    }

    private /* synthetic */ void lambda$cacheNetworkLocation$1(int r8, int r10) {
        Thread.sleep(3000);     // Catch: InterruptedException -> L5
    L8:
        if (this.mGnssEngineOn.get() == true) goto L10;
    L13:
        Location r11 = this.mCacheNlpLocation.get();
        if (r11 != null) goto L17;
        CommSenseLog.dWithMethodName(TAG, "skip null cached nlp location");
        return;
    L17:
        CommSenseLog.vWithMethodName(TAG, "network location cache dispatch, userId=" + r8);
        updateLatestInternal(r10, r11, r8);
        return;
    L10:
        if (this.mReceivedGnssLocation.get() == false) goto L13;
        CommSenseLog.dWithMethodName(TAG, "skip cached nlp location while gnss on");
        return;
    L5:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "sleep interrupted", e);
        goto L8
    }

    private static /* synthetic */ void lambda$executeLocationUpdateTask$2(LocationUpdateTask r8, InnerAwareInfoCallback r10) {
        r10.onLocationSourceChanged(new LocationSource(LocationUpdateTask.access$100(r8)));
    }

    private static /* synthetic */ Thread lambda$new$0(Runnable r8) {
        return new Thread(r8, "StarLocationUpdateQueue");
    }

    private void maybeReportNlpError(LocationSource r14) {
        CommSenseLog.iWithMethodName(TAG, "start");
        if (isPassiveNetworkSource(r14) == true) goto L6;
        return;
    L6:
        if (isSameAsLatestPreviousNetworkLocation(r14) == false) goto L9;
        CommSenseLog.dWithMethodName(TAG, "skipped, same as latest previous network location");
        return;
    L9:
        CommSenseLog.iWithMethodName(TAG, "find nlp location");
        LocationSource r8 = findLatestPreviousBdCellSource(r14);
        if (r8 != null) goto L12;
        return;
    L12:
        CommSenseLog.iWithMethodName(TAG, "find cell location");
        if (isValidRadius(r8.getRadius()) == true) goto L15;
    L37:
        CommSenseLog.dWithMethodName(TAG, "skipped, invalid location radius");
        return;
    L15:
        if (isValidRadius(r14.getRadius()) == false) goto L37;
        if (isBeforeOrSameByTime(r8, r14) == true) goto L21;
        CommSenseLog.dWithMethodName(TAG, "skipped, cell location is later than nlp location");
        return;
    L21:
        CoordinateTransformUtils.CoordinateSystem r10 = r8.getCoordSys();
        CoordinateTransformUtils.CoordinateSystem r11 = CoordinateTransformUtils.CoordinateSystem.WGS84;
        if (r10 == r11) goto L24;
    L35:
        CommSenseLog.dWithMethodName(TAG, "skipped, inconsistent coordinate system");
        return;
    L24:
        if (r14.getCoordSys() != r11) goto L35;
        double r12 = LocationUtil.getInstance().calculateDistance(r8.getLatitude(), r8.getLongitude(), r14.getLatitude(), r14.getLongitude());
        if (Double.isNaN(r12) == false) goto L29;
    L33:
        CommSenseLog.dWithMethodName(TAG, "skipped, invalid location distance");
        return;
    L29:
        if (Double.isInfinite(r12) == true) goto L33;
        int r13 = resolveNlpValidCode(r8, r14, r12);
        CommSenseLog.iWithMethodName(TAG, "nlpValidCode: " + r13);
        StarLocationTeaReporter.reportNlpError(r8, r14, r13, r12);
    }

    private boolean processLocationSource(LocationSource r11, boolean r12) {
        LocationSource r8 = new LocationSource(r11);
        if (r8.getSource() != 6) goto L5;
        r8.setApplied(false);
    L5:
        Object r13 = this.mHistoryLock;
        monitor-enter(r13);
        long r10 = r8.getElapsedRealtimeNanos();     // Catch: Throwable -> L55
        if (r10 <= 0) goto L20;
        Iterator<LocationSource> r14 = this.mHistorySources.descendingIterator();     // Catch: Throwable -> L55
    L11:
        if (r14.hasNext() == false) goto L20;
        long r15 = r14.next().getElapsedRealtimeNanos();     // Catch: Throwable -> L55
        if (r15 <= 0) goto L11;
        if (r10 >= r15) goto L20;
        CommSenseLog.dWithMethodName(TAG, "drop elapsed realtime rollback location source, source=" + r8.getSource() + ", provider=" + r8.getProvider() + ", elapsedRealtimeNanos=" + r10 + ", latestElapsedRealtimeNanos=" + r15);     // Catch: Throwable -> L55
        monitor-exit(r13);     // Catch: Throwable -> L55
        return false;
    L20:
        long r16 = r8.getLocationTime();     // Catch: Throwable -> L55
        if (r16 <= 0) goto L41;
        Iterator<LocationSource> r17 = this.mHistorySources.descendingIterator();     // Catch: Throwable -> L55
    L24:
        if (r17.hasNext() == false) goto L33;
        long r18 = r17.next().getLocationTime();     // Catch: Throwable -> L55
        if (r18 <= 0) goto L24;
        if (r16 >= r18) goto L33;
        CommSenseLog.dWithMethodName(TAG, "drop location time rollback location source, source=" + r8.getSource() + ", provider=" + r8.getProvider() + ", locationTime=" + r16 + ", latestLocationTime=" + r18);     // Catch: Throwable -> L55
        monitor-exit(r13);     // Catch: Throwable -> L55
        return false;
    L33:
        Iterator<LocationSource> r19 = this.mHistorySources.iterator();     // Catch: Throwable -> L55
    L35:
        if (r19.hasNext() == false) goto L41;
        if (r19.next().getLocationTime() != r16) goto L35;
        CommSenseLog.dWithMethodName(TAG, "drop duplicate location source, source=" + r8.getSource() + ", provider=" + r8.getProvider() + ", locationTime=" + r16);     // Catch: Throwable -> L55
        monitor-exit(r13);     // Catch: Throwable -> L55
        return false;
    L41:
        this.mLatestSourceProvider.put(r8.getProvider(), r8);     // Catch: Throwable -> L55
        this.mHistorySources.addLast(r8);     // Catch: Throwable -> L55
    L43:
        if (this.mHistorySources.size() <= 100) goto L45;
        this.mHistorySources.removeFirst();     // Catch: Throwable -> L55
        goto L43
    L45:
        monitor-exit(r13);     // Catch: Throwable -> L55
        LocationUpdateTask r110 = LocationUpdateTask.access$000(r8);
        if (r12 == true) goto L58;
        enqueueLocationUpdateTask(r110);
        return true;
    L58:
        executeLocationUpdateTask(r110);     // Catch: RuntimeException -> L50
        return true;
    L50:
        e = move-exception;
        CommSenseLog.e(TAG, "process replay location update task failed", e);
        return true;
    L55:
        th = move-exception;
        throw th;
    }

    private boolean processSameLocation(LocationSource r8) {
        if (this.mContext != null) goto L6;
        CommSenseLog.dWithMethodName(TAG, "skipped, context is null");
        return false;
    L6:
        boolean r10 = StarGeofenceManager.getInstance(this.mContext, r8.getUserId()).hasUnknownStateGeofence(r8.getUserId());
        boolean r11 = StarAoiBoardManager.getInstance(this.mContext, r8.getUserId()).hasUnknownStateAoiBoards();
        if (r10 == true) goto L13;
        if (r11 == true) goto L13;
        CommSenseLog.vWithMethodName(TAG, "ignore same location");
        return false;
    L13:
        return processLocationSource(r8, false);
    }

    private int resolveGpsLocationConfidenceLevel(Location r8) {
        float r10 = r8.getAccuracy();
        if (r10 > 0.0f) goto L7;
        return 0;
    L7:
        if (r10 <= 0.0f) goto L13;
        if (r10 > 20.0f) goto L13;
        return 5;
    L13:
        if (r10 > 50.0f) goto L17;
        return 4;
    L17:
        if (r10 > MEDIUM_CONFIDENCE_GPS_ACCURACY_THRESHOLD) goto L20;
        return 3;
    L20:
        return 1;
    }

    private int resolveNetworkLocationConfidenceLevel(Location r8) {
        float r10 = r8.getAccuracy();
        if (r10 > 0.0f) goto L5;
        return 0;
    L5:
        boolean r11 = LocationUtil.getInstance().isDisableNlpWifiCache();
        if (r10 <= 0.0f) goto L13;
        if (r10 > HIGH_CONFIDENCE_NETWORK_ACCURACY_THRESHOLD) goto L13;
        if (r11 == false) goto L22;
        return 4;
    L22:
        return 3;
    L13:
        if (r10 > MEDIUM_CONFIDENCE_NETWORK_ACCURACY_THRESHOLD) goto L19;
        if (r11 == true) goto L23;
        return 1;
    L23:
        return 3;
    L19:
        if (r10 > LOW_CONFIDENCE_NETWORK_ACCURACY_THRESHOLD) goto L21;
        return r11 ? 1 : 0;
    L21:
        return 0;
    }

    private int resolveNlpValidCode(LocationSource r8, LocationSource r10, double r11) {
        float r12 = r8.getRadius();
        double r13 = r12;
        if (r11 <= (CELL_COVERAGE_OUTSIDE_MULTIPLIER * r13)) goto L9;
        if (r10.getRadius() <= r12) goto L7;
        return 3;
    L7:
        return 2;
    L9:
        if (r11 <= r13) goto L11;
        return 1;
    L11:
        return 0;
    }

    private boolean skipSameVendorGeofenceLocation(Location r8) {
        Location r10 = this.mLastVendorGeofenceLocation.getAndSet(new Location(r8));
        if (LocationUtil.getInstance().isSameLocation(r8, r10) == false) goto L6;
        CommSenseLog.vWithMethodName(TAG, "skip same vendor geofence location");
        return true;
    L6:
        return false;
    }

    private Location toLocation(LocationSource r8) {
        Location r10 = new Location(r8.getProvider());
        r10.setLatitude(r8.getLatitude());
        r10.setLongitude(r8.getLongitude());
        if (r8.getRadius() <= 0.0f) goto L6;
        r10.setAccuracy(r8.getRadius());
    L6:
        if (r8.getElapsedRealtimeNanos() <= 0) goto L9;
        r10.setElapsedRealtimeNanos(r8.getElapsedRealtimeNanos());
    L9:
        if (r8.getLocationTime() <= 0) goto L11;
        r10.setTime(r8.getLocationTime());
    L11:
        Bundle r11 = r8.getExtra();
        r11.putInt(EXTRA_LOCATION_CONFIDENCE, r8.getConfidence());
        r10.setExtras(r11);
        if (r11.containsKey(EXTRA_ALTITUDE) == false) goto L15;
        r10.setAltitude(r11.getDouble(EXTRA_ALTITUDE));
    L15:
        if (r11.containsKey(EXTRA_VERTICAL_ACCURACY_METERS) == false) goto L18;
        r10.setVerticalAccuracyMeters(r11.getFloat(EXTRA_VERTICAL_ACCURACY_METERS));
    L18:
        if (r11.containsKey(EXTRA_SPEED) == false) goto L21;
        r10.setSpeed(r11.getFloat(EXTRA_SPEED));
    L21:
        if (r11.containsKey(EXTRA_BEARING) == false) goto L24;
        r10.setBearing(r11.getFloat(EXTRA_BEARING));
    L24:
        if (r11.containsKey(EXTRA_SPEED_ACCURACY_METERS_PER_SECOND) == false) goto L27;
        r10.setSpeedAccuracyMetersPerSecond(r11.getFloat(EXTRA_SPEED_ACCURACY_METERS_PER_SECOND));
    L27:
        if (r11.containsKey(EXTRA_BEARING_ACCURACY_DEGREES) == false) goto L29;
        r10.setBearingAccuracyDegrees(r11.getFloat(EXTRA_BEARING_ACCURACY_DEGREES));
    L29:
        r10.setMock(r8.isMock());
        return r10;
    }

    private boolean updateLatestInternal(int r8, Location r10, int r11) {
        LocationSource r12 = fromLocation(r8, r10, r11);
        if (r12 != null) goto L6;
        return false;
    L6:
        LocationUtil r13 = LocationUtil.getInstance();
        r12.setSimReady(r13.isSimReady()).setWifiConnected(r13.isWifiConnected()).setMock(r10.isMock());
        return updateLatest(r12);
    }

    public void clear() {
        this.mLatestSourceProvider.clear();
        Object r8 = this.mHistoryLock;
        monitor-enter(r8);
        this.mHistorySources.clear();     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Location copyLocationWithConfidence(Location r8) {
        Location r10 = new Location(r8);
        if (r8.getExtras() == null) goto L5;
        Bundle r11 = new Bundle(r8.getExtras());
    L6:
        int r12 = getLocationConfidence(r8);
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r8.getProvider()) == false) goto L10;
        r12 = resolveGpsLocationConfidenceLevel(r8);
    L12:
        r11.putInt(EXTRA_LOCATION_CONFIDENCE, r12);
        r10.setExtras(r11);
        return r10;
    L10:
        if ("network".equals(r8.getProvider()) == false) goto L12;
        r12 = resolveNetworkLocationConfidenceLevel(r8);
        goto L12
    L5:
        r11 = new Bundle();
        goto L6
    }

    public int downgradeConfidence(int r8) {
        if (r8 != 3) goto L5;
        return 1;
    L5:
        if (r8 != 4) goto L7;
        return 3;
    L7:
        if (r8 == 5) goto L10;
        return 0;
    L10:
        return 4;
    }

    public int downgradeConfidenceAfterLargeMovement(int r8) {
        if (r8 < 3) goto L5;
        return 1;
    L5:
        return 0;
    }

    public LocationSource getLastLocationSource() {
        Object r8 = this.mHistoryLock;
        monitor-enter(r8);
        LocationSource r10 = this.mHistorySources.peekLast();     // Catch: Throwable -> L10
        if (r10 != null) goto L7;
        LocationSource r11 = null;
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L10
        return r11;
    L7:
        r11 = new LocationSource(r10);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public LocationSource getLatest(String r8) {
        LocationSource r10 = this.mLatestSourceProvider.get(r8);
        if (r10 != null) goto L6;
        return null;
    L6:
        return new LocationSource(r10);
    }

    public Map<String, LocationSource> getLatestSnapshot() {
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator<Map.Entry<String, LocationSource>> r10 = this.mLatestSourceProvider.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        Map.Entry<String, LocationSource> r11 = r10.next();
        r8.put(r11.getKey(), new LocationSource(r11.getValue()));
        goto L4
    L7:
        return Collections.unmodifiableMap(r8);
    }

    public int getLocationConfidence(Location r8) {
        if (r8 != null) goto L5;
        return 0;
    L5:
        Bundle r10 = r8.getExtras();
        if (r10 != null) goto L8;
    L11:
        String r11 = r8.getProvider();
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r11) == false) goto L16;
        return resolveGpsLocationConfidenceLevel(r8);
    L16:
        if ("network".equals(r11) == true) goto L18;
        return 0;
    L18:
        return resolveNetworkLocationConfidenceLevel(r8);
    L8:
        if (r10.containsKey(EXTRA_LOCATION_CONFIDENCE) == false) goto L11;
        return r10.getInt(EXTRA_LOCATION_CONFIDENCE, 0);
    }

    public synchronized void initLogFile(Context r8) {
        monitor-enter(this);
        if (r8 != null) goto L8;
        CommSenseLog.d(TAG, "initLogFile skipped, context is null");     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L8:
        Context r10 = r8.getApplicationContext();     // Catch: Throwable -> L19
        if (r10 == null) goto L12;
        r8 = r10;
    L12:
        this.mContext = r8;     // Catch: Throwable -> L19
        File r11 = new File(LocationUtil.getInstance().getStarDir(r8), STR_LOCATION_FILE_NAME);     // Catch: Throwable -> L15 Throwable -> L19
        r11.delete();     // Catch: Throwable -> L15 Throwable -> L19
        r11.createNewFile();     // Catch: Throwable -> L15 Throwable -> L19
        this.mLocationFile = r11;     // Catch: Throwable -> L15 Throwable -> L19
        CommSenseLog.d(TAG, "initLogFile, file: " + this.mLocationFile);     // Catch: Throwable -> L15 Throwable -> L19
        CommSenseLog.recordFileWithKey(CommSenseLog.KEY_FILE_LOCATION, this.mLocationFile);     // Catch: Throwable -> L15 Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L15:
        e = move-exception;
        CommSenseLog.e(TAG, "initLogFile failed", e);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public synchronized void initOnce(Context r8) {
        monitor-enter(this);
        initLogFile(r8);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean replayLocationSource(LocationSource r8) {
        return processLocationSource(r8, true);
    }

    public void setGnssEngineOn(boolean r8) {
        boolean r10 = this.mGnssEngineOn.getAndSet(r8);
        if (r8 == false) goto L5;
        if (r10 == false) goto L5;
        return;
    L5:
        this.mReceivedGnssLocation.set(false);
    }

    public boolean updateLatest(int r8, Location r10, int r11) {
        CommSenseLog.dWithMethodName(TAG, "updateLatest source=" + r8 + ", location=" + r10);
        if (r8 != 2) goto L8;
        if (skipSameVendorGeofenceLocation(r10) == false) goto L8;
        return false;
    L8:
        if (5 != r8) goto L12;
        return updateLatestInternal(r8, r10, r11);
    L12:
        if ("network".equals(r10.getProvider()) == false) goto L22;
        if (this.mGnssEngineOn.get() == false) goto L20;
        if (this.mReceivedGnssLocation.get() == false) goto L20;
        CommSenseLog.dWithMethodName(TAG, "skip nlp location while gnss on and gps received");
        return false;
    L20:
        return cacheNetworkLocation(r8, r10, r11);
    L22:
        if (this.mGnssEngineOn.get() == false) goto L27;
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r10.getProvider()) == false) goto L27;
        this.mReceivedGnssLocation.set(true);
    L27:
        return updateLatestInternal(r8, r10, r11);
    }

    public boolean updateLatest(LocationSource r8) {
        LocationSource r10 = this.mLatestSourceProvider.get(r8.getProvider());
        if (r10 == null) goto L9;
        if (r10.equals(r8) == false) goto L9;
        return processSameLocation(r8);
    L9:
        return processLocationSource(r8, false);
    }
}
