package com.obric.cae.smartNetwork.netOpt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.TransportInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.NetworkAccelerate.VipStrategyReport;
import com.obric.cae.smartNetwork.qoe.CellularQoECallback;
import com.obric.cae.smartNetwork.qoe.CellularQoEParam;
import com.obric.cae.smartNetwork.qoe.CellularQoeEvaluateStats;
import com.obric.cae.smartNetwork.qoe.NetworkQoEMonitor;
import com.obric.cae.smartNetwork.qoe.WiFiQoECallback;
import com.obric.cae.smartNetwork.qoe.WiFiQoEParam;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkTruthManager {
    private static final String SLEEP_MODE = "sleepmode";
    private static final String SLEEP_MODE_CHANGED = "com.bytedanceos.action.SLEEP_MODE_CHANGED";
    private static final String TAG = "NetworkTruthManager";
    private static volatile NetworkTruthManager sInstance;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private Network mDefaultNetwork;
    private final ConnectivityManager.NetworkCallback mDefaultNetworkCallback;
    private final Handler mHandler;
    private final L4NetEvaluate mL4NetEvaluate;
    private final ConnectivityManager.NetworkCallback mNetworkCallback;
    private final L4NetEvaluate.L4NetErrReportCb mNetworkErrReportCb;
    private final NetworkQoEMonitor mNetworkQoEMonitor;
    private NetworkTruth mNetworkTruth;
    private final PowerManager mPowerManager;
    private final BroadcastReceiver mPowerReceiver;
    private final BroadcastReceiver mScreenReceiver;
    private final BroadcastReceiver mSleepModeReceiver;
    private final Watcher mWatcher;

    public class Watcher implements CellularQoECallback, WiFiQoECallback {
        final /* synthetic */ NetworkTruthManager this$0;

        private Watcher(NetworkTruthManager r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.smartNetwork.qoe.CellularQoECallback
        public void onCellularL2EvaluateReport(CellularQoeEvaluateStats r8) {
            NetworkTruth.CellularQoE r10 = new NetworkTruth.CellularQoE();
            r10.setSlotId(r8.slotId).setErrBitMap(r8.errBitMap).setTimestamp(System.currentTimeMillis());
            NetworkTruthManager.access$100(this.this$0).enqueueCellularQoE(r10);
        }

        @Override // com.obric.cae.smartNetwork.qoe.CellularQoECallback
        public void onCellularQoEParamUpdate(CellularQoEParam r8) {
        }

        @Override // com.obric.cae.smartNetwork.qoe.WiFiQoECallback
        public void onWiFiQoEParamUpdate(WiFiQoEParam r8) {
            NetworkTruth.WifiQoE r10 = new NetworkTruth.WifiQoE();
            r10.setBand(r8.getBand()).setRxThroughput(r8.getRxThroughput()).setTxThroughput(r8.getTxThroughput()).setTimestamp(System.currentTimeMillis());
            NetworkTruthManager.access$100(this.this$0).enqueueWifiQoE(r10);
        }

        public /* synthetic */ Watcher(NetworkTruthManager r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    private NetworkTruthManager(Context r8, NetworkQoEMonitor r10) {
        this.mContext = r8;
        this.mDefaultNetwork = null;
        this.mNetworkQoEMonitor = r10;
        this.mConnectivityManager = (ConnectivityManager) r8.getSystemService("connectivity");
        HandlerThread r11 = new HandlerThread(TAG);
        r11.start();
        this.mHandler = new Handler(r11.getLooper());
        this.mWatcher = new Watcher(this, null);
        this.mNetworkTruth = new NetworkTruth();
        VipStrategyReport.getInstance().registerNetworkTruth(this.mNetworkTruth);
        this.mPowerManager = (PowerManager) r8.getSystemService("power");
        this.mPowerReceiver = createPowerReceiver();
        this.mScreenReceiver = createScreenReceiver();
        this.mSleepModeReceiver = createSleepModeReceiver();
        this.mNetworkCallback = createNetworkCallback();
        this.mDefaultNetworkCallback = createDefaultNetworkCallback();
        this.mNetworkErrReportCb = createL4NetErrReportCb();
        this.mL4NetEvaluate = L4NetEvaluate.getInstance(r8);
    }

    public static /* synthetic */ NetworkTruth access$100(NetworkTruthManager r8) {
        return r8.mNetworkTruth;
    }

    public static /* synthetic */ PowerManager access$200(NetworkTruthManager r8) {
        return r8.mPowerManager;
    }

    public static /* synthetic */ NetworkTruth.NetworkInfo access$300(NetworkTruthManager r8, Network r10) {
        return r8.prodNetworkInfo(r10);
    }

    public static /* synthetic */ void access$400(NetworkTruthManager r8, Network r10) {
        r8.updateDefaultNetwork(r10);
    }

    public static /* synthetic */ Network access$500(NetworkTruthManager r8) {
        return r8.mDefaultNetwork;
    }

    private ConnectivityManager.NetworkCallback createDefaultNetworkCallback() {
        return new AnonymousClass5(this);
    }

    private L4NetEvaluate.L4NetErrReportCb createL4NetErrReportCb() {
        return new AnonymousClass6(this);
    }

    private ConnectivityManager.NetworkCallback createNetworkCallback() {
        return new AnonymousClass4(this);
    }

    private BroadcastReceiver createPowerReceiver() {
        return new AnonymousClass1(this);
    }

    private BroadcastReceiver createScreenReceiver() {
        return new AnonymousClass2(this);
    }

    private BroadcastReceiver createSleepModeReceiver() {
        return new AnonymousClass3(this);
    }

    private NetworkTruth.CellularInfo getCellularInfo() {
        NetworkTruth.CellularInfo r8 = new NetworkTruth.CellularInfo();
        TelephonyManager r10 = (TelephonyManager) this.mContext.getSystemService("phone");
        if (r10 == null) goto L64;
        SubscriptionManager r11 = (SubscriptionManager) this.mContext.getSystemService("telephony_subscription_service");
        int r12 = 0;
        if (r11 == null) goto L11;
        List<SubscriptionInfo> r13 = r11.getActiveSubscriptionInfoList();
        if (r13 == null) goto L11;
        if (r13.isEmpty() == true) goto L11;
        int r14 = r13.get(0).getSubscriptionId();
    L12:
        int r15 = r10.getNetworkType();
        List<CellInfo> r16 = r10.getAllCellInfo();
        long r17 = 0;
        if (r16 != null) goto L15;
    L62:
        int r18 = 0;
    L63:
        r8.setSubId(r14).setType(r15).setCellId(r17).setRsrp(r12).setSinr(r18);
        goto L64
    L15:
        if (r16.isEmpty() == true) goto L62;
        Iterator<CellInfo> r19 = r16.iterator();
        r18 = 0;
        long r20 = 0;
    L18:
        if (r19.hasNext() == false) goto L61;
        CellInfo r21 = r19.next();
        if ((r21 instanceof CellInfoLte) == false) goto L28;
        CellInfoLte r22 = (CellInfoLte) r21;
        CellIdentityLte r110 = r22.getCellIdentity();
        if (r110 == null) goto L24;
        r20 = r110.getCi();
    L24:
        CellSignalStrengthLte r23 = r22.getCellSignalStrength();
        if (r23 == null) goto L60;
        r12 = r23.getRsrp();
        r18 = r23.getRssnr();
    L60:
        if (r20 == 0) goto L18;
    L28:
        if ((r21 instanceof CellInfoNr) == false) goto L36;
        CellInfoNr r24 = (CellInfoNr) r21;
        CellIdentityNr r111 = (CellIdentityNr) r24.getCellIdentity();
        if (r111 == null) goto L32;
        r20 = r111.getNci();
    L32:
        CellSignalStrengthNr r25 = (CellSignalStrengthNr) r24.getCellSignalStrength();
        if (r25 == null) goto L60;
        r12 = r25.getSsRsrp();
        r18 = r25.getSsSinr();
        goto L60
    L36:
        if ((r21 instanceof CellInfoGsm) == false) goto L44;
        CellInfoGsm r26 = (CellInfoGsm) r21;
        CellIdentityGsm r112 = r26.getCellIdentity();
        if (r112 == null) goto L40;
        r20 = r112.getCid();
    L40:
        CellSignalStrengthGsm r27 = r26.getCellSignalStrength();
        if (r27 == null) goto L60;
        r12 = r27.getDbm();
        goto L60
    L44:
        if ((r21 instanceof CellInfoWcdma) == false) goto L52;
        CellInfoWcdma r28 = (CellInfoWcdma) r21;
        CellIdentityWcdma r113 = r28.getCellIdentity();
        if (r113 == null) goto L48;
        r20 = r113.getCid();
    L48:
        CellSignalStrengthWcdma r29 = r28.getCellSignalStrength();
        if (r29 == null) goto L60;
        r12 = r29.getDbm();
        goto L60
    L52:
        if ((r21 instanceof CellInfoCdma) == false) goto L60;
        CellInfoCdma r30 = (CellInfoCdma) r21;
        CellIdentityCdma r114 = r30.getCellIdentity();
        if (r114 == null) goto L56;
        r20 = r114.getBasestationId();
    L56:
        CellSignalStrengthCdma r31 = r30.getCellSignalStrength();
        if (r31 == null) goto L60;
        r12 = r31.getDbm();
    L61:
        r17 = r20;
    L11:
        r14 = 0;
    L64:
        return r8;
    }

    public static NetworkTruthManager getInstance(Context r8, NetworkQoEMonitor r10) {
        if (sInstance != null) goto L15;
        monitor-enter(NetworkTruthManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NetworkTruthManager(r8, r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetworkTruthManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private Pair<String, String> getSsidFromNetworkCapabilities(NetworkCapabilities r8) {
        String r10 = "";
        Method r11 = NetworkCapabilities.class.getDeclaredMethod("getSsid", new Class[0]);     // Catch: Exception -> L7 NoSuchMethodException -> L9
        r11.setAccessible(true);     // Catch: Exception -> L7 NoSuchMethodException -> L9
        Object r12 = r11.invoke(r8, new Object[0]);     // Catch: Exception -> L7 NoSuchMethodException -> L9
        if (r12 == null) goto L12;
        String r13 = r12.toString();     // Catch: Exception -> L7 NoSuchMethodException -> L9
    L13:
        WifiManager r14 = (WifiManager) this.mContext.getSystemService("wifi");
        String r15 = r14.getConnectionInfo().getSSID();
        String r16 = r14.getConnectionInfo().getBSSID();
        if (r15 == null) goto L19;
        if (r15.equals(r13) == false) goto L19;
        r10 = r16;
    L19:
        return new Pair(r13, r10);
    L12:
        r13 = "";
    L9:
        e = move-exception;
        StringBuilder r17 = new StringBuilder("getSsidMethod not found: ");
        String r18 = e.getMessage();
    L11:
        r17.append(r18);
        CaeLog.e(TAG, r17.toString());
    L7:
        e = move-exception;
        r17 = new StringBuilder("getSsidMethod failed: ");
        r18 = e.getMessage();
        goto L11
    }

    private NetworkTruth.NetworkInfo prodNetworkInfo(Network r8) {
        NetworkTruth.NetworkInfo r10 = new NetworkTruth.NetworkInfo();
        r10.setNetId(r8.toString()).setCapability(null);
        NetworkCapabilities r11 = this.mConnectivityManager.getNetworkCapabilities(r8);
        if (r11 == null) goto L16;
        LinkProperties r12 = this.mConnectivityManager.getLinkProperties(r8);
        if (r12 == null) goto L16;
        if (r12.getInterfaceName() == null) goto L16;
        if (r11.hasTransport(1) == false) goto L14;
        TransportInfo r13 = r11.getTransportInfo();
        if ((r13 instanceof WifiInfo) == false) goto L16;
        WifiInfo r14 = (WifiInfo) r13;
        NetworkTruth.WifiInfo r15 = new NetworkTruth.WifiInfo();
        Pair<String, String> r16 = getSsidFromNetworkCapabilities(r11);
        r15.setSsid((String) r16.first).setBssid((String) r16.second).setFreq(r14.getFrequency()).setLinkspeed(r14.getLinkSpeed()).setRxLinkspeed(r14.getRxLinkSpeedMbps()).setRssi(r14.getRssi());
        r10.setCapability(r15);
        goto L16
    L14:
        if (r11.hasTransport(0) == false) goto L16;
        r10.setCapability(getCellularInfo());
    L16:
        return r10;
    }

    private void updateDefaultNetwork(Network r8) {
        CaeLog.d(TAG, "newDefaultNetwork: " + r8);
        if (r8 != null) goto L5;
        NetworkTruth.NetworkInfo r10 = null;
    L6:
        this.mNetworkTruth.setDefaultNetworkInfo(r10);
        Network r11 = this.mDefaultNetwork;
        if (r11 != null) goto L9;
        if (r8 == null) goto L9;
    L14:
        this.mDefaultNetwork = r8;
        NetworkTruth.NetworkChangedEvent r12 = new NetworkTruth.NetworkChangedEvent();
        r12.setType(3).setNetworkInfo(r10).setTimestamp(System.currentTimeMillis());
        this.mNetworkTruth.enqueueNetworkChangedEvent(r12);
        return;
    L9:
        if (r11 == null) goto L11;
        if (r8 == null) goto L14;
    L11:
        if (r11 != null) goto L13;
        return;
    L13:
        if (r11.equals(r8) == false) goto L14;
        return;
    L5:
        r10 = prodNetworkInfo(r8);
        goto L6
    }

    public String getNetworkTruth() {
        return this.mNetworkTruth.toJsonString();
    }

    public void start() {
        this.mNetworkQoEMonitor.start();
        this.mNetworkQoEMonitor.registerCellularQoECallback(this.mWatcher);
        this.mNetworkQoEMonitor.registerWiFiQoECallback(this.mWatcher);
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        r8.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        this.mContext.registerReceiver(this.mPowerReceiver, r8);
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.intent.action.SCREEN_ON");
        r10.addAction("android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(this.mScreenReceiver, r10);
        IntentFilter r11 = new IntentFilter();
        r11.addAction("com.bytedanceos.action.SLEEP_MODE_CHANGED");
        this.mContext.registerReceiver(this.mSleepModeReceiver, r11);
        NetworkRequest r12 = new NetworkRequest.Builder().addCapability(12).addTransportType(0).addTransportType(1).build();
        ConnectivityManager r13 = this.mConnectivityManager;
        if (r13 == null) goto L5;
        r13.registerNetworkCallback(r12, this.mNetworkCallback, this.mHandler);
        this.mConnectivityManager.registerDefaultNetworkCallback(this.mDefaultNetworkCallback, this.mHandler);
    L5:
        this.mL4NetEvaluate.registerErrReportCb(this.mNetworkErrReportCb);
    }

    public void stop() {
        this.mNetworkQoEMonitor.stop();
        this.mNetworkQoEMonitor.unregisterCellularQoECallback(this.mWatcher);
        this.mNetworkQoEMonitor.unregisterWiFiQoECallback(this.mWatcher);
        this.mContext.unregisterReceiver(this.mPowerReceiver);
        this.mContext.unregisterReceiver(this.mScreenReceiver);
        this.mContext.unregisterReceiver(this.mSleepModeReceiver);
        ConnectivityManager r8 = this.mConnectivityManager;
        if (r8 == null) goto L5;
        r8.unregisterNetworkCallback(this.mNetworkCallback);
        this.mConnectivityManager.unregisterNetworkCallback(this.mDefaultNetworkCallback);
    L5:
        this.mL4NetEvaluate.unregisterErrReportCb(this.mNetworkErrReportCb);
    }
}
