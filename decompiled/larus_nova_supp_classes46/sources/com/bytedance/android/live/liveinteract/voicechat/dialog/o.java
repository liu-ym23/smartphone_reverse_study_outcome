package com.bytedance.android.live.liveinteract.voicechat.dialog;

import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o implements com.bytedance.android.live.liveinteract.videotalk.utils.g {
    public final /* synthetic */ p a;

    @Override // com.bytedance.android.live.liveinteract.videotalk.utils.g
    public final void onFinish() {
        com.bytedance.android.livesdk.common.b r0 = this.a;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r0);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r1.getLooper()) goto L7;
        r1.post(DialogLancet.createDismissRunnable(r0));
    }

    public o(p r1) {
        this.a = r1;
    }
}
