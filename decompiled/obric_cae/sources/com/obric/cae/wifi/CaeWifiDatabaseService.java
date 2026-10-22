package com.obric.cae.wifi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiScanner;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.ServiceManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.appcompat.app.r;
import androidx.room.k;
import com.obric.cae.CaeReceiver;
import com.obric.cae.libs.wifi.ICaeWifiDatabaseManager;
import com.obric.cae.smartNetwork.CloudConfigParseAndSave;
import com.obric.cae.smartNetwork.throughtput.ThroughputCalculation;
import com.obric.cae.smartNetwork.throughtput.ThroughputCallback;
import com.obric.cae.utils.CaeUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class CaeWifiDatabaseService extends Service {
    public static final String ACTION_STARTSCAN_DAILY_REPORT = "com.obric.cae.wifi.action.STARTSCAN_DAILY_REPORT";
    private static final int CAEWIFI_SERVICE_EVENT_FEATURE_ID = 52;
    private static final int DEFAULT_LOW_THROUGHPUT_SCAN_THRESHOLD_KBPS = 20000;
    private static final int LOW_TPUT_FORCE_FULLSCAN_BACKOFF_INDEX = 2;
    private static final long[] LOW_TPUT_SCAN_BACKOFF_INTERVALS_MS = null;
    private static final int LOW_TPUT_SCAN_EXIT_MARGIN_KBPS = 5000;
    private static final int MAX_PARTIAL_SCAN_FREQS = 32;
    private static final String PREF_CURR_COUNT = "startscan_curr_success_count";
    private static final String PREF_CURR_DAY_KEY = "startscan_curr_day_key";
    private static final String PREF_DAILY_FULL_SCAN_COUNT = "startscan_daily_full_scan_count";
    private static final String PREF_DAILY_PARTIAL_SCAN_COUNT = "startscan_daily_partial_scan_count";
    private static final String PREF_LAST_REPORTED_DAY_KEY = "startscan_last_reported_day_key";
    private static final String PREF_NAME = "cae_wifi_database_service";
    private static final String PREF_PREV_COUNT = "startscan_prev_success_count";
    private static final String PREF_PREV_DAILY_FULL_SCAN_COUNT = "startscan_prev_daily_full_scan_count";
    private static final String PREF_PREV_DAILY_PARTIAL_SCAN_COUNT = "startscan_prev_daily_partial_scan_count";
    private static final String PREF_PREV_DAY_KEY = "startscan_prev_day_key";
    private static final int REQUEST_CODE_STARTSCAN_DAILY_REPORT = 10005;
    private static final String SERVICE_NAME_WIFI_DATABASE = "cae_wifi_database";
    private static final String TAG = "CaeWifiDatabaseService";
    private static final ExecutorService sDailyReportAlarmExecutor = null;
    private final ICaeWifiDatabaseManager.Stub mBinder;
    private volatile WiFiTputCacheManager mCacheManager;
    private int mDailyFullScanCount;
    private int mDailyPartialScanCount;
    private volatile ExecutorService mDbExecutor;
    private volatile boolean mDestroyed;
    private boolean mForceFullScanAfter40s;
    private final Handler mHandler;
    private String mLastBssid;
    private volatile int mLastLowThroughputScanThroughputKbps;
    private int mLastRssi;
    private boolean mLastWifiConnected;
    private int mLowTputBackoffIndex;
    private boolean mLowTputMonitorActive;
    private final Runnable mLowTputScanCheckRunnable;
    private final WifiScanner.ScanListener mLowTputWifiScannerListener;
    private final int[] mLowTputWindow;
    private int mLowTputWindowCount;
    private int mLowTputWindowIndex;
    private long mLowTputWindowSum;
    private SharedPreferences mPrefs;
    private int mPrevDailyFullScanCount;
    private int mPrevDailyPartialScanCount;
    private final ArrayMap<String, TreeSet<Integer>> mScannedFreqsCache;
    private boolean mScreenInteractive;
    private boolean mScreenReceiverRegistered;
    private final BroadcastReceiver mScreenStateReceiver;
    private String mStartScanCurrDayKey;
    private int mStartScanCurrSuccessCount;
    private String mStartScanLastReportedDayKey;
    private String mStartScanPrevDayKey;
    private int mStartScanPrevSuccessCount;
    private volatile ThroughputCalculation mThroughputCalculation;
    private volatile WifiManager mWifiManager;
    private volatile WiFiQoEManager mWifiQoEManager;
    private volatile boolean mWifiQoeStarted;
    private final BroadcastReceiver mWifiScanReceiver;
    private boolean mWifiScanReceiverRegistered;
    private volatile WifiScanner mWifiScanner;

    /* JADX INFO: renamed from: com.obric.cae.wifi.CaeWifiDatabaseService$4, reason: invalid class name */
    public class AnonymousClass4 implements ThroughputCallback {
        final /* synthetic */ CaeWifiDatabaseService this$0;
        final /* synthetic */ WiFiTputCacheManager val$cacheManager;

        public AnonymousClass4(CaeWifiDatabaseService r8, WiFiTputCacheManager r10) {
            this.this$0 = r8;
            this.val$cacheManager = r10;
        }

        public static /* synthetic */ void a(WiFiTputCacheManager r8, String r10, int r11, int r12) {
            lambda$onWifiConnectInfoChanged$0(r8, r10, r11, r12);
        }

        public static /* synthetic */ void b(WiFiTputCacheManager r8, String r10, int r11, int r12) {
            lambda$onThroughputChanged$1(r8, r10, r11, r12);
        }

        private static /* synthetic */ void lambda$onThroughputChanged$1(WiFiTputCacheManager r8, String r10, int r11, int r12) {
            r8.addOrUpdateData(r10, r11, r12);
        }

        private static /* synthetic */ void lambda$onWifiConnectInfoChanged$0(WiFiTputCacheManager r8, String r10, int r11, int r12) {
            r8.addOrUpdateData(r10, r11, r12);
        }

        @Override // com.obric.cae.smartNetwork.throughtput.ThroughputCallback
        public void onSecondaryThroughputChanged(int r8, int r10) {
            CaeWifiDatabaseService.access$000(this.this$0);
        }

        @Override // com.obric.cae.smartNetwork.throughtput.ThroughputCallback
        public void onThroughputChanged(final int r8, int r10) {
            if (CaeWifiDatabaseService.access$000(this.this$0) == false) goto L6;
            return;
        L6:
            if (CaeWifiDatabaseService.access$600(this.this$0) != null) goto L8;
            return;
        L8:
            if (CaeWifiDatabaseService.access$1100(this.this$0) == Integer.MIN_VALUE) goto L14;
            final String r11 = CaeWifiDatabaseService.access$600(this.this$0);
            final int r12 = CaeWifiDatabaseService.access$1100(this.this$0);
            if (r8 <= 0) goto L15;
            CaeWifiDatabaseService.access$900(this.this$0, r8);
            CaeWifiDatabaseService r13 = this.this$0;
            final WiFiTputCacheManager r14 = this.val$cacheManager;
            CaeWifiDatabaseService.access$1000(r13, new e(r14, r11, r12, r8));
            return;
        L15:
            return;
        }

        @Override // com.obric.cae.smartNetwork.throughtput.ThroughputCallback
        public void onWifiConnectInfoChanged(Bundle r8) {
            if (CaeWifiDatabaseService.access$000(this.this$0) == false) goto L5;
            return;
        L5:
            if (r8 != null) goto L7;
            return;
        L7:
            final String r10 = r8.getString(WiFiDBHelper.COL_BSSID);
            final int r11 = r8.getInt(WiFiDBHelper.COL_RSSI, Integer.MIN_VALUE);
            if (r10 != null) goto L11;
            return;
        L11:
            if (CaeWifiDatabaseService.access$600(this.this$0) != null) goto L13;
        L15:
            final int r12 = 0;
        L20:
            th = move-exception;
            Log.e(CaeWifiDatabaseService.TAG, "getThroughput failed", th);
        L22:
            if (r12 > 0) goto L24;
            return;
        L24:
            CaeWifiDatabaseService.access$900(this.this$0, r12);
            CaeWifiDatabaseService r13 = this.this$0;
            final WiFiTputCacheManager r14 = this.val$cacheManager;
            CaeWifiDatabaseService.access$1000(r13, new d(r14, r10, r11, r12));
            CaeWifiDatabaseService.access$602(this.this$0, r10);
            CaeWifiDatabaseService.access$1102(this.this$0, r11);
            return;
        L17:
            if (CaeWifiDatabaseService.access$800(this.this$0) == null) goto L22;
            r12 = CaeWifiDatabaseService.access$800(this.this$0).getThroughput();     // Catch: Throwable -> L20
            goto L22
        L13:
            if (CaeWifiDatabaseService.access$600(this.this$0).equals(r10) == true) goto L15;
            CaeWifiDatabaseService.access$700(this.this$0, "bssid changed: " + CaeUtil.stringToMD5(CaeWifiDatabaseService.access$600(this.this$0)) + " -> " + CaeUtil.stringToMD5(r10));
            goto L15
        }

        @Override // com.obric.cae.smartNetwork.throughtput.ThroughputCallback
        public void onWifiConnectStateChanged(int r8) {
            if (CaeWifiDatabaseService.access$000(this.this$0) == false) goto L5;
            return;
        L5:
            boolean r10 = true;
            if (r8 == 1) goto L10;
            r10 = false;
        L10:
            if (CaeWifiDatabaseService.access$1200(this.this$0) == r10) goto L16;
            CaeWifiDatabaseService r11 = this.this$0;
            if (r10 == false) goto L14;
            String r12 = "wifi connected";
        L15:
            CaeWifiDatabaseService.access$700(r11, r12);
            CaeWifiDatabaseService.access$1202(this.this$0, r10);
            goto L16
        L14:
            r12 = "wifi disconnected";
        L16:
            if (r10 == true) goto L23;
            CaeWifiDatabaseService.access$602(this.this$0, null);
            CaeWifiDatabaseService.access$1102(this.this$0, Integer.MIN_VALUE);
            CaeWifiDatabaseService.access$1302(this.this$0, -1);
        L23:
            this.val$cacheManager.onWifiConnectionStateChanged(r10);     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            Log.e(CaeWifiDatabaseService.TAG, "onWifiConnectStateChanged handle failed", th);
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.wifi.CaeWifiDatabaseService$5, reason: invalid class name */
    public class AnonymousClass5 implements WifiScanner.ScanListener {
        final /* synthetic */ CaeWifiDatabaseService this$0;

        public AnonymousClass5(CaeWifiDatabaseService r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(AnonymousClass5 r8) {
            r8.lambda$onFailure$0();
        }

        public static /* synthetic */ void b(AnonymousClass5 r8, ArrayList r10) {
            r8.lambda$onResults$1(r10);
        }

        private /* synthetic */ void lambda$onFailure$0() {
            CaeWifiDatabaseService r8 = this.this$0;
            monitor-enter(r8);
            CaeWifiDatabaseService.access$1700(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r8);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$onResults$1(ArrayList r8) {
            CaeWifiDatabaseService.access$1600(this.this$0, r8);
        }

        public void onFailure(int r8, String r10) {
            Log.e(CaeWifiDatabaseService.TAG, "WifiScanner scan failed: reason=" + r8 + ", desc=" + r10);
            CaeWifiDatabaseService.access$1500(this.this$0).post(new f(this, 0));
        }

        public void onFullResult(ScanResult r8) {
        }

        public void onPeriodChanged(int r8) {
        }

        public void onResults(WifiScanner.ScanData[] r8) {
            int r10 = 0;
            if (r8 != null) goto L5;
        L7:
            ScanResult[] r11 = new ScanResult[0];
        L8:
            final ArrayList r12 = new ArrayList();
            if (r11 == null) goto L16;
            int r13 = r11.length;
        L11:
            if (r10 >= r13) goto L16;
            ScanResult r14 = r11[r10];
            if (r14 == null) goto L15;
            r12.add(r14);
        L15:
            r10 = r10 + 1;
        L16:
            CaeWifiDatabaseService.access$1500(this.this$0).post(new g(this, r12));
            return;
        L5:
            if (r8.length <= 0) goto L7;
            r11 = r8[0].getResults();
            goto L8
        }

        public void onSuccess() {
            CaeWifiDatabaseService r8 = this.this$0;
            monitor-enter(r8);
            CaeWifiDatabaseService.access$1400(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r8);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        sDailyReportAlarmExecutor = Executors.newSingleThreadExecutor(new c());
        LOW_TPUT_SCAN_BACKOFF_INTERVALS_MS = new long[]{10000, 20000, 40000, 80000, 160000};
    }

    public CaeWifiDatabaseService() {
        this.mLastRssi = Integer.MIN_VALUE;
        this.mLastLowThroughputScanThroughputKbps = -1;
        this.mScannedFreqsCache = new ArrayMap();
        this.mForceFullScanAfter40s = false;
        this.mDailyPartialScanCount = 0;
        this.mDailyFullScanCount = 0;
        this.mPrevDailyPartialScanCount = 0;
        this.mPrevDailyFullScanCount = 0;
        this.mScreenInteractive = true;
        this.mScreenReceiverRegistered = false;
        this.mScreenStateReceiver = new AnonymousClass1(this);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mLowTputWindow = new int[5];
        this.mLowTputWindowCount = 0;
        this.mLowTputWindowIndex = 0;
        this.mLowTputWindowSum = 0;
        this.mLowTputMonitorActive = false;
        this.mLowTputBackoffIndex = 0;
        this.mLowTputScanCheckRunnable = new AnonymousClass2(this);
        this.mWifiScanReceiverRegistered = false;
        this.mWifiScanReceiver = new AnonymousClass3(this);
        this.mLowTputWifiScannerListener = new AnonymousClass5(this);
        this.mBinder = new AnonymousClass6(this);
    }

    public static /* synthetic */ void a(WiFiTputCacheManager r8, String r10, int r11, int r12) {
        lambda$initThroughputAndRssiMonitor$5(r8, r10, r11, r12);
    }

    public static /* synthetic */ boolean access$000(CaeWifiDatabaseService r8) {
        return r8.mDestroyed;
    }

    public static /* synthetic */ void access$1000(CaeWifiDatabaseService r8, Runnable r10) {
        r8.executeDbTask(r10);
    }

    public static /* synthetic */ boolean access$102(CaeWifiDatabaseService r8, boolean r10) {
        r8.mScreenInteractive = r10;
        return r10;
    }

    public static /* synthetic */ int access$1100(CaeWifiDatabaseService r8) {
        return r8.mLastRssi;
    }

    public static /* synthetic */ int access$1102(CaeWifiDatabaseService r8, int r10) {
        r8.mLastRssi = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1200(CaeWifiDatabaseService r8) {
        return r8.mLastWifiConnected;
    }

    public static /* synthetic */ boolean access$1202(CaeWifiDatabaseService r8, boolean r10) {
        r8.mLastWifiConnected = r10;
        return r10;
    }

    public static /* synthetic */ int access$1300(CaeWifiDatabaseService r8) {
        return r8.mLastLowThroughputScanThroughputKbps;
    }

    public static /* synthetic */ int access$1302(CaeWifiDatabaseService r8, int r10) {
        r8.mLastLowThroughputScanThroughputKbps = r10;
        return r10;
    }

    public static /* synthetic */ void access$1400(CaeWifiDatabaseService r8) {
        r8.onStartScanSuccessLocked();
    }

    public static /* synthetic */ Handler access$1500(CaeWifiDatabaseService r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ void access$1600(CaeWifiDatabaseService r8, List r10) {
        r8.processScanResultsForBandInfo(r10);
    }

    public static /* synthetic */ boolean access$1700(CaeWifiDatabaseService r8) {
        return r8.startFullScanWithWifiManagerLocked();
    }

    public static /* synthetic */ WiFiTputCacheManager access$1800(CaeWifiDatabaseService r8) {
        return r8.mCacheManager;
    }

    public static /* synthetic */ int access$1900(CaeWifiDatabaseService r8) {
        return r8.getConfiguredTriggerScanTputThreshold();
    }

    public static /* synthetic */ void access$200(CaeWifiDatabaseService r8) {
        r8.cancelLowTputScanCheckLocked();
    }

    public static /* synthetic */ void access$300(CaeWifiDatabaseService r8, String r10, boolean r11) {
        r8.resetLowThroughputScanState(r10, r11);
    }

    public static /* synthetic */ void access$400(CaeWifiDatabaseService r8) {
        r8.handleLowThroughputScanCheck();
    }

    public static /* synthetic */ void access$500(CaeWifiDatabaseService r8) {
        r8.processScanResultsForBandInfo();
    }

    public static /* synthetic */ String access$600(CaeWifiDatabaseService r8) {
        return r8.mLastBssid;
    }

    public static /* synthetic */ String access$602(CaeWifiDatabaseService r8, String r10) {
        r8.mLastBssid = r10;
        return r10;
    }

    public static /* synthetic */ void access$700(CaeWifiDatabaseService r8, String r10) {
        r8.resetLowThroughputScanStateOnWifiChange(r10);
    }

    public static /* synthetic */ ThroughputCalculation access$800(CaeWifiDatabaseService r8) {
        return r8.mThroughputCalculation;
    }

    public static /* synthetic */ void access$900(CaeWifiDatabaseService r8, int r10) {
        r8.handleLowThroughputScan(r10);
    }

    private void addLowTputSampleLocked(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        int r8 = this.mLowTputWindowCount;
        int[] r11 = this.mLowTputWindow;
        if (r8 >= r11.length) goto L8;
        int r12 = this.mLowTputWindowIndex;
        r11[r12] = r10;
        this.mLowTputWindowSum += (long) r10;
        this.mLowTputWindowCount = r8 + 1;
        this.mLowTputWindowIndex = (r12 + 1) % r11.length;
        return;
    L8:
        int r13 = this.mLowTputWindowIndex;
        int r14 = r11[r13];
        r11[r13] = r10;
        this.mLowTputWindowSum = (((long) r10) - ((long) r14)) + this.mLowTputWindowSum;
        this.mLowTputWindowIndex = (r13 + 1) % r11.length;
    }

    public static /* synthetic */ void b(CaeWifiDatabaseService r8, Runnable r10) {
        r8.lambda$executeDbTask$3(r10);
    }

    public static /* synthetic */ void c(CaeWifiDatabaseService r8) {
        r8.lambda$onStartCommand$6();
    }

    private void cancelLowTputScanCheckLocked() {
        this.mHandler.removeCallbacks(this.mLowTputScanCheckRunnable);
    }

    public static /* synthetic */ void d(CaeWifiDatabaseService r8) {
        r8.lambda$scheduleDeferredInit$2();
    }

    public static /* synthetic */ void e(CaeWifiDatabaseService r8, List r10) {
        r8.lambda$processScanResultsForBandInfo$1(r10);
    }

    private void ensureWifiDbExists() {
    L13:
        th = move-exception;
        Log.e(TAG, "ensure wifi db exist failed", th);
        return;
    L16:
        String r8 = WiFiDBHelper.getInstance(getApplicationContext()).getWritableDatabase().getPath();     // Catch: Throwable -> L6
    L7:
        StringBuilder r10 = new StringBuilder("wifi db ready");     // Catch: Throwable -> L13
        if (r8 == null) goto L10;
        String r11 = ": ".concat(r8);     // Catch: Throwable -> L13
    L11:
        r10.append(r11);     // Catch: Throwable -> L13
        Log.d(TAG, r10.toString());     // Catch: Throwable -> L13
        return;
    L10:
        r11 = "";
        goto L11
    L6:
        Log.e(TAG, "db.getPath failed");     // Catch: Throwable -> L13
        r8 = null;
        goto L7
    }

    private void executeDbTask(Runnable r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (this.mDestroyed == true) goto L17;
        ExecutorService r10 = this.mDbExecutor;
        if (r10 != null) goto L14;
        return;
    L14:
        r10.execute(new r(22, this, r8));     // Catch: RuntimeException -> L11
        return;
    L11:
        e = move-exception;
        Log.w(TAG, "execute db task failed", e);
        return;
    }

    public static /* synthetic */ void f(Context r8) {
        lambda$scheduleNextStartScanDailyReportAlarm$4(r8);
    }

    private static String formatDayKey(long r8) {
        return new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(r8));
    }

    public static /* synthetic */ Thread g(Runnable r8) {
        return lambda$static$0(r8);
    }

    private int getConfiguredTriggerScanTputThreshold() {
        int r8 = Settings.Global.getInt(getContentResolver(), CloudConfigParseAndSave.SETTINGS_GLOBAL_WIFI_TRIGGER_SCAN_TPUT_THRESHOLD, DEFAULT_LOW_THROUGHPUT_SCAN_THRESHOLD_KBPS);     // Catch: Throwable -> L7
        if (r8 > 0) goto L6;
        return DEFAULT_LOW_THROUGHPUT_SCAN_THRESHOLD_KBPS;
    L6:
        return r8;
    L7:
        th = move-exception;
        Log.e(TAG, "getConfiguredTriggerScanTputThreshold failed", th);
        return DEFAULT_LOW_THROUGHPUT_SCAN_THRESHOLD_KBPS;
    }

    private TreeSet<Integer> getOrLoadScannedFreqsMhzLocked(String r8, String r10) {
        String r11 = makeBssidSsidKey(r8, r10);
        TreeSet<Integer> r12 = this.mScannedFreqsCache.get(r11);
        if (r12 == null) goto L5;
        return r12;
    L5:
        TreeSet<Integer> r13 = new TreeSet();
        List<Integer> r14 = getScannedFreqsMhzForNetwork(r8, r10);
        if (r14 == null) goto L15;
        Iterator<Integer> r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L15;
        Integer r16 = r15.next();
        if (r16 == null) goto L9;
        if (r16.intValue() <= 0) goto L9;
        r13.add(r16);
    L15:
        this.mScannedFreqsCache.put(r11, r13);
        return r13;
    }

    private static String getYesterdayKey(long r8) {
        Calendar r10 = Calendar.getInstance();
        r10.setTimeInMillis(r8);
        r10.add(6, -1);
        return formatDayKey(r10.getTimeInMillis());
    }

    private synchronized void handleLowThroughputScan(int r8) {
        monitor-enter(this);
        if (r8 > 0) goto L26;
        monitor-exit(this);
        return;
    L26:
        addLowTputSampleLocked(r8);     // Catch: Throwable -> L23
        int r10 = this.mLowTputWindowCount;     // Catch: Throwable -> L23
        int[] r11 = this.mLowTputWindow;     // Catch: Throwable -> L23
        if (r10 >= r11.length) goto L11;
        monitor-exit(this);
        return;
    L11:
        long r12 = this.mLowTputWindowSum / ((long) r11.length);     // Catch: Throwable -> L23
        int r13 = getConfiguredTriggerScanTputThreshold();     // Catch: Throwable -> L23
        if (this.mLowTputMonitorActive == false) goto L14;
    L21:
        monitor-exit(this);
        return;
    L14:
        if (r12 >= r13) goto L21;
        if (this.mScreenInteractive == false) goto L21;
        this.mForceFullScanAfter40s = false;     // Catch: Throwable -> L23
        boolean r14 = startScanSafelyLocked();     // Catch: Throwable -> L23
        if (r14 == false) goto L20;
        this.mLastLowThroughputScanThroughputKbps = (int) r12;     // Catch: Throwable -> L23
        this.mLowTputMonitorActive = true;     // Catch: Throwable -> L23
        this.mLowTputBackoffIndex = 0;     // Catch: Throwable -> L23
        scheduleLowTputScanCheckLocked(LOW_TPUT_SCAN_BACKOFF_INTERVALS_MS[0]);     // Catch: Throwable -> L23
    L20:
        Log.i(TAG, "handleLowThroughputScan: avg5=" + r12 + " kbps, threshold=" + r13 + ", startScan=" + r14 + ", monitorActive=" + this.mLowTputMonitorActive + ", backoffIndex=" + this.mLowTputBackoffIndex);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    private void handleLowThroughputScanCheck() {
        if (this.mLowTputMonitorActive == true) goto L6;
        return;
    L6:
        if (this.mScreenInteractive == true) goto L9;
        cancelLowTputScanCheckLocked();
        resetLowThroughputScanState("screen off", true);
        return;
    L9:
        int r8 = this.mLowTputWindow.length;
        if (this.mLowTputWindowCount >= r8) goto L13;
        scheduleLowTputScanCheckLocked(LOW_TPUT_SCAN_BACKOFF_INTERVALS_MS[this.mLowTputBackoffIndex]);
        Log.d(TAG, "handleLowThroughputScanCheck: window not full, count=" + this.mLowTputWindowCount + ", backoffIndex=" + this.mLowTputBackoffIndex);
        return;
    L13:
        long r10 = this.mLowTputWindowSum / ((long) r8);
        int r11 = getConfiguredTriggerScanTputThreshold();
        int r12 = r11 + 5000;
        if (r10 < r12) goto L18;
        cancelLowTputScanCheckLocked();
        this.mLowTputMonitorActive = false;
        this.mLowTputBackoffIndex = 0;
        this.mForceFullScanAfter40s = false;
        Log.i(TAG, "handleLowThroughputScanCheck: recovered, avg5=" + r10 + " kbps, threshold=" + r11 + ", exitThreshold=" + r12);
        return;
    L18:
        if (r10 < r11) goto L21;
        long[] r13 = LOW_TPUT_SCAN_BACKOFF_INTERVALS_MS;
        int r14 = Math.min(this.mLowTputBackoffIndex + 1, r13.length - 1);
        this.mLowTputBackoffIndex = r14;
        long r15 = r13[r14];
        scheduleLowTputScanCheckLocked(r15);
        Log.i(TAG, "handleLowThroughputScanCheck: hold, avg5=" + r10 + " kbps, threshold=" + r11 + ", exitThreshold=" + r12 + ", nextDelayMs=" + r15 + ", backoffIndex=" + this.mLowTputBackoffIndex);
        return;
    L21:
        boolean r16 = startScanSafelyLocked();
        if (r16 == false) goto L24;
        this.mLastLowThroughputScanThroughputKbps = (int) r10;
    L24:
        long[] r17 = LOW_TPUT_SCAN_BACKOFF_INTERVALS_MS;
        int r18 = Math.min(this.mLowTputBackoffIndex + 1, r17.length - 1);
        this.mLowTputBackoffIndex = r18;
        long r19 = r17[r18];
        scheduleLowTputScanCheckLocked(r19);
        Log.i(TAG, "handleLowThroughputScanCheck: avg5=" + r10 + " kbps, threshold=" + r11 + ", startScan=" + r16 + ", nextDelayMs=" + r19 + ", backoffIndex=" + this.mLowTputBackoffIndex);
    }

    private void initThroughputAndRssiMonitor() {
        final WiFiTputCacheManager r8 = this.mCacheManager;     // Catch: Throwable -> L24
        if (r8 != null) goto L6;
    L22:
        Log.e(TAG, "initThroughputAndRssiMonitor: cacheManager or dbExecutor is null");     // Catch: Throwable -> L24
        return;
    L6:
        if (this.mDbExecutor == null) goto L22;
        this.mThroughputCalculation = new ThroughputCalculation(getApplicationContext(), new AnonymousClass4(this, r8));     // Catch: Throwable -> L24
        WifiManager r10 = this.mWifiManager;     // Catch: Throwable -> L24
        if (r10 == null) goto L31;
        WifiInfo r11 = r10.getConnectionInfo();     // Catch: Throwable -> L24
        if (r11 == null) goto L32;
        this.mLastBssid = r11.getBSSID();     // Catch: Throwable -> L24
        this.mLastRssi = r11.getRssi();     // Catch: Throwable -> L24
        if (this.mThroughputCalculation == null) goto L16;
        final int r12 = this.mThroughputCalculation.getThroughput();     // Catch: Throwable -> L27
    L17:
        if (r12 <= 0) goto L33;
        final String r13 = this.mLastBssid;     // Catch: Throwable -> L27
        if (r13 == null) goto L34;
        final int r14 = this.mLastRssi;     // Catch: Throwable -> L27
        executeDbTask(new a(r8, r13, r14, r12));     // Catch: Throwable -> L27
        return;
    L34:
        return;
    L33:
        return;
    L16:
        r12 = 0;
    L36:
        return;
    L32:
        return;
    L31:
        return;
    L24:
        th = move-exception;
        Log.e(TAG, "initThroughputAndRssiMonitor failed", th);
    }

    private /* synthetic */ void lambda$executeDbTask$3(Runnable r8) {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        r8.run();
    }

    private static /* synthetic */ void lambda$initThroughputAndRssiMonitor$5(WiFiTputCacheManager r8, String r10, int r11, int r12) {
        r8.addOrUpdateData(r10, r11, r12);
    }

    private /* synthetic */ void lambda$onStartCommand$6() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mDestroyed == true) goto L6;
        reportStartScanDailyLocked();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    private /* synthetic */ void lambda$processScanResultsForBandInfo$1(List r8) {
    L8:
        th = move-exception;
        Log.e(TAG, "Failed to save band records to DB", th);
        return;
    L4:
        if (this.mCacheManager == null) goto L6;
        this.mCacheManager.insertBandRecords(r8);     // Catch: Throwable -> L8
    L6:
        Log.i(TAG, "Successfully processed and saved " + r8.size() + " band records.");     // Catch: Throwable -> L8
    }

    private /* synthetic */ void lambda$scheduleDeferredInit$2() {
        if (this.mDestroyed == false) goto L44;
        return;
    L44:
        WiFiQoEManager r8 = WiFiQoEManager.getInstance(getApplicationContext());     // Catch: Throwable -> L20
        if (this.mDestroyed == false) goto L8;
        return;
    L8:
        r8.start();     // Catch: Throwable -> L20
        monitor-enter(this);     // Catch: Throwable -> L20
        boolean r10 = this.mDestroyed;     // Catch: Throwable -> L17
        if (r10 == true) goto L13;
        this.mWifiQoEManager = r8;     // Catch: Throwable -> L17
        this.mWifiQoeStarted = true;     // Catch: Throwable -> L17
    L13:
        monitor-exit(this);     // Catch: Throwable -> L17
        if (r10 == false) goto L23;
        r8.stop();     // Catch: Throwable -> L20
        return;
    L23:
        if (this.mDestroyed == false) goto L40;
        return;
    L40:
        this.mCacheManager = WiFiTputCacheManager.getInstance(getApplicationContext());     // Catch: Throwable -> L27
    L30:
        if (this.mDestroyed == false) goto L32;
        return;
    L32:
        scheduleNextStartScanDailyReportAlarm(getApplicationContext());
        if (this.mDestroyed == false) goto L35;
        return;
    L35:
        ensureWifiDbExists();
        if (this.mDestroyed == false) goto L38;
        return;
    L38:
        initThroughputAndRssiMonitor();
        return;
    L27:
        th = move-exception;
        Log.e(TAG, "init WiFiTputCacheManager failed", th);
        goto L30
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Log.e(TAG, "start WiFiQoEManager failed", th);
        goto L23
    }

    private static /* synthetic */ void lambda$scheduleNextStartScanDailyReportAlarm$4(Context r8) {
        scheduleNextStartScanDailyReportAlarmInternal(r8);
    }

    private static /* synthetic */ Thread lambda$static$0(Runnable r8) {
        return new Thread(r8, "CaeWifiDailyAlarm");
    }

    private void loadStartScanDailyStateLocked() {
        SharedPreferences r8 = this.mPrefs;
        if (r8 != null) goto L5;
        return;
    L5:
        this.mStartScanCurrDayKey = r8.getString(PREF_CURR_DAY_KEY, null);
        this.mStartScanCurrSuccessCount = r8.getInt(PREF_CURR_COUNT, 0);
        this.mStartScanPrevDayKey = r8.getString(PREF_PREV_DAY_KEY, null);
        this.mStartScanPrevSuccessCount = r8.getInt(PREF_PREV_COUNT, 0);
        this.mStartScanLastReportedDayKey = r8.getString(PREF_LAST_REPORTED_DAY_KEY, null);
        this.mDailyPartialScanCount = r8.getInt(PREF_DAILY_PARTIAL_SCAN_COUNT, 0);
        this.mDailyFullScanCount = r8.getInt(PREF_DAILY_FULL_SCAN_COUNT, 0);
        this.mPrevDailyPartialScanCount = r8.getInt(PREF_PREV_DAILY_PARTIAL_SCAN_COUNT, 0);
        this.mPrevDailyFullScanCount = r8.getInt(PREF_PREV_DAILY_FULL_SCAN_COUNT, 0);
    }

    private static String makeBssidSsidKey(String r8, String r10) {
        return String.valueOf(r8) + "|" + String.valueOf(r10);
    }

    private void mergeScannedFreqsCacheLocked(String r8, String r10, Set<Integer> r11) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L29;
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.isEmpty() == true) goto L31;
        String r12 = makeBssidSsidKey(r8, r10);
        TreeSet<Integer> r13 = this.mScannedFreqsCache.get(r12);
        if (r13 != null) goto L13;
        r13 = new TreeSet();
        this.mScannedFreqsCache.put(r12, r13);
    L13:
        Iterator<Integer> r14 = r11.iterator();
    L15:
        if (r14.hasNext() == false) goto L32;
        Integer r15 = r14.next();
        if (r15 == null) goto L15;
        if (r15.intValue() <= 0) goto L15;
        r13.add(r15);
        goto L15
    L32:
        return;
    L31:
        return;
    }

    private void onStartScanSuccessLocked() {
        rolloverStartScanDailyIfNeededLocked(formatDayKey(System.currentTimeMillis()));
        this.mStartScanCurrSuccessCount++;
        persistStartScanDailyStateLocked();
    }

    private void persistStartScanDailyStateLocked() {
        SharedPreferences r8 = this.mPrefs;
        if (r8 != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r10 = r8.edit();
        r10.putString(PREF_CURR_DAY_KEY, this.mStartScanCurrDayKey);
        r10.putInt(PREF_CURR_COUNT, this.mStartScanCurrSuccessCount);
        r10.putString(PREF_PREV_DAY_KEY, this.mStartScanPrevDayKey);
        r10.putInt(PREF_PREV_COUNT, this.mStartScanPrevSuccessCount);
        r10.putString(PREF_LAST_REPORTED_DAY_KEY, this.mStartScanLastReportedDayKey);
        r10.putInt(PREF_DAILY_PARTIAL_SCAN_COUNT, this.mDailyPartialScanCount);
        r10.putInt(PREF_DAILY_FULL_SCAN_COUNT, this.mDailyFullScanCount);
        r10.putInt(PREF_PREV_DAILY_PARTIAL_SCAN_COUNT, this.mPrevDailyPartialScanCount);
        r10.putInt(PREF_PREV_DAILY_FULL_SCAN_COUNT, this.mPrevDailyFullScanCount);
        r10.apply();
    }

    private void processScanResultsForBandInfo() {
        if (this.mDestroyed == false) goto L6;
        return;
    L6:
        if (this.mWifiManager != null) goto L18;
        return;
    L18:
        List<ScanResult> r8 = this.mWifiManager.getScanResults();     // Catch: Throwable -> L10
    L12:
        if (r8 != null) goto L14;
        return;
    L14:
        if (r8.isEmpty() == true) goto L21;
        processScanResultsForBandInfo(r8);
        return;
    L21:
        return;
    L10:
        th = move-exception;
        Log.e(TAG, "getScanResults failed", th);
        r8 = null;
        goto L12
    }

    private void reportStartScanDailyLocked() {
        long r8 = System.currentTimeMillis();
        String r10 = formatDayKey(r8);
        String r11 = getYesterdayKey(r8);
        rolloverStartScanDailyIfNeededLocked(r10);
        if (r11 == null) goto L9;
        if (r11.equals(this.mStartScanLastReportedDayKey) == false) goto L9;
        scheduleNextStartScanDailyReportAlarm(getApplicationContext());
        return;
    L9:
        if (r11 != null) goto L11;
    L13:
        if (r11 != null) goto L15;
    L17:
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L18:
        StartScanDailyReportData.Builder r15 = StartScanDailyReportData.newBuilder();
        r15.setEventType("wifi_startscan_daily");
        if (r11 != null) goto L21;
        String r16 = "";
    L22:
        r15.setDateKey(r16);
        r15.setStartScanSuccessCount(r12);
        r15.setDeviceTime(r8);
        r15.setDeviceDate(CaeUtil.timeMillisToDateString(r8));
        r15.setPartialScanCount(r13);
        r15.setFullScanCount(r14);
        CaeWifiServiceProtoData.Builder r17 = CaeWifiServiceProtoData.newBuilder();
        r17.setStartScanDailyReport(r15);
        CaeWifiServiceProto.Builder r18 = CaeWifiServiceProto.newBuilder();
        r18.addCaeWifiServiceProto(r17);
        CaeUtil.writePbEventSafely(r8, 52, r18.build().toByteArray());
        this.mStartScanLastReportedDayKey = r11;
        if (r11 != null) goto L25;
    L27:
        persistStartScanDailyStateLocked();
        scheduleNextStartScanDailyReportAlarm(getApplicationContext());
        Log.i(TAG, "reportStartScanDailyLocked: dateKey=" + r11 + ", count=" + r12 + ", partialScanCount=" + r13 + ", fullScanCount=" + r14);
        return;
    L25:
        if (r11.equals(this.mStartScanPrevDayKey) == false) goto L27;
        this.mStartScanPrevDayKey = null;
        this.mStartScanPrevSuccessCount = 0;
        this.mPrevDailyPartialScanCount = 0;
        this.mPrevDailyFullScanCount = 0;
        goto L27
    L21:
        r16 = r11;
        goto L22
    L15:
        if (r11.equals(this.mStartScanCurrDayKey) == false) goto L17;
        r12 = this.mStartScanCurrSuccessCount;
        r13 = this.mDailyPartialScanCount;
        r14 = this.mDailyFullScanCount;
        goto L18
    L11:
        if (r11.equals(this.mStartScanPrevDayKey) == false) goto L13;
        r12 = this.mStartScanPrevSuccessCount;
        r13 = this.mPrevDailyPartialScanCount;
        r14 = this.mPrevDailyFullScanCount;
        goto L18
    }

    private synchronized void resetLowThroughputScanState(String r8, boolean r10) {
        monitor-enter(this);
        this.mLowTputMonitorActive = false;     // Catch: Throwable -> L11
        this.mLowTputBackoffIndex = 0;     // Catch: Throwable -> L11
        this.mForceFullScanAfter40s = false;     // Catch: Throwable -> L11
        if (r10 == false) goto L8;
        this.mLowTputWindowCount = 0;     // Catch: Throwable -> L11
        this.mLowTputWindowIndex = 0;     // Catch: Throwable -> L11
        this.mLowTputWindowSum = 0;     // Catch: Throwable -> L11
    L8:
        this.mLastLowThroughputScanThroughputKbps = -1;     // Catch: Throwable -> L11
        Log.i(TAG, "resetLowThroughputScanState: " + r8 + ", clearWindow=" + r10);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private synchronized void resetLowThroughputScanStateOnWifiChange(String r8) {
        monitor-enter(this);
        cancelLowTputScanCheckLocked();     // Catch: Throwable -> L6
        this.mScannedFreqsCache.clear();     // Catch: Throwable -> L6
        resetLowThroughputScanState(r8, true);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void rolloverStartScanDailyIfNeededLocked(String r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        String r10 = this.mStartScanCurrDayKey;
        if (r10 != null) goto L9;
        this.mStartScanCurrDayKey = r8;
        this.mStartScanCurrSuccessCount = 0;
        this.mDailyPartialScanCount = 0;
        this.mDailyFullScanCount = 0;
        return;
    L9:
        if (r8.equals(r10) == true) goto L12;
        this.mStartScanPrevDayKey = this.mStartScanCurrDayKey;
        this.mStartScanPrevSuccessCount = this.mStartScanCurrSuccessCount;
        this.mPrevDailyPartialScanCount = this.mDailyPartialScanCount;
        this.mPrevDailyFullScanCount = this.mDailyFullScanCount;
        this.mStartScanCurrDayKey = r8;
        this.mStartScanCurrSuccessCount = 0;
        this.mDailyPartialScanCount = 0;
        this.mDailyFullScanCount = 0;
        return;
    }

    private void scheduleDeferredInit() {
        ExecutorService r8 = this.mDbExecutor;
        if (r8 != null) goto L6;
        Log.e(TAG, "scheduleDeferredInit: dbExecutor is null");
        return;
    L6:
        r8.execute(new b(this, 0));
    }

    private void scheduleLowTputScanCheckLocked(long r8) {
        this.mHandler.removeCallbacks(this.mLowTputScanCheckRunnable);
        this.mHandler.postDelayed(this.mLowTputScanCheckRunnable, r8);
    }

    public static void scheduleNextStartScanDailyReportAlarm(Context r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Context r10 = r8.getApplicationContext();
        if (r10 != null) goto L13;
        Log.w(TAG, "schedule daily report alarm skipped: application context is null");
        return;
    L13:
        sDailyReportAlarmExecutor.execute(new f(r10, 1));     // Catch: RuntimeException -> L10
        return;
    L10:
        e = move-exception;
        Log.w(TAG, "schedule daily report alarm task failed", e);
    }

    private static void scheduleNextStartScanDailyReportAlarmInternal(Context r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        AlarmManager r10 = (AlarmManager) r8.getSystemService("alarm");
        if (r10 != null) goto L7;
        return;
    L7:
        long r11 = System.currentTimeMillis();
        Calendar r12 = Calendar.getInstance();
        r12.setTimeInMillis(r11);
        r12.set(11, 0);
        r12.set(12, 5);
        r12.set(13, 0);
        r12.set(14, 0);
        if (r12.getTimeInMillis() > r11) goto L10;
        r12.add(6, 1);
    L10:
        r10.setExactAndAllowWhileIdle(0, r12.getTimeInMillis(), PendingIntent.getBroadcast(r8, 10005, new Intent(r8, CaeReceiver.class).setAction(ACTION_STARTSCAN_DAILY_REPORT).setPackage(r8.getPackageName()), 201326592));
    }

    private boolean startFullScanWithWifiManagerLocked() {
        WifiManager r8 = this.mWifiManager;
        if (r8 != null) goto L13;
        Log.w(TAG, "startFullScanWithWifiManagerLocked: wifiManager is null");
        return false;
    L13:
        Log.d(TAG, "startScan (full)");     // Catch: Throwable -> L10
        boolean r10 = r8.startScan();     // Catch: Throwable -> L10
        if (r10 == false) goto L9;
        onStartScanSuccessLocked();     // Catch: Throwable -> L10
    L9:
        return r10;
    L10:
        th = move-exception;
        Log.e(TAG, "startFullScanWithWifiManagerLocked: startScan failed", th);
        return false;
    }

    private boolean startPartialFreqScanWithWifiScannerLocked(TreeSet<Integer> r8) {
        WifiScanner r10 = this.mWifiScanner;
        if (r10 != null) goto L6;
        Log.w(TAG, "startPartialFreqScanWithWifiScannerLocked: wifiScanner is null");
        return false;
    L6:
        if (r8 != null) goto L8;
    L33:
        return false;
    L8:
        if (r8.isEmpty() == true) goto L33;
        ArrayList r11 = new ArrayList();
        Iterator<Integer> r12 = r8.iterator();
    L12:
        if (r12.hasNext() == false) goto L21;
        Integer r13 = r12.next();
        if (r13 == null) goto L12;
        if (r13.intValue() <= 0) goto L12;
        r11.add(r13);
        if (r11.size() < 32) goto L12;
    L21:
        if (r11.isEmpty() == false) goto L23;
        return false;
    L23:
        WifiScanner.ChannelSpec[] r14 = new WifiScanner.ChannelSpec[r11.size()];
        int r15 = 0;
    L25:
        if (r15 >= r11.size()) goto L27;
        r14[r15] = new WifiScanner.ChannelSpec(((Integer) r11.get(r15)).intValue());
        r15 = r15 + 1;
        goto L25
    L27:
        WifiScanner.ScanSettings r16 = new WifiScanner.ScanSettings();
        r16.band = 0;
        r16.channels = r14;
        r16.reportEvents = 3;
        r10.startScan(r16, this.mLowTputWifiScannerListener);     // Catch: Throwable -> L31
        return true;
    L31:
        th = move-exception;
        Log.w(TAG, "startPartialFreqScanWithWifiScannerLocked: startScan failed", th);
        goto L33
    }

    private boolean startScanSafelyLocked() {
        if (this.mForceFullScanAfter40s == true) goto L8;
        if (this.mLowTputBackoffIndex < 2) goto L8;
        this.mForceFullScanAfter40s = true;
    L8:
        if (this.mForceFullScanAfter40s == false) goto L36;
    L32:
        boolean r8 = startFullScanWithWifiManagerLocked();
        if (r8 == false) goto L35;
        this.mDailyFullScanCount++;
        Log.d(TAG, "fullScanStarted: mDailyFullScanCount " + this.mDailyFullScanCount);
    L35:
        return r8;
    L36:
        String r10 = null;
        if (this.mWifiManager == null) goto L12;
        WifiInfo r11 = this.mWifiManager.getConnectionInfo();     // Catch: Throwable -> L30
    L13:
        if (r11 == null) goto L15;
        String r12 = r11.getBSSID();     // Catch: Throwable -> L30
    L16:
        if (r11 == null) goto L19;
        r10 = stripSsidQuotes(r11.getSSID());     // Catch: Throwable -> L30
    L19:
        if (TextUtils.isEmpty(r12) == true) goto L32;
        if (TextUtils.isEmpty(r10) == true) goto L32;
        TreeSet<Integer> r13 = getOrLoadScannedFreqsMhzLocked(r12, r10);     // Catch: Throwable -> L30
        if (r13 == null) goto L32;
        if (r13.isEmpty() == true) goto L32;
        if (startPartialFreqScanWithWifiScannerLocked(r13) == false) goto L32;
        this.mDailyPartialScanCount++;     // Catch: Throwable -> L30
        Log.d(TAG, "startScanSafelyLocked: WifiScanner partial scan started, freqsSize=" + r13.size() + ", backoffIndex=" + this.mLowTputBackoffIndex);     // Catch: Throwable -> L30
        StringBuilder r14 = new StringBuilder("mDailyPartialScanCount ");     // Catch: Throwable -> L30
        r14.append(this.mDailyPartialScanCount);     // Catch: Throwable -> L30
        Log.d(TAG, r14.toString());     // Catch: Throwable -> L30
        return true;
    L15:
        r12 = null;
        goto L16
    L12:
        r11 = null;
    L30:
        th = move-exception;
        Log.w(TAG, "startScanSafelyLocked: partial scan path failed, fallback to full scan", th);
        goto L32
    }

    private static String stripSsidQuotes(String r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        if (r8.startsWith("\"") == true) goto L8;
        return r8;
    L8:
        if (r8.endsWith("\"") == true) goto L10;
        return r8;
    L10:
        if (r8.length() >= 2) goto L12;
        return r8;
    L12:
        return r8.substring(1, r8.length() - 1);
    }

    public List<Integer> getScannedFreqsMhzForNetwork(String r8, String r10) {
        if (this.mCacheManager != null) goto L7;
        Log.e(TAG, "getScannedFreqsMhzForNetwork: mCacheManager is null");
        return new ArrayList();
    L7:
        return this.mCacheManager.getScannedFreqsMhz(r8, r10);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r8) {
        Log.i(TAG, "onBind");
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        this.mDestroyed = false;
        this.mDbExecutor = Executors.newSingleThreadExecutor();
        this.mWifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        this.mWifiScanner = (WifiScanner) getApplicationContext().getSystemService("wifiscanner");     // Catch: Throwable -> L5
    L7:
        ServiceManager.addService(SERVICE_NAME_WIFI_DATABASE, this.mBinder);
        this.mPrefs = getSharedPreferences(PREF_NAME, 0);
        monitor-enter(this);
        loadStartScanDailyStateLocked();     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        PowerManager r8 = (PowerManager) getSystemService("power");     // Catch: Throwable -> L18
        if (r8 == null) goto L15;
        boolean r10 = r8.isInteractive();     // Catch: Throwable -> L18
    L16:
        this.mScreenInteractive = r10;     // Catch: Throwable -> L18
    L37:
        IntentFilter r11 = new IntentFilter();     // Catch: Throwable -> L22
        r11.addAction("android.intent.action.SCREEN_ON");     // Catch: Throwable -> L22
        r11.addAction("android.intent.action.SCREEN_OFF");     // Catch: Throwable -> L22
        registerReceiver(this.mScreenStateReceiver, r11);     // Catch: Throwable -> L22
        this.mScreenReceiverRegistered = true;     // Catch: Throwable -> L22
    L41:
        registerReceiver(this.mWifiScanReceiver, new IntentFilter("android.net.wifi.SCAN_RESULTS"));     // Catch: Throwable -> L26
        this.mWifiScanReceiverRegistered = true;     // Catch: Throwable -> L26
    L28:
        scheduleDeferredInit();
        return;
    L26:
        th = move-exception;
        Log.w(TAG, "register scan receiver failed", th);
    L22:
        th = move-exception;
        Log.w(TAG, "register screen state receiver failed", th);
        goto L41
    L15:
        r10 = true;
    L18:
        th = move-exception;
        Log.w(TAG, "init screenInteractive failed", th);
        this.mScreenInteractive = true;
    L30:
        th = move-exception;
        throw th;
    L5:
        th = move-exception;
        Log.w(TAG, "init WifiScanner failed", th);
        this.mWifiScanner = null;
        goto L7
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
        boolean r8 = true;
        this.mDestroyed = true;
        monitor-enter(this);
        WiFiQoEManager r10 = this.mWifiQoEManager;     // Catch: Throwable -> L40
        if (this.mWifiQoeStarted == false) goto L8;
        if (r10 == null) goto L8;
    L9:
        this.mWifiQoeStarted = false;     // Catch: Throwable -> L40
        this.mWifiQoEManager = null;     // Catch: Throwable -> L40
        monitor-exit(this);     // Catch: Throwable -> L40
        if (r8 == true) goto L45;
    L16:
        monitor-enter(this);
        cancelLowTputScanCheckLocked();     // Catch: Throwable -> L37
        this.mLowTputMonitorActive = false;     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        if (this.mScreenReceiverRegistered == false) goto L27;
        unregisterReceiver(this.mScreenStateReceiver);     // Catch: Throwable -> L23
    L25:
        this.mScreenReceiverRegistered = false;
    L23:
        th = move-exception;
        Log.w(TAG, "unregister screen state receiver failed", th);
    L27:
        if (this.mWifiScanReceiverRegistered == true) goto L43;
    L33:
        this.mThroughputCalculation = null;
        if (this.mDbExecutor == null) goto L53;
        this.mDbExecutor.shutdown();
        this.mDbExecutor = null;
        return;
    L53:
        return;
    L43:
        unregisterReceiver(this.mWifiScanReceiver);     // Catch: Throwable -> L30
    L32:
        this.mWifiScanReceiverRegistered = false;
    L30:
        th = move-exception;
        Log.w(TAG, "unregister scan receiver failed", th);
    L37:
        th = move-exception;
        throw th;
    L45:
        r10.stop();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Log.e(TAG, "stop WiFiQoEManager failed", th);
    L8:
        r8 = false;
    L40:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r8, int r10, int r11) {
        if (r8 == null) goto L7;
        if (ACTION_STARTSCAN_DAILY_REPORT.equals(r8.getAction()) == false) goto L7;
        executeDbTask(new b(this, 1));
    L7:
        return super.onStartCommand(r8, r10, r11);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r8) {
        Log.i(TAG, "onUnbind");
        return super.onUnbind(r8);
    }

    private void processScanResultsForBandInfo(List<ScanResult> r10) {
        if (this.mWifiManager != null) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.isEmpty() == true) goto L122;
        int r8 = -1;
        HashSet r11 = null;
        WifiInfo r12 = this.mWifiManager.getConnectionInfo();     // Catch: Throwable -> L29
        if (r12 != null) goto L13;
    L28:
        String r13 = null;
        String r14 = null;
    L32:
        long r15 = System.currentTimeMillis();
        HashSet r16 = new HashSet();
        if (r8 <= 0) goto L35;
        r16.add(Integer.valueOf(r8));
    L35:
        Iterator<ScanResult> r17 = r10.iterator();
    L37:
        if (r17.hasNext() == false) goto L52;
        ScanResult r18 = r17.next();
        if (r18 == null) goto L37;
        if (r18.BSSID == null) goto L37;
        if (TextUtils.isEmpty(r13) == true) goto L48;
        if (r13.equalsIgnoreCase(r18.BSSID) == true) goto L37;
    L48:
        int r19 = r18.frequency;
        if (r19 <= 0) goto L37;
        r16.add(Integer.valueOf(r19));
        goto L37
    L52:
        if (r16.isEmpty() == false) goto L55;
        return;
    L55:
        if (TextUtils.isEmpty(r13) == false) goto L57;
    L84:
        ScannedBandRecord r110 = new ScannedBandRecord();
        r110.timestamp = r15;
        r110.currentBssid = r13;
        r110.currentSsid = r14;
        if (r11 == null) goto L87;
        r16 = r11;
    L87:
        r110.scannedFreqsMhz = TextUtils.join(",", r16);
        ArrayList r20 = new ArrayList();
        r20.add(r110);
        if (r20.isEmpty() == true) goto L121;
        executeDbTask(new k(17, this, r20));
        return;
    L121:
        return;
    L57:
        if (TextUtils.isEmpty(r14) == true) goto L84;
        monitor-enter(this);
        String r111 = makeBssidSsidKey(r13, r14);     // Catch: Throwable -> L81
        TreeSet<Integer> r21 = this.mScannedFreqsCache.get(r111);     // Catch: Throwable -> L81
        if (r21 != null) goto L62;
        r21 = new TreeSet();     // Catch: Throwable -> L81
        this.mScannedFreqsCache.put(r111, r21);     // Catch: Throwable -> L81
    L62:
        r11 = new HashSet();     // Catch: Throwable -> L81
        Iterator r112 = r16.iterator();     // Catch: Throwable -> L81
    L64:
        if (r112.hasNext() == false) goto L74;
        Integer r22 = (Integer) r112.next();     // Catch: Throwable -> L81
        if (r22 == null) goto L64;
        if (r22.intValue() <= 0) goto L64;
        if (r21.contains(r22) == true) goto L64;
        r11.add(r22);     // Catch: Throwable -> L81
        goto L64
    L74:
        if (r11.isEmpty() == false) goto L78;
        Log.d(TAG, "processScanResultsForBandInfo: no new freqs for current network, skip DB write");     // Catch: Throwable -> L81
        monitor-exit(this);     // Catch: Throwable -> L81
        return;
    L78:
        r21.addAll(r11);     // Catch: Throwable -> L81
        monitor-exit(this);     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        throw th;
    L13:
        if (r12.getNetworkId() == (-1)) goto L28;
        r13 = r12.getBSSID();     // Catch: Throwable -> L29
        r14 = r12.getSSID();     // Catch: Throwable -> L26
        r8 = r12.getFrequency();     // Catch: Throwable -> L24
        if (r14 == null) goto L32;
        if (r14.startsWith("\"") == false) goto L32;
        if (r14.endsWith("\"") == false) goto L32;
        r14 = r14.substring(1, r14.length() - 1);     // Catch: Throwable -> L24
    L24:
        th = th;
    L31:
        Log.w(TAG, "Failed to get current connection info", th);
    L26:
        th = th;
        r14 = null;
    L29:
        th = th;
        r13 = null;
        r14 = null;
        goto L31
    }
}
