package com.larus.dora.impl.nl.notification_rule.ui;

import android.widget.LinearLayout;
import com.larus.dora.impl.databinding.LarusDoraFragmentCustomBroadcastRulesBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class z<T> implements FlowCollector {
    public final /* synthetic */ CustomBroadcastRulesFragment a;

    public z(CustomBroadcastRulesFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        boolean r3 = ((Boolean) r1).booleanValue();
        LarusDoraFragmentCustomBroadcastRulesBinding r4 = this.a.d;
        if (r4 == null) goto L11;
        LinearLayout r5 = r4.b;
        if (r5 == null) goto L11;
        if (r3 == false) goto L8;
        float r6 = 1.0f;
    L9:
        r5.setAlpha(r6);
        goto L11
    L8:
        r6 = 0.3f;
    L11:
        return Unit.INSTANCE;
    }
}
