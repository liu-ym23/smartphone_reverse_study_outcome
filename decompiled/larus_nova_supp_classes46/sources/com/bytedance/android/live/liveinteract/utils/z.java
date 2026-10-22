package com.bytedance.android.live.liveinteract.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.ui.o5;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z implements View.OnClickListener {
    public final /* synthetic */ o5 a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ com.bytedance.android.live.network.response.e c;
    public final /* synthetic */ String d;

    public z(o5 r1, Context r2, com.bytedance.android.live.network.response.e r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        String r5 = ((bf2.a) this.c.data).getBanDetailSchema();
        if (r5 == null) goto L21;
        jc1.k.n(IBaseLiveActionHandler.class).handle(this.b, UriProtector.parse(r5));
        o5 r6 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r6);
        if (r0 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r6);
        goto L21
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L7:
        if (Looper.myLooper() == r0.getLooper()) goto L9;
        r0.post(DialogLancet.createDismissRunnable(r6));
    L21:
        HashMap r7 = new HashMap();
        r7.put("ban_type", this.d);
        r7.put("click_position", "ban_detail");
        com.bytedance.android.livesdk.log.j0.l().sendLog("audience_ban_feature_disable_popup_click", r7, new Object[0]);
    }
}
