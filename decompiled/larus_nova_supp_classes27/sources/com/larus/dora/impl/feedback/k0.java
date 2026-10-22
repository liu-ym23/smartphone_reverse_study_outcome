package com.larus.dora.impl.feedback;

import android.content.Context;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k0<T> implements FlowCollector {
    public final /* synthetic */ DoraGFeedbackFragment a;

    public k0(DoraGFeedbackFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r2, Continuation r3) {
        q0 r4 = (q0) r2;
        if ((r4 instanceof q0.c) == false) goto L13;
        DoraGFeedbackFragment r5 = this.a;
        r5.p = true;
        if (((com.larus.common_ui.dialog.l0) r5.o.getValue()).isShowing() == true) goto L11;
        com.larus.common_ui.dialog.l0 r6 = (com.larus.common_ui.dialog.l0) r5.o.getValue();
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L25;
        DialogLancet.handleBlockedDialogShow(r6);
        goto L11
    L25:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L10:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
    L11:
        ((com.larus.common_ui.dialog.l0) r5.o.getValue()).setContentView(2131562179);
    L23:
        return Unit.INSTANCE;
    L13:
        if ((r4 instanceof q0.d) == false) goto L16;
        DoraGFeedbackFragment r7 = this.a;
        int r0 = DoraGFeedbackFragment.r;
        r7.W90();
        g49.d.d("DoraSuggestionFragment", "Feedback submit succeeded, returning to device management");
        t19.s r8 = t19.s.a;
        Context r1 = this.a.getContext();
        String r9 = ((q0.d) r4).a;
        r8.getClass();
        t19.s.p(r1, r9);
        this.a.requireActivity().getOnBackPressedDispatcher().onBackPressed();
        goto L23
    L16:
        if ((r4 instanceof q0.a) == false) goto L21;
        DoraGFeedbackFragment r10 = this.a;
        int r11 = DoraGFeedbackFragment.r;
        r10.W90();
        q0.a r12 = (q0.a) r4;
        if (com.larus.utils.o0.d(r12.a) == false) goto L20;
        t19.s r13 = t19.s.a;
        Context r14 = this.a.getContext();
        String r15 = r12.a;
        r13.getClass();
        t19.s.u(r14, r15, 0);
    L20:
        this.a.X90().resetState();
        goto L23
    L21:
        DoraGFeedbackFragment r16 = this.a;
        int r17 = DoraGFeedbackFragment.r;
        r16.W90();
        goto L23
    }
}
