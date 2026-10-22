package com.larus.dora.obric.device_management.setting.g.feedback;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.larus.common_ui.dialog.l0;
import com.larus.dora.impl.feedback.q0;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class w<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGFeedbackFragment a;

    public w(DoraObricGFeedbackFragment r1) {
        this.a = r1;
    }

    public static void a(l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final Object emit(Object r2, Continuation r3) {
        q0 r4 = (q0) r2;
        if ((r4 instanceof q0.c) == false) goto L10;
        l0 r5 = (l0) this.a.z.getValue();
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(r5);
    L20:
        return Unit.INSTANCE;
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L8:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        goto L20
    L10:
        if ((r4 instanceof q0.d) == false) goto L13;
        a((l0) this.a.z.getValue());
        t19.s r6 = t19.s.a;
        Context r0 = this.a.getContext();
        String r7 = ((q0.d) r4).a;
        r6.getClass();
        t19.s.p(r0, r7);
        this.a.requireActivity().getOnBackPressedDispatcher().onBackPressed();
        goto L20
    L13:
        if ((r4 instanceof q0.a) == false) goto L18;
        a((l0) this.a.z.getValue());
        q0.a r8 = (q0.a) r4;
        if (o0.d(r8.a) == false) goto L17;
        t19.s r9 = t19.s.a;
        Context r1 = this.a.getContext();
        String r10 = r8.a;
        r9.getClass();
        t19.s.u(r1, r10, 0);
    L17:
        this.a.Y90().resetState();
        goto L20
    L18:
        a((l0) this.a.z.getValue());
        goto L20
    }
}
