package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface PowerMonitor$Natives {
    void onAppInBackgroundChanged(boolean r1);

    void onBatteryChargingChanged();

    void onInstantResume();

    void onInstantSuspend();

    void onResume();

    void onSuspend();

    void onThermalStatusChanged(int r1);
}
