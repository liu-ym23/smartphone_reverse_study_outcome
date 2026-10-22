package com.obric.cae.statusReport.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.net.module.util.Inet4AddressUtils;
import com.cae.caed.INefiListener;
import com.cae.caed.NefiInfoParcel;
import com.cae.caed.WifiStatsParcel;
import com.obric.cae.libs.statusreport.ILinkLayerQualityListener;
import com.obric.cae.libs.statusreport.LinkLayerQuality;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import com.obric.cae.smartNetwork.networkHandover.b;
import com.obric.cae.utils.CaeUtil;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class WifiStatusReport {
    private static final String CAE_WIFI_ACCESS_PERMISSION = "com.obric.cae.permission.CAE_WIFI_ACCESS";
    private static final String TAG = "WifiStatusReport";
    private static final int WIFI_STATUS_REPORT_EVENT_PERIOD = 2;
    private int HEAVYINFO_UPDATE_INTERVAL;
    private int MSG_HANDLE_HEAVYINFOUPDATE;
    private final HashMap<String, LinkLayerQualityAgent> linkLayerQualityAgentMap;
    private CaeWifiInfo mCaeWifiInfo;
    private CaeWifiStatusCollect mCaeWifiStatusCollect;
    private Context mContext;
    private int mCurrChanApCount;
    private WifiInfo mCurrentWifiInfo;
    private DhcpInfo mDhcpInfo;
    private IntentFilter mFilter;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private final HashMap<ILinkLayerQualityListener, LinkLayerDeathRecipient> mLLDeathRecipientMap;
    private WifiInfo mLastWifiInfo;
    private final RemoteCallbackList<ILinkLayerQualityListener> mLinkLayerListeners;
    private NefidInterface mNefidInterface;
    private NefidListener mNefidListener;
    private int mNeibourCount;
    private BroadcastReceiver mReceiver;
    private boolean mWifiConnected;
    private WifiManager mWifiManager;

    public class LinkLayerDeathRecipient implements IBinder.DeathRecipient {
        private ILinkLayerQualityListener mListener;
        private String mPackageName;
        final /* synthetic */ WifiStatusReport this$0;

        public LinkLayerDeathRecipient(WifiStatusReport r8, String r10, ILinkLayerQualityListener r11) {
            this.this$0 = r8;
            this.mPackageName = r10;
            this.mListener = r11;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            CaeLog.i(WifiStatusReport.TAG, "Binder is dead, package:" + this.mPackageName + " listener: " + this.mListener);
            ILinkLayerQualityListener r8 = this.mListener;
            if (r8 == null) goto L6;
            this.this$0.unregisterLinkLayerQualityChangedListener(this.mPackageName, r8);
            return;
        }
    }

    public final class NefidListener extends INefiListener.Stub {
        final /* synthetic */ WifiStatusReport this$0;

        public NefidListener(WifiStatusReport r8) {
            this.this$0 = r8;
            if (WifiStatusReport.access$900(r8) == null) goto L6;
            WifiStatusReport.access$1002(r8, WifiStatusReport.access$900(r8).getConnectionInfo());
            WifiStatusReport.access$1102(r8, null);
            return;
        }

        @Override // com.cae.caed.INefiListener
        public void OnInfoChanged(int r8, List<NefiInfoParcel> r10) {
        }

        @Override // com.cae.caed.INefiListener
        public void OnWifiStatsChanged(List<WifiStatsParcel> r11) {
            ArrayList r8 = new ArrayList();
            Iterator<WifiStatsParcel> r10 = r11.iterator();
        L3:
            boolean r12 = false;
            int r13 = -1;
            if (r10.hasNext() == false) goto L28;
            WifiStatsParcel r14 = r10.next();
            String r15 = r14.f4203a;
            r8.add(r15);
            if (WifiStatusReport.access$1200(this.this$0).containsKey(r15) == true) goto L18;
            WifiStatusReport r16 = this.this$0;
            WifiStatusReport.access$1002(r16, WifiStatusReport.access$900(r16).getConnectionInfo());
            WifiStatusReport r17 = this.this$0;
            if (WifiStatusReport.access$1300(r17, WifiStatusReport.access$1000(r17)) == true) goto L10;
        L14:
            if (r12 == false) goto L16;
            CaeLog.d(WifiStatusReport.TAG, "Creating new LinkLayerQualityAgent for interface: " + r15);
            WifiStatusReport.access$1200(this.this$0).put(r15, new LinkLayerQualityAgent(WifiStatusReport.access$1400(this.this$0), r15));
        L17:
            WifiStatusReport r18 = this.this$0;
            WifiStatusReport.access$1102(r18, WifiStatusReport.access$1000(r18));
            goto L18
        L16:
            CaeLog.d(WifiStatusReport.TAG, "Not adding active LinkLayerQualityAgent instance as no connection was built.");
            goto L17
        L10:
            if (WifiStatusReport.access$1100(this.this$0) != null) goto L12;
        L13:
            r12 = true;
            goto L14
        L12:
            if (TextUtils.equals(WifiStatusReport.access$1000(this.this$0).getBSSID(), WifiStatusReport.access$1100(this.this$0).getBSSID()) == true) goto L14;
        L18:
            int r19 = WifiStatusReport.access$200(this.this$0);
            int r20 = WifiStatusReport.access$400(this.this$0);
            if (r11.size() <= 1) goto L21;
            r20 = -1;
        L22:
            LinkLayerQualityAgent r21 = (LinkLayerQualityAgent) WifiStatusReport.access$1200(this.this$0).get(r15);
            if (r21 == null) goto L3;
            r21.updateLinkLayerQuality(r14, r13, r20);     // Catch: Exception -> L26
            WifiStatusReport.access$1500(this.this$0, r21.getLinkLayerQuality());     // Catch: Exception -> L26
            WifiStatusReport.access$1600(this.this$0, r21.getLinkLayerQuality());     // Catch: Exception -> L26
        L26:
            e = move-exception;
            CaeLog.e(WifiStatusReport.TAG, "Exception while updating LinkLayerQualityAgent for interface: " + r15, e);
            goto L3
        L21:
            r13 = r19;
            goto L22
        L28:
            ArrayList r110 = new ArrayList();
            Iterator r22 = WifiStatusReport.access$1200(this.this$0).keySet().iterator();
        L30:
            if (r22.hasNext() == false) goto L35;
            String r23 = (String) r22.next();
            if (r8.contains(r23) == true) goto L30;
            r110.add(r23);
            goto L30
        L35:
            if (r110.isEmpty() == false) goto L37;
            return;
        L37:
            if (WifiStatusReport.access$900(this.this$0) == null) goto L65;
            WifiStatusReport r24 = this.this$0;
            WifiStatusReport.access$1002(r24, WifiStatusReport.access$900(r24).getConnectionInfo());
            if (WifiStatusReport.access$1000(this.this$0) != null) goto L41;
        L47:
            if (r12 == false) goto L49;
            CaeLog.d(WifiStatusReport.TAG, "Removing " + r110.size() + " inactive LinkLayerQualityAgent instances.");
            HashMap r25 = WifiStatusReport.access$1200(this.this$0);
            Objects.requireNonNull(r25);
            r110.forEach(new b(r25, 1));
        L50:
            WifiStatusReport r111 = this.this$0;
            WifiStatusReport.access$1102(r111, WifiStatusReport.access$1000(r111));
            return;
        L49:
            CaeLog.d(WifiStatusReport.TAG, "Not removing inactive LinkLayerQualityAgent instances as no connection was dropped.");
            goto L50
        L41:
            if (WifiStatusReport.access$1000(this.this$0).getNetworkId() != (-1)) goto L43;
        L46:
            r12 = true;
            goto L47
        L43:
            if (WifiStatusReport.access$1100(this.this$0) == null) goto L47;
            if (TextUtils.equals(WifiStatusReport.access$1100(this.this$0).getBSSID(), WifiStatusReport.access$1000(this.this$0).getBSSID()) == true) goto L47;
        }
    }

    public class WifiStatusReportProcessHandler extends Handler {
        final /* synthetic */ WifiStatusReport this$0;

        public WifiStatusReportProcessHandler(WifiStatusReport r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            if (r8.what != WifiStatusReport.access$100(this.this$0)) goto L8;
            WifiStatusReport r10 = this.this$0;
            WifiStatusReport.access$202(r10, WifiStatusReport.access$300(r10));
            WifiStatusReport r11 = this.this$0;
            WifiStatusReport.access$402(r11, WifiStatusReport.access$500(r11));
            if (WifiStatusReport.access$600(this.this$0) == false) goto L9;
            Message r12 = WifiStatusReport.access$700(this.this$0).obtainMessage();
            r12.what = WifiStatusReport.access$100(this.this$0);
            WifiStatusReport.access$700(this.this$0).sendMessageDelayed(r12, WifiStatusReport.access$800(this.this$0));
            return;
        L9:
            return;
        }
    }

    public WifiStatusReport(Context r8) {
        this.mWifiConnected = false;
        this.MSG_HANDLE_HEAVYINFOUPDATE = 1;
        this.HEAVYINFO_UPDATE_INTERVAL = 180000;
        this.mNeibourCount = 0;
        this.mCurrChanApCount = 0;
        this.linkLayerQualityAgentMap = new HashMap();
        this.mLinkLayerListeners = new RemoteCallbackList();
        this.mLLDeathRecipientMap = new HashMap();
        this.mContext = r8;
        this.mWifiManager = (WifiManager) r8.getSystemService("wifi");
        CaeWifiStatusCollect r10 = CaeWifiStatusCollect.getInstance();
        this.mCaeWifiStatusCollect = r10;
        r10.init(this.mContext, this.mWifiManager);
        HandlerThread r11 = new HandlerThread("linklayer_quality");
        this.mHandlerThread = r11;
        r11.start();
        this.mHandler = new WifiStatusReportProcessHandler(this, this.mHandlerThread.getLooper());
        this.mCaeWifiInfo = new CaeWifiInfo();
        this.mNefidInterface = NefidInterface.getInstance(this.mContext);
        NefidListener r12 = new NefidListener(this);
        this.mNefidListener = r12;
        this.mNefidInterface.registerNefidInfoListener(r12, 16, "all", 0, 0, 2);
        CaeLog.d(TAG, "registerNefidInfoListener");
    }

    public static /* synthetic */ void access$000(WifiStatusReport r8, Intent r10) {
        r8.handleStateChanged(r10);
    }

    public static /* synthetic */ int access$100(WifiStatusReport r8) {
        return r8.MSG_HANDLE_HEAVYINFOUPDATE;
    }

    public static /* synthetic */ WifiInfo access$1000(WifiStatusReport r8) {
        return r8.mCurrentWifiInfo;
    }

    public static /* synthetic */ WifiInfo access$1002(WifiStatusReport r8, WifiInfo r10) {
        r8.mCurrentWifiInfo = r10;
        return r10;
    }

    public static /* synthetic */ WifiInfo access$1100(WifiStatusReport r8) {
        return r8.mLastWifiInfo;
    }

    public static /* synthetic */ WifiInfo access$1102(WifiStatusReport r8, WifiInfo r10) {
        r8.mLastWifiInfo = r10;
        return r10;
    }

    public static /* synthetic */ HashMap access$1200(WifiStatusReport r8) {
        return r8.linkLayerQualityAgentMap;
    }

    public static /* synthetic */ boolean access$1300(WifiStatusReport r8, WifiInfo r10) {
        return r8.isValidConnectedWifiInfo(r10);
    }

    public static /* synthetic */ Context access$1400(WifiStatusReport r8) {
        return r8.mContext;
    }

    public static /* synthetic */ void access$1500(WifiStatusReport r8, LinkLayerQuality r10) {
        r8.reportLinkLayerQuality(r10);
    }

    public static /* synthetic */ void access$1600(WifiStatusReport r8, LinkLayerQuality r10) {
        r8.dispatchLinkLayerQualityChanged(r10);
    }

    public static /* synthetic */ int access$200(WifiStatusReport r8) {
        return r8.mCurrChanApCount;
    }

    public static /* synthetic */ int access$202(WifiStatusReport r8, int r10) {
        r8.mCurrChanApCount = r10;
        return r10;
    }

    public static /* synthetic */ int access$300(WifiStatusReport r8) {
        return r8.getCurrChannelApCount();
    }

    public static /* synthetic */ int access$400(WifiStatusReport r8) {
        return r8.mNeibourCount;
    }

    public static /* synthetic */ int access$402(WifiStatusReport r8, int r10) {
        r8.mNeibourCount = r10;
        return r10;
    }

    public static /* synthetic */ int access$500(WifiStatusReport r8) {
        return r8.getNeibourCountByArp();
    }

    public static /* synthetic */ boolean access$600(WifiStatusReport r8) {
        return r8.mWifiConnected;
    }

    public static /* synthetic */ Handler access$700(WifiStatusReport r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ int access$800(WifiStatusReport r8) {
        return r8.HEAVYINFO_UPDATE_INTERVAL;
    }

    public static /* synthetic */ WifiManager access$900(WifiStatusReport r8) {
        return r8.mWifiManager;
    }

    private void dispatchLinkLayerQualityChanged(LinkLayerQuality r8) {
        RemoteCallbackList<ILinkLayerQualityListener> r10 = this.mLinkLayerListeners;
        if (r10 != null) goto L6;
        CaeLog.e(TAG, "dispatchLinkLayerQualityChanged error, mLinkLayerListeners is null");
        return;
    L6:
        int r11 = r10.beginBroadcast();
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L15;
        ILinkLayerQualityListener r13 = (ILinkLayerQualityListener) this.mLinkLayerListeners.getBroadcastItem(r12);
        if (r13 == null) goto L14;
        r13.onLinkLayerQualityChanged(r8);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        android.aimedia.a.q("dispatchLinkLayerQualityChanged excepion:", e, TAG);
    L14:
        r12 = r12 + 1;
        goto L7
    L15:
        this.mLinkLayerListeners.finishBroadcast();
    }

    private void enforceAccessPermission() {
        this.mContext.enforceCallingPermission(CAE_WIFI_ACCESS_PERMISSION, "Permission required to access Cae Wifi Service");     // Catch: SecurityException -> L4
        return;
    L4:
        e = move-exception;
        CaeLog.e(TAG, "enforceAccessPermission SecurityException: " + e);
        throw e;
    }

    private int getCurrChannelApCount() {
        WifiInfo r8 = this.mWifiManager.getConnectionInfo();
        int r10 = 0;
        if (r8 != null) goto L7;
        String r11 = "Cannot get current WiFi connection info";
    L5:
        CaeLog.d(TAG, r11);
        return r10;
    L7:
        int r12 = r8.getFrequency();
        List<ScanResult> r13 = this.mWifiManager.getScanResults();
        if (r13 != null) goto L10;
    L19:
        r11 = "No available scan results";
        goto L5
    L10:
        if (r13.isEmpty() == true) goto L19;
        Iterator<ScanResult> r14 = r13.iterator();
    L14:
        if (r14.hasNext() == false) goto L18;
        if (r14.next().frequency != r12) goto L14;
        r10 = r10 + 1;
        goto L14
    L18:
        r11 = "Current channel AP count: " + r10 + " on frequency: " + r12 + "MHz";
        goto L5
    }

    private int getNeibourCountByArp() {
        BufferedReader r8 = new BufferedReader(new FileReader("/proc/net/arp"));     // Catch: Exception -> L39 IOException -> L42 FileNotFoundException -> L45
        r8.readLine();     // Catch: Throwable -> L32
        int r10 = 0;
    L52:
        String r11 = r8.readLine();     // Catch: Throwable -> L30
        if (r11 == null) goto L22;
        String r12 = r11.trim();     // Catch: Throwable -> L30
        if (r12.isEmpty() == true) goto L52;
        String[] r13 = r12.split("\\s+");     // Catch: Throwable -> L30
        if (r13.length < 6) goto L52;
        String r14 = r13[3];     // Catch: Throwable -> L30
        if ("00:00:00:00:00:00".equals(r14) == true) goto L52;
        if (r14.matches("([0-9A-Fa-f]{2}:){5}[0-9A-Fa-f]{2}") == false) goto L52;
        r10 = r10 + 1;     // Catch: Throwable -> L30
        CaeLog.d(TAG, String.format("ARP Entry - IP: %-15s MAC: %s Flag: %s", new Object[]{r13[0], r14, r13[2]}));     // Catch: Throwable -> L30
        goto L52
    L22:
        r8.close();     // Catch: Exception -> L24 IOException -> L26 FileNotFoundException -> L28
    L49:
        return r10;
    L30:
        Throwable th = th;
    L50:
        r8.close();     // Catch: Throwable -> L36
    L38:
        throw th;     // Catch: Exception -> L24 IOException -> L26 FileNotFoundException -> L28
    L36:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L24 IOException -> L26 FileNotFoundException -> L28
    L32:
        th = move-exception;
        r10 = 0;
        th = th;
        goto L50
    L45:
        e = move-exception;
        r10 = 0;
        e = e;
    L47:
        String r15 = "ARP file not found";
    L48:
        CaeLog.e(TAG, r15, e);
    L42:
        e = move-exception;
        r10 = 0;
        e = e;
    L44:
        r15 = "Error reading ARP file";
    L39:
        e = move-exception;
        r10 = 0;
        e = e;
    L41:
        r15 = "Unexpected error in ARP processing";
    L28:
        e = e;
    L26:
        e = e;
    L24:
        e = e;
        goto L41
    }

    private void handleStateChanged(Intent r8) {
        String r10 = r8.getAction();
        CaeLog.d(TAG, "onReceive : " + r10);
        if ("android.net.wifi.STATE_CHANGE".equals(r10) == false) goto L11;
        NetworkInfo r11 = (NetworkInfo) r8.getParcelableExtra("networkInfo");
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.isConnected() == false) goto L33;
        reportUPnPDeviceInfo();
        this.mWifiConnected = true;
        String r12 = "network is connected";
    L9:
        CaeLog.d(TAG, r12);
        return;
    L33:
        return;
    L11:
        if ("android.net.wifi.supplicant.STATE_CHANGE".equals(r10) == false) goto L19;
        SupplicantState r13 = (SupplicantState) r8.getParcelableExtra("newState");
        CaeLog.d(TAG, "Receive action: " + r10 + " state = " + r13);
        if (r13 != SupplicantState.DISCONNECTED) goto L15;
        CaeLog.d(TAG, "network is disconnected");
        this.mWifiConnected = false;
        this.linkLayerQualityAgentMap.clear();
        this.mLastWifiInfo = null;
        this.mCurrentWifiInfo = null;
        CaeLog.d(TAG, "All LinkLayerQualityAgent instances removed due to no WiFi connection.");
    L15:
        reportConnectionTime(r13);
        if (r13 != SupplicantState.COMPLETED) goto L35;
        updateCaeWifiInfo(this.mWifiManager.getConnectionInfo());
        this.mWifiConnected = true;
        return;
    L35:
        return;
    L19:
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r10) == false) goto L26;
        if (r8.getIntExtra("wifi_state", 4) == 1) goto L23;
        return;
    L23:
        if (this.mWifiConnected == false) goto L38;
        this.mWifiConnected = false;
        reportConnectionTime(SupplicantState.DISCONNECTED);
        this.linkLayerQualityAgentMap.clear();
        this.mLastWifiInfo = null;
        this.mCurrentWifiInfo = null;
        r12 = "All LinkLayerQualityAgent instances removed due to WiFi disabled.";
        goto L9
    L38:
        return;
    L26:
        if ("android.intent.action.SCREEN_OFF".equals(r10) == false) goto L29;
        reportPowerStats(0);
        return;
    L29:
        if ("android.intent.action.SCREEN_ON".equals(r10) == false) goto L40;
        reportPowerStats(1);
        return;
    }

    private void initReceiver() {
        IntentFilter r8 = new IntentFilter();
        this.mFilter = r8;
        r8.addAction("android.net.wifi.STATE_CHANGE");
        this.mFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        this.mFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        this.mFilter.addAction("android.intent.action.SCREEN_ON");
        this.mFilter.addAction("android.intent.action.SCREEN_OFF");
        CaeLog.d(TAG, "initReceiver");
        this.mReceiver = new AnonymousClass1(this);
    }

    private boolean isValidConnectedWifiInfo(WifiInfo r8) {
        if (r8 != null) goto L4;
    L8:
        return false;
    L4:
        if (r8.getSupplicantState() != SupplicantState.COMPLETED) goto L8;
        if (TextUtils.isEmpty(r8.getBSSID()) == true) goto L8;
        return true;
    }

    private void registerReceiver() {
        if (this.mReceiver == null) goto L5;
        return;
    L5:
        initReceiver();
        this.mContext.registerReceiver(this.mReceiver, this.mFilter);
    }

    private void reportConnectionTime(SupplicantState r8) {
        CaeWifiStatusCollect r10 = this.mCaeWifiStatusCollect;
        if (r10 == null) goto L6;
        r10.reportConnectionTime(r8, this.mCaeWifiInfo.makeCopy());
        return;
    }

    private void reportLinkLayerQuality(LinkLayerQuality r8) {
        WifiInfo r10 = this.mWifiManager.getConnectionInfo();
        CaeWifiStatusCollect r11 = this.mCaeWifiStatusCollect;
        if (r11 == null) goto L7;
        if (r10 == null) goto L8;
        r11.reportLinkLayerQuality(r8);
        return;
    L8:
        return;
    }

    private void reportPowerStats(int r8) {
        CaeWifiStatusCollect r10 = this.mCaeWifiStatusCollect;
        if (r10 == null) goto L6;
        r10.reportPowerStats(r8);
        return;
    }

    private void reportUPnPDeviceInfo() {
        WifiInfo r8 = this.mWifiManager.getConnectionInfo();
        if (isValidConnectedWifiInfo(r8) == true) goto L6;
        CaeLog.d(TAG, "Skip UPnP device info report for invalid Wi-Fi connection");
        return;
    L6:
        DhcpInfo r10 = this.mWifiManager.getDhcpInfo();
        this.mDhcpInfo = r10;
        if (r10 != null) goto L9;
        return;
    L9:
        String r11 = Inet4AddressUtils.intToInet4AddressHTL(r10.gateway).getHostAddress();
        String r12 = r8.getBSSID();
        updateCaeWifiInfo(r8);
        CaeWifiStatusCollect r13 = this.mCaeWifiStatusCollect;
        if (r13 == null) goto L13;
        r13.reportUPnPDeviceInfo(r11, r12, this.mCaeWifiInfo.makeCopy());
        return;
    }

    private void updateCaeWifiInfo(WifiInfo r8) {
        CaeWifiInfo r10 = this.mCaeWifiInfo;
        if (r10 == null) goto L6;
        r10.updateCaeWifiInfo(r8);
        return;
    }

    public String getCaeVersion() {
        return CaeUtil.getCaeVersion();
    }

    public LinkLayerQuality getLinkLayerQuality(String r8) {
        enforceAccessPermission();
        CaeLog.i(TAG, "getLinkLayerQuality entry");
        HashMap<String, LinkLayerQualityAgent> r10 = this.linkLayerQualityAgentMap;
        if (r10 == null) goto L7;
        LinkLayerQualityAgent r11 = r10.get("wlan0");
        if (r11 == null) goto L7;
        return r11.getLinkLayerQuality();
    L7:
        return null;
    }

    public boolean registerLinkLayerQualityChangedListener(String r8, ILinkLayerQualityListener r10) {
        if (r10 != null) goto L5;
        String r11 = "registerLinkLayerQualityChangedListener error, listener is null";
    L11:
        CaeLog.e(TAG, r11);
        return false;
    L5:
        enforceAccessPermission();
        CaeLog.e(TAG, "registerLinkLayerQualityChangedListener entry, listener: " + r10);
        LinkLayerDeathRecipient r12 = new LinkLayerDeathRecipient(this, r8, r10);     // Catch: RemoteException -> L9
        this.mLLDeathRecipientMap.put(r10, r12);     // Catch: RemoteException -> L9
        r10.asBinder().linkToDeath(r12, 0);     // Catch: RemoteException -> L9
        this.mLinkLayerListeners.register(r10);
        return true;
    L9:
        e = move-exception;
        r11 = "registerLinkLayerQualityChangedListener exception! :" + e;
        goto L11
    }

    public void startMonitoring() {
        CaeLog.d(TAG, "Starting Wi-Fi status report monitoring");
        registerReceiver();
    }

    public void stopMonitoring() {
        CaeLog.d(TAG, "Stopping wifi status report monitoring");
        unRegisterReceiver();
        HashMap<String, LinkLayerQualityAgent> r8 = this.linkLayerQualityAgentMap;
        if (r8 == null) goto L11;
        Iterator<LinkLayerQualityAgent> r10 = r8.values().iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        LinkLayerQualityAgent r11 = r10.next();
        if (r11 == null) goto L6;
        r11.cleanup();
        goto L6
    L10:
        this.linkLayerQualityAgentMap.clear();
    L11:
        this.mCaeWifiStatusCollect.cleanup();
    }

    public void unRegisterReceiver() {
        BroadcastReceiver r8 = this.mReceiver;
        if (r8 == null) goto L6;
        this.mContext.unregisterReceiver(r8);
        this.mReceiver = null;
        return;
    }

    public boolean unregisterLinkLayerQualityChangedListener(String r8, ILinkLayerQualityListener r10) {
        if (r10 != null) goto L5;
        String r11 = "unregisterLinkLayerQualityChangedListener error, listener is null";
    L13:
        CaeLog.e(TAG, r11);
        return false;
    L5:
        enforceAccessPermission();
        CaeLog.e(TAG, "unregisterLinkLayerQualityChangedListener entry, listener: " + r10);
        LinkLayerDeathRecipient r12 = this.mLLDeathRecipientMap.get(r10);     // Catch: Exception -> L11
        if (r12 == null) goto L9;
        r10.asBinder().unlinkToDeath(r12, 0);     // Catch: Exception -> L11
        this.mLLDeathRecipientMap.remove(r10);     // Catch: Exception -> L11
    L9:
        this.mLinkLayerListeners.unregister(r10);
        return true;
    L11:
        e = move-exception;
        r11 = "unregisterLinkLayerQualityChangedListener exception! :" + e;
        goto L13
    }
}
