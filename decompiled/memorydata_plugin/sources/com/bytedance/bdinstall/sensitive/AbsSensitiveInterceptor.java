package com.bytedance.bdinstall.sensitive;

import android.net.wifi.WifiInfo;
import android.telephony.SubscriptionInfo;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class AbsSensitiveInterceptor {
    AbsSensitiveInterceptor() {
    }

    abstract List<SubscriptionInfo> getActiveSubscriptionInfoList();

    abstract WifiInfo getConnectionInfo();

    abstract String getCountry();

    abstract String getDeviceId();

    abstract byte[] getHardwareAddress(NetworkInterface r1);

    abstract String getIccId(SubscriptionInfo r1);

    abstract String getImeiByIndex(int r1);

    abstract String getMacAddress(WifiInfo r1);

    abstract String getMeidByIndex(int r1);

    abstract Enumeration<NetworkInterface> getNetworkInterfaces();

    abstract String getNetworkOperator();

    abstract String getNetworkOperatorName();

    abstract String getSSID(WifiInfo r1);

    abstract String getSerial();

    abstract String getSimCountryIso();

    abstract String getSimSerialNumber();
}
