package com.larus.dora.obric.device_management.setting.earbuds.gesture;

import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsGestureWakeUpFragment a;

    public u(DoraObricEarbudsGestureWakeUpFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r2, Continuation r3) {
        com.larus.dora.impl.device.settings.gesture.wakeup.h r4 = (com.larus.dora.impl.device.settings.gesture.wakeup.h) r2;
        if (r4 == null) goto L8;
        GestureWakeupType r5 = r4.getType();
        if (r5 == null) goto L8;
        DoraObricEarbudsGestureWakeUpFragment.W90(this.a, r4.b, r5);
    L8:
        return Unit.INSTANCE;
    }
}
