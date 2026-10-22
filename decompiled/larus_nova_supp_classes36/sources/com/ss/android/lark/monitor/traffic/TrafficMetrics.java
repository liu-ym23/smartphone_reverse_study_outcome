package com.ss.android.lark.monitor.traffic;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class TrafficMetrics {
    public static final String FROM_HTTP = "http";
    public static final String FROM_RTC = "rtc";
    public static final String FROM_RUST = "rust";
    public static final String FROM_TOTAL = "total";
    public static final String FROM_VIDEO_PLAY = "video_play";
    public static final String FROM_WEB_VIEW = "web";
    public static final String FRPM_TTNET = "ttnet";
    private static final float KB = 9.765625E-4f;

    @JSONField(serialize = false)
    public String from;

    @JSONField(serialize = false)
    public long mobileBytesRx;

    @JSONField(serialize = false)
    public long mobileBytesTx;
    public float mobileKBytesRx;
    public float mobileKBytesTx;

    @JSONField(serialize = false)
    public long wifiBytesRx;

    @JSONField(serialize = false)
    public long wifiBytesTx;
    public float wifiKBytesRx;
    public float wifiKBytesTx;

    public void convert2KB() {
        this.mobileKBytesRx = this.mobileBytesRx * KB;
        this.mobileKBytesTx = this.mobileBytesTx * KB;
        this.wifiKBytesRx = this.wifiBytesRx * KB;
        this.wifiKBytesTx = this.wifiBytesTx * KB;
    }

    @JSONField(serialize = false)
    public boolean isValid() {
        if (this.mobileBytesRx <= 0) goto L5;
    L12:
        return true;
    L5:
        if (this.mobileBytesTx > 0) goto L12;
        if (this.wifiBytesRx > 0) goto L12;
        if (this.wifiBytesTx > 0) goto L12;
        return false;
    }

    public void reset() {
        this.wifiBytesTx = 0;
        this.wifiBytesRx = 0;
        this.mobileBytesTx = 0;
        this.mobileBytesRx = 0;
    }

    public float totalKBytes() {
        return (((this.mobileBytesRx * KB) + (this.mobileBytesTx * KB)) + (this.wifiBytesRx * KB)) + (this.wifiBytesTx * KB);
    }

    public float totalMobileKBytes() {
        return (this.mobileBytesRx * KB) + (this.mobileBytesTx * KB);
    }

    public float totalRxKBytes() {
        return (this.mobileBytesRx * KB) + (this.wifiBytesRx * KB);
    }

    public float totalTxKBytes() {
        return (this.mobileBytesTx * KB) + (this.wifiBytesTx * KB);
    }

    public float totalWifiKBytes() {
        return (this.wifiBytesRx * KB) + (this.wifiBytesTx * KB);
    }

    public TrafficMetrics() {
    }

    public String from() {
        return this.from;
    }

    public void set(TrafficMetrics r3) {
        this.mobileBytesRx = r3.mobileBytesRx;
        this.mobileBytesTx = r3.mobileBytesTx;
        this.wifiBytesRx = r3.wifiBytesRx;
        this.wifiBytesTx = r3.wifiBytesTx;
    }

    public TrafficMetrics(long r1, long r3, long r5, long r7) {
        this.mobileBytesRx = r1;
        this.mobileBytesTx = r3;
        this.wifiBytesRx = r5;
        this.wifiBytesTx = r7;
    }
}
