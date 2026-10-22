package com.larus.dora.impl.onboarding;

import com.larus.common_ui.dialog.CommonDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e0 implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ DoraOnboardingDialogBaseFragment a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        CommonDialog r0 = this.a.e;
        if (r0 == null) goto L13;
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L14;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    public e0(DoraOnboardingDialogBaseFragment r1) {
        this.a = r1;
    }
}
