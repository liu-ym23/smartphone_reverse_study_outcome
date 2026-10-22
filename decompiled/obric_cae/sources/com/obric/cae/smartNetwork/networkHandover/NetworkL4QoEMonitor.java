package com.obric.cae.smartNetwork.networkHandover;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Message;
import android.os.SystemProperties;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkL4QoEMonitor {
    private static final String NETWORK_CELL_SCORE_PROPERTY_KEY = "sys.net.cell.score";
    private static final String NETWORK_WIFI_SCORE_PROPERTY_KEY = "sys.net.wifi.score";
    private static final String TAG = "NetworkL4QoEMonitor";
    private static final int WIFI_SIGNAL_LEVEL_NUM = 5;
    private static final int WIFI_SIGNAL_LEVEL_THRESHOLD = 3;
    private final Context mContext;
    private final HandoverParameterManager mHandoverParameterManager;
    private final L4NetEvaluate.L4NetErrReportCb mL4NetErrReportCb;
    private final L4NetEvaluate mL4NetEvaluate;
    private final ConcurrentHashMap<Integer, Integer> mLastUnackedByNetId;
    private final Set<Integer> mMonitoredNetIds;
    private final NetworkPolicyCenter mNetworkPolicyCenter;
    private final WifiManager mWifiManager;

    public NetworkL4QoEMonitor(Context r8, NetworkPolicyCenter r10) {
        this.mMonitoredNetIds = ConcurrentHashMap.newKeySet();
        this.mLastUnackedByNetId = new ConcurrentHashMap();
        this.mL4NetErrReportCb = new AnonymousClass1(this);
        this.mContext = r8;
        this.mNetworkPolicyCenter = r10;
        this.mHandoverParameterManager = HandoverParameterManager.getInstance(r8);
        this.mL4NetEvaluate = L4NetEvaluate.getInstance(r8);
        this.mWifiManager = (WifiManager) r8.getSystemService("wifi");
    }

    public static /* synthetic */ Context access$000(NetworkL4QoEMonitor r8) {
        return r8.mContext;
    }

    public static /* synthetic */ boolean access$100(NetworkL4QoEMonitor r8, int r10) {
        return r8.isNetworkMonitored(r10);
    }

    public static /* synthetic */ void access$200(NetworkL4QoEMonitor r8, int r10, L4NetEvaluate.L4NetStats r11) {
        r8.evaluateNetworkL4Qos(r10, r11);
    }

    private int computeDeltaUnacked(int r8, int r10) {
        Integer r11 = this.mLastUnackedByNetId.get(Integer.valueOf(r8));
        if (r11 != null) goto L5;
        return r10;
    L5:
        return Math.max(0, r10 - r11.intValue());
    }

    private void evaluateNetworkL4Qos(int r8, L4NetEvaluate.L4NetStats r10) {
        if (isNetworkMonitored(r8) == true) goto L5;
        return;
    L5:
        int r11 = NetworkUtil.getNetworkTypeForNetId(this.mContext, r8);
        r10.unacked = getAdjustedL4Unacked(r8, r10.unacked, r11);
        int r12 = NetworkQoeScore.getNetworkScore(r10);
        String r13 = TAG;
        StringBuilder r14 = defpackage.b.f("netId: ", r8, ", ifName: ");
        r14.append(r10.ifName);
        r14.append(", l4QosScore: ");
        r14.append(r12);
        r14.append(", stats: ");
        r14.append(r10);
        CaeLog.i(r13, r14.toString());
        updateNetworkScore(r8, r12);
        if (r12 <= this.mHandoverParameterManager.getNetworkL4QoeBadThreshold()) goto L9;
        NetworkPolicyCenter r15 = this.mNetworkPolicyCenter;
        int r16 = 8;
    L11:
        Message r17 = r15.obtainMessage(r16, r8, 0);
        this.mNetworkPolicyCenter.sendMessage(r17);
        return;
    L9:
        if (r12 >= this.mHandoverParameterManager.getNetworkL4QoeGoodThreshold()) goto L13;
        r15 = this.mNetworkPolicyCenter;
        r16 = 7;
        goto L11
    }

    private int getAdjustedL4Unacked(int r8, int r10, int r11) {
        if (r11 == 1) goto L5;
    L8:
        int r12 = computeDeltaUnacked(r8, r10);
    L9:
        this.mLastUnackedByNetId.put(Integer.valueOf(r8), Integer.valueOf(r10));
        return r12;
    L5:
        if (isStrongWifiSignal() == true) goto L8;
        r12 = r10;
        goto L9
    }

    private boolean isNetworkMonitored(int r8) {
        return this.mMonitoredNetIds.contains(Integer.valueOf(r8));
    }

    private boolean isStrongWifiSignal() {
        WifiManager r8 = this.mWifiManager;
        if (r8 != null) goto L16;
        return false;
    L16:
        WifiInfo r10 = r8.getConnectionInfo();     // Catch: Exception -> L13
        if (r10 != null) goto L8;
        return false;
    L8:
        if (WifiManager.calculateSignalLevel(r10.getRssi(), 5) < 3) goto L18;
        return true;
    L18:
        return false;
    L13:
        e = move-exception;
        String r11 = TAG;
        defpackage.b.k(e, new StringBuilder("isStrongWifiSignal failed: "), r11);
        return false;
    }

    private void updateNetworkScore(int r8, int r10) {
        int r11 = NetworkUtil.getNetworkTypeForNetId(this.mContext, r8);
        if (r11 == 0) goto L19;
        if (r11 == 1) goto L21;
        return;
    L21:
        SystemProperties.set(NETWORK_WIFI_SCORE_PROPERTY_KEY, String.valueOf(r10));     // Catch: Exception -> L10
        return;
    L10:
        e = e;
        String r12 = TAG;
        StringBuilder r13 = new StringBuilder("set wifi score failed: ");
    L17:
        r13.append(e);
        CaeLog.e(r12, r13.toString());
        return;
    L19:
        SystemProperties.set(NETWORK_CELL_SCORE_PROPERTY_KEY, String.valueOf(r10));     // Catch: Exception -> L15
        return;
    L15:
        e = e;
        r12 = TAG;
        r13 = new StringBuilder("set cell score failed: ");
        goto L17
    }

    public void addNetworkQoEMonitor(int r8) {
        defpackage.a.i("add network l4 qoe monitor: ", r8, TAG);
        this.mMonitoredNetIds.add(Integer.valueOf(r8));
    }

    public void removeNetworkQoEMonitor(int r8) {
        defpackage.a.i("remove network l4 qoe monitor: ", r8, TAG);
        this.mMonitoredNetIds.remove(Integer.valueOf(r8));
    }

    public void start() {
        CaeLog.i(TAG, "start NetworkL4QoEMonitor");
        this.mL4NetEvaluate.registerErrReportCb(this.mL4NetErrReportCb);
    }

    public void stop() {
        CaeLog.i(TAG, "stop NetworkL4QoEMonitor");
        this.mL4NetEvaluate.unregisterErrReportCb(this.mL4NetErrReportCb);
        this.mMonitoredNetIds.clear();
        this.mLastUnackedByNetId.clear();
    }
}
