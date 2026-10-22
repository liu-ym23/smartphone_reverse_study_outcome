package com.obric.cae.userAware;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.obric.cae.location.cell.g;
import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes3.dex */
final class WifiConnectionScanController {
    private static final int CONNECTED_TRIGGERED_FENCE_COMPANY = 2;
    private static final int CONNECTED_TRIGGERED_FENCE_HOME = 1;
    private static final int CONNECTED_TRIGGERED_FENCE_NONE = 0;
    private static final int CONNECTION_SCAN_INTERVAL_MULTIPLIER = 2;
    static final long ENTER_ROOM_STOP_CONNECTED_SCAN_DELAY_MS = 5000;
    private static final long INVALID_DISCONNECT_TS = -1;
    private static final long RECENT_RSSI_FOR_DISCONNECT_MS = 3000;
    private static final int RSSI_VALID_MAX_EXCLUSIVE_DBM = 0;
    private static final int RSSI_VALID_MIN_DBM = -100;
    private static final long STRONG_SIGNAL_DISCONNECT_DEBOUNCE_MS = 3000;
    private static final int STRONG_SIGNAL_RSSI_DBM = -68;
    private static final String TAG = "WifiConnectionScanController";
    private int mConnectedTriggeredFenceKey;
    private int mConnectedTriggeredScanCountToday;
    private String mConnectedTriggeredScanDay;
    private ConcurrentWifiScanner.RequestHandle mConnectionTriggeredScanHandle;
    private String mCurrentConnectedBssid;
    private final Host mHost;
    private int mLastConnectedRssi;
    private long mLastConnectedRssiTs;
    private long mLastDisconnectTs;
    private boolean mPendingDisconnectedScan;
    private volatile int mPendingStopConnectedScanHandleId;
    private WifiScanConfigProvider mScanConfigProvider;
    private final Runnable mStartDisconnectedTriggeredScanRunnable;
    private final Runnable mStopConnectedTriggeredScanRunnable;

    public interface Host {
        Context getContext();

        int getCurrentGeofenceState();

        Handler getHandler();

        ConcurrentWifiScanner getScanner();

        WifiManager getWifiManager();

        boolean isOutsideFenceState();

        void resumeRssiTriggeredScanIfNeeded();

        ConcurrentWifiScanner.RequestHandle startHomeCompanyScan(int r1, long r2, long r4, boolean r6);
    }

    public WifiConnectionScanController(Host r4) {
        Host r5 = (Host) ZeusTransformUtils.wrapperContextForParams(r4, Host.class, "com.obric.memorydata.plugin");
        this.mCurrentConnectedBssid = null;
        this.mLastDisconnectTs = -1;
        this.mConnectedTriggeredScanDay = "";
        this.mConnectedTriggeredScanCountToday = 0;
        this.mConnectedTriggeredFenceKey = 0;
        this.mPendingStopConnectedScanHandleId = -1;
        this.mLastConnectedRssi = Integer.MIN_VALUE;
        this.mLastConnectedRssiTs = 0;
        this.mPendingDisconnectedScan = false;
        this.mHost = r5;
        this.mStopConnectedTriggeredScanRunnable = new $$Lambda$WifiConnectionScanController$tIr_3IuOpskFHvmtL4LMlMrgqEc(this);
        this.mStartDisconnectedTriggeredScanRunnable = new $$Lambda$WifiConnectionScanController$WDjHs6M1c1VkJTq_3MnfPejUo(this);
    }

    private boolean cancelPendingDisconnectedScan(String r4) {
        if (this.mPendingDisconnectedScan == true) goto L5;
        return false;
    L5:
        Handler r0 = this.mHost.getHandler();
        if (r0 == null) goto L8;
        r0.removeCallbacks(this.mStartDisconnectedTriggeredScanRunnable);
    L8:
        this.mPendingDisconnectedScan = false;
        a.e(TAG, "Cancel delayed disconnected-triggered scan: reason=" + r4);
        return true;
    }

    private static String formatDay(long r3) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Long.valueOf(r3));
    }

    private int getConnectedTriggeredFenceKey(int r1) {
        if (r1 != 1) goto L6;
        return 1;
    L6:
        if (r1 != 3) goto L9;
        return 2;
    L9:
        return 0;
    }

    private WifiScanConfigProvider getScanConfigProvider() {
        if (this.mScanConfigProvider != null) goto L6;
        this.mScanConfigProvider = WifiScanConfigProvider.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mHost.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L6:
        return this.mScanConfigProvider;
    }

    private static long multiplyInterval(long r2) {
        if (r2 > 0) goto L6;
        return r2;
    L6:
        if (r2 <= DurationKt.MAX_MILLIS) goto L10;
        return Long.MAX_VALUE;
    L10:
        return r2 * 2;
    }

    private void scheduleDisconnectedTriggeredScanAfterDebounce() {
        Handler r0 = this.mHost.getHandler();
        if (r0 != null) goto L6;
        a.g(TAG, "Cannot debounce disconnected scan: handler is null");
        startDisconnectedTriggeredScanNow();
        return;
    L6:
        r0.removeCallbacks(this.mStartDisconnectedTriggeredScanRunnable);
        this.mPendingDisconnectedScan = true;
        r0.postDelayed(this.mStartDisconnectedTriggeredScanRunnable, 3000);
        a.e(TAG, "Delay disconnected-triggered scan: debounceMs=3000, lastRssi=" + this.mLastConnectedRssi + ", rssiAgeMs=" + (System.currentTimeMillis() - this.mLastConnectedRssiTs));
    }

    private boolean shouldDebounceDisconnectedScan(long r4) {
        long r5 = r4 - this.mLastConnectedRssiTs;
        if (this.mLastConnectedRssi > STRONG_SIGNAL_RSSI_DBM) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == true) goto L12;
        a.c(TAG, "Disconnected scan debounce bypassed: lastRssi=" + this.mLastConnectedRssi + ", rssiAgeMs=" + r5);
    L12:
        return r0;
    L5:
        if (r5 < 0) goto L9;
        if (r5 > 3000) goto L9;
        r0 = true;
        goto L10
    }

    private void startConnectedTriggeredScan() {
        WifiManager r1 = this.mHost.getWifiManager();
        if (r1 != null) goto L7;
        String r0 = "startConnectionTriggeredScan: mWifiManager is null";
    L5:
        a.g(TAG, r0);
        return;
    L7:
        WifiInfo r2 = r1.getConnectionInfo();
        if (r2 != null) goto L10;
        r0 = "startConnectionTriggeredScan: wifiInfo is null";
        goto L5
    L10:
        this.mCurrentConnectedBssid = r2.getBSSID();
        if (cancelPendingDisconnectedScan("quick reconnect within disconnect debounce") == false) goto L13;
        return;
    L13:
        WifiScanConfigProvider.ActiveConfigSnapshot r3 = getScanConfigProvider().getActiveConfigSnapshot();
        long r4 = r3.getConnectedReconnectWindowMs();
        long r5 = SystemClock.elapsedRealtime();
        long r7 = this.mLastDisconnectTs;
        if (r7 != (-1)) goto L16;
    L20:
        boolean r6 = false;
    L21:
        if (r6 == false) goto L24;
        stopDisconnectedScanAfterQuickReconnect();
        return;
    L24:
        int r8 = getConnectedTriggeredFenceKey(this.mHost.getCurrentGeofenceState());
        String r9 = formatDay(System.currentTimeMillis());
        if (TextUtils.equals(r9, this.mConnectedTriggeredScanDay) == true) goto L28;
        this.mConnectedTriggeredScanDay = r9;
        this.mConnectedTriggeredScanCountToday = 0;
        this.mConnectedTriggeredFenceKey = r8;
    L28:
        if (this.mConnectedTriggeredFenceKey == r8) goto L30;
        this.mConnectedTriggeredFenceKey = r8;
        this.mConnectedTriggeredScanCountToday = 0;
    L30:
        int r10 = r3.getConnectedDailyFullScanLimit();
        if (r8 == 0) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == true) goto L36;
    L38:
        boolean r12 = false;
    L39:
        long r13 = multiplyInterval(r3.getEffectiveIntervalMs(5));
        long r14 = r3.getConnectedOnceScanDurationMs();
        long r16 = r3.getHomeCompanyScanDurationMs(5, true);
        long r18 = r3.getHomeCompanyScanDurationMs(5, false);
        if (r8 != 1) goto L43;
    L45:
        if (r12 == false) goto L47;
        long r15 = r14;
    L48:
        boolean r20 = r3.shouldIgnoreMovementGate(5, r12);
        a.c(TAG, "Start triggered scan(connected): interval=" + r13 + "ms, duration=" + r15 + "ms, onlyOnce=" + r12 + ", fenceKey=" + r8 + ", todayCount=" + this.mConnectedTriggeredScanCountToday);
        this.mConnectionTriggeredScanHandle = this.mHost.startHomeCompanyScan(5, r13, r15, r20);
        StringBuilder r17 = new StringBuilder("Connected-triggered scan request ");
        if (this.mConnectionTriggeredScanHandle != null) goto L51;
        String r19 = "rejected";
    L52:
        a.e(TAG, r17.append(r19).append(", fenceKey=").append(r8).append(", sceneId=5").toString());
        if (this.mConnectionTriggeredScanHandle == null) goto L56;
        if (r11 == false) goto L56;
        this.mConnectedTriggeredScanCountToday++;
    L56:
        this.mLastDisconnectTs = -1;
        return;
    L51:
        r19 = "accepted: handleId=" + this.mConnectionTriggeredScanHandle.getId();
        goto L52
    L47:
        r15 = r16;
        goto L48
    L43:
        if (r8 != 2) goto L45;
        r16 = r18;
        goto L45
    L36:
        if (this.mConnectedTriggeredScanCountToday < r10) goto L38;
        r12 = true;
        goto L39
    L33:
        r11 = false;
        goto L34
    L16:
        if (r5 < r7) goto L20;
        if ((r5 - r7) > r4) goto L20;
        r6 = true;
        goto L21
    }

    private void startConnectionTriggeredScan(int r3) {
        if (this.mHost.getScanner() != null) goto L7;
        a.i(TAG, "startConnectionTriggeredScan: scanner is null");
        return;
    L7:
        if (this.mHost.isOutsideFenceState() == false) goto L10;
        a.e(TAG, "startConnectionTriggeredScan: skip in OutsideFenceState");
        return;
    L10:
        if (r3 != 0) goto L12;
        startDisconnectedTriggeredScan();
        return;
    L12:
        startConnectedTriggeredScan();
    }

    private void startDisconnectedTriggeredScan() {
        if (shouldDebounceDisconnectedScan(System.currentTimeMillis()) == false) goto L6;
        scheduleDisconnectedTriggeredScanAfterDebounce();
        this.mCurrentConnectedBssid = null;
        return;
    L6:
        startDisconnectedTriggeredScanNow();
    }

    private void startDisconnectedTriggeredScanNow() {
        if (this.mHost.getScanner() != null) goto L7;
        a.i(TAG, "startDisconnectedTriggeredScanNow: scanner is null");
        return;
    L7:
        if (this.mHost.isOutsideFenceState() == false) goto L10;
        a.e(TAG, "startDisconnectedTriggeredScanNow: skip in OutsideFenceState");
        return;
    L10:
        WifiScanConfigProvider.ActiveConfigSnapshot r0 = getScanConfigProvider().getActiveConfigSnapshot();
        long r7 = multiplyInterval(r0.getEffectiveIntervalMs(4));
        int r3 = this.mHost.getCurrentGeofenceState();
        if (r3 != 1) goto L13;
        boolean r5 = true;
    L14:
        long r9 = r0.getHomeCompanyScanDurationMs(4, r5);
        boolean r11 = r0.shouldIgnoreMovementGate(4, true);
        a.c(TAG, "Start triggered scan(disconnected): interval=" + r7 + "ms, duration=" + r9 + "ms, geofenceState=" + r3);
        this.mConnectionTriggeredScanHandle = this.mHost.startHomeCompanyScan(4, r7, r9, r11);
        this.mCurrentConnectedBssid = null;
        return;
    L13:
        r5 = false;
        goto L14
    }

    private void stopDisconnectedScanAfterQuickReconnect() {
        a.e(TAG, "startConnectionTriggeredScan: avoid roming and swithc network to scan");
        ConcurrentWifiScanner r0 = this.mHost.getScanner();
        if (r0 == null) goto L7;
        ConcurrentWifiScanner.RequestHandle r1 = this.mConnectionTriggeredScanHandle;
        if (r1 == null) goto L7;
        boolean r2 = r0.stopScan(r1);
        this.mConnectionTriggeredScanHandle = null;
    L8:
        if (r2 == false) goto L11;
        this.mHost.resumeRssiTriggeredScanIfNeeded();
        return;
    L11:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public synchronized void cleanup() {
        monitor-enter(this);
        Handler r0 = this.mHost.getHandler();     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.mStopConnectedTriggeredScanRunnable);     // Catch: Throwable -> L9
        r0.removeCallbacks(this.mStartDisconnectedTriggeredScanRunnable);     // Catch: Throwable -> L9
    L6:
        this.mPendingStopConnectedScanHandleId = -1;     // Catch: Throwable -> L9
        this.mPendingDisconnectedScan = false;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized String getCurrentConnectedBssid() {
        monitor-enter(this);
        String r0 = this.mCurrentConnectedBssid;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void handleWifiConnectionStateChanged(int r3, int r4) {
        monitor-enter(this);
        if (r4 != 1) goto L8;
    L5:
        startConnectionTriggeredScan(r4);     // Catch: Throwable -> L6
    L15:
        monitor-exit(this);
        return;
    L8:
        if (r4 != 0) goto L15;
        if (r3 != 1) goto L11;
        this.mLastDisconnectTs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6
        goto L5
    L11:
        a.e(TAG, "Skip disconnected-triggered scan: previousState=" + r3 + ", currentState=" + r4);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public /* synthetic */ void lambda$new$0$WifiConnectionScanController() {
        monitor-enter(this);
        int r2 = this.mPendingStopConnectedScanHandleId;     // Catch: Throwable -> L22
        this.mPendingStopConnectedScanHandleId = -1;     // Catch: Throwable -> L22
        if (r2 > 0) goto L26;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L26:
        ConcurrentWifiScanner r3 = this.mHost.getScanner();     // Catch: Throwable -> L18
        if (r3 != null) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L12:
        ConcurrentWifiScanner.RequestHandle r4 = this.mConnectionTriggeredScanHandle;     // Catch: Throwable -> L18
        if (r4 != null) goto L15;
    L20:
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L15:
        if (r4.getId() != r2) goto L20;
        a.e(TAG, "Stop connected-triggered scan after enter-room delay, handleId=" + r2);     // Catch: Throwable -> L18
        r3.stopScan(r4);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        a.g(TAG, "Stop connected-triggered scan failed: " + th.getMessage());     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public /* synthetic */ void lambda$new$1$WifiConnectionScanController() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mPendingDisconnectedScan == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        this.mPendingDisconnectedScan = false;     // Catch: Throwable -> L10
        a.e(TAG, "Start delayed disconnected-triggered scan after debounce");     // Catch: Throwable -> L10
        startDisconnectedTriggeredScanNow();     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    public synchronized void resetConnectedScanCounterOnFenceExit() {
        monitor-enter(this);
        cancelPendingDisconnectedScan("fence exit");     // Catch: Throwable -> L6
        this.mConnectedTriggeredFenceKey = 0;     // Catch: Throwable -> L6
        this.mConnectedTriggeredScanCountToday = 0;     // Catch: Throwable -> L6
        a.e(TAG, "Reset connected-triggered scan counter on fence exit: day=" + this.mConnectedTriggeredScanDay);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void scheduleStopConnectedScanAfterEnterRoom() {
        monitor-enter(this);
        Handler r0 = this.mHost.getHandler();     // Catch: Throwable -> L24
        if (r0 != null) goto L6;
    L22:
        monitor-exit(this);
        return;
    L6:
        if (this.mHost.getScanner() == null) goto L22;
        ConcurrentWifiScanner.RequestHandle r1 = this.mConnectionTriggeredScanHandle;     // Catch: Throwable -> L24
        if (r1 == null) goto L22;
        if (r1.isScene(5) == false) goto L22;
        long r2 = 5000;
        long r3 = getScanConfigProvider().getActiveConfigSnapshot().getEnterHomeRoomStopConnectedScanDelayMs();     // Catch: Throwable -> L17
    L15:
        if (r3 <= 0) goto L19;
        r2 = r3;
    L19:
        this.mPendingStopConnectedScanHandleId = this.mConnectionTriggeredScanHandle.getId();     // Catch: Throwable -> L24
        r0.removeCallbacks(this.mStopConnectedTriggeredScanRunnable);     // Catch: Throwable -> L24
        r0.postDelayed(this.mStopConnectedTriggeredScanRunnable, r2);     // Catch: Throwable -> L24
        g.a(new StringBuilder("Schedule stop connected-triggered scan in ").append(r2).append("ms, handleId="), this.mPendingStopConnectedScanHandleId, TAG);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        a.g(TAG, "scheduleStopConnectedScanAfterEnterRoom: read spec failed, fallback to default: " + th.getMessage());     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public synchronized void startForCurrentConnectionState(int r2) {
        monitor-enter(this);
        if (r2 == 1) goto L12;
        if (r2 == 0) goto L12;
    L7:
        monitor-exit(this);
        return;
    L12:
        startConnectionTriggeredScan(r2);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void updateLastConnectedRssi(int r2, long r3) {
        monitor-enter(this);
        if (r2 <= (-100)) goto L10;
        if (r2 >= 0) goto L10;
        this.mLastConnectedRssi = r2;     // Catch: Throwable -> L13
        this.mLastConnectedRssiTs = r3;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L10:
        a.c(TAG, "Skip updating last connected RSSI: invalid value");     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
