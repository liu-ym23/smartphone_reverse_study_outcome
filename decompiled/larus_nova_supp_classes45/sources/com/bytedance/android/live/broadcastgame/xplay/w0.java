package com.bytedance.android.live.broadcastgame.xplay;

import android.content.DialogInterface;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ XplayPanelService a;

    public w0(XplayPanelService r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        com.bytedance.android.live.broadcastgame.api.xplay.p r7 = this.a.l;
        if (r7.d == true) goto L5;
    L11:
        this.a.q.a("stop from more dialog");
        r5.dismiss();
        HybridDialog r8 = this.a.j;
        if (r8 == null) goto L22;
        r8.dismiss();     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L23;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L23:
        return;
    L22:
        return;
    L5:
        if (r7.f != XplayScene.TalkRoom) goto L11;
        IInteractService r11 = jc1.k.f(IInteractService.class);
        if (r11 == null) goto L11;
        com.bytedance.android.live.liveinteract.utils.n r12 = r11.getLinkMicGameTraceUtils();
        if (r12 == null) goto L11;
        com.bytedance.android.live.liveinteract.utils.n.a.a(r12, true, "onClickDanmuQuitButton", null, 12);
        goto L11
    }
}
