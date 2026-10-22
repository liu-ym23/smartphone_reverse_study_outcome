package com.obric.cae.libs.statusreport;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class LinkStatsParcel implements Parcelable {
    public static final Parcelable.Creator<LinkStatsParcel> CREATOR = null;
    private int ccaLevel;
    private int center_freq;
    private int contention_atime_be;
    private int contention_atime_bk;
    private int contention_atime_vi;
    private int contention_atime_vo;
    private int deltaCcaBusyTime;
    private int deltaRadioOnTime;
    private int deltaRxSuccess;
    private long deltaTxBad;
    private long deltaTxRetries;
    private long deltaTxSuccess;
    private int link_id;
    private int on_time_scan;
    private int per;
    private float power_pred_mw;
    private int radio_id;
    private int rl_cca_busy_rate;
    private int rl_rx_link_speed;
    private int rl_tx_link_speed;
    private int rssi_ack;
    private int rssi_data;
    private int rssi_mgmt;
    private int rx_speed_kbps;
    private int txBadLevel;
    private long txMpduBe;
    private long txMpduVi;
    private long txMpduVo;
    private int txRetranLevel;
    private int txRetranLevelBe;
    private int txRetranLevelVi;
    private int txRetranLevelVo;
    private long txRetriesBe;
    private long txRetriesVi;
    private long txRetriesVo;
    private int tx_speed_kbps;
    private int width;

    public class a implements Parcelable.Creator<LinkStatsParcel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LinkStatsParcel createFromParcel(Parcel r1) {
            return new LinkStatsParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final LinkStatsParcel[] newArray(int r1) {
            return new LinkStatsParcel[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public LinkStatsParcel() {
    }

    public LinkStatsParcel(Parcel r3) {
        this.link_id = r3.readInt();
        this.radio_id = r3.readInt();
        this.center_freq = r3.readInt();
        this.deltaCcaBusyTime = r3.readInt();
        this.deltaRadioOnTime = r3.readInt();
        this.ccaLevel = r3.readInt();
        this.deltaTxSuccess = r3.readLong();
        this.deltaTxRetries = r3.readLong();
        this.txRetranLevel = r3.readInt();
        this.deltaTxBad = r3.readLong();
        this.txBadLevel = r3.readInt();
        this.deltaRxSuccess = r3.readInt();
        this.contention_atime_be = r3.readInt();
        this.contention_atime_bk = r3.readInt();
        this.contention_atime_vi = r3.readInt();
        this.contention_atime_vo = r3.readInt();
        this.txMpduBe = r3.readLong();
        this.txRetriesBe = r3.readLong();
        this.txRetranLevelBe = r3.readInt();
        this.txMpduVi = r3.readLong();
        this.txRetriesVi = r3.readLong();
        this.txRetranLevelVi = r3.readInt();
        this.txMpduVo = r3.readLong();
        this.txRetriesVo = r3.readLong();
        this.txRetranLevelVo = r3.readInt();
        this.width = r3.readInt();
        this.rssi_mgmt = r3.readInt();
        this.rssi_data = r3.readInt();
        this.rssi_ack = r3.readInt();
        this.rl_tx_link_speed = r3.readInt();
        this.rl_rx_link_speed = r3.readInt();
        this.rl_cca_busy_rate = r3.readInt();
        this.per = r3.readInt();
        this.on_time_scan = r3.readInt();
        this.tx_speed_kbps = r3.readInt();
        this.rx_speed_kbps = r3.readInt();
        this.power_pred_mw = r3.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCcaLevel() {
        return this.ccaLevel;
    }

    public int getCenter_freq() {
        return this.center_freq;
    }

    public int getContention_atime_be() {
        return this.contention_atime_be;
    }

    public int getContention_atime_bk() {
        return this.contention_atime_bk;
    }

    public int getContention_atime_vi() {
        return this.contention_atime_vi;
    }

    public int getContention_atime_vo() {
        return this.contention_atime_vo;
    }

    public int getDeltaCcaBusyTime() {
        return this.deltaCcaBusyTime;
    }

    public int getDeltaRadioOnTime() {
        return this.deltaRadioOnTime;
    }

    public int getDeltaRxSuccess() {
        return this.deltaRxSuccess;
    }

    public long getDeltaTxBad() {
        return this.deltaTxBad;
    }

    public long getDeltaTxRetries() {
        return this.deltaTxRetries;
    }

    public long getDeltaTxSuccess() {
        return this.deltaTxSuccess;
    }

    public int getLink_id() {
        return this.link_id;
    }

    public int getOn_time_scan() {
        return this.on_time_scan;
    }

    public int getPer() {
        return this.per;
    }

    public float getPower_pred_mw() {
        return this.power_pred_mw;
    }

    public int getRadio_id() {
        return this.radio_id;
    }

    public int getRl_cca_busy_rate() {
        return this.rl_cca_busy_rate;
    }

    public int getRl_rx_link_speed() {
        return this.rl_rx_link_speed;
    }

    public int getRl_tx_link_speed() {
        return this.rl_tx_link_speed;
    }

    public int getRssi_ack() {
        return this.rssi_ack;
    }

    public int getRssi_data() {
        return this.rssi_data;
    }

    public int getRssi_mgmt() {
        return this.rssi_mgmt;
    }

    public int getRx_speed_kbps() {
        return this.rx_speed_kbps;
    }

    public int getTxBadLevel() {
        return this.txBadLevel;
    }

    public long getTxMpduBe() {
        return this.txMpduBe;
    }

    public long getTxMpduVi() {
        return this.txMpduVi;
    }

    public long getTxMpduVo() {
        return this.txMpduVo;
    }

    public int getTxRetranLevel() {
        return this.txRetranLevel;
    }

    public int getTxRetranLevelBe() {
        return this.txRetranLevelBe;
    }

    public int getTxRetranLevelVi() {
        return this.txRetranLevelVi;
    }

    public int getTxRetranLevelVo() {
        return this.txRetranLevelVo;
    }

    public long getTxRetriesBe() {
        return this.txRetriesBe;
    }

    public long getTxRetriesVi() {
        return this.txRetriesVi;
    }

    public long getTxRetriesVo() {
        return this.txRetriesVo;
    }

    public int getTx_speed_kbps() {
        return this.tx_speed_kbps;
    }

    public int getWidth() {
        return this.width;
    }

    public void setCcaLevel(int r1) {
        this.ccaLevel = r1;
    }

    public void setCenter_freq(int r1) {
        this.center_freq = r1;
    }

    public void setContention_atime_be(int r1) {
        this.contention_atime_be = r1;
    }

    public void setContention_atime_bk(int r1) {
        this.contention_atime_bk = r1;
    }

    public void setContention_atime_vi(int r1) {
        this.contention_atime_vi = r1;
    }

    public void setContention_atime_vo(int r1) {
        this.contention_atime_vo = r1;
    }

    public void setDeltaCcaBusyTime(int r1) {
        this.deltaCcaBusyTime = r1;
    }

    public void setDeltaRadioOnTime(int r1) {
        this.deltaRadioOnTime = r1;
    }

    public void setDeltaRxSuccess(int r1) {
        this.deltaRxSuccess = r1;
    }

    public void setDeltaTxBad(long r1) {
        this.deltaTxBad = r1;
    }

    public void setDeltaTxRetries(long r1) {
        this.deltaTxRetries = r1;
    }

    public void setDeltaTxSuccess(long r1) {
        this.deltaTxSuccess = r1;
    }

    public void setLink_id(int r1) {
        this.link_id = r1;
    }

    public void setOn_time_scan(int r1) {
        this.on_time_scan = r1;
    }

    public void setPer(int r1) {
        this.per = r1;
    }

    public void setPower_pred_mw(float r1) {
        this.power_pred_mw = r1;
    }

    public void setRadio_id(int r1) {
        this.radio_id = r1;
    }

    public void setRl_cca_busy_rate(int r1) {
        this.rl_cca_busy_rate = r1;
    }

    public void setRl_rx_link_speed(int r1) {
        this.rl_rx_link_speed = r1;
    }

    public void setRl_tx_link_speed(int r1) {
        this.rl_tx_link_speed = r1;
    }

    public void setRssi_ack(int r1) {
        this.rssi_ack = r1;
    }

    public void setRssi_data(int r1) {
        this.rssi_data = r1;
    }

    public void setRssi_mgmt(int r1) {
        this.rssi_mgmt = r1;
    }

    public void setRx_speed_kbps(int r1) {
        this.rx_speed_kbps = r1;
    }

    public void setTxBadLevel(int r1) {
        this.txBadLevel = r1;
    }

    public void setTxMpduBe(long r1) {
        this.txMpduBe = r1;
    }

    public void setTxMpduVi(long r1) {
        this.txMpduVi = r1;
    }

    public void setTxMpduVo(long r1) {
        this.txMpduVo = r1;
    }

    public void setTxRetranLevel(int r1) {
        this.txRetranLevel = r1;
    }

    public void setTxRetranLevelBe(int r1) {
        this.txRetranLevelBe = r1;
    }

    public void setTxRetranLevelVi(int r1) {
        this.txRetranLevelVi = r1;
    }

    public void setTxRetranLevelVo(int r1) {
        this.txRetranLevelVo = r1;
    }

    public void setTxRetriesBe(long r1) {
        this.txRetriesBe = r1;
    }

    public void setTxRetriesVi(long r1) {
        this.txRetriesVi = r1;
    }

    public void setTxRetriesVo(long r1) {
        this.txRetriesVo = r1;
    }

    public void setTx_speed_kbps(int r1) {
        this.tx_speed_kbps = r1;
    }

    public void setWidth(int r1) {
        this.width = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.link_id);
        r3.writeInt(this.radio_id);
        r3.writeInt(this.center_freq);
        r3.writeInt(this.deltaCcaBusyTime);
        r3.writeInt(this.deltaRadioOnTime);
        r3.writeInt(this.ccaLevel);
        r3.writeLong(this.deltaTxSuccess);
        r3.writeLong(this.deltaTxRetries);
        r3.writeInt(this.txRetranLevel);
        r3.writeLong(this.deltaTxBad);
        r3.writeInt(this.txBadLevel);
        r3.writeInt(this.deltaRxSuccess);
        r3.writeInt(this.contention_atime_be);
        r3.writeInt(this.contention_atime_bk);
        r3.writeInt(this.contention_atime_vi);
        r3.writeInt(this.contention_atime_vo);
        r3.writeLong(this.txMpduBe);
        r3.writeLong(this.txRetriesBe);
        r3.writeInt(this.txRetranLevelBe);
        r3.writeLong(this.txMpduVi);
        r3.writeLong(this.txRetriesVi);
        r3.writeInt(this.txRetranLevelVi);
        r3.writeLong(this.txMpduVo);
        r3.writeLong(this.txRetriesVo);
        r3.writeInt(this.txRetranLevelVo);
        r3.writeInt(this.width);
        r3.writeInt(this.rssi_mgmt);
        r3.writeInt(this.rssi_data);
        r3.writeInt(this.rssi_ack);
        r3.writeInt(this.rl_tx_link_speed);
        r3.writeInt(this.rl_rx_link_speed);
        r3.writeInt(this.rl_cca_busy_rate);
        r3.writeInt(this.per);
        r3.writeInt(this.on_time_scan);
        r3.writeInt(this.tx_speed_kbps);
        r3.writeInt(this.rx_speed_kbps);
        r3.writeFloat(this.power_pred_mw);
    }
}
