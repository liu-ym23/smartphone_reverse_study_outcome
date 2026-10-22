package com.larus.dora.impl.guide;

import androidx.fragment.app.Fragment;
import com.larus.dora.impl.guide.widget.DoraGuideBottomSheetDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h0 implements DoraGuideBottomSheetDialogFragment.b {
    public final /* synthetic */ DoraNotificationGuide a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ DoraGuideBottomSheetDialogFragment c;

    @Override // com.larus.dora.impl.guide.widget.DoraGuideBottomSheetDialogFragment.b
    public final void onClose() {
        this.a.l();
    }

    @Override // com.larus.dora.impl.guide.widget.DoraGuideBottomSheetDialogFragment.b
    public final void onConfirm() {
        this.a.m(this.b);
        this.c.dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L12;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.larus.dora.impl.guide.widget.DoraGuideBottomSheetDialogFragment.b
    public final void onDismiss() {
        this.a.t();
    }

    public h0(DoraNotificationGuide r1, Fragment r2, DoraGuideBottomSheetDialogFragment r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
