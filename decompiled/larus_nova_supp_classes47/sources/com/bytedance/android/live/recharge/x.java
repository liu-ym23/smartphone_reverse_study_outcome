package com.bytedance.android.live.recharge;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ RechargeDialogFragmentV2 a;

    public x(RechargeDialogFragmentV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Unit r3 = (Unit) r2;
        this.a.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L12;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
