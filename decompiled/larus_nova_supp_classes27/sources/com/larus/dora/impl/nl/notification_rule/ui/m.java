package com.larus.dora.impl.nl.notification_rule.ui;

import com.larus.bmhome.utils.x1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m<T> implements FlowCollector {
    public final /* synthetic */ AddRuleInputFragment a;

    public m(AddRuleInputFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r2, Continuation r3) {
        Unit r4 = (Unit) r2;
        x1 r5 = this.a.f;
        if (r5 == null) goto L5;
        r5.a(true);
    L5:
        NotificationRuleBottomSheet r6 = this.a.getParentFragment();
        NotificationRuleBottomSheet r0 = null;
        if ((r6 instanceof NotificationRuleBottomSheet) == false) goto L8;
        NotificationRuleBottomSheet r7 = r6;
    L9:
        if (r7 == null) goto L13;
        Function0<Unit> r8 = r7.e;
        if (r8 == null) goto L13;
        r8.invoke();
    L13:
        NotificationRuleBottomSheet r9 = this.a.getParentFragment();
        if ((r9 instanceof NotificationRuleBottomSheet) == false) goto L16;
        r0 = r9;
    L16:
        if (r0 == null) goto L24;
        r0.dismiss();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r10 = DialogFragmentLancet.sLastShowStack;
        if (r10 == null) goto L24;
        com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L24:
        return Unit.INSTANCE;
    L8:
        r7 = null;
        goto L9
    }
}
