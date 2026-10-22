package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ BaseActionSheet.ActionSheetAdapter a;
    public final /* synthetic */ BaseActionSheet.d b;

    public j(BaseActionSheet.ActionSheetAdapter r1, BaseActionSheet.d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        BaseActionSheet.c r5 = this.a.a.f;
        if (r5 == null) goto L5;
        r5.a(this.b);
    L5:
        Dialog r6 = this.a.a.getDialog();
        if (r6 == null) goto L24;
        Handler r0 = DialogLancet.resolveDialogHandler(r6);
        if (r0 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r6);
        return;
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r1 == null) goto L21;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        goto L21
    L10:
        if (Looper.myLooper() == r0.getLooper()) goto L12;
        r0.post(DialogLancet.createDismissRunnable(r6));
        return;
    }
}
