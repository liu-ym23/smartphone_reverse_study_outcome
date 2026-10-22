package com.obric.cae.libs.statusreport;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
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
        public final LinkStatsParcel createFromParcel(Parcel r8) {
            return new LinkStatsParcel(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final LinkStatsParcel[] newArray(int r8) {
            return new LinkStatsParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public LinkStatsParcel() {
    }

    public LinkStatsParcel(Parcel r8) {
        this.link_id = r8.readInt();
        this.radio_id = r8.readInt();
        this.center_freq = r8.readInt();
        this.deltaCcaBusyTime = r8.readInt();
        this.deltaRadioOnTime = r8.readInt();
        this.ccaLevel = r8.readInt();
        this.deltaTxSuccess = r8.readLong();
        this.deltaTxRetries = r8.readLong();
        this.txRetranLevel = r8.readInt();
        this.deltaTxBad = r8.readLong();
        this.txBadLevel = r8.readInt();
        this.deltaRxSuccess = r8.readInt();
        this.contention_atime_be = r8.readInt();
        this.contention_atime_bk = r8.readInt();
        this.contention_atime_vi = r8.readInt();
        this.contention_atime_vo = r8.readInt();
        this.txMpduBe = r8.readLong();
        this.txRetriesBe = r8.readLong();
        this.txRetranLevelBe = r8.readInt();
        this.txMpduVi = r8.readLong();
        this.txRetriesVi = r8.readLong();
        this.txRetranLevelVi = r8.readInt();
        this.txMpduVo = r8.readLong();
        this.txRetriesVo = r8.readLong();
        this.txRetranLevelVo = r8.readInt();
        this.width = r8.readInt();
        this.rssi_mgmt = r8.readInt();
        this.rssi_data = r8.readInt();
        this.rssi_ack = r8.readInt();
        this.rl_tx_link_speed = r8.readInt();
        this.rl_rx_link_speed = r8.readInt();
        this.rl_cca_busy_rate = r8.readInt();
        this.per = r8.readInt();
        this.on_time_scan = r8.readInt();
        this.tx_speed_kbps = r8.readInt();
        this.rx_speed_kbps = r8.readInt();
        this.power_pred_mw = r8.readFloat();
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

    public void setCcaLevel(int r8) {
        this.ccaLevel = r8;
    }

    public void setCenter_freq(int r8) {
        this.center_freq = r8;
    }

    public void setContention_atime_be(int r8) {
        this.contention_atime_be = r8;
    }

    public void setContention_atime_bk(int r8) {
        this.contention_atime_bk = r8;
    }

    public void setContention_atime_vi(int r8) {
        this.contention_atime_vi = r8;
    }

    public void setContention_atime_vo(int r8) {
        this.contention_atime_vo = r8;
    }

    public void setDeltaCcaBusyTime(int r8) {
        this.deltaCcaBusyTime = r8;
    }

    public void setDeltaRadioOnTime(int r8) {
        this.deltaRadioOnTime = r8;
    }

    public void setDeltaRxSuccess(int r8) {
        this.deltaRxSuccess = r8;
    }

    public void setDeltaTxBad(long r8) {
        this.deltaTxBad = r8;
    }

    public void setDeltaTxRetries(long r8) {
        this.deltaTxRetries = r8;
    }

    public void setDeltaTxSuccess(long r8) {
        this.deltaTxSuccess = r8;
    }

    public void setLink_id(int r8) {
        this.link_id = r8;
    }

    public void setOn_time_scan(int r8) {
        this.on_time_scan = r8;
    }

    public void setPer(int r8) {
        this.per = r8;
    }

    public void setPower_pred_mw(float r8) {
        this.power_pred_mw = r8;
    }

    public void setRadio_id(int r8) {
        this.radio_id = r8;
    }

    public void setRl_cca_busy_rate(int r8) {
        this.rl_cca_busy_rate = r8;
    }

    public void setRl_rx_link_speed(int r8) {
        this.rl_rx_link_speed = r8;
    }

    public void setRl_tx_link_speed(int r8) {
        this.rl_tx_link_speed = r8;
    }

    public void setRssi_ack(int r8) {
        this.rssi_ack = r8;
    }

    public void setRssi_data(int r8) {
        this.rssi_data = r8;
    }

    public void setRssi_mgmt(int r8) {
        this.rssi_mgmt = r8;
    }

    public void setRx_speed_kbps(int r8) {
        this.rx_speed_kbps = r8;
    }

    public void setTxBadLevel(int r8) {
        this.txBadLevel = r8;
    }

    public void setTxMpduBe(long r8) {
        this.txMpduBe = r8;
    }

    public void setTxMpduVi(long r8) {
        this.txMpduVi = r8;
    }

    public void setTxMpduVo(long r8) {
        this.txMpduVo = r8;
    }

    public void setTxRetranLevel(int r8) {
        this.txRetranLevel = r8;
    }

    public void setTxRetranLevelBe(int r8) {
        this.txRetranLevelBe = r8;
    }

    public void setTxRetranLevelVi(int r8) {
        this.txRetranLevelVi = r8;
    }

    public void setTxRetranLevelVo(int r8) {
        this.txRetranLevelVo = r8;
    }

    public void setTxRetriesBe(long r8) {
        this.txRetriesBe = r8;
    }

    public void setTxRetriesVi(long r8) {
        this.txRetriesVi = r8;
    }

    public void setTxRetriesVo(long r8) {
        this.txRetriesVo = r8;
    }

    public void setTx_speed_kbps(int r8) {
        this.tx_speed_kbps = r8;
    }

    public void setWidth(int r8) {
        this.width = r8;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.link_id);
        r8.writeInt(this.radio_id);
        r8.writeInt(this.center_freq);
        r8.writeInt(this.deltaCcaBusyTime);
        r8.writeInt(this.deltaRadioOnTime);
        r8.writeInt(this.ccaLevel);
        r8.writeLong(this.deltaTxSuccess);
        r8.writeLong(this.deltaTxRetries);
        r8.writeInt(this.txRetranLevel);
        r8.writeLong(this.deltaTxBad);
        r8.writeInt(this.txBadLevel);
        r8.writeInt(this.deltaRxSuccess);
        r8.writeInt(this.contention_atime_be);
        r8.writeInt(this.contention_atime_bk);
        r8.writeInt(this.contention_atime_vi);
        r8.writeInt(this.contention_atime_vo);
        r8.writeLong(this.txMpduBe);
        r8.writeLong(this.txRetriesBe);
        r8.writeInt(this.txRetranLevelBe);
        r8.writeLong(this.txMpduVi);
        r8.writeLong(this.txRetriesVi);
        r8.writeInt(this.txRetranLevelVi);
        r8.writeLong(this.txMpduVo);
        r8.writeLong(this.txRetriesVo);
        r8.writeInt(this.txRetranLevelVo);
        r8.writeInt(this.width);
        r8.writeInt(this.rssi_mgmt);
        r8.writeInt(this.rssi_data);
        r8.writeInt(this.rssi_ack);
        r8.writeInt(this.rl_tx_link_speed);
        r8.writeInt(this.rl_rx_link_speed);
        r8.writeInt(this.rl_cca_busy_rate);
        r8.writeInt(this.per);
        r8.writeInt(this.on_time_scan);
        r8.writeInt(this.tx_speed_kbps);
        r8.writeInt(this.rx_speed_kbps);
        r8.writeFloat(this.power_pred_mw);
    }
}
