package com.obric.cae.userAware;

import android.hardware.SensorEvent;

/* JADX INFO: loaded from: classes3.dex */
public interface SensorCollectMonitor {
    void onSensorDataChanged(SensorEvent r1);

    void onStepsCounterChanged(int r1);
}
