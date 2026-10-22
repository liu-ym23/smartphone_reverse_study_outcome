package com.bytedance.bdlocation.scan.wifi;

import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;

/* JADX INFO: loaded from: classes.dex */
public class BDWifiInfo {

    @ia.b("BSSID")
    private String bssid;

    @ia.b("channel")
    private int channel;

    @ia.b("isCurrent")
    private boolean isCurrent;

    @ia.b("RSSI")
    private int rssi;

    @ia.b("SSID")
    private String ssid;

    @ia.b(BwdlDropProvider.BwdlDropEntry.TIMESTAMP)
    private long timeStamp;

    public BDWifiInfo() {
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L18:
        return false;
    L8:
        if (getClass() != r8.getClass()) goto L18;
        BDWifiInfo r10 = (BDWifiInfo) r8;
        String r11 = this.bssid;
        if (r11 == null) goto L14;
        return r11.equals(r10.bssid);
    L14:
        if (r10.bssid != null) goto L17;
        return true;
    L17:
        return false;
    }

    public String getBssid() {
        return this.bssid;
    }

    public int getChannel() {
        return this.channel;
    }

    public int getRssi() {
        return this.rssi;
    }

    public String getSsid() {
        return this.ssid;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public int hashCode() {
        String r8 = this.bssid;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return r8.hashCode();
    }

    public boolean isCurrent() {
        return this.isCurrent;
    }

    public BDWifiInfo setBssid(String r8) {
        this.bssid = r8;
        return this;
    }

    public BDWifiInfo setChannel(int r8) {
        this.channel = r8;
        return this;
    }

    public BDWifiInfo setCurrent(boolean r8) {
        this.isCurrent = r8;
        return this;
    }

    public BDWifiInfo setRssi(int r8) {
        this.rssi = r8;
        return this;
    }

    public BDWifiInfo setSsid(String r8) {
        this.ssid = r8;
        return this;
    }

    public void setTimeStamp(long r8) {
        this.timeStamp = r8;
    }

    public String toString() {
        return "WifiInfo{bssid='" + this.bssid + "', channel='" + this.channel + "', isCurrent=" + this.isCurrent + ", rssi=" + this.rssi + ", ssid='" + this.ssid + "', timeStamp='" + this.timeStamp + "'}";
    }
}
