package com.obric.cae.statusReport.wifi;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.cae.caed.WifiStatsParcel;
import com.obric.cae.libs.statusreport.LinkLayerQuality;
import com.obric.cae.libs.statusreport.LinkStatsParcel;
import com.obric.cae.utils.CaeWifiUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class LinkLayerQualityAgent {
    private static final String TAG = "LinkLayerQualityAgent";
    private Context mContext;
    private LinkLayerQuality mCurrentQuality;
    private String mIfName;
    private String mWifiGeneration;

    public LinkLayerQualityAgent(Context r8, String r10) {
        this.mCurrentQuality = null;
        this.mWifiGeneration = "";
        this.mContext = r8;
        this.mIfName = r10;
        this.mCurrentQuality = new LinkLayerQuality();
        WifiManager r11 = (WifiManager) this.mContext.getSystemService("wifi");
        if (r11 == null) goto L8;
        WifiInfo r12 = r11.getConnectionInfo();
        if (r12 == null) goto L9;
        this.mWifiGeneration = CaeWifiUtil.wifiStandardToGenerationString(r12.getWifiStandard());
        return;
    L9:
        return;
    }

    private List<LinkStatsParcel> convertLinkStats(List<com.cae.caed.LinkStatsParcel> r8) {
        ArrayList r10 = new ArrayList();
        if (r8 != null) goto L5;
    L12:
        r10.add(new LinkStatsParcel());
        return r10;
    L5:
        if (r8.isEmpty() == true) goto L12;
        Iterator<com.cae.caed.LinkStatsParcel> r11 = r8.iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        com.cae.caed.LinkStatsParcel r12 = r11.next();
        LinkStatsParcel r13 = new LinkStatsParcel();
        r13.setLink_id(r12.f4139a);
        r13.setRadio_id(r12.f4140b);
        r13.setCenter_freq(r12.f4141m);
        r13.setDeltaCcaBusyTime(r12.f4142n);
        r13.setDeltaRadioOnTime(r12.f4143o);
        r13.setCcaLevel(r12.f4144p);
        r13.setDeltaTxSuccess(r12.f4145q);
        r13.setDeltaTxRetries(r12.f4146r);
        r13.setTxRetranLevel(r12.f4147s);
        r13.setDeltaTxBad(r12.f4148t);
        r13.setTxBadLevel(r12.f4149u);
        r13.setDeltaRxSuccess(r12.f4150v);
        r13.setContention_atime_be(r12.f4151w);
        r13.setContention_atime_bk(r12.f4152x);
        r13.setContention_atime_vi(r12.f4153y);
        r13.setContention_atime_vo(r12.f4154z);
        r13.setTxMpduBe(r12.A);
        r13.setTxRetriesBe(r12.B);
        r13.setTxRetranLevelBe(r12.C);
        r13.setTxMpduVi(r12.D);
        r13.setTxRetriesVi(r12.E);
        r13.setTxRetranLevelVi(r12.F);
        r13.setTxMpduVo(r12.G);
        r13.setTxRetriesVo(r12.H);
        r13.setTxRetranLevelVo(r12.I);
        r13.setWidth(r12.J);
        r13.setRssi_mgmt(r12.K);
        r13.setRssi_data(r12.L);
        r13.setRssi_ack(r12.M);
        r13.setRl_tx_link_speed(r12.N);
        r13.setRl_rx_link_speed(r12.O);
        r13.setRl_cca_busy_rate(r12.P);
        r13.setPer(r12.Q);
        r13.setOn_time_scan(r12.R);
        r13.setTx_speed_kbps(r12.S);
        r13.setRx_speed_kbps(r12.T);
        r13.setPower_pred_mw(r12.U);
        r10.add(r13);
        goto L9
    L11:
        return r10;
    }

    private static String getBand1FromStats(WifiStatsParcel r8) {
        if (r8 == null) goto L10;
        ArrayList r10 = r8.H;
        if (r10 != null) goto L6;
        return "";
    L6:
        if (r10.size() >= 2) goto L9;
        return "";
    L9:
        return getBandFromFrequency(((com.cae.caed.LinkStatsParcel) r8.H.get(1)).f4141m);
    L10:
        return "";
    }

    public static String getBandFromFrequency(int r8) {
        return CaeWifiUtil.toBand(r8);
    }

    private static String getBandFromStats(WifiStatsParcel r8) {
        if (r8 == null) goto L5;
        int r10 = r8.f4204b;
        if (r10 > 0) goto L14;
        ArrayList r11 = r8.H;
        if (r11 == null) goto L14;
        if (r11.isEmpty() == true) goto L14;
        r10 = ((com.cae.caed.LinkStatsParcel) r8.H.get(0)).f4141m;
    L14:
        return getBandFromFrequency(r10);
    L5:
        return getBandFromFrequency(0);
    }

    public void cleanup() {
    }

    public LinkLayerQuality getLinkLayerQuality() {
        LinkLayerQuality r8 = this.mCurrentQuality;
        monitor-enter(r8);
        LinkLayerQuality r10 = new LinkLayerQuality(this.mCurrentQuality);     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public void updateLinkLayerQuality(WifiStatsParcel r8, int r10, int r11) {
        LinkLayerQuality r12 = this.mCurrentQuality;
        monitor-enter(r12);
        this.mCurrentQuality.setIfName(r8.f4203a);     // Catch: Throwable -> L18
        this.mCurrentQuality.setFreq(r8.f4204b);     // Catch: Throwable -> L18
        this.mCurrentQuality.setTxlinkSpeed(r8.f4205m / 10);     // Catch: Throwable -> L18
        this.mCurrentQuality.setRxlinkSpeed(r8.f4206n / 10);     // Catch: Throwable -> L18
        this.mCurrentQuality.setBand(getBandFromStats(r8));     // Catch: Throwable -> L18
        this.mCurrentQuality.setBand1(getBand1FromStats(r8));     // Catch: Throwable -> L18
        this.mCurrentQuality.setWifiGeneration(this.mWifiGeneration);     // Catch: Throwable -> L18
        this.mCurrentQuality.setDeltaRxFcsErr(r8.f4207o);     // Catch: Throwable -> L18
        this.mCurrentQuality.setRxFcsErrLevel(r8.f4208p);     // Catch: Throwable -> L18
        this.mCurrentQuality.setTotalTxBytes(r8.f4209q);     // Catch: Throwable -> L18
        this.mCurrentQuality.setDeltaTxBytes(r8.f4210r);     // Catch: Throwable -> L18
        this.mCurrentQuality.setTxRealSpeed(r8.f4211s);     // Catch: Throwable -> L18
        this.mCurrentQuality.setTotalRxBytes(r8.f4212t);     // Catch: Throwable -> L18
        this.mCurrentQuality.setDeltaRxBytes(r8.f4213u);     // Catch: Throwable -> L18
        this.mCurrentQuality.setRxRealSpeed(r8.f4214v);     // Catch: Throwable -> L18
        this.mCurrentQuality.setTxMode(r8.f4215w);     // Catch: Throwable -> L18
        this.mCurrentQuality.setTxMcs(r8.f4216x);     // Catch: Throwable -> L18
        this.mCurrentQuality.setTxBw(r8.f4217y);     // Catch: Throwable -> L18
        this.mCurrentQuality.setTxNss(r8.U);     // Catch: Throwable -> L18
        this.mCurrentQuality.setRxMode(r8.f4218z);     // Catch: Throwable -> L18
        this.mCurrentQuality.setRxMcs(r8.A);     // Catch: Throwable -> L18
        this.mCurrentQuality.setRxBw(r8.B);     // Catch: Throwable -> L18
        this.mCurrentQuality.setRxNss(r8.V);     // Catch: Throwable -> L18
        this.mCurrentQuality.setDelta_channel_on_time(r8.Q);     // Catch: Throwable -> L18
        this.mCurrentQuality.setDelta_channel_tx_time(r8.R);     // Catch: Throwable -> L18
        this.mCurrentQuality.setDelta_channel_rx_time(r8.S);     // Catch: Throwable -> L18
        this.mCurrentQuality.setDelta_channel_cca_busy_time(r8.T);     // Catch: Throwable -> L18
        this.mCurrentQuality.setCcaScore(r8.C);     // Catch: Throwable -> L18
        this.mCurrentQuality.setPerScore(r8.D);     // Catch: Throwable -> L18
        this.mCurrentQuality.setRssiScore(r8.E);     // Catch: Throwable -> L18
        this.mCurrentQuality.setScenario(r8.F);     // Catch: Throwable -> L18
        this.mCurrentQuality.setArpNeighbourCount(r11);     // Catch: Throwable -> L18
        this.mCurrentQuality.setCurrentChannelAPCount(r10);     // Catch: Throwable -> L18
        this.mCurrentQuality.setMloIface(r8.G);     // Catch: Throwable -> L18
        this.mCurrentQuality.setRxTputPred((int) r8.I);     // Catch: Throwable -> L18
        this.mCurrentQuality.setTxTputPred((int) r8.J);     // Catch: Throwable -> L18
        this.mCurrentQuality.setWifiStandard(r8.P);     // Catch: Throwable -> L18
        this.mCurrentQuality.setTxDelayAvg(r8.L);     // Catch: Throwable -> L18
        this.mCurrentQuality.setTxDelayP10(r8.M);     // Catch: Throwable -> L18
        this.mCurrentQuality.setTxDelayP90(r8.N);     // Catch: Throwable -> L18
        this.mCurrentQuality.setTxDelayPkts(r8.K);     // Catch: Throwable -> L18
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L18
        int[] r14 = r8.O;     // Catch: Throwable -> L18
        int r15 = 0;
        if (r14 == null) goto L9;
        int r16 = r14.length;     // Catch: Throwable -> L18
        int r17 = 0;
    L7:
        if (r17 >= r16) goto L9;
        r13.add(Integer.valueOf(r14[r17]));     // Catch: Throwable -> L18
        r17 = r17 + 1;     // Catch: Throwable -> L18
    L9:
        this.mCurrentQuality.setDelaySizeMatrix(r13);     // Catch: Throwable -> L18
        ArrayList r18 = r8.H;     // Catch: Throwable -> L18
        if (r18 != null) goto L12;
    L14:
        int r19 = 0;
    L15:
        this.mCurrentQuality.setContentionAtimeBk(r15);     // Catch: Throwable -> L18
        this.mCurrentQuality.setContentionAtimeVi(r19);     // Catch: Throwable -> L18
        this.mCurrentQuality.setLinkStats(convertLinkStats(r8.H));     // Catch: Throwable -> L18
        monitor-exit(r12);     // Catch: Throwable -> L18
        return;
    L12:
        if (r18.isEmpty() == true) goto L14;
        com.cae.caed.LinkStatsParcel r20 = (com.cae.caed.LinkStatsParcel) r8.H.get(0);     // Catch: Throwable -> L18
        r15 = r20.f4152x;     // Catch: Throwable -> L18
        r19 = r20.f4153y;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }
}
