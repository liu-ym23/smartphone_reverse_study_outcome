package com.obric.cae.smartNetwork.netAccel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.MacAddress;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.TransportInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSpecifier;
import android.os.Message;
import android.provider.Settings;
import com.android.internal.util.State;
import com.android.internal.util.StateMachine;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.networkMonitor.ActivityMonitor;
import com.obric.cae.utils.CaeUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class DualWlanConnector extends StateMachine {
    private static final int CMD_DISABLE = 3;
    private static final int CMD_ENABLE = 4;
    private static final int CMD_PACKAGE_RUNNER_UPDATE = 1;
    private static final int CMD_RECONNECT = 2;
    private static final int CONNECT_TIMEOUT_MS = 6000;
    private static final int DUAL_WLAN_SIZE = 2;
    private static final int RATE_DELAY_OFF_MS_COUNT = 5;
    private static final int RATE_DOWNLOAD_THROUGHPUT_THRESHOLD = 0;
    private static final int SECONDARY_WIFI_CONNECTED = 1;
    private static final int SECONDARY_WIFI_DISCONNECTED = 0;
    private static final String SETTINGS_SECURE_SECONDARY_WIFI_CONNECTED = "secondary_wifi_connected";
    private static final String TAG = null;
    private static final int WIFI_SECURITY_SCORE_UNKNOWN_PASSWORD = 1;
    private static final int WIFI_SECURITY_SCORE_WAPI_PSK = 3;
    private static final int WIFI_SECURITY_SCORE_WEP = 2;
    private static final int WIFI_SECURITY_SCORE_WPA2_PSK = 4;
    private static final int WIFI_SECURITY_SCORE_WPA3_SAE = 6;
    private static final int WIFI_SECURITY_SCORE_WPA3_TRANSITION = 5;
    private boolean isBoot;
    private final AccelConfigManager mAccelConfigManager;
    private AccelMetric mAccelMetric;
    private final ActivityMonitor.ActivityMonitorListener mActivityMonitorListener;
    private AutoConnectingState mAutoConnectingState;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private DisabledState mDisabledState;
    private final ConcurrentHashMap<String, Boolean> mForegroudPackageRunner;
    private final L4NetEvaluate mL4NetEvaluate;
    private int mMode;
    private final ConnectivityManager.NetworkCallback mNetworkCallback;
    private NoConnectionState mNoConnectionState;
    private PowerWatcher mPowerWatcher;
    private final L4NetEvaluate.L4NetTcpInfoListenerCallback mRateListener;
    private final ConcurrentHashMap<String, Integer> mRatePackageRunner;
    private StopConnectedState mStopConnectedState;
    private final WifiManager mWifiManager;

    public class AutoConnectingState extends State {
        final /* synthetic */ DualWlanConnector this$0;

        private AutoConnectingState(DualWlanConnector r8) {
            this.this$0 = r8;
        }

        public void enter() {
            CaeLog.d(DualWlanConnector.access$400(), "AutoConnectingState");
            DualWlanConnector.access$1700(this.this$0, 0);
            if (DualWlanConnector.access$1800(this.this$0) == true) goto L6;
            this.this$0.sendMessageDelayed(2, 6000);
            return;
        }

        public boolean processMessage(Message r8) {
            if (super.processMessage(r8) == false) goto L5;
            return true;
        L5:
            int r10 = r8.what;
            if (r10 == 1) goto L20;
            if (r10 != 2) goto L10;
            DualWlanConnector.access$2000(this.this$0);
            if (DualWlanConnector.access$1800(this.this$0) == true) goto L18;
            this.this$0.sendMessageDelayed(2, 6000);
        L18:
            return true;
        L10:
            if (r10 == 3) goto L13;
            return false;
        L13:
            DualWlanConnector r11 = this.this$0;
            r11.transitionTo(DualWlanConnector.access$1400(r11));
            return true;
        L20:
            if (DualWlanConnector.access$1500(this.this$0) == true) goto L22;
            DualWlanConnector r12 = this.this$0;
            r12.transitionTo(DualWlanConnector.access$1900(r12));
        L22:
            return true;
        }

        public /* synthetic */ AutoConnectingState(DualWlanConnector r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class DisabledState extends State {
        final /* synthetic */ DualWlanConnector this$0;

        private DisabledState(DualWlanConnector r8) {
            this.this$0 = r8;
        }

        public void enter() {
            CaeLog.d(DualWlanConnector.access$400(), "DisabledState");
            if (DualWlanConnector.access$700(this.this$0) != true) goto L6;
            DualWlanConnector.access$702(this.this$0, false);
            return;
        L6:
            ActivityMonitor.getInstance(DualWlanConnector.access$900(this.this$0)).unregisterActivityListener(DualWlanConnector.access$800(this.this$0));
            DualWlanConnector.access$1100(this.this$0).unregisterL4NetTcpInfoListener(DualWlanConnector.access$1000(this.this$0));
        }

        public boolean processMessage(Message r8) {
            if (super.processMessage(r8) == false) goto L6;
            return true;
        L6:
            if (r8.what == 4) goto L9;
            return false;
        L9:
            DualWlanConnector r10 = this.this$0;
            r10.transitionTo(DualWlanConnector.access$1200(r10));
            return true;
        }

        public /* synthetic */ DisabledState(DualWlanConnector r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class NoConnectionState extends State {
        final /* synthetic */ DualWlanConnector this$0;

        private NoConnectionState(DualWlanConnector r8) {
            this.this$0 = r8;
        }

        public void enter() {
            CaeLog.d(DualWlanConnector.access$400(), "NoConnectionState");
            DualWlanConnector.access$1300(this.this$0);
            ActivityMonitor.getInstance(DualWlanConnector.access$900(this.this$0)).registerActivityListener(DualWlanConnector.access$800(this.this$0));
            DualWlanConnector.access$1100(this.this$0).registerL4NetTcpInfoListener(DualWlanConnector.access$1000(this.this$0));
        }

        public boolean processMessage(Message r8) {
            if (super.processMessage(r8) == false) goto L5;
            return true;
        L5:
            int r10 = r8.what;
            if (r10 == 1) goto L14;
            if (r10 == 3) goto L11;
            return false;
        L11:
            DualWlanConnector r11 = this.this$0;
            r11.transitionTo(DualWlanConnector.access$1400(r11));
            return true;
        L14:
            if (DualWlanConnector.access$1500(this.this$0) == false) goto L16;
            DualWlanConnector r12 = this.this$0;
            r12.transitionTo(DualWlanConnector.access$1600(r12));
        L16:
            return true;
        }

        public /* synthetic */ NoConnectionState(DualWlanConnector r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public static final class SavedWifiCandidate {
        private final ScanResult scanResult;
        private final int securityScore;

        public SavedWifiCandidate(ScanResult r8, int r10) {
            if (r8 == null) goto L7;
            this.scanResult = r8;
            this.securityScore = r10;
            return;
        L7:
            throw new IllegalArgumentException("scanResult must not be null");
        }

        public static /* synthetic */ ScanResult access$500(SavedWifiCandidate r8) {
            return r8.scanResult;
        }

        public static /* synthetic */ int access$600(SavedWifiCandidate r8) {
            return r8.securityScore;
        }
    }

    public class StopConnectedState extends State {
        final /* synthetic */ DualWlanConnector this$0;

        private StopConnectedState(DualWlanConnector r8) {
            this.this$0 = r8;
        }

        public void enter() {
            CaeLog.d(DualWlanConnector.access$400(), "StopConnectedState");
            DualWlanConnector.access$1700(this.this$0, 1);
            DualWlanConnector.access$2000(this.this$0);
            DualWlanConnector.access$1300(this.this$0);
        }

        public boolean processMessage(Message r8) {
            if (super.processMessage(r8) == false) goto L5;
            return true;
        L5:
            int r10 = r8.what;
            if (r10 == 1) goto L14;
            if (r10 == 3) goto L11;
            return false;
        L11:
            DualWlanConnector r11 = this.this$0;
            r11.transitionTo(DualWlanConnector.access$1400(r11));
            return true;
        L14:
            if (DualWlanConnector.access$1500(this.this$0) == false) goto L16;
            DualWlanConnector r12 = this.this$0;
            r12.transitionTo(DualWlanConnector.access$1600(r12));
        L16:
            return true;
        }

        public /* synthetic */ StopConnectedState(DualWlanConnector r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    static {
        TAG = "MultiNetwork-DualWlanConnector";
    }

    private DualWlanConnector(String r8, Context r10) {
        super(r8);
        AnonymousClass1 r11 = null;
        this.mDisabledState = new DisabledState(this, r11);
        this.mNoConnectionState = new NoConnectionState(this, r11);
        this.mAutoConnectingState = new AutoConnectingState(this, r11);
        this.mStopConnectedState = new StopConnectedState(this, r11);
        this.mMode = -1;
        this.isBoot = true;
        this.mRateListener = new AnonymousClass4(this);
        this.mContext = r10;
        this.mWifiManager = (WifiManager) r10.getSystemService("wifi");
        this.mConnectivityManager = (ConnectivityManager) r10.getSystemService("connectivity");
        this.mForegroudPackageRunner = new ConcurrentHashMap();
        this.mRatePackageRunner = new ConcurrentHashMap();
        this.mNetworkCallback = createNetworkCallback();
        this.mActivityMonitorListener = createActivityMonitorListener();
        this.mAccelConfigManager = AccelConfigManager.getInstance(r10);
        this.mL4NetEvaluate = L4NetEvaluate.getInstance(r10);
        this.mAccelMetric = AccelMetric.getInstance(r10);
        PowerWatcher r12 = new PowerWatcher(r10);
        this.mPowerWatcher = r12;
        r12.setPowerStatusListener(new AnonymousClass1(this));
        addState(this.mDisabledState);
        addState(this.mNoConnectionState);
        addState(this.mAutoConnectingState);
        addState(this.mStopConnectedState);
        setInitialState(this.mDisabledState);
    }

    public static /* synthetic */ L4NetEvaluate.L4NetTcpInfoListenerCallback access$1000(DualWlanConnector r8) {
        return r8.mRateListener;
    }

    public static /* synthetic */ L4NetEvaluate access$1100(DualWlanConnector r8) {
        return r8.mL4NetEvaluate;
    }

    public static /* synthetic */ NoConnectionState access$1200(DualWlanConnector r8) {
        return r8.mNoConnectionState;
    }

    public static /* synthetic */ void access$1300(DualWlanConnector r8) {
        r8.makePackageRunner();
    }

    public static /* synthetic */ DisabledState access$1400(DualWlanConnector r8) {
        return r8.mDisabledState;
    }

    public static /* synthetic */ boolean access$1500(DualWlanConnector r8) {
        return r8.isNeedConnect();
    }

    public static /* synthetic */ AutoConnectingState access$1600(DualWlanConnector r8) {
        return r8.mAutoConnectingState;
    }

    public static /* synthetic */ void access$1700(DualWlanConnector r8, int r10) {
        r8.reportAutoDualWlanCapability(r10);
    }

    public static /* synthetic */ boolean access$1800(DualWlanConnector r8) {
        return r8.connectDualWlan();
    }

    public static /* synthetic */ StopConnectedState access$1900(DualWlanConnector r8) {
        return r8.mStopConnectedState;
    }

    public static /* synthetic */ void access$2000(DualWlanConnector r8) {
        r8.disconnectDualWlan();
    }

    public static /* synthetic */ ConcurrentHashMap access$2100(DualWlanConnector r8) {
        return r8.mForegroudPackageRunner;
    }

    public static /* synthetic */ ConcurrentHashMap access$2200(DualWlanConnector r8) {
        return r8.mRatePackageRunner;
    }

    public static /* synthetic */ int access$2300(DualWlanConnector r8, String r10) {
        return r8.getUidByPackageName(r10);
    }

    public static /* synthetic */ String access$400() {
        return TAG;
    }

    public static /* synthetic */ boolean access$700(DualWlanConnector r8) {
        return r8.isBoot;
    }

    public static /* synthetic */ boolean access$702(DualWlanConnector r8, boolean r10) {
        r8.isBoot = r10;
        return r10;
    }

    public static /* synthetic */ ActivityMonitor.ActivityMonitorListener access$800(DualWlanConnector r8) {
        return r8.mActivityMonitorListener;
    }

    public static /* synthetic */ Context access$900(DualWlanConnector r8) {
        return r8.mContext;
    }

    private boolean connectDualWlan() {
        ArrayList r8 = new ArrayList();
        Network[] r10 = this.mConnectivityManager.getAllNetworks();
        if (r10 != null) goto L5;
        return false;
    L5:
        int r11 = r10.length;
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L18;
        NetworkCapabilities r13 = this.mConnectivityManager.getNetworkCapabilities(r10[r12]);
        if (r13 == null) goto L16;
        if (r13.hasTransport(1) == false) goto L16;
        TransportInfo r14 = r13.getTransportInfo();
        if ((r14 instanceof WifiInfo) == false) goto L15;
        r8.add((WifiInfo) r14);
        goto L16
    L15:
        return false;
    L16:
        r12 = r12 + 1;
        goto L7
    L18:
        if (r8.isEmpty() == false) goto L21;
        CaeLog.d(TAG, "no wlan here");
        return false;
    L21:
        int r15 = 2;
        if (r8.size() < 2) goto L25;
        CaeLog.d(TAG, "already has dual wlan");
        return false;
    L25:
        WifiInfo r16 = (WifiInfo) r8.get(0);
        if (r16 != null) goto L28;
    L57:
        CaeLog.d(TAG, "has no primary wifi completed here, " + r16);
        return false;
    L28:
        if (r16.getSupplicantState() != SupplicantState.COMPLETED) goto L57;
        int r17 = r16.getFrequency();
        int r18 = 5;
        if (r17 >= 4900) goto L33;
    L35:
        char r19 = 2;
    L36:
        if (r19 != 5) goto L38;
        r18 = 2;
    L38:
        SavedWifiCandidate r20 = selectSavedWifiCandidate(r18, r16.getBSSID());
        if (r20 != null) goto L42;
        CaeLog.d(TAG, "no saved secured secondary wifi found on band=" + r18 + "GHz");
        return false;
    L42:
        ScanResult r21 = SavedWifiCandidate.access$500(r20);
        if (r21 != null) goto L45;
    L55:
        CaeLog.e(TAG, "invalid secondary wifi candidate");
        return false;
    L45:
        if (r21.BSSID == null) goto L55;
        int r22 = this.mWifiManager.getStaConcurrencyForMultiInternetMode();
        if (r22 == 2) goto L50;
        setStaConcurrencyForMultiInternetMode(this.mWifiManager, 2);
    L50:
        WifiNetworkSpecifier.Builder r23 = new WifiNetworkSpecifier.Builder();
        if (r18 != 2) goto L53;
        r15 = 1;
    L53:
        r23.setBand(r15);
        r23.setBssid(MacAddress.fromString(r21.BSSID));
        NetworkRequest r24 = new NetworkRequest.Builder().addTransportType(1).addCapability(12).setNetworkSpecifier(r23.build()).build();
        String r25 = TAG;
        StringBuilder r26 = defpackage.b.f("Request secondary Wi-Fi on band=", r18, "GHz, bssid=");
        r26.append(CaeUtil.maskMacOrBssid(r21.BSSID));
        r26.append(", securityScore=");
        r26.append(SavedWifiCandidate.access$600(r20));
        r26.append(", rssi=");
        defpackage.b.p(r26, r21.level, r25);
        this.mConnectivityManager.requestNetwork(r24, this.mNetworkCallback, CONNECT_TIMEOUT_MS);
        this.mMode = r22;
        return true;
    L33:
        if (r17 > 5900) goto L35;
        r19 = 5;
        goto L36
    }

    private ActivityMonitor.ActivityMonitorListener createActivityMonitorListener() {
        return new AnonymousClass3(this);
    }

    private ConnectivityManager.NetworkCallback createNetworkCallback() {
        return new AnonymousClass2(this);
    }

    private void disconnectDualWlan() {
        if (this.mMode != (-1)) goto L5;
        return;
    L5:
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
        setStaConcurrencyForMultiInternetMode(this.mWifiManager, this.mMode);
        this.mMode = -1;
        Settings.Secure.putInt(this.mContext.getContentResolver(), SETTINGS_SECURE_SECONDARY_WIFI_CONNECTED, 0);
    }

    private WifiConfiguration findSavedConfiguredNetwork(ScanResult r8, List<WifiConfiguration> r10) {
        String r11 = r8.SSID;
        if (r11 != null) goto L5;
    L18:
        return null;
    L5:
        if (r11.isEmpty() == true) goto L18;
        String r12 = android.aimedia.a.i(new StringBuilder("\""), r8.SSID, "\"");
        Iterator<WifiConfiguration> r13 = r10.iterator();
    L9:
        if (r13.hasNext() == false) goto L18;
        WifiConfiguration r14 = r13.next();
        if (r14 == null) goto L9;
        String r15 = r14.SSID;
        if (r15 == null) goto L9;
        if (r12.equals(r15) == false) goto L9;
        return r14;
    }

    private List<WifiConfiguration> getConfiguredNetworks() {
        Object r8 = WifiManager.class.getMethod("getPrivilegedConfiguredNetworks", new Class[0]).invoke(this.mWifiManager, new Object[0]);     // Catch: Exception -> L6
        if ((r8 instanceof List) == false) goto L15;
        return (List) r8;
    L15:
        return this.mWifiManager.getConfiguredNetworks();
    L10:
        e = move-exception;
        CaeLog.e(TAG, "getConfiguredNetworks failed", e);
        return null;
    L6:
        e = move-exception;
        CaeLog.e(TAG, "getPrivilegedConfiguredNetworks failed", e);
        goto L15
    }

    private int getUidByPackageName(String r8) {
        return this.mContext.getPackageManager().getApplicationInfo(r8, 0).uid;
    L4:
        return -1;
    }

    private boolean hasSavedPassword(WifiConfiguration r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        String r10 = r8.preSharedKey;
        if (r10 != null) goto L8;
    L10:
        String[] r11 = r8.wepKeys;
        if (r11 != null) goto L13;
        return false;
    L13:
        int r12 = r11.length;
        int r13 = 0;
    L14:
        if (r13 >= r12) goto L21;
        String r14 = r11[r13];
        if (r14 == null) goto L20;
        if (r14.isEmpty() == true) goto L20;
        return true;
    L20:
        r13 = r13 + 1;
        goto L14
    L21:
        return false;
    L8:
        if (r10.isEmpty() == true) goto L10;
        return true;
    }

    private boolean isBetterSavedWifiCandidate(SavedWifiCandidate r8, SavedWifiCandidate r10) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r10 != null) goto L9;
        return true;
    L9:
        if (SavedWifiCandidate.access$600(r8) != SavedWifiCandidate.access$600(r10)) goto L11;
        int r11 = SavedWifiCandidate.access$500(r8).level;
        int r12 = SavedWifiCandidate.access$500(r10).level;
        ScanResult r13 = SavedWifiCandidate.access$500(r8);
        if (r11 == r12) goto L21;
        if (r13.level > SavedWifiCandidate.access$500(r10).level) goto L19;
        return false;
    L19:
        return true;
    L21:
        if (r13.frequency > SavedWifiCandidate.access$500(r10).frequency) goto L23;
        return false;
    L23:
        return true;
    L11:
        if (SavedWifiCandidate.access$600(r8) > SavedWifiCandidate.access$600(r10)) goto L13;
        return false;
    L13:
        return true;
    }

    private boolean isNeedConnect() {
        if (this.mPowerWatcher.isPowerRestricted() == false) goto L6;
        CaeLog.d(TAG, "Power status check failed: lowBattery=" + this.mPowerWatcher.isLowBattery() + ", powerSaveMode=" + this.mPowerWatcher.isPowerSaveMode() + ", highTemperature=" + this.mPowerWatcher.isHighTemperature());
        return false;
    L6:
        Iterator<Map.Entry<String, Integer>> r8 = this.mRatePackageRunner.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L12;
        if (r8.next().getValue().intValue() <= 0) goto L8;
        return true;
    L12:
        Iterator<Map.Entry<String, Boolean>> r10 = this.mForegroudPackageRunner.entrySet().iterator();
    L14:
        if (r10.hasNext() == false) goto L18;
        if (r10.next().getValue().booleanValue() != true) goto L14;
        return true;
    L18:
        return false;
    }

    private boolean isOpenScanResult(ScanResult r8) {
        String r10 = r8.capabilities;
        if (r10 != null) goto L6;
        return true;
    L6:
        if (r10.contains("WEP") == false) goto L8;
    L18:
        return false;
    L8:
        if (r10.contains("PSK") == true) goto L18;
        if (r10.contains("SAE") == true) goto L18;
        if (r10.contains("EAP") == true) goto L18;
        if (r10.contains("WAPI") == true) goto L18;
        if (r10.contains("OWE") == true) goto L18;
        return true;
    }

    private boolean isScanResultInTargetBand(ScanResult r8, int r10) {
        if (r10 != 5) goto L11;
        int r11 = r8.frequency;
        if (r11 < 4900) goto L10;
        if (r11 > 5900) goto L10;
        return true;
    L10:
        return false;
    L11:
        int r12 = r8.frequency;
        if (r12 < 2400) goto L17;
        if (r12 > 2500) goto L17;
        return true;
    L17:
        return false;
    }

    public static DualWlanConnector makeDualWlanConnector(Context r8) {
        DualWlanConnector r10 = new DualWlanConnector("DualWlanConnector", r8);
        r10.start();
        r10.startPowerWatcher();
        return r10;
    }

    private void makePackageRunner() {
        this.mForegroudPackageRunner.clear();
        this.mRatePackageRunner.clear();
        Iterator<Map.Entry<String, AccelConfigManager.PackageRule>> r8 = this.mAccelConfigManager.getAllPackageRules().entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L12;
        Map.Entry<String, AccelConfigManager.PackageRule> r10 = r8.next();
        int r11 = r10.getValue().getAutoDualWlanMode();
        if (r11 == 1) goto L7;
        if (r11 != 2) goto L4;
        ConcurrentHashMap r12 = this.mRatePackageRunner;
        String r13 = r10.getKey();
        Object r14 = 0;
    L8:
        r12.put(r13, r14);
        goto L4
    L7:
        r12 = this.mForegroudPackageRunner;
        r13 = r10.getKey();
        r14 = Boolean.FALSE;
        goto L8
    }

    private void reportAutoDualWlanCapability(int r10) {
        ArrayList r8 = new ArrayList();     // Catch: Exception -> L26
        Iterator<Map.Entry<String, Boolean>> r11 = this.mForegroudPackageRunner.entrySet().iterator();     // Catch: Exception -> L26
    L3:
        int r12 = 1;
        if (r11.hasNext() == false) goto L12;
        Map.Entry<String, Boolean> r13 = r11.next();     // Catch: Exception -> L26
        String r14 = r13.getKey();     // Catch: Exception -> L26
        boolean r15 = r13.getValue().booleanValue();     // Catch: Exception -> L26
        int r16 = getUidByPackageName(r14);     // Catch: Exception -> L26
        if (r16 == (-1)) goto L3;
        AutoDualWlanCapability.AppInfo.Builder r17 = AutoDualWlanCapability.AppInfo.newBuilder();     // Catch: Exception -> L26
        if (r15 == true) goto L11;
        r12 = 0;
    L11:
        r8.add(r17.setState(r12).setUid(r16).setPackageName(r14).build());     // Catch: Exception -> L26
        goto L3
    L12:
        Iterator<Map.Entry<String, Integer>> r18 = this.mRatePackageRunner.entrySet().iterator();     // Catch: Exception -> L26
    L14:
        if (r18.hasNext() == false) goto L23;
        Map.Entry<String, Integer> r19 = r18.next();     // Catch: Exception -> L26
        String r20 = r19.getKey();     // Catch: Exception -> L26
        int r21 = r19.getValue().intValue();     // Catch: Exception -> L26
        int r22 = getUidByPackageName(r20);     // Catch: Exception -> L26
        if (r22 == (-1)) goto L14;
        AutoDualWlanCapability.AppInfo.Builder r23 = AutoDualWlanCapability.AppInfo.newBuilder();     // Catch: Exception -> L26
        if (r21 <= 0) goto L20;
        int r24 = 1;
    L21:
        r8.add(r23.setState(r24).setUid(r22).setPackageName(r20).build());     // Catch: Exception -> L26
        goto L14
    L20:
        r24 = 0;
        goto L21
    L23:
        if (r8.isEmpty() == true) goto L41;
        this.mAccelMetric.reportAutoDualWlanCapability(r10, r8);     // Catch: Exception -> L26
        return;
    L41:
        return;
    L26:
        e = move-exception;
        defpackage.b.k(e, new StringBuilder("reportAutoDualWlanCapability failed: "), TAG);
    }

    private int scoreSavedWifiSecurity(ScanResult r8, WifiConfiguration r10) {
        String r11 = r8.capabilities;
        if (r11 != null) goto L6;
        r11 = "";
    L6:
        if (r11.contains("SAE") == false) goto L12;
        if (r11.contains("PSK") == false) goto L12;
        return 5;
    L12:
        if (r11.contains("SAE") == false) goto L16;
        return 6;
    L16:
        if (r11.contains("PSK") == false) goto L20;
        return 4;
    L20:
        if (r11.contains("WAPI-PSK") == false) goto L22;
        return 3;
    L22:
        if (r11.contains("WAPI") == false) goto L25;
        return 3;
    L25:
        if (r11.contains("WEP") == false) goto L29;
        return 2;
    L29:
        return hasSavedPassword(r10) ? 1 : 0;
    }

    private SavedWifiCandidate selectSavedWifiCandidate(int r8, String r10) {
        List<WifiConfiguration> r11 = getConfiguredNetworks();
        SavedWifiCandidate r12 = null;
        if (r11 != null) goto L5;
    L37:
        return r12;
    L5:
        if (r11.isEmpty() == true) goto L37;
        List<ScanResult> r13 = this.mWifiManager.getScanResults();
        if (r13 == null) goto L37;
        if (r13.isEmpty() == true) goto L37;
        Iterator<ScanResult> r14 = r13.iterator();
    L14:
        if (r14.hasNext() == false) goto L37;
        ScanResult r15 = r14.next();
        if (r15 == null) goto L14;
        String r16 = r15.BSSID;
        if (r16 == null) goto L14;
        if (r16.equals(r10) == true) goto L14;
        if (isScanResultInTargetBand(r15, r8) == false) goto L14;
        if (isOpenScanResult(r15) == true) goto L14;
        WifiConfiguration r17 = findSavedConfiguredNetwork(r15, r11);
        if (r17 == null) goto L14;
        if (hasSavedPassword(r17) == false) goto L14;
        SavedWifiCandidate r18 = new SavedWifiCandidate(r15, scoreSavedWifiSecurity(r15, r17));
        if (isBetterSavedWifiCandidate(r18, r12) == false) goto L14;
        r12 = r18;
        goto L14
    }

    private boolean setStaConcurrencyForMultiInternetMode(WifiManager r8, int r10) {
        Method r11 = r8.getClass().getDeclaredMethod("setStaConcurrencyForMultiInternetMode", new Class[]{Integer.TYPE});     // Catch: Exception -> L9
        r11.setAccessible(true);     // Catch: Exception -> L9
        Object r12 = r11.invoke(r8, new Object[]{Integer.valueOf(r10)});     // Catch: Exception -> L9
        if ((r12 instanceof Boolean) == false) goto L14;
        if (((Boolean) r12).booleanValue() == true) goto L8;
        return false;
    L8:
        return true;
    L14:
        return false;
    L9:
        e = move-exception;
        CaeLog.e("ReflectionUtil", "Error calling setStaConcurrencyForMultiInternetMode", e);
        return false;
    }

    private void startPowerWatcher() {
        PowerWatcher r8 = this.mPowerWatcher;
        if (r8 == null) goto L6;
        r8.start();
        return;
    }

    public DualWlanConnector addForegroudPackageRunner(String r8) {
        if (this.mForegroudPackageRunner.containsKey(r8) == false) goto L5;
        return this;
    L5:
        this.mForegroudPackageRunner.put(r8, Boolean.FALSE);
        return this;
    }

    public DualWlanConnector addRatePackageRunner(String r8) {
        if (this.mRatePackageRunner.containsKey(r8) == false) goto L5;
        return this;
    L5:
        this.mRatePackageRunner.put(r8, 0);
        return this;
    }

    public DualWlanConnector removeForegroudPackageRunner(String r8) {
        if (this.mForegroudPackageRunner.containsKey(r8) == true) goto L5;
        return this;
    L5:
        this.mForegroudPackageRunner.remove(r8);
        sendMessage(1);
        return this;
    }

    public DualWlanConnector removeRatePackageRunner(String r8) {
        if (this.mRatePackageRunner.containsKey(r8) == false) goto L5;
        return this;
    L5:
        this.mRatePackageRunner.remove(r8);
        sendMessage(1);
        return this;
    }

    public void sendCmdEnable(boolean r8) {
        CaeLog.d(TAG, "sendCmdEnable: " + r8);
        if (r8 != true) goto L5;
        int r10 = 4;
    L6:
        sendMessage(r10);
        return;
    L5:
        r10 = 3;
        goto L6
    }
}
