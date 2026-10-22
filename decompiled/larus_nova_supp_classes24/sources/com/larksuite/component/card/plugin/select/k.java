package com.larksuite.component.card.plugin.select;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.ui.navigation.LKUISearchView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ LKUISearchView a;
    public final /* synthetic */ LKUIDialog b;

    public k(LKUISearchView r1, LKUIDialog r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [android.app.Dialog, com.larksuite.component.ui.dialog.LKUIDialog, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        LKUISearchView r5 = this.a;
        r5.getClass();
        LKUISearchView.b(r5);
        ?? r6 = this.b;
        Handler r0 = DialogLancet.resolveDialogHandler(r6);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r6);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(r6));
    }
}
