package com.obric.cae.smartNetwork.throughtput;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import com.cae.caed.INefiListener;
import com.cae.caed.NefiInfoParcel;
import com.cae.caed.StaInfoParcel;
import com.cae.caed.WifiStatsParcel;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import com.obric.cae.utils.CaeUtil;
import com.obric.cae.wifi.WiFiDBHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ThroughputCalculation {
    private static final long DATA_EXPIRATION_THRESHOLD_MS = 2000;
    private static final String PRIMARY_INTERFACE = "wlan0";
    private static final String SECONDARY_INTERFACE = "wlan1";
    private static final String TAG = "ThroughputCalculation";
    private ConcurrentHashMap<String, SingleThroughputCalculation> calculationMap;
    private Context mContext;
    private int mCurrentConnectedApAuthType;
    private int mCurrentConnectedApFrequency;
    private String mCurrentConnectedApMacAddress;
    private String mCurrentConnectedApSsid;
    private int mCurrentConnectedApStandard;
    private long mCurrentConnectedApTimestamp;
    private int mCurrentConnectedApType;
    private WifiInfo mCurrentWifiInfo;
    private IntentFilter mFilter;
    private WifiInfo mLastWifiInfo;
    private NefidInterface mNefidInterface;
    private NefidListener mNefidListener;
    private int mPrimaryFreq;
    private BroadcastReceiver mReceiver;
    private ThroughputCallback mThroughputCallback;
    private boolean mWifiConnected;
    private WifiManager mWifiManager;

    public final class NefidListener extends INefiListener.Stub {
        final /* synthetic */ ThroughputCalculation this$0;

        private NefidListener(ThroughputCalculation r8) {
            this.this$0 = r8;
        }

        @Override // com.cae.caed.INefiListener
        public void OnInfoChanged(int r10, List<NefiInfoParcel> r11) {
            boolean r8 = false;
            if (r11 != null) goto L5;
        L56:
            ArrayList r12 = new ArrayList();     // Catch: Exception -> L53
            Iterator<NefiInfoParcel> r13 = r11.iterator();     // Catch: Exception -> L53
        L11:
            if (r13.hasNext() == false) goto L29;
            NefiInfoParcel r14 = r13.next();     // Catch: Exception -> L53
            String r15 = r14.f4155a;     // Catch: Exception -> L53
            r12.add(r15);     // Catch: Exception -> L53
            if (ThroughputCalculation.access$1000(this.this$0).containsKey(r15) == true) goto L26;
            ThroughputCalculation r16 = this.this$0;     // Catch: Exception -> L53
            ThroughputCalculation.access$1102(r16, ThroughputCalculation.access$1200(r16).getConnectionInfo());     // Catch: Exception -> L53
            if (ThroughputCalculation.access$1300(this.this$0) != null) goto L17;
        L22:
            boolean r17 = true;
        L23:
            if (r17 == false) goto L25;
            ThroughputCalculation.access$1000(this.this$0).put(r15, new SingleThroughputCalculation(ThroughputCalculation.access$1400(this.this$0), r15, new AnonymousClass1(this)));     // Catch: Exception -> L53
            ThroughputCalculation r18 = this.this$0;     // Catch: Exception -> L53
            ThroughputCalculation.access$1302(r18, ThroughputCalculation.access$1100(r18));     // Catch: Exception -> L53
            goto L26
        L25:
            CaeLog.d(ThroughputCalculation.TAG, "Not adding active SingleThroughputCalculation instance as no connection was built.");     // Catch: Exception -> L53
            goto L26
        L17:
            if (ThroughputCalculation.access$1100(this.this$0) != null) goto L19;
        L21:
            r17 = false;
            goto L23
        L19:
            if (ThroughputCalculation.access$1100(this.this$0).getBSSID().equals(ThroughputCalculation.access$1300(this.this$0).getBSSID()) == true) goto L21;
        L26:
            SingleThroughputCalculation r19 = (SingleThroughputCalculation) ThroughputCalculation.access$1000(this.this$0).get(r15);     // Catch: Exception -> L53
            if (r19 == null) goto L11;
            r19.updateWithInfoParcel(r14);     // Catch: Exception -> L53
            goto L11
        L29:
            ArrayList r110 = new ArrayList();     // Catch: Exception -> L53
            Iterator r20 = ThroughputCalculation.access$1000(this.this$0).keySet().iterator();     // Catch: Exception -> L53
        L31:
            if (r20.hasNext() == false) goto L36;
            String r21 = (String) r20.next();     // Catch: Exception -> L53
            if (r12.contains(r21) == true) goto L31;
            r110.add(r21);     // Catch: Exception -> L53
            goto L31
        L36:
            if (r110.isEmpty() == false) goto L38;
            return;
        L38:
            if (ThroughputCalculation.access$1200(this.this$0) == null) goto L69;
            ThroughputCalculation r22 = this.this$0;     // Catch: Exception -> L53
            ThroughputCalculation.access$1102(r22, ThroughputCalculation.access$1200(r22).getConnectionInfo());     // Catch: Exception -> L53
            if (ThroughputCalculation.access$1100(this.this$0) != null) goto L42;
        L48:
            if (r8 == false) goto L50;
            CaeLog.d(ThroughputCalculation.TAG, "Removing " + r110.size() + " inactive interfaces from calculationMap");     // Catch: Exception -> L53
            final ConcurrentHashMap r23 = ThroughputCalculation.access$1000(this.this$0);     // Catch: Exception -> L53
            Objects.requireNonNull(r23);     // Catch: Exception -> L53
            r110.forEach(new a(r23));     // Catch: Exception -> L53
        L51:
            ThroughputCalculation r24 = this.this$0;     // Catch: Exception -> L53
            ThroughputCalculation.access$1302(r24, ThroughputCalculation.access$1100(r24));     // Catch: Exception -> L53
            return;
        L50:
            CaeLog.d(ThroughputCalculation.TAG, "Not removing inactive interfaces as no connection was dropped.");     // Catch: Exception -> L53
            goto L51
        L42:
            if (ThroughputCalculation.access$1100(this.this$0).getNetworkId() != (-1)) goto L44;
        L47:
            r8 = true;
            goto L48
        L44:
            if (ThroughputCalculation.access$1300(this.this$0) == null) goto L48;
            if (ThroughputCalculation.access$1100(this.this$0).getBSSID().equals(ThroughputCalculation.access$1300(this.this$0).getBSSID()) == true) goto L48;
        L69:
            return;
        L53:
            e = move-exception;
            CaeLog.e(ThroughputCalculation.TAG, "Exception in OnInfoChanged: " + e.getMessage(), e);
            return;
        L5:
            if (r11.size() != 1) goto L56;
            if (ThroughputCalculation.access$200(this.this$0) == null) goto L56;
            NefiInfoParcel r25 = r11.get(0);
            long r26 = System.currentTimeMillis();
            Bundle r27 = new Bundle();
            r27.putString(WiFiDBHelper.COL_BSSID, ThroughputCalculation.access$200(this.this$0));
            r27.putString("ssid", ThroughputCalculation.access$300(this.this$0));
            r27.putInt(WiFiDBHelper.COL_RSSI, r25.f4156b.f4188a);
            r27.putInt("frequency", ThroughputCalculation.access$400(this.this$0));
            StaInfoParcel r28 = r25.f4156b;
            r27.putInt("totalBytes", r28.f4190m + r28.f4189b);
            r27.putLong("usedTime", r26 - ThroughputCalculation.access$500(this.this$0));
            r27.putLong("timestamp", System.currentTimeMillis());
            r27.putInt("authType", ThroughputCalculation.access$600(this.this$0));
            r27.putInt("apType", ThroughputCalculation.access$700(this.this$0));
            r27.putInt("apStandard", ThroughputCalculation.access$800(this.this$0));
            ThroughputCalculation.access$900(this.this$0).onWifiConnectInfoChanged(r27);
            goto L56
        }

        @Override // com.cae.caed.INefiListener
        public void OnWifiStatsChanged(List<WifiStatsParcel> r8) {
        }

        public /* synthetic */ NefidListener(ThroughputCalculation r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public ThroughputCalculation(Context r8, ThroughputCallback r10) {
        this.calculationMap = new ConcurrentHashMap();
        AnonymousClass1 r11 = null;
        this.mCurrentConnectedApMacAddress = null;
        this.mWifiConnected = false;
        this.mPrimaryFreq = -1;
        this.mContext = r8;
        this.mThroughputCallback = r10;
        NefidInterface r12 = NefidInterface.getInstance(r8);
        this.mNefidInterface = r12;
        if (r12 != null) goto L6;
        CaeLog.e(TAG, "NefidInterface.getInstance() returned null");
        return;
    L6:
        NefidListener r13 = new NefidListener(this, r11);
        this.mNefidListener = r13;
        this.mNefidInterface.registerNefidInfoListener(r13, 1, "all", 1, 0, 2);
        this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        initReceiver();
    }

    public static /* synthetic */ void access$100(ThroughputCalculation r8, Intent r10) {
        r8.handleStateChanged(r10);
    }

    public static /* synthetic */ ConcurrentHashMap access$1000(ThroughputCalculation r8) {
        return r8.calculationMap;
    }

    public static /* synthetic */ WifiInfo access$1100(ThroughputCalculation r8) {
        return r8.mCurrentWifiInfo;
    }

    public static /* synthetic */ WifiInfo access$1102(ThroughputCalculation r8, WifiInfo r10) {
        r8.mCurrentWifiInfo = r10;
        return r10;
    }

    public static /* synthetic */ WifiManager access$1200(ThroughputCalculation r8) {
        return r8.mWifiManager;
    }

    public static /* synthetic */ WifiInfo access$1300(ThroughputCalculation r8) {
        return r8.mLastWifiInfo;
    }

    public static /* synthetic */ WifiInfo access$1302(ThroughputCalculation r8, WifiInfo r10) {
        r8.mLastWifiInfo = r10;
        return r10;
    }

    public static /* synthetic */ Context access$1400(ThroughputCalculation r8) {
        return r8.mContext;
    }

    public static /* synthetic */ String access$200(ThroughputCalculation r8) {
        return r8.mCurrentConnectedApMacAddress;
    }

    public static /* synthetic */ String access$300(ThroughputCalculation r8) {
        return r8.mCurrentConnectedApSsid;
    }

    public static /* synthetic */ int access$400(ThroughputCalculation r8) {
        return r8.mCurrentConnectedApFrequency;
    }

    public static /* synthetic */ long access$500(ThroughputCalculation r8) {
        return r8.mCurrentConnectedApTimestamp;
    }

    public static /* synthetic */ int access$600(ThroughputCalculation r8) {
        return r8.mCurrentConnectedApAuthType;
    }

    public static /* synthetic */ int access$700(ThroughputCalculation r8) {
        return r8.mCurrentConnectedApType;
    }

    public static /* synthetic */ int access$800(ThroughputCalculation r8) {
        return r8.mCurrentConnectedApStandard;
    }

    public static /* synthetic */ ThroughputCallback access$900(ThroughputCalculation r8) {
        return r8.mThroughputCallback;
    }

    private void clearSingleThroughputCalculationInstances() {
        this.calculationMap.clear();
    }

    private void handleStateChanged(Intent r8) {
        String r10 = r8.getAction();
        if ("android.net.wifi.supplicant.STATE_CHANGE".equals(r10) == false) goto L16;
        SupplicantState r11 = (SupplicantState) r8.getParcelableExtra("newState");
        if (r11 != null) goto L7;
    L9:
        if (r11 != null) goto L11;
        return;
    L11:
        if (r11 != SupplicantState.COMPLETED) goto L47;
        WifiInfo r12 = this.mWifiManager.getConnectionInfo();
        if (r12 == null) goto L48;
        this.mPrimaryFreq = r12.getFrequency();
        defpackage.a.j(new StringBuilder("Primary Wi-Fi connected, frequency: "), this.mPrimaryFreq, TAG);
        return;
    L48:
        return;
    L47:
        return;
    L7:
        if (r11 != SupplicantState.DISCONNECTED) goto L9;
        clearSingleThroughputCalculationInstances();
        this.mLastWifiInfo = null;
        this.mCurrentWifiInfo = null;
        this.mPrimaryFreq = -1;
        return;
    L16:
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r10) == false) goto L23;
        if (r8.getIntExtra("wifi_state", 4) != 1) goto L50;
        clearSingleThroughputCalculationInstances();
        this.mLastWifiInfo = null;
        this.mCurrentWifiInfo = null;
        ThroughputCallback r13 = this.mThroughputCallback;
        if (r13 == null) goto L51;
        r13.onWifiConnectStateChanged(0);
        return;
    L51:
        return;
    L50:
        return;
    L23:
        if ("android.net.wifi.STATE_CHANGE".equals(r10) == false) goto L53;
        NetworkInfo r14 = (NetworkInfo) r8.getParcelableExtra("networkInfo");
        if (r14 != null) goto L27;
        return;
    L27:
        if (r14.getType() == 1) goto L29;
        return;
    L29:
        if (r14.isConnected() == false) goto L39;
        this.mThroughputCallback.onWifiConnectStateChanged(1);
        WifiInfo r15 = this.mWifiManager.getConnectionInfo();
        if (r15 == null) goto L56;
        this.mCurrentConnectedApMacAddress = r15.getBSSID();
        this.mCurrentConnectedApSsid = r15.getSSID();
        this.mCurrentConnectedApFrequency = r15.getFrequency();
        this.mCurrentConnectedApTimestamp = System.currentTimeMillis();
        this.mCurrentConnectedApAuthType = CaeUtil.getWiFiAuthTypeFromWifiInfo(r15);
        this.mCurrentConnectedApStandard = r15.getWifiStandard();
        this.mCurrentConnectedApType = -1;
        Iterator<WifiConfiguration> r16 = this.mWifiManager.getConfiguredNetworks().iterator();
    L34:
        if (r16.hasNext() == false) goto L59;
        WifiConfiguration r17 = r16.next();
        if (r17.SSID.equals(this.mCurrentConnectedApSsid) == false) goto L34;
        this.mCurrentConnectedApType = WifiConfiguration.isMetered(r17, r15) ? 1 : 0;
        return;
    L59:
        return;
    L56:
        return;
    L39:
        if (r14.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) goto L58;
        this.mThroughputCallback.onWifiConnectStateChanged(0);
        this.mCurrentConnectedApMacAddress = null;
        this.mCurrentConnectedApSsid = null;
        this.mCurrentConnectedApFrequency = Integer.MIN_VALUE;
        this.mCurrentConnectedApTimestamp = Long.MAX_VALUE;
        this.mCurrentConnectedApAuthType = 0;
        this.mCurrentConnectedApStandard = 0;
        return;
    L58:
        return;
    }

    private void initReceiver() {
        IntentFilter r8 = new IntentFilter();
        this.mFilter = r8;
        r8.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        this.mFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        this.mFilter.addAction("android.net.wifi.STATE_CHANGE");
        BroadcastReceiver r10 = new AnonymousClass1(this);
        this.mReceiver = r10;
        this.mContext.registerReceiver(r10, this.mFilter);
    }

    private boolean isSameBand(int r8, int r10) {
        if (CaeUtil.getCurrentWifiBand(r8) != CaeUtil.getCurrentWifiBand(r10)) goto L5;
        return true;
    L5:
        return false;
    }

    public int getThroughput() {
        SingleThroughputCalculation r8 = this.calculationMap.get(PRIMARY_INTERFACE);
        if (r8 != null) goto L5;
        return 0;
    L5:
        return r8.getThroughput();
    }

    public int getThroughputJitter() {
        SingleThroughputCalculation r8 = this.calculationMap.get(PRIMARY_INTERFACE);
        if (r8 != null) goto L5;
        return 0;
    L5:
        return r8.getThroughputJitter();
    }

    public float getThroughputJitterWeight() {
        SingleThroughputCalculation r8 = this.calculationMap.get(PRIMARY_INTERFACE);
        if (r8 != null) goto L5;
        return 0.0f;
    L5:
        return r8.getThroughputJitterWeight();
    }

    public void setThroughputCallback(ThroughputCallback r8) {
        this.mThroughputCallback = r8;
    }

    public void updateThroughputFormulaConfigs(String r8) {
        Iterator<SingleThroughputCalculation> r10 = this.calculationMap.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().updateThroughputFormulaConfigs(r8);
        goto L4
    }

    public void updateThroughputFormulaConfigs2(String r8) {
        ThroughputConfigLoader.applyConfigFromJson(r8);
    }

    public void updateThroughputJitterSegmentConfigs(String r8) {
        Iterator<SingleThroughputCalculation> r10 = this.calculationMap.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().updateThroughputJitterSegmentConfigs(r8);
        goto L4
    }

    public void updateThroughputJitterWeightProportion(float r8) {
        Iterator<SingleThroughputCalculation> r10 = this.calculationMap.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().updateThroughputJitterWeightProportion(r8);
        goto L4
    }
}
