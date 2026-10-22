package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ SelfDisciplineManagerDialogV2 a;

    public f(SelfDisciplineManagerDialogV2 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        r3.dismiss();
        nd0.g.g(2);
        kj0.b r5 = SelfDisciplineContext.Companion.d();
        if (r5 == null) goto L5;
        kj0.b.a.a(r5, 2, null, 6);
    L5:
        CommonBottomDialog r6 = this.a;
        Handler r7 = DialogLancet.resolveDialogHandler(r6);
        if (r7 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r6);
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r8 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r8 == null) goto L19;
        com.bytedance.crash.d.d(r8, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r7.getLooper()) goto L10;
        r7.post(DialogLancet.createDismissRunnable(r6));
    }
}
