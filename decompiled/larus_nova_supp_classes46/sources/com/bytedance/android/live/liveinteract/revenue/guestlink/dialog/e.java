package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements DialogInterface.OnClickListener {
    public final /* synthetic */ Ref.ObjectRef a;

    public e(Ref.ObjectRef r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        Dialog r5 = (Dialog) this.a.element;
        if (r5 == null) goto L21;
        Handler r6 = DialogLancet.resolveDialogHandler(r5);
        if (r6 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r5);
        goto L21
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r7 == null) goto L18;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L7:
        if (Looper.myLooper() == r6.getLooper()) goto L9;
        r6.post(DialogLancet.createDismissRunnable(r5));
    L21:
        ALogger.i("GuestLinkMainPageDialogForAudience", "click finishChannel, negative button");
    }
}
