package com.larus.dora.impl.nl.notification_rule.ui;

import com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class o implements Function0 {
    public final /* synthetic */ CustomBroadcastRulesFragment a;

    public /* synthetic */ o(CustomBroadcastRulesFragment r1) {
        this.a = r1;
    }

    public final Object invoke() {
        CustomBroadcastRulesViewModel r0 = this.a.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.loadRules();
        return Unit.INSTANCE;
    }
}
