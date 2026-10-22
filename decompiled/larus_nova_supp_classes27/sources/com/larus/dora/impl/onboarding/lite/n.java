package com.larus.dora.impl.onboarding.lite;

import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.dora.impl.view.DoraItemTextToggleSubTitle;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n<T> implements FlowCollector {
    public final /* synthetic */ DoraLiteOnboardingKeepAliveFragment a;

    public n(DoraLiteOnboardingKeepAliveFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        boolean r3 = ((Boolean) r1).booleanValue();
        DoraItemTextToggleSubTitle r4 = this.a.r;
        if (r4 == null) goto L8;
        CustomSwitchCompat r5 = r4.getToggleView();
        if (r5 == null) goto L8;
        r5.setChecked(r3);
    L8:
        return Unit.INSTANCE;
    }
}
