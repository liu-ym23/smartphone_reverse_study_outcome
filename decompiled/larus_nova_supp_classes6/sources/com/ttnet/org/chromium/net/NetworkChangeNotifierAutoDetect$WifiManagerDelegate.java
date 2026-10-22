package com.ttnet.org.chromium.net;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class NetworkChangeNotifierAutoDetect$WifiManagerDelegate {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Context mContext;
    private boolean mHasWifiPermission;
    private boolean mHasWifiPermissionComputed;
    private final Object mLock;
    private WifiManager mWifiManager;

    public String getWifiSsid() {
        return "";
    }

    private WifiInfo getWifiInfoLocked() {
        return com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$WifiManagerDelegate_android_net_wifi_WifiManager_getConnectionInfo(this.mWifiManager);
    L4:
        return com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$WifiManagerDelegate_android_net_wifi_WifiManager_getConnectionInfo(this.mWifiManager);
    L6:
        return null;
    }

    private boolean hasPermissionLocked() {
        if (this.mHasWifiPermissionComputed == false) goto L7;
        return this.mHasWifiPermission;
    L7:
        if (this.mContext.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.mContext.getPackageName()) != 0) goto L9;
        boolean r0 = true;
    L10:
        this.mHasWifiPermission = r0;
        if (r0 == false) goto L13;
        WifiManager r1 = (WifiManager) this.mContext.getSystemService("wifi");
    L14:
        this.mWifiManager = r1;
        this.mHasWifiPermissionComputed = true;
        return this.mHasWifiPermission;
    L13:
        r1 = null;
        goto L14
    L9:
        r0 = false;
        goto L10
    }

    public NetworkChangeNotifierAutoDetect$WifiManagerDelegate() {
        this.mLock = new Object();
        this.mContext = null;
    }

    static {
    }

    public NetworkChangeNotifierAutoDetect$WifiManagerDelegate(Context r2) {
        this.mLock = new Object();
        this.mContext = r2;
    }

    private static WifiInfo com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$WifiManagerDelegate_android_net_wifi_WifiManager_getConnectionInfo(WifiManager r18) {
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
}
