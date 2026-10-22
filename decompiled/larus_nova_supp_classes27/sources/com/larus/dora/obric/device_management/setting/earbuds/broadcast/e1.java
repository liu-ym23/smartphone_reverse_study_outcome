package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e1<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsBroadcastSettingFragment a;

    public e1(DoraObricEarbudsBroadcastSettingFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        if (((Boolean) r1).booleanValue() == false) goto L6;
        DoraObricEarbudsBroadcastSettingFragment r3 = this.a;
        int r4 = DoraObricEarbudsBroadcastSettingFragment.F;
        r3.ca0();
    L6:
        return Unit.INSTANCE;
    }
}
