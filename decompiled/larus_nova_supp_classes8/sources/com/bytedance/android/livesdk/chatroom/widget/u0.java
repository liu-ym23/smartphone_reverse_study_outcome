package com.bytedance.android.livesdk.chatroom.widget;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u0 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ v0 a;

    public u0(v0 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r4) {
        v0 r5 = this.a;
        if (r5.b == false) goto L5;
        return;
    L5:
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r5);
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r1 == null) goto L19;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r0.getLooper()) goto L10;
        r0.post(DialogLancet.createDismissRunnable(r5));
    }
}
