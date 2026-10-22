package com.bytedance.android.live.broadcastgame.xplay;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ r0 a;
    public final /* synthetic */ CommonStandardBottomDialog b;

    public q0(r0 r1, XplayMoreDialog r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        com.bytedance.android.live.broadcastgame.api.xplay.p r7 = this.a.a.D;
        if (r7.d == true) goto L5;
    L11:
        this.a.a.F.invoke();
        r5.dismiss();
        CommonStandardBottomDialog r8 = this.b;
        Handler r9 = DialogLancet.resolveDialogHandler(r8);
        if (r9 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(r8);
        r8.dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L25:
        DialogLancet.afterDialogDismiss(r8);
        return;
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r8);
        throw th;
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r11 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r11 == null) goto L25;
        com.bytedance.crash.d.d(r11, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
        goto L25
    L14:
        if (Looper.myLooper() == r9.getLooper()) goto L16;
        r9.post(DialogLancet.createDismissRunnable(r8));
        return;
    L5:
        if (r7.f != XplayScene.TalkRoom) goto L11;
        IInteractService r12 = jc1.k.f(IInteractService.class);
        if (r12 == null) goto L11;
        com.bytedance.android.live.liveinteract.utils.n r13 = r12.getLinkMicGameTraceUtils();
        if (r13 == null) goto L11;
        com.bytedance.android.live.liveinteract.utils.n.a.a(r13, true, "onClickDanmuQuitButton", null, 12);
        goto L11
    }
}
