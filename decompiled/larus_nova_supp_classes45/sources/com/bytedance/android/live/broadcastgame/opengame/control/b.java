package com.bytedance.android.live.broadcastgame.opengame.control;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ OpenPlatformControlService.e.a a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function0 d;

    public b(OpenPlatformControlService.e.a r1, Function0 r2, Function0 r3, Function0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        OpenPlatformControlService.e.a r5 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r5);
    L17:
        this.b.invoke();
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L12:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(r5));
        goto L17
    }
}
