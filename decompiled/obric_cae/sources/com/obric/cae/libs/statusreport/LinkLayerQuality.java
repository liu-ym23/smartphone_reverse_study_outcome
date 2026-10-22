package com.obric.cae.libs.statusreport;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
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
        public final LinkLayerQuality createFromParcel(Parcel r8) {
            LinkLayerQuality r10 = new LinkLayerQuality();
            LinkLayerQuality.a(r10, r8.readString());
            LinkLayerQuality.b(r10, r8.readInt());
            LinkLayerQuality.m(r10, r8.readInt());
            LinkLayerQuality.x(r10, r8.readInt());
            LinkLayerQuality.b(r10, r8.readString());
            LinkLayerQuality.c(r10, r8.readString());
            LinkLayerQuality.d(r10, r8.readString());
            LinkLayerQuality.F(r10, r8.readInt());
            LinkLayerQuality.G(r10, r8.readInt());
            LinkLayerQuality.H(r10, r8.readInt());
            LinkLayerQuality.a(r10, r8.readInt());
            LinkLayerQuality.c(r10, r8.readInt());
            LinkLayerQuality.d(r10, r8.readInt());
            LinkLayerQuality.e(r10, r8.readInt());
            LinkLayerQuality.f(r10, r8.readInt());
            LinkLayerQuality.g(r10, r8.readInt());
            LinkLayerQuality.h(r10, r8.readInt());
            LinkLayerQuality.i(r10, r8.readInt());
            LinkLayerQuality.j(r10, r8.readInt());
            LinkLayerQuality.k(r10, r8.readInt());
            LinkLayerQuality.l(r10, r8.readInt());
            LinkLayerQuality.n(r10, r8.readInt());
            LinkLayerQuality.o(r10, r8.readInt());
            LinkLayerQuality.p(r10, r8.readInt());
            LinkLayerQuality.q(r10, r8.readInt());
            LinkLayerQuality.r(r10, r8.readInt());
            LinkLayerQuality.s(r10, r8.readInt());
            LinkLayerQuality.t(r10, r8.readInt());
            LinkLayerQuality.u(r10, r8.readInt());
            LinkLayerQuality.v(r10, r8.readInt());
            LinkLayerQuality.w(r10, r8.readInt());
            LinkLayerQuality.y(r10, r8.readInt());
            LinkLayerQuality.z(r10, r8.readInt());
            int r11 = 0;
            if (r8.readByte() == 0) goto L5;
            boolean r12 = true;
        L6:
            LinkLayerQuality.a(r10, r12);
            r8.readTypedList(LinkLayerQuality.a(r10), LinkStatsParcel.CREATOR);
            LinkLayerQuality.A(r10, r8.readInt());
            LinkLayerQuality.B(r10, r8.readInt());
            LinkLayerQuality.C(r10, r8.readInt());
            LinkLayerQuality.D(r10, r8.readInt());
            LinkLayerQuality.E(r10, r8.readInt());
            LinkLayerQuality.a(r10, r8.readFloat());
            LinkLayerQuality.b(r10, r8.readFloat());
            LinkLayerQuality.c(r10, r8.readFloat());
            LinkLayerQuality.a(r10, r8.readLong());
            int r13 = r8.readInt();
            LinkLayerQuality.a(r10, new ArrayList(r13));
        L7:
            if (r11 >= r13) goto L9;
            LinkLayerQuality.b(r10).add(Integer.valueOf(r8.readInt()));
            r11 = r11 + 1;
            goto L7
        L9:
            return r10;
        L5:
            r12 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final LinkLayerQuality[] newArray(int r8) {
            return new LinkLayerQuality[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public LinkLayerQuality() {
        this.linkStats = new ArrayList();
        this.delaySizeMatrix = new ArrayList();
    }

    public static /* synthetic */ void A(LinkLayerQuality r8, int r10) {
        r8.rxTputPred = r10;
    }

    public static /* synthetic */ void B(LinkLayerQuality r8, int r10) {
        r8.txTputPred = r10;
    }

    public static /* synthetic */ void C(LinkLayerQuality r8, int r10) {
        r8.wifiStandard = r10;
    }

    public static /* synthetic */ void D(LinkLayerQuality r8, int r10) {
        r8.contentionAtimeBk = r10;
    }

    public static /* synthetic */ void E(LinkLayerQuality r8, int r10) {
        r8.contentionAtimeVi = r10;
    }

    public static /* synthetic */ void F(LinkLayerQuality r8, int r10) {
        r8.deltaRxFcsErr = r10;
    }

    public static /* synthetic */ void G(LinkLayerQuality r8, int r10) {
        r8.rxFcsErrLevel = r10;
    }

    public static /* synthetic */ void H(LinkLayerQuality r8, int r10) {
        r8.totalTxBytes = r10;
    }

    public static /* synthetic */ List a(LinkLayerQuality r8) {
        return r8.linkStats;
    }

    public static /* synthetic */ List b(LinkLayerQuality r8) {
        return r8.delaySizeMatrix;
    }

    public static /* synthetic */ void c(LinkLayerQuality r8, float r10) {
        r8.txDelayP90 = r10;
    }

    public static /* synthetic */ void d(LinkLayerQuality r8, int r10) {
        r8.totalRxBytes = r10;
    }

    public static /* synthetic */ void e(LinkLayerQuality r8, int r10) {
        r8.deltaRxBytes = r10;
    }

    public static /* synthetic */ void f(LinkLayerQuality r8, int r10) {
        r8.rxRealSpeed = r10;
    }

    public static /* synthetic */ void g(LinkLayerQuality r8, int r10) {
        r8.txMode = r10;
    }

    public static /* synthetic */ void h(LinkLayerQuality r8, int r10) {
        r8.txMcs = r10;
    }

    public static /* synthetic */ void i(LinkLayerQuality r8, int r10) {
        r8.txBw = r10;
    }

    public static /* synthetic */ void j(LinkLayerQuality r8, int r10) {
        r8.txNss = r10;
    }

    public static /* synthetic */ void k(LinkLayerQuality r8, int r10) {
        r8.rxMode = r10;
    }

    public static /* synthetic */ void l(LinkLayerQuality r8, int r10) {
        r8.rxMcs = r10;
    }

    public static /* synthetic */ void m(LinkLayerQuality r8, int r10) {
        r8.txlink_speed = r10;
    }

    public static /* synthetic */ void n(LinkLayerQuality r8, int r10) {
        r8.rxBw = r10;
    }

    public static /* synthetic */ void o(LinkLayerQuality r8, int r10) {
        r8.rxNss = r10;
    }

    public static /* synthetic */ void p(LinkLayerQuality r8, int r10) {
        r8.delta_channel_on_time = r10;
    }

    public static /* synthetic */ void q(LinkLayerQuality r8, int r10) {
        r8.delta_channel_tx_time = r10;
    }

    public static /* synthetic */ void r(LinkLayerQuality r8, int r10) {
        r8.delta_channel_rx_time = r10;
    }

    public static /* synthetic */ void s(LinkLayerQuality r8, int r10) {
        r8.delta_channel_cca_busy_time = r10;
    }

    public static /* synthetic */ void t(LinkLayerQuality r8, int r10) {
        r8.ccaScore = r10;
    }

    public static /* synthetic */ void u(LinkLayerQuality r8, int r10) {
        r8.perScore = r10;
    }

    public static /* synthetic */ void v(LinkLayerQuality r8, int r10) {
        r8.rssiScore = r10;
    }

    public static /* synthetic */ void w(LinkLayerQuality r8, int r10) {
        r8.scenario = r10;
    }

    public static /* synthetic */ void x(LinkLayerQuality r8, int r10) {
        r8.rxlink_speed = r10;
    }

    public static /* synthetic */ void y(LinkLayerQuality r8, int r10) {
        r8.currentChannelAPCount = r10;
    }

    public static /* synthetic */ void z(LinkLayerQuality r8, int r10) {
        r8.arpNeighbourCount = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    public void setArpNeighbourCount(int r8) {
        this.arpNeighbourCount = r8;
    }

    public void setBand(String r8) {
        this.band = r8;
    }

    public void setBand1(String r8) {
        this.band1 = r8;
    }

    public void setCcaScore(int r8) {
        this.ccaScore = r8;
    }

    public void setContentionAtimeBk(int r8) {
        this.contentionAtimeBk = r8;
    }

    public void setContentionAtimeVi(int r8) {
        this.contentionAtimeVi = r8;
    }

    public void setCurrentChannelAPCount(int r8) {
        this.currentChannelAPCount = r8;
    }

    public void setDelaySizeMatrix(List<Integer> r8) {
        this.delaySizeMatrix = r8;
    }

    public void setDeltaRxBytes(int r8) {
        this.deltaRxBytes = r8;
    }

    public void setDeltaRxFcsErr(int r8) {
        this.deltaRxFcsErr = r8;
    }

    public void setDeltaTxBytes(int r8) {
        this.deltaTxBytes = r8;
    }

    public void setDelta_channel_cca_busy_time(int r8) {
        this.delta_channel_cca_busy_time = r8;
    }

    public void setDelta_channel_on_time(int r8) {
        this.delta_channel_on_time = r8;
    }

    public void setDelta_channel_rx_time(int r8) {
        this.delta_channel_rx_time = r8;
    }

    public void setDelta_channel_tx_time(int r8) {
        this.delta_channel_tx_time = r8;
    }

    public void setFreq(int r8) {
        this.freq = r8;
    }

    public void setIfName(String r8) {
        this.ifName = r8;
    }

    public void setLinkStats(List<LinkStatsParcel> r8) {
        this.linkStats = r8;
    }

    public void setMloIface(boolean r8) {
        this.is_mlo_iface = r8;
    }

    public void setPerScore(int r8) {
        this.perScore = r8;
    }

    public void setRssiScore(int r8) {
        this.rssiScore = r8;
    }

    public void setRxBw(int r8) {
        this.rxBw = r8;
    }

    public void setRxFcsErrLevel(int r8) {
        this.rxFcsErrLevel = r8;
    }

    public void setRxMcs(int r8) {
        this.rxMcs = r8;
    }

    public void setRxMode(int r8) {
        this.rxMode = r8;
    }

    public void setRxNss(int r8) {
        this.rxNss = r8;
    }

    public void setRxRealSpeed(int r8) {
        this.rxRealSpeed = r8;
    }

    public void setRxTputPred(int r8) {
        this.rxTputPred = r8;
    }

    public void setRxlinkSpeed(int r8) {
        this.rxlink_speed = r8;
    }

    public void setScenario(int r8) {
        this.scenario = r8;
    }

    public void setTotalRxBytes(int r8) {
        this.totalRxBytes = r8;
    }

    public void setTotalTxBytes(int r8) {
        this.totalTxBytes = r8;
    }

    public void setTxBw(int r8) {
        this.txBw = r8;
    }

    public void setTxDelayAvg(float r8) {
        this.txDelayAvg = r8;
    }

    public void setTxDelayP10(float r8) {
        this.txDelayP10 = r8;
    }

    public void setTxDelayP90(float r8) {
        this.txDelayP90 = r8;
    }

    public void setTxDelayPkts(long r8) {
        this.txDelayPkts = r8;
    }

    public void setTxMcs(int r8) {
        this.txMcs = r8;
    }

    public void setTxMode(int r8) {
        this.txMode = r8;
    }

    public void setTxNss(int r8) {
        this.txNss = r8;
    }

    public void setTxRealSpeed(int r8) {
        this.txRealSpeed = r8;
    }

    public void setTxTputPred(int r8) {
        this.txTputPred = r8;
    }

    public void setTxlinkSpeed(int r8) {
        this.txlink_speed = r8;
    }

    public void setWifiGeneration(String r8) {
        this.wifiGeneration = r8;
    }

    public void setWifiStandard(int r8) {
        this.wifiStandard = r8;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder(" LinkLayerQuality:  ifName: ");
        r8.append(this.ifName);
        r8.append(" freq: ");
        r8.append(this.freq);
        r8.append(" txlink_speed: ");
        r8.append(this.txlink_speed);
        r8.append(" rxlink_speed: ");
        r8.append(this.rxlink_speed);
        r8.append(" band: ");
        r8.append(this.band);
        r8.append(" band1: ");
        r8.append(this.band1);
        r8.append(" wifiGeneration: ");
        r8.append(this.wifiGeneration);
        r8.append(" deltaRxFcsErr: ");
        r8.append(this.deltaRxFcsErr);
        r8.append(" rxFcsErrLevel: ");
        r8.append(this.rxFcsErrLevel);
        r8.append(" totalTxBytes: ");
        r8.append(this.totalTxBytes);
        r8.append(" deltaTxBytes: ");
        r8.append(this.deltaTxBytes);
        r8.append(" txRealSpeed: ");
        r8.append(this.txRealSpeed);
        r8.append(" totalRxBytes: ");
        r8.append(this.totalRxBytes);
        r8.append(" deltaRxBytes: ");
        r8.append(this.deltaRxBytes);
        r8.append(" rxRealSpeed: ");
        r8.append(this.rxRealSpeed);
        r8.append(" txMode: ");
        r8.append(this.txMode);
        r8.append(" txMcs: ");
        r8.append(this.txMcs);
        r8.append(" txBw: ");
        r8.append(this.txBw);
        r8.append(" txNss: ");
        r8.append(this.txNss);
        r8.append(" rxMode: ");
        r8.append(this.rxMode);
        r8.append(" rxMcs: ");
        r8.append(this.rxMcs);
        r8.append(" rxBw: ");
        r8.append(this.rxBw);
        r8.append(" rxNss: ");
        r8.append(this.rxNss);
        r8.append(" delta_channel_on_time: ");
        r8.append(this.delta_channel_on_time);
        r8.append(" delta_channel_tx_time: ");
        r8.append(this.delta_channel_tx_time);
        r8.append(" delta_channel_rx_time: ");
        r8.append(this.delta_channel_rx_time);
        r8.append(" delta_channel_cca_busy_time: ");
        r8.append(this.delta_channel_cca_busy_time);
        r8.append(" ccaScore: ");
        r8.append(this.ccaScore);
        r8.append(" perScore: ");
        r8.append(this.perScore);
        r8.append(" rssiScore: ");
        r8.append(this.rssiScore);
        r8.append(" scenario: ");
        r8.append(this.scenario);
        r8.append(" currentChannelAPCount: ");
        r8.append(this.currentChannelAPCount);
        r8.append(" arpNeighbourCount: ");
        r8.append(this.arpNeighbourCount);
        r8.append(" is_mlo_iface: ");
        r8.append(this.is_mlo_iface);
        if (this.linkStats == null) goto L5;
        r8.append(" linkStats size: ");
        r8.append(this.linkStats.size());
    L6:
        r8.append(" rxTputPred: ");
        r8.append(this.rxTputPred);
        r8.append(" txTputPred: ");
        r8.append(this.txTputPred);
        r8.append(" wifiStandard: ");
        r8.append(this.wifiStandard);
        r8.append(" contentionAtimeBk: ");
        r8.append(this.contentionAtimeBk);
        r8.append(" contentionAtimeVi: ");
        r8.append(this.contentionAtimeVi);
        r8.append(" txDelayAvg: ");
        r8.append(this.txDelayAvg);
        r8.append(" txDelayP10: ");
        r8.append(this.txDelayP10);
        r8.append(" txDelayP90: ");
        r8.append(this.txDelayP90);
        r8.append(" txDelayPkts: ");
        r8.append(this.txDelayPkts);
        if (this.delaySizeMatrix == null) goto L9;
        r8.append(" delaySizeMatrix size: ");
        r8.append(this.delaySizeMatrix.size());
    L11:
        return r8.toString();
    L9:
        r8.append(" delaySizeMatrix is null");
        goto L11
    L5:
        r8.append(" linkStats is null");
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.ifName);
        r8.writeInt(this.freq);
        r8.writeInt(this.txlink_speed);
        r8.writeInt(this.rxlink_speed);
        r8.writeString(this.band);
        r8.writeString(this.band1);
        r8.writeString(this.wifiGeneration);
        r8.writeInt(this.deltaRxFcsErr);
        r8.writeInt(this.rxFcsErrLevel);
        r8.writeInt(this.totalTxBytes);
        r8.writeInt(this.deltaTxBytes);
        r8.writeInt(this.txRealSpeed);
        r8.writeInt(this.totalRxBytes);
        r8.writeInt(this.deltaRxBytes);
        r8.writeInt(this.rxRealSpeed);
        r8.writeInt(this.txMode);
        r8.writeInt(this.txMcs);
        r8.writeInt(this.txBw);
        r8.writeInt(this.txNss);
        r8.writeInt(this.rxMode);
        r8.writeInt(this.rxMcs);
        r8.writeInt(this.rxBw);
        r8.writeInt(this.rxNss);
        r8.writeInt(this.delta_channel_on_time);
        r8.writeInt(this.delta_channel_tx_time);
        r8.writeInt(this.delta_channel_rx_time);
        r8.writeInt(this.delta_channel_cca_busy_time);
        r8.writeInt(this.ccaScore);
        r8.writeInt(this.perScore);
        r8.writeInt(this.rssiScore);
        r8.writeInt(this.scenario);
        r8.writeInt(this.currentChannelAPCount);
        r8.writeInt(this.arpNeighbourCount);
        r8.writeByte(this.is_mlo_iface ? 1 : 0);
        r8.writeTypedList(this.linkStats);
        r8.writeInt(this.rxTputPred);
        r8.writeInt(this.txTputPred);
        r8.writeInt(this.wifiStandard);
        r8.writeInt(this.contentionAtimeBk);
        r8.writeInt(this.contentionAtimeVi);
        r8.writeFloat(this.txDelayAvg);
        r8.writeFloat(this.txDelayP10);
        r8.writeFloat(this.txDelayP90);
        r8.writeLong(this.txDelayPkts);
        List<Integer> r11 = this.delaySizeMatrix;
        if (r11 == null) goto L12;
        r8.writeInt(r11.size());
        Iterator<Integer> r12 = this.delaySizeMatrix.iterator();
    L6:
        if (r12.hasNext() == false) goto L17;
        Integer r13 = r12.next();
        if (r13 == null) goto L10;
        int r14 = r13.intValue();
    L11:
        r8.writeInt(r14);
        goto L6
    L10:
        r14 = 0;
        goto L11
    L17:
        return;
    L12:
        r8.writeInt(0);
    }

    public LinkLayerQuality(LinkLayerQuality r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        this.ifName = r8.ifName;
        this.freq = r8.freq;
        this.txlink_speed = r8.txlink_speed;
        this.rxlink_speed = r8.rxlink_speed;
        this.band = r8.band;
        this.band1 = r8.band1;
        this.wifiGeneration = r8.wifiGeneration;
        this.deltaRxFcsErr = r8.deltaRxFcsErr;
        this.rxFcsErrLevel = r8.rxFcsErrLevel;
        this.totalTxBytes = r8.totalTxBytes;
        this.deltaTxBytes = r8.deltaTxBytes;
        this.txRealSpeed = r8.txRealSpeed;
        this.totalRxBytes = r8.totalRxBytes;
        this.deltaRxBytes = r8.deltaRxBytes;
        this.rxRealSpeed = r8.rxRealSpeed;
        this.txMode = r8.txMode;
        this.txMcs = r8.txMcs;
        this.txBw = r8.txBw;
        this.txNss = r8.txNss;
        this.rxMode = r8.rxMode;
        this.rxMcs = r8.rxMcs;
        this.rxBw = r8.rxBw;
        this.rxNss = r8.rxNss;
        this.delta_channel_on_time = r8.delta_channel_on_time;
        this.delta_channel_tx_time = r8.delta_channel_tx_time;
        this.delta_channel_rx_time = r8.delta_channel_rx_time;
        this.delta_channel_cca_busy_time = r8.delta_channel_cca_busy_time;
        this.ccaScore = r8.ccaScore;
        this.perScore = r8.perScore;
        this.rssiScore = r8.rssiScore;
        this.scenario = r8.scenario;
        this.currentChannelAPCount = r8.currentChannelAPCount;
        this.arpNeighbourCount = r8.arpNeighbourCount;
        this.is_mlo_iface = r8.is_mlo_iface;
        if (r8.linkStats == null) goto L8;
        ArrayList r10 = new ArrayList(r8.linkStats);
    L9:
        this.linkStats = r10;
        this.rxTputPred = r8.rxTputPred;
        this.txTputPred = r8.txTputPred;
        this.wifiStandard = r8.wifiStandard;
        this.contentionAtimeBk = r8.contentionAtimeBk;
        this.contentionAtimeVi = r8.contentionAtimeVi;
        this.txDelayAvg = r8.txDelayAvg;
        this.txDelayP10 = r8.txDelayP10;
        this.txDelayP90 = r8.txDelayP90;
        this.txDelayPkts = r8.txDelayPkts;
        if (r8.delaySizeMatrix == null) goto L12;
        this.delaySizeMatrix = new ArrayList(r8.delaySizeMatrix);
        return;
    L12:
        this.delaySizeMatrix = new ArrayList();
        return;
    L8:
        r10 = new ArrayList();
        goto L9
    }

    public static /* synthetic */ void a(LinkLayerQuality r8, float r10) {
        r8.txDelayAvg = r10;
    }

    public static /* synthetic */ void b(LinkLayerQuality r8, float r10) {
        r8.txDelayP10 = r10;
    }

    public static /* synthetic */ void c(LinkLayerQuality r8, int r10) {
        r8.txRealSpeed = r10;
    }

    public static /* synthetic */ void d(LinkLayerQuality r8, String r10) {
        r8.wifiGeneration = r10;
    }

    public static /* synthetic */ void a(LinkLayerQuality r8, int r10) {
        r8.deltaTxBytes = r10;
    }

    public static /* synthetic */ void b(LinkLayerQuality r8, int r10) {
        r8.freq = r10;
    }

    public static /* synthetic */ void c(LinkLayerQuality r8, String r10) {
        r8.band1 = r10;
    }

    public static /* synthetic */ void a(LinkLayerQuality r8, long r10) {
        r8.txDelayPkts = r10;
    }

    public static /* synthetic */ void b(LinkLayerQuality r8, String r10) {
        r8.band = r10;
    }

    public static /* synthetic */ void a(LinkLayerQuality r8, String r10) {
        r8.ifName = r10;
    }

    public static /* synthetic */ void a(LinkLayerQuality r8, ArrayList r10) {
        r8.delaySizeMatrix = r10;
    }

    public static /* synthetic */ void a(LinkLayerQuality r8, boolean r10) {
        r8.is_mlo_iface = r10;
    }
}
