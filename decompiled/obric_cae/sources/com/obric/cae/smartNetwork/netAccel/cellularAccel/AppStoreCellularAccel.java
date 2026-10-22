package com.obric.cae.smartNetwork.netAccel.cellularAccel;

import android.aimedia.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.keva.KevaImpl;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetTcpInfo;
import com.obric.cae.smartNetwork.netAccel.AccelConfigManager;
import com.obric.cae.smartNetwork.netAccel.AccelControl;
import com.obric.cae.smartNetwork.networkMonitor.ActivityMonitor;
import com.obric.cae.smartNetwork.networkRateLimit.GetSkinTemperature;
import defpackage.b;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class AppStoreCellularAccel implements CellularConnector.CellularConnectionListener {
    private static final String CELLULAR_IF_PREFIX = "rmnet";
    private static final long DEFAULT_DAILY_TRAFFIC_LIMIT_BYTES = 104857600;
    private static final String KEY_THERMAL_DISABLE = "zte_market_thermal_disable";
    private static final String KEY_TRAFFIC_QUOTA = "zte_market_data_traffic_quota";
    private static final String PREF_KEY_DATE = "today_date";
    private static final String PREF_KEY_TODAY_USED_BYTES = "today_used_bytes";
    private static final String PREF_NAME = "appstore_cellular_accel";
    private static final double SAVE_THRESHOLD_RATIO = 0.1d;
    private static final String TAG = "MultiNetwork-AppStoreCellularAccel";
    private static final String TARGET_PACKAGE = "zte.com.market";
    private static final float TEMP_THRESHOLD_START = 36.0f;
    private static final float TEMP_THRESHOLD_STOP = 39.0f;
    private static final long TRAFFIC_UNLIMITED = -1;
    private final AccelConfigManager mAccelConfigManager;
    private final AccelControl mAccelControl;
    private final ActivityMonitor.ActivityMonitorListener mActivityListener;
    private volatile boolean mAppStoreCellularAccelEnabled;
    private final CellularConnector mCellularConnector;
    private final Context mContext;
    private volatile long mDailyTrafficLimitBytes;
    private final GetSkinTemperature mGetSkinTemperature;
    private boolean mIsAccelerating;
    private boolean mIsForeground;
    private final AtomicBoolean mIsMonitoring;
    private final L4NetEvaluate mL4NetEvaluate;
    private final SharedPreferences mPrefs;
    private volatile long mSaveThresholdBytes;
    private boolean mScreenOn;
    private final BroadcastReceiver mScreenReceiver;
    private long mSessionTrafficBytes;
    private final ContentObserver mSettingsObserver;
    private final int mTargetUid;
    private volatile boolean mThermalControlDisabled;
    private int mTodayDate;
    private volatile long mTodayUsedBytes;
    private final L4NetEvaluate.L4NetTcpInfoListenerCallback mTrafficCallback;

    public AppStoreCellularAccel(Context r8, CellularConnector r10, AccelControl r11) {
        this.mIsMonitoring = new AtomicBoolean(false);
        this.mSessionTrafficBytes = 0;
        this.mTodayUsedBytes = 0;
        this.mTodayDate = 0;
        this.mIsForeground = false;
        this.mScreenOn = true;
        this.mIsAccelerating = false;
        this.mAppStoreCellularAccelEnabled = false;
        this.mDailyTrafficLimitBytes = DEFAULT_DAILY_TRAFFIC_LIMIT_BYTES;
        this.mSaveThresholdBytes = WsConstants.DEFAULT_IO_LIMIT;
        this.mThermalControlDisabled = false;
        final Handler r12 = new Handler(Looper.getMainLooper());
        ContentObserver r13 = new AnonymousClass1(this, r12);
        this.mSettingsObserver = r13;
        this.mTrafficCallback = new AnonymousClass2(this);
        ActivityMonitor.ActivityMonitorListener r14 = new AnonymousClass3(this);
        this.mActivityListener = r14;
        BroadcastReceiver r15 = new AnonymousClass4(this);
        this.mScreenReceiver = r15;
        this.mContext = r8;
        this.mCellularConnector = r10;
        this.mAccelControl = r11;
        this.mAccelConfigManager = AccelConfigManager.getInstance(r8);
        this.mL4NetEvaluate = L4NetEvaluate.getInstance(r8);
        GetSkinTemperature r16 = new GetSkinTemperature();
        this.mGetSkinTemperature = r16;
        r16.init();
        this.mTargetUid = resolveTargetUid();
        SharedPreferences r17 = r8.getSharedPreferences(PREF_NAME, 0);
        this.mPrefs = r17;
        this.mTodayDate = getTodayDate();
        if (r17.getInt(PREF_KEY_DATE, 0) != this.mTodayDate) goto L5;
        this.mTodayUsedBytes = r17.getLong(PREF_KEY_TODAY_USED_BYTES, 0);
    L6:
        this.mAppStoreCellularAccelEnabled = readAppStoreCellularAccelSetting();
        this.mDailyTrafficLimitBytes = readTrafficLimitSetting();
        this.mThermalControlDisabled = readThermalControlDisabled();
        r8.getContentResolver().registerContentObserver(Settings.System.getUriFor(KEY_TRAFFIC_QUOTA), false, r13);
        r8.getContentResolver().registerContentObserver(Settings.System.getUriFor(KEY_THERMAL_DISABLE), false, r13);
        ActivityMonitor.getInstance(r8).registerActivityListener(r14);
        IntentFilter r18 = new IntentFilter();
        r18.addAction("android.intent.action.SCREEN_OFF");
        r18.addAction("android.intent.action.USER_PRESENT");
        r8.registerReceiver(r15, r18);
        return;
    L5:
        this.mTodayUsedBytes = 0;
        goto L6
    }

    public static /* synthetic */ long access$000(AppStoreCellularAccel r8) {
        return r8.readTrafficLimitSetting();
    }

    public static /* synthetic */ boolean access$100(AppStoreCellularAccel r8) {
        return r8.mAppStoreCellularAccelEnabled;
    }

    public static /* synthetic */ boolean access$1000(AppStoreCellularAccel r8) {
        return r8.mIsForeground;
    }

    public static /* synthetic */ boolean access$1002(AppStoreCellularAccel r8, boolean r10) {
        r8.mIsForeground = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$102(AppStoreCellularAccel r8, boolean r10) {
        r8.mAppStoreCellularAccelEnabled = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1100(AppStoreCellularAccel r8) {
        return r8.mIsAccelerating;
    }

    public static /* synthetic */ boolean access$1102(AppStoreCellularAccel r8, boolean r10) {
        r8.mIsAccelerating = r10;
        return r10;
    }

    public static /* synthetic */ void access$1200(AppStoreCellularAccel r8) {
        r8.disableCellularAccelForUid();
    }

    public static /* synthetic */ CellularConnector access$1300(AppStoreCellularAccel r8) {
        return r8.mCellularConnector;
    }

    public static /* synthetic */ boolean access$1400(AppStoreCellularAccel r8) {
        return r8.isCellularAccelEnabled();
    }

    public static /* synthetic */ boolean access$1500(AppStoreCellularAccel r8) {
        return r8.mScreenOn;
    }

    public static /* synthetic */ boolean access$1502(AppStoreCellularAccel r8, boolean r10) {
        r8.mScreenOn = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1600(AppStoreCellularAccel r8) {
        return r8.isWifiConnected();
    }

    public static /* synthetic */ boolean access$1700(AppStoreCellularAccel r8) {
        return r8.isTempAllowStart();
    }

    public static /* synthetic */ void access$1800(AppStoreCellularAccel r8) {
        r8.allowCellularAccelForUid();
    }

    public static /* synthetic */ long access$200(AppStoreCellularAccel r8) {
        return r8.mDailyTrafficLimitBytes;
    }

    public static /* synthetic */ long access$202(AppStoreCellularAccel r8, long r10) {
        r8.mDailyTrafficLimitBytes = r10;
        return r10;
    }

    public static /* synthetic */ String access$300(AppStoreCellularAccel r8, long r10) {
        return r8.formatMB(r10);
    }

    public static /* synthetic */ long access$402(AppStoreCellularAccel r8, long r10) {
        r8.mSaveThresholdBytes = r10;
        return r10;
    }

    public static /* synthetic */ void access$500(AppStoreCellularAccel r8, boolean r10) {
        r8.onAccelSwitchChanged(r10);
    }

    public static /* synthetic */ boolean access$600(AppStoreCellularAccel r8) {
        return r8.readThermalControlDisabled();
    }

    public static /* synthetic */ boolean access$700(AppStoreCellularAccel r8) {
        return r8.mThermalControlDisabled;
    }

    public static /* synthetic */ boolean access$702(AppStoreCellularAccel r8, boolean r10) {
        r8.mThermalControlDisabled = r10;
        return r10;
    }

    public static /* synthetic */ AtomicBoolean access$800(AppStoreCellularAccel r8) {
        return r8.mIsMonitoring;
    }

    public static /* synthetic */ void access$900(AppStoreCellularAccel r8, ConcurrentHashMap r10) {
        r8.processTrafficReport(r10);
    }

    private void allowCellularAccelForUid() {
        int r8 = this.mTargetUid;
        if (r8 > 0) goto L5;
        return;
    L5:
        this.mAccelControl.setUidDenyNetworkType((byte) 0, r8, false);
    }

    private void checkDayReset() {
        int r8 = getTodayDate();
        if (r8 == this.mTodayDate) goto L6;
        CaeLog.i(TAG, "new day detected, resetting traffic counter");
        this.mTodayUsedBytes = 0;
        this.mSessionTrafficBytes = 0;
        this.mTodayDate = r8;
        saveTodayUsedBytes();
        return;
    }

    private void disableCellularAccelForUid() {
        int r8 = this.mTargetUid;
        if (r8 > 0) goto L5;
        return;
    L5:
        this.mAccelControl.setUidDenyNetworkType((byte) 0, r8, true);
        this.mAccelControl.disconnectSocketByUid(this.mTargetUid);
    }

    private String formatMB(long r8) {
        return String.format("%.2fMB", new Object[]{Double.valueOf(r8 / 1048576.0d)});
    }

    private int getTodayDate() {
        Calendar r8 = Calendar.getInstance();
        int r10 = r8.get(1) * KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        int r11 = (r8.get(2) * 100) + r10;
        return r8.get(5) + r11;
    }

    private boolean isCellularAccelEnabled() {
        if (this.mAccelConfigManager.getPackageRule(TARGET_PACKAGE).getCellularAccelEnable() == true) goto L7;
        CaeLog.i(TAG, "isCellularAccelEnabled: cloud config disabled");
        return false;
    L7:
        return this.mAppStoreCellularAccelEnabled;
    }

    private boolean isTempAllowStart() {
        if (isThermalControlDisabled() == false) goto L5;
        return true;
    L5:
        float r8 = this.mGetSkinTemperature.getSkinTemperature();
        CaeLog.d(TAG, "isTempAllowStart: temp=" + r8 + ", threshold=36.0");
        if (r8 < TEMP_THRESHOLD_START) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean isTempExceedStop() {
        if (isThermalControlDisabled() == false) goto L6;
        return false;
    L6:
        if (this.mGetSkinTemperature.getSkinTemperature() < TEMP_THRESHOLD_STOP) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean isThermalControlDisabled() {
        return this.mThermalControlDisabled;
    }

    private boolean isWifiConnected() {
        ConnectivityManager r8 = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "isWifiConnected: ConnectivityManager is null");
        return false;
    L6:
        Network[] r10 = r8.getAllNetworks();
        int r11 = r10.length;
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L14;
        NetworkCapabilities r13 = r8.getNetworkCapabilities(r10[r12]);
        if (r13 == null) goto L13;
        if (r13.hasTransport(1) == false) goto L13;
        return true;
    L13:
        r12 = r12 + 1;
        goto L7
    L14:
        return false;
    }

    private void onAccelSwitchChanged(boolean r8) {
        if (r8 == false) goto L18;
        if (this.mIsForeground == true) goto L7;
        return;
    L7:
        if (this.mScreenOn == true) goto L9;
        return;
    L9:
        if (this.mIsAccelerating == false) goto L11;
        return;
    L11:
        if (isWifiConnected() == true) goto L13;
        return;
    L13:
        if (isTrafficExceeded() == false) goto L15;
        return;
    L15:
        if (isTempAllowStart() == false) goto L26;
        CaeLog.i(TAG, "switch turned ON while foreground, starting cellular accel");
        allowCellularAccelForUid();
        this.mCellularConnector.connect(TARGET_PACKAGE, this);
        return;
    L26:
        return;
    L18:
        if (this.mIsAccelerating == false) goto L28;
        CaeLog.i(TAG, "switch turned OFF, stopping cellular accel");
        disableCellularAccelForUid();
        this.mCellularConnector.disconnect(TARGET_PACKAGE);
        this.mIsAccelerating = false;
        return;
    }

    private void processTrafficReport(ConcurrentHashMap<Integer, ConcurrentHashMap<Long, L4NetTcpInfo>> r11) {
        if (r11 == null) goto L44;
        int r8 = this.mTargetUid;
        if (r8 <= 0) goto L48;
        ConcurrentHashMap<Long, L4NetTcpInfo> r12 = r11.get(Integer.valueOf(r8));
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.isEmpty() == true) goto L49;
        Iterator<Map.Entry<Long, L4NetTcpInfo>> r13 = r12.entrySet().iterator();
        long r10 = 0;
    L13:
        if (r13.hasNext() == false) goto L20;
        L4NetTcpInfo r14 = r13.next().getValue();
        String r15 = r14.ifName;
        if (r15 == null) goto L13;
        if (r15.startsWith(CELLULAR_IF_PREFIX) == false) goto L13;
        r10 = r10 + (r14.tcpRecvBytes + r14.tcpSendBytes);
        goto L13
    L20:
        if (r10 <= 0) goto L46;
        this.mSessionTrafficBytes += r10;
        long r16 = this.mTodayUsedBytes + this.mSessionTrafficBytes;
        if (this.mDailyTrafficLimitBytes == (-1)) goto L27;
        if (this.mSessionTrafficBytes < this.mSaveThresholdBytes) goto L27;
        this.mTodayUsedBytes += this.mSessionTrafficBytes;
        this.mSessionTrafficBytes = 0;
        saveTodayUsedBytes();
    L27:
        if (this.mDailyTrafficLimitBytes != (-1)) goto L29;
    L31:
        boolean r17 = false;
    L32:
        if (r17 == false) goto L34;
    L35:
        StringBuilder r18 = a.l("stopping acceleration: trafficExceeded=", r17, ", tempExceedStop=");
        r18.append(isTempExceedStop());
        CaeLog.w(TAG, r18.toString());
        disableCellularAccelForUid();
        this.mCellularConnector.disconnect(TARGET_PACKAGE);
        this.mIsAccelerating = false;
        return;
    L34:
        if (isTempExceedStop() == true) goto L35;
        return;
    L29:
        if (r16 < this.mDailyTrafficLimitBytes) goto L31;
        r17 = true;
        goto L32
    L46:
        return;
    L49:
        return;
    L48:
        return;
    }

    private boolean readAppStoreCellularAccelSetting() {
        int r8 = Settings.System.getInt(this.mContext.getContentResolver(), KEY_TRAFFIC_QUOTA, 0);     // Catch: Exception -> L9
        if (r8 <= 0) goto L6;
    L7:
        return true;
    L6:
        if (r8 == (-1)) goto L7;
        return false;
    L9:
        e = move-exception;
        CaeLog.w(TAG, "readAppStoreCellularAccelSetting failed: " + e.getMessage());
        return false;
    }

    private boolean readThermalControlDisabled() {
        if (Settings.System.getInt(this.mContext.getContentResolver(), KEY_THERMAL_DISABLE, 0) == 1) goto L7;
        return false;
    L7:
        return true;
    L12:
        return false;
    }

    private long readTrafficLimitSetting() {
        int r8 = Settings.System.getInt(this.mContext.getContentResolver(), KEY_TRAFFIC_QUOTA, 0);     // Catch: Exception -> L12
        if (r8 != (-1)) goto L8;
        return -1;
    L8:
        if (r8 > 0) goto L11;
        return 0;
    L11:
        return (((long) r8) * 1024) * 1024;
    L12:
        e = move-exception;
        CaeLog.w(TAG, "readTrafficLimitSetting failed: " + e.getMessage());
        return 0;
    }

    private int resolveTargetUid() {
        int r8 = this.mContext.getPackageManager().getApplicationInfo(TARGET_PACKAGE, 0).uid;     // Catch: Exception -> L5
        CaeLog.d(TAG, "resolveTargetUid: zte.com.market -> uid=" + r8);     // Catch: Exception -> L5
        return r8;
    L5:
        e = move-exception;
        b.k(e, new StringBuilder("resolveTargetUid failed: "), TAG);
        return -1;
    }

    private void saveTodayUsedBytes() {
        this.mPrefs.edit().putInt(PREF_KEY_DATE, this.mTodayDate).putLong(PREF_KEY_TODAY_USED_BYTES, this.mTodayUsedBytes).apply();
        CaeLog.d(TAG, "saveTodayUsedBytes: " + formatMB(this.mTodayUsedBytes));
    }

    private void startTrafficMonitor() {
        if (this.mL4NetEvaluate != null) goto L7;
        CaeLog.e(TAG, "startTrafficMonitor: L4NetEvaluate not available");
        return;
    L7:
        if (this.mIsMonitoring.getAndSet(true) == false) goto L10;
        CaeLog.w(TAG, "already monitoring");
        return;
    L10:
        checkDayReset();
        this.mSessionTrafficBytes = 0;
        StringBuilder r8 = a.l("startTrafficMonitor: registered=", this.mL4NetEvaluate.registerL4NetTcpInfoListener(this.mTrafficCallback), ", targetUid=");
        r8.append(this.mTargetUid);
        r8.append(", todayUsed=");
        a.r(r8, formatMB(this.mTodayUsedBytes), TAG);
    }

    private void stopTrafficMonitor() {
        if (this.mIsMonitoring.getAndSet(false) == true) goto L5;
        return;
    L5:
        L4NetEvaluate r8 = this.mL4NetEvaluate;
        if (r8 == null) goto L8;
        r8.unregisterL4NetTcpInfoListener(this.mTrafficCallback);
    L8:
        this.mTodayUsedBytes += this.mSessionTrafficBytes;
        StringBuilder r10 = new StringBuilder("stopTrafficMonitor: sessionUsed=");
        r10.append(formatMB(this.mSessionTrafficBytes));
        r10.append(", todayTotal=");
        a.r(r10, formatMB(this.mTodayUsedBytes), TAG);
        this.mSessionTrafficBytes = 0;
        saveTodayUsedBytes();
    }

    public boolean isTrafficExceeded() {
        if (this.mDailyTrafficLimitBytes != (-1)) goto L5;
        return false;
    L5:
        checkDayReset();
        if ((this.mTodayUsedBytes + this.mSessionTrafficBytes) < this.mDailyTrafficLimitBytes) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.cellularAccel.CellularConnector.CellularConnectionListener
    public void onCellularConnected(Network r8) {
        this.mIsAccelerating = true;
        startTrafficMonitor();
    }

    @Override // com.obric.cae.smartNetwork.netAccel.cellularAccel.CellularConnector.CellularConnectionListener
    public void onCellularDisconnected() {
        stopTrafficMonitor();
    }

    @Override // com.obric.cae.smartNetwork.netAccel.cellularAccel.CellularConnector.CellularConnectionListener
    public void onCellularLost() {
        stopTrafficMonitor();
    }
}
