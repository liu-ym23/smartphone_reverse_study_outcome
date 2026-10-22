package com.obric.assistant.remote_card_container;

import android.os.IBinder;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i implements IBinder.DeathRecipient {
    public final /* synthetic */ IBinder a;
    public final /* synthetic */ Ref.ObjectRef<CommonDialog> b;

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        IBinder r1 = this.a;
        Ref.ObjectRef<CommonDialog> r2 = this.b;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L25
        FLogger.a.i("RemoteCardImpl", "binderDied, will dismiss dialog");     // Catch: Throwable -> L25
        if (r1 == null) goto L33;
        r1.unlinkToDeath(this, 0);     // Catch: Throwable -> L25
    L33:
        CommonDialog r4 = (CommonDialog) r2.element;     // Catch: Throwable -> L18
        if (r4 != null) goto L31;
        Unit r5 = null;
    L16:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L18
    L20:
        Throwable r7 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L25
        if (r7 == null) goto L23;
        FLogger.a.w("RemoteCardImpl", "dismiss dialog failed", r7);     // Catch: Throwable -> L25
    L23:
        Object r8 = Result.constructor-impl(Result.box-impl(r6));     // Catch: Throwable -> L25
    L27:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L37;
        FLogger.a.w("RemoteCardImpl", "linkToDeath failed", r9);
        return;
    L37:
        return;
    L31:
        r4.dismissAllowingStateLoss();     // Catch: Exception -> L10 Throwable -> L18
    L14:
        r5 = Unit.INSTANCE;     // Catch: Throwable -> L18
        goto L16
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r10 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r10 == null) goto L14;
        com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L25
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }

    public i(IBinder r1, Ref.ObjectRef<CommonDialog> r2) {
        this.a = r1;
        this.b = r2;
    }
}
