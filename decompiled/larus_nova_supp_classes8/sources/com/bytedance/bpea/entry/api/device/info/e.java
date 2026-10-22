package com.bytedance.bpea.entry.api.device.info;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static Sensor a(final SensorManager r3, final int r4, TokenCert r5) {
            BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
            int r1 = com.bytedance.bpea.entry.api.device.info.a.a;
            return (Sensor) r0.a(com.bytedance.bpea.entry.api.device.info.a.C0370a.a(r5, "deviceInfo_sensorManager_getDefaultSensor", 100703), new SensorEntry$Companion$getDefaultSensorUnsafe$1(r3, r4));
        }
    }

    static {
    }
}
