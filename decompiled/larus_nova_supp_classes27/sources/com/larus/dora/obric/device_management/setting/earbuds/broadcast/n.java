package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsAddRuleInputSheet a;

    public n(DoraObricEarbudsAddRuleInputSheet r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        Unit r3 = (Unit) r1;
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
    L10:
        return Unit.INSTANCE;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L10;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }
}
