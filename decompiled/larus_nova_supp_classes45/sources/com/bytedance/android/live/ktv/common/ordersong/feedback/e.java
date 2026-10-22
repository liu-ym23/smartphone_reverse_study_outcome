package com.bytedance.android.live.ktv.common.ordersong.feedback;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ KtvFeedbackDialog a;

    public e(KtvFeedbackDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
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
