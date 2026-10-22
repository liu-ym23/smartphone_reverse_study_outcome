package com.obric.aiagent.product.platform.impl.pocketmode;

import android.hardware.SensorEventListener;
import com.obric.aiagent.platform.a.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class CommonPocketModeDetector$Companion$unregister$$inlined$postInForeground$default$1 implements Runnable {
    public CommonPocketModeDetector$Companion$unregister$$inlined$postInForeground$default$1() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (CommonPocketModeDetector.access$getSensorRegistered$cp() == false) goto L8;
        CommonPocketModeDetector.Companion r3 = CommonPocketModeDetector.Companion;
        CommonPocketModeDetector.access$setSensorRegistered$cp(false);
        if (CommonPocketModeDetector.Companion.access$getSensor(CommonPocketModeDetector.Companion) == null) goto L9;
        CommonPocketModeDetector.Companion.access$getSensorManager(CommonPocketModeDetector.Companion).unregisterListener((SensorEventListener) ZeusTransformUtils.preCheckCast(CommonPocketModeDetector.access$getSensorEventListener$cp(), SensorEventListener.class, "com.obric.memorydata.plugin"));
        d.f5954a.b("CommonPocketModeDetector", "sensor unregistered");
        return;
    L9:
        return;
    }
}
