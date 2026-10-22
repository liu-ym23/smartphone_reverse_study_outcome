package com.larus.dora.impl.device.settings.gesture;

import android.content.Context;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l<T> implements FlowCollector {
    public final /* synthetic */ DoraGGestureSettingsFragment a;

    public l(DoraGGestureSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r2, Continuation r3) {
        Unit r4 = (Unit) r2;
        DoraGGestureSettingsFragment r5 = this.a;
        int r6 = DoraGGestureSettingsFragment.l;
        r5.getClass();
        g49.d.d("DoraGGestureSettingsFragment", "showOtaTooLowToast");
        Context r7 = r5.getContext();
        if (r7 == null) goto L7;
        t19.s.a.getClass();
        t19.s.s(r7, 2131901985);
    L7:
        return Unit.INSTANCE;
    }
}
