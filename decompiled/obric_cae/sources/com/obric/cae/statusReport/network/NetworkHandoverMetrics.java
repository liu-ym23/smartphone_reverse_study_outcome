package com.obric.cae.statusReport.network;

import android.content.Context;
import android.net.Network;
import android.net.wifi.WifiInfo;
import com.obric.cae.cldReport.CldInternalReport;
import com.obric.cae.cldReport.network.NetworkLogUtil;
import com.obric.cae.log.CaeLog;
import com.obric.cae.network.CaeNetworkHandoverData;
import com.obric.cae.network.CaeNetworkHandoverProto;
import com.obric.cae.network.CellularInfoData;
import com.obric.cae.network.NetworkQoE;
import com.obric.cae.network.SwitchNetworkData;
import com.obric.cae.network.SwitchTrafficData;
import com.obric.cae.network.WifiInfoData;
import com.obric.cae.smartNetwork.networkHandover.NetworkScore;
import com.obric.cae.smartNetwork.networkHandover.NetworkUtil;
import com.obric.cae.smartNetwork.networkHandoverRL.ModelSettingObserver;
import com.obric.cae.smartNetwork.networkHandoverRL.NetworkSwitchPolicyML;
import com.obric.cae.smartNetwork.qoe.NetworkQoEMonitor;
import com.obric.cae.utils.CaeUtil;
import defpackage.b;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkHandoverMetrics {
    private static final String TAG = "NetworkHandoverMetrics";
    private NetworkInfoCollect.CellularInfo mCellInfo;
    private NetworkQoECollect.QoEInfo mCellQoEInfo;
    private final Context mContext;
    private NetworkTrafficCollect.DataUsage mDataUsage;
    private NetworkInfoCollect.HandoverInfo mHandoverInfo;
    private final ModelSettingObserver mModelSettingObserver;
    private final NetworkInfoCollect mNetworkInfoCollect;
    private final NetworkQoECollect mNetworkQoECollect;
    private final NetworkQoEInfoCollector mNetworkQoEInfoCollector;
    private final NetworkSwitchPolicyML mNetworkSwitchPolicyML;
    private final NetworkTrafficCollect mNetworkTrafficCollect;
    private final ConcurrentHashMap<Integer, NetworkScore> mScores;
    private int mSwitchReason;
    private WifiInfo mWifiInfo;
    private NetworkQoECollect.QoEInfo mWifiQoEInfo;

    public NetworkHandoverMetrics(Context r8, NetworkQoEMonitor r10) {
        this.mScores = new ConcurrentHashMap();
        this.mContext = r8;
        this.mNetworkTrafficCollect = new NetworkTrafficCollect(r8);
        this.mNetworkQoECollect = new NetworkQoECollect(r8, r10);
        this.mNetworkInfoCollect = NetworkInfoCollect.getInstance(r8);
        this.mModelSettingObserver = ModelSettingObserver.getInstance(r8);
        this.mNetworkQoEInfoCollector = NetworkQoEInfoCollector.getInstance(r8);
        this.mNetworkSwitchPolicyML = NetworkSwitchPolicyML.getInstance(r8);
    }

    private void buildDataUsageProtoBufData() {
        SwitchTrafficData.Builder r8 = SwitchTrafficData.newBuilder();
        r8.setTimestamp(System.currentTimeMillis());
        r8.setSolutionType(getSolutionType());
        NetworkTrafficCollect.DataUsage r10 = this.mDataUsage;
        if (r10 == null) goto L8;
        r8.setDwellTime(r10.getDwellTime());
        r8.setDataUsage(this.mDataUsage.getDataUsage());
        Iterator<Map.Entry<String, Long>> r11 = this.mDataUsage.getAppDataUsage().entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        Map.Entry<String, Long> r12 = r11.next();
        SwitchTrafficData.AppDataUsageData.Builder r13 = SwitchTrafficData.AppDataUsageData.newBuilder();
        r13.setPackageName(r12.getKey()).setDataUsage(r12.getValue().longValue());
        r8.addAppDataUsage(r13);
    L8:
        CaeNetworkHandoverData.Builder r14 = CaeNetworkHandoverData.newBuilder();
        r14.setSwitchTrafficEvent(r8);
        CaeNetworkHandoverProto.Builder r15 = CaeNetworkHandoverProto.newBuilder();
        r15.addNetworkHandoverEvent(r14);
        CaeLog.d(TAG, "report data usage pb event data.");
        CaeUtil.writePbEventSafely(System.currentTimeMillis(), 95, r15.build().toByteArray());
    }

    private void buildSwitchProtoBufData() {
        SwitchNetworkData.Builder r8 = SwitchNetworkData.newBuilder();
        NetworkInfoCollect.HandoverInfo r10 = this.mHandoverInfo;
        if (r10 == null) goto L5;
        r8.setIsSuccess(r10.isSuccess()).setSwitchMode(this.mHandoverInfo.getMode()).setSwitchReason(this.mHandoverInfo.getReason()).setSwitchSubReason(this.mHandoverInfo.getSubReason()).setForegroundApp(safeString(this.mHandoverInfo.getForegroundApp())).setFailedReason(this.mHandoverInfo.getFailedReason()).setSwitchTimes(this.mHandoverInfo.getSwitchTimes());
    L5:
        r8.setTimestamp(System.currentTimeMillis());
        r8.setSolutionType(getSolutionType());
        WifiInfoData.Builder r11 = WifiInfoData.newBuilder();
        WifiInfo r12 = this.mWifiInfo;
        if (r12 == null) goto L17;
        String r13 = "";
        if (r12.getSSID() == null) goto L10;
        String r14 = this.mWifiInfo.getSSID();
    L12:
        if (this.mWifiInfo.getBSSID() == null) goto L14;
        r13 = this.mWifiInfo.getBSSID();
    L14:
        r11.setSsid(r14).setBssid(r13).setRssi(this.mWifiInfo.getRssi()).setFreq(this.mWifiInfo.getFrequency()).setStandard(this.mWifiInfo.getWifiStandard()).setLinkspeed(this.mWifiInfo.getLinkSpeed()).setL2AverageTput(this.mWifiQoEInfo.getL2AverageTput()).setL2AverageJitter(this.mWifiQoEInfo.getL2AverageJitter()).setTcpAverageRtt(this.mWifiQoEInfo.getTcpAverageRtt()).setTcpRetryRate(this.mWifiQoEInfo.getTcpRetryRate());
        ConcurrentLinkedQueue<NetworkQoE> r15 = this.mNetworkQoEInfoCollector.getRingBufferQoEInfo(1);
        if (r15 == null) goto L17;
        r11.addAllNetworkQoe(r15);
        goto L17
    L10:
        r14 = "";
    L17:
        CellularInfoData.Builder r16 = CellularInfoData.newBuilder();
        NetworkInfoCollect.CellularInfo r17 = this.mCellInfo;
        if (r17 == null) goto L22;
        r16.setSubid(r17.getSubId()).setType(this.mCellInfo.getType()).setCellId(this.mCellInfo.getCellId()).setRsrp(this.mCellInfo.getRsrp()).setTcpAverageRtt(this.mCellQoEInfo.getTcpAverageRtt()).setTcpRetryRate(this.mCellQoEInfo.getTcpRetryRate());
        ConcurrentLinkedQueue<NetworkQoE> r18 = this.mNetworkQoEInfoCollector.getRingBufferQoEInfo(0);
        if (r18 == null) goto L22;
        r16.addAllNetworkQoe(r18);
    L22:
        NetworkInfoCollect.HandoverInfo r19 = this.mHandoverInfo;
        if (r19 != null) goto L25;
    L27:
        NetworkInfoCollect.HandoverInfo r20 = this.mHandoverInfo;
        if (r20 != null) goto L30;
    L32:
        CaeNetworkHandoverData.Builder r21 = CaeNetworkHandoverData.newBuilder();
        r21.setSwitchNetworkEvent(r8);
        NetworkInfoCollect.HandoverInfo r22 = this.mHandoverInfo;
        if (r22 != null) goto L35;
    L45:
        CaeNetworkHandoverProto.Builder r23 = CaeNetworkHandoverProto.newBuilder();
        r23.addNetworkHandoverEvent(r21);
        CaeLog.i(TAG, "report network switch pb event data.");
        CaeUtil.writePbEventSafely(System.currentTimeMillis(), 95, r23.build().toByteArray());
        return;
    L35:
        if (r22.isSuccess() == false) goto L45;
        if (this.mHandoverInfo.getMode() != 2) goto L45;
        SwitchTrafficData.Builder r24 = SwitchTrafficData.newBuilder();
        r24.setTimestamp(System.currentTimeMillis());
        r24.setSolutionType(getSolutionType());
        NetworkTrafficCollect.DataUsage r25 = this.mDataUsage;
        if (r25 == null) goto L44;
        r24.setDwellTime(r25.getDwellTime());
        r24.setDataUsage(this.mDataUsage.getDataUsage());
        Iterator<Map.Entry<String, Long>> r26 = this.mDataUsage.getAppDataUsage().entrySet().iterator();
    L42:
        if (r26.hasNext() == false) goto L44;
        Map.Entry<String, Long> r27 = r26.next();
        SwitchTrafficData.AppDataUsageData.Builder r28 = SwitchTrafficData.AppDataUsageData.newBuilder();
        r28.setPackageName(r27.getKey()).setDataUsage(r27.getValue().longValue());
        r24.addAppDataUsage(r28);
    L44:
        r21.setSwitchTrafficEvent(r24);
        goto L45
    L30:
        if (r20.getMode() != 2) goto L32;
        r8.setBeforeCellular(r16).setAfterWifi(r11);
        goto L32
    L25:
        if (r19.getMode() != 1) goto L27;
        r8.setBeforeWifi(r11).setAfterCellular(r16);
        goto L32
    }

    private void collectHandoverInfo(boolean r8, int r10, int r11, int r12) {
        Network r13 = NetworkUtil.getNetworkForNetId(this.mContext, r11);
        Network r14 = NetworkUtil.getNetworkForNetId(this.mContext, r12);
        if (r13 == null) goto L15;
        if (r14 == null) goto L15;
        this.mWifiQoEInfo = this.mNetworkQoECollect.getWifiQoEInfo();
        this.mCellQoEInfo = this.mNetworkQoECollect.getCellQoEInfo();
        NetworkInfoCollect.HandoverInfo r15 = this.mNetworkInfoCollect.getHandoverInfo(r13, r14, this.mScores);
        this.mHandoverInfo = r15;
        r15.setIsSuccess(r8);
        this.mHandoverInfo.setReason(this.mSwitchReason);
        this.mHandoverInfo.setFailedReason(r10);
        this.mWifiInfo = this.mNetworkInfoCollect.getWifiInfoForNetwork();
        this.mCellInfo = this.mNetworkInfoCollect.getCellInfoForNetwork();
        if (r8 == true) goto L9;
        return;
    L9:
        if (this.mHandoverInfo.getMode() != 1) goto L12;
        this.mNetworkTrafficCollect.startQueryNetworkTraffic();
        CldInternalReport.reportErrorEvent(2, 1, 1, NetworkLogUtil.getHandoverReason(this.mHandoverInfo.getSubReason()), null);
        return;
    L12:
        if (this.mHandoverInfo.getMode() != 2) goto L19;
        this.mDataUsage = this.mNetworkTrafficCollect.stopQueryNetworkTraffic();
        CldInternalReport.reportErrorEvent(2, 1, 2, NetworkLogUtil.getHandoverReason(this.mHandoverInfo.getSubReason()), null);
        return;
    L19:
        return;
    L15:
        CaeLog.e(TAG, "recordNetworkSwitchEvent: beforeNetwork or afterNetwork is null");
    }

    private void collectNoCellHandoverFailInfo(int r8, int r10) {
        this.mWifiInfo = this.mNetworkInfoCollect.getWifiInfoForNetwork();
        this.mCellInfo = null;
        this.mWifiQoEInfo = this.mNetworkQoECollect.getWifiQoEInfo();
        NetworkInfoCollect.HandoverInfo r11 = this.mNetworkInfoCollect.getNoCellFailHandoverInfo(r8, this.mScores);
        this.mHandoverInfo = r11;
        r11.setIsSuccess(false);
        this.mHandoverInfo.setReason(this.mSwitchReason);
        this.mHandoverInfo.setFailedReason(r10);
    }

    private int getSolutionType() {
        if (this.mModelSettingObserver.getRlHandoverEnabled() == false) goto L9;
        if (this.mNetworkSwitchPolicyML.isAvailable() == false) goto L9;
        return 2;
    L9:
        if (this.mModelSettingObserver.getClusterHandoverEnabled() == false) goto L12;
        return 3;
    L12:
        return 1;
    }

    private void reportDataUsageProtoBufDataSafely() {
        buildDataUsageProtoBufData();     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        CaeLog.e(TAG, "report data usage protobuf data failed", e);
    }

    private void reportSwitchProtoBufDataSafely() {
        buildSwitchProtoBufData();     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        CaeLog.e(TAG, "report switch protobuf data failed", e);
    }

    private static String safeString(String r8) {
        if (r8 != null) goto L6;
        return "";
    L6:
        return r8;
    }

    public void recordNetworkConnectedEvent(int r8, NetworkScore r10) {
        b.m("recordNetworkConnectedEvent: netId = ", r8, TAG);
        this.mScores.putIfAbsent(Integer.valueOf(r8), r10);
    }

    public void recordNetworkDisconnectedEvent(int r8) {
        b.m("recordNetworkDisconnectedEvent: netId = ", r8, TAG);
        NetworkScore r10 = this.mScores.get(Integer.valueOf(r8));
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.getNetType() != 1) goto L9;
        this.mNetworkQoECollect.clearWifiQoEInfo();
    L11:
        this.mScores.remove(Integer.valueOf(r8));
        if (this.mNetworkTrafficCollect.isCollecting() == true) goto L14;
        return;
    L14:
        if (this.mCellInfo == null) goto L18;
        this.mDataUsage = this.mNetworkTrafficCollect.stopQueryNetworkTraffic();
        reportDataUsageProtoBufDataSafely();
        return;
    L18:
        return;
    L9:
        if (r10.getNetType() != 0) goto L11;
        this.mNetworkQoECollect.clearCellQoEInfo();
        goto L11
    }

    public void recordNetworkHandoverReason(int r8) {
        b.m("recordNetworkHandoverReason: reason = ", r8, TAG);
        this.mSwitchReason = r8;
    }

    public void recordNetworkScoreChangeEvent(NetworkScore r8) {
        CaeLog.d(TAG, "recordNetworkScoreChangeEvent: score = " + r8);
        if (this.mScores.containsKey(Integer.valueOf(r8.getNetId())) == false) goto L6;
        this.mScores.put(Integer.valueOf(r8.getNetId()), r8);
        return;
    }

    public void reportHandoverFail(int r8, int r10, int r11) {
        if (r10 != (-1)) goto L5;
        collectNoCellHandoverFailInfo(r8, r11);
    L6:
        reportSwitchProtoBufDataSafely();
        return;
    L5:
        collectHandoverInfo(false, r11, r8, r10);
        goto L6
    }

    public void reportHandoverSuccess(int r8, int r10) {
        collectHandoverInfo(true, 0, r8, r10);
        reportSwitchProtoBufDataSafely();
    }

    public void start() {
        this.mNetworkQoECollect.start();
    }

    public void stop() {
        this.mNetworkQoECollect.stop();
    }
}
