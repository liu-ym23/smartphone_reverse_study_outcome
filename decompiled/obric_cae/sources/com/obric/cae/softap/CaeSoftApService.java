package com.obric.cae.softap;

import android.content.Context;
import android.net.TetheringManager;
import android.net.wifi.SoftApConfiguration;
import android.net.wifi.SoftApInfo;
import android.net.wifi.WifiAvailableChannel;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.activity.k;
import androidx.room.m;
import com.obric.cae.libs.softap.CaeSoftApConfig;
import com.obric.cae.libs.softap.CaeSoftApStatus;
import com.obric.cae.libs.softap.ICaeSoftApCallback;
import com.obric.cae.libs.softap.ICaeSoftApManager;
import com.obric.cae.location.geosdk.bytedance.BdLocationManager;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class CaeSoftApService extends ICaeSoftApManager.Stub {
    private static final int CAC_SECONDS = 60;
    private static final int MAX_ALLOWED_CHANNEL = 60;
    private static final int MIN_ALLOWED_CHANNEL = 36;
    private static final Set<Integer> REQUIRED_CN_160_FREQS = null;
    private static final String SOFTAP_ACCESS_PERMISSION = "com.obric.cae.permission.CAE_SOFTAP_ACCESS";
    private static final long SOFTAP_CAPABILITY_160MHZ = 2;
    private static final long SOFTAP_CAPABILITY_BASIC = 1;
    private static final long SOFTAP_CAPABILITY_BITS = 511;
    private static final long SOFTAP_CAPABILITY_HIDDEN_SSID = 128;
    private static final long SOFTAP_CAPABILITY_METERED = 256;
    private static final long SOFTAP_CAPABILITY_SECURITY_OPEN = 8;
    private static final long SOFTAP_CAPABILITY_SECURITY_WPA2_PSK = 16;
    private static final long SOFTAP_CAPABILITY_SECURITY_WPA2_WPA3_TRANSITION = 64;
    private static final long SOFTAP_CAPABILITY_SECURITY_WPA3_SAE = 32;
    private static final long SOFTAP_CAPABILITY_TX_POWER_CONTROL = 4;
    private static final int SOFTAP_INTERFACE_VERSION = 1;
    private static final String SOFTAP_RADAR_SYSFS_PATH = "/sys/class/net/wlan2/radar";
    private static final int SOFTAP_TX_POWER_DBM_160 = 16;
    private static final String TAG = "CaeSoftApService";
    private static final long WIFI_DISABLE_POLL_MS = 200;
    private static final long WIFI_DISABLE_TIMEOUT_MS = 10000;
    private long mCacEndElapsedMs;
    private Runnable mCacTicker;
    private final Executor mCallbackExecutor;
    private final RemoteCallbackList<ICaeSoftApCallback> mCallbacks;
    private final Context mContext;
    private String mCurrentSoftApIfName;
    private boolean mExpectCac;
    private boolean mFallbackTo80Active;
    private final Handler mHandler;
    private final HostapdCtrlMonitor mHostapdMonitor;
    private CaeSoftApConfig mLastStartConfig;
    private String mLastStartCountryCode;
    private final Object mLock;
    private final NefidInterface mNefidInterface;
    private final WifiManager.SoftApCallback mSoftApCallback;
    private boolean mSoftApCallbackRegistered;
    private CaeSoftApStatus mStatus;
    private final TetheringManager mTetheringManager;
    private final HandlerThread mThread;
    private String mTxPowerAppliedIfName;
    private boolean mTxPowerCapApplied;
    private final WifiManager mWifiManager;

    static {
        REQUIRED_CN_160_FREQS = new HashSet(Arrays.asList(new Integer[]{5180, 5200, 5220, 5240, 5260, 5280, 5300, 5320}));
    }

    public CaeSoftApService(Context r8) {
        this.mCallbacks = new RemoteCallbackList();
        HandlerThread r10 = new HandlerThread("CaeSoftAp");
        this.mThread = r10;
        this.mLock = new Object();
        this.mHostapdMonitor = new HostapdCtrlMonitor();
        this.mSoftApCallbackRegistered = false;
        this.mStatus = new CaeSoftApStatus();
        this.mCacEndElapsedMs = 0;
        this.mExpectCac = false;
        this.mTxPowerCapApplied = false;
        this.mTxPowerAppliedIfName = "";
        this.mCurrentSoftApIfName = "";
        this.mLastStartCountryCode = "";
        this.mFallbackTo80Active = false;
        this.mSoftApCallback = new AnonymousClass1(this);
        Context r11 = r8.getApplicationContext();
        this.mContext = r11;
        this.mWifiManager = (WifiManager) r11.getSystemService("wifi");
        this.mTetheringManager = (TetheringManager) r11.getSystemService(TetheringManager.class);
        this.mNefidInterface = NefidInterface.getInstance(r11);
        r10.start();
        this.mHandler = new Handler(r10.getLooper());
        this.mCallbackExecutor = new b(this);
        setStateLocked(0, 0, null);
        registerSoftApCallbackIfNeeded();
    }

    public static /* synthetic */ void H2(CaeSoftApService r8, SoftApConfiguration r10) {
        r8.lambda$restartSoftApAs80DueToRadar$3(r10);
    }

    public static /* synthetic */ void I2(CaeSoftApService r8) {
        r8.stopSoftApInternal();
    }

    public static /* synthetic */ void J2(CaeSoftApService r8, CaeSoftApConfig r10, String r11) {
        r8.lambda$startSoftAp$1(r10, r11);
    }

    public static /* synthetic */ void K2(CaeSoftApService r8, SoftApConfiguration r10, boolean r11, long r12) {
        r8.lambda$waitForWifiDisabledThenStart$2(r10, r11, r12);
    }

    public static /* synthetic */ void L2(CaeSoftApService r8, Runnable r10) {
        r8.lambda$new$0(r10);
    }

    public static /* synthetic */ void access$000(CaeSoftApService r8, int r10, int r11) {
        r8.handleFrameworkStateChanged(r10, r11);
    }

    public static /* synthetic */ void access$100(CaeSoftApService r8, SoftApInfo r10) {
        r8.handleFrameworkInfoChanged(r10);
    }

    public static /* synthetic */ void access$1000(CaeSoftApService r8, int r10, int r11, String r12) {
        r8.setStateLocked(r10, r11, r12);
    }

    public static /* synthetic */ void access$1100(CaeSoftApService r8, SoftApInfo r10) {
        r8.syncSoftApTxPowerLocked(r10);
    }

    public static /* synthetic */ void access$200(CaeSoftApService r8, String r10) {
        r8.handleHostapdEvent(r10);
    }

    public static /* synthetic */ Object access$300(CaeSoftApService r8) {
        return r8.mLock;
    }

    public static /* synthetic */ void access$400(CaeSoftApService r8) {
        r8.cancelCacTickerLocked();
    }

    public static /* synthetic */ void access$500(CaeSoftApService r8, int r10, String r11) {
        r8.failAsync(r10, r11);
    }

    public static /* synthetic */ CaeSoftApStatus access$600(CaeSoftApService r8) {
        return r8.mStatus;
    }

    public static /* synthetic */ void access$700(CaeSoftApService r8) {
        r8.notifyStatusLocked();
    }

    public static /* synthetic */ Handler access$800(CaeSoftApService r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ boolean access$902(CaeSoftApService r8, boolean r10) {
        r8.mExpectCac = r10;
        return r10;
    }

    private static int bandwidthToMhz(int r8) {
        if (r8 == 11) goto L15;
        switch(r8) {
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L7;
            default: goto L5;
        };
    L5:
        return 0;
    L7:
        return 160;
    L9:
        return 80;
    L11:
        return 40;
    L13:
        return 20;
    L15:
        return 320;
    }

    private SoftApConfiguration buildSoftApConfiguration(CaeSoftApConfig r8, String r10, int r11) {
        SoftApConfiguration.Builder r12 = new SoftApConfiguration.Builder();
        r12.setSsid(r8.ssid);
        r12.setHiddenSsid(r8.hidden);
        r12.setBand(2);
        r12.setBands(new int[]{2});
        r12.setChannel(r8.channel, 2);
        int r13 = r8.securityType;
        if (r13 != 0) goto L6;
        r12.setPassphrase(null, 0);
    L11:
        setMeteredReflect(r12, r8.metered);
        if (r11 != 160) goto L14;
        int r14 = 6;
    L15:
        setMaxChannelBandwidthReflect(r12, r14);
        setIeee80211axEnabledReflect(r12, true);
        setIeee80211beEnabledReflect(r12, false);
        setCountryCodeReflect(r12, r10);
        setUserConfigurationReflect(r12, true);
        return r12.build();
    L14:
        r14 = 4;
        goto L15
    L6:
        if (r13 != 2) goto L8;
        r12.setPassphrase(r8.passphrase, 3);
        goto L11
    L8:
        if (r13 != 3) goto L10;
        r12.setPassphrase(r8.passphrase, 2);
        goto L11
    L10:
        r12.setPassphrase(r8.passphrase, 1);
        goto L11
    }

    private void cancelCacTickerLocked() {
        cancelCacTickerLocked(true);
    }

    private void clearTxPowerCapTrackingLocked() {
        this.mTxPowerCapApplied = false;
        this.mTxPowerAppliedIfName = "";
        this.mCurrentSoftApIfName = "";
    }

    private void continueStartSoftApAfterWifiDisabled(SoftApConfiguration r8, boolean r10) {
        this.mHostapdMonitor.start(this.mHandler, new AnonymousClass2(this));
        Object r11 = this.mLock;
        monitor-enter(r11);
        if (r10 == false) goto L7;
        enterCacLocked("assumed");     // Catch: Throwable -> L60
    L8:
        monitor-exit(r11);     // Catch: Throwable -> L60
        logTetheringStartPrereqs(r8);
        if (this.mTetheringManager != null) goto L73;
        Object r12 = this.mLock;
        monitor-enter(r12);
        cancelCacTickerLocked();     // Catch: Throwable -> L17
        monitor-exit(r12);     // Catch: Throwable -> L17
        failAsync(-7, "TetheringManager null");
        return;
    L17:
        th = move-exception;
        throw th;
    L73:
        WifiManager r13 = this.mWifiManager;     // Catch: Throwable -> L40 SecurityException -> L50
        if (r13 != null) goto L24;
    L26:
        boolean r14 = false;
    L27:
        CaeLog.i(TAG, "setSoftApConfiguration result=" + r14);     // Catch: Throwable -> L40 SecurityException -> L50
        if (r14 == true) goto L38;
        Object r15 = this.mLock;     // Catch: Throwable -> L40 SecurityException -> L50
        monitor-enter(r15);     // Catch: Throwable -> L40 SecurityException -> L50
        cancelCacTickerLocked();     // Catch: Throwable -> L35
        monitor-exit(r15);     // Catch: Throwable -> L35
        failAsync(-4, "setSoftApConfiguration failed");     // Catch: Throwable -> L40 SecurityException -> L50
        return;
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40 SecurityException -> L50
    L38:
        this.mTetheringManager.startTethering(new TetheringManager.TetheringRequest.Builder(0).setShouldShowEntitlementUi(false).setExemptFromEntitlementCheck(true).build(), this.mCallbackExecutor, new AnonymousClass3(this));     // Catch: Throwable -> L40 SecurityException -> L50
        return;
    L24:
        if (r13.setSoftApConfiguration(r8) == false) goto L26;
        r14 = true;
    L50:
        e = move-exception;
        monitor-enter(this.mLock);
        cancelCacTickerLocked();     // Catch: Throwable -> L57
        failAsync(-1, "startTethering denied: " + e);
        return;
    L57:
        th = move-exception;
        throw th;
    L40:
        th = move-exception;
        monitor-enter(this.mLock);
        cancelCacTickerLocked();     // Catch: Throwable -> L47
        failAsync(-4, "startTethering error: " + th);
        return;
    L47:
        th = move-exception;
        throw th;
    L7:
        cancelCacTickerLocked();     // Catch: Throwable -> L60
        this.mStatus.remainingCacSeconds = 0;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        throw th;
    }

    private static CaeSoftApConfig copyConfig(CaeSoftApConfig r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        CaeSoftApConfig r10 = new CaeSoftApConfig();
        r10.ssid = r8.ssid;
        r10.passphrase = r8.passphrase;
        r10.securityType = r8.securityType;
        r10.wifiStandard = r8.wifiStandard;
        r10.hidden = r8.hidden;
        r10.metered = r8.metered;
        r10.enable160Mhz = r8.enable160Mhz;
        r10.channel = r8.channel;
        return r10;
    }

    private void enforceCallerAllowed() {
        this.mContext.enforceCallingOrSelfPermission(SOFTAP_ACCESS_PERMISSION, "Caller must hold com.obric.cae.permission.CAE_SOFTAP_ACCESS");
    }

    private void ensureWifiDisabledThenStart(SoftApConfiguration r8, boolean r10) {
        WifiManager r11 = this.mWifiManager;
        if (r11 == null) goto L5;
        int r12 = r11.getWifiState();
    L6:
        boolean r13 = true;
        if (r12 != 1) goto L10;
        CaeLog.i(TAG, "Wi-Fi already disabled before 160MHz SoftAP start");
        continueStartSoftApAfterWifiDisabled(r8, r10);
        return;
    L10:
        if (r12 != 0) goto L24;
        String r14 = "Wi-Fi is disabling, wait before SoftAP start";
    L22:
        CaeLog.i(TAG, r14);
        waitForWifiDisabledThenStart(r8, r10, SystemClock.elapsedRealtime() + 10000);
        return;
    L24:
        WifiManager r15 = this.mWifiManager;     // Catch: Throwable -> L18
        if (r15 == null) goto L16;
        if (r15.setWifiEnabled(false) == false) goto L16;
    L17:
        r14 = "disable Wi-Fi before SoftAP: issued=" + r13 + " state=" + r12;
    L16:
        r13 = false;
    L18:
        th = move-exception;
        failAsync(-4, "disable Wi-Fi failed: " + th);
        return;
    L5:
        r12 = 4;
        goto L6
    }

    private void enterCacLocked(String r8) {
        CaeSoftApStatus r10 = this.mStatus;
        int r11 = r10.state;
        if (r11 != 3) goto L5;
        return;
    L5:
        if (r11 != 5) goto L7;
        return;
    L7:
        if (r11 == 4) goto L13;
        this.mExpectCac = true;
        r10.remainingCacSeconds = 60;
        this.mCacEndElapsedMs = SystemClock.elapsedRealtime() + 60000;
        StringBuilder r12 = defpackage.b.h("enterCacLocked: reason=", r8, " cacEndElapsedMs=");
        r12.append(this.mCacEndElapsedMs);
        CaeLog.i(TAG, r12.toString());
        setStateLocked(2, 0, "CAC: " + r8);
        startCacTickerLocked();
        return;
    }

    private void failAsync(int r8, String r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        setStateLocked(5, r8, r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private int failNow(int r8, String r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        setStateLocked(5, r8, r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        return r8;
    L8:
        th = move-exception;
        throw th;
    }

    private static int frequencyToChannel(int r8) {
        if (r8 < 2412) goto L13;
        if (r8 > 2484) goto L13;
        if (r8 != 2484) goto L9;
        return 14;
    L9:
        int r10 = r8 - 2407;
    L11:
        return r10 / 5;
    L13:
        if (r8 < 5000) goto L18;
        if (r8 > 5895) goto L18;
        r10 = r8 - 5000;
    L18:
        if (r8 >= 5955) goto L20;
        return 0;
    L20:
        if (r8 > 7115) goto L24;
        r10 = r8 - 5950;
        goto L11
    L24:
        return 0;
    }

    private String get160To80FallbackReason() {
        String r8 = getRadarSysfsIssue();
        if (r8 == null) goto L6;
        return r8;
    L6:
        return getCn160DfsBlockIssue();
    }

    private String getCn160DfsBlockIssue() {
        WifiManager r8 = this.mWifiManager;
        if (r8 != null) goto L24;
        return "WifiManager null";
    L24:
        List<WifiAvailableChannel> r10 = r8.getAllowedChannels(6, 2);     // Catch: Throwable -> L16 UnsupportedOperationException -> L20 SecurityException -> L22
        HashSet r11 = new HashSet();     // Catch: Throwable -> L16 UnsupportedOperationException -> L20 SecurityException -> L22
        Iterator<WifiAvailableChannel> r12 = r10.iterator();     // Catch: Throwable -> L16 UnsupportedOperationException -> L20 SecurityException -> L22
    L9:
        if (r12.hasNext() == false) goto L11;
        r11.add(Integer.valueOf(r12.next().getFrequencyMhz()));     // Catch: Throwable -> L16 UnsupportedOperationException -> L20 SecurityException -> L22
        goto L9
    L11:
        Set<Integer> r13 = REQUIRED_CN_160_FREQS;     // Catch: Throwable -> L16 UnsupportedOperationException -> L20 SecurityException -> L22
        if (r11.containsAll(r13) == false) goto L14;
        return null;
    L14:
        return "DFS 160MHz block unavailable for ch36-64: allowed5gSapFreqs=" + r11 + ", required=" + r13 + ", likely radar non-occupancy in effect";
    L22:
        e = e;
        StringBuilder r14 = new StringBuilder("getAllowedChannels denied: ");
    L18:
        r14.append(e);
        CaeLog.w(TAG, r14.toString());
        return null;
    L20:
        e = e;
        r14 = new StringBuilder("getAllowedChannels unsupported: ");
    L16:
        e = th;
        r14 = new StringBuilder("getAllowedChannels failed: ");
        goto L18
    }

    private String getRadarSysfsIssue() {
        File r8 = new File(SOFTAP_RADAR_SYSFS_PATH);
        if (r8.exists() == true) goto L32;
        return null;
    L32:
        BufferedReader r10 = new BufferedReader(new FileReader(r8));     // Catch: Throwable -> L25
        String r11 = r10.readLine();     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r11) == false) goto L10;
        r10.close();     // Catch: Throwable -> L25
        return null;
    L10:
        String r12 = r11.trim();     // Catch: Throwable -> L19
        if ("0".equals(r12) == false) goto L13;
    L17:
        r10.close();     // Catch: Throwable -> L25
        return null;
    L13:
        if ("false".equalsIgnoreCase(r12) == true) goto L17;
        String r13 = "radar sysfs asserted: /sys/class/net/wlan2/radar=" + r12;     // Catch: Throwable -> L19
        r10.close();     // Catch: Throwable -> L25
        return r13;
    L19:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Throwable -> L25
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CaeLog.w(TAG, "read radar sysfs failed: " + th);
        return null;
    }

    private static String getSoftApInterfaceName(SoftApInfo r8) {
        if (r8 != null) goto L13;
        return "";
    L13:
        String r10 = r8.getApInstanceIdentifier();     // Catch: Throwable -> L10
        if (r10 != null) goto L9;
        return "";
    L9:
        return r10;
    L10:
        th = move-exception;
        CaeLog.w(TAG, "getApInstanceIdentifier failed: " + th);
        return "";
    }

    private String getWifiCountryCodeSafe() {
        WifiManager r8 = this.mWifiManager;     // Catch: Throwable -> L8 SecurityException -> L12
        if (r8 != null) goto L6;
        return null;
    L6:
        return r8.getCountryCode();
    L12:
        e = e;
        StringBuilder r10 = new StringBuilder("getCountryCode denied: ");
    L10:
        r10.append(e);
        CaeLog.w(TAG, r10.toString());
        return null;
    L8:
        e = th;
        r10 = new StringBuilder("getCountryCode error: ");
        goto L10
    }

    private void handleFrameworkInfoChanged(SoftApInfo r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        CaeSoftApStatus r11 = this.mStatus;     // Catch: Throwable -> L29
        r11.frequencyMhz = r8.getFrequency();     // Catch: Throwable -> L29
        CaeSoftApStatus r12 = this.mStatus;     // Catch: Throwable -> L29
        r12.bandwidthMhz = bandwidthToMhz(r8.getBandwidth());     // Catch: Throwable -> L29
        int r13 = frequencyToChannel(r8.getFrequency());     // Catch: Throwable -> L29
        if (r13 <= 0) goto L7;
        this.mStatus.channel = r13;     // Catch: Throwable -> L29
    L7:
        syncSoftApTxPowerLocked(r8);     // Catch: Throwable -> L29
        if (this.mExpectCac == false) goto L15;
        if (requiresAssumedCac(r8) == true) goto L15;
        cancelCacTickerLocked();     // Catch: Throwable -> L29
        this.mStatus.remainingCacSeconds = 0;     // Catch: Throwable -> L29
        setStateLocked(3, 0, "framework: running without CAC");     // Catch: Throwable -> L29
        syncSoftApTxPowerLocked(r8);     // Catch: Throwable -> L29
        monitor-exit(r10);     // Catch: Throwable -> L29
        return;
    L15:
        if (this.mStatus.remainingCacSeconds <= 0) goto L17;
    L26:
        setStateLocked(2, 0, "CAC: in progress");     // Catch: Throwable -> L29
        monitor-exit(r10);     // Catch: Throwable -> L29
        return;
    L17:
        if (this.mExpectCac == true) goto L19;
    L23:
        notifyStatusLocked();     // Catch: Throwable -> L29
        monitor-exit(r10);     // Catch: Throwable -> L29
        return;
    L19:
        if (SystemClock.elapsedRealtime() >= this.mCacEndElapsedMs) goto L23;
        if (this.mStatus.state == 2) goto L23;
    L29:
        th = move-exception;
        throw th;
    }

    private void handleFrameworkStateChanged(int r8, int r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        switch(r8) {
            case 10: goto L34;
            case 11: goto L31;
            case 12: goto L27;
            case 13: goto L11;
            case 14: goto L7;
            default: goto L39;
        };
    L7:
        maybeReleaseSoftApTxPowerLocked("framework: failed", true);     // Catch: Throwable -> L37
        cancelCacTickerLocked();     // Catch: Throwable -> L37
        this.mStatus.remainingCacSeconds = 0;     // Catch: Throwable -> L37
        setStateLocked(5, mapSapFailureToErr(r10), "framework: failed reason=" + r10);     // Catch: Throwable -> L37
        monitor-exit(r11);     // Catch: Throwable -> L37
        return;
    L31:
        maybeReleaseSoftApTxPowerLocked("framework: disabled", true);     // Catch: Throwable -> L37
        cancelCacTickerLocked();     // Catch: Throwable -> L37
        this.mStatus.remainingCacSeconds = 0;     // Catch: Throwable -> L37
        setStateLocked(0, 0, "framework: disabled");     // Catch: Throwable -> L37
        monitor-exit(r11);     // Catch: Throwable -> L37
        return;
    L34:
        cancelCacTickerLocked();     // Catch: Throwable -> L37
        this.mStatus.remainingCacSeconds = 0;     // Catch: Throwable -> L37
        setStateLocked(4, 0, "framework: disabling");     // Catch: Throwable -> L37
        monitor-exit(r11);     // Catch: Throwable -> L37
        return;
    L39:
        CaeLog.w(TAG, "Unknown SoftAp state: " + r8 + ", fail=" + r10);     // Catch: Throwable -> L37
        monitor-exit(r11);     // Catch: Throwable -> L37
        return;
    L11:
        if (this.mStatus.remainingCacSeconds > 0) goto L21;
        if (this.mExpectCac == true) goto L15;
    L17:
        setStateLocked(3, 0, "framework: enabled");     // Catch: Throwable -> L37
        syncSoftApTxPowerLocked(null);     // Catch: Throwable -> L37
        monitor-exit(r11);     // Catch: Throwable -> L37
        return;
    L15:
        if (SystemClock.elapsedRealtime() >= this.mCacEndElapsedMs) goto L17;
    L21:
        if (this.mStatus.state == 2) goto L23;
        setStateLocked(2, 0, "CAC: in progress");     // Catch: Throwable -> L37
    L24:
        monitor-exit(r11);     // Catch: Throwable -> L37
        return;
    L23:
        notifyStatusLocked();     // Catch: Throwable -> L37
        goto L24
    L27:
        if (this.mStatus.state == 2) goto L29;
        setStateLocked(1, 0, "framework: enabling");     // Catch: Throwable -> L37
    L29:
        monitor-exit(r11);     // Catch: Throwable -> L37
        return;
    L37:
        th = move-exception;
        throw th;
    }

    private void handleHostapdEvent(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        CaeLog.i(TAG, "hostapd-event: " + r8);
        if (r8.startsWith("DFS-CAC-START") == false) goto L16;
        Object r10 = this.mLock;
        monitor-enter(r10);
        enterCacLocked("DFS-CAC-START");     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        if (r8.startsWith("DFS-CAC-COMPLETED") == false) goto L28;
        Object r11 = this.mLock;
        monitor-enter(r11);
        CaeSoftApStatus r12 = this.mStatus;     // Catch: Throwable -> L24
        if (r12.state != 2) goto L22;
        r12.remainingCacSeconds = 0;     // Catch: Throwable -> L24
        notifyStatusLocked();     // Catch: Throwable -> L24
    L22:
        monitor-exit(r11);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    L28:
        if (r8.startsWith("DFS-RADAR-DETECTED") == false) goto L35;
        if (restartSoftApAs80DueToRadar("DFS-RADAR-DETECTED") == false) goto L32;
        return;
    L32:
        failAsync(-5, "DFS-RADAR-DETECTED");
        this.mHandler.post(new k(this, 23));
        return;
    L35:
        if (r8.startsWith("AP-ENABLED") == false) goto L37;
    L54:
        Object r13 = this.mLock;
        monitor-enter(r13);
        cancelCacTickerLocked();     // Catch: Throwable -> L59
        this.mStatus.remainingCacSeconds = 0;     // Catch: Throwable -> L59
        setStateLocked(3, 0, null);     // Catch: Throwable -> L59
        syncSoftApTxPowerLocked(null);     // Catch: Throwable -> L59
        monitor-exit(r13);     // Catch: Throwable -> L59
        return;
    L59:
        th = move-exception;
        throw th;
    L37:
        if (r8.startsWith("INTERFACE-ENABLED") == true) goto L54;
        if (r8.startsWith("AP-DISABLED") == false) goto L42;
    L43:
        Object r14 = this.mLock;
        monitor-enter(r14);
        cancelCacTickerLocked();     // Catch: Throwable -> L51
        if (this.mStatus.state == 4) goto L48;
        setStateLocked(5, -4, "AP-DISABLED");     // Catch: Throwable -> L51
    L49:
        monitor-exit(r14);     // Catch: Throwable -> L51
        return;
    L48:
        setStateLocked(0, 0, null);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    L42:
        if (r8.startsWith("INTERFACE-DISABLED") == true) goto L43;
    }

    private boolean hasPermission(String r8) {
        if (this.mContext.checkSelfPermission(r8) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isAllowedPrimaryChannel(int r8) {
        if (r8 >= 36) goto L5;
    L9:
        return false;
    L5:
        if (r8 > 60) goto L9;
        if (((r8 - 36) % 8) != 0) goto L9;
        return true;
    }

    private /* synthetic */ void lambda$new$0(Runnable r8) {
        this.mHandler.post(r8);
    }

    private /* synthetic */ void lambda$restartSoftApAs80DueToRadar$3(SoftApConfiguration r8) {
        ensureWifiDisabledThenStart(r8, false);
    }

    private /* synthetic */ void lambda$startSoftAp$1(CaeSoftApConfig r8, String r10) {
        startSoftApInternal(r8, r10);
    }

    private /* synthetic */ void lambda$waitForWifiDisabledThenStart$2(SoftApConfiguration r8, boolean r10, long r11) {
        waitForWifiDisabledThenStart(r8, r10, r11);
    }

    private void logTetheringStartPrereqs(SoftApConfiguration r8) {
        TetheringManager r10 = (TetheringManager) this.mContext.getSystemService(TetheringManager.class);     // Catch: Throwable -> L5
    L7:
        StringBuilder r11 = new StringBuilder("tethering-start-prereqs: tm=");
        if (r10 == null) goto L10;
        boolean r12 = true;
    L11:
        r11.append(r12);
        r11.append(" perm.TETHER_PRIVILEGED=");
        r11.append(hasPermission("android.permission.TETHER_PRIVILEGED"));
        r11.append(" perm.NETWORK_STACK=");
        r11.append(hasPermission("android.permission.NETWORK_STACK"));
        r11.append(" perm.MAINLINE_NETWORK_STACK=");
        r11.append(hasPermission("android.permission.MAINLINE_NETWORK_STACK"));
        r11.append(" config=");
        r11.append(r8);
        CaeLog.i(TAG, r11.toString());
        return;
    L10:
        r12 = false;
    L5:
        th = move-exception;
        CaeLog.w(TAG, "get TetheringManager failed: " + th);
        r10 = null;
        goto L7
    }

    private static int mapSapFailureToErr(int r8) {
        return -4;
    }

    private void maybeReleaseSoftApTxPowerLocked(String r8, boolean r10) {
        if (this.mTxPowerCapApplied == true) goto L8;
        if (r10 == false) goto L21;
        clearTxPowerCapTrackingLocked();
        return;
    L21:
        return;
    L8:
        if (TextUtils.isEmpty(this.mCurrentSoftApIfName) == true) goto L10;
        String r11 = this.mCurrentSoftApIfName;
    L11:
        NefidInterface r12 = this.mNefidInterface;
        boolean r13 = false;
        if (r12 != null) goto L14;
    L16:
        StringBuilder r14 = new StringBuilder("release SoftAP txpower result=");
        r14.append(r13);
        r14.append(" ifName=");
        r14.append(r11);
        r14.append(" reason=");
        android.aimedia.a.r(r14, r8, TAG);
        if (r13 == true) goto L19;
        if (r10 == true) goto L19;
        return;
    L19:
        clearTxPowerCapTrackingLocked();
        return;
    L14:
        if (r12.setSoftApTxPower(r11, 0, 0) == false) goto L16;
        r13 = true;
        goto L16
    L10:
        r11 = this.mTxPowerAppliedIfName;
        goto L11
    }

    private void notifyStatusLocked() {
        CaeSoftApStatus r8 = getStatus();
        int r10 = this.mCallbacks.beginBroadcast();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L6;
        ((ICaeSoftApCallback) this.mCallbacks.getBroadcastItem(r11)).onStatusChanged(r8);     // Catch: RemoteException -> L8
    L5:
        r11 = r11 + 1;
        goto L3
    L6:
        this.mCallbacks.finishBroadcast();
    }

    private void registerSoftApCallbackIfNeeded() {
        WifiManager r8 = this.mWifiManager;
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.mSoftApCallbackRegistered == true) goto L15;
        r8.registerSoftApCallback(this.mCallbackExecutor, this.mSoftApCallback);     // Catch: Throwable -> L9
        this.mSoftApCallbackRegistered = true;     // Catch: Throwable -> L9
        CaeLog.i(TAG, "registerSoftApCallback success");     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        CaeLog.w(TAG, "registerSoftApCallback failed: " + th);
        return;
    }

    private static boolean requiresAssumedCac(SoftApInfo r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r8.getBandwidth() != 6) goto L9;
        return true;
    L9:
        return false;
    }

    private int resolveEffectiveWifiStandard(CaeSoftApConfig r8) {
        return 6;
    }

    private boolean restartSoftApAs80DueToRadar(String r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
    L36:
        th = move-exception;
        throw th;
    L5:
        if (this.mFallbackTo80Active == false) goto L10;
        CaeLog.i(TAG, "radar fallback already active, keep current handling: " + r8);     // Catch: Throwable -> L36
        monitor-exit(r10);     // Catch: Throwable -> L36
        return false;
    L10:
        if (this.mLastStartConfig != null) goto L12;
    L33:
        CaeLog.w(TAG, "radar fallback skipped, last start config missing");     // Catch: Throwable -> L36
        monitor-exit(r10);     // Catch: Throwable -> L36
        return false;
    L12:
        if (TextUtils.isEmpty(this.mLastStartCountryCode) == true) goto L33;
        CaeSoftApConfig r11 = copyConfig(this.mLastStartConfig);     // Catch: Throwable -> L36
        String r12 = this.mLastStartCountryCode;     // Catch: Throwable -> L36
        int r13 = 1;
        this.mFallbackTo80Active = true;     // Catch: Throwable -> L36
        cancelCacTickerLocked();     // Catch: Throwable -> L36
        maybeReleaseSoftApTxPowerLocked("radar fallback", true);     // Catch: Throwable -> L36
        this.mHostapdMonitor.stop();     // Catch: Throwable -> L36
        monitor-exit(r10);     // Catch: Throwable -> L36
        CaeLog.i(TAG, "restart SoftAP as 80MHz due to radar: " + r8);
        setStateLocked(1, 0, "fallback to 80MHz: " + r8);
        TetheringManager r14 = this.mTetheringManager;     // Catch: Throwable -> L24
        if (r14 == null) goto L20;
        r14.stopTethering(0);     // Catch: Throwable -> L24
    L39:
    L43:
        this.mHandler.postDelayed(new f(r13, this, buildSoftApConfiguration(r11, r12, 80)), 1000);
        return true;
    L30:
        th = move-exception;
        failAsync(-4, "build 80MHz fallback config failed: " + th);
        return true;
    L20:
        WifiManager r15 = this.mWifiManager;     // Catch: Throwable -> L24
        if (r15 == null) goto L39;
        r15.stopSoftAp();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CaeLog.w(TAG, "stop SoftAP before fallback failed: " + th);
        goto L43
    }

    private static String sanitizeSoftApInterfaceName(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return "";
    L5:
        String r10 = r8.trim();
        if ("0".equals(r10) == false) goto L8;
    L11:
        return "";
    L8:
        if ("null".equalsIgnoreCase(r10) == true) goto L11;
        return r10;
    }

    private static void setCountryCodeReflect(SoftApConfiguration.Builder r8, String r10) {
        SoftApConfiguration.Builder.class.getMethod("setCountryCode", new Class[]{String.class}).invoke(r8, new Object[]{r10});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CaeLog.w(TAG, "setCountryCode reflect failed: " + th);
    }

    private static void setIeee80211axEnabledReflect(SoftApConfiguration.Builder r8, boolean r10) {
        SoftApConfiguration.Builder.class.getMethod("setIeee80211axEnabled", new Class[]{Boolean.TYPE}).invoke(r8, new Object[]{Boolean.valueOf(r10)});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CaeLog.w(TAG, "setIeee80211axEnabled reflect failed: " + th);
    }

    private static void setIeee80211beEnabledReflect(SoftApConfiguration.Builder r8, boolean r10) {
        SoftApConfiguration.Builder.class.getMethod("setIeee80211beEnabled", new Class[]{Boolean.TYPE}).invoke(r8, new Object[]{Boolean.valueOf(r10)});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CaeLog.w(TAG, "setIeee80211beEnabled reflect failed: " + th);
    }

    private static void setMaxChannelBandwidthReflect(SoftApConfiguration.Builder r8, int r10) {
        SoftApConfiguration.Builder.class.getMethod("setMaxChannelBandwidth", new Class[]{Integer.TYPE}).invoke(r8, new Object[]{Integer.valueOf(r10)});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CaeLog.w(TAG, "setMaxChannelBandwidth reflect failed: " + th);
    }

    private static void setMeteredReflect(SoftApConfiguration.Builder r8, boolean r10) {
        SoftApConfiguration.Builder.class.getMethod("setMetered", new Class[]{Boolean.TYPE}).invoke(r8, new Object[]{Boolean.valueOf(r10)});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CaeLog.w(TAG, "setMetered reflect failed: " + th);
    }

    private void setStateLocked(int r8, int r10, String r11) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        CaeSoftApStatus r13 = this.mStatus;     // Catch: Throwable -> L7
        r13.state = r8;     // Catch: Throwable -> L7
        r13.errorCode = r10;     // Catch: Throwable -> L7
        r13.errorDetail = r11;     // Catch: Throwable -> L7
        notifyStatusLocked();     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void setUserConfigurationReflect(SoftApConfiguration.Builder r8, boolean r10) {
        SoftApConfiguration.Builder.class.getMethod("setUserConfiguration", new Class[]{Boolean.TYPE}).invoke(r8, new Object[]{Boolean.valueOf(r10)});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CaeLog.w(TAG, "setUserConfiguration reflect failed: " + th);
    }

    private void startCacTickerLocked() {
        cancelCacTickerLocked(false);
        Runnable r8 = new AnonymousClass4(this);
        this.mCacTicker = r8;
        this.mHandler.postDelayed(r8, 1000);
    }

    private void startSoftApInternal(CaeSoftApConfig r17, String r18) {
        if (this.mWifiManager != null) goto L6;
        String r8 = "WifiManager null";
    L31:
        failAsync(-7, r8);
        return;
    L6:
        int r10 = resolveEffectiveWifiStandard(r17);
        String r11 = get160To80FallbackReason();
        if (r11 != null) goto L9;
        int r12 = 160;
    L11:
        if (r12 != 160) goto L13;
        boolean r13 = true;
    L14:
        StringBuilder r14 = new StringBuilder("startSoftAp: ssid=");
        r14.append(r17.ssid);
        r14.append(" sec=");
        r14.append(r17.securityType);
        r14.append(" standard(requested)=");
        defpackage.b.q(r14, r17.wifiStandard, " standard(effective)=", r10, " ch=");
        r14.append(r17.channel);
        r14.append(" 160=");
        r14.append(r17.enable160Mhz);
        r14.append(" targetBandwidth=");
        r14.append(r12);
        r14.append(" fallbackReason=");
        r14.append(r11);
        r14.append(" hidden=");
        r14.append(r17.hidden);
        r14.append(" metered=");
        r14.append(r17.metered);
        r14.append(" cc=");
        r14.append(r18);
        r14.append(" uid=");
        r14.append(Binder.getCallingUid());
        CaeLog.i(TAG, r14.toString());
        Object r15 = this.mLock;
        monitor-enter(r15);
        this.mLastStartConfig = copyConfig(r17);     // Catch: Throwable -> L33
        this.mLastStartCountryCode = r18;     // Catch: Throwable -> L33
        if (r12 != 80) goto L19;
        boolean r16 = true;
    L20:
        this.mFallbackTo80Active = r16;     // Catch: Throwable -> L33
        CaeSoftApStatus r19 = this.mStatus;     // Catch: Throwable -> L33
        r19.countryCode = r18;     // Catch: Throwable -> L33
        r19.channel = r17.channel;     // Catch: Throwable -> L33
        r19.bandwidthMhz = 0;     // Catch: Throwable -> L33
        r19.frequencyMhz = 0;     // Catch: Throwable -> L33
        r19.remainingCacSeconds = 0;     // Catch: Throwable -> L33
        this.mCacEndElapsedMs = 0;     // Catch: Throwable -> L33
        this.mExpectCac = false;     // Catch: Throwable -> L33
        clearTxPowerCapTrackingLocked();     // Catch: Throwable -> L33
        monitor-exit(r15);     // Catch: Throwable -> L33
        if (r11 != null) goto L24;
        String r20 = null;
    L25:
        setStateLocked(1, 0, r20);
        registerSoftApCallbackIfNeeded();
        SoftApConfiguration r21 = buildSoftApConfiguration(r17, r18, r12);     // Catch: Throwable -> L29
        CaeLog.i(TAG, "softApConfig built: " + r21);     // Catch: Throwable -> L29
        ensureWifiDisabledThenStart(r21, r13);
        return;
    L29:
        th = move-exception;
        r8 = "build SoftApConfiguration failed: " + th;
        goto L31
    L24:
        r20 = "fallback to 80MHz: ".concat(r11);
        goto L25
    L19:
        r16 = false;
    L33:
        th = move-exception;
        throw th;
    L13:
        r13 = false;
        goto L14
    L9:
        r12 = 80;
        goto L11
    }

    private void stopSoftApInternal() {
        setStateLocked(4, 0, null);
        Object r8 = this.mLock;
        monitor-enter(r8);
        maybeReleaseSoftApTxPowerLocked("stop", true);     // Catch: Throwable -> L17
        cancelCacTickerLocked();     // Catch: Throwable -> L17
        this.mHostapdMonitor.stop();     // Catch: Throwable -> L17
        this.mFallbackTo80Active = false;     // Catch: Throwable -> L17
        monitor-exit(r8);     // Catch: Throwable -> L17
        TetheringManager r10 = this.mTetheringManager;     // Catch: Throwable -> L13
        if (r10 == null) goto L9;
        r10.stopTethering(0);     // Catch: Throwable -> L13
    L22:
    L15:
        setStateLocked(0, 0, null);
        return;
    L9:
        WifiManager r11 = this.mWifiManager;     // Catch: Throwable -> L13
        if (r11 == null) goto L22;
        r11.stopSoftAp();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CaeLog.w(TAG, "stopSoftAp error: " + th);
    L17:
        th = move-exception;
        throw th;
    }

    private void syncSoftApTxPowerLocked(SoftApInfo r8) {
        if (r8 == null) goto L4;
        this.mCurrentSoftApIfName = sanitizeSoftApInterfaceName(getSoftApInterfaceName(r8));
    L4:
        CaeSoftApStatus r10 = this.mStatus;
        boolean r11 = false;
        if (r10.bandwidthMhz == 160) goto L7;
        maybeReleaseSoftApTxPowerLocked("non-160 bandwidth", false);
        return;
    L7:
        if (r10.state == 3) goto L11;
        StringBuilder r12 = new StringBuilder("defer SoftAP txpower apply until RUNNING state=");
        r12.append(this.mStatus.state);
        r12.append(" ifName=");
        android.aimedia.a.r(r12, this.mCurrentSoftApIfName, TAG);
        return;
    L11:
        if (this.mTxPowerCapApplied == false) goto L16;
        if (TextUtils.equals(this.mTxPowerAppliedIfName, this.mCurrentSoftApIfName) == false) goto L16;
        return;
    L16:
        if (this.mTxPowerCapApplied == true) goto L18;
    L20:
        NefidInterface r13 = this.mNefidInterface;
        if (r13 != null) goto L23;
    L25:
        StringBuilder r14 = android.aimedia.a.l("apply SoftAP txpower fixed result=", r11, " ifName=");
        r14.append(this.mCurrentSoftApIfName);
        r14.append(" dbm=16 state=");
        defpackage.b.p(r14, this.mStatus.state, TAG);
        if (r11 == false) goto L31;
        this.mTxPowerCapApplied = true;
        this.mTxPowerAppliedIfName = this.mCurrentSoftApIfName;
        return;
    L31:
        return;
    L23:
        if (r13.setSoftApTxPower(this.mCurrentSoftApIfName, 1, 16) == false) goto L25;
        r11 = true;
        goto L25
    L18:
        if (TextUtils.equals(this.mTxPowerAppliedIfName, this.mCurrentSoftApIfName) == true) goto L20;
        maybeReleaseSoftApTxPowerLocked("interface changed", false);
        goto L20
    }

    private void waitForWifiDisabledThenStart(final SoftApConfiguration r10, final boolean r11, final long r12) {
        WifiManager r8 = this.mWifiManager;
        if (r8 == null) goto L5;
        int r13 = r8.getWifiState();
    L7:
        if (r13 != 1) goto L11;
        CaeLog.i(TAG, "Wi-Fi disabled, continue 160MHz SoftAP start");
        continueStartSoftApAfterWifiDisabled(r10, r11);
        return;
    L11:
        if (SystemClock.elapsedRealtime() < r12) goto L14;
        failAsync(-4, defpackage.a.d("disable Wi-Fi timeout, state=", r13));
        return;
    L14:
        this.mHandler.postDelayed(new a(this, r10, r11, r12), 200);
        return;
    L5:
        r13 = 4;
        goto L7
    }

    @Override // com.obric.cae.libs.softap.ICaeSoftApManager
    public long getSoftApCapabilityBits() {
        enforceCallerAllowed();
        return SOFTAP_CAPABILITY_BITS;
    }

    @Override // com.obric.cae.libs.softap.ICaeSoftApManager
    public int getSoftApInterfaceVersion() {
        enforceCallerAllowed();
        return 1;
    }

    @Override // com.obric.cae.libs.softap.ICaeSoftApManager
    public CaeSoftApStatus getStatus() {
        enforceCallerAllowed();
        Object r8 = this.mLock;
        monitor-enter(r8);
        CaeSoftApStatus r10 = new CaeSoftApStatus();     // Catch: Throwable -> L7
        CaeSoftApStatus r11 = this.mStatus;     // Catch: Throwable -> L7
        r10.state = r11.state;     // Catch: Throwable -> L7
        r10.errorCode = r11.errorCode;     // Catch: Throwable -> L7
        r10.errorDetail = r11.errorDetail;     // Catch: Throwable -> L7
        r10.countryCode = r11.countryCode;     // Catch: Throwable -> L7
        r10.channel = r11.channel;     // Catch: Throwable -> L7
        r10.frequencyMhz = r11.frequencyMhz;     // Catch: Throwable -> L7
        r10.bandwidthMhz = r11.bandwidthMhz;     // Catch: Throwable -> L7
        r10.remainingCacSeconds = r11.remainingCacSeconds;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.cae.libs.softap.ICaeSoftApManager
    public void registerCallback(ICaeSoftApCallback r8) {
        enforceCallerAllowed();
        if (r8 == null) goto L6;
        this.mCallbacks.register(r8);
        return;
    }

    @Override // com.obric.cae.libs.softap.ICaeSoftApManager
    public int startSoftAp(CaeSoftApConfig r8, ICaeSoftApCallback r10) {
        enforceCallerAllowed();
        if (r8 != null) goto L6;
        return -3;
    L6:
        if (r8.enable160Mhz == true) goto L10;
        return failNow(-3, "enable160Mhz=false");
    L10:
        if (isAllowedPrimaryChannel(r8.channel) == true) goto L14;
        return failNow(-3, "channel must be one of 36/44/52/60");
    L14:
        if (TextUtils.isEmpty(r8.ssid) == true) goto L16;
        int r11 = r8.securityType;
        if (r11 != 0) goto L20;
    L27:
        int r12 = r8.wifiStandard;
        if (r12 != 6) goto L30;
    L33:
        if (r11 != 0) goto L35;
    L40:
        String r13 = getWifiCountryCodeSafe();
        if (BdLocationManager.DEFAULT_WORLD_VIEW.equalsIgnoreCase(r13) == true) goto L51;
        Object r14 = this.mLock;
        monitor-enter(r14);
        this.mStatus.countryCode = r13;     // Catch: Throwable -> L48
        monitor-exit(r14);     // Catch: Throwable -> L48
        return failNow(-2, defpackage.b.c("countryCode=", r13));
    L48:
        th = move-exception;
        throw th;
    L51:
        if (r10 == null) goto L53;
        this.mCallbacks.register(r10);
    L53:
        this.mHandler.post(new m(this, r8, r13));
        return 0;
    L35:
        if (TextUtils.isEmpty(r8.passphrase) == true) goto L39;
        if (r8.passphrase.length() >= 8) goto L40;
    L39:
        return failNow(-3, "passphrase invalid");
    L30:
        if (r12 == 7) goto L33;
        return failNow(-3, "unsupported wifiStandard=" + r8.wifiStandard);
    L20:
        if (r11 == 1) goto L27;
        if (r11 == 2) goto L27;
        if (r11 == 3) goto L27;
        return failNow(-3, "unsupported securityType=" + r8.securityType);
    L16:
        return failNow(-3, "ssid empty");
    }

    @Override // com.obric.cae.libs.softap.ICaeSoftApManager
    public int stopSoftAp() {
        enforceCallerAllowed();
        this.mHandler.post(new c(this, 0));
        return 0;
    }

    @Override // com.obric.cae.libs.softap.ICaeSoftApManager
    public void unregisterCallback(ICaeSoftApCallback r8) {
        enforceCallerAllowed();
        if (r8 == null) goto L6;
        this.mCallbacks.unregister(r8);
        return;
    }

    private void cancelCacTickerLocked(boolean r8) {
        Runnable r10 = this.mCacTicker;
        if (r10 == null) goto L5;
        this.mHandler.removeCallbacks(r10);
        this.mCacTicker = null;
    L5:
        if (r8 == false) goto L8;
        this.mCacEndElapsedMs = 0;
        this.mExpectCac = false;
        return;
    }
}
