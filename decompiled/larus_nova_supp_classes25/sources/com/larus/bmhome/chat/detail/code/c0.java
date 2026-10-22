package com.larus.bmhome.chat.detail.code;

import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c0 implements com.larus.bmhome.share.network.j {
    public final /* synthetic */ CodeBlockDetailFragment a;

    public final void dismissLoading() {
        CodeBlockDetailFragment r0 = this.a;
        int r1 = CodeBlockDetailFragment.k0;
        com.larus.common_ui.dialog.l0 r2 = r0.ea0();
        if (r2 == null) goto L21;
        Handler r3 = DialogLancet.resolveDialogHandler(r2);
        if (r3 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r2);
        r2.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r2);
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r4 == null) goto L18;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r2);
        throw th;
    L7:
        if (Looper.myLooper() == r3.getLooper()) goto L9;
        r3.post(DialogLancet.createDismissRunnable(r2));
        return;
    }

    public final void showLoading() {
        CodeBlockDetailFragment r0 = this.a;
        int r1 = CodeBlockDetailFragment.k0;
        com.larus.common_ui.dialog.l0 r2 = r0.ea0();
        if (r2 != null) goto L5;
        return;
    L5:
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L11;
        DialogLancet.handleBlockedDialogShow(r2);
        return;
    L11:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
    }

    public c0(CodeBlockDetailFragment r1) {
        this.a = r1;
    }
}
