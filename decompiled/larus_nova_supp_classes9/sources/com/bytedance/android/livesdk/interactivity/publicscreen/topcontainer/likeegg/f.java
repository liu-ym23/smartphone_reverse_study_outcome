package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ CompositeImagePreviewDialog a;

    public f(CompositeImagePreviewDialog r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [android.app.Dialog, com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.CompositeImagePreviewDialog, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        Function0<Unit> r5 = this.a.C;
        if (r5 == null) goto L5;
        Unit r6 = (Unit) r5.invoke();
    L5:
        ?? r7 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r7);
        if (r0 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r7);
        r7.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r7);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r1 == null) goto L19;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r7);
        throw th;
    L8:
        if (Looper.myLooper() == r0.getLooper()) goto L10;
        r0.post(DialogLancet.createDismissRunnable(r7));
    }
}
