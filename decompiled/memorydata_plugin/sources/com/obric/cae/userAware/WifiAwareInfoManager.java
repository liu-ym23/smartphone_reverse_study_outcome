package com.obric.cae.userAware;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.cae.libs.statemachine.d;
import com.obric.cae.libs.useraware.BssidThreshold;
import com.obric.cae.libs.useraware.RssiDropThreshold;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.log.a;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class WifiAwareInfoManager {
    private static final int ALREADY_ENTER_FENCE = 1;
    static final int COMPANY_DROP_THRESHOLD_DB = 10;
    static final int COMPANY_DROP_WINDOW_SEC = 10;
    private static final boolean DEFAULT_ALREADY_ENTER_FENCE = true;
    public static final int ENTER_GEOFENCE_EVENT = 1;
    public static final int EXIT_GEOFENCE_EVENT = 2;
    private static final long GEOFENCE_EVENT_DELAY_MS = 500;
    static final int HOME_CHANGE_THRESHOLD_DB = 9;
    static final int HOME_CHANGE_WINDOW_SEC = 2;
    static final int HOME_DROP_THRESHOLD_DB = 17;
    static final int HOME_DROP_WINDOW_SEC = 5;
    private static final String KEY_BSSID_THRESHOLD_JSON = "bssid_threshold_json";
    private static final String KEY_HAS_ALREADY_ENTER_FENCE = "has_already_enter_fence";
    private static final int NOT_ENTER_FENCE = 0;
    public static final int PREDICTED_ENTER_ROOM_EVENT = 1;
    public static final int PREDICTED_EXIT_ROOM_EVENT = 2;
    private static final String PREF_WIFI_THRESHOLD = "cae_wifi_threshold_prefs";
    private static final String TAG = "WifiAwareInfoManager";
    public static final int WIFI_CONNECTION_STATE_CONNECTED = 1;
    public static final int WIFI_CONNECTION_STATE_DISCONNECTED = 0;
    private static volatile WifiAwareInfoManager sInstance;
    private List<String> mAvoidRomingConnectedBssids;
    private ConcurrentWifiScanner mConcurrentWifiScanner;
    private Context mContext;
    private volatile int mCurrentGeofenceState;
    private final List<RssiDropThreshold> mDropThresholdList;
    private final Object mDropThresholdLock;
    private boolean mFastWifiScanEnabled;
    public boolean mFunctionEnabled;
    private final GeofenceEventDelaySorter mGeofenceEventDelaySorter;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    public boolean mHasFirstEnterFence;
    private volatile boolean mInPredictedRoom;
    private final AtomicBoolean mIsWifiRecording;
    private String mLastConnectedSsid;
    private WifiStandardData mLastWifiConnectInfo;
    private boolean mLoggedWifiConnectInfoSkipByFunctionDisabled;
    private final PnoSavedNetworkStore mPnoSavedNetworkStore;
    private WifiScanConfigProvider mScanConfigProvider;
    private UserAwareService mService;
    private StepCounterCallback mStepCounterCallback;
    private final Map<String, Integer> mThresholdMap;
    private WifiAwareInfoMonitor mWifiAwareInfoMonitor;
    private WifiStandardData mWifiConnectInfo;
    private WifiConnectionScanController mWifiConnectionScanController;
    private int mWifiConnectionState;
    private WifiFenceMonitor mWifiFenceMonitor;
    private WifiManager mWifiManager;
    private Map<String, WifiStandardData> mWifiRomingStandardDataList;
    private String mWifiScanFileKey;
    private List<WifiStandardData> mWifiScanNeighborAp;
    private List<WifiStandardData> mWifiScanStandardDataList;
    private WifiScanStateMachine mWifiScanStateMachine;
    private WifiSceneScanController mWifiSceneScanController;

    public class StepCounterCallback extends InnerAwareInfoCallback {
        final /* synthetic */ WifiAwareInfoManager this$0;

        private StepCounterCallback(WifiAwareInfoManager r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ StepCounterCallback(WifiAwareInfoManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onStepsCounterChanged(int r2) {
            a.c(WifiAwareInfoManager.TAG, "onStepsCounterChanged : " + r2);
        }
    }

    private WifiAwareInfoManager(Context r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        this.mInPredictedRoom = false;
        this.mWifiScanStandardDataList = new ArrayList();
        this.mWifiScanNeighborAp = new ArrayList();
        this.mWifiRomingStandardDataList = new HashMap();
        this.mFastWifiScanEnabled = false;
        this.mThresholdMap = new HashMap();
        this.mDropThresholdLock = new Object();
        this.mDropThresholdList = new ArrayList();
        this.mWifiScanFileKey = "";
        this.mWifiConnectionState = 0;
        this.mHasFirstEnterFence = true;
        this.mFunctionEnabled = false;
        this.mLoggedWifiConnectInfoSkipByFunctionDisabled = false;
        this.mAvoidRomingConnectedBssids = new ArrayList();
        this.mIsWifiRecording = new AtomicBoolean(false);
        this.mCurrentGeofenceState = -1;
        this.mContext = ZeusTransformUtils.wrapperContext(r14, "com.obric.memorydata.plugin");
        this.mWifiManager = (WifiManager) ZeusTransformUtils.preCheckCast(r14.getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");
        HandlerThread r3 = new HandlerThread("WifiAwareHandlerThread");
        this.mHandlerThread = r3;
        r3.start();
        Handler r6 = new Handler(this.mHandlerThread.getLooper());
        this.mHandler = r6;
        this.mGeofenceEventDelaySorter = new GeofenceEventDelaySorter(r6, GEOFENCE_EVENT_DELAY_MS, TAG, new AnonymousClass1(this), new AnonymousClass2(this));
        this.mPnoSavedNetworkStore = new PnoSavedNetworkStore(this.mContext);
        if (getWifiPrefs().getInt(KEY_HAS_ALREADY_ENTER_FENCE, 1) != 1) goto L5;
        boolean r4 = true;
    L6:
        this.mHasFirstEnterFence = r4;
        Context r5 = this.mContext;
        if (AwareStateListener.getEnableWifiScanFunction(r5, r5.getContentResolver()) != 1) goto L9;
        r0 = true;
    L9:
        this.mFunctionEnabled = r0;
        a.e(TAG, "Init wifi scan function: scope=" + UserAwareUtil.getHostSettingsScope(this.mContext) + ", enabled=" + this.mFunctionEnabled + ", hasFirstEnterFence=" + this.mHasFirstEnterFence);
        this.mConcurrentWifiScanner = new ConcurrentWifiScanner(r14, this);
        this.mWifiSceneScanController = new WifiSceneScanController(new ConcurrentWifiScanTrigger(new $$Lambda$WifiAwareInfoManager$G4sj3zeLfUT4XEDpE3sSkPrzY(this)), new $$Lambda$WifiAwareInfoManager$WlzT5ZYtGjBSrK7eXXMw2dX3mjk(this), new $$Lambda$WifiAwareInfoManager$_pbPqNnDNMAvDNwdD75V06foXns(this));
        this.mWifiScanStateMachine = new WifiScanStateMachine(this.mContext, this, this.mConcurrentWifiScanner);
        getScanConfigProvider().registerUpdateListener(new $$Lambda$WifiAwareInfoManager$WAi38b4q9NPtWo8dLzRT3qSrUx8(this));
        this.mWifiConnectionScanController = new WifiConnectionScanController(new AnonymousClass3(this));
        this.mWifiFenceMonitor = new WifiFenceMonitor(this.mContext, this.mWifiScanStateMachine, null);
        this.mStepCounterCallback = new StepCounterCallback(this, null);
        UserAwareService r15 = (UserAwareService) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(UserAwareService.getService(), "com.obric.memorydata.plugin"), UserAwareService.class, "com.obric.memorydata.plugin");
        this.mService = r15;
        if (r15 == null) goto L12;
        UserAwareManager.getInstance().registerInnerCallback(this.mStepCounterCallback);
    L12:
        loadRssiThresholds();
        initDropThresholdsFromProvider();
        return;
    L5:
        r4 = false;
        goto L6
    }

    public static /* synthetic */ int access$000(WifiAwareInfoManager r0) {
        return r0.mCurrentGeofenceState;
    }

    public static /* synthetic */ void access$100(WifiAwareInfoManager r0, int r1) {
        r0.dispatchGeofenceEvent(r1);
    }

    public static /* synthetic */ Context access$200(WifiAwareInfoManager r0) {
        return r0.mContext;
    }

    public static /* synthetic */ Handler access$300(WifiAwareInfoManager r0) {
        return r0.mHandler;
    }

    public static /* synthetic */ WifiManager access$400(WifiAwareInfoManager r0) {
        return r0.mWifiManager;
    }

    public static /* synthetic */ ConcurrentWifiScanner access$500(WifiAwareInfoManager r0) {
        return r0.mConcurrentWifiScanner;
    }

    public static /* synthetic */ WifiScanStateMachine access$600(WifiAwareInfoManager r0) {
        return r0.mWifiScanStateMachine;
    }

    private void dispatchGeofenceEvent(int r4) {
        a.e(TAG, "notifyGeofenceChanged(dispatch): event -- " + r4);
        this.mCurrentGeofenceState = r4;
        this.mWifiFenceMonitor.onExitHome();
        this.mWifiScanStateMachine.updateFenceState(r4);
        if (r4 != 1) goto L5;
    L17:
        this.mWifiScanStateMachine.onFenceEnter();
        this.mWifiFenceMonitor.start(r4);
        if (this.mHasFirstEnterFence == true) goto L21;
        getWifiPrefs().edit().putInt(KEY_HAS_ALREADY_ENTER_FENCE, 1).apply();
        this.mHasFirstEnterFence = true;
    L21:
        if (this.mWifiConnectionState != 1) goto L29;
        a.e(TAG, "start scan if wifi connected before enter geofense");
        WifiConnectionScanController r5 = this.mWifiConnectionScanController;
        if (r5 == null) goto L30;
        r5.startForCurrentConnectionState(this.mWifiConnectionState);
        return;
    L30:
        return;
    L29:
        return;
    L5:
        if (r4 == 3) goto L17;
        if (r4 != 2) goto L10;
    L11:
        WifiConnectionScanController r6 = this.mWifiConnectionScanController;
        if (r6 == null) goto L14;
        r6.resetConnectedScanCounterOnFenceExit();
    L14:
        this.mWifiScanStateMachine.onFenceExit();
        if (this.mWifiFenceMonitor.isRunning() == false) goto L27;
        this.mWifiFenceMonitor.stop();
        return;
    L27:
        return;
    L10:
        if (r4 == 4) goto L11;
    }

    public static synchronized WifiAwareInfoManager getInstance(Context r4) {
        monitor-enter(WifiAwareInfoManager.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r5 != null) goto L10;
        monitor-exit(WifiAwareInfoManager.class);
        return null;
    L10:
        if (sInstance != null) goto L12;
        sInstance = new WifiAwareInfoManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
    L12:
        WifiAwareInfoManager r6 = sInstance;     // Catch: Throwable -> L15
        monitor-exit(WifiAwareInfoManager.class);
        return r6;
    L15:
        th = move-exception;
        throw th;
    }

    private WifiScanConfigProvider getScanConfigProvider() {
        if (this.mScanConfigProvider != null) goto L6;
        this.mScanConfigProvider = WifiScanConfigProvider.getInstance(this.mContext);
    L6:
        return this.mScanConfigProvider;
    }

    private SharedPreferences getWifiPrefs() {
        return this.mContext.getSharedPreferences(PREF_WIFI_THRESHOLD, 0);
    }

    private void initDropThresholdsFromProvider() {
        refreshDropThresholds(getScanConfigProvider().getActiveConfigSnapshot());
    }

    public static /* synthetic */ void lambda$WAi38b4q9NPtWo8dLzRT3qSrUx8(WifiAwareInfoManager r0, WifiScanConfigProvider.ActiveConfigSnapshot r1) {
        r0.refreshDropThresholds(r1);
    }

    public static /* synthetic */ void lambda$_pbPqNnDNMAvDNwdD75V06foXns(WifiAwareInfoManager r0, List r1, WifiScanAttribution r2) {
        r0.postHandleWifiScanResults(r1, r2);
    }

    private JSONObject loadJsonFromPrefs(String r3) {
        return new JSONObject(getWifiPrefs().getString(r3, "{}"));
    L5:
        e = move-exception;
        a.a(TAG, "Failed to parse JSON from prefs key=" + r3, e);
        return new JSONObject();
    }

    private void loadRssiThresholds() {
        JSONObject r1 = loadJsonFromPrefs(KEY_BSSID_THRESHOLD_JSON);
        Iterator<String> r2 = r1.keys();     // Catch: JSONException -> L9
    L5:
        if (r2.hasNext() == false) goto L7;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L9
        this.mThresholdMap.put(r3, Integer.valueOf(r1.getInt(r3)));     // Catch: JSONException -> L9
        goto L5
    L7:
        a.c(TAG, "Threshold map loaded.");     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        a.a(TAG, "Error loading threshold map: ", e);
    }

    private void postHandleWifiScanResults(List<ScanResult> r3, final WifiScanAttribution r4) {
        final List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.mHandler.post(new $$Lambda$WifiAwareInfoManager$pQlm_gWbsm0GYXatkFGTJf5uvEk(this, r5, r4));
    }

    private void refreshDropThresholds(WifiScanConfigProvider.ActiveConfigSnapshot r5) {
        List<RssiDropThreshold> r6 = r5.getRssiDropThresholds();     // Catch: Throwable -> L18
        Object r1 = this.mDropThresholdLock;     // Catch: Throwable -> L18
        monitor-enter(r1);     // Catch: Throwable -> L18
        this.mDropThresholdList.clear();     // Catch: Throwable -> L15
        if (r6 == null) goto L8;
        this.mDropThresholdList.addAll(r6);     // Catch: Throwable -> L15
    L8:
        ArrayList r7 = new ArrayList(this.mDropThresholdList);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        WifiScanStateMachine r2 = this.mWifiScanStateMachine;     // Catch: Throwable -> L18
        if (r2 == null) goto L13;
        r2.setRssiDropThresholdList(r7);     // Catch: Throwable -> L18
    L13:
        a.c(TAG, "initDropThresholdsFromProvider: loaded " + r7.size() + " groups from scan-spec provider");     // Catch: Throwable -> L18
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        a.i(TAG, "initDropThresholdsFromProvider failed, fall back to original defaults: " + th);
        monitor-enter(this.mDropThresholdLock);
        this.mDropThresholdList.clear();     // Catch: Throwable -> L27
        this.mDropThresholdList.add(new RssiDropThreshold(2, 9));     // Catch: Throwable -> L27
        this.mDropThresholdList.add(new RssiDropThreshold(10, 10));     // Catch: Throwable -> L27
        this.mDropThresholdList.add(new RssiDropThreshold(5, 17));     // Catch: Throwable -> L27
        ArrayList r0 = new ArrayList(this.mDropThresholdList);     // Catch: Throwable -> L27
        WifiScanStateMachine r4 = this.mWifiScanStateMachine;
        if (r4 == null) goto L35;
        r4.setRssiDropThresholdList(r0);
        return;
    L35:
        return;
    L27:
        th = move-exception;
        throw th;
    }

    private void saveJsonToPrefs(String r1, JSONObject r2) {
        getWifiPrefs().edit().putString(r1, r2.toString()).apply();
    }

    private void saveRssiThresholds() {
        JSONObject r1 = new JSONObject();
        Iterator<String> r2 = this.mThresholdMap.keySet().iterator();     // Catch: JSONException -> L9
    L5:
        if (r2.hasNext() == false) goto L7;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L9
        r1.put(r3, this.mThresholdMap.get(r3));     // Catch: JSONException -> L9
        goto L5
    L7:
        saveJsonToPrefs(KEY_BSSID_THRESHOLD_JSON, r1);     // Catch: JSONException -> L9
        a.c(TAG, "Threshold map saved.");     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        a.a(TAG, "Error saving threshold map: ", e);
    }

    public void addBssidsToAvoidRomingScan(List<String> r6) {
        Iterator r7 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        if (this.mAvoidRomingConnectedBssids.contains(r0) == true) goto L8;
        this.mAvoidRomingConnectedBssids.add(r0);
        StringBuilder r2 = new StringBuilder("add BSSID for avoid roming scan: ");
    L9:
        a.e(TAG, r2.append(r0).toString());
        goto L4
    L8:
        r2 = new StringBuilder("This BSSID has already been added to the list : ");
        goto L9
    }

    public void cleanBssidsToAvoidRomingScan() {
        this.mAvoidRomingConnectedBssids.clear();
        a.e(TAG, "clean BSSID for avoid roming scan");
    }

    public synchronized void cleanup() {
        monitor-enter(this);
        WifiConnectionScanController r0 = this.mWifiConnectionScanController;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.cleanup();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void clearAllRssiThresholds() {
        a.c(TAG, "clearAllRssiThresholds");
        this.mThresholdMap.clear();
        saveRssiThresholds();
    }

    public void clearRssiDropThresholds() {
        Object r0 = this.mDropThresholdLock;
        monitor-enter(r0);
        this.mDropThresholdList.clear();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WifiScanStateMachine r2 = this.mWifiScanStateMachine;
        if (r2 == null) goto L15;
        r2.setRssiDropThresholdList(new ArrayList());
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public List<String> getBssidsToAvoidRomingScan() {
        return this.mAvoidRomingConnectedBssids;
    }

    public String getCurrentConnectedBssid() {
        WifiConnectionScanController r0 = this.mWifiConnectionScanController;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentConnectedBssid();
    }

    public List<RssiDropThreshold> getRssiDropThresholds() {
        Object r0 = this.mDropThresholdLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mDropThresholdList);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<BssidThreshold> getRssiThresholds() {
        ArrayList r0 = new ArrayList();
        Iterator<String> r1 = this.mThresholdMap.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        r0.add(new BssidThreshold(r2, ((Integer) ZeusTransformUtils.preCheckCast(this.mThresholdMap.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue()));
        goto L4
    L6:
        return r0;
    }

    public Set<Map<String, Integer>> getSavedPnoNetworkSetForFence(int r1) {
        PnoSavedNetworkStore r0 = this.mPnoSavedNetworkStore;
        if (r0 == null) goto L6;
        return r0.getSavedPnoNetworkSetForFence(r1);
    L6:
        return Collections.emptySet();
    }

    public int getThresholdForBssid(String r2) {
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.mThresholdMap.get(r2), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return r1.intValue();
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

    public void handleWifiConnectionStateChanged(int r5) {
        int r0 = this.mWifiConnectionState;
        this.mWifiConnectionState = r5;
        WifiAwareInfoMonitor r1 = this.mWifiAwareInfoMonitor;
        if (r1 == null) goto L8;
        if (r5 != 1) goto L6;
        boolean r3 = true;
    L7:
        r1.onWifiNetworkAvailable(r3);
        goto L8
    L6:
        r3 = false;
    L8:
        if (r5 != 1) goto L13;
        WifiConnectionScanController r2 = this.mWifiConnectionScanController;
        if (r2 == null) goto L12;
    L11:
        r2.handleWifiConnectionStateChanged(r0, r5);
    L12:
        this.mWifiScanStateMachine.onWifiConnectStateChanged(r5);
        return;
    L13:
        if (r5 != 0) goto L18;
        r2 = this.mWifiConnectionScanController;
        if (r2 == null) goto L12;
    }

    public void handleWifiScanResults(List<ScanResult> r3) {
        handleWifiScanResults((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), WifiScanAttributionFactory.invalid());
    }

    public void handleWifiScanResults(List<ScanResult> r13, WifiScanAttribution r14) {
        List<ScanResult> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L6;
        r14 = WifiScanAttributionFactory.invalid();
    L6:
        UserAwareManager r0 = UserAwareManager.getInstance();
        if (r0 != null) goto L10;
        a.i(TAG, "handleWifiScanResults: userAwareManager is null");
        return;
    L10:
        a.e(TAG, "handleWifiScanResults: " + r15.size());
        this.mWifiScanStandardDataList.clear();
        this.mWifiScanNeighborAp.clear();
        this.mWifiFenceMonitor.handleScanResults(r15);
        Set<String> r3 = this.mWifiFenceMonitor.getHomeBssids();
        Iterator<ScanResult> r4 = r15.iterator();
        boolean r6 = false;
    L11:
        int r8 = 1;
        if (r4.hasNext() == false) goto L44;
        ScanResult r7 = (ScanResult) ZeusTransformUtils.preCheckCast(r4.next(), ScanResult.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r7.BSSID) == true) goto L21;
        WifiStandardData r9 = this.mLastWifiConnectInfo;
        if (r9 == null) goto L21;
        if (r7.BSSID.equals(r9.getBssid()) == false) goto L21;
        r6 = true;
    L21:
        if (com.obric.cae.libs.utils.a.a(r7.frequency) == false) goto L24;
    L27:
        WifiStandardData r10 = new WifiStandardData.a().a(System.currentTimeMillis()).b(r7.SSID).a(r7.BSSID).c(r7.frequency).d(r8).b(r7.level).a(WifiManager.calculateSignalLevel(r7.level, 5)).e(com.obric.cae.libs.utils.a.a(r7)).f(0).g(r7.getWifiStandard()).a();
        this.mWifiScanStandardDataList.add(r10);
        if (r3.contains(r10.getBssid()) == true) goto L31;
        this.mWifiScanNeighborAp.add(r10);
    L31:
        if (r0.isRecording() == true) goto L39;
        if (r0.isRecordingByCallback() == true) goto L39;
        if (r0.isHarLevel2DataRecording() == false) goto L43;
        if (AwareStateListener.isHarCollectLocal() == true) goto L39;
    L43:
        r0.postHarLevel2Data(r10);
    L39:
        if (SceneCollectionSessionContext.getInstance().shouldUseRawOutput() == false) goto L41;
        String r11 = r10.toUnmaskedString();
    L42:
        a.b(r11, a.b(this.mWifiScanFileKey));
        goto L43
    L41:
        r11 = r10.toString();
        goto L42
    L24:
        if (com.obric.cae.libs.utils.a.b(r7.frequency) == false) goto L26;
        r8 = 2;
        goto L27
    L26:
        r8 = 0;
        goto L27
    L44:
        NearElevator r1 = NearElevator.getInstance(this.mContext);
        if (r1 == null) goto L47;
        r1.pushWifiScanResult(r15);
    L47:
        WifiAwareInfoMonitor r16 = this.mWifiAwareInfoMonitor;
        if (r16 == null) goto L51;
        r16.onWifiScanNeighborApChanged(this.mWifiScanNeighborAp);
    L51:
        if (UserAwareManager.getInstance().isActiveRecording() == false) goto L54;
        a.c(TAG, "is recording wifi scan result, avoid report scan result to MemD");
        return;
    L54:
        if (r6 == false) goto L56;
    L62:
        WifiAwareInfoMonitor r17 = this.mWifiAwareInfoMonitor;
        if (r17 == null) goto L70;
        r17.onWifiScanInfoChanged(this.mWifiScanStandardDataList, r14);
        return;
    L70:
        return;
    L56:
        if (this.mWifiConnectionState != 1) goto L62;
        WifiStandardData r18 = this.mLastWifiConnectInfo;
        if (r18 == null) goto L62;
        if (r18.getTimestamp() <= (System.currentTimeMillis() - 3500)) goto L62;
        a.c(TAG, "handleWifiScanResults: add last connect info to scan list");
        this.mWifiScanStandardDataList.add(this.mLastWifiConnectInfo);
        goto L62
    }

    public boolean isDoorTriggerBssidConnected(String r2) {
        if (this.mAvoidRomingConnectedBssids.isEmpty() == false) goto L7;
        return true;
    L7:
        return this.mAvoidRomingConnectedBssids.contains(r2);
    }

    public boolean isFastWifiScanEnabled() {
        return this.mFastWifiScanEnabled;
    }

    public boolean isInPredictedRoom() {
        return this.mInPredictedRoom;
    }

    public boolean isOutsideFenceState() {
        WifiScanStateMachine r0 = this.mWifiScanStateMachine;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOutsideFenceState() == false) goto L7;
        return true;
    }

    public boolean isPnoScanning() {
        WifiScanStateMachine r0 = this.mWifiScanStateMachine;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isPnoScanning() == false) goto L7;
        return true;
    }

    public boolean isTrainingMode() {
        ConcurrentWifiScanner r0 = this.mConcurrentWifiScanner;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getTrainingMode();
    }

    public /* synthetic */ ConcurrentWifiScanner lambda$new$0$WifiAwareInfoManager() {
        return this.mConcurrentWifiScanner;
    }

    public /* synthetic */ void lambda$new$1$WifiAwareInfoManager(boolean r3, ConcurrentWifiScanner.AttributedScanCallback r4, WifiScanAttribution r5) {
        ConcurrentWifiScanner.AttributedScanCallback r6 = (ConcurrentWifiScanner.AttributedScanCallback) ZeusTransformUtils.wrapperContextForParams(r4, ConcurrentWifiScanner.AttributedScanCallback.class, "com.obric.memorydata.plugin");
        ConcurrentWifiScanner r2 = this.mConcurrentWifiScanner;
        if (r2 == null) goto L6;
        r2.setTrainingMode(r3, r6, r5);
        return;
    }

    public /* synthetic */ void lambda$notifyGeofenceChanged$3$WifiAwareInfoManager(int r1) {
        this.mGeofenceEventDelaySorter.onGeofenceEvent(r1);
    }

    public /* synthetic */ void lambda$postHandleWifiScanResults$2$WifiAwareInfoManager(List r3, WifiScanAttribution r4) {
        handleWifiScanResults((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    public /* synthetic */ void lambda$updateWifiConnectInfo$4$WifiAwareInfoManager(Bundle r1) {
        processWifiConnectInfo(r1);
    }

    public void notifyGeofenceChanged(final int r3) {
        Handler r0 = this.mHandler;
        if (r0 == null) goto L5;
        r0.post(new $$Lambda$WifiAwareInfoManager$0y9S8XvLpbGX5qgmzAcWpx5gqA8(this, r3));
        return;
    L5:
        dispatchGeofenceEvent(r3);
    }

    public void notifyLearningSuccess(boolean r3) {
        a.e(TAG, "notifyLearningSuccess: " + r3);
        WifiScanStateMachine r2 = this.mWifiScanStateMachine;
        if (r2 == null) goto L6;
        r2.setLearningSuccess(r3);
        return;
    }

    public void notifyRoomChangedPredicted(int r3) {
        if (r3 != 1) goto L7;
        a.e(TAG, "receive enter room predicted event");
        this.mInPredictedRoom = true;
        this.mWifiScanStateMachine.onEnterHome();
        this.mWifiFenceMonitor.onEnterHome();
        WifiConnectionScanController r2 = this.mWifiConnectionScanController;
        if (r2 == null) goto L9;
        r2.scheduleStopConnectedScanAfterEnterRoom();
        return;
    L9:
        return;
    L7:
        a.e(TAG, "receive exit room predicted event");
        this.mInPredictedRoom = false;
        this.mWifiScanStateMachine.onExitHome();
        this.mWifiFenceMonitor.onExitHome();
    }

    public void processWifiConnectInfo(Bundle r9) {
        String r0 = UserAwareUtil.removeDoubleQuotes(r9.getString(Api.KEY_SSID));
        String r1 = r9.getString("bssid");
        int r2 = r9.getInt("frequency");
        int r3 = r9.getInt("rssi");
        WifiConnectionScanController r4 = this.mWifiConnectionScanController;
        if (r4 == null) goto L5;
        r4.updateLastConnectedRssi(r3, System.currentTimeMillis());
    L5:
        int r5 = 0;
        if (com.obric.cae.libs.utils.a.a(r2) == false) goto L9;
        r5 = 1;
    L12:
        if (this.mThresholdMap.containsKey(r1) == true) goto L14;
    L15:
        this.mWifiScanStateMachine.onRssiChanged(r3);
    L16:
        WifiStandardData r10 = new WifiStandardData.a().a(r9.getLong("timestamp")).a(r1).b(r0).c(r2).d(r5).b(r3).a(WifiManager.calculateSignalLevel(r3, 5)).b(r9.getInt("totalBytes")).c(r9.getLong("usedTime")).e(r9.getInt("authType")).f(r9.getInt("apType")).g(r9.getInt("apStandard")).a();
        this.mLastWifiConnectInfo = r10;
        PnoSavedNetworkStore r6 = this.mPnoSavedNetworkStore;
        if (r6 == null) goto L19;
        r6.maybeSaveForGeofenceEvent(this.mCurrentGeofenceState, r0, r2);
    L19:
        WifiAwareInfoMonitor r7 = this.mWifiAwareInfoMonitor;
        if (r7 == null) goto L23;
        r7.onWifiConnectInfoChanged(r10);
    L23:
        if (TextUtils.equals(r0, this.mLastConnectedSsid) == true) goto L29;
        if (this.mWifiRomingStandardDataList.isEmpty() == true) goto L29;
        this.mWifiRomingStandardDataList.clear();
    L31:
        this.mLastConnectedSsid = r0;
        UserAwareManager r8 = UserAwareManager.getInstance();
        if (r8 != null) goto L35;
        return;
    L35:
        if (r8.isRecording() == false) goto L37;
    L42:
        a.b(r10.toString() + ", Connected", a.b(this.mWifiScanFileKey));
    L43:
        r8.postHarLevel2Data(r10);
        return;
    L37:
        if (r8.isRecordingByCallback() == true) goto L42;
        if (r8.isHarLevel2DataRecording() == false) goto L43;
        if (AwareStateListener.isHarCollectLocal() == false) goto L43;
    L29:
        if (this.mWifiRomingStandardDataList.containsKey(r1) == true) goto L31;
        this.mWifiRomingStandardDataList.put(r1, r10);
        goto L31
    L14:
        if (r3 > ((Integer) ZeusTransformUtils.preCheckCast(this.mThresholdMap.get(r1), Integer.class, "com.obric.memorydata.plugin")).intValue()) goto L16;
    L9:
        if (com.obric.cae.libs.utils.a.b(r2) == false) goto L12;
        r5 = 2;
        goto L12
    }

    public void recordWifiFile(String r1, File r2) {
        this.mWifiScanFileKey = r1;
        a.a(r1, r2);
    }

    public void registerWifiAwareInfoMonitor(WifiAwareInfoMonitor r3) {
        WifiAwareInfoMonitor r4 = (WifiAwareInfoMonitor) ZeusTransformUtils.wrapperContextForParams(r3, WifiAwareInfoMonitor.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        a.i(TAG, "registerWifiAwareInfoMonitor: monitor is null");
        return;
    L6:
        this.mWifiAwareInfoMonitor = r4;
    }

    public void removeBssidsToAvoidRomingScan(List<String> r6) {
        Iterator r7 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        if (this.mAvoidRomingConnectedBssids.contains(r0) == false) goto L8;
        this.mAvoidRomingConnectedBssids.remove(r0);
        StringBuilder r2 = new StringBuilder("remove BSSID for avoid roming scan: ");
    L9:
        a.e(TAG, r2.append(r0).toString());
        goto L4
    L8:
        r2 = new StringBuilder("This BSSID is no longer in the list: ");
        goto L9
    }

    public void removeRssiThresholds(List<String> r5) {
        Iterator r6 = ((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        a.c(TAG, "removeRssiThresholds: " + r0);
        this.mThresholdMap.remove(r0);
        goto L4
    L6:
        saveRssiThresholds();
    }

    public void setEnableWifiScanFunction(boolean r4) {
        boolean r0 = this.mFunctionEnabled;
        this.mFunctionEnabled = r4;
        this.mLoggedWifiConnectInfoSkipByFunctionDisabled = false;
        a.e(TAG, "Update wifi scan function: previous=" + r0 + ", enabled=" + r4 + ", scope=" + UserAwareUtil.getHostSettingsScope(this.mContext));
    }

    public void setFastWifiScanEnabled(boolean r1) {
        a.i(TAG, "unsupport setFastWifiScanEnabled can use setTrainingMode instead");
    }

    public void setRssiDropThresholds(List<RssiDropThreshold> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        Object r0 = this.mDropThresholdLock;
        monitor-enter(r0);
        this.mDropThresholdList.clear();     // Catch: Throwable -> L23
        Iterator r7 = r6.iterator();     // Catch: Throwable -> L23
    L9:
        if (r7.hasNext() == false) goto L17;
        RssiDropThreshold r1 = (RssiDropThreshold) ZeusTransformUtils.preCheckCast(r7.next(), RssiDropThreshold.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r1 == null) goto L9;
        if (r1.durationSec <= 0) goto L9;
        if (r1.dropDb <= 0) goto L9;
        this.mDropThresholdList.add(r1);     // Catch: Throwable -> L23
        goto L9
    L17:
        ArrayList r8 = new ArrayList(this.mDropThresholdList);     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        WifiScanStateMachine r4 = this.mWifiScanStateMachine;
        if (r4 == null) goto L37;
        r4.setRssiDropThresholdList(r8);
        return;
    L37:
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public void setRssiThresholds(List<BssidThreshold> r5) {
        Iterator r6 = ((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        BssidThreshold r0 = (BssidThreshold) ZeusTransformUtils.preCheckCast(r6.next(), BssidThreshold.class, "com.obric.memorydata.plugin");
        a.c(TAG, "setRssiThresholds: " + r0.bssid + " " + r0.threshold);
        String r2 = r0.bssid;
        if (r2 == null) goto L4;
        this.mThresholdMap.put(r2, Integer.valueOf(r0.threshold));
        goto L4
    L8:
        saveRssiThresholds();
    }

    public void setTrainingMode(boolean r2) {
        setTrainingMode(r2, 301);
    }

    public void setTrainingMode(boolean r2, int r3) {
        if (r2 == true) goto L4;
    L7:
        WifiSceneScanController r1 = this.mWifiSceneScanController;
        if (r1 == null) goto L11;
        r1.setCollectionTrainingMode(r2, r3);
        return;
    L11:
        return;
    L4:
        if (getScanConfigProvider().getActiveConfigSnapshot().isSceneEnabled(r3) == true) goto L7;
        a.e(TAG, d.a("setTrainingMode: scene disabled, sceneId=", r3, ", name=").append(WifiScanSceneType.sceneNameOf(r3)).toString());
    }

    public void setWifiRssiTriggerThresholds(int r7, int r8, int r9, int r10, int r11) {
        WifiScanStateMachine r0 = this.mWifiScanStateMachine;
        if (r0 == null) goto L6;
        r0.setRssiTriggerThresholds(r7, r8, r9, r10, r11);
        return;
    }

    public ConcurrentWifiScanner.RequestHandle startCollectionWifiScan(int r10, long r11, long r13) {
        WifiScanConfigProvider.ActiveConfigSnapshot r0 = getScanConfigProvider().getActiveConfigSnapshot();
        if (r0.isSceneEnabled(r10) == true) goto L6;
        a.e(TAG, d.a("startCollectionWifiScan: scene disabled, sceneId=", r10, ", name=").append(WifiScanSceneType.sceneNameOf(r10)).toString());
        return null;
    L6:
        long r5 = r0.getConfiguredSceneIntervalMsOrDefault(r10, r11);
        long r7 = r0.getConfiguredSceneDurationMsOrDefault(r10, r13);
        WifiSceneScanController r3 = this.mWifiSceneScanController;
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.startCollectionWifiScan(r10, r5, r7);
    }

    public ConcurrentWifiScanner.RequestHandle startCollectionWifiScan(long r7, long r9) {
        return startCollectionWifiScan(301, r7, r9);
    }

    public void startElevatorWifiDataCollection(int r2, int r3) {
        startElevatorWifiDataCollection(201, r2, r3);
    }

    public void startElevatorWifiDataCollection(int r9, int r10, int r11) {
        a.c(TAG, "startElevatorWifiDataCollection");
        startElevatorWifiScan(r9, r10, r11);
    }

    public ConcurrentWifiScanner.RequestHandle startElevatorWifiScan(int r10, long r11, long r13) {
        WifiScanConfigProvider.ActiveConfigSnapshot r0 = getScanConfigProvider().getActiveConfigSnapshot();
        if (r0.isSceneEnabled(r10) == true) goto L6;
        a.e(TAG, d.a("startElevatorWifiScan: scene disabled, sceneId=", r10, ", name=").append(WifiScanSceneType.sceneNameOf(r10)).toString());
        return null;
    L6:
        long r5 = r0.getConfiguredSceneIntervalMsOrDefault(r10, r11);
        long r7 = r0.getConfiguredSceneTotalTimeoutMsOrDefault(r10, r13);
        WifiSceneScanController r3 = this.mWifiSceneScanController;
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.startElevatorWifiScan(r10, r5, r7);
    }

    public ConcurrentWifiScanner.RequestHandle startElevatorWifiScan(long r7, long r9) {
        return startElevatorWifiScan(201, r7, r9);
    }

    public void startHarLevel2WifiDataCollection(int r2, int r3) {
        startHarLevel2WifiDataCollection(101, r2, r3);
    }

    public void startHarLevel2WifiDataCollection(int r9, int r10, int r11) {
        a.c(TAG, "startHarLevel2WifiDataCollection");
        startHarWifiScan(r9, r10, r11);
    }

    public ConcurrentWifiScanner.RequestHandle startHarWifiScan(int r10, long r11, long r13) {
        WifiScanConfigProvider.ActiveConfigSnapshot r0 = getScanConfigProvider().getActiveConfigSnapshot();
        if (r0.isSceneEnabled(r10) == true) goto L6;
        a.e(TAG, d.a("startHarWifiScan: scene disabled, sceneId=", r10, ", name=").append(WifiScanSceneType.sceneNameOf(r10)).toString());
        return null;
    L6:
        long r5 = r0.getConfiguredSceneIntervalMsOrDefault(r10, r11);
        long r7 = r0.getConfiguredSceneDurationMsOrDefault(r10, r13);
        WifiSceneScanController r3 = this.mWifiSceneScanController;
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.startHarWifiScan(r10, r5, r7);
    }

    public ConcurrentWifiScanner.RequestHandle startHarWifiScan(long r7, long r9) {
        return startHarWifiScan(101, r7, r9);
    }

    public ConcurrentWifiScanner.RequestHandle startHomeCompanyScan(int r9, long r10, long r12, boolean r14) {
        return startHomeCompanyScan(r9, r10, r12, r14, !r14);
    }

    public ConcurrentWifiScanner.RequestHandle startHomeCompanyScan(int r9, long r10, long r12, boolean r14, boolean r15) {
        if (getScanConfigProvider().getActiveConfigSnapshot().isSceneEnabled(r9) == true) goto L6;
        a.e(TAG, d.a("startHomeCompanyScan: scene disabled, sceneId=", r9, ", name=").append(WifiScanSceneType.sceneNameOf(r9)).toString());
        return null;
    L6:
        WifiSceneScanController r0 = this.mWifiSceneScanController;
        if (r0 != null) goto L11;
        a.i(TAG, "startHomeCompanyScan rejected: scene controller is null, sceneId=" + r9);
        return null;
    L11:
        return r0.startHomeCompanyScan(r9, r10, r12, r14, r15);
    }

    public void startSingleHarDataCollection(int r2, int r3) {
        startSingleHarDataCollection(301, r2, r3);
    }

    public void startSingleHarDataCollection(int r9, int r10, int r11) {
        a.c(TAG, "startSingleHarDataCollection");
        startCollectionWifiScan(r9, r10, r11);
    }

    public void startWifiRecord(boolean r5) {
        if (this.mIsWifiRecording.get() != r5) goto L6;
        return;
    L6:
        if (r5 == true) goto L8;
    L11:
        this.mIsWifiRecording.set(r5);
        a.c(TAG, "startWifiRecord: " + r5);
        setTrainingMode(r5, 301);
        return;
    L8:
        if (getScanConfigProvider().getActiveConfigSnapshot().isSceneEnabled(301) == true) goto L11;
        a.e(TAG, "startWifiRecord: scene disabled, sceneId=301, name=" + WifiScanSceneType.sceneNameOf(301));
    }

    public void updateWifiConnectInfo(final Bundle r3) {
        boolean r0 = this.mIsWifiRecording.get();
        if (this.mHasFirstEnterFence == true) goto L5;
    L6:
        if (r0 == false) goto L10;
    L7:
        this.mLoggedWifiConnectInfoSkipByFunctionDisabled = false;
        this.mHandler.post(new $$Lambda$WifiAwareInfoManager$7pYAWxs9WVnXNXXv0h4GT_FQDPs(this, r3));
        return;
    L10:
        if (this.mFunctionEnabled == false) goto L12;
        return;
    L12:
        if (this.mLoggedWifiConnectInfoSkipByFunctionDisabled == true) goto L16;
        a.e(TAG, "updateWifiConnectInfo skipped: mFunctionEnabled=false, RSSI/signalLevel will not be processed or logged, mHasFirstEnterFence=" + this.mHasFirstEnterFence + ", isWifiRecording=" + r0);
        this.mLoggedWifiConnectInfoSkipByFunctionDisabled = true;
        return;
    L16:
        return;
    L5:
        if (this.mFunctionEnabled == true) goto L7;
        goto L6
    }
}
