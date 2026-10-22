package com.obric.cae.smartNetwork;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.networkHandover.NetworkUtil;
import com.obric.cae.statusReport.wifi.CaeWifiStatusCollect;
import com.obric.cae.utils.CaeUtil;
import com.obric.cae.wifi.WiFiDBHelper;
import java.util.ArrayDeque;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PoorLinkDisconnectPolicy {
    private static final long DEFAULT_COOLDOWN_MS = 120000;
    private static final int DEFAULT_HIT_COUNT_THRESHOLD = 3;
    private static final int DEFAULT_RSSI_24G_DBM = -73;
    private static final int DEFAULT_RSSI_5G_DBM = -85;
    private static final int DEFAULT_TPUT_KBPS = 3000;
    private static final int DESTINATION_NETWORK_CELLULAR = 2;
    private static final int DESTINATION_NETWORK_NONE = 0;
    private static final int DESTINATION_NETWORK_OTHER_WIFI = 1;
    private static final int INVALID_RSSI = Integer.MIN_VALUE;
    private static final long RECOVERY_REPORT_TIMEOUT_MS = 10000;
    private static final String TAG = "PoorLinkDisconnectPolicy";
    private static final long WIFI_INFO_STALE_MS = 3500;
    private final ContentObserver mConfigObserver;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private volatile long mCooldownMs;
    private final Handler mHandler;
    private int mHitCount;
    private long mLastDisconnectTimestampMs;
    private String mLatestBssid;
    private int mLatestFrequency;
    private int mLatestRssi;
    private int mLatestRxThroughputKbps;
    private String mLatestSsid;
    private int mLatestTxThroughputKbps;
    private long mLatestWifiInfoTimestampMs;
    private volatile boolean mNetworkHandoverEnabled;
    private volatile boolean mPolicyEnabled;
    private final ArrayDeque<Integer> mRecentThroughputSamples;
    private int mRecentThroughputSum;
    private volatile int mRssi24GThresholdDbm;
    private volatile int mRssi5GThresholdDbm;
    private volatile int mThroughputThresholdKbps;
    private int mTriggerId;
    private final WifiManager mWifiManager;

    public final class RecoveryMonitor {
        private boolean mFinished;
        private final ConnectivityManager.NetworkCallback mNetworkCallback;
        private boolean mRegistered;
        private final TriggerSnapshot mSnapshot;
        private final Runnable mTimeoutRunnable;
        final /* synthetic */ PoorLinkDisconnectPolicy this$0;

        public RecoveryMonitor(final PoorLinkDisconnectPolicy r8, TriggerSnapshot r10) {
            this.this$0 = r8;
            this.mSnapshot = r10;
            this.mNetworkCallback = new AnonymousClass1(this, r8);
            this.mTimeoutRunnable = new AnonymousClass2(this, r8);
        }

        public static /* synthetic */ void access$100(RecoveryMonitor r8, Network r10) {
            r8.handleNetworkChanged(r10);
        }

        public static /* synthetic */ void access$200(RecoveryMonitor r8, NetworkCapabilities r10) {
            r8.handleCapabilitiesChanged(r10);
        }

        public static /* synthetic */ void access$300(RecoveryMonitor r8, int r10, int r11) {
            r8.finish(r10, r11);
        }

        private void finish(int r8, int r10) {
            if (this.mFinished == false) goto L5;
            return;
        L5:
            this.mFinished = true;
            PoorLinkDisconnectPolicy.access$400(this.this$0).removeCallbacks(this.mTimeoutRunnable);
            if (this.mRegistered == true) goto L13;
        L11:
            PoorLinkDisconnectPolicy.access$800(this.this$0, this.mSnapshot, r8, r10);
            return;
        L13:
            PoorLinkDisconnectPolicy.access$500(this.this$0).unregisterNetworkCallback(this.mNetworkCallback);     // Catch: Exception -> L9
        L9:
            e = move-exception;
            CaeLog.e(PoorLinkDisconnectPolicy.TAG, "unregister recovery monitor failed", e);
            goto L11
        }

        private void handleCapabilitiesChanged(NetworkCapabilities r8) {
            int r10 = PoorLinkDisconnectPolicy.access$600(this.this$0, r8, this.mSnapshot.bssid);
            if (r10 != 1) goto L5;
        L6:
            finish(r10, PoorLinkDisconnectPolicy.access$700(this.this$0, r8));
            return;
        L5:
            if (r10 == 2) goto L6;
        }

        private void handleNetworkChanged(Network r8) {
            if (r8 != null) goto L4;
            return;
        L4:
            handleCapabilitiesChanged(PoorLinkDisconnectPolicy.access$500(this.this$0).getNetworkCapabilities(r8));
        }

        public void start() {
            PoorLinkDisconnectPolicy.access$500(this.this$0).registerDefaultNetworkCallback(this.mNetworkCallback, PoorLinkDisconnectPolicy.access$400(this.this$0));     // Catch: Exception -> L6
            this.mRegistered = true;     // Catch: Exception -> L6
            PoorLinkDisconnectPolicy.access$400(this.this$0).postDelayed(this.mTimeoutRunnable, 10000);     // Catch: Exception -> L6
            Network r8 = PoorLinkDisconnectPolicy.access$500(this.this$0).getActiveNetwork();     // Catch: Exception -> L6
            if (r8 == null) goto L11;
            handleNetworkChanged(r8);     // Catch: Exception -> L6
            return;
        L11:
            return;
        L6:
            e = move-exception;
            CaeLog.e(PoorLinkDisconnectPolicy.TAG, "start recovery monitor failed", e);
            finish(0, 0);
        }
    }

    public static final class TriggerSnapshot {
        final int avgThroughputKbps;
        final String bssid;
        final String foregroundPackage;
        final int rssi;
        final int triggerId;
        final int wifiBand;

        public TriggerSnapshot(int r8, String r10, int r11, int r12, int r13, String r14) {
            this.triggerId = r8;
            this.bssid = r10;
            this.wifiBand = r11;
            this.rssi = r12;
            this.avgThroughputKbps = r13;
            this.foregroundPackage = r14;
        }
    }

    public PoorLinkDisconnectPolicy(Context r8) {
        this.mRecentThroughputSamples = new ArrayDeque();
        this.mLatestRssi = Integer.MIN_VALUE;
        this.mLatestFrequency = 0;
        this.mLatestRxThroughputKbps = 0;
        this.mLatestTxThroughputKbps = 0;
        this.mHitCount = 0;
        this.mTriggerId = 0;
        this.mRecentThroughputSum = 0;
        this.mLatestWifiInfoTimestampMs = 0;
        this.mLastDisconnectTimestampMs = 0;
        this.mPolicyEnabled = true;
        this.mRssi24GThresholdDbm = DEFAULT_RSSI_24G_DBM;
        this.mRssi5GThresholdDbm = DEFAULT_RSSI_5G_DBM;
        this.mThroughputThresholdKbps = 3000;
        this.mCooldownMs = 120000;
        this.mNetworkHandoverEnabled = false;
        this.mContext = r8;
        this.mWifiManager = (WifiManager) r8.getSystemService("wifi");
        this.mConnectivityManager = (ConnectivityManager) r8.getSystemService("connectivity");
        final Handler r10 = new Handler(Looper.getMainLooper());
        this.mHandler = r10;
        this.mConfigObserver = new AnonymousClass1(this, r10);
        loadConfigFromSettings();
        registerConfigObserver();
    }

    public static /* synthetic */ void access$000(PoorLinkDisconnectPolicy r8) {
        r8.loadConfigFromSettings();
    }

    public static /* synthetic */ Handler access$400(PoorLinkDisconnectPolicy r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ ConnectivityManager access$500(PoorLinkDisconnectPolicy r8) {
        return r8.mConnectivityManager;
    }

    public static /* synthetic */ int access$600(PoorLinkDisconnectPolicy r8, NetworkCapabilities r10, String r11) {
        return r8.getDestinationNetwork(r10, r11);
    }

    public static /* synthetic */ int access$700(PoorLinkDisconnectPolicy r8, NetworkCapabilities r10) {
        return r8.isInternetRecovered(r10);
    }

    public static /* synthetic */ void access$800(PoorLinkDisconnectPolicy r8, TriggerSnapshot r10, int r11, int r12) {
        r8.reportRecovery(r10, r11, r12);
    }

    private void addThroughputSample(int r8) {
        this.mRecentThroughputSamples.addLast(Integer.valueOf(r8));
        this.mRecentThroughputSum += r8;
    L4:
        if (this.mRecentThroughputSamples.size() <= 3) goto L6;
        this.mRecentThroughputSum -= this.mRecentThroughputSamples.removeFirst().intValue();
        goto L4
    }

    private void disconnectPoorLink() {
        if (this.mWifiManager != null) goto L6;
        CaeLog.e(TAG, "WifiManager is null, skip poor link disconnect");
        resetHitCount();
        return;
    L6:
        long r8 = System.currentTimeMillis();
        int r10 = this.mTriggerId + 1;
        this.mTriggerId = r10;
        TriggerSnapshot r11 = new TriggerSnapshot(r10, this.mLatestBssid, getWifiBandForReport(this.mLatestFrequency), this.mLatestRssi, getAverageThroughputKbps(), getForegroundPackageName());
        this.mLastDisconnectTimestampMs = r8;
        resetHitCount();
        StringBuilder r12 = defpackage.b.f("disconnect poor Wi-Fi link, triggerId=", r10, ", bssid=");
        r12.append(this.mLatestBssid);
        r12.append(", ssid=");
        r12.append(this.mLatestSsid);
        r12.append(", rssi=");
        r12.append(this.mLatestRssi);
        r12.append(", freq=");
        r12.append(this.mLatestFrequency);
        r12.append(", rx=");
        r12.append(this.mLatestRxThroughputKbps);
        r12.append(", tx=");
        defpackage.b.p(r12, this.mLatestTxThroughputKbps, TAG);
    L11:
        e = move-exception;
        CaeLog.e(TAG, "disconnect poor Wi-Fi link failed", e);
        return;
    L8:
        if (this.mWifiManager.disconnect() == false) goto L16;
        scheduleRecoveryReport(r11);     // Catch: Exception -> L11
        return;
    }

    private void evaluate() {
        long r8 = System.currentTimeMillis();
        if (this.mPolicyEnabled == true) goto L7;
        resetHitCount();
        return;
    L7:
        if ((r8 - this.mLastDisconnectTimestampMs) >= this.mCooldownMs) goto L11;
        resetHitCount();
        return;
    L11:
        if (shouldSkipDisconnectForNetworkHandover() == false) goto L15;
        resetHitCount();
        return;
    L15:
        if (isWifiInfoValid(r8) == true) goto L17;
    L34:
        resetHitCount();
        return;
    L17:
        if (isCurrentWifiConnected() == false) goto L34;
        boolean r10 = isRssiPoor();
        if (this.mLatestRxThroughputKbps >= this.mThroughputThresholdKbps) goto L22;
    L25:
        boolean r11 = true;
    L26:
        StringBuilder r12 = new StringBuilder("rx=");
        r12.append(this.mLatestRxThroughputKbps);
        r12.append(", tx=");
        r12.append(this.mLatestTxThroughputKbps);
        r12.append("throughputPoor=");
        r12.append(r11);
        r12.append(", rssi=");
        defpackage.a.j(r12, this.mLatestRssi, TAG);
        if (r10 == false) goto L32;
        if (r11 == false) goto L32;
        this.mHitCount++;
        StringBuilder r13 = new StringBuilder("poor link hit count=");
        r13.append(this.mHitCount);
        r13.append(", rssi=");
        r13.append(this.mLatestRssi);
        r13.append(", freq=");
        r13.append(this.mLatestFrequency);
        r13.append(", rx=");
        r13.append(this.mLatestRxThroughputKbps);
        r13.append(", tx=");
        defpackage.a.j(r13, this.mLatestTxThroughputKbps, TAG);
        if (this.mHitCount < 3) goto L36;
        disconnectPoorLink();
        return;
    L36:
        return;
    L32:
        resetHitCount();
        return;
    L22:
        if (this.mLatestTxThroughputKbps < this.mThroughputThresholdKbps) goto L25;
        r11 = false;
        goto L26
    }

    private int getAverageThroughputKbps() {
        if (this.mRecentThroughputSamples.isEmpty() == false) goto L7;
        return 0;
    L7:
        return this.mRecentThroughputSum / this.mRecentThroughputSamples.size();
    }

    private String getCurrentBssid() {
        WifiManager r8 = this.mWifiManager;
        if (r8 != null) goto L12;
        return null;
    L12:
        WifiInfo r10 = r8.getConnectionInfo();     // Catch: Exception -> L9
        if (r10 == null) goto L14;
        return r10.getBSSID();
    L14:
        return null;
    L9:
        e = move-exception;
        CaeLog.e(TAG, "get current BSSID failed", e);
        return null;
    }

    private int getDestinationNetwork(NetworkCapabilities r8, String r10) {
        if (r8 != null) goto L6;
        return 0;
    L6:
        if (r8.hasTransport(0) == false) goto L10;
        return 2;
    L10:
        if (r8.hasTransport(1) == false) goto L16;
        String r11 = getCurrentBssid();
        if (r11 == null) goto L16;
        if (r11.equals(r10) == true) goto L16;
        return 1;
    L16:
        return 0;
    }

    private String getForegroundPackageName() {
        ActivityManager r8 = (ActivityManager) this.mContext.getSystemService("activity");     // Catch: Exception -> L15
        if (r8 != null) goto L6;
        return "";
    L6:
        List<ActivityManager.RunningTaskInfo> r10 = r8.getRunningTasks(1);     // Catch: Exception -> L15
        if (r10 != null) goto L9;
        return "";
    L9:
        if (r10.isEmpty() == true) goto L21;
        ComponentName r11 = r10.get(0).topActivity;     // Catch: Exception -> L15
        if (r11 == null) goto L22;
        return r11.getPackageName();
    L22:
        return "";
    L21:
        return "";
    L15:
        e = move-exception;
        CaeLog.e(TAG, "get foreground package failed", e);
        return "";
    }

    private int getWifiBandForReport(int r8) {
        int r10 = CaeUtil.getCurrentWifiBand(r8);
        if (r10 != 1) goto L7;
        return 24;
    L7:
        if (r10 != 2) goto L10;
        return 5;
    L10:
        return 0;
    }

    private boolean isCurrentWifiConnected() {
        WifiManager r8 = this.mWifiManager;
        if (r8 != null) goto L15;
        return false;
    L15:
        WifiInfo r10 = r8.getConnectionInfo();     // Catch: Exception -> L12
        if (r10 == null) goto L17;
        if (r10.getNetworkId() == (-1)) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L12:
        e = move-exception;
        CaeLog.e(TAG, "check current Wi-Fi state failed", e);
        return false;
    }

    private int isInternetRecovered(NetworkCapabilities r8) {
        if (r8 != null) goto L4;
    L6:
        return 0;
    L4:
        if (r8.hasCapability(16) == false) goto L6;
        return 1;
    }

    private boolean isRssiPoor() {
        int r8 = CaeUtil.getCurrentWifiBand(this.mLatestFrequency);
        if (r8 != 1) goto L9;
        if (this.mLatestRssi <= this.mRssi24GThresholdDbm) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (r8 == 2) goto L11;
        return false;
    L11:
        if (this.mLatestRssi <= this.mRssi5GThresholdDbm) goto L13;
        return false;
    L13:
        return true;
    }

    private boolean isWifiInfoValid(long r8) {
        if (this.mLatestRssi != Integer.MIN_VALUE) goto L5;
    L9:
        return false;
    L5:
        if (this.mLatestFrequency <= 0) goto L9;
        if ((r8 - this.mLatestWifiInfoTimestampMs) > WIFI_INFO_STALE_MS) goto L9;
        return true;
    }

    private void loadConfigFromSettings() {
        ContentResolver r8 = this.mContext.getContentResolver();
        this.mNetworkHandoverEnabled = "1".equals(Settings.Global.getString(r8, "network_avoid_bad_wifi"));
        boolean r10 = true;
        if (Settings.Global.getInt(r8, CloudConfigParseAndSave.SETTINGS_GLOBAL_ENABLE_CAE_POOR_LINK_DISCONNECT, 1) == 1) goto L6;
        r10 = false;
    L6:
        this.mPolicyEnabled = r10;
        this.mRssi24GThresholdDbm = Settings.Global.getInt(r8, CloudConfigParseAndSave.SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_RSSI_24G, DEFAULT_RSSI_24G_DBM);
        this.mRssi5GThresholdDbm = Settings.Global.getInt(r8, CloudConfigParseAndSave.SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_RSSI_5G, DEFAULT_RSSI_5G_DBM);
        this.mThroughputThresholdKbps = Settings.Global.getInt(r8, CloudConfigParseAndSave.SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_TPUT_KBPS, 3000);
        this.mCooldownMs = Settings.Global.getLong(r8, CloudConfigParseAndSave.SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_COOLDOWN_MS, 120000);
        CaeLog.i(TAG, "poor link config updated, enabled=" + this.mPolicyEnabled + ", rssi24g=" + this.mRssi24GThresholdDbm + ", rssi5g=" + this.mRssi5GThresholdDbm + ", throughput=" + this.mThroughputThresholdKbps + ", cooldown=" + this.mCooldownMs + ", networkHandoverEnabled=" + this.mNetworkHandoverEnabled);
    }

    private void registerConfigObserver() {
        ContentResolver r8 = this.mContext.getContentResolver();
        r8.registerContentObserver(Settings.Global.getUriFor("network_avoid_bad_wifi"), false, this.mConfigObserver);
        r8.registerContentObserver(Settings.Global.getUriFor(CloudConfigParseAndSave.SETTINGS_GLOBAL_ENABLE_CAE_POOR_LINK_DISCONNECT), false, this.mConfigObserver);
        r8.registerContentObserver(Settings.Global.getUriFor(CloudConfigParseAndSave.SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_RSSI_24G), false, this.mConfigObserver);
        r8.registerContentObserver(Settings.Global.getUriFor(CloudConfigParseAndSave.SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_RSSI_5G), false, this.mConfigObserver);
        r8.registerContentObserver(Settings.Global.getUriFor(CloudConfigParseAndSave.SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_TPUT_KBPS), false, this.mConfigObserver);
        r8.registerContentObserver(Settings.Global.getUriFor(CloudConfigParseAndSave.SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_COOLDOWN_MS), false, this.mConfigObserver);
    }

    private void reportRecovery(TriggerSnapshot r11, int r12, int r13) {
        CaeWifiStatusCollect.getInstance().reportPoorLinkDisconnect(r11.triggerId, r11.bssid, r11.wifiBand, r11.rssi, r11.avgThroughputKbps, r13, r12, r11.foregroundPackage);     // Catch: Exception -> L5
        CaeLog.i(TAG, "report poor link disconnect pb event, triggerId=" + r11.triggerId + ", wifiBand=" + r11.wifiBand + ", rssi=" + r11.rssi + ", avgThroughput=" + r11.avgThroughputKbps + ", recovered=" + r13 + ", destination=" + r12 + ", foregroundApp=" + r11.foregroundPackage);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "report poor link disconnect event failed", e);
    }

    private void resetHitCount() {
        this.mHitCount = 0;
    }

    private void scheduleRecoveryReport(TriggerSnapshot r8) {
        if (this.mConnectivityManager != null) goto L6;
        reportRecovery(r8, 0, 0);
        return;
    L6:
        new RecoveryMonitor(this, r8).start();
    }

    private boolean shouldSkipDisconnectForNetworkHandover() {
        if (this.mNetworkHandoverEnabled == true) goto L12;
        return false;
    L12:
        boolean r8 = NetworkUtil.isCellDataEnabled(this.mContext);     // Catch: Exception -> L9
        if (r8 == false) goto L8;
        CaeLog.d(TAG, "cell data and network handover are enabled, skip poor link disconnect");     // Catch: Exception -> L9
    L8:
        return r8;
    L9:
        e = move-exception;
        android.aimedia.a.q("check cell data enabled failed: ", e, TAG);
        return false;
    }

    public void onThroughputChanged(int r8, int r10) {
        this.mLatestRxThroughputKbps = r8;
        this.mLatestTxThroughputKbps = r10;
        addThroughputSample(Math.min(r8, r10));
        evaluate();
    }

    public void onWifiConnectInfoChanged(Bundle r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.mLatestBssid = r8.getString(WiFiDBHelper.COL_BSSID);
        this.mLatestSsid = r8.getString("ssid");
        this.mLatestRssi = r8.getInt(WiFiDBHelper.COL_RSSI, Integer.MIN_VALUE);
        this.mLatestFrequency = r8.getInt("frequency", 0);
        this.mLatestWifiInfoTimestampMs = System.currentTimeMillis();
    }

    public void onWifiConnectStateChanged(int r8) {
        if (r8 != 0) goto L5;
        resetHitCount();
        this.mLatestRssi = Integer.MIN_VALUE;
        this.mLatestFrequency = 0;
        this.mLatestBssid = null;
        this.mLatestSsid = null;
        this.mLatestWifiInfoTimestampMs = 0;
        return;
    }

    public void release() {
        this.mContext.getContentResolver().unregisterContentObserver(this.mConfigObserver);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        CaeLog.e(TAG, "unregister config observer failed", e);
    }
}
