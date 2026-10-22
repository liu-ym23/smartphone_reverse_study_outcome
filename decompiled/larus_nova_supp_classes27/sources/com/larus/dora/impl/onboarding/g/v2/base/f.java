package com.larus.dora.impl.onboarding.g.v2.base;

import com.larus.common_ui.dialog.p0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f implements p0 {
    public final /* synthetic */ DoraGOnboardingDialogBaseFragment a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L12;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public f(DoraGOnboardingDialogBaseFragment r1) {
        this.a = r1;
    }
}
