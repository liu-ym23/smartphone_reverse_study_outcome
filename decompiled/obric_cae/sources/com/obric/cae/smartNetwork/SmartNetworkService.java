package com.obric.cae.smartNetwork;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.obric.cae.R;
import com.obric.cae.libs.l4NetStatus.IQoeStatusListener;
import com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager;
import com.obric.cae.libs.network.ICaeNetworkHandoverListener;
import com.obric.cae.libs.network.ICaeNetworkHandoverManager;
import com.obric.cae.libs.wifi.ICaeSmartNetworkManager;
import com.obric.cae.libs.wifi.ICaeWifiAdapter;
import com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener;
import com.obric.cae.libs.wifi.ISecondaryWifiCallback;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.fastReconnect.WifiFastReconnectManager;
import com.obric.cae.smartNetwork.iplocateCountrycode.IplocateCountryCode;
import com.obric.cae.smartNetwork.mpflow.MpflowManager;
import com.obric.cae.smartNetwork.multipath.MultiPathManager;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import com.obric.cae.smartNetwork.netAccel.AccelManager;
import com.obric.cae.smartNetwork.netPolicy.NetPolicyMetric;
import com.obric.cae.smartNetwork.networkHandover.NetworkHandoverManager;
import com.obric.cae.smartNetwork.networkRtt.NetworkRttService;
import com.obric.cae.smartNetwork.qoe.NetworkQoEMonitor;
import com.obric.cae.smartNetwork.secondaryWifi.SecondaryWifiManager;
import com.obric.cae.smartNetwork.throughtput.InternalThroughputListener;
import com.obric.cae.smartNetwork.throughtput.ThroughputCalculation;
import com.obric.cae.smartNetwork.trafficMonitor.MobileTrafficMonitor;
import com.obric.cae.userAware.UserAwareService;
import com.obric.cae.utils.CaeUtil;
import g0.d;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class SmartNetworkService extends Service {
    public static final String BOOT_COMPLETED_EXTRA = "boot_completed";
    private static final String DEFAULT_CAPTIVE_PORTAL_GLOBAL_HTTPS_URLS = "https://connectivitycheck-global.picovr.com/generate_204";
    private static final String DEFAULT_CAPTIVE_PORTAL_GLOBAL_HTTP_URLS = "http://connectivitycheck-global.picovr.com/generate_204";
    private static final String DEFAULT_CAPTIVE_PORTAL_HTTPS_URLS = "https://connectivitycheck.oceancloudapi.com/generate204";
    private static final String DEFAULT_CAPTIVE_PORTAL_HTTP_URLS = "http://connectivitycheck.oceancloudapi.com/generate204";
    public static final int FROM_BOOT_COMPLETED = 1;
    private static final int MCC_CHINESE = 460;
    private static final int MCC_UNKNOW = -1;
    private static final String SERVICE_NAME = "cae_wifi";
    private static final String SERVICE_NAME_CAE_WIFI_ADAPTER = "cae_wifi_adapter";
    private static final String SERVICE_NAME_NETWORK_HANDOVER = "cae_handover";
    private static final String SERVICE_NAME_NETWORK_RTT = "cae_network_rtt";
    private static final String SERVICE_NAME_QOE_REPORT = "cae_qoe_report";
    private static final String TAG = "SmartNetworkService";
    public static final int UNKNOW_BOOT_COMPLETED = -1;
    private CaeSmartNetworkService mCaeSmartNetworkService;
    private CaeWifiAdapterService mCaeWifiAdapter;
    private CloudBinder mCloudBinder;
    private CloudConfigParseAndSave mCloudConfigParseAndSave;
    private Context mContext;
    private ContentObserver mDeviceProvisionedObserver;
    private WifiFastReconnectManager mFastReconnectManager;
    private NetworkHandoverManager mFusionHandoverManager;
    private Set<InternalThroughputListener> mInternalThroughputListener;
    private IplocateCountryCode mIplocateCountryCode;
    private L4NetEvaluate mL4NetEvaluate;
    private SmartNetworkPolicyManager mLowLatencyNetworkPolicyManager;
    private Messenger mMessenger;
    private MobileTrafficMonitor mMobileTrafficMonitor;
    private MultiPathManager mMultiPathManager;
    private NefidInterface mNefidInterface;
    private NetworkHandoverService mNetworkHandoverService;
    private NetworkQoEMonitor mNetworkQoEMonitor;
    private PoorLinkDisconnectPolicy mPoorLinkDisconnectPolicy;
    private boolean mProvisionedObserverRegistered;
    private QoeReportService mQoeReportService;
    private final RemoteCallbackList<IQoeStatusListener> mQoeStatusListeners;
    private final RemoteCallbackList<ICaeWifiLinkThroughputListener> mRegisteredWifiListeners;
    private ContentResolver mResolver;
    private SecondaryWifiManager mSecondaryWifiManager;
    private TelephonyManager mTelephonyManager;
    private ThroughputCalculation mThroughputCalculation;

    public class CaeSmartNetworkService extends ICaeSmartNetworkManager.Stub {
        final /* synthetic */ SmartNetworkService this$0;

        public CaeSmartNetworkService(SmartNetworkService r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public String getCurrentSecondarySsid() {
            SmartNetworkService.access$900(this.this$0);
            String r8 = SmartNetworkService.access$1000(this.this$0).getCurrentSecondarySsid();
            defpackage.b.o("getCurrentSecondarySsid called. Result: ", r8, SmartNetworkService.access$200());
            return r8;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public int getLinkThroughput() {
            return SmartNetworkService.access$800(this.this$0).getThroughput();
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public int getLinkThroughputJitter() {
            return SmartNetworkService.access$800(this.this$0).getThroughputJitter();
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public float getLinkThroughputJitterWeight() {
            return SmartNetworkService.access$800(this.this$0).getThroughputJitterWeight();
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public List<ScanResult> getSecondaryWifiList() {
            SmartNetworkService.access$900(this.this$0);
            return SmartNetworkService.access$1000(this.this$0).getSecondaryWifiList();
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r8) {
            SmartNetworkService.access$700(this.this$0).register(r8);
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void registerSecondaryWifiListener(ISecondaryWifiCallback r8) {
            SmartNetworkService.access$900(this.this$0);
            SmartNetworkService.access$1000(this.this$0).registerSecondaryWifiListener(r8);
            CaeLog.d(SmartNetworkService.access$200(), "registerSecondaryWifiListener called.");
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void releaseAll() {
            SmartNetworkService.access$900(this.this$0);
            CaeLog.d(SmartNetworkService.access$200(), "releaseAll called.");
            SmartNetworkService.access$1000(this.this$0).releaseAll();
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void releaseSecondaryWifi(ISecondaryWifiCallback r8) {
            SmartNetworkService.access$900(this.this$0);
            CaeLog.d(SmartNetworkService.access$200(), "releaseSecondaryWifi called. ");
            SmartNetworkService.access$1000(this.this$0).releaseSecondaryWifi(r8);
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void requestSecondaryWifi(String r8, String r10, String r11, String r12, ISecondaryWifiCallback r13) {
            SmartNetworkService.access$900(this.this$0);
            defpackage.b.o("requestSecondaryWifi called. SSID = ", r10, SmartNetworkService.access$200());
            SmartNetworkService.access$1000(this.this$0).requestSecondaryWifi(r8, r10, r11, r12, r13);
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r8) {
            SmartNetworkService.access$700(this.this$0).unregister(r8);
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void unregisterSecondaryWifiListener(ISecondaryWifiCallback r8) {
            SmartNetworkService.access$900(this.this$0);
            SmartNetworkService.access$1000(this.this$0).unregisterSecondaryWifiListener(r8);
            CaeLog.d(SmartNetworkService.access$200(), "unregisterSecondaryWifiListener called.");
        }
    }

    public class CaeWifiAdapterService extends ICaeWifiAdapter.Stub {
        final /* synthetic */ SmartNetworkService this$0;

        public CaeWifiAdapterService(SmartNetworkService r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
        public int getRoamRssiThreshold(int r8) {
            defpackage.b.m("getRoamRssiThreshold called. ifaceIndex = ", r8, SmartNetworkService.access$200());
            return SmartNetworkService.access$1400(this.this$0).getRoamRssiThreshold(r8);
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
        public boolean setLatencyLevel(int r8, int r10) {
            CaeLog.d(SmartNetworkService.access$200(), "setLatencyLevel called. ifaceIndex = " + r8 + ", latencyLevel = " + r10);
            return SmartNetworkService.access$1400(this.this$0).setLatencyLevel(r8, r10);
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
        public boolean setRoamRssiThreshold(int r8, int r10) {
            CaeLog.d(SmartNetworkService.access$200(), "setRoamRssiThreshold called. ifaceIndex = " + r8 + ", rssiThreshold = " + r10);
            return SmartNetworkService.access$1400(this.this$0).setRoamRssiThreshold(r8, r10);
        }
    }

    public class NetworkHandoverService extends ICaeNetworkHandoverManager.Stub {
        final /* synthetic */ SmartNetworkService this$0;

        public NetworkHandoverService(SmartNetworkService r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.libs.network.ICaeNetworkHandoverManager
        public void registerNetworkHandoverListener(ICaeNetworkHandoverListener r8) {
            if (SmartNetworkService.access$1300(this.this$0) != null) goto L6;
            CaeLog.e(SmartNetworkService.access$200(), "registerNetworkHandoverListener: mFusionHandoverManager is not initialized yet");
            return;
        L6:
            SmartNetworkService.access$1300(this.this$0).registerNetworkHandoverListener(r8);
        }

        @Override // com.obric.cae.libs.network.ICaeNetworkHandoverManager
        public void unregisterNetworkHandoverListener(ICaeNetworkHandoverListener r8) {
            if (SmartNetworkService.access$1300(this.this$0) != null) goto L6;
            CaeLog.e(SmartNetworkService.access$200(), "unregisterNetworkHandoverListener: mFusionHandoverManager is not initialized yet");
            return;
        L6:
            SmartNetworkService.access$1300(this.this$0).unregisterNetworkHandoverListener(r8);
        }
    }

    public class QoeReportService extends IQoeStatusReportManager.Stub {
        final /* synthetic */ SmartNetworkService this$0;

        public QoeReportService(SmartNetworkService r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
        public boolean registerQoeStatusListener(String r8, IQoeStatusListener r10) {
            SmartNetworkService.access$1100(this.this$0);
            if (SmartNetworkService.access$1200(this.this$0) != null) goto L5;
            CaeLog.w(SmartNetworkService.access$200(), "registerQoeStatusListener failed: mL4NetEvaluate is null");
            return false;
        L5:
            return SmartNetworkService.access$1200(this.this$0).registerQoeStatusListener(r10);
        }

        @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
        public boolean unregisterQoeStatusListener(String r8, IQoeStatusListener r10) {
            SmartNetworkService.access$1100(this.this$0);
            if (SmartNetworkService.access$1200(this.this$0) != null) goto L5;
            CaeLog.w(SmartNetworkService.access$200(), "unregisterQoeStatusListener failed: mL4NetEvaluate is null");
            return false;
        L5:
            return SmartNetworkService.access$1200(this.this$0).unregisterQoeStatusListener(r10);
        }
    }

    public class SimStateReceiver extends BroadcastReceiver {
        final /* synthetic */ SmartNetworkService this$0;

        public SimStateReceiver(SmartNetworkService r8) {
            this.this$0 = r8;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            String r11 = r10.getAction();
            if ("android.intent.action.BOOT_COMPLETED".equals(r11) == true) goto L7;
            if ("android.intent.action.SIM_STATE_CHANGED".equals(r11) == true) goto L7;
            return;
        L7:
            if (SmartNetworkService.access$000(this.this$0) == false) goto L11;
            int r12 = SmartNetworkService.access$100(this.this$0);
            defpackage.a.i("(BOOT_COMPLETED || ACTION_SIM_CARD_STATE_CHANGED) && provisioned=1, mcc:", r12, SmartNetworkService.access$200());
            if (SmartNetworkService.access$400(SmartNetworkService.access$300(this.this$0)) == true) goto L14;
            SmartNetworkService.access$500(this.this$0, r12);
            return;
        L14:
            return;
        L11:
            CaeLog.i(SmartNetworkService.access$200(), "BOOT_COMPLETED & provisioned=0, start observing...");
            SmartNetworkService.access$600(this.this$0);
        }
    }

    public SmartNetworkService() {
        this.mRegisteredWifiListeners = new RemoteCallbackList();
        this.mQoeStatusListeners = new RemoteCallbackList();
        this.mInternalThroughputListener = new CopyOnWriteArraySet();
        this.mProvisionedObserverRegistered = false;
    }

    public static /* synthetic */ int a(Map.Entry r8, Map.Entry r10) {
        return lambda$getLocationMcc$1(r8, r10);
    }

    public static /* synthetic */ boolean access$000(SmartNetworkService r8) {
        return r8.isDeviceProvisioned();
    }

    public static /* synthetic */ int access$100(SmartNetworkService r8) {
        return r8.getMcc();
    }

    public static /* synthetic */ SecondaryWifiManager access$1000(SmartNetworkService r8) {
        return r8.mSecondaryWifiManager;
    }

    public static /* synthetic */ void access$1100(SmartNetworkService r8) {
        r8.enforcePhoneUid();
    }

    public static /* synthetic */ L4NetEvaluate access$1200(SmartNetworkService r8) {
        return r8.mL4NetEvaluate;
    }

    public static /* synthetic */ NetworkHandoverManager access$1300(SmartNetworkService r8) {
        return r8.mFusionHandoverManager;
    }

    public static /* synthetic */ NefidInterface access$1400(SmartNetworkService r8) {
        return r8.mNefidInterface;
    }

    public static /* synthetic */ PoorLinkDisconnectPolicy access$1500(SmartNetworkService r8) {
        return r8.mPoorLinkDisconnectPolicy;
    }

    public static /* synthetic */ Set access$1600(SmartNetworkService r8) {
        return r8.mInternalThroughputListener;
    }

    public static /* synthetic */ void access$1700(SmartNetworkService r8, Bundle r10) {
        r8.sendMessageConnectionInfo(r10);
    }

    public static /* synthetic */ void access$1800(SmartNetworkService r8, int r10) {
        r8.sendMessageConnectionState(r10);
    }

    public static /* synthetic */ ContentResolver access$1900(SmartNetworkService r8) {
        return r8.mResolver;
    }

    public static /* synthetic */ String access$200() {
        return TAG;
    }

    public static /* synthetic */ void access$2000(SmartNetworkService r8) {
        r8.stopWatchingDeviceProvisioned();
    }

    public static /* synthetic */ Context access$300(SmartNetworkService r8) {
        return r8.mContext;
    }

    public static /* synthetic */ boolean access$400(Context r8) {
        return isWifionlyProduct(r8);
    }

    public static /* synthetic */ boolean access$500(SmartNetworkService r8, int r10) {
        return r8.setCaptivePortalUrl(r10);
    }

    public static /* synthetic */ void access$600(SmartNetworkService r8) {
        r8.startWatchingDeviceProvisioned();
    }

    public static /* synthetic */ RemoteCallbackList access$700(SmartNetworkService r8) {
        return r8.mRegisteredWifiListeners;
    }

    public static /* synthetic */ ThroughputCalculation access$800(SmartNetworkService r8) {
        return r8.mThroughputCalculation;
    }

    public static /* synthetic */ void access$900(SmartNetworkService r8) {
        r8.enforceSystemUid();
    }

    public static /* synthetic */ void b(SmartNetworkService r8) {
        r8.lambda$onCreate$0();
    }

    private void disablePrivateDnsMode() {
        Settings.Global.putString(this.mResolver, "private_dns_default_mode", "off");
    }

    private void enforcePhoneUid() {
        int r8 = Binder.getCallingUid();
        int r10 = Binder.getCallingPid();
        if (r8 != 1001) goto L5;
        return;
    L5:
        if (CaeUtil.isPrivileged(this.mContext, r10, r8) == false) goto L7;
        return;
    L7:
        if (r8 != 1027) goto L10;
        return;
    L10:
        throw new SecurityException("Only phone allowed");
    }

    private void enforceSystemUid() {
        int r8 = Binder.getCallingUid();
        int r10 = Binder.getCallingPid();
        if (r8 != 1000) goto L5;
        return;
    L5:
        if (CaeUtil.isPrivileged(this.mContext, r10, r8) == false) goto L7;
        return;
    L7:
        if (r8 != 1027) goto L10;
        return;
    L10:
        throw new SecurityException("Only system allowed");
    }

    private int getMcc() {
        String r8 = getLocationMcc();
        if (TextUtils.isEmpty(r8) == true) goto L6;
        CaeLog.i(TAG, "Return location mcc: " + r8);
        return Integer.parseInt(r8);
    L6:
        List<SubscriptionInfo> r10 = SubscriptionManager.from(this.mContext).getActiveSubscriptionInfoList();
        if (r10 != null) goto L9;
        return -1;
    L9:
        Iterator<SubscriptionInfo> r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L16;
        String r12 = ((TelephonyManager) this.mContext.getSystemService("phone")).createForSubscriptionId(r11.next().getSubscriptionId()).getNetworkOperator();
        if (TextUtils.isEmpty(r12) == true) goto L11;
        int r13 = Integer.parseInt(r12.substring(0, 3));
        defpackage.a.i("return MccMncOverrideInfo mcc=", r13, TAG);
        return r13;
    L16:
        return -1;
    }

    private String getMccFromCellInfo(CellInfo r8) {
        if ((r8 instanceof CellInfoGsm) == false) goto L7;
        return ((CellInfoGsm) r8).getCellIdentity().getMccString();
    L7:
        if ((r8 instanceof CellInfoLte) == false) goto L11;
        return ((CellInfoLte) r8).getCellIdentity().getMccString();
    L11:
        if ((r8 instanceof CellInfoWcdma) == false) goto L15;
        return ((CellInfoWcdma) r8).getCellIdentity().getMccString();
    L15:
        if ((r8 instanceof CellInfoTdscdma) == false) goto L19;
        return ((CellInfoTdscdma) r8).getCellIdentity().getMccString();
    L19:
        if ((r8 instanceof CellInfoNr) == true) goto L21;
        return null;
    L21:
        return ((CellIdentityNr) ((CellInfoNr) r8).getCellIdentity()).getMccString();
    }

    private boolean isDeviceProvisioned() {
        if (Settings.Global.getInt(this.mResolver, "device_provisioned", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private static boolean isFastReconnectSupported(Context r8) {
        return r8.getResources().getBoolean(R.bool.cae_supported_wifi_fast_reconnect);
    }

    private static boolean isIplocateCountryCodeSupported(Context r8) {
        return r8.getResources().getBoolean(R.bool.cae_supported_iplocate_countrycode);
    }

    private static boolean isMpflowSupported(Context r8) {
        return r8.getResources().getBoolean(R.bool.cae_supported_mpflow);
    }

    private static boolean isMultiPathSupported(Context r8) {
        return r8.getResources().getBoolean(R.bool.cae_supported_multipath);
    }

    private static boolean isNetAccelSupported(Context r8) {
        return r8.getResources().getBoolean(R.bool.cae_supported_net_accel);
    }

    private static boolean isNetPolicySupported(Context r8) {
        return r8.getResources().getBoolean(R.bool.cae_supported_net_policy);
    }

    private static boolean isNetworkHandoverSupported(Context r8) {
        return r8.getResources().getBoolean(R.bool.cae_supported_network_handover);
    }

    private static boolean isNetworkRttSupported(Context r8) {
        return r8.getResources().getBoolean(R.bool.cae_supported_network_rtt);
    }

    private static boolean isQoeReportSupported(Context r8) {
        return r8.getResources().getBoolean(R.bool.cae_supported_qoe_report);
    }

    private static boolean isTrafficMonitorSupported(Context r8) {
        return r8.getResources().getBoolean(R.bool.cae_supported_traffic_monitor);
    }

    private static boolean isWifiAdapterSupported(Context r8) {
        return r8.getResources().getBoolean(R.bool.cae_supported_wifi_adapter);
    }

    private static boolean isWifionlyProduct(Context r8) {
        return r8.getResources().getBoolean(R.bool.cae_wifionly_product);
    }

    private static /* synthetic */ int lambda$getLocationMcc$1(Map.Entry r8, Map.Entry r10) {
        return ((Integer) r8.getValue()).compareTo((Integer) r10.getValue());
    }

    private /* synthetic */ void lambda$onCreate$0() {
        long r8 = SystemClock.elapsedRealtime();
        Process.setThreadPriority(0);
        this.mLowLatencyNetworkPolicyManager = new SmartNetworkPolicyManager(this.mContext);
        startFastReconnectService();
        if (CaeUtil.isNonEeaAbroad() == true) goto L5;
        CaeLog.i(TAG, "Non Eea Abroad, disable private dns mode.");
        disablePrivateDnsMode();
    L5:
        NetworkQoEMonitor r10 = new NetworkQoEMonitor(this.mContext, this);
        this.mNetworkQoEMonitor = r10;
        r10.start();
        if (isMultiPathSupported(this.mContext) == false) goto L9;
        CaeLog.d(TAG, "start up multipath feature.");
        MultiPathManager r11 = MultiPathManager.getInstance();
        this.mMultiPathManager = r11;
        r11.init(this.mContext, this.mNetworkQoEMonitor);
    L9:
        if (isQoeReportSupported(this.mContext) == false) goto L11;
        CaeLog.d(TAG, "start up qoe report feature.");
        this.mQoeReportService = new QoeReportService(this);
    L11:
        String r12 = TAG;
        CaeLog.d(r12, "L4NetEvaluate will always start");
        L4NetEvaluate r13 = L4NetEvaluate.getInstance(this.mContext);
        this.mL4NetEvaluate = r13;
        r13.start();
        this.mL4NetEvaluate.setNetworkQoEMonitor(this.mNetworkQoEMonitor);
        if (isNetworkHandoverSupported(this.mContext) == false) goto L15;
        CaeLog.i(r12, "start up network handover feature.");
        this.mFusionHandoverManager = NetworkHandoverManager.getInstance(this.mContext, this.mNetworkQoEMonitor);
        NetworkHandoverService r14 = new NetworkHandoverService(this);
        this.mNetworkHandoverService = r14;
        ServiceManager.addService(SERVICE_NAME_NETWORK_HANDOVER, r14);
    L15:
        if (isTrafficMonitorSupported(this.mContext) == false) goto L18;
        this.mMobileTrafficMonitor = new MobileTrafficMonitor(this.mContext);
    L18:
        if (isMpflowSupported(this.mContext) == false) goto L21;
        new MpflowManager(this.mContext);
    L21:
        if (isIplocateCountryCodeSupported(this.mContext) == false) goto L24;
        IplocateCountryCode r15 = new IplocateCountryCode(this.mContext);
        this.mIplocateCountryCode = r15;
        r15.register();
    L24:
        if (isNetAccelSupported(this.mContext) == false) goto L27;
        AccelManager.getInstance(this.mContext, this);
    L27:
        if (isNetPolicySupported(this.mContext) == false) goto L29;
        CaeLog.d(r12, "start up net policy feature.");
        NetPolicyMetric.make(this.mContext);
    L29:
        CaeLog.i(r12, "SmartNetInitThread execution time: " + (SystemClock.elapsedRealtime() - r8) + " ms");
    }

    private void saveUrlForCaptivePortal(String r8, String r10, String r11, String r12) {
        if (TextUtils.isEmpty(r8) == true) goto L5;
        Settings.Global.putString(this.mContext.getContentResolver(), CloudConfigParseAndSave.CAPTIVE_PORTAL_HTTP_URL, r8);
    L6:
        boolean r13 = TextUtils.isEmpty(r10);
        ContentResolver r14 = this.mContext.getContentResolver();
        if (r13 == true) goto L9;
        Settings.Global.putString(r14, CloudConfigParseAndSave.CAPTIVE_PORTAL_HTTPS_URL, r10);
        return;
    L9:
        Settings.Global.putString(r14, CloudConfigParseAndSave.CAPTIVE_PORTAL_HTTPS_URL, r12);
        return;
    L5:
        Settings.Global.putString(this.mContext.getContentResolver(), CloudConfigParseAndSave.CAPTIVE_PORTAL_HTTP_URL, r11);
        goto L6
    }

    private void sendMessageConnectionInfo(Bundle r8) {
        if (this.mMessenger != null) goto L10;
        return;
    L10:
        Message r10 = Message.obtain(null, 1);     // Catch: RemoteException -> L7
        r10.setData(r8);     // Catch: RemoteException -> L7
        this.mMessenger.send(r10);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    private void sendMessageConnectionState(int r8) {
        if (this.mMessenger != null) goto L10;
        return;
    L10:
        Message r10 = Message.obtain(null, 3);     // Catch: RemoteException -> L7
        r10.arg1 = r8;     // Catch: RemoteException -> L7
        this.mMessenger.send(r10);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    private boolean setCaptivePortalUrl(int r8) {
        if (isWifionlyProduct(this.mContext) == false) goto L6;
        boolean r10 = CaeUtil.isOverseaRomVersion();
    L11:
        if (r10 == false) goto L13;
        String r11 = Settings.Global.getString(this.mContext.getContentResolver(), CloudConfigParseAndSave.CAPTIVE_PORTAL_GLOBAL_HTTP_URL);
        String r12 = Settings.Global.getString(this.mContext.getContentResolver(), CloudConfigParseAndSave.CAPTIVE_PORTAL_GLOBAL_HTTPS_URL);
        String r13 = DEFAULT_CAPTIVE_PORTAL_GLOBAL_HTTP_URLS;
        String r14 = DEFAULT_CAPTIVE_PORTAL_GLOBAL_HTTPS_URLS;
    L14:
        saveUrlForCaptivePortal(r11, r12, r13, r14);
        return true;
    L13:
        r11 = Settings.Global.getString(this.mContext.getContentResolver(), CloudConfigParseAndSave.CAPTIVE_PORTAL_CN_HTTP_URL);
        r12 = Settings.Global.getString(this.mContext.getContentResolver(), CloudConfigParseAndSave.CAPTIVE_PORTAL_CN_HTTPS_URL);
        r13 = DEFAULT_CAPTIVE_PORTAL_HTTP_URLS;
        r14 = DEFAULT_CAPTIVE_PORTAL_HTTPS_URLS;
        goto L14
    L6:
        if (r8 != MCC_CHINESE) goto L8;
    L10:
        r10 = false;
        goto L11
    L8:
        if (r8 == (-1)) goto L10;
        r10 = true;
        goto L11
    }

    private void startFastReconnectService() {
        if (isFastReconnectSupported(this.mContext) == false) goto L6;
        CaeLog.d(TAG, "start Wi-Fi fast reconnect service.");
        this.mFastReconnectManager = WifiFastReconnectManager.getInstance(this.mContext);
        return;
    }

    private void startWatchingDeviceProvisioned() {
        if (this.mProvisionedObserverRegistered == false) goto L5;
        return;
    L5:
        Uri r8 = Settings.Global.getUriFor("device_provisioned");
        if (r8 == null) goto L9;
        this.mResolver.registerContentObserver(r8, false, this.mDeviceProvisionedObserver);
        this.mProvisionedObserverRegistered = true;
        CaeLog.i(TAG, "Start watching DEVICE_PROVISIONED...");
        return;
    }

    private void stopWatchingDeviceProvisioned() {
        if (this.mProvisionedObserverRegistered == true) goto L5;
        return;
    L5:
        this.mResolver.unregisterContentObserver(this.mDeviceProvisionedObserver);
        this.mProvisionedObserverRegistered = false;
        CaeLog.i(TAG, "Stop watching DEVICE_PROVISIONED.");
    }

    public String getLocationMcc() {
        List<CellInfo> r8 = this.mTelephonyManager.getAllCellInfo();
        if (r8 != null) goto L6;
        CaeLog.i(TAG, "CellInfo is null");
        return null;
    L6:
        HashMap r10 = new HashMap();
        Iterator<CellInfo> r11 = r8.iterator();
    L8:
        if (r11.hasNext() == false) goto L13;
        String r12 = getMccFromCellInfo(r11.next());
        if (r12 == null) goto L8;
        r10.put(r12, Integer.valueOf(((Integer) r10.getOrDefault(r12, 0)).intValue() + 1));
        goto L8
    L13:
        if (r10.size() > 0) goto L16;
        return null;
    L16:
        return (String) ((Map.Entry) Collections.max(r10.entrySet(), new d(2))).getKey();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r8) {
        CaeLog.d(TAG, "onBind");
        return this.mCaeSmartNetworkService;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.mContext = this;
        this.mResolver = getContentResolver();
        this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        IntentFilter r8 = defpackage.a.c("android.intent.action.SIM_STATE_CHANGED", "android.intent.action.BOOT_COMPLETED");
        registerReceiver(new SimStateReceiver(this), r8);
        CaeLog.e(TAG, "onCreate new CloudConfigParseAndSave");
        CloudConfigParseAndSave r10 = new CloudConfigParseAndSave(this.mContext, this);
        this.mCloudConfigParseAndSave = r10;
        this.mCloudBinder = new CloudBinder(this.mContext, r10);
        this.mPoorLinkDisconnectPolicy = new PoorLinkDisconnectPolicy(this.mContext);
        this.mThroughputCalculation = new ThroughputCalculation(this.mContext, new AnonymousClass1(this));
        this.mCaeSmartNetworkService = new CaeSmartNetworkService(this);
        this.mSecondaryWifiManager = new SecondaryWifiManager(this.mContext);
        if (isWifiAdapterSupported(this.mContext) == false) goto L5;
        this.mNefidInterface = NefidInterface.getInstance(this.mContext);
        this.mCaeWifiAdapter = new CaeWifiAdapterService(this);
    L5:
        final Handler r11 = new Handler(Looper.getMainLooper());
        this.mDeviceProvisionedObserver = new AnonymousClass2(this, r11);
        new Thread(new b(this, 1), "SmartNetInitThread").start();
    }

    @Override // android.app.Service
    public void onDestroy() {
        stopWatchingDeviceProvisioned();
        PoorLinkDisconnectPolicy r8 = this.mPoorLinkDisconnectPolicy;
        if (r8 == null) goto L6;
        r8.release();
    L6:
        if (isIplocateCountryCodeSupported(this.mContext) == false) goto L10;
        IplocateCountryCode r10 = this.mIplocateCountryCode;
        if (r10 == null) goto L10;
        r10.unregister();
    L10:
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r8, int r10, int r11) {
        String r12 = TAG;
        CaeLog.d(r12, "onStartCommand");
        if (r8 != null) goto L5;
    L16:
        ServiceManager.addService(SERVICE_NAME, this.mCaeSmartNetworkService);
        if (isWifiAdapterSupported(this.mContext) == false) goto L20;
        CaeLog.d(r12, "add wifi adapter binder service.");
        ServiceManager.addService(SERVICE_NAME_CAE_WIFI_ADAPTER, this.mCaeWifiAdapter);
    L20:
        if (isQoeReportSupported(this.mContext) == false) goto L23;
        CaeLog.d(r12, "add qoe report binder service.");
        ServiceManager.addService(SERVICE_NAME_QOE_REPORT, new QoeReportService(this));
    L23:
        if (isNetworkRttSupported(this.mContext) == false) goto L26;
        CaeLog.d(r12, "add network rtt binder service.");
        ServiceManager.addService(SERVICE_NAME_NETWORK_RTT, new NetworkRttService(this.mContext, this.mL4NetEvaluate));
    L26:
        return super.onStartCommand(r8, r10, r11);
    L5:
        if (r8.getIntExtra(BOOT_COMPLETED_EXTRA, -1) == 1) goto L7;
        Messenger r13 = (Messenger) r8.getParcelableExtra(UserAwareService.INTENT_EXTRA_OBJECT_MESSENGER);
        if (r13 == null) goto L15;
        this.mMessenger = r13;
    L15:
        CaeLog.i(r12, "received UserAwareService messenger :" + this.mMessenger);
        goto L16
    L7:
        if (isDeviceProvisioned() == false) goto L11;
        int r14 = getMcc();
        defpackage.a.i("onStartCommand BOOT flag & provisioned=1, mcc:", r14, r12);
        if (isWifionlyProduct(this.mContext) == true) goto L16;
        setCaptivePortalUrl(r14);
        goto L16
    L11:
        CaeLog.i(r12, "onStartCommand BOOT flag & provisioned=0, start observing...");
        startWatchingDeviceProvisioned();
        goto L16
    }

    public void registerInternalThroughputListener(InternalThroughputListener r8) {
        if (r8 == null) goto L5;
        this.mInternalThroughputListener.add(r8);
        return;
    }

    public void unregisterInternalThroughputListener(InternalThroughputListener r8) {
        if (r8 == null) goto L5;
        this.mInternalThroughputListener.remove(r8);
        return;
    }

    public void updateThroughputJitterPredictionFormula(String r8) {
        this.mThroughputCalculation.updateThroughputJitterSegmentConfigs(r8);
    }

    public void updateThroughputJitterWeightProportion(float r8) {
        this.mThroughputCalculation.updateThroughputJitterWeightProportion(r8);
    }

    public void updateThroughputPredictionFormula(String r8) {
        this.mThroughputCalculation.updateThroughputFormulaConfigs(r8);
    }

    public void updateThroughputPredictionFormula2(String r8) {
        this.mThroughputCalculation.updateThroughputFormulaConfigs2(r8);
    }

    public void updateUrl() {
        if (isDeviceProvisioned() == true) goto L5;
        return;
    L5:
        int r8 = getMcc();
        defpackage.a.i("updateUrl, get mcc:", r8, TAG);
        setCaptivePortalUrl(r8);
    }
}
