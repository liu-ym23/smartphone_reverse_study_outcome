package com.obric.cae.location.zpp;

import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.activity.k;
import com.google.protobuf.d;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.useraware.CellAwareInfo;
import com.obric.cae.libs.useraware.GnssSvAwareInfo;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.location.geofence.StarGeoCallback;
import com.obric.cae.location.geofence.StarGeofenceManager;
import com.obric.cae.location.report.StarLocationReportBase;
import com.obric.cae.location.report.StarLocationReportFactory;
import com.obric.cae.location.report.StarLocationTeaReporter;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.utils.AIKernelJavaBridge;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import xd.j;

/* JADX INFO: loaded from: classes.dex */
public class StarZppManager {
    public static final String BUNDLE_KEY_ZPP_CONFIDENCE = "zpp_confidence";
    private static final String CAE_ZPP_NAME = "cae_zpp";
    public static final List<String> FEATURE_COLUMNS = null;
    private static final String FEATURE_KEY_CELL_ID_CHANGED = "cell_id_changed";
    private static final String FEATURE_KEY_CELL_RSSI_DELTA = "cell_rssi_delta";
    private static final String FEATURE_KEY_ENGINE_STATUS_AVAILABLE = "engine_status_available";
    private static final String FEATURE_KEY_ENGINE_STATUS_UNAVAILABLE = "engine_status_unavailable";
    private static final String FEATURE_KEY_GEOFENCE_DYNAMIC_PRESENT = "geofence_dynamic_present";
    private static final String FEATURE_KEY_GEOFENCE_IS_COMPANY = "geofence_is_company";
    private static final String FEATURE_KEY_GEOFENCE_IS_HOME = "geofence_is_home";
    private static final String FEATURE_KEY_HAR_STATE_ACCELERATING = "har_state_ACCELERATING";
    private static final String FEATURE_KEY_HAR_STATE_STILL = "har_state_STILL";
    private static final String FEATURE_KEY_HAR_STATE_VEHICLE = "har_state_VEHICLE";
    private static final String FEATURE_KEY_HAR_STATE_WALKING = "har_state_WALKING";
    private static final String FEATURE_KEY_LAST_FIX_ACCURACY = "last_fix_accuracy";
    private static final String FEATURE_KEY_LAST_FIX_IS_GPS = "last_fix_is_gps";
    private static final String FEATURE_KEY_STEPS_SINCE_LAST_FIX = "steps_since_last_fix";
    private static final String FEATURE_KEY_TIME_SINCE_LAST_FIX = "time_since_last_fix";
    private static final String FEATURE_KEY_USER_AWARE_AT_COMPANY = "user_aware_at_company";
    private static final String FEATURE_KEY_USER_AWARE_AT_HOME = "user_aware_at_home";
    private static final String FEATURE_KEY_USER_AWARE_ON_THE_WAY = "user_aware_on_the_way";
    private static final String FEATURE_KEY_VISIBLE_SVS = "visible_svs";
    private static final String FEATURE_KEY_VISIBLE_SVS_MEAN_CN0 = "visible_svs_mean_cn0";
    private static final String FEATURE_KEY_WIFI_CONNECTED_ANY = "wifi_connected_any";
    private static final String FEATURE_KEY_WIFI_JACCARD_INDEX = "wifi_jaccard_index";
    private static final String FEATURE_KEY_WIFI_RSSI_MEAN = "wifi_rssi_mean";
    private static final String FEATURE_KEY_WIFI_VISIBLE_COUNT = "wifi_visible_count";
    private static final long INFERENCE_DEBOUNCE_DELAY_MS = 2000;
    private static final long INFERENCE_DEBOUNCE_DELAY_MS_MAX = 10000;
    private static final long PROVIDER_INFERENCE_CACHE_VALID_MS = 10000;
    private static final String STR_ZPP_FILE_NAME = "star_zpp.txt";
    private static final String TAG = "StarLocation-zpp";
    private static final long TIME_TOLERANCE_MS_LONG = 60000;
    private static final long TIME_TOLERANCE_MS_SHORT = 30000;
    private static final long UPDATE_INFERENCE_DELAY_MS_MAX = 60000;
    public static final String ZPP_CLOUD_ENABLE = "zpp_cloud_enable";
    private static final String ZPP_CONFIDENCE_HIGH = "high";
    private static final String ZPP_CONFIDENCE_LOW = "low";
    private static final String ZPP_CONFIDENCE_MEDIUM = "medium";
    private static final String ZPP_CONFIDENCE_ZERO = "zero";
    public static final String ZPP_MODEL_INFER_STRATEGY = "zpp_model_infer_strategy";
    private static final int ZPP_MODEL_INFER_STRATEGY_HIGH = 2;
    private static final int ZPP_MODEL_INFER_STRATEGY_LOW = 0;
    private static final int ZPP_MODEL_INFER_STRATEGY_MAX = 3;
    private static final int ZPP_MODEL_INFER_STRATEGY_MEDIUM = 1;
    private static final int ZPP_MODEL_PRELOAD_SECONDS = 60;
    private static final ConcurrentHashMap<Integer, StarZppManager> sInstances = null;
    private final Context mContext;
    private Set<String> mCurrentBssidSet;
    private CellAwareInfo mCurrentCellInfo;
    private int mCurrentEngineStatus;
    private float mCurrentStepCount;
    private String mCurrentUserAwareChangeState;
    private boolean mCurrentWifiConnectedAny;
    private float mCurrentWifiRssiMean;
    private int mCurrentWifiVisibleCount;
    private final Map<Integer, Long> mHarStatusTimestampMap;
    private Handler mInferenceHandler;
    private HandlerThread mInferenceHandlerThread;
    private final InnerZppLocation mInnerZppLocation;
    private final AtomicBoolean mIsHarSupported;
    private final AtomicBoolean mIsLocationStateSupported;
    protected final AtomicBoolean mIsModelLoaded;
    private final AtomicBoolean mIsZppRunning;
    private Set<String> mLastBssidSetAtFix;
    private CellAwareInfo mLastCellInfoAtFix;
    private long mLastCheckModelRunTimestamp;
    private WifiStandardData mLastConnectedWifi;
    private GnssSvAwareInfo mLastGnssState;
    private int mLastHarStatus;
    private long mLastInferenceTimestamp;
    private float mLastStepsAtFix;
    private int mModelInferStrategy;
    protected String mModelVersion;
    private final Map<String, InferenceCache> mProviderInferenceCacheMap;
    private final Map<String, Object> mProviderInferenceLockMap;
    private final int mUserId;
    private float mZppConfidence;
    private float[] mZppFeatures;
    private File mZppFile;
    private final ZppInnerCallback mZppInnerCallback;

    /* JADX INFO: renamed from: com.obric.cae.location.zpp.StarZppManager$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType = null;

        static {
            int[] r8 = new int[StarGeofence.GeoType.values().length];
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType = r8;
            r8[StarGeofence.GeoType.HOME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType[StarGeofence.GeoType.COMPANY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType[StarGeofence.GeoType.INDOOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class InferenceCache {
        private final float confidence;
        private final float[] features;
        private final long timestamp;

        public InferenceCache(long r8, float r10, float[] r11) {
            this.timestamp = r8;
            this.confidence = r10;
            if (r11 != null) goto L5;
            float[] r12 = null;
        L6:
            this.features = r12;
            return;
        L5:
            r12 = Arrays.copyOf(r11, r11.length);
            goto L6
        }

        public static /* synthetic */ long access$1900(InferenceCache r8) {
            return r8.timestamp;
        }

        public static /* synthetic */ float access$2000(InferenceCache r8) {
            return r8.confidence;
        }

        public static /* synthetic */ float[] access$2100(InferenceCache r8) {
            return r8.features;
        }
    }

    public static class InnerStarZppData {
        private float confidence;
        private float distance;
        private float[] featureArray;
        private String modelVersion;
        private long timestamp;

        public InnerStarZppData(String r8) {
            this.modelVersion = r8;
        }

        public float getConfidence() {
            return this.confidence;
        }

        public float getDistance() {
            return this.distance;
        }

        public List<Float> getFeatureArray() {
            float[] r8 = this.featureArray;
            if (r8 == null) goto L12;
            if (r8.length == 0) goto L12;
            ArrayList r10 = new ArrayList(this.featureArray.length);
            float[] r11 = this.featureArray;
            int r12 = r11.length;
            int r13 = 0;
        L8:
            if (r13 >= r12) goto L10;
            r10.add(Float.valueOf(r11[r13]));
            r13 = r13 + 1;
            goto L8
        L10:
            return r10;
        L12:
            return Collections.emptyList();
        }

        public String getModelVersion() {
            return this.modelVersion;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public InnerStarZppData setConfidence(float r8) {
            this.confidence = r8;
            return this;
        }

        public InnerStarZppData setDistance(float r8) {
            this.distance = r8;
            return this;
        }

        public InnerStarZppData setFeatureArray(float[] r8) {
            this.featureArray = r8;
            return this;
        }

        public InnerStarZppData setTimestamp(long r8) {
            this.timestamp = r8;
            return this;
        }

        public String toString() {
            return "InnerStarZppData{" + this.modelVersion + ", " + this.timestamp + ", " + this.confidence + ", " + Arrays.toString(this.featureArray) + ", " + this.distance + '}';
        }
    }

    public class InnerZppLocation {
        private long lastFixTimestamp;
        private Location lastGlpLocation;
        private long lastGlpTimestamp;
        private Location lastNlpLocation;
        private long lastNlpTimestamp;
        private Location lastZppLocation;
        private final Object mLock;
        final /* synthetic */ StarZppManager this$0;

        public InnerZppLocation(StarZppManager r8) {
            this.this$0 = r8;
            this.mLock = new Object();
            this.lastFixTimestamp = 0;
            this.lastZppLocation = null;
            this.lastNlpTimestamp = 0;
            this.lastGlpTimestamp = 0;
            this.lastNlpLocation = null;
            this.lastGlpLocation = null;
        }

        private Location copyLocation(Location r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            return new Location(r8);
        }

        private void updateLastZppLocation(String r10) {
            if (StarZppManager.access$300(this.this$0) >= 1) goto L5;
        L7:
            Object r11 = this.mLock;
            monitor-enter(r11);
            Location r8 = copyLocation(this.lastZppLocation);     // Catch: Throwable -> L32
            if (this.lastNlpLocation == null) goto L20;
            long r12 = this.lastNlpTimestamp;     // Catch: Throwable -> L32
            if ((r12 - this.lastGlpTimestamp) < 60000) goto L20;
            this.lastFixTimestamp = r12;     // Catch: Throwable -> L32
            if (LocationUtil.getInstance().isSameLocation(this.lastNlpLocation, this.lastZppLocation) == false) goto L18;
            monitor-exit(r11);     // Catch: Throwable -> L32
            return;
        L18:
            Location r13 = copyLocation(this.lastNlpLocation);     // Catch: Throwable -> L32
        L19:
            this.lastZppLocation = r13;     // Catch: Throwable -> L32
            Location r14 = copyLocation(this.lastZppLocation);     // Catch: Throwable -> L32
            if (r14 != null) goto L29;
            monitor-exit(r11);     // Catch: Throwable -> L32
            return;
        L29:
            monitor-exit(r11);     // Catch: Throwable -> L32
            StarZppManager.access$2500(this.this$0, r8, r14);
            return;
        L20:
            this.lastFixTimestamp = this.lastGlpTimestamp;     // Catch: Throwable -> L32
            if (LocationUtil.getInstance().isSameLocation(this.lastGlpLocation, this.lastZppLocation) == false) goto L24;
            monitor-exit(r11);     // Catch: Throwable -> L32
            return;
        L24:
            r13 = copyLocation(this.lastGlpLocation);     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            throw th;
        L5:
            if ((System.currentTimeMillis() - StarZppManager.access$2200(this.this$0)) < 60000) goto L7;
            StarZppManager r15 = this.this$0;
            StarZppManager.access$2302(r15, StarZppManager.access$2400(r15, r10, false));
            goto L7
        }

        public void clear() {
            Object r8 = this.mLock;
            monitor-enter(r8);
            this.lastNlpTimestamp = 0;     // Catch: Throwable -> L8
            this.lastGlpTimestamp = 0;     // Catch: Throwable -> L8
            this.lastFixTimestamp = 0;     // Catch: Throwable -> L8
            this.lastNlpLocation = null;     // Catch: Throwable -> L8
            this.lastGlpLocation = null;     // Catch: Throwable -> L8
            this.lastZppLocation = null;     // Catch: Throwable -> L8
            monitor-exit(r8);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public Location getBestLocation() {
            Object r8 = this.mLock;
            monitor-enter(r8);
            Location r10 = copyLocation(this.lastZppLocation);     // Catch: Throwable -> L7
            monitor-exit(r8);     // Catch: Throwable -> L7
            return r10;
        L7:
            th = move-exception;
            throw th;
        }

        public long getLastFixTimestamp() {
            Object r8 = this.mLock;
            monitor-enter(r8);
            long r10 = this.lastFixTimestamp;     // Catch: Throwable -> L7
            monitor-exit(r8);     // Catch: Throwable -> L7
            return r10;
        L7:
            th = move-exception;
            throw th;
        }

        public Location getLastGlpLocation() {
            Object r8 = this.mLock;
            monitor-enter(r8);
            Location r10 = copyLocation(this.lastGlpLocation);     // Catch: Throwable -> L7
            monitor-exit(r8);     // Catch: Throwable -> L7
            return r10;
        L7:
            th = move-exception;
            throw th;
        }

        public long getLastGlpTimestamp() {
            Object r8 = this.mLock;
            monitor-enter(r8);
            long r10 = this.lastGlpTimestamp;     // Catch: Throwable -> L7
            monitor-exit(r8);     // Catch: Throwable -> L7
            return r10;
        L7:
            th = move-exception;
            throw th;
        }

        public Location getLastLocation(String r8) {
            Object r10 = this.mLock;
            monitor-enter(r10);
        L17:
            th = move-exception;
            throw th;
        L5:
            if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r8) == false) goto L10;
            Location r11 = copyLocation(this.lastGlpLocation);     // Catch: Throwable -> L17
            monitor-exit(r10);     // Catch: Throwable -> L17
            return r11;
        L10:
            if ("network".equals(r8) == false) goto L14;
            Location r12 = copyLocation(this.lastNlpLocation);     // Catch: Throwable -> L17
            monitor-exit(r10);     // Catch: Throwable -> L17
            return r12;
        L14:
            Location r13 = copyLocation(this.lastZppLocation);     // Catch: Throwable -> L17
            monitor-exit(r10);     // Catch: Throwable -> L17
            return r13;
        }

        public Location getLastNlpLocation() {
            Object r8 = this.mLock;
            monitor-enter(r8);
            Location r10 = copyLocation(this.lastNlpLocation);     // Catch: Throwable -> L7
            monitor-exit(r8);     // Catch: Throwable -> L7
            return r10;
        L7:
            th = move-exception;
            throw th;
        }

        public long getLastNlpTimestamp() {
            Object r8 = this.mLock;
            monitor-enter(r8);
            long r10 = this.lastNlpTimestamp;     // Catch: Throwable -> L7
            monitor-exit(r8);     // Catch: Throwable -> L7
            return r10;
        L7:
            th = move-exception;
            throw th;
        }

        public void setLastGlpLocation(long r8, Location r10) {
            Object r11 = this.mLock;
            monitor-enter(r11);
            this.lastGlpTimestamp = r8;     // Catch: Throwable -> L8
            this.lastGlpLocation = copyLocation(r10);     // Catch: Throwable -> L8
            monitor-exit(r11);     // Catch: Throwable -> L8
            updateLastZppLocation(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void setLastNlpLocation(long r8, Location r10) {
            Object r11 = this.mLock;
            monitor-enter(r11);
            this.lastNlpTimestamp = r8;     // Catch: Throwable -> L8
            this.lastNlpLocation = copyLocation(r10);     // Catch: Throwable -> L8
            monitor-exit(r11);     // Catch: Throwable -> L8
            updateLastZppLocation("network");
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public long getLastFixTimestamp(String r8) {
            Object r10 = this.mLock;
            monitor-enter(r10);
        L17:
            th = move-exception;
            throw th;
        L5:
            if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r8) == false) goto L10;
            long r11 = this.lastGlpTimestamp;     // Catch: Throwable -> L17
            monitor-exit(r10);     // Catch: Throwable -> L17
            return r11;
        L10:
            if ("network".equals(r8) == false) goto L14;
            long r12 = this.lastNlpTimestamp;     // Catch: Throwable -> L17
            monitor-exit(r10);     // Catch: Throwable -> L17
            return r12;
        L14:
            long r13 = this.lastFixTimestamp;     // Catch: Throwable -> L17
            monitor-exit(r10);     // Catch: Throwable -> L17
            return r13;
        }
    }

    public class ZppInnerCallback extends InnerAwareInfoCallback {
        final /* synthetic */ StarZppManager this$0;

        public ZppInnerCallback(StarZppManager r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onCellInfoChanged(CellAwareInfo r8) {
            CommSenseLog.v(StarZppManager.TAG, "onCellInfoChanged: " + r8);
            StarZppManager.access$1602(this.this$0, r8);
            if (StarZppManager.access$300(this.this$0) < 2) goto L6;
            StarZppManager.access$400(this.this$0);
            return;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onCellNeighborInfoChanged(List<CellAwareInfo> r8) {
            CommSenseLog.d(StarZppManager.TAG, "onCellNeighborInfoChanged: " + r8);
            if (StarZppManager.access$300(this.this$0) < 2) goto L6;
            StarZppManager.access$400(this.this$0);
            return;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onEngineStatusChanged(int r8) {
            CommSenseLog.v(StarZppManager.TAG, "onEngineStatusChanged: " + r8);
            StarZppManager.access$1002(this.this$0, r8);
            if (StarZppManager.access$300(this.this$0) < 2) goto L6;
            StarZppManager.access$400(this.this$0);
            return;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onGeofenceInfoChange(StarGeofence r8, Location r10) {
            CommSenseLog.d(StarZppManager.TAG, "onGeofenceInfoChange: " + r8);
            if (StarZppManager.access$300(this.this$0) < 2) goto L6;
            StarZppManager.access$400(this.this$0);
            return;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onGnssSvInfoChanged(GnssSvAwareInfo r8) {
            if (r8 != null) goto L4;
            return;
        L4:
            CommSenseLog.v(StarZppManager.TAG, "onGnssSvInfoChanged: " + r8);
            StarZppManager.access$1802(this.this$0, r8);
            if (StarZppManager.access$300(this.this$0) < 2) goto L8;
            StarZppManager.access$400(this.this$0);
            return;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onHAREnableValueChange(int r8) {
            CommSenseLog.d(StarZppManager.TAG, "onHAREnableValueChange: " + r8);
            AtomicBoolean r10 = StarZppManager.access$1300(this.this$0);
            boolean r11 = true;
            if (r8 == 1) goto L6;
            r11 = false;
        L6:
            r10.set(r11);
            if (StarZppManager.access$300(this.this$0) < 2) goto L10;
            StarZppManager.access$400(this.this$0);
            return;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onHARStatusChanged(int r8, long r10) {
            CommSenseLog.d(StarZppManager.TAG, "onHARStatusChanged: " + r8);
            StarZppManager.access$1402(this.this$0, r8);
            StarZppManager.access$1500(this.this$0).put(Integer.valueOf(r8), Long.valueOf(r10));
            if (StarZppManager.access$300(this.this$0) < 2) goto L6;
            StarZppManager.access$400(this.this$0);
            return;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onLocationChanged(Location r8) {
            if ("passive".equals(r8.getProvider()) == false) goto L5;
            return;
        L5:
            if ("fused".equals(r8.getProvider()) == true) goto L10;
            CommSenseLog.d(StarZppManager.TAG, "onLocationChanged: " + r8);
            StarZppManager.access$1700(this.this$0, r8);
            return;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onLocationStateValueChange(String r8) {
            CommSenseLog.v(StarZppManager.TAG, "onLocationStateValueChange: " + r8);
            if (TextUtils.isEmpty(r8) == false) goto L6;
            StarZppManager.access$800(this.this$0).set(false);
            return;
        L6:
            StarZppManager.access$800(this.this$0).compareAndSet(false, true);
            StarZppManager.access$902(this.this$0, r8);
            if (StarZppManager.access$300(this.this$0) < 3) goto L10;
            UserAwareManager.getInstance().zppCollectLocation(10);
        L10:
            if (StarZppManager.access$300(this.this$0) < 2) goto L13;
            StarZppManager.access$400(this.this$0);
            return;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onLocationUiSettingChanged(boolean r8) {
            CommSenseLog.d(StarZppManager.TAG, "onLocationUiSettingChanged: " + r8);
            StarZppManager r10 = this.this$0;
            if (r8 == false) goto L5;
            r10.initAiKernelZppModel();
            return;
        L5:
            r10.deinitAiKernelZppModel();
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onStepsCounterChanged(int r8) {
            CommSenseLog.v(StarZppManager.TAG, "onStepsCounterChanged: " + r8);
            if (StarZppManager.access$1100(this.this$0) != 0.0f) goto L5;
            StarZppManager.access$1202(this.this$0, r8);
        L5:
            StarZppManager.access$1102(this.this$0, r8);
            if (StarZppManager.access$300(this.this$0) < 2) goto L9;
            StarZppManager.access$400(this.this$0);
            return;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onWifiConnectInfoChanged(WifiStandardData r8) {
            if (r8 != null) goto L5;
            return;
        L5:
            if (StarZppManager.access$200(this.this$0) != null) goto L7;
        L8:
            CommSenseLog.v(StarZppManager.TAG, "onWifiConnectInfoChanged: " + r8);
            StarZppManager.access$202(this.this$0, r8);
            if (StarZppManager.access$300(this.this$0) < 2) goto L13;
            StarZppManager.access$400(this.this$0);
            return;
        L13:
            return;
        L7:
            if (r8.getBssid().equals(StarZppManager.access$200(this.this$0).getBssid()) == false) goto L8;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onWifiScanInfoChanged(List<WifiStandardData> r8) {
            if (r8 != null) goto L4;
            return;
        L4:
            if (r8.isEmpty() == true) goto L22;
            int r10 = r8.size();
            HashSet r11 = new HashSet();
            Iterator<WifiStandardData> r12 = r8.iterator();
            double r13 = 0.0d;
        L8:
            if (r12.hasNext() == false) goto L13;
            WifiStandardData r14 = r12.next();
            if (r14.getBssid() == null) goto L12;
            r11.add(r14.getBssid());
        L12:
            r13 = r13 + ((double) r14.getRssi());
            goto L8
        L13:
            StarZppManager.access$502(this.this$0, r10);
            StarZppManager.access$602(this.this$0, (float) (r13 / ((double) r10)));
            StarZppManager.access$702(this.this$0, r11);
            CommSenseLog.v(StarZppManager.TAG, "onWifiScanInfoChanged: " + StarZppManager.access$500(this.this$0) + ", " + StarZppManager.access$600(this.this$0));
            if (StarZppManager.access$300(this.this$0) < 2) goto L21;
            StarZppManager.access$400(this.this$0);
            return;
        L21:
            return;
        }
    }

    static {
        FEATURE_COLUMNS = Collections.unmodifiableList(Arrays.asList(new String[]{FEATURE_KEY_TIME_SINCE_LAST_FIX, FEATURE_KEY_STEPS_SINCE_LAST_FIX, FEATURE_KEY_HAR_STATE_STILL, FEATURE_KEY_HAR_STATE_WALKING, FEATURE_KEY_HAR_STATE_ACCELERATING, FEATURE_KEY_HAR_STATE_VEHICLE, FEATURE_KEY_WIFI_VISIBLE_COUNT, FEATURE_KEY_WIFI_RSSI_MEAN, FEATURE_KEY_WIFI_CONNECTED_ANY, FEATURE_KEY_WIFI_JACCARD_INDEX, FEATURE_KEY_CELL_ID_CHANGED, FEATURE_KEY_CELL_RSSI_DELTA, FEATURE_KEY_GEOFENCE_IS_HOME, FEATURE_KEY_GEOFENCE_IS_COMPANY, FEATURE_KEY_GEOFENCE_DYNAMIC_PRESENT, FEATURE_KEY_ENGINE_STATUS_UNAVAILABLE, FEATURE_KEY_ENGINE_STATUS_AVAILABLE, FEATURE_KEY_USER_AWARE_AT_HOME, FEATURE_KEY_USER_AWARE_AT_COMPANY, FEATURE_KEY_USER_AWARE_ON_THE_WAY, FEATURE_KEY_VISIBLE_SVS_MEAN_CN0, FEATURE_KEY_VISIBLE_SVS, FEATURE_KEY_LAST_FIX_ACCURACY, FEATURE_KEY_LAST_FIX_IS_GPS}));
        sInstances = new ConcurrentHashMap();
    }

    private StarZppManager(Context r8, int r10) {
        this.mModelVersion = "";
        this.mModelInferStrategy = 0;
        this.mIsModelLoaded = new AtomicBoolean(false);
        this.mIsZppRunning = new AtomicBoolean(false);
        this.mIsLocationStateSupported = new AtomicBoolean(false);
        this.mIsHarSupported = new AtomicBoolean(false);
        this.mInnerZppLocation = new InnerZppLocation(this);
        this.mZppInnerCallback = new ZppInnerCallback(this);
        this.mLastInferenceTimestamp = 0;
        this.mLastCheckModelRunTimestamp = 0;
        this.mProviderInferenceCacheMap = new ConcurrentHashMap();
        this.mProviderInferenceLockMap = new ConcurrentHashMap();
        this.mZppConfidence = 0.0f;
        this.mZppFeatures = new float[FEATURE_COLUMNS.size()];
        this.mLastStepsAtFix = 0.0f;
        this.mLastHarStatus = 4;
        this.mCurrentStepCount = 0.0f;
        this.mHarStatusTimestampMap = new ConcurrentHashMap();
        this.mCurrentEngineStatus = 0;
        this.mCurrentWifiVisibleCount = 0;
        this.mCurrentWifiRssiMean = Float.NaN;
        this.mCurrentWifiConnectedAny = false;
        this.mCurrentBssidSet = new ConcurrentSkipListSet();
        this.mContext = r8.getApplicationContext();
        this.mUserId = r10;
        initOnce();
    }

    public static /* synthetic */ j a(StarZppManager r8, float[] r10, String r11, Float r12) {
        return r8.lambda$runInferenceInternalLocked$5(r10, r11, r12);
    }

    public static /* synthetic */ void access$000(StarZppManager r8) {
        r8.getZppCloudEnable();
    }

    public static /* synthetic */ void access$100(StarZppManager r8) {
        r8.getZppModelInferStrategy();
    }

    public static /* synthetic */ int access$1002(StarZppManager r8, int r10) {
        r8.mCurrentEngineStatus = r10;
        return r10;
    }

    public static /* synthetic */ float access$1100(StarZppManager r8) {
        return r8.mCurrentStepCount;
    }

    public static /* synthetic */ float access$1102(StarZppManager r8, float r10) {
        r8.mCurrentStepCount = r10;
        return r10;
    }

    public static /* synthetic */ float access$1202(StarZppManager r8, float r10) {
        r8.mLastStepsAtFix = r10;
        return r10;
    }

    public static /* synthetic */ AtomicBoolean access$1300(StarZppManager r8) {
        return r8.mIsHarSupported;
    }

    public static /* synthetic */ int access$1402(StarZppManager r8, int r10) {
        r8.mLastHarStatus = r10;
        return r10;
    }

    public static /* synthetic */ Map access$1500(StarZppManager r8) {
        return r8.mHarStatusTimestampMap;
    }

    public static /* synthetic */ CellAwareInfo access$1602(StarZppManager r8, CellAwareInfo r10) {
        r8.mCurrentCellInfo = r10;
        return r10;
    }

    public static /* synthetic */ void access$1700(StarZppManager r8, Location r10) {
        r8.processLocation(r10);
    }

    public static /* synthetic */ GnssSvAwareInfo access$1802(StarZppManager r8, GnssSvAwareInfo r10) {
        r8.mLastGnssState = r10;
        return r10;
    }

    public static /* synthetic */ WifiStandardData access$200(StarZppManager r8) {
        return r8.mLastConnectedWifi;
    }

    public static /* synthetic */ WifiStandardData access$202(StarZppManager r8, WifiStandardData r10) {
        r8.mLastConnectedWifi = r10;
        return r10;
    }

    public static /* synthetic */ long access$2200(StarZppManager r8) {
        return r8.mLastInferenceTimestamp;
    }

    public static /* synthetic */ float access$2302(StarZppManager r8, float r10) {
        r8.mZppConfidence = r10;
        return r10;
    }

    public static /* synthetic */ float access$2400(StarZppManager r8, String r10, boolean r11) {
        return r8.runInferenceInternal(r10, r11);
    }

    public static /* synthetic */ void access$2500(StarZppManager r8, Location r10, Location r11) {
        r8.correctZppLocation(r10, r11);
    }

    public static /* synthetic */ int access$300(StarZppManager r8) {
        return r8.mModelInferStrategy;
    }

    public static /* synthetic */ void access$400(StarZppManager r8) {
        r8.runInference();
    }

    public static /* synthetic */ int access$500(StarZppManager r8) {
        return r8.mCurrentWifiVisibleCount;
    }

    public static /* synthetic */ int access$502(StarZppManager r8, int r10) {
        r8.mCurrentWifiVisibleCount = r10;
        return r10;
    }

    public static /* synthetic */ float access$600(StarZppManager r8) {
        return r8.mCurrentWifiRssiMean;
    }

    public static /* synthetic */ float access$602(StarZppManager r8, float r10) {
        r8.mCurrentWifiRssiMean = r10;
        return r10;
    }

    public static /* synthetic */ Set access$702(StarZppManager r8, Set r10) {
        r8.mCurrentBssidSet = r10;
        return r10;
    }

    public static /* synthetic */ AtomicBoolean access$800(StarZppManager r8) {
        return r8.mIsLocationStateSupported;
    }

    public static /* synthetic */ String access$902(StarZppManager r8, String r10) {
        r8.mCurrentUserAwareChangeState = r10;
        return r10;
    }

    private Location addZppConfidenceBundle(Location r8, float r10) {
        if (r8 != null) goto L5;
        return null;
    L5:
        String r11 = confidence2String(r10);
        Bundle r12 = new Bundle();
        r12.putString(BUNDLE_KEY_ZPP_CONFIDENCE, r11);
        r8.setExtras(r12);
        CommSenseLog.dWithMethodName(TAG, r8 + ", confidence: " + r10);
        return r8;
    }

    private float applyProviderInferenceCache(String r8, InferenceCache r10) {
        this.mZppConfidence = InferenceCache.access$2000(r10);
        if (InferenceCache.access$2100(r10) == null) goto L5;
        this.mZppFeatures = Arrays.copyOf(InferenceCache.access$2100(r10), InferenceCache.access$2100(r10).length);
    L5:
        StringBuilder r11 = defpackage.b.h("runInferenceInternal: use cache, provider: ", r8, ", confidence: ");
        r11.append(this.mZppConfidence);
        CommSenseLog.d(TAG, r11.toString());
        return this.mZppConfidence;
    }

    public static /* synthetic */ Object b(StarZppManager r8, PackageResource r10, Boolean r11) {
        return r8.lambda$initAiKernelZppModel$1(r10, r11);
    }

    private Map<String, Float> buildFeatures(String r12) {
        Map<String, Float> r8 = Collections.synchronizedMap(new AnonymousClass3(this));
        long r10 = System.currentTimeMillis();
        long r11 = this.mInnerZppLocation.getLastFixTimestamp(r12);
        float r13 = Float.NaN;
        if (r11 <= 0) goto L5;
        float r14 = (r10 - r11) / 1000.0f;
    L6:
        r8.put(FEATURE_KEY_TIME_SINCE_LAST_FIX, Float.valueOf(r14));
        r8.put(FEATURE_KEY_STEPS_SINCE_LAST_FIX, Float.valueOf(this.mCurrentStepCount - this.mLastStepsAtFix));
        processHarStatusOneHot(r10, this.mHarStatusTimestampMap, r8);
        float r15 = 1.0f;
        if (this.mCurrentWifiConnectedAny == false) goto L9;
        float r16 = 1.0f;
    L10:
        r8.put(FEATURE_KEY_WIFI_CONNECTED_ANY, Float.valueOf(r16));
        long r17 = r10 - r11;
        if (r17 > 60000) goto L13;
        r8.put(FEATURE_KEY_WIFI_VISIBLE_COUNT, Float.valueOf(this.mCurrentWifiVisibleCount));
        r8.put(FEATURE_KEY_WIFI_RSSI_MEAN, Float.valueOf(this.mCurrentWifiRssiMean));
        r8.put(FEATURE_KEY_WIFI_JACCARD_INDEX, Float.valueOf(jaccardIndex(this.mCurrentBssidSet, this.mLastBssidSetAtFix)));
    L13:
        CellAwareInfo r18 = this.mCurrentCellInfo;
        if (r18 != null) goto L16;
    L22:
        processGeofenceOneHot(r8);
        processEngineStatusOneHot(this.mCurrentEngineStatus, r8);
        processUserAwareOneHot(this.mCurrentUserAwareChangeState, r8);
        if (r17 > 30000) goto L32;
        GnssSvAwareInfo r19 = this.mLastGnssState;
        if (r19 == null) goto L27;
        float r20 = r19.getVisibleSvMeanCn0();
    L28:
        r8.put(FEATURE_KEY_VISIBLE_SVS_MEAN_CN0, Float.valueOf(r20));
        GnssSvAwareInfo r21 = this.mLastGnssState;
        if (r21 == null) goto L31;
        r13 = r21.getVisibleSvCount();
    L31:
        r8.put(FEATURE_KEY_VISIBLE_SVS, Float.valueOf(r13));
        goto L32
    L27:
        r20 = Float.NaN;
    L32:
        Location r110 = this.mInnerZppLocation.getLastLocation(r12);
        if (r110 == null) goto L39;
        r8.put(FEATURE_KEY_LAST_FIX_ACCURACY, Float.valueOf(r110.getAccuracy()));
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r110.getProvider()) == true) goto L38;
        r15 = 0.0f;
    L38:
        r8.put(FEATURE_KEY_LAST_FIX_IS_GPS, Float.valueOf(r15));
    L39:
        return r8;
    L16:
        if (this.mLastCellInfoAtFix == null) goto L22;
        if (r18.getMci() == this.mLastCellInfoAtFix.getMci()) goto L20;
        float r22 = 1.0f;
    L21:
        r8.put(FEATURE_KEY_CELL_ID_CHANGED, Float.valueOf(r22));
        r8.put(FEATURE_KEY_CELL_RSSI_DELTA, Float.valueOf(this.mCurrentCellInfo.getSignalStrength() - this.mLastCellInfoAtFix.getSignalStrength()));
        goto L22
    L20:
        r22 = 0.0f;
        goto L21
    L9:
        r16 = 0.0f;
        goto L10
    L5:
        r14 = Float.NaN;
        goto L6
    }

    public static /* synthetic */ Object c(String r8) {
        return lambda$getProviderInferenceLock$4(r8);
    }

    private void checkHarSupported() {
        if (AwareStateListener.getInstance().getHAREnableValue() != 1) goto L6;
        this.mIsHarSupported.set(true);
        return;
    }

    private String confidence2String(float r8) {
        if (r8 < 0.8f) goto L7;
        return ZPP_CONFIDENCE_HIGH;
    L7:
        if (r8 < 0.6f) goto L11;
        return ZPP_CONFIDENCE_MEDIUM;
    L11:
        if (r8 < 0.44f) goto L14;
        return ZPP_CONFIDENCE_LOW;
    L14:
        return ZPP_CONFIDENCE_ZERO;
    }

    private void correctZppLocation(Location r8, Location r10) {
        if (r8 != null) goto L5;
    L12:
        this.mLastStepsAtFix = this.mCurrentStepCount;
        this.mLastCellInfoAtFix = this.mCurrentCellInfo;
        if (this.mCurrentBssidSet == null) goto L15;
        ConcurrentSkipListSet r11 = new ConcurrentSkipListSet(this.mCurrentBssidSet);
    L16:
        this.mLastBssidSetAtFix = r11;
        CommSenseLog.dumpD(TAG, "correctZppLocation: " + r10, this.mZppFile);
        return;
    L15:
        r11 = new ConcurrentSkipListSet();
        goto L16
    L5:
        if (this.mIsModelLoaded.get() == false) goto L12;
        if (Float.compare(this.mZppConfidence, 0.0f) == 0) goto L12;
        float r12 = r10.distanceTo(r8);
        InnerStarZppData r13 = new InnerStarZppData(this.mModelVersion).setTimestamp(System.currentTimeMillis()).setConfidence(this.mZppConfidence).setFeatureArray(this.mZppFeatures).setDistance(r12);
        StarLocationReportBase r14 = StarLocationReportFactory.getReportInstance();
        if (r14 == null) goto L11;
        r14.reportStarZppEval(r13, r8.getAccuracy(), this.mModelInferStrategy);
    L11:
        StarLocationTeaReporter.reportZppEval(r13, r8.getAccuracy(), this.mModelInferStrategy);
        CommSenseLog.dumpD(TAG, "mLastZppLocation: " + r8 + ", currentLocation: " + r10 + ", featureArray: " + Arrays.toString(this.mZppFeatures) + ", confidence: " + this.mZppConfidence + ", distance: " + r12, this.mZppFile);
        goto L12
    }

    private void crossCheckCurrentUserAwareState() {
        String r8 = AwareStateListener.getInstance().getLocationChangeStateValue();
        this.mCurrentUserAwareChangeState = r8;
        boolean r10 = true;
        if (TextUtils.isEmpty(r8) == true) goto L5;
        this.mIsLocationStateSupported.set(true);
    L5:
        boolean r11 = false;
        if (this.mCurrentUserAwareChangeState.equalsIgnoreCase("into_home") == true) goto L13;
        if (this.mCurrentUserAwareChangeState.equalsIgnoreCase("into_company") == false) goto L11;
        r11 = true;
        r10 = false;
        goto L13
    L11:
        r10 = false;
    L13:
        if (r10 == true) goto L45;
        if (r11 == true) goto L45;
        CommSenseLog.d(TAG, "crossCheckCurrentUserAwareState: " + this.mCurrentUserAwareChangeState);
        return;
    L45:
        List<StarGeofence> r12 = StarGeofenceManager.getInstance(this.mContext, this.mUserId).getBinder().listGeofences(this.mContext.getPackageName());     // Catch: RemoteException -> L42
        if (r12 != null) goto L20;
    L40:
        this.mCurrentUserAwareChangeState = "";
        return;
    L20:
        if (r12.isEmpty() == true) goto L40;
        Iterator<StarGeofence> r13 = r12.iterator();
    L24:
        if (r13.hasNext() == false) goto L38;
        StarGeofence r14 = r13.next();
        if (r14 == null) goto L24;
        if (r14.getGeoState() != StarGeofence.GeoState.INSIDE) goto L24;
        if (r14.getGeoType() != StarGeofence.GeoType.HOME) goto L34;
        if (r10 == false) goto L34;
    L36:
        CommSenseLog.d(TAG, "crossCheckCurrentUserAwareState: " + this.mCurrentUserAwareChangeState);
        return;
    L34:
        if (r14.getGeoType() != StarGeofence.GeoType.COMPANY) goto L24;
        if (r11 == false) goto L24;
    L38:
        CommSenseLog.e(TAG, "crossCheckCurrentUserAwareState failed: " + this.mCurrentUserAwareChangeState + ", reset to empty");
        this.mCurrentUserAwareChangeState = "";
        return;
    L42:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to list geofences", e);
        this.mCurrentUserAwareChangeState = "";
    }

    public static /* synthetic */ void d(StarZppManager r8) {
        r8.lambda$runInference$2();
    }

    public static /* synthetic */ void e(StarZppManager r8) {
        r8.lambda$runInference$3();
    }

    public static /* synthetic */ void f(StarZppManager r8) {
        r8.lambda$initZpp$0();
    }

    public static synchronized StarZppManager getInstance(Context r8, int r10) {
        monitor-enter(StarZppManager.class);
        ConcurrentHashMap<Integer, StarZppManager> r11 = sInstances;     // Catch: Throwable -> L9
        StarZppManager r12 = r11.get(Integer.valueOf(r10));     // Catch: Throwable -> L9
        if (r12 != null) goto L7;
        r12 = new StarZppManager(r8, r10);     // Catch: Throwable -> L9
        r11.put(Integer.valueOf(r10), r12);     // Catch: Throwable -> L9
    L7:
        monitor-exit(StarZppManager.class);
        return r12;
    L9:
        th = move-exception;
        throw th;
    }

    private Object getProviderInferenceLock(String r8) {
        return this.mProviderInferenceLockMap.computeIfAbsent(r8, new d(7));
    }

    private InferenceCache getValidProviderInferenceCache(String r8, long r10) {
        InferenceCache r11 = this.mProviderInferenceCacheMap.get(r8);
        if (r11 != null) goto L5;
        return null;
    L5:
        if ((r10 - InferenceCache.access$1900(r11)) >= 10000) goto L10;
        return r11;
    L10:
        return null;
    }

    private void getZppCloudEnable() {
        String r8 = Settings.Global.getString(this.mContext.getContentResolver(), ZPP_CLOUD_ENABLE);
        if (TextUtils.isEmpty(r8) == true) goto L8;
        if ("True".equalsIgnoreCase(r8) == false) goto L8;
        initZpp();
        return;
    L8:
        if (TextUtils.isEmpty(r8) == false) goto L10;
        return;
    L10:
        if ("False".equalsIgnoreCase(r8) == false) goto L15;
        deinitZpp();
        return;
    }

    private void getZppModelInferStrategy() {
        String r8 = Settings.Global.getString(this.mContext.getContentResolver(), ZPP_MODEL_INFER_STRATEGY);
        if (TextUtils.isEmpty(r8) == true) goto L13;
        int r10 = Integer.parseInt(r8);     // Catch: NumberFormatException -> L8
        if (r10 == this.mModelInferStrategy) goto L14;
        this.mModelInferStrategy = r10;     // Catch: NumberFormatException -> L8
        CommSenseLog.d(TAG, "getZppModelInferStrategy: " + this.mModelInferStrategy);     // Catch: NumberFormatException -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to parse model infer strategy", e);
        return;
    }

    private void initOnce() {
        initZppLogFile();
        Uri r8 = Settings.Global.getUriFor(ZPP_CLOUD_ENABLE);
        final Handler r10 = null;
        if (r8 == null) goto L5;
        this.mContext.getContentResolver().registerContentObserver(r8, false, new AnonymousClass1(this, r10));
    L5:
        getZppCloudEnable();
        Uri r11 = Settings.Global.getUriFor(ZPP_MODEL_INFER_STRATEGY);
        if (r11 == null) goto L8;
        this.mContext.getContentResolver().registerContentObserver(r11, false, new AnonymousClass2(this, r10));
    L8:
        getZppModelInferStrategy();
    }

    private void initZppLogFile() {
        if (this.mUserId != 0) goto L5;
        String r8 = STR_ZPP_FILE_NAME;
    L6:
        File r10 = new File(LocationUtil.getInstance().getStarDir(this.mContext), r8);
        r10.delete();
        r10.createNewFile();     // Catch: IOException -> L9
    L10:
        this.mZppFile = r10;
        CommSenseLog.d(TAG, "initZppLogFile, file: " + this.mZppFile);
        CommSenseLog.recordFileWithKey("zpp", this.mZppFile);
        return;
    L9:
        CommSenseLog.e(TAG, "IO error occurred!");
        goto L10
    L5:
        r8 = android.aimedia.a.h(new StringBuilder("star_zpp_"), this.mUserId, ".txt");
        goto L6
    }

    private float jaccardIndex(Set<String> r8, Set<String> r10) {
        if (r8 != null) goto L4;
        r8 = new ConcurrentSkipListSet();
    L4:
        if (r10 != null) goto L7;
        r10 = new ConcurrentSkipListSet();
    L7:
        if (r8.isEmpty() == true) goto L9;
    L12:
        ConcurrentSkipListSet r11 = new ConcurrentSkipListSet(r8);
        r11.addAll(r10);
        if (r11.isEmpty() == false) goto L16;
        return 0.0f;
    L16:
        ConcurrentSkipListSet r12 = new ConcurrentSkipListSet(r8);
        r12.retainAll(r10);
        return r12.size() / r11.size();
    L9:
        if (r10.isEmpty() == false) goto L12;
        return 1.0f;
    }

    private static /* synthetic */ Object lambda$getProviderInferenceLock$4(String r8) {
        return new Object();
    }

    private /* synthetic */ Object lambda$initAiKernelZppModel$1(PackageResource r8, Boolean r10) {
        this.mIsModelLoaded.set(r10.booleanValue());
        if (r8 != null) goto L5;
        return null;
    L5:
        if (r10.booleanValue() == false) goto L16;
        String r11 = r8.getVersion();
        List<PackageResource> r12 = r8.getSubRes();
        if (r12 != null) goto L9;
        return null;
    L9:
        if (r12.isEmpty() == true) goto L18;
        PackageResource r13 = r12.get(0);
        if (r13 == null) goto L19;
        StringBuilder r14 = android.aimedia.a.k(r11, "@");
        r14.append(r13.getVersion());
        this.mModelVersion = r14.toString();
        CommSenseLog.dumpD(TAG, "initZppModel: " + this.mModelVersion, this.mZppFile);
        return null;
    L19:
        return null;
    L18:
        return null;
    L16:
        return null;
    }

    private /* synthetic */ void lambda$initZpp$0() {
        Thread.sleep(10000);     // Catch: InterruptedException -> L5
    L7:
        crossCheckCurrentUserAwareState();
        checkHarSupported();
        if (LocationUtil.getInstance().isLocationUiEnabled() == false) goto L13;
        initAiKernelZppModel();
        return;
    L13:
        return;
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to sleep", e);
        goto L7
    }

    private /* synthetic */ void lambda$runInference$2() {
        runInferenceInternal("fused", true);
    }

    private /* synthetic */ void lambda$runInference$3() {
        runInferenceInternal("fused", true);
    }

    private /* synthetic */ j lambda$runInferenceInternalLocked$5(float[] r8, String r10, Float r11) {
        if (r11 == null) goto L5;
        this.mZppConfidence = r11.floatValue();
        this.mZppFeatures = r8;
        updateProviderInferenceCache(r10, r11.floatValue(), r8, System.currentTimeMillis());
        CommSenseLog.dumpD(TAG, "features: " + Arrays.toString(r8) + " confidence: " + this.mZppConfidence, this.mZppFile);
    L5:
        return j.f13877a;
    }

    private float[] preprocess(Map<String, Float> r8) {
        float[] r10 = new float[FEATURE_COLUMNS.size()];
        int r11 = 0;
    L3:
        List<String> r12 = FEATURE_COLUMNS;
        if (r11 >= r12.size()) goto L13;
        Float r13 = r8.get(r12.get(r11));
        if (r13 != null) goto L8;
    L11:
        float r14 = 0.0f;
    L12:
        r10[r11] = r14;
        r11 = r11 + 1;
        goto L3
    L8:
        if (r13.isNaN() == true) goto L11;
        r14 = r13.floatValue();
        goto L12
    L13:
        return r10;
    }

    private void processEngineStatusOneHot(int r8, Map<String, Float> r10) {
        if (r8 != 1) goto L5;
        String r11 = FEATURE_KEY_ENGINE_STATUS_UNAVAILABLE;
    L9:
        r10.put(r11, Float.valueOf(1.0f));
        return;
    L5:
        if (r8 != 2) goto L11;
        r11 = FEATURE_KEY_ENGINE_STATUS_AVAILABLE;
        goto L9
    }

    private void processGeofenceOneHot(Map<String, Float> r8) {
        List<StarGeofence> r10 = StarGeofenceManager.getInstance(this.mContext, this.mUserId).getBinder().listGeofences(this.mContext.getPackageName());     // Catch: RemoteException -> L28
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator<StarGeofence> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L27;
        StarGeofence r12 = r11.next();
        if (r12 == null) goto L7;
        if (r12.getGeoState() != StarGeofence.GeoState.INSIDE) goto L7;
        int r13 = AnonymousClass4.$SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType[r12.getGeoType().ordinal()];
        if (r13 == 1) goto L25;
        if (r13 == 2) goto L24;
        if (r13 != 3) goto L7;
        if (r12.getGeofenceId().startsWith(StarGeoCallback.DYNAMIC_GEOFENCE_ID_PREFIX) == false) goto L7;
        String r14 = FEATURE_KEY_GEOFENCE_DYNAMIC_PRESENT;
    L26:
        r8.put(r14, Float.valueOf(1.0f));
        goto L7
    L24:
        r14 = FEATURE_KEY_GEOFENCE_IS_COMPANY;
        goto L26
    L25:
        r14 = FEATURE_KEY_GEOFENCE_IS_HOME;
        goto L26
    L27:
        return;
    L28:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to list geofences", e);
    }

    private void processHarStatus(int r8, Map<String, Float> r10) {
        if (this.mIsHarSupported.get() == true) goto L7;
        r10.put(FEATURE_KEY_HAR_STATE_STILL, Float.valueOf(-1.0f));
        r10.put(FEATURE_KEY_HAR_STATE_WALKING, Float.valueOf(-1.0f));
        r10.put(FEATURE_KEY_HAR_STATE_ACCELERATING, Float.valueOf(-1.0f));
        r10.put(FEATURE_KEY_HAR_STATE_VEHICLE, Float.valueOf(-1.0f));
        return;
    L7:
        switch(r8) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L17;
            case 5: goto L11;
            case 6: goto L11;
            case 7: goto L11;
            case 8: goto L11;
            default: goto L17;
        };
    L9:
        r10.put(FEATURE_KEY_HAR_STATE_ACCELERATING, Float.valueOf(1.0f));
        return;
    L10:
        r10.put(FEATURE_KEY_HAR_STATE_WALKING, Float.valueOf(1.0f));
        return;
    L11:
        r10.put(FEATURE_KEY_HAR_STATE_VEHICLE, Float.valueOf(1.0f));
        return;
    L12:
        r10.put(FEATURE_KEY_HAR_STATE_STILL, Float.valueOf(1.0f));
        return;
    }

    private void processHarStatusOneHot(long r8, Map<Integer, Long> r10, Map<String, Float> r11) {
        Iterator<Map.Entry<Integer, Long>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Map.Entry<Integer, Long> r13 = r12.next();
        int r14 = r13.getKey().intValue();
        if ((r8 - r13.getValue().longValue()) > 60000) goto L4;
        processHarStatus(r14, r11);
        goto L4
    L8:
        processHarStatus(this.mLastHarStatus, r11);
    }

    private void processLocation(Location r8) {
        if (r8 != null) goto L6;
        CommSenseLog.w(TAG, "processLocation: location is null");
        return;
    L6:
        long r10 = System.currentTimeMillis();
        if ("network".equals(r8.getProvider()) == false) goto L13;
        if (LocationUtil.getInstance().isSameLocation(this.mInnerZppLocation.getLastNlpLocation(), r8) == false) goto L11;
        return;
    L11:
        this.mInnerZppLocation.setLastNlpLocation(r10, r8);
        return;
    L13:
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r8.getProvider()) == false) goto L15;
        this.mInnerZppLocation.setLastGlpLocation(r10, r8);
        return;
    L15:
        CommSenseLog.d(TAG, "processLocation: unsupported provider " + r8.getProvider());
    }

    private void processUserAwareOneHot(String r8, Map<String, Float> r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isEmpty() == false) goto L7;
        return;
    L7:
        if (this.mIsLocationStateSupported.get() == true) goto L10;
        r10.put(FEATURE_KEY_USER_AWARE_AT_HOME, Float.valueOf(-1.0f));
        r10.put(FEATURE_KEY_USER_AWARE_AT_COMPANY, Float.valueOf(-1.0f));
        r10.put(FEATURE_KEY_USER_AWARE_ON_THE_WAY, Float.valueOf(-1.0f));
        return;
    L10:
        byte r11 = -1;
        switch(r8.hashCode()) {
            case -1106037339: goto L38;
            case -527125069: goto L34;
            case -498341474: goto L30;
            case -406175659: goto L26;
            case 54091568: goto L22;
            case 687039628: goto L18;
            case 771441502: goto L14;
            default: goto L42;
        };
    L14:
        if (r8.equals("into_home") == false) goto L42;
        r11 = 6;
        goto L42
    L18:
        if (r8.equals("out_company") == false) goto L42;
        r11 = 5;
        goto L42
    L22:
        if (r8.equals("out_home") == false) goto L42;
        r11 = 4;
        goto L42
    L26:
        if (r8.equals("company_indoor") == false) goto L42;
        r11 = 3;
        goto L42
    L30:
        if (r8.equals("into_company") == false) goto L42;
        r11 = 2;
        goto L42
    L34:
        if (r8.equals("home_indoor") == false) goto L42;
        r11 = 1;
        goto L42
    L38:
        if (r8.equals("outside") == false) goto L42;
        r11 = 0;
    L42:
        switch(r11) {
            case 0: goto L46;
            case 1: goto L45;
            case 2: goto L44;
            case 3: goto L44;
            case 4: goto L46;
            case 5: goto L46;
            case 6: goto L45;
            default: goto L52;
        };
    L44:
        r10.put(FEATURE_KEY_USER_AWARE_AT_COMPANY, Float.valueOf(1.0f));
        return;
    L45:
        r10.put(FEATURE_KEY_USER_AWARE_AT_HOME, Float.valueOf(1.0f));
        return;
    L46:
        r10.put(FEATURE_KEY_USER_AWARE_ON_THE_WAY, Float.valueOf(1.0f));
        return;
    }

    private void runInference() {
        Handler r8 = this.mInferenceHandler;
        if (r8 != null) goto L5;
        return;
    L5:
        r8.removeCallbacksAndMessages(null);
        if ((System.currentTimeMillis() - this.mLastInferenceTimestamp) >= 10000) goto L8;
        this.mInferenceHandler.postDelayed(new b(this, 1), 2000);
        return;
    L8:
        this.mInferenceHandler.post(new k(this, 17));
    }

    private float runInferenceInternal(String r8, boolean r10) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        r8 = "fused";
    L5:
        if (r10 == true) goto L16;
        Object r11 = getProviderInferenceLock(r8);
        monitor-enter(r11);
        float r12 = runInferenceInternalLocked(r8, false);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return r12;
    L12:
        th = move-exception;
        throw th;
    L16:
        return runInferenceInternalLocked(r8, true);
    }

    private float runInferenceInternalLocked(final String r10, boolean r11) {
        if (this.mIsModelLoaded.get() == true) goto L6;
        CommSenseLog.e(TAG, "runInferenceInternal: wait for model load");
        initAiKernelZppModel();
        this.mZppConfidence = 0.0f;
        return 0.0f;
    L6:
        long r8 = System.currentTimeMillis();
        InferenceCache r12 = getValidProviderInferenceCache(r10, r8);
        if (r12 != null) goto L9;
        this.mLastInferenceTimestamp = r8;
        if (this.mInnerZppLocation.getLastLocation(r10) != null) goto L13;
        CommSenseLog.w(TAG, "Skipping inference: No high accuracy fix available yet.");
        this.mZppConfidence = 0.0f;
    L13:
        final float[] r13 = preprocess(buildFeatures(r10));
        CommSenseLog.d(TAG, "runInferenceInternal: start async: " + r11 + ", provider: " + r10);
        if (r11 == false) goto L17;
        AIKernelJavaBridge.runModelInferenceAsync(CAE_ZPP_NAME, "zpp_features", r13, new a(this, r13, r10));
        return 0.0f;
    L17:
        Float r14 = AIKernelJavaBridge.runModelInferenceSync(CAE_ZPP_NAME, "zpp_features", r13);
        if (r14 == null) goto L21;
        this.mZppConfidence = r14.floatValue();
        this.mZppFeatures = r13;
        updateProviderInferenceCache(r10, r14.floatValue(), r13, r8);
    L21:
        return this.mZppConfidence;
    L9:
        return applyProviderInferenceCache(r10, r12);
    }

    private void updateProviderInferenceCache(String r8, float r10, float[] r11, long r12) {
        this.mProviderInferenceCacheMap.put(r8, new InferenceCache(r12, r10, r11));
    }

    public synchronized void deinitAiKernelZppModel() {
        monitor-enter(this);
        this.mProviderInferenceCacheMap.clear();     // Catch: Throwable -> L11
        if (this.mIsModelLoaded.get() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        AIKernelJavaBridge.releaseModel(CAE_ZPP_NAME);     // Catch: Throwable -> L11
        this.mIsModelLoaded.set(false);     // Catch: Throwable -> L11
        CommSenseLog.dumpD(TAG, "deinitZppModel: " + this.mModelVersion, this.mZppFile);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized void deinitZpp() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsZppRunning.get() == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mIsZppRunning.set(false);     // Catch: Throwable -> L15
        this.mInnerZppLocation.clear();     // Catch: Throwable -> L15
        this.mProviderInferenceCacheMap.clear();     // Catch: Throwable -> L15
        this.mProviderInferenceLockMap.clear();     // Catch: Throwable -> L15
        CommSenseLog.i(TAG, "deinitZpp");     // Catch: Throwable -> L15
        UserAwareManager.getInstance().unregisterInnerCallback(this.mZppInnerCallback);     // Catch: Throwable -> L15
        deinitAiKernelZppModel();     // Catch: Throwable -> L15
        HandlerThread r8 = this.mInferenceHandlerThread;     // Catch: Throwable -> L15
        if (r8 == null) goto L10;
        r8.quitSafely();     // Catch: Throwable -> L15
        this.mInferenceHandlerThread = null;     // Catch: Throwable -> L15
    L10:
        Handler r10 = this.mInferenceHandler;     // Catch: Throwable -> L15
        if (r10 == null) goto L13;
        r10.removeCallbacksAndMessages(null);     // Catch: Throwable -> L15
        this.mInferenceHandler = null;     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
    }

    public Location getLastKnownLocation(String r8) {
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r8) == false) goto L8;
        this.mZppConfidence = runInferenceInternal(r8, false);
        Location r10 = this.mInnerZppLocation.getLastGlpLocation();
    L6:
        return addZppConfidenceBundle(r10, this.mZppConfidence);
    L8:
        if ("network".equals(r8) == false) goto L11;
        this.mZppConfidence = runInferenceInternal(r8, false);
        r10 = this.mInnerZppLocation.getLastNlpLocation();
        goto L6
    L11:
        return getZppLocation();
    }

    public Location getZppLocation() {
        this.mZppConfidence = runInferenceInternal("fused", false);
        Location r8 = this.mInnerZppLocation.getBestLocation();
        if (r8 != null) goto L7;
        return null;
    L7:
        return addZppConfidenceBundle(r8, this.mZppConfidence);
    }

    public synchronized void initAiKernelZppModel() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsModelLoaded.get() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        CommSenseLog.d(TAG, "initAiKernelZppModel");     // Catch: Throwable -> L15
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L15
        if ((r8 - this.mLastCheckModelRunTimestamp) >= 10000) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.mLastCheckModelRunTimestamp = r8;     // Catch: Throwable -> L15
        AIKernelJavaBridge.initAndLoadModel(570851, this.mContext, CAE_ZPP_NAME, new c(this), 60);     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    public synchronized void initZpp() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsZppRunning.get() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mIsZppRunning.set(true);     // Catch: Throwable -> L10
        CommSenseLog.i(TAG, "initZpp");     // Catch: Throwable -> L10
        HandlerThread r8 = new HandlerThread("ZppInferenceHandler");     // Catch: Throwable -> L10
        this.mInferenceHandlerThread = r8;     // Catch: Throwable -> L10
        r8.start();     // Catch: Throwable -> L10
        this.mInferenceHandler = new Handler(this.mInferenceHandlerThread.getLooper());     // Catch: Throwable -> L10
        new Thread(new b(this, 0)).start();     // Catch: Throwable -> L10
        UserAwareManager.getInstance().registerInnerCallback(this.mZppInnerCallback);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public void setWifiConnected(boolean r8) {
        if (r8 != this.mCurrentWifiConnectedAny) goto L5;
        return;
    L5:
        this.mCurrentWifiConnectedAny = r8;
        if (r8 == true) goto L9;
        this.mLastConnectedWifi = null;
    L9:
        if (this.mModelInferStrategy < 2) goto L12;
        runInference();
        return;
    }
}
