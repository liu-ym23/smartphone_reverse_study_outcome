package com.obric.cae.smartNetwork.networkHandoverRL.feedback;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.TelephonyManager;
import androidx.activity.j;
import com.obric.cae.cldReport.CldInternalReport;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.networkHandoverRL.ModelSettingObserver;
import com.obric.cae.smartNetwork.networkHandoverRL.NetworkSwitchPolicyML;
import com.obric.cae.smartNetwork.networkHandoverRL.feature.FeatureData;
import com.obric.cae.smartNetwork.networkHandoverRL.feature.FeatureStorage;
import com.obric.cae.statusReport.network.HandoverFeedback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class WifiCellSwitchMonitor {
    private static volatile WifiCellSwitchMonitor sInstance;
    private final String TAG;
    private final int USER_DISABLE_CELL;
    private final int USER_DISABLE_WIFI;
    private final int USER_NO_OPERATION;
    private final Context mContext;
    private final FeatureStorage mFeatureStorage;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private FeatureData mHandoverFeature;
    private final HandoverFeedback mHandoverFeedback;
    private long mHandoverTimestamp;
    private final ModelSettingObserver mModelSettingObserver;
    private final HashMap<Integer, Integer> mNetworks;
    private final TelephonyManager mTelephonyManager;
    private final WifiManager mWifiManager;

    private WifiCellSwitchMonitor(Context r8) {
        this.TAG = "WifiCellSwitchMonitor";
        this.USER_DISABLE_WIFI = 1;
        this.USER_DISABLE_CELL = 2;
        this.USER_NO_OPERATION = 3;
        this.mNetworks = new HashMap();
        HandlerThread r10 = new HandlerThread("WifiCellSwitchMonitor");
        this.mHandlerThread = r10;
        this.mHandoverTimestamp = -1;
        this.mContext = r8;
        this.mWifiManager = (WifiManager) r8.getSystemService("wifi");
        this.mTelephonyManager = (TelephonyManager) r8.getSystemService("phone");
        r10.start();
        this.mHandler = new Handler(r10.getLooper());
        this.mFeatureStorage = FeatureStorage.getInstance(r8);
        this.mModelSettingObserver = ModelSettingObserver.getInstance(r8);
        this.mHandoverFeedback = HandoverFeedback.getInstance(r8);
    }

    public static /* synthetic */ void a(WifiCellSwitchMonitor r8) {
        r8.lambda$notifyNetworkHandover$0();
    }

    private void checkCellToggleStatus() {
        if (isWifiConnected() == true) goto L5;
        return;
    L5:
        if (isCellEnabled() == false) goto L7;
        return;
    L7:
        if ((System.currentTimeMillis() - this.mHandoverTimestamp) > this.mModelSettingObserver.getSatisfiedHandoverTimeoutMs()) goto L12;
        this.mHandler.removeCallbacksAndMessages(null);
        reportToggleEvent(2);
        return;
    }

    private void checkWifiToggleStatus() {
        if (isCellularConnected() == true) goto L5;
        return;
    L5:
        if (isWifiEnabled() == true) goto L9;
        reportToggleEvent(1);
        return;
    }

    public static WifiCellSwitchMonitor getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(WifiCellSwitchMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new WifiCellSwitchMonitor(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(WifiCellSwitchMonitor.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private NetworkSwitchPolicyML getNetworkSwitchPolicyML() {
        return NetworkSwitchPolicyML.getInstance(this.mContext);
    }

    private boolean isCellEnabled() {
        return this.mTelephonyManager.isDataEnabled();
    }

    private boolean isCellNetwork(int r8) {
        if (this.mNetworks.get(Integer.valueOf(r8)).intValue() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isCellularConnected() {
        Iterator<Map.Entry<Integer, Integer>> r8 = this.mNetworks.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        if (isCellNetwork(r8.next().getKey().intValue()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean isWifiConnected() {
        Iterator<Map.Entry<Integer, Integer>> r8 = this.mNetworks.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        if (isWifiNetwork(r8.next().getKey().intValue()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean isWifiEnabled() {
        return this.mWifiManager.isWifiEnabled();
    }

    private boolean isWifiNetwork(int r8) {
        if (this.mNetworks.get(Integer.valueOf(r8)).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private /* synthetic */ void lambda$notifyNetworkHandover$0() {
        reportToggleEvent(3);
    }

    private void reportToggleEvent(int r13) {
        FeatureData r8 = this.mFeatureStorage.getLatestFeature();
        if (r13 == 1) goto L39;
        if (r13 == 2) goto L24;
        if (r13 == 3) goto L8;
        CaeLog.e(this.TAG, "unknown toggle event");
        return;
    L8:
        if (this.mHandoverFeature != null) goto L12;
        String r12 = this.TAG;
        String r14 = "reportToggleEvent: USER_NO_OPERATION, handoverFeature is null";
    L10:
        CaeLog.e(r12, r14);
        return;
    L12:
        CaeLog.i(this.TAG, "reportToggleEvent: USER_NO_OPERATION, index=" + this.mHandoverFeature.getIndex() + ", feature=" + this.mHandoverFeature.toString());
        NetworkSwitchPolicyML r15 = getNetworkSwitchPolicyML();
        if (this.mModelSettingObserver.getRlHandoverEnabled() == false) goto L19;
        if (r15.isAvailable() == false) goto L17;
        r15.notifyResult(this.mHandoverFeature.getIndex(), 2);
    L17:
        this.mHandoverFeedback.reportSwitchAndNoInterveneEvent(2, this.mHandoverTimestamp, this.mHandoverFeature);
    L22:
        int r16 = 6;
    L52:
        CldInternalReport.reportErrorEvent(2, 1, 3, r16, null);
        return;
    L19:
        if (this.mModelSettingObserver.getClusterHandoverEnabled() == false) goto L21;
        this.mHandoverFeedback.reportSwitchAndNoInterveneEvent(3, this.mHandoverTimestamp, this.mHandoverFeature);
        goto L22
    L21:
        this.mHandoverFeedback.reportSwitchAndNoInterveneEvent(1, this.mHandoverTimestamp, this.mHandoverFeature);
        goto L22
    L24:
        if (this.mHandoverFeature == null) goto L38;
        if (r8 == null) goto L38;
        CaeLog.i(this.TAG, "reportToggleEvent: USER_DISABLE_CELL, index=" + this.mHandoverFeature.getIndex() + ", feature=" + this.mHandoverFeature.toString());
        NetworkSwitchPolicyML r17 = getNetworkSwitchPolicyML();
        if (this.mModelSettingObserver.getRlHandoverEnabled() == true) goto L30;
        boolean r18 = this.mModelSettingObserver.getClusterHandoverEnabled();
        HandoverFeedback r10 = this.mHandoverFeedback;
        if (r18 == false) goto L36;
        int r11 = 3;
    L37:
        r10.reportSwitchAndInterveneEvent(r11, this.mHandoverTimestamp, this.mHandoverFeature, System.currentTimeMillis(), r8);
        r16 = 4;
        goto L52
    L36:
        r11 = 1;
        goto L37
    L30:
        if (r17.isAvailable() == false) goto L32;
        r17.notifyResult(this.mHandoverFeature.getIndex(), 1);
    L32:
        r10 = this.mHandoverFeedback;
        r11 = 2;
    L38:
        r12 = this.TAG;
        r14 = "reportToggleEvent: USER_DISABLE_CELL, handoverFeature or latestFeature is null";
        goto L10
    L39:
        if (r8 != null) goto L41;
        r12 = this.TAG;
        r14 = "reportToggleEvent: USER_DISABLE_WIFI, latestFeature is null";
        goto L10
    L41:
        CaeLog.i(this.TAG, "reportToggleEvent: USER_DISABLE_WIFI, index=" + r8.getIndex() + ", feature=" + r8.toString());
        NetworkSwitchPolicyML r19 = getNetworkSwitchPolicyML();
        if (this.mModelSettingObserver.getRlHandoverEnabled() == true) goto L44;
        boolean r110 = this.mModelSettingObserver.getClusterHandoverEnabled();
        HandoverFeedback r111 = this.mHandoverFeedback;
        long r20 = System.currentTimeMillis();
        if (r110 == false) goto L50;
        r111.reportNoSwitchAndInterveneEvent(3, r20, r8);
    L51:
        r16 = 5;
        goto L52
    L50:
        r111.reportNoSwitchAndInterveneEvent(1, r20, r8);
        goto L51
    L44:
        if (r19.isAvailable() == false) goto L46;
        r19.notifyResult(r8.getIndex(), 0);
    L46:
        this.mHandoverFeedback.reportNoSwitchAndInterveneEvent(2, System.currentTimeMillis(), r8);
        goto L51
    }

    public void addNetwork(int r8, int r10) {
        this.mNetworks.put(Integer.valueOf(r8), Integer.valueOf(r10));
    }

    public void notifyNetworkHandover(int r8, FeatureData r10) {
        if (r8 != 1) goto L7;
        this.mHandoverFeature = r10;
        this.mHandoverTimestamp = System.currentTimeMillis();
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.postDelayed(new j(this, 26), this.mModelSettingObserver.getSatisfiedHandoverTimeoutMs());
        return;
    }

    public void release() {
        this.mNetworks.clear();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void removeNetwork(int r8) {
        if (this.mNetworks.containsKey(Integer.valueOf(r8)) == true) goto L7;
        CaeLog.e(this.TAG, "removeNetwork: netId " + r8 + " not found");
        return;
    L7:
        if (isWifiNetwork(r8) == false) goto L10;
        checkWifiToggleStatus();
    L12:
        this.mNetworks.remove(Integer.valueOf(r8));
        return;
    L10:
        if (isCellNetwork(r8) == false) goto L12;
        checkCellToggleStatus();
        goto L12
    }
}
