package com.obric.cae.connectivity;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.activity.j;
import com.obric.cae.smartNetwork.CloudConfigParseAndSave;
import defpackage.b;

/* JADX INFO: loaded from: classes.dex */
public class CaeCollectionStrategyManager implements ConnectivityMotionDetector.MotionStateListener {
    private static final long DEBOUNCE_INTERVAL_MS = 10000;
    private static final String TAG = "CaeCollectionStrategyMgr";
    private static CaeCollectionStrategyManager sInstance;
    private boolean isAoiActive;
    private long lastCollectTs;
    private IAoiDataCollector mBleCollector;
    private IAoiDataCollector mCellularCollector;
    private long mCollectIntervalMs;
    private Context mContext;
    private int mCurrentDeviceState;
    private String mCurrentPoiName;
    private int mDailyMaxReportCount;
    private IAoiDataCollector mGnssCollector;
    private final Handler mHandler;
    private final Runnable mIntervalRunnable;
    private int mMaxCountPerAoi;
    private long mMaxDurationMs;
    private final Runnable mMaxDurationRunnable;
    private ConnectivityMotionDetector mMotionDetector;
    private int mStillMaxCount;
    private IAoiDataCollector mWifiCollector;
    private int stillCollectCount;

    private CaeCollectionStrategyManager() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.isAoiActive = false;
        this.mCurrentDeviceState = 0;
        this.stillCollectCount = 0;
        this.lastCollectTs = 0;
        this.mCollectIntervalMs = 60000;
        this.mMaxDurationMs = 3600000;
        this.mStillMaxCount = 4;
        this.mDailyMaxReportCount = 180;
        this.mMaxCountPerAoi = 2;
        this.mCurrentPoiName = "";
        this.mIntervalRunnable = new AnonymousClass1(this);
        this.mMaxDurationRunnable = new j(this, 18);
        this.mWifiCollector = CaeWifiScanInfoReport.getInstance();
        this.mBleCollector = CaeBleScanInfoReport.getInstance();
        this.mCellularCollector = CaeCellularInfoReport.getInstance();
        this.mGnssCollector = CaeGnssInfoReport.getInstance();
    }

    public static /* synthetic */ void a(CaeCollectionStrategyManager r8) {
        r8.lambda$new$0();
    }

    public static /* synthetic */ boolean access$000(CaeCollectionStrategyManager r8) {
        return r8.isAoiActive;
    }

    public static /* synthetic */ int access$100(CaeCollectionStrategyManager r8) {
        return r8.mCurrentDeviceState;
    }

    public static /* synthetic */ int access$200(CaeCollectionStrategyManager r8) {
        return r8.stillCollectCount;
    }

    public static /* synthetic */ int access$208(CaeCollectionStrategyManager r8) {
        int r10 = r8.stillCollectCount;
        r8.stillCollectCount = r10 + 1;
        return r10;
    }

    public static /* synthetic */ int access$300(CaeCollectionStrategyManager r8) {
        return r8.mStillMaxCount;
    }

    public static /* synthetic */ void access$400(CaeCollectionStrategyManager r8, String r10) {
        r8.triggerCollection(r10);
    }

    public static /* synthetic */ long access$500(CaeCollectionStrategyManager r8) {
        return r8.mCollectIntervalMs;
    }

    public static /* synthetic */ Handler access$600(CaeCollectionStrategyManager r8) {
        return r8.mHandler;
    }

    public static synchronized CaeCollectionStrategyManager getInstance() {
        monitor-enter(CaeCollectionStrategyManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new CaeCollectionStrategyManager();     // Catch: Throwable -> L10
    L7:
        CaeCollectionStrategyManager r8 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(CaeCollectionStrategyManager.class);
        return r8;
    }

    private /* synthetic */ void lambda$new$0() {
        Log.w(TAG, "Max duration reached! Forcing to stop.");
        stopAllStrategies("MAX_DURATION_REACHED");
    }

    private void startIntervalTimer() {
        this.mHandler.removeCallbacks(this.mIntervalRunnable);
        this.mHandler.postDelayed(this.mIntervalRunnable, this.mCollectIntervalMs);
    }

    private void startMaxDurationTimer() {
        this.mHandler.removeCallbacks(this.mMaxDurationRunnable);
        this.mHandler.postDelayed(this.mMaxDurationRunnable, this.mMaxDurationMs);
    }

    private void stopAllStrategies(String r8) {
        Log.i(TAG, "Stopping strategies. Reason: " + r8);
        this.isAoiActive = false;
        this.mHandler.removeCallbacks(this.mIntervalRunnable);
        this.mHandler.removeCallbacks(this.mMaxDurationRunnable);
        ConnectivityMotionDetector r10 = this.mMotionDetector;
        if (r10 == null) goto L5;
        r10.stop();
    L5:
        IAoiDataCollector r11 = this.mWifiCollector;
        if (r11 == null) goto L8;
        r11.stopCollect();
    L8:
        IAoiDataCollector r12 = this.mBleCollector;
        if (r12 == null) goto L11;
        r12.stopCollect();
    L11:
        IAoiDataCollector r13 = this.mCellularCollector;
        if (r13 == null) goto L14;
        r13.stopCollect();
    L14:
        IAoiDataCollector r14 = this.mGnssCollector;
        if (r14 == null) goto L18;
        r14.stopCollect();
        return;
    }

    private void triggerCollection(String r8) {
        long r10 = System.currentTimeMillis();
        if ((r10 - this.lastCollectTs) >= 10000) goto L6;
        Log.d(TAG, "Debounce: Skip collection for reason=" + r8);
        return;
    L6:
        Context r11 = this.mContext;
        if (r11 == null) goto L17;
        AoiCollectQuotaManager r12 = AoiCollectQuotaManager.getInstance(r11);
        if (r12.getDailyTotalCount() < this.mDailyMaxReportCount) goto L13;
        Log.w(TAG, "Daily max report count reached: " + this.mDailyMaxReportCount);
        stopAllStrategies("DAILY_QUOTA_REACHED");
        return;
    L13:
        if (r12.getAoiCount(this.mCurrentPoiName) < this.mMaxCountPerAoi) goto L16;
        Log.w(TAG, "AOI max report count reached: " + this.mMaxCountPerAoi + " for " + this.mCurrentPoiName);
        stopAllStrategies("AOI_QUOTA_REACHED");
        return;
    L16:
        r12.incrementCount(this.mCurrentPoiName);
    L17:
        this.lastCollectTs = r10;
        Log.i(TAG, "Triggering collection. Reason: " + r8);
        IAoiDataCollector r13 = this.mWifiCollector;
        if (r13 == null) goto L20;
        r13.startCollect(this.mCurrentPoiName, this.lastCollectTs);
    L20:
        IAoiDataCollector r14 = this.mBleCollector;
        if (r14 == null) goto L24;
        r14.startCollect(this.mCurrentPoiName, this.lastCollectTs);
    L24:
        if ("AOI_ENTER".equals(r8) == false) goto L28;
        IAoiDataCollector r15 = this.mCellularCollector;
        if (r15 == null) goto L28;
        r15.startCollect(this.mCurrentPoiName, this.lastCollectTs);
    L28:
        IAoiDataCollector r16 = this.mGnssCollector;
        if (r16 == null) goto L32;
        r16.startCollect(this.mCurrentPoiName, this.lastCollectTs);
        return;
    }

    public void onEnterAoi(Context r8, String r10) {
        if (this.isAoiActive == false) goto L6;
        Log.w(TAG, "AOI is already active, ignore Enter event.");
        return;
    L6:
        Log.i(TAG, "=== Enter AOI: " + r10 + " ===");
        if (r8 == null) goto L15;
        this.mContext = r8;
        boolean r11 = false;
        if (Settings.Global.getInt(r8.getContentResolver(), CloudConfigParseAndSave.SETTINGS_GLOBAL_AOI_COLLECT_ENABLE, 0) != 1) goto L11;
        r11 = true;
    L11:
        if (r11 == true) goto L14;
        Log.w(TAG, "AOI collect is disabled by cloud config.");
        return;
    L14:
        this.mCollectIntervalMs = Settings.Global.getLong(r8.getContentResolver(), CloudConfigParseAndSave.SETTINGS_GLOBAL_AOI_COLLECT_INTERVAL_MS, 60000);
        this.mMaxDurationMs = Settings.Global.getLong(r8.getContentResolver(), CloudConfigParseAndSave.SETTINGS_GLOBAL_AOI_COLLECT_MAX_DURATION_MS, 3600000);
        this.mStillMaxCount = Settings.Global.getInt(r8.getContentResolver(), CloudConfigParseAndSave.SETTINGS_GLOBAL_AOI_COLLECT_STILL_MAX_COUNT, 4);
        this.mDailyMaxReportCount = Settings.Global.getInt(r8.getContentResolver(), CloudConfigParseAndSave.SETTINGS_GLOBAL_AOI_COLLECT_DAILY_MAX_REPORT_COUNT, 180);
        this.mMaxCountPerAoi = Settings.Global.getInt(r8.getContentResolver(), CloudConfigParseAndSave.SETTINGS_GLOBAL_AOI_COLLECT_MAX_COUNT_PER_AOI, 1);
    L15:
        this.isAoiActive = true;
        this.mCurrentPoiName = r10;
        if (this.mMotionDetector != null) goto L18;
        this.mMotionDetector = new ConnectivityMotionDetector(r8, this);
    L18:
        this.mMotionDetector.start();
        triggerCollection("AOI_ENTER");
        startIntervalTimer();
        startMaxDurationTimer();
    }

    public void onExitAoi() {
        Log.i(TAG, "=== Exit AOI ===");
        stopAllStrategies("AOI_EXIT");
    }

    @Override // com.obric.cae.connectivity.ConnectivityMotionDetector.MotionStateListener
    public void onMotionStateChanged(int r8) {
        if (this.isAoiActive == true) goto L5;
        return;
    L5:
        int r10 = this.mCurrentDeviceState;
        this.mCurrentDeviceState = r8;
        if (r10 != r8) goto L8;
        return;
    L8:
        boolean r11 = true;
        if (r10 != 2) goto L11;
        boolean r12 = true;
    L12:
        if (r8 == 2) goto L16;
        r11 = false;
    L16:
        if (r12 == true) goto L19;
        if (r11 == false) goto L19;
        Log.i(TAG, "State changed: STILL -> MOVING");
        this.stillCollectCount = 0;
        triggerCollection("START_MOVING");
        startIntervalTimer();
        return;
    L19:
        if (r12 == false) goto L24;
        if (r11 == true) goto L25;
        Log.i(TAG, "State changed: MOVING -> STILL");
        this.stillCollectCount = 0;
        return;
    L25:
        return;
    L24:
        return;
    L11:
        r12 = false;
        goto L12
    }

    public void onExitAoi(String r8) {
        if (this.isAoiActive == true) goto L6;
        return;
    L6:
        if (r8 != null) goto L8;
    L11:
        Log.i(TAG, "=== Exit AOI: " + r8 + " ===");
        stopAllStrategies("AOI_EXIT");
        return;
    L8:
        if (r8.equals(this.mCurrentPoiName) == true) goto L11;
        StringBuilder r10 = b.h("Ignoring EXIT event for different AOI: ", r8, " (currently collecting: ");
        r10.append(this.mCurrentPoiName);
        r10.append(")");
        Log.i(TAG, r10.toString());
    }
}
