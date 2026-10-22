package com.bytedance.android.live.livepkaudience.emoji;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ BaseAudienceInteractDynamicEmojiDialog a;

    public a(BaseAudienceInteractDynamicEmojiDialog r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [android.app.Dialog, com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog, java.lang.Object] */
    public final void onChanged(Object r4) {
        Integer r5 = (Integer) r4;
        if (r5 == null) goto L8;
        if (r5.intValue() != 2) goto L8;
        return;
    L8:
        if (hd0.c.f().i() == true) goto L30;
        ?? r6 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r6);
        if (r0 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r6);
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r1 == null) goto L23;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L12:
        if (Looper.myLooper() == r0.getLooper()) goto L14;
        r0.post(DialogLancet.createDismissRunnable(r6));
        return;
    }
}
