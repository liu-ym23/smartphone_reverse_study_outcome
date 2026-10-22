package com.bytedance.bdturing;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        int r5 = r4.getId();
        if (r5 != 2131364724) goto L6;
        c r6 = this.a;
        r6.s = EventReport.CloseType.CLOSE_FB_CLOSE;
    L8:
        c r7 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r7);
        if (r0 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r7);
        r7.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r7);
        return;
    L18:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r1 == null) goto L22;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r7);
        throw th;
    L11:
        if (Looper.myLooper() == r0.getLooper()) goto L13;
        r0.post(DialogLancet.createDismissRunnable(r7));
        return;
    L6:
        if (r5 != 2131364723) goto L8;
        c r8 = this.a;
        r8.s = EventReport.CloseType.CLOSE_FB_FEEDBACK;
        goto L8
    }
}
