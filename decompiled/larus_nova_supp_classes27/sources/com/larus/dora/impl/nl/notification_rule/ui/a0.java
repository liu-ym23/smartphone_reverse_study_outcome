package com.larus.dora.impl.nl.notification_rule.ui;

import android.content.Context;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a0<T> implements FlowCollector {
    public final /* synthetic */ CustomBroadcastRulesFragment a;

    public a0(CustomBroadcastRulesFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        int r5 = ((Number) r3).intValue();
        Context r6 = this.a.getContext();
        if (r6 == null) goto L6;
        CustomBroadcastRulesFragment r0 = this.a;
        t19.s r1 = t19.s.a;
        String r7 = r0.getString(r5);
        r1.getClass();
        t19.s.c(r6, r7);
    L6:
        return Unit.INSTANCE;
    }
}
