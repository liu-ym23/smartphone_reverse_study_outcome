package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0 implements View.OnClickListener {
    public final /* synthetic */ XiaoAnSettingDialog a;

    public a0(XiaoAnSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L12;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
