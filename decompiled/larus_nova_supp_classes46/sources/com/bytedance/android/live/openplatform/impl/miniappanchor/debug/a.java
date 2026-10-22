package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ DebugMenuDialog a;

    public a(DebugMenuDialog r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [android.app.Dialog, com.bytedance.android.live.openplatform.impl.miniappanchor.debug.DebugMenuDialog, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        ?? r5 = this.a;
        int r0 = DebugMenuDialog.c;
        r5.getClass();
        IQRCodeService r1 = k.f(IQRCodeService.class);
        if (r1 == null) goto L5;
        r1.startScanQRCode(r5.getContext(), new b(r5));
    L5:
        CommonBottomDialog r6 = this.a;
        Handler r2 = DialogLancet.resolveDialogHandler(r6);
        if (r2 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r6);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r3 == null) goto L19;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L8:
        if (Looper.myLooper() == r2.getLooper()) goto L10;
        r2.post(DialogLancet.createDismissRunnable(r6));
    }
}
