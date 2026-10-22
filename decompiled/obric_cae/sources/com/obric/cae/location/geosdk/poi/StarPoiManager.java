package com.obric.cae.location.geosdk.poi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.XmlResourceParser;
import android.database.ContentObserver;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.provider.Settings;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.activity.j;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.entity.PoiInfoEntity;
import com.bytedance.bdlocation.init.BDLocationAgent;
import com.obric.cae.cloud.applog.ByteIOUtils;
import com.obric.cae.commonsense.R;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.libs.location.poi.IStarPoiCallback;
import com.obric.cae.libs.location.poi.IStarPoiManager;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.location.geosdk.bytedance.BdLocationManager;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class StarPoiManager {
    private static final String ACTION_ALARM_INSIDE_PERIOD = "com.obric.cae.action.POI_ALARM_INSIDE_PERIOD";
    private static final String ACTION_ALARM_STATIONARY_DELAYED_QUERY = "com.obric.cae.action.POI_ALARM_STATIONARY_DELAYED_QUERY";
    private static final String ACTION_ALARM_STATIONARY_STEP_CHECK = "com.obric.cae.action.POI_ALARM_STATIONARY_STEP_CHECK";
    private static final String BLOCK_REASON_EMPTY_POI_NAME_NON_MALL_AOI = "empty_poi_name_non_mall_aoi";
    private static final String BLOCK_REASON_INSIDE_AREA_PROBE = "inside_area_probe";
    private static final String BLOCK_REASON_LOW_POI_CONFIDENCE = "low_poi_confidence";
    private static final String EVENT_POI_FEEDBACK = "poi_feedback";
    private static final String EVENT_POI_POWER = "poi_power_evnt";
    public static final String EXTRA_AOI_NEW_TYPE_CODE_L3 = "aoi_new_type_code_l3";
    public static final String EXTRA_AOI_NEW_TYPE_NAME_L3 = "aoi_new_type_name_l3";
    private static final String EXTRA_NEAR_THE_AOI = "common_general_restrict_nearby_the_aoi";
    private static final String EXTRA_NEAR_THE_POI = "common_general_restrict_nearby_the_poi";
    private static final String FOOD_COURT_TYPE_NAME = "美食城";
    private static final long[] INSIDE_PERIODS_MS = null;
    private static final String KEY_AOI_NAME = "aoi_name";
    private static final String KEY_DEVICE_ID = "device_id";
    private static final String KEY_EVENT_TIME = "event_time";
    private static final String KEY_IS_SCREEN_ON = "is_screen_on";
    private static final String KEY_LOCK_REASON = "lock_reason";
    private static final String KEY_LOCK_TIME = "lock_time";
    private static final String KEY_LOCK_TIMES = "lock_times";
    private static final String KEY_POI_EVENT_KEY = "poi_event_key";
    private static final String KEY_POI_NAME = "poi_name";
    private static final String KEY_REPORT_TYPE = "report_type";
    private static final String KEY_TOTAL_TIME = "total_time";
    private static final String KEY_USER_CHOICE = "user_choice";
    private static final Set<String> MALL_NEW_TYPE_CODE_L3 = null;
    private static final String MALL_TYPE_NAME = "商场";
    private static final int MAX_LOG_CHUNK_LENGTH = 1800;
    private static final int MSG_ALARM_INSIDE_PERIOD = 3;
    private static final int MSG_ALARM_STATIONARY_STEP_CHECK = 8;
    private static final int MSG_AOI_BOARD_EVENT = 5;
    private static final int MSG_CELL_POI_STATUS_CHANGED = 6;
    private static final int MSG_GEOFENCE_INFO_CHANGED = 4;
    private static final int MSG_GEOFENCE_RESET_PERIOD = 7;
    private static final int MSG_HAR_STATUS_CHANGED = 2;
    private static final int MSG_STATIONARY_DELAYED_QUERY = 9;
    private static final int MSG_STEPS_COUNTER_CHANGED = 1;
    private static final long NEAR_POI_LOCATION_SUBMIT_GRACE_MS = 0;
    private static final String PEDESTRIAN_STREET_TYPE_NAME = "步行街";
    private static final long POI_TYPE_DATA_RETRY_INTERVAL_MS = 0;
    private static final int REPORT_TYPE_POI_BLOCKED = 4;
    private static final int STATIONARY_SOURCE_HAR = 1;
    private static final int STATIONARY_SOURCE_STEP_CHECK = 2;
    private static final long STEPS_REFRESH_DELAY_MS = 200;
    private static final String SUBWAY_NEW_TYPE_CODE = "131401";
    private static final String TAG = "StarLocation-PoiManager";
    private static final String TRIGGER_TYPE_PERIODIC_NEAR_POI = "StarPoiManager-near-poi";
    private static final long UP_DOWN_STAGE_TIMEOUT_MS = 0;
    private static final int USER_SELECT_NONE = -1;
    private static final long WAKELOCK_TIMEOUT_MS = 30000;
    private static final StarPoiManager sInstance = null;
    private AlarmManager mAlarmManager;
    private BroadcastReceiver mAlarmReceiver;
    private volatile Context mAppContext;
    private InnerAwareInfoCallback mAwareCallback;
    private final ConcurrentHashMap<Integer, CallbackRecord> mCallbackMap;
    private long mCurrentCellId;
    private int mCurrentCellPoiType;
    private int mCurrentInsidePeriodIndex;
    private volatile PoiCategory mCurrentPoiCategory;
    private volatile PoiDetectState mCurrentState;
    private volatile boolean mDebugBypassNearPoiCheck;
    private final IStarPoiManager.Stub mIStarPoiManagerBinder;
    private final AtomicBoolean mInited;
    private PendingIntent mInsideAlarmIntent;
    private volatile boolean mIsStationaryFromHar;
    private volatile boolean mIsStationaryFromStep;
    private volatile boolean mIsUserStationary;
    private long mLastDateDayKey;
    private int mLastDetectSteps;
    private volatile String mLastNearAoi;
    private volatile String mLastNearPoi;
    private volatile Bundle mLastNearPoiExtras;
    private long mLastPoiDetectTimeMs;
    private volatile long mLastUpDownEventTimeMs;
    private volatile int mLatestHarStatus;
    private int mLatestSteps;
    private long mLatestStepsUpdateTimeMs;
    private volatile int mLatestUpDownType;
    private final LocationSubmitNotification mLocationSubmitNotification;
    private volatile long mNearPoiLocationSubmitWindowExpireTimeMs;
    private final AtomicBoolean mNearPoiLocationSubmitWindowOpen;
    private final AtomicBoolean mNearPoiQueryRunning;
    private volatile boolean mPendingWalkStepQuery;
    private volatile float mPoiConfidenceThreshold;
    private volatile boolean mPoiDetectEnabled;
    private ContentObserver mPoiDetectSwitchObserver;
    private final Map<String, PoiCategory> mPoiL1CategoryMap;
    private final Map<String, PoiCategory> mPoiL2CategoryMap;
    private final ScheduledThreadPoolExecutor mPoiTaskExecutor;
    private final AtomicBoolean mPoiTypeDataReady;
    private boolean mStationaryActionTriggered;
    private int mStationaryCheckBaseSteps;
    private long mStationaryCheckBaseTimeMs;
    private volatile int mStationaryDelaySeconds;
    private PendingIntent mStationaryDelayedQueryAlarmIntent;
    private PendingIntent mStationaryStepCheckAlarmIntent;
    private volatile long mStationaryStepCheckIntervalMs;
    private volatile int mStationaryStepDeltaThreshold;
    private final AtomicBoolean mSubmitNotificationRegistered;
    private final AtomicBoolean mUpDownStairSensorRegistered;
    private PowerManager.WakeLock mWakeLock;
    private int mWakeLockAcquireCount;
    private int mWakeLockAcquireSource;
    private long mWakeLockAcquireTimeMs;
    private long mWakeLockTotalDurationMs;
    private volatile int mWalkStepThreshold;
    private Handler mWorkerHandler;
    private HandlerThread mWorkerThread;

    /* JADX INFO: renamed from: com.obric.cae.location.geosdk.poi.StarPoiManager$2, reason: invalid class name */
    public class AnonymousClass2 extends IStarPoiManager.Stub {
        final /* synthetic */ StarPoiManager this$0;

        public AnonymousClass2(StarPoiManager r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void H2() {
            lambda$triggerNearPoiLocation$0();
        }

        private static /* synthetic */ void lambda$triggerNearPoiLocation$0() {
            StarPoiManager.access$900(StarPoiManager.access$200());
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public Bundle getLastNearPoiExtras() {
            return StarPoiManager.access$200().getLastNearPoiExtras();
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public Bundle getPoiDetectInfo() {
            return StarPoiManager.access$400(StarPoiManager.access$200());
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public int getPoiDetectState() {
            return StarPoiManager.access$300(StarPoiManager.access$200());
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void registerNearPoiCallback(IStarPoiCallback r8) {
            if (r8 == null) goto L6;
            StarPoiManager.access$200().registerNearPoiCallback(Binder.getCallingPid(), Binder.getCallingUid(), r8);
            return;
        L6:
            throw new IllegalArgumentException("callback is null");
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void setDebugBypassNearPoiCheck(boolean r8) {
            StarPoiManager.access$700(StarPoiManager.access$200(), r8);
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void setPoiDetectStateDebug(int r8) {
            StarPoiManager.access$500(StarPoiManager.access$200(), r8);
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void setStationaryDelaySeconds(int r8) {
            StarPoiManager.access$800(StarPoiManager.access$200(), r8);
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void triggerNearPoiLocation() {
            StarPoiManager.access$600(StarPoiManager.access$200()).post(new f());
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiManager
        public void unregisterNearPoiCallback() {
            StarPoiManager.access$200().unregisterNearPoiCallback(Binder.getCallingPid(), Binder.getCallingUid());
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.location.geosdk.poi.StarPoiManager$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$location$geosdk$poi$StarPoiManager$PoiCategory = null;
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$location$geosdk$poi$StarPoiManager$PoiDetectState = null;

        static {
            int[] r8 = new int[PoiCategory.values().length];
            $SwitchMap$com$obric$cae$location$geosdk$poi$StarPoiManager$PoiCategory = r8;
            r8[PoiCategory.SITTABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L20:
            $SwitchMap$com$obric$cae$location$geosdk$poi$StarPoiManager$PoiCategory[PoiCategory.WALKABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L6:
            int[] r10 = new int[PoiDetectState.values().length];
            $SwitchMap$com$obric$cae$location$geosdk$poi$StarPoiManager$PoiDetectState = r10;
            r10[PoiDetectState.DETECT_STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L26:
            $SwitchMap$com$obric$cae$location$geosdk$poi$StarPoiManager$PoiDetectState[PoiDetectState.INSIDE_AREA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L32:
            $SwitchMap$com$obric$cae$location$geosdk$poi$StarPoiManager$PoiDetectState[PoiDetectState.MONITORING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L22:
            $SwitchMap$com$obric$cae$location$geosdk$poi$StarPoiManager$PoiDetectState[PoiDetectState.ENERGY_SAVING_SIT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L28:
            $SwitchMap$com$obric$cae$location$geosdk$poi$StarPoiManager$PoiDetectState[PoiDetectState.ENERGY_SAVING_WALK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static final class CallbackRecord {
        final IStarPoiCallback callback;
        final IBinder.DeathRecipient deathRecipient;

        public CallbackRecord(IStarPoiCallback r8, IBinder.DeathRecipient r10) {
            this.callback = r8;
            this.deathRecipient = r10;
        }
    }

    public static final enum PoiCategory extends Enum<PoiCategory> {
        private static final /* synthetic */ PoiCategory[] $VALUES = null;
        public static final PoiCategory SITTABLE = null;
        public static final PoiCategory UNKNOWN = null;
        public static final PoiCategory WALKABLE = null;

        private static /* synthetic */ PoiCategory[] $values() {
            return new PoiCategory[]{UNKNOWN, SITTABLE, WALKABLE};
        }

        static {
            UNKNOWN = new PoiCategory(BdimCategoryConstants.VALUE_UNKNOWN, 0);
            SITTABLE = new PoiCategory("SITTABLE", 1);
            WALKABLE = new PoiCategory("WALKABLE", 2);
            $VALUES = $values();
        }

        private PoiCategory(String r8, int r10) {
            super(r8, r10);
        }

        public static PoiCategory valueOf(String r8) {
            return (PoiCategory) Enum.valueOf(PoiCategory.class, r8);
        }

        public static PoiCategory[] values() {
            return (PoiCategory[]) $VALUES.clone();
        }
    }

    public static final enum PoiDetectState extends Enum<PoiDetectState> {
        private static final /* synthetic */ PoiDetectState[] $VALUES = null;
        public static final PoiDetectState DETECT_STOPPED = null;
        public static final PoiDetectState ENERGY_SAVING_SIT = null;
        public static final PoiDetectState ENERGY_SAVING_WALK = null;
        public static final PoiDetectState INSIDE_AREA = null;
        public static final PoiDetectState MONITORING = null;

        private static /* synthetic */ PoiDetectState[] $values() {
            return new PoiDetectState[]{DETECT_STOPPED, INSIDE_AREA, MONITORING, ENERGY_SAVING_SIT, ENERGY_SAVING_WALK};
        }

        static {
            DETECT_STOPPED = new PoiDetectState("DETECT_STOPPED", 0);
            INSIDE_AREA = new PoiDetectState("INSIDE_AREA", 1);
            MONITORING = new PoiDetectState("MONITORING", 2);
            ENERGY_SAVING_SIT = new PoiDetectState("ENERGY_SAVING_SIT", 3);
            ENERGY_SAVING_WALK = new PoiDetectState("ENERGY_SAVING_WALK", 4);
            $VALUES = $values();
        }

        private PoiDetectState(String r8, int r10) {
            super(r8, r10);
        }

        public static PoiDetectState valueOf(String r8) {
            return (PoiDetectState) Enum.valueOf(PoiDetectState.class, r8);
        }

        public static PoiDetectState[] values() {
            return (PoiDetectState[]) $VALUES.clone();
        }
    }

    public class PoiHandler extends Handler {
        final /* synthetic */ StarPoiManager this$0;

        public PoiHandler(StarPoiManager r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        private void handleAoiBoardEvent() {
            StarPoiManager.access$2100(this.this$0, PoiDetectState.MONITORING);
        }

        private void handleCellPoiStatusChanged(int r8, long r10) {
            CommSenseLog.dWithMethodName(StarPoiManager.TAG, "handleCellPoiStatusChanged cellPoiType=" + r8 + ", cellid=" + r10 + ", currentCellId=" + StarPoiManager.access$2600(this.this$0));
            StarPoiManager.access$2702(this.this$0, r8);
            if ((r8 & 2) == 0) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L11;
            StarPoiManager.access$2602(this.this$0, r10);
            if (StarPoiManager.access$2200(this.this$0) != PoiDetectState.DETECT_STOPPED) goto L15;
            StarPoiManager r12 = this.this$0;
            PoiDetectState r13 = PoiDetectState.INSIDE_AREA;
        L13:
            StarPoiManager.access$2100(r12, r13);
            return;
        L15:
            return;
        L11:
            if (r10 != StarPoiManager.access$2600(this.this$0)) goto L16;
            r12 = this.this$0;
            r13 = PoiDetectState.DETECT_STOPPED;
            goto L13
        L16:
            return;
        L5:
            r11 = false;
            goto L6
        }

        private void handleGeofenceInfoChanged(int r8) {
            StarPoiManager r10 = this.this$0;
            if (r8 != 0) goto L5;
            PoiDetectState r11 = PoiDetectState.INSIDE_AREA;
        L6:
            StarPoiManager.access$2100(r10, r11);
            return;
        L5:
            r11 = PoiDetectState.DETECT_STOPPED;
            goto L6
        }

        private void handleGeofenceResetPeriod() {
            if (StarPoiManager.access$2200(this.this$0) != PoiDetectState.INSIDE_AREA) goto L6;
            StarPoiManager.access$2400(this.this$0);
            StarPoiManager.access$2500(this.this$0);
            return;
        }

        private void handleHarChanged(int r8) {
            boolean r10 = false;
            if (StarPoiManager.access$2000(this.this$0, r8) == false) goto L5;
            updateStationaryState(false, 1);
            StarPoiManager.access$2100(this.this$0, PoiDetectState.DETECT_STOPPED);
            return;
        L5:
            if (r8 != 0) goto L7;
            r10 = true;
        L7:
            if (r10 == false) goto L9;
        L11:
            updateStationaryState(r10, 1);
            if (StarPoiManager.access$2200(this.this$0) != PoiDetectState.INSIDE_AREA) goto L16;
            requestNearPoiLocationSafely();
            return;
        L16:
            return;
        L9:
            if (StarPoiManager.access$2200(this.this$0) == PoiDetectState.DETECT_STOPPED) goto L11;
            StarPoiManager.access$2300(this.this$0);
            goto L11
        }

        private void handleInsidePeriodAlarm() {
            requestNearPoiLocationSafely();
            if (StarPoiManager.access$2800(this.this$0) >= StarPoiManager.access$2900().length) goto L5;
            StarPoiManager.access$2808(this.this$0);
        L5:
            StarPoiManager.access$2500(this.this$0);
        }

        private void handleStationaryDelayedQuery() {
            if (StarPoiManager.access$4000(this.this$0) == false) goto L11;
            StarPoiManager r8 = this.this$0;
            if (StarPoiManager.access$3000(r8, StarPoiManager.access$2200(r8)) == false) goto L11;
            if (StarPoiManager.access$4100(this.this$0) == true) goto L11;
            StarPoiManager.access$4102(this.this$0, true);
            requestNearPoiLocationSafely();
            return;
        L11:
            CommSenseLog.dWithMethodName(StarPoiManager.TAG, "skip stationary delayed query, stationary=" + StarPoiManager.access$4000(this.this$0) + ", state=" + StarPoiManager.access$2200(this.this$0) + ", actionTriggered=" + StarPoiManager.access$4100(this.this$0));
        }

        private void handleStationaryStepCheckAlarm() {
            StarPoiManager r8 = this.this$0;
            if (StarPoiManager.access$3000(r8, StarPoiManager.access$2200(r8)) == true) goto L16;
            StarPoiManager.access$3100(this.this$0);
            return;
        L16:
            Thread.sleep(200);     // Catch: InterruptedException -> L14
            StarPoiManager r10 = this.this$0;
            if (StarPoiManager.access$3000(r10, StarPoiManager.access$2200(r10)) == true) goto L12;
            StarPoiManager.access$3100(this.this$0);
            return;
        L12:
            handleStationaryStepCheckAlarmInternal();
            return;
        L14:
            Thread.currentThread().interrupt();
        }

        private void handleStationaryStepCheckAlarmInternal() {
            int r8 = StarPoiManager.access$3200(this.this$0);
            long r10 = StarPoiManager.access$3300(this.this$0);
            long r11 = System.currentTimeMillis();
            if (r8 >= 0) goto L7;
            CommSenseLog.wWithMethodName(StarPoiManager.TAG, "skip stationary step check, steps unavailable");
            resetStationaryStepCheckBaseline(r8, r11);
            StarPoiManager.access$3400(this.this$0);
            return;
        L7:
            if (StarPoiManager.access$3500(this.this$0) >= 0) goto L9;
        L31:
            CommSenseLog.dWithMethodName(StarPoiManager.TAG, "init stationary step check baseline, steps=" + r8);
            resetStationaryStepCheckBaseline(r8, r11);
            StarPoiManager.access$3400(this.this$0);
            return;
        L9:
            if (StarPoiManager.access$3600(this.this$0) <= 0) goto L31;
            if (r10 > StarPoiManager.access$3600(this.this$0)) goto L14;
            CommSenseLog.dWithMethodName(StarPoiManager.TAG, "stationary step check with unchanged steps timestamp, baseTimeMs=" + StarPoiManager.access$3600(this.this$0) + ", stepsUpdateTimeMs=" + r10);
        L14:
            int r12 = r8 - StarPoiManager.access$3500(this.this$0);
            long r13 = r11 - StarPoiManager.access$3600(this.this$0);
            if (r12 >= 0) goto L17;
        L29:
            CommSenseLog.wWithMethodName(StarPoiManager.TAG, "reset stationary step check baseline, stepDelta=" + r12 + ", elapsedMs=" + r13);
            resetStationaryStepCheckBaseline(r8, r11);
            StarPoiManager.access$3400(this.this$0);
            return;
        L17:
            if (r13 <= 0) goto L29;
            if (r12 >= StarPoiManager.access$3700(this.this$0)) goto L22;
            boolean r14 = true;
        L23:
            CommSenseLog.dWithMethodName(StarPoiManager.TAG, "stationary step check state=" + StarPoiManager.access$2200(this.this$0) + ", baseSteps=" + StarPoiManager.access$3500(this.this$0) + ", currentSteps=" + r8 + ", stepDelta=" + r12 + ", elapsedMs=" + r13 + ", isStationary=" + r14);
            if (r14 == false) goto L27;
            updateStationaryState(true, 2);
            return;
        L27:
            resetStationaryStepCheckBaseline(r8, r11);
            StarPoiManager.access$3400(this.this$0);
            return;
        L22:
            r14 = false;
            goto L23
        }

        private void handleStepsChanged(int r8) {
            requestNearPoiLocationSafely();
        }

        private void requestNearPoiLocationSafely() {
            if (StarPoiManager.access$5100(this.this$0, "requestNearPoiLocationSafely") == false) goto L5;
            return;
        L5:
            StarPoiManager.access$5200(this.this$0);
        }

        private void resetStationaryStepCheckBaseline(int r8, long r10) {
            StarPoiManager.access$3502(this.this$0, r8);
            StarPoiManager.access$3602(this.this$0, r10);
        }

        private void updateStationaryState(boolean r8, int r10) {
            if (r10 != 1) goto L8;
            StarPoiManager.access$3802(this.this$0, r8);
            if (r8 == true) goto L10;
            StarPoiManager.access$3902(this.this$0, false);
        L10:
            boolean r11 = StarPoiManager.access$4000(this.this$0);
            if (StarPoiManager.access$3800(this.this$0) == false) goto L13;
        L16:
            boolean r12 = true;
        L17:
            StarPoiManager.access$4002(this.this$0, r12);
            CommSenseLog.dWithMethodName(StarPoiManager.TAG, "updateStationaryState source=" + r10 + ", har=" + StarPoiManager.access$3800(this.this$0) + ", step=" + StarPoiManager.access$3900(this.this$0) + ", " + r11 + " -> " + r12 + ", state=" + StarPoiManager.access$2200(this.this$0) + ", actionTriggered=" + StarPoiManager.access$4100(this.this$0) + ", pendingWalkStepQuery=" + StarPoiManager.access$4200(this.this$0));
            StarPoiManager r13 = this.this$0;
            if (r12 == true) goto L26;
            StarPoiManager.access$4300(r13);
            StarPoiManager.access$4102(this.this$0, false);
            if (r11 == false) goto L48;
            StarPoiManager r14 = this.this$0;
            if (StarPoiManager.access$3000(r14, StarPoiManager.access$2200(r14)) == false) goto L49;
            StarPoiManager.access$4400(this.this$0);
            return;
        L49:
            return;
        L48:
            return;
        L26:
            if (StarPoiManager.access$3000(r13, StarPoiManager.access$2200(r13)) == false) goto L28;
            StarPoiManager.access$4500(this.this$0);
        L28:
            if (r11 == false) goto L31;
            return;
        L31:
            if (StarPoiManager.access$4600(this.this$0) == false) goto L34;
            CommSenseLog.dWithMethodName(StarPoiManager.TAG, "skip stationary query in up/down stage, upDownType=" + StarPoiManager.access$4700(this.this$0) + ", lastUpDownEventTimeMs=" + StarPoiManager.access$4800(this.this$0));
            StarPoiManager.access$4900(this.this$0);
            return;
        L34:
            StarPoiManager.access$4900(this.this$0);
            if (StarPoiManager.access$2200(this.this$0) == PoiDetectState.MONITORING) goto L41;
            if (StarPoiManager.access$2200(this.this$0) == PoiDetectState.ENERGY_SAVING_SIT) goto L41;
            if (StarPoiManager.access$2200(this.this$0) == PoiDetectState.ENERGY_SAVING_WALK) goto L41;
            return;
        L41:
            if (StarPoiManager.access$2200(this.this$0) == PoiDetectState.ENERGY_SAVING_WALK) goto L43;
        L46:
            StarPoiManager.access$5000(this.this$0);
            return;
        L43:
            if (StarPoiManager.access$4200(this.this$0) == false) goto L46;
            StarPoiManager.access$4102(this.this$0, true);
            requestNearPoiLocationSafely();
            return;
        L13:
            if (StarPoiManager.access$3900(this.this$0) == true) goto L16;
            r12 = false;
            goto L17
        L8:
            if (r10 != 2) goto L10;
            StarPoiManager.access$3902(this.this$0, r8);
            goto L10
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            CommSenseLog.dWithMethodName(StarPoiManager.TAG, "handleMessage what=" + r8.what);
        L20:
            th = move-exception;
            CommSenseLog.eWithMethodName(StarPoiManager.TAG, "handleMessage failed", th);     // Catch: Throwable -> L24
        L22:
            StarPoiManager.access$1900(this.this$0);
            return;
        L24:
            th = move-exception;
            StarPoiManager.access$1900(this.this$0);
            throw th;
        L4:
            if (StarPoiManager.access$1700(this.this$0) == true) goto L8;
            StarPoiManager.access$1900(this.this$0);
            return;
        L8:
            switch(r8.what) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                default: goto L29;
            };     // Catch: Throwable -> L20
        L10:
            handleStationaryDelayedQuery();     // Catch: Throwable -> L20
            goto L29
        L11:
            handleStationaryStepCheckAlarm();     // Catch: Throwable -> L20
            goto L29
        L12:
            handleGeofenceResetPeriod();     // Catch: Throwable -> L20
            goto L29
        L13:
            handleCellPoiStatusChanged(r8.arg1, ((Long) r8.obj).longValue());     // Catch: Throwable -> L20
            goto L29
        L14:
            handleAoiBoardEvent();     // Catch: Throwable -> L20
            goto L29
        L15:
            handleGeofenceInfoChanged(r8.arg1);     // Catch: Throwable -> L20
            goto L29
        L16:
            handleInsidePeriodAlarm();     // Catch: Throwable -> L20
            goto L29
        L17:
            handleHarChanged(r8.arg1);     // Catch: Throwable -> L20
            goto L29
        L18:
            handleStepsChanged(r8.arg1);     // Catch: Throwable -> L20
        L29:
            goto L22
        }
    }

    public static final class PoiThreadFactory implements ThreadFactory {
        private PoiThreadFactory() {
        }

        public /* synthetic */ PoiThreadFactory(AnonymousClass1 r8) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r8) {
            Thread r10 = new Thread(r8, "star-poi-task");
            r10.setPriority(4);
            return r10;
        }
    }

    static {
        sInstance = new StarPoiManager();
        ConcurrentHashMap.KeySetView r8 = ConcurrentHashMap.newKeySet();
        MALL_NEW_TYPE_CODE_L3 = r8;
        POI_TYPE_DATA_RETRY_INTERVAL_MS = TimeUnit.MINUTES.toMillis(2);
        TimeUnit r10 = TimeUnit.SECONDS;
        NEAR_POI_LOCATION_SUBMIT_GRACE_MS = r10.toMillis(1);
        INSIDE_PERIODS_MS = new long[]{60000, 180000, 300000, 600000, 1800000, 3600000, 7200000};
        UP_DOWN_STAGE_TIMEOUT_MS = r10.toMillis(20);
        r8.add("011901");
        r8.add("052201");
        r8.add("052202");
    }

    private StarPoiManager() {
        this.mCallbackMap = new ConcurrentHashMap();
        this.mInited = new AtomicBoolean(false);
        this.mSubmitNotificationRegistered = new AtomicBoolean(false);
        this.mNearPoiQueryRunning = new AtomicBoolean(false);
        this.mNearPoiLocationSubmitWindowOpen = new AtomicBoolean(false);
        this.mPoiTypeDataReady = new AtomicBoolean(false);
        ScheduledThreadPoolExecutor r8 = new ScheduledThreadPoolExecutor(1, new PoiThreadFactory(null));
        this.mPoiTaskExecutor = r8;
        this.mLastNearPoi = "";
        this.mLastNearAoi = "";
        this.mCurrentState = PoiDetectState.DETECT_STOPPED;
        this.mCurrentPoiCategory = PoiCategory.UNKNOWN;
        this.mIsUserStationary = false;
        this.mIsStationaryFromHar = false;
        this.mIsStationaryFromStep = false;
        this.mDebugBypassNearPoiCheck = false;
        this.mPoiDetectEnabled = false;
        this.mPoiConfidenceThreshold = 0.67f;
        this.mWalkStepThreshold = AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD;
        this.mStationaryStepDeltaThreshold = 10;
        this.mStationaryStepCheckIntervalMs = 60000;
        this.mLatestSteps = -1;
        this.mLatestStepsUpdateTimeMs = 0;
        this.mLastDetectSteps = 0;
        this.mPendingWalkStepQuery = false;
        this.mUpDownStairSensorRegistered = new AtomicBoolean(false);
        this.mLatestUpDownType = 0;
        this.mLastUpDownEventTimeMs = 0;
        this.mStationaryCheckBaseSteps = -1;
        this.mStationaryCheckBaseTimeMs = 0;
        this.mStationaryActionTriggered = false;
        this.mStationaryDelaySeconds = 20;
        this.mLatestHarStatus = -1;
        this.mCurrentInsidePeriodIndex = 0;
        this.mLastPoiDetectTimeMs = 0;
        this.mCurrentCellId = -1;
        this.mCurrentCellPoiType = -1;
        this.mWakeLockAcquireTimeMs = 0;
        this.mWakeLockTotalDurationMs = 0;
        this.mWakeLockAcquireCount = 0;
        this.mWakeLockAcquireSource = 0;
        this.mLastDateDayKey = 0;
        this.mNearPoiLocationSubmitWindowExpireTimeMs = 0;
        this.mPoiL1CategoryMap = new HashMap();
        this.mPoiL2CategoryMap = new HashMap();
        this.mLocationSubmitNotification = new AnonymousClass1(this);
        this.mIStarPoiManagerBinder = new AnonymousClass2(this);
        r8.setRemoveOnCancelPolicy(true);
    }

    public static /* synthetic */ void a(StarPoiManager r8) {
        r8.lambda$queryNearPoiData$1();
    }

    public static /* synthetic */ void access$100(StarPoiManager r8, BDLocation r10) {
        r8.handleLocationSubmitNotification(r10);
    }

    public static /* synthetic */ void access$1000(StarPoiManager r8, Context r10) {
        r8.applyPoiDetectSettings(r10);
    }

    public static /* synthetic */ void access$1100(StarPoiManager r8, int r10) {
        r8.handleAwareStepsCounterChanged(r10);
    }

    public static /* synthetic */ void access$1200(StarPoiManager r8, int r10, long r11) {
        r8.handleAwareHarStatusChanged(r10, r11);
    }

    public static /* synthetic */ void access$1300(StarPoiManager r8, StarGeofence r10) {
        r8.handleAwareGeofenceInfoChange(r10);
    }

    public static /* synthetic */ void access$1400(StarPoiManager r8, AoiBoard r10) {
        r8.handleAwareAoiBoardEvent(r10);
    }

    public static /* synthetic */ void access$1500(StarPoiManager r8, SensorEvent r10) {
        r8.handleAwareSensorDataChanged(r10);
    }

    public static /* synthetic */ void access$1600(StarPoiManager r8) {
        r8.handleDateChanged();
    }

    public static /* synthetic */ boolean access$1700(StarPoiManager r8) {
        return r8.isPoiDetectEnabled();
    }

    public static /* synthetic */ void access$1800(StarPoiManager r8, long r10, int r11) {
        r8.acquireWakeLock(r10, r11);
    }

    public static /* synthetic */ void access$1900(StarPoiManager r8) {
        r8.releaseWakeLock();
    }

    public static /* synthetic */ StarPoiManager access$200() {
        return sInstance;
    }

    public static /* synthetic */ boolean access$2000(StarPoiManager r8, int r10) {
        return r8.isTransportationMode(r10);
    }

    public static /* synthetic */ void access$2100(StarPoiManager r8, PoiDetectState r10) {
        r8.transitionToState(r10);
    }

    public static /* synthetic */ PoiDetectState access$2200(StarPoiManager r8) {
        return r8.mCurrentState;
    }

    public static /* synthetic */ void access$2300(StarPoiManager r8) {
        r8.registerUpDownStairSensor();
    }

    public static /* synthetic */ void access$2400(StarPoiManager r8) {
        r8.resetInsidePeriod();
    }

    public static /* synthetic */ void access$2500(StarPoiManager r8) {
        r8.scheduleInsidePeriodAlarm();
    }

    public static /* synthetic */ long access$2600(StarPoiManager r8) {
        return r8.mCurrentCellId;
    }

    public static /* synthetic */ long access$2602(StarPoiManager r8, long r10) {
        r8.mCurrentCellId = r10;
        return r10;
    }

    public static /* synthetic */ int access$2702(StarPoiManager r8, int r10) {
        r8.mCurrentCellPoiType = r10;
        return r10;
    }

    public static /* synthetic */ int access$2800(StarPoiManager r8) {
        return r8.mCurrentInsidePeriodIndex;
    }

    public static /* synthetic */ int access$2808(StarPoiManager r8) {
        int r10 = r8.mCurrentInsidePeriodIndex;
        r8.mCurrentInsidePeriodIndex = r10 + 1;
        return r10;
    }

    public static /* synthetic */ long[] access$2900() {
        return INSIDE_PERIODS_MS;
    }

    public static /* synthetic */ int access$300(StarPoiManager r8) {
        return r8.getPoiDetectState();
    }

    public static /* synthetic */ boolean access$3000(StarPoiManager r8, PoiDetectState r10) {
        return r8.shouldRunStationaryStepCheck(r10);
    }

    public static /* synthetic */ void access$3100(StarPoiManager r8) {
        r8.stopStationaryStepCheck();
    }

    public static /* synthetic */ int access$3200(StarPoiManager r8) {
        return r8.mLatestSteps;
    }

    public static /* synthetic */ long access$3300(StarPoiManager r8) {
        return r8.mLatestStepsUpdateTimeMs;
    }

    public static /* synthetic */ void access$3400(StarPoiManager r8) {
        r8.scheduleStationaryStepCheckAlarm();
    }

    public static /* synthetic */ int access$3500(StarPoiManager r8) {
        return r8.mStationaryCheckBaseSteps;
    }

    public static /* synthetic */ int access$3502(StarPoiManager r8, int r10) {
        r8.mStationaryCheckBaseSteps = r10;
        return r10;
    }

    public static /* synthetic */ long access$3600(StarPoiManager r8) {
        return r8.mStationaryCheckBaseTimeMs;
    }

    public static /* synthetic */ long access$3602(StarPoiManager r8, long r10) {
        r8.mStationaryCheckBaseTimeMs = r10;
        return r10;
    }

    public static /* synthetic */ int access$3700(StarPoiManager r8) {
        return r8.mStationaryStepDeltaThreshold;
    }

    public static /* synthetic */ boolean access$3800(StarPoiManager r8) {
        return r8.mIsStationaryFromHar;
    }

    public static /* synthetic */ boolean access$3802(StarPoiManager r8, boolean r10) {
        r8.mIsStationaryFromHar = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$3900(StarPoiManager r8) {
        return r8.mIsStationaryFromStep;
    }

    public static /* synthetic */ boolean access$3902(StarPoiManager r8, boolean r10) {
        r8.mIsStationaryFromStep = r10;
        return r10;
    }

    public static /* synthetic */ Bundle access$400(StarPoiManager r8) {
        return r8.getPoiDetectInfo();
    }

    public static /* synthetic */ boolean access$4000(StarPoiManager r8) {
        return r8.mIsUserStationary;
    }

    public static /* synthetic */ boolean access$4002(StarPoiManager r8, boolean r10) {
        r8.mIsUserStationary = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$4100(StarPoiManager r8) {
        return r8.mStationaryActionTriggered;
    }

    public static /* synthetic */ boolean access$4102(StarPoiManager r8, boolean r10) {
        r8.mStationaryActionTriggered = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$4200(StarPoiManager r8) {
        return r8.mPendingWalkStepQuery;
    }

    public static /* synthetic */ void access$4300(StarPoiManager r8) {
        r8.cancelStationaryDelayedQuery();
    }

    public static /* synthetic */ void access$4400(StarPoiManager r8) {
        r8.startStationaryStepCheck();
    }

    public static /* synthetic */ void access$4500(StarPoiManager r8) {
        r8.pauseStationaryStepCheckForStationary();
    }

    public static /* synthetic */ boolean access$4600(StarPoiManager r8) {
        return r8.isInUpDownStage();
    }

    public static /* synthetic */ int access$4700(StarPoiManager r8) {
        return r8.mLatestUpDownType;
    }

    public static /* synthetic */ long access$4800(StarPoiManager r8) {
        return r8.mLastUpDownEventTimeMs;
    }

    public static /* synthetic */ void access$4900(StarPoiManager r8) {
        r8.unregisterUpDownStairSensor();
    }

    public static /* synthetic */ void access$500(StarPoiManager r8, int r10) {
        r8.setPoiDetectStateDebug(r10);
    }

    public static /* synthetic */ void access$5000(StarPoiManager r8) {
        r8.scheduleStationaryDelayedQuery();
    }

    public static /* synthetic */ boolean access$5100(StarPoiManager r8, String r10) {
        return r8.shouldBlockPoiQueryForTransportation(r10);
    }

    public static /* synthetic */ void access$5200(StarPoiManager r8) {
        r8.requestNearPoiLocation();
    }

    public static /* synthetic */ Handler access$600(StarPoiManager r8) {
        return r8.mWorkerHandler;
    }

    public static /* synthetic */ void access$700(StarPoiManager r8, boolean r10) {
        r8.setDebugBypassNearPoiCheck(r10);
    }

    public static /* synthetic */ void access$800(StarPoiManager r8, int r10) {
        r8.setStationaryDelaySeconds(r10);
    }

    public static /* synthetic */ void access$900(StarPoiManager r8) {
        r8.triggerNearPoiLocation();
    }

    private void acquireWakeLock(long r8, int r10) {
        PowerManager.WakeLock r11 = this.mWakeLock;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isHeld() == true) goto L9;
        this.mWakeLockAcquireTimeMs = System.currentTimeMillis();
        this.mWakeLockAcquireSource = r10;
        this.mWakeLockAcquireCount++;
        CommSenseLog.dWithMethodName(TAG, "acquireWakeLock timeoutMs=" + r8 + ", source=" + r10 + ", count=" + this.mWakeLockAcquireCount);
        this.mWakeLock.acquire(r8);
        return;
    }

    private void applyPoiDetectRuntimeConfig(Context r8) {
        int r10 = this.mStationaryDelaySeconds;
        long r11 = this.mStationaryStepCheckIntervalMs;
        this.mStationaryDelaySeconds = readPositiveIntSetting(r8, AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_DELAY_SECONDS, this.mStationaryDelaySeconds);
        this.mWalkStepThreshold = readPositiveIntSetting(r8, AwareStateListener.SETTINGS_GLOBAL_POI_WALK_STEP_THRESHOLD, this.mWalkStepThreshold);
        this.mStationaryStepDeltaThreshold = readPositiveIntSetting(r8, AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_DELTA_THRESHOLD, this.mStationaryStepDeltaThreshold);
        this.mStationaryStepCheckIntervalMs = readPositiveLongSetting(r8, AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_CHECK_INTERVAL_MS, this.mStationaryStepCheckIntervalMs);
        this.mPoiConfidenceThreshold = readPoiConfidenceThreshold(r8);
        CommSenseLog.iWithMethodName(TAG, "poi detect config updated, stationaryDelaySeconds=" + this.mStationaryDelaySeconds + ", walkStepThreshold=" + this.mWalkStepThreshold + ", stationaryStepDeltaThreshold=" + this.mStationaryStepDeltaThreshold + ", stationaryStepCheckIntervalMs=" + this.mStationaryStepCheckIntervalMs + ", poiConfidenceThreshold=" + this.mPoiConfidenceThreshold);
        if (this.mStationaryDelaySeconds == r10) goto L12;
        if (this.mIsUserStationary == false) goto L12;
        if (shouldRunStationaryStepCheck(this.mCurrentState) == false) goto L12;
        if (this.mStationaryActionTriggered == true) goto L12;
        scheduleStationaryDelayedQuery();
    L12:
        if (this.mStationaryStepCheckIntervalMs != r11) goto L14;
        return;
    L14:
        if (shouldRunStationaryStepCheck(this.mCurrentState) == true) goto L16;
        return;
    L16:
        if (this.mIsUserStationary == true) goto L21;
        cancelStationaryStepCheckAlarm();
        scheduleStationaryStepCheckAlarm();
        return;
    }

    private void applyPoiDetectSettings(Context r8) {
        applyPoiDetectSwitch(readPoiDetectEnabled(r8));
        applyPoiDetectRuntimeConfig(r8);
    }

    private void applyPoiDetectSwitch(boolean r8) {
        if (this.mPoiDetectEnabled != r8) goto L5;
        return;
    L5:
        this.mPoiDetectEnabled = r8;
        CommSenseLog.iWithMethodName(TAG, "poi detect switch changed, enabled=" + r8);
        if (r8 == true) goto L9;
        disablePoiDetect();
        return;
    }

    public static /* synthetic */ void b(StarPoiManager r8) {
        r8.queryPoiTypeDatasSafely();
    }

    private void beginNearPoiLocationSubmitWindow() {
        this.mNearPoiLocationSubmitWindowExpireTimeMs = (System.currentTimeMillis() + BdLocationManager.LOCATION_TIMEOUT) + NEAR_POI_LOCATION_SUBMIT_GRACE_MS;
        this.mNearPoiLocationSubmitWindowOpen.set(true);
    }

    public static /* synthetic */ void c(StarPoiManager r8, int r10) {
        r8.lambda$registerNearPoiCallback$0(r10);
    }

    private void cancelInsideAlarm() {
        AlarmManager r8 = this.mAlarmManager;
        if (r8 == null) goto L8;
        PendingIntent r10 = this.mInsideAlarmIntent;
        if (r10 == null) goto L9;
        r8.cancel(r10);
        return;
    L9:
        return;
    }

    private void cancelStationaryDelayedQuery() {
        AlarmManager r8 = this.mAlarmManager;
        if (r8 == null) goto L8;
        PendingIntent r10 = this.mStationaryDelayedQueryAlarmIntent;
        if (r10 == null) goto L9;
        r8.cancel(r10);
        return;
    L9:
        return;
    }

    private void cancelStationaryStepCheckAlarm() {
        AlarmManager r8 = this.mAlarmManager;
        if (r8 == null) goto L8;
        PendingIntent r10 = this.mStationaryStepCheckAlarmIntent;
        if (r10 == null) goto L9;
        r8.cancel(r10);
        return;
    L9:
        return;
    }

    private PoiCategory classifyPoiCategory(String r8, String r10, String r11) {
        if (r8 == null) goto L4;
        Locale r12 = Locale.ROOT;
        String r13 = r8.toLowerCase(r12);
        if (TextUtils.isEmpty(r10) == true) goto L12;
        r10.toLowerCase(r12);
        PoiCategory r14 = this.mPoiL2CategoryMap.get((r8 + "_" + r10).toLowerCase(r12));
        if (r14 == null) goto L12;
        if (r14 == PoiCategory.UNKNOWN) goto L12;
        return r14;
    L12:
        PoiCategory r15 = this.mPoiL1CategoryMap.get(r13);
        if (r15 == null) goto L16;
        return r15;
    L16:
        return PoiCategory.UNKNOWN;
    L4:
        return PoiCategory.UNKNOWN;
    }

    private void closeNearPoiLocationSubmitWindow() {
        this.mNearPoiLocationSubmitWindowOpen.set(false);
        this.mNearPoiLocationSubmitWindowExpireTimeMs = 0;
    }

    private boolean consumeNearPoiLocationSubmitWindow() {
        if (this.mNearPoiLocationSubmitWindowOpen.get() == true) goto L6;
        return false;
    L6:
        if (System.currentTimeMillis() <= this.mNearPoiLocationSubmitWindowExpireTimeMs) goto L9;
        closeNearPoiLocationSubmitWindow();
        return false;
    L9:
        boolean r8 = this.mNearPoiLocationSubmitWindowOpen.compareAndSet(true, false);
        if (r8 == false) goto L12;
        this.mNearPoiLocationSubmitWindowExpireTimeMs = 0;
    L12:
        return r8;
    }

    private String describeBundle(Bundle r8) {
        StringBuilder r10 = new StringBuilder("{");
        Iterator<String> r11 = r8.keySet().iterator();
        boolean r12 = true;
    L4:
        if (r11.hasNext() == false) goto L9;
        String r13 = r11.next();
        if (r12 == true) goto L8;
        r10.append(", ");
    L8:
        r10.append(r13);
        r10.append("=");
        r10.append(r8.get(r13));
        r12 = false;
        goto L4
    L9:
        r10.append("}");
        return r10.toString();
    }

    private static String describePoiEntities(List<PoiInfoEntity> r8) {
        if (r8 != null) goto L5;
        return "null";
    L5:
        StringBuilder r10 = new StringBuilder("[");
        int r11 = 0;
    L7:
        if (r11 >= r8.size()) goto L15;
        PoiInfoEntity r12 = r8.get(r11);
        if (r11 <= 0) goto L11;
        r10.append(", ");
    L11:
        if (r12 != null) goto L13;
        r10.append("null");
    L14:
        r11 = r11 + 1;
        goto L7
    L13:
        r10.append("{LocationID=");
        r10.append(r12.LocationID);
        r10.append(", AwemeID=");
        r10.append(r12.AwemeID);
        r10.append(", AmapID=");
        r10.append(r12.AmapID);
        r10.append(", Name=");
        r10.append(r12.Name);
        r10.append(", Typecode=");
        r10.append(r12.Typecode);
        r10.append(", Confidence=");
        r10.append(r12.Confidence);
        r10.append(", Distance=");
        r10.append(r12.Distance);
        r10.append(", Source=");
        r10.append(r12.Source);
        r10.append("}");
        goto L14
    L15:
        r10.append("]");
        return r10.toString();
    }

    private void disablePoiDetect() {
        unregisterUpDownStairSensor();
        cancelInsideAlarm();
        stopStationaryStepCheck();
        Handler r8 = this.mWorkerHandler;
        if (r8 == null) goto L5;
        r8.removeCallbacksAndMessages(null);
    L5:
        handleStateExit(this.mCurrentState);
        this.mCurrentState = PoiDetectState.DETECT_STOPPED;
        this.mIsUserStationary = false;
        this.mIsStationaryFromHar = false;
        this.mIsStationaryFromStep = false;
        this.mStationaryActionTriggered = false;
        this.mLatestUpDownType = 0;
        this.mLastUpDownEventTimeMs = 0;
        this.mCurrentInsidePeriodIndex = 0;
        resetWalkStepQueryBaseline();
        releaseWakeLock();
    }

    private int getCallbackKey(int r8, int r10) {
        if (r8 <= 0) goto L4;
        return r8;
    L4:
        if (r10 <= 0) goto L8;
        return -r10;
    L8:
        return Process.myPid();
    }

    private int getCurrentStepThreshold() {
        if (AnonymousClass6.$SwitchMap$com$obric$cae$location$geosdk$poi$StarPoiManager$PoiDetectState[this.mCurrentState.ordinal()] == 5) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return this.mWalkStepThreshold;
    }

    public static StarPoiManager getInstance() {
        return sInstance;
    }

    private static String getJsonValueAsString(JSONObject r8, String r10) {
        if (r8.has(r10) == true) goto L5;
        return null;
    L5:
        if (r8.isNull(r10) == true) goto L13;
        Object r11 = r8.opt(r10);
        if (r11 != null) goto L11;
        return null;
    L11:
        return String.valueOf(r11);
    L13:
        return null;
    }

    private Bundle getPoiDetectInfo() {
        Bundle r8 = new Bundle();
        r8.putInt("state", getPoiDetectState());
        int r10 = AnonymousClass6.$SwitchMap$com$obric$cae$location$geosdk$poi$StarPoiManager$PoiCategory[this.mCurrentPoiCategory.ordinal()];
        if (r10 != 1) goto L5;
        String r11 = "sittable";
    L9:
        r8.putString("poi_category", r11);
        r8.putInt("category", this.mCurrentPoiCategory.ordinal());
        r8.putBoolean("isStationary", this.mIsUserStationary);
        r8.putInt("stationaryDelaySeconds", this.mStationaryDelaySeconds);
        r8.putInt("walkStepThreshold", this.mWalkStepThreshold);
        r8.putInt("stationaryStepDeltaThreshold", this.mStationaryStepDeltaThreshold);
        r8.putLong("stationaryStepCheckIntervalMs", this.mStationaryStepCheckIntervalMs);
        r8.putInt("currentStepThreshold", getCurrentStepThreshold());
        r8.putLong("lastDetectTimeMs", this.mLastPoiDetectTimeMs);
        return r8;
    L5:
        if (r10 == 2) goto L7;
        r11 = "unknown";
        goto L9
    L7:
        r11 = "walkable";
        goto L9
    }

    private int getPoiDetectState() {
        return this.mCurrentState.ordinal();
    }

    private long getTodayDayKey() {
        Calendar r8 = Calendar.getInstance();
        long r10 = ((long) r8.get(1)) * 10000;
        return ((((long) (r8.get(2) + 1)) * 100) + r10) + ((long) r8.get(5));
    }

    private void handleAwareAoiBoardEvent(AoiBoard r8) {
        if (isPoiDetectEnabled() == true) goto L5;
        return;
    L5:
        if (r8 != null) goto L7;
        return;
    L7:
        CommSenseLog.dWithMethodName(TAG, "onAoiBoardEvent type=" + r8.getType() + ", event=" + r8.getEvent());
        if (this.mCurrentState == PoiDetectState.INSIDE_AREA) goto L12;
        if (this.mCurrentState == PoiDetectState.DETECT_STOPPED) goto L12;
        return;
    L12:
        if (r8.getType() == AoiBoard.Type.MALL) goto L14;
        return;
    L14:
        if (r8.getEvent() != AoiBoard.Event.ENTER) goto L19;
        acquireWakeLock(30000, 5);
        this.mWorkerHandler.obtainMessage(5).sendToTarget();
        return;
    }

    private void handleAwareGeofenceInfoChange(StarGeofence r8) {
        if (isPoiDetectEnabled() == true) goto L5;
        return;
    L5:
        if (r8 != null) goto L7;
        return;
    L7:
        CommSenseLog.dWithMethodName(TAG, "onGeofenceInfoChange geoType=" + r8.getGeoType() + ", geoState=" + r8.getGeoState());
        if (r8.getGeoType() == StarGeofence.GeoType.MALL) goto L10;
        return;
    L10:
        boolean r10 = hasInsideMallGeofence();
        if (r10 == true) goto L13;
    L16:
        if (r10 == true) goto L18;
    L20:
        if (r10 == false) goto L22;
        return;
    L22:
        if (this.mCurrentState == PoiDetectState.DETECT_STOPPED) goto L26;
        acquireWakeLock(30000, 4);
        Message r11 = this.mWorkerHandler.obtainMessage(4, 1, 0);
    L15:
        r11.sendToTarget();
        return;
    L26:
        return;
    L18:
        if (this.mCurrentState != PoiDetectState.INSIDE_AREA) goto L20;
        acquireWakeLock(30000, 7);
        r11 = this.mWorkerHandler.obtainMessage(7, 0, 0);
        goto L15
    L13:
        if (this.mCurrentState != PoiDetectState.DETECT_STOPPED) goto L16;
        acquireWakeLock(30000, 4);
        r11 = this.mWorkerHandler.obtainMessage(4, 0, 0);
        goto L15
    }

    private void handleAwareHarStatusChanged(int r8, long r10) {
        int r11 = this.mLatestHarStatus;
        this.mLatestHarStatus = r8;
        if (isPoiDetectEnabled() == true) goto L6;
        return;
    L6:
        if (this.mCurrentState != PoiDetectState.DETECT_STOPPED) goto L8;
        return;
    L8:
        CommSenseLog.dWithMethodName(TAG, "onHARStatusChanged status=" + r8 + ", timestampMs=" + r10);
        boolean r12 = isTransportationMode(r11);
        boolean r13 = isTransportationMode(r8);
        if (r8 != 0) goto L11;
        boolean r14 = true;
    L12:
        if (r12 == r13) goto L14;
    L15:
        acquireWakeLock(30000, 2);
        this.mWorkerHandler.obtainMessage(2, r8, 0).sendToTarget();
        return;
    L14:
        if (this.mIsStationaryFromHar != r14) goto L15;
        return;
    L11:
        r14 = false;
        goto L12
    }

    private void handleAwareSensorDataChanged(SensorEvent r8) {
        if (isPoiDetectEnabled() == false) goto L20;
        if (r8 == null) goto L21;
        Sensor r10 = r8.sensor;
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.getType() != 33171019) goto L23;
        float[] r11 = r8.values;
        if (r11 != null) goto L12;
        return;
    L12:
        if (r11.length == 0) goto L25;
        int r12 = (int) r11[0];
        long r13 = System.currentTimeMillis();
        this.mLatestUpDownType = r12;
        if (r12 != 0) goto L17;
        long r14 = 0;
    L18:
        this.mLastUpDownEventTimeMs = r14;
        StringBuilder r15 = defpackage.b.f("upDownType=", r12, ", isInUpDownStage=");
        r15.append(isInUpDownStage(r13));
        CommSenseLog.dWithMethodName(TAG, r15.toString());
        return;
    L17:
        r14 = r13;
        goto L18
    L25:
        return;
    L23:
        return;
    L21:
        return;
    }

    private void handleAwareStepsCounterChanged(int r8) {
        if (isPoiDetectEnabled() == true) goto L6;
        return;
    L6:
        if ((Math.abs(r8) % 10) != 0) goto L8;
        StringBuilder r10 = defpackage.b.f("onStepsCounterChanged steps=", r8, ", mLastDetectSteps=");
        r10.append(this.mLastDetectSteps);
        CommSenseLog.dWithMethodName(TAG, r10.toString());
    L8:
        this.mLatestSteps = r8;
        this.mLatestStepsUpdateTimeMs = System.currentTimeMillis();
        handleStationaryExitBySteps(r8);
        maybeTriggerStepBasedPoiQuery(r8);
    }

    private void handleBdLocation(BDLocation r8, String r10) {
        if (isPoiDetectEnabled() == true) goto L6;
        return;
    L6:
        if (this.mCurrentState != PoiDetectState.DETECT_STOPPED) goto L9;
        return;
    L9:
        if (r8 != null) goto L12;
        CommSenseLog.wWithMethodName(TAG, "skip null location, source=" + r10);
        return;
    L12:
        String r11 = r8.getExtra();
        logLocationDebugInfo(r8, r10, r11);
        if (TextUtils.isEmpty(r11) == false) goto L17;
        CommSenseLog.iWithMethodName(TAG, "skip empty extra, source=" + r10);
        return;
    L17:
        if (this.mDebugBypassNearPoiCheck == false) goto L20;
        queryNearPoiData();
        return;
    L20:
        Bundle r12 = parseNearPoiExtras(r11, r10);
        if (r12 == null) goto L23;
        this.mLastNearPoi = r12.getString(EXTRA_NEAR_THE_POI, "false");
        this.mLastNearAoi = r12.getString(EXTRA_NEAR_THE_AOI, "false");
        StringBuilder r13 = defpackage.b.h("source=", r10, ", nearPoi=");
        r13.append(this.mLastNearPoi);
        r13.append(", nearAoi=");
        r13.append(this.mLastNearAoi);
        CommSenseLog.iWithMethodName(TAG, r13.toString());
        boolean r14 = isTrueValue(this.mLastNearPoi);
        boolean r15 = isTrueValue(this.mLastNearAoi);
        if (r14 == true) goto L33;
        if (r15 == true) goto L33;
        return;
    L33:
        queryNearPoiData();
        return;
    L23:
        if (this.mCurrentState != PoiDetectState.MONITORING) goto L25;
    L28:
        transitionToState(PoiDetectState.INSIDE_AREA);
        return;
    L25:
        if (this.mCurrentState == PoiDetectState.ENERGY_SAVING_SIT) goto L28;
        if (this.mCurrentState == PoiDetectState.ENERGY_SAVING_WALK) goto L28;
    }

    private void handleDateChanged() {
        long r8 = getTodayDayKey();
        if (r8 == this.mLastDateDayKey) goto L6;
        this.mLastDateDayKey = r8;
        resetWakeLockStats();
        return;
    }

    private void handleLocationSubmitNotification(BDLocation r8) {
        if (consumeNearPoiLocationSubmitWindow() == true) goto L6;
        dumpPoiLog("skip submit_notification outside near poi location request");
        return;
    L6:
        handleBdLocation(r8, "submit_notification");
    }

    private void handlePoiDetectResult(Bundle r8) {
        PoiCategory r10 = classifyPoiCategory(r8.getString("new_type_name_l1"), r8.getString("new_type_name_l2"), r8.getString("new_type_name_l3"));
        int r11 = AnonymousClass6.$SwitchMap$com$obric$cae$location$geosdk$poi$StarPoiManager$PoiDetectState[this.mCurrentState.ordinal()];
        if (r11 != 1) goto L5;
        CommSenseLog.wWithMethodName(TAG, "skip poi detect result in detect stopped");
        return;
    L5:
        if (r11 != 2) goto L7;
        CommSenseLog.wWithMethodName(TAG, "unexpected poi detect result in inside area");
    L33:
        this.mCurrentPoiCategory = r10;
        this.mLastPoiDetectTimeMs = System.currentTimeMillis();
        return;
    L7:
        if (r11 == 3) goto L26;
        if (r11 == 4) goto L20;
        if (r11 == 5) goto L14;
        CommSenseLog.eWithMethodName(TAG, "unexpected state in handlePoiDetectResult: " + this.mCurrentState);
        goto L33
    L14:
        if (r10 != PoiCategory.SITTABLE) goto L17;
    L27:
        PoiDetectState r12 = PoiDetectState.ENERGY_SAVING_SIT;
    L28:
        transitionToState(r12);
        goto L33
    L17:
        if (r10 != PoiCategory.UNKNOWN) goto L33;
    L24:
        r12 = PoiDetectState.MONITORING;
        goto L28
    L20:
        if (r10 != PoiCategory.WALKABLE) goto L23;
    L21:
        r12 = PoiDetectState.ENERGY_SAVING_WALK;
        goto L28
    L23:
        if (r10 != PoiCategory.UNKNOWN) goto L33;
    L26:
        if (r10 == PoiCategory.SITTABLE) goto L27;
        if (r10 != PoiCategory.WALKABLE) goto L33;
        goto L33
    }

    private void handleStateEnter(PoiDetectState r8) {
        int r10 = AnonymousClass6.$SwitchMap$com$obric$cae$location$geosdk$poi$StarPoiManager$PoiDetectState[r8.ordinal()];
        if (r10 != 1) goto L5;
        cancelInsideAlarm();
        unregisterUpDownStairSensor();
        return;
    L5:
        if (r10 != 2) goto L7;
        resetInsidePeriod();
        scheduleInsidePeriodAlarm();
        return;
    L7:
        if (r10 != 3) goto L9;
        return;
    L9:
        if (r10 != 4) goto L11;
        return;
    L11:
        if (r10 == 5) goto L18;
        CommSenseLog.eWithMethodName(TAG, "unexpected state enter: " + r8);
        return;
    }

    private void handleStateExit(PoiDetectState r8) {
        int r10 = AnonymousClass6.$SwitchMap$com$obric$cae$location$geosdk$poi$StarPoiManager$PoiDetectState[r8.ordinal()];
        if (r10 != 1) goto L5;
        return;
    L5:
        if (r10 != 2) goto L7;
        cancelInsideAlarm();
        return;
    L7:
        if (r10 != 3) goto L9;
        return;
    L9:
        if (r10 != 4) goto L11;
        return;
    L11:
        if (r10 == 5) goto L18;
        CommSenseLog.eWithMethodName(TAG, "unexpected state exit: " + r8);
        return;
    }

    private void handleStationaryExitBySteps(int r8) {
        if (this.mIsStationaryFromStep == false) goto L19;
        int r10 = this.mStationaryCheckBaseSteps;
        if (r10 >= 0) goto L8;
        return;
    L8:
        if ((r8 - r10) >= this.mStationaryStepDeltaThreshold) goto L10;
        return;
    L10:
        this.mIsStationaryFromStep = false;
        if (this.mIsStationaryFromHar == true) goto L20;
        this.mIsUserStationary = false;
        cancelStationaryDelayedQuery();
        this.mStationaryActionTriggered = false;
        if (this.mCurrentState == PoiDetectState.DETECT_STOPPED) goto L16;
        registerUpDownStairSensor();
    L16:
        if (shouldRunStationaryStepCheck(this.mCurrentState) == false) goto L21;
        startStationaryStepCheck();
        return;
    L21:
        return;
    L20:
        return;
    }

    private boolean hasInsideMallGeofence() {
        Context r8 = this.mAppContext;
        if (r8 != null) goto L17;
        return false;
    L17:
        Iterator<StarGeofence> r10 = StarLocationDbManager.getInstance(r8, 0).queryGeofencesByUserIdAndType(0, StarGeofence.GeoType.MALL).iterator();     // Catch: RuntimeException -> L14
    L7:
        if (r10.hasNext() == false) goto L16;
        StarGeofence r11 = r10.next();     // Catch: RuntimeException -> L14
        if (r11 == null) goto L7;
        if (r11.getGeoState() != StarGeofence.GeoState.INSIDE) goto L7;
        return true;
    L16:
        return false;
    L14:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "query mall geofences failed", e);
        goto L16
    }

    private boolean hasMatchedKeyPresence(Bundle r8, String r10, String r11) {
        if (r8.containsKey(r10) != r8.containsKey(r11)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasRequiredNearPoiKeys(Bundle r8) {
        if (r8.containsKey("timestamp") == true) goto L5;
    L21:
        return false;
    L5:
        if (r8.containsKey(IStarPoiCallback.NEAR_THE_POI) == false) goto L21;
        if (r8.containsKey(IStarPoiCallback.NEAR_THE_AOI) == false) goto L21;
        if (r8.containsKey("new_type_name_l1") == false) goto L21;
        if (r8.containsKey("new_type_name_l2") == false) goto L21;
        if (r8.containsKey("new_type_name_l3") == false) goto L21;
        if (r8.containsKey("new_type_code_l1") == false) goto L21;
        if (r8.containsKey("new_type_code_l2") == false) goto L21;
        if (r8.containsKey("new_type_code_l3") == false) goto L21;
        return true;
    }

    private boolean hasUsefulPoiReport(Bundle r8) {
        if (TextUtils.isEmpty(r8.getString("poi_id")) == true) goto L5;
    L12:
        return true;
    L5:
        if (TextUtils.isEmpty(r8.getString("poi_name")) == false) goto L12;
        if (TextUtils.isEmpty(r8.getString(IStarPoiCallback.AOI_ID)) == false) goto L12;
        if (TextUtils.isEmpty(r8.getString("aoi_name")) == false) goto L12;
        return false;
    }

    private boolean hasValidNearPoiReportContract(Bundle r8) {
        if (hasRequiredNearPoiKeys(r8) == true) goto L5;
    L15:
        return false;
    L5:
        if (hasMatchedKeyPresence(r8, IStarPoiCallback.SDK_LOGID, IStarPoiCallback.SCENE_LOGID) == false) goto L15;
        if (hasMatchedKeyPresence(r8, "poi_id", IStarPoiCallback.POI_CONFIDENCE) == false) goto L15;
        if (hasMatchedKeyPresence(r8, IStarPoiCallback.AOI_ID, IStarPoiCallback.AOI_CONFIDENCE) == false) goto L15;
        if (TextUtils.isEmpty(r8.getString("poi_name")) == true) goto L13;
    L14:
        return true;
    L13:
        if (TextUtils.isEmpty(r8.getString("aoi_name")) == true) goto L15;
        goto L14
    }

    private void initAlarmManager(Context r8) {
        this.mAlarmManager = (AlarmManager) r8.getSystemService("alarm");
        String r10 = r8.getPackageName();
        this.mInsideAlarmIntent = PendingIntent.getBroadcast(r8, 1, new Intent(ACTION_ALARM_INSIDE_PERIOD).setPackage(r10), 201326592);
        this.mStationaryStepCheckAlarmIntent = PendingIntent.getBroadcast(r8, 4, new Intent(ACTION_ALARM_STATIONARY_STEP_CHECK).setPackage(r10), 201326592);
        this.mStationaryDelayedQueryAlarmIntent = PendingIntent.getBroadcast(r8, 5, new Intent(ACTION_ALARM_STATIONARY_DELAYED_QUERY).setPackage(r10), 201326592);
    }

    private void initWakeLock(Context r8) {
        this.mWakeLock = ((PowerManager) r8.getSystemService("power")).newWakeLock(1, TAG);
    }

    private void initWorkerThread() {
        HandlerThread r8 = new HandlerThread("StarPoiManagerThread");
        this.mWorkerThread = r8;
        r8.start();
        this.mWorkerHandler = new PoiHandler(this, this.mWorkerThread.getLooper());
    }

    private boolean isAccQualifiedPoi(Bundle r8) {
        if (r8.containsKey(IStarPoiCallback.IS_ACC_QUALIFIED_POI) == true) goto L5;
        return true;
    L5:
        if (r8.getInt(IStarPoiCallback.IS_ACC_QUALIFIED_POI, 0) != 1) goto L8;
        return true;
    L8:
        return false;
    }

    private boolean isInUpDownStage() {
        return isInUpDownStage(System.currentTimeMillis());
    }

    private boolean isMallOrPedestrianStreetAoi(Bundle r8) {
        String r10 = r8.getString(EXTRA_AOI_NEW_TYPE_CODE_L3, "");
        if (MALL_NEW_TYPE_CODE_L3.contains(r10.trim()) == false) goto L5;
        return true;
    L5:
        String r11 = r8.getString(EXTRA_AOI_NEW_TYPE_NAME_L3, "");
        if (r11.contains(FOOD_COURT_TYPE_NAME) == false) goto L8;
        return true;
    L8:
        if (r11.contains(MALL_TYPE_NAME) == false) goto L10;
        return true;
    L10:
        if (r11.contains(PEDESTRIAN_STREET_TYPE_NAME) == true) goto L16;
        return false;
    L16:
        return true;
    }

    private boolean isPoiDetectEnabled() {
        return this.mPoiDetectEnabled;
    }

    private boolean isScreenOn() {
        Context r8 = this.mAppContext;
        if (r8 != null) goto L5;
        return false;
    L5:
        PowerManager r10 = (PowerManager) r8.getSystemService("power");
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r10.isInteractive() == false) goto L12;
        return true;
    L12:
        return false;
    }

    private boolean isSimReadyAndRegistered() {
        Context r8 = this.mAppContext;
        if (r8 != null) goto L5;
        return false;
    L5:
        TelephonyManager r10 = (TelephonyManager) r8.getSystemService("phone");
        if (r10 != null) goto L8;
    L18:
        return false;
    L8:
        if (r10.getSimState() != 5) goto L18;
        ServiceState r11 = r10.getServiceState();     // Catch: SecurityException -> L16
        if (r11 == null) goto L21;
        if (r11.getState() != 0) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L16:
        e = move-exception;
        CommSenseLog.wWithMethodName(TAG, "check sim registration failed: " + e.getMessage());
        goto L18
    }

    private boolean isSyntheticSubwayReport(Bundle r8) {
        return SUBWAY_NEW_TYPE_CODE.equals(r8.getString("new_type_code_l3"));
    }

    private boolean isTransportationMode(int r8) {
        if (r8 != 6) goto L5;
    L12:
        return true;
    L5:
        if (r8 == 8) goto L12;
        if (r8 == 5) goto L12;
        if (r8 == 7) goto L12;
        return false;
    }

    private static boolean isTrueValue(String r8) {
        if ("true".equalsIgnoreCase(r8) == false) goto L5;
    L8:
        return true;
    L5:
        if ("1".equals(r8) == true) goto L8;
        return false;
    }

    private /* synthetic */ void lambda$queryNearPoiData$1() {
    L9:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", th);     // Catch: Throwable -> L13
    L11:
        resetWalkStepQueryBaseline();
        this.mNearPoiQueryRunning.set(false);
        return;
    L13:
        th = move-exception;
        resetWalkStepQueryBaseline();
        this.mNearPoiQueryRunning.set(false);
        throw th;
    L4:
        if (shouldBlockPoiQueryForTransportation("queryNearPoiData task") == false) goto L7;
        resetWalkStepQueryBaseline();
        this.mNearPoiQueryRunning.set(false);
        return;
    L7:
        CommSenseLog.iWithMethodName(TAG, "success=" + BdLocationManager.getInstance().queryNearPoiData());     // Catch: Throwable -> L9
        goto L11
    }

    private /* synthetic */ void lambda$registerNearPoiCallback$0(int r8) {
        this.mCallbackMap.remove(Integer.valueOf(r8));
    }

    private void loadPoiCategoryConfig(Context r8) {
        XmlResourceParser r10 = r8.getResources().getXml(R.xml.poi_category_mapping);     // Catch: Throwable -> L30
        int r11 = r10.getEventType();     // Catch: Throwable -> L30
        PoiCategory r12 = PoiCategory.UNKNOWN;     // Catch: Throwable -> L30
        String r13 = null;
    L5:
        if (r11 == 1) goto L28;
        String r14 = r10.getName();     // Catch: Throwable -> L30
        if (r11 == 2) goto L17;
        if (r11 != 3) goto L27;
        if ("category_l1".equals(r14) == false) goto L27;
        PoiCategory r15 = PoiCategory.UNKNOWN;     // Catch: Throwable -> L30 Throwable -> L30
        r13 = null;
    L27:
        r11 = r10.next();     // Catch: Throwable -> L30 Throwable -> L30
        goto L5
    L17:
        if ("category_l1".equals(r14) == false) goto L22;
        r13 = r10.getAttributeValue(null, QesdkUtils.TAGS.JSON_TAG_NAME);     // Catch: Throwable -> L30 Throwable -> L30
        PoiCategory r16 = parseCategoryType(r10.getAttributeValue(null, "default"));     // Catch: Throwable -> L30 Throwable -> L30
        if (r13 == null) goto L27;
        this.mPoiL1CategoryMap.put(r13.toLowerCase(Locale.ROOT), r16);     // Catch: Throwable -> L30 Throwable -> L30
        goto L27
    L22:
        if ("category_l2".equals(r14) == false) goto L27;
        if (r13 == null) goto L27;
        String r17 = r10.getAttributeValue(null, QesdkUtils.TAGS.JSON_TAG_NAME);     // Catch: Throwable -> L30 Throwable -> L30
        PoiCategory r18 = parseCategoryType(r10.getAttributeValue(null, "type"));     // Catch: Throwable -> L30 Throwable -> L30
        if (r17 == null) goto L27;
        this.mPoiL2CategoryMap.put((r13 + "_" + r17).toLowerCase(Locale.ROOT), r18);     // Catch: Throwable -> L30 Throwable -> L30
        goto L27
    L28:
        CommSenseLog.iWithMethodName(TAG, "loadPoiCategoryConfig success: l1=" + this.mPoiL1CategoryMap.size() + ", l2=" + this.mPoiL2CategoryMap.size());     // Catch: Throwable -> L30 Throwable -> L30
        return;
    L30:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "loadPoiCategoryConfig failed", e);
    }

    private void logLocationDebugInfo(BDLocation r8, String r10, String r11) {
        StringBuilder r12 = defpackage.b.h("source=", r10, ", submitLogId=");
        r12.append(r8.getSubmitLogId());
        r12.append(", locationType=");
        r12.append(r8.getLocationType());
        r12.append(", locationSdk=");
        r12.append(r8.getLocationSDKName());
        r12.append(", poi=");
        r12.append(r8.getPoi());
        r12.append(", aoi=");
        r12.append(r8.getAoi());
        r12.append(", geoPoiList=");
        r12.append(r8.getGeoPoiList());
        r12.append(", geoAoiList=");
        r12.append(r8.getGeoAoiList());
        r12.append(", poiEntities=");
        r12.append(describePoiEntities(r8.getPoiEntities()));
        r12.append(", aoiEntities=");
        r12.append(describePoiEntities(r8.getAoiEntities()));
        r12.append(", locInfoRsp=");
        r12.append(r8.getLocInfoRsp());
        r12.append(", locationResult=");
        r12.append(r8.getLocationResult());
        CommSenseLog.dWithMethodName(TAG, r12.toString());
        logLongMessage("rawExtra source=" + r10 + ", extra=", r11);
    }

    private static void logLongMessage(String r8, String r10) {
        if (r10 != null) goto L7;
        r10 = "null";
    L9:
        CommSenseLog.dWithMethodName(TAG, defpackage.a.e(r8, r10));
        return;
    L7:
        if (r10.length() <= MAX_LOG_CHUNK_LENGTH) goto L9;
        int r11 = ((r10.length() + MAX_LOG_CHUNK_LENGTH) - 1) / MAX_LOG_CHUNK_LENGTH;
        int r12 = 0;
    L12:
        if (r12 >= r11) goto L14;
        int r13 = r12 * MAX_LOG_CHUNK_LENGTH;
        int r14 = Math.min(r10.length(), r13 + MAX_LOG_CHUNK_LENGTH);
        StringBuilder r15 = android.aimedia.a.k(r8, "chunk=");
        r12 = r12 + 1;
        r15.append(r12);
        r15.append("/");
        r15.append(r11);
        r15.append(", ");
        r15.append(r10.substring(r13, r14));
        CommSenseLog.dWithMethodName(TAG, r15.toString());
        goto L12
    }

    private void maybeTriggerStepBasedPoiQuery(int r8) {
        if (this.mCurrentState == PoiDetectState.ENERGY_SAVING_WALK) goto L6;
        return;
    L6:
        if (this.mPendingWalkStepQuery == false) goto L8;
        return;
    L8:
        int r10 = r8 - this.mLastDetectSteps;
        if (r10 < getCurrentStepThreshold()) goto L12;
        this.mPendingWalkStepQuery = true;
        StringBuilder r11 = defpackage.b.f("walk step threshold reached, wait stationary to query, steps=", r8, ", baseSteps=");
        r11.append(this.mLastDetectSteps);
        r11.append(", stepDelta=");
        r11.append(r10);
        CommSenseLog.iWithMethodName(TAG, r11.toString());
        return;
    }

    private PoiCategory parseCategoryType(String r8) {
        if (r8 == null) goto L4;
        String r10 = r8.toLowerCase(Locale.ROOT);
        r10.getClass();
        if (r10.equals("walkable") == true) goto L14;
        if (r10.equals("sittable") == true) goto L12;
        return PoiCategory.UNKNOWN;
    L12:
        return PoiCategory.SITTABLE;
    L14:
        return PoiCategory.WALKABLE;
    L4:
        return PoiCategory.UNKNOWN;
    }

    private Bundle parseNearPoiExtras(String r10, String r11) {
        JSONObject r8 = new JSONObject(r10);     // Catch: JSONException -> L16
        String r12 = getJsonValueAsString(r8, EXTRA_NEAR_THE_POI);     // Catch: JSONException -> L16
        String r13 = getJsonValueAsString(r8, EXTRA_NEAR_THE_AOI);     // Catch: JSONException -> L16
        if (TextUtils.isEmpty(r12) == true) goto L6;
    L9:
        Bundle r14 = new Bundle();     // Catch: JSONException -> L16
        if (TextUtils.isEmpty(r12) == true) goto L13;
        r14.putString(EXTRA_NEAR_THE_POI, r12);     // Catch: JSONException -> L16
    L13:
        if (TextUtils.isEmpty(r13) == true) goto L15;
        r14.putString(EXTRA_NEAR_THE_AOI, r13);     // Catch: JSONException -> L16
    L15:
        return r14;
    L6:
        if (TextUtils.isEmpty(r13) == false) goto L9;
        CommSenseLog.dWithMethodName(TAG, "skip missing near poi fields, source=" + r11 + ", keys=" + r8.names());     // Catch: JSONException -> L16
        return null;
    L16:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "invalid extra=" + r10, e);
        return null;
    }

    private void pauseStationaryStepCheckForStationary() {
        cancelStationaryStepCheckAlarm();
        int r8 = this.mLatestSteps;
        if (r8 < 0) goto L5;
        this.mStationaryCheckBaseSteps = r8;
        this.mStationaryCheckBaseTimeMs = System.currentTimeMillis();
    L5:
        CommSenseLog.dWithMethodName(TAG, "pauseStationaryStepCheckForStationary state=" + this.mCurrentState + ", baseSteps=" + this.mStationaryCheckBaseSteps);
    }

    private void queryPoiTypeDatasSafely() {
        if (isPoiDetectEnabled() == true) goto L6;
        return;
    L6:
        if (this.mPoiTypeDataReady.get() == false) goto L16;
        return;
    L16:
        boolean r8 = BdLocationManager.getInstance().queryPoiTypeDatas();     // Catch: Throwable -> L13
        if (r8 == false) goto L11;
        this.mPoiTypeDataReady.set(true);     // Catch: Throwable -> L13
    L11:
        CommSenseLog.iWithMethodName(TAG, "success=" + r8);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", th);
    }

    private float readPoiConfidenceThreshold(Context r8) {
        float r10 = Settings.Global.getFloat(r8.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_CONFIDENCE_THRESHOLD, 0.67f);
        if (r10 >= 0.0f) goto L5;
    L7:
        CommSenseLog.wWithMethodName(TAG, "ignore invalid poi confidence threshold=" + r10);
        return 0.67f;
    L5:
        if (r10 > 1.0f) goto L7;
        return r10;
    }

    private boolean readPoiDetectEnabled(Context r8) {
        if (Settings.Global.getInt(r8.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_POI_DETECT_FUNCTION, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private int readPositiveIntSetting(Context r8, String r10, int r11) {
        int r12 = Settings.Global.getInt(r8.getContentResolver(), r10, r11);
        if (r12 <= 0) goto L5;
        return r12;
    L5:
        CommSenseLog.wWithMethodName(TAG, "ignore invalid int setting, key=" + r10 + ", value=" + r12);
        return r11;
    }

    private long readPositiveLongSetting(Context r8, String r10, long r11) {
        long r12 = Settings.Global.getLong(r8.getContentResolver(), r10, r11);
        if (r12 <= 0) goto L5;
        return r12;
    L5:
        CommSenseLog.wWithMethodName(TAG, "ignore invalid long setting, key=" + r10 + ", value=" + r12);
        return r11;
    }

    private void registerAlarmReceiver(Context r8) {
        this.mAlarmReceiver = new AnonymousClass5(this);
        IntentFilter r10 = new IntentFilter();
        r10.addAction(ACTION_ALARM_INSIDE_PERIOD);
        r10.addAction(ACTION_ALARM_STATIONARY_STEP_CHECK);
        r10.addAction(ACTION_ALARM_STATIONARY_DELAYED_QUERY);
        r10.addAction("android.intent.action.DATE_CHANGED");
        r10.addAction("android.intent.action.TIME_SET");
        r10.addAction("android.intent.action.TIMEZONE_CHANGED");
        r8.registerReceiver(this.mAlarmReceiver, r10, 4);
    }

    private void registerAwareCallback() {
        this.mAwareCallback = new AnonymousClass4(this);
        UserAwareManager.getInstance().registerInnerCallback(this.mAwareCallback);
    }

    private void registerLocationSubmitNotification() {
        if (this.mSubmitNotificationRegistered.compareAndSet(false, true) == true) goto L10;
        return;
    L10:
        BDLocationAgent.addSubmitNotification(null, this.mLocationSubmitNotification);     // Catch: Throwable -> L7
        CommSenseLog.iWithMethodName(TAG, "registered");     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        this.mSubmitNotificationRegistered.set(false);
        CommSenseLog.eWithMethodName(TAG, "failed", th);
    }

    private void registerPoiDetectSettingObserver(Context r8, String r10) {
        Uri r11 = Settings.Global.getUriFor(r10);
        if (r11 == null) goto L6;
        r8.getContentResolver().registerContentObserver(r11, false, this.mPoiDetectSwitchObserver);
        return;
    }

    private void registerPoiDetectSwitchObserver(final Context r8) {
        if (this.mPoiDetectSwitchObserver == null) goto L5;
        return;
    L5:
        final Handler r10 = this.mWorkerHandler;
        this.mPoiDetectSwitchObserver = new AnonymousClass3(this, r10, r8);
        registerPoiDetectSettingObserver(r8, AwareStateListener.SETTINGS_GLOBAL_ENABLE_POI_DETECT_FUNCTION);
        registerPoiDetectSettingObserver(r8, AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_DELAY_SECONDS);
        registerPoiDetectSettingObserver(r8, AwareStateListener.SETTINGS_GLOBAL_POI_WALK_STEP_THRESHOLD);
        registerPoiDetectSettingObserver(r8, AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_DELTA_THRESHOLD);
        registerPoiDetectSettingObserver(r8, AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_CHECK_INTERVAL_MS);
        registerPoiDetectSettingObserver(r8, AwareStateListener.SETTINGS_GLOBAL_POI_CONFIDENCE_THRESHOLD);
    }

    private void registerUpDownStairSensor() {
        if (this.mUpDownStairSensorRegistered.compareAndSet(false, true) == false) goto L6;
        UserAwareManager.getInstance().getSensorCollectManager().registerUpDownStairSensor();
        return;
    }

    private void releaseWakeLock() {
        PowerManager.WakeLock r8 = this.mWakeLock;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.isHeld() == false) goto L9;
        long r10 = System.currentTimeMillis() - this.mWakeLockAcquireTimeMs;
        this.mWakeLockTotalDurationMs += r10;
        CommSenseLog.dWithMethodName(TAG, "releaseWakeLock duration=" + r10 + "ms, totalDuration=" + this.mWakeLockTotalDurationMs + "ms, count=" + this.mWakeLockAcquireCount);
        reportWakeLockEndEvent(r10);
        this.mWakeLock.release();
        return;
    }

    private void reportBlockedPoiFeedback(Bundle r11, String r12) {
        long r8 = r11.getLong("timestamp", System.currentTimeMillis());     // Catch: Exception -> L9
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L9
        r10.put(KEY_REPORT_TYPE, 4);     // Catch: Exception -> L9
        if (r11.containsKey(IStarPoiCallback.POI_CONFIDENCE) == false) goto L7;
        r12 = r12 + "_" + r11.getDouble(IStarPoiCallback.POI_CONFIDENCE);     // Catch: Exception -> L9
    L7:
        r10.put(KEY_POI_EVENT_KEY, r12 + "_" + r8);     // Catch: Exception -> L9
        r10.put("event_time", r8);     // Catch: Exception -> L9
        r10.put("user_choice", -1);     // Catch: Exception -> L9
        r10.put("poi_name", r11.getString("poi_name", ""));     // Catch: Exception -> L9
        r10.put("aoi_name", r11.getString("aoi_name", ""));     // Catch: Exception -> L9
        r10.put("device_id", MatrixDidUtils.getDid());     // Catch: Exception -> L9
        ByteIOUtils.trackEvent(EVENT_POI_FEEDBACK, r10);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "report blocked poi_feedback failed", e);
    }

    private void reportWakeLockEndEvent(long r8) {
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L4
        r10.put(KEY_IS_SCREEN_ON, isScreenOn());     // Catch: JSONException -> L4
        r10.put(KEY_LOCK_REASON, this.mWakeLockAcquireSource);     // Catch: JSONException -> L4
        r10.put(KEY_LOCK_TIME, toReportInt(r8));     // Catch: JSONException -> L4
        r10.put(KEY_LOCK_TIMES, this.mWakeLockAcquireCount);     // Catch: JSONException -> L4
        r10.put("total_time", toReportInt(this.mWakeLockTotalDurationMs));     // Catch: JSONException -> L4
        r10.put("device_id", MatrixDidUtils.getDid());     // Catch: JSONException -> L4
        ByteIOUtils.trackEvent(EVENT_POI_POWER, r10);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "report wake lock end event failed: " + e.getMessage());
    }

    private void requestNearPoiLocation() {
        beginNearPoiLocationSubmitWindow();
        BdLocationManager.getInstance().getLocationSync(true, TRIGGER_TYPE_PERIODIC_NEAR_POI, BdLocationManager.LOCATION_TIMEOUT);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        closeNearPoiLocationSubmitWindow();
        CommSenseLog.eWithMethodName(TAG, "failed", th);
    }

    private void resetInsidePeriod() {
        this.mCurrentInsidePeriodIndex = 0;
    }

    private void resetWakeLockStats() {
        this.mWakeLockAcquireCount = 0;
        this.mWakeLockTotalDurationMs = 0;
        CommSenseLog.dWithMethodName(TAG, "WakeLock stats reset");
    }

    private void resetWalkStepQueryBaseline() {
        this.mLastDetectSteps = this.mLatestSteps;
        this.mPendingWalkStepQuery = false;
    }

    private void scheduleInsidePeriodAlarm() {
        if (isPoiDetectEnabled() == true) goto L5;
        return;
    L5:
        int r8 = this.mCurrentInsidePeriodIndex;
        long[] r10 = INSIDE_PERIODS_MS;
        if (r8 < r10.length) goto L9;
        CommSenseLog.dWithMethodName(TAG, "skip schedule inside period alarm, index=" + this.mCurrentInsidePeriodIndex);
        return;
    L9:
        long r11 = r10[r8];
        AlarmManager r12 = this.mAlarmManager;
        if (r12 != null) goto L12;
        return;
    L12:
        if (this.mInsideAlarmIntent == null) goto L16;
        r12.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + r11, this.mInsideAlarmIntent);
        return;
    }

    private void scheduleStationaryDelayedQuery() {
        if (isPoiDetectEnabled() == true) goto L6;
        return;
    L6:
        if (isInUpDownStage() == false) goto L10;
        StringBuilder r8 = new StringBuilder("skip stationary delayed query in up/down stage, upDownType=");
        r8.append(this.mLatestUpDownType);
        r8.append(", lastUpDownEventTimeMs=");
        r8.append(this.mLastUpDownEventTimeMs);
    L8:
        CommSenseLog.dWithMethodName(TAG, r8.toString());
        return;
    L10:
        cancelStationaryDelayedQuery();
        long r10 = TimeUnit.SECONDS.toMillis(this.mStationaryDelaySeconds);
        AlarmManager r11 = this.mAlarmManager;
        if (r11 != null) goto L13;
    L15:
        r8 = new StringBuilder("scheduleStationaryDelayedQuery delaySeconds=");
        r8.append(this.mStationaryDelaySeconds);
        r8.append(", state=");
        r8.append(this.mCurrentState);
        goto L8
    L13:
        if (this.mStationaryDelayedQueryAlarmIntent == null) goto L15;
        r11.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + r10, this.mStationaryDelayedQueryAlarmIntent);
        goto L15
    }

    private void scheduleStationaryStepCheckAlarm() {
        if (isPoiDetectEnabled() == true) goto L5;
        return;
    L5:
        AlarmManager r8 = this.mAlarmManager;
        if (r8 != null) goto L8;
        return;
    L8:
        if (this.mStationaryStepCheckAlarmIntent == null) goto L12;
        r8.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + this.mStationaryStepCheckIntervalMs, this.mStationaryStepCheckAlarmIntent);
        return;
    }

    private void setDebugBypassNearPoiCheck(boolean r8) {
        this.mDebugBypassNearPoiCheck = r8;
        CommSenseLog.iWithMethodName(TAG, "setDebugBypassNearPoiCheck: " + r8);
    }

    private void setPoiDetectStateDebug(int r8) {
        if (isPoiDetectEnabled() == true) goto L6;
        CommSenseLog.dWithMethodName(TAG, "skip debug set state, poi detect disabled");
        return;
    L6:
        PoiDetectState r10 = PoiDetectState.DETECT_STOPPED;
        PoiDetectState[] r11 = PoiDetectState.values();
        int r12 = r11.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L12;
        PoiDetectState r14 = r11[r13];
        if (r14.ordinal() == r8) goto L10;
        r13 = r13 + 1;
        goto L7
    L10:
        r10 = r14;
    L12:
        CommSenseLog.iWithMethodName(TAG, "debug set state: " + this.mCurrentState + " -> " + r10);
        transitionToState(r10);
    }

    private void setStationaryDelaySeconds(int r8) {
        if (r8 > 0) goto L6;
        CommSenseLog.wWithMethodName(TAG, "ignore invalid stationary delay seconds: " + r8);
        return;
    L6:
        this.mStationaryDelaySeconds = r8;
        CommSenseLog.iWithMethodName(TAG, "setStationaryDelaySeconds: " + r8);
        if (this.mIsUserStationary == true) goto L9;
        return;
    L9:
        if (shouldRunStationaryStepCheck(this.mCurrentState) == true) goto L11;
        return;
    L11:
        if (this.mStationaryActionTriggered == true) goto L16;
        scheduleStationaryDelayedQuery();
        return;
    }

    private boolean shouldBlockEmptyPoiNameReport(Bundle r8) {
        if (this.mDebugBypassNearPoiCheck == false) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(r8.getString("poi_name")) == false) goto L9;
        if (isMallOrPedestrianStreetAoi(r8) == true) goto L9;
        return true;
    }

    private boolean shouldBlockPoiQueryForTransportation(String r8) {
        if (isTransportationMode(this.mLatestHarStatus) == true) goto L6;
        return false;
    L6:
        StringBuilder r10 = defpackage.b.h("skip poi query in transportation mode, source=", r8, ", harStatus=");
        r10.append(this.mLatestHarStatus);
        r10.append(", state=");
        r10.append(this.mCurrentState);
        CommSenseLog.dWithMethodName(TAG, r10.toString());
        return true;
    }

    private boolean shouldNotifyNearPoiCallback(Bundle r8) {
        if (r8.containsKey(IStarPoiCallback.POI_CONFIDENCE) == true) goto L5;
        return true;
    L5:
        double r10 = r8.getDouble(IStarPoiCallback.POI_CONFIDENCE);
        if (r10 < this.mPoiConfidenceThreshold) goto L8;
        return true;
    L8:
        dumpPoiLog("skip near poi callback for low confidence=" + r10 + ", threshold=" + this.mPoiConfidenceThreshold);
        return false;
    }

    private boolean shouldRunStationaryStepCheck(PoiDetectState r8) {
        if (r8 != PoiDetectState.MONITORING) goto L5;
    L10:
        return true;
    L5:
        if (r8 == PoiDetectState.ENERGY_SAVING_SIT) goto L10;
        if (r8 == PoiDetectState.ENERGY_SAVING_WALK) goto L10;
        return false;
    }

    private void startPoiTypeDataTask() {
        this.mPoiTaskExecutor.scheduleWithFixedDelay(new j(this, 20), 10000, POI_TYPE_DATA_RETRY_INTERVAL_MS, TimeUnit.MILLISECONDS);
    }

    private void startStationaryStepCheck() {
        if (isPoiDetectEnabled() == true) goto L5;
        return;
    L5:
        this.mStationaryCheckBaseSteps = this.mLatestSteps;
        this.mStationaryCheckBaseTimeMs = System.currentTimeMillis();
        this.mStationaryActionTriggered = false;
        scheduleStationaryStepCheckAlarm();
        CommSenseLog.dWithMethodName(TAG, "startStationaryStepCheck baseSteps=" + this.mStationaryCheckBaseSteps + ", state=" + this.mCurrentState);
    }

    private void stopStationaryStepCheck() {
        cancelStationaryDelayedQuery();
        cancelStationaryStepCheckAlarm();
        this.mStationaryCheckBaseSteps = -1;
        this.mStationaryCheckBaseTimeMs = 0;
        this.mStationaryActionTriggered = false;
    }

    private int toReportInt(long r8) {
        if (r8 <= 2147483647L) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return (int) Math.max(r8, 0);
    }

    private void transitionToState(PoiDetectState r8) {
        if (isPoiDetectEnabled() == false) goto L5;
    L7:
        PoiDetectState r10 = this.mCurrentState;
        if (r10 != r8) goto L10;
        return;
    L10:
        CommSenseLog.iWithMethodName(TAG, "transition: " + r10 + " -> " + r8 + ", steps=" + this.mLatestSteps);
        handleStateExit(r10);
        this.mCurrentState = r8;
        resetWalkStepQueryBaseline();
        boolean r11 = shouldRunStationaryStepCheck(r10);
        boolean r12 = shouldRunStationaryStepCheck(r8);
        if (r11 == false) goto L14;
        if (r12 == true) goto L14;
        stopStationaryStepCheck();
    L17:
        handleStateEnter(r8);
        return;
    L14:
        if (r11 == true) goto L17;
        if (r12 == false) goto L17;
        startStationaryStepCheck();
        goto L17
    L5:
        if (r8 == PoiDetectState.DETECT_STOPPED) goto L7;
    }

    private void triggerNearPoiLocation() {
        if (isPoiDetectEnabled() == true) goto L7;
        CommSenseLog.dWithMethodName(TAG, "skip trigger location, poi detect disabled");
        return;
    L7:
        if (shouldBlockPoiQueryForTransportation("triggerNearPoiLocation") == false) goto L9;
        return;
    L9:
        requestNearPoiLocation();
    }

    private void unregisterAlarmReceiver(Context r8) {
        BroadcastReceiver r10 = this.mAlarmReceiver;
        if (r10 == null) goto L10;
        r8.unregisterReceiver(r10);     // Catch: Throwable -> L7
    L5:
        this.mAlarmReceiver = null;
        return;
    }

    private void unregisterPoiDetectSwitchObserver(Context r8) {
        if (this.mPoiDetectSwitchObserver != null) goto L9;
        return;
    L9:
        r8.getContentResolver().unregisterContentObserver(this.mPoiDetectSwitchObserver);     // Catch: Throwable -> L8
    L6:
        this.mPoiDetectSwitchObserver = null;
    }

    private void unregisterUpDownStairSensor() {
        if (this.mUpDownStairSensorRegistered.compareAndSet(true, false) == false) goto L6;
        UserAwareManager.getInstance().getSensorCollectManager().unregisterUpDownStairSensor();
        return;
    }

    public void destroy() {
        CommSenseLog.iWithMethodName(TAG, "destroy");
        unregisterUpDownStairSensor();
        cancelInsideAlarm();
        stopStationaryStepCheck();
        releaseWakeLock();
        Context r8 = this.mAppContext;
        if (r8 == null) goto L5;
        unregisterPoiDetectSwitchObserver(r8);
    L5:
        HandlerThread r10 = this.mWorkerThread;
        if (r10 == null) goto L9;
        r10.quitSafely();
        this.mWorkerThread = null;
        this.mWorkerHandler = null;
    L9:
        if (this.mAwareCallback != null) goto L16;
    L12:
        if (r8 == null) goto L18;
        unregisterAlarmReceiver(r8);
        return;
    L18:
        return;
    L16:
        UserAwareManager.getInstance().unregisterInnerCallback(this.mAwareCallback);     // Catch: Throwable -> L15
    L11:
        this.mAwareCallback = null;
        goto L12
    }

    public void dumpPoiLog(String r8) {
        Context r10 = this.mAppContext;
        if (r10 != null) goto L6;
        CommSenseLog.dWithMethodName(TAG, r8);
        return;
    L6:
        StarAoiBoardManager.getInstance(r10).dumpPoiLog(r8);
    }

    public IStarPoiManager getBinder() {
        return this.mIStarPoiManagerBinder;
    }

    public String getLastNearAoi() {
        return this.mLastNearAoi;
    }

    public String getLastNearPoi() {
        return this.mLastNearPoi;
    }

    public Bundle getLastNearPoiExtras() {
        Bundle r8 = this.mLastNearPoiExtras;
        if (r8 != null) goto L6;
        return null;
    L6:
        return new Bundle(r8);
    }

    public void handleCellPoiStatusChange(int r8, long r10) {
        if (isPoiDetectEnabled() == true) goto L6;
        return;
    L6:
        if (isSimReadyAndRegistered() == true) goto L9;
        return;
    L9:
        if (r8 == this.mCurrentCellPoiType) goto L11;
    L13:
        CommSenseLog.iWithMethodName(TAG, "handleCellPoiStatusChange cellPoiType=" + r8 + ", cellid=" + r10);
        acquireWakeLock(30000, 6);
        this.mWorkerHandler.obtainMessage(6, r8, 0, Long.valueOf(r10)).sendToTarget();
        return;
    L11:
        if (this.mCurrentState == PoiDetectState.DETECT_STOPPED) goto L13;
    }

    public void initOnce(Context r8) {
        if (this.mInited.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        CommSenseLog.iWithMethodName(TAG, "init");
        this.mAppContext = r8;
        this.mPoiDetectEnabled = readPoiDetectEnabled(r8);
        applyPoiDetectRuntimeConfig(r8);
        BdLocationManager.getInstance().init(r8);
        loadPoiCategoryConfig(r8);
        startPoiTypeDataTask();
        registerLocationSubmitNotification();
        initWakeLock(r8);
        initAlarmManager(r8);
        initWorkerThread();
        registerPoiDetectSwitchObserver(r8);
        registerAwareCallback();
        registerAlarmReceiver(r8);
        if (this.mPoiDetectEnabled == true) goto L9;
        disablePoiDetect();
        return;
    }

    public void notifyNearPoiReport(Bundle r10) {
        if (isPoiDetectEnabled() == true) goto L6;
        return;
    L6:
        if (this.mCurrentState != PoiDetectState.DETECT_STOPPED) goto L10;
        dumpPoiLog("skip notifyNearPoiReport in detect stopped, extras=" + describeBundle(r10));
        return;
    L10:
        if (hasUsefulPoiReport(r10) == true) goto L14;
        dumpPoiLog("skip notifyNearPoiReport invalid extras=" + describeBundle(r10));
        return;
    L14:
        if (hasValidNearPoiReportContract(r10) == true) goto L18;
        dumpPoiLog("skip notifyNearPoiReport invalid contract extras=" + describeBundle(r10));
        return;
    L18:
        if (isAccQualifiedPoi(r10) == true) goto L22;
        dumpPoiLog("skip notifyNearPoiReport acc not qualified, extras=" + describeBundle(r10));
        return;
    L22:
        if (shouldBlockEmptyPoiNameReport(r10) == false) goto L25;
        reportBlockedPoiFeedback(r10, BLOCK_REASON_EMPTY_POI_NAME_NON_MALL_AOI);
        dumpPoiLog("skip notifyNearPoiReport empty poi name and unsupported aoi type, extras=" + describeBundle(r10));
        return;
    L25:
        this.mLastNearPoiExtras = new Bundle(r10);
        dumpPoiLog("notifyNearPoiReport extras=" + describeBundle(r10));
        if (shouldNotifyNearPoiCallback(r10) == true) goto L30;
        reportBlockedPoiFeedback(r10, BLOCK_REASON_LOW_POI_CONFIDENCE);
        return;
    L30:
        if (this.mCurrentState == PoiDetectState.INSIDE_AREA) goto L32;
    L35:
        Iterator<Map.Entry<Integer, CallbackRecord>> r8 = this.mCallbackMap.entrySet().iterator();
    L37:
        if (r8.hasNext() == false) goto L52;
        Map.Entry<Integer, CallbackRecord> r11 = r8.next();
        Integer r12 = r11.getKey();
        CallbackRecord r13 = r11.getValue();
        if (r12 == null) goto L37;
        if (r13 == null) goto L37;
        IStarPoiCallback r14 = r13.callback;
        if (r14 == null) goto L37;
        r14.onNearPoiReport(new Bundle(r10));     // Catch: Throwable -> L46 RemoteException -> L48
        CommSenseLog.dWithMethodName(TAG, "notify pid=" + r12);     // Catch: Throwable -> L46 RemoteException -> L48
    L48:
        e = move-exception;
        this.mCallbackMap.remove(r12);
        r13.callback.asBinder().unlinkToDeath(r13.deathRecipient, 0);     // Catch: Throwable -> L54
    L51:
        CommSenseLog.eWithMethodName(TAG, "notify failed for pid=" + r12, e);
    L46:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "notify failed for pid=" + r12, th);
        goto L37
    L52:
        handlePoiDetectResult(r10);
        return;
    L32:
        if (isSyntheticSubwayReport(r10) == true) goto L35;
        reportBlockedPoiFeedback(r10, BLOCK_REASON_INSIDE_AREA_PROBE);
        dumpPoiLog("skip near poi callback for inside area probe, extras=" + describeBundle(r10));
        transitionToState(PoiDetectState.MONITORING);
        handlePoiDetectResult(r10);
    }

    public void queryNearPoiData() {
        if (isPoiDetectEnabled() == true) goto L6;
        return;
    L6:
        if (shouldBlockPoiQueryForTransportation("queryNearPoiData") == false) goto L9;
        return;
    L9:
        if (this.mNearPoiQueryRunning.compareAndSet(false, true) == true) goto L12;
        CommSenseLog.iWithMethodName(TAG, "skip duplicate request");
        return;
    L12:
        this.mPoiTaskExecutor.execute(new androidx.activity.d(this, 21));
    }

    public void registerNearPoiCallback(int r8, int r10, IStarPoiCallback r11) {
        final int r12 = getCallbackKey(r8, r10);
        IBinder r13 = r11.asBinder();
        CallbackRecord r14 = this.mCallbackMap.remove(Integer.valueOf(r12));
        if (r14 != null) goto L12;
    L5:
        IBinder.DeathRecipient r15 = new e(this, r12);
        r13.linkToDeath(r15, 0);     // Catch: RemoteException -> L8
        this.mCallbackMap.put(Integer.valueOf(r12), new CallbackRecord(r11, r15));     // Catch: RemoteException -> L8
        CommSenseLog.dWithMethodName(TAG, "register pid=" + r8 + ", uid=" + r10 + ", key=" + r12 + ", callback=" + r11.hashCode());     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "register failed: " + e.getMessage());
        return;
    L12:
        r14.callback.asBinder().unlinkToDeath(r14.deathRecipient, 0);     // Catch: Throwable -> L11
        goto L5
    }

    public void unregisterNearPoiCallback(int r8, int r10) {
        int r11 = getCallbackKey(r8, r10);
        CallbackRecord r12 = this.mCallbackMap.remove(Integer.valueOf(r11));
        if (r12 != null) goto L10;
        StringBuilder r13 = new StringBuilder("skip unregister missing pid=");
    L7:
        defpackage.b.q(r13, r8, ", uid=", r10, ", key=");
        r13.append(r11);
        CommSenseLog.dWithMethodName(TAG, r13.toString());
        return;
    L10:
        r12.callback.asBinder().unlinkToDeath(r12.deathRecipient, 0);     // Catch: Throwable -> L9
    L6:
        r13 = new StringBuilder("unregister pid=");
        goto L7
    }

    private boolean isInUpDownStage(long r8) {
        long r10 = this.mLastUpDownEventTimeMs;
        if (this.mLatestUpDownType != 0) goto L5;
    L9:
        return false;
    L5:
        if (r10 <= 0) goto L9;
        if ((r8 - r10) > UP_DOWN_STAGE_TIMEOUT_MS) goto L9;
        return true;
    }
}
