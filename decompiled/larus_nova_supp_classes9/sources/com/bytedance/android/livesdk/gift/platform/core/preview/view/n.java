package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.content.DialogInterface;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ UgcGiftSaleDialog a;

    public n(UgcGiftSaleDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
    L9:
        DialogInterface.OnDismissListener r3 = this.a.n;
        if (r3 == null) goto L15;
        r3.onDismiss(null);
        return;
    L15:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L9;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }
}
