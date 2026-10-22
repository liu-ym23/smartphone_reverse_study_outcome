package com.bytedance.android.live.revlink.impl.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.ui.o5;
import com.bytedance.android.livesdk.link.model.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevLinkBannedUtil$showPkBanDialog$$inlined$let$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ o5 a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ j0 c;

    public RevLinkBannedUtil$showPkBanDialog$$inlined$let$lambda$1(o5 r1, Context r2, j0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        String r5 = this.c.getUrl();
        if (r5 == null) goto L21;
        ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).x6(this.b, r5, new AnonymousClass1(this));
        o5 r6 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r6);
        if (r0 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r6);
        return;
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
        return;
    }
}
