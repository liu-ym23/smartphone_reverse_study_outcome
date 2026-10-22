package com.obric.cae.libs.wifi.basicInfo;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.utils.WifiUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ScanResultBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WifiManager f5591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<ScanResult> f5592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WifiInfo f5593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5599i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5600j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f5601k;

    public ScanResultBean(Context r8, WifiManager r10) {
        this.f5599i = Integer.MIN_VALUE;
        this.f5600j = Integer.MIN_VALUE;
        this.f5601k = r8;
        this.f5591a = r10;
        if (r10.isWifiEnabled() == false) goto L5;
        r10.startScan();
    L5:
        update();
    }

    public int getBandwidth() {
        int r8 = this.f5596f;
        if (r8 != 4) goto L5;
    L18:
        r8 = r8 - 1;
    L17:
        return (int) (Math.pow(2.0d, r8) * 20.0d);
    L5:
        if (r8 == 5) goto L18;
        if (r8 == 0) goto L17;
        if (r8 == 1) goto L17;
        if (r8 == 2) goto L17;
        if (r8 == 3) goto L17;
        return -1;
    }

    public int getCurrentChannelUsedCount() {
        if (this.f5595e == false) goto L5;
        int r8 = this.f5599i;
        int r10 = this.f5600j;
        if (r8 >= r10) goto L10;
        return r8;
    L10:
        return r10;
    L5:
        return this.f5599i;
    }

    public List<ScanResult> getLastScanResults() {
        return this.f5592b;
    }

    public boolean startScan() {
        WifiManager r8 = this.f5591a;
        if (r8 != null) goto L5;
        return false;
    L5:
        return r8.startScan();
    }

    public void update() {
        this.f5592b = WifiUtils.getWifiScanResults(this.f5601k, this.f5591a);
        WifiInfo r8 = this.f5591a.getConnectionInfo();
        this.f5593c = r8;
        if (this.f5592b == null) goto L31;
        if (r8 == null) goto L42;
        this.f5594d = r8.getBSSID();
        this.f5597g = this.f5593c.getFrequency();
        Iterator<ScanResult> r10 = this.f5592b.iterator();
    L8:
        if (r10.hasNext() == false) goto L17;
        ScanResult r11 = r10.next();
        if (r11.BSSID.equals(this.f5594d) == false) goto L8;
        this.f5596f = r11.channelWidth;
        if (LogUtil.isLoggable(3) == false) goto L15;
        LogUtil.d("ScanResultBean", "match bssid!, channelWidth:" + this.f5596f);
    L15:
        if (this.f5596f != 4) goto L17;
        this.f5595e = true;
        this.f5597g = r11.centerFreq0;
        this.f5598h = r11.centerFreq1;
    L17:
        this.f5599i = 0;
        if (this.f5595e == false) goto L20;
        this.f5600j = 0;
    L20:
        Iterator<ScanResult> r12 = this.f5592b.iterator();
    L22:
        if (r12.hasNext() == false) goto L43;
        int r13 = r12.next().frequency;
        if (r13 != this.f5597g) goto L27;
        this.f5599i++;
    L27:
        if (this.f5595e == false) goto L22;
        if (r13 != this.f5598h) goto L22;
        this.f5600j++;
        goto L22
    L43:
        return;
    L42:
        return;
    }

    public ScanResultBean(List<ScanResult> r8, WifiInfo r10) {
        this.f5599i = Integer.MIN_VALUE;
        this.f5600j = Integer.MIN_VALUE;
        this.f5592b = r8;
        this.f5593c = r10;
    }
}
