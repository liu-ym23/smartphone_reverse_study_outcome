package com.obric.cae.libs.wifi.basicInfo;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.utils.WifiUtils;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class ScanResultBean {
    public final WifiManager a;
    public List<ScanResult> b;
    public WifiInfo c;
    public String d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public final Context k;

    public int getBandwidth() {
        int r0 = this.f;
        if (r0 != 4) goto L5;
    L19:
        double r1 = Math.pow(2.0d, r0 - 1);
    L18:
        return (int) (r1 * 20.0d);
    L5:
        if (r0 == 5) goto L19;
        if (r0 == 0) goto L16;
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L16;
        if (r0 == 3) goto L16;
        return -1;
    L16:
        r1 = Math.pow(2.0d, r0);
        goto L18
    }

    public int getCurrentChannelUsedCount() {
        if (this.e == false) goto L5;
        int r0 = this.i;
        int r1 = this.j;
        if (r0 >= r1) goto L10;
        return r0;
    L10:
        return r1;
    L5:
        return this.i;
    }

    public boolean startScan() {
        WifiManager r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        return com_obric_cae_libs_wifi_basicInfo_ScanResultBean_android_net_wifi_WifiManager_startScan(r0);
    }

    public void update() {
        this.b = WifiUtils.getWifiScanResults(this.k, this.a);
        WifiInfo r0 = com_obric_cae_libs_wifi_basicInfo_ScanResultBean_android_net_wifi_WifiManager_getConnectionInfo(this.a);
        this.c = r0;
        if (this.b == null) goto L31;
        if (r0 == null) goto L42;
        this.d = com_obric_cae_libs_wifi_basicInfo_ScanResultBean_android_net_wifi_WifiInfo_getBSSID(r0);
        this.g = this.c.getFrequency();
        Iterator<ScanResult> r1 = this.b.iterator();
    L8:
        if (r1.hasNext() == false) goto L17;
        ScanResult r2 = r1.next();
        if (r2.BSSID.equals(this.d) == false) goto L8;
        this.f = r2.channelWidth;
        if (LogUtil.isLoggable(3) == false) goto L15;
        LogUtil.d("ScanResultBean", "match bssid!, channelWidth:" + this.f);
    L15:
        if (this.f != 4) goto L17;
        this.e = true;
        this.g = r2.centerFreq0;
        this.h = r2.centerFreq1;
    L17:
        this.i = 0;
        if (this.e == false) goto L20;
        this.j = 0;
    L20:
        Iterator<ScanResult> r3 = this.b.iterator();
    L22:
        if (r3.hasNext() == false) goto L43;
        int r4 = r3.next().frequency;
        if (r4 != this.g) goto L27;
        this.i++;
    L27:
        if (this.e == false) goto L22;
        if (r4 != this.h) goto L22;
        this.j++;
        goto L22
    L43:
        return;
    L42:
        return;
    }

    public List<ScanResult> getLastScanResults() {
        return this.b;
    }

    private static String com_obric_cae_libs_wifi_basicInfo_ScanResultBean_android_net_wifi_WifiInfo_getBSSID(WifiInfo r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        b r11 = new b();
        a r2 = (a) ApiHookConfig.b.get(101100);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(101100, "android/net/wifi/WifiInfo", "getBSSID", r18, r10, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.getBSSID();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private static WifiInfo com_obric_cae_libs_wifi_basicInfo_ScanResultBean_android_net_wifi_WifiManager_getConnectionInfo(WifiManager r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        b r11 = new b();
        a r2 = (a) ApiHookConfig.b.get(102301);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(102301, "android/net/wifi/WifiManager", "getConnectionInfo", r18, r10, "android.net.wifi.WifiInfo", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (WifiInfo) r4.b;
    L21:
        return r18.getConnectionInfo();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private static boolean com_obric_cae_libs_wifi_basicInfo_ScanResultBean_android_net_wifi_WifiManager_startScan(WifiManager r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        b r11 = new b();
        a r2 = (a) ApiHookConfig.b.get(102302);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(102302, "android/net/wifi/WifiManager", "startScan", r18, r10, "boolean", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Boolean) r4.b).booleanValue();
    L21:
        return r18.startScan();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public ScanResultBean(Context r2, WifiManager r3) {
        this.i = Integer.MIN_VALUE;
        this.j = Integer.MIN_VALUE;
        this.k = r2;
        this.a = r3;
        if (r3.isWifiEnabled() == false) goto L5;
        com_obric_cae_libs_wifi_basicInfo_ScanResultBean_android_net_wifi_WifiManager_startScan(r3);
    L5:
        update();
    }

    public ScanResultBean(List<ScanResult> r2, WifiInfo r3) {
        this.i = Integer.MIN_VALUE;
        this.j = Integer.MIN_VALUE;
        this.b = r2;
        this.c = r3;
    }
}
