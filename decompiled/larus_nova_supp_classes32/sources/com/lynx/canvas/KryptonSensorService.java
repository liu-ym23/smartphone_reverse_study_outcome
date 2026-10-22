package com.lynx.canvas;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class KryptonSensorService extends KryptonService {

    public interface Listener {
        void notifyGyroscopeData(float r1, float r2, float r3, long r4);

        void notifyOrientationData(float r1, float r2, float r3, long r4);
    }

    public List<Integer> getAvailableSensorTypes(List<Integer> r1) {
        return null;
    }

    public abstract void setListener(Listener r1);

    public abstract boolean start(List<Integer> r1, int r2);

    public abstract void stop();

    public KryptonSensorService() {
    }
}
