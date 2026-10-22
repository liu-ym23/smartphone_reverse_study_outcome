package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ KtvMusicFeedbackDialog a;

    public o(KtvMusicFeedbackDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        KtvMusicFeedbackDialog r3 = this.a;
        int r0 = KtvMusicFeedbackDialog.o;
        r3.T90();
        KtvMusicFeedbackDialog r4 = this.a;
        r4.d = null;
        r4.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L12;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
