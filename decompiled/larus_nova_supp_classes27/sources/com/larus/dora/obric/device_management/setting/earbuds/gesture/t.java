package com.larus.dora.obric.device_management.setting.earbuds.gesture;

import androidx.fragment.app.FragmentActivity;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsGestureWakeUpFragment a;

    public t(DoraObricEarbudsGestureWakeUpFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        if ((((com.larus.dora.impl.device.settings.gesture.wakeup.a) r1) instanceof com.larus.dora.impl.device.settings.gesture.wakeup.a.C0044a) == false) goto L10;
        FragmentActivity r3 = this.a.getActivity();
        if (r3 == null) goto L8;
        r3.finish();
    L8:
        return Unit.INSTANCE;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
