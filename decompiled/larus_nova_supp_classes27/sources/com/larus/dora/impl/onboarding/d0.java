package com.larus.dora.impl.onboarding;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d0 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ DoraOnboardingDialogBaseFragment a;

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

    public d0(DoraOnboardingDialogBaseFragment r1) {
        this.a = r1;
    }
}
