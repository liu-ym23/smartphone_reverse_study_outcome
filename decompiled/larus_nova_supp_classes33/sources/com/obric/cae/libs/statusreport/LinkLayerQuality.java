package com.obric.cae.libs.statusreport;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class LinkLayerQuality implements Parcelable {
    public static final Parcelable.Creator<LinkLayerQuality> CREATOR = null;
    private static final String TAG = "LinkLayerQuality";
    private int arpNeighbourCount;
    private String band;
    private String band1;
    private int ccaScore;
    private int contentionAtimeBk;
    private int contentionAtimeVi;
    private int currentChannelAPCount;
    private List<Integer> delaySizeMatrix;
    private int deltaRxBytes;
    private int deltaRxFcsErr;
    private int deltaTxBytes;
    private int delta_channel_cca_busy_time;
    private int delta_channel_on_time;
    private int delta_channel_rx_time;
    private int delta_channel_tx_time;
    private int freq;
    private String ifName;
    private boolean is_mlo_iface;
    private List<LinkStatsParcel> linkStats;
    private int perScore;
    private int rssiScore;
    private int rxBw;
    private int rxFcsErrLevel;
    private int rxMcs;
    private int rxMode;
    private int rxNss;
    private int rxRealSpeed;
    private int rxTputPred;
    private int rxlink_speed;
    private int scenario;
    private int totalRxBytes;
    private int totalTxBytes;
    private int txBw;
    private float txDelayAvg;
    private float txDelayP10;
    private float txDelayP90;
    private long txDelayPkts;
    private int txMcs;
    private int txMode;
    private int txNss;
    private int txRealSpeed;
    private int txTputPred;
    private int txlink_speed;
    private String wifiGeneration;
    private int wifiStandard;

    public class a implements Parcelable.Creator<LinkLayerQuality> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LinkLayerQuality createFromParcel(Parcel r6) {
            LinkLayerQuality r0 = new LinkLayerQuality();
            LinkLayerQuality.a(r0, r6.readString());
            LinkLayerQuality.b(r0, r6.readInt());
            LinkLayerQuality.m(r0, r6.readInt());
            LinkLayerQuality.x(r0, r6.readInt());
            LinkLayerQuality.b(r0, r6.readString());
            LinkLayerQuality.c(r0, r6.readString());
            LinkLayerQuality.d(r0, r6.readString());
            LinkLayerQuality.F(r0, r6.readInt());
            LinkLayerQuality.G(r0, r6.readInt());
            LinkLayerQuality.H(r0, r6.readInt());
            LinkLayerQuality.a(r0, r6.readInt());
            LinkLayerQuality.c(r0, r6.readInt());
            LinkLayerQuality.d(r0, r6.readInt());
            LinkLayerQuality.e(r0, r6.readInt());
            LinkLayerQuality.f(r0, r6.readInt());
            LinkLayerQuality.g(r0, r6.readInt());
            LinkLayerQuality.h(r0, r6.readInt());
            LinkLayerQuality.i(r0, r6.readInt());
            LinkLayerQuality.j(r0, r6.readInt());
            LinkLayerQuality.k(r0, r6.readInt());
            LinkLayerQuality.l(r0, r6.readInt());
            LinkLayerQuality.n(r0, r6.readInt());
            LinkLayerQuality.o(r0, r6.readInt());
            LinkLayerQuality.p(r0, r6.readInt());
            LinkLayerQuality.q(r0, r6.readInt());
            LinkLayerQuality.r(r0, r6.readInt());
            LinkLayerQuality.s(r0, r6.readInt());
            LinkLayerQuality.t(r0, r6.readInt());
            LinkLayerQuality.u(r0, r6.readInt());
            LinkLayerQuality.v(r0, r6.readInt());
            LinkLayerQuality.w(r0, r6.readInt());
            LinkLayerQuality.y(r0, r6.readInt());
            LinkLayerQuality.z(r0, r6.readInt());
            int r2 = 0;
            if (r6.readByte() == 0) goto L5;
            boolean r1 = true;
        L6:
            LinkLayerQuality.a(r0, r1);
            r6.readTypedList(LinkLayerQuality.a(r0), LinkStatsParcel.CREATOR);
            LinkLayerQuality.A(r0, r6.readInt());
            LinkLayerQuality.B(r0, r6.readInt());
            LinkLayerQuality.C(r0, r6.readInt());
            LinkLayerQuality.D(r0, r6.readInt());
            LinkLayerQuality.E(r0, r6.readInt());
            LinkLayerQuality.a(r0, r6.readFloat());
            LinkLayerQuality.b(r0, r6.readFloat());
            LinkLayerQuality.c(r0, r6.readFloat());
            LinkLayerQuality.a(r0, r6.readLong());
            int r3 = r6.readInt();
            LinkLayerQuality.a(r0, new ArrayList(r3));
        L7:
            if (r2 >= r3) goto L9;
            LinkLayerQuality.b(r0).add(Integer.valueOf(r6.readInt()));
            r2 = r2 + 1;
            goto L7
        L9:
            return r0;
        L5:
            r1 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final LinkLayerQuality[] newArray(int r1) {
            return new LinkLayerQuality[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(" LinkLayerQuality:  ifName: ");
        r0.append(this.ifName);
        r0.append(" freq: ");
        r0.append(this.freq);
        r0.append(" txlink_speed: ");
        r0.append(this.txlink_speed);
        r0.append(" rxlink_speed: ");
        r0.append(this.rxlink_speed);
        r0.append(" band: ");
        r0.append(this.band);
        r0.append(" band1: ");
        r0.append(this.band1);
        r0.append(" wifiGeneration: ");
        r0.append(this.wifiGeneration);
        r0.append(" deltaRxFcsErr: ");
        r0.append(this.deltaRxFcsErr);
        r0.append(" rxFcsErrLevel: ");
        r0.append(this.rxFcsErrLevel);
        r0.append(" totalTxBytes: ");
        r0.append(this.totalTxBytes);
        r0.append(" deltaTxBytes: ");
        r0.append(this.deltaTxBytes);
        r0.append(" txRealSpeed: ");
        r0.append(this.txRealSpeed);
        r0.append(" totalRxBytes: ");
        r0.append(this.totalRxBytes);
        r0.append(" deltaRxBytes: ");
        r0.append(this.deltaRxBytes);
        r0.append(" rxRealSpeed: ");
        r0.append(this.rxRealSpeed);
        r0.append(" txMode: ");
        r0.append(this.txMode);
        r0.append(" txMcs: ");
        r0.append(this.txMcs);
        r0.append(" txBw: ");
        r0.append(this.txBw);
        r0.append(" txNss: ");
        r0.append(this.txNss);
        r0.append(" rxMode: ");
        r0.append(this.rxMode);
        r0.append(" rxMcs: ");
        r0.append(this.rxMcs);
        r0.append(" rxBw: ");
        r0.append(this.rxBw);
        r0.append(" rxNss: ");
        r0.append(this.rxNss);
        r0.append(" delta_channel_on_time: ");
        r0.append(this.delta_channel_on_time);
        r0.append(" delta_channel_tx_time: ");
        r0.append(this.delta_channel_tx_time);
        r0.append(" delta_channel_rx_time: ");
        r0.append(this.delta_channel_rx_time);
        r0.append(" delta_channel_cca_busy_time: ");
        r0.append(this.delta_channel_cca_busy_time);
        r0.append(" ccaScore: ");
        r0.append(this.ccaScore);
        r0.append(" perScore: ");
        r0.append(this.perScore);
        r0.append(" rssiScore: ");
        r0.append(this.rssiScore);
        r0.append(" scenario: ");
        r0.append(this.scenario);
        r0.append(" currentChannelAPCount: ");
        r0.append(this.currentChannelAPCount);
        r0.append(" arpNeighbourCount: ");
        r0.append(this.arpNeighbourCount);
        r0.append(" is_mlo_iface: ");
        r0.append(this.is_mlo_iface);
        if (this.linkStats == null) goto L5;
        r0.append(" linkStats size: ");
        r0.append(this.linkStats.size());
    L6:
        r0.append(" rxTputPred: ");
        r0.append(this.rxTputPred);
        r0.append(" txTputPred: ");
        r0.append(this.txTputPred);
        r0.append(" wifiStandard: ");
        r0.append(this.wifiStandard);
        r0.append(" contentionAtimeBk: ");
        r0.append(this.contentionAtimeBk);
        r0.append(" contentionAtimeVi: ");
        r0.append(this.contentionAtimeVi);
        r0.append(" txDelayAvg: ");
        r0.append(this.txDelayAvg);
        r0.append(" txDelayP10: ");
        r0.append(this.txDelayP10);
        r0.append(" txDelayP90: ");
        r0.append(this.txDelayP90);
        r0.append(" txDelayPkts: ");
        r0.append(this.txDelayPkts);
        if (this.delaySizeMatrix == null) goto L9;
        r0.append(" delaySizeMatrix size: ");
        r0.append(this.delaySizeMatrix.size());
    L11:
        return r0.toString();
    L9:
        r0.append(" delaySizeMatrix is null");
        goto L11
    L5:
        r0.append(" linkStats is null");
        goto L6
    }

    public LinkLayerQuality() {
        this.linkStats = new ArrayList();
        this.delaySizeMatrix = new ArrayList();
    }

    public int getArpNeighbourCount() {
        return this.arpNeighbourCount;
    }

    public String getBand() {
        return this.band;
    }

    public String getBand1() {
        return this.band1;
    }

    public int getCcaScore() {
        return this.ccaScore;
    }

    public int getContentionAtimeBk() {
        return this.contentionAtimeBk;
    }

    public int getContentionAtimeVi() {
        return this.contentionAtimeVi;
    }

    public int getCurrentChannelAPCount() {
        return this.currentChannelAPCount;
    }

    public List<Integer> getDelaySizeMatrix() {
        return this.delaySizeMatrix;
    }

    public int getDeltaRxBytes() {
        return this.deltaRxBytes;
    }

    public int getDeltaRxFcsErr() {
        return this.deltaRxFcsErr;
    }

    public int getDeltaTxBytes() {
        return this.deltaTxBytes;
    }

    public int getDelta_channel_cca_busy_time() {
        return this.delta_channel_cca_busy_time;
    }

    public int getDelta_channel_on_time() {
        return this.delta_channel_on_time;
    }

    public int getDelta_channel_rx_time() {
        return this.delta_channel_rx_time;
    }

    public int getDelta_channel_tx_time() {
        return this.delta_channel_tx_time;
    }

    public int getFreq() {
        return this.freq;
    }

    public String getIfName() {
        return this.ifName;
    }

    public List<LinkStatsParcel> getLinkStats() {
        return this.linkStats;
    }

    public int getPerScore() {
        return this.perScore;
    }

    public int getRssiScore() {
        return this.rssiScore;
    }

    public int getRxBw() {
        return this.rxBw;
    }

    public int getRxFcsErrLevel() {
        return this.rxFcsErrLevel;
    }

    public int getRxMcs() {
        return this.rxMcs;
    }

    public int getRxMode() {
        return this.rxMode;
    }

    public int getRxNss() {
        return this.rxNss;
    }

    public int getRxRealSpeed() {
        return this.rxRealSpeed;
    }

    public int getRxTputPred() {
        return this.rxTputPred;
    }

    public int getRxlinkSpeed() {
        return this.rxlink_speed;
    }

    public int getScenario() {
        return this.scenario;
    }

    public int getTotalRxBytes() {
        return this.totalRxBytes;
    }

    public int getTotalTxBytes() {
        return this.totalTxBytes;
    }

    public int getTxBw() {
        return this.txBw;
    }

    public float getTxDelayAvg() {
        return this.txDelayAvg;
    }

    public float getTxDelayP10() {
        return this.txDelayP10;
    }

    public float getTxDelayP90() {
        return this.txDelayP90;
    }

    public long getTxDelayPkts() {
        return this.txDelayPkts;
    }

    public int getTxMcs() {
        return this.txMcs;
    }

    public int getTxMode() {
        return this.txMode;
    }

    public int getTxNss() {
        return this.txNss;
    }

    public int getTxRealSpeed() {
        return this.txRealSpeed;
    }

    public int getTxTputPred() {
        return this.txTputPred;
    }

    public int getTxlinkSpeed() {
        return this.txlink_speed;
    }

    public String getWifiGeneration() {
        return this.wifiGeneration;
    }

    public int getWifiStandard() {
        return this.wifiStandard;
    }

    public boolean isMloIface() {
        return this.is_mlo_iface;
    }

    public LinkLayerQuality(LinkLayerQuality r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        this.ifName = r3.ifName;
        this.freq = r3.freq;
        this.txlink_speed = r3.txlink_speed;
        this.rxlink_speed = r3.rxlink_speed;
        this.band = r3.band;
        this.band1 = r3.band1;
        this.wifiGeneration = r3.wifiGeneration;
        this.deltaRxFcsErr = r3.deltaRxFcsErr;
        this.rxFcsErrLevel = r3.rxFcsErrLevel;
        this.totalTxBytes = r3.totalTxBytes;
        this.deltaTxBytes = r3.deltaTxBytes;
        this.txRealSpeed = r3.txRealSpeed;
        this.totalRxBytes = r3.totalRxBytes;
        this.deltaRxBytes = r3.deltaRxBytes;
        this.rxRealSpeed = r3.rxRealSpeed;
        this.txMode = r3.txMode;
        this.txMcs = r3.txMcs;
        this.txBw = r3.txBw;
        this.txNss = r3.txNss;
        this.rxMode = r3.rxMode;
        this.rxMcs = r3.rxMcs;
        this.rxBw = r3.rxBw;
        this.rxNss = r3.rxNss;
        this.delta_channel_on_time = r3.delta_channel_on_time;
        this.delta_channel_tx_time = r3.delta_channel_tx_time;
        this.delta_channel_rx_time = r3.delta_channel_rx_time;
        this.delta_channel_cca_busy_time = r3.delta_channel_cca_busy_time;
        this.ccaScore = r3.ccaScore;
        this.perScore = r3.perScore;
        this.rssiScore = r3.rssiScore;
        this.scenario = r3.scenario;
        this.currentChannelAPCount = r3.currentChannelAPCount;
        this.arpNeighbourCount = r3.arpNeighbourCount;
        this.is_mlo_iface = r3.is_mlo_iface;
        if (r3.linkStats == null) goto L8;
        this.linkStats = new ArrayList(r3.linkStats);
    L9:
        this.rxTputPred = r3.rxTputPred;
        this.txTputPred = r3.txTputPred;
        this.wifiStandard = r3.wifiStandard;
        this.contentionAtimeBk = r3.contentionAtimeBk;
        this.contentionAtimeVi = r3.contentionAtimeVi;
        this.txDelayAvg = r3.txDelayAvg;
        this.txDelayP10 = r3.txDelayP10;
        this.txDelayP90 = r3.txDelayP90;
        this.txDelayPkts = r3.txDelayPkts;
        if (r3.delaySizeMatrix == null) goto L12;
        this.delaySizeMatrix = new ArrayList(r3.delaySizeMatrix);
        return;
    L12:
        this.delaySizeMatrix = new ArrayList();
        return;
    L8:
        this.linkStats = new ArrayList();
        goto L9
    }

    public static /* synthetic */ List a(LinkLayerQuality r0) {
        return r0.linkStats;
    }

    public static /* synthetic */ List b(LinkLayerQuality r0) {
        return r0.delaySizeMatrix;
    }

    public void setArpNeighbourCount(int r1) {
        this.arpNeighbourCount = r1;
    }

    public void setBand(String r1) {
        this.band = r1;
    }

    public void setBand1(String r1) {
        this.band1 = r1;
    }

    public void setCcaScore(int r1) {
        this.ccaScore = r1;
    }

    public void setContentionAtimeBk(int r1) {
        this.contentionAtimeBk = r1;
    }

    public void setContentionAtimeVi(int r1) {
        this.contentionAtimeVi = r1;
    }

    public void setCurrentChannelAPCount(int r1) {
        this.currentChannelAPCount = r1;
    }

    public void setDelaySizeMatrix(List<Integer> r1) {
        this.delaySizeMatrix = r1;
    }

    public void setDeltaRxBytes(int r1) {
        this.deltaRxBytes = r1;
    }

    public void setDeltaRxFcsErr(int r1) {
        this.deltaRxFcsErr = r1;
    }

    public void setDeltaTxBytes(int r1) {
        this.deltaTxBytes = r1;
    }

    public void setDelta_channel_cca_busy_time(int r1) {
        this.delta_channel_cca_busy_time = r1;
    }

    public void setDelta_channel_on_time(int r1) {
        this.delta_channel_on_time = r1;
    }

    public void setDelta_channel_rx_time(int r1) {
        this.delta_channel_rx_time = r1;
    }

    public void setDelta_channel_tx_time(int r1) {
        this.delta_channel_tx_time = r1;
    }

    public void setFreq(int r1) {
        this.freq = r1;
    }

    public void setIfName(String r1) {
        this.ifName = r1;
    }

    public void setLinkStats(List<LinkStatsParcel> r1) {
        this.linkStats = r1;
    }

    public void setMloIface(boolean r1) {
        this.is_mlo_iface = r1;
    }

    public void setPerScore(int r1) {
        this.perScore = r1;
    }

    public void setRssiScore(int r1) {
        this.rssiScore = r1;
    }

    public void setRxBw(int r1) {
        this.rxBw = r1;
    }

    public void setRxFcsErrLevel(int r1) {
        this.rxFcsErrLevel = r1;
    }

    public void setRxMcs(int r1) {
        this.rxMcs = r1;
    }

    public void setRxMode(int r1) {
        this.rxMode = r1;
    }

    public void setRxNss(int r1) {
        this.rxNss = r1;
    }

    public void setRxRealSpeed(int r1) {
        this.rxRealSpeed = r1;
    }

    public void setRxTputPred(int r1) {
        this.rxTputPred = r1;
    }

    public void setRxlinkSpeed(int r1) {
        this.rxlink_speed = r1;
    }

    public void setScenario(int r1) {
        this.scenario = r1;
    }

    public void setTotalRxBytes(int r1) {
        this.totalRxBytes = r1;
    }

    public void setTotalTxBytes(int r1) {
        this.totalTxBytes = r1;
    }

    public void setTxBw(int r1) {
        this.txBw = r1;
    }

    public void setTxDelayAvg(float r1) {
        this.txDelayAvg = r1;
    }

    public void setTxDelayP10(float r1) {
        this.txDelayP10 = r1;
    }

    public void setTxDelayP90(float r1) {
        this.txDelayP90 = r1;
    }

    public void setTxDelayPkts(long r1) {
        this.txDelayPkts = r1;
    }

    public void setTxMcs(int r1) {
        this.txMcs = r1;
    }

    public void setTxMode(int r1) {
        this.txMode = r1;
    }

    public void setTxNss(int r1) {
        this.txNss = r1;
    }

    public void setTxRealSpeed(int r1) {
        this.txRealSpeed = r1;
    }

    public void setTxTputPred(int r1) {
        this.txTputPred = r1;
    }

    public void setTxlinkSpeed(int r1) {
        this.txlink_speed = r1;
    }

    public void setWifiGeneration(String r1) {
        this.wifiGeneration = r1;
    }

    public void setWifiStandard(int r1) {
        this.wifiStandard = r1;
    }

    public static /* synthetic */ void A(LinkLayerQuality r0, int r1) {
        r0.rxTputPred = r1;
    }

    public static /* synthetic */ void B(LinkLayerQuality r0, int r1) {
        r0.txTputPred = r1;
    }

    public static /* synthetic */ void C(LinkLayerQuality r0, int r1) {
        r0.wifiStandard = r1;
    }

    public static /* synthetic */ void D(LinkLayerQuality r0, int r1) {
        r0.contentionAtimeBk = r1;
    }

    public static /* synthetic */ void E(LinkLayerQuality r0, int r1) {
        r0.contentionAtimeVi = r1;
    }

    public static /* synthetic */ void F(LinkLayerQuality r0, int r1) {
        r0.deltaRxFcsErr = r1;
    }

    public static /* synthetic */ void G(LinkLayerQuality r0, int r1) {
        r0.rxFcsErrLevel = r1;
    }

    public static /* synthetic */ void H(LinkLayerQuality r0, int r1) {
        r0.totalTxBytes = r1;
    }

    public static /* synthetic */ void a(LinkLayerQuality r0, float r1) {
        r0.txDelayAvg = r1;
    }

    public static /* synthetic */ void b(LinkLayerQuality r0, float r1) {
        r0.txDelayP10 = r1;
    }

    public static /* synthetic */ void c(LinkLayerQuality r0, float r1) {
        r0.txDelayP90 = r1;
    }

    public static /* synthetic */ void d(LinkLayerQuality r0, int r1) {
        r0.totalRxBytes = r1;
    }

    public static /* synthetic */ void e(LinkLayerQuality r0, int r1) {
        r0.deltaRxBytes = r1;
    }

    public static /* synthetic */ void f(LinkLayerQuality r0, int r1) {
        r0.rxRealSpeed = r1;
    }

    public static /* synthetic */ void g(LinkLayerQuality r0, int r1) {
        r0.txMode = r1;
    }

    public static /* synthetic */ void h(LinkLayerQuality r0, int r1) {
        r0.txMcs = r1;
    }

    public static /* synthetic */ void i(LinkLayerQuality r0, int r1) {
        r0.txBw = r1;
    }

    public static /* synthetic */ void j(LinkLayerQuality r0, int r1) {
        r0.txNss = r1;
    }

    public static /* synthetic */ void k(LinkLayerQuality r0, int r1) {
        r0.rxMode = r1;
    }

    public static /* synthetic */ void l(LinkLayerQuality r0, int r1) {
        r0.rxMcs = r1;
    }

    public static /* synthetic */ void m(LinkLayerQuality r0, int r1) {
        r0.txlink_speed = r1;
    }

    public static /* synthetic */ void n(LinkLayerQuality r0, int r1) {
        r0.rxBw = r1;
    }

    public static /* synthetic */ void o(LinkLayerQuality r0, int r1) {
        r0.rxNss = r1;
    }

    public static /* synthetic */ void p(LinkLayerQuality r0, int r1) {
        r0.delta_channel_on_time = r1;
    }

    public static /* synthetic */ void q(LinkLayerQuality r0, int r1) {
        r0.delta_channel_tx_time = r1;
    }

    public static /* synthetic */ void r(LinkLayerQuality r0, int r1) {
        r0.delta_channel_rx_time = r1;
    }

    public static /* synthetic */ void s(LinkLayerQuality r0, int r1) {
        r0.delta_channel_cca_busy_time = r1;
    }

    public static /* synthetic */ void t(LinkLayerQuality r0, int r1) {
        r0.ccaScore = r1;
    }

    public static /* synthetic */ void u(LinkLayerQuality r0, int r1) {
        r0.perScore = r1;
    }

    public static /* synthetic */ void v(LinkLayerQuality r0, int r1) {
        r0.rssiScore = r1;
    }

    public static /* synthetic */ void w(LinkLayerQuality r0, int r1) {
        r0.scenario = r1;
    }

    public static /* synthetic */ void x(LinkLayerQuality r0, int r1) {
        r0.rxlink_speed = r1;
    }

    public static /* synthetic */ void y(LinkLayerQuality r0, int r1) {
        r0.currentChannelAPCount = r1;
    }

    public static /* synthetic */ void z(LinkLayerQuality r0, int r1) {
        r0.arpNeighbourCount = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.ifName);
        r3.writeInt(this.freq);
        r3.writeInt(this.txlink_speed);
        r3.writeInt(this.rxlink_speed);
        r3.writeString(this.band);
        r3.writeString(this.band1);
        r3.writeString(this.wifiGeneration);
        r3.writeInt(this.deltaRxFcsErr);
        r3.writeInt(this.rxFcsErrLevel);
        r3.writeInt(this.totalTxBytes);
        r3.writeInt(this.deltaTxBytes);
        r3.writeInt(this.txRealSpeed);
        r3.writeInt(this.totalRxBytes);
        r3.writeInt(this.deltaRxBytes);
        r3.writeInt(this.rxRealSpeed);
        r3.writeInt(this.txMode);
        r3.writeInt(this.txMcs);
        r3.writeInt(this.txBw);
        r3.writeInt(this.txNss);
        r3.writeInt(this.rxMode);
        r3.writeInt(this.rxMcs);
        r3.writeInt(this.rxBw);
        r3.writeInt(this.rxNss);
        r3.writeInt(this.delta_channel_on_time);
        r3.writeInt(this.delta_channel_tx_time);
        r3.writeInt(this.delta_channel_rx_time);
        r3.writeInt(this.delta_channel_cca_busy_time);
        r3.writeInt(this.ccaScore);
        r3.writeInt(this.perScore);
        r3.writeInt(this.rssiScore);
        r3.writeInt(this.scenario);
        r3.writeInt(this.currentChannelAPCount);
        r3.writeInt(this.arpNeighbourCount);
        r3.writeByte(this.is_mlo_iface ? 1 : 0);
        r3.writeTypedList(this.linkStats);
        r3.writeInt(this.rxTputPred);
        r3.writeInt(this.txTputPred);
        r3.writeInt(this.wifiStandard);
        r3.writeInt(this.contentionAtimeBk);
        r3.writeInt(this.contentionAtimeVi);
        r3.writeFloat(this.txDelayAvg);
        r3.writeFloat(this.txDelayP10);
        r3.writeFloat(this.txDelayP90);
        r3.writeLong(this.txDelayPkts);
        List<Integer> r5 = this.delaySizeMatrix;
        if (r5 == null) goto L12;
        r3.writeInt(r5.size());
        Iterator<Integer> r6 = this.delaySizeMatrix.iterator();
    L6:
        if (r6.hasNext() == false) goto L17;
        Integer r1 = r6.next();
        if (r1 == null) goto L10;
        int r2 = r1.intValue();
    L11:
        r3.writeInt(r2);
        goto L6
    L10:
        r2 = 0;
        goto L11
    L17:
        return;
    L12:
        r3.writeInt(0);
    }

    public static /* synthetic */ void a(LinkLayerQuality r0, int r1) {
        r0.deltaTxBytes = r1;
    }

    public static /* synthetic */ void b(LinkLayerQuality r0, int r1) {
        r0.freq = r1;
    }

    public static /* synthetic */ void c(LinkLayerQuality r0, int r1) {
        r0.txRealSpeed = r1;
    }

    public static /* synthetic */ void d(LinkLayerQuality r0, String r1) {
        r0.wifiGeneration = r1;
    }

    public static /* synthetic */ void a(LinkLayerQuality r0, long r1) {
        r0.txDelayPkts = r1;
    }

    public static /* synthetic */ void b(LinkLayerQuality r0, String r1) {
        r0.band = r1;
    }

    public static /* synthetic */ void c(LinkLayerQuality r0, String r1) {
        r0.band1 = r1;
    }

    public static /* synthetic */ void a(LinkLayerQuality r0, String r1) {
        r0.ifName = r1;
    }

    public static /* synthetic */ void a(LinkLayerQuality r0, ArrayList r1) {
        r0.delaySizeMatrix = r1;
    }

    public static /* synthetic */ void a(LinkLayerQuality r0, boolean r1) {
        r0.is_mlo_iface = r1;
    }
}
