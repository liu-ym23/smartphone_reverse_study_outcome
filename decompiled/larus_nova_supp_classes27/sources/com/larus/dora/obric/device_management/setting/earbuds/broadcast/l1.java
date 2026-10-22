package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import com.obric.oui.button.OButton;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l1<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsConfirmRulesSheet a;

    public l1(DoraObricEarbudsConfirmRulesSheet r1) {
        this.a = r1;
    }

    public final Object emit(Object r4, Continuation r5) {
        boolean r6 = ((Boolean) r4).booleanValue();
        OButton r7 = this.a.e;
        if (r7 == null) goto L5;
        r7.setEnabled(!r6);
    L5:
        OButton r8 = this.a.e;
        float r0 = 1.0f;
        if (r8 == null) goto L11;
        if (r6 == false) goto L9;
        float r2 = 0.3f;
    L10:
        r8.setAlpha(r2);
        goto L11
    L9:
        r2 = 1.0f;
    L11:
        OButton r9 = this.a.f;
        if (r9 == null) goto L14;
        r9.setEnabled(!r6);
    L14:
        OButton r10 = this.a.f;
        if (r10 == null) goto L20;
        if (r6 == false) goto L18;
        r0 = 0.3f;
    L18:
        r10.setAlpha(r0);
    L20:
        return Unit.INSTANCE;
    }
}
