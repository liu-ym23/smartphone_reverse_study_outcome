package com.obric.cae.userAware;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import android.text.TextUtils;
import com.obric.cae.libs.useraware.BssidThreshold;
import com.obric.cae.libs.useraware.RssiDropThreshold;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.libs.utils.CaelibUtils;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.cae.wifi.WiFiDBHelper;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import s1.x;

/* JADX INFO: loaded from: classes2.dex */
public class WifiAwareInfoManager {
    private static final int ALREADY_ENTER_FENCE = 1;
    private static final int COMPANY_DROP_THRESHOLD_DB = 10;
    private static final int COMPANY_DROP_WINDOW_SEC = 10;
    private static final int CONNECTED_TRIGGERED_FENCE_COMPANY = 2;
    private static final int CONNECTED_TRIGGERED_FENCE_HOME = 1;
    private static final int CONNECTED_TRIGGERED_FENCE_NONE = 0;
    private static final int CONNECTED_TRIGGERED_SCAN_DAILY_FULL_LIMIT = 2;
    private static final long CONNECTED_TRIGGERED_SCAN_ONCE_DURATION_MS = 6000;
    private static final boolean DEFAULT_ALREADY_ENTER_FENCE = true;
    private static final long DISCONNECTED_TRIGGERED_SCAN_DURATION_MS = 20000;
    public static final int ENTER_GEOFENCE_EVENT = 1;
    private static final long ENTER_ROOM_STOP_CONNECTED_SCAN_DELAY_MS = 5000;
    public static final int EXIT_GEOFENCE_EVENT = 2;
    private static final long GEOFENCE_EVENT_DELAY_MS = 500;
    private static final int HOME_CHANGE_THRESHOLD_DB = 9;
    private static final int HOME_CHANGE_WINDOW_SEC = 2;
    private static final long HOME_DISCONNECTED_TRIGGERED_SCAN_DURATION_MS = 60000;
    private static final int HOME_DROP_THRESHOLD_DB = 17;
    private static final int HOME_DROP_WINDOW_SEC = 5;
    private static final String KEY_BSSID_THRESHOLD_JSON = "bssid_threshold_json";
    private static final String KEY_DROP_LIST_JSON = "drop_threshold_list_json";
    private static final String KEY_HAS_ALREADY_ENTER_FENCE = "has_already_enter_fence";
    private static final int NOT_ENTER_FENCE = 0;
    public static final int PREDICTED_ENTER_ROOM_EVENT = 1;
    public static final int PREDICTED_EXIT_ROOM_EVENT = 2;
    private static final String PREF_WIFI_THRESHOLD = "cae_wifi_threshold_prefs";
    private static final long RECONNECT_FORCE_SCAN_WINDOW_MS = 5000;
    private static final String TAG = "WifiAwareInfoManager";
    public static final int WIFI_CONNECTION_STATE_CONNECTED = 1;
    public static final int WIFI_CONNECTION_STATE_DISCONNECTED = 0;
    private static volatile WifiAwareInfoManager sInstance;
    private List<String> mAvoidRomingConnectedBssids;
    private ConcurrentWifiScanner mConcurrentWifiScanner;
    private int mConnectedTriggeredFenceKey;
    private int mConnectedTriggeredScanCountToday;
    private String mConnectedTriggeredScanDay;
    private Context mContext;
    private String mCurrentConnectedBssid;
    private volatile int mCurrentGeofenceState;
    private final SimpleDateFormat mDayFormat;
    private final List<RssiDropThreshold> mDropThresholdList;
    private boolean mFastWifiScanEnabled;
    public boolean mFunctionEnabled;
    private final GeofenceEventDelaySorter mGeofenceEventDelaySorter;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    public boolean mHasFirstEnterFence;
    private volatile boolean mInPredictedRoom;
    private final AtomicBoolean mIsWifiRecording;
    private String mLastConnectedSsid;
    private long mLastDisconnectTs;
    public int mLastTriggeredSceneType;
    private WifiStandardData mLastWifiConnectInfo;
    private volatile int mPendingStopConnectedScanHandleId;
    private final PnoSavedNetworkStore mPnoSavedNetworkStore;
    private UserAwareService mService;
    private StepCounterCallback mStepCounterCallback;
    private final Runnable mStopConnectedTriggeredScanRunnable;
    private final Map<String, Integer> mThresholdMap;
    private WifiAwareInfoMonitor mWifiAwareInfoMonitor;
    private WifiStandardData mWifiConnectInfo;
    private ConcurrentWifiScanner.RequestHandle mWifiConnectedStateChangeTriggeredScanHandle;
    private int mWifiConnectionState;
    private WifiFenceMonitor mWifiFenceMonitor;
    private WifiManager mWifiManager;
    private Map<String, WifiStandardData> mWifiRomingStandardDataList;
    private String mWifiScanFileKey;
    private List<WifiStandardData> mWifiScanNeighborAp;
    private List<WifiStandardData> mWifiScanStandardDataList;
    private WifiScanStateMachine mWifiScanStateMachine;

    public class StepCounterCallback extends InnerAwareInfoCallback {
        final /* synthetic */ WifiAwareInfoManager this$0;

        private StepCounterCallback(WifiAwareInfoManager r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onStepsCounterChanged(int r8) {
            CommSenseLog.d(WifiAwareInfoManager.TAG, "onStepsCounterChanged : " + r8);
        }

        public /* synthetic */ StepCounterCallback(WifiAwareInfoManager r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    private WifiAwareInfoManager(Context r13) {
        boolean r8 = false;
        this.mInPredictedRoom = false;
        this.mWifiScanStandardDataList = new ArrayList();
        this.mWifiScanNeighborAp = new ArrayList();
        this.mWifiRomingStandardDataList = new HashMap();
        this.mFastWifiScanEnabled = false;
        this.mThresholdMap = new HashMap();
        this.mDropThresholdList = new ArrayList();
        this.mWifiScanFileKey = "";
        this.mWifiConnectionState = 0;
        this.mHasFirstEnterFence = true;
        this.mFunctionEnabled = false;
        this.mAvoidRomingConnectedBssids = new ArrayList();
        this.mIsWifiRecording = new AtomicBoolean(false);
        AnonymousClass1 r10 = null;
        this.mCurrentConnectedBssid = null;
        this.mLastDisconnectTs = 0;
        this.mDayFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        this.mConnectedTriggeredScanDay = "";
        this.mConnectedTriggeredScanCountToday = 0;
        this.mConnectedTriggeredFenceKey = 0;
        this.mPendingStopConnectedScanHandleId = -1;
        this.mStopConnectedTriggeredScanRunnable = new b(this, 3);
        this.mCurrentGeofenceState = -1;
        this.mLastTriggeredSceneType = -1;
        this.mContext = r13;
        this.mWifiManager = (WifiManager) r13.getSystemService("wifi");
        HandlerThread r11 = new HandlerThread("WifiAwareHandlerThread");
        this.mHandlerThread = r11;
        r11.start();
        Handler r12 = new Handler(this.mHandlerThread.getLooper());
        this.mHandler = r12;
        this.mGeofenceEventDelaySorter = new GeofenceEventDelaySorter(r12, GEOFENCE_EVENT_DELAY_MS, TAG, new AnonymousClass1(this), new AnonymousClass2(this));
        if (getWifiPrefs().getInt(KEY_HAS_ALREADY_ENTER_FENCE, 1) != 1) goto L5;
        boolean r14 = true;
    L6:
        this.mHasFirstEnterFence = r14;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION, 0) != 1) goto L9;
        r8 = true;
    L9:
        this.mFunctionEnabled = r8;
        this.mConcurrentWifiScanner = new ConcurrentWifiScanner(r13, this);
        WifiScanStateMachine r15 = new WifiScanStateMachine(this.mContext, this, this.mConcurrentWifiScanner);
        this.mWifiScanStateMachine = r15;
        this.mWifiFenceMonitor = new WifiFenceMonitor(this.mContext, r15, null);
        this.mStepCounterCallback = new StepCounterCallback(this, r10);
        UserAwareService r16 = UserAwareService.getService();
        this.mService = r16;
        if (r16 == null) goto L12;
        UserAwareManager.getInstance().registerInnerCallback(this.mStepCounterCallback);
    L12:
        loadRssiThresholds();
        loadDropThresholds();
        this.mPnoSavedNetworkStore = new PnoSavedNetworkStore(this.mContext);
        return;
    L5:
        r14 = false;
        goto L6
    }

    public static /* synthetic */ void a(WifiAwareInfoManager r8, List r10) {
        r8.lambda$startConnectionTriggeredScan$4(r10);
    }

    public static /* synthetic */ int access$000(WifiAwareInfoManager r8) {
        return r8.mCurrentGeofenceState;
    }

    public static /* synthetic */ void access$100(WifiAwareInfoManager r8, int r10) {
        r8.dispatchGeofenceEvent(r10);
    }

    public static /* synthetic */ void b(WifiAwareInfoManager r8, List r10) {
        r8.lambda$startConnectionTriggeredScan$1(r10);
    }

    public static /* synthetic */ void c(WifiAwareInfoManager r8, List r10) {
        r8.lambda$startConnectionTriggeredScan$2(r10);
    }

    public static /* synthetic */ void d(WifiAwareInfoManager r8, int r10) {
        r8.lambda$notifyGeofenceChanged$5(r10);
    }

    private void dispatchGeofenceEvent(int r8) {
        CommSenseLog.i(TAG, "notifyGeofenceChanged(dispatch): event -- " + r8);
        this.mCurrentGeofenceState = r8;
        this.mWifiFenceMonitor.onExitHome();
        this.mWifiScanStateMachine.updateFenceState(r8);
        if (r8 != 1) goto L5;
    L14:
        WifiScanStateMachine r10 = this.mWifiScanStateMachine;
        WifiFenceMonitor r11 = this.mWifiFenceMonitor;
        if (r8 != 1) goto L17;
        Set<Map<String, Integer>> r12 = r11.getHomeFenceScanResults();
    L18:
        r10.onFenceEnter(r12);
        this.mWifiFenceMonitor.start(r8);
        if (this.mHasFirstEnterFence == true) goto L22;
        getWifiPrefs().edit().putInt(KEY_HAS_ALREADY_ENTER_FENCE, 1).apply();
        this.mHasFirstEnterFence = true;
    L22:
        if (this.mWifiConnectionState != 1) goto L28;
        CommSenseLog.i(TAG, "start scan if wifi connected before enter geofense");
        startConnectionTriggeredScan(this.mWifiConnectionState);
        return;
    L28:
        return;
    L17:
        r12 = r11.getCompanyFenceScanResults();
        goto L18
    L5:
        if (r8 == 3) goto L14;
        if (r8 != 2) goto L10;
    L11:
        this.mConnectedTriggeredFenceKey = 0;
        this.mConnectedTriggeredScanCountToday = 0;
        CommSenseLog.i(TAG, "Reset connected-triggered scan counter on fence exit: day=" + this.mConnectedTriggeredScanDay);
        this.mWifiScanStateMachine.onFenceExit();
        if (this.mWifiFenceMonitor.isRunning() == false) goto L26;
        this.mWifiFenceMonitor.stop();
        return;
    L26:
        return;
    L10:
        if (r8 == 4) goto L11;
    }

    public static /* synthetic */ void e(WifiAwareInfoManager r8) {
        r8.lambda$new$0();
    }

    public static /* synthetic */ void f(WifiAwareInfoManager r8, Bundle r10) {
        r8.lambda$updateWifiConnectInfo$6(r10);
    }

    public static /* synthetic */ void g(WifiAwareInfoManager r8, List r10) {
        r8.lambda$setTrainingMode$8(r10);
    }

    public static synchronized WifiAwareInfoManager getInstance(Context r8) {
        monitor-enter(WifiAwareInfoManager.class);
        if (r8 != null) goto L17;
        monitor-exit(WifiAwareInfoManager.class);
        return null;
    L17:
    L14:
        th = move-exception;
        throw th;
    L9:
        if (sInstance != null) goto L11;
        sInstance = new WifiAwareInfoManager(r8.getApplicationContext());     // Catch: Throwable -> L14
    L11:
        WifiAwareInfoManager r10 = sInstance;     // Catch: Throwable -> L14
        monitor-exit(WifiAwareInfoManager.class);
        return r10;
    }

    private SharedPreferences getWifiPrefs() {
        return this.mContext.getSharedPreferences(PREF_WIFI_THRESHOLD, 0);
    }

    public static /* synthetic */ void h(WifiAwareInfoManager r8, List r10) {
        r8.lambda$startConnectionTriggeredScan$3(r10);
    }

    public static /* synthetic */ void i(WifiAwareInfoManager r8, List r10) {
        r8.lambda$startSingleHarDataCollection$10(r10);
    }

    public static /* synthetic */ void j(WifiAwareInfoManager r8, List r10) {
        r8.lambda$startSingleHarDataCollection$9(r10);
    }

    public static /* synthetic */ void k(WifiAwareInfoManager r8, List r10) {
        r8.lambda$setTrainingMode$7(r10);
    }

    private /* synthetic */ void lambda$new$0() {
        int r8 = this.mPendingStopConnectedScanHandleId;
        this.mPendingStopConnectedScanHandleId = -1;
        if (r8 > 0) goto L17;
        return;
    L17:
    L14:
        th = move-exception;
        CommSenseLog.w(TAG, "Stop connected-triggered scan failed: " + th.getMessage());
        return;
    L6:
        if (this.mConcurrentWifiScanner != null) goto L8;
        return;
    L8:
        ConcurrentWifiScanner.RequestHandle r10 = this.mWifiConnectedStateChangeTriggeredScanHandle;     // Catch: Throwable -> L14
        if (r10 != null) goto L11;
        return;
    L11:
        if (r10.getId() != r8) goto L20;
        CommSenseLog.i(TAG, "Stop connected-triggered scan after enter-room delay, handleId=" + r8);     // Catch: Throwable -> L14
        this.mConcurrentWifiScanner.stopScan(r10);     // Catch: Throwable -> L14
        return;
    }

    private /* synthetic */ void lambda$notifyGeofenceChanged$5(int r8) {
        this.mGeofenceEventDelaySorter.onGeofenceEvent(r8);
    }

    private /* synthetic */ void lambda$setTrainingMode$7(List r8) {
        handleWifiScanResults(r8);
    }

    private /* synthetic */ void lambda$setTrainingMode$8(List r8) {
        this.mHandler.post(new x(8, this, r8));
    }

    private /* synthetic */ void lambda$startConnectionTriggeredScan$1(List r8) {
        handleWifiScanResults(r8);
    }

    private /* synthetic */ void lambda$startConnectionTriggeredScan$2(List r8) {
        this.mHandler.post(new androidx.appcompat.app.r(21, this, r8));
    }

    private /* synthetic */ void lambda$startConnectionTriggeredScan$3(List r8) {
        handleWifiScanResults(r8);
    }

    private /* synthetic */ void lambda$startConnectionTriggeredScan$4(List r8) {
        this.mHandler.post(new u(this, r8, 1));
    }

    private /* synthetic */ void lambda$startSingleHarDataCollection$10(List r8) {
        this.mHandler.post(new u(this, r8, 0));
    }

    private /* synthetic */ void lambda$startSingleHarDataCollection$9(List r8) {
        handleWifiScanResults(r8);
    }

    private /* synthetic */ void lambda$updateWifiConnectInfo$6(Bundle r8) {
        processWifiConnectInfo(r8);
    }

    private void loadDropThresholds() {
        JSONObject r8 = loadJsonFromPrefs(KEY_DROP_LIST_JSON);
        this.mDropThresholdList.clear();     // Catch: JSONException -> L12
        Iterator<String> r10 = r8.keys();     // Catch: JSONException -> L12
    L5:
        if (r10.hasNext() == false) goto L8;
        JSONObject r11 = r8.getJSONObject(r10.next());     // Catch: JSONException -> L12
        int r12 = r11.getInt("durationSec");     // Catch: JSONException -> L12
        int r13 = r11.getInt("dropDb");     // Catch: JSONException -> L12
        this.mDropThresholdList.add(new RssiDropThreshold(r12, r13));     // Catch: JSONException -> L12
        goto L5
    L8:
        if (this.mDropThresholdList.size() > 0) goto L10;
        this.mDropThresholdList.add(new RssiDropThreshold(2, 9));     // Catch: JSONException -> L12
        this.mDropThresholdList.add(new RssiDropThreshold(10, 10));     // Catch: JSONException -> L12
        this.mDropThresholdList.add(new RssiDropThreshold(5, 17));     // Catch: JSONException -> L12
    L10:
        this.mWifiScanStateMachine.setRssiDropThresholdList(this.mDropThresholdList);     // Catch: JSONException -> L12
        return;
    L12:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to load drop thresholds", e);
    }

    private JSONObject loadJsonFromPrefs(String r8) {
        return new JSONObject(getWifiPrefs().getString(r8, "{}"));
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to parse JSON from prefs key=" + r8, e);
        return new JSONObject();
    }

    private void loadRssiThresholds() {
        JSONObject r8 = loadJsonFromPrefs(KEY_BSSID_THRESHOLD_JSON);
        Iterator<String> r10 = r8.keys();     // Catch: JSONException -> L9
    L5:
        if (r10.hasNext() == false) goto L7;
        String r11 = r10.next();     // Catch: JSONException -> L9
        this.mThresholdMap.put(r11, Integer.valueOf(r8.getInt(r11)));     // Catch: JSONException -> L9
        goto L5
    L7:
        CommSenseLog.d(TAG, "Threshold map loaded.");     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "Error loading threshold map: ", e);
    }

    private void saveDropThresholds() {
        JSONObject r8 = new JSONObject();
        int r10 = 0;
    L11:
    L8:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to save drop thresholds", e);
        return;
    L4:
        if (r10 >= this.mDropThresholdList.size()) goto L6;
        RssiDropThreshold r11 = this.mDropThresholdList.get(r10);     // Catch: JSONException -> L8
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L8
        r12.put("durationSec", r11.durationSec);     // Catch: JSONException -> L8
        r12.put("dropDb", r11.dropDb);     // Catch: JSONException -> L8
        r8.put(String.valueOf(r10), r12);     // Catch: JSONException -> L8
        r10 = r10 + 1;     // Catch: JSONException -> L8
        goto L11
    L6:
        saveJsonToPrefs(KEY_DROP_LIST_JSON, r8);     // Catch: JSONException -> L8
    }

    private void saveJsonToPrefs(String r8, JSONObject r10) {
        getWifiPrefs().edit().putString(r8, r10.toString()).apply();
    }

    private void saveRssiThresholds() {
        JSONObject r8 = new JSONObject();
        Iterator<String> r10 = this.mThresholdMap.keySet().iterator();     // Catch: JSONException -> L9
    L5:
        if (r10.hasNext() == false) goto L7;
        String r11 = r10.next();     // Catch: JSONException -> L9
        r8.put(r11, this.mThresholdMap.get(r11));     // Catch: JSONException -> L9
        goto L5
    L7:
        saveJsonToPrefs(KEY_BSSID_THRESHOLD_JSON, r8);     // Catch: JSONException -> L9
        CommSenseLog.d(TAG, "Threshold map saved.");     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "Error saving threshold map: ", e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void startConnectionTriggeredScan(int r21) {
        if (this.mConcurrentWifiScanner != null) goto L7;
        CommSenseLog.e(TAG, "startConnectionTriggeredScan: mConcurrentWifiScanner is null");
        return;
    L7:
        if (isOutsideFenceState() == false) goto L10;
        CommSenseLog.i(TAG, "startConnectionTriggeredScan: skip in OutsideFenceState");
        return;
    L10:
        WifiScanStateMachine r8 = this.mWifiScanStateMachine;
        if (r8 == null) goto L13;
        r8.isLearningSuccess();
    L13:
        long r10 = 60000;
        boolean r11 = true;
        boolean r12 = false;
        boolean r13 = false;
        r12 = false;
        if (r21 != 0) goto L23;
        long r14 = WifiScanStateMachine.getThrottledScanIntervalMs(this.mContext);
        if (this.mCurrentGeofenceState == 1) goto L19;
        r11 = false;
    L19:
        if (r11 == true) goto L22;
        r10 = 20000;
    L22:
        long r15 = r10;
        CommSenseLog.d(TAG, "Start triggered scan(disconnected): interval=" + r14 + "ms, duration=" + r15 + "ms, geofenceState=" + this.mCurrentGeofenceState);
        this.mLastTriggeredSceneType = 4;
        this.mWifiConnectedStateChangeTriggeredScanHandle = this.mConcurrentWifiScanner.startScan(r14, r15, new t(this, r12 ? 1 : 0), true);
        this.mCurrentConnectedBssid = null;
        this.mLastDisconnectTs = System.currentTimeMillis();
        return;
    L23:
        WifiManager r16 = this.mWifiManager;
        if (r16 != null) goto L27;
        CommSenseLog.w(TAG, "startConnectionTriggeredScan: mWifiManager is null");
        return;
    L27:
        WifiInfo r17 = r16.getConnectionInfo();
        if (r17 != null) goto L31;
        CommSenseLog.w(TAG, "startConnectionTriggeredScan: wifiInfo is null");
        return;
    L31:
        this.mCurrentConnectedBssid = r17.getBSSID();
        if (this.mLastDisconnectTs != 0) goto L34;
    L37:
        Object[] r18 = true;
    L38:
        if (r18 == false) goto L45;
        CommSenseLog.i(TAG, "startConnectionTriggeredScan: avoid roming and swithc network to scan");
        ConcurrentWifiScanner.RequestHandle r19 = this.mWifiConnectedStateChangeTriggeredScanHandle;
        if (r19 == null) goto L42;
        r13 = this.mConcurrentWifiScanner.stopScan(r19);
        this.mWifiConnectedStateChangeTriggeredScanHandle = null;
    L42:
        if (r13 == false) goto L74;
        this.mWifiScanStateMachine.resumeRssiTriggeredScanIfNeeded();
        return;
    L74:
        return;
    L45:
        int r20 = 2;
        if (this.mCurrentGeofenceState != 1) goto L49;
        int r22 = 1;
    L52:
        String r23 = this.mDayFormat.format(Long.valueOf(System.currentTimeMillis()));
        if (TextUtils.equals(r23, this.mConnectedTriggeredScanDay) == true) goto L56;
        this.mConnectedTriggeredScanDay = r23;
        this.mConnectedTriggeredScanCountToday = 0;
        this.mConnectedTriggeredFenceKey = r22;
    L56:
        if (this.mConnectedTriggeredFenceKey == r22) goto L58;
        this.mConnectedTriggeredFenceKey = r22;
        this.mConnectedTriggeredScanCountToday = 0;
    L58:
        if (r22 == 0) goto L60;
        Object[] r24 = true;
    L61:
        if (r24 == true) goto L63;
    L65:
        long r110 = WifiScanStateMachine.getThrottledScanIntervalMs(this.mContext);
        if (r12 == false) goto L68;
        r10 = 6000;
    L68:
        CommSenseLog.d(TAG, "Start triggered scan(connected): interval=" + r110 + "ms, duration=" + r10 + "ms, onlyOnce=" + r12 + ", fenceKey=" + r22 + ", todayCount=" + this.mConnectedTriggeredScanCountToday);
        this.mLastTriggeredSceneType = 5;
        ConcurrentWifiScanner.RequestHandle r25 = this.mConcurrentWifiScanner.startScan(r110, r10, new e(this, r20), r12);
        this.mWifiConnectedStateChangeTriggeredScanHandle = r25;
        if (r25 == null) goto L72;
        if (r24 == false) goto L72;
        this.mConnectedTriggeredScanCountToday++;
    L72:
        this.mLastDisconnectTs = 0;
        return;
    L63:
        if (this.mConnectedTriggeredScanCountToday < 2) goto L65;
        r12 = true;
        goto L65
    L60:
        r24 = false;
        goto L61
    L49:
        if (this.mCurrentGeofenceState != 3) goto L51;
        r22 = 2;
        goto L52
    L51:
        r22 = 0;
        goto L52
    L34:
        if ((System.currentTimeMillis() - this.mLastDisconnectTs) <= 5000) goto L37;
        r18 = false;
        goto L38
    }

    public void addBssidsToAvoidRomingScan(List<String> r8) {
        Iterator<String> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        String r11 = r10.next();
        if (this.mAvoidRomingConnectedBssids.contains(r11) == true) goto L8;
        this.mAvoidRomingConnectedBssids.add(r11);
        StringBuilder r12 = new StringBuilder("add BSSID for avoid roming scan: ");
    L9:
        r12.append(r11);
        CommSenseLog.i(TAG, r12.toString());
        goto L4
    L8:
        r12 = new StringBuilder("This BSSID has already been added to the list : ");
        goto L9
    }

    public void cleanBssidsToAvoidRomingScan() {
        this.mAvoidRomingConnectedBssids.clear();
        CommSenseLog.i(TAG, "clean BSSID for avoid roming scan");
    }

    public void clearAllRssiThresholds() {
        CommSenseLog.d(TAG, "clearAllRssiThresholds");
        this.mThresholdMap.clear();
        saveRssiThresholds();
    }

    public void clearRssiDropThresholds() {
        this.mDropThresholdList.clear();
        this.mWifiScanStateMachine.setRssiDropThresholdList(this.mDropThresholdList);
        getWifiPrefs().edit().remove(KEY_DROP_LIST_JSON).apply();
    }

    public List<String> getBssidsToAvoidRomingScan() {
        return this.mAvoidRomingConnectedBssids;
    }

    public String getCurrentConnectedBssid() {
        return this.mCurrentConnectedBssid;
    }

    public int getLastScanSceneType() {
        return this.mLastTriggeredSceneType;
    }

    public List<RssiDropThreshold> getRssiDropThresholds() {
        return new ArrayList(this.mDropThresholdList);
    }

    public List<BssidThreshold> getRssiThresholds() {
        ArrayList r8 = new ArrayList();
        Iterator<String> r10 = this.mThresholdMap.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        String r11 = r10.next();
        r8.add(new BssidThreshold(r11, this.mThresholdMap.get(r11).intValue()));
        goto L4
    L6:
        return r8;
    }

    public Set<Map<String, Integer>> getSavedPnoNetworkSetForFence(int r8) {
        PnoSavedNetworkStore r10 = this.mPnoSavedNetworkStore;
        if (r10 == null) goto L6;
        return r10.getSavedPnoNetworkSetForFence(r8);
    L6:
        return Collections.emptySet();
    }

    public int getThresholdForBssid(String r8) {
        Integer r10 = this.mThresholdMap.get(r8);
        if (r10 != null) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return r10.intValue();
    }

    public WifiStandardData getWifiConnectInfo() {
        return this.mWifiConnectInfo;
    }

    public int getWifiConnectionState() {
        return this.mWifiConnectionState;
    }

    public WifiFenceMonitor getWifiFenceMonitor() {
        return this.mWifiFenceMonitor;
    }

    public List<WifiStandardData> getWifiRomingChanged() {
        return new ArrayList(this.mWifiRomingStandardDataList.values());
    }

    public List<WifiStandardData> getWifiScanInfo() {
        return this.mWifiScanStandardDataList;
    }

    public List<WifiStandardData> getWifiScanNeighborAp() {
        return this.mWifiScanNeighborAp;
    }

    public WifiScanStateMachine getWifiScanStateMachine() {
        return this.mWifiScanStateMachine;
    }

    public void handleWifiConnectionStateChanged(int r8) {
        this.mWifiConnectionState = r8;
        WifiAwareInfoMonitor r10 = this.mWifiAwareInfoMonitor;
        if (r10 == null) goto L8;
        if (r8 != 1) goto L6;
        boolean r11 = true;
    L7:
        r10.onWifiNetworkAvailable(r11);
        goto L8
    L6:
        r11 = false;
    L8:
        if (r8 == 1) goto L10;
        if (r8 == 0) goto L10;
        return;
    L10:
        startConnectionTriggeredScan(r8);
        this.mWifiScanStateMachine.onWifiConnectStateChanged(r8);
    }

    @SuppressLint({"NewApi"})
    public void handleWifiScanResults(List<ScanResult> r12) {
        UserAwareManager r8 = UserAwareManager.getInstance();
        if (r8 != null) goto L6;
        CommSenseLog.e(TAG, "handleWifiScanResults: userAwareManager is null");
        return;
    L6:
        CommSenseLog.i(TAG, "handleWifiScanResults: " + r12.size());
        this.mWifiScanStandardDataList.clear();
        this.mWifiScanNeighborAp.clear();
        this.mWifiFenceMonitor.handleScanResults(r12);
        Set<String> r10 = this.mWifiFenceMonitor.getHomeBssids();
        Iterator<ScanResult> r11 = r12.iterator();
        boolean r13 = false;
    L7:
        int r14 = 1;
        if (r11.hasNext() == false) goto L36;
        ScanResult r15 = r11.next();
        if (TextUtils.isEmpty(r15.BSSID) == true) goto L17;
        WifiStandardData r16 = this.mLastWifiConnectInfo;
        if (r16 == null) goto L17;
        if (r15.BSSID.equals(r16.getBssid()) == false) goto L17;
        r13 = true;
    L17:
        if (CaelibUtils.is24GHz(r15.frequency) == false) goto L20;
    L23:
        WifiStandardData r17 = new WifiStandardData.Builder().setTimestamp(System.currentTimeMillis()).setSsid(r15.SSID).setBssid(r15.BSSID).setFrequency(r15.frequency).setBand(r14).setRssi(r15.level).setSignalLevel(WifiManager.calculateSignalLevel(r15.level, 5)).setAuthType(CaelibUtils.getWiFiAuthTypeFromScanResult(r15)).setApType(0).setApStandard(r15.getWifiStandard()).build();
        this.mWifiScanStandardDataList.add(r17);
        if (r10.contains(r17.getBssid()) == true) goto L27;
        this.mWifiScanNeighborAp.add(r17);
    L27:
        if (r8.isRecording() == false) goto L29;
    L34:
        CommSenseLog.addTimeLog(r17.toString(), CommSenseLog.getRecordFile(this.mWifiScanFileKey));
    L35:
        r8.postHarLevel2Data(r17);
        goto L7
    L29:
        if (r8.isRecordingByCallback() == true) goto L34;
        if (r8.isHarLevel2DataRecording() == false) goto L35;
        if (AwareStateListener.isHarCollectLocal() == false) goto L35;
    L20:
        if (CaelibUtils.is5GHz(r15.frequency) == false) goto L22;
        r14 = 2;
        goto L23
    L22:
        r14 = 0;
        goto L23
    L36:
        NearElevator r18 = NearElevator.getInstance(this.mContext);
        if (r18 == null) goto L39;
        r18.pushWifiScanResult(r12);
    L39:
        WifiAwareInfoMonitor r19 = this.mWifiAwareInfoMonitor;
        if (r19 == null) goto L43;
        r19.onWifiScanNeighborApChanged(this.mWifiScanNeighborAp);
    L43:
        if (UserAwareManager.getInstance().isActiveRecording() == false) goto L46;
        CommSenseLog.d(TAG, "is recording wifi scan result, avoid report scan result to MemD");
        return;
    L46:
        if (r13 == false) goto L48;
    L54:
        WifiAwareInfoMonitor r110 = this.mWifiAwareInfoMonitor;
        if (r110 == null) goto L62;
        r110.onWifiScanInfoChanged(this.mWifiScanStandardDataList);
        return;
    L62:
        return;
    L48:
        if (this.mWifiConnectionState != 1) goto L54;
        WifiStandardData r111 = this.mLastWifiConnectInfo;
        if (r111 == null) goto L54;
        if (r111.getTimestamp() <= (System.currentTimeMillis() - 3500)) goto L54;
        CommSenseLog.d(TAG, "handleWifiScanResults: add last connect info to scan list");
        this.mWifiScanStandardDataList.add(this.mLastWifiConnectInfo);
        goto L54
    }

    public boolean isDoorTriggerBssidConnected(String r8) {
        if (this.mAvoidRomingConnectedBssids.isEmpty() == false) goto L7;
        return true;
    L7:
        return this.mAvoidRomingConnectedBssids.contains(r8);
    }

    public boolean isFastWifiScanEnabled() {
        return this.mFastWifiScanEnabled;
    }

    public boolean isInPredictedRoom() {
        return this.mInPredictedRoom;
    }

    public boolean isOutsideFenceState() {
        WifiScanStateMachine r8 = this.mWifiScanStateMachine;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.isOutsideFenceState() == false) goto L7;
        return true;
    }

    public boolean isPnoScanning() {
        WifiScanStateMachine r8 = this.mWifiScanStateMachine;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.isPnoScanning() == false) goto L7;
        return true;
    }

    public boolean isTrainingMode() {
        ConcurrentWifiScanner r8 = this.mConcurrentWifiScanner;
        if (r8 != null) goto L5;
        return false;
    L5:
        return r8.getTrainingMode();
    }

    public void notifyGeofenceChanged(int r8) {
        Handler r10 = this.mHandler;
        if (r10 == null) goto L5;
        r10.post(new com.obric.cae.libs.softap.d(r8, 1, this));
        return;
    L5:
        dispatchGeofenceEvent(r8);
    }

    public void notifyLearningSuccess(boolean r8) {
        CommSenseLog.i(TAG, "notifyLearningSuccess: " + r8);
        WifiScanStateMachine r10 = this.mWifiScanStateMachine;
        if (r10 == null) goto L6;
        r10.setLearningSuccess(r8);
        return;
    }

    public void notifyRoomChangedPredicted(int r8) {
        if (r8 != 1) goto L13;
        CommSenseLog.i(TAG, "receive enter room predicted event");
        this.mInPredictedRoom = true;
        this.mWifiScanStateMachine.onEnterHome();
        this.mWifiFenceMonitor.onEnterHome();
        if (this.mHandler != null) goto L7;
        return;
    L7:
        if (this.mConcurrentWifiScanner != null) goto L9;
        return;
    L9:
        if (this.mLastTriggeredSceneType != 5) goto L17;
        ConcurrentWifiScanner.RequestHandle r10 = this.mWifiConnectedStateChangeTriggeredScanHandle;
        if (r10 == null) goto L18;
        this.mPendingStopConnectedScanHandleId = r10.getId();
        this.mHandler.removeCallbacks(this.mStopConnectedTriggeredScanRunnable);
        this.mHandler.postDelayed(this.mStopConnectedTriggeredScanRunnable, 5000);
        CommSenseLog.i(TAG, "Schedule stop connected-triggered scan in 5000ms, handleId=" + this.mPendingStopConnectedScanHandleId);
        return;
    L18:
        return;
    L17:
        return;
    L13:
        CommSenseLog.i(TAG, "receive exit room predicted event");
        this.mInPredictedRoom = false;
        this.mWifiScanStateMachine.onExitHome();
        this.mWifiFenceMonitor.onExitHome();
    }

    public void processWifiConnectInfo(Bundle r10) {
        String r8 = UserAwareUtil.removeDoubleQuotes(r10.getString("ssid"));
        String r11 = r10.getString(WiFiDBHelper.COL_BSSID);
        int r12 = r10.getInt("frequency");
        int r13 = r10.getInt(WiFiDBHelper.COL_RSSI);
        if (CaelibUtils.is24GHz(r12) == false) goto L6;
        int r14 = 1;
    L10:
        if (this.mThresholdMap.containsKey(r11) == true) goto L12;
    L13:
        this.mWifiScanStateMachine.onRssiChanged(r13);
    L14:
        WifiStandardData r15 = new WifiStandardData.Builder().setTimestamp(r10.getLong("timestamp")).setBssid(r11).setSsid(r8).setFrequency(r12).setBand(r14).setRssi(r13).setSignalLevel(WifiManager.calculateSignalLevel(r13, 5)).setDataflow(r10.getInt("totalBytes")).setUseTime(r10.getLong("usedTime")).setAuthType(r10.getInt("authType")).setApType(r10.getInt("apType")).setApStandard(r10.getInt("apStandard")).build();
        this.mLastWifiConnectInfo = r15;
        PnoSavedNetworkStore r16 = this.mPnoSavedNetworkStore;
        if (r16 == null) goto L17;
        r16.maybeSaveForGeofenceEvent(this.mCurrentGeofenceState, r8, r12);
    L17:
        WifiAwareInfoMonitor r17 = this.mWifiAwareInfoMonitor;
        if (r17 == null) goto L21;
        r17.onWifiConnectInfoChanged(r15);
    L21:
        if (TextUtils.equals(r8, this.mLastConnectedSsid) == true) goto L27;
        if (this.mWifiRomingStandardDataList.isEmpty() == true) goto L27;
        this.mWifiRomingStandardDataList.clear();
    L29:
        this.mLastConnectedSsid = r8;
        UserAwareManager r18 = UserAwareManager.getInstance();
        if (r18 != null) goto L33;
        return;
    L33:
        if (r18.isRecording() == false) goto L35;
    L40:
        CommSenseLog.addTimeLog(r15.toString() + ", Connected", CommSenseLog.getRecordFile(this.mWifiScanFileKey));
    L41:
        r18.postHarLevel2Data(r15);
        return;
    L35:
        if (r18.isRecordingByCallback() == true) goto L40;
        if (r18.isHarLevel2DataRecording() == false) goto L41;
        if (AwareStateListener.isHarCollectLocal() == false) goto L41;
    L27:
        if (this.mWifiRomingStandardDataList.containsKey(r11) == true) goto L29;
        this.mWifiRomingStandardDataList.put(r11, r15);
        goto L29
    L12:
        if (r13 > this.mThresholdMap.get(r11).intValue()) goto L14;
    L6:
        if (CaelibUtils.is5GHz(r12) == false) goto L8;
        r14 = 2;
        goto L10
    L8:
        r14 = 0;
        goto L10
    }

    public void recordWifiFile(String r8, File r10) {
        this.mWifiScanFileKey = r8;
        CommSenseLog.recordFileWithKey(r8, r10);
    }

    public void registerWifiAwareInfoMonitor(WifiAwareInfoMonitor r8) {
        if (r8 != null) goto L5;
        CommSenseLog.e(TAG, "registerWifiAwareInfoMonitor: monitor is null");
        return;
    L5:
        this.mWifiAwareInfoMonitor = r8;
    }

    public void removeBssidsToAvoidRomingScan(List<String> r8) {
        Iterator<String> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        String r11 = r10.next();
        if (this.mAvoidRomingConnectedBssids.contains(r11) == false) goto L8;
        this.mAvoidRomingConnectedBssids.remove(r11);
        StringBuilder r12 = new StringBuilder("remove BSSID for avoid roming scan: ");
    L9:
        r12.append(r11);
        CommSenseLog.i(TAG, r12.toString());
        goto L4
    L8:
        r12 = new StringBuilder("This BSSID is no longer in the list: ");
        goto L9
    }

    public void removeRssiThresholds(List<String> r8) {
        Iterator<String> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        String r11 = r10.next();
        CommSenseLog.d(TAG, "removeRssiThresholds: " + r11);
        this.mThresholdMap.remove(r11);
        goto L4
    L6:
        saveRssiThresholds();
    }

    public void setEnableWifiScanFunction(boolean r8) {
        this.mFunctionEnabled = r8;
    }

    public void setFastWifiScanEnabled(boolean r8) {
        CommSenseLog.e(TAG, "unsupport setFastWifiScanEnabled can use setTrainingMode instead");
    }

    public void setRssiDropThresholds(List<RssiDropThreshold> r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.mDropThresholdList.clear();
        Iterator<RssiDropThreshold> r10 = r8.iterator();
    L6:
        if (r10.hasNext() == false) goto L12;
        RssiDropThreshold r11 = r10.next();
        if (r11.durationSec <= 0) goto L6;
        if (r11.dropDb <= 0) goto L6;
        this.mDropThresholdList.add(r11);
        goto L6
    L12:
        this.mWifiScanStateMachine.setRssiDropThresholdList(this.mDropThresholdList);
        saveDropThresholds();
    }

    public void setRssiThresholds(List<BssidThreshold> r8) {
        Iterator<BssidThreshold> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        BssidThreshold r11 = r10.next();
        CommSenseLog.d(TAG, "setRssiThresholds: " + r11.bssid + " " + r11.threshold);
        String r12 = r11.bssid;
        if (r12 == null) goto L4;
        this.mThresholdMap.put(r12, Integer.valueOf(r11.threshold));
        goto L4
    L8:
        saveRssiThresholds();
    }

    public void setTrainingMode(boolean r8) {
        this.mConcurrentWifiScanner.setTrainingMode(r8, new v(this, 2));
    }

    public void setWifiRssiTriggerThresholds(int r8, int r10, int r11, int r12, int r13) {
        WifiScanStateMachine r14 = this.mWifiScanStateMachine;
        if (r14 == null) goto L6;
        r14.setRssiTriggerThresholds(r8, r10, r11, r12, r13);
        return;
    }

    public void startSingleHarDataCollection(int r10, int r11) {
        CommSenseLog.d(TAG, "startSingleHarDataCollection");
        this.mConcurrentWifiScanner.startUnrestrictedSingleScan(r10, r11, new t(this, 1));
    }

    public void startWifiRecord(boolean r8) {
        if (this.mIsWifiRecording.get() != r8) goto L5;
        return;
    L5:
        this.mIsWifiRecording.set(r8);
        CommSenseLog.d(TAG, "startWifiRecord: " + r8);
        setTrainingMode(r8);
    }

    public void updateWifiConnectInfo(Bundle r8) {
        CommSenseLog.d(TAG, "updateWifiConnectInfo, mHasFirstEnterFence = " + this.mHasFirstEnterFence + ", mFunctionEnabled = " + this.mFunctionEnabled);
        if (this.mHasFirstEnterFence == false) goto L7;
        if (this.mFunctionEnabled == false) goto L7;
    L8:
        this.mHandler.post(new androidx.appcompat.app.r(20, this, r8));
        return;
    L7:
        if (this.mIsWifiRecording.get() == true) goto L8;
    }
}
