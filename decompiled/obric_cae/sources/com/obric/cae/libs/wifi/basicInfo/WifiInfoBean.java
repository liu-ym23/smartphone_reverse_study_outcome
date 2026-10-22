package com.obric.cae.libs.wifi.basicInfo;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.utils.WifiUtils;

/* JADX INFO: loaded from: classes.dex */
public class WifiInfoBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WifiManager f5602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f5608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5610i;

    public WifiInfoBean(WifiManager r8) {
        this.f5602a = r8;
        update();
    }

    public boolean equals(WifiInfoBean r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        String r10 = this.f5603b;
        if (r10 != null) goto L8;
    L32:
        return false;
    L8:
        if (r10.equals(r8.f5603b) == true) goto L32;
        String r11 = this.f5604c;
        if (r11 == null) goto L32;
        if (r11.equals(r8.f5604c) == true) goto L32;
        if (this.f5605d == r8.f5605d) goto L19;
        return false;
    L19:
        if (this.f5606e == r8.f5606e) goto L22;
        return false;
    L22:
        if (this.f5607f == r8.f5607f) goto L25;
        return false;
    L25:
        if (this.f5609h == r8.f5609h) goto L28;
        return false;
    L28:
        if (this.f5610i == r8.f5610i) goto L30;
        return false;
    L30:
        return true;
    }

    public String getBssid() {
        return this.f5603b;
    }

    public int getChannel() {
        return this.f5607f;
    }

    public int getFrequency() {
        return this.f5605d;
    }

    public int getRssi() {
        update();
        return this.f5606e;
    }

    public int getRxLinkSpeedMbps() {
        return this.f5609h;
    }

    public String getSsid() {
        return this.f5604c;
    }

    public int getTxLinkSpeedMbps() {
        return this.f5610i;
    }

    public int getWifiStandard() {
        return this.f5608g.intValue();
    }

    public boolean is24GHz() {
        return WifiUtils.is24GHz(this.f5605d);
    }

    public boolean is5GHz() {
        return WifiUtils.is5GHz(this.f5605d);
    }

    public boolean is6GHz() {
        return WifiUtils.is6GHz(this.f5605d);
    }

    public String toString() {
        return "mBssid=" + WifiUtils.maskMacAddress(this.f5603b) + ", mSsid=" + WifiUtils.ssidHide(WifiUtils.removeDoubleQuotes(this.f5604c)) + ", mFrequency=" + this.f5605d + ", mRssi=" + this.f5606e + ", mChannel=" + this.f5607f + ", mRxLinkSpeed=" + this.f5609h + ", mTxLinkSpeed=" + this.f5610i;
    }

    public WifiInfoBean update() {
        WifiInfo r8 = this.f5602a.getConnectionInfo();
        LogUtil.d("WifiInfoBean", "get WifiInfo:" + r8);
        this.f5603b = r8.getBSSID();
        this.f5604c = r8.getSSID();
        this.f5605d = r8.getFrequency();
        this.f5606e = r8.getRssi();
        this.f5607f = WifiUtils.convertFrequencyMhzToChannel(this.f5605d);
        this.f5609h = r8.getRxLinkSpeedMbps();
        this.f5610i = r8.getTxLinkSpeedMbps();
        this.f5609h = r8.getRxLinkSpeedMbps();
        this.f5610i = r8.getTxLinkSpeedMbps();
        this.f5608g = Integer.valueOf(r8.getWifiStandard());
        return this;
    }
}
