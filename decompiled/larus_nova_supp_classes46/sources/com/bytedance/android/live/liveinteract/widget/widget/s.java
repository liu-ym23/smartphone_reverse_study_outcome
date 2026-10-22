package com.bytedance.android.live.liveinteract.widget.widget;

import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ LinkUserFollowGuideDialog a;

    public s(LinkUserFollowGuideDialog r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.widget.widget.LinkUserFollowGuideDialog, java.lang.Object] */
    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.longValue() != 1) goto L24;
        ?? r7 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r7);
        if (r0 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r7);
        r7.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r7);
        return;
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r7);
        throw th;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r1 == null) goto L21;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        goto L21
    L10:
        if (Looper.myLooper() == r0.getLooper()) goto L12;
        r0.post(DialogLancet.createDismissRunnable(r7));
        return;
    }
}
