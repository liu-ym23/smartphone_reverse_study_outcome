package com.obric.cae.smartNetwork.throughtput;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public interface ThroughputCallback {
    default void onPrimaryTxDelayStatsUpdated(long r8, float r10, float r11, float r12) {
    }

    void onSecondaryThroughputChanged(int r8, int r10);

    default void onSecondaryTxDelayStatsUpdated(long r8, float r10, float r11, float r12) {
    }

    void onThroughputChanged(int r8, int r10);

    void onWifiConnectInfoChanged(Bundle r8);

    void onWifiConnectStateChanged(int r8);
}
