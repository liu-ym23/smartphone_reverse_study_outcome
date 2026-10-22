package com.bytedance.android.livesdk.floatview;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.floatview.mob.VideoFloatWindowLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ o a;

    public m(o r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.b.k0;
        Boolean r0 = Boolean.FALSE;
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r0);
        o r6 = this.a;
        Handler r1 = DialogLancet.resolveDialogHandler(r6);
        if (r1 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r6);
    L17:
        Lazy r7 = VideoFloatWindowLogger.a;
        VideoFloatWindowLogger.a.a().getClass();
        VideoFloatWindowLogger.c("refuse");
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L5:
        if (Looper.myLooper() == r1.getLooper()) goto L7;
        r1.post(DialogLancet.createDismissRunnable(r6));
        goto L17
    }
}
