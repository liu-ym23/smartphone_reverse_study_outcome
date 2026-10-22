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

    abstract byte[] getHardwareAddress(NetworkInterface r10);

    abstract String getIccId(SubscriptionInfo r10);

    abstract String getImeiByIndex(int r10);

    abstract String getMacAddress(WifiInfo r10);

    abstract String getMeidByIndex(int r10);

    abstract Enumeration<NetworkInterface> getNetworkInterfaces();

    abstract String getNetworkOperator();

    abstract String getNetworkOperatorName();

    abstract String getSSID(WifiInfo r10);

    abstract String getSerial();

    abstract String getSimCountryIso();

    abstract String getSimSerialNumber();
}
