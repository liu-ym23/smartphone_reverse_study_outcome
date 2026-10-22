package com.larus.dora.impl.nl.notification_rule.ui;

import android.content.Context;
import com.larus.bmhome.utils.x1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k<T> implements FlowCollector {
    public final /* synthetic */ AddRuleInputFragment a;

    public k(AddRuleInputFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        int r5 = ((Number) r3).intValue();
        x1 r6 = this.a.f;
        if (r6 == null) goto L5;
        r6.a(true);
    L5:
        Context r7 = this.a.getContext();
        if (r7 == null) goto L9;
        AddRuleInputFragment r0 = this.a;
        t19.s r1 = t19.s.a;
        String r8 = r0.getString(r5);
        r1.getClass();
        t19.s.c(r7, r8);
    L9:
        return Unit.INSTANCE;
    }
}
