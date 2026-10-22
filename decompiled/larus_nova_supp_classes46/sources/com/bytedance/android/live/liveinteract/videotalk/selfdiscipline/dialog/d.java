package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import zg1.g1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ SelfDisciplineManageDialog a;

    public d(SelfDisciplineManageDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        g1 r5 = (g1) r4;
        CommonBottomDialog r6 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r6);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r6);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
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
        r0.post(DialogLancet.createDismissRunnable(r6));
    }
}
