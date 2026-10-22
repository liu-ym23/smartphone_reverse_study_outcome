package com.byted.mgl.merge.service.api.privacy.device;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.webkit.CookieManager;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IPrivacyDeviceInfo {
    String getBSSID(WifiInfo r1, String r10);

    List<WifiConfiguration> getConfiguredNetworks(WifiManager r1, String r10);

    WifiInfo getConnectionInfo(WifiManager r1, String r10);

    String getCookie(CookieManager r1, String r10, String r11);

    Sensor getDefaultSensor(SensorManager r1, int r10, String r11);

    String getExtraInfo(NetworkInfo r1, String r10);

    String getNetworkOperator(TelephonyManager r1, String r10);

    String getNetworkOperatorName(TelephonyManager r1, String r10);

    int getNetworkType(TelephonyManager r1, String r10);

    String getSSID(WifiInfo r1, String r10);

    List<ScanResult> getScanResults(WifiManager r1, String r10);

    void setCookie(CookieManager r1, String r10, String r11, String r12);

    boolean startScan(WifiManager r1, String r10);
}
