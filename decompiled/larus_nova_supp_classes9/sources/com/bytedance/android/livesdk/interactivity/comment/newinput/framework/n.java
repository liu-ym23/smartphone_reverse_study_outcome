package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.input.i a;

    public n(com.bytedance.android.livesdk.interactivity.comment.input.i r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        com.bytedance.android.livesdk.interactivity.api.monitor.b.a(false);
        com.bytedance.android.livesdk.interactivity.comment.input.i r5 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r5);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(r5));
    }
}
