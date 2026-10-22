package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ KtvFeedbackDialog a;

    public c(KtvFeedbackDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (((KtvFeedbackComponentView) this.a.X90(2131372271)).getSelectedSet().isEmpty() == false) goto L6;
        f2.b(2131918392, 0);
        return;
    L6:
        KtvFeedbackDialog.Y90(this.a);
        this.a.T90();
        this.a.dismiss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L16;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
