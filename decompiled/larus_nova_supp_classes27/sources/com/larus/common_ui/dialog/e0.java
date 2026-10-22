package com.larus.common_ui.dialog;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e0 {
    public static void a(l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static final void b(l0 r2, Activity r3) {
        if (r3 != null) goto L16;
    L6:
        boolean r4 = false;
    L7:
        if (r4 == false) goto L18;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.isShowing() == false) goto L20;
        a(r2);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        FLogger.a.e("safeDismissDialog", "commonLoadDialog dismiss crash because: " + e.getMessage(), e);
        return;
    L20:
        return;
    L18:
        return;
    L16:
        if (r3.isFinishing() == true) goto L6;
        r4 = true;
        goto L7
    }
}
