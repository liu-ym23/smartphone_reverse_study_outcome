package com.obric.aiagent.product.platform.impl.pocketmode;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import com.obric.aiagent.product.a.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class CommonPocketModeDetector$Companion$register$$inlined$postInForeground$default$1 implements Runnable {
    public CommonPocketModeDetector$Companion$register$$inlined$postInForeground$default$1() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (CommonPocketModeDetector.access$getSensorRegistered$cp() == true) goto L9;
        Sensor r4 = CommonPocketModeDetector.Companion.access$getSensor(CommonPocketModeDetector.Companion);
        if (r4 == null) goto L10;
        CommonPocketModeDetector.Companion r0 = CommonPocketModeDetector.Companion;
        CommonPocketModeDetector.access$setSensorRegistered$cp(true);
        CommonPocketModeDetector.Companion.access$getSensorManager(CommonPocketModeDetector.Companion).registerListener((SensorEventListener) ZeusTransformUtils.preCheckCast(CommonPocketModeDetector.access$getSensorEventListener$cp(), SensorEventListener.class, "com.obric.memorydata.plugin"), r4, 0, d.f5969a.a());
        com.obric.aiagent.platform.a.d.f5954a.b("CommonPocketModeDetector", "sensor registered");
        return;
    L10:
        return;
    }
}
