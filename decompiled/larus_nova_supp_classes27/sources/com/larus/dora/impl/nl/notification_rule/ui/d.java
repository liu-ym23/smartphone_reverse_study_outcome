package com.larus.dora.impl.nl.notification_rule.ui;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d<T> implements FlowCollector {
    public final /* synthetic */ AddRuleClarificationFragment a;

    public d(AddRuleClarificationFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r2, Continuation r3) {
        Unit r4 = (Unit) r2;
        NotificationRuleBottomSheet r5 = this.a.getParentFragment();
        NotificationRuleBottomSheet r0 = null;
        if ((r5 instanceof NotificationRuleBottomSheet) == false) goto L5;
        NotificationRuleBottomSheet r6 = r5;
    L6:
        if (r6 == null) goto L10;
        Function0<Unit> r7 = r6.e;
        if (r7 == null) goto L10;
        r7.invoke();
    L10:
        NotificationRuleBottomSheet r8 = this.a.getParentFragment();
        if ((r8 instanceof NotificationRuleBottomSheet) == false) goto L13;
        r0 = r8;
    L13:
        if (r0 == null) goto L21;
        r0.dismiss();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L21;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L21:
        return Unit.INSTANCE;
    L5:
        r6 = null;
        goto L6
    }
}
