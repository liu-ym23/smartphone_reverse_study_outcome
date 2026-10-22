package com.bytedance.android.annie.container.dialog;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ BaseDialogFragment a;

    public h(BaseDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        Dialog r11 = this.a.getDialog();
        if (r11 == null) goto L21;
        Handler r0 = DialogLancet.resolveDialogHandler(r11);
        if (r0 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r11);
        r11.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r11);
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r11);
        throw th;
    L7:
        if (Looper.myLooper() == r0.getLooper()) goto L9;
        r0.post(DialogLancet.createDismissRunnable(r11));
        return;
    }
}
