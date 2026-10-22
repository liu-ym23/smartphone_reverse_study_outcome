package com.bytedance.bpea.entry.api.device.info;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/hardware/Sensor;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class SensorEntry$Companion$getDefaultSensorUnsafe$2 extends Lambda implements Function0<Sensor> {
    final /* synthetic */ SensorManager $this_getDefaultSensorUnsafe;
    final /* synthetic */ int $type;
    final /* synthetic */ boolean $wakeup;

    public SensorEntry$Companion$getDefaultSensorUnsafe$2(SensorManager r1, int r2, boolean r3) {
        this.$this_getDefaultSensorUnsafe = r1;
        this.$type = r2;
        this.$wakeup = r3;
        super(0);
    }

    public final Sensor invoke() {
        return this.$this_getDefaultSensorUnsafe.getDefaultSensor(this.$type, this.$wakeup);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1622invoke() {
        return invoke();
    }
}
