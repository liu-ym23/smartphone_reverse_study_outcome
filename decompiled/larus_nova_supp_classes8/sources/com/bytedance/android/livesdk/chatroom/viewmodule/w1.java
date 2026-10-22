package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.message.model.kj;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w1 implements Action {
    public final /* synthetic */ LiveEndRemindWidget a;
    public final /* synthetic */ int b;

    public w1(LiveEndRemindWidget r1, int r2, kj r3) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        if (13 != this.b) goto L5;
        LiveEndRemindWidget r0 = this.a;
        int r1 = LiveEndRemindWidget.d;
        r0.getClass();
        LiveEndRemindWidget.zq("livesdk_anchor_elderly_midnight2_popup_status", null);
    L5:
        c9 r2 = this.a.c;
        if (r2 == null) goto L24;
        Handler r3 = DialogLancet.resolveDialogHandler(r2);
        if (r3 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r2);
        r2.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r2);
        goto L24
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r4 == null) goto L21;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r2);
        throw th;
    L10:
        if (Looper.myLooper() == r3.getLooper()) goto L12;
        r3.post(DialogLancet.createDismissRunnable(r2));
    L24:
        LiveEndRemindWidget.xq(this.a);
    }
}
