package com.bytedance.android.livesdk.common;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.PopupMenu;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ e a;

    public g(e r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        PopupMenu.OnMenuItemClickListener r5 = this.a.i;
        if (r5 != null) goto L5;
    L6:
        e r6 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r6);
        if (r0 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r6);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r1 == null) goto L20;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L9:
        if (Looper.myLooper() == r0.getLooper()) goto L11;
        r0.post(DialogLancet.createDismissRunnable(r6));
        return;
    L5:
        if (r5.onMenuItemClick(null) == true) goto L6;
    }
}
