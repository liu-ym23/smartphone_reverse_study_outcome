package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import com.obric.oui.button.OButton;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a2<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsCustomBroadcastRulesFragment a;

    public a2(DoraObricEarbudsCustomBroadcastRulesFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        boolean r3 = ((Boolean) r1).booleanValue();
        DoraObricEarbudsCustomBroadcastRulesFragment r4 = this.a;
        r4.l = r3;
        OButton r5 = r4.k;
        if (r5 == null) goto L9;
        if (r3 == false) goto L6;
        float r6 = 1.0f;
    L7:
        r5.setAlpha(r6);
        goto L9
    L6:
        r6 = 0.3f;
    L9:
        return Unit.INSTANCE;
    }
}
