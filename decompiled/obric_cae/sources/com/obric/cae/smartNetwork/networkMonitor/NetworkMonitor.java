package com.obric.cae.smartNetwork.networkMonitor;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.provider.Settings;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.smartNetwork.CloudConfigParseAndSave;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.networkHandover.HandoverParameterManager;
import com.obric.cae.smartNetwork.networkHandover.NetworkExecutor;
import com.obric.cae.statusReport.network.NetworkInfoCollect;
import defpackage.b;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkMonitor {
    private static final boolean DEBUG = false;
    private static final String DEFAULT_PROBE_URL = "http://connectivitycheck.oceancloudapi.com/generate204";
    public static final int DETECT_RESULT_FAILED = 2;
    public static final int DETECT_RESULT_PORTAL = 3;
    public static final int DETECT_RESULT_SUCCESS = 1;
    public static final int DETECT_RESULT_UNKNOWN = 0;
    public static final int DETECT_SCENE_HAS_INTERNET = 2;
    public static final int DETECT_SCENE_NETWORK_CONNECT = 1;
    public static final int DETECT_SCENE_NETWORK_HANDOVER = 6;
    public static final int DETECT_SCENE_NONE = 0;
    public static final int DETECT_SCENE_NO_INTERNET = 3;
    public static final int DETECT_SCENE_WEAK_INTERNET = 4;
    public static final int DETECT_SCENE_WIFI_ROAMING = 5;
    private static final long DNS_RESOLVE_INTERVAL = 10000;
    public static final int MSG_DETECT_MODE_BACKOFF = 2;
    public static final int MSG_DETECT_MODE_CLOSE = 3;
    public static final int MSG_DETECT_MODE_ONCE = 0;
    public static final int MSG_DETECT_MODE_PERIOD = 1;
    private static final int NETWORK_TYPE_UNKNOWN = -1;
    private static final long ONCE_DETECTION_INTERVAL = 20000;
    private static final String TAG = "CaeNetworkMonitor";
    private final ActivityMonitor mActivityMonitor;
    private final ActivityMonitor.ActivityMonitorListener mActivityMonitorListener;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private int mDetectBackoff;
    private int mDetectScene;
    private final DnsResolverProbe mDnsResolverProbe;
    private final HandlerThread mHandlerThread;
    private final HandoverParameterManager mHandoverParameterManager;
    private boolean mHasForeground;
    private final HttpConnectionProbe mHttpConnectionProbe;
    private boolean mIsGoodNetwork;
    private boolean mIsValidated;
    private final L4NetEvaluate mL4NetEvaluate;
    private long mLastDnsResolveTime;
    private long mLastOnceDetectionTime;
    private final Object mLock;
    private final int mNetId;
    private final Network mNetwork;
    private final ConnectivityManager.NetworkCallback mNetworkCallback;
    private boolean mNetworkCallbackRegistered;
    private final L4NetEvaluate.L4NetErrReportCb mNetworkErrReportCb;
    private final NetworkExecutor mNetworkExecutor;
    private final NetworkRequest mNetworkRequest;
    private int mNetworkType;
    private final PowerManager mPowerManager;
    private final ScheduleHandler mScheduleHandler;
    private final BroadcastReceiver mScreenBroadcastReceiver;
    private final IntentFilter mScreenFilter;
    private boolean mScreenOn;
    private WifiRoamingMonitor mWifiRoamingMonitor;

    public interface NetworkMonitorListener {
        void onProbeResult(boolean r8, int r10);
    }

    public class ScheduleHandler extends Handler {
        public static final int KEEP_BACKOFF = 0;
        public static final int RESET_BACKOFF = 1;
        final /* synthetic */ NetworkMonitor this$0;

        public ScheduleHandler(NetworkMonitor r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            int r10 = r8.what;
            if (r10 != 0) goto L5;
            NetworkMonitor.access$000(this.this$0);
            return;
        L5:
            if (r10 != 1) goto L7;
            NetworkMonitor.access$100(this.this$0);
            return;
        L7:
            if (r10 != 2) goto L9;
            NetworkMonitor.access$200(this.this$0, r8.arg1);
            return;
        L9:
            if (r10 != 3) goto L19;
            NetworkMonitor.access$300(this.this$0);
            return;
        }
    }

    public class WifiRoamingMonitor {
        private IntentFilter filter;
        private String mBSSID;
        private String mSSID;
        private WifiManager mWifiManager;
        BroadcastReceiver mWifiRoamingReceiver;
        final /* synthetic */ NetworkMonitor this$0;

        public WifiRoamingMonitor(NetworkMonitor r8) {
            this.this$0 = r8;
            this.mWifiRoamingReceiver = new AnonymousClass1(this);
            WifiManager r10 = (WifiManager) NetworkMonitor.access$400(r8).getSystemService("wifi");
            this.mWifiManager = r10;
            this.mSSID = r10.getConnectionInfo().getSSID();
            this.mBSSID = this.mWifiManager.getConnectionInfo().getBSSID();
            IntentFilter r11 = new IntentFilter();
            this.filter = r11;
            r11.addAction("android.net.wifi.STATE_CHANGE");
        }

        public static /* synthetic */ WifiManager access$1700(WifiRoamingMonitor r8) {
            return r8.mWifiManager;
        }

        public static /* synthetic */ String access$1800(WifiRoamingMonitor r8) {
            return r8.mBSSID;
        }

        public static /* synthetic */ String access$1802(WifiRoamingMonitor r8, String r10) {
            r8.mBSSID = r10;
            return r10;
        }

        public static /* synthetic */ String access$1900(WifiRoamingMonitor r8) {
            return r8.mSSID;
        }

        public void start() {
            CaeLog.d(NetworkMonitor.TAG, "start monitor wifi roaming detect.");
            NetworkMonitor.access$400(this.this$0).registerReceiver(this.mWifiRoamingReceiver, this.filter);
        }

        public void stop() {
            CaeLog.d(NetworkMonitor.TAG, "stop monitor wifi roaming detect.");
            NetworkMonitor.access$400(this.this$0).unregisterReceiver(this.mWifiRoamingReceiver);
        }
    }

    @SuppressLint({"NewApi"})
    public NetworkMonitor(Context r8, NetworkExecutor r10, int r11) {
        this.mNetworkType = -1;
        this.mLock = new Object();
        this.mLastOnceDetectionTime = 0;
        this.mLastDnsResolveTime = 0;
        this.mIsValidated = false;
        this.mScreenOn = false;
        this.mHasForeground = false;
        this.mIsGoodNetwork = true;
        this.mDetectScene = 0;
        this.mNetworkCallbackRegistered = false;
        this.mNetworkErrReportCb = new AnonymousClass1(this);
        this.mScreenBroadcastReceiver = new AnonymousClass4(this);
        this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).build();
        this.mNetworkCallback = new AnonymousClass5(this);
        this.mActivityMonitorListener = new AnonymousClass6(this);
        this.mContext = r8;
        this.mNetId = r11;
        this.mNetworkExecutor = r10;
        HandoverParameterManager r12 = HandoverParameterManager.getInstance(r8);
        this.mHandoverParameterManager = r12;
        this.mL4NetEvaluate = L4NetEvaluate.getInstance(r8);
        this.mDetectBackoff = r12.getBackoffDetectPeriod();
        this.mConnectivityManager = (ConnectivityManager) r8.getSystemService("connectivity");
        Network r13 = getNetworkForNetId(r11);
        this.mNetwork = r13;
        this.mHttpConnectionProbe = new HttpConnectionProbe(r13);
        this.mDnsResolverProbe = new DnsResolverProbe(r13);
        HandlerThread r14 = new HandlerThread("NetworkMonitorThread");
        this.mHandlerThread = r14;
        r14.start();
        this.mScheduleHandler = new ScheduleHandler(this, r14.getLooper());
        this.mActivityMonitor = ActivityMonitor.getInstance(r8);
        PowerManager r15 = (PowerManager) r8.getSystemService("power");
        this.mPowerManager = r15;
        this.mScreenOn = r15.isInteractive();
        IntentFilter r16 = new IntentFilter();
        this.mScreenFilter = r16;
        r16.addAction("android.intent.action.SCREEN_ON");
        r16.addAction("android.intent.action.SCREEN_OFF");
    }

    public static /* synthetic */ void access$000(NetworkMonitor r8) {
        r8.startOnceDetect();
    }

    public static /* synthetic */ void access$100(NetworkMonitor r8) {
        r8.startPeriodDetect();
    }

    public static /* synthetic */ int access$1000(NetworkMonitor r8) {
        return r8.mNetworkType;
    }

    public static /* synthetic */ NetworkInfoCollect.NetworkDetailInfo access$1100(NetworkMonitor r8) {
        return r8.getNetworkDetailInfo();
    }

    public static /* synthetic */ NetworkExecutor access$1200(NetworkMonitor r8) {
        return r8.mNetworkExecutor;
    }

    public static /* synthetic */ void access$1300(NetworkMonitor r8, boolean r10) {
        r8.handleScreenStateChanged(r10);
    }

    public static /* synthetic */ Network access$1400(NetworkMonitor r8) {
        return r8.mNetwork;
    }

    public static /* synthetic */ boolean access$1500(NetworkMonitor r8) {
        return r8.mIsValidated;
    }

    public static /* synthetic */ boolean access$1502(NetworkMonitor r8, boolean r10) {
        r8.mIsValidated = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1600(NetworkMonitor r8) {
        return r8.mHasForeground;
    }

    public static /* synthetic */ boolean access$1602(NetworkMonitor r8, boolean r10) {
        r8.mHasForeground = r10;
        return r10;
    }

    public static /* synthetic */ void access$200(NetworkMonitor r8, int r10) {
        r8.startBackoffDetect(r10);
    }

    public static /* synthetic */ boolean access$2000(NetworkMonitor r8) {
        return r8.mScreenOn;
    }

    public static /* synthetic */ ScheduleHandler access$2100(NetworkMonitor r8) {
        return r8.mScheduleHandler;
    }

    public static /* synthetic */ void access$300(NetworkMonitor r8) {
        r8.stopAllDetect();
    }

    public static /* synthetic */ Context access$400(NetworkMonitor r8) {
        return r8.mContext;
    }

    public static /* synthetic */ int access$500(NetworkMonitor r8) {
        return r8.mNetId;
    }

    public static /* synthetic */ boolean access$600(NetworkMonitor r8) {
        return r8.mIsGoodNetwork;
    }

    public static /* synthetic */ boolean access$602(NetworkMonitor r8, boolean r10) {
        r8.mIsGoodNetwork = r10;
        return r10;
    }

    public static /* synthetic */ void access$700(NetworkMonitor r8) {
        r8.mayTriggerNetworkDetect();
    }

    public static /* synthetic */ Object access$800(NetworkMonitor r8) {
        return r8.mLock;
    }

    public static /* synthetic */ int access$900(NetworkMonitor r8) {
        return r8.mDetectScene;
    }

    public static /* synthetic */ int access$902(NetworkMonitor r8, int r10) {
        r8.mDetectScene = r10;
        return r10;
    }

    private NetworkInfoCollect.NetworkDetailInfo getNetworkDetailInfo() {
        return NetworkInfoCollect.getInstance(this.mContext).getNetworkDetailInfo(this.mNetwork);
    }

    private Network getNetworkForNetId(int r8) {
        Network[] r10 = this.mConnectivityManager.getAllNetworks();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        Network r13 = r10[r12];
        if (r13.toString().equals(Integer.toString(r8)) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        NetworkInfo r14 = this.mConnectivityManager.getNetworkInfo(r13);
        if (r14 == null) goto L9;
        this.mNetworkType = r14.getType();
    L9:
        return r13;
    L11:
        CaeLog.e(TAG, "getNetworkForNetId failed.");
        return null;
    }

    private String getNetworkTypeString(int r8) {
        if (r8 != 0) goto L4;
        return "MOBILE";
    L4:
        if (r8 != 1) goto L6;
        return "WIFI";
    L6:
        if (r8 != 7) goto L8;
        return "BLUETOOTH";
    L8:
        if (r8 != 9) goto L10;
        return "ETHERNET";
    L10:
        if (r8 == 17) goto L13;
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L13:
        return "VPN";
    }

    private String getProbeUrl() {
        String r8 = Settings.Global.getString(this.mContext.getContentResolver(), CloudConfigParseAndSave.CAPTIVE_PORTAL_HTTP_URL);
        if (r8 != null) goto L5;
        return DEFAULT_PROBE_URL;
    L5:
        if (r8.isEmpty() == true) goto L10;
        return r8;
    L10:
        return DEFAULT_PROBE_URL;
    }

    private void handleScreenStateChanged(boolean r8) {
        this.mScreenOn = r8;
        CaeLog.d(TAG, "screen state changed. netId: " + this.mNetId + ", screenOn: " + r8);
        mayTriggerNetworkDetect();
    }

    private void mayTriggerNetworkDetect() {
        boolean r8 = this.mScreenOn;
        if (r8 == true) goto L5;
    L9:
        if (r8 == true) goto L11;
    L17:
        this.mScheduleHandler.sendEmptyMessage(3);
        return;
    L11:
        if (this.mIsValidated == true) goto L17;
        boolean r10 = this.mHasForeground;
        ScheduleHandler r11 = this.mScheduleHandler;
        if (r10 == false) goto L16;
        r11.sendEmptyMessage(1);
        return;
    L16:
        r11.sendMessage(r11.obtainMessage(2, 1, 0));
        return;
    L5:
        if (this.mIsValidated == false) goto L9;
        if (this.mIsGoodNetwork == true) goto L9;
        this.mDetectScene = 4;
        this.mScheduleHandler.sendEmptyMessage(0);
    }

    private void registerNetworkCallback() {
        if (this.mNetworkCallbackRegistered == false) goto L9;
        return;
    L9:
        this.mConnectivityManager.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback);     // Catch: ConnectivityManager.TooManyRequestsException -> L7
        this.mNetworkCallbackRegistered = true;     // Catch: ConnectivityManager.TooManyRequestsException -> L7
        return;
    L7:
        CaeLog.e(TAG, "registerNetworkCallback failed: network request quota exceeded.");
    }

    private void startBackoffDetect(int r8) {
        this.mScheduleHandler.removeCallbacksAndMessages(null);
        this.mDetectScene = 3;
        defpackage.a.j(new StringBuilder("Trigger backoff network validity detection. netId: "), this.mNetId, TAG);
        startDetectHttpAndDns(null);
        if (r8 != 0) goto L6;
        int r10 = Math.min(this.mDetectBackoff * 2, this.mHandoverParameterManager.getMaxDetectPeriod());
    L8:
        this.mDetectBackoff = r10;
    L9:
        StringBuilder r11 = new StringBuilder("The next network validity detection time is ");
        r11.append(this.mDetectBackoff);
        r11.append("ms. netId is ");
        defpackage.a.j(r11, this.mNetId, TAG);
        ScheduleHandler r12 = this.mScheduleHandler;
        r12.sendMessageDelayed(r12.obtainMessage(2, 0, 0), this.mDetectBackoff);
        return;
    L6:
        if (r8 != 1) goto L9;
        r10 = this.mHandoverParameterManager.getBackoffDetectPeriod();
        goto L8
    }

    private void startDetectHttpAndDns(final NetworkMonitorListener r8) {
        StringBuilder r10 = new StringBuilder("send http probe. netId: ");
        r10.append(this.mNetId);
        r10.append(", detectScene: ");
        r10.append(this.mDetectScene);
        r10.append(", type: ");
        b.p(r10, this.mNetworkType, TAG);
        this.mHttpConnectionProbe.executeHttpProbe(getProbeUrl(), new AnonymousClass3(this, r8));
    }

    private void startOnceDetect() {
        long r8 = System.currentTimeMillis();
        if ((r8 - this.mLastOnceDetectionTime) >= 20000) goto L6;
        CaeLog.d(TAG, "The last network validity detection time is " + (r8 - this.mLastOnceDetectionTime) + "ms, which is less than 20000ms.");
        return;
    L6:
        defpackage.a.j(new StringBuilder("Trigger a single network validity detection. netId is: "), this.mNetId, TAG);
        this.mLastOnceDetectionTime = r8;
        startDetectHttpAndDns(null);
    }

    private void startPeriodDetect() {
        this.mScheduleHandler.removeCallbacksAndMessages(null);
        this.mDetectScene = 3;
        StringBuilder r8 = new StringBuilder("Trigger periodic network validity detection, the period is: ");
        r8.append(this.mHandoverParameterManager.getCycleDetectPeriod());
        r8.append("ms. netId is ");
        defpackage.a.j(r8, this.mNetId, TAG);
        startDetectHttpAndDns(null);
        this.mScheduleHandler.sendEmptyMessageDelayed(1, this.mHandoverParameterManager.getCycleDetectPeriod());
    }

    private void stopAllDetect() {
        if (this.mScheduleHandler.hasMessages(0) == false) goto L5;
    L8:
        CaeLog.d(TAG, "Stop network validity detection.");
        this.mScheduleHandler.removeCallbacksAndMessages(null);
        return;
    L5:
        if (this.mScheduleHandler.hasMessages(1) == true) goto L8;
        if (this.mScheduleHandler.hasMessages(2) == true) goto L8;
    }

    private void unregisterNetworkCallback() {
        if (this.mNetworkCallbackRegistered == true) goto L5;
        return;
    L5:
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
        this.mNetworkCallbackRegistered = false;
    }

    public void executeDnsResolve() {
        long r8 = System.currentTimeMillis();
        if ((r8 - this.mLastDnsResolveTime) >= 10000) goto L5;
        return;
    L5:
        this.mLastDnsResolveTime = r8;
        StringBuilder r10 = new StringBuilder("send dns probe. netId: ");
        r10.append(this.mNetId);
        r10.append(", type: ");
        b.p(r10, this.mNetworkType, TAG);
        this.mDnsResolverProbe.executeDnsResolve(getProbeUrl(), new AnonymousClass2(this));
    }

    public void start() {
        if (this.mNetworkType != 1) goto L5;
        WifiRoamingMonitor r8 = new WifiRoamingMonitor(this);
        this.mWifiRoamingMonitor = r8;
        r8.start();
    L5:
        this.mActivityMonitor.registerActivityListener(this.mActivityMonitorListener);
        registerNetworkCallback();
        this.mContext.registerReceiver(this.mScreenBroadcastReceiver, this.mScreenFilter);
        this.mL4NetEvaluate.registerErrReportCb(this.mNetworkErrReportCb);
    }

    public void startOnceDetectExternal(NetworkMonitorListener r8, int r10) {
        this.mDetectScene = r10;
        startDetectHttpAndDns(r8);
    }

    public void stop() {
        this.mScheduleHandler.removeCallbacksAndMessages(null);
        if (this.mNetworkType != 1) goto L5;
        this.mWifiRoamingMonitor.stop();
    L5:
        this.mActivityMonitor.unregisterActivityListener(this.mActivityMonitorListener);
        unregisterNetworkCallback();
        this.mContext.unregisterReceiver(this.mScreenBroadcastReceiver);
        this.mHandlerThread.quitSafely();
        this.mL4NetEvaluate.unregisterErrReportCb(this.mNetworkErrReportCb);
    }
}
