package com.obric.cae.libs.wifi.basicInfo;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.utils.WifiUtils;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class WifiInfoBean {
    public final WifiManager a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public Integer g;
    public int h;
    public int i;

    public int getWifiStandard() {
        return this.g.intValue();
    }

    public boolean is24GHz() {
        return WifiUtils.is24GHz(this.d);
    }

    public boolean is5GHz() {
        return WifiUtils.is5GHz(this.d);
    }

    public boolean is6GHz() {
        return WifiUtils.is6GHz(this.d);
    }

    public String toString() {
        return "mBssid=" + WifiUtils.maskMacAddress(this.b) + ", mSsid=" + WifiUtils.ssidHide(WifiUtils.removeDoubleQuotes(this.c)) + ", mFrequency=" + this.d + ", mRssi=" + this.e + ", mChannel=" + this.f + ", mRxLinkSpeed=" + this.h + ", mTxLinkSpeed=" + this.i;
    }

    public WifiInfoBean update() {
        WifiInfo r0 = com_obric_cae_libs_wifi_basicInfo_WifiInfoBean_android_net_wifi_WifiManager_getConnectionInfo(this.a);
        LogUtil.d("WifiInfoBean", "get WifiInfo:" + r0);
        this.b = com_obric_cae_libs_wifi_basicInfo_WifiInfoBean_android_net_wifi_WifiInfo_getBSSID(r0);
        this.c = com_obric_cae_libs_wifi_basicInfo_WifiInfoBean_android_net_wifi_WifiInfo_getSSID(r0);
        this.d = r0.getFrequency();
        this.e = r0.getRssi();
        this.f = WifiUtils.convertFrequencyMhzToChannel(this.d);
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 29) goto L5;
        this.h = r0.getRxLinkSpeedMbps();
        this.i = r0.getTxLinkSpeedMbps();
    L7:
        if (r1 < 30) goto L9;
        this.h = r0.getRxLinkSpeedMbps();
        this.i = r0.getTxLinkSpeedMbps();
        this.g = Integer.valueOf(r0.getWifiStandard());
    L10:
        return this;
    L9:
        this.i = r0.getLinkSpeed();
        this.h = 0;
        this.g = 0;
        goto L10
    L5:
        this.h = 0;
        this.i = 0;
        goto L7
    }

    public int getRssi() {
        update();
        return this.e;
    }

    public String getBssid() {
        return this.b;
    }

    public int getChannel() {
        return this.f;
    }

    public int getFrequency() {
        return this.d;
    }

    public int getRxLinkSpeedMbps() {
        return this.h;
    }

    public String getSsid() {
        return this.c;
    }

    public int getTxLinkSpeedMbps() {
        return this.i;
    }

    public WifiInfoBean(WifiManager r1) {
        this.a = r1;
        update();
    }

    private static String com_obric_cae_libs_wifi_basicInfo_WifiInfoBean_android_net_wifi_WifiInfo_getBSSID(WifiInfo r18) {
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

    private static String com_obric_cae_libs_wifi_basicInfo_WifiInfoBean_android_net_wifi_WifiInfo_getSSID(WifiInfo r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        b r11 = new b();
        a r2 = (a) ApiHookConfig.b.get(101000);
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
        d r4 = r7.preInvoke(101000, "android/net/wifi/WifiInfo", "getSSID", r18, r10, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.getSSID();
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

    private static WifiInfo com_obric_cae_libs_wifi_basicInfo_WifiInfoBean_android_net_wifi_WifiManager_getConnectionInfo(WifiManager r18) {
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

    public boolean equals(WifiInfoBean r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        String r1 = this.b;
        if (r1 != null) goto L8;
    L32:
        return false;
    L8:
        if (r1.equals(r4.b) == true) goto L32;
        String r2 = this.c;
        if (r2 == null) goto L32;
        if (r2.equals(r4.c) == true) goto L32;
        if (this.d == r4.d) goto L19;
        return false;
    L19:
        if (this.e == r4.e) goto L22;
        return false;
    L22:
        if (this.f == r4.f) goto L25;
        return false;
    L25:
        if (this.h == r4.h) goto L28;
        return false;
    L28:
        if (this.i == r4.i) goto L30;
        return false;
    L30:
        return true;
    }
}
