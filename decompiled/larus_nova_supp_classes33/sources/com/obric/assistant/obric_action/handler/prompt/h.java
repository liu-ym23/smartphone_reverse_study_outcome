package com.obric.assistant.obric_action.handler.prompt;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larus.common_ui.dialog.f0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h {
    public static final f0 c(FragmentActivity r3) {
        return new f0(null, Integer.valueOf(ContextCompat.getColor(r3, 2131103203)), null, 5);
    }

    public static final Object a(FragmentActivity r5, Function2 r6, ContinuationImpl r7) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r7), 1);
        r0.C();
        Ref.BooleanRef r1 = new Ref.BooleanRef();
        DialogFragment r8 = (DialogFragment) r6.invoke(new PromptDialogActionHandlersKt$awaitPromptDialog$2$dialog$1(r1, r0), new PromptDialogActionHandlersKt$awaitPromptDialog$2$dialog$2(r1, r0));
        r0.i(new f(r8));
        FragmentManager r9 = r5.getSupportFragmentManager();
        String r2 = "ObricActionPromptDialog-" + r8.hashCode();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
        if (r9.isStateSaved() == false) goto L10;
        FragmentTransaction r10 = r9.beginTransaction();     // Catch: Throwable -> L18
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r8, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r2, 0) == true) goto L9;
        r10 = r10.add(r8, r2);     // Catch: Throwable -> L18
    L9:
        Integer r11 = Integer.valueOf(r10.commitAllowingStateLoss());     // Catch: Throwable -> L18
    L16:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L18
    L20:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L24;
        FLogger.a.e("ObricActionPromptDialog", "show prompt dialog failed: " + r13);
    L24:
        if (Result.isSuccess-impl(r12) == true) goto L26;
        b(r1, r0, new j("dismissed", 14));
    L26:
        Object r14 = r0.B();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L29:
        return r14;
    L10:
        LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L18
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, r2, r4);     // Catch: Throwable -> L18
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r9, r8, r4) == false) goto L33;
    L15:
        r11 = Unit.INSTANCE;     // Catch: Throwable -> L18
        goto L16
    L33:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L30 Throwable -> L18
    L14:
        r8.show(r9, r2);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public static final void b(Ref.BooleanRef r1, kotlinx.coroutines.i r2, j r3) {
        if (r1.element == false) goto L5;
        return;
    L5:
        if (r2.isActive() == false) goto L9;
        r1.element = true;
        r2.resumeWith(Result.constructor-impl(r3));
        return;
    }
}
