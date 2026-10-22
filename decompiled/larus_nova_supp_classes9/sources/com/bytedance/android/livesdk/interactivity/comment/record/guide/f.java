package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ LiveHighlightRecordGuideDialog a;

    public f(LiveHighlightRecordGuideDialog r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [android.app.Dialog, com.bytedance.android.livesdk.interactivity.comment.record.guide.LiveHighlightRecordGuideDialog, java.lang.Object] */
    public final void accept(Object r4) {
        CloseDialogSource r5 = (CloseDialogSource) r4;
        ?? r6 = this.a;
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
