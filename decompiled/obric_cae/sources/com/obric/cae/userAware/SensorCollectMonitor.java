package com.obric.cae.userAware;

import android.hardware.SensorEvent;

/* JADX INFO: loaded from: classes2.dex */
public interface SensorCollectMonitor {
    void onSensorDataChanged(SensorEvent r8);

    void onStepsCounterChanged(int r8);
}
