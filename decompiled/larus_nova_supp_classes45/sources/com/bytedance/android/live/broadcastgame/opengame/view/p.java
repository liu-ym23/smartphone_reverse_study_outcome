package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p implements DialogInterface.OnClickListener {
    public final /* synthetic */ OPPluginMoreDialog$getItemClickListener$1 a;
    public final /* synthetic */ OPPluginMoreDialog b;

    public p(OPPluginMoreDialog$getItemClickListener$1 r1, OPPluginMoreDialog r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.view.OPPluginMoreDialog, java.lang.Object] */
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        this.a.a.F.k.b("user exit");
        r3.dismiss();
        ?? r5 = this.b;
        Handler r6 = DialogLancet.resolveDialogHandler(r5);
        if (r6 != null) goto L5;
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
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r7 == null) goto L16;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r6.getLooper()) goto L7;
        r6.post(DialogLancet.createDismissRunnable(r5));
    }
}
