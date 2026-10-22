package com.bytedance.android.live.livepkaudience.dialog;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.livepkaudience.view.PkWithAudienceFeedbackView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t implements View.OnClickListener {
    public final /* synthetic */ PkWithAudienceFeedbackDialog a;

    public t(PkWithAudienceFeedbackDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (TextUtils.isEmpty(((PkWithAudienceFeedbackView) this.a.S90(2131372320)).getSelectedTag()) == false) goto L7;
        f2.b(2131922740, 0);
        return;
    L7:
        if (PkWithAudienceFeedbackDialog.T90(this.a) == false) goto L18;
        this.a.W90();
        PkWithAudienceFeedbackDialog.V90(this.a);
        this.a.dismiss();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L19;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L19:
        return;
    }
}
