package com.obric.assistant.obric_action.handler.prompt;

import androidx.fragment.app.DialogFragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f implements Function1<Throwable, Unit> {
    public final /* synthetic */ DialogFragment a;

    public f(DialogFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        Throwable r5 = (Throwable) r4;
        DialogFragment r6 = this.a;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        r6.dismissAllowingStateLoss();     // Catch: Exception -> L6 Throwable -> L12
    L10:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L18;
        FLogger.a.e("ObricActionPromptDialog", "dismiss prompt dialog failed: " + r8);
    L18:
        return Unit.INSTANCE;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r9 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r9 == null) goto L10;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
