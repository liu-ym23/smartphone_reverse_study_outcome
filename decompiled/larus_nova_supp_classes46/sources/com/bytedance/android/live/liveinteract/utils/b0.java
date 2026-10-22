package com.bytedance.android.live.liveinteract.utils;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livesdk.chatroom.ui.o5;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0 implements View.OnClickListener {
    public final /* synthetic */ o5 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public b0(o5 r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.b == null) goto L24;
        IBaseLiveActionHandler r5 = jc1.k.n(IMiddlewareRoomService.class).actionHandler();
        if (r5 == null) goto L7;
        r5.handle(this.a.getContext(), this.b);
    L7:
        o5 r6 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r6);
        if (r0 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r6);
        goto L24
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r1 == null) goto L21;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L10:
        if (Looper.myLooper() == r0.getLooper()) goto L12;
        r0.post(DialogLancet.createDismissRunnable(r6));
    L24:
        HashMap r7 = new HashMap();
        r7.put("ban_type", this.c);
        r7.put("click_position", "appeal");
        com.bytedance.android.livesdk.log.j0.l().sendLog("audience_ban_feature_disable_popup_click", r7, new Object[0]);
    }
}
