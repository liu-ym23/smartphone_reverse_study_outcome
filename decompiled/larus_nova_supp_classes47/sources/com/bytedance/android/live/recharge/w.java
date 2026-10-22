package com.bytedance.android.live.recharge;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ RechargeDialogFragmentV2 a;

    public w(RechargeDialogFragmentV2 r1) {
        this.a = r1;
    }

    public final void accept(T r2) {
        if ((r2 instanceof fw0.a) == false) goto L14;
        RechargeDialogFragmentV2 r3 = this.a;
        int r0 = RechargeDialogFragmentV2.n;
        r3.setOnDismissListener(null);
        r3.dismissAllowingStateLoss();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L15;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L15:
        return;
    }
}
