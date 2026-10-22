package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n1<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsConfirmRulesSheet a;

    public n1(DoraObricEarbudsConfirmRulesSheet r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        int r5 = ((Number) r3).intValue();
        FragmentActivity r6 = this.a.getActivity();
        if (r6 == null) goto L6;
        DoraObricEarbudsConfirmRulesSheet r0 = this.a;
        Handler r1 = com.obric.oui.toast.f.n;
        com.obric.oui.toast.f.a.a(r6, r0.getString(r5));
    L6:
        return Unit.INSTANCE;
    }
}
