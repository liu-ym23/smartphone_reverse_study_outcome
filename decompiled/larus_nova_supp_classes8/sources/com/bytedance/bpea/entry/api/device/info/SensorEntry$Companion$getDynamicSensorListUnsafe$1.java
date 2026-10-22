package com.bytedance.bpea.entry.api.device.info;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroid/hardware/Sensor;", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class SensorEntry$Companion$getDynamicSensorListUnsafe$1 extends Lambda implements Function0<List<Sensor>> {
    final /* synthetic */ SensorManager $this_getDynamicSensorListUnsafe;
    final /* synthetic */ int $type;

    public SensorEntry$Companion$getDynamicSensorListUnsafe$1(SensorManager r1, int r2) {
        this.$this_getDynamicSensorListUnsafe = r1;
        this.$type = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final List<Sensor> m1623invoke() {
        return this.$this_getDynamicSensorListUnsafe.getDynamicSensorList(this.$type);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1623invoke();
    }
}
